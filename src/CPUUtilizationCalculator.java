import java.util.*;
public class CPUUtilizationCalculator {
    public static void calculateAndDisplayCPUUtilizationAndIdleTime(ArrayList<Process> processes) {
        int totalExecutionTime = 0;
        int totalIdleTime = 0;
        int currentTime = 0;

        for (Process process : processes) {
            if (process.arrivalTime > currentTime) {
                totalIdleTime += process.arrivalTime - currentTime;
                currentTime = process.arrivalTime;
            }
            totalExecutionTime += process.executionTime;
            currentTime += process.executionTime;
        }

        double cpuUtilizationPercentage = ((double) totalExecutionTime / (totalExecutionTime + totalIdleTime)) * 100;
        System.out.println("CPU Utilization: " + cpuUtilizationPercentage + "%");
        System.out.println("Idle Time: " + totalIdleTime + "ms");
    }
}