package TimeCalculator;

/**
 * The Calculator class contains information to add time provided in duration
 * 
 * @author Samantha Ryan
 *
 */
public class Calculator {
	private int seconds;
	private int minutes;
	private int hours;
	private static final int SIXTY = 60;
	private static Calculator instance = null;

	/**
	 * Constructs a Calculator object starting with 0:00:00 duration
	 */
	private Calculator() {
		seconds = 0;
		minutes = 0;
		hours = 0;
	}

	/**
	 * Gets the instance of this calculator
	 * 
	 * @return instance of this calculator
	 */
	public static Calculator instanceOf() {
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}

	/**
	 * Adds the seconds and correctly handles overflow (when there are 60+
	 * seconds)
	 * 
	 * @param sec
	 *            number of seconds to add
	 * @return total number of seconds reflecting overflow handling
	 */
	private int addSeconds(int sec) {
		if (sec < 0) {
			throw new IllegalArgumentException();
		}
		seconds += sec;
		if (seconds > 59) {
			addMinutes(seconds / SIXTY);
			seconds %= SIXTY;
		}
		return seconds;
	}

	/**
	 * Adds the minutes and correctly handles overflow (when there are 60+
	 * minutes)
	 * 
	 * @param min
	 *            number of minutes to add
	 * @return total number of minutes reflecting overflow handling
	 */
	private int addMinutes(int min) {
		if (min < 0) {
			throw new IllegalArgumentException();
		}
		minutes += min;
		if (minutes > 59) {
			addHours(minutes / SIXTY);
			minutes %= SIXTY;
		}
		return minutes;
	}

	/**
	 * Adds the hours
	 * 
	 * @param hr
	 *            number of hours to add
	 * @return total number of hours
	 */
	private int addHours(int hr) {
		if (hr < 0) {
			throw new IllegalArgumentException();
		}
		hours += hr;
		return hours;
	}

	/**
	 * Adds a new time duration to the current total
	 * 
	 * @param hr
	 *            hours to add
	 * @param min
	 *            minutes to add
	 * @param sec
	 *            seconds to add to the total time
	 */
	public void addTime(int hr, int min, int sec) {
		addSeconds(sec);
		addMinutes(min);
		addHours(hr);
	}

	/**
	 * String representation of the total time
	 */
	public String toString() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	/**
	 * Resets the total time duration to 0:00:00
	 */
	public void resetTime() {
		seconds = 0;
		minutes = 0;
		hours = 0;
	}

	/**
	 * Subtracts the time
	 * 
	 * @param hr
	 *            hours to subtract
	 * @param min
	 *            minutes to subtract
	 * @param sec
	 *            seconds to subtract
	 */
	public void subtractTime(int hr, int min, int sec) {
		
	}

}
