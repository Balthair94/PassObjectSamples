package com.baltazar.passobjectsamples.dataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Baltazar Rodriguez
 * @since v1.0.0
 */
@Parcelize
data class Person(var name: String, var age: Int, var job: Job) : Parcelable