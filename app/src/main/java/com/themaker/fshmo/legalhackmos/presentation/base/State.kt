package com.themaker.fshmo.legalhackmos.presentation.base

enum class State {
    HasData,
    NoData,
    Loading,
    NetworkError,
    ServerError,
    PartiallyMissingData
}