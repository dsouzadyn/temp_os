import java.util.*;

public class Fcfs {
	public static double abs(double d) {
		return (d < 0) ? -1*d : d; 
	}
	public static void main(String args[]) {
		int n; 
		double seekTime = 0, startHead;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[] data = new double[n+1];
		data[0] = sc.nextDouble();
		for(int i = 1; i <= n; i++) {
			data[i] = sc.nextDouble(); 
		}
		for(int i = 0; i < n-1; i++) {
			//100 23 89 132 42 187
			seekTime += abs(data[i] - data[i+1]);
			System.out.println(abs(data[i] - data[i+1]));
		}
		System.out.println(seekTime);

		System.out.println(seekTime/n);
	}	
}
