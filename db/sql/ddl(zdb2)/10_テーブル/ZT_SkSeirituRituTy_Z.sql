CREATE TABLE ZT_SkSeirituRituTy_Z (
     ztyeigyouhonbusisyacd                              VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）営業本部支社コード */
     ztysisyanm                                         VARCHAR     (42)                                                                ,  /* （中継用）支社名 */
     ztysosikicd                                        VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）組織コード */
     ztykanjisosikinm20                                 VARCHAR     (42)                                                                ,  /* （中継用）漢字組織名（２０文字） */
     ztyatukaisyadrtenhyouji                            VARCHAR     (1)                                                                 ,  /* （中継用）扱者代理店表示 */
     ztyatukaikojincd                                   VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）扱者個人コード */
     ztytansyukukjatukaisyanm                           VARCHAR     (16)                                                                ,  /* （中継用）短縮漢字扱者名 */
     ztymosno                                           VARCHAR     (9)                                                       NOT NULL  ,  /* （中継用）申込番号 */
     ztyknjhhknmei                                      VARCHAR     (32)                                                                ,  /* （中継用）漢字被保険者名 */
     ztyhhknnen2keta                                    VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令（２桁） */
     ztykyksyanen                                       VARCHAR     (2)                                                                 ,  /* （中継用）契約者年令 */
     ztymosym                                           VARCHAR     (6)                                                                 ,  /* （中継用）申込月度 */
     ztymosnyuuryokuymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）申込入力年月日 */
     ztymoskbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）申込区分 */
     ztymossyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）申込消滅区分 */
     ztymossyumtkktymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）申込消滅確定年月日 */
     ztykurikosiriyuukbn                                VARCHAR     (2)                                                                 ,  /* （中継用）繰越理由区分 */
     ztynyknzumihyouji                                  VARCHAR     (1)                                                                 ,  /* （中継用）入金済表示 */
     ztynyknjkkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）入金状況区分 */
     ztyketjkkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）決定状況区分 */
     ztydakuhiktjyoutaikbn                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定状態区分 */
     ztykokutiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）告知年月日 */
     ztyhjykktkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）報状告知区分 */
     ztytokuteikanikokutikbn                            VARCHAR     (1)                                                                 ,  /* （中継用）特定簡易告知区分 */
     ztydakuhikettikekkacd                              VARCHAR     (2)                                                                 ,  /* （中継用）諾否決定結果コード */
     ztysinhsys                                         DECIMAL     (11)                                                                ,  /* （中継用）新保障Ｓ */
     ztyjyunhsys                                        DECIMAL     (11)                                                                ,  /* （中継用）純保障Ｓ */
     ztyhsys                                            DECIMAL     (11)                                                                ,  /* （中継用）保障Ｓ */
     ztysoukensuu                                       DECIMAL     (3)                                                                 ,  /* （中継用）総件数 */
     ztytoukeihknsyruikbn                               VARCHAR     (2)                                                                 ,  /* （中継用）統計用保険種類区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztykykktaikbn                                      VARCHAR     (2)                                                                 ,  /* （中継用）契約形態区分 */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）募集代理店扱形態区分 */
     ztytokusyujimutoriatukaikbn                        VARCHAR     (1)                                                                 ,  /* （中継用）特殊事務取扱区分 */
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
     ztymostoutyakuymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）申込書到着年月日 */
     ztykkttoutyakuymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）告知書到着年月日 */
     ztysakuseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）作成日 */
     ztysyokaipnyuknhuhukbn2                            VARCHAR     (2)                                                                 ,  /* （中継用）初回Ｐ入金方法区分（２文字） */
     ztysyokaiharaikomip                                DECIMAL     (11)                                                                ,  /* （中継用）初回払込Ｐ */
     ztyryousyuuymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）領収年月日 */
     ztykeiyakukakuninsyuruikbn                         VARCHAR     (2)                                                                 ,  /* （中継用）契約確認種類区分 */
     ztykykkakjkkbn1                                    VARCHAR     (1)                                                                 ,  /* （中継用）契約確認状況区分（1文字） */
     ztymusymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）申込年月日 */
     ztymossyosakuseiymd                                VARCHAR     (8)                                                                 ,  /* （中継用）申込書作成年月日 */
     ztysyosakuseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）証券作成年月日 */
     ztykjkyknm                                         VARCHAR     (32)                                                                ,  /* （中継用）漢字契約者名 */
     ztyknkyknm18                                       VARCHAR     (38)                                                                ,  /* （中継用）カナ契約者名（１８文字） */
     ztyseirituyoukihontikucd                           VARCHAR     (8)                                                                 ,  /* （中継用）成立率用基本地区コード */
     ztymosksnym                                        VARCHAR     (6)                                                                 ,  /* （中継用）申込起算年月 */
     ztyyohurimiryou                                    VARCHAR     (1)                                                                 ,  /* （中継用）預振未了 */
     ztycreditmiryou                                    VARCHAR     (1)                                                                 ,  /* （中継用）クレカ未了 */
     ztykzktrkservicekbn                                VARCHAR     (1)                                                                 ,  /* （中継用）ご家族登録サービス区分 */
     ztykykdrtkykarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約者代理特約有表示 */
     ztystdairiseikyuutkykarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）指定代理請求特約有表示 */
     ztyyakkanjyuryouhoukbn                             VARCHAR     (1)                                                                 ,  /* （中継用）約款受領方法区分 */
     ztyyakkanbunsyono                                  VARCHAR     (16)                                                                ,  /* （中継用）約款文書番号 */
     ztyyobiv37                                         VARCHAR     (37)                                                                ,  /* （中継用）予備項目Ｖ３７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SkSeirituRituTy_Z ADD CONSTRAINT PK_SkSeirituRituTy PRIMARY KEY (
     ztyeigyouhonbusisyacd                                    , /* （中継用）営業本部支社コード */
     ztysosikicd                                              , /* （中継用）組織コード */
     ztyatukaikojincd                                         , /* （中継用）扱者個人コード */
     ztymosno                                                   /* （中継用）申込番号 */
) ;
