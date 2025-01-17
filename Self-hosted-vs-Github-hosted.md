# Self-Hosted Runners vs. GitHub-Hosted Runners

In github actions there machine which have the name runners that execute jobs in a Github Actions workflows.(GitHub Runners, n.d.) 
GitHub provides runners that can be used to run jobs, or the runner can be hosted on the user's machine. Depending on organizational needs, one may use GitHub-hosted runners (provided and maintained by GitHub) or self-hosted runners (provisioned and managed by the user). This here is a comparison between them.(Github Overview, n.d)

## GitHub-Hosted Runners

- **Managed by GitHub.**  
  GitHub is responsible for provisioning, maintaining, and updating the runners. (Github-hosted runners, n.d)
  
- **Pre-Installed Tools.**  
  Comes with pre-installed tools. (Github Overview, n.d)

- **Ease of Use.**  
  Straightforward to set up; ideal for quick onboarding without additional infrastructure overhead. (Medan, 2022, “Downsides of Self-Hosted Runners,” para. 2).

- **Resource Limitations.**  
  The runners come with predefined hardware resources which limits performance for heavier workloads.(GitHub, n.d., About GitHub-hosted runners ).

- **Scenarios.**  
  Best suited for most typical CI/CD pipelines, especially when minimal customization is required. For small teams without a dedicated DevOps engineer, a GitHub-hosted solution simplifies setup and maintenance, allowing teams to focus more on software development (Medan, 2022,“ Tips and recommendations for choosing the right runners” ).

## Self-Hosted Runners

- **Managed by You.**  
  The user is responsible for hosting, configuring, and maintaining the runners. As noted in the GitHub documentation, self-hosted runners allow users to customize the hardware, operating system, and software tools but require them to handle updates, configurations, and system maintenance (GitHub, n.d., “Self-hosted runners management”) unlike the Github-hosted runners.

- **Custom Environment.**  
  Offers complete control to install specific tools and fine-tune system resources. As GitHub (n.d.) notes, self-hosted runners allow users to "install software available on your local network, and choose an operating system not offered by GitHub-hosted runners."

- **“Unlimited” Resources.**  
  Self-hosted runners are not limited to the restrictions of the GitHub-hosted runners. They can use as much of the host hardware as they need or are configured to. (Medan, 2022,“Benefits of self-hosted runners” )

- **Cost Savings.**  
  Self-hosted runners reduce expensive if there is an available infrastructure to be used on since they are free to use unlike GitHub-hosted runners, which operate on a pay-per-minute pricing model.(GitHub, n.d., “Cost Savings”)


- **Scenarios.**  
  Ideal for large workloads or if an operating system not part of the ones which Github actions offers is needed. Self-hosted runners are great if the code base has processes that are very multithreaded. Additionally self-hosted runners are securer since they are running on the network of the user.(Medan, 2022, “Tips and recommendations for choosing the right runners”, ).



---

## References
GitHub. (n.d.). Using secrets. Retrieved January 16, 2025, from https://docs.github.com/en/actions/security-for-github-actions/security-guides/using-secrets-in-github-actions#creating-secrets-for-a-repository

Github. (n.d.) Runners (https://docs.github.com/en/actions/about-github-actions/understanding-github-actions#runners)

Github. (n.d.) Overview (https://docs.github.com/en/actions/using-github-hosted-runners/using-github-hosted-runners/about-github-hosted-runners#overview-of-github-hosted-runners)


GitHub. (n.d). *About self-hosted runners*. [https://docs.github.com/en/actions/using-github-hosted-runners/using-github-hosted-runners/about-github-hosted-runners#overview-of-github-hosted-runners](https://docs.github.com/en/actions/using-github-hosted-runners/using-github-hosted-runners/about-github-hosted-runners#overview-of-github-hosted-runners)


GitHub. (n.d). *Self-hosted runners management*.
https://docs.github.com/en/actions/hosting-your-own-runners/managing-self-hosted-runners/about-self-hosted-runners#about-self-hosted-runners

GitHub. (n.d.) Github-hosted runners. (https://docs.github.com/en/enterprise-server@3.10/actions/using-github-hosted-runners/using-github-hosted-runners/about-github-hosted-runners#overview-of-github-hosted-runners)


Medan, E. (2022, November 8). Choosing GitHub runners vs self-hosted runners. *Arnica*. https://www.arnica.io/blog/choosing-github-runners-vs-self-hosted-runners


GitHub. (n.d.). About GitHub-hosted runners. GitHub Documentation. Retrieved January 16, 2025, from https://docs.github.com/en/actions/using-github-hosted-runners/using-github-hosted-runners/about-github-hosted-runners


GitHub. (n.d.). Cost Savings. GitHub Documentation. Retrieved January 16, 2025, from
https://docs.github.com/en/actions/hosting-your-own-runners/managing-self-hosted-runners/about-self-hosted-runners#differences-between-github-hosted-and-self-hosted-runners