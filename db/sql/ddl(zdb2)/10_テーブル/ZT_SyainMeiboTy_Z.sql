CREATE TABLE ZT_SyainMeiboTy_Z (
     ztyhokenkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）保険区分 */
     ztysyainmeibokbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）社員名簿用区分 */
     ztykyksyaskinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）契約者索引名番号 */
     ztysyainnm                                         VARCHAR     (38)                                                                ,  /* （中継用）社員名 */
     ztykanjisyainnm                                    VARCHAR     (32)                                                                ,  /* （中継用）漢字社員名 */
     ztysyainseiymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）社員生年月日 */
     ztytsinkihontikucd                                 VARCHAR     (8)                                                                 ,  /* （中継用）通信先基本地区コード */
     ztykanjitsinkaiadr                                 VARCHAR     (126)                                                               ,  /* （中継用）漢字通信先下位住所 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztytksyuannaikykkbn                                VARCHAR     (1)                                                                 ,  /* （中継用）特殊案内契約区分 */
     ztysouhuhunoukbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）送付不能区分 */
     ztysyainmeibos                                     DECIMAL     (13)                                                                ,  /* （中継用）社員名簿用Ｓ */
     ztysyainmeibop                                     DECIMAL     (11)                                                                ,  /* （中継用）社員名簿用Ｐ */
     ztysyainmeibosyouyop                               DECIMAL     (11)                                                                ,  /* （中継用）社員名簿用賞与払Ｐ */
     ztyyofuritysytzumihyouji                           VARCHAR     (1)                                                                 ,  /* （中継用）預振抽出済表示 */
     ztynayosekihontikucd                               VARCHAR     (8)                                                                 ,  /* （中継用）名寄せ用基本地区コード */
     ztyyobiv10                                         VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SyainMeiboTy_Z ADD CONSTRAINT PK_SyainMeiboTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;
