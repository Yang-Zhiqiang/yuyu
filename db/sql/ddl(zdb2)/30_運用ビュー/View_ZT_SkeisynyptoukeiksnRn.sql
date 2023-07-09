CREATE VIEW ZT_SkeisynyptoukeiksnRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrndatakanrino ,         /* （連携用）データ管理番号 */
     zrnsyoricd ,         /* （連携用）処理コード */
     zrnrendoukbn ,         /* （連携用）連動区分 */
     zrnyobiv1 ,         /* （連携用）予備項目Ｖ１ */
     zrnsyuunoukeirokbn ,         /* （連携用）収納経路区分 */
     zrnsuitousisya ,         /* （連携用）出納支社 */
     zrnsyuukinym ,         /* （連携用）集金年月 */
     zrnjyuutouym ,         /* （連携用）充当年月 */
     zrnjyuutoukaisuu ,         /* （連携用）充当回数 */
     zrnzennoukbn ,         /* （連携用）前納区分 */
     zrnsetkykkbn ,         /* （連携用）セット契約区分 */
     zrnbankikkatuhyouji ,         /* （連携用）バンク一括表示 */
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrntnknmnosjtikbbnjyutukbn ,         /* （連携用）転換見直時定期部分充当区分 */
     zrnsetrenseimrtikatakbn ,         /* （連携用）セット連生マル定型区分 */
     zrnhaitoukbn ,         /* （連携用）配当区分 */
     zrnsyukeiyakupwaribikikbnx2 ,         /* （連携用）主契約Ｐ割引区分＿２ */
     zrnsykyktnknyugukbnx2 ,         /* （連携用）主契約転換優遇区分＿２ */
     zrnsetkaigomaruteikatakbn ,         /* （連携用）セット介護マル定型区分 */
     zrndenymd ,         /* （連携用）伝票日付 */
     zrnsyonendosyokaip ,         /* （連携用）初年度初回Ｐ */
     zrnsyonendo2kaimeikoup ,         /* （連携用）初年度２回目以降Ｐ */
     zrnjinendoikoup ,         /* （連携用）次年度以降Ｐ */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnsaimnkkykhyj ,         /* （連携用）才満期契約表示 */
     zrnhknkkn ,         /* （連携用）保険期間 */
     zrnphrkkikn ,         /* （連携用）Ｐ払込期間 */
     zrnhihokensyaagev2 ,         /* （連携用）被保険者年令Ｖ２ */
     zrnkyksyanen ,         /* （連携用）契約者年令 */
     zrnkykymd ,         /* （連携用）契約年月日 */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnsdpdkbn ,         /* （連携用）Ｓ建Ｐ建区分 */
     zrnryouritukbn ,         /* （連携用）料率区分 */
     zrntksyuannaikykkbn ,         /* （連携用）特殊案内契約区分 */
     zrndai2hhknnen ,         /* （連携用）第２被保険者年令 */
     zrnhknsyuruikigousedaikbn ,         /* （連携用）保険種類記号世代区分 */
     zrnpmenhukakbn ,         /* （連携用）Ｐ免付加区分 */
     zrnhosyouikkatumnoshyouji ,         /* （連携用）保障一括見直表示 */
     zrnyobiv1x2 ,         /* （連携用）予備項目Ｖ１＿２ */
     zrnkihons ,         /* （連携用）基本Ｓ */
     zrngoukeitenkans ,         /* （連携用）合計転換Ｓ */
     zrnhngknksaiteihosyukngk ,         /* （連携用）変額年金最低保証金額 */
     zrnaatukaisosikicd ,         /* （連携用）Ａ扱者組織コード */
     zrnaatukaikojincd ,         /* （連携用）Ａ扱者個人コード */
     zrnbsyym ,         /* （連携用）募集年月 */
     zrnharaikomip ,         /* （連携用）払込Ｐ */
     zrnsyukeiyakup ,         /* （連携用）主契約Ｐ */
     zrntokujyoup ,         /* （連携用）特条Ｐ */
     zrnitibuitijibarais ,         /* （連携用）一部一時払Ｓ */
     zrnitibuitijibaraip ,         /* （連携用）一部一時払Ｐ */
     zrngoukeitenkanteikis ,         /* （連携用）合計転換定期Ｓ */
     zrnsyuunoukbn ,         /* （連携用）収納区分 */
     zrntkykkumkhnsyukosuu ,         /* （連携用）特約項目編集個数 */
     zrnsiteizukipwarimasihyouji ,         /* （連携用）指定月Ｐ割増表示 */
     zrnpwarimasisiteim1 ,         /* （連携用）Ｐ割増指定月１ */
     zrnpwarimasisiteim2 ,         /* （連携用）Ｐ割増指定月２ */
     zrnsiteimsykykpbairitu ,         /* （連携用）指定月主契約Ｐ倍率 */
     zrnsiteizukisyukeiyakup ,         /* （連携用）指定月主契約Ｐ */
     zrnsiteizukiharaikomip ,         /* （連携用）指定月払込Ｐ */
     zrnsaisyuusiteimhrkp ,         /* （連携用）最終指定月払込Ｐ */
     zrnsaisyuusiteiym ,         /* （連携用）最終指定年月 */
     zrnanniskcd ,         /* （連携用）案内先コード */
     zrntumitateriritu ,         /* （連携用）積立利率 */
     zrnsitihsyuriritu ,         /* （連携用）最低保証利率 */
     zrnnkgnsritu ,         /* （連携用）年金原資率 */
     zrnsinnyuukinkbn ,         /* （連携用）新入金区分 */
     zrndfnyuukinkbn ,         /* （連携用）ＤＦ入金区分 */
     zrntorikuzusip ,         /* （連携用）取崩Ｐ */
     zrnkbnkeiriyousegmentcd ,         /* （連携用）区分経理用セグメントコード */
     zrnsykikykjkykym ,         /* （連携用）初回契約時契約年月 */
     zrndfkijyunkingaku ,         /* （連携用）ＤＦ基準金額 */
     zrnstdssytikbn ,         /* （連携用）外出集定区分 */
     zrnsotodasimanagehyouji ,         /* （連携用）外出満年令表示 */
     zrnsotodasiphkbnmnoshyouji ,         /* （連携用）外出Ｐ不可分見直表示 */
     zrnstdsstkjytkyuhyj ,         /* （連携用）外出新特条適用表示 */
     zrnkousinmanryouage ,         /* （連携用）更新満了年令 */
     zrnknkuzusnzyrttekitkarihyj ,         /* （連携用）健康増進乗率適用特約有表示 */
     zrnknkuzusnzyrt ,         /* （連携用）健康増進乗率 */
     zrntenkanjiknkuzusnzyrt ,         /* （連携用）転換時健康増進乗率 */
     zrnpwrbksidhitekiyouhyj ,         /* （連携用）保険料割引制度非適用表示 */
     zrnsuuriyouyobin1x2 ,         /* （連携用）数理用予備項目Ｎ１＿２ */
     zrnzyrthntiyustatuskbn ,         /* （連携用）乗率判定用ステータス区分 */
     zrnyobiv9 ,         /* （連携用）予備項目Ｖ９ */
     zrnsotodasipmenkbn ,         /* （連携用）外出Ｐ免区分 */
     zrntokubetuhosyoukikan ,         /* （連携用）特別保障期間 */
     zrnsuuriyouyobin7 ,         /* （連携用）数理用予備項目Ｎ７ */
     zrnphireilkeisanyoup ,         /* （連携用）Ｐ比例Ｌ計算用Ｐ */
     zrnyobin11 ,         /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2 ,         /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3 ,         /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4 ,         /* （連携用）予備項目Ｎ１１＿４ */
     zrncashlesshyj ,         /* （連携用）キャッシュレス表示 */
     zrnkykjiqpackhyj ,         /* （連携用）契約時Ｑパック表示 */
     zrntenkanminaosikbn ,         /* （連携用）転換見直区分 */
     zrnhhknnentysihyj ,         /* （連携用）被保険者年令調整表示 */
     zrndai2hhknnentysihyj ,         /* （連携用）第２被保険者年令調整表示 */
     zrnkyksyaagetyouseihyj ,         /* （連携用）契約者年令調整表示 */
     zrnsykykhokenhoutekiyouhyj ,         /* （連携用）主契約保険法適用表示 */
     zrnhrimngtkykphrkkaisuukbn ,         /* （連携用）払満後特約Ｐ払込回数区分 */
     zrnjidoukousinhyouji ,         /* （連携用）自動更新表示 */
     zrnsuuriyouyobin1 ,         /* （連携用）数理用予備項目Ｎ１ */
     zrntkjykbn ,         /* （連携用）特条区分 */
     zrndai2tokujyoukbn ,         /* （連携用）第２特条区分 */
     zrnryoumasihyouten ,         /* （連携用）料増標点 */
     zrndai2ryoumasihyouten ,         /* （連携用）第２料増標点 */
     zrnsuuriyouyobin2 ,         /* （連携用）数理用予備項目Ｎ２ */
     zrnsuuriyouyobin10 ,         /* （連携用）数理用予備項目Ｎ１０ */
     zrnsuuriyouyobin10x2 ,         /* （連携用）数理用予備項目Ｎ１０＿２ */
     zrnsuuriyouyobin10x3 ,         /* （連携用）数理用予備項目Ｎ１０＿３ */
     zrnsuuriyouyobin10x4 ,         /* （連携用）数理用予備項目Ｎ１０＿４ */
     zrnyobiv10x6 ,         /* （連携用）予備項目Ｖ１０＿６ */
     zrnyobiv10x7 ,         /* （連携用）予備項目Ｖ１０＿７ */
     zrnyobiv10x8 ,         /* （連携用）予備項目Ｖ１０＿８ */
     zrnyobiv10x9 ,         /* （連携用）予備項目Ｖ１０＿９ */
     zrnyobiv10x10 ,         /* （連携用）予備項目Ｖ１０＿１０ */
     zrnyobiv10x11 ,         /* （連携用）予備項目Ｖ１０＿１１ */
     zrnbosyuukeitaikbn ,         /* （連携用）募集形態区分 */
     zrnhrimngtkykphrkkirkbn ,         /* （連携用）払満後特約Ｐ払込経路区分 */
     zrnhrimngtkykpryurtkbn ,         /* （連携用）払満後特約Ｐ料率区分 */
     zrnsyukeiyakusyuruicdv3 ,         /* （連携用）主契約種類コードＶ３ */
     zrnyobin11x5 ,         /* （連携用）予備項目Ｎ１１＿５ */
     zrnyobin11x6 ,         /* （連携用）予備項目Ｎ１１＿６ */
     zrnyobin11x7 ,         /* （連携用）予備項目Ｎ１１＿７ */
     zrnyobin11x8 ,         /* （連携用）予備項目Ｎ１１＿８ */
     zrnyobin11x9 ,         /* （連携用）予備項目Ｎ１１＿９ */
     zrnraysystemhyj ,         /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn ,         /* （連携用）外貨区分 */
     zrnkykjikawaserate ,         /* （連携用）契約時為替レート */
     zrnkykjikawaseratetkyuymd ,         /* （連携用）契約時為替レート適用年月日 */
     zrnkeiyakujiyoteiriritu ,         /* （連携用）契約時予定利率 */
     zrnenkdtsbujsitihsyukngk ,         /* （連携用）円貨建死亡時最低保証金額 */
     zrnnyuukintuukakbn ,         /* （連携用）入金通貨区分 */
     zrnsisuurendourate ,         /* （連携用）指数連動部分割合 */
     zrnsisuukbn ,         /* （連携用）指数区分 */
     zrnnyknjikawaserate ,         /* （連携用）入金時為替レート */
     zrnnyknjikawaseratetkyuymd ,         /* （連携用）入金時為替レート適用年月日 */
     zrnsuuriyouyobin12 ,         /* （連携用）数理用予備項目Ｎ１２ */
     zrnyobiv10x15 ,         /* （連携用）予備項目Ｖ１０＿１５ */
     zrnyobiv10x16 ,         /* （連携用）予備項目Ｖ１０＿１６ */
     zrnnkgns ,         /* （連携用）年金原資 */
     zrnsisuubbntounyuugk ,         /* （連携用）指数部分投入金額 */
     zrnsaisinyoteiriritu ,         /* （連携用）最新予定利率 */
     zrnyobin5 ,         /* （連携用）予備項目Ｎ５ */
     zrnyobin11x10 ,         /* （連携用）予備項目Ｎ１１＿１０ */
     zrnkiharaikomip ,         /* （連携用）既払込Ｐ */
     zrntumitatekin ,         /* （連携用）積立金 */
     zrnzennoujiikkatubaraijytgk ,         /* （連携用）前納時一括払充当額 */
     zrngaikadatenkgns ,         /* （連携用）外貨建年金原資 */
     zrngaikadatesyukeiyakup ,         /* （連携用）外貨建主契約Ｐ */
     zrnyobiv1x3 ,         /* （連携用）予備項目Ｖ１＿３ */
     zrntokuyakukoumokuv160 ,         /* （連携用）特約項目Ｖ１６０ */
     zrntokuyakukoumokuv160x2 ,         /* （連携用）特約項目Ｖ１６０＿２ */
     zrntokuyakukoumokuv160x3 ,         /* （連携用）特約項目Ｖ１６０＿３ */
     zrntokuyakukoumokuv160x4 ,         /* （連携用）特約項目Ｖ１６０＿４ */
     zrntokuyakukoumokuv160x5 ,         /* （連携用）特約項目Ｖ１６０＿５ */
     zrntokuyakukoumokuv160x6 ,         /* （連携用）特約項目Ｖ１６０＿６ */
     zrntokuyakukoumokuv160x7 ,         /* （連携用）特約項目Ｖ１６０＿７ */
     zrntokuyakukoumokuv160x8 ,         /* （連携用）特約項目Ｖ１６０＿８ */
     zrntokuyakukoumokuv160x9 ,         /* （連携用）特約項目Ｖ１６０＿９ */
     zrntokuyakukoumokuv160x10 ,         /* （連携用）特約項目Ｖ１６０＿１０ */
     zrntokuyakukoumokuv160x11 ,         /* （連携用）特約項目Ｖ１６０＿１１ */
     zrntokuyakukoumokuv160x12 ,         /* （連携用）特約項目Ｖ１６０＿１２ */
     zrntokuyakukoumokuv160x13 ,         /* （連携用）特約項目Ｖ１６０＿１３ */
     zrntokuyakukoumokuv160x14 ,         /* （連携用）特約項目Ｖ１６０＿１４ */
     zrntokuyakukoumokuv160x15 ,         /* （連携用）特約項目Ｖ１６０＿１５ */
     zrntokuyakukoumokuv160x16 ,         /* （連携用）特約項目Ｖ１６０＿１６ */
     zrntokuyakukoumokuv160x17 ,         /* （連携用）特約項目Ｖ１６０＿１７ */
     zrntokuyakukoumokuv160x18 ,         /* （連携用）特約項目Ｖ１６０＿１８ */
     zrntokuyakukoumokuv160x19 ,         /* （連携用）特約項目Ｖ１６０＿１９ */
     zrntokuyakukoumokuv160x20 ,         /* （連携用）特約項目Ｖ１６０＿２０ */
     zrntokuyakukoumokuv160x21 ,         /* （連携用）特約項目Ｖ１６０＿２１ */
     zrntokuyakukoumokuv160x22 ,         /* （連携用）特約項目Ｖ１６０＿２２ */
     zrntokuyakukoumokuv160x23 ,         /* （連携用）特約項目Ｖ１６０＿２３ */
     zrntokuyakukoumokuv160x24 ,         /* （連携用）特約項目Ｖ１６０＿２４ */
     zrntokuyakukoumokuv160x25 ,         /* （連携用）特約項目Ｖ１６０＿２５ */
     zrntokuyakukoumokuv160x26 ,         /* （連携用）特約項目Ｖ１６０＿２６ */
     zrntokuyakukoumokuv160x27 ,         /* （連携用）特約項目Ｖ１６０＿２７ */
     zrntokuyakukoumokuv160x28 ,         /* （連携用）特約項目Ｖ１６０＿２８ */
     zrntokuyakukoumokuv160x29 ,         /* （連携用）特約項目Ｖ１６０＿２９ */
     zrntokuyakukoumokuv160x30 ,         /* （連携用）特約項目Ｖ１６０＿３０ */
     zrntokuyakukoumokuv160x31 ,         /* （連携用）特約項目Ｖ１６０＿３１ */
     zrntokuyakukoumokuv160x32 ,         /* （連携用）特約項目Ｖ１６０＿３２ */
     zrntokuyakukoumokuv160x33 ,         /* （連携用）特約項目Ｖ１６０＿３３ */
     zrntokuyakukoumokuv160x34 ,         /* （連携用）特約項目Ｖ１６０＿３４ */
     zrntokuyakukoumokuv160x35 ,         /* （連携用）特約項目Ｖ１６０＿３５ */
     zrntokuyakukoumokuv160x36 ,         /* （連携用）特約項目Ｖ１６０＿３６ */
     zrntokuyakukoumokuv160x37 ,         /* （連携用）特約項目Ｖ１６０＿３７ */
     zrntokuyakukoumokuv160x38 ,         /* （連携用）特約項目Ｖ１６０＿３８ */
     zrntokuyakukoumokuv160x39 ,         /* （連携用）特約項目Ｖ１６０＿３９ */
     zrntokuyakukoumokuv160x40 ,         /* （連携用）特約項目Ｖ１６０＿４０ */
     zrntokuyakukoumokuv160x41 ,         /* （連携用）特約項目Ｖ１６０＿４１ */
     zrntokuyakukoumokuv160x42 ,         /* （連携用）特約項目Ｖ１６０＿４２ */
     zrntokuyakukoumokuv160x43 ,         /* （連携用）特約項目Ｖ１６０＿４３ */
     zrntokuyakukoumokuv160x44 ,         /* （連携用）特約項目Ｖ１６０＿４４ */
     zrntokuyakukoumokuv160x45 ,         /* （連携用）特約項目Ｖ１６０＿４５ */
     zrntokuyakukoumokuv160x46 ,         /* （連携用）特約項目Ｖ１６０＿４６ */
     zrntokuyakukoumokuv160x47 ,         /* （連携用）特約項目Ｖ１６０＿４７ */
     zrntokuyakukoumokuv160x48 ,         /* （連携用）特約項目Ｖ１６０＿４８ */
     zrntokuyakukoumokuv160x49 ,         /* （連携用）特約項目Ｖ１６０＿４９ */
     zrntokuyakukoumokuv160x50           /* （連携用）特約項目Ｖ１６０＿５０ */
FROM ZT_SkeisynyptoukeiksnRn_Z;