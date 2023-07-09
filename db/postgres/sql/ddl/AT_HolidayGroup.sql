CREATE TABLE AT_HolidayGroup (
     holidayGroupCd                                     varchar     (20)                                                      NOT NULL  ,  /* 休日グループコード                                     */
     holidayGroupNm                                     varchar     (40)                                                                ,  /* 休日グループ名                                       */
     holidayGroupDescription                            varchar     (200)                                                               ,  /* 休日グループ備考                                      */
     sysSiyouKbn                                        varchar     (1)                                                                 ,  /* システム使用区分                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_HolidayGroup ADD CONSTRAINT AT_HolidayGroupPk PRIMARY KEY (
     holidayGroupCd                                             /* 休日グループコード                                      */
) ;
