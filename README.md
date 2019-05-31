## About this project 
This is a collection of Spring & Spring Boot techniques.

### Events
Events are one of the more overlooked functionalities in the framework. Event publishing is one of the capabilities provided by ApplicationContext.

- the event should extend ApplicationEvent
- the publisher should `inject` an ApplicationEventPublisher 
- the listener should implement the ApplicationListener 

create and publish events are synchronous by default.

The publisher constructs the event object and publishes it to anyone who's listening, multiple listener is fine.

Default, spring events are synchronous, publisher method blocks until all listeners finish processing the event. Just by creating an `ApplicationEventMulticaster` bean with an executor, you can turn that to Asynchronous.

