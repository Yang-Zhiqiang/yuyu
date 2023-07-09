CREATE TABLE BM_ChkTkykSyuNenreiHani (
     pmnjtkkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 保険料免除特約区分                                     */
     hhknfromnen                                        NUMBER      (3)                                                                 ,  /* 被保険者年齢自                                       */
     hhkntonen                                          NUMBER      (3)                                                                 ,  /* 被保険者年齢至                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkTkykSyuNenreiHani ADD CONSTRAINT PK_ChkTkykSyuNenreiHani PRIMARY KEY (
     pmnjtkkbn                                                  /* 保険料免除特約区分                                      */
) ;
