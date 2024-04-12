package cleanArchitecture.layerData.Repository

import cleanArchitecture.layerData.Repository.db.Db
import cleanArchitecture.layerData.Repository.network.Network

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository {
    val db: Db
    val network: Network
}