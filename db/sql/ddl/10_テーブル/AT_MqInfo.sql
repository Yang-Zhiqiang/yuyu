CREATE TABLE AT_MqInfo (
     serverType                                         VARCHAR     (4)                                                       NOT NULL  ,  /* サーバ種別                                         */
     mqOnlineStatus                                     VARCHAR     (1)                                                                 ,  /* ＭＱオンライン状態区分                                   */
     mqEmgcyStopStatus                                  VARCHAR     (1)                                                                 ,  /* ＭＱ緊急停止状態区分                                    */
     rkmAtesaki                                         VARCHAR     (8)                                                                 ,  /* 連携元宛先                                         */
     contextPath                                        VARCHAR     (50)                                                                ,  /* コンテキストパス                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_MqInfo ADD CONSTRAINT AT_MqInfoPk PRIMARY KEY (
     serverType                                                 /* サーバ種別                                          */
) ;
