CREATE VIEW MT_BAK_DsHonninKakuninCd AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     trkssikibetukey ,         /* 取消識別キー */
     dskrhnnkakcd ,         /* ＤＳ仮本人確認コード */
     dskrhnnkakcdsetkbn ,         /* ＤＳ仮本人確認コード設定区分 */
     dskrhnnkakcdsetymd ,         /* ＤＳ仮本人確認コード設定年月日 */
     dskrhnnkakcdyuukouymd ,         /* ＤＳ仮本人確認コード有効年月日 */
     dshnnkakcd ,         /* ＤＳ本人確認コード */
     dshnnkakcdsetymd ,         /* ＤＳ本人確認コード設定年月日 */
     zenkaidskrhnnkakcd ,         /* 前回ＤＳ仮本人確認コード */
     dskrhnnkakcdttshjyhsymd ,         /* ＤＳ仮本人確認コード通知送付事由発生日 */
     dskrhnnkakcdttyhkbn ,         /* ＤＳ仮本人確認コード通知要否区分 */
     dskrhnnkakcdtttydnjykbn ,         /* ＤＳ仮本人確認コード通知中断事由区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_BAK_DsHonninKakuninCd_Z;