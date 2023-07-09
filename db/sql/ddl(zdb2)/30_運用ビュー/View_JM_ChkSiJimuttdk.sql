CREATE VIEW JM_ChkSiJimuttdk AS SELECT
     kinouId ,         /* 機能ＩＤ */
     syorijimuttdkcd ,         /* 処理中事務手続コード */
     sknaiyouchkkbn ,         /* 請求内容チェック区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_ChkSiJimuttdk_Z;