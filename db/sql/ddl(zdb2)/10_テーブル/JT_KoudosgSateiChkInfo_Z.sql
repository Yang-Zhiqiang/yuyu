CREATE TABLE JT_KoudosgSateiChkInfo_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     gengkumukbn                                        VARCHAR     (1)                                                                 ,  /* 減額有無区分 */
     gengkymd                                           VARCHAR     (8)                                                                 ,  /* 減額日 */
     gengkcomment                                       VARCHAR     (32)                                                                ,  /* 減額コメント */
     skisinouryokuumukbn                                VARCHAR     (1)                                                                 ,  /* 請求意思能力有無区分 */
     skisinouryokuttdktyuuikbn                          VARCHAR     (1)                                                                 ,  /* 請求意思能力手続注意区分 */
     skisinouryokucomment                               VARCHAR     (32)                                                                ,  /* 請求意思能力コメント */
     shrsakiseikyuusyakbn                               VARCHAR     (1)                                                                 ,  /* 支払先請求者区分 */
     shrsakicomment                                     VARCHAR     (82)                                                                ,  /* 支払先コメント */
     kyhkaisyuuyouhiikbn                                VARCHAR     (1)                                                                 ,  /* 給付金回収要否区分 */
     kyhkaisyuuyouhiicomment                            VARCHAR     (82)                                                                ,  /* 給付金回収コメント */
     danpozaikeiumukbn                                  VARCHAR     (1)                                                                 ,  /* 団保財形有無区分 */
     danpozaikeicomment                                 VARCHAR     (82)                                                                ,  /* 団保財形コメント */
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

ALTER TABLE JT_KoudosgSateiChkInfo_Z ADD CONSTRAINT PK_KoudosgSateiChkInfo PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                            /* 請求履歴番号 */
) ;
