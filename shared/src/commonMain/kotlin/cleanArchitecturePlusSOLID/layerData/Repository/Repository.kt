package cleanArchitecturePlusSOLID.layerData.Repository

import cleanArchitecturePlusSOLID.layerData.Repository.db.Db
import cleanArchitecturePlusSOLID.layerData.Repository.network.Network

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository {
    val db: Db
    val network: Network
}