# testJDBC

Dependências adicionadas no Uber Jar para `br.com.transpetro:testJDBC:jar:1.0.0`

```txt
testJDBC:jar
+- com.oracle:ojdbc:jar:12.1.0.1:system
+- mysql:mysql-connector-java:jar:8.0.22:compile
|  \- com.google.protobuf:protobuf-java:jar:3.11.4:compile
+- org.postgresql:postgresql:jar:42.2.18.jre6:compile
+- com.h2database:h2:jar:1.4.200:compile
+- com.sleepycat:je:jar:7.0.6:compile
+- com.microsoft.sqlserver:mssql-jdbc:jar:6.4.0.jre7:compile
+- net.sourceforge.jtds:jtds:jar:1.3.1:compile
\- log4j:log4j:jar:1.2.17:compile
```

Se houver alguma incompatibilidade com a JVM que está executando o processo
é possível alterar o arquivo `pom.xml` para corrigir o problema.

Para fazer o build use:

```bash
mvn clean package assembly:single
```

Para executar com H2 em disco local, use como no exemplo abaixo:

```bash
mkdir -p /tmp/data/H2/DATABASE
java -Ddb.driver=org.h2.Driver \
     -Ddb.url="jdbc:h2:/tmp/data/H2/DATABASE/test_01" \
     -Ddb.user=My-database-user \
     -Ddb.pass="my-secret-pass" \
     -jar target/testJDBC.jar
ls -la /tmp/data/H2/DATABASE
```

Para Oracle, MS SQL, MySQL, Postgres, etc. altere os parâmetros de acordo.
