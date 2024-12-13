package com.education.ztu.DAO;

import com.education.ztu.Dependency.IConnectionFactory;
import com.education.ztu.Puzzle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PuzzleDAO implements IDAO<Puzzle> {
    private final IConnectionFactory connectionFactory;

    public PuzzleDAO(IConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void insert(Puzzle model) throws SQLException {
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("insert into puzzles(name, description, price, amount, brand) values (?, ?, ?, ?, ?)");
        stmt.setString(1, model.getName());
        stmt.setString(2, model.getDescription());
        stmt.setInt(3, model.getAmount());
        stmt.setDouble(4, model.getPrice());
        stmt.setString(5, model.getBrand());

        stmt.execute();
    }

    @Override
    public Optional<Puzzle> findById(int id) throws SQLException {
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("select * from puzzles where id=?");
        stmt.setInt(1, id);

        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()){
            return Optional.of(new Puzzle(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getInt("amount"),
                    resultSet.getDouble("price"),
                    resultSet.getString("brand")
            ));
        }

        return Optional.empty();
    }

    @Override
    public List<Puzzle> getAll() throws SQLException  {
        Connection connection = connectionFactory.getConnection();

        ResultSet resultSet = connection.createStatement().executeQuery("select * from puzzles");
        List<Puzzle> puzzles = new ArrayList<>();
        while(resultSet.next()){
            puzzles.add(new Puzzle(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getInt("amount"),
                    resultSet.getDouble("price"),
                    resultSet.getString("brand")
            ));
        }

        return puzzles;
    }

    @Override
    public void update(Puzzle model) throws SQLException {
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("update puzzles set name = ?, description = ?, amount = ?, price = ?, brand = ? where id = ?");
        stmt.setString(1, model.getName());
        stmt.setString(2, model.getDescription());
        stmt.setInt(3, model.getAmount());
        stmt.setDouble(4, model.getPrice());
        stmt.setString(5, model.getBrand());
        stmt.setInt(6, model.getId());

        stmt.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = connectionFactory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("delete from puzzles where id = ?");
        stmt.setInt(1, id);

        stmt.execute();
    }
}
