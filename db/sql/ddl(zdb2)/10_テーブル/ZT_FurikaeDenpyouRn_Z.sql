CREATE TABLE ZT_FurikaeDenpyouRn_Z (
     zrnkytkmksyoruicd                                  CHAR        (5)                                                       NOT NULL  ,  /* （連携用）共通項目書類コード */
     zrnkytkmktyouhyousksymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）共通項目帳票作成年月日 */
     zrnkytkmksystemkbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）共通項目システム区分 */
     zrnkytkmktorihikino                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）共通項目取引番号 */
     zrnkytkmktorihikinoedano                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）共通項目取引番号枝番号 */
     zrnkytkmkseifukukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共通項目正副区分 */
     zrnkytkmkfuridenhassoukbn                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）共通項目振替伝票用発送区分 */
     zrnkytkmkyobi                                      CHAR        (61)                                                      NOT NULL  ,  /* （連携用）共通項目予備項目 */
     zrnsystemkbn                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）システム区分 */
     zrntorihikinoc8                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）取引番号Ｃ８ */
     zrntorihikinoedano                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引番号枝番号 */
     zrnkjhikaeinjikm                                   GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）漢字控印字項目 */
     zrntorihikiymdgengokbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取引年月日元号区分 */
     zrntorihikinen                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引年 */
     zrntorihikituki                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引月 */
     zrntorihikibi                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）取引日 */
     zrnkanjyoukbn                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）勘定区分 */
     zrnkanjyoukbnnm                                    GRAPHIC     (6)                                                       NOT NULL  ,  /* （連携用）勘定区分名 */
     zrnkjtantoukanm                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）漢字担当課名 */
     zrnkjtantoucd                                      GRAPHIC     (1)                                                       NOT NULL  ,  /* （連携用）漢字担当コード */
     zrnkjsystemnm                                      GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）漢字システム名 */
     zrnkarikurikosikingaku                             CHAR        (12)                                                      NOT NULL  ,  /* （連携用）借方繰越金額 */
     zrnkasikurikosikingaku                             CHAR        (12)                                                      NOT NULL  ,  /* （連携用）貸方繰越金額 */
     zrndenpyoukbnnm                                    GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）伝票区分名 */
     zrnkjkarikurikosigkhyjkm                           GRAPHIC     (2)                                                       NOT NULL  ,  /* （連携用）漢字借方繰越合計表示項目 */
     zrnkarikurikosigkkingaku                           CHAR        (13)                                                      NOT NULL  ,  /* （連携用）借方繰越合計金額 */
     zrnkjkasikurikosigkhyjkm                           GRAPHIC     (2)                                                       NOT NULL  ,  /* （連携用）漢字貸方繰越合計表示項目 */
     zrnkasikurikosigkkingaku                           CHAR        (13)                                                      NOT NULL  ,  /* （連携用）貸方繰越合計金額 */
     zrnkjtekiyou1                                      GRAPHIC     (70)                                                      NOT NULL  ,  /* （連携用）漢字摘要１ */
     zrnkjtekiyou2                                      GRAPHIC     (70)                                                      NOT NULL  ,  /* （連携用）漢字摘要２ */
     zrnkjtekiyou3                                      GRAPHIC     (70)                                                      NOT NULL  ,  /* （連携用）漢字摘要３ */
     zrnkjkarikanjyoukamokunm1                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字借方勘定科目名１ */
     zrnkjkasikanjyoukamokunm1                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字貸方勘定科目名１ */
     zrnkaritekiyoukm1                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）借方摘要項目１ */
     zrnkarikingaku1                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）借方金額１ */
     zrnkasitekiyoukm1                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）貸方摘要項目１ */
     zrnkasikingaku1                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）貸方金額１ */
     zrnkjkaritekiyoukm1                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字借方摘要項目１ */
     zrnkjkasitekiyoukm1                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字貸方摘要項目１ */
     zrnkjkarikanjyoukamokunm2                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字借方勘定科目名２ */
     zrnkjkasikanjyoukamokunm2                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字貸方勘定科目名２ */
     zrnkaritekiyoukm2                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）借方摘要項目２ */
     zrnkarikingaku2                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）借方金額２ */
     zrnkasitekiyoukm2                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）貸方摘要項目２ */
     zrnkasikingaku2                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）貸方金額２ */
     zrnkjkaritekiyoukm2                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字借方摘要項目２ */
     zrnkjkasitekiyoukm2                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字貸方摘要項目２ */
     zrnkjkarikanjyoukamokunm3                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字借方勘定科目名３ */
     zrnkjkasikanjyoukamokunm3                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字貸方勘定科目名３ */
     zrnkaritekiyoukm3                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）借方摘要項目３ */
     zrnkarikingaku3                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）借方金額３ */
     zrnkasitekiyoukm3                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）貸方摘要項目３ */
     zrnkasikingaku3                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）貸方金額３ */
     zrnkjkaritekiyoukm3                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字借方摘要項目３ */
     zrnkjkasitekiyoukm3                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字貸方摘要項目３ */
     zrnkjkarikanjyoukamokunm4                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字借方勘定科目名４ */
     zrnkjkasikanjyoukamokunm4                          GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）漢字貸方勘定科目名４ */
     zrnkaritekiyoukm4                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）借方摘要項目４ */
     zrnkarikingaku4                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）借方金額４ */
     zrnkasitekiyoukm4                                  CHAR        (23)                                                      NOT NULL  ,  /* （連携用）貸方摘要項目４ */
     zrnkasikingaku4                                    CHAR        (12)                                                      NOT NULL  ,  /* （連携用）貸方金額４ */
     zrnkjkaritekiyoukm4                                GRAPHIC     (26)                                                      NOT NULL  ,  /* （連携用）漢字借方摘要項目４ */
     zrnkjkasitekiyoukm4                                GRAPHIC     (26)                                                      NOT NULL     /* （連携用）漢字貸方摘要項目４ */
)
;

ALTER TABLE ZT_FurikaeDenpyouRn_Z ADD CONSTRAINT PK_FurikaeDenpyouRn PRIMARY KEY (
     zrntorihikinoc8                                          , /* （連携用）取引番号Ｃ８ */
     zrntorihikinoedano                                       , /* （連携用）取引番号枝番号 */
     zrntorihikiymdgengokbn                                   , /* （連携用）取引年月日元号区分 */
     zrntorihikinen                                           , /* （連携用）取引年 */
     zrntorihikituki                                          , /* （連携用）取引月 */
     zrntorihikibi                                              /* （連携用）取引日 */
) ;
