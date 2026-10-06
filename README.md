# java-dilinde-ozgecmis-hazirlayan-uygulama


Bu proje, Java programlama dili ve Object-Oriented Programming (OOP) prensipleri kullanılarak, kişiselleştirilmiş bir özgeçmiş (CV) belgesini PDF formatında oluşturan bir konsol uygulamasıdır.

## Proje Mimarisi ve Kullanılan Nesneler

Projede sorumlulukların ayrılması (Separation of Concerns) ve Nesne Yönelimli Programlama prensiplerine tam uyum sağlanmıştır.

### Kullanılan Sınıflar ve Nesnelerin Amacı:
1. **`Experience` (İş Deneyimi Modeli):**
   - **Neden Kullanıldı?** Adayın geçmiş iş deneyimlerini (şirket adı, pozisyon, süre, açıklama) veri yapısı olarak temsil etmek için kullanıldı. 
   - **Kapsülleme (Encapsulation):** Tüm alanlar `private` tutulmuş, verilere erişim `getter` metotları ile sağlanmıştır.

2. **`PersonalInfo` (Kişisel Bilgi ve Aday Modeli):**
   - **Neden Kullanıldı?** Adayın ad, unvan, e-posta, telefon, profil fotoğrafı yolu ve `List<Experience>` türünde iş deneyimlerini bir arada tutan ana veri modelidir.
   - **İlişki (Composition/Aggregation):** İçerisinde birden fazla `Experience` nesnesi barındırır.

3. **`ResumePdfGenerator` (PDF Oluşturucu Sınıf):**
   - **Neden Kullanıldı?** Ödev yönergesi gereği PDF oluşturma ve çizim mantığı `main` metodu içinde değil, sorumluluğu sadece belge üretmek olan ayrı bir sınıfta kurgulanmıştır.
   - **İşlevi:** `PersonalInfo` nesnesini girdi olarak alır ve `iText` kütüphanesini kullanarak sayfa düzeni, fotoğraf ekleme, tablo ve metin biçimlendirmelerini gerçekleştirir.

4. **`Main` (Uygulama Başlatıcı):**
   - **Neden Kullanıldı?** Uygulamanın giriş noktasıdır. Modelleri nesneleştirir (*instantiate* eder), hayali 3 iş deneyimini yükler ve `ResumePdfGenerator` sınıfını tetikler.

## Kullanılan Kütüphaneler
- **iTextPDF (`com.itextpdf:itextpdf:5.5.13.3`):** Java ortamında belgeleme, tablo yönetimi ve resim yerleştirme işlemlerini yönetmek amacıyla harici kütüphane olarak projeye dahil edilmiştir.

## Nasıl Çalıştırılır?
1. `Main.java` dosyasını çalıştırın.
2. Oluşan `Seymanur_Eke_Ozgecmis.pdf` dosyasını proje dizininden görüntüleyin.
