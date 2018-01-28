/*
 * Generated file - Do not edit!
 */
package test.javabean;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.MethodDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * BeanInfo class for SimpleI18NBean.
 */
public class SimpleI18NBeanBeanInfo extends SimpleBeanInfo
{
   /** Description of the Field */
   protected BeanDescriptor bd = new BeanDescriptor(test.javabean.SimpleI18NBean.class);
   /** Description of the Field */
   protected Image iconMono16;
   /** Description of the Field */
   protected Image iconColor16 = loadImage("/toolbarButtonGraphics/general/Stop16.gif");
   /** Description of the Field */
   protected Image iconMono32;
   /** Description of the Field */
   protected Image iconColor32;
   /** Description of the Field */
   private final static ResourceBundle res = ResourceBundle.getBundle("test.javabean.SimpleI18NBeanBeanInfo");

   /** Constructor for the SimpleI18NBeanBeanInfo object */
   public SimpleI18NBeanBeanInfo() throws java.beans.IntrospectionException
   {
   	// setup bean descriptor in constructor. 
       bd.setName("SimpleI18NBean");

       bd.setDisplayName(res.getString("bean.displayName"));
       bd.setShortDescription(res.getString("bean.shortDescription"));

       bd.setValue("literal","A sample attribute");
       bd.setValue("expression",new StringBuffer());

       BeanInfo info = Introspector.getBeanInfo(getBeanDescriptor().getBeanClass().getSuperclass());
       String order = info.getBeanDescriptor().getValue("propertyorder") == null ? "" : (String) info.getBeanDescriptor().getValue("propertyorder");
       PropertyDescriptor[] pd = getPropertyDescriptors();
       for (int i = 0; i != pd.length; i++)
       {
          if (order.indexOf(pd[i].getName()) == -1)
          {
             order = order + (order.length() == 0 ? "" : ":") + pd[i].getName();
          }
       }
       getBeanDescriptor().setValue("propertyorder", order);
   }

   /**
    * Gets the additionalBeanInfo
    *
    * @return   The additionalBeanInfo value
    */
   public BeanInfo[] getAdditionalBeanInfo()
   {
      Vector bi = new Vector();
      BeanInfo[] biarr = null;
      try
      {
      }
      catch (Exception e)
      {
         // Ignore it
      }
      return biarr;
   }

   /**
    * Gets the beanDescriptor
    *
    * @return   The beanDescriptor value
    */
   public BeanDescriptor getBeanDescriptor()
   {
      return bd;
   }

   /**
    * Gets the defaultPropertyIndex
    *
    * @return   The defaultPropertyIndex value
    */
   public int getDefaultPropertyIndex()
   {
      String defName = "";
      if (defName.equals(""))
      {
         return -1;
      }
      PropertyDescriptor[] pd = getPropertyDescriptors();
      for (int i = 0; i < pd.length; i++)
      {
         if (pd[i].getName().equals(defName))
         {
            return i;
         }
      }
      return -1;
   }

   /**
    * Gets the icon
    *
    * @param type  Description of the Parameter
    * @return      The icon value
    */
   public Image getIcon(int type)
   {
      if (type == BeanInfo.ICON_COLOR_16x16)
      {
         return iconColor16;
      }
      if (type == BeanInfo.ICON_MONO_16x16)
      {
         return iconMono16;
      }
      if (type == BeanInfo.ICON_COLOR_32x32)
      {
         return iconColor32;
      }
      if (type == BeanInfo.ICON_MONO_32x32)
      {
         return iconMono32;
      }
      return null;
   }

