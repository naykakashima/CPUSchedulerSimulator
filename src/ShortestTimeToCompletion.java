import java.util.*;

public class ShortestTimeToCompletion {

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


            readyQueue.sort(Comparator.comparingInt(p -> p.remainingTime));
            Process current = readyQueue.removeFirst();

            currentTime += 1;
            current.remainingTime -= 1;


            if (current.remainingTime == 0) {
                current.completionTime = currentTime;
                current.turnaroundTime = current.completionTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.executionTime;
                completedProcesses.add(current);
            } else {
                readyQueue.add(current);
            }
        }

        displayResults(completedProcesses);


        CPUUtilizationCalculator.calculateAndDisplayCPUUtilizationAndIdleTime(completedProcesses);

        AverageTimes.displayAverageTimes(completedProcesses);

    }



    private void displayResults(ArrayList<Process> processes) {
        System.out.println("STCF Scheduling Results:");
        for (Process p : processes) {
            System.out.println("Process " + p.processID + ": Arrival Time = " + p.arrivalTime +
                    ", Execution Time = " + p.executionTime + ", Waiting Time = " + p.waitingTime +
                    ", Turnaround Time = " + p.turnaroundTime + ", Completion Time = " + p.completionTime);
        }
    }
}
