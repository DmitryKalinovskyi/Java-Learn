package com.education.ztu.Task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<BasicModel> models = new ArrayList<>();
        models.add(new UserModel("Dmytro", "ipz@example.com"));
        models.add(new ProductModel("Laptop", 200));
        models.add(new OrderModel());

        models.forEach(model -> {
            Class<? extends BasicModel> aClass = model.getClass();
            try{
                Model modelAnnotation = aClass.getAnnotation(Model.class);
                System.out.println(modelAnnotation.tableName());
            }catch (NullPointerException e){
                System.out.printf("There is no model annotation in class %s.", aClass.getName());
            }
        });
    }
}
