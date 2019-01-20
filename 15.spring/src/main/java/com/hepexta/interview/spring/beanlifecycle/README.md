# Bean Lifecycle

* Instantiate (create instance from defenition)
* Populate properties
* Call BeanNameAware.setBeanName
* Call BeanFactoryAware.setBeanFactory
* PreInitialization (via BeanPostProcessors)
* @PostConstract
* PostInitialization (via BeanPostProcessors)

* @PreDestroy