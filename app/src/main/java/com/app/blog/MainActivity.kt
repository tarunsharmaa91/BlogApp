package com.app.blog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

//This will allow all dependency of container class to be used by MainActivity class
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Navigation Components:
        1. Navigation Graph: Contain navigation related info (destination and paths)
        2. Nav Host: Default Nav Host Display destination from nav graph
        3. Nav Controller: Manage App navigation within Nav Host
         */

        /*
        Dependency injection:
        Dependency: When one class depends upon another class that is called dependency, eg: Car is dependent on engine, engine is dependency
        Injection: Create an object once and use among different classes
        Injection is Container(Called as provider) carries the Engine(dependency) class and helps to inject that in Car(Called as consumer) class

        Type:
        Manual dependency injection> Not recommended because of boilerplate code
        Auto injection> Have to use Dagger 2, Koin, Hilt here for this

        Hilt: It is a framework/library for dependency injection in android

        @HiltAndroidApp: To create and keep container in  Application level
        @AndroidEntryPoint: To use the dependency in container
        @Inject: To inject/provide any specific dependency
        1. Field Injection
        2. Constructor Injection

        @Inject: It is used where you are the owner of code, eg, we are the owner of Machine and Car class
        @Binds: This is for injecting interface since there is no constructor in interface
        @Provides: This is for the code which we don't own, like any library like retrofit, room
         */

        //Flow will handle back pressure, it can handle multiple values sequentially but suspend fun can only handle one value

    }
}