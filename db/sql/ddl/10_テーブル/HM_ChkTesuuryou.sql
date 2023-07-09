CREATE TABLE HM_ChkTesuuryou (
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁）                                        */
     hrkmtsry                                           NUMBER      (13)                                                                ,  /* 振込手数料                                         */
     hrkmtsry$                                          VARCHAR     (10)                                                                ,  /* 振込手数料(通貨型)                                    */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_ChkTesuuryou ADD CONSTRAINT PK_ChkTesuuryou PRIMARY KEY (
     renno3keta                                                 /* 連番（３桁）                                         */
) ;

CREATE INDEX IX1_ChkTesuuryou ON HM_ChkTesuuryou (
     hrkmtsry                                                   /* 振込手数料                                          */
) ;
