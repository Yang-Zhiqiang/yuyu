CREATE TABLE AT_KadouTimeGroup_Z (
     kadouTimeGroupCd                                   VARCHAR     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード */
     kadouTimeGroupNm                                   VARCHAR     (42)                                                                ,  /* 稼働時間グループ名 */
     kadouTimeGroupDescription                          VARCHAR     (202)                                                               ,  /* 稼働時間グループ備考 */
     holidayGroupCd                                     VARCHAR     (20)                                                                ,  /* 休日グループコード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_KadouTimeGroup_Z ADD CONSTRAINT AT_KadouTimeGroupPk PRIMARY KEY (
     kadouTimeGroupCd                                           /* 稼働時間グループコード */
) ;
