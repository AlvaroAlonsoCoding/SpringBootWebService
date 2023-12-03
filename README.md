# Demo SpringBoot REST api for simple GET requests #

## How to run ##

## Data Model ##
	Embedded in memory H2 DDBB with CREATE-DROP schema handling
 	Schema creation is delegated to Hibernate based on JPA model classes
 	Data is inserted after schema creation by the use of the data.sql script
 	Two tables within:
   		BRAND - Containing brand data
   		PRICES - Containing price data for a given product and time period

## Repository ##
  	Two repositories, one per ddbb table
  	Both extending org.springframework.data.repository.CrudRepository
	  ProductPrices repository required a custom JPQL
  	Only demo's get methods are implemented

## Controller ##
  	Simple REST controller for the api request handling

## Tests ##
  	Integration testing covering the fifth requested api querying cases.
  	Each test validates the following JSON fields:
	     - productId
	     - brand.name
	     - startDate
	     - endDate
	     - price
