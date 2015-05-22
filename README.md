# ToDoList
Как сделать 110% процентов

Разработчики
------------
* Степулёнок Денис Олегович - super.denis@gmail.com
* Громов Илья Анварович - igromovbox@gmail.com
* Тарасов Вова Вовович
* Кочарина Галина
* Панина Екатерина Сергеевна
* Терехов Евгений
* Мочалов Иван
* Пархоменко Александр
* Васильев Даниил

Предметная область:
-------------------
* Задачи
* События в календаре
* Контакты
* События по которым меняется состояние системы (новые письма и т.д.)

Метафора описывающая работу системы:
**Доска** - хранилище данных доступное всем компонентам: каждый компонент дописывает (добавляет) на доску то что может, забирает и вычёркивает с доски что может.

**Синхронизация для задач:**
* Источники задач: электронная почта, ввод на сайте, ввод в приложении
* Синхронизация (другие списки задач)
 * GTasks: https://developers.google.com/google-apps/tasks/
 * Wunderlist: https://developer.wunderlist.com/documentation
 * Any.do ?
* Автоматические исполнители (скрипты, службы, делегировать)

**Задачи можно группировать и фильтровать по контекстам:**
* где? (дом, работа, магазин, etc.) - геолокация на мобильном телефоне, на сайте можно выбирать одно из мест.
* когда? (утро, вечер, можно анализировать периоды активности пользователя и )
* Любым тегам пользовательским (когда вижу техлида, девушку... и т.д.)

**Задачи можно сортировать:**
* по приоритету P1, P2, P3, P4, P5 или Срочно, Высокий, Средний, Низкий
* по deadline (времени завершения)

**Синхронизация для календаря:**
* Google Calendar API - https://developers.google.com/google-apps/calendar/
* VKontakte API - https://vk.com/apiclub

Компонент для Time-tracking - запись событий по времени для сравнения с исходным планом.

Поместить курс Java Junior Developer в список задач.

Важно: версионность списка задач/календаря - можно в любой момент выгрузить всё в виде
простого текста и сравнить с предыдущим, а также откатиться на любую предыдущую версию.

Можно сделать свой API для создания клиентов под iOS и другие ОС?