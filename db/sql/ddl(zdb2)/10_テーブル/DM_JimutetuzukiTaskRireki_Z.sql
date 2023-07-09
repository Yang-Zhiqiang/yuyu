CREATE TABLE DM_JimutetuzukiTaskRireki_Z (
     kensuuHokanYmd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 件数保管日 */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     workflowTskId                                      VARCHAR     (50)                                                      NOT NULL  ,  /* ワークフロータスクID */
     workflowTskNm                                      VARCHAR     (52)                                                                ,  /* ワークフロータスク名 */
     hyoujijyun                                         DECIMAL     (2)                                                                 ,  /* 表示順 */
     worklistHyoujiFlag                                 DECIMAL     (1)                                                                 ,  /* 工程ワークリスト表示フラグ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE DM_JimutetuzukiTaskRireki_Z ADD CONSTRAINT PK_BAK_JimutetuzukiTask PRIMARY KEY (
     kensuuHokanYmd                                           , /* 件数保管日 */
     subSystemId                                              , /* サブシステムＩＤ */
     jimutetuzukicd                                           , /* 事務手続コード */
     workflowTskId                                              /* ワークフロータスクID */
) ;
