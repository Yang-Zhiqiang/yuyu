CREATE VIEW AT_TyouhyouHozon AS SELECT
     reportKey ,         /* 帳票キー */
     pdfData ,         /* ＰＤＦデータ */
     tyouhyouJoinKey ,         /* 帳票結合キー */
     angoukaKbn ,         /* 暗号化区分 */
     pdfHozonKbn ,         /* ＰＤＦ保存区分 */
     zipHozonKbn ,         /* ＺＩＰ保存区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_TyouhyouHozon_Z;