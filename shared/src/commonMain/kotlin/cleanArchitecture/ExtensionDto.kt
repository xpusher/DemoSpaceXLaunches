package cleanArchitecture

import cleanArchitecture.layerDomain.entity.LaunchNetwork
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import cleanArchitecture.layerDomain.entity.LaunchSerializable
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
    val localDateTimeFormat=
        localDateTime.toInstant(TimeZone.UTC).toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTimeFormat.date} ${localDateTimeFormat.hour}:${localDateTimeFormat.minute}:${localDateTimeFormat.second}"
}
fun LaunchSerializable.toLaunch():Launch{
    return Launch(
        this.flightNumber,
        this.missionName,
        this.details,
        this.launchSuccess,
        this.launchDateUTC,
        this.patchUrlSmall,
        this.patchUrlLarge,
        this.articleUrl,
        this.timestamp,
    )
}
fun Launch.toLaunchSerializable():LaunchSerializable{
    return LaunchSerializable(
        this.flightNumber,
        this.missionName,
        this.details,
        this.launchSuccess,
        this.launchDateUTC,
        this.patchUrlSmall,
        this.patchUrlLarge,
        this.articleUrl,
        this.timestamp,
    )
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