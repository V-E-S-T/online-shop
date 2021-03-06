/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Remote interface for Customer.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public interface Customer
   extends test.interfaces.Person
{
   /**
    * Overriden from Person.
    */
   public void talkTo(  )
      throws java.rmi.RemoteException;

   /**
    * Overloaded works too.
    */
   public void talkTo( java.lang.String somebody )
      throws java.rmi.RemoteException;

   /**
    * Accounts of this customer
    */
   public java.util.Collection getAccounts(  )
      throws java.rmi.RemoteException;

   /**
    * Just to show that generated methods can be exported to remote/local interafce
    */
   public void addAccount( test.interfaces.AccountValue added )
      throws javax.ejb.FinderException, java.rmi.RemoteException;

   public void setCustomerNormalValue( test.interfaces.CustomerNormalValue value )
      throws test.interfaces.ApplicationException, java.rmi.RemoteException;

   public test.interfaces.CustomerNormalValue getCustomerNormalValue(  )
      throws java.rmi.RemoteException;

   /**
    * Generated bulk accessor. This is set as remote to allow clients to get all data in one call.
    */
   public test.interfaces.CustomerData getData(  )
      throws java.rmi.RemoteException;

   /**
    * Accounts of this customer
    */
   public java.util.Collection getShippingAddresses(  )
      throws java.rmi.RemoteException;

   public void setId( java.lang.String id )
      throws java.rmi.RemoteException;

   /**
    * Name of the person.
    */
   public java.lang.String getName(  )
      throws java.rmi.RemoteException;

   /**
    * FirstName of the person.
    */
   public java.lang.String getFirstName(  )
      throws java.rmi.RemoteException;

   public void setFirstName( java.lang.String firstName )
      throws java.rmi.RemoteException;

   /**
    * phone of the person.
    */
   public java.lang.String getPhone(  )
      throws java.rmi.RemoteException;

   public void setPhone( java.lang.String phone )
      throws java.rmi.RemoteException;

   /**
    * fax of the person.
    */
   public java.lang.String getFax(  )
      throws java.rmi.RemoteException;

   public void setFax( java.lang.String fax )
      throws java.rmi.RemoteException;

   /**
    * The creation-date of the entity. This field is purely to track when this entity was created, and should be set in ejbCreate (<code>setCreationDate(new Date());</code>. It is not included in the value object. <p>We use the qualified name here because XDoclet doesn't copy imports from base classes into the generated interfaces.</p>
    */
   public java.util.Date getCreationDate(  )
      throws java.rmi.RemoteException;

   public void setCreationDate( java.util.Date creationDate )
      throws java.rmi.RemoteException;

}
