package com.example.primetube.model

class Error(var message : String? , var srcFragment : String) {
}

class AppError(var errorMessage : String? , var errorSrc : String?) : Throwable(){

}