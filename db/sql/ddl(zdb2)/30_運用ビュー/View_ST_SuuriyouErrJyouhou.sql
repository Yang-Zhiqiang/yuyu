CREATE VIEW ST_SuuriyouErrJyouhou AS SELECT
     syoriYmd ,         /* 処理年月日 */
     kakutyoujobcd ,         /* 拡張ジョブコード */
     syono ,         /* 証券番号 */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     suuritoukeiyouerrnaiyou ,         /* 数理統計用エラー内容 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ST_SuuriyouErrJyouhou_Z;