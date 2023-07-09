CREATE VIEW JT_SiRireki AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     shrsikibetukey ,         /* 支払識別キー */
     seikyuurirekino ,         /* 請求履歴番号 */
     shrkekkakbn ,         /* 支払結果区分 */
     shrsyoriymd ,         /* 支払処理日 */
     tyakkinymd ,         /* 着金日 */
     shrgkkei ,         /* 支払額合計 */
     shrgkkei$ ,         /* 支払額合計(通貨型) */
     zeitratkikbn ,         /* 税取扱区分 */
     torikesiflg ,         /* 取消フラグ */
     torikesiymd ,         /* 取消日 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SiRireki_Z;