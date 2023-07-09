CREATE TABLE AT_KinouKengen (
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kinouModeId                                        varchar     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ                                       */
     roleCd                                             varchar     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     siborikomiId                                       varchar     (50)                                                                ,  /* 絞込みID                                         */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_KinouKengen ADD CONSTRAINT AT_KinouKengenPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     kinouModeId                                              , /* 機能モードＩＤ                                        */
     roleCd                                                     /* ロールコード                                         */
) ;
