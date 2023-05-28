package ru.netology

class CommitionTest {
    @Test
    fun commitionVisa() {
        val card = "Visa"
        val transfer = 10000
        val previous = 0
        val result = comission(myTypeCard=card, amount=transfer,pref=previous)
        assertEquols(75,result)
    }
}