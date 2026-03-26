import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        int robotNumber = sc.nextInt();

        Robot[] robots = new Robot[robotNumber];

        sc.nextLine();

        for (int i = 0; i < robotNumber; i++) {
            String robotType = sc.next();
            int robotId = sc.nextInt();
            String modelName = sc.next();
            
            switch (robotType) {
                case "DR":
                    robots[i] = new DroneRobot(robotId, modelName);
                    break;
                case "FR":
                    robots[i] = new FishRobot(robotId, modelName);
                    break;
                case "AR":
                    robots[i] = new AmphibiousRobot(robotId, modelName);
                    break;
                default:
                    break;
            }

            sc.nextLine();
        }

        for (int i = 0; i < robotNumber; i++) {
            robots[i].performMainTask();
            if (robots[i] instanceof Flyable) {
                ((Flyable) robots[i]).fly();
            } 
            if (robots[i] instanceof Swimmable) {
                ((Swimmable) robots[i]).swim();
            }
            if (robots[i] instanceof GPS) {
                ((GPS) robots[i]).getCoordinates();
            }
            System.out.println();
        }
    }
}
