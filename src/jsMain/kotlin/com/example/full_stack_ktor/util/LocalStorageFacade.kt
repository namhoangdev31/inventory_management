package com.example.full_stack_ktor.util

import com.example.full_stack_ktor.model.AuthLoggedInUserDto
import kotlinx.browser.localStorage

object LocalStorageFacade {
	const val KEY_ACCESS_TOKEN = "app_access_token"
	const val KEY_USER_DATA = "app_user_data"
	const val KEY_CMS_ACCESS_TOKEN = "cms_access_token"
	const val KEY_CMS_USER_DATA = "cms_user_data"
	fun saveAccessToken(accessToken: String) {
		localStorage.setItem(KEY_ACCESS_TOKEN, accessToken)
	}
	
	fun getAccessToken(): String? {
		return localStorage.getItem(KEY_ACCESS_TOKEN)
	}
	
	fun deleteAccessToken() {
		localStorage.removeItem(KEY_ACCESS_TOKEN)
	}
	
	fun saveUserData(userData: AuthLoggedInUserDto) {
		localStorage.setItem(KEY_USER_DATA, JSON.stringify(userData))
	}
	
	fun getUserData(): AuthLoggedInUserDto? {
		val authData = localStorage.getItem(KEY_USER_DATA);
		return authData?.let {
			JSON.parse<AuthLoggedInUserDto>(it)
		}
	}
	
	fun deleteUserData() {
		localStorage.removeItem(KEY_USER_DATA)
	}
	
	fun saveCmsAccessToken(accessToken: String) {
		localStorage.setItem(KEY_CMS_ACCESS_TOKEN, accessToken)
	}
	
	fun getCmsAccessToken(): String? {
		return localStorage.getItem(KEY_CMS_ACCESS_TOKEN)
	}
	
	fun deleteCmsAccessToken() {
		localStorage.removeItem(KEY_CMS_ACCESS_TOKEN)
	}
}