package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.id.PKZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.GenQZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenTy;

/**
 * 死亡率統計整備後連動Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SbRituToukeiSeibiRenTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SbRituToukeiSeibiRenTy}</td><td colspan="3">死亡率統計整備後連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_SbRituToukeiSeibiRenTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikbn ztysyorikbn}</td><td>（中継用）処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctr ztykykmfksnctr}</td><td>（中継用）契約ＭＦ更新ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyorino ztysyorino}</td><td>（中継用）処理ＮＯ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukgu ztysyukgu}</td><td>（中継用）種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykym ztykykym}</td><td>（中継用）契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokujyouhyouji ztytokujyouhyouji}</td><td>（中継用）特条表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyviphyouji ztyviphyouji}</td><td>（中継用）ＶＩＰ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykisnkihons ztykisnkihons}</td><td>（中継用）計算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykeisansibous ztykeisansibous}</td><td>（中継用）計算死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyshrs ztyshrs}</td><td>（中継用）支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyshrymd ztyshrymd}</td><td>（中継用）支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaisisyacd ztysiharaisisyacd}</td><td>（中継用）支払支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtgenincd ztysymtgenincd}</td><td>（中継用）消滅原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikaym ztykeikaym}</td><td>（中継用）経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbugenincd ztysbugenincd}</td><td>（中継用）死亡原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnen ztydai2hhknnen}</td><td>（中継用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tokujyouhyouji ztydai2tokujyouhyouji}</td><td>（中継用）第２特条表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtisyukgu ztytignmrtisyukgu}</td><td>（中継用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikikan ztyteigenmaruteikikan}</td><td>（中継用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeiteigenbubuns ztygoukeiteigenbubuns}</td><td>（中継用）合計逓減部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrenseimrtisyukgu ztyrenseimrtisyukgu}</td><td>（中継用）連生マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedsshrarihyj ztylivingneedsshrarihyj}</td><td>（中継用）リビングニーズ支払有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylnkeikaym ztylnkeikaym}</td><td>（中継用）ＬＮ経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylnshrgenincd ztylnshrgenincd}</td><td>（中継用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenkbn ztykituenkbn}</td><td>（中継用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenhonsuu ztykituenhonsuu}</td><td>（中継用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydugktnknsntkhuhukbn ztydugktnknsntkhuhukbn}</td><td>（中継用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjitokujyouarihyj ztykykjitokujyouarihyj}</td><td>（中継用）契約時特条有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukousinkbn ztytokuyakukousinkbn}</td><td>（中継用）特約更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikisiym ztyteigenmaruteikisiym}</td><td>（中継用）逓減マル定期始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyunyumrtisyukgu ztysyunyumrtisyukgu}</td><td>（中継用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumaruteikikan ztysyuunyuumaruteikikan}</td><td>（中継用）収入マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtinknengkn7 ztysyuunyuumrtinknengkn7}</td><td>（中継用）収入マル定年金年額Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumaruteikisiym ztysyuunyuumaruteikisiym}</td><td>（中継用）収入マル定期始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysysnymd ztysysnymd}</td><td>（中継用）初診年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysindanymd ztysindanymd}</td><td>（中継用）診断年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybyoumeicd1 ztybyoumeicd1}</td><td>（中継用）病名コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybyoumeicd2 ztybyoumeicd2}</td><td>（中継用）病名コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnaiyoukbn ztyshrnaiyoukbn}</td><td>（中継用）支払内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygituyuknkbn1 ztygituyuknkbn1}</td><td>（中継用）該当要件区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygituyuknkbn2 ztygituyuknkbn2}</td><td>（中継用）該当要件区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyeiebnri1 ztysyeiebnri1}</td><td>（中継用）シェイエ分類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyeiebnri2 ztysyeiebnri2}</td><td>（中継用）シェイエ分類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminnesotacd1 ztyminnesotacd1}</td><td>（中継用）ミネソタコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminnesotacd2 ztyminnesotacd2}</td><td>（中継用）ミネソタコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminnesotacd3 ztyminnesotacd3}</td><td>（中継用）ミネソタコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminnesotacd4 ztyminnesotacd4}</td><td>（中継用）ミネソタコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminnesotacd5 ztyminnesotacd5}</td><td>（中継用）ミネソタコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsisiensindanjiyuu ztymnsisiensindanjiyuu}</td><td>（中継用）慢性膵炎診断事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuhnsindanjiyuu ztyknkuhnsindanjiyuu}</td><td>（中継用）肝硬変診断事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhushrkbn ztyhushrkbn}</td><td>（中継用）不支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhushrym ztyhushrym}</td><td>（中継用）不支払年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtinkshrkkn ztysyuunyuumrtinkshrkkn}</td><td>（中継用）収入マル定年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokujyousakugenkikan ztytokujyousakugenkikan}</td><td>（中継用）特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakutenkankykhyj ztygengakutenkankykhyj}</td><td>（中継用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikomihouhou ztyharaikomihouhou}</td><td>（中継用）払込方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsahouhou ztysinsahouhou}</td><td>（中継用）診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyutksytioukbn ztykykniyutksytioukbn}</td><td>（中継用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnduyuryumshyutn ztyrnduyuryumshyutn}</td><td>（中継用）連動用料増標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanpobui1 ztyhutanpobui1}</td><td>（中継用）不担保部位１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn1 ztyhtnpkkn1}</td><td>（中継用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanpobui2 ztyhutanpobui2}</td><td>（中継用）不担保部位２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn2 ztyhtnpkkn2}</td><td>（中継用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukasyuksyu ztyhukasyuksyu}</td><td>（中継用）付加主契約種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyoutokuyakukbn ztysuuriyoutokuyakukbn}</td><td>（中継用）数理用特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuno ztytokuyakuno}</td><td>（中継用）特約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykusnmetkyksykipjyutuym ztykusnmetkyksykipjyutuym}</td><td>（中継用）更新前特約初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykikjgykbn ztysykikjgykbn}</td><td>（中継用）職域事業区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanminaosikbn ztytenkanminaosikbn}</td><td>（中継用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaijyokbn ztykaijyokbn}</td><td>（中継用）解除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuruihenkouarihyouji ztysyuruihenkouarihyouji}</td><td>（中継用）種類変更有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyasonzokuhyj ztydai2hihokensyasonzokuhyj}</td><td>（中継用）第２被保険者存続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukigou ztysyukeiyakukigou}</td><td>（中継用）主契約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuutohukatkhyj ztytyuutohukatkhyj}</td><td>（中継用）中途付加特約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoukigjyutigituymd ztyyoukigjyutigituymd}</td><td>（中継用）要介護状態該当年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoukigjyutigeninkbn ztyyoukigjyutigeninkbn}</td><td>（中継用）要介護状態原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykmtssyukahikbn ztysykmtssyukahikbn}</td><td>（中継用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfktrsmtkahikbn ztyfktrsmtkahikbn}</td><td>（中継用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokoukahikbn ztyhokoukahikbn}</td><td>（中継用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyykkahikbn ztynyykkahikbn}</td><td>（中継用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyihukutyakudatukahikbn ztyihukutyakudatukahikbn}</td><td>（中継用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytihougeninkbn ztytihougeninkbn}</td><td>（中継用）痴呆原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukgusdkbn ztysyukgusdkbn}</td><td>（中継用）種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtisyukgusdkbn ztytignmrtisyukgusdkbn}</td><td>（中継用）逓減マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrenseimrtisyukgusdkbn ztyrenseimrtisyukgusdkbn}</td><td>（中継用）連生マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyunyumrtisyukgusdkbn ztysyunyumrtisyukgusdkbn}</td><td>（中継用）収入マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykyksyuruikgusdkbn ztysykyksyuruikgusdkbn}</td><td>（中継用）主契約種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhukakbn ztypmenhukakbn}</td><td>（中継用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv2 ztypmenkbnv2}</td><td>（中継用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenjikohasseiymd ztypmenjikohasseiymd}</td><td>（中継用）Ｐ免事故発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeirokbn ztybosyuukeirokbn}</td><td>（中継用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorinov2 ztysyorinov2}</td><td>（中継用）処理番号Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigkyhsitihsyutkykhyj ztykigkyhsitihsyutkykhyj}</td><td>（中継用）介護給付最低保証特約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpobui1 ztypmenhutanpobui1}</td><td>（中継用）Ｐ免不担保部位１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpokikan1 ztypmenhutanpokikan1}</td><td>（中継用）Ｐ免不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpobui2 ztypmenhutanpobui2}</td><td>（中継用）Ｐ免不担保部位２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpokikan2 ztypmenhutanpokikan2}</td><td>（中継用）Ｐ免不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyujidatakanrino ztykanyujidatakanrino}</td><td>（中継用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktgsnzkkykdatakanrino ztybnktgsnzkkykdatakanrino}</td><td>（中継用）分割後存続契約データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkttnknkbn ztybnkttnknkbn}</td><td>（中継用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktjisisttkarihyj ztybnktjisisttkarihyj}</td><td>（中継用）分割時災疾特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssnskbn ztystdssnskbn}</td><td>（中継用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycareneedssiharaihyouji ztycareneedssiharaihyouji}</td><td>（中継用）ケアニーズ支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktjitiktkarihyj ztybnktjitiktkarihyj}</td><td>（中継用）分割時定期特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinkbn ztykousinkbn}</td><td>（中継用）更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyksnym ztyksnym}</td><td>（中継用）更新年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeiyuksnhyj ztyijitoukeiyuksnhyj}</td><td>（中継用）医事統計用更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikoujisnskbn ztyikoujisnskbn}</td><td>（中継用）移行時診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1 ztysuuriyouyobin1}</td><td>（中継用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyimustiyusbus ztyimustiyusbus}</td><td>（中継用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykeisansykykbbnkhns ztykeisansykykbbnkhns}</td><td>（中継用）計算主契約部分基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyoubosyuukeitaikbn ztysuuriyoubosyuukeitaikbn}</td><td>（中継用）数理用募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysysnikoujiym ztysysnikoujiym}</td><td>（中継用）終身移行時年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnspshrhyj ztygnspshrhyj}</td><td>（中継用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnspshrkeikaym ztygnspshrkeikaym}</td><td>（中継用）がんサポ支払経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnspshrgenincd ztygnspshrgenincd}</td><td>（中継用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyngerkahikbn ztyngerkahikbn}</td><td>（中継用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokenhoutekiyouhyouji ztyhokenhoutekiyouhyouji}</td><td>（中継用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisansyukeiyakup ztykeisansyukeiyakup}</td><td>（中継用）計算主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisangoukeitenkans ztykeisangoukeitenkans}</td><td>（中継用）計算合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykeisangoukeitenkankakaku ztykeisangoukeitenkankakaku}</td><td>（中継用）計算合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykisnwnsgukitnknkakaku ztykisnwnsgukitnknkakaku}</td><td>（中継用）計算Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytnknkhnbbnjyuturt ztytnknkhnbbnjyuturt}</td><td>（中継用）転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyharaizumiymd ztyharaizumiymd}</td><td>（中継用）払済年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdsstkjytkyuhyj ztystdsstkjytkyuhyj}</td><td>（中継用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisanyoteiriritu ztykeisanyoteiriritu}</td><td>（中継用）計算予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyseiketuseiyoukahikbn ztyseiketuseiyoukahikbn}</td><td>（中継用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuurouhunoukgjyoutaikbn ztysyuurouhunoukgjyoutaikbn}</td><td>（中継用）就労不能介護状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuurouhunoujyoutaikbn ztysyuurouhunoujyoutaikbn}</td><td>（中継用）就労不能状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznkyhsyoubyouhasseiymd ztysiznkyhsyoubyouhasseiymd}</td><td>（中継用）生前給付傷病発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyusisnknkuskgitukbn ztykyusisnknkuskgitukbn}</td><td>（中継用）急性心筋梗塞該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynousottyuugaitoukbn ztynousottyuugaitoukbn}</td><td>（中継用）脳卒中該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjinhuzengaitoukbn ztyjinhuzengaitoukbn}</td><td>（中継用）腎不全該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydoumyakusikkangaitoukbn ztydoumyakusikkangaitoukbn}</td><td>（中継用）動脈疾患該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino2 ztydatakanrino2}</td><td>（中継用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino3 ztydatakanrino3}</td><td>（中継用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujivithkhyouji ztysinkeiyakujivithkhyouji}</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtsiyounendo ztyknkuzusnzyrtsiyounendo}</td><td>（中継用）健康増進乗率使用年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvittkykkaiyakuymd ztyvittkykkaiyakuymd}</td><td>（中継用）Ｖｉｔ特約解約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwrbksidhitekiyouhyj ztypwrbksidhitekiyouhyj}</td><td>（中継用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynintisyougeninkbn ztynintisyougeninkbn}</td><td>（中継用）認知症原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x2 ztysuuriyouyobin1x2}</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x3 ztysuuriyouyobin8x3}</td><td>（中継用）数理用予備項目Ｎ８＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x4 ztysuuriyouyobin8x4}</td><td>（中継用）数理用予備項目Ｎ８＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x5 ztysuuriyouyobin8x5}</td><td>（中継用）数理用予備項目Ｎ８＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x6 ztysuuriyouyobin8x6}</td><td>（中継用）数理用予備項目Ｎ８＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x7 ztysuuriyouyobin8x7}</td><td>（中継用）数理用予備項目Ｎ８＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x8 ztysuuriyouyobin8x8}</td><td>（中継用）数理用予備項目Ｎ８＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x9 ztysuuriyouyobin8x9}</td><td>（中継用）数理用予備項目Ｎ８＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x10 ztysuuriyouyobin8x10}</td><td>（中継用）数理用予備項目Ｎ８＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin7 ztyyobin7}</td><td>（中継用）予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x2 ztyyobin7x2}</td><td>（中継用）予備項目Ｎ７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x3 ztyyobin7x3}</td><td>（中継用）予備項目Ｎ７＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x4 ztyyobin7x4}</td><td>（中継用）予備項目Ｎ７＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x5 ztyyobin7x5}</td><td>（中継用）予備項目Ｎ７＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv59 ztyyobiv59}</td><td>（中継用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikadatekihons ztygaikadatekihons}</td><td>（中継用）外貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesibous ztygaikadatesibous}</td><td>（中継用）外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SbRituToukeiSeibiRenTy
 * @see     PKZT_SbRituToukeiSeibiRenTy
 * @see     QZT_SbRituToukeiSeibiRenTy
 * @see     GenQZT_SbRituToukeiSeibiRenTy
 */
