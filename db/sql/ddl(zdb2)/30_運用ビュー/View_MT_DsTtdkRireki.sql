CREATE VIEW MT_DsTtdkRireki AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     henkousikibetukey ,         /* 変更識別キー */
     syoriYmd ,         /* 処理年月日 */
     dssyorikbn ,         /* ＤＳ処理区分 */
     henkourrkumu ,         /* 変更履歴有無 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsTtdkRireki_Z;