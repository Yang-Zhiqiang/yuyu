CREATE TABLE ZT_KubunKeiriFileTy_Z (
     ztykaikeitani                                      VARCHAR     (7)                                                                 ,  /* （中継用）会計単位 */
     ztysystemkbnnum                                    VARCHAR     (2)                                                                 ,  /* （中継用）システム区分（数値） */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztytorihikiymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）取引年月日 */
     ztytorihikinon7                                    VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）取引番号Ｎ７ */
     ztynyuuryokubasyo                                  VARCHAR     (7)                                                                 ,  /* （中継用）入力場所 */
     ztynyuuryokusyacd                                  VARCHAR     (6)                                                                 ,  /* （中継用）入力者コード */
     ztysyoriymdn                                       VARCHAR     (8)                                                                 ,  /* （中継用）処理年月日（数値） */
     ztykessankbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）決算区分 */
     ztyonlinesyorikbn                                  VARCHAR     (2)                                                                 ,  /* （中継用）オンライン処理区分 */
     ztyyobiv28                                         VARCHAR     (28)                                                                ,  /* （中継用）予備項目Ｖ２８ */
     ztykanjyoukbnn                                     VARCHAR     (4)                                                                 ,  /* （中継用）勘定区分（数値） */
     ztytaisyakukbnn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）貸借区分（数値） */
     ztykanjyoukamokucdn                                VARCHAR     (5)                                                       NOT NULL  ,  /* （中継用）勘定科目コード（数値） */
     ztyyobiv4                                          VARCHAR     (4)                                                                 ,  /* （中継用）予備項目Ｖ４ */
     ztysuitoubumoncd                                   VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）出納部門コード */
     ztykingaku                                         DECIMAL     (15)                                                                ,  /* （中継用）金額 */
     ztykizokusegment                                   VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）帰属セグメント */
     ztyaitesegment                                     VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）相手セグメント */
     ztyyobiv23                                         VARCHAR     (23)                                                                ,  /* （中継用）予備項目Ｖ２３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KubunKeiriFileTy_Z ADD CONSTRAINT PK_KubunKeiriFileTy PRIMARY KEY (
     ztytorihikiymd                                           , /* （中継用）取引年月日 */
     ztytorihikinon7                                          , /* （中継用）取引番号Ｎ７ */
     ztytaisyakukbnn                                          , /* （中継用）貸借区分（数値） */
     ztykanjyoukamokucdn                                      , /* （中継用）勘定科目コード（数値） */
     ztysuitoubumoncd                                         , /* （中継用）出納部門コード */
     ztykizokusegment                                         , /* （中継用）帰属セグメント */
     ztyaitesegment                                             /* （中継用）相手セグメント */
) ;
