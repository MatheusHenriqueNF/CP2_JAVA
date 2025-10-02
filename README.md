# 🚁 Projeto CP2 - Drone Mission API  

API REST para gerenciamento de **drones** e **missões**, desenvolvida em **Java Spring Boot**.  
Permite cadastrar drones, criar missões e consultar relatórios estratégicos sobre uso da frota.  

---

## 📌 Endpoints

### 📍 Drones (`/api/drone`)

- **GET** `/api/drone/{id}` → Busca drone por ID  
- **PUT** `/api/drone/{id}` → Atualiza um drone (objeto inteiro) por ID  
- **PATCH** `/api/drone/{id}` → Atualiza parcialmente um drone  
- **GET** `/api/drone` → Lista todos os drones  
- **POST** `/api/drone` → Insere um novo drone  
- **DELETE** `/api/drone` → Remove o objeto drone por ID  
- **GET** `/api/drone/{id}/baterry-drone` → Retorna bateria de drone por ID  
- **GET** `/api/drone/{id}/ranking` → Retorna o ranking de drones por missão  
- **DELETE** `/api/drone/removeObject` → Remove objeto drone inteiro  

---

### 📍 Missões (`/api/mission`)

- **GET** `/api/mission` → Lista todas as missões  
- **POST** `/api/mission` → Insere uma nova missão  
- **GET** `/api/mission/{id}` → Busca missão por ID  
- **GET** `/api/mission/mission-drone/{droneId}` → Busca missões relacionadas a um drone  

---

## 📋 Exemplos de Requisições (cURL)

### ➕ Cadastrar Drones
{ "model": "F-16", "batteryCapacity": 100, "status": "Online" }
{ "model": "DDB-890", "batteryCapacity": 40, "status": "Em manutenção" }

### ➕ Cadastrar Missões
{ 
  "description": "Ir fazer manutenção em torre de rádio", 
  "location": "São Paulo, Brazil", 
  "scheduledDate": "2025-10-01", 
  "droneId": "id-gerado-ao-cadastrar-o-drone", 
  "estimatedBatteryUsage": 15 
}
{ 
  "description": "Fazer resgate de gato na árvore", 
  "location": "Piracicaba, SP, Brazil", 
  "scheduledDate": "2025-10-01", 
  "droneId": "id-gerado-ao-cadastrar-o-drone", 
  "estimatedBatteryUsage": 30 
}

---

## 🔍 Endpoints Não-CRUD  

### 1️⃣ Relatório de uso de bateria  
Esse endpoint foi escolhido porque permite **monitorar a eficiência energética dos drones**.  
Como a autonomia da bateria é um fator crítico em operações, calcular a média de capacidade estimada em missões ajuda a:  
- Identificar drones com desgaste anormal  
- Apoiar manutenção preventiva  
- Planejar rotas com maior confiabilidade  

### 2️⃣ Ranking de drones mais utilizados  
Esse endpoint foi escolhido porque auxilia na **análise de utilização da frota**.  
O ranking permite:  
- Identificar drones mais demandados  
- Balancear as operações  
- Apoiar decisões sobre substituição, manutenção e investimentos  

---

## 🚀 Como Executar Localmente  

### ✅ Pré-requisitos
- **Java 21+**  
- **Maven 3.9+**

### 📂 Clonar o repositório
git clone https://github.com/MatheusHenriqueNF/CP2_JAVA.git
cd Project-Mission-Drone

### ⚙️ Compilar o projeto
mvn clean install

### ▶️ Executar a aplicação
mvn spring-boot:run

A aplicação iniciará em:  
👉 http://localhost:8080  

---

## 🗄️ Banco de Dados (H2)
- **Console:** http://localhost:8080/console  

---

## 📖 Documentação Swagger
Disponível em:  
👉 http://localhost:8080/swagger-ui.html  

---
