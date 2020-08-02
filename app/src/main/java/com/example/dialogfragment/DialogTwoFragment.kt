package com.example.dialogfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogTwoFragment : DialogFragment() {

    private lateinit var oneCallback: OneCallback

    companion object {

        fun getInstance(callback: OneCallback): DialogTwoFragment {
            val bundle = Bundle().apply {
                putSerializable("callback", callback)
            }

            return DialogTwoFragment().apply {
                arguments = bundle
            }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        oneCallback = arguments!!.getSerializable("callback") as OneCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_two_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.open).setOnClickListener {
            val dialog = DialogThreeFragment.getInstance()
            val ft = childFragmentManager.beginTransaction()
            dialog.show(ft, DialogTwoFragment::class.java.simpleName)
        }
        view.findViewById<Button>(R.id.close).setOnClickListener {
            oneCallback.onClose()
        }
    }

}
