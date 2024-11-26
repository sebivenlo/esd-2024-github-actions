# Exercise 1

1. Fork this repository
2. Go to repository `Settings > Actions > Runners` and click on `New self-hosted-runner`
3. Select Linux and scroll down to `Configure` section.
4. Extract `--url <url>` and `--token <token>`
    - Example: `$ ./config.cmd --url https://github.com/evl-8/github-action-demo --token 
  ABCDEFIGHIJKLMNOPQRSTUVW12345` extracts to  
  `Url: https://github.com/evl-8/github-action-demo` and
  `Token: ABCDEFIGHIJKLMNOPQRSTUVW12345`
5. Run the command <br> `docker run --name github-actions-runner -e URL=<url> -e TOKEN=<token> github-actions-runner`