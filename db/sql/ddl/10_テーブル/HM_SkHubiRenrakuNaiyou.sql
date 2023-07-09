CREATE TABLE HM_SkHubiRenrakuNaiyou (
     skhubirenrakunaiyoucd                              VARCHAR     (2)                                                       NOT NULL  ,  /* 新契約不備連絡内容コード                                  */
     skhubirenrakunaiyou                                VARCHAR     (764)                                                               ,  /* 新契約不備連絡内容                                     */
     tyoubunflg                                         VARCHAR     (1)                                                                 ,  /* 長文フラグ                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_SkHubiRenrakuNaiyou ADD CONSTRAINT PK_SkHubiRenrakuNaiyou PRIMARY KEY (
     skhubirenrakunaiyoucd                                      /* 新契約不備連絡内容コード                                   */
) ;
