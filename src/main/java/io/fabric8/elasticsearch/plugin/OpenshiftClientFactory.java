/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.elasticsearch.plugin;

import org.elasticsearch.common.inject.Inject;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

public class OpenshiftClientFactory {

    private final PluginSettings settings;

    @Inject
    public OpenshiftClientFactory(final PluginSettings settings) {
        this.settings = settings;
    }
    
    public OpenShiftClient create(Config config) {
        config.setMasterUrl(settings.getMasterUrl());
        config.setTrustCerts(settings.isTrustCerts());
        return new DefaultOpenShiftClient(config);
    }
}
