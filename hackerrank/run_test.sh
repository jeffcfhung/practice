#!/bin/sh

LANG='java'
build() {
    program=$1
    if [ -f $program.java ] ; then
        javac $program.java
    else
        if [ -f $program.c ] ; then
            COMPILER="gcc"
            suffix="c"
        else
            COMPILER="g++"
            suffix="cpp"
        fi

        COMPILER="$COMPILER -g -Wall"
        `$COMPILER -c $program.$suffix`
        `$COMPILER -o $program $program.o`
    fi
}

run() {
    program=$1
}

expect() {
    echo "[Output]\n$1\n[Expected]\n$2\n\nResult:"
    if [ "$1" = "$2" ]; then
        echo "OK"
    else
        echo "Failed"
    fi
}

get_program_name() {
    echo ${FUNCNAME[2]} | cut -d "_" -f 2
}

test() {
    program=$1
    case="$2"

    build $program

    if [ $? -ne 0 ] ; then
        echo "Compile error!"
        exit 1
    fi

    echo "[Input]"
    cat ${program}_input"$case".txt

    execCmd='./${program}'
    if [ "$LANG" = "java" ] ; then
        execCmd="java ${program}"
    fi
    expect "`${execCmd} < ${program}_input$case.txt`" "`cat ${program}_output$case.txt`"
}

action=$1
program=$2

shift
shift

if [ "$program" = "" ] ; then
    echo "Usage: $0 <action> <program_name> [index of test case]"
    echo "  <action> test or build"
    echo "  [index of test case] Can be empty which implies default"
    echo "  Example: ./run_test.sh test Trial 1"
    exit 1
fi

case $action in
    test)
        test $program $*
        ;;
    build)
        build $program
        ;;
    *)
        ;;
esac
