# DesktopPDF

[![Build Status](https://app.travis-ci.com/Kazantsev27/DesktopPDF.svg?branch=master)](https://app.travis-ci.com/Kazantsev27/DesktopPDF)

Создание PDF документа в рамках РГР.
Как работает программа: открывает стандартное окно с 4-мя полями ввода данных, где после заполнения (или можно оставить пустыми поля) необходимо нажать кнопку "Создать PDF". В итоге будет создан типовой PDF файл под названием, которое вы укажите в классе ListenerPDF. Файл сохранится по пути на котором находится выполняемая программа. Для завершения работы программы необходимо нажать кнопку "Выход".

Что из себя представляет генерируемый PDF файл?
Файл стандартного вида, где будет отображен заданный текст (он задается в программном коде, а не берется из файла), будет отображена таблица с 4 столбцами и одной значащей строкой, значение которой вводит пользователь, а также в документе будет присутствовать изображение (логотип УГАТУ). В случае если необходимо изменить текст, параметры таблицы или изображение, то это возможно выполнить изменяя параметры класса. 

Обновление от 9 октября 2021:
- реализован вывод сообщения о создании PDF файла;
- реализована библиотека (класс) с заданным методом;
- использован Javadoc;
- переопределена структура основного приложения: теперь класс ListenerCreate не используется.

Обновление от 8 октября 2021:
- реализован GUI с полями ввода;
- реализован алгоритм создание конкретного PDF;
- добавлена возможность выводить текст на русском языке;
- проект с новой структурой;

