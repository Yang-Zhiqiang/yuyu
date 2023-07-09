CREATE TABLE AT_HaitaSeigyo (
     haitaSyuruiCd                                      varchar     (20)                                                      NOT NULL  ,  /* 排他種類コード                                       */
     haitaKey                                           varchar     (200)                                                     NOT NULL  ,  /* 排他キー                                          */
     haitamotoKinouId                                   varchar     (50)                                                      NOT NULL  ,  /* 排他元機能ＩＤ                                       */
     haitaUserId                                        varchar     (30)                                                      NOT NULL  ,  /* 排他ユーザーID                                      */
     haitaKaisiTime                                     varchar     (20)                                                      NOT NULL  ,  /* 排他開始時間                                        */
     haitaUniqueKey                                     varchar     (32)                                                      NOT NULL  ,  /* 排他ユニークキー                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_HaitaSeigyo ADD CONSTRAINT AT_HaitaSeigyoPk PRIMARY KEY (
     haitaSyuruiCd                                            , /* 排他種類コード                                        */
     haitaKey                                                   /* 排他キー                                           */
) ;
