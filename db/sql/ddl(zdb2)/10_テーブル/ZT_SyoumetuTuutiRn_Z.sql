CREATE TABLE ZT_SyoumetuTuutiRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntantousitukbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）担当室区分 */
     zrnsksdoufuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）請求書同封区分 */
     zrnmynosinkokuiraidoufuukbn                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）マイナンバー申告依頼同封区分 */
     zrnsikibetuno                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）識別番号 */
     zrnyobiv14                                         CHAR        (14)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１４ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv44                                         CHAR        (44)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４４ */
     zrnansyuyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntoiawasekaisyanmkj                              GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）問合せ先会社名（漢字） */
     zrntawsosikikj                                     GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1x18keta                         GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１（１８桁） */
     zrntawteluktkkanou2x18keta                         GRAPHIC     (18)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２（１８桁） */
     zrnyobiv50                                         CHAR        (50)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ５０ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnaisatumongon50keta1                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）１ */
     zrnaisatumongon50keta2                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）２ */
     zrnaisatumongon50keta3                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）３ */
     zrnaisatumongon50keta4                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）４ */
     zrnaisatumongon50keta5                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）５ */
     zrnaisatumongon50keta6                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）挨拶文言（５０桁）６ */
     zrnyobiv120                                        CHAR        (120)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１２０ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnkyknmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnhhknnmkj                                        GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnkykymdseireki                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrnhknsyurui30keta                                 GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）保険種類（３０桁） */
     zrnsyoumetuymd                                     GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）消滅日 */
     zrnoharaimodosikn                                  CHAR        (13)                                                      NOT NULL  ,  /* （連携用）お払戻金 */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２０ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnshrymd11keta                                    GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）支払日（１１桁） */
     zrntekiyou1                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要１ */
     zrnshrkngkmeisaihugou1                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号１ */
     zrnshrgkmeisai1                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細１ */
     zrnshrgktuukasyu1                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類１ */
     zrnbikou1                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考１ */
     zrntekiyou2                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要２ */
     zrnshrkngkmeisaihugou2                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号２ */
     zrnshrgkmeisai2                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細２ */
     zrnshrgktuukasyu2                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類２ */
     zrnbikou2                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考２ */
     zrntekiyou3                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要３ */
     zrnshrkngkmeisaihugou3                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号３ */
     zrnshrgkmeisai3                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細３ */
     zrnshrgktuukasyu3                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類３ */
     zrnbikou3                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考３ */
     zrntekiyou4                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要４ */
     zrnshrkngkmeisaihugou4                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号４ */
     zrnshrgkmeisai4                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細４ */
     zrnshrgktuukasyu4                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類４ */
     zrnbikou4                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考４ */
     zrntekiyou5                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要５ */
     zrnshrkngkmeisaihugou5                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号５ */
     zrnshrgkmeisai5                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細５ */
     zrnshrgktuukasyu5                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類５ */
     zrnbikou5                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考５ */
     zrntekiyou6                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要６ */
     zrnshrkngkmeisaihugou6                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号６ */
     zrnshrgkmeisai6                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細６ */
     zrnshrgktuukasyu6                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類６ */
     zrnbikou6                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考６ */
     zrntekiyou7                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要７ */
     zrnshrkngkmeisaihugou7                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号７ */
     zrnshrgkmeisai7                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細７ */
     zrnshrgktuukasyu7                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類７ */
     zrnbikou7                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考７ */
     zrntekiyou8                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要８ */
     zrnshrkngkmeisaihugou8                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号８ */
     zrnshrgkmeisai8                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細８ */
     zrnshrgktuukasyu8                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類８ */
     zrnbikou8                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考８ */
     zrntekiyou9                                        GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要９ */
     zrnshrkngkmeisaihugou9                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号９ */
     zrnshrgkmeisai9                                    CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細９ */
     zrnshrgktuukasyu9                                  CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類９ */
     zrnbikou9                                          GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考９ */
     zrntekiyou10                                       GRAPHIC     (12)                                                      NOT NULL  ,  /* （連携用）摘要１０ */
     zrnshrkngkmeisaihugou10                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払金額明細符号１０ */
     zrnshrgkmeisai10                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払金額明細１０ */
     zrnshrgktuukasyu10                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払金額通貨種類１０ */
     zrnbikou10                                         GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）備考１０ */
     zrnshrgkgoukei                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）支払額合計 */
     zrnshrtuukasyu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支払通貨種類 */
     zrnyobiv215                                        CHAR        (215)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２１５ */
     zrnansyuyouyobin10x6                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrnshrnaiyouhskmongon1                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）支払内容補足文言１ */
     zrnshrnaiyouhskmongon2                             GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）支払内容補足文言２ */
     zrnyobiv40                                         CHAR        (40)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４０ */
     zrnansyuyouyobin10x7                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿７ */
     zrnbanknmkj                                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）銀行名（漢字） */
     zrnsitennmkj                                       GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）支店名（漢字） */
     zrnyokinkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預金種目区分 */
     zrnkouzano12keta                                   CHAR        (12)                                                      NOT NULL  ,  /* （連携用）口座番号（１２桁） */
     zrnkzmeiginmknhan                                  CHAR        (30)                                                      NOT NULL  ,  /* （連携用）口座名義人氏名（カナ）（半角） */
     zrnkzsyurui                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座種類 */
     zrnyobiv26x2                                       CHAR        (26)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２６＿２ */
     zrnansyuyouyobin10x8                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿８ */
     zrnsynykngk                                        CHAR        (10)                                                      NOT NULL  ,  /* （連携用）収入金額 */
     zrnsynykngktuukasyu                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）収入金額通貨種類 */
     zrnhtykeihi                                        CHAR        (10)                                                      NOT NULL  ,  /* （連携用）必要経費 */
     zrnhtykeihituukasyu                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）必要経費通貨種類 */
     zrnshrkyksyahtykeihi                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）お支払時の契約者の必要経費 */
     zrnshrkykhtykeihituukasyu                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）お支払時の契約者の必要経費通貨種類 */
     zrngsbnrkzthtykeihi                                CHAR        (10)                                                      NOT NULL  ,  /* （連携用）源泉分離課税対象の必要経費 */
     zrngsbnrkzthtykeihituksyu                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）源泉分離課税対象の必要経費通貨種類 */
     zrngsbnrkztsaeki                                   CHAR        (10)                                                      NOT NULL  ,  /* （連携用）源泉分離課税対象の差益 */
     zrngsbnrkztsaekituksyu                             CHAR        (3)                                                       NOT NULL  ,  /* （連携用）源泉分離課税対象の差益通貨種類 */
     zrnzeimunaiyouhensyuctrlkbn                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）税務内容編集制御区分 */
     zrnzeimumongonoutkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）税務文言出力区分 */
     zrnzeimumongon1                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）税務文言１ */
     zrnzeimumongon2                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）税務文言２ */
     zrnzeimumongon3                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）税務文言３ */
     zrnzeimumongon4                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）税務文言４ */
     zrnzeimumongon5                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）税務文言５ */
     zrnyendthnkzeimuinfohskkbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）円建変更時税務情報補足区分 */
     zrnyobiv74                                         CHAR        (74)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ７４ */
     zrnansyuyouyobin10x9                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿９ */
     zrnosirasehyoudai                                  GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）お知らせ表題 */
     zrnosirasemongon1                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１ */
     zrnosirasemongon2                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２ */
     zrnosirasemongon3                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３ */
     zrnosirasemongon4                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４ */
     zrnosirasemongon5                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言５ */
     zrnosirasemongon6                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言６ */
     zrnosirasemongon7                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言７ */
     zrnosirasemongon8                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言８ */
     zrnosirasemongon9                                  GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言９ */
     zrnosirasemongon10                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１０ */
     zrnosirasemongon11                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１１ */
     zrnosirasemongon12                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１２ */
     zrnosirasemongon13                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１３ */
     zrnosirasemongon14                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１４ */
     zrnosirasemongon15                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１５ */
     zrnosirasemongon16                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１６ */
     zrnosirasemongon17                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１７ */
     zrnosirasemongon18                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１８ */
     zrnosirasemongon19                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１９ */
     zrnosirasemongon20                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２０ */
     zrnosirasemongon21                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２１ */
     zrnosirasemongon22                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２２ */
     zrnosirasemongon23                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２３ */
     zrnosirasemongon24                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２４ */
     zrnosirasemongon25                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２５ */
     zrnosirasemongon26                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２６ */
     zrnosirasemongon27                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２７ */
     zrnosirasemongon28                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２８ */
     zrnosirasemongon29                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２９ */
     zrnosirasemongon30                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３０ */
     zrnosirasemongon31                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３１ */
     zrnosirasemongon32                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３２ */
     zrnosirasemongon33                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３３ */
     zrnosirasemongon34                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３４ */
     zrnosirasemongon35                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３５ */
     zrnosirasemongon36                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３６ */
     zrnosirasemongon37                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３７ */
     zrnosirasemongon38                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３８ */
     zrnosirasemongon39                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３９ */
     zrnosirasemongon40                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４０ */
     zrnosirasemongon41                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４１ */
     zrnosirasemongon42                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４２ */
     zrnosirasemongon43                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４３ */
     zrnosirasemongon44                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４４ */
     zrnosirasemongon45                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４５ */
     zrnosirasemongon46                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４６ */
     zrnosirasemongon47                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４７ */
     zrnosirasemongon48                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４８ */
     zrnosirasemongon49                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４９ */
     zrnosirasemongon50                                 GRAPHIC     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言５０ */
     zrnyobiv255                                        CHAR        (255)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５５ */
     zrnansyuyouyobin10x10                              CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿１０ */
     zrnteisyutusrmongon1                               GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）ご提出いただく書類文言１ */
     zrnteisyutusrmongon2                               GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）ご提出いただく書類文言２ */
     zrnteisyutusrmongon3                               GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）ご提出いただく書類文言３ */
     zrnmsgyobi1                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）メッセージ予備項目１ */
     zrnansyuyouyobin10x11                              CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿１１ */
     zrnseikyuusyasyomeimongon1                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言１ */
     zrnseikyuusyasyomeimongon2                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言２ */
     zrnseikyuusyasyomeimongon3                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言３ */
     zrnseikyuusyasyomeimongon4                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言４ */
     zrnseikyuusyasyomeimongon5                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言５ */
     zrnseikyuusyasyomeimongon6                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言６ */
     zrnseikyuusyasyomeimongon7                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言７ */
     zrnseikyuusyasyomeimongon8                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言８ */
     zrnseikyuusyasyomeimongon9                         GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者署名欄文言９ */
     zrnseikyuusyagenyno                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）請求者現住所郵便番号 */
     zrnseikyuusyagenadr1                               GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者現住所１（漢字） */
     zrnseikyuusyagenadr2                               GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者現住所２（漢字） */
     zrnseikyuusyagenadr3                               GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）請求者現住所３（漢字） */
     zrnseikyuuyagentelno                               CHAR        (14)                                                      NOT NULL  ,  /* （連携用）請求者現住所電話番号 */
     zrntoritugisyasyozokunm                            GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）取次者所属名 */
     zrntoritugisyakjncd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）取次者個人コード */
     zrntoritugisyanm                                   GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）取次者氏名 */
     zrnhozonkkny                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保存期間（年） */
     zrnyobiv168                                        CHAR        (168)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１６８ */
     zrnansyuyouyobin10x12                              CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿１２ */
     zrnteisyutusrmongon4                               GRAPHIC     (50)                                                      NOT NULL  ,  /* （連携用）ご提出いただく書類文言４ */
     zrnyobiv155                                        CHAR        (155)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１５５ */
     zrnyobiv97                                         CHAR        (97)                                                      NOT NULL     /* （連携用）予備項目Ｖ９７ */
)
;

ALTER TABLE ZT_SyoumetuTuutiRn_Z ADD CONSTRAINT PK_ZT_SyoumetuTuutiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnsikibetuno                                              /* （連携用）識別番号 */
) ;
