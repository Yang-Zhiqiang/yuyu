CREATE TABLE DT_SyoriKensuuHokanJimu (
     kensuuHokanYmd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 件数保管日 */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     accountId                                          VARCHAR     (30)                                                      NOT NULL  ,  /* アカウントＩＤ */
     zenjituzanKensuu                                   NUMBER      (6)                                                                 ,  /* 前日残件数 */
     zanKensuu                                          NUMBER      (6)                                                                 ,  /* 残件数 */
     kanryoKensuu                                       NUMBER      (6)                                                                 ,  /* 完了件数 */
     taskKanryouKensuuarihyouji                         NUMBER      (1)                                                                 ,  /* タスク完了件数有表示 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE DT_SyoriKensuuHokanJimu ADD CONSTRAINT PK_SyoriKensuuHokanJimu PRIMARY KEY (
     kensuuHokanYmd                                           , /* 件数保管日 */
     jimutetuzukicd                                           , /* 事務手続コード */
     accountId                                                  /* アカウントＩＤ */
) ;
