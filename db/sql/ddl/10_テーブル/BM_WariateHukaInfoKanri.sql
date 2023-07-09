CREATE TABLE BM_WariateHukaInfoKanri (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     currenttskid                                       VARCHAR     (50)                                                      NOT NULL  ,  /* 現在タスクID */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     nexttskid                                          VARCHAR     (50)                                                                ,  /* 次回タスクID */
     wrthukatskid                                       VARCHAR     (50)                                                                ,  /* 割当不可タスクID */
     wrthukakaijyotskid                                 VARCHAR     (50)                                                                ,  /* 割当不可解除用タスクID */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_WariateHukaInfoKanri ADD CONSTRAINT PK_WariateHukaInfoKanri PRIMARY KEY (
     subSystemId                                              , /* サブシステムＩＤ */
     jimutetuzukicd                                           , /* 事務手続コード */
     currenttskid                                             , /* 現在タスクID */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_WariateHukaInfoKanri ON BM_WariateHukaInfoKanri (
     subSystemId                                              , /* サブシステムＩＤ */
     jimutetuzukicd                                           , /* 事務手続コード */
     currenttskid                                             , /* 現在タスクID */
     nexttskid                                                  /* 次回タスクID */
) ;
