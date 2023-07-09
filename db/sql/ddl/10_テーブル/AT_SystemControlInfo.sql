CREATE TABLE AT_SystemControlInfo (
     systemCtrlInfo                                     VARCHAR     (8)                                                       NOT NULL  ,  /* システム制御情報                                      */
     mqEmgcyStopStatus                                  VARCHAR     (1)                                                       NOT NULL  ,  /* ＭＱ緊急停止状態区分                                    */
     onlineStatus                                       VARCHAR     (1)                                                       NOT NULL  ,  /* オンライン状態区分                                     */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_SystemControlInfo ADD CONSTRAINT AT_SystemControlInfoPk PRIMARY KEY (
     systemCtrlInfo                                             /* システム制御情報                                       */
) ;
