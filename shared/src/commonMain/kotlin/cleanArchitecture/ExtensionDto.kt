package cleanArchitecture

import cleanArchitecture.layerDomain.entity.LaunchNetwork
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import com.example.Launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime


fun LocalDateTime.Companion.nowUTC(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(TimeZone.UTC)
}
fun LocalDateTime.Companion.toPresentationFromUTC(localDateTime: LocalDateTime):String{
    val localDateTime=
        localDateTime.toInstant(TimeZone.UTC).toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.date} ${localDateTime.hour}:${localDateTime.minute}:${localDateTime.second}"
}

fun LaunchNetwork.toLaunch(timestamp:LocalDateTime):Launch{
    return Launch(
        flightNumber.toLong(),
        missionName,
        details,
        if (launchSuccess==true) 1 else 0,
        launchYear.toString(),
        links.patch?.small,
        links.patch?.large,
        links.article,
        timestamp.toString()
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
        "$articleUrl",
        timestamp
    )
}