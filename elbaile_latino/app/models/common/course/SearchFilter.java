package models.common.course;

public class SearchFilter {

	public String dateFrom;
	public String dateTo;
	public String danceStyle;
	public String language;

	public String getFilterString()
	{
		String str = "";
		if(dateFrom.length() > 0)
			str += "From: " + dateFrom + ", ";

		if(dateTo.length() > 0)
			str += "To: " + dateFrom + ", ";

		if(danceStyle.length() > 0)
			str += "Style: " + danceStyle + ", ";

		if(language.length() > 0)
			str += "Language: " + language;

		return str;
	}
}
