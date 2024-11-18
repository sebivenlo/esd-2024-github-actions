#import "callouts.typ": *

#let calibri = "Calibri"
#let arial = "Arial"

#let fontSize = 11pt;

#set text(
  region: "en",
  lang: "en", // meta info für typst
  font: calibri,
  size: fontSize
)

= Prerequisites

- Git installed on your machine
- A GitHub account
- Docker Desktop installed
- VS Code installed

#show link: set text(fill: blue)
#show link: underline

#let named(content) = {
  box(
    fill: gray.lighten(50%), 
    outset: 0.1em, 
    text(
      font: "DejaVu Sans Mono", 
      weight: "black",
      size: fontSize - 1pt, 
      content
    )
  )
} 

#set heading(numbering: "1 a)")

= Assignment

== Task

1. Go to the #link("https://github.com/evl-8/esd-github-actions-assignment")[https://github.com/evl-8/esd-github-actions-assignment] repository

2. Fork the repository

3. Got to repository #named[Settings > Actions > Runners] and click on #named[New self-hosted-runner]

4. Select #named[Linux] and scroll down to the #named[Configure] section.

5. Extract `--url <url>` and `--token <token>` 

#example[
  ```
  # Create the runner and start the configuration experience
  $ ./config.cmd --url https://github.com/evl-8/github-action-demo --token DHE5AGH6AWKB5LQLTETAQE7MX7GQS
  # Run it!
  $ ./run.cmd

  Extracts to 

  Url: https://github.com/evl-8/github-action-demo
  Token: DHE5AGH6AWKB5LQLTETAQE7MX7GQS
  ```
]

== Task



= Assignment

= Assignment

= Assignment