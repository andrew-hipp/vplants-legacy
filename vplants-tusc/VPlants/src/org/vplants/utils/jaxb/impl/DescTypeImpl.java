//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.4-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2005.08.10 at 02:44:28 CDT 
//


package org.vplants.utils.jaxb.impl;

public class DescTypeImpl implements org.vplants.utils.jaxb.DescType, com.sun.xml.bind.JAXBObject, org.vplants.utils.jaxb.impl.runtime.UnmarshallableObject, org.vplants.utils.jaxb.impl.runtime.XMLSerializable, org.vplants.utils.jaxb.impl.runtime.ValidatableObject
{

    protected java.lang.String _Size;
    protected org.vplants.utils.jaxb.PartsType _Parts;
    protected java.lang.String _GrowthForm;
    public final static java.lang.Class version = (org.vplants.utils.jaxb.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (org.vplants.utils.jaxb.DescType.class);
    }

    public java.lang.String getSize() {
        return _Size;
    }

    public void setSize(java.lang.String value) {
        _Size = value;
    }

    public org.vplants.utils.jaxb.PartsType getParts() {
        return _Parts;
    }

    public void setParts(org.vplants.utils.jaxb.PartsType value) {
        _Parts = value;
    }

    public java.lang.String getGrowthForm() {
        return _GrowthForm;
    }

    public void setGrowthForm(java.lang.String value) {
        _GrowthForm = value;
    }

    public org.vplants.utils.jaxb.impl.runtime.UnmarshallingEventHandler createUnmarshaller(org.vplants.utils.jaxb.impl.runtime.UnmarshallingContext context) {
        return new org.vplants.utils.jaxb.impl.DescTypeImpl.Unmarshaller(context);
    }

