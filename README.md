# X-Road Anypoint Connector
MuleSoft Connector for consuming services from X-Road in Finland. See: https://esuomi.fi/suomi-fi-services/suomi-fi-data-exchange-layer/?lang=en

# Mule supported versions
Mule 3.5.x, 3.6.x, 3.7.x, 3.8.x, 3.9.x

# Security Server (Liityntäpalvelin) supported versions
Security Server >= 6.7.x
X-Road protocol: 4.0

# Installation
For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio

For released connectors you can download them from the update site in Anypoint Studio. 
Open Anypoint Studio, go to Help 'Install New Software' and select Anypoint Connectors Update Site where you'll find all available connectors.

## Installation in Mule CE projects
1. Build the connector: `mvn clean package`
2. Harvest created `x-road-connector-1.0.0.jar` and `pom.xml`, rename POM to `x-road-connector-1.0.0.pom`
3. Add JAR and POM to project in `src/lib/fi/solita/mule/modules/x-road-connector/1.0.0/`
4. Add `src/lib` as repository to project POM
4. Add dependency to project:
```xml
<dependency>
    <groupId>fi.solita.mule.modules</groupId>
    <artifactId>x-road-connector</artifactId>
    <version>1.0.0</version>
</dependency>
```

# Usage
Build the connector with MuleSoft's Anypoint Studio and attach it to your project with the built jar-file.
In order to build a community version of the connector, change the category parameter from pom.xml to: Community

Schema prefix and schema location:

```xml
<mule xmlns:x-road="http://www.mulesoft.org/schema/mule/x-road"
      xsi:schemaLocation="http://www.mulesoft.org/schema/mule/x-road http://www.mulesoft.org/schema/mule/x-road/current/mule-x-road.xsd">
```

Example usage from a Mule project:

    <x-road:x-road name="Xroad_config" endpointUrl="${endpoint.lipa}" trustStorePath="keystore.jks" trustStorePassword="${truststore.password}" trustStoreType="JKS"
        clientXroadInstance="${lipa.instance}" clientMemberClass="${lipa.client.memberClass}"
        clientMemberCode="${lipa.client.memberCode}" clientSubsystemCode="${lipa.client.subsystemCode}"
        serviceXroadInstance="${lipa.instance}" serviceMemberClass="${lipa.service.x.memberClass}"
        serviceMemberCode="${lipa.service.x.memberCode}" serviceSubsystemCode="${lipa.service.x.subsystemCode}" />

    <script:component>
      <script:script engine="groovy">
                <![CDATA[
                payload = org.w3c.dom.Document('Service-specific Request Document');
                ]]>
      </script:script>
    </script:component>

    <x-road:send-message config-ref="Xroad_config"
      serviceServiceCode="${lipa.service.x.serviceCode}" serviceServiceVersion="${lipa.service.x.serviceVersion}" userId="#[message.inboundProperties.'userId']" />

For further information about usage our documentation at https://github.com/solita/mule-x-road-connector.

# Reporting Issues

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link https://github.com/solita/mule-x-road-connector/issues.