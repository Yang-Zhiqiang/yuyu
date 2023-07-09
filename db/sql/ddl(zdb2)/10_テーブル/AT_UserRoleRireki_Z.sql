CREATE TABLE AT_UserRoleRireki_Z (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ */
     roleCd                                             VARCHAR     (30)                                                                ,  /* ロールコード */
     rirekiSyuruiKbn                                    VARCHAR     (1)                                                                 ,  /* 履歴種類区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_UserRoleRireki_Z ADD CONSTRAINT AT_UserRoleRirekiPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;
