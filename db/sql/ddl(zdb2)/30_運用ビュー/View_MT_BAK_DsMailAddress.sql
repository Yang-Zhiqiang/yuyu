CREATE VIEW MT_BAK_DsMailAddress AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailaddressrenban ,         /* ＤＳメールアドレス連番 */
     trkssikibetukey ,         /* 取消識別キー */
     dsmailtourokujyoutaikbn ,         /* ＤＳメール登録状態区分 */
     dsmailaddress ,         /* ＤＳメールアドレス */
     dsmailsousinjyoutaikbn ,         /* ＤＳメール送信状態区分 */
     dsmailsousintisrykbn ,         /* ＤＳメール送信停止理由区分 */
     dstourokuymdtime ,         /* ＤＳ登録日時 */
     dskousinymdtime ,         /* ＤＳ更新日時 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_BAK_DsMailAddress_Z;