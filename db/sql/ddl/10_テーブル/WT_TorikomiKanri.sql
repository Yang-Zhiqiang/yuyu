CREATE TABLE WT_TorikomiKanri (
     iwfImageId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* IWFイメージＩＤ */
     torikomiSyoruiCd                                   VARCHAR     (30)                                                                ,  /* 取込書類コード */
     tourokuId                                          VARCHAR     (30)                                                                ,  /* 登録者ＩＤ */
     tourokuTime                                        VARCHAR     (17)                                                                ,  /* 登録時間 */
     extParam1                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ１ */
     extParam2                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ２ */
     extParam3                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ３ */
     extParam4                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ４ */
     extParam5                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ５ */
     extParam6                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ６ */
     extParam7                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ７ */
     extParam8                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ８ */
     extParam9                                          VARCHAR     (50)                                                                ,  /* 拡張パラメータ９ */
     extParam10                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１０ */
     extParam11                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１１ */
     extParam12                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１２ */
     extParam13                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１３ */
     extParam14                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１４ */
     extParam15                                         VARCHAR     (50)                                                                ,  /* 拡張パラメータ１５ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_TorikomiKanri ADD CONSTRAINT PK_TorikomiKanri PRIMARY KEY (
     iwfImageId                                                 /* IWFイメージＩＤ */
) ;

CREATE INDEX WT_TorikomiKanriIdx1 ON WT_TorikomiKanri (
     torikomiSyoruiCd                                           /* 取込書類コード */
) ;

CREATE INDEX WT_TorikomiKanriIdx2 ON WT_TorikomiKanri (
     tourokuTime                                                /* 登録時間 */
) ;
