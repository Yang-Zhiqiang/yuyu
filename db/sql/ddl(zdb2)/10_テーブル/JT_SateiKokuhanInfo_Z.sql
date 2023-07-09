CREATE TABLE JT_SateiKokuhanInfo_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     kokuhancheckkbn1                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分１ */
     kokuhanchecomment1                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント１ */
     kokuhancheckkbn2                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分２ */
     kokuhanchecomment2                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント２ */
     kokuhancheckkbn3                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分３ */
     kokuhanchecomment3                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント３ */
     kokuhancheckkbn4                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分４ */
     kokuhanchecomment4                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント４ */
     kokuhancheckkbn5                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分５ */
     kokuhanchecomment5                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント５ */
     kokuhancheckkbn6                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分６ */
     kokuhanchecomment6                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント６ */
     kokuhancheckkbn7                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分７ */
     kokuhanchecomment7                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント７ */
     kokuhancheckkbn8                                   VARCHAR     (1)                                                                 ,  /* 告反チェック区分８ */
     kokuhanchecomment8                                 VARCHAR     (66)                                                                ,  /* 告反チェックコメント８ */
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

ALTER TABLE JT_SateiKokuhanInfo_Z ADD CONSTRAINT PK_SateiKokuhanInfo PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                            /* 請求履歴番号 */
) ;
