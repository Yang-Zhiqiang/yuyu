CREATE VIEW BT_KijituTuriHnbnKnsouTutJk AS SELECT
     subSystemId ,         /* サブシステムＩＤ */
     tysytno ,         /* 抽出番号 */
     nikaimeikoutuutiyouhi ,         /* ２回目以降通知要否 */
     tuutijkkbn ,         /* 通知状況区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KijituTuriHnbnKnsouTutJk_Z;