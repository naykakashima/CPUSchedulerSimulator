import java.util.*;

public class ShortestJobFirst {
    public void schedule(ArrayList<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        ArrayList<Process> readyQueue = new ArrayList<>();
        ArrayList<Process> completedProcesses = new ArrayList<>();
        int currentTime = 0;
        while (!processes.isEmpty() || !readyQueue.isEmpty()) {
            for (Iterator<Process> iterator = processes.iterator(); iterator.hasNext(); ) {
                Process p = iterator.next();
                if (p.arrivalTime <= currentTime && !readyQueue.contains(p)) {
                    readyQueue.add(p);
                    iterator.remove();
                }
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }


            readyQueue.sort(Comparator.comparingInt(p -> p.executionTime));
            Process current = readyQueue.removeFirst();
            current.waitingTime = currentTime - current.arrivalTime;
            current.completionTime = currentTime + current.executionTime;
            current.turnaroundTime = current.completionTime - current.arrivalTime;
            currentTime += current.executionTime;
            completedProcesses.add(current);
        }

        displayResults(completedProcesses);
        CPUUtilizationCalculator.calculateAndDisplayCPUUtilizationAndIdleTime(completedProcesses);
        AverageTimes.displayAverageTimes(completedProcesses);
    }


    private void displayResults(ArrayList<Process> completedProcesses) {
        System.out.println("SJF Scheduling Results:");
        for (Process p : completedProcesses) {
            System.out.println("Process " + p.processID + ": Arrival Time = " + p.arrivalTime +
                    ", Execution Time = " + p.executionTime + ", Waiting Time = " + p.waitingTime +
                    ", Turnaround Time = " + p.turnaroundTime + ", Completion Time = " + p.completionTime);
        }
    }
}
