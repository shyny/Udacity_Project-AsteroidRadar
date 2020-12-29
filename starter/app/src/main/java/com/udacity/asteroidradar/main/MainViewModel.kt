package com.udacity.asteroidradar.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.Asteroid
import timber.log.Timber

class MainViewModel : ViewModel() {

    private val _asteroidsList = MutableLiveData<List<Asteroid>>()
    val asteroidsList: LiveData<List<Asteroid>>
        get() = _asteroidsList

    private val _navigateToSelectedAsteroid = MutableLiveData<Asteroid>()
    val navigateToSelectedAsteroid: LiveData<Asteroid>
        get() = _navigateToSelectedAsteroid


    val list = mutableListOf(
            Asteroid(1,"prisma4","01/01/2020",34.6,234.08,1200.4,2034.8,false),
            Asteroid(2,"Sorenas3","01/12/2017",84.1,214.12,1200.4,2034.8,true),
            Asteroid(3,"prisma4","04/11/2014",31.6,239.08,1200.4,2034.8,false),
            Asteroid(4,"prisma5","13/07/2015",20.9,234.56,1200.4,2034.8,true),
            Asteroid(5,"Andromeda21","27/03/2009",33.2,134.11,1200.4,2034.8,false),
            Asteroid(6,"Plutoner09","01/09/2011",67.7,294.86,1200.4,2034.8,false),
            Asteroid(7,"Nepstar10","06/11/2019",69.1,210.10,1200.4,2034.8,true)
    )
    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getAsteroidsList()
        for (l in list) {
            Timber.i("List: "+ l.codename)
        }
    }

    private fun getAsteroidsList(){
        _asteroidsList.value = list
    }

    fun displayAsteroidDetails(asteroid: Asteroid) {
        _navigateToSelectedAsteroid.value = asteroid
    }

    fun displayAsteroidDetailsComplete() {
        _navigateToSelectedAsteroid.value = null
    }

}