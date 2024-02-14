/**
 * 
 */
package collection;

import java.util.Arrays;

/**
 * Java program that creates a song array.
 * 
 * @author KathrynIrving
 * @version 2.15.2023_351
 */
public class SongArray {

	/** Private fields which represent the song array class */
	private static final int MAX = 10;
	private Song[] songArray;
	private int size;

	/**
	 * Constructor that creates an array of songs with a maximum amount it can hold
	 */
	public SongArray() {
		songArray = new Song[MAX];
		size = 0;
	}

	/**
	 * Method that adds a song to the array unless it would exceed the max number of
	 * songs allowed
	 */
	public boolean addSong(Song newSong) {
		if (size >= MAX) {
			System.out.println("Reached maximum number of songs, no new songs added.");
			return false;
		} else {
			songArray[size] = newSong;
			size++;
			return true;
		}
	}

	/** Method that finds where in the array a song is located */
	public int findSong(String title) {
		for (int i = 0; i < size; i++) {
			if (songArray[i].getTitle() == title) {
				return i;
			}
		}
		return -1;
	}

	/** Method that swaps the order of songs */
	public void swapSong(int swap1, int swap2) {
		Song temp = songArray[swap1];
		songArray[swap1] = songArray[swap2];
		songArray[swap2] = temp;
	}

	/** Method that sorts the songs by the writer using swapSong method */
	public void sortByWriter() {
		for (int i = 1; i < size; i++) {
			for (int j = size - 1; j >= i; j--) {
				if (songArray[j].getWriter().compareTo(songArray[j - 1].getWriter()) < 0) {
					swapSong(j, j - 1);
				}
			}
		}
	}

	/** Method that sorts the songs by the duration using swapSong method */
	public void sortByDuration() {
		for (int i = 1; i < size; i++) {
			for (int j = size - 1; j >= i; j--) {
				if (songArray[j].getDuration() < songArray[j - 1].getDuration()) {
					swapSong(j, j - 1);
				}
			}
		}
	}

	/** Method that sorts the songs by the genre using swapSong method */
	public void sortByGenre() {
		for (int i = 1; i < size; i++) {
			for (int j = size - 1; j >= i; j--) {
				if ((songArray[j].getGenre()).compareTo(songArray[j - 1].getGenre()) < 0) {
					swapSong(j, j - 1);
				}
			}
		}
	}

	/**
	 * Method that sorts the songs by the year the song was released using swapSong
	 * method
	 */
	public void sortByYear() {
		for (int i = 1; i < size; i++) {
			for (int j = size - 1; j >= i; j--) {
				if (songArray[j].getYear() < songArray[j - 1].getYear()) {
					swapSong(j, j - 1);
				}
			}
		}
	}

	/** Method that puts the array into a string */
	public String toString() {
		return Arrays.toString(songArray) + "\n";
	}

	/** Method that returns the size of the array */
	public int getSize() {
		return size;
	}
}
