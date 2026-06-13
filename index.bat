@echo off
chcp 65001 > nul
cd /d "%~dp0"

javac -encoding UTF-8 Index.java
if errorlevel 1 (
    echo No se pudo preparar el menu.
    pause
    exit /b 1
)

java Index
pause
