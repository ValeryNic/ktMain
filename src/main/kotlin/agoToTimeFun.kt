package ru.netology

import java.lang.Exception

fun agoToText(friendName: String, lastTimeSec: Long, friendText:String ){
    //val infoFriend: String = when (lastTimeSec) {
    //    lastTimeSec < 60 -> "только что"
    //    lastTimeSec > 59 && lastTimeSec < 3600 -> oneTimeMin(lastTimeSec)
    //    lastTimeSec > 3599 && lastTimeSec < 60 * 60 * 24 - 1 -> oneTimeHours(lastTimeSec)
    //    lastTimeSec>60*60*24-1 && lastTimeSec<60*60*48-1 -> "вчера"
    //    lastTimeSec>60*60*48-1 && lastTimeSec< 60*60*72-1 -> "позавчера"
    //    else -> "давно"
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
fun myTransferCard(myTypeCard:String, amountSumm:Int, amount:Int) {
    //print("Введите сумму перевода в рублях = ")
    //val s = readln()
    //val amount = s?.toInt() ?: throw Exception ()
    if(myTypeCard=="Visa" || myTypeCard=="Мир") {
        val commition: Int = if (amount < 35) {
            0
        } else if (amount * 75 / 10000 < 35) {
            35
        } else {
            amount * 75 / 10000
        }
        //if (commition==0){
        //    println("Переводы в сумме менее 35 рублей не предоставляются!")
        //}
        if (amount > 150000) println("Превышен лимит перевода: 150_000 рублей")

        if ((amountSumm + amount)>600000) println("Превышен лимит ежемесячных переводов: 600_000 рублей")


    }
    if(myTypeCard=="VK Pay"){
        if(amount>15000) println("Превышен лимит перевода: 15_000 рублей")
        if((amount+amountSumm)>40000) println("Превышен лимит ежемесячных переводов: 40_000 рублей")
    }
}