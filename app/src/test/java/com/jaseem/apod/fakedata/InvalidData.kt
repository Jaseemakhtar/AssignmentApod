package com.jaseem.apod.fakedata

import com.jaseem.apod.data.network.model.CosmosRemote

// missing important fields
val inValidData = listOf(
    CosmosRemote(
        copyright = "Zhuokai Liu",
        date = "2019-12-05",
        explanation = "Beautiful spiral galaxy NGC 6744 is nearly 175,000 light-years across, larger than our own Milky Way.",
        hdurl = "https://apod.nasa.gov/apod/image/1912/NGC6744_FinalLiuYuhang.jpg",
        mediaType = "image",
        serviceVersion = "v1",
        title = null,
        url = "https://apod.nasa.gov/apod/image/1912/NGC6744_FinalLiuYuhang1024.jpg"
    ),
    CosmosRemote(
        copyright = "Ivan Pedretti",
        date = "2019-12-04",
        explanation = null,
        hdurl = "https://apod.nasa.gov/apod/image/1912/ElectricMilkyWay_Pedretti_1920.jpg",
        mediaType = "image",
        serviceVersion = "v1",
        title = "Electric Night",
        url = "https://apod.nasa.gov/apod/image/1912/ElectricMilkyWay_Pedretti_1080.jpg"
    ),
    CosmosRemote(
        copyright = "ESA/HubbleNASA",
        date = "2019-12-01",
        explanation = null,
        hdurl = "https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg",
        mediaType = "image",
        serviceVersion = "v1",
        title = "Starburst Galaxy M94 from Hubble",
        url = "https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg"
    )
)