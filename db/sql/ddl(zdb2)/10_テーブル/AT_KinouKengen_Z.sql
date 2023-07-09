CREATE TABLE AT_KinouKengen_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     kinouModeId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ */
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード */
     siborikomiId                                       VARCHAR     (50)                                                                ,  /* 絞込みＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_KinouKengen_Z ADD CONSTRAINT AT_KinouKengenPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ */
     kinouModeId                                              , /* 機能モードＩＤ */
     roleCd                                                     /* ロールコード */
) ;
