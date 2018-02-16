#!/bin/sh

LANG='java'
build() {
    target_file=../../main/java/$1
    if [ -f $target_file.java ] ; then
        javac $target_file.java
    else
        if [ -f $target_file.c ] ; then
            COMPILER="gcc"
            suffix="c"
        else
            COMPILER="g++"
            suffix="cpp"
        fi

        COMPILER="$COMPILER -g -Wall"
        `$COMPILER -c $target_file.$suffix`
        `$COMPILER -o $target_file $target_file.o`
    fi
}

run() {
    program=$1
}

expect() {
    echo "[Output]\n$1\n[Expected]\n$2\n\nResult:"
    if [ "$1" = "$2" ]; then
        echo "OK"
        exit 0
    else
        echo "Failed"
        exit -1
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
    echo ${program}
    cat ${program}_input"$case".txt

    execCmd='./${program}'
    if [ "$LANG" = "java" ] ; then
        execCmd="java -classpath ../../main/java ${program}"
    fi
    expect "`${execCmd} < ${program}_input$case.txt`" "`cat ${program}_output$case.txt`"
}

action=$1
program=$2
echo ${program}

shift
shift

if [ "$program" = "" ] ; then
    echo "Usage: $0 <action> <program_name> [index of test case]"
    echo "  <action> test, build or create_data_file"
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
    create_data_file)
        touch ${program}_input.txt ${program}_output.txt
        ;;
    *)
        ;;
esac
