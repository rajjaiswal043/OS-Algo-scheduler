import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Process {
    int id;
    int burstTime;
    int remainingTime;
    int arrivalTime;

    public Process(int id, int burstTime, int arrivalTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", burstTime=" + burstTime +
                ", remainingTime=" + remainingTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}

class Scheduler {

    // Round Robin
    public void roundRobin(Queue<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>(processes);
        System.out.println("Round Robin Scheduling:");
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            if (process.remainingTime > quantum) {
                process.remainingTime -= quantum;
                System.out.println("Process " + process.id + " executed for " + quantum + " units.");
                queue.add(process);
            } else {
                System.out.println("Process " + process.id + " executed for " + process.remainingTime + " units and finished.");
                process.remainingTime = 0;
            }
        }
    }

    // First In First Out
    public void fifo(Queue<Process> processes) {
        Queue<Process> queue = new LinkedList<>(processes);
        System.out.println("First In First Out Scheduling:");
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            System.out.println("Process " + process.id + " executed for " + process.burstTime + " units and finished.");
        }
    }

    // Shortest Job First
    public void sjf(Queue<Process> processes) {
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.burstTime, b.burstTime));
        pq.addAll(processes);
        System.out.println("Shortest Job First Scheduling:");
        while (!pq.isEmpty()) {
            Process process = pq.poll();
            System.out.println("Process " + process.id + " executed for " + process.burstTime + " units and finished.");
        }
    }

    // Uni-programming
    public void uniProgramming(Process process) {
        System.out.println("Uni-programming Scheduling:");
        System.out.println("Process " + process.id + " executed for " + process.burstTime + " units and finished.");
    }

    public static void main(String[] args) {
        Queue<Process> processes = new LinkedList<>();
        processes.add(new Process(1, 10, 0));
        processes.add(new Process(2, 5, 1));
        processes.add(new Process(3, 8, 2));

        Scheduler scheduler = new Scheduler();

        System.out.println("\nRound Robin:");
        scheduler.roundRobin(new LinkedList<>(processes), 4);

        System.out.println("\nFIFO:");
        scheduler.fifo(new LinkedList<>(processes));

        System.out.println("\nSJF:");
        scheduler.sjf(new LinkedList<>(processes));

        System.out.println("\nUni-programming:");
        scheduler.uniProgramming(new Process(4, 15, 3));
    }
}
// Operating System Scheduling Algorithms Simulation in Java

// Implemented and simulated Round Robin, FIFO, SJF, and uni-programming scheduling algorithms in Java. Utilized priority queues for SJF and quantum counters to ensure fair resource allocation. Documented project specifications, designed test cases, and verified algorithm efficiency.

// - Developed Java applications for simulating Round Robin, FIFO, SJF, and uni-programming scheduling algorithms.
// - Implemented priority queues for SJF to prioritize processes based on burst times, enhancing scheduling efficiency.
// - Utilized quantum counters in round-robin scheduling to prevent process starvation and ensure fair CPU time allocation.
// - Documented project details and findings, providing a reference for future enhancements and optimizations.

// Technologies: Java, Queue, PriorityQueue
// Skills: Java programming, algorithm design, problem-solving, documentation
// 