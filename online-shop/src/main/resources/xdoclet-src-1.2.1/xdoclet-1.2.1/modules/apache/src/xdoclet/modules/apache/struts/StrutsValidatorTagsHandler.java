/*
 * Copyright (c) 2001, 2002 The XDoclet team
 * All rights reserved.
 */
package xdoclet.modules.apache.struts;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.SequencedHashMap;

import xjavadoc.ClassIterator;
import xjavadoc.XClass;
import xjavadoc.XCollections;
import xjavadoc.XMethod;
import xjavadoc.XParameter;
import xjavadoc.XTag;

import xdoclet.DocletSupport;
import xdoclet.XDocletException;
import xdoclet.tagshandler.AbstractProgramElementTagsHandler;
import xdoclet.tagshandler.MethodTagsHandler;
import xdoclet.tagshandler.TypeTagsHandler;

/**
 * Struts Validator tag handler tags
 *
 * @author               Erik Hatcher (ehatcher@apache.org)
 * @created              August 23, 2002
 * @xdoclet.taghandler   namespace="Validator"
 * @version              $Revision: 1.8 $
 */
public class StrutsValidatorTagsHandler extends AbstractProgramElementTagsHandler
{
    private final static List supportedTypes = new ArrayList();
    private String  curFieldName;
    private String  currentArgKey;
    private Map     args;

    static {
        supportedTypes.add("java.lang.String");
        supportedTypes.add("java.lang.Integer");
        supportedTypes.add("int");
        supportedTypes.add("java.lang.Float");
        supportedTypes.add("float");
        supportedTypes.add("java.lang.Long");
        supportedTypes.add("long");
        supportedTypes.add("java.lang.Double");
        supportedTypes.add("double");
        supportedTypes.add("java.lang.Boolean");
        supportedTypes.add("boolean");
    }

    /**
     * Iterates over all Struts Form beans and evaluates the body of the tag for each class.
     *
     * @param template              The body of the block tag
     * @param attributes            The attributes of the template tag
     * @exception XDocletException
     * @doc.tag                     type="block"
     */
    public void forAllForms(String template, Properties attributes) throws XDocletException
    {
        Collection classes = getAllClasses();

        for (ClassIterator i = XCollections.classIterator(classes); i.hasNext(); ) {
            XClass currentClass = i.next();

            setCurrentClass(currentClass);
            if (DocletSupport.isDocletGenerated(getCurrentClass()) || (getCurrentClass().isAbstract())) {
                continue;
            }
            if (TypeTagsHandler.isOfType(currentClass, "org.apache.struts.validator.ValidatorForm", TypeTagsHandler.TYPE_HIERARCHY)) {
                generate(template);
            }
        }
    }

    /**
     * Gets the "name" attribute for the &lt;form> element in the xml descriptor. This should be the "path" form
     * attribute if this is a ValidatorActiorForm or the "name" attribute otherwise.
     *
     * @param attributes         The content tag attributes.
     * @return
     * @throws XDocletException  if anything goes awry.
     * @doc.tag                  type="content"
     */
    public String formName(Properties attributes) throws XDocletException
    {
        if (getCurrentClass().isA("org.apache.struts.validator.ValidatorActionForm"))
            return getTagValue(FOR_CLASS, "struts.form", "path", null, null, false, true);
        else
            return getTagValue(FOR_CLASS, "struts.form", "name", null, null, false, true);
    }

    /**
     * Iterates over all arguments for the current field.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void forAllFieldArgs(String template, Properties attributes) throws XDocletException
    {
        for (Iterator iterator = args.keySet().iterator(); iterator.hasNext(); ) {
            currentArgKey = (String) iterator.next();
            generate(template);
        }
    }

    /**
     * Current argument index number (0 to 3).
     *
     * @param props
     * @return
     * @doc.tag      type="content"
     */
    public String argIndex(Properties props)
    {
        return currentArgKey.charAt(3) + "";
    }

    /**
     * Current argument name - only valid if argument is for a specific validator type.
     *
     * @param props
     * @return
     * @doc.tag      type="content"
     */
    public String argName(Properties props)
    {
        String name = currentArgKey.substring(currentArgKey.indexOf('_') + 1);

        return name;
    }

    /**
     * Current argument value, which is either an inline value or resource key.
     *
     * @param props
     * @return
     * @doc.tag      type="content"
     */
    public String argValue(Properties props)
    {
        return (String) args.get(currentArgKey);
    }

