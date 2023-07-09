CREATE TABLE AT_KadouTime_Z (
     kadouTimeGroupCd                                   VARCHAR     (20)                                                      NOT NULL  ,  /* 稼働時間グループコード */
     kadouTimeYoubiKbn                                  VARCHAR     (1)                                                       NOT NULL  ,  /* 稼働時間曜日区分 */
     eigyoubiKbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 営業日区分 */
     kadouTimeSiteiKbn                                  VARCHAR     (1)                                                                 ,  /* 稼働時間指定区分 */
     kadouTimeFrom1                                     VARCHAR     (4)                                                                 ,  /* 稼働時間１（自） */
     kadouTimeTo1                                       VARCHAR     (4)                                                                 ,  /* 稼働時間１（至） */
     kadouTimeFrom2                                     VARCHAR     (4)                                                                 ,  /* 稼働時間２（自） */
     kadouTimeTo2                                       VARCHAR     (4)                                                                 ,  /* 稼働時間２（至） */
     kadouTimeFrom3                                     VARCHAR     (4)                                                                 ,  /* 稼働時間３（自） */
     kadouTimeTo3                                       VARCHAR     (4)                                                                 ,  /* 稼働時間３（至） */
     kadouTimeFrom4                                     VARCHAR     (4)                                                                 ,  /* 稼働時間４（自） */
     kadouTimeTo4                                       VARCHAR     (4)                                                                 ,  /* 稼働時間４（至） */
     kadouTimeFrom5                                     VARCHAR     (4)                                                                 ,  /* 稼働時間５（自） */
     kadouTimeTo5                                       VARCHAR     (4)                                                                 ,  /* 稼働時間５（至） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_KadouTime_Z ADD CONSTRAINT AT_KadouTimePk PRIMARY KEY (
     kadouTimeGroupCd                                         , /* 稼働時間グループコード */
     kadouTimeYoubiKbn                                        , /* 稼働時間曜日区分 */
     eigyoubiKbn                                                /* 営業日区分 */
) ;
