package com.example.challengekonfio.domain

import com.example.challengekonfio.data.repository.DogsRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
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

        useCaseDog.getListDogs().collect { data ->
           assertNotNull(data)
        }
    }
}