#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Website Interaction Scenarios

 @TestCase1
  Scenario: Open URL, verify title, handle cookie popup, hover & click on "Our Stakeholders" and "Patients and Caregivers" link
    Given I open the URL "https://www.merillife.com/"
    When I close the cookie popup if present
    And I hover over Our Stakeholders link
     Then I click on Patients and Caregivers
    @TestCase3
  Scenario: Scroll to and click on the Angioplasty element
    When I scroll to and click on Angioplasty
    Then I should see the Angioplasty page
  @TestCase4
  Scenario: Click on Coronary Artery Disease link and switch to a new window
    When I am on the page with the Coronary Artery Disease link I click on the Coronary Artery Disease link
    Then I should be switched to a new window
  @TestCase5
  Scenario: Click on Bare-metal Stent link
     When I click on the Bare-metal Stent link
    Then I should be navigated to the new page and capture the screenshot
    @TestCase6
  Scenario: Click on Tech Specifications header and save the specifications to a file
    When I click on the Tech Specifications header
    Then The specifications should be saved to a file and a screenshot captured
@TestCase7
Scenario: Close child window, switch back to main window, and click links
    When I close the child window
    And I switch back to the main window
    And I hover over the Our Stakeholders links
    And I click the Patients And Caregivers links
    Then the Patients and Caregivers page should be opened
 @TestCase8
 Scenario: Click on the Coronary Artery Disease image
    When I scroll to the Coronary Artery Disease element and I click
    #Then the Coronary Artery Disease page should  opened
@TestCase9
Scenario: Click on the "Bare-metal stent" link again after returning to the main window
    When I click on the Bare-metal stents link
    And I click on the Vascular Intervention link
    Then I click on the Evermine50 drug link
    #Then I should be navigated to the Evermine50 drug page
 @TestCase10
 Scenario: Click on the Tech link
 When I click on the technical spec
 Then Capture the values   