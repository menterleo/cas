package org.apereo.cas.authentication;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.io.Serializable;
import lombok.ToString;
import lombok.Getter;

/**
 * This is {@link BasicIdentifiableCredential}, a simple credential implementation
 * that is only recognized by its id. The id generally represents an authentication token
 * encrypted in some fashion.
 *
 * @author Misagh Moayyed
 * @since 4.2.0
 */
@Slf4j
@ToString
@Getter
public class BasicIdentifiableCredential implements Credential, Serializable {

    private static final long serialVersionUID = -700605020472810939L;

    private String id;

    /**
     * Instantiates a new Basic identifiable credential.
     *
     * @param id the id
     */
    public BasicIdentifiableCredential(final String id) {
        this.id = id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final BasicIdentifiableCredential rhs = (BasicIdentifiableCredential) obj;
        return new EqualsBuilder().append(this.id, rhs.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).toHashCode();
    }
}
