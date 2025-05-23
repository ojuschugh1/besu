/*
 * Copyright contributors to Besu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.consensus.qbft.adaptor;

import org.hyperledger.besu.consensus.qbft.core.types.QbftBlockHeader;
import org.hyperledger.besu.consensus.qbft.core.types.QbftBlockchain;
import org.hyperledger.besu.ethereum.chain.Blockchain;
import org.hyperledger.besu.ethereum.core.BlockHeader;

/** Adaptor class to allow a {@link Blockchain} to be used as a {@link QbftBlockchain}. */
public class QbftBlockchainAdaptor implements QbftBlockchain {
  private final Blockchain blockchain;

  /**
   * Create a new instance of the adaptor.
   *
   * @param blockchain The {@link Blockchain} to adapt.
   */
  public QbftBlockchainAdaptor(final Blockchain blockchain) {
    this.blockchain = blockchain;
  }

  @Override
  public QbftBlockHeader getChainHeadHeader() {
    BlockHeader chainHeadHeader = blockchain.getChainHeadHeader();
    return new QbftBlockHeaderAdaptor(chainHeadHeader);
  }

  @Override
  public long getChainHeadBlockNumber() {
    return blockchain.getChainHeadBlockNumber();
  }
}
