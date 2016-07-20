/*
 * Copyright 2016 Copyright 2016 Akamai Technologies, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.akamai.testing.edgegrid.core;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimaps;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Client credential used to sign a request.
 *
 * @author mgawinec@akamai.com
 */
public class ClientCredential {

    private String clientToken;
    private String accessToken;
    private String clientSecret;

    ClientCredential(Builder b) {
        this.clientToken = checkNotNull(b.clientToken);
        this.accessToken = checkNotNull(b.accessToken);
        this.clientSecret = checkNotNull(b.clientSecret);
    }

    /**
     * Returns a new builder. The returned builder is equivalent to the builder
     * generated by {@link Builder}.
     */
    public static Builder builder() {
        return new Builder();
    }

    String getClientToken() {
        return clientToken;
    }

    String getAccessToken() {
        return accessToken;
    }

    String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final ClientCredential other = (ClientCredential) o;
        return Objects.equals(this.clientToken, other.clientToken)
                && Objects.equals(this.clientSecret, other.clientSecret)
                && Objects.equals(this.accessToken, other.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, clientSecret, accessToken);
    }

    @Override
    public String toString() {
        return "ClientCredential(clientToken=" + clientSecret + ", accessToken=" + accessToken + ", clientSecret=" + clientSecret + ")";
    }

    public static class Builder {
        private String clientToken;
        private String accessToken;
        private String clientSecret;

        /**
         * Creates a new builder. The returned builder is equivalent to the builder
         * generated by {@link ClientCredential#builder}.
         */
        public Builder() {
        }

        /**
         * Sets a token representing an OPEN API service client.
         */
        public Builder clientToken(String clientToken) {
            this.clientToken = checkNotNull(clientToken);
            return this;
        }


        /**
         * Sets a secret associated with a client token.
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = checkNotNull(clientSecret);
            return this;
        }

        /**
         * Sets an access token representing authorizations a client has for OPEN API service.
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = checkNotNull(accessToken);
            return this;
        }

        /**
         * Returns a newly-created immutable client credential.
         */
        public ClientCredential build() {
            return new ClientCredential(this);
        }


    }
}