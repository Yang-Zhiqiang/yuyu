CREATE TABLE AT_KadouTimeGroup (
     kadouTimeGroupCd                                   VARCHAR     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード */
     kadouTimeGroupNm                                   VARCHAR     (20)                                                                ,  /* 稼働時間グループ名 */
     kadouTimeGroupDescription                          VARCHAR     (100)                                                               ,  /* 稼働時間グループ備考 */
     holidayGroupCd                                     VARCHAR     (20)                                                                ,  /* 休日グループコード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AT_KadouTimeGroup ADD CONSTRAINT AT_KadouTimeGroupPk PRIMARY KEY (
     kadouTimeGroupCd                                           /* 稼働時間グループコード */
) ;
