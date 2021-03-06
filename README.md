# Overview

<div style="text-align: center">

[![Build Status](https://travis-ci.org/astrapi69/lottery.svg?branch=develop)](https://travis-ci.org/astrapi69/lottery)
[![Coverage Status](https://codecov.io/gh/astrapi69/lottery/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/lottery)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/lottery.svg?style=flat)](https://github.com/astrapi69/lottery/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/lottery/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/lottery)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

</div>

The target of this project is to create random lottery results.

## Note

No animals were harmed in the making of this library.

# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this project, please consider a donation

over paypal: <br><br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" style="border: none" />
</a>
<br><br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over flattr:

<a href="http://flattr.com/thing/4152938/astrapi69lottery-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" style="border: none" />
</a>

## Key features:

* Calculate how much draws will be needed to win with the given lottery ticket
* Draw a lottery numbers in different algorithms
* Draw a super number
* Draw the number of the game seventy seven
* Draw of lottery numbers in a given number area and a given volume
* Summarize draw with a given counter map from already drawn lottery numbers

## License

The source code comes under a propriatary and confidential license. Unauthorized copying of this
software and its files, via any medium is strictly prohibited.

## Javadoc

[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/lottery-core.svg)](http://www.javadoc.io/doc/de.alpharogroup/lottery-core)
lottery-core

[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/lottery-data.svg)](http://www.javadoc.io/doc/de.alpharogroup/lottery-data)
lottery-data

## Maven dependency

Maven dependency is now available on sonatype. Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;quick~lottery) for latest
snapshots and releases.

You can first define the version properties:

	<properties>
			...
		<!-- LOTTERY versions -->
		<lottery.version>6.1</lottery.version>
		<lottery-core.version>${lottery.version}</lottery-core.version>
		<lottery-data.version>${lottery.version}</lottery-data.version>
			...
	</properties>

You can add the following dependencies to your project for use the functionality of lottery.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of lottery-core:

		<dependencies>
			...
			<!-- LOTTERY-CORE DEPENDENCY -->
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>lottery-core</artifactId>
				<version>${lottery-core.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import only the
lottery-data like algorithms, modes, paddings etc.:

		<dependencies>
			...
			<!-- LOTTERY-DATA DEPENDENCY -->
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>lottery-data</artifactId>
				<version>${lottery-data.version}</version>
			</dependency>
			...
		</dependencies>

## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of lottery:

define version in file gradle.properties

```
lotteryVersion=6.1
```

or in build.gradle ext area

```
ext {
			...
    lotteryVersion = "6.1"
			...
}
```

and than add the dependency to the dependencies area

```
dependencies {
			...
    implementation("de.alpharogroup:lottery-core:$lotteryVersion")
    implementation("de.alpharogroup:lottery-data:$lotteryVersion")
			...
}
```

## Semantic Versioning

The versions of lottery are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for lottery are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/lottery/fork](https://github.com/astrapi69/lottery/fork)

To share your
changes, [submit a pull request](https://github.com/astrapi69/lottery/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the lottery developers with your questions, concerns, comments, bug
reports, or feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/lottery/issues).

## Similar projects and links

* [github lottery project list](https://github.com/topics/lottery?o=desc&s=updated)

## Credits

|**Travis CI**|
|     :---:      |
|[![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png)](https://coveralls.io/github/astrapi69/lottery?branch=master)|
|Special thanks to [Travis CI](https://travis-ci.org) for providing a free continuous integration service for open source projects|
|     <img width=1000/>     |

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/lottery-core.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~lottery-core~~~) lottery-core|
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/lottery-data.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~lottery-data~~~) lottery-data|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**codecov.io**|
|     :---:      |
|[![Coverage Status](https://codecov.io/gh/astrapi69/lottery/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/lottery)|
|Special thanks to [codecov.io](https://codecov.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/lottery-core.svg)](http://www.javadoc.io/doc/de.alpharogroup/lottery-core) lottery-core|
|[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/lottery-data.svg)](http://www.javadoc.io/doc/de.alpharogroup/lottery-data) lottery-data|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
