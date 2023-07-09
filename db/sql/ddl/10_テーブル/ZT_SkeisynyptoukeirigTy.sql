CREATE TABLE ZT_SkeisynyptoukeirigTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztydatakanrino                                     VARCHAR     (11)                                                                ,  /* （中継用）データ管理番号 */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztyrendoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）連動区分 */
     ztyyobiv1                                          VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１ */
     ztysyuunoukeirokbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）収納経路区分 */
     ztysuitousisya                                     VARCHAR     (3)                                                                 ,  /* （中継用）出納支社 */
     ztysyuukinym                                       VARCHAR     (6)                                                                 ,  /* （中継用）集金年月 */
     ztyjyuutouym                                       VARCHAR     (6)                                                                 ,  /* （中継用）充当年月 */
     ztyjyuutoukaisuu                                   VARCHAR     (4)                                                                 ,  /* （中継用）充当回数 */
     ztyzennoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）前納区分 */
     ztysetkykkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）セット契約区分 */
     ztybankikkatuhyouji                                VARCHAR     (1)                                                                 ,  /* （中継用）バンク一括表示 */
     ztyrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）レコード区分 */
     ztytnknmnosjtikbbnjyutukbn                         VARCHAR     (1)                                                                 ,  /* （中継用）転換見直時定期部分充当区分 */
     ztysetrenseimrtikatakbn                            VARCHAR     (1)                                                                 ,  /* （中継用）セット連生マル定型区分 */
     ztyhaitoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）配当区分 */
     ztysyukeiyakupwaribikikbnx2                        VARCHAR     (1)                                                                 ,  /* （中継用）主契約Ｐ割引区分＿２ */
     ztysykyktnknyugukbnx2                              VARCHAR     (1)                                                                 ,  /* （中継用）主契約転換優遇区分＿２ */
     ztysetkaigomaruteikatakbn                          VARCHAR     (1)                                                                 ,  /* （中継用）セット介護マル定型区分 */
     ztydenymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）伝票日付 */
     ztysyonendosyokaip                                 NUMBER      (11)                                                                ,  /* （中継用）初年度初回Ｐ */
     ztysyonendo2kaimeikoup                             NUMBER      (11)                                                                ,  /* （中継用）初年度２回目以降Ｐ */
     ztyjinendoikoup                                    NUMBER      (11)                                                                ,  /* （中継用）次年度以降Ｐ */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztyhihokensyaagev2                                 VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令Ｖ２ */
     ztykyksyanen                                       VARCHAR     (2)                                                                 ,  /* （中継用）契約者年令 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztysdpdkbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）Ｓ建Ｐ建区分 */
     ztyryouritukbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）料率区分 */
     ztytksyuannaikykkbn                                VARCHAR     (1)                                                                 ,  /* （中継用）特殊案内契約区分 */
     ztydai2hhknnen                                     VARCHAR     (2)                                                                 ,  /* （中継用）第２被保険者年令 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztypmenhukakbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）Ｐ免付加区分 */
     ztyhosyouikkatumnoshyouji                          VARCHAR     (1)                                                                 ,  /* （中継用）保障一括見直表示 */
     ztyyobiv1x2                                        VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１＿２ */
     ztykihons                                          NUMBER      (11)                                                                ,  /* （中継用）基本Ｓ */
     ztygoukeitenkans                                   NUMBER      (11)                                                                ,  /* （中継用）合計転換Ｓ */
     ztyhngknksaiteihosyukngk                           NUMBER      (11)                                                                ,  /* （中継用）変額年金最低保証金額 */
     ztyaatukaisosikicd                                 VARCHAR     (7)                                                                 ,  /* （中継用）Ａ扱者組織コード */
     ztyaatukaikojincd                                  VARCHAR     (6)                                                                 ,  /* （中継用）Ａ扱者個人コード */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztyharaikomip                                      NUMBER      (11)                                                                ,  /* （中継用）払込Ｐ */
     ztysyukeiyakup                                     NUMBER      (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztytokujyoup                                       NUMBER      (11)                                                                ,  /* （中継用）特条Ｐ */
     ztyitibuitijibarais                                NUMBER      (11)                                                                ,  /* （中継用）一部一時払Ｓ */
     ztyitibuitijibaraip                                NUMBER      (11)                                                                ,  /* （中継用）一部一時払Ｐ */
     ztygoukeitenkanteikis                              NUMBER      (11)                                                                ,  /* （中継用）合計転換定期Ｓ */
     ztysyuunoukbn                                      VARCHAR     (3)                                                                 ,  /* （中継用）収納区分 */
     ztytkykkumkhnsyukosuu                              NUMBER      (3)                                                                 ,  /* （中継用）特約項目編集個数 */
     ztysiteizukipwarimasihyouji                        VARCHAR     (1)                                                                 ,  /* （中継用）指定月Ｐ割増表示 */
     ztypwarimasisiteim1                                VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ割増指定月１ */
     ztypwarimasisiteim2                                VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ割増指定月２ */
     ztysiteimsykykpbairitu                             VARCHAR     (2)                                                                 ,  /* （中継用）指定月主契約Ｐ倍率 */
     ztysiteizukisyukeiyakup                            NUMBER      (11)                                                                ,  /* （中継用）指定月主契約Ｐ */
     ztysiteizukiharaikomip                             NUMBER      (11)                                                                ,  /* （中継用）指定月払込Ｐ */
     ztysaisyuusiteimhrkp                               NUMBER      (11)                                                                ,  /* （中継用）最終指定月払込Ｐ */
     ztysaisyuusiteiym                                  VARCHAR     (6)                                                                 ,  /* （中継用）最終指定年月 */
     ztyanniskcd                                        VARCHAR     (8)                                                                 ,  /* （中継用）案内先コード */
     ztytumitateriritu                                  NUMBER      (5,4)                                                               ,  /* （中継用）積立利率 */
     ztysitihsyuriritu                                  NUMBER      (5,4)                                                               ,  /* （中継用）最低保証利率 */
     ztynkgnsritu                                       NUMBER      (9,6)                                                               ,  /* （中継用）年金原資率 */
     ztysinnyuukinkbn                                   VARCHAR     (2)                                                                 ,  /* （中継用）新入金区分 */
     ztydfnyuukinkbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＤＦ入金区分 */
     ztytorikuzusip                                     NUMBER      (11)                                                                ,  /* （中継用）取崩Ｐ */
     ztykbnkeiriyousegmentcd                            VARCHAR     (4)                                                                 ,  /* （中継用）区分経理用セグメントコード */
     ztysykikykjkykym                                   VARCHAR     (6)                                                                 ,  /* （中継用）初回契約時契約年月 */
     ztydfkijyunkingaku                                 NUMBER      (11)                                                                ,  /* （中継用）ＤＦ基準金額 */
     ztystdssytikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）外出集定区分 */
     ztysotodasimanagehyouji                            VARCHAR     (1)                                                                 ,  /* （中継用）外出満年令表示 */
     ztysotodasiphkbnmnoshyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）外出Ｐ不可分見直表示 */
     ztystdsstkjytkyuhyj                                VARCHAR     (1)                                                                 ,  /* （中継用）外出新特条適用表示 */
     ztykousinmanryouage                                VARCHAR     (2)                                                                 ,  /* （中継用）更新満了年令 */
     ztyknkuzusnzyrttekitkarihyj                        VARCHAR     (1)                                                                 ,  /* （中継用）健康増進乗率適用特約有表示 */
     ztyknkuzusnzyrt                                    VARCHAR     (3)                                                                 ,  /* （中継用）健康増進乗率 */
     ztytenkanjiknkuzusnzyrt                            VARCHAR     (3)                                                                 ,  /* （中継用）転換時健康増進乗率 */
     ztypwrbksidhitekiyouhyj                            VARCHAR     (1)                                                                 ,  /* （中継用）保険料割引制度非適用表示 */
     ztysuuriyouyobin1x2                                VARCHAR     (1)                                                                 ,  /* （中継用）数理用予備項目Ｎ１＿２ */
     ztyzyrthntiyustatuskbn                             VARCHAR     (1)                                                                 ,  /* （中継用）乗率判定用ステータス区分 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztysotodasipmenkbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）外出Ｐ免区分 */
     ztytokubetuhosyoukikan                             VARCHAR     (2)                                                                 ,  /* （中継用）特別保障期間 */
     ztysuuriyouyobin7                                  VARCHAR     (7)                                                                 ,  /* （中継用）数理用予備項目Ｎ７ */
     ztyphireilkeisanyoup                               NUMBER      (11)                                                                ,  /* （中継用）Ｐ比例Ｌ計算用Ｐ */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿４ */
     ztycashlesshyj                                     VARCHAR     (1)                                                                 ,  /* （中継用）キャッシュレス表示 */
     ztykykjiqpackhyj                                   VARCHAR     (1)                                                                 ,  /* （中継用）契約時Ｑパック表示 */
     ztytenkanminaosikbn                                VARCHAR     (1)                                                                 ,  /* （中継用）転換見直区分 */
     ztyhhknnentysihyj                                  VARCHAR     (1)                                                                 ,  /* （中継用）被保険者年令調整表示 */
     ztydai2hhknnentysihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）第２被保険者年令調整表示 */
     ztykyksyaagetyouseihyj                             VARCHAR     (1)                                                                 ,  /* （中継用）契約者年令調整表示 */
     ztysykykhokenhoutekiyouhyj                         VARCHAR     (1)                                                                 ,  /* （中継用）主契約保険法適用表示 */
     ztyhrimngtkykphrkkaisuukbn                         VARCHAR     (1)                                                                 ,  /* （中継用）払満後特約Ｐ払込回数区分 */
     ztyjidoukousinhyouji                               VARCHAR     (1)                                                                 ,  /* （中継用）自動更新表示 */
     ztysuuriyouyobin1                                  VARCHAR     (1)                                                                 ,  /* （中継用）数理用予備項目Ｎ１ */
     ztytkjykbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）特条区分 */
     ztydai2tokujyoukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）第２特条区分 */
     ztyryoumasihyouten                                 NUMBER      (5)                                                                 ,  /* （中継用）料増標点 */
     ztydai2ryoumasihyouten                             NUMBER      (5)                                                                 ,  /* （中継用）第２料増標点 */
     ztysuuriyouyobin2                                  VARCHAR     (2)                                                                 ,  /* （中継用）数理用予備項目Ｎ２ */
     ztysuuriyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０ */
     ztysuuriyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿２ */
     ztysuuriyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿３ */
     ztysuuriyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿４ */
     ztyyobiv10x6                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿６ */
     ztyyobiv10x7                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿７ */
     ztyyobiv10x8                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿８ */
     ztyyobiv10x9                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿９ */
     ztyyobiv10x10                                      VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿１０ */
     ztyyobiv10x11                                      VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿１１ */
     ztybosyuukeitaikbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）募集形態区分 */
     ztyhrimngtkykphrkkirkbn                            VARCHAR     (1)                                                                 ,  /* （中継用）払満後特約Ｐ払込経路区分 */
     ztyhrimngtkykpryurtkbn                             VARCHAR     (1)                                                                 ,  /* （中継用）払満後特約Ｐ料率区分 */
     ztysyukeiyakusyuruicdv3                            VARCHAR     (3)                                                                 ,  /* （中継用）主契約種類コードＶ３ */
     ztyyobin11x5                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿５ */
     ztyyobin11x6                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿６ */
     ztyyobin11x7                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿７ */
     ztyyobin11x8                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿８ */
     ztyyobin11x9                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿９ */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztygaikakbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）外貨区分 */
     ztykykjikawaserate                                 NUMBER      (9,6)                                                               ,  /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd                          VARCHAR     (8)                                                                 ,  /* （中継用）契約時為替レート適用年月日 */
     ztykeiyakujiyoteiriritu                            NUMBER      (5,4)                                                               ,  /* （中継用）契約時予定利率 */
     ztyenkdtsbujsitihsyukngk                           NUMBER      (11)                                                                ,  /* （中継用）円貨建死亡時最低保証金額 */
     ztynyuukintuukakbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）入金通貨区分 */
     ztysisuurendourate                                 VARCHAR     (3)                                                                 ,  /* （中継用）指数連動部分割合 */
     ztysisuukbn                                        VARCHAR     (2)                                                                 ,  /* （中継用）指数区分 */
     ztynyknjikawaserate                                NUMBER      (9,6)                                                               ,  /* （中継用）入金時為替レート */
     ztynyknjikawaseratetkyuymd                         VARCHAR     (8)                                                                 ,  /* （中継用）入金時為替レート適用年月日 */
     ztysuuriyouyobin12                                 VARCHAR     (12)                                                                ,  /* （中継用）数理用予備項目Ｎ１２ */
     ztyyobiv10x15                                      VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿１５ */
     ztyyobiv10x16                                      VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿１６ */
     ztynkgns                                           NUMBER      (11)                                                                ,  /* （中継用）年金原資 */
     ztysisuubbntounyuugk                               NUMBER      (11)                                                                ,  /* （中継用）指数部分投入金額 */
     ztysaisinyoteiriritu                               NUMBER      (5,4)                                                               ,  /* （中継用）最新予定利率 */
     ztyyobin5                                          NUMBER      (5)                                                                 ,  /* （中継用）予備項目Ｎ５ */
     ztyyobin11x10                                      NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿１０ */
     ztykiharaikomip                                    NUMBER      (11)                                                                ,  /* （中継用）既払込Ｐ */
     ztytumitatekin                                     NUMBER      (11)                                                                ,  /* （中継用）積立金 */
     ztyzennoujiikkatubaraijytgk                        NUMBER      (11)                                                                ,  /* （中継用）前納時一括払充当額 */
     ztygaikadatenkgns                                  NUMBER      (11)                                                                ,  /* （中継用）外貨建年金原資 */
     ztygaikadatesyukeiyakup                            NUMBER      (11)                                                                ,  /* （中継用）外貨建主契約Ｐ */
     ztyyobiv1x3                                        VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１＿３ */
     ztytokuyakukoumokuv160                             VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０ */
     ztytokuyakukoumokuv160x2                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２ */
     ztytokuyakukoumokuv160x3                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３ */
     ztytokuyakukoumokuv160x4                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４ */
     ztytokuyakukoumokuv160x5                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿５ */
     ztytokuyakukoumokuv160x6                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿６ */
     ztytokuyakukoumokuv160x7                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿７ */
     ztytokuyakukoumokuv160x8                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿８ */
     ztytokuyakukoumokuv160x9                           VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿９ */
     ztytokuyakukoumokuv160x10                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１０ */
     ztytokuyakukoumokuv160x11                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１１ */
     ztytokuyakukoumokuv160x12                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１２ */
     ztytokuyakukoumokuv160x13                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１３ */
     ztytokuyakukoumokuv160x14                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１４ */
     ztytokuyakukoumokuv160x15                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１５ */
     ztytokuyakukoumokuv160x16                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１６ */
     ztytokuyakukoumokuv160x17                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１７ */
     ztytokuyakukoumokuv160x18                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１８ */
     ztytokuyakukoumokuv160x19                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿１９ */
     ztytokuyakukoumokuv160x20                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２０ */
     ztytokuyakukoumokuv160x21                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２１ */
     ztytokuyakukoumokuv160x22                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２２ */
     ztytokuyakukoumokuv160x23                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２３ */
     ztytokuyakukoumokuv160x24                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２４ */
     ztytokuyakukoumokuv160x25                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２５ */
     ztytokuyakukoumokuv160x26                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２６ */
     ztytokuyakukoumokuv160x27                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２７ */
     ztytokuyakukoumokuv160x28                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２８ */
     ztytokuyakukoumokuv160x29                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿２９ */
     ztytokuyakukoumokuv160x30                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３０ */
     ztytokuyakukoumokuv160x31                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３１ */
     ztytokuyakukoumokuv160x32                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３２ */
     ztytokuyakukoumokuv160x33                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３３ */
     ztytokuyakukoumokuv160x34                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３４ */
     ztytokuyakukoumokuv160x35                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３５ */
     ztytokuyakukoumokuv160x36                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３６ */
     ztytokuyakukoumokuv160x37                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３７ */
     ztytokuyakukoumokuv160x38                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３８ */
     ztytokuyakukoumokuv160x39                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿３９ */
     ztytokuyakukoumokuv160x40                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４０ */
     ztytokuyakukoumokuv160x41                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４１ */
     ztytokuyakukoumokuv160x42                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４２ */
     ztytokuyakukoumokuv160x43                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４３ */
     ztytokuyakukoumokuv160x44                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４４ */
     ztytokuyakukoumokuv160x45                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４５ */
     ztytokuyakukoumokuv160x46                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４６ */
     ztytokuyakukoumokuv160x47                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４７ */
     ztytokuyakukoumokuv160x48                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４８ */
     ztytokuyakukoumokuv160x49                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿４９ */
     ztytokuyakukoumokuv160x50                          VARCHAR     (160)                                                               ,  /* （中継用）特約項目Ｖ１６０＿５０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SkeisynyptoukeirigTy ADD CONSTRAINT PK_SkeisynyptoukeirigTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
