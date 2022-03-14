package com.automatodev.home_ponto.dto

data class AppPreferencesDto(
    var showIntro: Boolean?,
    var darkTheme: Boolean?,
    var registration: Int?
) {

    constructor() : this(false, false, 0)
}