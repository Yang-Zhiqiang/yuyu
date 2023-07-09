CREATE TABLE BM_TantouCd_Z (
     tantocd                                            VARCHAR     (1)                                                       NOT NULL  ,  /* 担当コード */
     busitucd                                           VARCHAR     (3)                                                                 ,  /* 部・室コード */
     tantounm                                           VARCHAR     (102)                                                               ,  /* 担当名 */
     busitunm                                           VARCHAR     (42)                                                                ,  /* 部・室名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_TantouCd_Z ADD CONSTRAINT PK_TantouCd PRIMARY KEY (
     tantocd                                                    /* 担当コード */
) ;
