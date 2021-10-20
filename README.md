#Реализуем параллельный запуск тестов.

---



##Вариант 1


###Добавить в файл build.gradle task:


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



##Вариант 2


###В папке *resources* создаем отдельный файл junit-platform.properties c аналогичным содержимым:


>junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
junit.jupiter.execution.parallel.mode.classes.default=concurrent
junit.jupiter.execution.parallel.config.strategy=fixed
>junit.jupiter.execution.parallel.config.fixed.parallelism=5