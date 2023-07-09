CREATE TABLE JT_SibouSateiChkInfo_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     bengosikenkaiumukbn                                VARCHAR     (1)                                                                 ,  /* 弁護士見解有無区分 */
     kujyouumukbn                                       VARCHAR     (1)                                                                 ,  /* 苦情有無区分 */
     jimumissumukbn                                     VARCHAR     (1)                                                                 ,  /* 事務ミス有無区分 */
     kyhgksitukaisouyouhikbn                            VARCHAR     (1)                                                                 ,  /* 給付金室回送要否区分 */
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

ALTER TABLE JT_SibouSateiChkInfo_Z ADD CONSTRAINT PK_SibouSateiChkInfo PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                            /* 請求履歴番号 */
) ;
