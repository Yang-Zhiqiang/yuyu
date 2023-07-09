CREATE VIEW JT_Toriatukaifuryouinfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     tratkihuryouumukbn ,         /* 取扱不良有無区分 */
     gyousinkaisouyouhikbn ,         /* 業審回送要否区分 */
     aireqdaityoukisaikbn ,         /* あいリク台帳記載区分 */
     tratkihuryoucomment ,         /* 取扱不良コメント */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_Toriatukaifuryouinfo_Z;