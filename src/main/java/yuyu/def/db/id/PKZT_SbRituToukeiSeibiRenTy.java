package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.mapping.GenZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.GenQZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenTy;

/**
 * 死亡率統計整備後連動Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SbRituToukeiSeibiRenTy}</td><td colspan="3">死亡率統計整備後連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv12</td><td>（中継用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikbn</td><td>（中継用）処理区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoriymd</td><td>（中継用）処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfksnctr</td><td>（中継用）契約ＭＦ更新ＣＴＲ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysyorino</td><td>（中継用）処理ＮＯ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukgu</td><td>（中継用）種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykym</td><td>（中継用）契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokujyouhyouji</td><td>（中継用）特条表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyviphyouji</td><td>（中継用）ＶＩＰ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykisnkihons</td><td>（中継用）計算基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykeisansibous</td><td>（中継用）計算死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyshrs</td><td>（中継用）支払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyshrymd</td><td>（中継用）支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaisisyacd</td><td>（中継用）支払支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtgenincd</td><td>（中継用）消滅原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikaym</td><td>（中継用）経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbugenincd</td><td>（中継用）死亡原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnen</td><td>（中継用）第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tokujyouhyouji</td><td>（中継用）第２特条表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytignmrtisyukgu</td><td>（中継用）逓減マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteigenmaruteikikan</td><td>（中継用）逓減マル定期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygoukeiteigenbubuns</td><td>（中継用）合計逓減部分Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrenseimrtisyukgu</td><td>（中継用）連生マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivingneedsshrarihyj</td><td>（中継用）リビングニーズ支払有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylnkeikaym</td><td>（中継用）ＬＮ経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylnshrgenincd</td><td>（中継用）ＬＮ支払原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykituenkbn</td><td>（中継用）喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykituenhonsuu</td><td>（中継用）喫煙本数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydugktnknsntkhuhukbn</td><td>（中継用）同額転換選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjitokujyouarihyj</td><td>（中継用）契約時特条有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukousinkbn</td><td>（中継用）特約更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteigenmaruteikisiym</td><td>（中継用）逓減マル定期始年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyunyumrtisyukgu</td><td>（中継用）収入マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuunyuumaruteikikan</td><td>（中継用）収入マル定期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuunyuumrtinknengkn7</td><td>（中継用）収入マル定年金年額Ｎ７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysyuunyuumaruteikisiym</td><td>（中継用）収入マル定期始年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysysnymd</td><td>（中継用）初診年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysindanymd</td><td>（中継用）診断年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybyoumeicd1</td><td>（中継用）病名コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybyoumeicd2</td><td>（中継用）病名コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrnaiyoukbn</td><td>（中継用）支払内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygituyuknkbn1</td><td>（中継用）該当要件区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygituyuknkbn2</td><td>（中継用）該当要件区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyeiebnri1</td><td>（中継用）シェイエ分類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyeiebnri2</td><td>（中継用）シェイエ分類２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminnesotacd1</td><td>（中継用）ミネソタコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminnesotacd2</td><td>（中継用）ミネソタコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminnesotacd3</td><td>（中継用）ミネソタコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminnesotacd4</td><td>（中継用）ミネソタコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminnesotacd5</td><td>（中継用）ミネソタコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymnsisiensindanjiyuu</td><td>（中継用）慢性膵炎診断事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuhnsindanjiyuu</td><td>（中継用）肝硬変診断事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhushrkbn</td><td>（中継用）不支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhushrym</td><td>（中継用）不支払年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuunyuumrtinkshrkkn</td><td>（中継用）収入マル定年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokujyousakugenkikan</td><td>（中継用）特条削減期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygengakutenkankykhyj</td><td>（中継用）減額転換契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikomihouhou</td><td>（中継用）払込方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinsahouhou</td><td>（中継用）診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyutksytioukbn</td><td>（中継用）契約内容特殊対応区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrnduyuryumshyutn</td><td>（中継用）連動用料増標点</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhutanpobui1</td><td>（中継用）不担保部位１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtnpkkn1</td><td>（中継用）不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhutanpobui2</td><td>（中継用）不担保部位２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtnpkkn2</td><td>（中継用）不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhukasyuksyu</td><td>（中継用）付加主契約種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyoutokuyakukbn</td><td>（中継用）数理用特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuno</td><td>（中継用）特約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitoukbn</td><td>（中継用）配当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykusnmetkyksykipjyutuym</td><td>（中継用）更新前特約初回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykikjgykbn</td><td>（中継用）職域事業区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaikojincd</td><td>（中継用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanminaosikbn</td><td>（中継用）転換見直区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaijyokbn</td><td>（中継用）解除区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuruihenkouarihyouji</td><td>（中継用）種類変更有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hihokensyasonzokuhyj</td><td>（中継用）第２被保険者存続表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakukigou</td><td>（中継用）主契約記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuutohukatkhyj</td><td>（中継用）中途付加特約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoukigjyutigituymd</td><td>（中継用）要介護状態該当年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoukigjyutigeninkbn</td><td>（中継用）要介護状態原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykmtssyukahikbn</td><td>（中継用）食物摂取可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfktrsmtkahikbn</td><td>（中継用）拭き取り始末可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokoukahikbn</td><td>（中継用）歩行可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyykkahikbn</td><td>（中継用）入浴可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyihukutyakudatukahikbn</td><td>（中継用）衣服着脱可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytihougeninkbn</td><td>（中継用）痴呆原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukgusdkbn</td><td>（中継用）種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytignmrtisyukgusdkbn</td><td>（中継用）逓減マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrenseimrtisyukgusdkbn</td><td>（中継用）連生マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyunyumrtisyukgusdkbn</td><td>（中継用）収入マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykyksyuruikgusdkbn</td><td>（中継用）主契約種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhukakbn</td><td>（中継用）Ｐ免付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenkbnv2</td><td>（中継用）Ｐ免区分Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenjikohasseiymd</td><td>（中継用）Ｐ免事故発生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeirokbn</td><td>（中継用）募集経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorinov2</td><td>（中継用）処理番号Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigkyhsitihsyutkykhyj</td><td>（中継用）介護給付最低保証特約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpobui1</td><td>（中継用）Ｐ免不担保部位１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpokikan1</td><td>（中継用）Ｐ免不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpobui2</td><td>（中継用）Ｐ免不担保部位２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpokikan2</td><td>（中継用）Ｐ免不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanyujidatakanrino</td><td>（中継用）加入時データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnktgsnzkkykdatakanrino</td><td>（中継用）分割後存続契約データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkttnknkbn</td><td>（中継用）分割転換区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjiqpackhyj</td><td>（中継用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnktjisisttkarihyj</td><td>（中継用）分割時災疾特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssnskbn</td><td>（中継用）外出診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycareneedssiharaihyouji</td><td>（中継用）ケアニーズ支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnktjitiktkarihyj</td><td>（中継用）分割時定期特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinkbn</td><td>（中継用）更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyksnym</td><td>（中継用）更新年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeiyuksnhyj</td><td>（中継用）医事統計用更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikoujisnskbn</td><td>（中継用）移行時診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssytikbn</td><td>（中継用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin1</td><td>（中継用）数理用予備項目Ｎ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyimustiyusbus</td><td>（中継用）医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykeisansykykbbnkhns</td><td>（中継用）計算主契約部分基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysuuriyoubosyuukeitaikbn</td><td>（中継用）数理用募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysysnikoujiym</td><td>（中継用）終身移行時年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygnspshrhyj</td><td>（中継用）がんサポ支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygnspshrkeikaym</td><td>（中継用）がんサポ支払経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygnspshrgenincd</td><td>（中継用）がんサポ支払原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnentysihyj</td><td>（中継用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyngerkahikbn</td><td>（中継用）寝返り可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenhoutekiyouhyouji</td><td>（中継用）保険法適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteijyoutaihushrhyj</td><td>（中継用）特定状態不支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasiphkbnmnoshyouji</td><td>（中継用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisansyukeiyakup</td><td>（中継用）計算主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokubetuhosyoukikan</td><td>（中継用）特別保障期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisangoukeitenkans</td><td>（中継用）計算合計転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykeisangoukeitenkankakaku</td><td>（中継用）計算合計転換価格</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykisnwnsgukitnknkakaku</td><td>（中継用）計算Ｗなし合計転換価格</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztytnknkhnbbnjyuturt</td><td>（中継用）転換基本部分充当率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyharaizumiymd</td><td>（中継用）払済年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdsstkjytkyuhyj</td><td>（中継用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisanyoteiriritu</td><td>（中継用）計算予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyseiketuseiyoukahikbn</td><td>（中継用）清潔整容可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuurouhunoukgjyoutaikbn</td><td>（中継用）就労不能介護状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuurouhunoujyoutaikbn</td><td>（中継用）就労不能状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiznkyhsyoubyouhasseiymd</td><td>（中継用）生前給付傷病発生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyusisnknkuskgitukbn</td><td>（中継用）急性心筋梗塞該当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynousottyuugaitoukbn</td><td>（中継用）脳卒中該当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjinhuzengaitoukbn</td><td>（中継用）腎不全該当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydoumyakusikkangaitoukbn</td><td>（中継用）動脈疾患該当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino2</td><td>（中継用）データ管理番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino3</td><td>（中継用）データ管理番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkeiyakujivithkhyouji</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrttekitkarihyj</td><td>（中継用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrtsiyounendo</td><td>（中継用）健康増進乗率使用年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrt</td><td>（中継用）健康増進乗率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvittkykkaiyakuymd</td><td>（中継用）Ｖｉｔ特約解約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwrbksidhitekiyouhyj</td><td>（中継用）保険料割引制度非適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynintisyougeninkbn</td><td>（中継用）認知症原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin1x2</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x3</td><td>（中継用）数理用予備項目Ｎ８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x4</td><td>（中継用）数理用予備項目Ｎ８＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x5</td><td>（中継用）数理用予備項目Ｎ８＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x6</td><td>（中継用）数理用予備項目Ｎ８＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x7</td><td>（中継用）数理用予備項目Ｎ８＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x8</td><td>（中継用）数理用予備項目Ｎ８＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x9</td><td>（中継用）数理用予備項目Ｎ８＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8x10</td><td>（中継用）数理用予備項目Ｎ８＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin7</td><td>（中継用）予備項目Ｎ７</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin7x2</td><td>（中継用）予備項目Ｎ７＿２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin7x3</td><td>（中継用）予備項目Ｎ７＿３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin7x4</td><td>（中継用）予備項目Ｎ７＿４</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin7x5</td><td>（中継用）予備項目Ｎ７＿５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbn</td><td>（中継用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv59</td><td>（中継用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikadatekihons</td><td>（中継用）外貨建基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesibous</td><td>（中継用）外貨建死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaserate</td><td>（中継用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysrdai1hknkkn</td><td>（中継用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin8</td><td>（中継用）数理用予備項目Ｎ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x2</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukasyukbn</td><td>（中継用）通貨種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SbRituToukeiSeibiRenTy
 * @see     GenZT_SbRituToukeiSeibiRenTy
 * @see     QZT_SbRituToukeiSeibiRenTy
 * @see     GenQZT_SbRituToukeiSeibiRenTy
 */
public class PKZT_SbRituToukeiSeibiRenTy extends AbstractExDBPrimaryKey<ZT_SbRituToukeiSeibiRenTy, PKZT_SbRituToukeiSeibiRenTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SbRituToukeiSeibiRenTy() {
    }

    public PKZT_SbRituToukeiSeibiRenTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_SbRituToukeiSeibiRenTy> getEntityClass() {
        return ZT_SbRituToukeiSeibiRenTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}