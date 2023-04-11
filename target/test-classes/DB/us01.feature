@db01
Feature: Database
  Scenario: Database üzerinden Users tablosundaki first_name ve last_name'i verilen kullanicinin bilgilerinin döndügü
  dogrulanmali.(first_name= Admin, last_name=User)

    Given Database icin baglanti kurulur
    Then  Ussifirbir icin querry olusturulur
    Then  Ussifirbir icin querry yollanir
    And   Statement ile donen sifirbir verileri dogrulanir
    And   Database baglantisi basariyla kapatilir