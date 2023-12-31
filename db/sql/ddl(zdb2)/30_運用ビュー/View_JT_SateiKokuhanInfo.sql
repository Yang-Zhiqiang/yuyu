CREATE VIEW JT_SateiKokuhanInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     kokuhancheckkbn1 ,         /* 告反チェック区分１ */
     kokuhanchecomment1 ,         /* 告反チェックコメント１ */
     kokuhancheckkbn2 ,         /* 告反チェック区分２ */
     kokuhanchecomment2 ,         /* 告反チェックコメント２ */
     kokuhancheckkbn3 ,         /* 告反チェック区分３ */
     kokuhanchecomment3 ,         /* 告反チェックコメント３ */
     kokuhancheckkbn4 ,         /* 告反チェック区分４ */
     kokuhanchecomment4 ,         /* 告反チェックコメント４ */
     kokuhancheckkbn5 ,         /* 告反チェック区分５ */
     kokuhanchecomment5 ,         /* 告反チェックコメント５ */
     kokuhancheckkbn6 ,         /* 告反チェック区分６ */
     kokuhanchecomment6 ,         /* 告反チェックコメント６ */
     kokuhancheckkbn7 ,         /* 告反チェック区分７ */
     kokuhanchecomment7 ,         /* 告反チェックコメント７ */
     kokuhancheckkbn8 ,         /* 告反チェック区分８ */
     kokuhanchecomment8 ,         /* 告反チェックコメント８ */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SateiKokuhanInfo_Z;