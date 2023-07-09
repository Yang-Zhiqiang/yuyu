CREATE TABLE ZT_DirectMailDataTy_Z (
     ztyhokenkbnnys                                     VARCHAR     (1)                                                                 ,  /* （中継用）保険区分（名寄せ） */
     ztysakuinmeinonys                                  VARCHAR     (10)                                                                ,  /* （中継用）索引名番号（名寄せ） */
     ztysyainnm                                         VARCHAR     (38)                                                                ,  /* （中継用）社員名 */
     ztysyainseiymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）社員生年月日 */
     ztykanjisyainnm                                    VARCHAR     (32)                                                                ,  /* （中継用）漢字社員名 */
     ztytsinkihontikucd                                 VARCHAR     (8)                                                                 ,  /* （中継用）通信先基本地区コード */
     ztynaimitureigaihyj                                VARCHAR     (1)                                                                 ,  /* （中継用）内密例外表示 */
     ztydrtenhyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）代理店表示 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykanjitsinkaiadr                                 VARCHAR     (126)                                                               ,  /* （中継用）漢字通信先下位住所 */
     ztysouhuhunoukbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）送付不能区分 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyhknnm                                           VARCHAR     (82)                                                                ,  /* （中継用）保険名称 */
     ztynenhousiki                                      VARCHAR     (1)                                                                 ,  /* （中継用）年齢方式 */
     ztykzktrkarihyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ご家族登録有表示 */
     ztyaatkioybsydrtencd                               VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者親募集代理店コード */
     ztybatkioybsydrtencd                               VARCHAR     (7)                                                                 ,  /* （中継用）Ｂ扱者親募集代理店コード */
     ztyyobiv250x1                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１ */
     ztyyobiv250x2                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿２ */
     ztyyobiv250x3                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿３ */
     ztyyobiv250x4                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿４ */
     ztyyobiv250x5                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿５ */
     ztyyobiv250x6                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿６ */
     ztyyobiv250x7                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿７ */
     ztyyobiv250x8                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿８ */
     ztyyobiv250x9                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿９ */
     ztyyobiv250x10                                     VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１０ */
     ztyyobiv250x11                                     VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１１ */
     ztyyobiv250x12                                     VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１２ */
     ztyyobiv250x13                                     VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１３ */
     ztyyobiv250x14                                     VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１４ */
     ztyyobiv122                                        VARCHAR     (122)                                                               ,  /* （中継用）予備項目Ｖ１２２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DirectMailDataTy_Z ADD CONSTRAINT PK_DirectMailDataTy PRIMARY KEY (
     ztysyono                                                   /* （中継用）証券番号 */
) ;
