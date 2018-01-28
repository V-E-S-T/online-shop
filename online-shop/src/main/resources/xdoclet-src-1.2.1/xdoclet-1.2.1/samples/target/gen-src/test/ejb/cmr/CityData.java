/*
 * Generated by XDoclet - Do not edit!
 */
package test.ejb.cmr;

/**
 * Data object for City.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public class CityData
   extends java.lang.Object
   implements java.io.Serializable
{
   private java.lang.Integer cityId;
   private java.lang.Integer countryIdFk;
   private java.lang.String name;

  /* begin value object */

  /* end value object */

   public CityData()
   {
   }

   public CityData( java.lang.Integer cityId,java.lang.Integer countryIdFk,java.lang.String name )
   {
      setCityId(cityId);
      setCountryIdFk(countryIdFk);
      setName(name);
   }

   public CityData( CityData otherData )
   {
      setCityId(otherData.getCityId());
      setCountryIdFk(otherData.getCountryIdFk());
      setName(otherData.getName());

   }

   public java.lang.Integer getPrimaryKey() {
     return  getCityId();
   }

   public java.lang.Integer getCityId()
   {
      return this.cityId;
   }
   public void setCityId( java.lang.Integer cityId )
   {
      this.cityId = cityId;
   }

   public java.lang.Integer getCountryIdFk()
   {
      return this.countryIdFk;
   }
   public void setCountryIdFk( java.lang.Integer countryIdFk )
   {
      this.countryIdFk = countryIdFk;
   }

   public java.lang.String getName()
   {
      return this.name;
   }
   public void setName( java.lang.String name )
   {
      this.name = name;
   }

   public String toString()
   {
      StringBuffer str = new StringBuffer("{");

      str.append("cityId=" + getCityId() + " " + "countryIdFk=" + getCountryIdFk() + " " + "name=" + getName());
      str.append('}');

      return(str.toString());
   }

   public boolean equals( Object pOther )
   {
      if( pOther instanceof CityData )
      {
         CityData lTest = (CityData) pOther;
         boolean lEquals = true;

         if( this.cityId == null )
         {
            lEquals = lEquals && ( lTest.cityId == null );
         }
         else
         {
            lEquals = lEquals && this.cityId.equals( lTest.cityId );
         }
         if( this.countryIdFk == null )
         {
            lEquals = lEquals && ( lTest.countryIdFk == null );
         }
         else
         {
            lEquals = lEquals && this.countryIdFk.equals( lTest.countryIdFk );
         }
         if( this.name == null )
         {
            lEquals = lEquals && ( lTest.name == null );
         }
         else
         {
            lEquals = lEquals && this.name.equals( lTest.name );
         }

         return lEquals;
      }
      else
      {
         return false;
      }
   }

   public int hashCode()
   {
      int result = 17;

      result = 37*result + ((this.cityId != null) ? this.cityId.hashCode() : 0);

      result = 37*result + ((this.countryIdFk != null) ? this.countryIdFk.hashCode() : 0);

      result = 37*result + ((this.name != null) ? this.name.hashCode() : 0);

      return result;
   }

}
