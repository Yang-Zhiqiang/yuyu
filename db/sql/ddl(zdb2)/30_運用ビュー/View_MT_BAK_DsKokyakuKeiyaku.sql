CREATE VIEW MT_BAK_DsKokyakuKeiyaku AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     dskykkanyuuymd ,         /* ＤＳ契約加入年月日 */
     dskykhenkouymd ,         /* ＤＳ契約変更年月日 */
     dskykmukouhyj ,         /* ＤＳ契約無効表示 */
     dskykmukouymd ,         /* ＤＳ契約無効年月日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     pplessrenjidssymenttdkhyj           /* ペーパーレス連動時ＤＳ書面手続表示 */
FROM MT_BAK_DsKokyakuKeiyaku_Z;