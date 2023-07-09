CREATE TABLE JT_Toriatukaifuryouinfo_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     tratkihuryouumukbn                                 VARCHAR     (1)                                                                 ,  /* 取扱不良有無区分 */
     gyousinkaisouyouhikbn                              VARCHAR     (1)                                                                 ,  /* 業審回送要否区分 */
     aireqdaityoukisaikbn                               VARCHAR     (1)                                                                 ,  /* あいリク台帳記載区分 */
     tratkihuryoucomment                                VARCHAR     (102)                                                               ,  /* 取扱不良コメント */
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

ALTER TABLE JT_Toriatukaifuryouinfo_Z ADD CONSTRAINT PK_Toriatukaifuryouinfo PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                            /* 請求履歴番号 */
) ;
