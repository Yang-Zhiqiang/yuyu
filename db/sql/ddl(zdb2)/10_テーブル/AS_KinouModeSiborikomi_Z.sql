CREATE TABLE AS_KinouModeSiborikomi_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     kinouModeId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ */
     siborikomiId                                       VARCHAR     (50)                                                      NOT NULL  ,  /* 絞込みＩＤ */
     siborikomiNm                                       VARCHAR     (32)                                                                ,  /* 絞込み名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_KinouModeSiborikomi_Z ADD CONSTRAINT AS_KinouModeSiborikomiPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ */
     kinouModeId                                              , /* 機能モードＩＤ */
     siborikomiId                                               /* 絞込みＩＤ */
) ;
