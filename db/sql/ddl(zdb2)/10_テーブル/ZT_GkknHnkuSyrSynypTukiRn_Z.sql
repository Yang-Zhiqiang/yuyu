CREATE TABLE ZT_GkknHnkuSyrSynypTukiRn_Z (
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnyuukourecordlength                              DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）有効レコード長 */
     zrnrdwarea                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）ＲＤＷ領域 */
     zrndatakanrino                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）データ管理番号 */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrnrendoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）連動区分 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnsyuunoukeirokbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）収納経路区分 */
     zrnsuitousisya                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）出納支社 */
     zrnsyuukinym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）集金年月 */
     zrnjyuutouym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）充当年月 */
     zrnjyuutoukaisuu                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）充当回数 */
     zrnzennoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納区分 */
     zrnsetkykkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）セット契約区分 */
     zrnbankikkatuhyouji                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）バンク一括表示 */
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrntnknmnosjtikbbnjyutukbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換見直時定期部分充当区分 */
     zrnsetrenseimrtikatakbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）セット連生マル定型区分 */
     zrnhaitoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）配当区分 */
     zrnsyukeiyakupwaribikikbnx2                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約Ｐ割引区分＿２ */
     zrnsykyktnknyugukbnx2                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約転換優遇区分＿２ */
     zrnsetkaigomaruteikatakbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）セット介護マル定型区分 */
     zrndenymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）伝票日付 */
     zrnsyonendosyokaip                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）初年度初回Ｐ */
     zrnsyonendo2kaimeikoup                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）初年度２回目以降Ｐ */
     zrnjinendoikoup                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）次年度以降Ｐ */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnhihokensyaagev2                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令Ｖ２ */
     zrnkyksyanen                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年令 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnsdpdkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｓ建Ｐ建区分 */
     zrnryouritukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）料率区分 */
     zrntksyuannaikykkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特殊案内契約区分 */
     zrndai2hhknnen                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第２被保険者年令 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnpmenhukakbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免付加区分 */
     zrnhosyouikkatumnoshyouji                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保障一括見直表示 */
     zrnyobiv1x2                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿２ */
     zrnkihons                                          DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）基本Ｓ */
     zrngoukeitenkans                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計転換Ｓ */
     zrnhngknksaiteihosyukngk                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）変額年金最低保証金額 */
     zrnaatukaisosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者組織コード */
     zrnaatukaikojincd                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ａ扱者個人コード */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnharaikomip                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）払込Ｐ */
     zrnsyukeiyakup                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）主契約Ｐ */
     zrntokujyoup                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）特条Ｐ */
     zrnitibuitijibarais                                DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一部一時払Ｓ */
     zrnitibuitijibaraip                                DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）一部一時払Ｐ */
     zrngoukeitenkanteikis                              DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）合計転換定期Ｓ */
     zrnsyuunoukbn                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）収納区分 */
     zrntkykkumkhnsyukosuu                              DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）特約項目編集個数 */
     zrnsiteizukipwarimasihyouji                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）指定月Ｐ割増表示 */
     zrnpwarimasisiteim1                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ割増指定月１ */
     zrnpwarimasisiteim2                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ割増指定月２ */
     zrnsiteimsykykpbairitu                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）指定月主契約Ｐ倍率 */
     zrnsiteizukisyukeiyakup                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）指定月主契約Ｐ */
     zrnsiteizukiharaikomip                             DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）指定月払込Ｐ */
     zrnsaisyuusiteimhrkp                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）最終指定月払込Ｐ */
     zrnsaisyuusiteiym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）最終指定年月 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrntumitateriritu                                  DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）積立利率 */
     zrnsitihsyuriritu                                  DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）最低保証利率 */
     zrnnkgnsritu                                       DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）年金原資率 */
     zrnsinnyuukinkbn                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）新入金区分 */
     zrndfnyuukinkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＦ入金区分 */
     zrntorikuzusip                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）取崩Ｐ */
     zrnkbnkeiriyousegmentcd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメントコード */
     zrnsykikykjkykym                                   CHAR        (6)                                                       NOT NULL  ,  /* （連携用）初回契約時契約年月 */
     zrndfkijyunkingaku                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）ＤＦ基準金額 */
     zrnstdssytikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出集定区分 */
     zrnsotodasimanagehyouji                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出満年令表示 */
     zrnsotodasiphkbnmnoshyouji                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出Ｐ不可分見直表示 */
     zrnstdsstkjytkyuhyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出新特条適用表示 */
     zrnkousinmanryouage                                CHAR        (2)                                                       NOT NULL  ,  /* （連携用）更新満了年令 */
     zrnknkuzusnzyrttekitkarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）健康増進乗率適用特約有表示 */
     zrnknkuzusnzyrt                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）健康増進乗率 */
     zrntenkanjiknkuzusnzyrt                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）転換時健康増進乗率 */
     zrnpwrbksidhitekiyouhyj                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険料割引制度非適用表示 */
     zrnsuuriyouyobin1x2                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１＿２ */
     zrnzyrthntiyustatuskbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）乗率判定用ステータス区分 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnsotodasipmenkbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外出Ｐ免区分 */
     zrntokubetuhosyoukikan                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）特別保障期間 */
     zrnsuuriyouyobin7                                  CHAR        (7)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ７ */
     zrnphireilkeisanyoup                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）Ｐ比例Ｌ計算用Ｐ */
     zrnyobin11                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿４ */
     zrncashlesshyj                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）キャッシュレス表示 */
     zrnkykjiqpackhyj                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約時Ｑパック表示 */
     zrntenkanminaosikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）転換見直区分 */
     zrnhhknnentysihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者年令調整表示 */
     zrndai2hhknnentysihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）第２被保険者年令調整表示 */
     zrnkyksyaagetyouseihyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者年令調整表示 */
     zrnsykykhokenhoutekiyouhyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）主契約保険法適用表示 */
     zrnhrimngtkykphrkkaisuukbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払満後特約Ｐ払込回数区分 */
     zrnjidoukousinhyouji                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）自動更新表示 */
     zrnsuuriyouyobin1                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１ */
     zrntkjykbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特条区分 */
     zrndai2tokujyoukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）第２特条区分 */
     zrnryoumasihyouten                                 DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）料増標点 */
     zrndai2ryoumasihyouten                             DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）第２料増標点 */
     zrnsuuriyouyobin2                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ２ */
     zrnsuuriyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０ */
     zrnsuuriyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿２ */
     zrnsuuriyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿３ */
     zrnsuuriyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿４ */
     zrnyobiv10x6                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿６ */
     zrnyobiv10x7                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿７ */
     zrnyobiv10x8                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿８ */
     zrnyobiv10x9                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿９ */
     zrnyobiv10x10                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿１０ */
     zrnyobiv10x11                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿１１ */
     zrnbosyuukeitaikbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）募集形態区分 */
     zrnhrimngtkykphrkkirkbn                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払満後特約Ｐ払込経路区分 */
     zrnhrimngtkykpryurtkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払満後特約Ｐ料率区分 */
     zrnsyukeiyakusyuruicdv3                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）主契約種類コードＶ３ */
     zrnyobin11x5                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿５ */
     zrnyobin11x6                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿６ */
     zrnyobin11x7                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿７ */
     zrnyobin11x8                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿８ */
     zrnyobin11x9                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿９ */
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外貨区分 */
     zrnkykjikawaserate                                 DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）契約時為替レート */
     zrnkykjikawaseratetkyuymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約時為替レート適用年月日 */
     zrnkeiyakujiyoteiriritu                            DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）契約時予定利率 */
     zrnenkdtsbujsitihsyukngk                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）円貨建死亡時最低保証金額 */
     zrnnyuukintuukakbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入金通貨区分 */
     zrnsisuurendourate                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）指数連動部分割合 */
     zrnsisuukbn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）指数区分 */
     zrnnyknjikawaserate                                DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）入金時為替レート */
     zrnnyknjikawaseratetkyuymd                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）入金時為替レート適用年月日 */
     zrnsuuriyouyobin12                                 CHAR        (12)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１２ */
     zrnyobiv10x15                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿１５ */
     zrnyobiv10x16                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿１６ */
     zrnnkgns                                           DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）年金原資 */
     zrnsisuubbntounyuugk                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）指数部分投入金額 */
     zrnsaisinyoteiriritu                               DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）最新予定利率 */
     zrnyobin5                                          DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｎ５ */
     zrnyobin11x10                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿１０ */
     zrnkiharaikomip                                    DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払込Ｐ */
     zrntumitatekin                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）積立金 */
     zrnzennoujiikkatubaraijytgk                        DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）前納時一括払充当額 */
     zrngaikadatenkgns                                  DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）外貨建年金原資 */
     zrngaikadatesyukeiyakup                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）外貨建主契約Ｐ */
     zrnyobiv1x3                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１＿３ */
     zrntokuyakukoumokuv160                             CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０ */
     zrntokuyakukoumokuv160x2                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２ */
     zrntokuyakukoumokuv160x3                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３ */
     zrntokuyakukoumokuv160x4                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４ */
     zrntokuyakukoumokuv160x5                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿５ */
     zrntokuyakukoumokuv160x6                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿６ */
     zrntokuyakukoumokuv160x7                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿７ */
     zrntokuyakukoumokuv160x8                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿８ */
     zrntokuyakukoumokuv160x9                           CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿９ */
     zrntokuyakukoumokuv160x10                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１０ */
     zrntokuyakukoumokuv160x11                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１１ */
     zrntokuyakukoumokuv160x12                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１２ */
     zrntokuyakukoumokuv160x13                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１３ */
     zrntokuyakukoumokuv160x14                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１４ */
     zrntokuyakukoumokuv160x15                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１５ */
     zrntokuyakukoumokuv160x16                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１６ */
     zrntokuyakukoumokuv160x17                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１７ */
     zrntokuyakukoumokuv160x18                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１８ */
     zrntokuyakukoumokuv160x19                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿１９ */
     zrntokuyakukoumokuv160x20                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２０ */
     zrntokuyakukoumokuv160x21                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２１ */
     zrntokuyakukoumokuv160x22                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２２ */
     zrntokuyakukoumokuv160x23                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２３ */
     zrntokuyakukoumokuv160x24                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２４ */
     zrntokuyakukoumokuv160x25                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２５ */
     zrntokuyakukoumokuv160x26                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２６ */
     zrntokuyakukoumokuv160x27                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２７ */
     zrntokuyakukoumokuv160x28                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２８ */
     zrntokuyakukoumokuv160x29                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿２９ */
     zrntokuyakukoumokuv160x30                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３０ */
     zrntokuyakukoumokuv160x31                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３１ */
     zrntokuyakukoumokuv160x32                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３２ */
     zrntokuyakukoumokuv160x33                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３３ */
     zrntokuyakukoumokuv160x34                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３４ */
     zrntokuyakukoumokuv160x35                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３５ */
     zrntokuyakukoumokuv160x36                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３６ */
     zrntokuyakukoumokuv160x37                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３７ */
     zrntokuyakukoumokuv160x38                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３８ */
     zrntokuyakukoumokuv160x39                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿３９ */
     zrntokuyakukoumokuv160x40                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４０ */
     zrntokuyakukoumokuv160x41                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４１ */
     zrntokuyakukoumokuv160x42                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４２ */
     zrntokuyakukoumokuv160x43                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４３ */
     zrntokuyakukoumokuv160x44                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４４ */
     zrntokuyakukoumokuv160x45                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４５ */
     zrntokuyakukoumokuv160x46                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４６ */
     zrntokuyakukoumokuv160x47                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４７ */
     zrntokuyakukoumokuv160x48                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４８ */
     zrntokuyakukoumokuv160x49                          CHAR        (160)                                                     NOT NULL  ,  /* （連携用）特約項目Ｖ１６０＿４９ */
     zrntokuyakukoumokuv160x50                          CHAR        (160)                                                     NOT NULL     /* （連携用）特約項目Ｖ１６０＿５０ */
)
;

ALTER TABLE ZT_GkknHnkuSyrSynypTukiRn_Z ADD CONSTRAINT PK_GkknHnkuSyrSynypTukiRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;
