CREATE TABLE BM_ChkItijibrTuusanS_Z (
     hhknfromnen                                        DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢自 */
     hhkntonen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢至 */
     gnds                                               DECIMAL     (13)                                                                ,  /* 限度Ｓ */
     gnds$                                              VARCHAR     (10)                                                                ,  /* 限度Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkItijibrTuusanS_Z ADD CONSTRAINT PK_ChkItijibrTuusanS PRIMARY KEY (
     hhknfromnen                                              , /* 被保険者年齢自 */
     hhkntonen                                                  /* 被保険者年齢至 */
) ;
