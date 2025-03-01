package io.newm.chain.database.repository

import io.newm.chain.database.entity.LedgerAssetMetadata
import io.newm.chain.database.entity.RawTransaction
import io.newm.chain.database.entity.StakeDelegation
import io.newm.chain.database.entity.StakeRegistration
import io.newm.chain.model.CreatedUtxo
import io.newm.chain.model.NativeAssetMetadata
import io.newm.chain.model.SpentUtxo
import io.newm.chain.model.Utxo

interface LedgerRepository {

    fun queryUtxos(address: String): List<Utxo>

    fun doRollback(blockNumber: Long)

    fun upcertNativeAssets(nativeAssetsMetadata: Set<NativeAssetMetadata>): Set<NativeAssetMetadata>

    fun insertLedgerAssetMetadataList(assetMetadataList: List<LedgerAssetMetadata>)

    fun pruneSpent(slotNumber: Long)

    fun spendUtxos(slotNumber: Long, blockNumber: Long, spentUtxos: Set<SpentUtxo>)

    fun createUtxos(slotNumber: Long, blockNumber: Long, createdUtxos: Set<CreatedUtxo>)

    fun createStakeRegistrations(stakeRegistrations: List<StakeRegistration>)

    fun findPointerStakeRegistration(slot: Long, txIndex: Int, certIndex: Int): StakeRegistration?

    fun createStakeDelegations(stakeDelegations: List<StakeDelegation>)

    fun queryPoolLoyalty(stakeAddress: String, poolId: String, currentEpoch: Long): Long

    fun queryAdaHandle(adaHandleName: String): String?

    fun siblingHashCount(hash: String): Long

    fun queryPayerAddress(receivedUtxo: Utxo): String

    fun createRawTransactions(rawTransactions: List<RawTransaction>)
}
