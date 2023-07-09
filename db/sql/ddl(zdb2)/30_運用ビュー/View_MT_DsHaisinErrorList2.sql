CREATE VIEW MT_DsHaisinErrorList2 AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     dsmailhaisinrenban ,         /* ＤＳメール配信連番 */
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailaddressrenban ,         /* ＤＳメールアドレス連番 */
     dssousinmailsyubetukbn ,         /* ＤＳ送信メール種別区分 */
     dssousinno ,         /* ＤＳ送信番号 */
     syono ,         /* 証券番号 */
     haisinjidsmailaddress ,         /* 配信時ＤＳメールアドレス */
     dsmailsousinymd ,         /* ＤＳメール送信日 */
     dsmailsakujyoymd ,         /* ＤＳメール削除日 */
     haisinerrorcount ,         /* 配信エラーカウント */
     haisinerrorcount2 ,         /* 配信エラーカウント２ */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsHaisinErrorList2_Z;