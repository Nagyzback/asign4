import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for client's age
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        // Display options
        System.out.println("Choose your goal:");
        System.out.println("1. Lose weight");
        System.out.println("2. Gain muscles");
        System.out.println("3. Maintenance");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        // Generate nutrition plan based on the chosen option
        switch (choice) {
            case 1:
                generateWeightLossPlan(age);
                break;
            case 2:
                generateMuscleGainPlan(age);
                break;
            case 3:
                generateMaintenancePlan(age);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Generate nutrition plan for losing weight
    private static void generateWeightLossPlan(int age) {
        System.out.println("Your nutrition plan for losing weight:");

        // Breakfast
        System.out.println("Breakfast: Low-calorie smoothie with fruits and protein powder.");
        // Lunch
        System.out.println("Lunch: Grilled chicken salad with mixed greens and vinaigrette dressing.");
        // Dinner
        System.out.println("Dinner: Baked salmon with steamed vegetables and quinoa.");

        // Additional advice based on age
        if (age > 40) {
            System.out.println("Additional advice: Try to limit carbohydrates intake.");
        } else {
            System.out.println("Additional advice: Include healthy snacks like almonds or Greek yogurt between meals.");
        }
    }

    // Generate nutrition plan for gaining muscles
    private static void generateMuscleGainPlan(int age) {
        System.out.println("Your nutrition plan for gaining muscles:");

        // Breakfast
        System.out.println("Breakfast: Oatmeal with banana and nuts, accompanied by a protein shake.");
        // Lunch
        System.out.println("Lunch: Grilled steak with sweet potatoes and broccoli.");
        // Dinner
        System.out.println("Dinner: Brown rice with grilled chicken breast and asparagus.");

        // Additional advice based on age
        if (age < 30) {
            System.out.println("Additional advice: Increase protein intake to support muscle growth.");
        } else {
            System.out.println("Additional advice: Focus on compound exercises during workouts for better muscle stimulation.");
        }
    }

    // Generate nutrition plan for maintenance
    private static void generateMaintenancePlan(int age) {
        System.out.println("Your nutrition plan for maintenance:");

        // Breakfast
        System.out.println("Breakfast: Whole grain toast with avocado and scrambled eggs.");
        // Lunch
        System.out.println("Lunch: Quinoa salad with mixed vegetables and grilled tofu.");
        // Dinner
        System.out.println("Dinner: Grilled fish with roasted vegetables and brown rice.");

        // Additional advice based on age
        if (age > 50) {
            System.out.println("Additional advice: Ensure to include foods rich in calcium and vitamin D for bone health.");
        } else {
            System.out.println("Additional advice: Stay hydrated and incorporate a variety of colorful fruits and vegetables in your meals.");
        }
    }
}
