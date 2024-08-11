package org.example;

public enum MetroLine {

    B1("B1: Halkalı - Gebze Suburban Line"),
    B2("B2: Halkalı - Bahçeşehir Suburban Line"),
    BRT("Bus Rapit Transit"),
    F1("F1: Taksim - Kabataş Funicular Line"),
    F2("F2: Karaköy - Beyoğlu Funicular Line"),
    F3("F3: Seyrantepe - Vadistanbul Funicular Line"),
    F4("F4: Boğaziçi Ü./Hisarüstü - Aşiyan Funicular Line"),
    M1A("M1A: Otogar - Atatürk Havalimanı Metro Line"),
    M1B("M1B: Yenikapı - Kirazlı Metro Line"),
    M2A("M2A: Sanayi Mah. - Seyrantepe Metro Line"),
    M2B("M2B: Yenikapı - Hacıosman Metro Line"),
    M3("M3: Kirazlı - Başakşehir Metro Line"),
    M4("M4: Kadıköy - Sabiha Gökçen Havalimanı Metro Line"),
    M5("M5: Üsküdar - Çekmeköy Metro Line"),
    M6("M6: Levent - Boğaziçi Ü./Hisarüstü Metro Line"),
    M7("M7: Yıldız - Mahmutbey Metro Line"),
    M8("M8: Bostancı - Parseller Metro Line"),
    M9("M9: Bahariye - Olimpiyat Metro Line"),
    M11("M11: Kağıthane - İstanbul Havalimanı Metro Line"),
    T1("T1: Kabataş - Bağcılar Tram Line"),
    T2("T2: Taksim - Tünel Heritage Tram"),
    T4("T4: Topkapı - Mescid'i Selam Tram Line"),
    T5("T5: Cibali - Alibeyköy Cep Otogarı Tram Line");

    private final String lineName;

    public String getLineName() {
        return lineName;
    }

    MetroLine(String lineName) {
        this.lineName = lineName;
    }
}
