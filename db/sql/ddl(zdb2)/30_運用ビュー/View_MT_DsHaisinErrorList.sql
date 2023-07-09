CREATE VIEW MT_DsHaisinErrorList AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailaddressrenban ,         /* ＤＳメールアドレス連番 */
     haisinjidsmailaddress ,         /* 配信時ＤＳメールアドレス */
     dssousinno ,         /* ＤＳ送信番号 */
     haisinerrorcount ,         /* 配信エラーカウント */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsHaisinErrorList_Z;