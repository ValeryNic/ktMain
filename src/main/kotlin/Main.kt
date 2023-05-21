package ru.netology

import java.lang.Exception


fun main(args: Array<String>) {
    //Console con = System.console()

    println("Интересуетесь банковскими переводами? - нажмите 1")
    println("Затрудняетесь в написании числительных? - нажмите 2")
    println("Любите музыку и интересуетесь скидками? - нажмите 3")
    //val index: Int = Integer.parseInt(scanner.readLine())
    val s = readln()
    val i = s?.toInt() ?: throw Exception ()
    val active = true
    val summ = 14800
    when (i) {
        1 -> myTransfer()
        2 -> mySlang(511)
        3 -> myMusic(active, summ)
        else -> println("Ошибочный ввод")
    }
}
fun myTransfer() {
    print("Введите сумму перевода в рублях = ")
    val s = readln()
    val amount = s?.toInt() ?: throw Exception ()
    val commition: Int = if(amount<35) {
        0
    } else if (amount*75/10000<35){
        35
    } else {
        amount*75/10000
    }
    val transfer = if (commition==0){
        println("Переводы в сумме менее 35 рублей не предоставляются!")
    }else {
        println(commition)
    }
}
fun mySlang(likes: Int){
    val s: String = "лайк"
    val sEnd = endOfWord(likes)


    println ("Likes = $likes $s$sEnd")
}
fun endOfWord(likes: Int): String {
    val likesMin = if (likes>=100){
        likes%100
    }else{
        likes
    }
    val i = if (likesMin>=20) {
        likes % 10
    } else if (likesMin<20 && likesMin>5){
        5
    }
    else{likesMin}
    val sEnd: String = if (i==0 || i>4){
        "ов "
    } else if (i==1){
        " "
    } else {
        "а "
    }
    return sEnd

}
fun myMusic(active: Boolean, summ:Int){
    //var discountSumm: Int = 0
    val discountSumm: Int = if (summ < 10001 && summ > 1000) {
        100
    } else if (summ<1001) {
        0
    }
    else{
        summ*5/100
    }
    val discontActive: Int = if (active){
        (summ-discountSumm)/100
    } else {0}
    val discount=discountSumm+discontActive
    val price=summ-discount
    println("Заказ $summ руб., ваша скидка - $discount руб., к оплате $price руб.")
}





