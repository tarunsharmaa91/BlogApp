package com.app.blog

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Hilt will generate dagger components and code to automatically inject our android classes
//Decouple build dependency
//Simplify configuration
//Improve testing


//Below annotation create base class for components
@HiltAndroidApp
class BlogApp : Application()