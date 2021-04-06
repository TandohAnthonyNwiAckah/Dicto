//package com.tanamo.dicto.util
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.annotation.Nullable
//import androidx.fragment.app.Fragment
//import com.google.android.gms.ads.AdRequest
//import com.tanamo.dicto.R
//import kotlinx.android.synthetic.main.cedis.*
//
//
///**
// * Created by ${TANDOH} on ${6/20/2017}.
// */
//
//class Cedis : Fragment() {
//
//    private lateinit var adr: AdRequest
//
//    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.cedis, container, false)
//    }
//
//    @SuppressLint("MissingPermission")
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        adr = AdRequest.Builder().build()
//        adV!!.loadAd(adr)
//    }
//
//}
