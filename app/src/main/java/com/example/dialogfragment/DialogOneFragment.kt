package com.example.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogOneFragment : DialogFragment(), OneCallback {

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
        return inflater.inflate(R.layout.dialog_one_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.open).setOnClickListener {
            val dialog = DialogTwoFragment.getInstance(this)
            val ft = childFragmentManager.beginTransaction()
            dialog.show(ft, DialogTwoFragment::class.java.simpleName)
        }
        view.findViewById<Button>(R.id.close).setOnClickListener {
            dismiss()
        }
    }

    override fun onClose() {
        dismiss()
    }

}
