## Similarities
 
- Build, test and deploy code changes, which in turn enables faster development cycles [^1], [^17]
- Allow developers to automate the process of integrating code changes[^17] from multiple team members [^1]
- Can deploy code to different environments such as: dev, staging (stage) and production (prod) [^1]
- Maintain code quality [^1], by running tests* and linters**.
- Keeping teams in sync [^1], by pushing internal libraries to a central server as soon they are finished

\* _such as [JUnit](https://junit.org/junit5/) in Java, [https://kotest.io/](https://kotest.io/) for Kotlin or [Rust Tests] https://doc.rust-lang.org/book/ch11-01-writing-tests.html_  
\** _such as SonarLint in Java, [Detekt](https://github.com/detekt/detekt) in Kotlin or [Clippy](https://github.com/rust-lang/rust-clippy) in Rust_


## Criteria

For the comparison I choose following criteria:

### Setup

The required effort or knowledge is an important criteria in an organisational context.
The longer you have to work on something, the more you have to pay your employees.
The more they need to know, the higher your employees need to be educated, and in turn their salary is higher.
If setup is long and complex you need more effort and knowledge than with a simple setup or no setup.
A complex setup usually comes with the benefit that the program is more powerful.
If this is desired or not, depends on the context.

### Price

Price is important factories for business, so it is important to keep it low.
Price here refers to the software itself and not additional costs for hosting.
This could be included, but an extensive price comparisons is out of scope, because there a lot of different
cloud providers. Price can vary a lot therefore.
A price range should be stated here.

### Vendor Lock in

Vendor lock in means that you are forced to use the software by the same vendor, instead of different ones.
This is usually not desired, because it limits the flexibility of switching to other products, if your requirements changes.

### Host Type

Host type refers to how the CI/CD is hosted. Self-hosted, cloud or both.
Some companies have very strict security guidelines or company secrets.
A cloud-hosted CI/CD could expose a risk for some companies

### Scaling

Scaling is important, because team size and company size can vary.
At a certain point, you need to scale your CI/CD properly.
A CI/CD cluster will differ significantly between a student group and large automobile manufacturer.
It should be stated how easy it is to scale and also mention price, if possible

### Extensibility

Extensibility refers to the possibility to customize CI/CD.
Some projects may require a certain software or in-house solutions.
In that case it is important to what extent CI/CD can be customized.

### Execution Model 

Execution Model explains the architecture and way of working.
This is important, because different projects may require different architecture.
An event-based architecture my draw too much performance when there are a lot of events. 

### Maintenance

Maintenance is important because CI/CD is setup once, and then maintained.
Maintenance means here how easy it is to debug or how much effort is required.

### Ease of use

Ease of use  means how easy it is to learn a CI/CD platform.
For small projects or prototypes a fast result may be important.
Usually, a steep learning curve implies more configuration.
So you have a trade-off between complexity and Ease of use

## General Overview

|       | GitHub                                                                                                                                                                                           | Jenkins                                                                  |
|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|
| Setup | Installation only required for self-hosted runners[^10], otherwise none                                                                                                                          | Installation required [^6]                                               
| Price | Free for standard GitHub-hosted runners in public repositories, and for self-hosted runners [^4] <br> For private repositories, GitHub Free offers 500MB storage and 2000 minutes per month [^4] | Free, but requires self hosting                                          |
| Vendor Lock in | Practically yes\*, you need to use GitHub                                                                                                                                                        | No, you can install it to different vendors [^6]                         
| Scaling |
| Extensibility | Huge community support and GitHub marketplace[^1], [^15]                                                                                                                                         | Through the Plugin index [^14]                                           
| Maintenance | Detailed logs and visual representations of workflows [^1], [^9]                                                                                                                                 | Yes, through BlueOcean [^11] or plugins like "Pipeline: Stage View"[^12] 
| Ease of use | GitHub provides templates [^13] and will automatically suggest these based on your repository code, no installion requierd | Easy to install [^16]                                                    | 

\* _Technically, nobody is stopping you from cloning a non-GitHub repository in a self-Hosted runner action_

## Feature Overview

### Testing on different machines/environments

If you are building a cross-platform program, you need to verify it works on different machines.
If you are using Rust, you also need to compile per architecture and operating system [^3]
Even when you are using Java, you need to verify your program on different machines, because issues my occur, like
line ending mismatch.

|                                            | GitHub Actions                | Jenkins |
|--------------------------------------------|-------------------------------| - |
| Integration with other platforms | Seamless integration wih GitHub | Compatible with popular DevOps tools like Maven, Gradle, Git, Docker, and Kubernetes.[^16], [^17] 
| Testing on different machines/environments | GitHub matrix strategies [^2] | Distributed builds* [^1], [^17]
| Scripting lanugage | YAML                          | Groovy

\* Although [^1] and [^17] state that distributed builds can do that, the Jenkins Documentation for Distributed builds is outdated [^18], but the updated one is still under [^19].

[^1]: https://testomat.io/blog/jenkins-vs-github-actions-which-cicd-tool-is-right/
[^2]: https://docs.github.com/en/actions/writing-workflows/choosing-what-your-workflow-does/running-variations-of-jobs-in-a-workflow#example-using-a-single-dimension-matrix
[^3]: https://forge.rust-lang.org/infra/other-installation-methods.html
[^4]: https://docs.github.com/en/billing/managing-billing-for-your-products/managing-billing-for-github-actions/about-billing-for-github-actions#about-billing-for-github-actions
[^5]: https://docs.github.com/en/actions/about-github-actions/understanding-github-actions#runners
[^6]: https://www.jenkins.io/doc/book/installing/
[^7]: https://github.com/jenkinsci/jenkins
[^8]: https://github.com/jenkinsci/jenkins/blob/master/LICENSE.txt
[^9]: https://docs.github.com/en/actions/writing-workflows/quickstart#viewing-your-workflow-results
[^10]: https://docs.github.com/en/actions/hosting-your-own-runners/managing-self-hosted-runners/adding-self-hosted-runners
[^11]: https://www.jenkins.io/doc/book/blueocean/#blue-ocean-overview
[^12]: https://plugins.jenkins.io/pipeline-stage-view/
[^13]: https://github.com/actions/starter-workflows
[^14]: https://plugins.jenkins.io/
[^15]: https://github.com/marketplace
[^16]: https://www.accelq.com/blog/what-is-jenkins-in-devops/
[^17]: https://dev.to/mcieciora/why-jenkins-is-still-mvp-among-cicd-tools-2npn
[^18]: https://wiki.jenkins-ci.org/display/JENKINS/Distributed+builds
[^19]: https://www.jenkins.io/doc/developer/distributed-builds/