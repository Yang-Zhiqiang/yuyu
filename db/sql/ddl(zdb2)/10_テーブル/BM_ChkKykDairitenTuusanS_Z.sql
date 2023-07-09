CREATE TABLE BM_ChkKykDairitenTuusanS_Z (
     kihonssyuruikbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 基本Ｓ種類区分 */
     gnds                                               DECIMAL     (13)                                                                ,  /* 限度Ｓ */
     gnds$                                              VARCHAR     (10)                                                                ,  /* 限度Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkKykDairitenTuusanS_Z ADD CONSTRAINT PK_ChkKykDairitenTuusanS PRIMARY KEY (
     kihonssyuruikbn                                            /* 基本Ｓ種類区分 */
) ;
