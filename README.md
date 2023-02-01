# GBPMN

流程引擎

- [] 实现流程编排
- [] 在线编辑流程图
- [] 实现 el 规则

队列接入第三方服务 RabbitMQ，有时间就将其抽象实现，支持多种方式实现 DB、Redis

### RabbitMQ docker-compose

```yaml
version: '3.1'
services:
  rabbitmq:
    image: rabbitmq:management
    container_name: rabbitmq
    restart: always
    hostname: rabbitmq
    environment:
      - RABBITMQ_DEFAULT_USER=admin
      - RABBITMQ_DEFAULT_PASS=admin
    volumes:
      - /root/rabbit/data:/var/lib/rabbitmq
    ports:
      - "15672:15672"
      - "5672:5672"
```