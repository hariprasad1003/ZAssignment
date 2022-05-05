## Day 1

### Java Install

```
sudo apt install default-jre
sudo apt install default-jdk

java -version
javac -version
```

### Set JAVA_HOME and PATH

```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
echo $JAVA_HOME
export PATH=$PATH:$JAVA_HOME/bin
echo $PATH
```

### Set CLASSPATH using cp or classpath

```
javac -d ~/Desktop Greeting.java
javac -cp ~/Desktop printGreeting.java 
java -cp ~/Desktop printGreeting.java
```

### Crete jar 

```
jar cf greetingpackage.jar
```

### Set CLASSPATH using environment variable

```
gedit /etc/environment
JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
export JAVA_HOME
PATH=$PATH:$JAVA_HOME/bin
export PATH
CLASSPATH=".:/home/hariprasad/Desktop"
export CLASSPATH
source /etc/environment
echo $JAVA_HOME
echo $PATH
echo $CLASSPATH
```

```
javac printGreeting.java
java printGreeting
```