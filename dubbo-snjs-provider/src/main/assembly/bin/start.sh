#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
LOGS_DIR=$DEPLOY_DIR/logs

if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi

PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The system already started!"
    echo "PID: $PIDS"
    exit 1
fi

LIB_DIR=$DEPLOY_DIR/lib

JAVA_OPTS=" -Xms1024m -Xmx3042m -XX:MaxPermSize=512M"

echo "Starting..."
echo "Starting at `date +'%Y-%m-%d %H:%M'`" >> $LOGS_DIR/admin.log

nohup java $JAVA_OPTS -classpath $CONF_DIR:$LIB_DIR/* com.dvt.snjs.app.Main 1>/dev/null 2>&1 &

echo "OK!"
PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
echo "PID=$PIDS" >> $LOGS_DIR/admin.log
