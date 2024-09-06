GeonamesApi
GeonamesApi projesi, iki aşamadan oluşan bir veri işleme ve görüntüleme sistemidir.

Aşamalar
1. Aşama: Geonames Mikro Servisi
İlk aşamada, Geonames Mikro Servisi bulunur. Bu mikro hizmet, Geonames API'den veri alır ve bu verileri kendi içinde işleyerek sunar. İşlenen veriler iki ana kategoriye ayrılır:

EarthQuake: Deprem verileri
WikiSearch: Coğrafi veriler

2. Aşama: GeonamesApp
İkinci aşamada, GeonamesApp yer alır. Bu uygulama, Retrofit kullanarak Geonames Mikro Servisi'nden veri talep eder ve aldığı veriyi ekranda gösterir.
