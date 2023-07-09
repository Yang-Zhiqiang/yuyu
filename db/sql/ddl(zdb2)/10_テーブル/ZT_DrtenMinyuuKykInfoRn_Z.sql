CREATE TABLE ZT_DrtenMinyuuKykInfoRn_Z (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnsyuukeikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）集計区分 */
     zrnminyukaisuu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）未入回数 */
     zrnmisyuup                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）未収Ｐ */
     zrnhsys                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrnsyuuseis                                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）修正Ｓ */
     zrnfukkatutyuuikbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）復活注意区分 */
     zrnmrarihyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＭＲ有表示 */
     zrnfsttatekaekykhyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初回立替契約表示 */
     zrntatekaekjrenzokukaisu                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）立替計上連続回数 */
     zrnkeizokutyuuihyouji                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）継続注意表示 */
     zrnsyouhinbunruikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）商品分類区分 */
     zrnsyouhnnmkbn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）商品名称区分 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrnkzhurikaehurihunokbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替振替不能理由区分 */
     zrnautocalltaisyoukykhyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）オートコール対象契約表示 */
     zrnbsudirtnatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店扱形態区分 */
     zrnbsydrtencdx1                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード＿１ */
     zrnbsydrtencdx2                                    CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード＿２ */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnyobiv34                                         CHAR        (34)                                                      NOT NULL     /* （連携用）予備項目Ｖ３４ */
)
;

ALTER TABLE ZT_DrtenMinyuuKykInfoRn_Z ADD CONSTRAINT PK_ZT_DrtenMinyuuKykInfoRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
