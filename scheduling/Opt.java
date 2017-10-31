import java.util.*;

public class Opt {
	public static boolean isFree(int[] frames) {
		for(int i = 0; i < frames.length; i++) {
			if (frames[i] == -1) return true;
		}
		return false;
	}
	public static void printFrames(int[] frames) {
		for(int i = 0; i < frames.length; i++) {
			System.out.print(frames[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	public static int findLeastUsed(int[] frames, int[] process, int pIndex) {
		int[] fIndexes = new int[frames.length];
		for(int j = 0; j < fIndexes.length; j++) fIndexes[j] = 5000;
		int fIndexMax = 0;
		int fIndex = 0;
		for(int f = 0; f < frames.length; f++) {
			for(int p = pIndex + 1; p < process.length; p++) {
				if (frames[f] == process[p]) {
					fIndexes[f] = p;
					break;
				}	
			}
		}
		for(int i = 0; i < fIndexes.length; i++) {
			if(fIndexes[i] > fIndexMax) {
				fIndexMax = fIndexes[i];
				fIndex = i;
			}
		}
		return fIndex;
	}
	public static boolean isPresent(int[] frames, int p) {
		for(int f = 0; f < frames.length; f++) {
			if(frames[f] == p) return true;
		}
		return false;
	}
	public static void insertProcess(int[] frames, int[] process, int pIndex) {
		int hits = 0; int misses = 0;
		int fIndex = 0;
		for(int j = pIndex; j < process.length; j++) {
			if(isFree(frames)){
				if(!isPresent(frames, process[j])) { 
					frames[fIndex++] = process[j];
					misses++;
				} else {
					hits++;
				}
				printFrames(frames);
			}
			else {
				if(!isPresent(frames, process[j])) {
					fIndex = findLeastUsed(frames, process, j);
					frames[fIndex] = process[j];
					misses++;
				} else {
					hits++;
				}
				printFrames(frames);
			}
		}
		System.out.print("Hits: ");
		System.out.println(hits);
		System.out.print("Misses: ");
		System.out.println(misses);
		
	}
	public static void main(String[] args) {
		int n, nFrames;
		Scanner sc = new Scanner(System.in);
		nFrames = sc.nextInt();
		int[] frames = new int[nFrames];
		for(int f = 0; f < frames.length; f++) frames[f] = -1;
		n = sc.nextInt();
		int[] processes = new int[n];
		for(int i = 0; i < n; i++) {
			processes[i] = sc.nextInt();
		}
		insertProcess(frames, processes, 0);
	}
}