    /**
     * Evaluates body if current argument is a resource key.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void ifArgIsResource(String template, Properties attributes) throws XDocletException
    {
        if (currentArgKey.indexOf("resource") > 0) {
            generate(template);
        }
    }

    /**
     * Evaluates the body if the current argument is an inline value rather than a resource key.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void ifArgIsValue(String template, Properties attributes) throws XDocletException
    {
        if (currentArgKey.indexOf("value") > 0) {
            generate(template);
        }
    }

    /**
     * Evaluates the body if the current argument is a validator-specific argument.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void ifArgIsForType(String template, Properties attributes) throws XDocletException
    {
        if (currentArgKey.indexOf('_') > 0) {
            generate(template);
        }
    }

    /**
     * Evaluates the body if there is no arg0 specified.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void ifNoArg0(String template, Properties attributes) throws XDocletException
    {
        if (args.get("arg0resource") == null && args.get("arg0value") == null) {
            generate(template);
        }
    }

    /**
     * Evaluates the body if form has fields requiring validation.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void ifFormHasFields(String template, Properties attributes) throws XDocletException
    {
        if (getFields(getCurrentClass()).size() > 0) {
            generate(template);
        }
    }

    /**
     * Iterates the body for each field of the current form requiring validation.
     *
     * @param template
     * @param attributes
     * @throws XDocletException
     * @doc.tag                  type="block"
     */
    public void forAllFields(String template, Properties attributes) throws XDocletException
    {
        XClass clazz = getCurrentClass();
        Map setters = getFields(clazz);

        for (Iterator iterator = setters.keySet().iterator(); iterator.hasNext(); ) {
            curFieldName = (String) iterator.next();

            XMethod field = (XMethod) setters.get(curFieldName);

            setCurrentMethod(field);
            loadFieldArguments();
            generate(template);
        }
    }

    /**
     * Returns the current fields name.
     *
     * @param props
     * @return
     * @doc.tag      type="content"
     */
    public String fieldName(Properties props)
    {
        return curFieldName;
    }

    /**
     * Returns a comma-separated list of the specified validator types.
     *
     * @param props
     * @return
     * @doc.tag      type="content"
     */
    public String validatorList(Properties props)
    {
        XMethod method = getCurrentMethod();
        Collection tags = method.getDoc().getTags("struts.validator");
        StringBuffer buffer = new StringBuffer();

        for (Iterator iterator = tags.iterator(); iterator.hasNext(); ) {
            XTag tag = (XTag) iterator.next();

            buffer.append(tag.getAttributeValue("type"));
            if (iterator.hasNext()) {
                buffer.append(",");
            }
        }
        return buffer.toString();
    }

    private Map getFields(XClass clazz) throws XDocletException
    {
        return getFields(clazz, "");
    }

    private Map getFields(XClass clazz, String prefix) throws XDocletException
    {
        Map fields = new SequencedHashMap();

        Collection curFields = clazz.getMethods(true);

        // TODO: nested forms currently won't work unless
        // there is a setter for it, but that is not needed
        // as only the sub-forms must have setters.  The top-level
        // only requires a getter.
        for (Iterator iterator = curFields.iterator(); iterator.hasNext(); ) {
            XMethod setter = (XMethod) iterator.next();

            if (MethodTagsHandler.isSetterMethod(setter)) {
                if (setter.getDoc().getTag("struts.validator") != null) {
                    String name = MethodTagsHandler.getPropertyNameFor(setter);
                    XParameter param = (XParameter) setter.getParameters().iterator().next();
                    String type = param.getType().getQualifiedName();

                    if (supportedTypes.contains(type)) {
                        fields.put(prefix + name, setter);
                    }
                    else {
                        fields.putAll(getFields(param.getType(), prefix + (prefix.length() == 0 ? "" : ".") + name + "."));
                    }
                }
            }
        }

        return fields;
    }

    private void loadFieldArguments()
    {
        /*
         * A bit of explanation is due here.  Rather than come up with
         * some fancy data structure to keep validator arguments stored into,
         * I simply store them into a Map with the value being the value
         * from the parameter.  The name, however, represents the argument
         * index, whether its a resource or an inline value, and whether it
         * is attached to a particular validator type.  The name format is:
         * argN[resource|value][_TYPE]
         * the argN[resource|value] piece is the actual parameter name.
         * N is the argument index.
         * TYPE is added only if the parameter appears on struts.validator tag
         * which indicates its only associated with a specific validator type.
         */
        args = new SequencedHashMap();

        XMethod method = getCurrentMethod();

        // Collect all general args
        Collection argTags = method.getDoc().getTags("struts.validator-args");

        for (Iterator argsIterator = argTags.iterator(); argsIterator.hasNext(); ) {
            XTag tag = (XTag) argsIterator.next();
            Collection attributeNames = tag.getAttributeNames();

            for (Iterator attributesIterator = attributeNames.iterator(); attributesIterator.hasNext(); ) {
                String name = (String) attributesIterator.next();

                if (name.startsWith("arg")) {
                    args.put(name, tag.getAttributeValue(name));
                }
            }
        }

        // Collect all type-specific args
        Collection argTypeTags = method.getDoc().getTags("struts.validator");

        for (Iterator typeTagsIterator = argTypeTags.iterator(); typeTagsIterator.hasNext(); ) {
            XTag tag = (XTag) typeTagsIterator.next();
            Collection attributeNames = tag.getAttributeNames();
            String type = tag.getAttributeValue("type");

            for (Iterator attributesIterator = attributeNames.iterator(); attributesIterator.hasNext(); ) {
                String name = (String) attributesIterator.next();

                if (name.startsWith("arg")) {
                    args.put(name + "_" + type, tag.getAttributeValue(name));
                }
            }
        }
    }
}
