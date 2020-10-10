# SimpleNem12Parser

## Task
* Expected duration: 3-4 hours
* Requires Java 8
* Solution can be in Java (preferably Java8) or Groovy

NEM12 is a file format used to represent meter read data from smart meters.

You are given a sample of a simplified version of the NEM12 file.  You are also given the domain model to represent the data in this file.  Here are more details.

Refer to comments for following files.
* `EnergyUnit.java`
* `MeterRead.java`
* `MeterVolume.java`
* `Quality.java`
* `SimpleNem12Parser.java`
* `TestHarness.java`

### SimpleNem12.csv format specifications
* You can assume, for this exercise, that no quotes or extraneous commas appear in the CSV data.
* First item on every line is the RecordType
* RecordType 100 must be the first line in the file
* RecordType 900 must be the last line in the file
* RecordType 200 represents the start of a meter read block.  This record has the following subsequent items (after RecordType).
You can assume each file does not contain more than one RecordType 200 with the same NMI.
  * NMI ("National Metering Identifier") - String ID representing the meter on the site, modelled in `MeterRead.nmi`.  Value should always be 10 chars long.
  * EnergyUnit - Energy unit of the meter reads, modelled in `EnergyUnit` enum type and `MeterRead.energyUnit`.
* RecordType 300 represents the volume of the meter read for a particular date.  This record has the following subsequent items (after RecordType).
  * Date - In the format yyyyMMdd (e.g. 20170102 is 2nd Jan, 2017).  Modelled in `MeterRead.volumes` map key.
  * Volume - Signed number value.  Modelled in `MeterVolume.volume`.
  * Quality - Represents quality of the meter read, whether it's Actual (A) or Estimate (E).  Value should always be A or E.  Modelled in `MeterVolume.quality`

Your tasks:
1. Write a list of any questions you would have to clarify these requirements.
 * The source of csv file? What is the time window the data file should arrive?
 * After data parsing, where should the output be sent to (i.e. destination) ? What is the time window the output should be sent out
 * How should the app handle exceptions /errors
   * if the csv is missing, invalid, or with corrupted data
   * if the first line of the data file is not 100, the last line of the data file is not 900, the meter read block does not start with 200, and/or the volume of the meter read does not start with 300 ?
   * if duplicate NMIs found in the same file?
   * if date format provided is incorrect?
   * if NMI provided is not equal to 10?
   * if the quality provided is not A or E ?
   * if the energy unit is not KWH? 
   
 * any NMI lookup or validation required ? Validation on NMI extinct, disconnect, abolished ?
 * On average, how many csv files to be processed per run ? The time it take on average ? With this information, you can run with the same settings to see if the app is performing or all. 


2. Create a new class (e.g. SimpleNem12ParserImpl) that implements interface `SimpleNem12Parser`.

How you implement this class and solve this problem is entirely up to you.
You can use any external libraries deemed suitable but be judicious and where necessary, provide 
clear instructions on how best to review your work.

You cannot modify SimpleNem12.csv.  Any changes to the provided domain model are fine though they shouldn't be necessary.

Please send your submission to gavin.brougham@redenergy.com.au either in a zip file or online source code sharing services such as GitHub or Bitbucket.
