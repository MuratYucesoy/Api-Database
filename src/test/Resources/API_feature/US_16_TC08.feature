#When a GET request body with valid authorization information and state_id is sent to the /api/profile/stateCities
#endpoint,it should be verified that the status code returned is 200 and the message information is "success".

Feature: Api Status code message bilgisi
  Scenario: Status code message bilgisi
    Given Istenilen "api,profile,stateCities" endpoint adrsine gidilir
    Then  US_onalti_TC_sifirsekiz icin request body olusturulur
    And   US_onalti_TC_sifirsekiz icin response kaydeder
    And   Status Code 200 ve message "success" bilgileri assert edilir