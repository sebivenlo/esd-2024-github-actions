# Exercise 3

This exercise will guide you how to build, verify and publish a Java project using Github Actions. 
Each task we will incrementally enhance the workflow.

## Creating the build job

The goal of this step is to build the Java app using a job.

### Requirements
- The workflow name should be "Java CI with Gradle"
- The workflow must run when pushing to branch "dev"
- The job must be called "build"
- The job should run on "self-hosted"

### Steps

- Checkout the source code
- Setup Java 17
- Execute `./gradlew build`
- Upload the results as artifacts

> [!TIP]
> Set a default working directory 
> 
> ```
> defaults:
>   run:
>     working-directory: <path>
> ```

> [!TIP]
> If `gradlew` cannot be execute, add
> ```
> - name: Make gradlew executable
>   run: chmod +x gradlew
> ```
>as step before.

## Creating the verify job

Now that the app is build, we need to verify the code.
Verify means running tests and checkstyle.

### Requirements
 - The job should run on your self hosted runner
 - The job must be called "verify"
 - The job must depend on "build"

### Steps

- Download the results from the previous job
- Setup Java 17
- Run the tests with `./gradlew test`
- Run the checkstyle with  `/gradlew checkstyleMain`
- Upload the results as artifacts

## Creating the publish job

In this job, we will upload our final Jar to a nexus repository server

### Requirements
 - The job must run on your self hosted runner
 - The job must be named "publish"
 - The job must depend on "verify"

> [!TIP]
> You can add secrets by clicking `Settings` > `Secrets and variables` > `Actions`.

### Preparation

- Add secrets to the github repository
  - Add a secret `REPO_USERNAME` with the value `admin`
  - Add a secret `REPO_PASSWORD` with the value `admin123`

### Steps

- Setup Java 17
- Download the results from the previous job
- Execute `./gradlew publish` and add ```env:
          ORG_GRADLE_PROJECT_dockerRepoUsername: ${{ secrets.REPO_USERNAME }}
          ORG_GRADLE_PROJECT_dockerRepoPassword: ${{ secrets.REPO_PASSWORD }}```

## Making a pull request

### Requirements

- The workflow should run when pushing on branch "prod", "dev" and "stage"
- The workflow should run when making a pull request on branch "prod", "dev" and "stage"

- Create a pull request from `dev` into `stage`
- Wait for all Github actions and `Merge pull request`
- Do the same for `stage` into prod