CPU Scheduler Simulator
=======================

A simple Java-based CPU scheduling simulator for educational purposes. 
This tool allows users to input a set of processes and simulate different scheduling algorithms used in Operating Systems.

Supported Scheduling Algorithms:
--------------------------------
1. First Come First Serve (FCFS)
2. Shortest Job First (SJF)
3. Round Robin (RR) - with configurable time quantum
4. Shortest Time to Completion First (STCF) - preemptive SJF

Features:
---------
- Calculates and displays:
  * Waiting Time
  * Turnaround Time
  * Completion Time
  * CPU Utilization
  * Idle Time
  * Average Response and Turnaround Time
- Modular algorithm design: each algorithm is implemented in its own class
- Clean console-based interface
- Supports real-time process arrival (arrival time simulation)

How to Use:
-----------
1. Run the `Main` class.
2. Input the number of processes.
3. For each process, enter:
   - Arrival Time
   - Execution Time
4. Choose the scheduling algorithm:
   - 1 for FCFS
   - 2 for SJF
   - 3 for Round Robin (you'll be prompted for time quantum)
   - 4 for STCF
5. View simulation results directly in the console.

Code Overview:
--------------
- `Main.java`                        : User input and algorithm selection
- `Process.java`                    : Process data structure
- `FirstComeFirstServe.java`       : FCFS implementation
- `ShortestJobFirst.java`          : SJF implementation
- `RoundRobin.java`                : RR implementation (preemptive)
- `ShortestTimeToCompletion.java`  : STCF implementation (preemptive SJF)
- `AverageTimes.java`              : Averages for response and turnaround time
- `CPUUtilizationCalculator.java`  : Calculates CPU usage and idle time

Educational Focus:
------------------
This project is designed for students and developers learning Operating System fundamentals. 
It emphasizes clarity and correctness over performance, making it easy to understand, extend, or modify.

License:
--------
MIT License (or specify your own if applicable)

Developed by: [Your Name or GitHub Username]
