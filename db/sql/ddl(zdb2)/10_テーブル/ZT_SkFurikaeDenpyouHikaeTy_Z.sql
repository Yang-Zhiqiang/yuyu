CREATE TABLE ZT_SkFurikaeDenpyouHikaeTy_Z (
     ztykytkmksyoruicd                                  VARCHAR     (5)                                                                 ,  /* （中継用）共通項目書類コード */
     ztykytkmktyouhyousksymd                            VARCHAR     (8)                                                                 ,  /* （中継用）共通項目帳票作成年月日 */
     ztykytkmksystemkbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）共通項目システム区分 */
     ztykytkmktorihikino                                VARCHAR     (8)                                                                 ,  /* （中継用）共通項目取引番号 */
     ztykytkmktorihikinoedano                           VARCHAR     (2)                                                                 ,  /* （中継用）共通項目取引番号枝番号 */
     ztykytkmkseifukukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）共通項目正副区分 */
     ztykytkmkfuridenhassoukbn                          VARCHAR     (2)                                                                 ,  /* （中継用）共通項目振替伝票用発送区分 */
     ztykytkmkyobi                                      VARCHAR     (61)                                                                ,  /* （中継用）共通項目予備項目 */
     ztysystemkbn                                       VARCHAR     (2)                                                                 ,  /* （中継用）システム区分 */
     ztytorihikinoc8                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）取引番号Ｃ８ */
     ztytorihikinoedano                                 VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）取引番号枝番号 */
     ztykjhikaeinjikm                                   VARCHAR     (8)                                                                 ,  /* （中継用）漢字控印字項目 */
     ztytorihikiymdgengokbn                             VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）取引年月日元号区分 */
     ztytorihikinen                                     VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）取引年 */
     ztytorihikituki                                    VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）取引月 */
     ztytorihikibi                                      VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）取引日 */
     ztykanjyoukbn                                      VARCHAR     (4)                                                                 ,  /* （中継用）勘定区分 */
     ztykanjyoukbnnm                                    VARCHAR     (14)                                                                ,  /* （中継用）勘定区分名 */
     ztykjtantoukanm                                    VARCHAR     (18)                                                                ,  /* （中継用）漢字担当課名 */
     ztykjtantoucd                                      VARCHAR     (4)                                                                 ,  /* （中継用）漢字担当コード */
     ztykjsystemnm                                      VARCHAR     (22)                                                                ,  /* （中継用）漢字システム名 */
     ztykarikurikosikingaku                             VARCHAR     (12)                                                                ,  /* （中継用）借方繰越金額 */
     ztykasikurikosikingaku                             VARCHAR     (12)                                                                ,  /* （中継用）貸方繰越金額 */
     ztydenpyoukbnnm                                    VARCHAR     (10)                                                                ,  /* （中継用）伝票区分名 */
     ztykjkarikurikosigkhyjkm                           VARCHAR     (6)                                                                 ,  /* （中継用）漢字借方繰越合計表示項目 */
     ztykarikurikosigkkingaku                           VARCHAR     (13)                                                                ,  /* （中継用）借方繰越合計金額 */
     ztykjkasikurikosigkhyjkm                           VARCHAR     (6)                                                                 ,  /* （中継用）漢字貸方繰越合計表示項目 */
     ztykasikurikosigkkingaku                           VARCHAR     (13)                                                                ,  /* （中継用）貸方繰越合計金額 */
     ztykjtekiyou1                                      VARCHAR     (142)                                                               ,  /* （中継用）漢字摘要１ */
     ztykjtekiyou2                                      VARCHAR     (142)                                                               ,  /* （中継用）漢字摘要２ */
     ztykjtekiyou3                                      VARCHAR     (142)                                                               ,  /* （中継用）漢字摘要３ */
     ztykjkarikanjyoukamokunm1                          VARCHAR     (42)                                                                ,  /* （中継用）漢字借方勘定科目名１ */
     ztykjkasikanjyoukamokunm1                          VARCHAR     (42)                                                                ,  /* （中継用）漢字貸方勘定科目名１ */
     ztykaritekiyoukm1                                  VARCHAR     (23)                                                                ,  /* （中継用）借方摘要項目１ */
     ztykarikingaku1                                    VARCHAR     (12)                                                                ,  /* （中継用）借方金額１ */
     ztykasitekiyoukm1                                  VARCHAR     (23)                                                                ,  /* （中継用）貸方摘要項目１ */
     ztykasikingaku1                                    VARCHAR     (12)                                                                ,  /* （中継用）貸方金額１ */
     ztykjkaritekiyoukm1                                VARCHAR     (54)                                                                ,  /* （中継用）漢字借方摘要項目１ */
     ztykjkasitekiyoukm1                                VARCHAR     (54)                                                                ,  /* （中継用）漢字貸方摘要項目１ */
     ztykjkarikanjyoukamokunm2                          VARCHAR     (42)                                                                ,  /* （中継用）漢字借方勘定科目名２ */
     ztykjkasikanjyoukamokunm2                          VARCHAR     (42)                                                                ,  /* （中継用）漢字貸方勘定科目名２ */
     ztykaritekiyoukm2                                  VARCHAR     (23)                                                                ,  /* （中継用）借方摘要項目２ */
     ztykarikingaku2                                    VARCHAR     (12)                                                                ,  /* （中継用）借方金額２ */
     ztykasitekiyoukm2                                  VARCHAR     (23)                                                                ,  /* （中継用）貸方摘要項目２ */
     ztykasikingaku2                                    VARCHAR     (12)                                                                ,  /* （中継用）貸方金額２ */
     ztykjkaritekiyoukm2                                VARCHAR     (54)                                                                ,  /* （中継用）漢字借方摘要項目２ */
     ztykjkasitekiyoukm2                                VARCHAR     (54)                                                                ,  /* （中継用）漢字貸方摘要項目２ */
     ztykjkarikanjyoukamokunm3                          VARCHAR     (42)                                                                ,  /* （中継用）漢字借方勘定科目名３ */
     ztykjkasikanjyoukamokunm3                          VARCHAR     (42)                                                                ,  /* （中継用）漢字貸方勘定科目名３ */
     ztykaritekiyoukm3                                  VARCHAR     (23)                                                                ,  /* （中継用）借方摘要項目３ */
     ztykarikingaku3                                    VARCHAR     (12)                                                                ,  /* （中継用）借方金額３ */
     ztykasitekiyoukm3                                  VARCHAR     (23)                                                                ,  /* （中継用）貸方摘要項目３ */
     ztykasikingaku3                                    VARCHAR     (12)                                                                ,  /* （中継用）貸方金額３ */
     ztykjkaritekiyoukm3                                VARCHAR     (54)                                                                ,  /* （中継用）漢字借方摘要項目３ */
     ztykjkasitekiyoukm3                                VARCHAR     (54)                                                                ,  /* （中継用）漢字貸方摘要項目３ */
     ztykjkarikanjyoukamokunm4                          VARCHAR     (42)                                                                ,  /* （中継用）漢字借方勘定科目名４ */
     ztykjkasikanjyoukamokunm4                          VARCHAR     (42)                                                                ,  /* （中継用）漢字貸方勘定科目名４ */
     ztykaritekiyoukm4                                  VARCHAR     (23)                                                                ,  /* （中継用）借方摘要項目４ */
     ztykarikingaku4                                    VARCHAR     (12)                                                                ,  /* （中継用）借方金額４ */
     ztykasitekiyoukm4                                  VARCHAR     (23)                                                                ,  /* （中継用）貸方摘要項目４ */
     ztykasikingaku4                                    VARCHAR     (12)                                                                ,  /* （中継用）貸方金額４ */
     ztykjkaritekiyoukm4                                VARCHAR     (54)                                                                ,  /* （中継用）漢字借方摘要項目４ */
     ztykjkasitekiyoukm4                                VARCHAR     (54)                                                                ,  /* （中継用）漢字貸方摘要項目４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SkFurikaeDenpyouHikaeTy_Z ADD CONSTRAINT PK_SkFurikaeDenpyouHikaeTy PRIMARY KEY (
     ztytorihikinoc8                                          , /* （中継用）取引番号Ｃ８ */
     ztytorihikinoedano                                       , /* （中継用）取引番号枝番号 */
     ztytorihikiymdgengokbn                                   , /* （中継用）取引年月日元号区分 */
     ztytorihikinen                                           , /* （中継用）取引年 */
     ztytorihikituki                                          , /* （中継用）取引月 */
     ztytorihikibi                                              /* （中継用）取引日 */
) ;
