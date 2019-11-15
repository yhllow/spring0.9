@Echo Off

Title install third party jars
Pushd %~dp0

echo install jars...
call mvn install:install-file -Dfile=./com.springsource.org.aopalliance-1.0.0.jar -DgroupId=org.aopalliance -DartifactId=com.springsource.org.aopalliance -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
call mvn install:install-file -Dfile=./jms-1.1.jar -DgroupId=javax.jms -DartifactId=jms -Dversion=1.1 -Dpackaging=jar -DgeneratePom=true

pause