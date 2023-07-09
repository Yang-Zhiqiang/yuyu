CREATE VIEW MT_BAK_DsTorihikiServiceKanri AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     dstrhkserviceriyoujkkbn ,         /* ＤＳ取引サービス利用状況区分 */
     dstrhkserviceteisiriyuukbn ,         /* ＤＳ取引サービス停止理由区分 */
     dstrhkservicetourokuymd ,         /* ＤＳ取引サービス登録年月日 */
     dstrhkservicemukouymd ,         /* ＤＳ取引サービス無効年月日 */
     dstrhkservicekanyukeirokbn ,         /* ＤＳ取引サービス加入経路区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_BAK_DsTorihikiServiceKanri_Z;