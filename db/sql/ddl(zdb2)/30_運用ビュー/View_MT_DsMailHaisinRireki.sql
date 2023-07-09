CREATE VIEW MT_DsMailHaisinRireki AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailhaisinrenban ,         /* ＤＳメール配信連番 */
     haisinjidsmailaddress ,         /* 配信時ＤＳメールアドレス */
     dssousinno ,         /* ＤＳ送信番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     dssousinmailsyubetukbn ,         /* ＤＳ送信メール種別区分 */
     syono           /* 証券番号 */
FROM MT_DsMailHaisinRireki_Z;