@wip
Feature: us15
  Scenario:
    Given Database icin baglanti kurulur
    Then  Us_onbes icin 2 yeni insert info querry hazirlanir
    Then  Assertion islemi yapilir
    And   Database baglantisi basariyla kapatilir
