package com.turun.personsmvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true)

    @SerializedName("kisi_id")
    @ColumnInfo("kisi_id") @NotNull
    var kisi_id: Int,
    @SerializedName("kisi_ad")
    @ColumnInfo("kisi_ad") @NotNull
    var kisi_ad: String,
    @SerializedName("kisi_tel")
    @ColumnInfo("kisi_tel") @NotNull
    var kisi_tel: String
) : Serializable//veri transferi için
