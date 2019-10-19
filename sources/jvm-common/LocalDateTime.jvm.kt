package io.fluidsonic.time


actual fun LocalDateTime.atTimeZone(timeZone: TimeZone): Timestamp =
	toPlatform().atZone(timeZone.toPlatform()).toInstant().toCommon()


actual fun LocalDateTime.toDayOfWeek() =
	PlatformDayOfWeek.from(toPlatform()).toCommon()


fun LocalDateTime.toPlatform(): PlatformLocalDateTime =
	PlatformLocalDateTime.of(
		date.year.toInt(),
		date.month.toInt(),
		date.day.toInt(),
		time.hour.toInt(),
		time.minute.toInt(),
		time.second.toInt(),
		time.nanosecond.toInt()
	)


fun PlatformLocalDateTime.toCommon() =
	LocalDateTime.of(
		year = year.toLong(),
		month = monthValue.toLong(),
		day = dayOfMonth.toLong(),
		hour = hour.toLong(),
		minute = minute.toLong(),
		second = second.toLong(),
		nanosecond = nano.toLong()
	)
