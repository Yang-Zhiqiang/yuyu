CREATE TABLE WM_TorikomiDaiBunrui_Z (
     syzkDaiBunruiId                                    VARCHAR     (30)                                                      NOT NULL  ,  /* 所属大分類ＩＤ */
     syzkDaiBunruiNm                                    VARCHAR     (125)                                                               ,  /* 所属大分類名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE WM_TorikomiDaiBunrui_Z ADD CONSTRAINT PK_TorikomiDaiBunrui PRIMARY KEY (
     syzkDaiBunruiId                                            /* 所属大分類ＩＤ */
) ;
