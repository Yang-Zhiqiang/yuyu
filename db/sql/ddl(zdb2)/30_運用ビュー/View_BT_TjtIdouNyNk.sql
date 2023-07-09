CREATE VIEW BT_TjtIdouNyNk AS SELECT
     nksysyno ,         /* 年金証書番号 */
     renno3keta ,         /* 連番（３桁） */
     recordsakujyohyouji ,         /* レコード削除表示 */
     youkyuuno ,         /* 要求通番 */
     syouhncd ,         /* 商品コード */
     nkshrstartymd ,         /* 年金支払開始日 */
     kykymd ,         /* 契約日 */
     nksyoumetucd ,         /* 年金消滅コード */
     syoumetuymd ,         /* 消滅日 */
     shrtuukasyu ,         /* 支払通貨種類 */
     teinksyu ,         /* 定額年金年金種類 */
     tsnyounkgns ,         /* 通算用年金原資 */
     tsnyounkgns$ ,         /* 通算用年金原資(通貨型) */
     nkukthhkndouhyouji ,         /* 年金受取人被保険者同一表示 */
     syouhnsdno ,         /* 商品世代番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_TjtIdouNyNk_Z;