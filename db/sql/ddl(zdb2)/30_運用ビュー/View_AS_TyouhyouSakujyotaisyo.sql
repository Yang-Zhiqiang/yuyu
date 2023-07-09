CREATE VIEW AS_TyouhyouSakujyotaisyo AS SELECT
     syoruiCd ,         /* 書類コード */
     hozonKikan ,         /* 保存期間 */
     nengetukbn ,         /* 年月区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_TyouhyouSakujyotaisyo_Z;