package com.example.primetube.model

import java.util.*


class Subscription(var channelId : String , var allowNotification : Boolean){}
class PremiumContent(var videoId : String , var datePurchased : Date){}

class User(var firstName : String, var lastName : String, var username : String, var  email : String,var password : String,
           var emailConfirmed : String? = null,  var profileImagePath : String?  = null,
           var favorites : Array<String>?  = null, var createdChannel : Array<String>?  = null, var subscriptions : Array<Subscription>?  = null,
           var purchasedContent : Array<PremiumContent>?  = null, var likedVideoId : Array<String>?  = null, var watchLaterVideoIds : Array<String>?  = null,
           var playlist : Array<Playlist>?  = null, var notificationId : Array<String>?  = null)  {
}