import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TarihFarki {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // İlk tarihi alma
        LocalDate ilkTarih = tarihAl("İlk tarihi (gg.aa.yyyy formatında) giriniz: ", scanner);

        // İkinci tarihi alma
        LocalDate ikinciTarih = tarihAl("İkinci tarihi (gg.aa.yyyy formatında) giriniz: ", scanner);

        // Tarih farkını hesaplama
        long gunFarki = Math.abs(ikinciTarih.toEpochDay() - ilkTarih.toEpochDay());
        long yilFarki = gunFarki / 365;
        long ayFarki = yilFarki * 12;

        // Sonuçları ekrana yazdırma
        System.out.println("Tarih Farkı: ");
        System.out.println("Gün: " + gunFarki);
        System.out.println("Ay: " + ayFarki);
        System.out.println("Yıl: " + yilFarki);
    }

    private static LocalDate tarihAl(String mesaj, Scanner scanner) {
        LocalDate tarih = null;
        do {
            try {
                System.out.print(mesaj);
                String tarihStr = scanner.nextLine();
                tarih = parseTarih(tarihStr);
            } catch (DateTimeException e) {
                System.out.println("Geçersiz tarih formatı. Tekrar deneyin.");
            }
        } while (tarih == null);
        return tarih;
    }

    private static LocalDate parseTarih(String tarihStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(tarihStr, formatter);
    }
}
