package com.education.ztu;

import com.education.ztu.DAO.PuzzleDAO;
import com.education.ztu.Dependency.ConnectionFactory;
import com.education.ztu.Dependency.IConnectionFactory;
import com.education.ztu.interfaces.InsertFunctionalInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static String truncateString(String str, int maxLength) {
        if (str == null) {
            return ""; // Handle null gracefully
        }
        return str.length() > maxLength ? str.substring(0, maxLength - 3) + "..." : str;
    }

    public static void Task3(IConnectionFactory connectionFactory) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        Statement stm = connection.createStatement();
        ResultSet result = stm.executeQuery("select * from puzzles");
        List<Puzzle> puzzles = new ArrayList<>();
        while(result.next()){
            puzzles.add(new Puzzle(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("description"),
                    result.getInt("amount"),
                    result.getDouble("price"),
                    result.getString("brand")
            ));
        }

        System.out.println("Puzzles in database.");
        for(Puzzle puzzle: puzzles){
            System.out.printf("%20s|%20s|%10d|%10.2f|%20s",
                    truncateString(puzzle.getName(), 20),
                    truncateString(puzzle.getDescription(), 20),
                    puzzle.getAmount(),
                    puzzle.getPrice(),
                    truncateString(puzzle.getBrand(), 20));
            System.out.println();
        }
    }

    public static void Task4(IConnectionFactory connectionFactory) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        PreparedStatement preparedInsertSQL = connection.prepareStatement("insert into puzzles(name, description, amount, price, brand) values (?, ?, ?, ?, ?)");
        InsertFunctionalInterface<Puzzle> inserter = (preparedInsert, puzzle) -> {
            try{
                preparedInsert.setString(1, puzzle.getName());
                preparedInsert.setString(2, puzzle.getDescription());
                preparedInsert.setInt(3, puzzle.getAmount());
                preparedInsert.setDouble(4, puzzle.getPrice());
                preparedInsert.setString(5, puzzle.getBrand());

                preparedInsert.execute();
                return true;
            }catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        };

        List<Puzzle> puzzles = List.of(
                new Puzzle("Mystery Maze", "A challenging maze puzzle", 10, 15.99, "PuzzleCo"),
                new Puzzle("Castle Quest", "A medieval-themed puzzle", 25, 29.99, "BrainGames"),
                new Puzzle("Ocean Explorer", "Discover the underwater world", 12, 19.49, "DeepDive Puzzles"),
                new Puzzle("Space Odyssey", "Explore the galaxy in this puzzle", 8, 24.99, "StarrySkies"),
                new Puzzle("Jungle Adventure", "Embark on a tropical adventure", 15, 18.50, "WildPuzzles")
        );

        int insertedCount = 0;
        for (Puzzle puzzle : puzzles) {
            if (inserter.insert(preparedInsertSQL, puzzle)) {
                insertedCount++;
            }
        }

        if(insertedCount == 5){
            System.out.println("Five puzzles inserted successfully!");
        }
        else{
            System.out.println("Failed to insert all puzzles.");
        }
    }


    public static void Task5(IConnectionFactory connectionFactory) throws SQLException {
        Connection connection = connectionFactory.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false); // Begin transaction

            PreparedStatement stmt1 = connection.prepareStatement(
                    "INSERT INTO puzzles(name, description, amount, price, brand) VALUES (?, ?, ?, ?, ?)"
            );
            stmt1.setString(1, "First Puzzle");
            stmt1.setString(2, "This is the first puzzle.");
            stmt1.setInt(3, 10);
            stmt1.setDouble(4, 20.99);
            stmt1.setString(5, "Brand A");
            stmt1.executeUpdate();

            savepoint = connection.setSavepoint("AfterFirstInsert");

            PreparedStatement stmt2 = connection.prepareStatement(
                    "INSERT INTO puzzles(name, description, amount, price, brand) VALUES (?, ?, ?, ?)" // Missing one parameter intentionally
            );
            stmt2.setString(1, "Second Puzzle");
            stmt2.setString(2, "This is the second puzzle.");
            stmt2.setInt(3, 5);
            stmt2.setDouble(4, 15.99);
            stmt2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
            if (savepoint != null) {
                connection.rollback(savepoint);
                System.out.println("Rolled back to the savepoint.");
            } else {
                connection.rollback();
                System.out.println("Rolled back the entire transaction.");
            }
        } finally {
            connection.setAutoCommit(true); // Restore default auto-commit mode
        }

        System.out.println("Final state of puzzles in the database:");
        Task3(connectionFactory);
    }


    public static void Task6(IConnectionFactory connectionFactory){
        PuzzleDAO puzzleDAO = new PuzzleDAO(connectionFactory);
        System.out.println("Task6:");
        try {
            Optional<Puzzle> puzzle = puzzleDAO.findById(2);
            if(puzzle.isPresent()){
                System.out.println("We found puzzle in database.");
            }
            else{
                System.out.println("Puzzle is not founded.");
            }

            puzzleDAO.delete(2);
            puzzle = puzzleDAO.findById(2);
            if(puzzle.isPresent()){
                System.out.println("We found puzzle in database.");
            }
            else{
                System.out.println("Puzzle is not founded.");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        String connectionString = "jdbc:postgresql://localhost:5432/testDatabase";
        try{
            IConnectionFactory connectionFactory = new ConnectionFactory(connectionString, "postgres", "1111");

            Task3(connectionFactory);

            Task4(connectionFactory);

            Task5(connectionFactory);

            Task6(connectionFactory);

        }catch (SQLException e){
            System.out.printf(e.getMessage());
        }
    }
}
