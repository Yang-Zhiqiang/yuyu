CREATE VIEW JT_SateiJyuukasituChkInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     juukasitucheckkbn1 ,         /* 重過失チェック区分１ */
     juukasitucheckcomment1 ,         /* 重過失チェックコメント１ */
     juukasitucheckkbn2 ,         /* 重過失チェック区分２ */
     juukasitucheckcomment2 ,         /* 重過失チェックコメント２ */
     juukasitucheckkbn3 ,         /* 重過失チェック区分３ */
     juukasitucheckcomment3 ,         /* 重過失チェックコメント３ */
     juukasitucheckkbn4 ,         /* 重過失チェック区分４ */
     juukasitucheckcomment4 ,         /* 重過失チェックコメント４ */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SateiJyuukasituChkInfo_Z;