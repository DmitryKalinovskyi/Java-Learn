import com.education.ztu.car.Car;
import com.education.ztu.car.CarBattery;
import com.education.ztu.car.CarBuilder;
import com.education.ztu.car.Engine;
import com.education.ztu.humans.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Car buildMyDreamCar(){
        CarBuilder carBuilder = new CarBuilder();

        return carBuilder
                .setBrand("bmw")
                .setModel("x5")
                .setCarBattery(new CarBattery(0, 1000))
                .setEngine(new Engine())
                .build();
    }
    public static Car buildBadCar(){
        CarBuilder carBuilder = new CarBuilder();

        return carBuilder
                .setBrand("?")
                .setModel("?")
                .setCarBattery(new CarBattery(0, 1))
                .setEngine(new Engine())
                .build();
    }
    public static void main(String[] args) {
        Car dreamCar = buildMyDreamCar();
        Car veryBadCar = buildBadCar();

        dreamCar.startEngine();
        dreamCar.stopEngine();

        System.out.println("Values of Location enum: ");
        for(Location value: Location.values()){
            System.out.println(value);
        }

        Student student = new Student("Dmytro", "Kalinovskyi", 18, Gender.MALE, Location.ZHYTOMYR, 3, "ZPSU", "Software Engineer");

        boolean isHuman = student instanceof Human;
        System.out.println(isHuman? "Student is human.": "Student is not human.");

        System.out.println(student.getFullInfo());
        System.out.println(student.getOccupation());

        Teacher teacher = new Teacher("Ruslan", "Petrosyan", 99, Gender.MALE, Location.KIEV, veryBadCar, "KPI", "Algos");
        System.out.println(teacher.getFullInfo());
        System.out.println(teacher.getOccupation());

        Employee employee = new Employee("Sushik", "Rostia", 21, Gender.MALE, Location.RIVNE, dreamCar, "Junior .NET", ".NET bang");
        System.out.println(employee.getFullInfo());
        System.out.println(employee.getOccupation());
    }
}