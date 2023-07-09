CREATE TABLE AT_HolidayGroup (
     holidayGroupCd                                     VARCHAR     (20)                                                      NOT NULL  ,  /* 休日グループコード */
     holidayGroupNm                                     VARCHAR     (20)                                                                ,  /* 休日グループ名 */
     holidayGroupDescription                            VARCHAR     (100)                                                               ,  /* 休日グループ備考 */
     sysSiyouKbn                                        VARCHAR     (1)                                                                 ,  /* システム使用区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AT_HolidayGroup ADD CONSTRAINT AT_HolidayGroupPk PRIMARY KEY (
     holidayGroupCd                                             /* 休日グループコード */
) ;
