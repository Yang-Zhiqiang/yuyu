CREATE TABLE BM_DairitenSyougou_Z (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     kanjihoujinsyougou                                 VARCHAR     (82)                                                                ,  /* 漢字法人商号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_DairitenSyougou_Z ADD CONSTRAINT PK_DairitenSyougou PRIMARY KEY (
     drtencd                                                    /* 代理店コード */
) ;
