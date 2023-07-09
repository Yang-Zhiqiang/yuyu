CREATE TABLE AT_TyouhyouKensaku (
     uniqueId                                           varchar     (100)                                                     NOT NULL  ,  /* ユニークID                                        */
     reportKey                                          varchar     (20)                                                                ,  /* 帳票キー                                          */
     syoruiCd                                           varchar     (5)                                                                 ,  /* 書類コード                                         */
     subSystemId                                        varchar     (50)                                                                ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                                ,  /* カテゴリＩＤ                                        */
     kinouId                                            varchar     (50)                                                                ,  /* 機能ＩＤ                                          */
     kensakuKey1                                        varchar     (30)                                                                ,  /* 検索キー１                                         */
     kensakuKey2                                        varchar     (30)                                                                ,  /* 検索キー２                                         */
     kensakuKey3                                        varchar     (30)                                                                ,  /* 検索キー３                                         */
     kensakuKey4                                        varchar     (30)                                                                ,  /* 検索キー４                                         */
     kensakuKey5                                        varchar     (30)                                                                ,  /* 検索キー５                                         */
     syoriYmd                                           varchar     (8)                                                                 ,  /* 処理年月日                                         */
     firstOutYmd                                        varchar     (8)                                                                 ,  /* 初回出力年月日                                       */
     lastOutYmd                                         varchar     (8)                                                                 ,  /* 最終出力年月日                                       */
     outCount                                           decimal     (3)                                                                 ,  /* 出力回数                                          */
     lastOutUserId                                      varchar     (30)                                                                ,  /* 最終出力ユーザーID                                    */
     syoruiKetugouUmuKbn                                decimal     (1)                                                                 ,  /* 書類結合有無区分                                      */
     fileSize                                           decimal     (12)                                                                ,  /* ファイルサイズ                                       */
     pageCount                                          decimal     (5)                                                                 ,  /* ページ数                                          */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_TyouhyouKensaku ADD CONSTRAINT AT_TyouhyouKensakuPk PRIMARY KEY (
     uniqueId                                                   /* ユニークID                                         */
) ;

CREATE INDEX CT_TyouhyouKensakuIX1 ON AT_TyouhyouKensaku (
     reportKey                                                  /* 帳票キー                                           */
) ;

CREATE INDEX CT_TyouhyouKensakuIX2 ON AT_TyouhyouKensaku (
     subSystemId                                              , /* サブシステムＩＤ                                       */
     syoruiCd                                                 , /* 書類コード                                          */
     kensakuKey1                                              , /* 検索キー１                                          */
     syoriYmd                                                   /* 処理年月日                                          */
) ;
