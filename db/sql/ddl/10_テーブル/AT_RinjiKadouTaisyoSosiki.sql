CREATE TABLE AT_RinjiKadouTaisyoSosiki (
     kadouSosikiCd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* 稼働組織コード                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_RinjiKadouTaisyoSosiki ADD CONSTRAINT AT_RinjiKadouTaisyoSosikiPk PRIMARY KEY (
     kadouSosikiCd                                              /* 稼働組織コード                                        */
) ;
