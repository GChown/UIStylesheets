JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
	.java.class:


CLASSES = \
		          Window.java

default: 
	        @$(JC) $(JFLAGS) *.java; java Window

run:
		@java Window

classes: $(CLASSES:.java=.class)

clean:
	        $(RM) *.class
