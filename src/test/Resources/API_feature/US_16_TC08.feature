#/api/profile/stateCities endpoint'ine gecerli authorization bilgileri ve state_id iceren bir GET request body
# gönderildiginde dönen status code'in 200 ve message bilgisinin "success" oldugu dogrulanmal
@US16
Feature: Api Status code message bilgisi
  Scenario: Status code message bilgisi
    Given Istenilen "api,profile,stateCities" endpoint adrsine gidilir
    Then  US_onalti_TC_sifirsekiz icin request body olusturulur
    And   US_onalti_TC_sifirsekiz icin response kaydeder
    And   Status Code 200 ve message "success" bilgileri assert edilir