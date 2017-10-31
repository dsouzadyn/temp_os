import java.util.*;

class Process implements Comparable<Process> {
	public double bt;
	int priority;
	public Process(double bt, int priority) {
		this.bt = bt;
		this.priority = priority;
	}
	public int compareTo(Process p) {
		return (int)(this.priority - p.priority);
	}
}

public class Priority {
	public static double add(double[] d) {
		double sum = 0;
		for(int i = 0; i < d.length; i++) sum += d[i];
		return sum;
	}
	public static void main(String[] args) {
		int n, b, p;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[] wt = new double[n];
		double[] tat = new double[n];
		ArrayList<Process> cpu = new ArrayList<Process>();
		for(int i = 0; i < n; i++) {
			b = sc.nextInt();
			p = sc.nextInt();
			cpu.add(new Process(b, (int)p));
		}
		Collections.sort(cpu);
		wt[0] = 0;
		for(int i = 1; i < n; i++) {
			wt[i] = wt[i-1] + cpu.get(i-1).bt;
		}
		for(int i = 0; i < n; i++) {
			tat[i] = wt[i] + cpu.get(i).bt;
		}
		double awt = add(wt)/(double)n;
		double atat = add(tat)/(double)n;
		System.out.println(awt);
		System.out.println(atat);
	}
}
