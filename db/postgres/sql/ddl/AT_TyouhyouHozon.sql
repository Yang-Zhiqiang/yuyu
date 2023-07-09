CREATE TABLE AT_TyouhyouHozon (
     reportKey                                          varchar     (20)                                                      NOT NULL  ,  /* 帳票キー                                          */
     pdfData                                            bytea                                                                           ,  /* PDFデータ                                        */
     tyouhyouKetugouKey                                 varchar     (17)                                                                ,  /* 帳票結合キー                                        */
     pdfHozonKbn                                        decimal     (1)                                                                 ,  /* PDF保存区分                                       */
     zipHozonKbn                                        decimal     (1)                                                                 ,  /* ZIP保存区分                                       */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_TyouhyouHozon ADD CONSTRAINT AT_TyouhyouHozonPK PRIMARY KEY (
     reportKey                                                  /* 帳票キー                                           */
) ;

CREATE INDEX CT_TyouhyouHozon_IX1 ON AT_TyouhyouHozon (
     tyouhyouKetugouKey                                         /* 帳票結合キー                                         */
) ;
