import java.util.*;

class Bankers {
	public static boolean check(int[] a, int[][] n, int r) {
		for(int i = 0; i < a.length; i++) {
			if(n[r][i] > a[i]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int nProcesses;
		int nResources;
		Scanner sc = new Scanner(System.in);
		nProcesses = sc.nextInt();
		nResources = sc.nextInt();
		int[][] allocatedMatrix = new int[nProcesses][nResources];
		int[][] maxMatrix = new int[nProcesses][nResources];
		int[][] needMatrix = new int[nProcesses][nResources];
		int[] available = new int[nResources];
		System.out.println("Enter allocation matrix:");
		for(int i = 0; i < nProcesses; i++) {
			for(int j = 0; j < nResources; j++) {
				allocatedMatrix[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		System.out.println("Enter max matrix:");
		for(int i = 0; i < nProcesses; i++) {
			for(int j = 0; j < nResources; j++) {
				maxMatrix[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		for(int i = 0; i < nProcesses; i++) {
			for(int j = 0; j < nResources; j++) {
				needMatrix[i][j] = maxMatrix[i][j] - allocatedMatrix[i][j];
			}
		}
		System.out.println("Enter available resources:");
		for(int i = 0; i < nResources; i++) {
			available[i] = sc.nextInt();
		}
		boolean done[] = new boolean[nProcesses];
		boolean allocated = false;
		for(int i = 0; i < nProcesses; i++) {
			if(!done[i] && check(available, needMatrix, i)) {
				done[i] = true;
				for(int r = 0; r < available.length; r++) {
					available[r] = available[r] - needMatrix[i][r] + maxMatrix[i][r];
				}
				allocated = true;
				System.out.println("Allocated Process " + i);
			}
			if(!allocated) break;
		}
		if(!allocated) System.out.println("Could not allocate process");
		else System.out.println("Resources allocated safely");
	} 
}
