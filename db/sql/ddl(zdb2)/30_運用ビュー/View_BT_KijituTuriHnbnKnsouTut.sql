CREATE VIEW BT_KijituTuriHnbnKnsouTut AS SELECT
     syoriYmd ,         /* 処理年月日 */
     subSystemId ,         /* サブシステムＩＤ */
     tysytno ,         /* 抽出番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KijituTuriHnbnKnsouTut_Z;