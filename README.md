# Реализуем параллельный запуск тестов.





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


### В папке *resources* создаем отдельный файл с именем junit-platform.properties и аналогичным содержимым (работает как для gradle, так и для maven проектов):
  
  
  >junit.jupiter.execution.parallel.enabled=true<p>
junit.jupiter.execution.parallel.mode.default=concurrent<p>
junit.jupiter.execution.parallel.mode.classes.default=concurrent<p>
junit.jupiter.execution.parallel.config.strategy=fixed<p>
>junit.jupiter.execution.parallel.config.fixed.parallelism=5

---  

##  Дополнительный материал по теме:
  
 Доклад на Heisenbug  2021 Moscow:<p> Дмитрий Тучс — [JUnit 5 Parallel test execution. Теория и практика](https://www.youtube.com/watch?v=ZIkIUCyJBGU&t=15s)
