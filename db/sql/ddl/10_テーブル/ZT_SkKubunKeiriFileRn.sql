CREATE TABLE ZT_SkKubunKeiriFileRn (
     zrnkaikeitani                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）会計単位 */
     zrnsystemkbnnum                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）システム区分（数値） */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrntorihikiymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）取引年月日 */
     zrntorihikinon7                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）取引番号Ｎ７ */
     zrnnyuuryokubasyo                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）入力場所 */
     zrnnyuuryokusyacd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）入力者コード */
     zrnsyoriymdn                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日（数値） */
     zrnkessankbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決算区分 */
     zrnonlinesyorikbn                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）オンライン処理区分 */
     zrnyobiv28                                         CHAR        (28)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２８ */
     zrnkanjyoukbnn                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）勘定区分（数値） */
     zrntaisyakukbnn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn                                CHAR        (5)                                                       NOT NULL  ,  /* （連携用）勘定科目コード（数値） */
     zrnyobiv4                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ４ */
     zrnsuitoubumoncd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）出納部門コード */
     zrnkingaku                                         NUMBER      (15)                                                      NOT NULL  ,  /* （連携用）金額 */
     zrnkizokusegment                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）帰属セグメント */
     zrnaitesegment                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）相手セグメント */
     zrnyobiv23                                         CHAR        (23)                                                      NOT NULL     /* （連携用）予備項目Ｖ２３ */
)
;

ALTER TABLE ZT_SkKubunKeiriFileRn ADD CONSTRAINT ZT_SkKubunKeiriFileRn PRIMARY KEY (
     zrntorihikiymd                                           , /* （連携用）取引年月日 */
     zrntorihikinon7                                          , /* （連携用）取引番号Ｎ７ */
     zrntaisyakukbnn                                          , /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn                                      , /* （連携用）勘定科目コード（数値） */
     zrnsuitoubumoncd                                         , /* （連携用）出納部門コード */
     zrnkizokusegment                                         , /* （連携用）帰属セグメント */
     zrnaitesegment                                             /* （連携用）相手セグメント */
) ;
