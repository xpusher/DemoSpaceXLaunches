package cleanArchitecture.layerPresentation

public data class LaunchPresentation(
    public val flightNumber: Long,
    public val missionName: String,
    public val details: String,
    public val launchSuccess: Boolean,
    public val launchDateUTC: String,
    public val patchUrlSmall: String,
    public val patchUrlLarge: String,
    public val articleUrl: String,
)
