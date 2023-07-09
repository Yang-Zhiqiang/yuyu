CREATE TABLE IT_ItekiToukeiInfo (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     ketkekkacd                                         VARCHAR     (2)                                                                 ,  /* 決定結果コード                                       */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード                                     */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_ItekiToukeiInfo ADD CONSTRAINT PK_ItekiToukeiInfo PRIMARY KEY (
     syono                                                      /* 証券番号                                           */
) ;
