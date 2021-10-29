/**
 * MIT License Copyright (c) 2016 Solita Oy
 */
package fi.solita.mule.modules.xroad.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.xml.transformer.XmlPrettyPrinter;
import org.mule.tck.junit4.FunctionalTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XRoadFunctionalTest extends FunctionalTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(XRoadFunctionalTest.class);

    @Override
    protected String getConfigFile() {
        return "automation-test-flows.xml";
    }

    @Test
    public void sendHelloMessage() throws Exception {
        MuleEvent result = runFlow("send-HelloServiceMessage");
        String messageAsString = result.getMessageAsString();
        logProperties(result.getMessage());
        assertTrue(messageAsString.contains("Greetings from adapter server!"));
        assertEquals("automationTest", result.getMessage().getOutboundProperty("X-ROAD-userId"));        
    }

    @Test
    public void sendGetRandomMessage() throws Exception {
        MuleEvent result = runFlow("send-GetRandomMessage");
        String messageAsString = result.getMessageAsString();
        logProperties(result.getMessage());
        assertTrue(messageAsString.contains("data>"));
        assertTrue(result.getMessage().getOutboundProperty("X-Road-clientXroadInstance").toString().startsWith("FI-"));
    }

    private void logProperties(MuleMessage message) throws Exception {
        LOGGER.warn("Outbound properties: ");
    	for (String propName :  message.getOutboundPropertyNames()) {
            LOGGER.warn(propName + ": " + message.getOutboundProperty(propName));
    	}
        LOGGER.warn("Result:\n" + prettyXML(message.getPayloadAsString()));
    }

    private String prettyXML(String xmlString) {
        XmlPrettyPrinter transformer = new XmlPrettyPrinter();
        try {
            return (String) transformer.transform(xmlString, "UTF-8");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
