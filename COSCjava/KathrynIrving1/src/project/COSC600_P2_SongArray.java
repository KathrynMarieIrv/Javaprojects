/**
 * 
 */
package project;

import collection.Song;
import collection.SongArray;

/**
 * Song and SongArray testing class
 * 
 * @author KathrynIrving
 * @version 2.15.2023_351
 */

public class COSC600_P2_SongArray {

	/** Test method for test class */

	public static void test() {
		Song s1 = new Song();
		Song s2 = new Song();
		Song s3 = new Song();
		Song s4 = new Song();
		Song s5 = new Song();
		Song s6 = new Song();

		s1.setSong("Brick by Boring Brick", "Paramore", "Paramore", 4.1, "Alternative", 2009);
		s2.setSong("Longshot", "Catfish and the Bottlemen", "Catfish and the Bottlemen", 3.5, "Indie", 2022);
		s3.setSong("Blank Space", "Taylor Swift", "Taylor Swift", 4.3, "Pop", 2014);
		s4.setSong("Cyanide", "Metallica", "Metallica", 6.4, "Metal", 2008);
		s5.setSong("Eclipse", "Pink Floyd", "Pink Floyd", 2.2, "Rock", 1972);
		s6.setSong("Soldier", "Gavin Degraw", "Gavin Degraw", 3.3, "Pop", 2011);

		SongArray sArray = new SongArray();

		sArray.addSong(s1);
		sArray.addSong(s2);
		sArray.addSong(s3);
		sArray.addSong(s4);
		sArray.addSong(s5);
		sArray.addSong(s6);

		System.out.println("Songs in unsorted order as entered\n");
		System.out.println(sArray.toString());
		System.out.println();

		System.out.println("Array Index for song: Yelp\t" + sArray.findSong("Yelp") + "\n");

		if (sArray.findSong("Yelp") == -1)
			System.out.println("Song not found!\n");

		System.out.println(
				"Array Index for song: Brick by Boring Brick\t" + sArray.findSong("Brick by Boring Brick") + "\n");

		if (sArray.findSong("Brick by Boring Brick") == -1)
			System.out.println("Song not found!\n");

		System.out.println("Songs sorted by duration:\n");
		sArray.sortByDuration();
		System.out.println(sArray.toString());

		System.out.println("Songs sorted by genre:\n");
		sArray.sortByGenre();
		System.out.println(sArray.toString());

		System.out.println("Songs sorted by writer:\n");
		sArray.sortByWriter();
		System.out.println(sArray.toString());

		System.out.println("Songs sorted by year:\n");
		sArray.sortByYear();
		System.out.println(sArray.toString());

	}

}
