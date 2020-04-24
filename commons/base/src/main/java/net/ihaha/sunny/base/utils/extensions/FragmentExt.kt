package net.ihaha.sunny.base.utils.extensions


import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import net.ihaha.sunny.base.data.dto.SResult
import net.ihaha.sunny.base.presentation.fragment.BaseFragment
import net.ihaha.sunny.base.utils.typealiases.InHandler
import net.ihaha.sunny.base.viewModels.IBaseViewModel

fun Fragment.hideKeyboard() = activity?.hideKeyboard()
fun Fragment.showKeyboard(view: View) = activity?.showKeyboard(view)

//the same for Fragments
fun Fragment.dip(value: Int): Int = requireActivity().dip(value)
fun Fragment.dip(value: Float): Int = requireActivity().dip(value)
fun Fragment.sp(value: Int): Int = requireActivity().sp(value)
fun Fragment.sp(value: Float): Int = requireActivity().sp(value)
fun Fragment.px2dip(px: Int): Float = requireActivity().px2dip(px)
fun Fragment.px2sp(px: Int): Float = requireActivity().px2sp(px)
fun Fragment.dimen(@DimenRes resource: Int): Int = requireActivity().dimen(resource)
fun Fragment.color(@ColorRes resource: Int): Int = requireActivity().color(resource)
fun Fragment.string(@StringRes resource: Int): String = requireActivity().string(resource)
fun Fragment.drawable(@DrawableRes resource: Int): Drawable? = requireActivity().drawable(resource)

fun <T : SResult<*>> BaseFragment<IBaseViewModel>.onResultChange(data: LiveData<T>?, stateHandle: InHandler<T>) {
    data?.observe(viewLifecycleOwner, stateHandle)
}

fun <T : Any> BaseFragment<IBaseViewModel>.onAnyChange(data: LiveData<T>?, stateHandle: InHandler<T>?) {
    stateHandle?.apply {
        data?.observe(viewLifecycleOwner, this)
    }
}