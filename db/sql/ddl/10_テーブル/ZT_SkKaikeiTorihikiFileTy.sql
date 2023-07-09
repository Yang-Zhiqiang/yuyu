CREATE TABLE ZT_SkKaikeiTorihikiFileTy (
     ztylen                                             VARCHAR     (4)                                                                 ,  /* （中継用）ＬＥＮ                                      */
     ztykaikeitani                                      VARCHAR     (7)                                                                 ,  /* （中継用）会計単位                                     */
     ztysystemkbnnum                                    VARCHAR     (2)                                                                 ,  /* （中継用）システム区分（数値）                               */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード                                    */
     ztytorihikiymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）取引年月日                                    */
     ztytorihikinon7                                    VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）取引番号Ｎ７                                   */
     ztynyuuryokubasyo                                  VARCHAR     (7)                                                                 ,  /* （中継用）入力場所                                     */
     ztynyuuryokusyacd                                  VARCHAR     (6)                                                                 ,  /* （中継用）入力者コード                                   */
     ztysyoriymdn                                       VARCHAR     (8)                                                                 ,  /* （中継用）処理年月日（数値）                                */
     ztysimekirikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）締切区分                                     */
     ztykessankbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）決算区分                                     */
     ztyyobiv20                                         VARCHAR     (20)                                                                ,  /* （中継用）予備項目Ｖ２０                                  */
     ztykaisyakantorihikikbn                            VARCHAR     (1)                                                                 ,  /* （中継用）会社間取引区分                                  */
     ztytukekaekbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）付替区分                                     */
     ztytablekosuu                                      VARCHAR     (3)                                                                 ,  /* （中継用）テーブル個数                                   */
     ztykanjyoukbnn                                     VARCHAR     (4)                                                                 ,  /* （中継用）勘定区分（数値）                                 */
     ztytaisyakukbnn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）貸借区分（数値）                                 */
     ztykanjyoukamokucdn                                VARCHAR     (5)                                                       NOT NULL  ,  /* （中継用）勘定科目コード（数値）                              */
     ztyyobiv4                                          VARCHAR     (4)                                                                 ,  /* （中継用）予備項目Ｖ４                                   */
     ztysuitoubumon                                     VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）出納部門                                     */
     ztykingaku                                         NUMBER      (15)                                                                ,  /* （中継用）金額                                       */
     ztytekiyoucd                                       VARCHAR     (20)                                                      NOT NULL  ,  /* （中継用）摘要コード                                    */
     ztyyobiv10                                         VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０                                  */
     ztymeisaikanryoukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）明細完了区分                                   */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE ZT_SkKaikeiTorihikiFileTy ADD CONSTRAINT PK_SkKaikeiTorihikiFileTy PRIMARY KEY (
     ztytorihikiymd                                           , /* （中継用）取引年月日                                     */
     ztytorihikinon7                                          , /* （中継用）取引番号Ｎ７                                    */
     ztytaisyakukbnn                                          , /* （中継用）貸借区分（数値）                                  */
     ztykanjyoukamokucdn                                      , /* （中継用）勘定科目コード（数値）                               */
     ztysuitoubumon                                           , /* （中継用）出納部門                                      */
     ztytekiyoucd                                               /* （中継用）摘要コード                                     */
) ;
