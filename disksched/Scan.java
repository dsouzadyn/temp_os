import java.util.*;
class ScanDisk {
	int[] x;
	int[] finalX;
	int startingHead;
	public ScanDisk(int[] scan, int start) {
		x = scan;
		finalX = new int[x.length + 2];
		startingHead = start;
	}
	public int[] calculateScanDisk() {
		int[] sortedX = new int[x.length];
		int[] modified;
		int count = 0;
		for(int i = 0; i < x.length; i++) {
			if(x[i] >= 0 && x[i] < startingHead) {
				sortedX[count++] = x[i];
			}
		}
		modified = new int[count];
		for(int i = 0; i < modified.length; i++) {
			modified[i] = sortedX[i];
		}
		Arrays.sort(modified);
		int num = 0;
		finalX[num] = startingHead;
		num++;
		for(int i = modified.length - 1; i >= 0; i--) {
			finalX[num++] = modified[i];
		}
		finalX[num] = 0;
		num++;
		int b = 0;
		int[] secondPart = new int[finalX.length];
		for(int i = 0; i < x.length; i++) {
			if(x[i] > startingHead) {
				secondPart[b++] = x[i];
			}
		}
		int[] abc = new int[b];
		for(int i = 0; i < abc.length; i++) {
			abc[i] = secondPart[i];
		}
		Arrays.sort(abc);
		for(int i = 0; i < b; i++) {
			finalX[num++] = abc[i];
		}
		int[] readyX = new int[finalX.length - 1];
		for(int i = 0; i < readyX.length; i++) {
			readyX[i] = finalX[i];
		}
		return finalX;
	}
}
public class Scan {
	public static void main(String[] args) {
		int n, start;
		double seekTime = 0;
		double ast = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		start = sc.nextInt();
		int[] data = new int[n+1];
		data[0] = start;
		for(int i = 0; i < n; i++) {
			data[i+1] = sc.nextInt();
		}
		ScanDisk sd = new ScanDisk(data, start);
		int[] scanned = sd.calculateScanDisk();
		for(int i = 0; i < scanned.length; i++) {
			System.out.print(scanned[i]);
			System.out.print(" ");
		}
		for(int i = 0; i < scanned.length - 1; i++) {
			seekTime += Math.abs(scanned[i] - scanned[i+1]);
		}
		System.out.println();
		System.out.println(seekTime);
		System.out.println(((double)seekTime)/((double)scanned.length));
	}
}
