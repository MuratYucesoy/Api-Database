@us15
Feature: us15
  Scenario Outline:  Database üzerinden users tablosuna coklu kullanici ekleyebilmek istiyorum.

    Given Database icin baglanti kurulur
    Then  US_OnBes <id>,"<first_name>","<last_name>",<role_id>,"<password>" icin querry hazirlanir
    Then  Hazirlanan querryi statement araciligiyla yollar
    Then  Database baglantisi basariyla kapatilir
    Examples:
      |  id |first_name|last_name|role_id| password  |
      |10048|Cem       |Adrian     |1      |A1234qwer.e|
      |10049| David    |Neves      |3      |B32727dh.f |

