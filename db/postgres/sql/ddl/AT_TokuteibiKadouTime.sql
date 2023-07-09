CREATE TABLE AT_TokuteibiKadouTime (
     kadouTimeGroupCd                                   varchar     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード                                   */
     kadouTimeSiteiYmd                                  varchar     (8)                                                       NOT NULL  ,  /* 稼働時間指定年月日                                     */
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

ALTER TABLE AT_TokuteibiKadouTime ADD CONSTRAINT AT_TokuteibiKadouTimePK PRIMARY KEY (
     kadouTimeGroupCd                                         , /* 稼働時間グループコード                                    */
     kadouTimeSiteiYmd                                          /* 稼働時間指定年月日                                      */
) ;
