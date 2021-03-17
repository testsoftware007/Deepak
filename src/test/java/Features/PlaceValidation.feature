Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
 Given Add Place Payload with "<name>" "<language>" "<address>"
 When User calls "PostPlaceAPI" with "post" http method
 Then The API call got success with status code 200
 And "status" in response body is "OK"
 And "scope" in response body is "APP"
 And verify place_id created maps to "<name>" using "GetPlaceAPI"
 
Examples:
 |name|language|address|
 |Kumar |English |Noida |
 #|Kumar1|English1|Noida1 |
 
@DeletePlace
Scenario: Verify that if delete place functionality is working fine
 
Given DeletePlace Payload
When User calls "DeletePlaceAPI" with "post" http method
Then The API call got success with status code 200
And "status" in response body is "OK"

