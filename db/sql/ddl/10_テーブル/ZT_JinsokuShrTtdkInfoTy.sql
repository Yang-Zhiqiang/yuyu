CREATE TABLE ZT_JinsokuShrTtdkInfoTy (
     ztysyorisosikicd                                   VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）処理組織コード                                  */
     ztysyoricd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）処理コード                                    */
     ztyhknknshrsntkno                                  VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険金支払処理選択番号                              */
     ztysyoruiukeymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）書類受付日                                    */
     ztysyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）処理年月日                                    */
     ztydenymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）伝票日付                                     */
     ztysyoruikeikaeigyoubisuu                          VARCHAR     (2)                                                                 ,  /* （中継用）書類受付経過営業日数                               */
     ztysyorikeikaeigyoubisuu                           VARCHAR     (2)                                                                 ,  /* （中継用）処理経過営業日数                                 */
     ztytoritugisosikicd                                VARCHAR     (7)                                                                 ,  /* （中継用）取次組織コード                                  */
     ztytanmatusyuruikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）端末種類区分                                   */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号                                     */
     ztykeiyakuymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）契約日                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE ZT_JinsokuShrTtdkInfoTy ADD CONSTRAINT PK_JinsokuShrTtdkInfoTy PRIMARY KEY (
     ztysyorisosikicd                                         , /* （中継用）処理組織コード                                   */
     ztysyoricd                                               , /* （中継用）処理コード                                     */
     ztyhknknshrsntkno                                        , /* （中継用）保険金支払処理選択番号                               */
     ztysyoruiukeymd                                          , /* （中継用）書類受付日                                     */
     ztysyoriymd                                              , /* （中継用）処理年月日                                     */
     ztydenymd                                                , /* （中継用）伝票日付                                      */
     ztysyono                                                   /* （中継用）証券番号                                      */
) ;
