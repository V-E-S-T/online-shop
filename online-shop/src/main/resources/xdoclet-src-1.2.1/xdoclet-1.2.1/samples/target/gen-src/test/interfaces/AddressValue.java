/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Value object for Address.
 *
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public class AddressValue
   extends java.lang.Object
   implements java.io.Serializable 
{
   private java.lang.String id;
   private boolean idHasBeenSet = false;
   private java.lang.String street;
   private boolean streetHasBeenSet = false;
   private java.lang.String city;
   private boolean cityHasBeenSet = false;

   private java.lang.String pk;

   public AddressValue()
   {
   }

   public AddressValue( java.lang.String id,java.lang.String street,java.lang.String city )
   {
	  this.id = id;
	  idHasBeenSet = true;
	  this.street = street;
	  streetHasBeenSet = true;
	  this.city = city;
	  cityHasBeenSet = true;
	  pk = this.getId();
   }

   //TODO Cloneable is better than this !
   public AddressValue( AddressValue otherValue )
   {
	  this.id = otherValue.id;
	  idHasBeenSet = true;
	  this.street = otherValue.street;
	  streetHasBeenSet = true;
	  this.city = otherValue.city;
	  cityHasBeenSet = true;

	  pk = this.getId();
   }

   public java.lang.String getPrimaryKey()
   {
	  return pk;
   }

   public void setPrimaryKey( java.lang.String pk )
   {
      // it's also nice to update PK object - just in case
      // somebody would ask for it later...
      this.pk = pk;
	  setId( pk );
   }

   public java.lang.String getId()
   {
	  return this.id;
   }

   public void setId( java.lang.String id )
   {
	  this.id = id;
	  idHasBeenSet = true;

		  pk = id;
   }

   public boolean idHasBeenSet(){
	  return idHasBeenSet;
   }
   public java.lang.String getStreet()
   {
	  return this.street;
   }

   public java.lang.String getCity()
   {
	  return this.city;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("id=" + getId() + " " + "street=" + getStreet() + " " + "city=" + getCity());
	  str.append('}');

	  return(str.toString());
   }

   /**
    * A Value Object has an identity if the attributes making its Primary Key have all been set. An object without identity is never equal to any other object.
    *
    * @return true if this instance has an identity.
    */
   protected boolean hasIdentity()
   {
	  return idHasBeenSet;
   }

   public boolean equals(Object other)
   {
      if (this == other)
         return true;
	  if ( ! hasIdentity() ) return false;
	  if (other instanceof AddressValue)
	  {
		 AddressValue that = (AddressValue) other;
		 if ( ! that.hasIdentity() ) return false;
		 boolean lEquals = true;
		 if( this.id == null )
		 {
			lEquals = lEquals && ( that.id == null );
		 }
		 else
		 {
			lEquals = lEquals && this.id.equals( that.id );
		 }

		 lEquals = lEquals && isIdentical(that);

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public boolean isIdentical(Object other)
   {
	  if (other instanceof AddressValue)
	  {
		 AddressValue that = (AddressValue) other;
		 boolean lEquals = true;
		 if( this.street == null )
		 {
			lEquals = lEquals && ( that.street == null );
		 }
		 else
		 {
			lEquals = lEquals && this.street.equals( that.street );
		 }
		 if( this.city == null )
		 {
			lEquals = lEquals && ( that.city == null );
		 }
		 else
		 {
			lEquals = lEquals && this.city.equals( that.city );
		 }

		 return lEquals;
	  }
	  else
	  {
		 return false;
	  }
   }

   public int hashCode(){
	  int result = 17;
      result = 37*result + ((this.id != null) ? this.id.hashCode() : 0);

      result = 37*result + ((this.street != null) ? this.street.hashCode() : 0);

      result = 37*result + ((this.city != null) ? this.city.hashCode() : 0);

	  return result;
   }

}
