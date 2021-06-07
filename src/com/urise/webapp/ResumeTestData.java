package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
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

        ArrayList<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization("Java Online Projects", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", LocalDate.of(2013,10,0), LocalDate.now()));
        organizations.add(new Organization("Wrike", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.", LocalDate.of(2014,10, 0), LocalDate.of(2016, 1, 0)));
        organizations.add(new Organization("RIT Center", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python", LocalDate.of(2012,4, 0), LocalDate.of(2014, 10, 0)));

        ArrayList<Organization> educations = new ArrayList<>();
        educations.add(new Organization("Coursera", "", "Functional Programming Principles in Scala\" by Martin Odersky", LocalDate.of(2013,3,0), LocalDate.of(2013,5,0)));
        educations.add(new Organization("Luxoft", "", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", LocalDate.of(2011,3,0), LocalDate.of(2011,4,0)));
        educations.add(new Organization("Siemens AG", "", "3 месяца обучения мобильным IN сетям (Берлин)", LocalDate.of(2005,1,0), LocalDate.of(2005,4,0)));
        educations.add(new Organization("Alcatel", "", "6 месяцев обучения цифровым телефонным сетям (Москва)", LocalDate.of(1997,9,0), LocalDate.of(1998,3,0)));
        educations.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "", "Инженер (программист Fortran, C)", LocalDate.of(1987,9,0), LocalDate.of(1993,7,0)));

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
        kislinResume.addSection(SectionType.EXPERIENCE, new OrganizationSection(organizations));
        kislinResume.addSection(SectionType.EDUCATION, new OrganizationSection(educations));

    }
}
