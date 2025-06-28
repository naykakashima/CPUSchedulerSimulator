import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Operating System Simulator!");
        System.out.println("Instructions:");
        System.out.println("1. Enter the number of processes you want to simulate.");
        System.out.println("2. Enter the properties of the process you want to simulate (Process ID, Arrival time, Execution Time).");
        System.out.println("3. Enter the algorithm you want to use (First Come First Serve, Shortest Job First, Round Robin, Shortest Time To Completion).");
        System.out.println("4. Programme will feed back information on the processes.");

        inputjob();
    }

    public static void inputjob() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes you want to simulate: ");
        int n = sc.nextInt();

        ArrayList<Process> processList = new ArrayList<>();
        System.out.println("Enter the properties of the processes (Arrival time, Execution Time) for each process:");
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + ":");
            int arrivalTime = sc.nextInt();
            int executionTime = sc.nextInt();
            processList.add(new Process(i, arrivalTime, executionTime));
        }

        System.out.println("Choose the scheduling algorithm:");
        System.out.println("1. First Come First Serve (FCFS)");
        System.out.println("2. Shortest Job First (SJF)");
        System.out.println("3. Round Robin (RR)");
        System.out.println("4. Shortest Time to Completion First (STCF)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                FirstComeFirstServe fcfs = new FirstComeFirstServe();
                fcfs.schedule(processList);
                break;

            case 2:
                ShortestJobFirst sjf = new ShortestJobFirst();
                sjf.schedule(processList);
                break;

            case 3:
                System.out.println("Enter the time quantum for Round Robin Algorithm:");
                int quantum = sc.nextInt();
                RoundRobin rr = new RoundRobin(quantum);
                rr.schedule(processList);
                break;

            case 4:
                ShortestTimeToCompletion stcf = new ShortestTimeToCompletion();
                stcf.schedule(processList);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        sc.close();
    }
}
