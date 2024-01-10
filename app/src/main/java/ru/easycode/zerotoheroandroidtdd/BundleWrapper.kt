package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import java.util.ArrayList

interface BundleWrapper {
    interface Mutable : Save, Restore

    interface Save {
        fun save(list: ArrayList<CharSequence>)
    }

    interface Restore {
        fun restore(): List<CharSequence>
    }

    class Base(private val bundle: Bundle) : Mutable {

        override fun save(list: ArrayList<CharSequence>) {
            bundle.putCharSequenceArrayList("key", list)
        }

        override fun restore(): List<CharSequence> {
            return bundle.getCharSequenceArrayList("key") ?: ArrayList()
        }
    }
}
