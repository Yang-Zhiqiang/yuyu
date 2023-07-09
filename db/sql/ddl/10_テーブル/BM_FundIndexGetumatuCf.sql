CREATE TABLE BM_FundIndexGetumatuCf (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分                                    */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　                                 */
     segkey                                             VARCHAR     (1)                                                       NOT NULL  ,  /* ＳＥＧＫＥＹ　　　　　　　　                                */
     gmcfhknknkigahurikaegaku                           NUMBER      (13)                                                                ,  /* 月末ＣＦ保険関係ＧＡ振替額                                 */
     gmcfhknknkigahurikaegaku$                          VARCHAR     (10)                                                                ,  /* 月末ＣＦ保険関係ＧＡ振替額(通貨型)                            */
     gkgmcfhknknkigahurikaegaku                         NUMBER      (13)                                                                ,  /* （外貨）月末ＣＦ保険関係ＧＡ振替額                             */
     gkgmcfhknknkigahurikaegaku$                        VARCHAR     (10)                                                                ,  /* （外貨）月末ＣＦ保険関係ＧＡ振替額(通貨型)                        */
     gmcfsakanrihigahurikaegaku                         NUMBER      (11)                                                                ,  /* 月末ＣＦＳＡ管理費ＧＡ振替額                                */
     gmcfsakanrihigahurikaegaku$                        VARCHAR     (10)                                                                ,  /* 月末ＣＦＳＡ管理費ＧＡ振替額(通貨型)                           */
     gmsthscstgahurikaegaku                             NUMBER      (11)                                                                ,  /* 月末最低保障コストＧＡ振替額                                */
     gmsthscstgahurikaegaku$                            VARCHAR     (10)                                                                ,  /* 月末最低保障コストＧＡ振替額(通貨型)                           */
     gmroanfundgahurikaegaku                            NUMBER      (11)                                                                ,  /* 月末ローンファンドＧＡ振替額                                */
     gmroanfundgahurikaegaku$                           VARCHAR     (10)                                                                ,  /* 月末ローンファンドＧＡ振替額(通貨型)                           */
     gmcfhkkksahurikaegaku                              NUMBER      (13)                                                                ,  /* 月末ＣＦ保険関係ＳＡ振替額                                 */
     gmcfhkkksahurikaegaku$                             VARCHAR     (10)                                                                ,  /* 月末ＣＦ保険関係ＳＡ振替額(通貨型)                            */
     gkgmcfhkkksahurikaegaku                            NUMBER      (13)                                                                ,  /* （外貨）月末ＣＦ保険関係ＳＡ振替額                             */
     gkgmcfhkkksahurikaegaku$                           VARCHAR     (10)                                                                ,  /* （外貨）月末ＣＦ保険関係ＳＡ振替額(通貨型)                        */
     gmroanfundsahurikaegaku                            NUMBER      (11)                                                                ,  /* 月末ローンファンドＳＡ振替額                                */
     gmroanfundsahurikaegaku$                           VARCHAR     (10)                                                                ,  /* 月末ローンファンドＳＡ振替額(通貨型)                           */
     gmhokencvgoukeigaku                                NUMBER      (15)                                                                ,  /* 月末保険ＣＶ合計額                                     */
     gmhokencvgoukeigaku$                               VARCHAR     (10)                                                                ,  /* 月末保険ＣＶ合計額(通貨型)                                */
     gkgmhokencvgoukeigaku                              NUMBER      (15)                                                                ,  /* （外貨）月末保険ＣＶ合計額                                 */
     gkgmhokencvgoukeigaku$                             VARCHAR     (10)                                                                ,  /* （外貨）月末保険ＣＶ合計額(通貨型)                            */
     gmsktsganrigoukeizandaka                           NUMBER      (13)                                                                ,  /* 月末初期投資元利合計残高                                  */
     gmsktsganrigoukeizandaka$                          VARCHAR     (10)                                                                ,  /* 月末初期投資元利合計残高(通貨型)                             */
     gkgmsktsganrigoukeizandaka                         NUMBER      (13)                                                                ,  /* （外貨）月末初期投資元利合計残高                              */
     gkgmsktsganrigoukeizandaka$                        VARCHAR     (10)                                                                ,  /* （外貨）月末初期投資元利合計残高(通貨型)                         */
     gmmihurikaesousatugaku                             NUMBER      (13)                                                                ,  /* 月末未振替相殺額                                      */
     gmmihurikaesousatugaku$                            VARCHAR     (10)                                                                ,  /* 月末未振替相殺額(通貨型)                                 */
     gkgmmihurikaesousatugaku                           NUMBER      (13)                                                                ,  /* （外貨）月末未振替相殺額                                  */
     gkgmmihurikaesousatugaku$                          VARCHAR     (10)                                                                ,  /* （外貨）月末未振替相殺額(通貨型)                             */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_FundIndexGetumatuCf ADD CONSTRAINT PK_FundIndexGetumatuCf PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分                                     */
     fundhyoukaymd                                            , /* ファンド評価年月日　　　　                                  */
     segkey                                                     /* ＳＥＧＫＥＹ　　　　　　　　                                 */
) ;
