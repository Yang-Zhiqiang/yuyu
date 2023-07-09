CREATE VIEW IW_KhKzkPYokuJyuutouYoteiWk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syouhncd ,         /* 商品コード */
     kyktuukasyu ,         /* 契約通貨種類 */
     kykym ,         /* 契約年月 */
     jyuutouym ,         /* 充当年月 */
     hknkkn ,         /* 保険期間 */
     hokenryou ,         /* 保険料 */
     hokenryou$ ,         /* 保険料(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhKzkPYokuJyuutouYoteiWk_Z;