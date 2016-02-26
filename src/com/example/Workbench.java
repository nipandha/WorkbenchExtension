package com.example;

import com.example.gui.AddNarration;
import com.example.gui.CompileText;
import com.example.gui.ImageCheck;
import com.example.util.GETReq;
import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.beans.OfficeDocument;
import com.sun.star.frame.FrameSearchFlag;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XModel;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;
import javax.swing.JOptionPane;


public final class Workbench extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
              com.sun.star.frame.XDispatch,
              com.sun.star.lang.XInitialization,
              com.sun.star.frame.XDispatchProvider
{
    private final XComponentContext m_xContext;
    private com.sun.star.frame.XFrame m_xFrame;
    private static final String m_implementationName = Workbench.class.getName();
    private static final String[] m_serviceNames = {
        "com.sun.star.frame.ProtocolHandler" };
    private String path="/home/rgre/ekjwfwehfh.ppt";

    public Workbench( XComponentContext context )
    {
        m_xContext = context;
        //path=GETReq.get();
        if(path.equals(null))
        {
            
        }    
    };

    private String getDocument() {
  //if (this.officeDocument == null) {
    try {
        // this causes the error
        XMultiComponentFactory xMultiComponentFactory = this.m_xContext.getServiceManager();

        Object oDesktop = xMultiComponentFactory.createInstanceWithContext("com.sun.star.frame.Desktop", this.m_xContext);
        XDesktop xDesktop = (XDesktop) UnoRuntime.queryInterface(XDesktop.class, oDesktop);
        XComponent xComponent = xDesktop.getCurrentComponent();
        
        XComponentLoader xComponentLoader = UnoRuntime.queryInterface(XComponentLoader.class, oDesktop);

        String url = "private:factory/simpress";
        String targetFrameName = "_self";
        int searchFlags = FrameSearchFlag.SELF;
        PropertyValue[] propertyValues = new PropertyValue[1];
        propertyValues[0] = new PropertyValue();
        propertyValues[0].Name = "Hidden";
        propertyValues[0].Value = Boolean.TRUE;

        //XComponent xComponent = xComponentLoader.loadComponentFromURL(url, targetFrameName, searchFlags, propertyValues);

        XModel xModel = UnoRuntime.queryInterface(XModel.class, xComponent);
        
        return xModel.getURL();
    } catch (com.sun.star.uno.Exception ex) {
        //throw new RuntimeException(ex);
        ex.printStackTrace();
    }
  //}
  //return this.officeDocument;
  return null;
}
    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(Workbench.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }

    // com.sun.star.frame.XDispatch:
     public void dispatch( com.sun.star.util.URL aURL,
                           com.sun.star.beans.PropertyValue[] aArguments )
    {
         if ( aURL.Protocol.compareTo("com.example.workbench:") == 0 )
        {
            if ( aURL.Path.compareTo("Compile-Text") == 0 )
            {
                // add your own code here
                //CompileText.main(new String[]{path});
                String p=getDocument();
                JOptionPane.showMessageDialog(null, p, "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ( aURL.Path.compareTo("Check Image Quality") == 0 )
            {
                // add your own code here
                ImageCheck.main(new String[]{path});
                return;
            }
            if ( aURL.Path.compareTo("Add Narration") == 0 )
            {
                // add your own code here
                AddNarration.main(new String[]{path});
                return;
            }
        }
    }

    public void addStatusListener( com.sun.star.frame.XStatusListener xControl,
                                    com.sun.star.util.URL aURL )
    {
        // add your own code here
    }

    public void removeStatusListener( com.sun.star.frame.XStatusListener xControl,
                                       com.sun.star.util.URL aURL )
    {
        // add your own code here
    }

    // com.sun.star.lang.XInitialization:
    public void initialize( Object[] object )
        throws com.sun.star.uno.Exception
    {
        if ( object.length > 0 )
        {
            m_xFrame = (com.sun.star.frame.XFrame)UnoRuntime.queryInterface(
                com.sun.star.frame.XFrame.class, object[0]);
        }
    }

    // com.sun.star.frame.XDispatchProvider:
    public com.sun.star.frame.XDispatch queryDispatch( com.sun.star.util.URL aURL,
                                                       String sTargetFrameName,
                                                       int iSearchFlags )
    {
        if ( aURL.Protocol.compareTo("com.example.workbench:") == 0 )
        {
            if ( aURL.Path.compareTo("Compile-Text") == 0 )
                return this;
            if ( aURL.Path.compareTo("Check Image Quality") == 0 )
                return this;
            if ( aURL.Path.compareTo("Add Narration") == 0 )
                return this;
        }
        return null;
    }

    // com.sun.star.frame.XDispatchProvider:
    public com.sun.star.frame.XDispatch[] queryDispatches(
         com.sun.star.frame.DispatchDescriptor[] seqDescriptors )
    {
        int nCount = seqDescriptors.length;
        com.sun.star.frame.XDispatch[] seqDispatcher =
            new com.sun.star.frame.XDispatch[seqDescriptors.length];

        for( int i=0; i < nCount; ++i )
        {
            seqDispatcher[i] = queryDispatch(seqDescriptors[i].FeatureURL,
                                             seqDescriptors[i].FrameName,
                                             seqDescriptors[i].SearchFlags );
        }
        return seqDispatcher;
    }

}
