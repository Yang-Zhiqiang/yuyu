CREATE TABLE WT_KouteiRireki (
     tokenId                                            VARCHAR     (19)                                                      NOT NULL  ,  /* トークンＩＤ */
     gyoumuKey                                          VARCHAR     (20)                                                                ,  /* 業務キー */
     rirekiKbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 履歴区分 */
     syoriTime                                          VARCHAR     (17)                                                      NOT NULL  ,  /* 処理時間 */
     flowId                                             VARCHAR     (19)                                                                ,  /* フローＩＤ */
     nodeId                                             VARCHAR     (200)                                                               ,  /* ノードＩＤ */
     nodeNm                                             VARCHAR     (50)                                                                ,  /* ノード名 */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ */
     iwfSyoriKbn                                        VARCHAR     (2)                                                                 ,  /* IWF処理区分 */
     rrkMsg                                             VARCHAR     (2000)                                                              ,  /* 履歴メッセージ */
     extInfo                                            BLOB                                                                            ,  /* 付加情報 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_KouteiRireki ADD CONSTRAINT PK_KouteiRireki PRIMARY KEY (
     tokenId                                                  , /* トークンＩＤ */
     rirekiKbn                                                , /* 履歴区分 */
     syoriTime                                                  /* 処理時間 */
) ;

CREATE INDEX WT_KOUTEIRIREKIIdx1 ON WT_KouteiRireki (
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_KOUTEIRIREKIIdx2 ON WT_KouteiRireki (
     flowId                                                     /* フローＩＤ */
) ;
