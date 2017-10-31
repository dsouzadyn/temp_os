import java.util.*;
class Process implements Comparable<Process> {
	public double bt;
	public Process(double bt) {
		this.bt = bt;
	}
	public int compareTo(Process x) {
		return (int)(this.bt - x.bt);
	}
}
public class Sjf {
	public static double add(double[] d) {
		double sum = 0;
		for(int i = 0; i < d.length; i++) sum += d[i];
		return sum;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ArrayList<Process> cpu = new ArrayList();
		double[] wt = new double[n];
		double[] tat = new double[n];
		for(int i = 0; i < n; i++) {
			cpu.add(new Process(sc.nextDouble()));
		}
		wt[0] = 0;
		Collections.sort(cpu);
		for(int i = 1; i < cpu.size(); i++) {
			wt[i] = wt[i-1] + cpu.get(i-1).bt;
		}
		for(int i = 0; i < cpu.size(); i++) {
			tat[i] = wt[i] + cpu.get(i).bt;
		}
		double awt, atat;
		awt = add(wt)/(double)n;
		atat = add(tat)/(double)n;
		System.out.println(awt);
		System.out.println(atat);
	}
}
