package com.baltazar.passobjectsamples

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.baltazar.passobjectsamples.dataClasses.Person

/**
 * @author Baltazar Rodriguez
 * @since v1.0.0
 */
class PersonDataDialog: DialogFragment() {

    private var mTextData: TextView? = null
    private var mPerson: Person? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_person_data, container, false)
        mTextData = view.findViewById(R.id.text_person_data)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            mPerson = it.getParcelable(PERSON_DATA)
        }

        mTextData?.text = mPerson?.toString() ?: "No person"
    }

    companion object {
        private const val PERSON_DATA = "person_data"

        fun newInstance(person: Person): PersonDataDialog {
            val dialog = PersonDataDialog()
            val bundle = Bundle()
            bundle.putParcelable(PERSON_DATA, person)
            dialog.arguments = bundle

            return dialog
        }
    }
}