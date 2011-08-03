// beer bottle song

class BeerSong {
	public static void song(int bottles){
		String bottle;
		if (bottles == 0){
			System.out.println("No bottle of beer on the wall,");
			System.out.println("no bottles of beer,");
			System.out.println("ya' can't take one down,");
			System.out.println("ya' can't pass it around,");
			System.out.println("'cause there are no more bottles of beer on the wall!");
			System.out.println("");
		} else {
			if (bottles == 1){
				bottle = "bottle";
						
			} else {
				bottle = "bottles";
			}
			
			System.out.println(bottles +" "+ bottle +" of beer on the wall,");
			System.out.println(bottles +" "+ bottle +" of beer,");
			System.out.println("ya' take one down,");
			System.out.println("ya' pass it around,");
			System.out.println(bottles -1 +" "+ bottle +" of beer on the wall.");
			System.out.println(" ");
			song(bottles -1);
		}
	}
	public static void main(String[] args) {
		int bottles = 99;
		song(bottles);
	}
}