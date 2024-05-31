package com.example.functionsspeech.data.model

import com.google.gson.annotations.SerializedName

data class TextToSpeechData(
    @SerializedName("text") var text: String,
    @SerializedName("model_id") var modelid: String,
    /*@SerializedName("voice_setings")
    @SerializedName("similarity_boost") var similarity_boost: Double,
    @SerializedName("stability") var stability: Double*/
)
