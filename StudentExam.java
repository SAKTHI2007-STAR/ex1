import java.util.*;

public class StudentExam {

    static class Question {
        String text;
        String[] options;
        char correctAnswer;

        Question(String text, String[] options, char correctAnswer) {
            this.text = text;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "What is the size of an int in Java?",
                new String[]{"A) 8 bits", "B) 16 bits", "C) 32 bits", "D) 64 bits"},
                'C'));
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"A) implements", "B) extends", "C) inherits", "D) super"},
                'B'));
        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"A) start()", "B) run()", "C) main()", "D) init()"},
                'C'));
        questions.add(new Question(
                "Which collection class allows duplicate elements?",
                new String[]{"A) HashSet", "B) TreeSet", "C) ArrayList", "D) LinkedHashSet"},
                'C'));
        questions.add(new Question(
                "What does JVM stand for?",
                new String[]{"A) Java Virtual Machine", "B) Java Variable Method",
                        "C) Java Visual Model", "D) Java Verified Module"},
                'A'));

        System.out.println("===== STUDENT EXAM =====");
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        int score = 0;
        int totalMarksPerQuestion = 2;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ". " + q.text);
            for (String option : q.options) {
                System.out.println("   " + option);
            }
            System.out.print("Your answer (A/B/C/D): ");
            String input = sc.nextLine().trim().toUpperCase();

            char answer = input.isEmpty() ? ' ' : input.charAt(0);

            if (answer == q.correctAnswer) {
                System.out.println("Correct!");
                score += totalMarksPerQuestion;
            } else {
                System.out.println("Wrong! Correct answer: " + q.correctAnswer);
            }
        }

        int totalMarks = questions.size() * totalMarksPerQuestion;
        double percentage = (score * 100.0) / totalMarks;

        System.out.println("\n===== EXAM RESULT =====");
        System.out.println("Student Name : " + studentName);
        System.out.println("Score        : " + score + " / " + totalMarks);
        System.out.printf("Percentage   : %.2f%%\n", percentage);

        if (percentage >= 40) {
            System.out.println("Result       : PASS");
        } else {
            System.out.println("Result       : FAIL");
        }

        sc.close();
    }
}
