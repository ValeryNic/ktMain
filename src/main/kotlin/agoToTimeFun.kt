package ru.netology

import java.lang.Exception
import kotlin.math.max

fun agoToText(friendName: String, lastTimeSec: Long, friendText:String ){
    var infoFriend:String = " "
    if (lastTimeSec < 60) infoFriend="только что"
    else if(lastTimeSec > 59 && lastTimeSec < 3600) infoFriend=oneTimeMin(lastTimeSec)
    else if(lastTimeSec > 3599 && lastTimeSec < 60 * 60 * 24 - 1) infoFriend=oneTimeHours(lastTimeSec)
    else if(lastTimeSec>60*60*24-1 && lastTimeSec<60*60*48-1) infoFriend="вчера"
    else if(lastTimeSec>60*60*48-1 && lastTimeSec< 60*60*72-1) infoFriend="позавчера"
    else infoFriend="давно"
    println("$friendName был\"(а)\" $infoFriend\":\" $friendText")
}
fun oneTimeMin(lastTimeSec: Long):String {
    val lastMin:Long = lastTimeSec/60
    val endLasdtMin: String = ru.netology.endOfWord(lastMin, "минуту", "минуты", "минут")

    return "$lastMin $endLasdtMin назад"
}
fun oneTimeHours(lastTimeSec: Long):String {
    val lastHours: Long = lastTimeSec/3600
    val endLastHours: String = ru.netology.endOfWord(lastHours, "час", "часа", "часов")
    return "$lastHours $endLastHours назад"
}
fun myTransferCard(myTypeCard:String, amountSumm:Int, amount:Int): Int {
    val Error_Type=-1
    val Error_Limit=-2
    return when(myTypeCard) {
        "Mastercard", "Maestro" -> if(amount+amountSumm>75_000) (amount*0.006+20).toInt() else 0
        "Visa", "Мир" -> if(amount<=150_000 || amount+amountSumm<=600_000) max(35, (amount*0.0075).toInt()) else Error_Limit
        "VK Pay" -> if(amount<=15_000 || amount+amountSumm<=40_000) 0 else Error_Limit
    else -> Error_Type
    }
}