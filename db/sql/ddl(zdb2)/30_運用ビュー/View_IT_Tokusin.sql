CREATE VIEW IT_Tokusin AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tokusinkbn ,         /* 特伸区分 */
     tokusinsyoriymd ,         /* 特伸処理年月日 */
     hsgymd ,         /* 被災害年月日 */
     tokusinendymd ,         /* 特伸終了日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_Tokusin_Z;