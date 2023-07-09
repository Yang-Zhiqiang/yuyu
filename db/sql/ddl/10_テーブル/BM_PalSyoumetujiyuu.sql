CREATE TABLE BM_PalSyoumetujiyuu (
     palsyoumetucd                                      VARCHAR     (4)                                                       NOT NULL  ,  /* ＰＡＬ消滅コード                                      */
     betukutikeiyakukbn                                 VARCHAR     (1)                                                       NOT NULL  ,  /* 別口契約区分                                        */
     syoumetujiyuuname                                  VARCHAR     (50)                                                                ,  /* 消滅事由名称                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_PalSyoumetujiyuu ADD CONSTRAINT PK_PalSyoumetujiyuu PRIMARY KEY (
     palsyoumetucd                                            , /* ＰＡＬ消滅コード                                       */
     betukutikeiyakukbn                                         /* 別口契約区分                                         */
) ;
