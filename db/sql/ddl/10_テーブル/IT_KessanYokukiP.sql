CREATE TABLE IT_KessanYokukiP (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     keijyouym                                          NUMBER      (6)                                                       NOT NULL  ,  /* 計上年月 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     hknsyukigousdkbn1keta                              VARCHAR     (1)                                                                 ,  /* 保険種類記号世代区分（１桁） */
     hokensyuruikigouyobi1x1                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１ */
     hokensyuruikigouyobi1x2                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿２ */
     hokensyuruikigouyobi1x3                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿３ */
     hokensyuruikigouyobi1x4                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿４ */
     hokensyuruikigouyobi1x5                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿５ */
     hokensyuruikigouyobi1x6                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿６ */
     hokensyuruikigouyobi1x7                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿７ */
     hokensyuruikigouyobi1x8                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿８ */
     hokensyuruikigouyobi1x9                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿９ */
     hokensyuruikigouyobi1x10                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１０ */
     hokensyuruikigouyobi1x11                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１１ */
     hokensyuruikigouyobi1x12                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１２ */
     hokensyuruikigouyobi1x13                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１３ */
     hokensyuruikigouyobi1x14                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１４ */
     hokensyuruikigouyobi1x15                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備１＿１５ */
     hokensyuruikigouyobi2x1                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿１ */
     hokensyuruikigouyobi2x2                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿２ */
     hokensyuruikigouyobi2x3                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿３ */
     hokensyuruikigouyobi2x4                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿４ */
     hokensyuruikigouyobi2x5                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿５ */
     hokensyuruikigouyobi2x6                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿６ */
     hokensyuruikigouyobi2x7                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿７ */
     hokensyuruikigouyobi2x8                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿８ */
     hokensyuruikigouyobi2x9                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿９ */
     hokensyuruikigouyobi2x10                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備２＿１０ */
     hokensyuruikigouyobi3x1                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿１ */
     hokensyuruikigouyobi3x2                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿２ */
     hokensyuruikigouyobi3x3                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿３ */
     hokensyuruikigouyobi3x4                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿４ */
     hokensyuruikigouyobi3x5                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿５ */
     hokensyuruikigouyobi3x6                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿６ */
     hokensyuruikigouyobi3x7                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿７ */
     hokensyuruikigouyobi3x8                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿８ */
     hokensyuruikigouyobi3x9                            VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿９ */
     hokensyuruikigouyobi3x10                           VARCHAR     (1)                                                                 ,  /* 保険種類記号予備３＿１０ */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     annaihuyouriyuukbn                                 VARCHAR     (2)                                                                 ,  /* 案内不要理由区分 */
     syoumetucd                                         NUMBER      (4)                                                                 ,  /* 消滅コード */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     haraikomip                                         NUMBER      (11)                                                                ,  /* 払込Ｐ */
     haraikomip$                                        VARCHAR     (10)                                                                ,  /* 払込Ｐ(通貨型) */
     syukykp                                            NUMBER      (11)                                                                ,  /* 主契約Ｐ */
     syukykp$                                           VARCHAR     (10)                                                                ,  /* 主契約Ｐ(通貨型) */
     zennyknmonth                                       NUMBER      (2)                                                                 ,  /* 前回入金月数 */
     zenyuukinymd                                       VARCHAR     (8)                                                                 ,  /* 前回入金年月日 */
     jidoukousinhyouji                                  VARCHAR     (1)                                                                 ,  /* 自動更新表示 */
     tenkanhyouji                                       VARCHAR     (1)                                                                 ,  /* 転換表示 */
     hosyouikkatumnoshyouji                             VARCHAR     (1)                                                                 ,  /* 保障一括見直表示 */
     yobi01xv40                                         VARCHAR     (40)                                                                ,  /* 予備０１＿Ｖ４０ */
     tkkzkp                                             NUMBER      (11)                                                                ,  /* 特約継続Ｐ */
     tkkzkp$                                            VARCHAR     (10)                                                                ,  /* 特約継続Ｐ(通貨型) */
     keizokuphurikaekngk                                NUMBER      (11)                                                                ,  /* 継続Ｐ振替金額 */
     keizokuphurikaekngk$                               VARCHAR     (10)                                                                ,  /* 継続Ｐ振替金額(通貨型) */
     keizokuphurikaekaisiym                             VARCHAR     (6)                                                                 ,  /* 継続Ｐ振替開始年月 */
     haraikomipannaisaikaiym                            VARCHAR     (6)                                                                 ,  /* 払込Ｐ案内再開年月 */
     tkkzkkouryokukaisiymd                              VARCHAR     (8)                                                                 ,  /* 特約継続効力開始年月日 */
     hrimngtkykpjyuutouhoukbn                           VARCHAR     (1)                                                                 ,  /* 払満後特約Ｐ充当方法区分 */
     jkitkpjytym                                        VARCHAR     (6)                                                                 ,  /* 次回特約Ｐ充当年月 */
     itijibrzugktkp                                     NUMBER      (11)                                                                ,  /* 一時払増額特約Ｐ */
     pazukarikingk                                      NUMBER      (11)                                                                ,  /* Ｐ預り金額 */
     zennoukbn                                          VARCHAR     (1)                                                                 ,  /* 前納区分 */
     zennoukaisiymd                                     VARCHAR     (8)                                                                 ,  /* 前納開始年月日 */
     zennounyuukinymd                                   VARCHAR     (8)                                                                 ,  /* 前納入金年月日 */
     yokukipbunruicd                                    VARCHAR     (3)                                                                 ,  /* 翌期Ｐ分類コード */
     misyoricd1                                         VARCHAR     (4)                                                                 ,  /* 未処理コード１ */
     misyoricd2                                         VARCHAR     (4)                                                                 ,  /* 未処理コード２ */
     misyoricd3                                         VARCHAR     (4)                                                                 ,  /* 未処理コード３ */
     misyoricd4                                         VARCHAR     (4)                                                                 ,  /* 未処理コード４ */
     misyoricd5                                         VARCHAR     (4)                                                                 ,  /* 未処理コード５ */
     misyoricd6                                         VARCHAR     (4)                                                                 ,  /* 未処理コード６ */
     misyoricd7                                         VARCHAR     (4)                                                                 ,  /* 未処理コード７ */
     misyoricd8                                         VARCHAR     (4)                                                                 ,  /* 未処理コード８ */
     misyoricd9                                         VARCHAR     (4)                                                                 ,  /* 未処理コード９ */
     misyoricd10                                        VARCHAR     (4)                                                                 ,  /* 未処理コード１０ */
     yobi02xv39                                         VARCHAR     (39)                                                                ,  /* 予備０２＿Ｖ３９ */
     kbnkeiriyousegmentkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用セグメント区分 */
     kbnkeiriyourgnbnskkbn                              VARCHAR     (2)                                                                 ,  /* 区分経理用利源分析区分 */
     suurisyuruicd                                      VARCHAR     (2)                                                                 ,  /* 数理種類コード */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     kyknendo                                           VARCHAR     (4)                                                                 ,  /* 契約年度 */
     keiyakum                                           VARCHAR     (2)                                                                 ,  /* 契約月 */
     haraikatakbn                                       VARCHAR     (2)                                                                 ,  /* 払方区分 */
     iktyknndp                                          NUMBER      (13)                                                                ,  /* 一括払翌年度保険料 */
     iktyknndp$                                         VARCHAR     (10)                                                                ,  /* 一括払翌年度保険料(通貨型) */
     kigetumaenyknyknndp                                NUMBER      (13)                                                                ,  /* 期月前入金翌年度保険料 */
     kigetumaenyknyknndp$                               VARCHAR     (10)                                                                ,  /* 期月前入金翌年度保険料(通貨型) */
     yknndpkei                                          NUMBER      (13)                                                                ,  /* 翌年度保険料合計 */
     yknndpkei$                                         VARCHAR     (10)                                                                ,  /* 翌年度保険料合計(通貨型) */
     yobi03xn13                                         NUMBER      (13)                                                                ,  /* 予備０３＿Ｎ１３ */
     yobi03xn13$                                        VARCHAR     (10)                                                                ,  /* 予備０３＿Ｎ１３(通貨型) */
     yobi04xv23                                         VARCHAR     (23)                                                                ,  /* 予備０４＿Ｖ２３ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KessanYokukiP ADD CONSTRAINT PK_KessanYokukiP PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     keijyouym                                                , /* 計上年月 */
     syono                                                      /* 証券番号 */
) ;
