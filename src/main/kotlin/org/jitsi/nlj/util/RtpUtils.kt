/*
 * Copyright @ 2018 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.nlj.util

import org.jitsi.rtp.util.RtpUtils
import org.jitsi.util.RTPUtils


/**
 * Returns true if getting to [otherSeqNum] from the current sequence number involves wrapping around
 */
infix fun Int.wrapsTo(otherSeqNum: Int): Boolean {
    /**
     * If, according to [RTPUtils.isOlderSequenceNumberThan], [this] is older than [otherSeqNum] and
     * yet [otherSeqNum] is less than [this], then we wrapped around to get from [this] to
     * [otherSeqNum]
     */
    return RTPUtils.isOlderSequenceNumberThan(this, otherSeqNum) && otherSeqNum < this
}
