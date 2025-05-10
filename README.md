# Wrangler Enhancements – Internship Assignment

This project is a fork of CDAP Wrangler, submitted for the Software Engineering Intern Assignment.

## 🚀 Features Implemented

- **Byte Size Parser:** Parses strings like `10MB`, `5GB`, `512KB` into byte values.
- **Time Duration Parser:** Parses strings such as `150ms`, `5s`, `2min` into milliseconds.
- **Aggregate Stats Directive:** A new directive `aggregate-stats` that computes statistics (sum, avg, min, max) over grouped data.
- **Expression Language & Schema Extensions:** Integrated the new types into the CDAP expression language and schema definition.

## 🛠 Setup & Run

### Prerequisites

- Java 17+
- Maven 3.8+

### Build

```bash
git clone https://github.com/sahilyelvantge/wrangler
cd wrangler
git checkout develop
mvn clean install
