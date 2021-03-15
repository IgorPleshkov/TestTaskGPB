package ru.example.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ {

	public static volatile SingularAttribute<Message, LocalDateTime> dateTime;
	public static volatile SingularAttribute<Message, UUID> uuid;
	public static volatile SingularAttribute<Message, Status> status;

	public static final String DATE_TIME = "dateTime";
	public static final String UUID = "uuid";
	public static final String STATUS = "status";

}

