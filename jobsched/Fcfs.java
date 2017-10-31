import java.util.*;
class Process {
	public double bt;
}
public class Fcfs {
	public static double add(double[] d) {
		double sum = 0;
		for(int i = 0; i < d.length; i++) sum += d[i];
		return sum;
	}
	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Process[] cpu = new Process[n];
		for(int i = 0; i < n; i++) {
			cpu[i] = new Process();
			cpu[i].bt = sc.nextInt();
		}
		double[] wt = new double[n];
		double[] tat = new double[n];
		wt[0] = 0;
		for(int i = 1; i < cpu.length; i++) {
			wt[i] = cpu[i-1].bt + wt[i-1];
		}
		tat[0] = cpu[0].bt;
		for(int i = 0; i < cpu.length; i++) {
			tat[i] = cpu[i].bt + wt[i];
		}
		double awt = (add(wt)/(double)n);
		System.out.println(awt);
		double atat = (add(tat)/(double)n);
		System.out.println(atat);
	}
}
