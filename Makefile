# Clean results of previous build: Generate executable archive
install:
	./gradlew clean install

# Run executable file (do this after install)
run-dist:
	./build/install/app/bin/app

# Run file with diff
run-diff-json:
	./build/install/app/bin/app file1.json file2.json
run-diff-yml:
	./build/install/app/bin/app filepath1.yml filepath2.yml

# Check updates for dependencies (libraries; plugins from build.gradle)
check-updates:
	./gradlew dependencyUpdates

# Compile project and run from console
run:
	./gradlew clean
	./gradlew run

# Check code-style
lint:
	./gradlew checkstyleMain

# Execute install tasks + another tasks
build:
	./gradlew clean build

# For Jacoco test coverage with CodeClimate in main.yml
report:
	./gradlew jacocoTestReport

.PHONY: build