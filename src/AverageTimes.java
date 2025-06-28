import java.util.*;
public class AverageTimes {
    public static double calculateAverageResponseTime(ArrayList<Process> processes) {
        double totalResponseTime = 0.0;
        for (Process p : processes) {
            totalResponseTime += p.waitingTime;
        }
        return totalResponseTime / processes.size();
    }

    public static double calculateAverageTurnaroundTime(ArrayList<Process> processes) {
        double totalTurnaroundTime = 0.0;
        for (Process p : processes) {
            totalTurnaroundTime += p.turnaroundTime;
        }
        return totalTurnaroundTime / processes.size();
    }

    public static void displayAverageTimes(ArrayList<Process> processes) {
        double averageResponseTime = calculateAverageResponseTime(processes);
        double averageTurnaroundTime = calculateAverageTurnaroundTime(processes);
        System.out.println("Average Response Time: " + averageResponseTime + "ms");
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime + "ms");
    }
}