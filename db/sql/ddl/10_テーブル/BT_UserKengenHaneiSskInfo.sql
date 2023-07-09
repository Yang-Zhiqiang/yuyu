CREATE TABLE BT_UserKengenHaneiSskInfo (
     sosikicdkami3                                      VARCHAR     (3)                                                       NOT NULL  ,  /* 組織コード上３桁                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BT_UserKengenHaneiSskInfo ADD CONSTRAINT PK_UserKengenHaneiSskInfo PRIMARY KEY (
     sosikicdkami3                                              /* 組織コード上３桁                                       */
) ;
