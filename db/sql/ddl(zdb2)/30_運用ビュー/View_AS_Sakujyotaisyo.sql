CREATE VIEW AS_Sakujyotaisyo AS SELECT
     sakujyoTableId ,         /* 削除対象テーブルＩＤ */
     sakujyoKbn ,         /* 削除区分 */
     sakujyoKey ,         /* 削除キー */
     sakujyoKeyKbn ,         /* 削除キー区分 */
     hozonKikan ,         /* 保存期間 */
     nengappiKbn ,         /* 年月日区分 */
     dataTaihiKbn ,         /* データ退避区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_Sakujyotaisyo_Z;