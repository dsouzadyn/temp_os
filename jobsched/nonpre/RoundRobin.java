import java.util.*;

class Process {
	public double bt;
	public double rt;
	boolean done = false;
	public Process(double bt) {
		this.bt = bt;
		this.rt = this.bt;
	}
	public boolean isDone() {
		return done;
	}
	public void setIsDone(boolean done) {
		this.done = done;
	}
}

class RoundRobin {
	public static double add(double[] d) {
		double sum = 0;
		for(int i = 0; i < d.length; i++) sum += d[i];
		return sum;
	}
	public static void main(String[] args) {
		int n;
		double t = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double timeslice = 2;
		boolean complete = false;
		ArrayList<Process> cpu = new ArrayList<Process>();
		double[] wt = new double[n];
		double[] tat = new double[n];
		
		for(int i = 0; i < n; i++) {
			cpu.add(new Process(sc.nextDouble()));
		}
		while(!complete) {
			for(int i = 0; i < n; i++) {
				Process temp = cpu.get(i);
				if(!temp.isDone()) {
					if(temp.rt > timeslice) {
						temp.rt = temp.rt - timeslice;
						t += timeslice;
					} else {
						temp.setIsDone(true);
						t = t + temp.rt;
						wt[i] = t - temp.bt;
					}
				}
			}
			complete = true;
			for(int i = 0; i < n; i++) {
				if(!(cpu.get(i)).isDone()) {
					complete = false;
					break;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			tat[i] = (cpu.get(i)).bt + wt[i];
		}
		double awt = add(wt)/(double)n;
		double atat = add(tat)/(double)n;
		System.out.println(awt);
		System.out.println(atat);
	}
}
