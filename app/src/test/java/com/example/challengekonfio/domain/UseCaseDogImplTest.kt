package com.example.challengekonfio.domain

import com.example.challengekonfio.data.repository.DogsRepository
import com.example.challengekonfio.utils.DataState
import com.example.challengekonfio.utils.DataState.Success
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class UseCaseDogImplTest : TestCase(){

    @RelaxedMockK
    private lateinit var repository: DogsRepository
    lateinit var useCaseDog: UseCaseDog


    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        useCaseDog = UseCaseDogImpl(repository)
    }

    @Test
    fun whenTheServiceHasntDataReturnDataFromDb() = runBlocking {

        useCaseDog.getListDogs().collect { state ->
            when(state){
                is DataState.Success ->{
                    val data = state.data
                    assertNotNull("Content data => ",data)
                }
                else -> {}
            }
        }
    }
}