Feature: ServiceNow functionality
@functional	
Scenario: ServiceNow Delete Functionality
Given Click Open Button
When New frame is opened
Then Click the first row from the table
And capture the incident number for the deletion
When Click the delete button
Then click the okay button in the alert
And Closed the frame
Given Click Open Button
When New frame is opened
Then Enter the incident Number stored and search the details
And Verify if the incident is deleted 



@smoke
Scenario Outline: Create a New Incident
Given Click the All button
When New frame opens
Given Click the New button
Given Click the Caller Id button
Then Close the frame is open
When New window open
Then Click the first person name
Given switch back to normal window
When New frame opens
Given Enter the decription as <Description>
And capture the incident number
When click the submit button
Then Close the frame is open
When New frame opens
Given Enter the captured incident number in the search number
When Details is displayed capture the Incident number displayed
Then verify the incident is created

Examples:
	| Description|
	| 'Openlab incident' |
	| 'IBM incident' |
	| 'Access  Issue' |
	
@smoke
Scenario: ServiceNow Incident Functionality
Given Click Open Button to search incident
When New frame will be opened
Then Click the first row from the displayed records
Given capture the Incindent number for verification
When Click the incident Assignment group search button
Then New frame will be closed
When New window in opened
Given Enter s to search group
When Click the software assignment group
Then switch back to old window
When New frame will be opened
Given Enter the worknotes 
When Click the Assign button
Then New frame will be closed
When New frame will be opened
Given Enter the incident number to check
Then captures the result for the search
And verify if the incident assigned properly

@functional
Scenario: ServiceNow Update Functionality
Given Click Open Button to update incident
When Frame will be opened
Then Click the first row from the displayed records to update
Given Capture the Incindent number for confirm the updation
Then Select the urgency as high
And Select the status as improgress
Then Click the update button
And Frame will be closed
Given Click All Button to updated incident
When Frame will be opened
And Select the type of request as number
Given Enter the captured incident for the verification
Then Capture the urgency and status of the incident
And verify if the data is properly updated