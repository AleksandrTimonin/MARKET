# Проект "Онлайн магазин на Java Spring"
Добро пожаловать в проект "Онлайн магазин на Java Spring"! Этот проект представляет собой интернет-магазин, 
разработанный с использованием Java Spring Framework, на микросервисной архитектуре.
В магазине реализована работа с базой данных H2 (PostgreSQL dialect) для простоты развёртывания с использованием Hibernate. 
Также для сервиса корзин используется быстрая база данных Redis. 
Магазин поддерживает совмещение корзин неавторизованных пользователей с их корзинами после авторизации, 
а также предоставляет возможность добавления товаров в корзину, 
создания заказов и их оплаты с помощью PayPal.

Функциональности проекта
Авторизация:

Зарегистрированные пользователи могут авторизоваться с помощью своих учетных данных (bob 100).

Корзины:

Каждый пользователь имеет свою уникальную корзину для добавления товаров.
Система позволяет совмещать корзины неавторизованных пользователей с их корзинами после авторизации.

Оформление заказов:

Пользователи могут добавлять товары в корзину, создавать заказы на базе корзины и оформлять их для последующей оплаты.
Поддерживается разделение заказов на отдельные позиции товаров с указанием количества.
Оплата заказов:

Интеграция с PayPal API позволяет пользователям оплачивать созданные заказы онлайн.

Запуск проекта
Для запуска проекта, выполните следующие шаги:

Убедитесь, что у вас установлены следующие зависимости:

# ставим:
Java Development Kit (JDK) версии 11 или выше.
Redis для работы сервиса корзин.
Apache Maven для сборки проекта.

# в коробке:
H2 (PostgreSql диалект) 
PayPal API для обработки платежей.

База данных будет создана при первом запуске, с настройками указанными в файле application.yaml.

Установите и запустите Redis на вашей машине или используйте удаленный Redis-сервер.

Зарегистрируйтесь на PayPal Developer и получите необходимые API-ключи.

Замените значения переменных paypal.clientId и paypal.clientSecret в файле secret.properties микросенвиса core на полученные ключи от PayPal.

Запустите приложение с помощью Maven:

bash
Copy code
# Перейдите в директорию проекта
cd [тут должна быть ваша дирректория]

# Соберите проект с помощью Maven
mvn clean install

# Запустите приложение
mvn spring-boot:run
Ваш магазин должен быть доступен по адресу http://localhost:3000/front.

Документация API
К сожалению в рамках проекта документирование не предусмотрено.

Лицензия
Проект не лицензировался.

Автор
Александр Тимонин -https://github.com/AleksandrTimonin/

Благодарности
Благодарю преподавателя онлайн университета Geekbrains Александра Фисунова.
Спасибо за просмотр моего проекта! 
Если у вас возникли вопросы или предложения, не стесняйтесь обращаться :)

