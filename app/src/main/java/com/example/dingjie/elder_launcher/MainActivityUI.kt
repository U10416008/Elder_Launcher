package com.example.dingjie.elder_launcher

import android.graphics.Color
import android.view.Gravity
import org.jetbrains.anko.*

/**
 * Created by dingjie on 2018/3/19.
 */
class MainActivityUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(20)
            linearLayout{
                textView {
                    text = "12:00"
                    textColor = Color.BLACK
                    textSize = 24f
                }.lparams(width = wrapContent) {
                    margin = dip(20)
                }
                textView {
                    textResource = R.string.time
                    textColor = Color.BLACK
                    textSize = 24f
                }.lparams(width = wrapContent) {
                    margin = dip(20)
                }
                button("SOS") {
                    id = R.id.button
                    backgroundColorResource = R.color.red;
                    /*onClick {
                        toast("Hey ${name.text}! Thank you for contacting us. We will get in touch with you soon.")
                    }*/
                }.lparams(dip(280), sp(80))
            }
            linearLayout{

                verticalLayout {

                    imageView {
                        imageResource = R.drawable.contacts
                        id = R.id.contacts
                    }
                    textView {
                        textResource = R.string.contacts
                    }
                }.lparams{
                    weight = 0.5f
                }
                verticalLayout {
                    imageView {
                        id = R.id.chat
                        imageResource = R.drawable.contacts

                    }
                    textView {
                        textResource = R.string.contacts

                    }
                }.lparams{
                    weight = 0.5f
                }
            }
            linearLayout{
                verticalLayout {
                    imageView {
                        imageResource = R.drawable.contacts
                        id = R.id.game
                    }
                    textView {
                        textResource = R.string.contacts

                    }
                }.lparams{
                    weight = 0.5f
                }
                verticalLayout {
                    imageView {
                        imageResource = R.drawable.contacts
                        id = R.id.more

                    }
                    textView {
                        textResource = R.string.more

                    }
                }.lparams{
                    weight = 0.5f
                }
            }



        }
    }
}