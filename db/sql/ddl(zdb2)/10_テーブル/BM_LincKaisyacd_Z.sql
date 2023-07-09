CREATE TABLE BM_LincKaisyacd_Z (
     linckaisyacdnum                                    VARCHAR     (2)                                                       NOT NULL  ,  /* ＬＩＮＣ会社コード（数字） */
     linckaisyanm                                       VARCHAR     (62)                                                                ,  /* ＬＩＮＣ会社名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_LincKaisyacd_Z ADD CONSTRAINT PK_LincKaisyacd PRIMARY KEY (
     linckaisyacdnum                                            /* ＬＩＮＣ会社コード（数字） */
) ;
