import java.util.*;

public class Sstf {
	static double nearest = -1;
	static double d;
	public static double abs(double d) {
		return (d < 0) ? -1*d : d;
	}
	public static double nearestNumber(double desiredNumber, double[] data) {
		double bestDistance = 1000;
		for(int i = 0; i < data.length; i++) {
			if(nearest == data[i]) {
				data[i] = 5000;
			}
		}
		for(int j = 1; j < data.length; j++) {
			d = abs(desiredNumber - data[j]);
			if(d < bestDistance) {
				bestDistance = d;
				nearest = data[j];
			}
		}
		return nearest;
	}
	public static void main(String[] args) {
		int n;
		double startHead;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[] data = new double[n+1];
		double[] sstf = new double[n+1];
		data[0] = sc.nextDouble();
		startHead = data[0];
		for(int i = 1; i <= n; i++) {
			data[i] = sc.nextDouble();
		}
		System.out.println("Before sorting:");
		for(int j = 0; j <= n; j++) {
			System.out.println(data[j]);
		}
		sstf[0] = data[0];
		for(int p = 0; p < data.length - 1; p++) {
			sstf[p+1] = nearestNumber(startHead, data);
			startHead = nearest;
		}
		System.out.println("After sorting:");
		for(int k = 0; k <= n; k++) {
			System.out.println(sstf[k]);
		}
	}
}
