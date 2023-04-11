Feature: us03
  Scenario: Database üzerinden languages tablosundan verilen Id numarasinin native degerinin istenen datayi
            dondurdugu dogrulanmali.(id=10, native=Bosanski)

    Given Database icin baglanti kurulur
    Then  Creates query for US_three
    And   The assertion operation is performed for US_three
    And   Database baglantisi basariyla kapatilir
