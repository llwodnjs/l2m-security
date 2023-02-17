package com.l2m.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBusinessKeyStore is a Querydsl query type for BusinessKeyStore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusinessKeyStore extends EntityPathBase<BusinessKeyStore> {

    private static final long serialVersionUID = 1222302322L;

    public static final QBusinessKeyStore businessKeyStore = new QBusinessKeyStore("businessKeyStore");

    public final StringPath businessKey = createString("businessKey");

    public final DateTimePath<java.time.LocalDateTime> createDateTime = createDateTime("createDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBusinessKeyStore(String variable) {
        super(BusinessKeyStore.class, forVariable(variable));
    }

    public QBusinessKeyStore(Path<? extends BusinessKeyStore> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusinessKeyStore(PathMetadata metadata) {
        super(BusinessKeyStore.class, metadata);
    }

}

