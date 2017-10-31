import java.util.*;

public class Sstfk {
	static double nearest = -1;
	public static double abs(double d) {
		return (d < 0) ? -1*d : d;
	}
	public static double findNearest(double desiredNumber, double[] data) {
		double d;
		double nearestDistance = 1000;
		for(int i = 0; i < data.length; i++) {
			if(nearest == data[i])
				data[i] = 5000;
		}
		for(int k = 1; k < data.length; k++) {
			d = abs(data[k] - desiredNumber);
			if (d < nearestDistance) {
				nearestDistance = d;
				nearest = data[k];
			}
		}
		return nearest;
	}
	public static void main(String[] args) {
		int n;
		double startHead;
		double seekTime = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[] data = new double[n+1];
		double[] sstf = new double[n+1];
		startHead = sc.nextDouble();
		data[0] = startHead;
		sstf[0] = startHead;
		for(int p = 1; p <= n; p++) {
			data[p] = sc.nextDouble();
		}
		for(int i = 0; i < data.length - 1; i++) {
			sstf[i+1] = findNearest(startHead, data);
			startHead = nearest;
		}
		for(int c = 0; c < data.length - 1; c++) {
			seekTime += abs(sstf[c] - sstf[c+1]);
		}
		for(int i = 0; i < data.length; i++) {
			System.out.println(sstf[i]);
		}
		System.out.println(seekTime);
	}
}
