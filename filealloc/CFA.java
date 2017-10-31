import java.util.*;
class FAT {
	int start;
	int size;
	char name;
	boolean allocated;
	FAT(int start, int size, char name, boolean allocated) {
		this.start = start;
		this.size = size;
		this.name = name;
		this.allocated = allocated;
	}
}
public class CFA {
	static char[] M = new char[100];
	static boolean isFree(int start, int size) {
		if(start + size < 100) {
			for(int i = start; i < start+size; i++) {
				if(M[i] != 0)
					return false;
			}
		} else {
			return false;
		}
		return true;
	}
	static boolean allocate(int start, int size, char fname) {
		if(isFree(start, size)) {
			for(int i = start; i < start + size; i++) {
				M[i] = fname;
			}
			return true;
		} else {
			return false;
		}
	}
	static void printFAT(ArrayList<FAT> fat) {
		for(FAT f: fat) {
			System.out.print("Name:");
			System.out.println(f.name);
			System.out.print("Size:");
			System.out.println(f.size);
			System.out.print("Start:");
			System.out.println(f.start);
			System.out.print("Allocated:");
			System.out.println(f.allocated);
		}
	}
	public static void main(String[] args) {
		ArrayList<FAT> fat = new ArrayList<FAT>();
		int n;
		char fname;
		int size, start;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Enter start address:");
			start = sc.nextInt();
			System.out.println("Enter size:");
			size = sc.nextInt();
			System.out.println("Enter name:");
			fname = sc.next().charAt(0);
			if(allocate(start, size, fname)) {
				fat.add(new FAT(start, size, fname, true));
			} else {
				fat.add(new FAT(start, size, fname, false));
			}
		}
		printFAT(fat);
	}
}
