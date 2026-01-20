# CSV/XML → JSON Парсер 🔄

Простой и эффективный конвертер CSV и XML файлов в JSON формат, написанный на Java с использованием современных библиотек для обработки данных.

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)
![Support](https://img.shields.io/badge/Support-CSV%20%26%20XML-green.svg)

## 📋 Содержание
- [Особенности](#особенности)
- [Новый функционал](#новый-функционал)
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
- ✅ **Гибкость** - поддержка различных структур CSV и XML файлов
- ✅ **Красивый вывод** - отформатированный JSON с правильными отступами
- ✅ **Обработка ошибок** - информативные сообщения об ошибках
- ✅ **Кроссплатформенность** - работает на Windows, Linux и macOS
- ✅ **Библиотеки** - использует OpenCSV, Gson и Java DOM для надежной работы

## 🆕 Новый функционал

### Добавлена поддержка XML → JSON конвертации!

Теперь проект поддерживает два формата входных данных:

#### 📄 Поддержка XML файлов:
- Чтение и парсинг XML документов
- Поддержка вложенных структур
- Автоматическое преобразование типов данных
- Валидация XML структуры

#### 🔧 Новые методы в Main.java:
```java
// Парсинг XML файлов
List<Employee> parseXML(String fileName)

// Вспомогательные методы
String getTagValue(String tagName, Element element)
```

#### 📁 Пример XML файла (data.xml):
```xml
<staff>
    <employee>
        <id>1</id>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
        <country>USA</country>
        <age>25</age>
    </employee>
    <employee>
        <id>2</id>
        <firstName>Inav</firstName>
        <lastName>Petrov</lastName>
        <country>RU</country>
        <age>23</age>
    </employee>
</staff>
```

#### 📊 Результат конвертации (data2.json):
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
    "firstName": "Inav",
    "lastName": "Petrov",
    "country": "RU",
    "age": 23
  }
]
```

#### 🎯 Как использовать новую функционал:
```java
// Конвертация XML в JSON
List<Employee> xmlList = Main.parseXML("data.xml");
String jsonFromXml = Main.listToJson(xmlList);
Main.writeString(jsonFromXml, "data2.json");
```

## ⚙️ Требования

- Java 17 или выше
- Maven 3.8+ или Gradle 7+
- Любая IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Установка

### Клонирование репозитория
```bash
git clone https://github.com/vlzov/csv-json-parser.git
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
- **Java XML API** - для парсинга XML файлов (встроено в Java)
- **JUnit 5** - для тестирования

## 📖 Использование

### 1. Подготовка файлов
Создайте файлы в папке `src/main/resources/`:

**CSV файл (data.csv):**
```csv
1,John,Smith,USA,25
2,Ivan,Petrov,RU,23
```

**XML файл (data.xml):**
```xml
<staff>
    <employee>
        <id>1</id>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
        <country>USA</country>
        <age>25</age>
    </employee>
    <employee>
        <id>2</id>
        <firstName>Inav</firstName>
        <lastName>Petrov</lastName>
        <country>RU</country>
        <age>23</age>
    </employee>
</staff>
```

### 2. Запуск программы
```java
import com.vlzov.Main;

public class App {
    public static void main(String[] args) {
        Main.main(args); // Автоматически конвертирует и CSV, и XML
    }
}
```

Или через командную строку:
```bash
mvn compile exec:java -Dexec.mainClass="com.vlzov.Main"
```

### 3. Результаты
Программа создаст два файла:

**data.json** (из CSV):
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

**data2.json** (из XML):
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
    "firstName": "Inav",
    "lastName": "Petrov",
    "country": "RU",
    "age": 23
  }
]
```

### 4. Раздельное использование
```java
// Только CSV конвертация
String[] mapping = {"id", "firstName", "lastName", "country", "age"};
List<Employee> csvList = Main.parseCSV(mapping, "data.csv");
String json1 = Main.listToJson(csvList);
Main.writeString(json1, "output_from_csv.json");

// Только XML конвертация
List<Employee> xmlList = Main.parseXML("data.xml");
String json2 = Main.listToJson(xmlList);
Main.writeString(json2, "output_from_xml.json");
```

## 📁 Структура проекта

```
csv-json-parser/
├── src/
│   ├── main/
│   │   ├── java/com/vlzov/
│   │   │   ├── Main.java              # Основной класс программы
│   │   │   └── Entity/
│   │   │       └── Employee.java      # Модель сотрудника
│   │   └── resources/
│   │       ├── data.csv               # Пример CSV файла
│   │       ├── data.xml               # Пример XML файла
│   │       ├── data.json              # Результат CSV конвертации
│   │       └── data2.json             # Результат XML конвертации
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

