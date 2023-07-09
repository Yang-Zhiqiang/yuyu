CREATE TABLE BM_ChkJhTuusanS_Z (
     hhknfromnen                                        DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢自 */
     hhkntonen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢至 */
     gnds1                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ１ */
     gnds1$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ１(通貨型) */
     gnds2                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ２ */
     gnds2$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ２(通貨型) */
     gnds3                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ３ */
     gnds3$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ３(通貨型) */
     gnds4                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ４ */
     gnds4$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ４(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkJhTuusanS_Z ADD CONSTRAINT PK_ChkJhTuusanS PRIMARY KEY (
     hhknfromnen                                              , /* 被保険者年齢自 */
     hhkntonen                                                  /* 被保険者年齢至 */
) ;
