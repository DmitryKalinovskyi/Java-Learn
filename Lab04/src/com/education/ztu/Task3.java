package com.education.ztu;

public class Task3 {
    public static void main(String[] args){
        int a = 4, b = 36;

        // 1. Build the rows using StringBuilder.append()
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        sb.append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n");
        sb.append(a).append(" * ").append(b).append(" = ").append(a * b);

        System.out.println("Initial StringBuilder content:");
        System.out.println(sb);

        // 2. Replace '=' with "рівно" using insert() and deleteCharAt()
        StringBuilder sb2 = new StringBuilder(sb);
        int indexOfEqualSign = sb2.indexOf("=");
        while (indexOfEqualSign != -1) {
            sb2.deleteCharAt(indexOfEqualSign);
            sb2.insert(indexOfEqualSign, "рівно");
            indexOfEqualSign = sb2.indexOf("=", indexOfEqualSign + 1);
        }

        System.out.println("\nAfter replacing '-' with 'рівно' using insert() and deleteCharAt():");
        System.out.println(sb2);

        // 3. Replace '=' with "рівно" using replace()
        StringBuilder sb3 = new StringBuilder(sb);
        indexOfEqualSign = sb3.indexOf("=");
        while (indexOfEqualSign != -1) {
            sb3.replace(indexOfEqualSign, indexOfEqualSign+1, "рівно");
            indexOfEqualSign = sb3.indexOf("=", indexOfEqualSign + 1);
        }

        System.out.println("\nAfter replacing '=' with \"рівно\" using replace():");
        System.out.println(sb3);

        // 4. Reverse the string using reverse()
        sb.reverse();
        System.out.println("\nAfter reversing the string using reverse():");
        System.out.println(sb);

        // 5. Print length and capacity of the built string
        System.out.println("\nString length: " + sb.length());
        System.out.println("String capacity: " + sb.capacity());
    }

}
