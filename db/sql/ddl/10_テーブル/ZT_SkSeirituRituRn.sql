CREATE TABLE ZT_SkSeirituRituRn (
     zrneigyouhonbusisyacd                              CHAR        (7)                                                       NOT NULL  ,  /* （連携用）営業本部支社コード */
     zrnsisyanm                                         VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）支社名 */
     zrnsosikicd                                        CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コード */
     zrnkanjisosikinm20                                 VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）漢字組織名（２０文字） */
     zrnatukaisyadrtenhyouji                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）扱者代理店表示 */
     zrnatukaikojincd                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）扱者個人コード */
     zrntansyukukjatukaisyanm                           VARCHAR     (7)                                                       NOT NULL  ,  /* （連携用）短縮漢字扱者名 */
     zrnmosno                                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）申込番号 */
     zrnknjhhknmei                                      VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名 */
     zrnhhknnen2keta                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令（２桁） */
     zrnkyksyanen                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年令 */
     zrnmosym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）申込月度 */
     zrnmosnyuuryokuymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込入力年月日 */
     zrnmoskbn                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込区分 */
     zrnmossyoumetukbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込消滅区分 */
     zrnmossyumtkktymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込消滅確定年月日 */
     zrnkurikosiriyuukbn                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）繰越理由区分 */
     zrnnyknzumihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入金済表示 */
     zrnnyknjkkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入金状況区分 */
     zrnketjkkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決定状況区分 */
     zrndakuhiktjyoutaikbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定状態区分 */
     zrnkokutiymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）告知年月日 */
     zrnhjykktkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）報状告知区分 */
     zrntokuteikanikokutikbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特定簡易告知区分 */
     zrndakuhikettikekkacd                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定結果コード */
     zrnsinhsys                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）新保障Ｓ */
     zrnjyunhsys                                        NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）純保障Ｓ */
     zrnhsys                                            NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrnsoukensuu                                       NUMBER      (3)                                                       NOT NULL  ,  /* （連携用）総件数 */
     zrntoukeihknsyruikbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）統計用保険種類区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnkykktaikbn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約形態区分 */
     zrnbsudirtnatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店扱形態区分 */
     zrntokusyujimutoriatukaikbn                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特殊事務取扱区分 */
     zrnkihonhubi                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）基本不備 */
     zrnsphubi                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＳＰ不備 */
     zrnsseigenhubi                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｓ制限不備 */
     zrnnayosehumei                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）名寄不明 */
     zrntuusangendoover                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通算限度オーバー */
     zrnmosketteihoryuu                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込決定保留 */
     zrnkykkakjissityuu                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約確認実施中 */
     zrnkktketteihoryuu                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）告知決定保留 */
     zrnhonsyakethoryuu                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）本社決定保留 */
     zrnseiymdhubi                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）生年月日不備 */
     zrnphusoku                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ不足 */
     zrnsrhuketyu                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）成立保留受付中 */
     zrnpkakin                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ過金 */
     zrnmostoutyakuymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込書到着年月日 */
     zrnkkttoutyakuymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）告知書到着年月日 */
     zrnsakuseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）作成日 */
     zrnsyokaipnyuknhuhukbn2                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）初回Ｐ入金方法区分（２文字） */
     zrnsyokaiharaikomip                                NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）初回払込Ｐ */
     zrnryousyuuymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）領収年月日 */
     zrnkeiyakukakuninsyuruikbn                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約確認種類区分 */
     zrnkykkakjkkbn1                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約確認状況区分（１文字） */
     zrnmusymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込年月日 */
     zrnmossyosakuseiymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込書作成年月日 */
     zrnsyosakuseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）証券作成年月日 */
     zrnkjkyknm                                         VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字契約者名 */
     zrnknkyknm18                                       CHAR        (18)                                                      NOT NULL  ,  /* （連携用）カナ契約者名（１８文字） */
     zrnseirituyoukihontikucd                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）成立率用基本地区コード */
     zrnmosksnym                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）申込起算年月 */
     zrnyohurimiryou                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預振未了 */
     zrncreditmiryou                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）クレカ未了 */
     zrnkzktrkservicekbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ご家族登録サービス区分 */
     zrnkykdrtkykarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者代理特約有表示 */
     zrnstdairiseikyuutkykarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）指定代理請求特約有表示 */
     zrnyakkanjyuryouhoukbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）約款受領方法区分 */
     zrnyakkanbunsyono                                  CHAR        (16)                                                      NOT NULL  ,  /* （連携用）約款文書番号 */
     zrnyobiv37                                         CHAR        (37)                                                      NOT NULL     /* （連携用）予備項目Ｖ３７ */
)
;

ALTER TABLE ZT_SkSeirituRituRn ADD CONSTRAINT PK_SkSeirituRituRn PRIMARY KEY (
     zrneigyouhonbusisyacd                                    , /* （連携用）営業本部支社コード */
     zrnsosikicd                                              , /* （連携用）組織コード */
     zrnatukaikojincd                                         , /* （連携用）扱者個人コード */
     zrnmosno                                                   /* （連携用）申込番号 */
) ;
