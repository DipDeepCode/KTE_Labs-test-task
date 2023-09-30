# Решение тестового задания KTE_Labs

## Задание

Создать систему записи пациентов на приём, состоящую из:  
1. Базы данных (желательно PostgreSQL) с таблицами:  
   - врачи: id, uuid, ФИО и т. д. (здесь и далее «и т. д.» обозначает, что можно расширить структуру, если будут свои идеи)  
   - пациенты: id, uuid, ФИО, дата рождения и т. д.  
   - талон (слот времени): id, id врача, id пациента, время начала приёма и т.д.  
2. SQL-скрипт создания структура этой базы в выбранной СУБД (можно взять автоматически сгенерированный скрипт по созданной структуре).
3. Java web приложение, выполняющее основную логику (желательно Spring Boot)  
   - Осуществлять подключение и операции в БД (желательно средствами Java Persistence API)
   - SOAP сервис с методом создания расписания, который по переданным правилам создаёт слоты времени. Правила могут состоять из даты/времени начала расписания, продолжительность талона (слота времени), их количество и т. д. Можно применить более сложную структуру правил, если будет желание.
   - REST сервис работы с методами:
     - получение свободных слотов времени к указанному врачу на указанную дату
     - занятие слота времени по его id
     - получение всех слотов времени, занятых одним пациентом по id/uuid