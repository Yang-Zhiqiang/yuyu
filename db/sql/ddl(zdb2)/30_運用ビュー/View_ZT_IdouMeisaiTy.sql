CREATE VIEW ZT_IdouMeisaiTy AS SELECT
     ztysequenceno ,         /* （中継用）シーケンス番号 */
     ztyyuukourecordlength ,         /* （中継用）有効レコード長 */
     ztyrdwarea ,         /* （中継用）ＲＤＷ領域 */
     ztyrecordkbn ,         /* （中継用）レコード区分 */
     ztynenkinkaisigohyouji ,         /* （中継用）年金開始後表示 */
     ztynksgokurikosidhyj ,         /* （中継用）年金開始後繰越Ｄ表示 */
     ztykeijyouym ,         /* （中継用）計上年月 */
     ztyidojiyukbn ,         /* （中継用）異動事由区分 */
     ztyzougenkbn ,         /* （中継用）増減区分 */
     ztyidourecordkbn ,         /* （中継用）異動レコード区分 */
     ztykeijyouctrlkbn ,         /* （中継用）計上コントロール区分 */
     ztyhenkousyoriymd ,         /* （中継用）変更処理年月日 */
     ztykykmfksnctr ,         /* （中継用）契約ＭＦ更新ＣＴＲ */
     ztyrecordctr ,         /* （中継用）レコードＣＴＲ */
     ztysuuriyoukouryokukaisiymd ,         /* （中継用）数理用効力開始年月日 */
     ztydenymd ,         /* （中継用）伝票日付 */
     ztybluekeizokuhyouji ,         /* （中継用）Ｂｌｕｅ継続表示 */
     ztysuuriyouyobin1x2 ,         /* （中継用）数理用予備項目Ｎ１＿２ */
     ztytoukeikeijyoukbn ,         /* （中継用）統計計上区分 */
     ztyraysystemhyj ,         /* （中継用）ＲＡＹシステム表示 */
     ztyzenkiidouteiseikbn ,         /* （中継用）前期異動訂正区分 */
     ztybsyym ,         /* （中継用）募集年月 */
     ztytenkangokeiyakubosyuuym ,         /* （中継用）転換後契約募集年月 */
     ztyidoujiyuucd ,         /* （中継用）異動事由コード */
     ztysyoricd ,         /* （中継用）処理コード */
     ztysekininteiseihyouji ,         /* （中継用）責任訂正表示 */
     ztysuuriyouyobin8 ,         /* （中継用）数理用予備項目Ｎ８ */
     ztysihankibikinkbn ,         /* （中継用）四半期備金区分 */
     ztysuuriyouyobin1x3 ,         /* （中継用）数理用予備項目Ｎ１＿３ */
     ztydatakanrino ,         /* （中継用）データ管理番号 */
     ztyhknsyukigou ,         /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn ,         /* （中継用）保険種類記号世代区分 */
     ztysotodasipmenkbn ,         /* （中継用）外出Ｐ免区分 */
     ztystdssytikbn ,         /* （中継用）外出集定区分 */
     ztystdssnskbn ,         /* （中継用）外出診査区分 */
     ztysotodasimanagehyouji ,         /* （中継用）外出満年令表示 */
     ztysotodasiphkbnmnoshyouji ,         /* （中継用）外出Ｐ不可分見直表示 */
     ztystdsstkjytkyuhyj ,         /* （中継用）外出新特条適用表示 */
     ztykbnkeiriyousegmentkbn ,         /* （中継用）区分経理用セグメント区分 */
     ztykbnkeiriyourgnbnskkbn ,         /* （中継用）区分経理用利源分析区分 */
     ztysuurisyuruicd ,         /* （中継用）数理種類コード */
     ztyhosyoukinoukbn ,         /* （中継用）保障機能区分 */
     ztydaikbn ,         /* （中継用）大区分 */
     ztytyuukbn ,         /* （中継用）中区分 */
     ztysyoukbn ,         /* （中継用）小区分 */
     ztysedaikbn ,         /* （中継用）世代区分 */
     ztyharaikatakbn ,         /* （中継用）払方区分 */
     ztykykymd ,         /* （中継用）契約年月日 */
     ztyhknkkn ,         /* （中継用）保険期間 */
     ztyphrkkikn ,         /* （中継用）Ｐ払込期間 */
     ztysaimnkkykhyj ,         /* （中継用）才満期契約表示 */
     ztyannaifuyouriyuukbn ,         /* （中継用）案内不要理由区分 */
     ztytksyuannaikykkbn ,         /* （中継用）特殊案内契約区分 */
     ztyhrkkaisuukbn ,         /* （中継用）払込回数区分 */
     ztyhrkkeirokbn ,         /* （中継用）払込経路区分 */
     ztysdpdkbn ,         /* （中継用）Ｓ建Ｐ建区分 */
     ztyryouritukbn ,         /* （中継用）料率区分 */
     ztyao3tyou3sibousdatehyouji ,         /* （中継用）青３長３死亡Ｓ建表示 */
     ztyhhknseikbn ,         /* （中継用）被保険者性別区分 */
     ztyhihokensyaagev2 ,         /* （中継用）被保険者年令Ｖ２ */
     ztykyksyanen ,         /* （中継用）契約者年令 */
     ztydai2hhknnen ,         /* （中継用）第２被保険者年令 */
     ztytkbthsyumnryuhyouji ,         /* （中継用）特別保障満了表示 */
     ztysyukeiyakupwaribikikbn ,         /* （中継用）主契約Ｐ割引区分 */
     ztytenkanwaribikikbn ,         /* （中継用）転換割引区分 */
     ztyyuuhitutnknyuguryurtkbn ,         /* （中継用）有配当転換優遇料率区分 */
     ztysyukeiyakup ,         /* （中継用）主契約Ｐ */
     ztytokujyoup ,         /* （中継用）特条Ｐ */
     ztysiteizukisyukeiyakup ,         /* （中継用）指定月主契約Ｐ */
     ztykihons ,         /* （中継用）基本Ｓ */
     ztysibous ,         /* （中継用）死亡Ｓ */
     ztyhenkougokihons ,         /* （中継用）変更後基本Ｓ */
     ztyhenkougosibous ,         /* （中継用）変更後死亡Ｓ */
     ztyhenkouymd ,         /* （中継用）変更年月日 */
     ztyentyoukikan ,         /* （中継用）延長期間 */
     ztyseizonkyuuhukinsiteimd ,         /* （中継用）生存給付金指定月日 */
     ztysyukeiyakusiharaikingaku ,         /* （中継用）主契約支払金額 */
     ztyatukaisisyatodouhukencd ,         /* （中継用）扱支社都道府県コード */
     ztytokuyakuhukasuu ,         /* （中継用）特約付加数 */
     ztydi2hknkknikoujihisyaage ,         /* （中継用）第２保険期間移行時被者年令 */
     ztyhrimnentyoumaephrkkkn ,         /* （中継用）払満延長前Ｐ払込期間 */
     ztytokubetuhosyoukikan ,         /* （中継用）特別保障期間 */
     ztykousinmanryouage ,         /* （中継用）更新満了年令 */
     ztyknkuzusnzyrttekitkarihyj ,         /* （中継用）健康増進乗率適用特約有表示 */
     ztykuriagekurisagekbn ,         /* （中継用）繰上げ繰下げ区分 */
     ztyhrizmjhknsyukigousdkbn ,         /* （中継用）払済時保険種類記号世代区分 */
     ztykrsgjhknsyukigousdkbn ,         /* （中継用）繰下げ時保険種類記号世代区分 */
     ztysotodasisyouhinkaiteikbn ,         /* （中継用）外出商品改定区分 */
     ztyyobiv4 ,         /* （中継用）予備項目Ｖ４ */
     ztygoukeitenkans ,         /* （中継用）合計転換Ｓ */
     ztygoukeipbubuntenkans ,         /* （中継用）合計Ｐ部分転換Ｓ */
     ztytenkanteikisyuruikigou ,         /* （中継用）転換定期種類記号 */
     ztytenkanteikikigousedaikbn ,         /* （中継用）転換定期記号世代区分 */
     ztytnkntiksotodasikusnkbn ,         /* （中継用）転換定期外出更新区分 */
     ztytnkntikstdspmenkbn ,         /* （中継用）転換定期外出Ｐ免区分 */
     ztytenkanteikikigouyobi ,         /* （中継用）転換定期記号予備 */
     ztytenkanteikikikan ,         /* （中継用）転換定期期間 */
     ztygoukeitenkanteikis ,         /* （中継用）合計転換定期Ｓ */
     ztytnknteikinkshrkkn ,         /* （中継用）転換定期年金支払期間 */
     ztytenkansiharaikingaku ,         /* （中継用）転換支払金額 */
     ztytnkntikshrkngk ,         /* （中継用）転換定期支払金額 */
     ztytenkankaisuu ,         /* （中継用）転換回数 */
     ztygoukeitenkankakaku ,         /* （中継用）合計転換価格 */
     ztytnknkhnbbnjyuturt ,         /* （中継用）転換基本部分充当率 */
     ztywnasigoukeitenkanteikis ,         /* （中継用）Ｗなし合計転換定期Ｓ */
     ztytnknteikikousinmnryouage ,         /* （中継用）転換定期更新満了年令 */
     ztyyobiv5 ,         /* （中継用）予備項目Ｖ５ */
     ztykanyujidatakanrino ,         /* （中継用）加入時データ管理番号 */
     ztykanyujikykymd ,         /* （中継用）加入時契約年月日 */
     ztykanyuujihihokensyaage ,         /* （中継用）加入時被保険者年令 */
     ztykanyuujitenkanhyouji ,         /* （中継用）加入時転換表示 */
     ztyhsyuikktminaosikaisu ,         /* （中継用）保障一括見直回数 */
     ztysknnjynbknsisnrt ,         /* （中継用）責任準備金精算率 */
     ztytkjykbn ,         /* （中継用）特条区分 */
     ztysakugenkikan ,         /* （中継用）削減期間 */
     ztyryoumasihyouten ,         /* （中継用）料増標点 */
     ztysykyktkjyuryumsratehyj ,         /* （中継用）主契約特条料増レート表示 */
     ztysykyktkjyuryumsrate ,         /* （中継用）主契約特条料増レート */
     ztydai2tokujyoukbn ,         /* （中継用）第２特条区分 */
     ztydai2sakugenkikan ,         /* （中継用）第２削減期間 */
     ztydai2ryoumasihyouten ,         /* （中継用）第２料増標点 */
     ztytokuteibuijyoukenhyouji ,         /* （中継用）特定部位条件表示 */
     ztytokuteibuino1 ,         /* （中継用）特定部位番号１ */
     ztyhtnpkkn1 ,         /* （中継用）不担保期間１ */
     ztytokuteibuino2 ,         /* （中継用）特定部位番号２ */
     ztyhtnpkkn2 ,         /* （中継用）不担保期間２ */
     ztymhituiryuyutktbijyknhyj ,         /* （中継用）無配当医療用特定部位条件表示 */
     ztymuhaitouiryouyoutktbino1 ,         /* （中継用）無配当医療用特定部位番号１ */
     ztymuhaitouiryouyouhtnpkkn1 ,         /* （中継用）無配当医療用不担保期間１ */
     ztymuhaitouiryouyoutktbino2 ,         /* （中継用）無配当医療用特定部位番号２ */
     ztymuhaitouiryouyouhtnpkkn2 ,         /* （中継用）無配当医療用不担保期間２ */
     ztysiteizukipwarimasihyouji ,         /* （中継用）指定月Ｐ割増表示 */
     ztypwarimasisiteim1 ,         /* （中継用）Ｐ割増指定月１ */
     ztypwarimasisiteim2 ,         /* （中継用）Ｐ割増指定月２ */
     ztysiteimsykykpbairitu ,         /* （中継用）指定月主契約Ｐ倍率 */
     ztysaisyuusiteiym ,         /* （中継用）最終指定年月 */
     ztysykykkitmttvkeisanym ,         /* （中継用）主契約既積立Ｖ計算年月 */
     ztysykykkitmttsknnjynbkngk ,         /* （中継用）主契約既積立責任準備金額 */
     ztydftumitatekingaku ,         /* （中継用）ＤＦ積立金額 */
     ztydftumimasikin ,         /* （中継用）ＤＦ積増金 */
     ztyvbubundftenkankakaku ,         /* （中継用）Ｖ部分ＤＦ転換価格 */
     ztydpbubundftenkankakaku ,         /* （中継用）ＤＰ部分ＤＦ転換価格 */
     ztydftmttkngkitjbrbbn ,         /* （中継用）ＤＦ積立金額一時払部分 */
     ztyhendous ,         /* （中継用）変動Ｓ */
     ztyhengakujigyounendomatucv ,         /* （中継用）変額事業年度末ＣＶ */
     ztyitibuitijibarais ,         /* （中継用）一部一時払Ｓ */
     ztyitibuitijibaraip ,         /* （中継用）一部一時払Ｐ */
     ztyitibitjbrshrkngk ,         /* （中継用）一部一時払支払金額 */
     ztygoukeicv ,         /* （中継用）合計ＣＶ */
     ztyminasicv ,         /* （中継用）みなしＣＶ */
     ztyloanfund ,         /* （中継用）ローンファンド */
     ztysaiteihosyougaku ,         /* （中継用）最低保証額 */
     ztyhngksitihsyuyusykykp ,         /* （中継用）変額最低保証用主契約Ｐ */
     ztyhijynbrivasbujsitihsyugk ,         /* （中継用）平準払ＶＡ死亡時最低保証金額 */
     ztyhijynbrivamnkjsitihsyugk ,         /* （中継用）平準払ＶＡ満期時最低保証金額 */
     ztysiinkbn ,         /* （中継用）死因区分 */
     ztymudkaimasikihons ,         /* （中継用）ミューＤ買増基本Ｓ */
     ztykaimasiymd ,         /* （中継用）買増年月日 */
     ztykaimasikikan ,         /* （中継用）買増期間 */
     ztyhikitugikaimasis ,         /* （中継用）引継買増Ｓ */
     ztymudkaimasisiharaikingaku ,         /* （中継用）ミューＤ買増支払金額 */
     ztyszoukouryokukaisiymdx1 ,         /* （中継用）Ｓ増効力開始年月日＿１ */
     ztyszouhokensyuruikigoux1 ,         /* （中継用）Ｓ増保険種類記号＿１ */
     ztyszoukigousedaikbnx1 ,         /* （中継用）Ｓ増記号世代区分＿１ */
     ztyszoukikanx1 ,         /* （中継用）Ｓ増期間＿１ */
     ztyszouhihokensyaagex1 ,         /* （中継用）Ｓ増被保険者年令＿１ */
     ztyszoudai2hihknsyaagex1 ,         /* （中継用）Ｓ増第２被保険者年令＿１ */
     ztyzoukasx1 ,         /* （中継用）増加Ｓ＿１ */
     ztyzennendozoukasx1 ,         /* （中継用）前年度増加Ｓ＿１ */
     ztyszousiharaikingakux1 ,         /* （中継用）Ｓ増支払金額＿１ */
     ztyszoukouryokukaisiymdx2 ,         /* （中継用）Ｓ増効力開始年月日＿２ */
     ztyszouhokensyuruikigoux2 ,         /* （中継用）Ｓ増保険種類記号＿２ */
     ztyszoukigousedaikbnx2 ,         /* （中継用）Ｓ増記号世代区分＿２ */
     ztyszoukikanx2 ,         /* （中継用）Ｓ増期間＿２ */
     ztyszouhihokensyaagex2 ,         /* （中継用）Ｓ増被保険者年令＿２ */
     ztyszoudai2hihknsyaagex2 ,         /* （中継用）Ｓ増第２被保険者年令＿２ */
     ztyzoukasx2 ,         /* （中継用）増加Ｓ＿２ */
     ztyzennendozoukasx2 ,         /* （中継用）前年度増加Ｓ＿２ */
     ztyszousiharaikingakux2 ,         /* （中継用）Ｓ増支払金額＿２ */
     ztysuuriyouyobin1x5 ,         /* （中継用）数理用予備項目Ｎ１＿５ */
     ztysuuriyouyobin1x6 ,         /* （中継用）数理用予備項目Ｎ１＿６ */
     ztyhrimngkizktkykpmenhyj ,         /* （中継用）払満後継続特約Ｐ免表示 */
     ztymisyuustartym ,         /* （中継用）未収開始年月 */
     ztymisyuukaisuu ,         /* （中継用）未収回数 */
     ztyitjbrtkykkousnuktkarhyj ,         /* （中継用）一時払特約更新受付有表示 */
     ztygyousekihyoujis ,         /* （中継用）業績表示Ｓ */
     ztysykykgyusekihyjs ,         /* （中継用）主契約業績表示Ｓ */
     ztytenkangyousekihyoujis ,         /* （中継用）転換業績表示Ｓ */
     ztytnknteikigyousekihyjs ,         /* （中継用）転換定期業績表示Ｓ */
     ztytnkndpbbngyuskhyjs ,         /* （中継用）転換ＤＰ部分業績表示Ｓ */
     ztykykjyoutai ,         /* （中継用）契約状態 */
     ztypmenhukakbn ,         /* （中継用）Ｐ免付加区分 */
     ztykousinkbn ,         /* （中継用）更新区分 */
     ztymankiyoteikbn ,         /* （中継用）満期予定区分 */
     ztysykyktikmnkyoteikbn ,         /* （中継用）主契約定期満期予定区分 */
     ztytnknsykykkhnmnkytikbn ,         /* （中継用）転換主契約基本満期予定区分 */
     ztytnknsykyktikmnkytikbn ,         /* （中継用）転換主契約定期満期予定区分 */
     ztytenkanteikimankiyoteikbn ,         /* （中継用）転換定期満期予定区分 */
     ztyszoumankiyoteikbnx1 ,         /* （中継用）Ｓ増満期予定区分＿１ */
     ztyszoumankiyoteikbnx2 ,         /* （中継用）Ｓ増満期予定区分＿２ */
     ztyvestingmankiyoteikbn ,         /* （中継用）ベスティング満期予定区分 */
     ztyvkeisanhyouji ,         /* （中継用）Ｖ計算表示 */
     ztytoukisinkeiyakuhyouji ,         /* （中継用）当期新契約表示 */
     ztysykykhokenhoutekiyouhyj ,         /* （中継用）主契約保険法適用表示 */
     ztytokuteijyoutaihushrhyj ,         /* （中継用）特定状態不支払表示 */
     ztyytirrthndsysnmnskaisuu ,         /* （中継用）予定利率変動終身見直回数 */
     ztysuuriyouyobin3 ,         /* （中継用）数理用予備項目Ｎ３ */
     ztysuuriyouyobin11 ,         /* （中継用）数理用予備項目Ｎ１１ */
     ztywnasigoukeitenkankakaku ,         /* （中継用）Ｗなし合計転換価格 */
     ztyyobin11 ,         /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2 ,         /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3 ,         /* （中継用）予備項目Ｎ１１＿３ */
     ztytukibaraikansantokujyoup ,         /* （中継用）月払換算特条Ｐ */
     ztytnkngkykkssnkijyuym ,         /* （中継用）転換後契約決算計上年月 */
     ztysaiteihosyouhyouji ,         /* （中継用）最低保証表示 */
     ztysuuriyouyobin8x2 ,         /* （中継用）数理用予備項目Ｎ８＿２ */
     ztysuuriyouyobin14 ,         /* （中継用）数理用予備項目Ｎ１４ */
     ztyhrimngtkykphrkkaisuukbn ,         /* （中継用）払満後特約Ｐ払込回数区分 */
     ztyhrimngtkykphrkkirkbn ,         /* （中継用）払満後特約Ｐ払込経路区分 */
     ztyhrimngtkykpryurtkbn ,         /* （中継用）払満後特約Ｐ料率区分 */
     ztyyobiv13 ,         /* （中継用）予備項目Ｖ１３ */
     ztyidoujisaiteihosyoukngk ,         /* （中継用）異動時最低保証金額 */
     ztyidoujisaiteihosyoucost ,         /* （中継用）異動時最低保証コスト */
     ztysinhokenfundtumitatekin ,         /* （中継用）新保険ファンド積立金 */
     ztymsyuptusshkgkaiykhnrikn ,         /* （中継用）未収Ｐ等差引後解約返戻金 */
     ztyrrthndugtnkgetumatuv ,         /* （中継用）利率変動型年金月末Ｖ */
     ztyrrthndnksaiteihosyonkgns ,         /* （中継用）利率変動年金最低保証年金原資 */
     ztyrrthendougatanksibous ,         /* （中継用）利率変動型年金死亡Ｓ */
     ztyalmyousohutomeisyoukbn ,         /* （中継用）ＡＬＭ用ソフト名称区分 */
     ztysnkyksoftmeisyoukbn ,         /* （中継用）新契約ソフト名称区分 */
     ztysoftmeisyoukbn ,         /* （中継用）ソフト名称区分 */
     ztykykjitokujyouarihyj ,         /* （中継用）契約時特条有表示 */
     ztybnkttnknkbn ,         /* （中継用）分割転換区分 */
     ztytenkanminaosikbn ,         /* （中継用）転換見直区分 */
     ztysoujikeitenkankbn ,         /* （中継用）相似形転換区分 */
     ztynenkinkaisinendo ,         /* （中継用）年金開始年度 */
     ztynenkingatakbn ,         /* （中継用）年金型区分 */
     ztynknshry ,         /* （中継用）年金支払期間 */
     ztyheiyoubaraikeiyakukbn ,         /* （中継用）併用払契約区分 */
     ztynenkinmaruteihukakbn ,         /* （中継用）年金マル定付加区分 */
     ztysinseizonmrtiarihyj ,         /* （中継用）新生存マル定有表示 */
     ztysnkykyouibokijyukbn ,         /* （中継用）新契約用異募計上区分 */
     ztytokusitujyuusitusetkbn ,         /* （中継用）特疾重疾セット区分 */
     ztysiktsyuknbyugnhsyunshyj ,         /* （中継用）生活習慣病がん保障無表示 */
     ztypmensugugtganhsyunshyj ,         /* （中継用）Ｐ免総合型がん保障無表示 */
     ztytkykgyousekihyjszerohyj ,         /* （中継用）特約業績表示Ｓゼロ表示 */
     ztysuuriyouyobin7 ,         /* （中継用）数理用予備項目Ｎ７ */
     ztysyussaikeitaikbn ,         /* （中継用）出再形態区分 */
     ztyyobiv6 ,         /* （中継用）予備項目Ｖ６ */
     ztybosyuukeitaikbn ,         /* （中継用）募集形態区分 */
     ztyaatukaisosikicd ,         /* （中継用）Ａ扱者組織コード */
     ztyaatukaikojincd ,         /* （中継用）Ａ扱者個人コード */
     ztybsydrtencd ,         /* （中継用）募集代理店コード */
     ztycifcd ,         /* （中継用）ＣＩＦコード */
     ztysuuriyouyobiv8 ,         /* （中継用）数理用予備項目Ｖ８ */
     ztysinsakbn ,         /* （中継用）診査区分 */
     ztydai2hihokensyasinsakbn ,         /* （中継用）第２被保険者診査区分 */
     ztytoukeiyousinsakbn ,         /* （中継用）統計用診査区分 */
     ztydai2toukeiyousinsakbn ,         /* （中継用）第２統計用診査区分 */
     ztyketteikijyunkanwakbn ,         /* （中継用）決定基準緩和区分 */
     ztykihonsibouhyoukbn ,         /* （中継用）基本死亡表区分 */
     ztyteikisibouhyoukbn ,         /* （中継用）定期死亡表区分 */
     ztysonotasibouhyoukbn ,         /* （中継用）その他死亡表区分 */
     ztymrarihyj ,         /* （中継用）ＭＲ有表示 */
     ztysentakujyouhouarihyouji ,         /* （中継用）選択情報有表示 */
     ztydugktnknsntkhuhukbn ,         /* （中継用）同額転換選択方法区分 */
     ztygengakutenkankykhyj ,         /* （中継用）減額転換契約表示 */
     ztysykgycd ,         /* （中継用）職業コード */
     ztyjidoukousinkykkanyuuymd ,         /* （中継用）自動更新契約加入年月日 */
     ztysaikohtnknkykkykymd ,         /* （中継用）最古被転換契約契約年月日 */
     ztykousinmaesykyksburtkbn ,         /* （中継用）更新前主契約死亡率区分 */
     ztyhjnkykhyj ,         /* （中継用）法人契約表示 */
     ztyanniskcd ,         /* （中継用）案内先コード */
     ztyhjncd ,         /* （中継用）法人コード */
     ztyhjnjigyosyocd ,         /* （中継用）法人事業所コード */
     ztysaihokenno ,         /* （中継用）再保険番号 */
     ztydakuhikettikekkacd ,         /* （中継用）諾否決定結果コード */
     ztydai2dakuhiketteikekkacd ,         /* （中継用）第２諾否決定結果コード */
     ztypmenkbnv2 ,         /* （中継用）Ｐ免区分Ｖ２ */
     ztysiboukyuuhukin ,         /* （中継用）死亡給付金 */
     ztyjyudthumeharaitkykhkhyj ,         /* （中継用）重度痴呆前払特約付加表示 */
     ztyhaitoukbn ,         /* （中継用）配当区分 */
     ztyhhknnentysihyj ,         /* （中継用）被保険者年令調整表示 */
     ztydai2hhknnentysihyj ,         /* （中継用）第２被保険者年令調整表示 */
     ztykyksyaagetyouseihyj ,         /* （中継用）契約者年令調整表示 */
     ztykituenkbn ,         /* （中継用）喫煙区分 */
     ztykituenhonsuu ,         /* （中継用）喫煙本数 */
     ztymusentakukeiyakukbn ,         /* （中継用）無選択契約区分 */
     ztyyobiv6x2 ,         /* （中継用）予備項目Ｖ６＿２ */
     ztylivingneedstkykarihyj ,         /* （中継用）リビングニーズ特約有表示 */
     ztylivingneedssiharaihyouji ,         /* （中継用）リビングニーズ支払表示 */
     ztylnseikyuuymd ,         /* （中継用）ＬＮ請求年月日 */
     ztylnshrgenincd ,         /* （中継用）ＬＮ支払原因コード */
     ztydakuhikettisyacd ,         /* （中継用）諾否決定者コード */
     ztydai2dakuhiketteisyacd ,         /* （中継用）第２諾否決定者コード */
     ztygansapotokuyakuarihyouji ,         /* （中継用）がんサポ特約有表示 */
     ztygnspshrhyj ,         /* （中継用）がんサポ支払表示 */
     ztygansaposeikyuuymd ,         /* （中継用）がんサポ請求年月日 */
     ztygnspshrgenincd ,         /* （中継用）がんサポ支払原因コード */
     ztyyobiv3x2 ,         /* （中継用）予備項目Ｖ３＿２ */
     ztytargetmokuhyouritu ,         /* （中継用）ターゲット目標率 */
     ztyautoswitchmokuhyouritu ,         /* （中継用）オートスイッチ目標率 */
     ztytumitatekinitenarihyj ,         /* （中継用）積立金移転有表示 */
     ztytumitatekinitenkaisuu ,         /* （中継用）積立金移転回数 */
     ztydatakanrino2 ,         /* （中継用）データ管理番号２ */
     ztydatakanrino3 ,         /* （中継用）データ管理番号３ */
     ztyknkuzusnzyrttekinendo ,         /* （中継用）健康増進乗率適用年度 */
     ztyknkuzusnzyrt ,         /* （中継用）健康増進乗率 */
     ztyknkuzusnzyrtx2 ,         /* （中継用）健康増進乗率＿２ */
     ztyknkuzusnzyrtx3 ,         /* （中継用）健康増進乗率＿３ */
     ztysinkeiyakujiknkuzusnzyrt ,         /* （中継用）新契約時健康増進乗率 */
     ztytenkanjiknkuzusnzyrt ,         /* （中継用）転換時健康増進乗率 */
     ztysinkeiyakujivithkhyouji ,         /* （中継用）新契約時Ｖｉｔ保険表示 */
     ztykykjivithukusuukykhyj ,         /* （中継用）契約時Ｖｉｔ複数契約表示 */
     ztysuuriyouyobin9x2 ,         /* （中継用）数理用予備項目Ｎ９＿２ */
     ztypwrbksidhitekiyouhyj ,         /* （中継用）保険料割引制度非適用表示 */
     ztysuuriyouyobin9 ,         /* （中継用）数理用予備項目Ｎ９ */
     ztysuuriyouyobin10x7 ,         /* （中継用）数理用予備項目Ｎ１０＿７ */
     ztysuuriyouyobin10x8 ,         /* （中継用）数理用予備項目Ｎ１０＿８ */
     ztysuuriyouyobin10x9 ,         /* （中継用）数理用予備項目Ｎ１０＿９ */
     ztytumitatekinitenbubun ,         /* （中継用）積立金移転部分 */
     ztysagakusknnjynbknzndk ,         /* （中継用）差額責任準備金残高 */
     ztyyobin11x5 ,         /* （中継用）予備項目Ｎ１１＿５ */
     ztyyobin11x6 ,         /* （中継用）予備項目Ｎ１１＿６ */
     ztyyobin11x7 ,         /* （中継用）予備項目Ｎ１１＿７ */
     ztyyobin11x8 ,         /* （中継用）予備項目Ｎ１１＿８ */
     ztyyobin11x9 ,         /* （中継用）予備項目Ｎ１１＿９ */
     ztyyobin11x10 ,         /* （中継用）予備項目Ｎ１１＿１０ */
     ztyyobin11x11 ,         /* （中継用）予備項目Ｎ１１＿１１ */
     ztyyobin11x12 ,         /* （中継用）予備項目Ｎ１１＿１２ */
     ztyyobin11x13 ,         /* （中継用）予備項目Ｎ１１＿１３ */
     ztyyobin11x14 ,         /* （中継用）予備項目Ｎ１１＿１４ */
     ztyyobin11x15 ,         /* （中継用）予備項目Ｎ１１＿１５ */
     ztyyobin11x16 ,         /* （中継用）予備項目Ｎ１１＿１６ */
     ztyyobin11x17 ,         /* （中継用）予備項目Ｎ１１＿１７ */
     ztyzyrthntiyustatuskbn ,         /* （中継用）乗率判定用ステータス区分 */
     ztyzyrthntiyustatuskbnx2 ,         /* （中継用）乗率判定用ステータス区分＿２ */
     ztyzyrthntiyustatuskbnx3 ,         /* （中継用）乗率判定用ステータス区分＿３ */
     ztyzyrthntiyustatuskbnx4 ,         /* （中継用）乗率判定用ステータス区分＿４ */
     ztyzyrthntiyustatuskbnx5 ,         /* （中継用）乗率判定用ステータス区分＿５ */
     ztyyobiv10 ,         /* （中継用）予備項目Ｖ１０ */
     ztyyobiv15x2 ,         /* （中継用）予備項目Ｖ１５＿２ */
     ztyyobiv15x3 ,         /* （中継用）予備項目Ｖ１５＿３ */
     ztyyobiv15x4 ,         /* （中継用）予備項目Ｖ１５＿４ */
     ztygaikakbn ,         /* （中継用）外貨区分 */
     ztykawaserate1 ,         /* （中継用）為替レート１ */
     ztykawaseratetekiyouymd1 ,         /* （中継用）為替レート適用年月日１ */
     ztykawaserate2 ,         /* （中継用）為替レート２ */
     ztykawaseratetekiyouymd2 ,         /* （中継用）為替レート適用年月日２ */
     ztykykjikawaserate ,         /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd ,         /* （中継用）契約時為替レート適用年月日 */
     ztymvatyouseigow ,         /* （中継用）ＭＶＡ調整後Ｗ */
     ztymvakeisanjisknnjynbkn ,         /* （中継用）ＭＶＡ計算時責任準備金 */
     ztykaiyakukoujyoritu ,         /* （中継用）解約控除率 */
     ztyrendouritu ,         /* （中継用）連動率 */
     ztysrkaiyakusjkkktyouseirrt ,         /* （中継用）数理用解約時市場価格調整用利率 */
     ztysrkyksjkkktyouseiriritu ,         /* （中継用）数理用契約時市場価格調整用利率 */
     ztymvakeisankijyunymd ,         /* （中継用）ＭＶＡ計算基準年月日 */
     ztymvatyouseikou ,         /* （中継用）ＭＶＡ調整項 */
     ztyenkdtsbujsitihsyukngk ,         /* （中継用）円貨建死亡時最低保証金額 */
     ztyenkdtsbujsitihsyucost ,         /* （中継用）円貨建死亡時最低保証コスト */
     ztyenkdtsbujsitihsyuarihyj ,         /* （中継用）円貨建死亡時最低保証あり表示 */
     ztykeiyakujiyoteiriritu ,         /* （中継用）契約時予定利率 */
     ztytumitateriritu ,         /* （中継用）積立利率 */
     ztykaigomaebaraitkykarihyj ,         /* （中継用）介護前払特約あり表示 */
     ztysibouhyoukbn ,         /* （中継用）死亡表区分 */
     ztynyuukintuukakbn ,         /* （中継用）入金通貨区分 */
     ztysiharaituukakbn ,         /* （中継用）支払通貨区分 */
     ztywyendttargetmokuhyouritu ,         /* （中継用）円建Ｗターゲット目標率 */
     ztysisuurendourate ,         /* （中継用）指数連動部分割合 */
     ztysisuukbn ,         /* （中継用）指数区分 */
     ztyteirituikouhyouji ,         /* （中継用）定率移行表示 */
     ztysuuriyouyobin2x3 ,         /* （中継用）数理用予備項目Ｎ２＿３ */
     ztysuuriyouyobin10x11 ,         /* （中継用）数理用予備項目Ｎ１０＿１１ */
     ztytmttknzoukaritujygn ,         /* （中継用）積立金増加率上限 */
     ztysetteibairitu ,         /* （中継用）設定倍率 */
     ztytykzenoutouymdsisuu ,         /* （中継用）直前応当日指数 */
     ztykimatusisuu ,         /* （中継用）期末指数 */
     ztyyobiv3 ,         /* （中継用）予備項目Ｖ３ */
     ztyyenkadatekihons ,         /* （中継用）円貨建基本Ｓ */
     ztysitihsyumegkdtsibous ,         /* （中継用）最低保証前外貨建死亡Ｓ */
     ztyenkdtssrentumitatekin ,         /* （中継用）円貨建指数連動部分積立金 */
     ztysisuurentumitatekin ,         /* （中継用）指数連動部分積立金 */
     ztynksjitirttumitatekin ,         /* （中継用）年金開始時定率部分積立金 */
     ztykimatutirttumitatekin ,         /* （中継用）期末定率部分積立金 */
     ztygaikadatejyuutoup ,         /* （中継用）外貨建充当Ｐ */
     ztyyendttargetkijyunkingaku ,         /* （中継用）円建ターゲット基準金額 */
     ztyyobiv7 ,         /* （中継用）予備項目Ｖ７ */
     ztysitivkisnyukykjikwsrate ,         /* （中継用）最低Ｖ計算用契約時為替レート */
     ztysisuurentyokugotmttkn ,         /* （中継用）指数連動部分直後積立金 */
     ztyyoteiririturironbase ,         /* （中継用）予定利率（理論ベース） */
     ztyyoteiriritujtnyknbase ,         /* （中継用）予定利率（実入金ベース） */
     ztykihrkmpjtnyknbase ,         /* （中継用）既払込Ｐ（実入金ベース） */
     ztysyuptumitatekin ,         /* （中継用）主契約保険料積立金 */
     ztysyuptumitatekingsc ,         /* （中継用）主契約保険料積立金（月初） */
     ztygaikadatenkgns ,         /* （中継用）外貨建年金原資 */
     ztyjikaipjyuutouym2 ,         /* （中継用）次回Ｐ充当年月２ */
     ztysuuriyobin9 ,         /* （中継用）数理予備項目Ｎ９ */
     ztygessitumitatekin ,         /* （中継用）月始積立金 */
     ztygaikadatetougetujuutoup ,         /* （中継用）外貨建当月充当Ｐ */
     ztykihrkmpmsukisymbase ,         /* （中継用）既払込Ｐ（未収開始月ベース） */
     ztykeisanhanteiyoutmttkn ,         /* （中継用）計算判定用積立金 */
     ztygtmtv ,         /* （中継用）月末Ｖ */
     ztyzettaisibouritu ,         /* （中継用）絶対死亡率 */
     ztysoutaisibouritu ,         /* （中継用）相対死亡率 */
     ztysoutaikaiyakuritu ,         /* （中継用）相対解約率 */
     ztyvhireilritu2 ,         /* （中継用）Ｖ比例Ｌ率２ */
     ztyphireialpha ,         /* （中継用）Ｐ比例α */
     ztyphireibeta ,         /* （中継用）Ｐ比例β */
     ztyphireiganma ,         /* （中継用）Ｐ比例γ */
     ztyphireilwrbkritu ,         /* （中継用）Ｐ比例Ｌ割引率 */
     ztyyoteiriritumsukisymbase ,         /* （中継用）予定利率（未収開始月ベース） */
     ztyrrthnduhknvkisovkisnyu1 ,         /* （中継用）利率変動保険Ｖ基礎Ｖ計算用１ */
     ztyrrthnduhknvkisovkisnyu2 ,         /* （中継用）利率変動保険Ｖ基礎Ｖ計算用２ */
     ztyrrthnduhknvkisovkisnyu3 ,         /* （中継用）利率変動保険Ｖ基礎Ｖ計算用３ */
     ztyrrthnduhknvkisovkisnyu4 ,         /* （中継用）利率変動保険Ｖ基礎Ｖ計算用４ */
     ztyrrthnduhknvkiso ,         /* （中継用）利率変動保険Ｖ基礎Ｖ */
     ztytumitatekin ,         /* （中継用）積立金 */
     ztykiharaikomip ,         /* （中継用）既払込Ｐ */
     ztygaikadatesyukeiyakup ,         /* （中継用）外貨建主契約Ｐ */
     ztykykkjmmvatyouseigow ,         /* （中継用）解約控除前ＭＶＡ調整後Ｗ */
     ztyyobin11x39 ,         /* （中継用）予備項目Ｎ１１＿３９ */
     ztyyobin11x41 ,         /* （中継用）予備項目Ｎ１１＿４１ */
     ztyyobin11x42 ,         /* （中継用）予備項目Ｎ１１＿４２ */
     ztyyobin11x43 ,         /* （中継用）予備項目Ｎ１１＿４３ */
     ztyyobin11x44 ,         /* （中継用）予備項目Ｎ１１＿４４ */
     ztyyobin11x45 ,         /* （中継用）予備項目Ｎ１１＿４５ */
     ztysuuriyouyobin15x3 ,         /* （中継用）数理用予備項目Ｎ１５＿３ */
     ztysuuriyouyobin15x4 ,         /* （中継用）数理用予備項目Ｎ１５＿４ */
     ztysuuriyouyobin15x5 ,         /* （中継用）数理用予備項目Ｎ１５＿５ */
     ztysuuriyouyobin15x6 ,         /* （中継用）数理用予備項目Ｎ１５＿６ */
     ztyyobiv14 ,         /* （中継用）予備項目Ｖ１４ */
     ztykyksyhhknsydouituhyouji ,         /* （中継用）契約者被保険者同一表示 */
     ztykyksyaskinmeino ,         /* （中継用）契約者索引名番号 */
     ztygoukeikihons ,         /* （中継用）合計基本Ｓ */
     ztygoukeigyousekihyjsibous ,         /* （中継用）合計業績表示死亡Ｓ */
     ztyalmyousibous ,         /* （中継用）ＡＬＭ用死亡Ｓ */
     ztyharaikomip ,         /* （中継用）払込Ｐ */
     ztysiteizukiharaikomip ,         /* （中継用）指定月払込Ｐ */
     ztysaisyuusiteimhrkp ,         /* （中継用）最終指定月払込Ｐ */
     ztygoukeinenbaraikansanp ,         /* （中継用）合計年払換算Ｐ */
     ztygyousekihyoujisrank ,         /* （中継用）業績表示Ｓランク */
     ztyteikibairitu ,         /* （中継用）定期倍率 */
     ztytenkangodatakanrino ,         /* （中継用）転換後データ管理番号 */
     ztyaitekykdatakanrino1 ,         /* （中継用）相手契約データ管理番号１ */
     ztyaitekykdatakanrino2 ,         /* （中継用）相手契約データ管理番号２ */
     ztytnknsyokaipcashlesshyj ,         /* （中継用）転換初回Ｐキャッシュレス表示 */
     ztysyokaipannaikbn ,         /* （中継用）初回Ｐ案内区分 */
     ztyzennoukaisiymd ,         /* （中継用）前納開始年月日 */
     ztyzennoukikan ,         /* （中継用）前納期間 */
     ztyseizonkyuuhukinsiteiy ,         /* （中継用）生存給付金指定年 */
     ztyalmyouseizonkyhknsiteimd ,         /* （中継用）ＡＬＭ用生存給付金指定月日 */
     ztyjikaipjyuutouym ,         /* （中継用）次回Ｐ充当年月 */
     ztykykjiqpackhyj ,         /* （中継用）契約時Ｑパック表示 */
     ztyhktgtikkikkkn3x1 ,         /* （中継用）引継定期経過期間３＿１ */
     ztyhktgtikkikkkn3x2 ,         /* （中継用）引継定期経過期間３＿２ */
     ztyhktgtikkikkkn3x3 ,         /* （中継用）引継定期経過期間３＿３ */
     ztyhktgtikkikkkn3x4 ,         /* （中継用）引継定期経過期間３＿４ */
     ztykappadkeisankbnx1 ,         /* （中継用）カッパーＤ計算区分＿１ */
     ztykappadkeisankbnx2 ,         /* （中継用）カッパーＤ計算区分＿２ */
     ztykappadkeisankbnx3 ,         /* （中継用）カッパーＤ計算区分＿３ */
     ztykappadkeisankbnx4 ,         /* （中継用）カッパーＤ計算区分＿４ */
     ztysuuriyouyobin2 ,         /* （中継用）数理用予備項目Ｎ２ */
     ztyyobiv6x3 ,         /* （中継用）予備項目Ｖ６＿３ */
     ztykimatuvyoutumimasikin ,         /* （中継用）期末Ｖ用積増金 */
     ztykmtvyusnhknfundtmttkin ,         /* （中継用）期末Ｖ用新保険ファンド積立金 */
     ztygoukeinenkansanp3x1 ,         /* （中継用）合計年換算Ｐ３＿１ */
     ztygoukeinenkansanp3x2 ,         /* （中継用）合計年換算Ｐ３＿２ */
     ztygoukeinenkansanp3x3 ,         /* （中継用）合計年換算Ｐ３＿３ */
     ztygoukeinenkansanp3x4 ,         /* （中継用）合計年換算Ｐ３＿４ */
     ztykmtvyuhijynbritmttkin ,         /* （中継用）期末Ｖ用平準払積立金 */
     ztykimatuvyouitjbrtmttkin ,         /* （中継用）期末Ｖ用一時払積立金 */
     ztyyobin11x26 ,         /* （中継用）予備項目Ｎ１１＿２６ */
     ztyyobin11x27 ,         /* （中継用）予備項目Ｎ１１＿２７ */
     ztyyobin11x28 ,         /* （中継用）予備項目Ｎ１１＿２８ */
     ztyyobin11x29 ,         /* （中継用）予備項目Ｎ１１＿２９ */
     ztyyobin11x30 ,         /* （中継用）予備項目Ｎ１１＿３０ */
     ztyyobin11x31 ,         /* （中継用）予備項目Ｎ１１＿３１ */
     ztyyobin11x32 ,         /* （中継用）予備項目Ｎ１１＿３２ */
     ztyyobin11x33 ,         /* （中継用）予備項目Ｎ１１＿３３ */
     ztyhaitouyouloadingkijyuns ,         /* （中継用）配当用ローディング基準Ｓ */
     ztytouduketorihouhoukbn ,         /* （中継用）当Ｄ受取方法区分 */
     ztytumitated ,         /* （中継用）積立Ｄ */
     ztykariwariated ,         /* （中継用）仮割当Ｄ */
     ztytyokuzensiharaikijitu ,         /* （中継用）直前支払期日 */
     ztytyokuzentuusanhanteis ,         /* （中継用）直前通算判定Ｓ */
     ztytyokugosiharaikijitu ,         /* （中継用）直後支払期日 */
     ztytyokugotuusanhanteis ,         /* （中継用）直後通算判定Ｓ */
     ztytyokugokyuuhutaisyous ,         /* （中継用）直後給付対象Ｓ */
     ztytyokugocbkingaku ,         /* （中継用）直後ＣＢ金額 */
     ztysyokaisiharaikijitu ,         /* （中継用）初回支払期日 */
     ztysyokaituusanhanteis ,         /* （中継用）初回通算判定Ｓ */
     ztycbnayosetuusanhanteis ,         /* （中継用）ＣＢ名寄せ通算判定Ｓ */
     ztyhitenkankeiyakusuu ,         /* （中継用）被転換契約数 */
     ztygoukeipbubuntenkanteikis ,         /* （中継用）合計Ｐ部分転換定期Ｓ */
     ztysaidaihktgtikkikkkn ,         /* （中継用）最大引継定期経過期間 */
     ztysisyutnknhktgkujygk ,         /* （中継用）最終転換引継控除額 */
     ztyyobin11x34 ,         /* （中継用）予備項目Ｎ１１＿３４ */
     ztyhtnknkykkykymdx1 ,         /* （中継用）被転換契約契約年月日＿１ */
     ztytnkntkbtdkisnyusx1 ,         /* （中継用）転換特別Ｄ計算用Ｓ＿１ */
     ztytnknkaiykkujytksux1 ,         /* （中継用）転換解約控除月数＿１ */
     ztytnknkaiykkujygkx1 ,         /* （中継用）転換解約控除額＿１ */
     ztytenkanteikihyoujix1 ,         /* （中継用）転換定期表示＿１ */
     ztyhtnknkyknenknsnpx1 ,         /* （中継用）被転換契約年換算Ｐ＿１ */
     ztyhktgtikkikkknx1 ,         /* （中継用）引継定期経過期間＿１ */
     ztyhtnknkykkykymdx2 ,         /* （中継用）被転換契約契約年月日＿２ */
     ztytnkntkbtdkisnyusx2 ,         /* （中継用）転換特別Ｄ計算用Ｓ＿２ */
     ztytnknkaiykkujytksux2 ,         /* （中継用）転換解約控除月数＿２ */
     ztytnknkaiykkujygkx2 ,         /* （中継用）転換解約控除額＿２ */
     ztytenkanteikihyoujix2 ,         /* （中継用）転換定期表示＿２ */
     ztyhtnknkyknenknsnpx2 ,         /* （中継用）被転換契約年換算Ｐ＿２ */
     ztyhktgtikkikkknx2 ,         /* （中継用）引継定期経過期間＿２ */
     ztyhtnknkykkykymdx3 ,         /* （中継用）被転換契約契約年月日＿３ */
     ztytnkntkbtdkisnyusx3 ,         /* （中継用）転換特別Ｄ計算用Ｓ＿３ */
     ztytnknkaiykkujytksux3 ,         /* （中継用）転換解約控除月数＿３ */
     ztytnknkaiykkujygkx3 ,         /* （中継用）転換解約控除額＿３ */
     ztytenkanteikihyoujix3 ,         /* （中継用）転換定期表示＿３ */
     ztyhtnknkyknenknsnpx3 ,         /* （中継用）被転換契約年換算Ｐ＿３ */
     ztyhktgtikkikkknx3 ,         /* （中継用）引継定期経過期間＿３ */
     ztyhtnknkykkykymdx4 ,         /* （中継用）被転換契約契約年月日＿４ */
     ztytnkntkbtdkisnyusx4 ,         /* （中継用）転換特別Ｄ計算用Ｓ＿４ */
     ztytnknkaiykkujytksux4 ,         /* （中継用）転換解約控除月数＿４ */
     ztytnknkaiykkujygkx4 ,         /* （中継用）転換解約控除額＿４ */
     ztytenkanteikihyoujix4 ,         /* （中継用）転換定期表示＿４ */
     ztyhtnknkyknenknsnpx4 ,         /* （中継用）被転換契約年換算Ｐ＿４ */
     ztyhktgtikkikkknx4 ,         /* （中継用）引継定期経過期間＿４ */
     ztysknjyututkykkykkbn ,         /* （中継用）資金充当特約契約区分 */
     ztyswingminyuuphrkekngk ,         /* （中継用）スイング未入Ｐ振替金額 */
     ztyswingminyuuphrkejyutuym ,         /* （中継用）スイング未入Ｐ振替充当年月 */
     ztydftounendoitijitounyuup ,         /* （中継用）ＤＦ当年度一時投入Ｐ */
     ztydfkaiyakukujyhktggk ,         /* （中継用）ＤＦ解約控除引継額 */
     ztykaiyakukoujyotukisuu ,         /* （中継用）解約控除月数 */
     ztydfkaiyakuhenreikin ,         /* （中継用）ＤＦ解約返戻金 */
     ztysyuuseis ,         /* （中継用）修正Ｓ */
     ztyaatukaisyakeisyousisyacd ,         /* （中継用）Ａ扱者継承支社コード */
     ztyaatukaisyazaisekihyouji ,         /* （中継用）Ａ扱者在籍表示 */
     ztyaatukaisyabosyuujiage ,         /* （中継用）Ａ扱者募集時年令 */
     ztyaatukaisyabsyjisikakucd ,         /* （中継用）Ａ扱者募集時資格コード */
     ztyaatukaisyasikakucd ,         /* （中継用）Ａ扱者資格コード */
     ztyokyksmkuztrhkkitikbn ,         /* （中継用）お客様口座取引形態区分 */
     ztyhoyuusisyacd ,         /* （中継用）保有支社コード */
     ztysyokansisyacd ,         /* （中継用）所管支社コード */
     ztytantousyakbn ,         /* （中継用）担当者区分 */
     ztytantousyakbnnew ,         /* （中継用）担当者区分（新） */
     ztyclubsumiseikbn ,         /* （中継用）クラブスミセイ区分 */
     ztyfollowtantousyakbn ,         /* （中継用）フォロー担当者区分 */
     ztytantousyajyoutaikbn ,         /* （中継用）担当者状態区分 */
     ztykihonyoteii ,         /* （中継用）基本予定ｉ */
     ztyteikiyoteii ,         /* （中継用）定期予定ｉ */
     ztysonotayoteii ,         /* （中継用）その他予定ｉ */
     ztyitijibaraikihonyoteii ,         /* （中継用）一時払基本予定ｉ */
     ztyitijibaraiteikiyoteii ,         /* （中継用）一時払定期予定ｉ */
     ztyitijibaraisonotayoteii ,         /* （中継用）一時払その他予定ｉ */
     ztytenkankihonyoteii ,         /* （中継用）転換基本予定ｉ */
     ztytenkanteikiyoteii ,         /* （中継用）転換定期予定ｉ */
     ztyszouyoteii ,         /* （中継用）Ｓ増予定ｉ */
     ztyvestingyoteii ,         /* （中継用）ベスティング予定ｉ */
     ztysippeitokuyakuyoteii ,         /* （中継用）疾病特約予定ｉ */
     ztyseijinbyoutokuyakuyoteii ,         /* （中継用）成人病特約予定ｉ */
     ztyjyoseitokuyakuyoteii ,         /* （中継用）女性特約予定ｉ */
     ztytuuintokuyakuyoteii ,         /* （中継用）通院特約予定ｉ */
     ztysaiteihosyoui ,         /* （中継用）最低保証ｉ */
     ztyvkisoitjbrkhnyoteii ,         /* （中継用）Ｖ基礎一時払基本予定ｉ */
     ztyvkisorrtzeroikahyouji ,         /* （中継用）Ｖ基礎利率ゼロ％以下表示 */
     ztysuuriyouyobin3x2 ,         /* （中継用）数理用予備項目Ｎ３＿２ */
     ztyhoyuusisyacd2 ,         /* （中継用）保有支社コード２ */
     ztydftujyukujykisnkisiym ,         /* （中継用）ＤＦ通常控除計算期始年月 */
     ztytikikktbrijyututksu ,         /* （中継用）定期一括払充当月数 */
     ztysyunyumrtikykjtigngtkbn ,         /* （中継用）収入マル定契約時逓減型区分 */
     ztysuuriyouyobin2x2 ,         /* （中継用）数理用予備項目Ｎ２＿２ */
     ztyyobiv10x14 ,         /* （中継用）予備項目Ｖ１０＿１４ */
     ztykappadhktgkujygkx1 ,         /* （中継用）カッパーＤ引継控除額＿１ */
     ztykappadhktgkujygkx2 ,         /* （中継用）カッパーＤ引継控除額＿２ */
     ztykappadhktgkujygkx3 ,         /* （中継用）カッパーＤ引継控除額＿３ */
     ztykappadhktgkujygkx4 ,         /* （中継用）カッパーＤ引継控除額＿４ */
     ztytrkzsgkaiykkjynstmtkzndk ,         /* （中継用）取崩後解約控除なし積立金残高 */
     ztypmenkouryokuhasseiymd ,         /* （中継用）Ｐ免効力発生年月日 */
     ztysuuriyouyobin5 ,         /* （中継用）数理用予備項目Ｎ５ */
     ztysuuriyouyobin13 ,         /* （中継用）数理用予備項目Ｎ１３ */
     ztyyobin11x35 ,         /* （中継用）予備項目Ｎ１１＿３５ */
     ztyyobin11x36 ,         /* （中継用）予備項目Ｎ１１＿３６ */
     ztyyobin11x37 ,         /* （中継用）予備項目Ｎ１１＿３７ */
     ztytokuyakukoumokuv200 ,         /* （中継用）特約項目Ｖ２００ */
     ztytokuyakukoumokuv200x2 ,         /* （中継用）特約項目Ｖ２００＿２ */
     ztytokuyakukoumokuv200x3 ,         /* （中継用）特約項目Ｖ２００＿３ */
     ztytokuyakukoumokuv200x4 ,         /* （中継用）特約項目Ｖ２００＿４ */
     ztytokuyakukoumokuv200x5 ,         /* （中継用）特約項目Ｖ２００＿５ */
     ztytokuyakukoumokuv200x6 ,         /* （中継用）特約項目Ｖ２００＿６ */
     ztytokuyakukoumokuv200x7 ,         /* （中継用）特約項目Ｖ２００＿７ */
     ztytokuyakukoumokuv200x8 ,         /* （中継用）特約項目Ｖ２００＿８ */
     ztytokuyakukoumokuv200x9 ,         /* （中継用）特約項目Ｖ２００＿９ */
     ztytokuyakukoumokuv200x10 ,         /* （中継用）特約項目Ｖ２００＿１０ */
     ztytokuyakukoumokuv200x11 ,         /* （中継用）特約項目Ｖ２００＿１１ */
     ztytokuyakukoumokuv200x12 ,         /* （中継用）特約項目Ｖ２００＿１２ */
     ztytokuyakukoumokuv200x13 ,         /* （中継用）特約項目Ｖ２００＿１３ */
     ztytokuyakukoumokuv200x14 ,         /* （中継用）特約項目Ｖ２００＿１４ */
     ztytokuyakukoumokuv200x15 ,         /* （中継用）特約項目Ｖ２００＿１５ */
     ztytokuyakukoumokuv200x16 ,         /* （中継用）特約項目Ｖ２００＿１６ */
     ztytokuyakukoumokuv200x17 ,         /* （中継用）特約項目Ｖ２００＿１７ */
     ztytokuyakukoumokuv200x18 ,         /* （中継用）特約項目Ｖ２００＿１８ */
     ztytokuyakukoumokuv200x19 ,         /* （中継用）特約項目Ｖ２００＿１９ */
     ztytokuyakukoumokuv200x20 ,         /* （中継用）特約項目Ｖ２００＿２０ */
     ztytokuyakukoumokuv200x21 ,         /* （中継用）特約項目Ｖ２００＿２１ */
     ztytokuyakukoumokuv200x22 ,         /* （中継用）特約項目Ｖ２００＿２２ */
     ztytokuyakukoumokuv200x23 ,         /* （中継用）特約項目Ｖ２００＿２３ */
     ztytokuyakukoumokuv200x24 ,         /* （中継用）特約項目Ｖ２００＿２４ */
     ztytokuyakukoumokuv200x25 ,         /* （中継用）特約項目Ｖ２００＿２５ */
     ztytokuyakukoumokuv200x26 ,         /* （中継用）特約項目Ｖ２００＿２６ */
     ztytokuyakukoumokuv200x27 ,         /* （中継用）特約項目Ｖ２００＿２７ */
     ztytokuyakukoumokuv200x28 ,         /* （中継用）特約項目Ｖ２００＿２８ */
     ztytokuyakukoumokuv200x29 ,         /* （中継用）特約項目Ｖ２００＿２９ */
     ztytokuyakukoumokuv200x30 ,         /* （中継用）特約項目Ｖ２００＿３０ */
     ztytokuyakukoumokuv200x31 ,         /* （中継用）特約項目Ｖ２００＿３１ */
     ztytokuyakukoumokuv200x32 ,         /* （中継用）特約項目Ｖ２００＿３２ */
     ztytokuyakukoumokuv200x33 ,         /* （中継用）特約項目Ｖ２００＿３３ */
     ztytokuyakukoumokuv200x34 ,         /* （中継用）特約項目Ｖ２００＿３４ */
     ztytokuyakukoumokuv200x35 ,         /* （中継用）特約項目Ｖ２００＿３５ */
     ztytokuyakukoumokuv200x36 ,         /* （中継用）特約項目Ｖ２００＿３６ */
     ztytokuyakukoumokuv200x37 ,         /* （中継用）特約項目Ｖ２００＿３７ */
     ztytokuyakukoumokuv200x38 ,         /* （中継用）特約項目Ｖ２００＿３８ */
     ztytokuyakukoumokuv200x39 ,         /* （中継用）特約項目Ｖ２００＿３９ */
     ztytokuyakukoumokuv200x40 ,         /* （中継用）特約項目Ｖ２００＿４０ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_IdouMeisaiTy_Z;