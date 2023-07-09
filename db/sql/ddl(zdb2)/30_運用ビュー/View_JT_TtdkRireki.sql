CREATE VIEW JT_TtdkRireki AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     ttdkrrkskbtkey ,         /* 手続履歴識別キー */
     syoriYmd ,         /* 処理年月日 */
     syorisosikicd ,         /* 処理組織コード */
     jimukakuteiumukbn ,         /* 事務確定有無区分 */
     seikyuurirekino ,         /* 請求履歴番号 */
     shrsikibetukey ,         /* 支払識別キー */
     sateisyouninskbtkey ,         /* 査定承認識別キー */
     syanaicomment ,         /* 社内用コメント */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_TtdkRireki_Z;