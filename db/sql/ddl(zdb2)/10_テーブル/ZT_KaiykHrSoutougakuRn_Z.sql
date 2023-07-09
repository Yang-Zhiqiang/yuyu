CREATE TABLE ZT_KaiykHrSoutougakuRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyobiv12                                         CHAR        (12)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１２ */
     zrnkeisankijyunym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）計算基準年月 */
     zrndatakanrino                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）データ管理番号 */
     zrnsyutkkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約特約区分 */
     zrnsuurisyuruicd                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）数理種類コード */
     zrnkbnkeiriyousegmentkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）区分経理用利源分析区分 */
     zrnharaikatakbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払方区分 */
     zrntenkanitijibaraikbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換一時払区分 */
     zrntyuutohukahyouji                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）中途付加表示 */
     zrnsuuriyouyobin6                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ６ */
     zrnyobiv6x2                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ６＿２ */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnsotodasipmenkbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出Ｐ免区分 */
     zrnsotodasikousinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出更新区分 */
     zrnsotodasimanagehyouji                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出満年令表示 */
     zrnsotodasiphkbnmnoshyouji                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出Ｐ不可分見直表示 */
     zrnknkuzusnzyrttekitkarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）健康増進乗率適用特約有表示 */
     zrnhokensyuruikigouyobi                            CHAR        (5)                                                       NOT NULL  ,  /* （連携用）保険種類記号予備 */
     zrntokuyakugatakbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約型区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnryouritukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）料率区分 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnhihokensyaagev2                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令Ｖ２ */
     zrnkyksyanen                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年令 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrntkbthsyumnryuhyouji                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特別保障満了表示 */
     zrnnknshry                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）年金支払期間 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnkykjyoutai                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約状態 */
     zrnharaizumientyoujiage                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）払済延長時年令 */
     zrnentyoukikan                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）延長期間 */
     zrnsiteimpbairitu                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）指定月Ｐ倍率 */
     zrnpwarimasisiteim1                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ割増指定月１ */
     zrnpwarimasisiteim2                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ割増指定月２ */
     zrnsaisyuusiteiym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）最終指定年月 */
     zrnseizonkyuuhukinshrmd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）生存給付支払月日 */
     zrnkeikanensuu                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）経過年数 */
     zrnkeikatukisuu                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）経過月数 */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrntnknhktgkujyarhyouji                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換引継控除有表示 */
     zrntokuyakukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特約区分 */
     zrntokuyakuno                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特約番号 */
     zrndi2hknkknikoujihisyaage                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第２保険期間移行時被者年令 */
     zrnrecordno                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）レコード番号 */
     zrnmfkuriagekurisagekbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＭＦ繰上げ繰下げ区分 */
     zrnmfannaihuyouriyuukbn                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＭＦ案内不要理由区分 */
     zrnhrizmjhknsyukigousdkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払済時保険種類記号世代区分 */
     zrnhokenhoutekiyouhyouji                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険法適用表示 */
     zrntokubetuhosyoukikan                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特別保障期間 */
     zrnsintokujyouhyouji                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）新特条表示 */
     zrntkjykbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特条区分 */
     zrnryoumasihyouten                                 DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）料増標点 */
     zrndai2tokujyoukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）第２特条区分 */
     zrndai2ryoumasihyouten                             DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）第２料増標点 */
     zrnytirrthndsysnmnskaisuu                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予定利率変動終身見直回数 */
     zrnkousinmanryouage                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）更新満了年令 */
     zrnsuuriyouyobin9                                  CHAR        (9)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ９ */
     zrnkrsgjhknsyukigousdkbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）繰下げ時保険種類記号世代区分 */
     zrnknkuzusnzyrt                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）健康増進乗率 */
     zrnzyrthntiyustatuskbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）乗率判定用ステータス区分 */
     zrnyobiv15                                         CHAR        (15)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１５ */
     zrnerrtokuteikoumoku                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）エラー特定項目 */
     zrnkihons                                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）基本Ｓ */
     zrnhenkougokihons                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更後基本Ｓ */
     zrnhenkougosibous                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変更後死亡Ｓ */
     zrngyousekihyoujis                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）業績表示Ｓ */
     zrngoukeitenkankakaku                              DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計転換価格 */
     zrnwnasigoukeitenkanteikis                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）Ｗなし合計転換定期Ｓ */
     zrnyobin11                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnkaiyakuhr                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）解約返戻金 */
     zrnryumsbbnkaiyakuhr                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）料増部分解約返戻金 */
     zrnyobin11x3                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿４ */
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外貨区分 */
     zrnkawaserate                                      DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）為替レート */
     zrnkawaseratetekiyouymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）為替レート適用年月日 */
     zrnsaisinyoteiriritu                               DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）最新予定利率 */
     zrnsrkaiyakusjkkktyouseirrt                        DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）数理用解約時市場価格調整用利率 */
     zrnsrkyksjkkktyouseiriritu                         DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）数理用契約時市場価格調整用利率 */
     zrnmvakeisankijyunymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）ＭＶＡ計算基準年月日 */
     zrnmvatyouseikou                                   DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）ＭＶＡ調整項 */
     zrnkeiyakujiyoteiriritu                            DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）契約時予定利率 */
     zrnsuuriyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０ */
     zrnsuuriyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿２ */
     zrnyobin11x5                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿５ */
     zrnyobin11x6                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿６ */
     zrnyobin11x7                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿７ */
     zrnyobin11x8                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿８ */
     zrnyobin11x9                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿９ */
     zrnyobiv12x2                                       CHAR        (12)                                                      NOT NULL     /* （連携用）予備項目Ｖ１２＿２ */
)
;

ALTER TABLE ZT_KaiykHrSoutougakuRn_Z ADD CONSTRAINT PK_KaiykHrSoutougakuRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;
