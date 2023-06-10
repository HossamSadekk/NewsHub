package com.example.on_boarding.domain.use_case

import com.example.on_boarding.domain.repository.OnBoardingRepository
import javax.inject.Inject

class SaveOnBoardingStateUseCase @Inject constructor (private val repository: OnBoardingRepository) {
    suspend operator fun invoke(state:Boolean) = repository.saveOnBoardingState(state)
}