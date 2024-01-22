package com.qadeer.mvvmproject.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qadeer.mvvmproject.data.models.UserModel
import com.qadeer.mvvmproject.data.remote.repository.MainRepository
import com.qadeer.mvvmproject.utils.ResourceStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {


    private val _userModel: MutableLiveData<ResourceStatus<ArrayList<UserModel>>> =
        MutableLiveData()
    val userModel: MutableLiveData<ResourceStatus<ArrayList<UserModel>>>
        get() = _userModel


    fun getUsers() {
        viewModelScope.launch {
            _userModel.postValue(null)

            mainRepository.getUserList().let {

                if (it.isSuccessful) {
                    _userModel.postValue(ResourceStatus.success(it.body()))

                } else if (it.code() == 401) {
                    _userModel.postValue(ResourceStatus.verify("UnAuthorized", it.body()))

                } else {
                    _userModel.postValue(ResourceStatus.error("UnAuthorized", it.body()))

                }


            }

        }

    }


}