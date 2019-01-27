import java.util.*;
import java.io.*;
public class rainfall_storage{
	
	//https://dmoj.ca/problem/cco17p4

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>[] rain = new ArrayList[n];
		int[] a = new int[n];
		boolean[] sum = new boolean[25000];
		sum[0] = true;
		for (int i=0; i<n; i++) {
			rain[i] = new ArrayList<Integer>();
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i=0; i<n-1; i++) {
			if (i-1>=0&&a[i]==a[i-1]) {
				rain[i].addAll(rain[i-1]);
				continue;
			}
			for (int l=n-2; l>i; l--) {
				if (rain[i].contains(a[l]-a[i])) continue;
				rain[i].add(a[l]-a[i]);
			}
		}

//		for (ArrayList<Integer> r: rain) {
//			for (int w: r) {
//				System.out.print(w+" ");
//			}
//			System.out.println();
//		}

		//for each rain
		for (int i=0; i<n; i++) {
			for (int q=sum.length-1; q>=0; q--) {
				for (int w: rain[i]) {
					if (sum[q]&&q+w<sum.length&&!sum[q+w]) {
						sum[q+w] = true;
					}
				}
			}
		}

		for (int i=0; i<sum.length; i++) {
			if (sum[i]) System.out.print(i+" ");
		}



	}

	static class FastReader{ 
		BufferedReader br; StringTokenizer st; 
		public FastReader(InputStream x) { br = new BufferedReader(new InputStreamReader(x));} 
		String next() { while (st == null || !st.hasMoreElements()) {
			try { st = new StringTokenizer(br.readLine());}
			catch (IOException e) { e.printStackTrace();}
		} return st.nextToken();}
		int nextInt() { return Integer.parseInt(next());}
		long nextLong() { return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
		String nextLine() { String str = "";
		try { str = br.readLine(); }
		catch (IOException e) { e.printStackTrace(); }
		return str;
		}
	}
}
