# Exercise 4: Deploy a Static Site with GitHub Actions

In this exercise, you will create a workflow that uses **GitHub Pages** to deploy a static site online.

## Steps

### 1. Prepare the Static Site

The `index.html` file is already provided in the `exercise` folder.

---

### 2. Create a Workflow Action

1. In the `.github/workflows/` directory, create a new file named `exercise-4.yml`.

---

### 3. Configure the Workflow

1. **Give the workflow a name**: `"Deploy Static Site"`.
2. **Trigger the workflow**: Set it to run when pushing to the `main` branch.
3. **Add the following steps**:
   - Checkout the repository code using `actions/checkout@v3`.
   - Deploy to GitHub Pages using `peaceiris/actions-gh-pages@v3`.
   - Set the `publish_dir` to point to the `exercise` directory (where `index.html` is located).

---

### 4. Set Up GitHub Pages
1. Create a branch with the name **gh-pages** if not present
2. Go to your repository **Settings**.
3. Select **Pages** and select the **Source** to be Deploy from a branch
4. Set the branch to the `gh-pages` branch with root.

---

## Tips

- The `peaceiris/actions-gh-pages@v3` action simplifies deployment by handling the publishing process.
- Make sure to commit and push the `exercise-4.yml` file to trigger the workflow.

---

Good luck, and happy coding!
[Next Exercise](../exercise-5/README.md)