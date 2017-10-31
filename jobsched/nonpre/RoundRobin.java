import java.util.*;

class Process {
	public double bt;
	boolean done = false;
	public Process(double bt) {
		this.bt = bt;
	}
	public boolean isDone() {
		return done;
	}
	public void setIsDone(boolean done) {
		this.done = done;
	}
}

class RoundRobin {
	public static double add(double[] d) {
		double sum = 0;
		for(int i = 0; i < d.length; i++) sum += d[i];
		return sum;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int tslice = 1;
		int time = 0;
		boolean complete = false;
		ArrayList<Process> cpu = new ArrayList<Process>();
		for(int i = 0; i < n; i++) {
			cpu.add(new Process(sc.nextDouble()));
		}
		while(!complete) {
			for(int i = 0; i < n; i++) {
			
			}

		}
	}
}
