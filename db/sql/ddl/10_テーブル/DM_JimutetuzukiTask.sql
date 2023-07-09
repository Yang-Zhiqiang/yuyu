CREATE TABLE DM_JimutetuzukiTask (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード                                       */
     workflowTskId                                      VARCHAR     (50)                                                      NOT NULL  ,  /* ワークフロータスクID                                   */
     workflowTskNm                                      VARCHAR     (25)                                                                ,  /* ワークフロータスク名                                    */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順                                           */
     worklistHyoujiFlag                                 NUMBER      (1)                                                                 ,  /* 工程ワークリスト表示フラグ                                 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE DM_JimutetuzukiTask ADD CONSTRAINT DM_JimutetuzukiTaskPk PRIMARY KEY (
     subSystemId                                              , /* サブシステムＩＤ                                       */
     jimutetuzukicd                                           , /* 事務手続コード                                        */
     workflowTskId                                              /* ワークフロータスクID                                    */
) ;
