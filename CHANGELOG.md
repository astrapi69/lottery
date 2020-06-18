## Change log
----------------------

Version 5.11-SNAPSHOT
-------------



Version 5.10
-------------

ADDED:

- new estimation class for calculate the winning categories
- new class for resolve all possible combinations with algorithm for 
    - count all possible combinations
    - get all possible combinations as a list of lists

CHANGED:

- update gradle to new version 6.5
- extracted project properties to gradle.properties
- update of dependency jobj-compare version to 3.6.1

Version 5.9
-------------

ADDED:
 
- gradle as build system
- new factory method for create a map for count drawn numbers and can summarized with a given Map
- new dependency silly-beans in minor version 1.1 added

CHANGED:

- removed maven related files
- changed project nature from maven to gradle nature
- update of dependency silly-collections version to 8.1
- update of dependency randomizer version to 6.7
- update of test dependency testng version to 7.1.0
- removed all lombok dependent imports
- removed lombok dependency

Version 5.8
-------------

ADDED:
 
- new dependency of silly-beans in version 1 added

CHANGED:

- update of parent version to 5.4
- update of dependency silly-collections major version to 5.8
- update of dependency randomizer version to 6.5
- moved class-diagramm to test resources

Version 5.7
-------------

ADDED:
 
- new dependency of jobj-compare in version 3.2 added
- new method created for drawing with a multimap
- new method created for drawing in paranoid manner with a multimap 

CHANGED:

- update of randomizer version to 6.4
- update of silly-collections version to 5.5.1

Version 5.6
-------------

CHANGED:

- update of parent version to 5.3
- update of randomizer version to 6.3
- update of silly-collections version to 5.4.1
- extracted enum LotteryAlgorithm to own class file

Version 5.5.1
-------------

CHANGED:

- changed jdk from oraclejdk8 to openjdk8 in .travis.yml

Version 5.5
-------------

ADDED:
 
- new dependency of jobj-contract-verifier in version 3.2 added

CHANGED:

- update of parent version to 5
- update of dependency silly-collections version to 5.2.1
- update of randomizer version to 6.0.1

Version 5.4
-------------

CHANGED:

- update of parent version to 4.5
- update of dependency silly-collections version to 5.1
- update of jobject-extensions version to 2.5
- update of randomizer version to 5.6

Version 5.3
-------------

CHANGED:

- update of parent version to 4.2
- update of dependency silly-collections version to 4.35
- update of jobject-extensions version to 2.2
- update of randomizer version to 5.4
- removed unneeded .0 at the end of version

Version 5.2.0
-------------

ADDED:
 
- moved all lottery classes from project randomizer to this project
- created two new projects core and data
