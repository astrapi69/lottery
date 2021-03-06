## Change log
----------------------

Version 6.2-SNAPSHOT
-------------

CHANGED:

- update of gradle to new version 7.0
- update of dependency lombok version to 1.18.20
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.38.0

Version 6.1
-------------

ADDED:

- new bean class DrawModelBean that contains data that can be used for the draw of lottery numbers
- new methods with the new bean class DrawModelBean as argument created

CHANGED:

- update of dependency lombok version to 1.18.18
- update of gradle to new version 6.8.3

Version 6
-------------

ADDED:

- added new dependency commons-math3 in version 3.6.1
- new method for get all possible combination of two boxes with different number of combination
  sizes
- new method for calculate the count of all possible combination of two boxes with different number
  of combination sizes

CHANGED:

- update of dependency lombok version to 1.18.16
- update of gradle to new version 6.7
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.33.0
- change provider of code coverage to codecov.io
- update of dependency jobj-core version to 3.6
- update of dependency silly-math version to 1.3
- update of dependency randomizer version to 8
- update of dependency silly-collections version to 8.3
- update of test dependency testng to new version 7.3.0
- increase code coverage

Version 5.10
-------------

ADDED:

- new estimation class for calculate the winning categories
- new class for resolve all possible combinations with algorithm for
    - count all possible combinations
    - get all possible combinations as a list of lists
- new method for resolve lottery numbers with a default most drawn comparator
- new method for draw from multimap with an existing number counter map

CHANGED:

- changed visibility of method mergeDrawings from private to public
- update gradle to new version 6.6.1
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
