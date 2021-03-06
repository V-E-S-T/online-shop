/*
 * Copyright (c) 2001, 2002 The XDoclet team
 * All rights reserved.
 */
package xdoclet;

import java.util.Stack;

import xjavadoc.XClass;
import xjavadoc.XConstructor;
import xjavadoc.XField;
import xjavadoc.XMethod;
import xjavadoc.XPackage;
import xjavadoc.XTag;

/**
 * @author    Ara Abrahamian (ara_e@email.com)
 * @created   Oct 13, 2001
 * @version   $Revision: 1.16 $
 */
public abstract class DocletSupport
{
    /**
     * The current Tag. Various template tag implementations set this value, including looping tags such as
     * forAllClassTags. There's no distinction between class/method/field/constructor/whatever tags, and currentTag can
     * point to any one them.
     */
    protected static XTag currentMethodTag;

    protected static XTag currentClassTag;

    protected static XTag currentFieldTag;

    /**
     * The current class stack is used for pushing/poping classes to/from it, so that it's possible to work of the
     * current class while not losing the previous current class since template tags can be nested inside each other and
     * each may set a new class as the current class (by pushing the class to top of stack).
     *
     * @see   #setCurrentClass(xjavadoc.XClass)
     * @see   #getCurrentClass()
     * @see   #pushCurrentClass(xjavadoc.XClass)
     * @see   #popCurrentClass()
     */
    private transient Stack currentClassStack = null;

    /**
     * Reference to the current method. Unlike current class stack, there's no stack for methods, because rarely you
     * need to alter current method reference nestedly.
     *
     * @see   #getCurrentMethod()
     * @see   #setCurrentMethod(xjavadoc.XMethod)
     */
    private transient XMethod currentMethod = null;

    /**
     * Reference to the current constructor. Unlike current class stack, there's no stack for constructors, because
     * rarely you need to alter current constructor reference nestedly.
     *
     * @see   #getCurrentConstructor()
     * @see   #setCurrentConstructor(xjavadoc.XConstructor)
     */
    private transient XConstructor currentConstructor = null;

    /**
     * Reference to the current field. Unlike current class stack, there's no stack for fields, because rarely you need
     * to alter current field reference nestedly.
     *
     * @see   #getCurrentField()
     * @see   #setCurrentField(xjavadoc.XField)
     */
    private transient XField currentField = null;

    /**
     * Reference to the current package. Unlike current class stack, there's no stack for methods, because rarely you
     * need to alter current package reference nestedly.
     *
     * @see   #getCurrentPackage()
     * @see   #setCurrentPackage(xjavadoc.XPackage)
     */
    private transient XPackage currentPackage = null;

    public DocletSupport()
    {
        currentClassStack = new Stack();
    }

    /**
     * Gets the CurrentMethodTag attribute of the DocletSupport class
     *
     * @return   The CurrentMethodTag value
     */
    public static XTag getCurrentMethodTag()
    {
        return currentMethodTag;
    }

    /**
     * Gets the CurrentClassTag attribute of the DocletSupport class
     *
     * @return   The CurrentClassTag value
     */
    public static XTag getCurrentClassTag()
    {
        return currentClassTag;
    }

    /**
     * Gets the CurrentFieldTag attribute of the DocletSupport field
     *
     * @return   The CurrentFieldTag value
     */
    public static XTag getCurrentFieldTag()
    {
        return currentFieldTag;
    }

    /**
     * This method is for backward compatiblity only. Method or Class Tag getter should be used instead.
     *
     * @return   The CurrentTag value
     */
    public static XTag getCurrentTag()
    {
        if (currentMethodTag != null)
            return currentMethodTag;
        else
            return currentClassTag;
    }

    /**
     * Returns true if the clazz generated by xdoclet. An xdoclet generated class has a class-level xdoclet-generated
     * tag.
     *
     * @param clazz  Description of Parameter
     * @return       The DocletGenerated value
     */
    public static boolean isDocletGenerated(XClass clazz)
    {
        return clazz.getDoc().hasTag("xdoclet-generated", false);
    }

    /**
     * Sets the CurrentMethodTag attribute of the DocletSupport class
     *
     * @param currentTag  The new CurrentMethodTag value
     * @ant.ignore
     */
    public static void setCurrentMethodTag(XTag currentTag)
    {
        DocletSupport.currentMethodTag = currentTag;
    }

