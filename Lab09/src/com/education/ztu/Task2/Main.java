package com.education.ztu.Task2;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        String pathToInput = "./input/task2.input.txt";
        String outputForUpdatingNumberFormat = "./output/task2.output1.txt";
        String outputForUpdatingPositionByPhoneNumber = "./output/task2.output2.txt";

        try{
            String input = FileHelper.readFileContent(pathToInput);
            System.out.println(input);

            // find all phone numbers and emails.
            Pattern phonePattern = Pattern.compile("[+][0-9]{3} [0-9]{2} [0-9]{3} [0-9]{4}");
            Matcher phoneMatcher = phonePattern.matcher(input);
            System.out.println("Founded phone numbers: ");
            while(phoneMatcher.find()){
                System.out.println(phoneMatcher.group());
            }

            Pattern emailPattern = Pattern.compile("\\S{3,}@\\S{3,}");
            Matcher emailMatcher = emailPattern.matcher(input);
            System.out.println("\nFounded emails: ");
            while(emailMatcher.find()){
                System.out.println(emailMatcher.group());
            }

            Pattern dateOfBirthPattern = Pattern.compile("- [*][*]Дата народження[*][*]: (..).(..).(....)");
            Matcher dateOfBirthMatcher = dateOfBirthPattern.matcher(input);

            StringBuilder sb = new StringBuilder();

            while(dateOfBirthMatcher.find()){
                String modified = String.format("- **Дата народження**: %s-%s-%s",
                        dateOfBirthMatcher.group(1),
                        dateOfBirthMatcher.group(2),
                        dateOfBirthMatcher.group(3));

                dateOfBirthMatcher.appendReplacement(sb, modified);
            }
            dateOfBirthMatcher.appendTail(sb);

            FileHelper.writeFileContent(outputForUpdatingNumberFormat, sb.toString());

            // change position by phone number.
            String phoneNumber = "380 63 987 6543";
            String newPosition = "Manager";
            String positionByPhoneNumber = "(Посада[*][*]: )(.+?)(\\r\\n.*\\r\\n.*\\r\\n.*\\r\\n.*Телефон[*][*]: [+]"+phoneNumber+")";

            Pattern positionPattern = Pattern.compile(positionByPhoneNumber);
            System.out.println(positionByPhoneNumber);
            Matcher positionMatcher = positionPattern.matcher(input);
            sb = new StringBuilder();
            while(positionMatcher.find()){
                String modified = positionMatcher.group(1) + newPosition + positionMatcher.group(3);
                System.out.println("Matched");
                positionMatcher.appendReplacement(sb, modified);
            }
            positionMatcher.appendTail(sb);
            FileHelper.writeFileContent(outputForUpdatingPositionByPhoneNumber, sb.toString());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
