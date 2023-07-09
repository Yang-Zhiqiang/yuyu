CREATE VIEW MT_DsMailAddressSpiralYyk AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailaddressrenban ,         /* ＤＳメールアドレス連番 */
     dsmailaddress ,         /* ＤＳメールアドレス */
     dsrendoutaisyoukbn ,         /* ＤＳ連動対象区分 */
     dsmaildbsyorikbn ,         /* ＤＳメールＤＢ処理区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsMailAddressSpiralYyk_Z;