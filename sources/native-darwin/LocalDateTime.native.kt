package io.fluidsonic.time

import platform.Foundation.*


public actual fun LocalDateTime.atTimeZone(timeZone: TimeZone): Timestamp {
	val components = toPlatformComponents()
	components.timeZone = timeZone.platform

	return platform_gregorianCalendar.dateFromComponents(components)!!.toCommon()
}


public actual fun LocalDateTime.toDayOfWeek(): DayOfWeek =
	atTimeZone(TimeZone.utc).toDayOfWeek(TimeZone.utc)


internal fun LocalDateTime.toPlatformComponents(): NSDateComponents {
	val components = NSDateComponents()
	components.year = date.year.toLong()
	components.month = date.month.toLong()
	components.day = date.day.toLong()
	components.hour = time.hour.toLong()
	components.minute = time.minute.toLong()
	components.second = time.second.toLong()
	components.nanosecond = time.nanosecond.toLong()
	return components
}
