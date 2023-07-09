CREATE VIEW BT_YendthnkSikinIdouListSks AS SELECT
     syono ,         /* 証券番号 */
     keiriyendthnkkbn ,         /* 経理用円建変更区分 */
     syoriYmd ,         /* 処理年月日 */
     siteituuka ,         /* 指定通貨 */
     siteituukagk ,         /* 指定通貨金額 */
     siteituukagk$ ,         /* 指定通貨金額(通貨型) */
     trhktuuka ,         /* 取引通貨 */
     trhktuukagk ,         /* 取引通貨金額 */
     trhktuukagk$ ,         /* 取引通貨金額(通貨型) */
     kbnkeirisegcd ,         /* 区分経理用セグメントコード */
     sikinidougroupkbn ,         /* 資金移動グループ区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_YendthnkSikinIdouListSks_Z;