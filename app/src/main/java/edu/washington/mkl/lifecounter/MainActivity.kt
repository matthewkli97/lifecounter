package edu.washington.mkl.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val players: IntArray = intArrayOf(1, 1, 1, 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1P1 = findViewById(R.id.button1P1) as Button
        button1P1.setOnClickListener { view -> incrementByOne(0)}
        val button2P1 = findViewById(R.id.button2P1) as Button
        button2P1.setOnClickListener { view -> decrementByOne(0)}
        val button3P1 = findViewById(R.id.button3P1) as Button
        button3P1.setOnClickListener { view -> incrementByFive(0)}
        val button4P1 = findViewById(R.id.button4P1) as Button
        button4P1.setOnClickListener { view -> decrementByFive(0)}

        val button1P2 = findViewById(R.id.button1P2) as Button
        button1P2.setOnClickListener { view -> incrementByOne(1)}
        val button2P2 = findViewById(R.id.button2P2) as Button
        button2P2.setOnClickListener { view -> decrementByOne(1)}
        val button3P2 = findViewById(R.id.button3P2) as Button
        button3P2.setOnClickListener { view -> incrementByFive(1)}
        val button4P2 = findViewById(R.id.button4P2) as Button
        button4P2.setOnClickListener { view -> decrementByFive(1)}

        val button1P3 = findViewById(R.id.button1P3) as Button
        button1P3.setOnClickListener { view -> incrementByOne(2)}
        val button2P3 = findViewById(R.id.button2P3) as Button
        button2P3.setOnClickListener { view -> decrementByOne(2)}
        val button3P3 = findViewById(R.id.button3P3) as Button
        button3P3.setOnClickListener { view -> incrementByFive(2)}
        val button4P3 = findViewById(R.id.button4P3) as Button
        button4P3.setOnClickListener { view -> decrementByFive(2)}

        val button1P4 = findViewById(R.id.button1P4) as Button
        button1P4.setOnClickListener { view -> incrementByOne(3)}
        val button2P4 = findViewById(R.id.button2P4) as Button
        button2P4.setOnClickListener { view -> decrementByOne(3)}
        val button3P4 = findViewById(R.id.button3P4) as Button
        button3P4.setOnClickListener { view -> incrementByFive(3)}
        val button4P4 = findViewById(R.id.button4P4) as Button
        button4P4.setOnClickListener { view -> decrementByFive(3)}

        updateLives()
    }

    fun checkDeath() {
        val tv = findViewById(R.id.textViewOutput) as TextView
        tv.text = ""
        for (i in players.indices) {
            if(players[i] <= 0) {
                tv.text = "Player " + (i+1) + " LOSES!"
                Log.i("Main Activity", "Player " + i + " LOSES!")
            }
        }
    }

    fun incrementByOne(playerNum:Int) {
        players[playerNum]++
        Log.i("Main Activity", players[playerNum].toString())
        updateLives()
        checkDeath()
    }

    fun decrementByOne(playerNum:Int) {
        players[playerNum]--
        Log.i("Main Activity", players[playerNum].toString())
        updateLives()
        checkDeath()
    }
    fun incrementByFive(playerNum:Int) {
        players[playerNum] = players[playerNum] + 5
        Log.i("Main Activity", players[playerNum].toString())
        updateLives()
        checkDeath()

    }

    fun decrementByFive(playerNum:Int) {
        players[playerNum] = players[playerNum] - 5
        Log.i("Main Activity", players[playerNum].toString())
        updateLives()
        checkDeath()
    }

    fun updateLives() {
        for (i in players.indices) {
            val textId = "textViewP" + (i+1)
            val playerTextId = getResources().getIdentifier(textId, "id", getPackageName())

            val player = findViewById(playerTextId) as TextView

            player.text = "Player " + (i+1) + " : " + players[i]
        }
    }
}
