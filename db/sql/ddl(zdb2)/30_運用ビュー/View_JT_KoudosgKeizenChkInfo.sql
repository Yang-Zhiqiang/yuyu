CREATE VIEW JT_KoudosgKeizenChkInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     keizencheckkbn1 ,         /* 契前チェック区分１ */
     keizenchecomment1 ,         /* 契前チェックコメント１ */
     keizencheckkbn2 ,         /* 契前チェック区分２ */
     keizenchecomment2 ,         /* 契前チェックコメント２ */
     keizencheckkbn3 ,         /* 契前チェック区分３ */
     keizenchecomment3 ,         /* 契前チェックコメント３ */
     keizencheckkbn4 ,         /* 契前チェック区分４ */
     keizenchecomment4 ,         /* 契前チェックコメント４ */
     keizencheckkbn5 ,         /* 契前チェック区分５ */
     keizenchecomment5 ,         /* 契前チェックコメント５ */
     keizencheckkbn6 ,         /* 契前チェック区分６ */
     keizenchecomment6 ,         /* 契前チェックコメント６ */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_KoudosgKeizenChkInfo_Z;