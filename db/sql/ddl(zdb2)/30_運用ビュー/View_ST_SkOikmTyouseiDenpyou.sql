CREATE VIEW ST_SkOikmTyouseiDenpyou AS SELECT
     mosno ,         /* 申込番号 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     taisyakukbn ,         /* 貸借区分 */
     naibukeiyakukbn ,         /* 内部契約区分 */
     tekiyoukbn ,         /* 摘要区分 */
     seg1cd ,         /* セグメント１コード */
     huridenatesakicd ,         /* 振替伝票宛先部課コード */
     tantocd ,         /* 担当コード */
     denkanjokamokucd ,         /* 伝票用勘定科目コード */
     tekiyoucd ,         /* 摘要コード */
     suitoubumoncd ,         /* 出納部門コード */
     denyenkagk ,         /* 伝票金額（円） */
     denyenkagk$ ,         /* 伝票金額（円）(通貨型) */
     huridenpagekbn ,         /* 振替伝票ページ区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ST_SkOikmTyouseiDenpyou_Z;