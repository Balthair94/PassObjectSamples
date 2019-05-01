package com.baltazar.passobjectsamples.dataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Baltazar Rodriguez
 * @since v1.0.0
 */
@Parcelize
data class Job(var title: String, var salary: Int) : Parcelable