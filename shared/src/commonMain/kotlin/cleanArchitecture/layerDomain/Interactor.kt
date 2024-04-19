package cleanArchitecture.layerDomain

import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import cleanArchitecture.layerPresentation.Presenter
import cleanArchitecture.layerDomain.usecase.UserActions
import cleanArchitecture.toLaunchPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Interactor(
    private val presenter: Presenter,
    private val boundaries: Boundaries
) {
    val userActions = object : UserActions {

        override fun hardUpdateLaunches() {

            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    presenter.mutableLaunchesPresentation.value=null

                    boundaries.dbClearLaunches()

                    softUpdateLaunches()

                }

        }

        override fun softUpdateLaunches() {
            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    val dbLaunches=ArrayList(
                        boundaries.dbLoadLaunches())

                    if (dbLaunches.isEmpty())
                        boundaries.networkRequestLaunches().onEach {
                            boundaries.dbInsertLaunch(it)
                            dbLaunches.add(it)
                        }

                    presenter.mutableLaunchesPresentation.emit(
                        ArrayList<LaunchPresentation>()
                            .apply {
                                dbLaunches.forEach {
                                    add(it.toLaunchPresentation())
                                }
                            }
                    )

                }
        }

        override fun removeLaunches(flightNumber: Long) {

            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {
                    boundaries.dbRemoveLaunchesByFlightNumber(flightNumber)
                    softUpdateLaunches()
                }
        }

    }
    init {
        userActions.softUpdateLaunches()
    }
}