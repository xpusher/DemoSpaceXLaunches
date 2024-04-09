package cleanArchitecturePlusSOLID.domain.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
public data class TestResponseData(
    @SerialName("origin")
     val origin: String,
    @SerialName("args")
    val args: LinkedHashMap<String,String>,
    @SerialName("headers")
    val headers: LinkedHashMap<String,String>,
)