@MappedSuperclass
@Table(name=GenZT_SbRituToukeiSeibiRenTy.TABLE_NAME)
@IdClass(value=PKZT_SbRituToukeiSeibiRenTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SbRituToukeiSeibiRenTy extends AbstractExDBEntity<ZT_SbRituToukeiSeibiRenTy, PKZT_SbRituToukeiSeibiRenTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SbRituToukeiSeibiRenTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYSYORIKBN              = "ztysyorikbn";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYKYKMFKSNCTR           = "ztykykmfksnctr";
    public static final String ZTYSYORINO               = "ztysyorino";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYSYUKGU                = "ztysyukgu";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKYKYM                 = "ztykykym";
    public static final String ZTYTOKUJYOUHYOUJI        = "ztytokujyouhyouji";
    public static final String ZTYVIPHYOUJI             = "ztyviphyouji";
    public static final String ZTYKISNKIHONS            = "ztykisnkihons";
    public static final String ZTYKEISANSIBOUS          = "ztykeisansibous";
    public static final String ZTYSHRS                  = "ztyshrs";
    public static final String ZTYSHRYMD                = "ztyshrymd";
    public static final String ZTYSIHARAISISYACD        = "ztysiharaisisyacd";
    public static final String ZTYSYMTGENINCD           = "ztysymtgenincd";
    public static final String ZTYKEIKAYM               = "ztykeikaym";
    public static final String ZTYSBUGENINCD            = "ztysbugenincd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYDAI2HHKNNEN           = "ztydai2hhknnen";
    public static final String ZTYDAI2TOKUJYOUHYOUJI    = "ztydai2tokujyouhyouji";
    public static final String ZTYTIGNMRTISYUKGU        = "ztytignmrtisyukgu";
    public static final String ZTYTEIGENMARUTEIKIKAN    = "ztyteigenmaruteikikan";
    public static final String ZTYGOUKEITEIGENBUBUNS    = "ztygoukeiteigenbubuns";
    public static final String ZTYRENSEIMRTISYUKGU      = "ztyrenseimrtisyukgu";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYLIVINGNEEDSSHRARIHYJ  = "ztylivingneedsshrarihyj";
    public static final String ZTYLNKEIKAYM             = "ztylnkeikaym";
    public static final String ZTYLNSHRGENINCD          = "ztylnshrgenincd";
    public static final String ZTYKITUENKBN             = "ztykituenkbn";
    public static final String ZTYKITUENHONSUU          = "ztykituenhonsuu";
    public static final String ZTYDUGKTNKNSNTKHUHUKBN   = "ztydugktnknsntkhuhukbn";
    public static final String ZTYKYKJITOKUJYOUARIHYJ   = "ztykykjitokujyouarihyj";
    public static final String ZTYTOKUYAKUKOUSINKBN     = "ztytokuyakukousinkbn";
    public static final String ZTYTEIGENMARUTEIKISIYM   = "ztyteigenmaruteikisiym";
    public static final String ZTYSYUNYUMRTISYUKGU      = "ztysyunyumrtisyukgu";
    public static final String ZTYSYUUNYUUMARUTEIKIKAN  = "ztysyuunyuumaruteikikan";
    public static final String ZTYSYUUNYUUMRTINKNENGKN7 = "ztysyuunyuumrtinknengkn7";
    public static final String ZTYSYUUNYUUMARUTEIKISIYM = "ztysyuunyuumaruteikisiym";
    public static final String ZTYSYSNYMD               = "ztysysnymd";
    public static final String ZTYSINDANYMD             = "ztysindanymd";
    public static final String ZTYBYOUMEICD1            = "ztybyoumeicd1";
    public static final String ZTYBYOUMEICD2            = "ztybyoumeicd2";
    public static final String ZTYSHRNAIYOUKBN          = "ztyshrnaiyoukbn";
    public static final String ZTYGITUYUKNKBN1          = "ztygituyuknkbn1";
    public static final String ZTYGITUYUKNKBN2          = "ztygituyuknkbn2";
    public static final String ZTYSYEIEBNRI1            = "ztysyeiebnri1";
    public static final String ZTYSYEIEBNRI2            = "ztysyeiebnri2";
    public static final String ZTYMINNESOTACD1          = "ztyminnesotacd1";
    public static final String ZTYMINNESOTACD2          = "ztyminnesotacd2";
    public static final String ZTYMINNESOTACD3          = "ztyminnesotacd3";
    public static final String ZTYMINNESOTACD4          = "ztyminnesotacd4";
    public static final String ZTYMINNESOTACD5          = "ztyminnesotacd5";
    public static final String ZTYMNSISIENSINDANJIYUU   = "ztymnsisiensindanjiyuu";
    public static final String ZTYKNKUHNSINDANJIYUU     = "ztyknkuhnsindanjiyuu";
    public static final String ZTYHUSHRKBN              = "ztyhushrkbn";
    public static final String ZTYHUSHRYM               = "ztyhushrym";
    public static final String ZTYSYUUNYUUMRTINKSHRKKN  = "ztysyuunyuumrtinkshrkkn";
    public static final String ZTYTOKUJYOUSAKUGENKIKAN  = "ztytokujyousakugenkikan";
    public static final String ZTYGENGAKUTENKANKYKHYJ   = "ztygengakutenkankykhyj";
    public static final String ZTYHARAIKOMIHOUHOU       = "ztyharaikomihouhou";
    public static final String ZTYSINSAHOUHOU           = "ztysinsahouhou";
    public static final String ZTYKYKNIYUTKSYTIOUKBN    = "ztykykniyutksytioukbn";
    public static final String ZTYRNDUYURYUMSHYUTN      = "ztyrnduyuryumshyutn";
    public static final String ZTYHUTANPOBUI1           = "ztyhutanpobui1";
    public static final String ZTYHTNPKKN1              = "ztyhtnpkkn1";
    public static final String ZTYHUTANPOBUI2           = "ztyhutanpobui2";
    public static final String ZTYHTNPKKN2              = "ztyhtnpkkn2";
    public static final String ZTYHUKASYUKSYU           = "ztyhukasyuksyu";
    public static final String ZTYSUURIYOUTOKUYAKUKBN   = "ztysuuriyoutokuyakukbn";
    public static final String ZTYTOKUYAKUNO            = "ztytokuyakuno";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYKUSNMETKYKSYKIPJYUTUYM = "ztykusnmetkyksykipjyutuym";
    public static final String ZTYSYKIKJGYKBN           = "ztysykikjgykbn";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYTENKANMINAOSIKBN      = "ztytenkanminaosikbn";
    public static final String ZTYKAIJYOKBN             = "ztykaijyokbn";
    public static final String ZTYSYURUIHENKOUARIHYOUJI = "ztysyuruihenkouarihyouji";
    public static final String ZTYDAI2HIHOKENSYASONZOKUHYJ = "ztydai2hihokensyasonzokuhyj";
    public static final String ZTYSYUKEIYAKUKIGOU       = "ztysyukeiyakukigou";
    public static final String ZTYSYMTYMD               = "ztysymtymd";
    public static final String ZTYTYUUTOHUKATKHYJ       = "ztytyuutohukatkhyj";
    public static final String ZTYYOUKIGJYUTIGITUYMD    = "ztyyoukigjyutigituymd";
    public static final String ZTYYOUKIGJYUTIGENINKBN   = "ztyyoukigjyutigeninkbn";
    public static final String ZTYSYKMTSSYUKAHIKBN      = "ztysykmtssyukahikbn";
    public static final String ZTYFKTRSMTKAHIKBN        = "ztyfktrsmtkahikbn";
    public static final String ZTYHOKOUKAHIKBN          = "ztyhokoukahikbn";
    public static final String ZTYNYYKKAHIKBN           = "ztynyykkahikbn";
    public static final String ZTYIHUKUTYAKUDATUKAHIKBN = "ztyihukutyakudatukahikbn";
    public static final String ZTYTIHOUGENINKBN         = "ztytihougeninkbn";
    public static final String ZTYSYUKGUSDKBN           = "ztysyukgusdkbn";
    public static final String ZTYTIGNMRTISYUKGUSDKBN   = "ztytignmrtisyukgusdkbn";
    public static final String ZTYRENSEIMRTISYUKGUSDKBN = "ztyrenseimrtisyukgusdkbn";
    public static final String ZTYSYUNYUMRTISYUKGUSDKBN = "ztysyunyumrtisyukgusdkbn";
    public static final String ZTYSYKYKSYURUIKGUSDKBN   = "ztysykyksyuruikgusdkbn";
    public static final String ZTYPMENHUKAKBN           = "ztypmenhukakbn";
    public static final String ZTYPMENKBNV2             = "ztypmenkbnv2";
    public static final String ZTYPMENJIKOHASSEIYMD     = "ztypmenjikohasseiymd";
    public static final String ZTYBOSYUUKEIROKBN        = "ztybosyuukeirokbn";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYSYORINOV2             = "ztysyorinov2";
    public static final String ZTYKIGKYHSITIHSYUTKYKHYJ = "ztykigkyhsitihsyutkykhyj";
    public static final String ZTYPMENHUTANPOBUI1       = "ztypmenhutanpobui1";
    public static final String ZTYPMENHUTANPOKIKAN1     = "ztypmenhutanpokikan1";
    public static final String ZTYPMENHUTANPOBUI2       = "ztypmenhutanpobui2";
    public static final String ZTYPMENHUTANPOKIKAN2     = "ztypmenhutanpokikan2";
    public static final String ZTYKANYUJIDATAKANRINO    = "ztykanyujidatakanrino";
    public static final String ZTYBNKTGSNZKKYKDATAKANRINO = "ztybnktgsnzkkykdatakanrino";
    public static final String ZTYBNKTTNKNKBN           = "ztybnkttnknkbn";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYBNKTJISISTTKARIHYJ    = "ztybnktjisisttkarihyj";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSTDSSNSKBN            = "ztystdssnskbn";
    public static final String ZTYCARENEEDSSIHARAIHYOUJI = "ztycareneedssiharaihyouji";
    public static final String ZTYBNKTJITIKTKARIHYJ     = "ztybnktjitiktkarihyj";
    public static final String ZTYKOUSINKBN             = "ztykousinkbn";
    public static final String ZTYKSNYM                 = "ztyksnym";
    public static final String ZTYIJITOUKEIYUKSNHYJ     = "ztyijitoukeiyuksnhyj";
    public static final String ZTYIKOUJISNSKBN          = "ztyikoujisnskbn";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYSUURIYOUYOBIN1        = "ztysuuriyouyobin1";
    public static final String ZTYIMUSTIYUSBUS          = "ztyimustiyusbus";
    public static final String ZTYKEISANSYKYKBBNKHNS    = "ztykeisansykykbbnkhns";
    public static final String ZTYSUURIYOUBOSYUUKEITAIKBN = "ztysuuriyoubosyuukeitaikbn";
    public static final String ZTYSYSNIKOUJIYM          = "ztysysnikoujiym";
    public static final String ZTYGNSPSHRHYJ            = "ztygnspshrhyj";
    public static final String ZTYGNSPSHRKEIKAYM        = "ztygnspshrkeikaym";
    public static final String ZTYGNSPSHRGENINCD        = "ztygnspshrgenincd";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYNGERKAHIKBN           = "ztyngerkahikbn";
    public static final String ZTYHOKENHOUTEKIYOUHYOUJI = "ztyhokenhoutekiyouhyouji";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYKEISANSYUKEIYAKUP     = "ztykeisansyukeiyakup";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYKEISANGOUKEITENKANS   = "ztykeisangoukeitenkans";
    public static final String ZTYKEISANGOUKEITENKANKAKAKU = "ztykeisangoukeitenkankakaku";
    public static final String ZTYKISNWNSGUKITNKNKAKAKU = "ztykisnwnsgukitnknkakaku";
    public static final String ZTYTNKNKHNBBNJYUTURT     = "ztytnknkhnbbnjyuturt";
    public static final String ZTYHARAIZUMIYMD          = "ztyharaizumiymd";
    public static final String ZTYSTDSSTKJYTKYUHYJ      = "ztystdsstkjytkyuhyj";
    public static final String ZTYKEISANYOTEIRIRITU     = "ztykeisanyoteiriritu";
    public static final String ZTYSEIKETUSEIYOUKAHIKBN  = "ztyseiketuseiyoukahikbn";
    public static final String ZTYSYUUROUHUNOUKGJYOUTAIKBN = "ztysyuurouhunoukgjyoutaikbn";
    public static final String ZTYSYUUROUHUNOUJYOUTAIKBN = "ztysyuurouhunoujyoutaikbn";
    public static final String ZTYSIZNKYHSYOUBYOUHASSEIYMD = "ztysiznkyhsyoubyouhasseiymd";
    public static final String ZTYKYUSISNKNKUSKGITUKBN  = "ztykyusisnknkuskgitukbn";
    public static final String ZTYNOUSOTTYUUGAITOUKBN   = "ztynousottyuugaitoukbn";
    public static final String ZTYJINHUZENGAITOUKBN     = "ztyjinhuzengaitoukbn";
    public static final String ZTYDOUMYAKUSIKKANGAITOUKBN = "ztydoumyakusikkangaitoukbn";
    public static final String ZTYDATAKANRINO2          = "ztydatakanrino2";
    public static final String ZTYDATAKANRINO3          = "ztydatakanrino3";
    public static final String ZTYSINKEIYAKUJIVITHKHYOUJI = "ztysinkeiyakujivithkhyouji";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYKNKUZUSNZYRTSIYOUNENDO = "ztyknkuzusnzyrtsiyounendo";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYVITTKYKKAIYAKUYMD     = "ztyvittkykkaiyakuymd";
    public static final String ZTYPWRBKSIDHITEKIYOUHYJ  = "ztypwrbksidhitekiyouhyj";
    public static final String ZTYNINTISYOUGENINKBN     = "ztynintisyougeninkbn";
    public static final String ZTYSUURIYOUYOBIN1X2      = "ztysuuriyouyobin1x2";
    public static final String ZTYSUURIYOUYOBIN8X3      = "ztysuuriyouyobin8x3";
    public static final String ZTYSUURIYOUYOBIN8X4      = "ztysuuriyouyobin8x4";
    public static final String ZTYSUURIYOUYOBIN8X5      = "ztysuuriyouyobin8x5";
    public static final String ZTYSUURIYOUYOBIN8X6      = "ztysuuriyouyobin8x6";
    public static final String ZTYSUURIYOUYOBIN8X7      = "ztysuuriyouyobin8x7";
    public static final String ZTYSUURIYOUYOBIN8X8      = "ztysuuriyouyobin8x8";
    public static final String ZTYSUURIYOUYOBIN8X9      = "ztysuuriyouyobin8x9";
    public static final String ZTYSUURIYOUYOBIN8X10     = "ztysuuriyouyobin8x10";
    public static final String ZTYYOBIN7                = "ztyyobin7";
    public static final String ZTYYOBIN7X2              = "ztyyobin7x2";
    public static final String ZTYYOBIN7X3              = "ztyyobin7x3";
    public static final String ZTYYOBIN7X4              = "ztyyobin7x4";
    public static final String ZTYYOBIN7X5              = "ztyyobin7x5";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYYOBIV59               = "ztyyobiv59";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYGAIKADATEKIHONS       = "ztygaikadatekihons";
    public static final String ZTYGAIKADATESIBOUS       = "ztygaikadatesibous";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIV4                = "ztyyobiv4";

    private final PKZT_SbRituToukeiSeibiRenTy primaryKey;

    public GenZT_SbRituToukeiSeibiRenTy() {
        primaryKey = new PKZT_SbRituToukeiSeibiRenTy();
    }

    public GenZT_SbRituToukeiSeibiRenTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_SbRituToukeiSeibiRenTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_SbRituToukeiSeibiRenTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SbRituToukeiSeibiRenTy> getMetaClass() {
        return QZT_SbRituToukeiSeibiRenTy.class;
    }

    @Id
    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztyyobiv12;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztysyorikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYORIKBN)
    public String getZtysyorikbn() {
        return ztysyorikbn;
    }

    public void setZtysyorikbn(String pZtysyorikbn) {
        ztysyorikbn = pZtysyorikbn;
    }

    private String ztysyoriymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }

    private Integer ztykykmfksnctr;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYKMFKSNCTR)
    public Integer getZtykykmfksnctr() {
        return ztykykmfksnctr;
    }

    public void setZtykykmfksnctr(Integer pZtykykmfksnctr) {
        ztykykmfksnctr = pZtykykmfksnctr;
    }

    private String ztysyorino;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYORINO)
    public String getZtysyorino() {
        return ztysyorino;
    }

    public void setZtysyorino(String pZtysyorino) {
        ztysyorino = pZtysyorino;
    }

    private String ztysyoricd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztysyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUKGU)
    public String getZtysyukgu() {
        return ztysyukgu;
    }

    public void setZtysyukgu(String pZtysyukgu) {
        ztysyukgu = pZtysyukgu;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztykykym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYKYM)
    public String getZtykykym() {
        return ztykykym;
    }

    public void setZtykykym(String pZtykykym) {
        ztykykym = pZtykykym;
    }

    private String ztytokujyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUJYOUHYOUJI)
    public String getZtytokujyouhyouji() {
        return ztytokujyouhyouji;
    }

    public void setZtytokujyouhyouji(String pZtytokujyouhyouji) {
        ztytokujyouhyouji = pZtytokujyouhyouji;
    }

    private String ztyviphyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYVIPHYOUJI)
    public String getZtyviphyouji() {
        return ztyviphyouji;
    }

    public void setZtyviphyouji(String pZtyviphyouji) {
        ztyviphyouji = pZtyviphyouji;
    }

    private Integer ztykisnkihons;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKISNKIHONS)
    public Integer getZtykisnkihons() {
        return ztykisnkihons;
    }

    public void setZtykisnkihons(Integer pZtykisnkihons) {
        ztykisnkihons = pZtykisnkihons;
    }

    private Integer ztykeisansibous;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANSIBOUS)
    public Integer getZtykeisansibous() {
        return ztykeisansibous;
    }

    public void setZtykeisansibous(Integer pZtykeisansibous) {
        ztykeisansibous = pZtykeisansibous;
    }

    private Integer ztyshrs;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSHRS)
    public Integer getZtyshrs() {
        return ztyshrs;
    }

    public void setZtyshrs(Integer pZtyshrs) {
        ztyshrs = pZtyshrs;
    }

    private String ztyshrymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSHRYMD)
    public String getZtyshrymd() {
        return ztyshrymd;
    }

    public void setZtyshrymd(String pZtyshrymd) {
        ztyshrymd = pZtyshrymd;
    }

    private String ztysiharaisisyacd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSIHARAISISYACD)
    public String getZtysiharaisisyacd() {
        return ztysiharaisisyacd;
    }

    public void setZtysiharaisisyacd(String pZtysiharaisisyacd) {
        ztysiharaisisyacd = pZtysiharaisisyacd;
    }

    private String ztysymtgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYMTGENINCD)
    public String getZtysymtgenincd() {
        return ztysymtgenincd;
    }

    public void setZtysymtgenincd(String pZtysymtgenincd) {
        ztysymtgenincd = pZtysymtgenincd;
    }

    private String ztykeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEIKAYM)
    public String getZtykeikaym() {
        return ztykeikaym;
    }

    public void setZtykeikaym(String pZtykeikaym) {
        ztykeikaym = pZtykeikaym;
    }

    private String ztysbugenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSBUGENINCD)
    public String getZtysbugenincd() {
        return ztysbugenincd;
    }

    public void setZtysbugenincd(String pZtysbugenincd) {
        ztysbugenincd = pZtysbugenincd;
    }

    private String ztybsyym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztydai2hhknnen;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDAI2HHKNNEN)
    public String getZtydai2hhknnen() {
        return ztydai2hhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        ztydai2hhknnen = pZtydai2hhknnen;
    }

    private String ztydai2tokujyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDAI2TOKUJYOUHYOUJI)
    public String getZtydai2tokujyouhyouji() {
        return ztydai2tokujyouhyouji;
    }

    public void setZtydai2tokujyouhyouji(String pZtydai2tokujyouhyouji) {
        ztydai2tokujyouhyouji = pZtydai2tokujyouhyouji;
    }

    private String ztytignmrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTIGNMRTISYUKGU)
    public String getZtytignmrtisyukgu() {
        return ztytignmrtisyukgu;
    }

    public void setZtytignmrtisyukgu(String pZtytignmrtisyukgu) {
        ztytignmrtisyukgu = pZtytignmrtisyukgu;
    }

    private String ztyteigenmaruteikikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTEIGENMARUTEIKIKAN)
    public String getZtyteigenmaruteikikan() {
        return ztyteigenmaruteikikan;
    }

    public void setZtyteigenmaruteikikan(String pZtyteigenmaruteikikan) {
        ztyteigenmaruteikikan = pZtyteigenmaruteikikan;
    }

    private Integer ztygoukeiteigenbubuns;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGOUKEITEIGENBUBUNS)
    public Integer getZtygoukeiteigenbubuns() {
        return ztygoukeiteigenbubuns;
    }

    public void setZtygoukeiteigenbubuns(Integer pZtygoukeiteigenbubuns) {
        ztygoukeiteigenbubuns = pZtygoukeiteigenbubuns;
    }

    private String ztyrenseimrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYRENSEIMRTISYUKGU)
    public String getZtyrenseimrtisyukgu() {
        return ztyrenseimrtisyukgu;
    }

    public void setZtyrenseimrtisyukgu(String pZtyrenseimrtisyukgu) {
        ztyrenseimrtisyukgu = pZtyrenseimrtisyukgu;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztylivingneedsshrarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYLIVINGNEEDSSHRARIHYJ)
    public String getZtylivingneedsshrarihyj() {
        return ztylivingneedsshrarihyj;
    }

    public void setZtylivingneedsshrarihyj(String pZtylivingneedsshrarihyj) {
        ztylivingneedsshrarihyj = pZtylivingneedsshrarihyj;
    }

    private String ztylnkeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYLNKEIKAYM)
    public String getZtylnkeikaym() {
        return ztylnkeikaym;
    }

    public void setZtylnkeikaym(String pZtylnkeikaym) {
        ztylnkeikaym = pZtylnkeikaym;
    }

    private String ztylnshrgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYLNSHRGENINCD)
    public String getZtylnshrgenincd() {
        return ztylnshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtylnshrgenincd(String pZtylnshrgenincd) {
        ztylnshrgenincd = pZtylnshrgenincd;
    }

    private String ztykituenkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKITUENKBN)
    public String getZtykituenkbn() {
        return ztykituenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykituenkbn(String pZtykituenkbn) {
        ztykituenkbn = pZtykituenkbn;
    }

    private String ztykituenhonsuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKITUENHONSUU)
    public String getZtykituenhonsuu() {
        return ztykituenhonsuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykituenhonsuu(String pZtykituenhonsuu) {
        ztykituenhonsuu = pZtykituenhonsuu;
    }

    private String ztydugktnknsntkhuhukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDUGKTNKNSNTKHUHUKBN)
    public String getZtydugktnknsntkhuhukbn() {
        return ztydugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydugktnknsntkhuhukbn(String pZtydugktnknsntkhuhukbn) {
        ztydugktnknsntkhuhukbn = pZtydugktnknsntkhuhukbn;
    }

    private String ztykykjitokujyouarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYKJITOKUJYOUARIHYJ)
    public String getZtykykjitokujyouarihyj() {
        return ztykykjitokujyouarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykykjitokujyouarihyj(String pZtykykjitokujyouarihyj) {
        ztykykjitokujyouarihyj = pZtykykjitokujyouarihyj;
    }

    private String ztytokuyakukousinkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUYAKUKOUSINKBN)
    public String getZtytokuyakukousinkbn() {
        return ztytokuyakukousinkbn;
    }

    public void setZtytokuyakukousinkbn(String pZtytokuyakukousinkbn) {
        ztytokuyakukousinkbn = pZtytokuyakukousinkbn;
    }

    private String ztyteigenmaruteikisiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTEIGENMARUTEIKISIYM)
    public String getZtyteigenmaruteikisiym() {
        return ztyteigenmaruteikisiym;
    }

    public void setZtyteigenmaruteikisiym(String pZtyteigenmaruteikisiym) {
        ztyteigenmaruteikisiym = pZtyteigenmaruteikisiym;
    }

    private String ztysyunyumrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUNYUMRTISYUKGU)
    public String getZtysyunyumrtisyukgu() {
        return ztysyunyumrtisyukgu;
    }

    public void setZtysyunyumrtisyukgu(String pZtysyunyumrtisyukgu) {
        ztysyunyumrtisyukgu = pZtysyunyumrtisyukgu;
    }

    private String ztysyuunyuumaruteikikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUNYUUMARUTEIKIKAN)
    public String getZtysyuunyuumaruteikikan() {
        return ztysyuunyuumaruteikikan;
    }

    public void setZtysyuunyuumaruteikikan(String pZtysyuunyuumaruteikikan) {
        ztysyuunyuumaruteikikan = pZtysyuunyuumaruteikikan;
    }

    private Integer ztysyuunyuumrtinknengkn7;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUNYUUMRTINKNENGKN7)
    public Integer getZtysyuunyuumrtinknengkn7() {
        return ztysyuunyuumrtinknengkn7;
    }

    public void setZtysyuunyuumrtinknengkn7(Integer pZtysyuunyuumrtinknengkn7) {
        ztysyuunyuumrtinknengkn7 = pZtysyuunyuumrtinknengkn7;
    }

    private String ztysyuunyuumaruteikisiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUNYUUMARUTEIKISIYM)
    public String getZtysyuunyuumaruteikisiym() {
        return ztysyuunyuumaruteikisiym;
    }

    public void setZtysyuunyuumaruteikisiym(String pZtysyuunyuumaruteikisiym) {
        ztysyuunyuumaruteikisiym = pZtysyuunyuumaruteikisiym;
    }

    private String ztysysnymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYSNYMD)
    public String getZtysysnymd() {
        return ztysysnymd;
    }

    public void setZtysysnymd(String pZtysysnymd) {
        ztysysnymd = pZtysysnymd;
    }

    private String ztysindanymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSINDANYMD)
    public String getZtysindanymd() {
        return ztysindanymd;
    }

    public void setZtysindanymd(String pZtysindanymd) {
        ztysindanymd = pZtysindanymd;
    }

    private String ztybyoumeicd1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBYOUMEICD1)
    public String getZtybyoumeicd1() {
        return ztybyoumeicd1;
    }

    public void setZtybyoumeicd1(String pZtybyoumeicd1) {
        ztybyoumeicd1 = pZtybyoumeicd1;
    }

    private String ztybyoumeicd2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBYOUMEICD2)
    public String getZtybyoumeicd2() {
        return ztybyoumeicd2;
    }

    public void setZtybyoumeicd2(String pZtybyoumeicd2) {
        ztybyoumeicd2 = pZtybyoumeicd2;
    }

    private String ztyshrnaiyoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSHRNAIYOUKBN)
    public String getZtyshrnaiyoukbn() {
        return ztyshrnaiyoukbn;
    }

    public void setZtyshrnaiyoukbn(String pZtyshrnaiyoukbn) {
        ztyshrnaiyoukbn = pZtyshrnaiyoukbn;
    }

    private String ztygituyuknkbn1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGITUYUKNKBN1)
    public String getZtygituyuknkbn1() {
        return ztygituyuknkbn1;
    }

    public void setZtygituyuknkbn1(String pZtygituyuknkbn1) {
        ztygituyuknkbn1 = pZtygituyuknkbn1;
    }

    private String ztygituyuknkbn2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGITUYUKNKBN2)
    public String getZtygituyuknkbn2() {
        return ztygituyuknkbn2;
    }

    public void setZtygituyuknkbn2(String pZtygituyuknkbn2) {
        ztygituyuknkbn2 = pZtygituyuknkbn2;
    }

    private String ztysyeiebnri1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYEIEBNRI1)
    public String getZtysyeiebnri1() {
        return ztysyeiebnri1;
    }

    public void setZtysyeiebnri1(String pZtysyeiebnri1) {
        ztysyeiebnri1 = pZtysyeiebnri1;
    }

    private String ztysyeiebnri2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYEIEBNRI2)
    public String getZtysyeiebnri2() {
        return ztysyeiebnri2;
    }

    public void setZtysyeiebnri2(String pZtysyeiebnri2) {
        ztysyeiebnri2 = pZtysyeiebnri2;
    }

    private String ztyminnesotacd1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMINNESOTACD1)
    public String getZtyminnesotacd1() {
        return ztyminnesotacd1;
    }

    public void setZtyminnesotacd1(String pZtyminnesotacd1) {
        ztyminnesotacd1 = pZtyminnesotacd1;
    }

    private String ztyminnesotacd2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMINNESOTACD2)
    public String getZtyminnesotacd2() {
        return ztyminnesotacd2;
    }

    public void setZtyminnesotacd2(String pZtyminnesotacd2) {
        ztyminnesotacd2 = pZtyminnesotacd2;
    }

    private String ztyminnesotacd3;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMINNESOTACD3)
    public String getZtyminnesotacd3() {
        return ztyminnesotacd3;
    }

    public void setZtyminnesotacd3(String pZtyminnesotacd3) {
        ztyminnesotacd3 = pZtyminnesotacd3;
    }

    private String ztyminnesotacd4;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMINNESOTACD4)
    public String getZtyminnesotacd4() {
        return ztyminnesotacd4;
    }

    public void setZtyminnesotacd4(String pZtyminnesotacd4) {
        ztyminnesotacd4 = pZtyminnesotacd4;
    }

    private String ztyminnesotacd5;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMINNESOTACD5)
    public String getZtyminnesotacd5() {
        return ztyminnesotacd5;
    }

    public void setZtyminnesotacd5(String pZtyminnesotacd5) {
        ztyminnesotacd5 = pZtyminnesotacd5;
    }

    private String ztymnsisiensindanjiyuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYMNSISIENSINDANJIYUU)
    public String getZtymnsisiensindanjiyuu() {
        return ztymnsisiensindanjiyuu;
    }

    public void setZtymnsisiensindanjiyuu(String pZtymnsisiensindanjiyuu) {
        ztymnsisiensindanjiyuu = pZtymnsisiensindanjiyuu;
    }

    private String ztyknkuhnsindanjiyuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKNKUHNSINDANJIYUU)
    public String getZtyknkuhnsindanjiyuu() {
        return ztyknkuhnsindanjiyuu;
    }

    public void setZtyknkuhnsindanjiyuu(String pZtyknkuhnsindanjiyuu) {
        ztyknkuhnsindanjiyuu = pZtyknkuhnsindanjiyuu;
    }

    private String ztyhushrkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHUSHRKBN)
    public String getZtyhushrkbn() {
        return ztyhushrkbn;
    }

    public void setZtyhushrkbn(String pZtyhushrkbn) {
        ztyhushrkbn = pZtyhushrkbn;
    }

    private String ztyhushrym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHUSHRYM)
    public String getZtyhushrym() {
        return ztyhushrym;
    }

    public void setZtyhushrym(String pZtyhushrym) {
        ztyhushrym = pZtyhushrym;
    }

    private String ztysyuunyuumrtinkshrkkn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUNYUUMRTINKSHRKKN)
    public String getZtysyuunyuumrtinkshrkkn() {
        return ztysyuunyuumrtinkshrkkn;
    }

    public void setZtysyuunyuumrtinkshrkkn(String pZtysyuunyuumrtinkshrkkn) {
        ztysyuunyuumrtinkshrkkn = pZtysyuunyuumrtinkshrkkn;
    }

    private String ztytokujyousakugenkikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUJYOUSAKUGENKIKAN)
    public String getZtytokujyousakugenkikan() {
        return ztytokujyousakugenkikan;
    }

    public void setZtytokujyousakugenkikan(String pZtytokujyousakugenkikan) {
        ztytokujyousakugenkikan = pZtytokujyousakugenkikan;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztyharaikomihouhou;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHARAIKOMIHOUHOU)
    public String getZtyharaikomihouhou() {
        return ztyharaikomihouhou;
    }

    public void setZtyharaikomihouhou(String pZtyharaikomihouhou) {
        ztyharaikomihouhou = pZtyharaikomihouhou;
    }

    private String ztysinsahouhou;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSINSAHOUHOU)
    public String getZtysinsahouhou() {
        return ztysinsahouhou;
    }

    public void setZtysinsahouhou(String pZtysinsahouhou) {
        ztysinsahouhou = pZtysinsahouhou;
    }

    private String ztykykniyutksytioukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYKNIYUTKSYTIOUKBN)
    public String getZtykykniyutksytioukbn() {
        return ztykykniyutksytioukbn;
    }

    public void setZtykykniyutksytioukbn(String pZtykykniyutksytioukbn) {
        ztykykniyutksytioukbn = pZtykykniyutksytioukbn;
    }

    private String ztyrnduyuryumshyutn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYRNDUYURYUMSHYUTN)
    public String getZtyrnduyuryumshyutn() {
        return ztyrnduyuryumshyutn;
    }

    public void setZtyrnduyuryumshyutn(String pZtyrnduyuryumshyutn) {
        ztyrnduyuryumshyutn = pZtyrnduyuryumshyutn;
    }

    private String ztyhutanpobui1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHUTANPOBUI1)
    public String getZtyhutanpobui1() {
        return ztyhutanpobui1;
    }

    public void setZtyhutanpobui1(String pZtyhutanpobui1) {
        ztyhutanpobui1 = pZtyhutanpobui1;
    }

    private String ztyhtnpkkn1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHTNPKKN1)
    public String getZtyhtnpkkn1() {
        return ztyhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn1(String pZtyhtnpkkn1) {
        ztyhtnpkkn1 = pZtyhtnpkkn1;
    }

    private String ztyhutanpobui2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHUTANPOBUI2)
    public String getZtyhutanpobui2() {
        return ztyhutanpobui2;
    }

    public void setZtyhutanpobui2(String pZtyhutanpobui2) {
        ztyhutanpobui2 = pZtyhutanpobui2;
    }

    private String ztyhtnpkkn2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHTNPKKN2)
    public String getZtyhtnpkkn2() {
        return ztyhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn2(String pZtyhtnpkkn2) {
        ztyhtnpkkn2 = pZtyhtnpkkn2;
    }

    private String ztyhukasyuksyu;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHUKASYUKSYU)
    public String getZtyhukasyuksyu() {
        return ztyhukasyuksyu;
    }

    public void setZtyhukasyuksyu(String pZtyhukasyuksyu) {
        ztyhukasyuksyu = pZtyhukasyuksyu;
    }

    private String ztysuuriyoutokuyakukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUTOKUYAKUKBN)
    public String getZtysuuriyoutokuyakukbn() {
        return ztysuuriyoutokuyakukbn;
    }

    public void setZtysuuriyoutokuyakukbn(String pZtysuuriyoutokuyakukbn) {
        ztysuuriyoutokuyakukbn = pZtysuuriyoutokuyakukbn;
    }

    private String ztytokuyakuno;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUYAKUNO)
    public String getZtytokuyakuno() {
        return ztytokuyakuno;
    }

    public void setZtytokuyakuno(String pZtytokuyakuno) {
        ztytokuyakuno = pZtytokuyakuno;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztykusnmetkyksykipjyutuym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKUSNMETKYKSYKIPJYUTUYM)
    public String getZtykusnmetkyksykipjyutuym() {
        return ztykusnmetkyksykipjyutuym;
    }

    public void setZtykusnmetkyksykipjyutuym(String pZtykusnmetkyksykipjyutuym) {
        ztykusnmetkyksykipjyutuym = pZtykusnmetkyksykipjyutuym;
    }

    private String ztysykikjgykbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYKIKJGYKBN)
    public String getZtysykikjgykbn() {
        return ztysykikjgykbn;
    }

    public void setZtysykikjgykbn(String pZtysykikjgykbn) {
        ztysykikjgykbn = pZtysykikjgykbn;
    }

    private String ztysykgycd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztytenkanminaosikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTENKANMINAOSIKBN)
    public String getZtytenkanminaosikbn() {
        return ztytenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanminaosikbn(String pZtytenkanminaosikbn) {
        ztytenkanminaosikbn = pZtytenkanminaosikbn;
    }

    private String ztykaijyokbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKAIJYOKBN)
    public String getZtykaijyokbn() {
        return ztykaijyokbn;
    }

    public void setZtykaijyokbn(String pZtykaijyokbn) {
        ztykaijyokbn = pZtykaijyokbn;
    }

    private String ztysyuruihenkouarihyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYURUIHENKOUARIHYOUJI)
    public String getZtysyuruihenkouarihyouji() {
        return ztysyuruihenkouarihyouji;
    }

    public void setZtysyuruihenkouarihyouji(String pZtysyuruihenkouarihyouji) {
        ztysyuruihenkouarihyouji = pZtysyuruihenkouarihyouji;
    }

    private String ztydai2hihokensyasonzokuhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDAI2HIHOKENSYASONZOKUHYJ)
    public String getZtydai2hihokensyasonzokuhyj() {
        return ztydai2hihokensyasonzokuhyj;
    }

    public void setZtydai2hihokensyasonzokuhyj(String pZtydai2hihokensyasonzokuhyj) {
        ztydai2hihokensyasonzokuhyj = pZtydai2hihokensyasonzokuhyj;
    }

    private String ztysyukeiyakukigou;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUKEIYAKUKIGOU)
    public String getZtysyukeiyakukigou() {
        return ztysyukeiyakukigou;
    }

    public void setZtysyukeiyakukigou(String pZtysyukeiyakukigou) {
        ztysyukeiyakukigou = pZtysyukeiyakukigou;
    }

    private String ztysymtymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }

    private String ztytyuutohukatkhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTYUUTOHUKATKHYJ)
    public String getZtytyuutohukatkhyj() {
        return ztytyuutohukatkhyj;
    }

    public void setZtytyuutohukatkhyj(String pZtytyuutohukatkhyj) {
        ztytyuutohukatkhyj = pZtytyuutohukatkhyj;
    }

    private String ztyyoukigjyutigituymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOUKIGJYUTIGITUYMD)
    public String getZtyyoukigjyutigituymd() {
        return ztyyoukigjyutigituymd;
    }

    public void setZtyyoukigjyutigituymd(String pZtyyoukigjyutigituymd) {
        ztyyoukigjyutigituymd = pZtyyoukigjyutigituymd;
    }

    private String ztyyoukigjyutigeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOUKIGJYUTIGENINKBN)
    public String getZtyyoukigjyutigeninkbn() {
        return ztyyoukigjyutigeninkbn;
    }

    public void setZtyyoukigjyutigeninkbn(String pZtyyoukigjyutigeninkbn) {
        ztyyoukigjyutigeninkbn = pZtyyoukigjyutigeninkbn;
    }

    private String ztysykmtssyukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYKMTSSYUKAHIKBN)
    public String getZtysykmtssyukahikbn() {
        return ztysykmtssyukahikbn;
    }

    public void setZtysykmtssyukahikbn(String pZtysykmtssyukahikbn) {
        ztysykmtssyukahikbn = pZtysykmtssyukahikbn;
    }

    private String ztyfktrsmtkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYFKTRSMTKAHIKBN)
    public String getZtyfktrsmtkahikbn() {
        return ztyfktrsmtkahikbn;
    }

    public void setZtyfktrsmtkahikbn(String pZtyfktrsmtkahikbn) {
        ztyfktrsmtkahikbn = pZtyfktrsmtkahikbn;
    }

    private String ztyhokoukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHOKOUKAHIKBN)
    public String getZtyhokoukahikbn() {
        return ztyhokoukahikbn;
    }

    public void setZtyhokoukahikbn(String pZtyhokoukahikbn) {
        ztyhokoukahikbn = pZtyhokoukahikbn;
    }

    private String ztynyykkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYNYYKKAHIKBN)
    public String getZtynyykkahikbn() {
        return ztynyykkahikbn;
    }

    public void setZtynyykkahikbn(String pZtynyykkahikbn) {
        ztynyykkahikbn = pZtynyykkahikbn;
    }

    private String ztyihukutyakudatukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYIHUKUTYAKUDATUKAHIKBN)
    public String getZtyihukutyakudatukahikbn() {
        return ztyihukutyakudatukahikbn;
    }

    public void setZtyihukutyakudatukahikbn(String pZtyihukutyakudatukahikbn) {
        ztyihukutyakudatukahikbn = pZtyihukutyakudatukahikbn;
    }

    private String ztytihougeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTIHOUGENINKBN)
    public String getZtytihougeninkbn() {
        return ztytihougeninkbn;
    }

    public void setZtytihougeninkbn(String pZtytihougeninkbn) {
        ztytihougeninkbn = pZtytihougeninkbn;
    }

    private String ztysyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUKGUSDKBN)
    public String getZtysyukgusdkbn() {
        return ztysyukgusdkbn;
    }

    public void setZtysyukgusdkbn(String pZtysyukgusdkbn) {
        ztysyukgusdkbn = pZtysyukgusdkbn;
    }

    private String ztytignmrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTIGNMRTISYUKGUSDKBN)
    public String getZtytignmrtisyukgusdkbn() {
        return ztytignmrtisyukgusdkbn;
    }

    public void setZtytignmrtisyukgusdkbn(String pZtytignmrtisyukgusdkbn) {
        ztytignmrtisyukgusdkbn = pZtytignmrtisyukgusdkbn;
    }

    private String ztyrenseimrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYRENSEIMRTISYUKGUSDKBN)
    public String getZtyrenseimrtisyukgusdkbn() {
        return ztyrenseimrtisyukgusdkbn;
    }

    public void setZtyrenseimrtisyukgusdkbn(String pZtyrenseimrtisyukgusdkbn) {
        ztyrenseimrtisyukgusdkbn = pZtyrenseimrtisyukgusdkbn;
    }

    private String ztysyunyumrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUNYUMRTISYUKGUSDKBN)
    public String getZtysyunyumrtisyukgusdkbn() {
        return ztysyunyumrtisyukgusdkbn;
    }

    public void setZtysyunyumrtisyukgusdkbn(String pZtysyunyumrtisyukgusdkbn) {
        ztysyunyumrtisyukgusdkbn = pZtysyunyumrtisyukgusdkbn;
    }

    private String ztysykyksyuruikgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYKYKSYURUIKGUSDKBN)
    public String getZtysykyksyuruikgusdkbn() {
        return ztysykyksyuruikgusdkbn;
    }

    public void setZtysykyksyuruikgusdkbn(String pZtysykyksyuruikgusdkbn) {
        ztysykyksyuruikgusdkbn = pZtysykyksyuruikgusdkbn;
    }

    private String ztypmenhukakbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztypmenkbnv2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENKBNV2)
    public String getZtypmenkbnv2() {
        return ztypmenkbnv2;
    }

    public void setZtypmenkbnv2(String pZtypmenkbnv2) {
        ztypmenkbnv2 = pZtypmenkbnv2;
    }

    private String ztypmenjikohasseiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENJIKOHASSEIYMD)
    public String getZtypmenjikohasseiymd() {
        return ztypmenjikohasseiymd;
    }

    public void setZtypmenjikohasseiymd(String pZtypmenjikohasseiymd) {
        ztypmenjikohasseiymd = pZtypmenjikohasseiymd;
    }

    private String ztybosyuukeirokbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBOSYUUKEIROKBN)
    public String getZtybosyuukeirokbn() {
        return ztybosyuukeirokbn;
    }

    public void setZtybosyuukeirokbn(String pZtybosyuukeirokbn) {
        ztybosyuukeirokbn = pZtybosyuukeirokbn;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztysyorinov2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYORINOV2)
    public String getZtysyorinov2() {
        return ztysyorinov2;
    }

    public void setZtysyorinov2(String pZtysyorinov2) {
        ztysyorinov2 = pZtysyorinov2;
    }

    private String ztykigkyhsitihsyutkykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKIGKYHSITIHSYUTKYKHYJ)
    public String getZtykigkyhsitihsyutkykhyj() {
        return ztykigkyhsitihsyutkykhyj;
    }

    public void setZtykigkyhsitihsyutkykhyj(String pZtykigkyhsitihsyutkykhyj) {
        ztykigkyhsitihsyutkykhyj = pZtykigkyhsitihsyutkykhyj;
    }

    private String ztypmenhutanpobui1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENHUTANPOBUI1)
    public String getZtypmenhutanpobui1() {
        return ztypmenhutanpobui1;
    }

    public void setZtypmenhutanpobui1(String pZtypmenhutanpobui1) {
        ztypmenhutanpobui1 = pZtypmenhutanpobui1;
    }

    private String ztypmenhutanpokikan1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENHUTANPOKIKAN1)
    public String getZtypmenhutanpokikan1() {
        return ztypmenhutanpokikan1;
    }

    public void setZtypmenhutanpokikan1(String pZtypmenhutanpokikan1) {
        ztypmenhutanpokikan1 = pZtypmenhutanpokikan1;
    }

    private String ztypmenhutanpobui2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENHUTANPOBUI2)
    public String getZtypmenhutanpobui2() {
        return ztypmenhutanpobui2;
    }

    public void setZtypmenhutanpobui2(String pZtypmenhutanpobui2) {
        ztypmenhutanpobui2 = pZtypmenhutanpobui2;
    }

    private String ztypmenhutanpokikan2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPMENHUTANPOKIKAN2)
    public String getZtypmenhutanpokikan2() {
        return ztypmenhutanpokikan2;
    }

    public void setZtypmenhutanpokikan2(String pZtypmenhutanpokikan2) {
        ztypmenhutanpokikan2 = pZtypmenhutanpokikan2;
    }

    private String ztykanyujidatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKANYUJIDATAKANRINO)
    public String getZtykanyujidatakanrino() {
        return ztykanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtykanyujidatakanrino(String pZtykanyujidatakanrino) {
        ztykanyujidatakanrino = pZtykanyujidatakanrino;
    }

    private String ztybnktgsnzkkykdatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBNKTGSNZKKYKDATAKANRINO)
    public String getZtybnktgsnzkkykdatakanrino() {
        return ztybnktgsnzkkykdatakanrino;
    }

    public void setZtybnktgsnzkkykdatakanrino(String pZtybnktgsnzkkykdatakanrino) {
        ztybnktgsnzkkykdatakanrino = pZtybnktgsnzkkykdatakanrino;
    }

    private String ztybnkttnknkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBNKTTNKNKBN)
    public String getZtybnkttnknkbn() {
        return ztybnkttnknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtybnkttnknkbn(String pZtybnkttnknkbn) {
        ztybnkttnknkbn = pZtybnkttnknkbn;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztybnktjisisttkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBNKTJISISTTKARIHYJ)
    public String getZtybnktjisisttkarihyj() {
        return ztybnktjisisttkarihyj;
    }

    public void setZtybnktjisisttkarihyj(String pZtybnktjisisttkarihyj) {
        ztybnktjisisttkarihyj = pZtybnktjisisttkarihyj;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztycareneedssiharaihyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYCARENEEDSSIHARAIHYOUJI)
    public String getZtycareneedssiharaihyouji() {
        return ztycareneedssiharaihyouji;
    }

    public void setZtycareneedssiharaihyouji(String pZtycareneedssiharaihyouji) {
        ztycareneedssiharaihyouji = pZtycareneedssiharaihyouji;
    }

    private String ztybnktjitiktkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYBNKTJITIKTKARIHYJ)
    public String getZtybnktjitiktkarihyj() {
        return ztybnktjitiktkarihyj;
    }

    public void setZtybnktjitiktkarihyj(String pZtybnktjitiktkarihyj) {
        ztybnktjitiktkarihyj = pZtybnktjitiktkarihyj;
    }

    private String ztykousinkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKOUSINKBN)
    public String getZtykousinkbn() {
        return ztykousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinkbn(String pZtykousinkbn) {
        ztykousinkbn = pZtykousinkbn;
    }

    private String ztyksnym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKSNYM)
    public String getZtyksnym() {
        return ztyksnym;
    }

    public void setZtyksnym(String pZtyksnym) {
        ztyksnym = pZtyksnym;
    }

    private String ztyijitoukeiyuksnhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYIJITOUKEIYUKSNHYJ)
    public String getZtyijitoukeiyuksnhyj() {
        return ztyijitoukeiyuksnhyj;
    }

    public void setZtyijitoukeiyuksnhyj(String pZtyijitoukeiyuksnhyj) {
        ztyijitoukeiyuksnhyj = pZtyijitoukeiyuksnhyj;
    }

    private String ztyikoujisnskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYIKOUJISNSKBN)
    public String getZtyikoujisnskbn() {
        return ztyikoujisnskbn;
    }

    public void setZtyikoujisnskbn(String pZtyikoujisnskbn) {
        ztyikoujisnskbn = pZtyikoujisnskbn;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztysuuriyouyobin1;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN1)
    public String getZtysuuriyouyobin1() {
        return ztysuuriyouyobin1;
    }

    public void setZtysuuriyouyobin1(String pZtysuuriyouyobin1) {
        ztysuuriyouyobin1 = pZtysuuriyouyobin1;
    }

    private Integer ztyimustiyusbus;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYIMUSTIYUSBUS)
    public Integer getZtyimustiyusbus() {
        return ztyimustiyusbus;
    }

    public void setZtyimustiyusbus(Integer pZtyimustiyusbus) {
        ztyimustiyusbus = pZtyimustiyusbus;
    }

    private Integer ztykeisansykykbbnkhns;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANSYKYKBBNKHNS)
    public Integer getZtykeisansykykbbnkhns() {
        return ztykeisansykykbbnkhns;
    }

    public void setZtykeisansykykbbnkhns(Integer pZtykeisansykykbbnkhns) {
        ztykeisansykykbbnkhns = pZtykeisansykykbbnkhns;
    }

    private String ztysuuriyoubosyuukeitaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUBOSYUUKEITAIKBN)
    public String getZtysuuriyoubosyuukeitaikbn() {
        return ztysuuriyoubosyuukeitaikbn;
    }

    public void setZtysuuriyoubosyuukeitaikbn(String pZtysuuriyoubosyuukeitaikbn) {
        ztysuuriyoubosyuukeitaikbn = pZtysuuriyoubosyuukeitaikbn;
    }

    private String ztysysnikoujiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYSNIKOUJIYM)
    public String getZtysysnikoujiym() {
        return ztysysnikoujiym;
    }

    public void setZtysysnikoujiym(String pZtysysnikoujiym) {
        ztysysnikoujiym = pZtysysnikoujiym;
    }

    private String ztygnspshrhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGNSPSHRHYJ)
    public String getZtygnspshrhyj() {
        return ztygnspshrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygnspshrhyj(String pZtygnspshrhyj) {
        ztygnspshrhyj = pZtygnspshrhyj;
    }

    private String ztygnspshrkeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGNSPSHRKEIKAYM)
    public String getZtygnspshrkeikaym() {
        return ztygnspshrkeikaym;
    }

    public void setZtygnspshrkeikaym(String pZtygnspshrkeikaym) {
        ztygnspshrkeikaym = pZtygnspshrkeikaym;
    }

    private String ztygnspshrgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGNSPSHRGENINCD)
    public String getZtygnspshrgenincd() {
        return ztygnspshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtygnspshrgenincd(String pZtygnspshrgenincd) {
        ztygnspshrgenincd = pZtygnspshrgenincd;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztyngerkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYNGERKAHIKBN)
    public String getZtyngerkahikbn() {
        return ztyngerkahikbn;
    }

    public void setZtyngerkahikbn(String pZtyngerkahikbn) {
        ztyngerkahikbn = pZtyngerkahikbn;
    }

    private String ztyhokenhoutekiyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHOKENHOUTEKIYOUHYOUJI)
    public String getZtyhokenhoutekiyouhyouji() {
        return ztyhokenhoutekiyouhyouji;
    }

    public void setZtyhokenhoutekiyouhyouji(String pZtyhokenhoutekiyouhyouji) {
        ztyhokenhoutekiyouhyouji = pZtyhokenhoutekiyouhyouji;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private Integer ztykeisansyukeiyakup;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANSYUKEIYAKUP)
    public Integer getZtykeisansyukeiyakup() {
        return ztykeisansyukeiyakup;
    }

    public void setZtykeisansyukeiyakup(Integer pZtykeisansyukeiyakup) {
        ztykeisansyukeiyakup = pZtykeisansyukeiyakup;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private Integer ztykeisangoukeitenkans;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANGOUKEITENKANS)
    public Integer getZtykeisangoukeitenkans() {
        return ztykeisangoukeitenkans;
    }

    public void setZtykeisangoukeitenkans(Integer pZtykeisangoukeitenkans) {
        ztykeisangoukeitenkans = pZtykeisangoukeitenkans;
    }

    private Integer ztykeisangoukeitenkankakaku;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANGOUKEITENKANKAKAKU)
    public Integer getZtykeisangoukeitenkankakaku() {
        return ztykeisangoukeitenkankakaku;
    }

    public void setZtykeisangoukeitenkankakaku(Integer pZtykeisangoukeitenkankakaku) {
        ztykeisangoukeitenkankakaku = pZtykeisangoukeitenkankakaku;
    }

    private Integer ztykisnwnsgukitnknkakaku;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKISNWNSGUKITNKNKAKAKU)
    public Integer getZtykisnwnsgukitnknkakaku() {
        return ztykisnwnsgukitnknkakaku;
    }

    public void setZtykisnwnsgukitnknkakaku(Integer pZtykisnwnsgukitnknkakaku) {
        ztykisnwnsgukitnknkakaku = pZtykisnwnsgukitnknkakaku;
    }

    private BizNumber ztytnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTNKNKHNBBNJYUTURT)
    public BizNumber getZtytnknkhnbbnjyuturt() {
        return ztytnknkhnbbnjyuturt;
    }

    public void setZtytnknkhnbbnjyuturt(BizNumber pZtytnknkhnbbnjyuturt) {
        ztytnknkhnbbnjyuturt = pZtytnknkhnbbnjyuturt;
    }

    private String ztyharaizumiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYHARAIZUMIYMD)
    public String getZtyharaizumiymd() {
        return ztyharaizumiymd;
    }

    public void setZtyharaizumiymd(String pZtyharaizumiymd) {
        ztyharaizumiymd = pZtyharaizumiymd;
    }

    private String ztystdsstkjytkyuhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSTDSSTKJYTKYUHYJ)
    public String getZtystdsstkjytkyuhyj() {
        return ztystdsstkjytkyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdsstkjytkyuhyj(String pZtystdsstkjytkyuhyj) {
        ztystdsstkjytkyuhyj = pZtystdsstkjytkyuhyj;
    }

    private BizNumber ztykeisanyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEISANYOTEIRIRITU)
    public BizNumber getZtykeisanyoteiriritu() {
        return ztykeisanyoteiriritu;
    }

    public void setZtykeisanyoteiriritu(BizNumber pZtykeisanyoteiriritu) {
        ztykeisanyoteiriritu = pZtykeisanyoteiriritu;
    }

    private String ztyseiketuseiyoukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSEIKETUSEIYOUKAHIKBN)
    public String getZtyseiketuseiyoukahikbn() {
        return ztyseiketuseiyoukahikbn;
    }

    public void setZtyseiketuseiyoukahikbn(String pZtyseiketuseiyoukahikbn) {
        ztyseiketuseiyoukahikbn = pZtyseiketuseiyoukahikbn;
    }

    private String ztysyuurouhunoukgjyoutaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUROUHUNOUKGJYOUTAIKBN)
    public String getZtysyuurouhunoukgjyoutaikbn() {
        return ztysyuurouhunoukgjyoutaikbn;
    }

    public void setZtysyuurouhunoukgjyoutaikbn(String pZtysyuurouhunoukgjyoutaikbn) {
        ztysyuurouhunoukgjyoutaikbn = pZtysyuurouhunoukgjyoutaikbn;
    }

    private String ztysyuurouhunoujyoutaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSYUUROUHUNOUJYOUTAIKBN)
    public String getZtysyuurouhunoujyoutaikbn() {
        return ztysyuurouhunoujyoutaikbn;
    }

    public void setZtysyuurouhunoujyoutaikbn(String pZtysyuurouhunoujyoutaikbn) {
        ztysyuurouhunoujyoutaikbn = pZtysyuurouhunoujyoutaikbn;
    }

    private String ztysiznkyhsyoubyouhasseiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSIZNKYHSYOUBYOUHASSEIYMD)
    public String getZtysiznkyhsyoubyouhasseiymd() {
        return ztysiznkyhsyoubyouhasseiymd;
    }

    public void setZtysiznkyhsyoubyouhasseiymd(String pZtysiznkyhsyoubyouhasseiymd) {
        ztysiznkyhsyoubyouhasseiymd = pZtysiznkyhsyoubyouhasseiymd;
    }

    private String ztykyusisnknkuskgitukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKYUSISNKNKUSKGITUKBN)
    public String getZtykyusisnknkuskgitukbn() {
        return ztykyusisnknkuskgitukbn;
    }

    public void setZtykyusisnknkuskgitukbn(String pZtykyusisnknkuskgitukbn) {
        ztykyusisnknkuskgitukbn = pZtykyusisnknkuskgitukbn;
    }

    private String ztynousottyuugaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYNOUSOTTYUUGAITOUKBN)
    public String getZtynousottyuugaitoukbn() {
        return ztynousottyuugaitoukbn;
    }

    public void setZtynousottyuugaitoukbn(String pZtynousottyuugaitoukbn) {
        ztynousottyuugaitoukbn = pZtynousottyuugaitoukbn;
    }

    private String ztyjinhuzengaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYJINHUZENGAITOUKBN)
    public String getZtyjinhuzengaitoukbn() {
        return ztyjinhuzengaitoukbn;
    }

    public void setZtyjinhuzengaitoukbn(String pZtyjinhuzengaitoukbn) {
        ztyjinhuzengaitoukbn = pZtyjinhuzengaitoukbn;
    }

    private String ztydoumyakusikkangaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDOUMYAKUSIKKANGAITOUKBN)
    public String getZtydoumyakusikkangaitoukbn() {
        return ztydoumyakusikkangaitoukbn;
    }

    public void setZtydoumyakusikkangaitoukbn(String pZtydoumyakusikkangaitoukbn) {
        ztydoumyakusikkangaitoukbn = pZtydoumyakusikkangaitoukbn;
    }

    private String ztydatakanrino2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDATAKANRINO2)
    public String getZtydatakanrino2() {
        return ztydatakanrino2;
    }

    public void setZtydatakanrino2(String pZtydatakanrino2) {
        ztydatakanrino2 = pZtydatakanrino2;
    }

    private String ztydatakanrino3;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYDATAKANRINO3)
    public String getZtydatakanrino3() {
        return ztydatakanrino3;
    }

    public void setZtydatakanrino3(String pZtydatakanrino3) {
        ztydatakanrino3 = pZtydatakanrino3;
    }

    private String ztysinkeiyakujivithkhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSINKEIYAKUJIVITHKHYOUJI)
    public String getZtysinkeiyakujivithkhyouji() {
        return ztysinkeiyakujivithkhyouji;
    }

    public void setZtysinkeiyakujivithkhyouji(String pZtysinkeiyakujivithkhyouji) {
        ztysinkeiyakujivithkhyouji = pZtysinkeiyakujivithkhyouji;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztyknkuzusnzyrtsiyounendo;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKNKUZUSNZYRTSIYOUNENDO)
    public String getZtyknkuzusnzyrtsiyounendo() {
        return ztyknkuzusnzyrtsiyounendo;
    }

    public void setZtyknkuzusnzyrtsiyounendo(String pZtyknkuzusnzyrtsiyounendo) {
        ztyknkuzusnzyrtsiyounendo = pZtyknkuzusnzyrtsiyounendo;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyvittkykkaiyakuymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYVITTKYKKAIYAKUYMD)
    public String getZtyvittkykkaiyakuymd() {
        return ztyvittkykkaiyakuymd;
    }

    public void setZtyvittkykkaiyakuymd(String pZtyvittkykkaiyakuymd) {
        ztyvittkykkaiyakuymd = pZtyvittkykkaiyakuymd;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztynintisyougeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYNINTISYOUGENINKBN)
    public String getZtynintisyougeninkbn() {
        return ztynintisyougeninkbn;
    }

    public void setZtynintisyougeninkbn(String pZtynintisyougeninkbn) {
        ztynintisyougeninkbn = pZtynintisyougeninkbn;
    }

    private String ztysuuriyouyobin1x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN1X2)
    public String getZtysuuriyouyobin1x2() {
        return ztysuuriyouyobin1x2;
    }

    public void setZtysuuriyouyobin1x2(String pZtysuuriyouyobin1x2) {
        ztysuuriyouyobin1x2 = pZtysuuriyouyobin1x2;
    }

    private String ztysuuriyouyobin8x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X3)
    public String getZtysuuriyouyobin8x3() {
        return ztysuuriyouyobin8x3;
    }

    public void setZtysuuriyouyobin8x3(String pZtysuuriyouyobin8x3) {
        ztysuuriyouyobin8x3 = pZtysuuriyouyobin8x3;
    }

    private String ztysuuriyouyobin8x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X4)
    public String getZtysuuriyouyobin8x4() {
        return ztysuuriyouyobin8x4;
    }

    public void setZtysuuriyouyobin8x4(String pZtysuuriyouyobin8x4) {
        ztysuuriyouyobin8x4 = pZtysuuriyouyobin8x4;
    }

    private String ztysuuriyouyobin8x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X5)
    public String getZtysuuriyouyobin8x5() {
        return ztysuuriyouyobin8x5;
    }

    public void setZtysuuriyouyobin8x5(String pZtysuuriyouyobin8x5) {
        ztysuuriyouyobin8x5 = pZtysuuriyouyobin8x5;
    }

    private String ztysuuriyouyobin8x6;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X6)
    public String getZtysuuriyouyobin8x6() {
        return ztysuuriyouyobin8x6;
    }

    public void setZtysuuriyouyobin8x6(String pZtysuuriyouyobin8x6) {
        ztysuuriyouyobin8x6 = pZtysuuriyouyobin8x6;
    }

    private String ztysuuriyouyobin8x7;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X7)
    public String getZtysuuriyouyobin8x7() {
        return ztysuuriyouyobin8x7;
    }

    public void setZtysuuriyouyobin8x7(String pZtysuuriyouyobin8x7) {
        ztysuuriyouyobin8x7 = pZtysuuriyouyobin8x7;
    }

    private String ztysuuriyouyobin8x8;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X8)
    public String getZtysuuriyouyobin8x8() {
        return ztysuuriyouyobin8x8;
    }

    public void setZtysuuriyouyobin8x8(String pZtysuuriyouyobin8x8) {
        ztysuuriyouyobin8x8 = pZtysuuriyouyobin8x8;
    }

    private String ztysuuriyouyobin8x9;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X9)
    public String getZtysuuriyouyobin8x9() {
        return ztysuuriyouyobin8x9;
    }

    public void setZtysuuriyouyobin8x9(String pZtysuuriyouyobin8x9) {
        ztysuuriyouyobin8x9 = pZtysuuriyouyobin8x9;
    }

    private String ztysuuriyouyobin8x10;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8X10)
    public String getZtysuuriyouyobin8x10() {
        return ztysuuriyouyobin8x10;
    }

    public void setZtysuuriyouyobin8x10(String pZtysuuriyouyobin8x10) {
        ztysuuriyouyobin8x10 = pZtysuuriyouyobin8x10;
    }

    private Integer ztyyobin7;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN7)
    public Integer getZtyyobin7() {
        return ztyyobin7;
    }

    public void setZtyyobin7(Integer pZtyyobin7) {
        ztyyobin7 = pZtyyobin7;
    }

    private Integer ztyyobin7x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN7X2)
    public Integer getZtyyobin7x2() {
        return ztyyobin7x2;
    }

    public void setZtyyobin7x2(Integer pZtyyobin7x2) {
        ztyyobin7x2 = pZtyyobin7x2;
    }

    private Integer ztyyobin7x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN7X3)
    public Integer getZtyyobin7x3() {
        return ztyyobin7x3;
    }

    public void setZtyyobin7x3(Integer pZtyyobin7x3) {
        ztyyobin7x3 = pZtyyobin7x3;
    }

    private Integer ztyyobin7x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN7X4)
    public Integer getZtyyobin7x4() {
        return ztyyobin7x4;
    }

    public void setZtyyobin7x4(Integer pZtyyobin7x4) {
        ztyyobin7x4 = pZtyyobin7x4;
    }

    private Integer ztyyobin7x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN7X5)
    public Integer getZtyyobin7x5() {
        return ztyyobin7x5;
    }

    public void setZtyyobin7x5(Integer pZtyyobin7x5) {
        ztyyobin7x5 = pZtyyobin7x5;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyyobiv59;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIV59)
    public String getZtyyobiv59() {
        return ztyyobiv59;
    }

    public void setZtyyobiv59(String pZtyyobiv59) {
        ztyyobiv59 = pZtyyobiv59;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private Long ztygaikadatekihons;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGAIKADATEKIHONS)
    public Long getZtygaikadatekihons() {
        return ztygaikadatekihons;
    }

    public void setZtygaikadatekihons(Long pZtygaikadatekihons) {
        ztygaikadatekihons = pZtygaikadatekihons;
    }

    private Long ztygaikadatesibous;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYGAIKADATESIBOUS)
    public Long getZtygaikadatesibous() {
        return ztygaikadatesibous;
    }

    public void setZtygaikadatesibous(Long pZtygaikadatesibous) {
        ztygaikadatesibous = pZtygaikadatesibous;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_SbRituToukeiSeibiRenTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }
}