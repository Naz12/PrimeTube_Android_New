package com.example.primetube.model

import java.util.*

class Channel(var _id : String? , var channelName : String, var channelDescription : String, var channelImagePath : String? = null,
              var  dateCreated : Date? = null, var streamKey : String? = null, var creatorIds : String? = null,
              var adminIds : List<String>? = null, var pinnedVideoId : String? = null,
              var channelPlaylist : List<Playlist>? = null, var subscribers : List<String>? = null) {
}

data class ChannelHomeResponse(var uploads : Array<Video> , var popular : Array<Video>)