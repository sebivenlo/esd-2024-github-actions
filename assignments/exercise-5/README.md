# Exercise 5: Run Unit Tests and Comment with GitHub Actions

In this exercise, you will create a workflow that runs unit tests for the provided Java Spring Boot project, and if the tests pass, posts a comment on the commit itself.

## Steps

### 1. Prepare the Java Spring Boot Project
The Java Spring Boot project is already provided in the exercise folder.

### 2. Create a Workflow Action
In the `.github/workflows/` directory, create a new file named `exercise-5.yml`.

### 3. Configure the Workflow
- **Name the Workflow**: `"Test and Comment"`.
- **Trigger the Workflow**: Set it to run on `push` events.
  - **Add the Following Steps**:
      1. **Checkout the Repository Code**:  
         Use `actions/checkout@v3`.
      2. **Set Up JDK**:  
         Use `actions/setup-java@v3` to set up JDK (e.g., Java 17).
      3. **Compile Project**:  
         Run:
         ```bash
         mvn compile
         ```
      4. **Run Unit Tests**:  
         Execute:
         ```bash
         mvn test
         ```
      5. **Implement Conditional Logic**:  
         Use:
         ```yaml
         if: ${{ success() }}
         ...
         ...
         ...
       
         ```
         to check if the tests have passed.
      6. **Post a Comment on the Commit**:  
         Use `actions/github-script@v6` to post a comment indicating success.
         with this code:
      ```yaml
      script: |
        const commit_sha = context.sha;
        await github.repos.createCommitComment({
        owner: context.repo.owner,
        repo: context.repo.repo,
        commit_sha: commit_sha,
        body: '✅ All unit tests passed successfully!',
        });

### 4. Verify the Workflow
1. **Commit and Push Changes**:  
   Make sure to commit and push the `exercise-5.yml` file to trigger the workflow.
2. **Observe Workflow Execution**:  
   Go to your GitHub repository and click on the "Actions" tab to see the workflow run details.
3. **Check the Commit for the Comment**:  
   Navigate to the commit to verify if a comment has been posted indicating that the tests passed.

## Tips

### Permissions
Ensure your workflow has the necessary permissions to post comments by including:
    
    
        permissions:
            contents: write

[Next Exercise](../exercise-6/README.md)