    public void serializeBody(org.vplants.utils.jaxb.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        context.startElement("", "growthForm");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _GrowthForm), "GrowthForm");
        } catch (java.lang.Exception e) {
            org.vplants.utils.jaxb.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        context.startElement("", "size");
        context.endNamespaceDecls();
        context.endAttributes();
        try {
            context.text(((java.lang.String) _Size), "Size");
        } catch (java.lang.Exception e) {
            org.vplants.utils.jaxb.impl.runtime.Util.handlePrintConversionException(this, e, context);
        }
        context.endElement();
        if (_Parts instanceof javax.xml.bind.Element) {
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
        } else {
            context.startElement("", "parts");
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
            context.endNamespaceDecls();
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
            context.endAttributes();
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
            context.endElement();
        }
    }

    public void serializeAttributes(org.vplants.utils.jaxb.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_Parts instanceof javax.xml.bind.Element) {
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
        }
    }

    public void serializeURIs(org.vplants.utils.jaxb.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        if (_Parts instanceof javax.xml.bind.Element) {
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Parts), "Parts");
        }
    }

    public java.lang.Class getPrimaryInterface() {
        return (org.vplants.utils.jaxb.DescType.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\u001fcom.sun.msv.grammar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.su"
+"n.msv.grammar.BinaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1t\u0000 Lcom/sun/msv/gra"
+"mmar/Expression;L\u0000\u0004exp2q\u0000~\u0000\u0002xr\u0000\u001ecom.sun.msv.grammar.Expressi"
+"on\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Ljava/lang/Boolean;L\u0000\u000b"
+"expandedExpq\u0000~\u0000\u0002xpppsq\u0000~\u0000\u0000ppsr\u0000\'com.sun.msv.grammar.trex.Ele"
+"mentPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\tnameClasst\u0000\u001fLcom/sun/msv/grammar/Na"
+"meClass;xr\u0000\u001ecom.sun.msv.grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aigno"
+"reUndeclaredAttributesL\u0000\fcontentModelq\u0000~\u0000\u0002xq\u0000~\u0000\u0003pp\u0000sq\u0000~\u0000\u0000pps"
+"r\u0000\u001bcom.sun.msv.grammar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxn"
+"g/datatype/Datatype;L\u0000\u0006exceptq\u0000~\u0000\u0002L\u0000\u0004namet\u0000\u001dLcom/sun/msv/uti"
+"l/StringPair;xq\u0000~\u0000\u0003ppsr\u0000#com.sun.msv.datatype.xsd.StringType"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlwaysValidxr\u0000*com.sun.msv.datatype.xsd.Buil"
+"tinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.Concret"
+"eType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamespaceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~"
+"\u0000\u0014L\u0000\nwhiteSpacet\u0000.Lcom/sun/msv/datatype/xsd/WhiteSpaceProces"
+"sor;xpt\u0000 http://www.w3.org/2001/XMLSchemat\u0000\u0006stringsr\u00005com.su"
+"n.msv.datatype.xsd.WhiteSpaceProcessor$Preserve\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr"
+"\u0000,com.sun.msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001"
+"sr\u00000com.sun.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0000xq\u0000~\u0000\u0003ppsr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tloca"
+"lNameq\u0000~\u0000\u0014L\u0000\fnamespaceURIq\u0000~\u0000\u0014xpq\u0000~\u0000\u0018q\u0000~\u0000\u0017sr\u0000\u001dcom.sun.msv.gr"
+"ammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0001ppsr\u0000 com.sun.msv.grammar.At"
+"tributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0002L\u0000\tnameClassq\u0000~\u0000\bxq\u0000~\u0000\u0003sr\u0000\u0011j"
+"ava.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psq\u0000~\u0000\fppsr\u0000\"com.sun.m"
+"sv.datatype.xsd.QnameType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0011q\u0000~\u0000\u0017t\u0000\u0005QNamesr\u00005c"
+"om.sun.msv.datatype.xsd.WhiteSpaceProcessor$Collapse\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001"
+"\u0002\u0000\u0000xq\u0000~\u0000\u001aq\u0000~\u0000\u001dsq\u0000~\u0000\u001eq\u0000~\u0000)q\u0000~\u0000\u0017sr\u0000#com.sun.msv.grammar.Simple"
+"NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0014L\u0000\fnamespaceURIq\u0000~\u0000\u0014xr\u0000"
+"\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\u0004typet\u0000)http://"
+"www.w3.org/2001/XMLSchema-instancesr\u00000com.sun.msv.grammar.Ex"
+"pression$EpsilonExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003sq\u0000~\u0000$\u0001q\u0000~\u00003sq\u0000~\u0000"
+"-t\u0000\ngrowthFormt\u0000\u0000sq\u0000~\u0000\u0007pp\u0000sq\u0000~\u0000\u0000ppq\u0000~\u0000\u000fsq\u0000~\u0000 ppsq\u0000~\u0000\"q\u0000~\u0000%pq"
+"\u0000~\u0000&q\u0000~\u0000/q\u0000~\u00003sq\u0000~\u0000-t\u0000\u0004sizeq\u0000~\u00007sq\u0000~\u0000 ppsq\u0000~\u0000\u0007pp\u0000sq\u0000~\u0000 ppsr\u0000"
+" com.sun.msv.grammar.OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv."
+"grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0002xq\u0000~\u0000\u0003q\u0000~\u0000%psq\u0000~\u0000\"q\u0000~\u0000"
+"%psr\u00002com.sun.msv.grammar.Expression$AnyStringExpression\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0003q\u0000~\u00004q\u0000~\u0000Fsr\u0000 com.sun.msv.grammar.AnyNameClass\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000.q\u0000~\u00003sq\u0000~\u0000-t\u0000\u001corg.vplants.utils.jaxb.Partst\u0000"
+"+http://java.sun.com/jaxb/xjc/dummy-elementssq\u0000~\u0000\u0007pp\u0000sq\u0000~\u0000\u0000p"
+"psq\u0000~\u0000\u0007pp\u0000sq\u0000~\u0000 ppsq\u0000~\u0000Aq\u0000~\u0000%psq\u0000~\u0000\"q\u0000~\u0000%pq\u0000~\u0000Fq\u0000~\u0000Hq\u0000~\u00003sq\u0000"
+"~\u0000-t\u0000 org.vplants.utils.jaxb.PartsTypeq\u0000~\u0000Ksq\u0000~\u0000 ppsq\u0000~\u0000\"q\u0000~"
+"\u0000%pq\u0000~\u0000&q\u0000~\u0000/q\u0000~\u00003sq\u0000~\u0000-t\u0000\u0005partsq\u0000~\u00007sr\u0000\"com.sun.msv.grammar"
+".ExpressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar"
+"/ExpressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.Express"
+"ionPool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006pare"
+"ntt\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\r\u0001pq\u0000~\u0000Cq\u0000~\u0000Pq"
+"\u0000~\u0000\u0006q\u0000~\u0000>q\u0000~\u0000Mq\u0000~\u0000\u0005q\u0000~\u0000!q\u0000~\u0000:q\u0000~\u0000Tq\u0000~\u0000\u000bq\u0000~\u00009q\u0000~\u0000@q\u0000~\u0000Ox"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends org.vplants.utils.jaxb.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(org.vplants.utils.jaxb.impl.runtime.UnmarshallingContext context) {
            super(context, "----------");
        }

        protected Unmarshaller(org.vplants.utils.jaxb.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return org.vplants.utils.jaxb.impl.DescTypeImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  3 :
                        if (("size" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 4;
                            return ;
                        }
                        break;
                    case  0 :
                        if (("growthForm" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, true);
                            state = 1;
                            return ;
                        }
                        break;
                    case  7 :
                        if (("part" == ___local)&&("" == ___uri)) {
                            _Parts = ((org.vplants.utils.jaxb.impl.PartsTypeImpl) spawnChildFromEnterElement((org.vplants.utils.jaxb.impl.PartsTypeImpl.class), 8, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("part" == ___local)&&("" == ___uri)) {
                            _Parts = ((org.vplants.utils.jaxb.impl.PartsTypeImpl) spawnChildFromEnterElement((org.vplants.utils.jaxb.impl.PartsTypeImpl.class), 8, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        break;
                    case  6 :
                        if (("parts" == ___local)&&("" == ___uri)) {
                            _Parts = ((org.vplants.utils.jaxb.impl.PartsImpl) spawnChildFromEnterElement((org.vplants.utils.jaxb.impl.PartsImpl.class), 9, ___uri, ___local, ___qname, __atts));
                            return ;
                        }
                        if (("parts" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 7;
                            return ;
                        }
                        break;
                    case  9 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  2 :
                        if (("growthForm" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 3;
                            return ;
                        }
                        break;
                    case  8 :
                        if (("parts" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 9;
                            return ;
                        }
                        break;
                    case  5 :
                        if (("size" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  9 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  9 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  4 :
                            eatText1(value);
                            state = 5;
                            return ;
                        case  9 :
                            revertToParentFromText(value);
                            return ;
                        case  1 :
                            eatText2(value);
                            state = 2;
                            return ;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _Size = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        private void eatText2(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _GrowthForm = value;
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

    }

}