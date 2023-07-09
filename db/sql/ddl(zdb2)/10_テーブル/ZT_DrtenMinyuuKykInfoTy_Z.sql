CREATE TABLE ZT_DrtenMinyuuKykInfoTy_Z (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztysyuukeikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）集計区分 */
     ztyminyukaisuu                                     VARCHAR     (3)                                                                 ,  /* （中継用）未入回数 */
     ztymisyuup                                         DECIMAL     (11)                                                                ,  /* （中継用）未収Ｐ */
     ztyhsys                                            DECIMAL     (11)                                                                ,  /* （中継用）保障Ｓ */
     ztysyuuseis                                        DECIMAL     (11)                                                                ,  /* （中継用）修正Ｓ */
     ztyfukkatutyuuikbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）復活注意区分 */
     ztymrarihyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）ＭＲ有表示 */
     ztyfsttatekaekykhyj                                VARCHAR     (1)                                                                 ,  /* （中継用）初回立替契約表示 */
     ztytatekaekjrenzokukaisu                           VARCHAR     (2)                                                                 ,  /* （中継用）立替計上連続回数 */
     ztykeizokutyuuihyouji                              VARCHAR     (1)                                                                 ,  /* （中継用）継続注意表示 */
     ztysyouhinbunruikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）商品分類区分 */
     ztysyouhnnmkbn                                     VARCHAR     (2)                                                                 ,  /* （中継用）商品名称区分 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyjikaipjyuutouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）次回Ｐ充当年月 */
     ztykzhurikaehurihunokbn                            VARCHAR     (1)                                                                 ,  /* （中継用）口座振替振替不能理由区分 */
     ztyautocalltaisyoukykhyj                           VARCHAR     (1)                                                                 ,  /* （中継用）オートコール対象契約表示 */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店扱形態区分 */
     ztybsydrtencdx1                                    VARCHAR     (7)                                                                 ,  /* （中継用）募集代理店コード＿１ */
     ztybsydrtencdx2                                    VARCHAR     (7)                                                                 ,  /* （中継用）募集代理店コード＿２ */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyyobiv34                                         VARCHAR     (34)                                                                ,  /* （中継用）予備項目Ｖ３４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DrtenMinyuuKykInfoTy_Z ADD CONSTRAINT PK_ZT_DrtenMinyuuKykInfoTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;
