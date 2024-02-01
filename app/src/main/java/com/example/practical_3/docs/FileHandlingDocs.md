When working with android app data storage, it plays around a lot with the file system, and therefore causing the need to really know how java file handling actually works. Some research has been made

# Important concepts

## Streams

This is known as the logical connection between the java code and the file system. logical here meaning that we cannot see this connection like connections using wifi, we are unable to see physical wire connecting phones and wifi therefore it is called logical connection. Think of this as a pipe that connects the java code to the file system, for us to start to read or write to the file system, we first need to create a stream using either

```
FileInputStream FIS = getApplicationContext().openFileInput("filename")
```

or

```
FileOutputStream FOS = getApplicationContext().openFileOutput("filename")
```

for both input and output, note that the streams need to be closed for some security purposes I suppose but here basically using the getApplicationContext().openFileOutput, I assume the context is telling it so that we don’t have to explicitly say if we are looking at any specific folder but it will know where to look by default, whether it is in local storage or app specific or shared storage ( update when further research )

## Reader/Writer

Using the stream, we can easily perform read and write operations but it will only read one byte at a time which is very tedious to work with, so unless we have some way to convert our thing to read or write to bytes, we normally would declare a inputStreamReader to ease our lives

```
InputStreamReader inputStreamReader = new InputStreamReader(FIS, StandardCharsets.UTF_8);
```

Writing using android studio usually would straight away use the output stream since we have a method called getBytes() in string

```
fos.write(fileContents.getBytes());
```

## Buffered reader/writer

The inputStreamReader might seem enough to be used to read but it is actually not, although it does not read one byte at a time, it is still only reading one character at a time, therefore the loop would have to go one very long to say read a whole paragraph as each loop represents one character, this is still tedious so java has something called bufferedReader which is the most convenient there is to file reads

```
try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        }
```

Note that bufferedReader allows us to use things like readLine(), making our lives easier. Something to note here is that we have to close these streams and readers to prevent memory leaks that is very vulnerable when working with streams

```
Garbage collector is meant to collect unused
objects. A stream is often linked to a lot
of resources (file descriptor, socket, etc...)
that are much more critical in your machine.
Of course they are likely to be freed on program
exit, but they should stay open for as little
as possible
```

Note also that closing the bufferedReader actually closes everything including the stream and the inputreader thing

‌

# Resources

1. [Why we should close streams](https://stackoverflow.com/questions/35220440/why-do-i-need-to-close-streams#:~:text=yes%20you%20need%20to%20close,be%20use%20for%20further%20operation. "‌")
