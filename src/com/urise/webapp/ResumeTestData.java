package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;

public class ResumeTestData {
    public static void main(String[] args) {
        ArrayList<String> achievments = new ArrayList<>();
        achievments.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievments.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievments.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievments.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievments.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievments.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        ArrayList<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");

        ArrayList<Organization> experience = new ArrayList<>();
        experience.add(new Organization("Java Online Projects", new Organization.Position("Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", YearMonth.of(2013, 10), YearMonth.now())));
        experience.add(new Organization("Wrike", new Organization.Position("Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", YearMonth.of(2014, 10), YearMonth.of(2016, 1))));
        experience.add(new Organization("RIT Center", new Organization.Position("Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python", YearMonth.of(2012, 4), YearMonth.of(2014, 10))));
        experience.add(new Organization("Luxoft (Deutsche Bank)", new Organization.Position("Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.", YearMonth.of(2010, 12), YearMonth.of(2012, 04))));
        experience.add(new Organization("Yota", new Organization.Position("Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)", YearMonth.of(2008, 6), YearMonth.of(2010, 12))));
        experience.add(new Organization("Enkata", new Organization.Position("Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).", YearMonth.of(2007, 3), YearMonth.of(2008, 6))));
        experience.add(new Organization("Siemens AG", new Organization.Position("Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).", YearMonth.of(2005, 1), YearMonth.of(2005, 2))));
        experience.add(new Organization("Alcatel", new Organization.Position("Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).", YearMonth.of(1997, 9), YearMonth.of(2005, 1))));

        ArrayList<Organization> educations = new ArrayList<>();
        educations.add(new Organization("Coursera", new Organization.Position("Functional Programming Principles in Scala\" by Martin Odersky", "", YearMonth.of(2013, 3), YearMonth.of(2013, 5))));
        educations.add(new Organization("Luxoft", new Organization.Position("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "", YearMonth.of(2011, 3), YearMonth.of(2011, 4))));
        educations.add(new Organization("Siemens AG", new Organization.Position("3 месяца обучения мобильным IN сетям (Берлин)", "", YearMonth.of(2005, 1), YearMonth.of(2005, 4))));
        educations.add(new Organization("Alcatel", new Organization.Position("6 месяцев обучения цифровым телефонным сетям (Москва)", "", YearMonth.of(1997, 9), YearMonth.of(1998, 3))));
        educations.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", new Organization.Position("Аспирантура (программист С, С++)", "", YearMonth.of(1993, 9), YearMonth.of(1996, 7)), new Organization.Position("Инженер (программист Fortran, C)", "", YearMonth.of(1987, 9), YearMonth.of(1993, 7))));

        Resume kislinResume = new Resume("r01", "Григорий Кислин");
        kislinResume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        kislinResume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        kislinResume.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        kislinResume.addContact(ContactType.LINK, "https://www.linkedin.com/in/gkislin");
        kislinResume.addContact(ContactType.LINK2, "https://github.com/gkislin");
        kislinResume.addContact(ContactType.LINK3, "https://stackoverflow.com/users/548473");

        kislinResume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        kislinResume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        kislinResume.addSection(SectionType.ACHIEVMENT, new ListSection(achievments));
        kislinResume.addSection(SectionType.QUALIFICATIONS, new ListSection(qualifications));
        kislinResume.addSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        kislinResume.addSection(SectionType.EDUCATION, new OrganizationSection(educations));

        System.out.println(kislinResume.getFullName());
        System.out.println("\n-----Контакты-----");
        for (ContactType ct: ContactType.values()) {
        	System.out.println(ct.getTitle() + ": " + kislinResume.getContact(ct));
        }
        
        for (SectionType st: SectionType.values()) {
            System.out.println("\n-----" + st.getTitle() +"-----");
            System.out.println(kislinResume.getSection(st).toString());
        }
    }
}
