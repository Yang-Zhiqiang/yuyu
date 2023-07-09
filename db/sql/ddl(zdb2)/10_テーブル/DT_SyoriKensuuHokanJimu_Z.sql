CREATE TABLE DT_SyoriKensuuHokanJimu_Z (
     kensuuHokanYmd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 件数保管日 */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     accountId                                          VARCHAR     (30)                                                      NOT NULL  ,  /* アカウントＩＤ */
     zenjituzanKensuu                                   DECIMAL     (6)                                                                 ,  /* 前日残件数 */
     zanKensuu                                          DECIMAL     (6)                                                                 ,  /* 残件数 */
     kanryoKensuu                                       DECIMAL     (6)                                                                 ,  /* 完了件数 */
     taskKanryouKensuuarihyouji                         DECIMAL     (1)                                                                 ,  /* タスク完了件数有表示 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE DT_SyoriKensuuHokanJimu_Z ADD CONSTRAINT PK_SyoriKensuuHokanJimu PRIMARY KEY (
     kensuuHokanYmd                                           , /* 件数保管日 */
     jimutetuzukicd                                           , /* 事務手続コード */
     accountId                                                  /* アカウントＩＤ */
) ;
