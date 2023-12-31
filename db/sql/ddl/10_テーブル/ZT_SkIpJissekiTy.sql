CREATE TABLE ZT_SkIpJissekiTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztymosym                                           VARCHAR     (6)                                                                 ,  /* （中継用）申込月度 */
     ztyatukaikojincd                                   VARCHAR     (6)                                                                 ,  /* （中継用）扱者個人コード */
     ztydairitenatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）代理店扱形態区分 */
     ztyatkiwari3keta                                   NUMBER      (3)                                                                 ,  /* （中継用）扱割合（３桁） */
     ztykjsakininisetteihyj                             VARCHAR     (1)                                                                 ,  /* （中継用）計上先任意設定表示 */
     ztymosno                                           VARCHAR     (9)                                                                 ,  /* （中継用）申込番号 */
     ztykydatkikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分 */
     ztymossyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込消滅区分 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztykyksyanen                                       VARCHAR     (2)                                                                 ,  /* （中継用）契約者年令 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztykykktaikbn                                      VARCHAR     (2)                                                                 ,  /* （中継用）契約形態区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyryouritukbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）料率区分 */
     ztyrendouyouharaikomip                             NUMBER      (11)                                                                ,  /* （中継用）連動用払込Ｐ */
     ztysyukeiyakup                                     NUMBER      (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztyatukaisosikicd                                  VARCHAR     (7)                                                                 ,  /* （中継用）扱者組織コード */
     ztytoukeiyousinsakbn                               VARCHAR     (2)                                                                 ,  /* （中継用）統計用診査区分 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztysdpdkbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）Ｓ建Ｐ建区分 */
     ztygyousekiyouhosyous                              NUMBER      (11)                                                                ,  /* （中継用）業績用保障Ｓ */
     ztygoukeikihons                                    NUMBER      (11)                                                                ,  /* （中継用）合計基本Ｓ */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztymusymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）申込年月日 */
     ztymosnyuuryokuymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）申込入力年月日 */
     ztysyokaipryosyuymd                                VARCHAR     (8)                                                                 ,  /* （中継用）初回Ｐ領収年月日 */
     ztyfstpnyknsyoriymd                                VARCHAR     (8)                                                                 ,  /* （中継用）初回Ｐ入金処理年月日 */
     ztykokutiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）告知年月日 */
     ztymossyumtkktymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）申込消滅確定年月日 */
     ztysisyaketsyoriymd                                VARCHAR     (8)                                                                 ,  /* （中継用）支社決定処理年月日 */
     ztymossyosakuseiymd                                VARCHAR     (8)                                                                 ,  /* （中継用）申込書作成年月日 */
     ztyhhknsakuinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）被保険者索引名番号 */
     ztyhaitousiharaikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）配当支払区分 */
     ztyhubikbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）不備区分 */
     ztytsinkihontikucd                                 VARCHAR     (8)                                                                 ,  /* （中継用）通信先基本地区コード */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyseisekiym                                       VARCHAR     (6)                                                                 ,  /* （中継用）成績計上年月 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztytokusyujimutoriatukaikbn                        VARCHAR     (1)                                                                 ,  /* （中継用）特殊事務取扱区分 */
     ztybsydrtencd                                      VARCHAR     (7)                                                                 ,  /* （中継用）募集代理店コード */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztykyksyaskinmeino                                 VARCHAR     (10)                                                                ,  /* （中継用）契約者索引名番号 */
     ztymossakuseino                                    VARCHAR     (9)                                                                 ,  /* （中継用）申込書作成番号 */
     ztyhokensyuruikigouyobi1x1                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１ */
     ztyhokensyuruikigouyobi1x2                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿２ */
     ztyhokensyuruikigouyobi1x3                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿３ */
     ztyhokensyuruikigouyobi1x4                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿４ */
     ztyhokensyuruikigouyobi1x5                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿５ */
     ztyhokensyuruikigouyobi1x6                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿６ */
     ztyhokensyuruikigouyobi1x7                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿７ */
     ztyhokensyuruikigouyobi1x8                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿８ */
     ztyhokensyuruikigouyobi1x9                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿９ */
     ztyhokensyuruikigouyobi1x10                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１０ */
     ztyhokensyuruikigouyobi1x11                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１１ */
     ztyhokensyuruikigouyobi1x12                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１２ */
     ztyhokensyuruikigouyobi1x13                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１３ */
     ztyhokensyuruikigouyobi1x14                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１４ */
     ztyhokensyuruikigouyobi1x15                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備１＿１５ */
     ztyhokensyuruikigouyobi2x1                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿１ */
     ztyhokensyuruikigouyobi2x2                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿２ */
     ztyhokensyuruikigouyobi2x3                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿３ */
     ztyhokensyuruikigouyobi2x4                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿４ */
     ztyhokensyuruikigouyobi2x5                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿５ */
     ztyhokensyuruikigouyobi2x6                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿６ */
     ztyhokensyuruikigouyobi2x7                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿７ */
     ztyhokensyuruikigouyobi2x8                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿８ */
     ztyhokensyuruikigouyobi2x9                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿９ */
     ztyhokensyuruikigouyobi2x10                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備２＿１０ */
     ztyhokensyuruikigouyobi3x1                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿１ */
     ztyhokensyuruikigouyobi3x2                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿２ */
     ztyhokensyuruikigouyobi3x3                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿３ */
     ztyhokensyuruikigouyobi3x4                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿４ */
     ztyhokensyuruikigouyobi3x5                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿５ */
     ztyhokensyuruikigouyobi3x6                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿６ */
     ztyhokensyuruikigouyobi3x7                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿７ */
     ztyhokensyuruikigouyobi3x8                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿８ */
     ztyhokensyuruikigouyobi3x9                         VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿９ */
     ztyhokensyuruikigouyobi3x10                        VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号予備３＿１０ */
     ztynstkarihyj                                      VARCHAR     (1)                                                                 ,  /* （中継用）年金支払特約有表示 */
     ztystdairiseikyuutkykarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）指定代理請求特約有表示 */
     ztydai1kyktdkkbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）第１契約者続柄区分 */
     ztymossyouninymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）申込承認入力年月日 */
     ztynenkansanp                                      NUMBER      (11)                                                                ,  /* （中継用）年換算Ｐ */
     ztysibous                                          NUMBER      (11)                                                                ,  /* （中継用）死亡Ｓ */
     ztynksyuruikbn1                                    VARCHAR     (1)                                                                 ,  /* （中継用）年金種類区分（１文字） */
     ztyhensyuukeiyakusyamei                            VARCHAR     (41)                                                                ,  /* （中継用）編集契約者名 */
     ztykanjitsinkaiadr                                 VARCHAR     (62)                                                                ,  /* （中継用）漢字通信先下位住所 */
     ztytsintelno                                       VARCHAR     (14)                                                                ,  /* （中継用）通信先電話番号 */
     ztyhhknmei                                         VARCHAR     (18)                                                                ,  /* （中継用）被保険者名 */
     ztyhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）被保険者生年月日 */
     ztyhensyuuyoukyksyaseiymd                          VARCHAR     (8)                                                                 ,  /* （中継用）編集用契約者生年月日 */
     ztyitijibaraipkyktuuka                             NUMBER      (15,2)                                                              ,  /* （中継用）一時払Ｐ（契約通貨建） */
     ztykawaseraten5                                    NUMBER      (5,2)                                                               ,  /* （中継用）為替レートＮ５ */
     ztyhrktuukakbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込通貨区分 */
     ztysiteituukakbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）指定通貨区分 */
     ztysyksbsitihsyutkykarihyj                         VARCHAR     (1)                                                                 ,  /* （中継用）初期死亡時最低保証特約有表示 */
     ztyskkaigomaehrtkykarihyj                          VARCHAR     (1)                                                                 ,  /* （中継用）（新契約）介護前払特約有表示 */
     ztykihonskyktuuka                                  NUMBER      (15)                                                                ,  /* （中継用）基本Ｓ（契約通貨建） */
     ztyzenkizennouhyouji                               VARCHAR     (1)                                                                 ,  /* （中継用）全期前納表示 */
     ztynnknsnpssysyup                                  NUMBER      (11)                                                                ,  /* （中継用）年換算Ｐ算出用主契約Ｐ */
     ztynknsnpssyhrkkskbn                               VARCHAR     (1)                                                                 ,  /* （中継用）年換算Ｐ算出用払込回数区分 */
     ztykykdrtkykarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約者代理特約有表示 */
     ztykzktrkservicearihyj                             VARCHAR     (1)                                                                 ,  /* （中継用）ご家族登録サービス有表示 */
     ztyyobiv250x1                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿１ */
     ztyyobiv250x2                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿２ */
     ztyyobiv250x3                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿３ */
     ztyyobiv250x4                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿４ */
     ztyyobiv250x5                                      VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０＿５ */
     ztyyobiv213                                        VARCHAR     (213)                                                               ,  /* （中継用）予備項目Ｖ２１３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SkIpJissekiTy ADD CONSTRAINT PK_SkIpJissekiTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
