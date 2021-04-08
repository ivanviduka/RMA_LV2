package layout

import Person
import java.util.*


object PersonRepository {

    val persons: MutableList<Person>


    init {

        persons = retrievePersons()
    }


    private fun retrievePersons(): MutableList<Person> {
        return mutableListOf(
            Person(1,"Dennis Ritchie", GregorianCalendar(1941, 9,9), "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Dennis_Ritchie_2011.jpg/220px-Dennis_Ritchie_2011.jpg",
                 "Creator of C programming language and UNIX operating system. He was awarded the Turing Award in 1983.",
                "UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity."),
            Person(2,"Linus Torvalds", GregorianCalendar(1969, 12, 28), "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg/220px-LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg",
                "Creator of Linux kernel and Git. He was awarded with Millennium Technology Prize in 2012.",
                "Intelligence is the ability to avoid doing work, yet getting the work done."),
            Person(3,"Mark Zuckerberg", GregorianCalendar(1984, 5, 14), "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg/220px-Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg",
                "Co-founder of Facebook and Breakthrough Starshot. At age 23, he became the world's youngest self-made billionaire.",
                "Move fast and break things. Unless you are breaking stuff, you are not moving fast enough."),
            Person(4,"Alan Turing", GregorianCalendar(1912, 6, 23), "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Alan_Turing_Aged_16.jpg/220px-Alan_Turing_Aged_16.jpg",
                "Creator of the Turing machine, which can be considered a model of a general-purpose computer.He is widely considered to be the father of theoretical computer science and artificial intelligence.",
                "Sometimes it is the people no one can imagine anything of who do the things no one can imagine."),
            Person(5,"Steve Jobs", GregorianCalendar(1955, 2, 24), "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Steve_Jobs_Headshot_2010-CROP2.jpg/220px-Steve_Jobs_Headshot_2010-CROP2.jpg",
                "The chairman, CEO and a co-founder of Apple Inc., NeXT and the chairman of Pixar. He was considered as a pioneer of personal computer revolution.",
                "Don’t let the noise of others’ opinions drown out your own inner voice.")
        )
    }


    fun get(id: Int): Person? = persons.find { person -> person.id == id }
    fun getSize(): Int = persons.size
    fun add(person: Person) = persons.add(person)
}