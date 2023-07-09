CREATE TABLE AS_KinouModeSiborikomi (
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kinouModeId                                        varchar     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ                                       */
     siborikomiId                                       varchar     (50)                                                      NOT NULL  ,  /* 絞込みID                                         */
     siborikomiNm                                       varchar     (30)                                                                ,  /* 絞込み名                                          */
     defaultKbn                                         varchar     (1)                                                                 ,  /* デフォルト区分                                       */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_KinouModeSiborikomi ADD CONSTRAINT AS_KinouModeSiborikomiPk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     kinouModeId                                              , /* 機能モードＩＤ                                        */
     siborikomiId                                               /* 絞込みID                                          */
) ;
