CREATE TABLE BM_Syoritanto_Z (
     syoricd                                            VARCHAR     (4)                                                       NOT NULL  ,  /* 処理コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_Syoritanto_Z ADD CONSTRAINT PK_Syoritanto PRIMARY KEY (
     syoricd                                                    /* 処理コード */
) ;
