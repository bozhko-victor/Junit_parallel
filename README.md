# Реализуем параллельный запуск тестов средствами JUnit.





## Вариант 1


### Добавить в файл сборки *build.gradle* следующую конфигурацию:


> tasks.withType(Test) { <p>
> systemProperties(System.getProperties())<p>
> useJUnitPlatform()
>
>            {
>                systemProperties += [
>                        'junit.jupiter.execution.parallel.enabled'                 : true,
>                        'junit.jupiter.execution.parallel.mode.default'            : 'concurrent',
>                        'junit.jupiter.execution.parallel.mode.classes.default'    : 'concurrent',
>                        'junit.jupiter.execution.parallel.config.strategy'         : 'fixed',
>                        'junit.jupiter.execution.parallel.config.fixed.parallelism': 4
>                ]
>            }
> }



## Вариант 2


### В папке *resources* создаем отдельный файл с именем junit-platform.properties и аналогичным содержимым (работает как в gradle, так и maven проектах):


>junit.jupiter.execution.parallel.enabled=true<p>
junit.jupiter.execution.parallel.mode.default=concurrent<p>
junit.jupiter.execution.parallel.mode.classes.default=concurrent<p>
junit.jupiter.execution.parallel.config.strategy=fixed<p>
>junit.jupiter.execution.parallel.config.fixed.parallelism=5

---






## Исключение конфликтов при прогоне тестов

### Если необходимо добиться раздельного прогона каких-либо тестов, то используют следующие аннотации JUnit:

>@ResourceLock("1")


Пока выполняется тест с данной аннотацией, все другие тесты отмеченные @ResourceLock с тем же значением ("1") выполнятся не будут.

>@Execution(value = ExecutionMode.SAME_THREAD)

Тесты, помеченные этой аннотацией будут запускаться однопоточно (применимо как к отдельным тестам, так и целому классу).

----


##  Дополнительный материал по теме:

Доклад на Heisenbug  2021 Moscow:<p> Дмитрий Тучс — [JUnit 5 Parallel test execution. Теория и практика](https://www.youtube.com/watch?v=ZIkIUCyJBGU&t=15s)