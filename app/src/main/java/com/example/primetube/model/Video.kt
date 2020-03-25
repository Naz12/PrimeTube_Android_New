package com.example.primetube.model

import java.util.*

class Like(var userId : String , var date : Date){}
class Comment(var userId : String , var commentData : Date){}
class Chat(var userId : String , var text : String , var imagePath : String){}

 class Video(var _id : String? = null , var videoTittle : String, var videoDescription : String, var dateCreated : Date, var videoType : String,
            var videoTag : Array<String>, var videoPath : String, var originalVideoPath : String, var thumbnailPath : String,
            var originalThumbnailPath : String, var channelId : Any, var isLive : Boolean, var livePath : String,
            var price : Int, var creditCardNo : String, var purchasedCount : Int, var licenseKey : String, var watchCount : Int,
            var like : Array<Like>, var dislike : Array<Like>, var comment : Array<Comment>, var videoVersionPath : Array<String>,
            var chat : Array<Chat>
            )

data class VideoWithChannel(var _id : String? = null , var videoTittle : String, var videoDescription : String, var dateCreated : Date, var videoType : String,
                            var videoTag : Array<String>, var videoPath : String, var originalVideoPath : String, var thumbnailPath : String,
                            var originalThumbnailPath : String, var channelId : Channel, var isLive : Boolean, var livePath : String,
                            var price : Int, var creditCardNo : String, var purchasedCount : Int, var licenseKey : String, var watchCount : Int,
                            var like : Array<Like>, var dislike : Array<Like>, var comment : Array<Comment>, var videoVersionPath : Array<String>,
                            var chat : Array<Chat>
)