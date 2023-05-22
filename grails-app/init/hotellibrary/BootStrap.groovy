package hotellibrary

class BootStrap {

    CountryService countryService
    HotelService hotelService

    def init = { servletContext ->
        countryService.saveCountry("США", "Вашингтон")
        countryService.saveCountry("Россия", "Москва")
        countryService.saveCountry("Чехия", "Прага")
        countryService.saveCountry("Китай", "Пекин")

        hotelService.saveHotel("Счастливый Пушкин", 4, "Россия")
        hotelService.saveHotel("Парус", 5, "Россия", "https://hotel-parus.com/")
        hotelService.saveHotel("Людмила", 2, "Россия")
        hotelService.saveHotel("Англетер", 4, "Россия", "https://www.angleterrehotel.ru/")
        hotelService.saveHotel("Марриотт Москва Гранд", 5, "Россия", "https://moscowgrandhotel.ru/")
        hotelService.saveHotel("Надежда", 1, "Россия")
        hotelService.saveHotel("Старый странник", 3, "Россия", "https://strannik-hotel.ru/")
        hotelService.saveHotel("Сьерра-Мадре", 5, "США")
        hotelService.saveHotel("Надежда", 2, "Россия")
        hotelService.saveHotel("Хьянцан", 3, "Китай")
        hotelService.saveHotel("Пиньцьян", 3, "Китай")
        hotelService.saveHotel("Адеба", 3, "Чехия", "http://www.adeba.cz/")
        hotelService.saveHotel("Мицьпоньхьян", 4, "Китай")
        hotelService.saveHotel("Рассел Эрскин", 3, "США")
        hotelService.saveHotel("Берег у реки", 3, "Россия")
        hotelService.saveHotel("Ружьё на вешалке", 2, "Россия")
        hotelService.saveHotel("Яблоко", 2, "Китай")
        hotelService.saveHotel("Син Хуа", 3, "Китай")
        hotelService.saveHotel("Бао Хонж", 4, "Китай")
        hotelService.saveHotel("Санья", 2, "Китай")
        hotelService.saveHotel("Гранд Моррис", 4, "США")
        hotelService.saveHotel("Шерегеш Изба", 4, "Россия", "https://изба-шерегеш.рф")
    }
    def destroy = {

    }
}
