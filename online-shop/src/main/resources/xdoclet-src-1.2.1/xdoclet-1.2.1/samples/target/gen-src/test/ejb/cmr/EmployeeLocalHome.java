/*
 * Generated by XDoclet - Do not edit!
 */
package test.ejb.cmr;

/**
 * Local home interface for Employee.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public interface EmployeeLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/EmployeeLocal";
   public static final String JNDI_NAME="EmployeeLocal";

   public test.ejb.cmr.EmployeeLocal create(test.ejb.cmr.EmployeeValue ev)
      throws javax.ejb.CreateException;

   public test.ejb.cmr.EmployeeLocal findByPrimaryKey(java.lang.Integer pk)
      throws javax.ejb.FinderException;

}
