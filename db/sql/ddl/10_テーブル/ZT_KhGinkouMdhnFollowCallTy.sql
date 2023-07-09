CREATE TABLE ZT_KhGinkouMdhnFollowCallTy (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztysyorikbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）処理区分 */
     ztyannaip                                          NUMBER      (11)                                                                ,  /* （中継用）案内保険料 */
     ztyyobiv8                                          VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８ */
     ztyminyuuym                                        VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）未入年月 */
     ztyskymd                                           VARCHAR     (8)                                                                 ,  /* （中継用）失効年月日 */
     ztyskhr                                            NUMBER      (11)                                                                ,  /* （中継用）失効時返戻金 */
     ztyttkekin                                         NUMBER      (11)                                                                ,  /* （中継用）今期立替金額 */
     ztyttkeganri                                       NUMBER      (11)                                                                ,  /* （中継用）立替元利金合計 */
     ztyttkersk                                         NUMBER      (11)                                                                ,  /* （中継用）立替利息 */
     ztyttkeriritu                                      VARCHAR     (4)                                                                 ,  /* （中継用）立替利率 */
     ztyttkejyuutouym                                   VARCHAR     (6)                                                                 ,  /* （中継用）立替充当年月 */
     ztyttkejyuutounen                                  VARCHAR     (1)                                                                 ,  /* （中継用）立替充当年数 */
     ztyttkejyuutoutuki                                 VARCHAR     (2)                                                                 ,  /* （中継用）立替充当月数 */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobiv8x2                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿２ */
     ztyyobiv29                                         VARCHAR     (29)                                                                ,  /* （中継用）予備項目Ｖ２９ */
     ztykyksyaskinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）契約者索引名番号 */
     ztykyksyaseiymd                                    VARCHAR     (8)                                                                 ,  /* （中継用）契約者生年月日 */
     ztykyknmhnykkbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約者名翻訳結果区分 */
     ztykjkyknm35keta                                   VARCHAR     (35)                                                                ,  /* （中継用）漢字契約者名（３５桁） */
     ztyknkyksyamei                                     VARCHAR     (41)                                                                ,  /* （中継用）カナ契約者名 */
     ztyhhknnmhnykkbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）被保険者名翻訳結果区分 */
     ztyknjhhknmei                                      VARCHAR     (15)                                                                ,  /* （中継用）漢字被保険者名 */
     ztyknhhknmei                                       VARCHAR     (18)                                                                ,  /* （中継用）カナ被保険者名 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）被保険者生年月日 */
     ztykihontikucd                                     VARCHAR     (8)                                                                 ,  /* （中継用）基本地区コード */
     ztykyksyaadr                                       VARCHAR     (62)                                                                ,  /* （中継用）契約者住所 */
     ztytsintelno                                       VARCHAR     (14)                                                                ,  /* （中継用）通信先電話番号 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyjikaipjyuutouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）次回Ｐ充当年月 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyanniskcd                                        VARCHAR     (8)                                                                 ,  /* （中継用）案内先コード */
     ztyhknmeisyou15keta                                VARCHAR     (15)                                                                ,  /* （中継用）保険名称（１５桁） */
     ztybsyujdrtencd1                                   VARCHAR     (7)                                                                 ,  /* （中継用）募集時代理店コード１ */
     ztybsyujbosyuucd1                                  VARCHAR     (6)                                                                 ,  /* （中継用）募集時募集人コード１ */
     ztybsyujdrtencd2                                   VARCHAR     (7)                                                                 ,  /* （中継用）募集時代理店コード２ */
     ztybsyujbosyuucd2                                  VARCHAR     (6)                                                                 ,  /* （中継用）募集時募集人コード２ */
     ztybsyujdrtencd3                                   VARCHAR     (7)                                                                 ,  /* （中継用）募集時代理店コード３ */
     ztybsyujbosyuucd3                                  VARCHAR     (6)                                                                 ,  /* （中継用）募集時募集人コード３ */
     ztybsyujdrtencd4                                   VARCHAR     (7)                                                                 ,  /* （中継用）募集時代理店コード４ */
     ztybsyujbosyuucd4                                  VARCHAR     (6)                                                                 ,  /* （中継用）募集時募集人コード４ */
     ztybsyujdrtencd5                                   VARCHAR     (7)                                                                 ,  /* （中継用）募集時代理店コード５ */
     ztybsyujbosyuucd5                                  VARCHAR     (6)                                                                 ,  /* （中継用）募集時募集人コード５ */
     ztysaisindrtencd                                   VARCHAR     (7)                                                                 ,  /* （中継用）最新代理店コード */
     ztysaisinbosyuucd                                  VARCHAR     (6)                                                                 ,  /* （中継用）最新募集人コード */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号 */
     ztyhnsyugkhmignnmei                                VARCHAR     (30)                                                                ,  /* （中継用）編集後口座振替名義人名 */
     ztyyobiv39                                         VARCHAR     (39)                                                                ,  /* （中継用）予備項目Ｖ３９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_KhGinkouMdhnFollowCallTy ADD CONSTRAINT PK_KhGinkouMdhnFollowCallTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyminyuuym                                                /* （中継用）未入年月 */
) ;
