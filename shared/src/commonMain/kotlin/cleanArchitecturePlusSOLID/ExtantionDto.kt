package cleanArchitecturePlusSOLID

import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import com.example.Launch

fun RocketLaunch.toLaunch():Launch{
    return Launch(
        flightNumber.toLong(),
        missionName,
        details,
        if (launchSuccess==true) 1 else 0,
        launchYear.toString(),
        links.patch?.small,
        links.patch?.large,
        links.article,
    )
}