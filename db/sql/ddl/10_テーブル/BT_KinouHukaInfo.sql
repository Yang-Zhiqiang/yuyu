CREATE TABLE BT_KinouHukaInfo (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     tjttrkskahi                                        VARCHAR     (1)                                                                 ,  /* 当日取消可否                                        */
     kensuuhyoujijyun                                   NUMBER      (2)                                                                 ,  /* 件数表示順                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BT_KinouHukaInfo ADD CONSTRAINT PK_KinouHukaInfo PRIMARY KEY (
     kinouId                                                    /* 機能ＩＤ                                           */
) ;
