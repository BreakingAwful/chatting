# chatting
一个基于[Chatroom#49](https://github.com/Kanarienvogels/Chatroom/pull/49)的聊天系统。

## Build
```shell
mvn package
# peek inside
# jar tvf target/chatting-springboot-xxx.jar
java -jar target/chatting-springboot-xxx.jar
```

## ToDo
- [ ] refactor backend with SpringBoot
- [ ] design and use db
- [ ] use @Slf4j replace logger field
- [ ] refactor frontend
- [ ] use Logback replace slf4j
- [ ] use Redis
- [ ] automatically delete files when they expire