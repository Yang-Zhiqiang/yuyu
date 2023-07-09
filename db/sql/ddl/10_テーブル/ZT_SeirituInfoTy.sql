CREATE TABLE ZT_SeirituInfoTy (
     ztykijyunym                                        VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）基準年月 */
     ztyseisekiym                                       VARCHAR     (6)                                                                 ,  /* （中継用）成績計上年月 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhanbainm                                        VARCHAR     (2)                                                                 ,  /* （中継用）販売名称 */
     ztyatkisisya                                       VARCHAR     (3)                                                                 ,  /* （中継用）扱支社 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztysdpdkbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）Ｓ建Ｐ建区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztysinkykryouritukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）新契約用料率区分 */
     ztyduketorihouhoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）Ｄ受取方法区分 */
     ztykihons9                                         NUMBER      (9)                                                                 ,  /* （中継用）基本Ｓ（９桁） */
     ztyhsys                                            NUMBER      (11)                                                                ,  /* （中継用）保障Ｓ */
     ztytkbriknsnhrkp                                   NUMBER      (11)                                                                ,  /* （中継用）月払換算払込Ｐ */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztykyksyaseikbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約者性別区分 */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztykyksyanen                                       VARCHAR     (2)                                                                 ,  /* （中継用）契約者年令 */
     ztysykgycd                                         VARCHAR     (3)                                                                 ,  /* （中継用）職業コード */
     ztykyksyakikykarihyj                               VARCHAR     (1)                                                                 ,  /* （中継用）契約者既契約有表示 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztysyokaipnyuukinhouhoukbn                         VARCHAR     (1)                                                                 ,  /* （中継用）初回Ｐ入金方法区分 */
     ztytoukeiyousinsakbn                               VARCHAR     (2)                                                                 ,  /* （中継用）統計用診査区分 */
     ztyhhknsynensyuukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）被保険者年収区分 */
     ztysyukeiyakup                                     NUMBER      (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店扱形態区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztystdairiseikyuutkykarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）指定代理請求特約有表示 */
     ztymannenreihyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）満年令表示 */
     ztynksyuruikbn1                                    VARCHAR     (1)                                                                 ,  /* （中継用）年金種類区分（１文字） */
     ztynstkarihyj                                      VARCHAR     (1)                                                                 ,  /* （中継用）年金支払特約有表示 */
     ztyaatkioybsydrtencd                               VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者親募集代理店コード */
     ztybatkioybsydrtencd                               VARCHAR     (7)                                                                 ,  /* （中継用）Ｂ扱者親募集代理店コード */
     ztysinkeiyakujiyoteiriritu                         NUMBER      (5,4)                                                               ,  /* （中継用）新契約時予定利率 */
     ztysiteituukakihons                                NUMBER      (13,2)                                                              ,  /* （中継用）指定通貨建基本Ｓ */
     ztyhrktuukakbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込通貨区分 */
     ztysiteituukakbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）指定通貨区分 */
     ztyhrktuukatukiknznhrkp                            NUMBER      (13,2)                                                              ,  /* （中継用）払込通貨建月換算払込Ｐ */
     ztysiteituukatukiknznhrkp                          NUMBER      (13,2)                                                              ,  /* （中継用）指定通貨建月換算払込Ｐ */
     ztyyennyknrate                                     NUMBER      (7,4)                                                               ,  /* （中継用）円入金レート */
     ztygaikanyknrate                                   NUMBER      (7,4)                                                               ,  /* （中継用）外貨入金レート */
     ztyjyudkaigomehrtkarihyj                           VARCHAR     (1)                                                                 ,  /* （中継用）重度介護前払特約有表示 */
     ztysyksbyensitihsyutkykrate                        NUMBER      (7,4)                                                               ,  /* （中継用）初期死亡時円換算最低保証特約用為替レート */
     ztysjkkktyouseiriritu                              NUMBER      (5,4)                                                               ,  /* （中継用）市場価格調整用利率 */
     ztytargettkmkht                                    NUMBER      (3)                                                                 ,  /* （中継用）ターゲット特約目標値 */
     ztyteirituhaibunwari                               VARCHAR     (3)                                                                 ,  /* （中継用）定率部分配分割合 */
     ztyzenkizennouhyouji                               VARCHAR     (1)                                                                 ,  /* （中継用）全期前納表示 */
     ztypwaribikikbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ割引区分 */
     ztypwaribikihanteigk                               NUMBER      (11)                                                                ,  /* （中継用）Ｐ割引判定金額 */
     ztydai1hknkkn                                      VARCHAR     (2)                                                                 ,  /* （中継用）第１保険期間 */
     ztykykdrtkykarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約者代理特約有表示 */
     ztykzktrkservicetrkninzuu                          VARCHAR     (1)                                                                 ,  /* （中継用）ご家族登録サービス登録人数 */
     ztyteikisiharaiarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）定期支払特約有表示 */
     ztyyobiv6                                          VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SeirituInfoTy ADD CONSTRAINT PK_SeirituInfoTy PRIMARY KEY (
     ztykijyunym                                              , /* （中継用）基準年月 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
