CREATE VIEW IT_MukouTuuti AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     oyadrtencd ,         /* 親代理店コード */
     oyadrtennmkj ,         /* 親代理店名（漢字） */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsinadr4kj ,         /* 通信先住所４（漢字） */
     kyknmkj ,         /* 契約者名（漢字） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     kykymd ,         /* 契約日 */
     hrkkaisuu ,         /* 払込回数 */
     hrkp ,         /* 払込保険料 */
     hrkp$ ,         /* 払込保険料(通貨型) */
     yykknmnryymd ,         /* 猶予期間満了日 */
     rtratkicd ,         /* （帳票用）取扱コード */
     rtyouhyoucd ,         /* （帳票用）帳票コード */
     tyhyrenrakusikibetukbn ,         /* 帳票連絡先識別区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_MukouTuuti_Z;