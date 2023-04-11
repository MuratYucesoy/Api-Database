@us02
Feature: Us02
  Scenario: Database üzerinden seller_products tablosundaki discount_type degeri (1) olan tüm product'lari listelenmeli
  ve dogrulanmali.

    Given Database icin baglanti kurulur
    Then  USsifiriki icin query hazirlanir
    Then  Hazirlanan querry statement araciligiyla yollanir
    Then  Statement ile donen sifiriki verileri dogrulanir
    And   Database baglantisi basariyla kapatilir