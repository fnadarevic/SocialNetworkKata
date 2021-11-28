# SocialNetwork
 
__Build:__ Project is using maven dependencies and Java 8. Can be imported as a maven project into intellij. If it does not auto build, running mvn clean install command should download dependencies and build the project. 

__Note on lombok if not previously used:__ 
Lombok plug-in is also used from getters/setters/constructors, this should auto install through the dependency with newer versions of IntelliJ above 2020.3. 
This sometimes has issues in Eclipse and will need to be installed as a plug-in instead of only through dependency management.

__Currently implemented:__ User class that allows the user to post to their own timeline. Also implemented is a Post class for the user to post through that has time elapsed using Java 8 LocalTime and Duration classes. Test classes for both User and Post. 

__TO-DO:__ A Timeline for followed users. And followers for each user.  
