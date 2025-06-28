import java.util.*;
public class FirstComeFirstServe {
    public void schedule(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            p.waitingTime = currentTime - p.arrivalTime; // Calculate waiting time
            p.completionTime = currentTime + p.executionTime; // Calculate completion time
            p.turnaroundTime = p.completionTime - p.arrivalTime; // Calculate turnaround time
            currentTime += p.executionTime;// Update current time
        }

        displayResults(processes);
        CPUUtilizationCalculator.calculateAndDisplayCPUUtilizationAndIdleTime(processes); //method call
        AverageTimes.displayAverageTimes(processes); //method call
    }

    private void displayResults(ArrayList<Process> processes) {
        System.out.println("FCFS Scheduling Results:");
        for (Process p : processes) {
            System.out.println("Process " + p.processID + ": Arrival Time = " + p.arrivalTime +
                    ", Execution Time = " + p.executionTime + ", Waiting Time = " + p.waitingTime +
                    ", Turnaround Time = " + p.turnaroundTime + ", Completion Time = " + p.completionTime);
        }
    }
}