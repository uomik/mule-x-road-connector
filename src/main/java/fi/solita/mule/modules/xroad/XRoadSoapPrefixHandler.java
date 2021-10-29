package fi.solita.mule.modules.xroad;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class XRoadSoapPrefixHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        final Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        // Only process outbound messages
        if (outbound) {
            try {
                final SOAPMessage soapMessage = context.getMessage();
                final SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
                final SOAPHeader soapHeader = soapMessage.getSOAPHeader();
                final SOAPBody soapBody = soapMessage.getSOAPBody();

                // Add new prefix + namespace entry
                soapEnvelope.addNamespaceDeclaration("SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");

                // Set desired namespace prefix for the envelope, header and body
                soapEnvelope.setPrefix("SOAP-ENV");
                soapHeader.setPrefix("SOAP-ENV");
                soapBody.setPrefix("SOAP-ENV");

                // Remove prefix + namespace entries added by JAX-WS
                soapEnvelope.removeNamespaceDeclaration("soap");
                soapHeader.removeNamespaceDeclaration("soap");
                soapBody.removeNamespaceDeclaration("soap");

                soapMessage.saveChanges();
            }
            catch (SOAPException e) { }
        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) { }

}