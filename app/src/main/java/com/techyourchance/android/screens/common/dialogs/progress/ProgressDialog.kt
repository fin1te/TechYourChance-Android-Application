package com.techyourchance.android.screens.common.dialogs.progress

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.techyourchance.android.R
import com.techyourchance.android.common.eventbus.EventBusPoster
import com.techyourchance.android.screens.common.dialogs.BaseDialog
import com.techyourchance.android.screens.common.widgets.ViewExtensions.colorize
import javax.inject.Inject

class ProgressDialog : BaseDialog() {

    @Inject lateinit var eventBusPoster: EventBusPoster

    private lateinit var progress: ProgressBar
    private lateinit var txtTitle: TextView
    private lateinit var txtMessage: TextView

    private var message: CharSequence? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        controllerComponent.inject(this)
        super.onCreate(savedInstanceState)
        isCancelable = false
        message = requireArguments().getCharSequence(ARG_MESSAGE)
    }

    override fun onCreateDialogInternal(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.layout_dialog_progress)
        dialog.apply {
            progress = findViewById(R.id.progressBar)
            txtTitle = findViewById(R.id.txtDialogTitle)
            txtMessage = findViewById(R.id.txtDialogMessage)
        }
        if (message != null && message.toString().isNotBlank()) {
            txtMessage.text = message
            txtMessage.isVisible = true
        }
        return dialog
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        eventBusPoster.post(ProgressDialogDismissedEvent(dialogId))
    }

    companion object {
        const val ARG_MESSAGE = "ARG_MESSAGE"
        fun newInstance(message: CharSequence?): ProgressDialog {
            val args = Bundle()
            args.putCharSequence(ARG_MESSAGE, message)
            val dialog = ProgressDialog()
            dialog.arguments = args
            return dialog
        }
    }
}