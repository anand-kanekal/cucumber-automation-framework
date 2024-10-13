Feature: Global Search
  Search desired content

Scenario: Search results are loaded when search text is entered
  Given the user is on Cucumber home page
  When the user clicks on search
  And enters search text
  Then search results should be loaded
