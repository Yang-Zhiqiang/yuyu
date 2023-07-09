CREATE TABLE JT_SateiIppanHanteiInfo (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     ippanhanteitensuu1                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数１                                       */
     ippanhanteicomment1                                VARCHAR     (32)                                                                ,  /* 一般判定コメント１                                     */
     ippanhanteitensuu2                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数２                                       */
     ippanhanteicomment2                                VARCHAR     (32)                                                                ,  /* 一般判定コメント２                                     */
     ippanhanteitensuu3                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数３                                       */
     ippanhanteicomment3                                VARCHAR     (32)                                                                ,  /* 一般判定コメント３                                     */
     ippanhanteitensuu4                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数４                                       */
     ippanhanteicomment4                                VARCHAR     (32)                                                                ,  /* 一般判定コメント４                                     */
     ippanhanteitensuu5                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数５                                       */
     ippanhanteicomment5                                VARCHAR     (32)                                                                ,  /* 一般判定コメント５                                     */
     ippanhanteitensuu6                                 VARCHAR     (2)                                                                 ,  /* 一般判定点数６                                       */
     ippanhanteicomment6                                VARCHAR     (32)                                                                ,  /* 一般判定コメント６                                     */
     ippanhanteitensuugoukei                            VARCHAR     (2)                                                                 ,  /* 一般判定点数合計                                      */
     ippanhanteigoukeicomment                           VARCHAR     (32)                                                                ,  /* 一般判定合計コメント                                    */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_SateiIppanHanteiInfo ADD CONSTRAINT PK_SateiIppanHanteiInfo PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                            /* 請求履歴番号                                         */
) ;
