CREATE TABLE BM_ChkNenreiNensyuuTuusanS_Z (
     hhknfromnen                                        DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢自 */
     hhkntonen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢至 */
     hhknfromnensyuu                                    DECIMAL     (2)                                                       NOT NULL  ,  /* 被保険者年収区分自 */
     hhkntonensyuu                                      DECIMAL     (2)                                                       NOT NULL  ,  /* 被保険者年収区分至 */
     gnds1                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ１ */
     gnds1$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ１(通貨型) */
     gnds2                                              DECIMAL     (13)                                                                ,  /* 限度Ｓ２ */
     gnds2$                                             VARCHAR     (10)                                                                ,  /* 限度Ｓ２(通貨型) */
     itijibrgnds1                                       DECIMAL     (13)                                                                ,  /* 一時払限度Ｓ１ */
     itijibrgnds1$                                      VARCHAR     (10)                                                                ,  /* 一時払限度Ｓ１(通貨型) */
     itijibrgnds2                                       DECIMAL     (13)                                                                ,  /* 一時払限度Ｓ２ */
     itijibrgnds2$                                      VARCHAR     (10)                                                                ,  /* 一時払限度Ｓ２(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkNenreiNensyuuTuusanS_Z ADD CONSTRAINT PK_ChkNenreiNensyuuTuusanS PRIMARY KEY (
     hhknfromnen                                              , /* 被保険者年齢自 */
     hhkntonen                                                , /* 被保険者年齢至 */
     hhknfromnensyuu                                          , /* 被保険者年収区分自 */
     hhkntonensyuu                                              /* 被保険者年収区分至 */
) ;
