CREATE VIEW BT_YendthnkSikinIdouData AS SELECT
     syono ,         /* 証券番号 */
     keiriyendthnkkbn ,         /* 経理用円建変更区分 */
     syoriYmd ,         /* 処理年月日 */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     siteituuka ,         /* 指定通貨 */
     siteituukagk ,         /* 指定通貨金額 */
     siteituukagk$ ,         /* 指定通貨金額(通貨型) */
     trhktuuka ,         /* 取引通貨 */
     trhktuukagk ,         /* 取引通貨金額 */
     trhktuukagk$ ,         /* 取引通貨金額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_YendthnkSikinIdouData_Z;