   /**
    * Gets the Property Descriptors
    *
    * @return   The propertyDescriptors value
    */
   public PropertyDescriptor[] getPropertyDescriptors() 
   {
      try
      {
         Vector descriptors = new Vector();
         PropertyDescriptor descriptor = null;

         try
         {
            descriptor = new PropertyDescriptor("flag", test.javabean.SimpleBean.class);
         }
         catch (IntrospectionException e)
         {
            descriptor = new PropertyDescriptor("flag", test.javabean.SimpleBean.class, "isFlag", null);
         }

         descriptor.setDisplayName(res.getString("property.flag.displayName"));
         descriptor.setShortDescription(res.getString("property.flag.shortDescription"));

         descriptor.setHidden(false);

         descriptor.setBound(true);

         descriptors.add(descriptor);
         try
         {
            descriptor = new PropertyDescriptor("name", test.javabean.SimpleBean.class);
         }
         catch (IntrospectionException e)
         {
            descriptor = new PropertyDescriptor("name", test.javabean.SimpleBean.class, "getName", null);
         }

         descriptor.setDisplayName(res.getString("property.name.displayName"));
         descriptor.setShortDescription(res.getString("property.name.shortDescription"));

         descriptors.add(descriptor);
         try
         {
            descriptor = new PropertyDescriptor("count", test.javabean.SimpleBean.class, "getCount", null);
         }
         catch (IntrospectionException e)
         {
            descriptor = new PropertyDescriptor("count", test.javabean.SimpleBean.class, "getCount", null);
         }

         descriptor.setDisplayName(res.getString("property.count.displayName"));
         descriptor.setShortDescription(res.getString("property.count.shortDescription"));

         descriptors.add(descriptor);
         try
         {
            descriptor = new PropertyDescriptor("parent", test.javabean.SimpleBean.class);
         }
         catch (IntrospectionException e)
         {
            descriptor = new PropertyDescriptor("parent", test.javabean.SimpleBean.class, "getParent", null);
         }

         descriptor.setDisplayName(res.getString("property.parent.displayName"));
         descriptor.setShortDescription(res.getString("property.parent.shortDescription"));

         descriptors.add(descriptor);

         return (PropertyDescriptor[]) descriptors.toArray(new PropertyDescriptor[descriptors.size()]);
      }
      catch (Exception e)
      {
         // do not ignore, bomb politely so use has chance to discover what went wrong...
	 // I know that this is suboptimal solution, but swallowing silently is
	 // even worse... Propose better solution! 
	 e.printStackTrace();
      }
      return null;
   }

   /**
    * Gets the methodDescriptors attribute ...
    *
    * @return   The methodDescriptors value
    */
   public MethodDescriptor[] getMethodDescriptors() {
      Vector descriptors = new Vector();
      MethodDescriptor descriptor = null;
      Method[] m;
      Method method;

      try {
         m = Class.forName("test.javabean.SimpleI18NBean").getMethods();
      } catch (ClassNotFoundException e) {
         return new MethodDescriptor[0];
      }

      method = null;
      for (int j = 0; j != m.length; j++) {
         if (m[j].getName().equals("myFirstMethod")) {
            method = m[j];
            break;
         }
      }

      if (method != null) {
         ParameterDescriptor[] pd = new ParameterDescriptor[method.getParameterTypes().length];
         int pidx = 0;

         if (pidx == 0) {
            descriptor = new MethodDescriptor(method);
         } else {
            descriptor = new MethodDescriptor(method, pd);
         }
         descriptor.setName("myFirstMethod");
         descriptor.setDisplayName(res.getString("method.myFirstMethod.displayName"));
         descriptor.setDisplayName(res.getString("method.myFirstMethod.shortDescription"));

         descriptors.add(descriptor);
      }

      method = null;
      for (int j = 0; j != m.length; j++) {
         if (m[j].getName().equals("mySecondMethod")) {
            method = m[j];
            break;
         }
      }

      if (method != null) {
         ParameterDescriptor[] pd = new ParameterDescriptor[method.getParameterTypes().length];
         int pidx = 0;

         pd[pidx] = new ParameterDescriptor();
         pd[pidx].setName("param1");
         pd[pidx].setDisplayName(res.getString("method.mySecondMethod.param1.displayName"));

         pidx++;

         pd[pidx] = new ParameterDescriptor();
         pd[pidx].setName("param2");
         pd[pidx].setDisplayName(res.getString("method.mySecondMethod.param2.displayName"));

         pidx++;

         pd[pidx] = new ParameterDescriptor();
         pd[pidx].setName("param1");
         pd[pidx].setDisplayName(res.getString("method.mySecondMethod.param1.displayName"));

         pidx++;

         pd[pidx] = new ParameterDescriptor();
         pd[pidx].setName("param2");
         pd[pidx].setDisplayName(res.getString("method.mySecondMethod.param2.displayName"));

         pidx++;

         if (pidx == 0) {
            descriptor = new MethodDescriptor(method);
         } else {
            descriptor = new MethodDescriptor(method, pd);
         }
         descriptor.setName("mySecondMethod");
         descriptor.setDisplayName(res.getString("method.mySecondMethod.displayName"));
         descriptor.setDisplayName(res.getString("method.mySecondMethod.shortDescription"));

         descriptors.add(descriptor);
      }

      return (MethodDescriptor[]) descriptors.toArray(new MethodDescriptor[descriptors.size()]);
   }
}
