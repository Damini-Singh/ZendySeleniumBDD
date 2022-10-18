Feature: Validation for Search and Download for Zendy application

Scenario: 1. Validate the landing page key elements

Given user is on zendy landing page 
Then user checks all the key buttons and links are visible

Scenario: 2. Validate user logs in and download the Ebook online

Given user is on zendy landing page
When user logs in to zendy application
Then user homepage is loaded with username
When user search for "Software quality assurance best practices" text
Then user is landed to search page with search results
And user selects download button for first option
And user is redirected to new page for downloading article.


Scenario: 3. Validate user logs in and read the Ebook

Given user is on zendy landing page
When user logs in to zendy application
Then user homepage is loaded with username
When user search for "Software quality assurance best practices" text
Then user is landed to search page with search results
And user selects read button for first option
And user is redirected to new page for reading article.
