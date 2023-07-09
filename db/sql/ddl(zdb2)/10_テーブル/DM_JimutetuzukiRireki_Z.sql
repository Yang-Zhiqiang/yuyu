CREATE TABLE DM_JimutetuzukiRireki_Z (
     kensuuHokanYmd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 件数保管日 */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     jimutetuzukinm                                     VARCHAR     (42)                                                                ,  /* 事務手続名 */
     imagerenkeikbn                                     VARCHAR     (1)                                                                 ,  /* イメージ連携区分 */
     hyoujijyun                                         DECIMAL     (2)                                                                 ,  /* 表示順 */
     syukouteijimutetuzukicd                            VARCHAR     (19)                                                                ,  /* 主工程事務手続コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE DM_JimutetuzukiRireki_Z ADD CONSTRAINT PK_BAK_Jimutetuzuki PRIMARY KEY (
     kensuuHokanYmd                                           , /* 件数保管日 */
     jimutetuzukicd                                           , /* 事務手続コード */
     subSystemId                                                /* サブシステムＩＤ */
) ;
