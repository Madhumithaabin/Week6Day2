Feature: Leaftaps functionality

@functional
Scenario Outline: Test the createlead functionality
Given Click the CreateLead button
Given Enter the companyName as <CName>
Given Enter the FirstName as <FName>
Given Enter the LastName as <LName>
Given Enter the Phonenumber as <phoneno>
When Click the createlead button
Then New lead is created		
		Examples:
		| CName | FName | LName | phoneno |
		| 'HCL' | 'Madhumitha' |'Murugan' | '9840768866'|
		| 'IBM' | 'Priya' |'Sivaraan' | '9834368866'|
		| 'Accenture' | 'Thehjesh' |'Dinakaran' | '8840790866'|
		| 'HP' | 'Pradeep' |'Subramanian' | '9898767866'|

@smoke
Scenario: Test the deletelead functionality
Given Click the FindLeads link
And Click the phone button
And Enter the phonenumber as '99'
And Click the FindLeads button
When Records will be displayed in the table,capture the leadid from the first row
Then Click the first row leadid
And Click the delete button		
Given Click the FindLeads link
Given Enter the leadid as captured before
And Click the FindLeads button
Then Verify the record is deleted 
@regression
Scenario: Test the duplicatelead functionality
Given Click the FindLeadslink
And Click the phoneno button
And Enter the phoneno as '99'
And Click the FindLead button to check
Then Click the first row leadid when displayed
And Click the duplicate button		
Given Click the submit link
Then Duplicate lead is created

@sanity
Scenario: Test the editlead functionality
Given Click the FindLeads link to search
And Click the Phoneno Button
And Enter the phonenumber for edit as '99'
And Click the FindLeads button to fetch the details
Then Click the first row leadid when the result is displayed
And Click the editlead button		
Given Enter the company name as 'TCS'
When Click the submit button
Then lead is edited successfully
@smoke
Scenario: Test the mergelead functionality
Given Click the MergeLeads link
And Click the from search button
When New windows open,switch to new window
Then Enter the firstname as 'Gomathi'
And Click the FindLeadslink button to search
When Records will be displayed in the table,capture the leadid from the table
Then Click the first row leadid from the displayed table
When New windows closes,switch to old window
And Click the to search button
When New windows open,switch to new window
Then Enter the firstname as 'Smitha'
And Click the FindLeadslink button to search
Then Click the first row leadid from the displayed table
When New windows closes,switch to old window
And Click the merge button
When Alert appears accept it
And Click the FindLeads button to verify
Given Enter the lead as captured before		
And Click the FindLeadslink button to check
Then Verify if the data is merged
