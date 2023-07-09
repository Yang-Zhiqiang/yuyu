CREATE VIEW IT_KhHenreikin AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     henkousikibetukey ,         /* 変更識別キー */
     hrsyuruikbn ,         /* 返戻金種類区分 */
     shrymd ,         /* 支払日 */
     shrsyoriymd ,         /* 支払処理日 */
     hrhsisyoriymd ,         /* 返戻金発生処理日 */
     hrhsiymd ,         /* 返戻金発生日 */
     henreikingk ,         /* 返戻金額 */
     henreikingk$ ,         /* 返戻金額(通貨型) */
     hrsiharaijyoutaikbn ,         /* 返戻金支払状態区分 */
     seg1cd ,         /* セグメント１コード */
     seg2cd ,         /* セグメント２コード */
     tantocd ,         /* 担当コード */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhHenreikin_Z;