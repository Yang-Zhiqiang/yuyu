CREATE TABLE AT_KadouTime (
     kadouTimeGroupCd                                   varchar     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード                                   */
     kadouTimeYoubiKbn                                  varchar     (1)                                                       NOT NULL  ,  /* 稼働時間曜日区分                                      */
     eigyoubiKbn                                        varchar     (1)                                                       NOT NULL  ,  /* 営業日区分                                         */
     kadouTimeSiteiKbn                                  varchar     (1)                                                                 ,  /* 稼働時間指定区分                                      */
     kadouTimeFrom1                                     varchar     (4)                                                                 ,  /* 稼働時間１（自）                                      */
     kadouTimeTo1                                       varchar     (4)                                                                 ,  /* 稼働時間１（至）                                      */
     kadouTimeFrom2                                     varchar     (4)                                                                 ,  /* 稼働時間２（自）                                      */
     kadouTimeTo2                                       varchar     (4)                                                                 ,  /* 稼働時間２（至）                                      */
     kadouTimeFrom3                                     varchar     (4)                                                                 ,  /* 稼働時間３（自）                                      */
     kadouTimeTo3                                       varchar     (4)                                                                 ,  /* 稼働時間３（至）                                      */
     kadouTimeFrom4                                     varchar     (4)                                                                 ,  /* 稼働時間４（自）                                      */
     kadouTimeTo4                                       varchar     (4)                                                                 ,  /* 稼働時間４（至）                                      */
     kadouTimeFrom5                                     varchar     (4)                                                                 ,  /* 稼働時間５（自）                                      */
     kadouTimeTo5                                       varchar     (4)                                                                 ,  /* 稼働時間５（至）                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_KadouTime ADD CONSTRAINT AT_KadouTimePk PRIMARY KEY (
     kadouTimeGroupCd                                         , /* 稼働時間グループコード                                    */
     kadouTimeYoubiKbn                                        , /* 稼働時間曜日区分                                       */
     eigyoubiKbn                                                /* 営業日区分                                          */
) ;
