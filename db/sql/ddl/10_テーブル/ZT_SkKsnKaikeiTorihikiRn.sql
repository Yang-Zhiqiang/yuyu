CREATE TABLE ZT_SkKsnKaikeiTorihikiRn (
     zrnlen                                             CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＬＥＮ */
     zrnkaikeitani                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）会計単位 */
     zrnsystemkbnnum                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）システム区分（数値） */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrntorihikiymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）取引年月日 */
     zrntorihikinon7                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）取引番号Ｎ７ */
     zrnnyuuryokubasyo                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）入力場所 */
     zrnnyuuryokusyacd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）入力者コード */
     zrnsyoriymdn                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日（数値） */
     zrnsimekirikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）締切区分 */
     zrnkessankbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決算区分 */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２０ */
     zrnkaisyakantorihikikbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）会社間取引区分 */
     zrntukekaekbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）付替区分 */
     zrntablekosuu                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）テーブル個数 */
     zrnkanjyoukbnn                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）勘定区分（数値） */
     zrntaisyakukbnn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn                                CHAR        (5)                                                       NOT NULL  ,  /* （連携用）勘定科目コード（数値） */
     zrnyobiv4                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ４ */
     zrnsuitoubumon                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）出納部門 */
     zrnkingaku                                         NUMBER      (15)                                                      NOT NULL  ,  /* （連携用）金額 */
     zrntekiyoucd                                       CHAR        (20)                                                      NOT NULL  ,  /* （連携用）摘要コード */
     zrnyobiv10                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０ */
     zrnmeisaikanryoukbn                                CHAR        (1)                                                       NOT NULL     /* （連携用）明細完了区分 */
)
;

ALTER TABLE ZT_SkKsnKaikeiTorihikiRn ADD CONSTRAINT PK_SkKsnKaikeiTorihikiRn PRIMARY KEY (
     zrntorihikiymd                                           , /* （連携用）取引年月日 */
     zrntorihikinon7                                          , /* （連携用）取引番号Ｎ７ */
     zrntaisyakukbnn                                          , /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn                                      , /* （連携用）勘定科目コード（数値） */
     zrnsuitoubumon                                           , /* （連携用）出納部門 */
     zrntekiyoucd                                               /* （連携用）摘要コード */
) ;
