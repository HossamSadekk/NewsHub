package com.example.on_boarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {
    suspend fun saveOnBoardingState(state: Boolean)

}