package cleanArchitecture

import cleanArchitecture.layerDomain.entity.LaunchNetwork
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import com.example.Launch

fun LaunchNetwork.toLaunch():Launch{
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

fun Launch.toLaunchPresentation(): LaunchPresentation {
    return LaunchPresentation(
        flightNumber,
        missionName,
        "$details",
        launchSuccess==1L,
        launchDateUTC,
        "$patchUrlSmall",
        "$patchUrlLarge",
        "$articleUrl"

    )
}