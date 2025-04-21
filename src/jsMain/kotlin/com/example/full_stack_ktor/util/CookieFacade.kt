package com.example.full_stack_ktor.util

import kotlinx.browser.document
import kotlin.js.Date

object CookieFacade {
	
	/**
	 * Lấy cookie theo tên (không mã hóa).
	 */
	fun getCookie(name: String): String? {
		val cookies = document.cookie.split("; ")
		for (cookie in cookies) {
			val parts = cookie.split("=")
			if (parts.size == 2 && parts[0] == name) {
				return parts[1]
			}
		}
		return null
	}
	
	/**
	 * Gán cookie với thời hạn tính bằng số ngày.
	 */
	fun setCookie(name: String, value: String, days: Int) {
		var date = Date()
		val milliseconds = days * 24 * 60 * 60 * 1000
		date = Date(date.getTime() + milliseconds)
		val expires = "expires=${date.toUTCString()}"
		document.cookie = "$name=$value; $expires; path=/"
	}
	
	/**
	 * Xoá cookie bằng cách đặt ngày hết hạn trong quá khứ.
	 */
	fun deleteCookie(name: String) {
		document.cookie = "$name=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/"
	}
}
