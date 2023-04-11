@us16
Feature: us16
  Scenario: Database üzerinden Users tablosundaki kayitli kullanicilari Soyad'larinin bas harfine göre listeleyebilmek
  istiyorum.(Örn: Soyadi A ile baslayan kisileri listele)

    Given Database icin baglanti kurulur
    Then  usonalti icin querry olusturulur
    Then  usonalti icin statement ile querry yollanir
    Then  statement ile donen onalti sorgusu dogrulanir
    And   Database baglantisi basariyla kapatilir




