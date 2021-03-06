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
#ifndef LIB_READERCONFIGURATIONIMPL_H_
#define LIB_READERCONFIGURATIONIMPL_H_

#include <pulsar/ReaderConfiguration.h>
#include <boost/make_shared.hpp>

namespace pulsar {
struct ReaderConfigurationImpl {
    ReaderListener readerListener;
    bool hasReaderListener;
    int receiverQueueSize;
    std::string readerName;
    ReaderConfigurationImpl() : hasReaderListener(false), receiverQueueSize(1000), readerName() {}
};
}  // namespace pulsar
#endif /* LIB_READERCONFIGURATIONIMPL_H_ */
