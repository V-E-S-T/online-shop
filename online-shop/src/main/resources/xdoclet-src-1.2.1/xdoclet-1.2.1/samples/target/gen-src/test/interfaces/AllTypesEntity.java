/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Remote interface for AllTypesEntity.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public interface AllTypesEntity
   extends javax.ejb.EJBObject
{

   public int[] getIVOwnerHdl(  )
      throws java.rmi.RemoteException;

   public java.lang.String getId(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aBoolean.
    */
   public boolean getABoolean(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aBoolean.
    */
   public void setABoolean( boolean aBoolean )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aByte.
    */
   public byte getAByte(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aByte.
    */
   public void setAByte( byte aByte )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aShort.
    */
   public short getAShort(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aShort.
    */
   public void setAShort( short aShort )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aChar.
    */
   public char getAChar(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aChar.
    */
   public void setAChar( char aChar )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field anInt.
    */
   public int getAnInt(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field anInt.
    */
   public void setAnInt( int anInt )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aLong.
    */
   public long getALong(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aLong.
    */
   public void setALong( long aLong )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aFloat.
    */
   public float getAFloat(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aFloat.
    */
   public void setAFloat( float aFloat )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aDouble.
    */
   public double getADouble(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aDouble.
    */
   public void setADouble( double aDouble )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field anObject. NOTE: most CMP engines will store the Object class as a serialized object in a BLOB data type.
    */
   public java.lang.Object getAnObject(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field anObject.
    */
   public void setAnObject( java.lang.Object anObject )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field anObjectArray.
    */
   public java.lang.Object[] getAnObjectArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field anObjectArray.
    */
   public void setAnObjectArray( java.lang.Object[] anObjectArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aBooleanArray.
    */
   public boolean[] getABooleanArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aBooleanArray.
    */
   public void setABooleanArray( boolean[] aBooleanArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aByteArray.
    */
   public byte[] getAByteArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aByteArray.
    */
   public void setAByteArray( byte[] aByteArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aCharArray.
    */
   public char[] getACharArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aCharArray.
    */
   public void setACharArray( char[] aCharArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aShortArray.
    */
   public short[] getAShortArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aShortArray.
    */
   public void setAShortArray( short[] aShortArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field anIntArray.
    */
   public int[] getAnIntArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field anIntArray.
    */
   public void setAnIntArray( int[] anIntArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aLongArray.
    */
   public long[] getALongArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aLongArray.
    */
   public void setALongArray( long[] aLongArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aFloatArray.
    */
   public float[] getAFloatArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aFloatArray.
    */
   public void setAFloatArray( float[] aFloatArray )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field getter for field aDoubleArray.
    */
   public double[] getADoubleArray(  )
      throws java.rmi.RemoteException;

   /**
    * Abstract CMP 2.0 field setter for field aDoubleArray.
    */
   public void setADoubleArray( double[] aDoubleArray )
      throws java.rmi.RemoteException;

   /**
    * The creation-date of the entity. This field is purely to track when this entity was created, and should be set in ejbCreate (<code>setCreationDate(new Date());</code>. It is not included in the value object. <p>We use the qualified name here because XDoclet doesn't copy imports from base classes into the generated interfaces.</p>
    */
   public java.util.Date getCreationDate(  )
      throws java.rmi.RemoteException;

   public void setCreationDate( java.util.Date creationDate )
      throws java.rmi.RemoteException;

}
