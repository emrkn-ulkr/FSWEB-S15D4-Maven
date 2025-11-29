package org.example;


import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));

        WorkintechList<String> list = new WorkintechList<>();
        list.add("Mehmet");
        list.add("Ali");
        list.add("Mehmet");
        list.add("Zeynep");
        list.add("Batu");

        System.out.println("Ekleme Sonrası (Sırasız): " + list);
        list.sort();
        System.out.println("Sort Sonrası: " + list);
        list.remove("Mehmet");
        System.out.println("Mehmet silindikten sonra (Otomatik Sıralı): " + list);

        WorkintechList<Integer> numbers = new WorkintechList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);

        numbers.sort();
        System.out.println("Sayı Listesi: " + numbers);

        System.out.println("5 -> " + convertDecimalToBinary(5));
        System.out.println("6 -> " + convertDecimalToBinary(6));
        System.out.println("13 -> " + convertDecimalToBinary(13));
        System.out.println("0 -> " + convertDecimalToBinary(0));
    }

    public static boolean checkForPalindrome(String text) {

        if (text == null) {
            return false;
        }

        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ENGLISH);

        Stack<Character> stack = new Stack<>();


        for (char c : cleanText.toCharArray()) {
            stack.push(c);
        }


        for (char c : cleanText.toCharArray()) {

            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static String convertDecimalToBinary(int num) {
        // 0 özel bir durumdur, döngüye girmeden direkt dönebiliriz.
        if (num == 0) {
            return "0";
        }

        // Kalanları (0 ve 1'leri) tutmak için Stack oluşturuyoruz.
        Stack<Integer> stack = new Stack<>();

        // Sayı 0'dan büyük olduğu sürece bölme işlemine devam et
        while (num > 0) {
            int remainder = num % 2; // 2'ye bölümden kalanı al (0 veya 1)
            stack.push(remainder);   // Kalanı yığına at
            num = num / 2;           // Sayıyı 2'ye bölerek küçült
        }

        // String birleştirme işlemi için StringBuilder kullanıyoruz (Performans için)
        StringBuilder binaryString = new StringBuilder();

        // Stack boşalana kadar elemanları çekiyoruz (LIFO sayesinde tersten okumuş oluyoruz)
        while (!stack.isEmpty()) {
            binaryString.append(stack.pop());
        }

        return binaryString.toString();
    }
}

