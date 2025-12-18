# 📚 Kütüphane Yönetim Sistemi | Library Management System

---

## 📌 Proje Tanımı | Project Description

|  Türkçe |  English |
|-----------|------------|
| Bu proje, bir kütüphanedeki kitap ve kullanıcı işlemlerini yönetmek amacıyla geliştirilmiş **Java tabanlı bir web uygulamasıdır**. Kitapların kayıt altına alınması, listelenmesi ve temel kütüphane işlemlerinin dijital ortamda yönetilmesini hedefler. | This project is a **Java-based web application** developed to manage books and users in a library system. It aims to digitize basic library operations such as book registration, listing, and management. |

---

## 🎯 Projenin Amacı | Project Goals

| Türkçe |  English |
|-----------|------------|
| • Kütüphane yönetimini dijitalleştirmek<br>• Kitap kayıtlarını düzenli şekilde saklamak<br>• Kullanıcıların kitapları görüntülemesini sağlamak<br>• Basit ve anlaşılır bir web arayüzü sunmak | • Digitize library management processes<br>• Store and manage book records efficiently<br>• Allow users to view library data<br>• Provide a simple and user-friendly web interface |

---

## 🛠 Kullanılan Teknolojiler | Technologies Used

|  Türkçe | English |
|-----------|------------|
| Java<br>Maven<br>HTML / CSS<br>Docker<br>Spring Boot | Java<br>Maven<br>HTML / CSS<br>Docker<br>Spring Boot |

---

## 📂 Proje Yapısı | Project Structure

```text
library-management/
│
├── src/                → Application source code
├── .mvn/               → Maven wrapper files
├── target/             → Compiled output files
├── Dockerfile          → Docker configuration
├── pom.xml             → Maven dependencies & configuration
└── README.md           → Project documentation
---
## ⚙️ Çalışma Mantığı | How the System Works

|  Türkçe |  English |
|-----------|------------|
| 1. Kullanıcı web arayüzü üzerinden sisteme erişir<br>2. Backend işlemleri Java ile yürütülür<br>3. Kitap verileri sunucu tarafında işlenir<br>4. Sonuçlar HTML tabanlı arayüzde gösterilir | 1. Users access the system via a web interface<br>2. Backend logic is handled using Java<br>3. Book data is processed on the server side<br>4. Results are displayed through an HTML-based UI |

---

## 🚀 Projeyi Çalıştırma | Running the Project

### Maven
```bash
mvn clean install
mvn spring-boot:run

###Docker
docker build -t library-management .
docker run -p 8080:8080 library-management
