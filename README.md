# Windsurf TDD Kata

## Overview

This workshop will let you experience a Test Driven Development (TDD) kata with an AI partner using the Windsurf Editor.

This was first delivered at Software Crafters Cambridge on 17th June 2025. [Information deck here](https://docs.google.com/presentation/d/1KsgAzaZjeCc_sMMs2U4QO8pqLuecuQJOK1frJ8lGau0/edit?usp=sharing).

The exercise is the bowling game kata and it is described in the [EXERCISE.md](EXERCISE.md) file.

## Prerequisites

To take part in this workshop, you will first need to:

* Download and install the latest version of Windsurf Editor for your machine from [https://windsurf.com/download](https://windsurf.com/download).
* To be temporally added to a paid Windsurf Enterprise account, please complete [this form](https://forms.gle/z5gGPxxU7Gv2TEtd8) although using Windsurf in trial mode may be enough.
* Clone this repository to your machine using `git clone https://github.com/danielvaughan/windsurf-tdd-kata`.
* Launch the Windsurf editor and open the cloned project.

The Windsurf Editor is based on [Visual Studio Code](https://code.visualstudio.com/) so you will also need to have the plugins and support loaded for preferred programming language and test framework.

## How it works

The repository contains a file called [.windsurfrules](.windsurfrules). This tells it a bit about TDD and how to act in this workshop. It also tells it about the exercise you are working on.

## Getting Started

On the right of the Windsurf editor, you will see Cascade. This has two modes "Write" and "Chat". Chat will behave like a chat window, while Write will allow Windsurf to write, edit and run code. Select "Write".

There is also the option to select from a list of models. For this exercise make sure you select "Gemini 2.5 Pro (promo)".

In the Write prompt box, ask Windsurf to create a new project using your chosen programming language and test framework. For example here I am using Java 21 and Junit.

```text
Create a new project to use to solve the Kata using Java 21 and Junit 5
```

All being well, LLMs are non-deterministic after all, Windsurf will set up the project and create a failing test for the exercise.
