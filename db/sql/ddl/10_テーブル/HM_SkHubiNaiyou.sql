CREATE TABLE HM_SkHubiNaiyou (
     skhubikoumokucd                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 新契約不備項目コード                                    */
     skhubinaiyoucd                                     VARCHAR     (5)                                                       NOT NULL  ,  /* 新契約不備内容コード                                    */
     skhubinaiyou                                       VARCHAR     (40)                                                                ,  /* 新契約不備内容                                       */
     skhubinaiyousentakumongon                          VARCHAR     (25)                                                                ,  /* 新契約不備内容選択文言                                   */
     skseibisijinaiyoucd                                VARCHAR     (2)                                                                 ,  /* 新契約整備指示内容コード                                  */
     skhubirenrakunaiyoucd                              VARCHAR     (2)                                                                 ,  /* 新契約不備連絡内容コード                                  */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順                                           */
     hyoujikahikbn                                      VARCHAR     (1)                                                                 ,  /* 表示可否区分                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_SkHubiNaiyou ADD CONSTRAINT PK_SkHubiNaiyou PRIMARY KEY (
     skhubikoumokucd                                          , /* 新契約不備項目コード                                     */
     skhubinaiyoucd                                             /* 新契約不備内容コード                                     */
) ;
