/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.client.kafka.compat;

import java.util.Properties;

import org.apache.pulsar.client.api.ProducerConfiguration;

public class PulsarProducerKafkaConfig {

    /// Config variables
    public static final String PRODUCER_NAME = "pulsar.producer.name";
    public static final String INITIAL_SEQUENCE_ID = "pulsar.producer.initial.sequence.id";

    public static final String MAX_PENDING_MESSAGES = "pulsar.producer.max.pending.messages";
    public static final String MAX_PENDING_MESSAGES_ACROSS_PARTITIONS = "pulsar.producer.max.pending.messages.across.partitions";
    public static final String BATCHING_ENABLED = "pulsar.producer.batching.enabled";
    public static final String BATCHING_MAX_MESSAGES = "pulsar.producer.batching.max.messages";

    public static ProducerConfiguration getProducerConfiguration(Properties properties) {
        ProducerConfiguration conf = new ProducerConfiguration();

        if (properties.containsKey(PRODUCER_NAME)) {
            conf.setProducerName(properties.getProperty(PRODUCER_NAME));
        }

        if (properties.containsKey(INITIAL_SEQUENCE_ID)) {
            conf.setInitialSequenceId(Long.parseLong(properties.getProperty(INITIAL_SEQUENCE_ID)));
        }

        if (properties.containsKey(MAX_PENDING_MESSAGES)) {
            conf.setMaxPendingMessages(Integer.parseInt(properties.getProperty(MAX_PENDING_MESSAGES)));
        }

        if (properties.containsKey(MAX_PENDING_MESSAGES_ACROSS_PARTITIONS)) {
            conf.setMaxPendingMessagesAcrossPartitions(
                    Integer.parseInt(properties.getProperty(MAX_PENDING_MESSAGES_ACROSS_PARTITIONS)));
        }

        conf.setBatchingEnabled(Boolean.parseBoolean(properties.getProperty(BATCHING_ENABLED, "true")));

        if (properties.containsKey(BATCHING_MAX_MESSAGES)) {
            conf.setBatchingMaxMessages(Integer.parseInt(properties.getProperty(BATCHING_MAX_MESSAGES)));
        }

        return conf;
    }
}
