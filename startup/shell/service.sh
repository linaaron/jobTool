#!/bin/bash
BASE_DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/../../
export JOB_TOOL_HOME=$BASE_DIR

function packageWar() {
    echo "Installing war..."
    mvn clean package -f $BASE_DIR -Dmaven.test.skip=true
}

function startTomcat() {
    echo "start tomcat..."

    export CATALINA_HOME="$BASE_DIR/startup/tomcat"
    export JAVA_OPTS="-Dcatalina.home=$CATALINA_HOME -Dcatalina.base=$CATALINA_HOME -ms256m -mx1024m  -XX:MaxPermSize=160m -Duser.language=en -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true"
    export CATALINA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9991"
    export CATALINA_PID="$CATALINA_HOME/catalina.pid"

    $CATALINA_HOME/bin/catalina.sh start

    echo "-------------------------------------------------------"
}

function stopTomcat() {
    echo "Stop tomcat..."
    export CATALINA_HOME="$BASE_DIR/startup/tomcat"
    export CATALINA_PID="$CATALINA_HOME/catalina.pid"

    if [[ -e $CATALINA_PID && -s $CATALINA_PID ]]
    then
        $CATALINA_HOME/bin/catalina.sh stop -force
    else
        echo "no tomcat $1 pid"
    fi

    echo "-------------------------------------------------------"
}

