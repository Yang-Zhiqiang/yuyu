CREATE TABLE ZT_HnsyScrMeigiRn (
     zrnhnsyrecordkbn                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）反社レコ－ド区分 */
     zrnkijyunym                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）基準年月 */
     zrntaisyounmkn                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）対象者姓名（カナ） */
     zrntaisyounmkj                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）対象者姓名（漢字） */
     zrntaisyouseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）対象者生年月日 */
     zrntsnsknewyno                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）通信先新郵便番号 */
     zrntsnsknewtikucd                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通信先新地区コード */
     zrnhhknnewyno                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）被保険者新郵便番号 */
     zrnhhknnewtikucd                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者新地区コ－ド */
     zrnkstkannisknewyno                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）貸付案内先新郵便番号 */
     zrnkstkannisknewtikucd                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）貸付案内先新地区コ－ド */
     zrndntnewyno                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）団体新郵便番号 */
     zrndntnewtikucd                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）団体新地区コ－ド */
     zrnkanjitsinkaiadr                                 VARCHAR     (62)                                                      NOT NULL  ,  /* （連携用）漢字通信先下位住所 */
     zrntodouhukennm                                    CHAR        (10)                                                      NOT NULL  ,  /* （連携用）都道府県名 */
     zrnsigunnm                                         CHAR        (30)                                                      NOT NULL  ,  /* （連携用）市郡名 */
     zrnsosikicd1                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コ－ド１ */
     zrnsosikicd2                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コ－ド２ */
     zrnsosikicd3                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コ－ド３ */
     zrnsosikicd4                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コ－ド４ */
     zrnsosikicd5                                       CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コ－ド５ */
     zrnhhknhnsktodouhukencd                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者本籍都道府県コード */
     zrnkankeinmkn1                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）関係者名（カナ）１ */
     zrnkankeinmkn2                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）関係者名（カナ）２ */
     zrnkankeinmkn3                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）関係者名（カナ）３ */
     zrnkankeinmkn4                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）関係者名（カナ）４ */
     zrnkankeinmkn5                                     CHAR        (18)                                                      NOT NULL  ,  /* （連携用）関係者名（カナ）５ */
     zrnkankeinmkj1                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）関係者名（漢字）１ */
     zrnkankeinmkj2                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）関係者名（漢字）２ */
     zrnkankeinmkj3                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）関係者名（漢字）３ */
     zrnkankeinmkj4                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）関係者名（漢字）４ */
     zrnkankeinmkj5                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）関係者名（漢字）５ */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrndntcd                                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体コ－ド */
     zrndntnm                                           CHAR        (30)                                                      NOT NULL  ,  /* （連携用）団体名 */
     zrndntsyzkcd                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）団体所属コ－ド */
     zrndntkojincd                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）団体個人コ－ド */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrntsintelno                                       CHAR        (14)                                                      NOT NULL  ,  /* （連携用）通信先電話番号 */
     zrnhjncd                                           CHAR        (9)                                                       NOT NULL  ,  /* （連携用）法人コード */
     zrnhjnjigyosyocd                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）法人事業所コード */
     zrnsymtymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消滅年月日 */
     zrnsyokugyoucd                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コ－ド */
     zrndai2hhknyno                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）第２被保険者新郵便番号 */
     zrndai2hhknnewtikucd                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）第２被保険者新地区コ－ド */
     zrndai2hhkntodouhukencd                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第２被保険者本籍府県コ－ド */
     zrnsyokugyoucd2                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）第２職業コ－ド */
     zrnyobiv118                                        CHAR        (118)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１１８ */
     zrnskinnm                                          CHAR        (10)                                                      NOT NULL  ,  /* （連携用）索引姓名 */
     zrnyobiv40                                         CHAR        (40)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４０ */
     zrnnayosetaisyousegkbn                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）名寄せ対象者ＳＥＧ区分 */
     zrnnayosetaisyoukojinkbn                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）名寄せ対象者個人区分 */
     zrnyobiv46                                         CHAR        (46)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４６ */
     zrntodouhukencd1                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード１ */
     zrntodouhukencd2                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード２ */
     zrntodouhukencd3                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード３ */
     zrnyobiv34                                         CHAR        (34)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３４ */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnsyoumetucd                                      CHAR        (4)                                                       NOT NULL  ,  /* （連携用）消滅コード */
     zrnsymtymd2                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）消滅年月日＿２ */
     zrnbohaiyakkandisp                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）暴排条項導入約款適用表示 */
     zrnmeihenymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）名義変更年月日 */
     zrnseiymdseitsymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）生年月日性訂正年月日 */
     zrnkzkmrtityuutohukaymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）家族マル定中途付加年月日 */
     zrnkykmfkykknnm                                    CHAR        (41)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ契約者カナ姓名 */
     zrnkykmfkykkjnm                                    VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ契約者漢字姓名 */
     zrnkykmfkykseiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ契約者生年月日 */
     zrnkykmfhhkknnm                                    CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ被保険者カナ姓名 */
     zrnkykmfhhkkjnm                                    VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ被保険者漢字姓名 */
     zrnkykmfhhkseiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ被保険者生年月日 */
     zrnkykmfdai2knnm                                   CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ第２被カナ姓名 */
     zrnkykmfdai2kjnm                                   VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ第２被漢字姓名 */
     zrnkykmfdai2seiymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ第２被生年月日 */
     zrnkykmfsbuktknnm                                  CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ死亡受取人カナ姓名 */
     zrnkykmfsbuktkjnm                                  VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ死亡受取人漢字姓名 */
     zrnkykmfsbuktseiymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ死亡受取人生年月日 */
     zrnkykmfdai2ktknnm                                 CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ第２受取人カナ姓名 */
     zrnkykmfdai2ktkjnm                                 VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ第２受取人漢字姓名 */
     zrnkykmfdai2ktseiymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ第２受取人生年月日 */
     zrnkykmfmnkktknnm                                  CHAR        (18)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ満期受取人カナ姓名 */
     zrnkykmfmnkktkjnm                                  VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約ＭＦ満期受取人漢字姓名 */
     zrnkykmfmnkktseiymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ満期受取人生年月日 */
     zrndntcd2                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体コード２ */
     zrnkjdntnm                                         VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）漢字団体名 */
     zrnrinjikaisouhyouji                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）臨時回送表示 */
     zrnyobiv34x2                                       CHAR        (34)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３４＿２ */
     zrnsgtaisyoukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）照合対象区分 */
     zrnyobiv39                                         CHAR        (39)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３９ */
     zrnsyuuseihjnnm                                    CHAR        (25)                                                      NOT NULL  ,  /* （連携用）修正法人名 */
     zrnyobiv75                                         CHAR        (75)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ７５ */
     zrnsysyno                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証書番号 */
     zrnsueokikaisiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）据置開始年月日 */
     zrnhasseiriyuukbnscreen                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発生理由区分（反社スクリーニング） */
     zrnsueokijtkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）据置状態区分 */
     zrntaisyoufilekbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）対象ファイル区分 */
     zrnbohaiyakkandisp2                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）暴排条項導入約款適用表示２ */
     zrnmeihenymd2                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）名義変更年月日２ */
     zrnnksyoumetucd                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）年金消滅コード */
     zrnyobiv7                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ７ */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL     /* （連携用）予備項目Ｖ２０ */
)
;

ALTER TABLE ZT_HnsyScrMeigiRn ADD CONSTRAINT PK_HnsyScrMeigiRn PRIMARY KEY (
     zrntaisyounmkn                                           , /* （連携用）対象者姓名（カナ） */
     zrntaisyounmkj                                           , /* （連携用）対象者姓名（漢字） */
     zrntaisyouseiymd                                         , /* （連携用）対象者生年月日 */
     zrnnayosetaisyousegkbn                                   , /* （連携用）名寄せ対象者ＳＥＧ区分 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
