CREATE TABLE ZT_DrtenIpToukeiTy (
     ztyeigyouhonbusisyacd                              VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）営業本部支社コード */
     ztysosikicd                                        VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）組織コード */
     ztyatukaikojincd                                   VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）扱者個人コード */
     ztymosym                                           VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）申込月度 */
     ztymoskbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）申込区分 */
     ztytansyukukjatukaisyanm                           VARCHAR     (7)                                                                 ,  /* （中継用）短縮漢字扱者名 */
     ztymosno                                           VARCHAR     (9)                                                       NOT NULL  ,  /* （中継用）申込番号 */
     ztymossyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込消滅区分 */
     ztykurikosiriyuukbn                                VARCHAR     (2)                                                                 ,  /* （中継用）繰越理由区分 */
     ztynyknzumihyouji                                  VARCHAR     (1)                                                                 ,  /* （中継用）入金済表示 */
     ztytoukeihknsyruikbn                               VARCHAR     (2)                                                                 ,  /* （中継用）統計用保険種類区分 */
     ztyhjykktkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）報状告知区分 */
     ztykykktaikbn                                      VARCHAR     (2)                                                                 ,  /* （中継用）契約形態区分 */
     ztyjyunhsys                                        NUMBER      (11)                                                                ,  /* （中継用）純保障Ｓ */
     ztyhsys                                            NUMBER      (11)                                                                ,  /* （中継用）保障Ｓ */
     ztysoukensuu                                       NUMBER      (3)                                                                 ,  /* （中継用）総件数 */
     ztyketjkkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）決定状況区分 */
     ztydakuhiktjyoutaikbn                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定状態区分 */
     ztykihonhubi                                       VARCHAR     (1)                                                                 ,  /* （中継用）基本不備 */
     ztysphubi                                          VARCHAR     (1)                                                                 ,  /* （中継用）ＳＰ不備 */
     ztysseigenhubi                                     VARCHAR     (1)                                                                 ,  /* （中継用）Ｓ制限不備 */
     ztynayosehumei                                     VARCHAR     (1)                                                                 ,  /* （中継用）名寄不明 */
     ztytuusangendoover                                 VARCHAR     (1)                                                                 ,  /* （中継用）通算限度オーバー */
     ztymosketteihoryuu                                 VARCHAR     (1)                                                                 ,  /* （中継用）申込決定保留 */
     ztykykkakjissityuu                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約確認実施中 */
     ztykktketteihoryuu                                 VARCHAR     (1)                                                                 ,  /* （中継用）告知決定保留 */
     ztyhonsyakethoryuu                                 VARCHAR     (1)                                                                 ,  /* （中継用）本社決定保留 */
     ztyseiymdhubi                                      VARCHAR     (1)                                                                 ,  /* （中継用）生年月日不備 */
     ztyphusoku                                         VARCHAR     (1)                                                                 ,  /* （中継用）Ｐ不足 */
     ztysrhuketyu                                       VARCHAR     (1)                                                                 ,  /* （中継用）成立保留受付中 */
     ztypkakin                                          VARCHAR     (1)                                                                 ,  /* （中継用）Ｐ過金 */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店扱形態区分 */
     ztysakuseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）作成日 */
     ztykydatkikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分 */
     ztytansyukukjhhknnm                                VARCHAR     (7)                                                                 ,  /* （中継用）短縮漢字被保険者名 */
     ztyhhknsykgycd                                     VARCHAR     (3)                                                                 ,  /* （中継用）被保険者職業コード */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztymusymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）申込年月日 */
     ztysyokaipryosyuymd                                VARCHAR     (8)                                                                 ,  /* （中継用）初回Ｐ領収年月日 */
     ztykokutiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）告知年月日 */
     ztymosnyuuryokuymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）申込入力年月日 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztysekininkaisiymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）責任開始年月日 */
     ztyfstpnyknsyoriymd                                VARCHAR     (8)                                                                 ,  /* （中継用）初回Ｐ入金処理年月日 */
     ztyfstpnyknnaiyoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）初回Ｐ入金内容区分 */
     ztysisyaketsyoriymd                                VARCHAR     (8)                                                                 ,  /* （中継用）支社決定処理年月日 */
     ztysyosakuseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）証券作成年月日 */
     ztyseisekiym                                       VARCHAR     (6)                                                                 ,  /* （中継用）成績計上年月 */
     ztysyokaiharaikomip                                NUMBER      (11)                                                                ,  /* （中継用）初回払込Ｐ */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztytokusyujimutoriatukaikbn                        VARCHAR     (1)                                                                 ,  /* （中継用）特殊事務取扱区分 */
     ztybsydrtencd                                      VARCHAR     (7)                                                                 ,  /* （中継用）募集代理店コード */
     ztybsydrtenkjnm                                    VARCHAR     (15)                                                                ,  /* （中継用）募集代理店漢字名称 */
     ztyatkisyagyskkjsosikicd                           VARCHAR     (7)                                                                 ,  /* （中継用）扱者業績計上先組織コード */
     ztyatkisyadrtenatkiwari                            NUMBER      (3)                                                                 ,  /* （中継用）扱者代理店扱割合 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztykinyuukikancd                                   VARCHAR     (4)                                                                 ,  /* （中継用）金融機関コード */
     ztyinfositencd                                     VARCHAR     (3)                                                                 ,  /* （中継用）（情報系）支店コード */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztykjkyknm10                                       VARCHAR     (10)                                                                ,  /* （中継用）漢字契約者名（１０文字） */
     ztykthhbhyouji                                     VARCHAR     (1)                                                                 ,  /* （中継用）決定保留不備表示 */
     ztysrhhbhyouji                                     VARCHAR     (1)                                                                 ,  /* （中継用）成立保留不備表示 */
     ztymossyumtkktymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）申込消滅確定年月日 */
     ztydairitenjimusyocd                               VARCHAR     (4)                                                                 ,  /* （中継用）代理店事務所コード */
     ztytsrybnwari                                      NUMBER      (3)                                                                 ,  /* （中継用）手数料分割割合 */
     ztydrtenkeijyouym                                  VARCHAR     (6)                                                                 ,  /* （中継用）代理店計上年月 */
     ztykydatkidairitencd                               VARCHAR     (7)                                                                 ,  /* （中継用）共同扱代理店コード */
     ztydaihyoubosyuunincd                              VARCHAR     (6)                                                                 ,  /* （中継用）代表募集人コード */
     ztytansyukukjdhybosyuunm                           VARCHAR     (7)                                                                 ,  /* （中継用）短縮漢字代表募集人名 */
     ztyknkyknm15                                       VARCHAR     (15)                                                                ,  /* （中継用）カナ契約者名（１５文字） */
     ztydakuhikettikekkacd                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定結果コード */
     ztydkhktiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）諾否決定年月日 */
     ztytoukeiyousinsakbn                               VARCHAR     (2)                                                                 ,  /* （中継用）統計用診査区分 */
     ztyhonninkknnkbn                                   VARCHAR     (2)                                                                 ,  /* （中継用）本人確認区分 */
     ztynstkarihyj                                      VARCHAR     (1)                                                                 ,  /* （中継用）年金支払特約有表示 */
     ztynstknkkkn                                       VARCHAR     (2)                                                                 ,  /* （中継用）年金支払特約年金期間 */
     ztydrtentsryhushrkykhyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）代理店手数料不支払契約表示 */
     ztynyknkanskanouhyouji                             VARCHAR     (1)                                                                 ,  /* （中継用）入金勧奨可能表示 */
     ztydshukahyouji                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＤＳ付加表示 */
     ztystdairiseikyuutkykarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）指定代理請求特約有表示 */
     ztykyksyanen                                       VARCHAR     (2)                                                                 ,  /* （中継用）契約者年令 */
     ztykyksyaseikbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約者性別区分 */
     ztyhhknseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）被保険者生年月日 */
     ztydrtenpaperlessmoshyj                            VARCHAR     (1)                                                                 ,  /* （中継用）代理店ペーパーレス申込表示 */
     ztydrtenmostousyaukeymd                            VARCHAR     (8)                                                                 ,  /* （中継用）代理店申込書当社受付年月日 */
     ztykyktuuka                                        VARCHAR     (1)                                                                 ,  /* （中継用）契約通貨 */
     ztyhrktuuka                                        VARCHAR     (1)                                                                 ,  /* （中継用）払込通貨 */
     ztysykihrkpgaika                                   NUMBER      (13,2)                                                              ,  /* （中継用）初回払込Ｐ（外貨） */
     ztyyennykntkarihyouji                              VARCHAR     (1)                                                                 ,  /* （中継用）円入金特約有表示 */
     ztygaikanykntkarihyouji                            VARCHAR     (1)                                                                 ,  /* （中継用）外貨入金特約有表示 */
     ztykihonsgaika                                     NUMBER      (13,2)                                                              ,  /* （中継用）基本Ｓ（外貨） */
     ztytekiyoukawaserate                               NUMBER      (7,4)                                                               ,  /* （中継用）適用為替レート */
     ztykawaseratetekiyouymd                            VARCHAR     (8)                                                                 ,  /* （中継用）為替レート適用年月日 */
     ztymkhyoutiyensysnikoukbn                          VARCHAR     (3)                                                                 ,  /* （中継用）目標到達時円建終身保障移行区分 */
     ztysyksbyensitihsyutkykhyj                         VARCHAR     (1)                                                                 ,  /* （中継用）初期死亡時円換算最低保証特約有表示 */
     ztyjyudkaigomehrtkarihyj                           VARCHAR     (1)                                                                 ,  /* （中継用）重度介護前払特約有表示 */
     ztysykihrkpsiteituuka                              NUMBER      (13,2)                                                              ,  /* （中継用）初回払込Ｐ（指定通貨） */
     ztyteirituhaibunwari                               VARCHAR     (3)                                                                 ,  /* （中継用）定率部分配分割合 */
     ztysueokikknkbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）据置期間区分 */
     ztynksyuruikbn1                                    VARCHAR     (1)                                                                 ,  /* （中継用）年金種類区分（１文字） */
     ztydairitenkbtinfo1                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報１ */
     ztydairitenkbtinfo2                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報２ */
     ztydairitenkbtinfo3                                VARCHAR     (15)                                                                ,  /* （中継用）代理店個別情報３ */
     ztyyohurimiryou                                    VARCHAR     (1)                                                                 ,  /* （中継用）預振未了 */
     ztykznyuuryokuymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）口座入力年月日 */
     ztysetaitemosno                                    VARCHAR     (9)                                                                 ,  /* （中継用）セット相手申込番号 */
     ztyyakkanjyuryouhoukbn                             VARCHAR     (1)                                                                 ,  /* （中継用）約款受領方法区分 */
     ztyyakkanbunsyono                                  VARCHAR     (16)                                                                ,  /* （中継用）約款文書番号 */
     ztykzhuritourokuhoukbn                             VARCHAR     (1)                                                                 ,  /* （中継用）口座振替登録方法区分 */
     ztydai1hknkkn                                      VARCHAR     (2)                                                                 ,  /* （中継用）第１保険期間 */
     ztycreditnyuuryokuymd                              VARCHAR     (8)                                                                 ,  /* （中継用）クレジット入力年月日 */
     ztycreditmiryou                                    VARCHAR     (1)                                                                 ,  /* （中継用）クレカ未了 */
     ztycredittrkhoukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）クレジット登録方法区分 */
     ztycardbrandkbn                                    VARCHAR     (10)                                                                ,  /* （中継用）カードブランド */
     ztycarddatasousinymd                               VARCHAR     (8)                                                                 ,  /* （中継用）カードデータ送信日 */
     ztykykdrtkykarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約者代理特約有表示 */
     ztykzktrkservicekbn                                VARCHAR     (1)                                                                 ,  /* （中継用）ご家族登録サービス区分 */
     ztyteikisiharaiarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）定期支払特約有表示 */
     ztyteikishrkinshrtuukakbn                          VARCHAR     (1)                                                                 ,  /* （中継用）定期支払金支払通貨区分 */
     ztyteikisiharaikin                                 NUMBER      (13,2)                                                              ,  /* （中継用）定期支払金 */
     ztykoureikzksetumeihoukbn                          VARCHAR     (1)                                                                 ,  /* （中継用）高齢者ご家族等説明方法区分 */
     ztykoureimndnhukusuukaikbn                         VARCHAR     (1)                                                                 ,  /* （中継用）高齢者面談複数回実施区分 */
     ztykoureitratkisyaigidskkbn                        VARCHAR     (1)                                                                 ,  /* （中継用）高齢者取扱者以外同席区分 */
     ztyyobiv53                                         VARCHAR     (53)                                                                ,  /* （中継用）予備項目Ｖ５３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DrtenIpToukeiTy ADD CONSTRAINT PK_DrtenIpToukeiTy PRIMARY KEY (
     ztyeigyouhonbusisyacd                                    , /* （中継用）営業本部支社コード */
     ztysosikicd                                              , /* （中継用）組織コード */
     ztyatukaikojincd                                         , /* （中継用）扱者個人コード */
     ztymosym                                                 , /* （中継用）申込月度 */
     ztymosno                                                   /* （中継用）申込番号 */
) ;
