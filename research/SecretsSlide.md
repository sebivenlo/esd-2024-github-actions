# Understanding GitHub Secrets in CI/CD Workflows

## Overview of GitHub Secrets

> “Secrets and variables allow you to manage reusable configuration data. Secrets are encrypted and are used for sensitive data. (…) Variables are shown as plain text and are used for non-sensitive data.”  
> (GitHub Using Secrets, n.d.)

1. **Encryption**: Secrets are stored in an encrypted format, safeguarding sensitive data.  
2. **Plain Text Variables**: Non-sensitive variables appear in plaintext and can be viewed by anyone with the necessary repository access.  
3. **Permissions**: Anyone with collaborator access can utilize these secrets and variables in GitHub Actions. However, they are not passed to workflows triggered by pull requests originating from forks.

### Example Snippet

Below is an example of referencing secrets within a GitHub Actions workflow.(Using secrets in a workflow, n.d.)
```yaml
env:
  repo_Username: ${{ secrets.REPO_USERNAME }}
  repo_Password: ${{ secrets.REPO_PASSWORD }}
```

## Refrences

GitHub. (n.d.). Using secrets. Retrieved January 16, 2025, from https://docs.github.com/en/actions/security-for-github-actions/security-guides/using-secrets-in-github-actions#creating-secrets-for-a-repository

GitHub. (n.d.). Using secrets in a workflow. Retrieved January 16, 2025, from https://docs.github.com/en/actions/security-for-github-actions/security-guides/using-secrets-in-github-actions#using-secrets-in-a-workflow