CREATE TABLE AT_HaitaSeigyo (
     haitaSyuruiCd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 排他種類コード                                       */
     haitaKey                                           VARCHAR     (200)                                                     NOT NULL  ,  /* 排他キー                                          */
     haitamotoKinouId                                   VARCHAR     (50)                                                      NOT NULL  ,  /* 排他元機能ＩＤ                                       */
     haitaUserId                                        VARCHAR     (30)                                                      NOT NULL  ,  /* 排他ユーザーＩＤ                                      */
     haitaKaisiTime                                     VARCHAR     (17)                                                      NOT NULL  ,  /* 排他開始時間                                        */
     haitaUniqueKey                                     VARCHAR     (32)                                                      NOT NULL  ,  /* 排他ユニークキー                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_HaitaSeigyo ADD CONSTRAINT AT_HaitaSeigyoPk PRIMARY KEY (
     haitaSyuruiCd                                            , /* 排他種類コード                                        */
     haitaKey                                                   /* 排他キー                                           */
) ;
