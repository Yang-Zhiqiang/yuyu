CREATE VIEW MT_DsMailHaisinYoyaku AS SELECT
     dsmailhaisinyoyakuskbtkey ,         /* ＤＳメール配信予約識別キー */
     dsmailhaisinyoteiymd ,         /* ＤＳメール配信（予定）日 */
     dssousinmailsyubetukbn ,         /* ＤＳ送信メール種別区分 */
     dshaisinyoyakustatuskbn ,         /* ＤＳ配信予約ステータス区分 */
     dsmailhaisintourokuymd ,         /* ＤＳメール配信登録日 */
     dsmailhaisinsyouninymd ,         /* ＤＳメール配信承認日 */
     dsmailhaisintourokusyaid ,         /* ＤＳメール配信登録者ＩＤ */
     dsmailhaisinsyouninsyaid ,         /* ＤＳメール配信承認者ＩＤ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsMailHaisinYoyaku_Z;