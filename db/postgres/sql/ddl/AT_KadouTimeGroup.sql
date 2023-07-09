CREATE TABLE AT_KadouTimeGroup (
     kadouTimeGroupCd                                   varchar     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード                                   */
     kadouTimeGroupNm                                   varchar     (40)                                                                ,  /* 稼働時間グループ名                                     */
     kadouTimeGroupDescription                          varchar     (200)                                                               ,  /* 稼働時間グループ備考                                    */
     holidayGroupCd                                     varchar     (20)                                                                ,  /* 休日グループコード                                     */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_KadouTimeGroup ADD CONSTRAINT AT_KadouTimeGroupPk PRIMARY KEY (
     kadouTimeGroupCd                                           /* 稼働時間グループコード                                    */
) ;
