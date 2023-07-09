CREATE VIEW ZT_SbRituToukeiSeibiRenRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyobiv12 ,         /* （連携用）予備項目Ｖ１２ */
     zrndatakanrino ,         /* （連携用）データ管理番号 */
     zrnsyorikbn ,         /* （連携用）処理区分 */
     zrnsyoriymd ,         /* （連携用）処理年月日 */
     zrnkykmfksnctr ,         /* （連携用）契約ＭＦ更新ＣＴＲ */
     zrnsyorino ,         /* （連携用）処理ＮＯ */
     zrnsyoricd ,         /* （連携用）処理コード */
     zrnsyukgu ,         /* （連携用）種類記号 */
     zrnhihokensyaagev2 ,         /* （連携用）被保険者年令Ｖ２ */
     zrnhhknseikbn ,         /* （連携用）被保険者性別区分 */
     zrnkykym ,         /* （連携用）契約年月 */
     zrntokujyouhyouji ,         /* （連携用）特条表示 */
     zrnviphyouji ,         /* （連携用）ＶＩＰ表示 */
     zrnkisnkihons ,         /* （連携用）計算基本Ｓ */
     zrnkeisansibous ,         /* （連携用）計算死亡Ｓ */
     zrnshrs ,         /* （連携用）支払Ｓ */
     zrnshrymd ,         /* （連携用）支払年月日 */
     zrnsiharaisisyacd ,         /* （連携用）支払支社コード */
     zrnsymtgenincd ,         /* （連携用）消滅原因コード */
     zrnkeikaym ,         /* （連携用）経過年月 */
     zrnsbugenincd ,         /* （連携用）死亡原因コード */
     zrnbsyym ,         /* （連携用）募集年月 */
     zrndai2hhknnen ,         /* （連携用）第２被保険者年令 */
     zrndai2tokujyouhyouji ,         /* （連携用）第２特条表示 */
     zrntignmrtisyukgu ,         /* （連携用）逓減マル定種類記号 */
     zrnteigenmaruteikikan ,         /* （連携用）逓減マル定期間 */
     zrngoukeiteigenbubuns ,         /* （連携用）合計逓減部分Ｓ */
     zrnrenseimrtisyukgu ,         /* （連携用）連生マル定種類記号 */
     zrnyobiv1 ,         /* （連携用）予備項目Ｖ１ */
     zrnlivingneedsshrarihyj ,         /* （連携用）リビングニーズ支払有表示 */
     zrnlnkeikaym ,         /* （連携用）ＬＮ経過年月 */
     zrnlnshrgenincd ,         /* （連携用）ＬＮ支払原因コード */
     zrnkituenkbn ,         /* （連携用）喫煙区分 */
     zrnkituenhonsuu ,         /* （連携用）喫煙本数 */
     zrndugktnknsntkhuhukbn ,         /* （連携用）同額転換選択方法区分 */
     zrnkykjitokujyouarihyj ,         /* （連携用）契約時特条有表示 */
     zrntokuyakukousinkbn ,         /* （連携用）特約更新区分 */
     zrnteigenmaruteikisiym ,         /* （連携用）逓減マル定期始年月 */
     zrnsyunyumrtisyukgu ,         /* （連携用）収入マル定種類記号 */
     zrnsyuunyuumaruteikikan ,         /* （連携用）収入マル定期間 */
     zrnsyuunyuumrtinknengkn7 ,         /* （連携用）収入マル定年金年額Ｎ７ */
     zrnsyuunyuumaruteikisiym ,         /* （連携用）収入マル定期始年月 */
     zrnsysnymd ,         /* （連携用）初診年月日 */
     zrnsindanymd ,         /* （連携用）診断年月日 */
     zrnbyoumeicd1 ,         /* （連携用）病名コード１ */
     zrnbyoumeicd2 ,         /* （連携用）病名コード２ */
     zrnshrnaiyoukbn ,         /* （連携用）支払内容区分 */
     zrngituyuknkbn1 ,         /* （連携用）該当要件区分１ */
     zrngituyuknkbn2 ,         /* （連携用）該当要件区分２ */
     zrnsyeiebnri1 ,         /* （連携用）シェイエ分類１ */
     zrnsyeiebnri2 ,         /* （連携用）シェイエ分類２ */
     zrnminnesotacd1 ,         /* （連携用）ミネソタコード１ */
     zrnminnesotacd2 ,         /* （連携用）ミネソタコード２ */
     zrnminnesotacd3 ,         /* （連携用）ミネソタコード３ */
     zrnminnesotacd4 ,         /* （連携用）ミネソタコード４ */
     zrnminnesotacd5 ,         /* （連携用）ミネソタコード５ */
     zrnmnsisiensindanjiyuu ,         /* （連携用）慢性膵炎診断事由 */
     zrnknkuhnsindanjiyuu ,         /* （連携用）肝硬変診断事由 */
     zrnhushrkbn ,         /* （連携用）不支払区分 */
     zrnhushrym ,         /* （連携用）不支払年月 */
     zrnsyuunyuumrtinkshrkkn ,         /* （連携用）収入マル定年金支払期間 */
     zrntokujyousakugenkikan ,         /* （連携用）特条削減期間 */
     zrngengakutenkankykhyj ,         /* （連携用）減額転換契約表示 */
     zrnharaikomihouhou ,         /* （連携用）払込方法 */
     zrnsinsahouhou ,         /* （連携用）診査方法 */
     zrnkykniyutksytioukbn ,         /* （連携用）契約内容特殊対応区分 */
     zrnrnduyuryumshyutn ,         /* （連携用）連動用料増標点 */
     zrnhutanpobui1 ,         /* （連携用）不担保部位１ */
     zrnhtnpkkn1 ,         /* （連携用）不担保期間１ */
     zrnhutanpobui2 ,         /* （連携用）不担保部位２ */
     zrnhtnpkkn2 ,         /* （連携用）不担保期間２ */
     zrnhukasyuksyu ,         /* （連携用）付加主契約種類 */
     zrnsuuriyoutokuyakukbn ,         /* （連携用）数理用特約区分 */
     zrntokuyakuno ,         /* （連携用）特約番号 */
     zrnhaitoukbn ,         /* （連携用）配当区分 */
     zrnkusnmetkyksykipjyutuym ,         /* （連携用）更新前特約初回Ｐ充当年月 */
     zrnsykikjgykbn ,         /* （連携用）職域事業区分 */
     zrnsykgycd ,         /* （連携用）職業コード */
     zrnaatukaisosikicd ,         /* （連携用）Ａ扱者組織コード */
     zrnaatukaikojincd ,         /* （連携用）Ａ扱者個人コード */
     zrntenkanminaosikbn ,         /* （連携用）転換見直区分 */
     zrnkaijyokbn ,         /* （連携用）解除区分 */
     zrnsyuruihenkouarihyouji ,         /* （連携用）種類変更有表示 */
     zrndai2hihokensyasonzokuhyj ,         /* （連携用）第２被保険者存続表示 */
     zrnsyukeiyakukigou ,         /* （連携用）主契約記号 */
     zrnsymtymd ,         /* （連携用）消滅年月日 */
     zrntyuutohukatkhyj ,         /* （連携用）中途付加特約表示 */
     zrnyoukigjyutigituymd ,         /* （連携用）要介護状態該当年月日 */
     zrnyoukigjyutigeninkbn ,         /* （連携用）要介護状態原因区分 */
     zrnsykmtssyukahikbn ,         /* （連携用）食物摂取可否区分 */
     zrnfktrsmtkahikbn ,         /* （連携用）拭き取り始末可否区分 */
     zrnhokoukahikbn ,         /* （連携用）歩行可否区分 */
     zrnnyykkahikbn ,         /* （連携用）入浴可否区分 */
     zrnihukutyakudatukahikbn ,         /* （連携用）衣服着脱可否区分 */
     zrntihougeninkbn ,         /* （連携用）痴呆原因区分 */
     zrnsyukgusdkbn ,         /* （連携用）種類記号世代区分 */
     zrntignmrtisyukgusdkbn ,         /* （連携用）逓減マル定種類記号世代区分 */
     zrnrenseimrtisyukgusdkbn ,         /* （連携用）連生マル定種類記号世代区分 */
     zrnsyunyumrtisyukgusdkbn ,         /* （連携用）収入マル定種類記号世代区分 */
     zrnsykyksyuruikgusdkbn ,         /* （連携用）主契約種類記号世代区分 */
     zrnpmenhukakbn ,         /* （連携用）Ｐ免付加区分 */
     zrnpmenkbnv2 ,         /* （連携用）Ｐ免区分Ｖ２ */
     zrnpmenjikohasseiymd ,         /* （連携用）Ｐ免事故発生年月日 */
     zrnbosyuukeirokbn ,         /* （連携用）募集経路区分 */
     zrnbsudirtnatkikeitaikbn ,         /* （連携用）募集代理店扱形態区分 */
     zrnsyorinov2 ,         /* （連携用）処理番号Ｖ２ */
     zrnkigkyhsitihsyutkykhyj ,         /* （連携用）介護給付最低保証特約表示 */
     zrnpmenhutanpobui1 ,         /* （連携用）Ｐ免不担保部位１ */
     zrnpmenhutanpokikan1 ,         /* （連携用）Ｐ免不担保期間１ */
     zrnpmenhutanpobui2 ,         /* （連携用）Ｐ免不担保部位２ */
     zrnpmenhutanpokikan2 ,         /* （連携用）Ｐ免不担保期間２ */
     zrnkanyujidatakanrino ,         /* （連携用）加入時データ管理番号 */
     zrnbnktgsnzkkykdatakanrino ,         /* （連携用）分割後存続契約データ管理番号 */
     zrnbnkttnknkbn ,         /* （連携用）分割転換区分 */
     zrnkykjiqpackhyj ,         /* （連携用）契約時Ｑパック表示 */
     zrnbnktjisisttkarihyj ,         /* （連携用）分割時災疾特約有表示 */
     zrnsotodasipmenkbn ,         /* （連携用）外出Ｐ免区分 */
     zrnstdssnskbn ,         /* （連携用）外出診査区分 */
     zrncareneedssiharaihyouji ,         /* （連携用）ケアニーズ支払表示 */
     zrnbnktjitiktkarihyj ,         /* （連携用）分割時定期特約有表示 */
     zrnkousinkbn ,         /* （連携用）更新区分 */
     zrnksnym ,         /* （連携用）更新年月 */
     zrnijitoukeiyuksnhyj ,         /* （連携用）医事統計用更新表示 */
     zrnikoujisnskbn ,         /* （連携用）移行時診査区分 */
     zrnstdssytikbn ,         /* （連携用）外出集定区分 */
     zrnsuuriyouyobin1 ,         /* （連携用）数理用予備項目Ｎ１ */
     zrnimustiyusbus ,         /* （連携用）医務査定用死亡Ｓ */
     zrnkeisansykykbbnkhns ,         /* （連携用）計算主契約部分基本Ｓ */
     zrnsuuriyoubosyuukeitaikbn ,         /* （連携用）数理用募集形態区分 */
     zrnsysnikoujiym ,         /* （連携用）終身移行時年月 */
     zrngnspshrhyj ,         /* （連携用）がんサポ支払表示 */
     zrngnspshrkeikaym ,         /* （連携用）がんサポ支払経過年月 */
     zrngnspshrgenincd ,         /* （連携用）がんサポ支払原因コード */
     zrnsotodasimanagehyouji ,         /* （連携用）外出満年令表示 */
     zrnhhknnentysihyj ,         /* （連携用）被保険者年令調整表示 */
     zrndai2hhknnentysihyj ,         /* （連携用）第２被保険者年令調整表示 */
     zrnngerkahikbn ,         /* （連携用）寝返り可否区分 */
     zrnhokenhoutekiyouhyouji ,         /* （連携用）保険法適用表示 */
     zrntokuteijyoutaihushrhyj ,         /* （連携用）特定状態不支払表示 */
     zrnsotodasiphkbnmnoshyouji ,         /* （連携用）外出Ｐ不可分見直表示 */
     zrnkeisansyukeiyakup ,         /* （連携用）計算主契約Ｐ */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrntokubetuhosyoukikan ,         /* （連携用）特別保障期間 */
     zrnsaimnkkykhyj ,         /* （連携用）才満期契約表示 */
     zrnkeisangoukeitenkans ,         /* （連携用）計算合計転換Ｓ */
     zrnkeisangoukeitenkankakaku ,         /* （連携用）計算合計転換価格 */
     zrnkisnwnsgukitnknkakaku ,         /* （連携用）計算Ｗなし合計転換価格 */
     zrntnknkhnbbnjyuturt ,         /* （連携用）転換基本部分充当率 */
     zrnharaizumiymd ,         /* （連携用）払済年月日 */
     zrnstdsstkjytkyuhyj ,         /* （連携用）外出新特条適用表示 */
     zrnkeisanyoteiriritu ,         /* （連携用）計算予定利率 */
     zrnseiketuseiyoukahikbn ,         /* （連携用）清潔整容可否区分 */
     zrnsyuurouhunoukgjyoutaikbn ,         /* （連携用）就労不能介護状態区分 */
     zrnsyuurouhunoujyoutaikbn ,         /* （連携用）就労不能状態区分 */
     zrnsiznkyhsyoubyouhasseiymd ,         /* （連携用）生前給付傷病発生年月日 */
     zrnkyusisnknkuskgitukbn ,         /* （連携用）急性心筋梗塞該当区分 */
     zrnnousottyuugaitoukbn ,         /* （連携用）脳卒中該当区分 */
     zrnjinhuzengaitoukbn ,         /* （連携用）腎不全該当区分 */
     zrndoumyakusikkangaitoukbn ,         /* （連携用）動脈疾患該当区分 */
     zrndatakanrino2 ,         /* （連携用）データ管理番号２ */
     zrndatakanrino3 ,         /* （連携用）データ管理番号３ */
     zrnsinkeiyakujivithkhyouji ,         /* （連携用）新契約時Ｖｉｔ保険表示 */
     zrnknkuzusnzyrttekitkarihyj ,         /* （連携用）健康増進乗率適用特約有表示 */
     zrnknkuzusnzyrtsiyounendo ,         /* （連携用）健康増進乗率使用年度 */
     zrnknkuzusnzyrt ,         /* （連携用）健康増進乗率 */
     zrnvittkykkaiyakuymd ,         /* （連携用）Ｖｉｔ特約解約年月日 */
     zrnpwrbksidhitekiyouhyj ,         /* （連携用）保険料割引制度非適用表示 */
     zrnnintisyougeninkbn ,         /* （連携用）認知症原因区分 */
     zrnsuuriyouyobin1x2 ,         /* （連携用）数理用予備項目Ｎ１＿２ */
     zrnsuuriyouyobin8x3 ,         /* （連携用）数理用予備項目Ｎ８＿３ */
     zrnsuuriyouyobin8x4 ,         /* （連携用）数理用予備項目Ｎ８＿４ */
     zrnsuuriyouyobin8x5 ,         /* （連携用）数理用予備項目Ｎ８＿５ */
     zrnsuuriyouyobin8x6 ,         /* （連携用）数理用予備項目Ｎ８＿６ */
     zrnsuuriyouyobin8x7 ,         /* （連携用）数理用予備項目Ｎ８＿７ */
     zrnsuuriyouyobin8x8 ,         /* （連携用）数理用予備項目Ｎ８＿８ */
     zrnsuuriyouyobin8x9 ,         /* （連携用）数理用予備項目Ｎ８＿９ */
     zrnsuuriyouyobin8x10 ,         /* （連携用）数理用予備項目Ｎ８＿１０ */
     zrnyobin7 ,         /* （連携用）予備項目Ｎ７ */
     zrnyobin7x2 ,         /* （連携用）予備項目Ｎ７＿２ */
     zrnyobin7x3 ,         /* （連携用）予備項目Ｎ７＿３ */
     zrnyobin7x4 ,         /* （連携用）予備項目Ｎ７＿４ */
     zrnyobin7x5 ,         /* （連携用）予備項目Ｎ７＿５ */
     zrnzyrthntiyustatuskbn ,         /* （連携用）乗率判定用ステータス区分 */
     zrnyobiv59 ,         /* （連携用）予備項目Ｖ５９ */
     zrnraysystemhyj ,         /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn ,         /* （連携用）外貨区分 */
     zrngaikadatekihons ,         /* （連携用）外貨建基本Ｓ */
     zrngaikadatesibous ,         /* （連携用）外貨建死亡Ｓ */
     zrnkeiyakujiyoteiriritu ,         /* （連携用）契約時予定利率 */
     zrnkawaserate ,         /* （連携用）為替レート */
     zrnkawaseratetekiyouymd ,         /* （連携用）為替レート適用年月日 */
     zrnenkdtsbujsitihsyukngk ,         /* （連携用）円貨建死亡時最低保証金額 */
     zrnsuuriyouyobin10 ,         /* （連携用）数理用予備項目Ｎ１０ */
     zrnsuuriyouyobin10x2 ,         /* （連携用）数理用予備項目Ｎ１０＿２ */
     zrnyobiv10x3 ,         /* （連携用）予備項目Ｖ１０＿３ */
     zrnyobin11 ,         /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2 ,         /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3 ,         /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4 ,         /* （連携用）予備項目Ｎ１１＿４ */
     zrnyobin11x5 ,         /* （連携用）予備項目Ｎ１１＿５ */
     zrnyobiv4           /* （連携用）予備項目Ｖ４ */
FROM ZT_SbRituToukeiSeibiRenRn_Z;