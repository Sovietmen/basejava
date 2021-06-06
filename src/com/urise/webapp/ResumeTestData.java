package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

public class ResumeTestData {
    public static void main(String[] args) {

        Resume kislinResume = new Resume("r01", "Григорий Кислин");
        kislinResume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        kislinResume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        kislinResume.addContact(ContactType.SKYPE, "skype:grigory.kislin");
        kislinResume.addContact(ContactType.LINK, "https://www.linkedin.com/in/gkislin");
        kislinResume.addContact(ContactType.LINK2, "https://github.com/gkislin");
        kislinResume.addContact(ContactType.LINK3, "https://stackoverflow.com/users/548473");
        kislinResume.setObjective("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        kislinResume.setPersonal("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        kislinResume.setAchievement("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        kislinResume.setAchievement("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");

        System.out.println("---UUID---");
        System.out.println(kislinResume.getUuid());
        System.out.println("---Full name---");
        System.out.println(kislinResume.getFullName());
        System.out.println("---" + ContactType.PHONE.getTitle() + "---");
        System.out.println(kislinResume.getContact(ContactType.PHONE));
        System.out.println("---" + ContactType.SKYPE.getTitle() + "---");
        System.out.println(kislinResume.getContact(ContactType.SKYPE));
        System.out.println("---" + ContactType.MAIL.getTitle() + "---");
        System.out.println(kislinResume.getContact(ContactType.MAIL));
        System.out.println("---" + SectionType.OBJECTIVE.getTitle() + "---");
        System.out.println(kislinResume.getObjective().getContent());
        System.out.println("---" + SectionType.PERSONAL.getTitle() + "---");
        System.out.println(kislinResume.getPersonal().getContent());
        System.out.println("---" + SectionType.ACHIEVMENT.getTitle() + "---");
        for (String s : kislinResume.getAchievement().getContent()) {
            System.out.println(s);
        }
    }
}
