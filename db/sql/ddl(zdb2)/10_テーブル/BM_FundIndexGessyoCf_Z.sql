CREATE TABLE BM_FundIndexGessyoCf_Z (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分 */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　 */
     segkey                                             VARCHAR     (1)                                                       NOT NULL  ,  /* ＳＥＧＫＥＹ　　　　　　　　 */
     gscfhkkkgahurikaegaku                              DECIMAL     (13)                                                                ,  /* 月初ＣＦ保険関係ＧＡ振替額 */
     gscfhkkkgahurikaegaku$                             VARCHAR     (10)                                                                ,  /* 月初ＣＦ保険関係ＧＡ振替額(通貨型) */
     gkgscfhkkkgahurikaegaku                            DECIMAL     (13)                                                                ,  /* （外貨）月初ＣＦ保険関係ＧＡ振替額 */
     gkgscfhkkkgahurikaegaku$                           VARCHAR     (10)                                                                ,  /* （外貨）月初ＣＦ保険関係ＧＡ振替額(通貨型) */
     gscfhkkksahurikaegaku                              DECIMAL     (13)                                                                ,  /* 月初ＣＦ保険関係ＳＡ振替額 */
     gscfhkkksahurikaegaku$                             VARCHAR     (10)                                                                ,  /* 月初ＣＦ保険関係ＳＡ振替額(通貨型) */
     gkgscfhkkksahurikaegaku                            DECIMAL     (13)                                                                ,  /* （外貨）月初ＣＦ保険関係ＳＡ振替額 */
     gkgscfhkkksahurikaegaku$                           VARCHAR     (10)                                                                ,  /* （外貨）月初ＣＦ保険関係ＳＡ振替額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_FundIndexGessyoCf_Z ADD CONSTRAINT PK_FundIndexGessyoCf PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分 */
     fundhyoukaymd                                            , /* ファンド評価年月日　　　　 */
     segkey                                                     /* ＳＥＧＫＥＹ　　　　　　　　 */
) ;
