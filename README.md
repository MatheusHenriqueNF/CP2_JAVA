📌 Endpoints
Drones (/api/drone)
GET /api/drone/{id} → Busca drone por ID
PUT /api/drone/{id} → Atualiza um drone (objeto inteiro) por ID
PATCH /api/drone/{id} → Atualiza parcialmente um drone
GET /api/drone → Lista todos os drones
POST /api/drone → Insere um novo drone
DELETE /api/drone → Remove o objeto drone por ID
GET /api/drone/{id}/baterry-drone → Retorna bateria de drone por ID
GET /api/drone/{id}/ranking → Retorna o ranking de drones por missão
DELETE /api/drone/removeObject → Remove objeto drone inteiro
Missões (/api/v1/missions)
GET /api/mission → Lista todas as missões
POST /api/mission → Insere uma nova missão
GET /api/mission/{id} → Busca missão por ID
GET /api/mission/mission-drone/{droneId} → Busca missões relacionadas a um drone

📋 Exemplos de Requisições (cURL)
Cadastrar Drones
{
  "model": "F-16",
  "batteryCapacity": 100,
  "status": "Online"
}
{
  "model": "DDB-890",
  "batteryCapacity": 40,
  "status": "Em manutenção"
}
Cadastrar Missões
{
  "description": "Ir fazer manutenção em torre de rádio",
  "location": "São Paulo, Brazil",
  "scheduledDate": "2025-10-01",
  "droneId": "precisa colocar o id gerado ao cadastrar o drone",
  "estimatedBatteryUsage": 15
}
{
  "description": "Fazer resgate de gato na árvore",
  "location": "Piracicaba, SP, Brazil",
  "scheduledDate": "2025-10-01",
  "droneId": "precisa colocar o id gerado ao cadastrar o drone",
  "estimatedBatteryUsage": 30
}
{
  "description": "Espionagem do prefeito",
  "location": "Distrito Federal, DF, Brazil",
  "scheduledDate": "2025-10-01",
  "droneId": "precisa colocar o id gerado ao cadastrar o drone",
  "estimatedBatteryUsage": 50
}
{
  "description": "Nenhuma",
  "location": "Base",
  "scheduledDate": "2025-10-01",
  "droneId": "precisa colocar o id gerado ao cadastrar o drone",
  "estimatedBatteryUsage": 0
}


Justificativa para uso de GET nos Endpoints Não-CRUD
Relatório de uso de bateria (Endpoint 2)
Esse endpoint foi escolhido porque permite monitorar a eficiência energética dos drones. Como a autonomia da bateria é um fator crítico em operações de drones, calcular a média de capacidade estimada de bateria em missões fornece uma visão útil para manutenção preventiva e planejamento de rotas. Dessa forma, é possível identificar drones com desgaste anormal ou baixo desempenho, garantindo maior confiabilidade das operações.

Ranking de drones mais utilizados (Endpoint 4)
Esse endpoint foi escolhido porque auxilia na análise de utilização da frota. Através do ranking, a organização pode identificar quais drones são mais demandados, permitindo otimizar o uso, balancear as operações e planejar futuras aquisições. Além disso, o ranking gera informações estratégicas para relatórios gerenciais, ajudando na tomada de decisão sobre substituição, manutenção e investimentos.

🚀 Como Executar Localmente
Pré-requisitos
Java 21+
Maven 3.9+

Clonar o repositório
git clone https://github.com/MatheusHenriqueNF/CP2_JAVA.git

Entrar na pasta do projeto
cd Project-Mission-Drone

Compilar o projeto
mvn clean install

Execução
Executar a aplicação

mvn spring-boot:run
O projeto iniciará em:
http://localhost:8080

h2-console
O banco local H2-Console:
http://localhost:8080/console

A documentação Swagger estará disponível em:
http://localhost:8080/swagger-ui.html
