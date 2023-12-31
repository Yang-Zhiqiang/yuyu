CREATE VIEW ZT_SkeisynyptoukeiksnTy AS SELECT
     ztysequenceno ,         /* （中継用）シーケンス番号 */
     ztyyuukourecordlength ,         /* （中継用）有効レコード長 */
     ztyrdwarea ,         /* （中継用）ＲＤＷ領域 */
     ztydatakanrino ,         /* （中継用）データ管理番号 */
     ztysyoricd ,         /* （中継用）処理コード */
     ztyrendoukbn ,         /* （中継用）連動区分 */
     ztyyobiv1 ,         /* （中継用）予備項目Ｖ１ */
     ztysyuunoukeirokbn ,         /* （中継用）収納経路区分 */
     ztysuitousisya ,         /* （中継用）出納支社 */
     ztysyuukinym ,         /* （中継用）集金年月 */
     ztyjyuutouym ,         /* （中継用）充当年月 */
     ztyjyuutoukaisuu ,         /* （中継用）充当回数 */
     ztyzennoukbn ,         /* （中継用）前納区分 */
     ztysetkykkbn ,         /* （中継用）セット契約区分 */
     ztybankikkatuhyouji ,         /* （中継用）バンク一括表示 */
     ztyrecordkbn ,         /* （中継用）レコード区分 */
     ztytnknmnosjtikbbnjyutukbn ,         /* （中継用）転換見直時定期部分充当区分 */
     ztysetrenseimrtikatakbn ,         /* （中継用）セット連生マル定型区分 */
     ztyhaitoukbn ,         /* （中継用）配当区分 */
     ztysyukeiyakupwaribikikbnx2 ,         /* （中継用）主契約Ｐ割引区分＿２ */
     ztysykyktnknyugukbnx2 ,         /* （中継用）主契約転換優遇区分＿２ */
     ztysetkaigomaruteikatakbn ,         /* （中継用）セット介護マル定型区分 */
     ztydenymd ,         /* （中継用）伝票日付 */
     ztysyonendosyokaip ,         /* （中継用）初年度初回Ｐ */
     ztysyonendo2kaimeikoup ,         /* （中継用）初年度２回目以降Ｐ */
     ztyjinendoikoup ,         /* （中継用）次年度以降Ｐ */
     ztyhknsyukigou ,         /* （中継用）保険種類記号 */
     ztysaimnkkykhyj ,         /* （中継用）才満期契約表示 */
     ztyhknkkn ,         /* （中継用）保険期間 */
     ztyphrkkikn ,         /* （中継用）Ｐ払込期間 */
     ztyhihokensyaagev2 ,         /* （中継用）被保険者年令Ｖ２ */
     ztykyksyanen ,         /* （中継用）契約者年令 */
     ztykykymd ,         /* （中継用）契約年月日 */
     ztyhhknseikbn ,         /* （中継用）被保険者性別区分 */
     ztyannaifuyouriyuukbn ,         /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn ,         /* （中継用）払込回数区分 */
     ztysdpdkbn ,         /* （中継用）Ｓ建Ｐ建区分 */
     ztyryouritukbn ,         /* （中継用）料率区分 */
     ztytksyuannaikykkbn ,         /* （中継用）特殊案内契約区分 */
     ztydai2hhknnen ,         /* （中継用）第２被保険者年令 */
     ztyhknsyuruikigousedaikbn ,         /* （中継用）保険種類記号世代区分 */
     ztypmenhukakbn ,         /* （中継用）Ｐ免付加区分 */
     ztyhosyouikkatumnoshyouji ,         /* （中継用）保障一括見直表示 */
     ztyyobiv1x2 ,         /* （中継用）予備項目Ｖ１＿２ */
     ztykihons ,         /* （中継用）基本Ｓ */
     ztygoukeitenkans ,         /* （中継用）合計転換Ｓ */
     ztyhngknksaiteihosyukngk ,         /* （中継用）変額年金最低保証金額 */
     ztyaatukaisosikicd ,         /* （中継用）Ａ扱者組織コード */
     ztyaatukaikojincd ,         /* （中継用）Ａ扱者個人コード */
     ztybsyym ,         /* （中継用）募集年月 */
     ztyharaikomip ,         /* （中継用）払込Ｐ */
     ztysyukeiyakup ,         /* （中継用）主契約Ｐ */
     ztytokujyoup ,         /* （中継用）特条Ｐ */
     ztyitibuitijibarais ,         /* （中継用）一部一時払Ｓ */
     ztyitibuitijibaraip ,         /* （中継用）一部一時払Ｐ */
     ztygoukeitenkanteikis ,         /* （中継用）合計転換定期Ｓ */
     ztysyuunoukbn ,         /* （中継用）収納区分 */
     ztytkykkumkhnsyukosuu ,         /* （中継用）特約項目編集個数 */
     ztysiteizukipwarimasihyouji ,         /* （中継用）指定月Ｐ割増表示 */
     ztypwarimasisiteim1 ,         /* （中継用）Ｐ割増指定月１ */
     ztypwarimasisiteim2 ,         /* （中継用）Ｐ割増指定月２ */
     ztysiteimsykykpbairitu ,         /* （中継用）指定月主契約Ｐ倍率 */
     ztysiteizukisyukeiyakup ,         /* （中継用）指定月主契約Ｐ */
     ztysiteizukiharaikomip ,         /* （中継用）指定月払込Ｐ */
     ztysaisyuusiteimhrkp ,         /* （中継用）最終指定月払込Ｐ */
     ztysaisyuusiteiym ,         /* （中継用）最終指定年月 */
     ztyanniskcd ,         /* （中継用）案内先コード */
     ztytumitateriritu ,         /* （中継用）積立利率 */
     ztysitihsyuriritu ,         /* （中継用）最低保証利率 */
     ztynkgnsritu ,         /* （中継用）年金原資率 */
     ztysinnyuukinkbn ,         /* （中継用）新入金区分 */
     ztydfnyuukinkbn ,         /* （中継用）ＤＦ入金区分 */
     ztytorikuzusip ,         /* （中継用）取崩Ｐ */
     ztykbnkeiriyousegmentcd ,         /* （中継用）区分経理用セグメントコード */
     ztysykikykjkykym ,         /* （中継用）初回契約時契約年月 */
     ztydfkijyunkingaku ,         /* （中継用）ＤＦ基準金額 */
     ztystdssytikbn ,         /* （中継用）外出集定区分 */
     ztysotodasimanagehyouji ,         /* （中継用）外出満年令表示 */
     ztysotodasiphkbnmnoshyouji ,         /* （中継用）外出Ｐ不可分見直表示 */
     ztystdsstkjytkyuhyj ,         /* （中継用）外出新特条適用表示 */
     ztykousinmanryouage ,         /* （中継用）更新満了年令 */
     ztyknkuzusnzyrttekitkarihyj ,         /* （中継用）健康増進乗率適用特約有表示 */
     ztyknkuzusnzyrt ,         /* （中継用）健康増進乗率 */
     ztytenkanjiknkuzusnzyrt ,         /* （中継用）転換時健康増進乗率 */
     ztypwrbksidhitekiyouhyj ,         /* （中継用）保険料割引制度非適用表示 */
     ztysuuriyouyobin1x2 ,         /* （中継用）数理用予備項目Ｎ１＿２ */
     ztyzyrthntiyustatuskbn ,         /* （中継用）乗率判定用ステータス区分 */
     ztyyobiv9 ,         /* （中継用）予備項目Ｖ９ */
     ztysotodasipmenkbn ,         /* （中継用）外出Ｐ免区分 */
     ztytokubetuhosyoukikan ,         /* （中継用）特別保障期間 */
     ztysuuriyouyobin7 ,         /* （中継用）数理用予備項目Ｎ７ */
     ztyphireilkeisanyoup ,         /* （中継用）Ｐ比例Ｌ計算用Ｐ */
     ztyyobin11 ,         /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2 ,         /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3 ,         /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4 ,         /* （中継用）予備項目Ｎ１１＿４ */
     ztycashlesshyj ,         /* （中継用）キャッシュレス表示 */
     ztykykjiqpackhyj ,         /* （中継用）契約時Ｑパック表示 */
     ztytenkanminaosikbn ,         /* （中継用）転換見直区分 */
     ztyhhknnentysihyj ,         /* （中継用）被保険者年令調整表示 */
     ztydai2hhknnentysihyj ,         /* （中継用）第２被保険者年令調整表示 */
     ztykyksyaagetyouseihyj ,         /* （中継用）契約者年令調整表示 */
     ztysykykhokenhoutekiyouhyj ,         /* （中継用）主契約保険法適用表示 */
     ztyhrimngtkykphrkkaisuukbn ,         /* （中継用）払満後特約Ｐ払込回数区分 */
     ztyjidoukousinhyouji ,         /* （中継用）自動更新表示 */
     ztysuuriyouyobin1 ,         /* （中継用）数理用予備項目Ｎ１ */
     ztytkjykbn ,         /* （中継用）特条区分 */
     ztydai2tokujyoukbn ,         /* （中継用）第２特条区分 */
     ztyryoumasihyouten ,         /* （中継用）料増標点 */
     ztydai2ryoumasihyouten ,         /* （中継用）第２料増標点 */
     ztysuuriyouyobin2 ,         /* （中継用）数理用予備項目Ｎ２ */
     ztysuuriyouyobin10 ,         /* （中継用）数理用予備項目Ｎ１０ */
     ztysuuriyouyobin10x2 ,         /* （中継用）数理用予備項目Ｎ１０＿２ */
     ztysuuriyouyobin10x3 ,         /* （中継用）数理用予備項目Ｎ１０＿３ */
     ztysuuriyouyobin10x4 ,         /* （中継用）数理用予備項目Ｎ１０＿４ */
     ztyyobiv10x6 ,         /* （中継用）予備項目Ｖ１０＿６ */
     ztyyobiv10x7 ,         /* （中継用）予備項目Ｖ１０＿７ */
     ztyyobiv10x8 ,         /* （中継用）予備項目Ｖ１０＿８ */
     ztyyobiv10x9 ,         /* （中継用）予備項目Ｖ１０＿９ */
     ztyyobiv10x10 ,         /* （中継用）予備項目Ｖ１０＿１０ */
     ztyyobiv10x11 ,         /* （中継用）予備項目Ｖ１０＿１１ */
     ztybosyuukeitaikbn ,         /* （中継用）募集形態区分 */
     ztyhrimngtkykphrkkirkbn ,         /* （中継用）払満後特約Ｐ払込経路区分 */
     ztyhrimngtkykpryurtkbn ,         /* （中継用）払満後特約Ｐ料率区分 */
     ztysyukeiyakusyuruicdv3 ,         /* （中継用）主契約種類コードＶ３ */
     ztyyobin11x5 ,         /* （中継用）予備項目Ｎ１１＿５ */
     ztyyobin11x6 ,         /* （中継用）予備項目Ｎ１１＿６ */
     ztyyobin11x7 ,         /* （中継用）予備項目Ｎ１１＿７ */
     ztyyobin11x8 ,         /* （中継用）予備項目Ｎ１１＿８ */
     ztyyobin11x9 ,         /* （中継用）予備項目Ｎ１１＿９ */
     ztyraysystemhyj ,         /* （中継用）ＲＡＹシステム表示 */
     ztygaikakbn ,         /* （中継用）外貨区分 */
     ztykykjikawaserate ,         /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd ,         /* （中継用）契約時為替レート適用年月日 */
     ztykeiyakujiyoteiriritu ,         /* （中継用）契約時予定利率 */
     ztyenkdtsbujsitihsyukngk ,         /* （中継用）円貨建死亡時最低保証金額 */
     ztynyuukintuukakbn ,         /* （中継用）入金通貨区分 */
     ztysisuurendourate ,         /* （中継用）指数連動部分割合 */
     ztysisuukbn ,         /* （中継用）指数区分 */
     ztynyknjikawaserate ,         /* （中継用）入金時為替レート */
     ztynyknjikawaseratetkyuymd ,         /* （中継用）入金時為替レート適用年月日 */
     ztysuuriyouyobin12 ,         /* （中継用）数理用予備項目Ｎ１２ */
     ztyyobiv10x15 ,         /* （中継用）予備項目Ｖ１０＿１５ */
     ztyyobiv10x16 ,         /* （中継用）予備項目Ｖ１０＿１６ */
     ztynkgns ,         /* （中継用）年金原資 */
     ztysisuubbntounyuugk ,         /* （中継用）指数部分投入金額 */
     ztysaisinyoteiriritu ,         /* （中継用）最新予定利率 */
     ztyyobin5 ,         /* （中継用）予備項目Ｎ５ */
     ztyyobin11x10 ,         /* （中継用）予備項目Ｎ１１＿１０ */
     ztykiharaikomip ,         /* （中継用）既払込Ｐ */
     ztytumitatekin ,         /* （中継用）積立金 */
     ztyzennoujiikkatubaraijytgk ,         /* （中継用）前納時一括払充当額 */
     ztygaikadatenkgns ,         /* （中継用）外貨建年金原資 */
     ztygaikadatesyukeiyakup ,         /* （中継用）外貨建主契約Ｐ */
     ztyyobiv1x3 ,         /* （中継用）予備項目Ｖ１＿３ */
     ztytokuyakukoumokuv160 ,         /* （中継用）特約項目Ｖ１６０ */
     ztytokuyakukoumokuv160x2 ,         /* （中継用）特約項目Ｖ１６０＿２ */
     ztytokuyakukoumokuv160x3 ,         /* （中継用）特約項目Ｖ１６０＿３ */
     ztytokuyakukoumokuv160x4 ,         /* （中継用）特約項目Ｖ１６０＿４ */
     ztytokuyakukoumokuv160x5 ,         /* （中継用）特約項目Ｖ１６０＿５ */
     ztytokuyakukoumokuv160x6 ,         /* （中継用）特約項目Ｖ１６０＿６ */
     ztytokuyakukoumokuv160x7 ,         /* （中継用）特約項目Ｖ１６０＿７ */
     ztytokuyakukoumokuv160x8 ,         /* （中継用）特約項目Ｖ１６０＿８ */
     ztytokuyakukoumokuv160x9 ,         /* （中継用）特約項目Ｖ１６０＿９ */
     ztytokuyakukoumokuv160x10 ,         /* （中継用）特約項目Ｖ１６０＿１０ */
     ztytokuyakukoumokuv160x11 ,         /* （中継用）特約項目Ｖ１６０＿１１ */
     ztytokuyakukoumokuv160x12 ,         /* （中継用）特約項目Ｖ１６０＿１２ */
     ztytokuyakukoumokuv160x13 ,         /* （中継用）特約項目Ｖ１６０＿１３ */
     ztytokuyakukoumokuv160x14 ,         /* （中継用）特約項目Ｖ１６０＿１４ */
     ztytokuyakukoumokuv160x15 ,         /* （中継用）特約項目Ｖ１６０＿１５ */
     ztytokuyakukoumokuv160x16 ,         /* （中継用）特約項目Ｖ１６０＿１６ */
     ztytokuyakukoumokuv160x17 ,         /* （中継用）特約項目Ｖ１６０＿１７ */
     ztytokuyakukoumokuv160x18 ,         /* （中継用）特約項目Ｖ１６０＿１８ */
     ztytokuyakukoumokuv160x19 ,         /* （中継用）特約項目Ｖ１６０＿１９ */
     ztytokuyakukoumokuv160x20 ,         /* （中継用）特約項目Ｖ１６０＿２０ */
     ztytokuyakukoumokuv160x21 ,         /* （中継用）特約項目Ｖ１６０＿２１ */
     ztytokuyakukoumokuv160x22 ,         /* （中継用）特約項目Ｖ１６０＿２２ */
     ztytokuyakukoumokuv160x23 ,         /* （中継用）特約項目Ｖ１６０＿２３ */
     ztytokuyakukoumokuv160x24 ,         /* （中継用）特約項目Ｖ１６０＿２４ */
     ztytokuyakukoumokuv160x25 ,         /* （中継用）特約項目Ｖ１６０＿２５ */
     ztytokuyakukoumokuv160x26 ,         /* （中継用）特約項目Ｖ１６０＿２６ */
     ztytokuyakukoumokuv160x27 ,         /* （中継用）特約項目Ｖ１６０＿２７ */
     ztytokuyakukoumokuv160x28 ,         /* （中継用）特約項目Ｖ１６０＿２８ */
     ztytokuyakukoumokuv160x29 ,         /* （中継用）特約項目Ｖ１６０＿２９ */
     ztytokuyakukoumokuv160x30 ,         /* （中継用）特約項目Ｖ１６０＿３０ */
     ztytokuyakukoumokuv160x31 ,         /* （中継用）特約項目Ｖ１６０＿３１ */
     ztytokuyakukoumokuv160x32 ,         /* （中継用）特約項目Ｖ１６０＿３２ */
     ztytokuyakukoumokuv160x33 ,         /* （中継用）特約項目Ｖ１６０＿３３ */
     ztytokuyakukoumokuv160x34 ,         /* （中継用）特約項目Ｖ１６０＿３４ */
     ztytokuyakukoumokuv160x35 ,         /* （中継用）特約項目Ｖ１６０＿３５ */
     ztytokuyakukoumokuv160x36 ,         /* （中継用）特約項目Ｖ１６０＿３６ */
     ztytokuyakukoumokuv160x37 ,         /* （中継用）特約項目Ｖ１６０＿３７ */
     ztytokuyakukoumokuv160x38 ,         /* （中継用）特約項目Ｖ１６０＿３８ */
     ztytokuyakukoumokuv160x39 ,         /* （中継用）特約項目Ｖ１６０＿３９ */
     ztytokuyakukoumokuv160x40 ,         /* （中継用）特約項目Ｖ１６０＿４０ */
     ztytokuyakukoumokuv160x41 ,         /* （中継用）特約項目Ｖ１６０＿４１ */
     ztytokuyakukoumokuv160x42 ,         /* （中継用）特約項目Ｖ１６０＿４２ */
     ztytokuyakukoumokuv160x43 ,         /* （中継用）特約項目Ｖ１６０＿４３ */
     ztytokuyakukoumokuv160x44 ,         /* （中継用）特約項目Ｖ１６０＿４４ */
     ztytokuyakukoumokuv160x45 ,         /* （中継用）特約項目Ｖ１６０＿４５ */
     ztytokuyakukoumokuv160x46 ,         /* （中継用）特約項目Ｖ１６０＿４６ */
     ztytokuyakukoumokuv160x47 ,         /* （中継用）特約項目Ｖ１６０＿４７ */
     ztytokuyakukoumokuv160x48 ,         /* （中継用）特約項目Ｖ１６０＿４８ */
     ztytokuyakukoumokuv160x49 ,         /* （中継用）特約項目Ｖ１６０＿４９ */
     ztytokuyakukoumokuv160x50 ,         /* （中継用）特約項目Ｖ１６０＿５０ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SkeisynyptoukeiksnTy_Z;