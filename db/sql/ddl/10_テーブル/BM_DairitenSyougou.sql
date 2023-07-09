CREATE TABLE BM_DairitenSyougou (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード                                        */
     kanjihoujinsyougou                                 VARCHAR     (40)                                                                ,  /* 漢字法人商号                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_DairitenSyougou ADD CONSTRAINT PK_DairitenSyougou PRIMARY KEY (
     drtencd                                                    /* 代理店コード                                         */
) ;
