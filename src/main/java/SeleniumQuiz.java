import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeleniumQuiz {
    static class Question {
        String question;
        String[] options;
        char correctAnswer;

        Question(String question, String[] options, char correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/src/main/java/questions.csv";
        List<Question> questions = loadQuestions(fileName);
        runQuiz(questions);
    }

    private static List<Question> loadQuestions(String filename) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String question = parts[0];
                String[] options = { parts[1], parts[2], parts[3], parts[4] };
                char correctAnswer = parts[5].charAt(0);
                questions.add(new Question(question, options, correctAnswer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    private static void runQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int questionNumber = 1;

        for (Question q : questions) {
            System.out.println("Question " + questionNumber + ":");
            System.out.println(q.question);
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + q.options[i]);
            }
            System.out.print("Your answer (A/B/C/D), or press Enter to skip: ");
            String userInput = scanner.nextLine().trim().toUpperCase();

            if (userInput.isEmpty()) {
                System.out.println("Question skipped. The correct answer was " + q.correctAnswer);
            } else {
                try {
                    char userAnswer = userInput.charAt(0);
                    if (userAnswer >= 'A' && userAnswer <= 'D') {
                        if (userAnswer == q.correctAnswer) {
                            System.out.println("Correct!");
                            score++;
                        } else {
                            System.out.println("Incorrect. The correct answer is " + q.correctAnswer);
                        }
                    } else {
                        System.out.println("Invalid input. The correct answer is " + q.correctAnswer);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid input. The correct answer is " + q.correctAnswer);
                }
            }
            System.out.println();
            questionNumber++;
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
    }
}