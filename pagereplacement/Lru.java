import java.util.*;

public class Lru {
	static long[] uses = new long[100];
	public static boolean isPresent(int p,int[] f, int n) {
		for(int i = 0; i < n; i++) if(f[i] == p) return true;
		return false;
	}
	public static int findMin(int n) {
		long min = uses[0];
		int minIndex = 0;
		for(int i = 0; i < n; i++) { 
			if(uses[i] < min) {
				min = uses[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static void insertProcess(int p, int[] f, int n) {
		int minIndex = findMin(n);
		f[minIndex] = p;
		uses[minIndex] = System.currentTimeMillis();
	}

	public static void updateUse(int p, int[] f, int n) {
		for(int i = 0; i < n; i++) {
			if(f[i] == p) { 
				uses[i] = System.currentTimeMillis();
				break;
			}
		}
	}
	public static void printFrames(int f[], int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(f[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int fsize, hits = 0, misses = 0;
		Scanner sc = new Scanner(System.in);
		fsize = sc.nextInt();
		int n, p;
		n = sc.nextInt();
		int[] frames = new int[n];
		for(int i = 0; i < n; i++) {
			p = sc.nextInt();
			if(!isPresent(p, frames, n)) {
				misses++;
				insertProcess(p, frames, fsize);
				printFrames(frames, fsize);
			} else {
				updateUse(p, frames, fsize);
				printFrames(frames, fsize);
				hits++;
			}
		}
		System.out.print("Hits: ");
		System.out.println(hits);
		System.out.print("Misses: ");
		System.out.println(misses);
	}
}
