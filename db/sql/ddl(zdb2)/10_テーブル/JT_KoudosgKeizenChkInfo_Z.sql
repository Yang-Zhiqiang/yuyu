CREATE TABLE JT_KoudosgKeizenChkInfo_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     keizencheckkbn1                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分１ */
     keizenchecomment1                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント１ */
     keizencheckkbn2                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分２ */
     keizenchecomment2                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント２ */
     keizencheckkbn3                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分３ */
     keizenchecomment3                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント３ */
     keizencheckkbn4                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分４ */
     keizenchecomment4                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント４ */
     keizencheckkbn5                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分５ */
     keizenchecomment5                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント５ */
     keizencheckkbn6                                    VARCHAR     (1)                                                                 ,  /* 契前チェック区分６ */
     keizenchecomment6                                  VARCHAR     (66)                                                                ,  /* 契前チェックコメント６ */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_KoudosgKeizenChkInfo_Z ADD CONSTRAINT PK_KoudosgKeizenChkInfo PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                            /* 請求履歴番号 */
) ;
