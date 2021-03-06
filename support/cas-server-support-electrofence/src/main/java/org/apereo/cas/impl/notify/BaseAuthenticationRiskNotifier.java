package org.apereo.cas.impl.notify;

import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.api.AuthenticationRiskNotifier;
import org.apereo.cas.api.AuthenticationRiskScore;
import org.apereo.cas.authentication.Authentication;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is {@link BaseAuthenticationRiskNotifier}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@Slf4j
public abstract class BaseAuthenticationRiskNotifier implements AuthenticationRiskNotifier {

    
    /**
     * Cas properties.
     */
    @Autowired
    protected CasConfigurationProperties casProperties;
    
    /**
     * The Authentication.
     */
    protected Authentication authentication;
    /**
     * The Service.
     */
    protected RegisteredService service;
    /**
     * The Score.
     */
    protected AuthenticationRiskScore score;

    @Override
    public void setAuthentication(final Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public void setRegisteredService(final RegisteredService service) {
        this.service = service;
    }

    @Override
    public void setAuthenticationRiskScore(final AuthenticationRiskScore score) {
        this.score = score;
    }

    @Override
    public void run() {
        publish();
    }
}
