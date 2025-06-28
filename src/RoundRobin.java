import java.util.*;

public class RoundRobin {
    private final int quantum;

    public RoundRobin(int quantum) {
        this.quantum = quantum;
    }

    public void schedule(ArrayList<Process> processes) {

        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        Queue<Process> readyQueue = new LinkedList<>();
        int currentTime = 0;
        int processIndex = 0;
        int n = processes.size();


        while (!readyQueue.isEmpty() || processIndex < n) {


            while (processIndex < n && processes.get(processIndex).arrivalTime <= currentTime) {
                readyQueue.add(processes.get(processIndex));
                processIndex++;
            }


            if (readyQueue.isEmpty()) {
                currentTime = processes.get(processIndex).arrivalTime;
                continue;
            }


            Process p = readyQueue.poll();


            if (p.remainingTime > this.quantum) {
                currentTime += this.quantum;
                p.remainingTime -= this.quantum;
                readyQueue.add(p);
            } else {
                currentTime += p.remainingTime;
                p.remainingTime = 0;
                p.completionTime = currentTime;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.executionTime;
            }


            while (processIndex < n && processes.get(processIndex).arrivalTime <= currentTime) {
                readyQueue.add(processes.get(processIndex));
                processIndex++;
            }
        }


        displayResults(processes);
        CPUUtilizationCalculator.calculateAndDisplayCPUUtilizationAndIdleTime(processes);
        AverageTimes.displayAverageTimes(processes);
    }

    private void displayResults(ArrayList<Process> processes) {
        System.out.println("Round Robin Scheduling Results:");
        for (Process p : processes) {
            System.out.println("Process " + p.processID + ": Arrival Time = " + p.arrivalTime +
                    ", Execution Time = " + p.executionTime + ", Waiting Time = " + p.waitingTime +
                    ", Turnaround Time = " + p.turnaroundTime + ", Completion Time = " + p.completionTime);
        }
    }
}
