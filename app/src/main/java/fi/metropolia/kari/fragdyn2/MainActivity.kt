package fi.metropolia.kari.fragdyn2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var swapper: Boolean = false
    lateinit var frag1: Frag1
    lateinit var frag2: Frag2
    lateinit var fTransaction: FragmentTransaction
    lateinit var fManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        btn.setOnClickListener{swapFrags()}
        frag1 = Frag1.newInstance("Hello", "number 1")
        frag2 = Frag2.newInstance("Hello", "number 2")
        fManager = supportFragmentManager
        fTransaction = fManager.beginTransaction()
        fTransaction.add(R.id.fcontainer, frag1)
        fTransaction.commit()
        swapper = true

    }

    fun swapFrags(){
        if(swapper){
            fTransaction = fManager.beginTransaction()
            fTransaction.replace(R.id.fcontainer, frag2)
            fTransaction.addToBackStack(null);
            fTransaction.commit()
            swapper = false
        } else{
            fTransaction = fManager.beginTransaction()
            fTransaction.replace(R.id.fcontainer, frag1)
            fTransaction.addToBackStack(null);
            fTransaction.commit()
            swapper = true
        }
    }
}
