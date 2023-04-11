#/api/profile/countryStates endpoint'ine gecerli authorization bilgileri ve country id iceren bir GET request body
#gönderildiginde dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmali.
@US16
Feature: Api Status code message bilgisi
  Scenario: Status code message bilgisi
    Given Istenilen "api,profile,countryStates" endpoint adrsine gidilir
    Then  US_onalti_TC_sifiralti icin request body olusturulur
    And   US_onalti_TC_sifiralti icin response kaydeder
    And   Status Code 200 ve message "success" bilgileri assert edilir
    #/api/profile/countryStates endpointine gecerli authorization bilgileri ve country_id olarak 223  girilip Get
    # request body icerisinde gönderilince dönen response body'de id numarasi 3669 olan state'in "name" bilgisinin
    # Ankara" oldugunu dogrulanmali