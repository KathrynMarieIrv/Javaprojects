/**
 * 
 */
package collection;

import java.lang.String;
import java.time.Year;

/**
 * Java program that defines a Song
 * 
 * @author KathrynIrving
 * @version 2.15.2023_351
 */

public class Song {

	/** Private fields which represent the Song */

	private String title;
	private String writer;
	private String singer;
	private double duration;
	private String genre;
	private int year;

	/** Constructor that makes the song fields empty */
	public Song()

	{
		title = "";
		writer = "";
		singer = "";
		duration = 0.0;
		genre = "";
		year = 0;
	}

	/** Method that sets the Song */
	public void setSong(String title, String writer, String singer, double duration, String genre, int year) {
		this.title = title;
		this.writer = writer;
		this.singer = singer;
		this.duration = duration;
		this.genre = genre;
		this.year = year;

		if (title != "") {
			this.title = title;
		}

		if (writer != "") {
			this.writer = writer;
		}

		if (singer != "") {
			this.singer = singer;
		}

		if (duration != 0.0) {
			this.duration = duration;
		}

		if (genre != "") {
			this.genre = genre;
		}

		if (year > 1900 && year < Year.now().getValue()) {
			this.year = year;
		}
	}

	/** Method that returns the title of the song */
	public String getTitle() {
		return title;
	}

	/** Method that returns the writer of the song */
	public String getWriter() {
		return writer;
	}

	/** Method that returns the singer of the song */
	public String getSinger() {
		return singer;
	}

	/** Method that returns the duration of the song */
	public double getDuration() {
		return duration;
	}

	/** Method that returns the genre of the song */
	public String getGenre() {
		return genre;
	}

	/** Method that returns the year the song was released */
	public int getYear() {
		return year;
	}

	/** Method that puts all of the information for the song into a string */
	public String toString() {
		return "\n" + "\tTitle: " + title + "\tWriter: " + writer + "\tSinger: " + singer + "\tDuration: " + duration
				+ " minutes" + "\tGenre: " + genre + "\tYear: " + year;
	}
}