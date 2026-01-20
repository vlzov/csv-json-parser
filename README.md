# CSV → JSON Парсер 🔄

Простой и эффективный конвертер CSV файлов в JSON формат, написанный на Java с использованием современных библиотек для обработки данных.

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

## 📋 Содержание
- [Особенности](#особенности)
- [Требования](#требования)
- [Установка](#установка)
- [Использование](#использование)
- [Структура проекта](#структура-проекта)
- [Примеры](#примеры)
- [Разработка](#разработка)
- [Тестирование](#тестирование)
- [Лицензия](#лицензия)

## ✨ Особенности

- ✅ **Простой в использовании** - минимум конфигурации, максимум результата
- ✅ **Гибкость** - поддержка различных структур CSV файлов
- ✅ **Красивый вывод** - отформатированный JSON с правильными отступами
- ✅ **Обработка ошибок** - информативные сообщения об ошибках
- ✅ **Кроссплатформенность** - работает на Windows, Linux и macOS
- ✅ **Библиотеки** - использует OpenCSV и Gson для надежной работы

## ⚙️ Требования

- Java 17 или выше
- Maven 3.8+ или Gradle 7+
- Любая IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Установка

### Клонирование репозитория
```bash
git clone https://github.com/vladimir/csv-json-parser.git
cd csv-json-parser
```

### Сборка проекта
```bash
# Для Maven
mvn clean install

# Для Gradle
gradle build
```

### Зависимости
Проект использует следующие библиотеки:
- **OpenCSV 5.7.1** - для парсинга CSV файлов
- **Gson 2.8.9** - для работы с JSON
- **JUnit 5** - для тестирования

## 📖 Использование

### 1. Подготовка CSV файла
Создайте файл `data.csv` в папке `src/main/resources/`:

```csv
1,John,Smith,USA,25
2,Ivan,Petrov,RU,23
3,Maria,Garcia,ES,30
4,Ken,Watanabe,JP,28
```

### 2. Запуск программы
```java
import com.vlzov.Main;

public class App {
    public static void main(String[] args) {
        Main.main(args);
    }
}
```

Или через командную строку:
```bash
mvn compile exec:java -Dexec.mainClass="com.vlzov.Main"
```

### 3. Результат
Программа создаст файл `data.json` со следующим содержимым:

```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Smith",
    "country": "USA",
    "age": 25
  },
  {
    "id": 2,
    "firstName": "Ivan",
    "lastName": "Petrov",
    "country": "RU",
    "age": 23
  }
]
```

### 4. Кастомная конфигурация
```java
String[] customMapping = {"id", "name", "surname", "country", "years"};
String inputFile = "custom_data.csv";
String outputFile = "output.json";

List<Employee> employees = Main.parseCSV(customMapping, inputFile);
String json = Main.listToJson(employees);
Main.writeString(json, outputFile);
```

## 📁 Структура проекта

```
csv-json-parser/
├── src/
│   ├── main/
│   │   ├── java/com/vlzov/
│   │   │   ├── Main.java              # Основной класс программы
│   │   │   └── entity/
│   │   │       └── Employee.java      # Модель сотрудника
│   │   └── resources/
│   │       ├── data.csv               # Пример CSV файла
│   │       └── data.json              # Результат конвертации
│   └── test/                          # Тесты
├── target/                            # Скомпилированные файлы
├── pom.xml                           # Конфигурация Maven
├── .gitignore                        # Игнорируемые файлы Git
└── README.md                         # Эта документация
```

## 📊 Примеры

### Пример CSV файла
```csv
id,firstName,lastName,country,age
1,John,Smith,USA,25
2,Ivan,Petrov,RU,23
3,Emma,Wilson,GB,31
```

### Соответствующий JSON
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Smith",
    "country": "USA",
    "age": 25
  },
  {
    "id": 2,
    "firstName": "Ivan",
    "lastName": "Petrov",
    "country": "RU",
    "age": 23
  },
  {
    "id": 3,
    "firstName": "Emma",
    "lastName": "Wilson",
    "country": "GB",
    "age": 31
  }
]
```

## 🛠 Разработка

### Основные классы

#### `Employee.java`
```java
public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;
    
    // Конструкторы, геттеры/сеттеры
}
```

#### `Main.java`
Содержит три основных метода:
1. `parseCSV()` - парсинг CSV файла
2. `listToJson()` - преобразование списка в JSON
3. `writeString()` - запись JSON в файл

### Расширение функциональности

Для поддержки других форматов данных можно добавить:

```java
public interface DataConverter {
    List<Employee> parse(String fileName);
    String convert(List<Employee> employees);
    void save(String data, String fileName);
}
```

## 🧪 Тестирование

Запуск тестов:
```bash
mvn test
```

Пример теста:
```java
@Test
public void testParseCSV() {
    String[] mapping = {"id", "firstName", "lastName", "country", "age"};
    List<Employee> employees = Main.parseCSV(mapping, "test.csv");
    
    assertNotNull(employees);
    assertEquals(2, employees.size());
    assertEquals("John", employees.get(0).firstName);
}
```

## 📝 Лицензия

Этот проект распространяется под лицензией MIT. Подробнее см. файл [LICENSE](LICENSE).

## 🤝 Вклад в проект

1. Форкните репозиторий
2. Создайте ветку для новой функциональности (`git checkout -b feature/amazing-feature`)
3. Зафиксируйте изменения (`git commit -m 'Add amazing feature'`)
4. Отправьте изменения (`git push origin feature/amazing-feature`)
5. Создайте Pull Request

## 📞 Контакты

**Владимир** - [@vlzov](https://github.com/vlzov)

Ссылка на проект: [https://github.com/vlzov/csv-json-parser](https://github.com/vlzov/csv-json-parser)

---

## 🎯 Быстрый старт

### Самый простой способ запуска:

1. Убедитесь, что у вас установлены Java и Maven
2. Склонируйте проект
3. Поместите ваш CSV файл в `src/main/resources/`
4. Запустите:
```bash
mvn exec:java
```

### Docker (опционально):
```bash
docker build -t csv-json-parser .
docker run -v $(pwd)/data:/app/data csv-json-parser
```

---

⭐ **Если этот проект был полезен, не забудьте поставить звезду на GitHub!**

---

*Последнее обновление: Январь 2026*