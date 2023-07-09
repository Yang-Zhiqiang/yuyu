CREATE TABLE WT_KouteiLock (
     lockTime                                           VARCHAR     (17)                                                                ,  /* ロック時間 */
     lockKey                                            VARCHAR     (30)                                                                ,  /* ロックキー */
     gyoumuKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 業務キー */
     flowId                                             VARCHAR     (19)                                                      NOT NULL  ,  /* フローＩＤ */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ */
     nodeNm                                             VARCHAR     (50)                                                                ,  /* ノード名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_KouteiLock ADD CONSTRAINT PK_KouteiLock PRIMARY KEY (
     flowId                                                   , /* フローＩＤ */
     gyoumuKey                                                  /* 業務キー */
) ;

CREATE INDEX WT_KouteiLockIdx1 ON WT_KouteiLock (
     lockTime                                                   /* ロック時間 */
) ;
