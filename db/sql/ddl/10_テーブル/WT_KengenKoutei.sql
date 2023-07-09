CREATE TABLE WT_KengenKoutei (
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     flowId                                             VARCHAR     (19)                                                      NOT NULL  ,  /* フローＩＤ                                         */
     nodeId                                             VARCHAR     (200)                                                     NOT NULL  ,  /* ノードＩＤ                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE WT_KengenKoutei ADD CONSTRAINT PK_KengenKoutei PRIMARY KEY (
     roleCd                                                   , /* ロールコード                                         */
     flowId                                                   , /* フローＩＤ                                          */
     nodeId                                                     /* ノードＩＤ                                          */
) ;
