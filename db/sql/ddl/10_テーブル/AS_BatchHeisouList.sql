CREATE TABLE AS_BatchHeisouList (
     selfKinouId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* 自機能ＩＤ                                         */
     targetKinouId                                      VARCHAR     (50)                                                      NOT NULL  ,  /* 対象機能ＩＤ                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_BatchHeisouList ADD CONSTRAINT AS_BatchHeisouListPk PRIMARY KEY (
     selfKinouId                                              , /* 自機能ＩＤ                                          */
     targetKinouId                                              /* 対象機能ＩＤ                                         */
) ;
