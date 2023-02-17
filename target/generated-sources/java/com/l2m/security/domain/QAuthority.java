package com.l2m.security.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthority is a Querydsl query type for Authority
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthority extends EntityPathBase<Authority> {

    private static final long serialVersionUID = -1773442957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuthority authority = new QAuthority("authority");

    public final com.l2m.security.domain.global.QBaseEntity _super = new com.l2m.security.domain.global.QBaseEntity(this);

    public final StringPath businessKey = createString("businessKey");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDateTime = _super.createDateTime;

    //inherited
    public final StringPath createUserKey = _super.createUserKey;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDateTime = _super.updateDateTime;

    //inherited
    public final StringPath updateUserKey = _super.updateUserKey;

    public QAuthority(String variable) {
        this(Authority.class, forVariable(variable), INITS);
    }

    public QAuthority(Path<? extends Authority> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuthority(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuthority(PathMetadata metadata, PathInits inits) {
        this(Authority.class, metadata, inits);
    }

    public QAuthority(Class<? extends Authority> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

