# Template for WIA2007 Finals
Either use the created template while creating the app, or perform the following GitHub commands to get to know better on what changed to allow for the creation of certain template

First perform:
```
git log
```
This should let you see all the commits that contribute to a certain template being created, pick the template that you are interested in, copy the commit hash, and perform the following:
```
git checkout <CommitHash>
```
Replace the `<CommitHash>` with your commit of choice followed by:
```
git reset --soft HEAD~
```
open in VSCode and see the files changed. After inspection is done, simply do the following to reset to the latest version and perform the previous steps again when necessary. Run the command to make the repo up to date
```
git reset
git checkout .
git clean -df
git checkout master
```

## Sequence of creation and changes to take note

-   Activity
    -   ActivityTemplate.java
    -   AndroidManifest.xml
    -   MainActivity.java
