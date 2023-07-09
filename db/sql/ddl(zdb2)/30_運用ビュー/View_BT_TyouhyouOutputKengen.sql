CREATE VIEW BT_TyouhyouOutputKengen AS SELECT
     roleCd ,         /* ロールコード */
     syoruiCd ,         /* 書類コード */
     ikkatuoutputkahikbn ,         /* 一括出力可否区分 */
     kobetuoutputkahikbn ,         /* 個別出力可否区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_TyouhyouOutputKengen_Z;