### Пример XML файла
```xml
<staff>
    <employee>
        <id>1</id>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
        <country>USA</country>
        <age>25</age>
    </employee>
    <employee>
        <id>2</id>
        <firstName>Ivan</firstName>
        <lastName>Petrov</lastName>
        <country>RU</country>
        <age>23</age>
    </employee>
</staff>
```

### Соответствующий JSON (одинаковый для обоих форматов)
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

## 🛠 Разработка

### Основные классы

#### `Employee.java`
```java
package com.vlzov.Entity;

public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;
    
    // Пустой конструктор (для CSV парсера)
    public Employee() {}
    
    // Конструктор со всеми параметрами
    public Employee(long id, String firstName, String lastName, 
                   String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }
}
```

#### `Main.java` (обновленный)
Содержит пять основных методов:
1. `parseCSV()` - парсинг CSV файла
2. `parseXML()` - парсинг XML файла **(НОВЫЙ!)**
3. `listToJson()` - преобразование списка в JSON
4. `writeString()` - запись JSON в файл
5. `getTagValue()` - вспомогательный метод для XML парсинга **(НОВЫЙ!)**

### Расширение функциональности

Для поддержки других форматов данных можно добавить:

```java
public interface DataConverter {
    List<Employee> parse(String fileName);
    String convert(List<Employee> employees);
    void save(String data, String fileName);
}

// Пример реализации для JSON/YAML/других форматов
```

## 🧪 Тестирование

Запуск тестов:
```bash
mvn test
```

Пример теста для нового XML функционала:
```java
@Test
public void testParseXML() {
    // Подготовка тестового XML файла
    String testXml = "<staff><employee><id>1</id><firstName>Test</firstName>" +
                    "<lastName>User</lastName><country>TEST</country><age>30</age>" +
                    "</employee></staff>";
    
    // Сохраняем временный файл
    Files.write(Paths.get("test.xml"), testXml.getBytes());
    
    // Тестируем парсинг
    List<Employee> employees = Main.parseXML("test.xml");
    
    // Проверяем результаты
    assertNotNull(employees);
    assertEquals(1, employees.size());
    assertEquals("Test", employees.get(0).firstName);
    assertEquals(30, employees.get(0).age);
    
    // Удаляем временный файл
    Files.delete(Paths.get("test.xml"));
}

@Test
public void testGetTagValue() {
    // Тестируем вспомогательный метод
    // (реализация теста зависит от внутренней структуры)
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

### Что можно улучшить:
- Добавить поддержку JSON → CSV/XML конвертации
- Реализовать веб-интерфейс
- Добавить валидацию схемы XML через XSD
- Поддержку других форматов (YAML, Excel)

## 📞 Контакты

**Владимир** - [@vlzov](https://github.com/vlzov)

Ссылка на проект: [https://github.com/vlzov/csv-json-parser](https://github.com/vlzov/csv-json-parser)

---

## 🎯 Быстрый старт

### Самый простой способ запуска:

1. Убедитесь, что у вас установлены Java и Maven
2. Склонируйте проект
3. Поместите ваши CSV или XML файлы в `src/main/resources/`
4. Запустите:
```bash
mvn exec:java
```

### Примеры использования:

```bash
# Конвертация только CSV
java -cp target/classes com.vlzov.Main csv

# Конвертация только XML  
java -cp target/classes com.vlzov.Main xml

# Конвертация обоих форматов (по умолчанию)
java -cp target/classes com.vlzov.Main
```

### Docker (опционально):
```bash
docker build -t csv-xml-json-parser .
docker run -v $(pwd)/data:/app/data csv-xml-json-parser
```

---

⭐ **Если этот проект был полезен, не забудьте поставить звезду на GitHub!**

---

## 🔄 Сравнение форматов

| Формат | Преимущества | Когда использовать |
|--------|-------------|-------------------|
| **CSV** | Простота, маленький размер, читаемость | Табличные данные, Excel экспорт |
| **XML** | Структурированность, валидация, вложенность | Конфигурации, веб-сервисы, сложные данные |
| **JSON** | Легковесность, читаемость, поддержка в JavaScript | Веб-API, мобильные приложения, конфигурации |

---

*Последнее обновление: Январь 2026 | Версия 2.0 | Добавлена поддержка XML*