    /**
     * Sets the CurrentClassTag attribute of the DocletSupport class
     *
     * @param currentTag  The new CurrentClassTag value
     * @ant.ignore
     */
    public static void setCurrentClassTag(XTag currentTag)
    {
        DocletSupport.currentClassTag = currentTag;
    }

    /**
     * Sets the CurrentFieldTag attribute of the DocletSupport field
     *
     * @param currentTag  The new CurrentFieldTag value
     * @ant.ignore
     */
    public static void setCurrentFieldTag(XTag currentTag)
    {
        DocletSupport.currentFieldTag = currentTag;
    }

    /**
     * Peeks and return the current class from top of currentClassStack stack.
     *
     * @return   The CurrentClass value
     * @see      #setCurrentClass(xjavadoc.XClass)
     */
    public XClass getCurrentClass()
    {
        return currentClassStack.empty() ? null : (XClass) currentClassStack.peek();
    }

    /**
     * Returns current package.
     *
     * @return   The CurrentPackage value
     * @see      #setCurrentPackage(xjavadoc.XPackage)
     */
    public XPackage getCurrentPackage()
    {
        return currentPackage;
    }

    /**
     * Returns current method.
     *
     * @return   The CurrentMethod value
     * @see      #setCurrentMethod(xjavadoc.XMethod)
     */
    public XMethod getCurrentMethod()
    {
        return currentMethod;
    }

    /**
     * Returns current constructor.
     *
     * @return   The CurrentConstructor value
     * @see      #setCurrentConstructor(xjavadoc.XConstructor)
     */
    public XConstructor getCurrentConstructor()
    {
        return currentConstructor;
    }

    /**
     * Returns current field.
     *
     * @return   The CurrentField value
     * @see      #setCurrentField(xjavadoc.XField)
     */
    public XField getCurrentField()
    {
        return currentField;
    }

    /**
     * Returns current package.
     *
     * @param pakkage  The new CurrentPackage value
     * @see            #setCurrentPackage(xjavadoc.XPackage)
     * @ant.ignore
     */
    public void setCurrentPackage(XPackage pakkage)
    {
        currentPackage = pakkage;

        // since we're now working on a new package, clear the class stack
        currentClassStack.clear();
    }

    /**
     * Sets the CurrentMethod attribute of the DocletSupport object
     *
     * @param method  The new CurrentMethod value
     * @ant.ignore
     */
    public void setCurrentMethod(XMethod method)
    {
        currentMethod = method;
    }

    /**
     * Sets the CurrentConstructor attribute of the DocletSupport object
     *
     * @param constructor  The new CurrentConstructor value
     * @ant.ignore
     */
    public void setCurrentConstructor(XConstructor constructor)
    {
        currentConstructor = constructor;
    }

    /**
     * Sets the CurrentField attribute of the DocletSupport object
     *
     * @param field  The new CurrentField value
     * @ant.ignore
     */
    public void setCurrentField(XField field)
    {
        currentField = field;
    }

    /**
     * Sets current class to clazz by clearing currentClassStack stack and pushing clazz into top of it.
     *
     * @param clazz  The new CurrentClass value
     * @see          #getCurrentClass()
     * @ant.ignore
     */
    public void setCurrentClass(XClass clazz)
    {
        currentClassStack.clear();
        currentClassStack.push(clazz);
    }

    /**
     * Pushes class clazz to top of currentClassStack stack, making it effectively the current class.
     *
     * @param clazz  Description of Parameter
     * @return       Description of the Returned Value
     * @see          #getCurrentClass()
     * @see          #setCurrentClass(xjavadoc.XClass)
     * @see          #popCurrentClass()
     */
    public XClass pushCurrentClass(XClass clazz)
    {
        return (XClass) currentClassStack.push(clazz);
    }

    /**
     * Popes current class from top currentClassStack stack. The poped class is no longer the current class.
     *
     * @return   Description of the Returned Value
     * @see      #getCurrentClass()
     * @see      #setCurrentClass(xjavadoc.XClass)
     * @see      #pushCurrentClass(xjavadoc.XClass)
     */
    public XClass popCurrentClass()
    {
        return (XClass) currentClassStack.pop();
    }
}
