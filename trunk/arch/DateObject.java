
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.arch;

/**
 * Object for storing a date and date mask.
 * <p>
 * <b>Examples:</b><br>
 * <hr>
 * If the object stores 1990 then<br>
 * getDate() -> 01/01/1990<br>
 * getSortDate() -> 19900101<br>
 * getMask() -> 1<p>
 *
 * If the object stores Feb 1996 then<br>
 * getDate() -> 02/01/1990<br>
 * getSortDate() -> 19900201<br>
 * getMask() -> 2<p>
 *
 * If the object stores Apr. 23, 1996 then<br>
 * getDate() -> 04/23/1996<br>
 * getSortDate() -> 19900423<br>
 * getMask() -> 3<p>
 *
 * <P>
 * @author Matthew Schaub
 */
public class DateObject extends Object {
/** Data Mask Constant */
  public static final int YEAR_ONLY = 1;
/** Data Mask Constant */
  public static final int MONTH_YEAR = 2;
/** Data Mask Constant */
  public static final int DAY_MONTH_YEAR = 3;
/** Data Mask Constant */
  public static final int NULL_DATE = 4;

/** Local year variable */
  private String year = "0001";
/** Local month variable */
  private String month = "01";
/** Local day variable */
  private String day = "01";

/** Was the year field set? T/F */
  private boolean yearB = false;
/** Was the month field set? T/F */
  private boolean monthB = false;
/** Was the day field set? T/F */
  private boolean dayB = false;

/**
  * Constructs a new instance.
  */
  public DateObject() {
    super();
  }

/**
  * Set the year.
  * @param year YYYY
  */
  public void setYear(String year) {
    this.year = year;
    yearB = true;
  }

/**
  * Set the month.
  * @param month MM
  */
  public void setMonth(String month) {
    this.month = month;
    monthB = true;
  }

/**
  * Set the day.
  * @param year DD
  */
  public void setDay(String day) {
    this.day = day;
    dayB = true;
  }

/**
  * Convert date to string - MM/DD/YYYY
  * @return String MM/DD/YYYY
  */
  public String toString() {
    return getDate();
  }

/**
  * Convert date to string - MM/DD/YYYY
  * @return String MM/DD/YYYY
  */
  public String getDate() {
    return month + "/" + day + "/" + year;
  }

/**
  * Convert date to a sortable value.
  * @return String YYYYMMDD
  */
  public String getSortDate() {
    return year + month + day;
  }

/**
  * Get the date mask field.
  * @return int Date Mask
  */
  public int getMask() {
    int mask;

    if (dayB && monthB && yearB)
      mask = DAY_MONTH_YEAR;
    else if (monthB && yearB)
      mask = MONTH_YEAR;
    else if (yearB)
      mask = YEAR_ONLY;
    else
      mask = NULL_DATE;

    return mask;
  }

/**
  * Is the set date valid? T/F.  For example, if only the day field is set,
  * then this is not a valid date.
  * @return boolean Valid? T/F
  */
  public boolean isValid() {
    boolean valid = false;

    if (yearB && !monthB && !dayB)
      valid = true;
    else if (yearB && monthB && !dayB)
      valid = true;
    else if (yearB && monthB && dayB)
      valid = true;
    else if (!yearB && !monthB && !dayB)
      valid = true;

    return valid;
  }

/**
  * Reset the date fields.
  */
  public void clear() {
    year = "0001";
    month = "01";
    day = "01";

    yearB = false;
    monthB = false;
    dayB = false;
  }
}
