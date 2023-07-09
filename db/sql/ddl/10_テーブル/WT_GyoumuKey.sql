CREATE TABLE WT_GyoumuKey (
     flowId                                             VARCHAR     (19)                                                      NOT NULL  ,  /* フローＩＤ */
     gyoumuKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 業務キー */
     tokenId                                            VARCHAR     (19)                                                                ,  /* トークンＩＤ */
     createTime                                         VARCHAR     (17)                                                                ,  /* 作成日時 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_GyoumuKey ADD CONSTRAINT PK_GyoumuKey PRIMARY KEY (
     flowId                                                   , /* フローＩＤ */
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_GYOUMUKEYIdx1 ON WT_GyoumuKey (
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_GYOUMUKEYIdx2 ON WT_GyoumuKey (
     tokenId                                                    /* トークンＩＤ */
) ;
