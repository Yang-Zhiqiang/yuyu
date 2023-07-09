CREATE TABLE IM_KhTtdkTyuuikahi (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     ttdktyuuikbn                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 手続注意区分                                        */
     syorikahikbn                                       VARCHAR     (1)                                                                 ,  /* 処理可否区分                                        */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IM_KhTtdkTyuuikahi ADD CONSTRAINT PK_KhTtdkTyuuikahi PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     ttdktyuuikbn                                               /* 手続注意区分                                         */
) ;
