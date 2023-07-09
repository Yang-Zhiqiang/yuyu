CREATE TABLE WM_TorikomiSyouBunrui_Z (
     syzkSyouBunruiId                                   VARCHAR     (30)                                                      NOT NULL  ,  /* 所属小分類ＩＤ */
     syzkSyouBunruiNm                                   VARCHAR     (125)                                                               ,  /* 所属小分類名 */
     syzkDaiBunruiId                                    VARCHAR     (30)                                                                ,  /* 所属大分類ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE WM_TorikomiSyouBunrui_Z ADD CONSTRAINT PK_TorikomiSyouBunrui PRIMARY KEY (
     syzkSyouBunruiId                                           /* 所属小分類ＩＤ */
) ;
