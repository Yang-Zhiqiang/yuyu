CREATE TABLE ZT_RisaTjHitNminusZeroTy_Z (
     ztysequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              DECIMAL     (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztydatakanrino                                     VARCHAR     (11)                                                                ,  /* （中継用）データ管理番号 */
     ztyerrkbnv1                                        VARCHAR     (1)                                                                 ,  /* （中継用）エラー区分Ｖ１ */
     ztyratekbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）レート区分 */
     ztysuurisyuruicd                                   VARCHAR     (2)                                                                 ,  /* （中継用）数理種類コード */
     ztyyobiv2                                          VARCHAR     (2)                                                                 ,  /* （中継用）予備項目Ｖ２ */
     ztykbnkeiriyousegmentkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用セグメント区分 */
     ztykbnkeiriyourgnbnskkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用利源分析区分 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
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
     ztyharaikatakbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）払方区分 */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztykeiyakum                                        VARCHAR     (2)                                                                 ,  /* （中継用）契約月 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhihokensyaagev2                                 VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令Ｖ２ */
     zty5nenmeoutoubikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）５年目応当日区分 */
     ztykeijyouym                                       VARCHAR     (6)                                                                 ,  /* （中継用）計上年月 */
     ztykeiyakuoutoubikbn                               VARCHAR     (1)                                                                 ,  /* （中継用）契約応当日区分 */
     ztysuuriyouyobin1                                  VARCHAR     (1)                                                                 ,  /* （中継用）数理用予備項目Ｎ１ */
     ztysuuriyouyobin11                                 VARCHAR     (11)                                                                ,  /* （中継用）数理用予備項目Ｎ１１ */
     ztysaisitutokuyakuhukasuu                          DECIMAL     (3)                                                                 ,  /* （中継用）災疾特約付加数 */
     ztykihons                                          DECIMAL     (11)                                                                ,  /* （中継用）基本Ｓ */
     ztysibous                                          DECIMAL     (11)                                                                ,  /* （中継用）死亡Ｓ */
     ztytounendmtwrhrgkruikeigk                         DECIMAL     (11)                                                                ,  /* （中継用）当年度末割振額累計額 */
     ztywarihurigakurisoku1                             DECIMAL     (11)                                                                ,  /* （中継用）割振額利息１ */
     ztywarihurigakurisoku2                             DECIMAL     (11)                                                                ,  /* （中継用）割振額利息２ */
     ztyyokunendosyoyougakuyou                          DECIMAL     (11)                                                                ,  /* （中継用）翌年度所要額用 */
     ztyyokuyokunendosyoyougkyou                        DECIMAL     (11)                                                                ,  /* （中継用）翌々年度所要額用 */
     ztyyuukoutyuusyoyougaku                            DECIMAL     (11)                                                                ,  /* （中継用）有効中所要額 */
     ztysyoumetuyousyoyougaku1                          DECIMAL     (11)                                                                ,  /* （中継用）消滅用所要額１ */
     ztysyoumetuyousyoyougaku2                          DECIMAL     (11)                                                                ,  /* （中継用）消滅用所要額２ */
     ztytenkanyousyoyougaku1                            DECIMAL     (11)                                                                ,  /* （中継用）転換用所要額１ */
     ztytenkanyousyoyougaku2                            DECIMAL     (11)                                                                ,  /* （中継用）転換用所要額２ */
     ztytnknyutuujyoudsyoyougk1                         DECIMAL     (11)                                                                ,  /* （中継用）転換用通常Ｄ所要額１ */
     ztytnknyutuujyoudsyoyougk2                         DECIMAL     (11)                                                                ,  /* （中継用）転換用通常Ｄ所要額２ */
     ztytnknyuhrkbbnksyoyougk1                          DECIMAL     (11)                                                                ,  /* （中継用）転換用払込部分Ｋ所要額１ */
     ztytnknyuhrkbbnksyoyougk2                          DECIMAL     (11)                                                                ,  /* （中継用）転換用払込部分Ｋ所要額２ */
     ztytnknyuhrkbbnknnknsnp1                           DECIMAL     (11)                                                                ,  /* （中継用）転換用払込部分Ｋ年換算Ｐ１ */
     ztytnknyuhrkbbnknnknsnp2                           DECIMAL     (11)                                                                ,  /* （中継用）転換用払込部分Ｋ年換算Ｐ２ */
     ztytnknyutnknhktgksyoyougk1                        DECIMAL     (11)                                                                ,  /* （中継用）転換用転換引継Ｋ所要額１ */
     ztytnknyutnknhktgksyoyougk2                        DECIMAL     (11)                                                                ,  /* （中継用）転換用転換引継Ｋ所要額２ */
     ztytnknyutnknhktgknnknsnp1                         DECIMAL     (11)                                                                ,  /* （中継用）転換用転換引継Ｋ年換算Ｐ１ */
     ztytnknyutnknhktgknnknsnp2                         DECIMAL     (11)                                                                ,  /* （中継用）転換用転換引継Ｋ年換算Ｐ２ */
     ztytnknyusaisituksyoyougk1                         DECIMAL     (11)                                                                ,  /* （中継用）転換用災疾Ｋ所要額１ */
     ztytnknyusaisituksyoyougk2                         DECIMAL     (11)                                                                ,  /* （中継用）転換用災疾Ｋ所要額２ */
     ztytnknyusaisitukkyhntgk1                          DECIMAL     (11)                                                                ,  /* （中継用）転換用災疾Ｋ給付日額１ */
     ztytnknyusaisitukkyhntgk2                          DECIMAL     (11)                                                                ,  /* （中継用）転換用災疾Ｋ給付日額２ */
     ztyhrkbbnkdsyoyougk                                DECIMAL     (11)                                                                ,  /* （中継用）払込部分ＫＤ所要額 */
     ztyhrkbbnkdtisyunnknsnp                            DECIMAL     (11)                                                                ,  /* （中継用）払込部分ＫＤ対象年換算Ｐ */
     ztytusangohrkbbnkappad                             DECIMAL     (11)                                                                ,  /* （中継用）通算後払込部分カッパーＤ */
     ztytnknhktgkdsyoyougk                              DECIMAL     (11)                                                                ,  /* （中継用）転換引継ＫＤ所要額 */
     ztytnknhktgkdtisyunenknsnp                         DECIMAL     (11)                                                                ,  /* （中継用）転換引継ＫＤ対象年換算Ｐ */
     ztytusangotnknhktgkappad                           DECIMAL     (11)                                                                ,  /* （中継用）通算後転換引継カッパーＤ */
     ztytuusangohutuusiboukappad                        DECIMAL     (11)                                                                ,  /* （中継用）通算後普通死亡カッパーＤ */
     ztysaisitukappadsyoyougaku                         DECIMAL     (11)                                                                ,  /* （中継用）災疾カッパーＤ所要額 */
     ztytuusangosaisitukappad                           DECIMAL     (11)                                                                ,  /* （中継用）通算後災疾カッパーＤ */
     ztysistkappadtisyukyhntgk                          DECIMAL     (11)                                                                ,  /* （中継用）災疾カッパーＤ対象給付日額 */
     ztytuusangogoukeikappad                            DECIMAL     (11)                                                                ,  /* （中継用）通算後合計カッパーＤ */
     ztydtaisyouv                                       DECIMAL     (11)                                                                ,  /* （中継用）Ｄ対象Ｖ */
     ztyyobin11                                         DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztydaihyouyoteiriritu                              DECIMAL     (5,4)                                                               ,  /* （中継用）代表予定利率 */
     ztyknkuzusnzyrt                                    VARCHAR     (3)                                                                 ,  /* （中継用）健康増進乗率 */
     ztyzyrthntiyustatuskbn                             VARCHAR     (1)                                                                 ,  /* （中継用）乗率判定用ステータス区分 */
     ztyyobiv7                                          VARCHAR     (7)                                                                 ,  /* （中継用）予備項目Ｖ７ */
     ztytnknyusyusistksyoyougk1                         DECIMAL     (11)                                                                ,  /* （中継用）転換用主契約災疾Ｋ所要額１ */
     ztytnknyusyusistksyoyougk2                         DECIMAL     (11)                                                                ,  /* （中継用）転換用主契約災疾Ｋ所要額２ */
     ztytnknyusyusistkkyhntgk1                          DECIMAL     (11)                                                                ,  /* （中継用）転換用主契約災疾Ｋ給付日額１ */
     ztytnknyusyusistkkyhntgk2                          DECIMAL     (11)                                                                ,  /* （中継用）転換用主契約災疾Ｋ給付日額２ */
     ztysyusistkappadsyoyougk                           DECIMAL     (11)                                                                ,  /* （中継用）主契約災疾カッパーＤ所要額 */
     ztysyusistkdtisyukyhntgk                           DECIMAL     (11)                                                                ,  /* （中継用）主契約災疾ＫＤ対象給付日額 */
     ztyyobin11x8                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿８ */
     ztyyobin11x9                                       DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿９ */
     ztyyobin11x10                                      DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿１０ */
     ztyyobin11x11                                      DECIMAL     (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿１１ */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztygaikakbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）外貨区分 */
     ztykawaserate                                      DECIMAL     (9,6)                                                               ,  /* （中継用）為替レート */
     ztykawaseratetekiyouymd                            VARCHAR     (8)                                                                 ,  /* （中継用）為替レート適用年月日 */
     ztykeiyakujiyoteiriritu                            DECIMAL     (5,4)                                                               ,  /* （中継用）契約時予定利率 */
     ztyenkdtsbujsitihsyukngk                           DECIMAL     (11)                                                                ,  /* （中継用）円貨建死亡時最低保証金額 */
     ztytumitatekin                                     DECIMAL     (11)                                                                ,  /* （中継用）積立金 */
     ztykiharaikomip                                    DECIMAL     (11)                                                                ,  /* （中継用）既払込Ｐ */
     ztygaikadatesyukeiyakup                            DECIMAL     (11)                                                                ,  /* （中継用）外貨建主契約Ｐ */
     ztyyobiv2x2                                        VARCHAR     (2)                                                                 ,  /* （中継用）予備項目Ｖ２＿２ */
     ztynksjitirttumitatekin                            DECIMAL     (11)                                                                ,  /* （中継用）年金開始時定率部分積立金 */
     ztysisuurentumitatekin                             DECIMAL     (11)                                                                ,  /* （中継用）指数連動部分積立金 */
     ztysyukeiyakup                                     DECIMAL     (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztyyoteiririturironbase                            DECIMAL     (5,4)                                                               ,  /* （中継用）予定利率（理論ベース） */
     ztygkdtyknndsyoyougakuyou                          DECIMAL     (11)                                                                ,  /* （中継用）外貨建翌年度所要額用 */
     ztygkdtykyknndsyoyougakuyou                        DECIMAL     (11)                                                                ,  /* （中継用）外貨建翌々年度所要額用 */
     ztydkeisanjikwsrate                                DECIMAL     (9,6)                                                               ,  /* （中継用）Ｄ計算時為替レート */
     ztydkeisanjikwsratetkyymd                          VARCHAR     (8)                                                                 ,  /* （中継用）Ｄ計算時為替レート適用年月日 */
     ztyyobiv6                                          VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６ */
     ztyyobiv6x2                                        VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６＿２ */
     ztyyobiv6x3                                        VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６＿３ */
     ztyyobiv7x2                                        VARCHAR     (7)                                                                 ,  /* （中継用）予備項目Ｖ７＿２ */
     ztytokuyakukoumokuv120                             VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０ */
     ztytokuyakukoumokuv120x2                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２ */
     ztytokuyakukoumokuv120x3                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３ */
     ztytokuyakukoumokuv120x4                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿４ */
     ztytokuyakukoumokuv120x5                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿５ */
     ztytokuyakukoumokuv120x6                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿６ */
     ztytokuyakukoumokuv120x7                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿７ */
     ztytokuyakukoumokuv120x8                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿８ */
     ztytokuyakukoumokuv120x9                           VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿９ */
     ztytokuyakukoumokuv120x10                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１０ */
     ztytokuyakukoumokuv120x11                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１１ */
     ztytokuyakukoumokuv120x12                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１２ */
     ztytokuyakukoumokuv120x13                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１３ */
     ztytokuyakukoumokuv120x14                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１４ */
     ztytokuyakukoumokuv120x15                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１５ */
     ztytokuyakukoumokuv120x16                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１６ */
     ztytokuyakukoumokuv120x17                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１７ */
     ztytokuyakukoumokuv120x18                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１８ */
     ztytokuyakukoumokuv120x19                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿１９ */
     ztytokuyakukoumokuv120x20                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２０ */
     ztytokuyakukoumokuv120x21                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２１ */
     ztytokuyakukoumokuv120x22                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２２ */
     ztytokuyakukoumokuv120x23                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２３ */
     ztytokuyakukoumokuv120x24                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２４ */
     ztytokuyakukoumokuv120x25                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２５ */
     ztytokuyakukoumokuv120x26                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２６ */
     ztytokuyakukoumokuv120x27                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２７ */
     ztytokuyakukoumokuv120x28                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２８ */
     ztytokuyakukoumokuv120x29                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿２９ */
     ztytokuyakukoumokuv120x30                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３０ */
     ztytokuyakukoumokuv120x31                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３１ */
     ztytokuyakukoumokuv120x32                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３２ */
     ztytokuyakukoumokuv120x33                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３３ */
     ztytokuyakukoumokuv120x34                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３４ */
     ztytokuyakukoumokuv120x35                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３５ */
     ztytokuyakukoumokuv120x36                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３６ */
     ztytokuyakukoumokuv120x37                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３７ */
     ztytokuyakukoumokuv120x38                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３８ */
     ztytokuyakukoumokuv120x39                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿３９ */
     ztytokuyakukoumokuv120x40                          VARCHAR     (120)                                                               ,  /* （中継用）特約項目Ｖ１２０＿４０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_RisaTjHitNminusZeroTy_Z ADD CONSTRAINT PK_RisaTjHitNminusZeroTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
