package cleanArchitecture.layerDomain.entity

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public data class LaunchPresentation(
    public val flightNumber: Long,
    public val missionName: String,
    public val details: String,
    public val launchSuccess: Boolean,
    public val launchDateUTC: String,
    public val patchUrlSmall: String,
    public val patchUrlLarge: String,
    public val articleUrl: String,
    public val timestamp: String,
)

@Serializable
data class LaunchNetwork(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("details")
    val details: String?,
    @SerialName("success")
    val launchSuccess: Boolean?,
    @SerialName("links")
    val links: Links
) {
    var launchYear = launchDateUTC.toInstant().toLocalDateTime(TimeZone.UTC).year
}

@Serializable
data class Links(
    @SerialName("patch")
    val patch: Patch?,
    @SerialName("article")
    val article: String?
)

@Serializable
data class Patch(
    @SerialName("small")
    val small: String?,
    @SerialName("large")
    val large: String?
)
