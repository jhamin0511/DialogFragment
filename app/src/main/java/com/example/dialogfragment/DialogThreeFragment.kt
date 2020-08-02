package com.example.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogThreeFragment : DialogFragment() {

    companion object {

        fun getInstance(): DialogThreeFragment {
            val bundle = Bundle().apply {
            }

            return DialogThreeFragment().apply {
                arguments = bundle
            }
        }

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
        return inflater.inflate(R.layout.dialog_three_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.close).setOnClickListener {
            val manager = requireActivity().supportFragmentManager

            if (manager.fragments.isNotEmpty()) {
                val fragment = manager.fragments[0]
                manager.beginTransaction().remove(fragment).commit()
            }
        }
    }

}
