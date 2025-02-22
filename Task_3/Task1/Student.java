package Task_1;

import java.util.*;

class Student {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateTotalAndAverage();
    }

    private void calculateTotalAndAverage() {
        total = Arrays.stream(marks).sum();
        average = total / (double) marks.length;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bala", new int[]{97,99,96,98,100}));
        students.add(new Student("Sathish", new int[]{76,81,90,99,77}));
        students.add(new Student("Matt", new int[]{90,88,91,93,87}));

        students.sort(Comparator.comparingInt(s -> -s.total));

        System.out.println("Name:   |  Total:   |  Average:");
        System.out.println("-----------------------------");

        for (Student s : students) {
            System.out.printf("%-7s  |  %5d  |%.2f%n",s.name, s.total, s.average);
        }
    }
}
