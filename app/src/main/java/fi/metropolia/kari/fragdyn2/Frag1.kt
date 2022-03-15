package fi.metropolia.kari.fragdyn2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_frag1.view.*


private const val ARG1 = "param1"
private const val ARG2 = "param2"
private lateinit var viewOfLayout: View
/**
 * A simple [Fragment] subclass.
 * Use the [Frag1.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class Frag1 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param1 = it.getString(ARG1)
            param2 = it.getString(ARG2)
        }*/
        if(arguments != null) {
            param1 = arguments!!.getString(ARG1)
            param2 = arguments!!.getString(ARG2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        viewOfLayout = inflater.inflate(R.layout.fragment_frag1, container, false)
        viewOfLayout.f1txt.text = param1 + " " + param2
        return  viewOfLayout
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String): Frag1 {
            /*fun newInstance(param1: String, param2: String) =
         Frag1().apply {
                arguments = Bundle().apply {
                    putString(ARG1, param1)
                    putString(ARG2, param2)
                }
            } */
            val args: Bundle = Bundle()
            args.putString(ARG1,param1)
            args.putString(ARG2,param2)
            val fragment = Frag1()
            fragment.arguments = args
            return fragment
        }
    }
}
