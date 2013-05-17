
class Binsearch {

	public int binsearch(int[] array, int el) {
		return binsearch(array, 0, array.length-1, el);
	}

	public int calculateHalf(int start, int end) {
		return start + (end-start)/2;
		// wow, unsigned bitshift! :)
		//return (start+end) >>>1;
	}

	private int binsearch(int[] array, int start, int end, int el) {
		if ( end < start ) return -1;

		//int half = start + (end-start)/2;
		int half = calculateHalf(start, end);

		if ( array[half] == el )
			return half;
		if ( start == end )
			return -1;

		if ( array[half] > el )
			return binsearch(array, 0, half-1, el);
		else
			return binsearch(array, half+1, end, el);
	}

	Binsearch() {
	}

	Binsearch(String[] args) {
		if ( args.length == 0 ) 
			System.exit(-1);

		int[] array = new int[args.length];

		System.out.println("argc (and el to look for): " + args.length);

		for ( int i = 0 ; i < args.length ; i++ )
			array[i] = Integer.parseInt(args[i]);

		System.out.println("array (must be sorted): ");
		for ( int i = 0 ; i < args.length ; i++ )
			System.out.print(array[i] + " ");
		System.out.println();

		int ret = binsearch(array, args.length);

		if ( ret == -1 )
			System.out.println("Not Found");
		else
			System.out.println("Found at " + ret);
	}

	public static void main (String[] args) {
		new Binsearch(args);
	}

}
