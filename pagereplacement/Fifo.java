import java.util.*;


class Fifo {
	public static boolean isPresent(int p, int[] f, int n) {
		for(int i = 0; i < n; i++) if(f[i] == p) return true;
		return false;
	}
	public static int insertProcess(int p, int[] f, int lastLoc, int n) {
		f[lastLoc] = p;
		if (lastLoc + 1 == n) lastLoc = 0;
		else lastLoc = lastLoc + 1;
		return lastLoc;
	}
	public static void printFrames(int[] f, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(f[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int fsize, pfaults = 0, hits = 0;
		Scanner sc = new Scanner(System.in);
		fsize = sc.nextInt();
		int[] frames = new int[fsize];
		int n, p;
		int lastLoc = 0;
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			p = sc.nextInt();
			if(!isPresent(p, frames, fsize)) {
				lastLoc = insertProcess(p, frames, lastLoc, fsize);
				printFrames(frames, fsize);
				pfaults++;
			} else {
				printFrames(frames, fsize);
				hits++;
			}
		}
		System.out.print("Hits: ");
		System.out.println(hits);
		System.out.print("Misses: ");
		System.out.println(pfaults);
	}
}
