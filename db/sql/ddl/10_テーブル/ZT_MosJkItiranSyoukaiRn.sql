CREATE TABLE ZT_MosJkItiranSyoukaiRn (
     zrnmosym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）申込月度 */
     zrnmoskbn                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込区分 */
     zrnmosno                                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）申込番号 */
     zrnhknsyuruinm                                     VARCHAR     (10)                                                      NOT NULL  ,  /* （連携用）保険種類名称 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnmusymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込年月日 */
     zrnmosnyuuryokuymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）申込入力年月日 */
     zrnkydatkikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分 */
     zrnbsudirtnatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店扱形態区分 */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrnbsydrtenkjnm                                    VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）募集代理店漢字名称 */
     zrnatukaikojincd                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）扱者個人コード */
     zrntansyukukjatukaisyanm                           VARCHAR     (7)                                                       NOT NULL  ,  /* （連携用）短縮漢字扱者名 */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnkjkyknm10                                       VARCHAR     (10)                                                      NOT NULL  ,  /* （連携用）漢字契約者名（１０文字） */
     zrntansyukukjhhknnm                                VARCHAR     (7)                                                       NOT NULL  ,  /* （連携用）短縮漢字被保険者名 */
     zrnhhknnen2keta                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令（２桁） */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnmossyoumetukbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込消滅区分 */
     zrnkurikosiriyuukbn                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）繰越理由区分 */
     zrnketjkkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決定状況区分 */
     zrndakuhiktjyoutaikbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）諾否決定状態区分 */
     zrnmosketkekkakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込決定結果区分 */
     zrnkihonhubi                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）基本不備 */
     zrnkthhbhyouji                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決定保留不備表示 */
     zrnsrhhbhyouji                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）成立保留不備表示 */
     zrnnyknzumihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入金済表示 */
     zrnsinsazumihyouji                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）診査済表示 */
     zrntuukatanikbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通貨単位区分 */
     zrnsyokaihrkpmoji                                  CHAR        (11)                                                      NOT NULL  ,  /* （連携用）初回払込Ｐ（文字列） */
     zrnhjykktkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）報状告知区分 */
     zrnsyokaipryosyuymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）初回Ｐ領収年月日 */
     zrnkokutiymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）告知年月日 */
     zrnkariseirituymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）仮成立年月日 */
     zrnfstpnyknnaiyoukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初回Ｐ入金内容区分 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnsakuseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）作成日 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrnsyosakuseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）証券作成年月日 */
     zrnbsydrtenkobetuinfo1                             CHAR        (15)                                                      NOT NULL  ,  /* （連携用）募集代理店個別情報１ */
     zrnbsydrtenkobetuinfo2                             CHAR        (15)                                                      NOT NULL  ,  /* （連携用）募集代理店個別情報２ */
     zrnbsydrtenkobetuinfo3                             CHAR        (15)                                                      NOT NULL  ,  /* （連携用）募集代理店個別情報３ */
     zrnbsydrtenkobetuinfo4                             CHAR        (15)                                                      NOT NULL  ,  /* （連携用）募集代理店個別情報４ */
     zrnbsydrtenkobetuinfo5                             CHAR        (15)                                                      NOT NULL  ,  /* （連携用）募集代理店個別情報５ */
     zrnbankkouincd                                     CHAR        (10)                                                      NOT NULL  ,  /* （連携用）銀行行員コード */
     zrnbosyuutourokuno                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）募集人登録番号 */
     zrnmosjkkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）申込状況区分 */
     zrnkousinymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）更新年月日 */
     zrnsinsayoteiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）診査予定年月日 */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnkjhjnnm                                         VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）漢字法人名 */
     zrnyobiv93                                         CHAR        (93)                                                      NOT NULL     /* （連携用）予備項目Ｖ９３ */
)
;

ALTER TABLE ZT_MosJkItiranSyoukaiRn ADD CONSTRAINT PK_MosJkItiranSyoukaiRn PRIMARY KEY (
     zrnmosym                                                 , /* （連携用）申込月度 */
     zrnmosno                                                 , /* （連携用）申込番号 */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrnatukaikojincd                                           /* （連携用）扱者個人コード */
) ;
