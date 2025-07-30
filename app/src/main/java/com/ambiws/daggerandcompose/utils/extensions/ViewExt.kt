package com.ambiws.daggerandcompose.utils.extensions

import android.view.View
import android.widget.Toast

fun View.setUnderConstructionToast() {
    this.setOnClickListener {
        Toast.makeText(this.context, "Under Construction", Toast.LENGTH_SHORT).show()
    }
}
