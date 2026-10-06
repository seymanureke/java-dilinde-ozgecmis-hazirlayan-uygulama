public class Main {
    public static void main(String[] args) {
        // Kişisel bilgilerin oluşturulması
        PersonalInfo candidate = new PersonalInfo(
                "Şeymanur Eke",
                "Yazılım Mühendisi",
                "seymanur.eke@example.com",
                "+90 555 123 4567",
                "C:\\Users\\Şeymanur Eke\\Desktop\\ceb83c69-6653-41b0-b865-22413012ae89.jpg"
        );

        // Ödev Yönergesi Gereği: Hayali 3 İş Deneyimi
        candidate.addExperience(new Experience(
                "Tech Solutions A.Ş.",
                "Junior Software Developer",
                "2023 - 2024",
                "Java Spring Boot mimarisi ile RESTful servisler geliştirildi ve birim testleri yazıldı."
        ));

        candidate.addExperience(new Experience(
                "VeriViz Sistemleri",
                "Yazılım Stajyeri",
                "2022 - 2023",
                "Veritabanı optimizasyonu ve PostgreSQL sorgularının iyileştirilmesi süreçlerinde yer alındı."
        ));

        candidate.addExperience(new Experience(
                "InnoSoft Laboratuvarı",
                "Öğrenci Araştırmacı",
                "2021 - 2022",
                "C ve Java dilleri kullanılarak veri yapıları ve algoritma analizi üzerine çalışmalar yürütüldü."
        ));

        // PDF İşlemlerinin Yönerge Gereği Ayrı Sınıfta (ResumePdfGenerator) Yürütülmesi
        ResumePdfGenerator generator = new ResumePdfGenerator(candidate);
        generator.generatePdf("Seymanur_Eke_Ozgecmis.pdf");
    }
}