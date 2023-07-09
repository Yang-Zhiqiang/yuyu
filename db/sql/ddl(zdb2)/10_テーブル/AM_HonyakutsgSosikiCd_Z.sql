CREATE TABLE AM_HonyakutsgSosikiCd_Z (
     sosikicd                                           VARCHAR     (7)                                                       NOT NULL  ,  /* 組織コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_HonyakutsgSosikiCd_Z ADD CONSTRAINT AM_HonyakutsgSosikiCdPk PRIMARY KEY (
     sosikicd                                                   /* 組織コード */
) ;
