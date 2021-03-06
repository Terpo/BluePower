# BluePower

Blue Power is a collaborative effort to revive some of the things that are missing from previous versions of modded Minecraft.

## Installing

1. Clone into an empty directory using your git client of choice.
2. Import into the IDE of choice
* Eclipse:
     1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
     2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
        or run "gradlew eclipse" to generate the project.

* IntelliJ:
     1. Open IDEA, and import project select the build.gradle file and have it import.
     2. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
     3. Refresh the Gradle Project in IDEA if required.
3. After making code changes you can build with gradlew build
4. The output jar will be in builds/lib

## Contributions

Contributions and bug fixes are welcome. If you plan to add any features check with the team before starting as there may already be somebody working on it. PR's are not guaranteed to be accepted and should follow existing naming conventions etc. If in doubt join the discord [here](https://discord.gg/eSkYN8n) or irc channel `#bluepower` on esper.net
When adding code. Please use proper javadoc and always include an @author tag. 

## Bug reports
When issuing a bug report. Please take a look first here: https://github.com/Qmunity/BluePower/issues?q=is%3Aissue+is%3Aclosed. It might very well be that somebody already filed the bug you have, and we've already fixed it.

If nobody else reported the same bug, you can go ahead and report it. Please make sure to include the following info:
- **What where you doing when you had the issue?**
- **What did you expect to happen?**
- **What happened instead?**
- **Crashlog**

## Known Issues
Various things work inconsistently when Forge Multipart is not installed.

Please supply a crashlog using pastebin! do *not* paste a crashlog directly in the issue!
Also please try to reproduce your crash. It's possible that a crash only happened because of a quirk in the universe.

##### Note
The project is in active development and may not always be stable!

