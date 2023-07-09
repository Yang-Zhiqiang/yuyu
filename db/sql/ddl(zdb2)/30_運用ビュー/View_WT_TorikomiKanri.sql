CREATE VIEW WT_TorikomiKanri AS SELECT
     iwfImageId ,         /* IWFイメージＩＤ */
     torikomiSyoruiCd ,         /* 取込書類コード */
     tourokuId ,         /* 登録者ＩＤ */
     tourokuTime ,         /* 登録時間 */
     extParam1 ,         /* 拡張パラメータ１ */
     extParam2 ,         /* 拡張パラメータ２ */
     extParam3 ,         /* 拡張パラメータ３ */
     extParam4 ,         /* 拡張パラメータ４ */
     extParam5 ,         /* 拡張パラメータ５ */
     extParam6 ,         /* 拡張パラメータ６ */
     extParam7 ,         /* 拡張パラメータ７ */
     extParam8 ,         /* 拡張パラメータ８ */
     extParam9 ,         /* 拡張パラメータ９ */
     extParam10 ,         /* 拡張パラメータ１０ */
     extParam11 ,         /* 拡張パラメータ１１ */
     extParam12 ,         /* 拡張パラメータ１２ */
     extParam13 ,         /* 拡張パラメータ１３ */
     extParam14 ,         /* 拡張パラメータ１４ */
     extParam15 ,         /* 拡張パラメータ１５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_TorikomiKanri_Z;