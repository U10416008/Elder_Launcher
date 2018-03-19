package com.example.dingjie.elder_launcher

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView

import java.net.Socket


class MainActivity : AppCompatActivity() {

    internal val client = Client("192.168.0.112", 1234)
    internal lateinit var button: Button
    internal lateinit var more: ImageView
    internal lateinit var contact: ImageView
    internal lateinit var chat: ImageView
    internal lateinit var game: ImageView
    override fun onCreate(savedIntanceState: Bundle?) {
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)

        button.setOnClickListener { }
        initChat()
        initGame()
        initMore()
        initContacts()
        initServer()

    }
    fun initChat() {
        chat = findViewById(R.id.chats)
        chat.layoutParams.height = screenHeight / 3
        chat.layoutParams.width = screenWidth / 3
        chat.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, ContactActivity::class.java)
            startActivity(intent)
        }
        chat.setOnLongClickListener { false }
    }
    fun initGame() {
        game = findViewById(R.id.game)
        game.layoutParams.height = screenHeight / 3
        game.layoutParams.width = screenWidth / 3
        game.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, ContactActivity::class.java)
            startActivity(intent)
        }
        game.setOnLongClickListener { false }
    }
    fun initContacts() {
        contact = findViewById(R.id.contacts)
        contact.layoutParams.height = screenHeight / 3
        contact.layoutParams.width = screenWidth / 3
        contact.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, ContactActivity::class.java)
            startActivity(intent)
        }
        contact.setOnLongClickListener { false }
    }

    fun initMore() {
        more = findViewById(R.id.more)
        more.layoutParams.height = screenHeight / 3
        more.layoutParams.width = screenWidth / 3
        more.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@MainActivity, AppList::class.java)
            startActivity(intent)
        }
        more.setOnLongClickListener { false }
    }

    fun initServer() {
        client.setClientCallback(object : Client.ClientCallback {
            override fun onMessage(message: String) {}

            override fun onConnect(socket: Socket?) {

                client.send("Hello World!\n")
                client.send("0910832632")
                //client.disconnect();
            }

            override fun onDisconnect(socket: Socket?, message: String) {}

            override fun onConnectError(socket: Socket?, message: String) {}
        })

        client.connect()
    }

    companion object {
        val screenWidth: Int
            get() = Resources.getSystem().displayMetrics.widthPixels

        val screenHeight: Int
            get() = Resources.getSystem().displayMetrics.heightPixels
    }
}
