/**
 * MIT License Copyright (c) 2017 Solita Oy
 */
package fi.solita.mule.modules.xroad;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

@Configuration(friendlyName = "Configuration", configElementName = "x-road")
public class XRoadConnectorConfig {

    private XRoadClient client = new XRoadClient();

    /**
     * Url of the x-road server
     */
    @Configurable
    private String endpointUrl;

    /**
     * Path to the trust store. E.g. keystore.jks
     */
    @Configurable
    @Optional
    private String trustStorePath;

    /**
     * Password of the trust store.
     */
    @Configurable
    @Optional
    private String trustStorePassword;

    /**
     * Type of the trust store. E.g. JKS
     */
    @Configurable
    @Optional
    private String trustStoreType;

    /**
     * Path to the client keystore. E.g. keystore.jks
     */
    @Configurable
    @Optional
    private String keyStorePath;

    /**
     * Password of the client keystore.
     */
    @Configurable
    @Optional
    private String keyStorePassword;

    /**
     * Password of the client key.
     */
    @Configurable
    @Optional
    private String keyPassword;

    /**
     * Type of the client keystore. E.g. JKS
     */
    @Configurable
    @Optional
    private String keyStoreType;

    /**
     * X-Road header
     */
    @Configurable
    public String clientXroadInstance;

    /**
     * X-Road header
     */
    @Configurable
    public String clientMemberClass;

    /**
     * X-Road header
     */
    @Configurable
    public String clientMemberCode;

    /**
     * X-Road header
     */
    @Configurable
    public String clientSubsystemCode;

    /**
     * X-Road header
     */
    @Configurable
    public String serviceXroadInstance;

    /**
     * X-Road header
     */
    @Configurable
    public String serviceMemberClass;

    /**
     * X-Road header
     */
    @Configurable
    public String serviceMemberCode;

    /**
     * X-Road header
     */
    @Configurable
    public String serviceSubsystemCode;

    /**
     * X-Road header. Probably you want to configure this where you use the
     * connector.
     */
    @Configurable
    @Optional
    public String serviceServiceCode;

    /**
     * X-Road header. Probably you want to configure this where you use the
     * connector.
     */
    @Configurable
    @Optional
    public String serviceServiceVersion;

    /**
     * X-Road header. Probably you want to configure this where you use the
     * connector. You may leave this null.
     */
    @Configurable
    @Optional
    // Devkit won't allow Boolean to be null so we use String here
    public String async;

    /**
     * X-Road header
     */
    @Configurable
    @Optional
    public String userId;

    /**
     * X-Road header
     */
    @Configurable
    @Optional
    public String issue;

    /**
     * X-Road header
     */
    @Configurable
    @Optional
    @Default("4.0")
    public String protocolVersion;

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getTrustStorePath() {
        return trustStorePath;
    }

    public void setTrustStorePath(String trustStorePath) {
        this.trustStorePath = trustStorePath;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getTrustStoreType() {
        return trustStoreType;
    }

    public void setTrustStoreType(String trustStoreType) {
        this.trustStoreType = trustStoreType;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getClientXroadInstance() {
        return clientXroadInstance;
    }

    public void setClientXroadInstance(String clientXroadInstance) {
        this.clientXroadInstance = clientXroadInstance;
    }

    public String getClientMemberClass() {
        return clientMemberClass;
    }

    public void setClientMemberClass(String clientMemberClass) {
        this.clientMemberClass = clientMemberClass;
    }

    public String getClientMemberCode() {
        return clientMemberCode;
    }

    public void setClientMemberCode(String clientMemberCode) {
        this.clientMemberCode = clientMemberCode;
    }

    public String getClientSubsystemCode() {
        return clientSubsystemCode;
    }

    public void setClientSubsystemCode(String clientSubsystemCode) {
        this.clientSubsystemCode = clientSubsystemCode;
    }

    public String getServiceXroadInstance() {
        return serviceXroadInstance;
    }

    public void setServiceXroadInstance(String serviceXroadInstance) {
        this.serviceXroadInstance = serviceXroadInstance;
    }

    public String getServiceMemberClass() {
        return serviceMemberClass;
    }

    public void setServiceMemberClass(String serviceMemberClass) {
        this.serviceMemberClass = serviceMemberClass;
    }

    public String getServiceMemberCode() {
        return serviceMemberCode;
    }

    public void setServiceMemberCode(String serviceMemberCode) {
        this.serviceMemberCode = serviceMemberCode;
    }

    public String getServiceSubsystemCode() {
        return serviceSubsystemCode;
    }

    public void setServiceSubsystemCode(String serviceSubsystemCode) {
        this.serviceSubsystemCode = serviceSubsystemCode;
    }

    public String getServiceServiceCode() {
        return serviceServiceCode;
    }

    public void setServiceServiceCode(String serviceServiceCode) {
        this.serviceServiceCode = serviceServiceCode;
    }

    public String getServiceServiceVersion() {
        return serviceServiceVersion;
    }

    public void setServiceServiceVersion(String serviceServiceVersion) {
        this.serviceServiceVersion = serviceServiceVersion;
    }
   
    public String getAsync() {
        return async;
    }

    public void setAsync(String async) {
        this.async = async;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setClient(XRoadClient client) {
        this.client = client;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public XRoadClient getClient() {
        return client;
    }

    public XRoadHeaders getXRoadHeaders() {
        return new XRoadHeaders(null, clientXroadInstance, clientMemberClass, clientMemberCode,
                clientSubsystemCode, serviceXroadInstance, serviceMemberClass, serviceMemberCode,
                serviceSubsystemCode, serviceServiceCode, serviceServiceVersion,
                async == null ? null : Boolean.valueOf(async), userId, issue, protocolVersion);

    }

}
