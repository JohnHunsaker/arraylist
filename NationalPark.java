
import java.util.Date;
import java.text.DecimalFormat;

/**
 * Class to represent a National Park.
 */
public class NationalPark {

   private String mName;
   private double mArea;
   private int mVisitors;
   private Date mCreationDate;
   private String mLocation;
   private float mLatitude;
   private float mLongitude;

   public NationalPark(String name, double area, int visitors,
    Date creationDate, String location, float latitude, float longitude) {
      mName = name;
      mArea = area;
      mVisitors = visitors;
      mCreationDate = creationDate;
      mLocation = location;
      mLatitude = latitude;
      mLongitude = longitude;
   }

   public String getName() {
      return mName;
   }

   public void setName(String name) {
      mName = name;
   }

   public double getArea() {
      return mArea;
   }

   public void setArea(double area) {
      mArea = area;
   }

   public int getVisitors() {
      return mVisitors;
   }

   public void setVisitors(int visitors) {
      mVisitors = visitors;
   }

   public Date getCreationDate() {
      return mCreationDate;
   }

   public void setCreationDate(Date creationDate) {
      mCreationDate = creationDate;
   }

   public String getLocation() {
      return mLocation;
   }

   public void setLocation(String location) {
      mLocation = location;
   }

   public float getLatitude() {
      return mLatitude;
   }

   public void setLatitude(float latitude) {
      mLatitude = latitude;
   }

   public float getLongitude() {
      return mLongitude;
   }

   public void setLongitude(float longitude) {
      mLongitude = longitude;
   }
	
	/**
	 * Method to return a string representing a NationalPark.
	 * @return 
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###,##0.0");
 
		String str = "" + mName + ", " + mLocation + ". " + df.format(mArea) +
		 " square km. " + mVisitors + " annual visitors. ";
		return str;
	}
}
