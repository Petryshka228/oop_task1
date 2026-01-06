# Task 1 (OOP, Java): MyTreeMap + SimpleBidiMap

В репозитории два отдельных Maven-проекта:

- **tree-bidimap-lib** — библиотека классов (реализация MyTreeMap на бинарном дереве + SimpleBidiMap)
- **tree-bidimap-demo** — консольное приложение, которое подключает библиотеку и демонстрирует работу

## Что было исправлено в проекте

1. Удалены лишние папки из архива: `.git`, `.idea`, `target`.
2. Тесты были случайно положены в `src/main/java` (из-за этого сборка падала, т.к. JUnit подключён с scope `test`).
   Тесты перенесены в `src/test/java`.
3. Удалены шаблонные файлы `Main.java` ("Hello and welcome"), чтобы не путать запуск.
4. В библиотеку добавлен **Maven Wrapper** (mvnw/mvnw.cmd), чтобы не зависеть от системного Maven в Windows.

## Как собрать и запустить (Windows / PowerShell)

### 1) Собрать и установить библиотеку
Перейди в папку **tree-bidimap-lib** и выполни:

```powershell
.\mvnw.cmd clean install
```

### 2) Запустить демо
Перейди в папку **tree-bidimap-demo** и выполни:

```powershell
.\mvnw.cmd clean compile exec:java
```

### 3) Запустить тесты
Тесты запускаются в библиотеке:

```powershell
cd tree-bidimap-lib
.\mvnw.cmd test
```

## Как запускать в IntelliJ IDEA

1. Открой папку **tree-bidimap-lib** (или сразу корневую папку проекта).
2. Если IntelliJ не распознал Maven — нажми ПКМ на `pom.xml` → **Add as Maven Project**.
3. Чтобы запустить демо, открой `ru.vsu.oop.demo.Main` и нажми **Run**.

