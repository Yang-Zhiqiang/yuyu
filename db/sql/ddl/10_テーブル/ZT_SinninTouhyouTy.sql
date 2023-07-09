CREATE TABLE ZT_SinninTouhyouTy (
     ztyhokenkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）保険区分 */
     ztykyknaiyoukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約内容区分 */
     ztyhokenkbnnys                                     VARCHAR     (1)                                                                 ,  /* （中継用）保険区分（名寄せ） */
     ztysakuinmeinonys                                  VARCHAR     (10)                                                                ,  /* （中継用）索引名番号（名寄せ） */
     ztysyainnm                                         VARCHAR     (18)                                                                ,  /* （中継用）社員名 */
     ztykanjisyainnm                                    VARCHAR     (15)                                                                ,  /* （中継用）漢字社員名 */
     ztysyainseiymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）社員生年月日 */
     ztytsinkihontikucd                                 VARCHAR     (8)                                                                 ,  /* （中継用）通信先基本地区コード */
     ztykanjitsinkaiadr                                 VARCHAR     (62)                                                                ,  /* （中継用）漢字通信先下位住所 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztytksyuannaikykkbn                                VARCHAR     (1)                                                                 ,  /* （中継用）特殊案内契約区分 */
     ztysouhuhunoukbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）送付不能区分 */
     ztynaimitureigaihyj                                VARCHAR     (1)                                                                 ,  /* （中継用）内密例外表示 */
     ztysyuukinsisya                                    VARCHAR     (3)                                                                 ,  /* （中継用）集金支社 */
     ztysyuukintntusycd                                 VARCHAR     (6)                                                                 ,  /* （中継用）集金担当者個人コード */
     ztyokyakusamano                                    VARCHAR     (10)                                                                ,  /* （中継用）お客様番号 */
     ztynaibukojincd                                    VARCHAR     (6)                                                                 ,  /* （中継用）内部個人コード */
     ztyhokenkbnsyainno                                 VARCHAR     (1)                                                                 ,  /* （中継用）保険区分（社員ＮＯ） */
     ztysakuinmeinosyainno                              VARCHAR     (10)                                                                ,  /* （中継用）索引名番号（社員ＮＯ） */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyprivacyhogoyouhyj                               VARCHAR     (1)                                                                 ,  /* （中継用）プライバシー保護要表示 */
     ztykaigaitokoukykhyj                               VARCHAR     (1)                                                                 ,  /* （中継用）海外渡航契約表示 */
     ztynaibukbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）内部区分 */
     ztykyktsnatkitkyktrkjtkbn                          VARCHAR     (1)                                                                 ,  /* （中継用）契約通算扱特約登録状態区分 */
     ztyalcardhkkbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）ＡＬカード発行区分 */
     ztybsydrtenkbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店区分 */
     ztyvitkaiinno                                      VARCHAR     (10)                                                                ,  /* （中継用）Ｖｉｔ会員番号 */
     ztyyobiv60                                         VARCHAR     (60)                                                                ,  /* （中継用）予備項目Ｖ６０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SinninTouhyouTy ADD CONSTRAINT PK_SinninTouhyouTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;
