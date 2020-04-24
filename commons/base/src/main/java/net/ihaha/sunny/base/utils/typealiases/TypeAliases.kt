package net.ihaha.sunny.base.utils.typealiases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import kotlinx.coroutines.flow.Flow
import net.ihaha.sunny.base.data.dto.SResult

typealias UnitHandler = () -> Unit
typealias InHandler<T> = (T) -> Unit
typealias OutHandler<T> = () -> T
typealias InSameOutHandler<T> = (T) -> T
typealias InOutHandler<T, R> = (T) -> R


typealias SUnitHandler = suspend () -> Unit
typealias SInHandler<T> = suspend (T) -> Unit
typealias SOutHandler<T> = suspend () -> T
typealias SInSameOutHandler<T> = suspend (T) -> T
typealias SInOutHandler<T, R> = suspend (T) -> R
typealias SParentInOutHandler<P, T, R> = suspend P.(T) -> R

typealias ResultLiveData<T> = LiveData<SResult<T>>
typealias ResultListLiveData<T> = LiveData<SResult<List<T>>>
typealias ResultMutableLiveData<T> = MutableLiveData<SResult<T>>
typealias PagedLiveData<T> = LiveData<PagedList<T>>

typealias AnyResult = SResult<Any>
typealias AnyResultLiveData = ResultLiveData<Any>
typealias AnyResultListLiveData = ResultListLiveData<Any>
typealias AnyResultMutableLiveData = ResultMutableLiveData<Any>

typealias ResultList<T> = SResult<List<T>>
typealias FlowResultList<T> = Flow<SResult<List<T>>>
typealias ResultInHandler<T> = (SResult<T>) -> Unit
typealias ResultInOutHandler<T, R> = (SResult<T>) -> SResult<R>
