package domaine;

import java.util.Date;
import java.util.Objects;

public class Headline implements Comparable{

  private Date date;
  private String type;
  private String headline;

  public Headline(Date date, String type, String headline) {
    this.date = date;
    this.type = type;
    this.headline = headline;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  @Override
  public boolean equals(Object o) {
    Headline headline = (Headline) o;
    return Objects.equals(date, headline.date) &&
            Objects.equals(headline, headline.headline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, headline);
  }

  @Override
  public int compareTo(Object o) {
    Headline headline = (Headline)o;
    int result = this.headline.compareTo(headline.headline);
    if (result != 0) {
     return  result;
    }
    return this.date.compareTo(headline.date);
  }

  @Override
  public String toString() {
    return "Headline=" + headline + "\n" ;
  }
}
