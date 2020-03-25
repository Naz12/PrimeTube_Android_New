package com.example.primetube.model

import java.util.*

class Live(var channelId : String , var videoId : String , var tag : String , var date : Date) {
}

data class LiveResponseResult(var subscriptions : List<Video> , var popular : List<Video> , var previouslyLive : List<Video>)

