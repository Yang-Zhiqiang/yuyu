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
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.id.PKZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.GenQZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenRn;

/**
 * 死亡率統計整備後連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SbRituToukeiSeibiRenRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SbRituToukeiSeibiRenRn}</td><td colspan="3">死亡率統計整備後連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_SbRituToukeiSeibiRenRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikbn zrnsyorikbn}</td><td>（連携用）処理区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyorino zrnsyorino}</td><td>（連携用）処理ＮＯ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukgu zrnsyukgu}</td><td>（連携用）種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykym zrnkykym}</td><td>（連携用）契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokujyouhyouji zrntokujyouhyouji}</td><td>（連携用）特条表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnviphyouji zrnviphyouji}</td><td>（連携用）ＶＩＰ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkisnkihons zrnkisnkihons}</td><td>（連携用）計算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkeisansibous zrnkeisansibous}</td><td>（連携用）計算死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnshrs zrnshrs}</td><td>（連携用）支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnshrymd zrnshrymd}</td><td>（連携用）支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaisisyacd zrnsiharaisisyacd}</td><td>（連携用）支払支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtgenincd zrnsymtgenincd}</td><td>（連携用）消滅原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikaym zrnkeikaym}</td><td>（連携用）経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbugenincd zrnsbugenincd}</td><td>（連携用）死亡原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnen zrndai2hhknnen}</td><td>（連携用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tokujyouhyouji zrndai2tokujyouhyouji}</td><td>（連携用）第２特条表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgu zrntignmrtisyukgu}</td><td>（連携用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikikan zrnteigenmaruteikikan}</td><td>（連携用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeiteigenbubuns zrngoukeiteigenbubuns}</td><td>（連携用）合計逓減部分Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrenseimrtisyukgu zrnrenseimrtisyukgu}</td><td>（連携用）連生マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedsshrarihyj zrnlivingneedsshrarihyj}</td><td>（連携用）リビングニーズ支払有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnkeikaym zrnlnkeikaym}</td><td>（連携用）ＬＮ経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnshrgenincd zrnlnshrgenincd}</td><td>（連携用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenkbn zrnkituenkbn}</td><td>（連携用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenhonsuu zrnkituenhonsuu}</td><td>（連携用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndugktnknsntkhuhukbn zrndugktnknsntkhuhukbn}</td><td>（連携用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjitokujyouarihyj zrnkykjitokujyouarihyj}</td><td>（連携用）契約時特条有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukousinkbn zrntokuyakukousinkbn}</td><td>（連携用）特約更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikisiym zrnteigenmaruteikisiym}</td><td>（連携用）逓減マル定期始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtisyukgu zrnsyunyumrtisyukgu}</td><td>（連携用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumaruteikikan zrnsyuunyuumaruteikikan}</td><td>（連携用）収入マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtinknengkn7 zrnsyuunyuumrtinknengkn7}</td><td>（連携用）収入マル定年金年額Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumaruteikisiym zrnsyuunyuumaruteikisiym}</td><td>（連携用）収入マル定期始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsysnymd zrnsysnymd}</td><td>（連携用）初診年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsindanymd zrnsindanymd}</td><td>（連携用）診断年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd1 zrnbyoumeicd1}</td><td>（連携用）病名コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd2 zrnbyoumeicd2}</td><td>（連携用）病名コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnaiyoukbn zrnshrnaiyoukbn}</td><td>（連携用）支払内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngituyuknkbn1 zrngituyuknkbn1}</td><td>（連携用）該当要件区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngituyuknkbn2 zrngituyuknkbn2}</td><td>（連携用）該当要件区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyeiebnri1 zrnsyeiebnri1}</td><td>（連携用）シェイエ分類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyeiebnri2 zrnsyeiebnri2}</td><td>（連携用）シェイエ分類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminnesotacd1 zrnminnesotacd1}</td><td>（連携用）ミネソタコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminnesotacd2 zrnminnesotacd2}</td><td>（連携用）ミネソタコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminnesotacd3 zrnminnesotacd3}</td><td>（連携用）ミネソタコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminnesotacd4 zrnminnesotacd4}</td><td>（連携用）ミネソタコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminnesotacd5 zrnminnesotacd5}</td><td>（連携用）ミネソタコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsisiensindanjiyuu zrnmnsisiensindanjiyuu}</td><td>（連携用）慢性膵炎診断事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuhnsindanjiyuu zrnknkuhnsindanjiyuu}</td><td>（連携用）肝硬変診断事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhushrkbn zrnhushrkbn}</td><td>（連携用）不支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhushrym zrnhushrym}</td><td>（連携用）不支払年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtinkshrkkn zrnsyuunyuumrtinkshrkkn}</td><td>（連携用）収入マル定年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokujyousakugenkikan zrntokujyousakugenkikan}</td><td>（連携用）特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakutenkankykhyj zrngengakutenkankykhyj}</td><td>（連携用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikomihouhou zrnharaikomihouhou}</td><td>（連携用）払込方法</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsahouhou zrnsinsahouhou}</td><td>（連携用）診査方法</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyutksytioukbn zrnkykniyutksytioukbn}</td><td>（連携用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnduyuryumshyutn zrnrnduyuryumshyutn}</td><td>（連携用）連動用料増標点</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanpobui1 zrnhutanpobui1}</td><td>（連携用）不担保部位１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn1 zrnhtnpkkn1}</td><td>（連携用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanpobui2 zrnhutanpobui2}</td><td>（連携用）不担保部位２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn2 zrnhtnpkkn2}</td><td>（連携用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukasyuksyu zrnhukasyuksyu}</td><td>（連携用）付加主契約種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoutokuyakukbn zrnsuuriyoutokuyakukbn}</td><td>（連携用）数理用特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuno zrntokuyakuno}</td><td>（連携用）特約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkusnmetkyksykipjyutuym zrnkusnmetkyksykipjyutuym}</td><td>（連携用）更新前特約初回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykikjgykbn zrnsykikjgykbn}</td><td>（連携用）職域事業区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanminaosikbn zrntenkanminaosikbn}</td><td>（連携用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaijyokbn zrnkaijyokbn}</td><td>（連携用）解除区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuruihenkouarihyouji zrnsyuruihenkouarihyouji}</td><td>（連携用）種類変更有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyasonzokuhyj zrndai2hihokensyasonzokuhyj}</td><td>（連携用）第２被保険者存続表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukigou zrnsyukeiyakukigou}</td><td>（連携用）主契約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuutohukatkhyj zrntyuutohukatkhyj}</td><td>（連携用）中途付加特約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukigjyutigituymd zrnyoukigjyutigituymd}</td><td>（連携用）要介護状態該当年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukigjyutigeninkbn zrnyoukigjyutigeninkbn}</td><td>（連携用）要介護状態原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykmtssyukahikbn zrnsykmtssyukahikbn}</td><td>（連携用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfktrsmtkahikbn zrnfktrsmtkahikbn}</td><td>（連携用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokoukahikbn zrnhokoukahikbn}</td><td>（連携用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyykkahikbn zrnnyykkahikbn}</td><td>（連携用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnihukutyakudatukahikbn zrnihukutyakudatukahikbn}</td><td>（連携用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntihougeninkbn zrntihougeninkbn}</td><td>（連携用）痴呆原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukgusdkbn zrnsyukgusdkbn}</td><td>（連携用）種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgusdkbn zrntignmrtisyukgusdkbn}</td><td>（連携用）逓減マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenseimrtisyukgusdkbn zrnrenseimrtisyukgusdkbn}</td><td>（連携用）連生マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtisyukgusdkbn zrnsyunyumrtisyukgusdkbn}</td><td>（連携用）収入マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykyksyuruikgusdkbn zrnsykyksyuruikgusdkbn}</td><td>（連携用）主契約種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhukakbn zrnpmenhukakbn}</td><td>（連携用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv2 zrnpmenkbnv2}</td><td>（連携用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenjikohasseiymd zrnpmenjikohasseiymd}</td><td>（連携用）Ｐ免事故発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeirokbn zrnbosyuukeirokbn}</td><td>（連携用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorinov2 zrnsyorinov2}</td><td>（連携用）処理番号Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigkyhsitihsyutkykhyj zrnkigkyhsitihsyutkykhyj}</td><td>（連携用）介護給付最低保証特約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpobui1 zrnpmenhutanpobui1}</td><td>（連携用）Ｐ免不担保部位１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpokikan1 zrnpmenhutanpokikan1}</td><td>（連携用）Ｐ免不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpobui2 zrnpmenhutanpobui2}</td><td>（連携用）Ｐ免不担保部位２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpokikan2 zrnpmenhutanpokikan2}</td><td>（連携用）Ｐ免不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyujidatakanrino zrnkanyujidatakanrino}</td><td>（連携用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktgsnzkkykdatakanrino zrnbnktgsnzkkykdatakanrino}</td><td>（連携用）分割後存続契約データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkttnknkbn zrnbnkttnknkbn}</td><td>（連携用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktjisisttkarihyj zrnbnktjisisttkarihyj}</td><td>（連携用）分割時災疾特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncareneedssiharaihyouji zrncareneedssiharaihyouji}</td><td>（連携用）ケアニーズ支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktjitiktkarihyj zrnbnktjitiktkarihyj}</td><td>（連携用）分割時定期特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinkbn zrnkousinkbn}</td><td>（連携用）更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnym zrnksnym}</td><td>（連携用）更新年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeiyuksnhyj zrnijitoukeiyuksnhyj}</td><td>（連携用）医事統計用更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikoujisnskbn zrnikoujisnskbn}</td><td>（連携用）移行時診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1 zrnsuuriyouyobin1}</td><td>（連携用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnimustiyusbus zrnimustiyusbus}</td><td>（連携用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkeisansykykbbnkhns zrnkeisansykykbbnkhns}</td><td>（連携用）計算主契約部分基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoubosyuukeitaikbn zrnsuuriyoubosyuukeitaikbn}</td><td>（連携用）数理用募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsysnikoujiym zrnsysnikoujiym}</td><td>（連携用）終身移行時年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrhyj zrngnspshrhyj}</td><td>（連携用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrkeikaym zrngnspshrkeikaym}</td><td>（連携用）がんサポ支払経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrgenincd zrngnspshrgenincd}</td><td>（連携用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnngerkahikbn zrnngerkahikbn}</td><td>（連携用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenhoutekiyouhyouji zrnhokenhoutekiyouhyouji}</td><td>（連携用）保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisansyukeiyakup zrnkeisansyukeiyakup}</td><td>（連携用）計算主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisangoukeitenkans zrnkeisangoukeitenkans}</td><td>（連携用）計算合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkeisangoukeitenkankakaku zrnkeisangoukeitenkankakaku}</td><td>（連携用）計算合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkisnwnsgukitnknkakaku zrnkisnwnsgukitnknkakaku}</td><td>（連携用）計算Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntnknkhnbbnjyuturt zrntnknkhnbbnjyuturt}</td><td>（連携用）転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnharaizumiymd zrnharaizumiymd}</td><td>（連携用）払済年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdsstkjytkyuhyj zrnstdsstkjytkyuhyj}</td><td>（連携用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisanyoteiriritu zrnkeisanyoteiriritu}</td><td>（連携用）計算予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnseiketuseiyoukahikbn zrnseiketuseiyoukahikbn}</td><td>（連携用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuurouhunoukgjyoutaikbn zrnsyuurouhunoukgjyoutaikbn}</td><td>（連携用）就労不能介護状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuurouhunoujyoutaikbn zrnsyuurouhunoujyoutaikbn}</td><td>（連携用）就労不能状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznkyhsyoubyouhasseiymd zrnsiznkyhsyoubyouhasseiymd}</td><td>（連携用）生前給付傷病発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyusisnknkuskgitukbn zrnkyusisnknkuskgitukbn}</td><td>（連携用）急性心筋梗塞該当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnousottyuugaitoukbn zrnnousottyuugaitoukbn}</td><td>（連携用）脳卒中該当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjinhuzengaitoukbn zrnjinhuzengaitoukbn}</td><td>（連携用）腎不全該当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndoumyakusikkangaitoukbn zrndoumyakusikkangaitoukbn}</td><td>（連携用）動脈疾患該当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino2 zrndatakanrino2}</td><td>（連携用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino3 zrndatakanrino3}</td><td>（連携用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkeiyakujivithkhyouji zrnsinkeiyakujivithkhyouji}</td><td>（連携用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtsiyounendo zrnknkuzusnzyrtsiyounendo}</td><td>（連携用）健康増進乗率使用年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvittkykkaiyakuymd zrnvittkykkaiyakuymd}</td><td>（連携用）Ｖｉｔ特約解約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwrbksidhitekiyouhyj zrnpwrbksidhitekiyouhyj}</td><td>（連携用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnintisyougeninkbn zrnnintisyougeninkbn}</td><td>（連携用）認知症原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x2 zrnsuuriyouyobin1x2}</td><td>（連携用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x3 zrnsuuriyouyobin8x3}</td><td>（連携用）数理用予備項目Ｎ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x4 zrnsuuriyouyobin8x4}</td><td>（連携用）数理用予備項目Ｎ８＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x5 zrnsuuriyouyobin8x5}</td><td>（連携用）数理用予備項目Ｎ８＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x6 zrnsuuriyouyobin8x6}</td><td>（連携用）数理用予備項目Ｎ８＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x7 zrnsuuriyouyobin8x7}</td><td>（連携用）数理用予備項目Ｎ８＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x8 zrnsuuriyouyobin8x8}</td><td>（連携用）数理用予備項目Ｎ８＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x9 zrnsuuriyouyobin8x9}</td><td>（連携用）数理用予備項目Ｎ８＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8x10 zrnsuuriyouyobin8x10}</td><td>（連携用）数理用予備項目Ｎ８＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin7 zrnyobin7}</td><td>（連携用）予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x2 zrnyobin7x2}</td><td>（連携用）予備項目Ｎ７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x3 zrnyobin7x3}</td><td>（連携用）予備項目Ｎ７＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x4 zrnyobin7x4}</td><td>（連携用）予備項目Ｎ７＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x5 zrnyobin7x5}</td><td>（連携用）予備項目Ｎ７＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv59 zrnyobiv59}</td><td>（連携用）予備項目Ｖ５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikadatekihons zrngaikadatekihons}</td><td>（連携用）外貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesibous zrngaikadatesibous}</td><td>（連携用）外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SbRituToukeiSeibiRenRn
 * @see     PKZT_SbRituToukeiSeibiRenRn
 * @see     QZT_SbRituToukeiSeibiRenRn
 * @see     GenQZT_SbRituToukeiSeibiRenRn
 */
@MappedSuperclass
@Table(name=GenZT_SbRituToukeiSeibiRenRn.TABLE_NAME)
@IdClass(value=PKZT_SbRituToukeiSeibiRenRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SbRituToukeiSeibiRenRn extends AbstractExDBEntityForZDB<ZT_SbRituToukeiSeibiRenRn, PKZT_SbRituToukeiSeibiRenRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SbRituToukeiSeibiRenRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNSYORIKBN              = "zrnsyorikbn";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNKYKMFKSNCTR           = "zrnkykmfksnctr";
    public static final String ZRNSYORINO               = "zrnsyorino";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNSYUKGU                = "zrnsyukgu";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKYM                 = "zrnkykym";
    public static final String ZRNTOKUJYOUHYOUJI        = "zrntokujyouhyouji";
    public static final String ZRNVIPHYOUJI             = "zrnviphyouji";
    public static final String ZRNKISNKIHONS            = "zrnkisnkihons";
    public static final String ZRNKEISANSIBOUS          = "zrnkeisansibous";
    public static final String ZRNSHRS                  = "zrnshrs";
    public static final String ZRNSHRYMD                = "zrnshrymd";
    public static final String ZRNSIHARAISISYACD        = "zrnsiharaisisyacd";
    public static final String ZRNSYMTGENINCD           = "zrnsymtgenincd";
    public static final String ZRNKEIKAYM               = "zrnkeikaym";
    public static final String ZRNSBUGENINCD            = "zrnsbugenincd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNDAI2HHKNNEN           = "zrndai2hhknnen";
    public static final String ZRNDAI2TOKUJYOUHYOUJI    = "zrndai2tokujyouhyouji";
    public static final String ZRNTIGNMRTISYUKGU        = "zrntignmrtisyukgu";
    public static final String ZRNTEIGENMARUTEIKIKAN    = "zrnteigenmaruteikikan";
    public static final String ZRNGOUKEITEIGENBUBUNS    = "zrngoukeiteigenbubuns";
    public static final String ZRNRENSEIMRTISYUKGU      = "zrnrenseimrtisyukgu";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNLIVINGNEEDSSHRARIHYJ  = "zrnlivingneedsshrarihyj";
    public static final String ZRNLNKEIKAYM             = "zrnlnkeikaym";
    public static final String ZRNLNSHRGENINCD          = "zrnlnshrgenincd";
    public static final String ZRNKITUENKBN             = "zrnkituenkbn";
    public static final String ZRNKITUENHONSUU          = "zrnkituenhonsuu";
    public static final String ZRNDUGKTNKNSNTKHUHUKBN   = "zrndugktnknsntkhuhukbn";
    public static final String ZRNKYKJITOKUJYOUARIHYJ   = "zrnkykjitokujyouarihyj";
    public static final String ZRNTOKUYAKUKOUSINKBN     = "zrntokuyakukousinkbn";
    public static final String ZRNTEIGENMARUTEIKISIYM   = "zrnteigenmaruteikisiym";
    public static final String ZRNSYUNYUMRTISYUKGU      = "zrnsyunyumrtisyukgu";
    public static final String ZRNSYUUNYUUMARUTEIKIKAN  = "zrnsyuunyuumaruteikikan";
    public static final String ZRNSYUUNYUUMRTINKNENGKN7 = "zrnsyuunyuumrtinknengkn7";
    public static final String ZRNSYUUNYUUMARUTEIKISIYM = "zrnsyuunyuumaruteikisiym";
    public static final String ZRNSYSNYMD               = "zrnsysnymd";
    public static final String ZRNSINDANYMD             = "zrnsindanymd";
    public static final String ZRNBYOUMEICD1            = "zrnbyoumeicd1";
    public static final String ZRNBYOUMEICD2            = "zrnbyoumeicd2";
    public static final String ZRNSHRNAIYOUKBN          = "zrnshrnaiyoukbn";
    public static final String ZRNGITUYUKNKBN1          = "zrngituyuknkbn1";
    public static final String ZRNGITUYUKNKBN2          = "zrngituyuknkbn2";
    public static final String ZRNSYEIEBNRI1            = "zrnsyeiebnri1";
    public static final String ZRNSYEIEBNRI2            = "zrnsyeiebnri2";
    public static final String ZRNMINNESOTACD1          = "zrnminnesotacd1";
    public static final String ZRNMINNESOTACD2          = "zrnminnesotacd2";
    public static final String ZRNMINNESOTACD3          = "zrnminnesotacd3";
    public static final String ZRNMINNESOTACD4          = "zrnminnesotacd4";
    public static final String ZRNMINNESOTACD5          = "zrnminnesotacd5";
    public static final String ZRNMNSISIENSINDANJIYUU   = "zrnmnsisiensindanjiyuu";
    public static final String ZRNKNKUHNSINDANJIYUU     = "zrnknkuhnsindanjiyuu";
    public static final String ZRNHUSHRKBN              = "zrnhushrkbn";
    public static final String ZRNHUSHRYM               = "zrnhushrym";
    public static final String ZRNSYUUNYUUMRTINKSHRKKN  = "zrnsyuunyuumrtinkshrkkn";
    public static final String ZRNTOKUJYOUSAKUGENKIKAN  = "zrntokujyousakugenkikan";
    public static final String ZRNGENGAKUTENKANKYKHYJ   = "zrngengakutenkankykhyj";
    public static final String ZRNHARAIKOMIHOUHOU       = "zrnharaikomihouhou";
    public static final String ZRNSINSAHOUHOU           = "zrnsinsahouhou";
    public static final String ZRNKYKNIYUTKSYTIOUKBN    = "zrnkykniyutksytioukbn";
    public static final String ZRNRNDUYURYUMSHYUTN      = "zrnrnduyuryumshyutn";
    public static final String ZRNHUTANPOBUI1           = "zrnhutanpobui1";
    public static final String ZRNHTNPKKN1              = "zrnhtnpkkn1";
    public static final String ZRNHUTANPOBUI2           = "zrnhutanpobui2";
    public static final String ZRNHTNPKKN2              = "zrnhtnpkkn2";
    public static final String ZRNHUKASYUKSYU           = "zrnhukasyuksyu";
    public static final String ZRNSUURIYOUTOKUYAKUKBN   = "zrnsuuriyoutokuyakukbn";
    public static final String ZRNTOKUYAKUNO            = "zrntokuyakuno";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNKUSNMETKYKSYKIPJYUTUYM = "zrnkusnmetkyksykipjyutuym";
    public static final String ZRNSYKIKJGYKBN           = "zrnsykikjgykbn";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNTENKANMINAOSIKBN      = "zrntenkanminaosikbn";
    public static final String ZRNKAIJYOKBN             = "zrnkaijyokbn";
    public static final String ZRNSYURUIHENKOUARIHYOUJI = "zrnsyuruihenkouarihyouji";
    public static final String ZRNDAI2HIHOKENSYASONZOKUHYJ = "zrndai2hihokensyasonzokuhyj";
    public static final String ZRNSYUKEIYAKUKIGOU       = "zrnsyukeiyakukigou";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNTYUUTOHUKATKHYJ       = "zrntyuutohukatkhyj";
    public static final String ZRNYOUKIGJYUTIGITUYMD    = "zrnyoukigjyutigituymd";
    public static final String ZRNYOUKIGJYUTIGENINKBN   = "zrnyoukigjyutigeninkbn";
    public static final String ZRNSYKMTSSYUKAHIKBN      = "zrnsykmtssyukahikbn";
    public static final String ZRNFKTRSMTKAHIKBN        = "zrnfktrsmtkahikbn";
    public static final String ZRNHOKOUKAHIKBN          = "zrnhokoukahikbn";
    public static final String ZRNNYYKKAHIKBN           = "zrnnyykkahikbn";
    public static final String ZRNIHUKUTYAKUDATUKAHIKBN = "zrnihukutyakudatukahikbn";
    public static final String ZRNTIHOUGENINKBN         = "zrntihougeninkbn";
    public static final String ZRNSYUKGUSDKBN           = "zrnsyukgusdkbn";
    public static final String ZRNTIGNMRTISYUKGUSDKBN   = "zrntignmrtisyukgusdkbn";
    public static final String ZRNRENSEIMRTISYUKGUSDKBN = "zrnrenseimrtisyukgusdkbn";
    public static final String ZRNSYUNYUMRTISYUKGUSDKBN = "zrnsyunyumrtisyukgusdkbn";
    public static final String ZRNSYKYKSYURUIKGUSDKBN   = "zrnsykyksyuruikgusdkbn";
    public static final String ZRNPMENHUKAKBN           = "zrnpmenhukakbn";
    public static final String ZRNPMENKBNV2             = "zrnpmenkbnv2";
    public static final String ZRNPMENJIKOHASSEIYMD     = "zrnpmenjikohasseiymd";
    public static final String ZRNBOSYUUKEIROKBN        = "zrnbosyuukeirokbn";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNSYORINOV2             = "zrnsyorinov2";
    public static final String ZRNKIGKYHSITIHSYUTKYKHYJ = "zrnkigkyhsitihsyutkykhyj";
    public static final String ZRNPMENHUTANPOBUI1       = "zrnpmenhutanpobui1";
    public static final String ZRNPMENHUTANPOKIKAN1     = "zrnpmenhutanpokikan1";
    public static final String ZRNPMENHUTANPOBUI2       = "zrnpmenhutanpobui2";
    public static final String ZRNPMENHUTANPOKIKAN2     = "zrnpmenhutanpokikan2";
    public static final String ZRNKANYUJIDATAKANRINO    = "zrnkanyujidatakanrino";
    public static final String ZRNBNKTGSNZKKYKDATAKANRINO = "zrnbnktgsnzkkykdatakanrino";
    public static final String ZRNBNKTTNKNKBN           = "zrnbnkttnknkbn";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNBNKTJISISTTKARIHYJ    = "zrnbnktjisisttkarihyj";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNCARENEEDSSIHARAIHYOUJI = "zrncareneedssiharaihyouji";
    public static final String ZRNBNKTJITIKTKARIHYJ     = "zrnbnktjitiktkarihyj";
    public static final String ZRNKOUSINKBN             = "zrnkousinkbn";
    public static final String ZRNKSNYM                 = "zrnksnym";
    public static final String ZRNIJITOUKEIYUKSNHYJ     = "zrnijitoukeiyuksnhyj";
    public static final String ZRNIKOUJISNSKBN          = "zrnikoujisnskbn";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNSUURIYOUYOBIN1        = "zrnsuuriyouyobin1";
    public static final String ZRNIMUSTIYUSBUS          = "zrnimustiyusbus";
    public static final String ZRNKEISANSYKYKBBNKHNS    = "zrnkeisansykykbbnkhns";
    public static final String ZRNSUURIYOUBOSYUUKEITAIKBN = "zrnsuuriyoubosyuukeitaikbn";
    public static final String ZRNSYSNIKOUJIYM          = "zrnsysnikoujiym";
    public static final String ZRNGNSPSHRHYJ            = "zrngnspshrhyj";
    public static final String ZRNGNSPSHRKEIKAYM        = "zrngnspshrkeikaym";
    public static final String ZRNGNSPSHRGENINCD        = "zrngnspshrgenincd";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNNGERKAHIKBN           = "zrnngerkahikbn";
    public static final String ZRNHOKENHOUTEKIYOUHYOUJI = "zrnhokenhoutekiyouhyouji";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNKEISANSYUKEIYAKUP     = "zrnkeisansyukeiyakup";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNKEISANGOUKEITENKANS   = "zrnkeisangoukeitenkans";
    public static final String ZRNKEISANGOUKEITENKANKAKAKU = "zrnkeisangoukeitenkankakaku";
    public static final String ZRNKISNWNSGUKITNKNKAKAKU = "zrnkisnwnsgukitnknkakaku";
    public static final String ZRNTNKNKHNBBNJYUTURT     = "zrntnknkhnbbnjyuturt";
    public static final String ZRNHARAIZUMIYMD          = "zrnharaizumiymd";
    public static final String ZRNSTDSSTKJYTKYUHYJ      = "zrnstdsstkjytkyuhyj";
    public static final String ZRNKEISANYOTEIRIRITU     = "zrnkeisanyoteiriritu";
    public static final String ZRNSEIKETUSEIYOUKAHIKBN  = "zrnseiketuseiyoukahikbn";
    public static final String ZRNSYUUROUHUNOUKGJYOUTAIKBN = "zrnsyuurouhunoukgjyoutaikbn";
    public static final String ZRNSYUUROUHUNOUJYOUTAIKBN = "zrnsyuurouhunoujyoutaikbn";
    public static final String ZRNSIZNKYHSYOUBYOUHASSEIYMD = "zrnsiznkyhsyoubyouhasseiymd";
    public static final String ZRNKYUSISNKNKUSKGITUKBN  = "zrnkyusisnknkuskgitukbn";
    public static final String ZRNNOUSOTTYUUGAITOUKBN   = "zrnnousottyuugaitoukbn";
    public static final String ZRNJINHUZENGAITOUKBN     = "zrnjinhuzengaitoukbn";
    public static final String ZRNDOUMYAKUSIKKANGAITOUKBN = "zrndoumyakusikkangaitoukbn";
    public static final String ZRNDATAKANRINO2          = "zrndatakanrino2";
    public static final String ZRNDATAKANRINO3          = "zrndatakanrino3";
    public static final String ZRNSINKEIYAKUJIVITHKHYOUJI = "zrnsinkeiyakujivithkhyouji";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNKNKUZUSNZYRTSIYOUNENDO = "zrnknkuzusnzyrtsiyounendo";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNVITTKYKKAIYAKUYMD     = "zrnvittkykkaiyakuymd";
    public static final String ZRNPWRBKSIDHITEKIYOUHYJ  = "zrnpwrbksidhitekiyouhyj";
    public static final String ZRNNINTISYOUGENINKBN     = "zrnnintisyougeninkbn";
    public static final String ZRNSUURIYOUYOBIN1X2      = "zrnsuuriyouyobin1x2";
    public static final String ZRNSUURIYOUYOBIN8X3      = "zrnsuuriyouyobin8x3";
    public static final String ZRNSUURIYOUYOBIN8X4      = "zrnsuuriyouyobin8x4";
    public static final String ZRNSUURIYOUYOBIN8X5      = "zrnsuuriyouyobin8x5";
    public static final String ZRNSUURIYOUYOBIN8X6      = "zrnsuuriyouyobin8x6";
    public static final String ZRNSUURIYOUYOBIN8X7      = "zrnsuuriyouyobin8x7";
    public static final String ZRNSUURIYOUYOBIN8X8      = "zrnsuuriyouyobin8x8";
    public static final String ZRNSUURIYOUYOBIN8X9      = "zrnsuuriyouyobin8x9";
    public static final String ZRNSUURIYOUYOBIN8X10     = "zrnsuuriyouyobin8x10";
    public static final String ZRNYOBIN7                = "zrnyobin7";
    public static final String ZRNYOBIN7X2              = "zrnyobin7x2";
    public static final String ZRNYOBIN7X3              = "zrnyobin7x3";
    public static final String ZRNYOBIN7X4              = "zrnyobin7x4";
    public static final String ZRNYOBIN7X5              = "zrnyobin7x5";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNYOBIV59               = "zrnyobiv59";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNGAIKADATEKIHONS       = "zrngaikadatekihons";
    public static final String ZRNGAIKADATESIBOUS       = "zrngaikadatesibous";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIV4                = "zrnyobiv4";

    private final PKZT_SbRituToukeiSeibiRenRn primaryKey;

    public GenZT_SbRituToukeiSeibiRenRn() {
        primaryKey = new PKZT_SbRituToukeiSeibiRenRn();
    }

    public GenZT_SbRituToukeiSeibiRenRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_SbRituToukeiSeibiRenRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_SbRituToukeiSeibiRenRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SbRituToukeiSeibiRenRn> getMetaClass() {
        return QZT_SbRituToukeiSeibiRenRn.class;
    }

    @Id
    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnyobiv12;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnsyorikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYORIKBN)
    public String getZrnsyorikbn() {
        return zrnsyorikbn;
    }

    public void setZrnsyorikbn(String pZrnsyorikbn) {
        zrnsyorikbn = pZrnsyorikbn;
    }

    private String zrnsyoriymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }

    private Integer zrnkykmfksnctr;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYKMFKSNCTR)
    public Integer getZrnkykmfksnctr() {
        return zrnkykmfksnctr;
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

    private String zrnsyorino;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYORINO)
    public String getZrnsyorino() {
        return zrnsyorino;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyorino(String pZrnsyorino) {
        zrnsyorino = pZrnsyorino;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnsyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUKGU)
    public String getZrnsyukgu() {
        return zrnsyukgu;
    }

    public void setZrnsyukgu(String pZrnsyukgu) {
        zrnsyukgu = pZrnsyukgu;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkykym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYKYM)
    public String getZrnkykym() {
        return zrnkykym;
    }

    public void setZrnkykym(String pZrnkykym) {
        zrnkykym = pZrnkykym;
    }

    private String zrntokujyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUJYOUHYOUJI)
    public String getZrntokujyouhyouji() {
        return zrntokujyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokujyouhyouji(String pZrntokujyouhyouji) {
        zrntokujyouhyouji = pZrntokujyouhyouji;
    }

    private String zrnviphyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNVIPHYOUJI)
    public String getZrnviphyouji() {
        return zrnviphyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnviphyouji(String pZrnviphyouji) {
        zrnviphyouji = pZrnviphyouji;
    }

    private Integer zrnkisnkihons;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKISNKIHONS)
    public Integer getZrnkisnkihons() {
        return zrnkisnkihons;
    }

    public void setZrnkisnkihons(Integer pZrnkisnkihons) {
        zrnkisnkihons = pZrnkisnkihons;
    }

    private Integer zrnkeisansibous;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANSIBOUS)
    public Integer getZrnkeisansibous() {
        return zrnkeisansibous;
    }

    public void setZrnkeisansibous(Integer pZrnkeisansibous) {
        zrnkeisansibous = pZrnkeisansibous;
    }

    private Integer zrnshrs;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSHRS)
    public Integer getZrnshrs() {
        return zrnshrs;
    }

    public void setZrnshrs(Integer pZrnshrs) {
        zrnshrs = pZrnshrs;
    }

    private String zrnshrymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSHRYMD)
    public String getZrnshrymd() {
        return zrnshrymd;
    }

    public void setZrnshrymd(String pZrnshrymd) {
        zrnshrymd = pZrnshrymd;
    }

    private String zrnsiharaisisyacd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSIHARAISISYACD)
    public String getZrnsiharaisisyacd() {
        return zrnsiharaisisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsiharaisisyacd(String pZrnsiharaisisyacd) {
        zrnsiharaisisyacd = pZrnsiharaisisyacd;
    }

    private String zrnsymtgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYMTGENINCD)
    public String getZrnsymtgenincd() {
        return zrnsymtgenincd;
    }

    public void setZrnsymtgenincd(String pZrnsymtgenincd) {
        zrnsymtgenincd = pZrnsymtgenincd;
    }

    private String zrnkeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEIKAYM)
    public String getZrnkeikaym() {
        return zrnkeikaym;
    }

    public void setZrnkeikaym(String pZrnkeikaym) {
        zrnkeikaym = pZrnkeikaym;
    }

    private String zrnsbugenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSBUGENINCD)
    public String getZrnsbugenincd() {
        return zrnsbugenincd;
    }

    public void setZrnsbugenincd(String pZrnsbugenincd) {
        zrnsbugenincd = pZrnsbugenincd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrndai2hhknnen;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDAI2HHKNNEN)
    public String getZrndai2hhknnen() {
        return zrndai2hhknnen;
    }

    public void setZrndai2hhknnen(String pZrndai2hhknnen) {
        zrndai2hhknnen = pZrndai2hhknnen;
    }

    private String zrndai2tokujyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDAI2TOKUJYOUHYOUJI)
    public String getZrndai2tokujyouhyouji() {
        return zrndai2tokujyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tokujyouhyouji(String pZrndai2tokujyouhyouji) {
        zrndai2tokujyouhyouji = pZrndai2tokujyouhyouji;
    }

    private String zrntignmrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTIGNMRTISYUKGU)
    public String getZrntignmrtisyukgu() {
        return zrntignmrtisyukgu;
    }

    public void setZrntignmrtisyukgu(String pZrntignmrtisyukgu) {
        zrntignmrtisyukgu = pZrntignmrtisyukgu;
    }

    private String zrnteigenmaruteikikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTEIGENMARUTEIKIKAN)
    public String getZrnteigenmaruteikikan() {
        return zrnteigenmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigenmaruteikikan(String pZrnteigenmaruteikikan) {
        zrnteigenmaruteikikan = pZrnteigenmaruteikikan;
    }

    private Integer zrngoukeiteigenbubuns;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGOUKEITEIGENBUBUNS)
    public Integer getZrngoukeiteigenbubuns() {
        return zrngoukeiteigenbubuns;
    }

    public void setZrngoukeiteigenbubuns(Integer pZrngoukeiteigenbubuns) {
        zrngoukeiteigenbubuns = pZrngoukeiteigenbubuns;
    }

    private String zrnrenseimrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNRENSEIMRTISYUKGU)
    public String getZrnrenseimrtisyukgu() {
        return zrnrenseimrtisyukgu;
    }

    public void setZrnrenseimrtisyukgu(String pZrnrenseimrtisyukgu) {
        zrnrenseimrtisyukgu = pZrnrenseimrtisyukgu;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnlivingneedsshrarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNLIVINGNEEDSSHRARIHYJ)
    public String getZrnlivingneedsshrarihyj() {
        return zrnlivingneedsshrarihyj;
    }

    public void setZrnlivingneedsshrarihyj(String pZrnlivingneedsshrarihyj) {
        zrnlivingneedsshrarihyj = pZrnlivingneedsshrarihyj;
    }

    private String zrnlnkeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNLNKEIKAYM)
    public String getZrnlnkeikaym() {
        return zrnlnkeikaym;
    }

    public void setZrnlnkeikaym(String pZrnlnkeikaym) {
        zrnlnkeikaym = pZrnlnkeikaym;
    }

    private String zrnlnshrgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNLNSHRGENINCD)
    public String getZrnlnshrgenincd() {
        return zrnlnshrgenincd;
    }

    public void setZrnlnshrgenincd(String pZrnlnshrgenincd) {
        zrnlnshrgenincd = pZrnlnshrgenincd;
    }

    private String zrnkituenkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKITUENKBN)
    public String getZrnkituenkbn() {
        return zrnkituenkbn;
    }

    public void setZrnkituenkbn(String pZrnkituenkbn) {
        zrnkituenkbn = pZrnkituenkbn;
    }

    private String zrnkituenhonsuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKITUENHONSUU)
    public String getZrnkituenhonsuu() {
        return zrnkituenhonsuu;
    }

    public void setZrnkituenhonsuu(String pZrnkituenhonsuu) {
        zrnkituenhonsuu = pZrnkituenhonsuu;
    }

    private String zrndugktnknsntkhuhukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDUGKTNKNSNTKHUHUKBN)
    public String getZrndugktnknsntkhuhukbn() {
        return zrndugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndugktnknsntkhuhukbn(String pZrndugktnknsntkhuhukbn) {
        zrndugktnknsntkhuhukbn = pZrndugktnknsntkhuhukbn;
    }

    private String zrnkykjitokujyouarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYKJITOKUJYOUARIHYJ)
    public String getZrnkykjitokujyouarihyj() {
        return zrnkykjitokujyouarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykjitokujyouarihyj(String pZrnkykjitokujyouarihyj) {
        zrnkykjitokujyouarihyj = pZrnkykjitokujyouarihyj;
    }

    private String zrntokuyakukousinkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUYAKUKOUSINKBN)
    public String getZrntokuyakukousinkbn() {
        return zrntokuyakukousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukousinkbn(String pZrntokuyakukousinkbn) {
        zrntokuyakukousinkbn = pZrntokuyakukousinkbn;
    }

    private String zrnteigenmaruteikisiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTEIGENMARUTEIKISIYM)
    public String getZrnteigenmaruteikisiym() {
        return zrnteigenmaruteikisiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnteigenmaruteikisiym(String pZrnteigenmaruteikisiym) {
        zrnteigenmaruteikisiym = pZrnteigenmaruteikisiym;
    }

    private String zrnsyunyumrtisyukgu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUNYUMRTISYUKGU)
    public String getZrnsyunyumrtisyukgu() {
        return zrnsyunyumrtisyukgu;
    }

    public void setZrnsyunyumrtisyukgu(String pZrnsyunyumrtisyukgu) {
        zrnsyunyumrtisyukgu = pZrnsyunyumrtisyukgu;
    }

    private String zrnsyuunyuumaruteikikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUNYUUMARUTEIKIKAN)
    public String getZrnsyuunyuumaruteikikan() {
        return zrnsyuunyuumaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuunyuumaruteikikan(String pZrnsyuunyuumaruteikikan) {
        zrnsyuunyuumaruteikikan = pZrnsyuunyuumaruteikikan;
    }

    private Integer zrnsyuunyuumrtinknengkn7;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUNYUUMRTINKNENGKN7)
    public Integer getZrnsyuunyuumrtinknengkn7() {
        return zrnsyuunyuumrtinknengkn7;
    }

    public void setZrnsyuunyuumrtinknengkn7(Integer pZrnsyuunyuumrtinknengkn7) {
        zrnsyuunyuumrtinknengkn7 = pZrnsyuunyuumrtinknengkn7;
    }

    private String zrnsyuunyuumaruteikisiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUNYUUMARUTEIKISIYM)
    public String getZrnsyuunyuumaruteikisiym() {
        return zrnsyuunyuumaruteikisiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsyuunyuumaruteikisiym(String pZrnsyuunyuumaruteikisiym) {
        zrnsyuunyuumaruteikisiym = pZrnsyuunyuumaruteikisiym;
    }

    private String zrnsysnymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYSNYMD)
    public String getZrnsysnymd() {
        return zrnsysnymd;
    }

    public void setZrnsysnymd(String pZrnsysnymd) {
        zrnsysnymd = pZrnsysnymd;
    }

    private String zrnsindanymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSINDANYMD)
    public String getZrnsindanymd() {
        return zrnsindanymd;
    }

    public void setZrnsindanymd(String pZrnsindanymd) {
        zrnsindanymd = pZrnsindanymd;
    }

    private String zrnbyoumeicd1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBYOUMEICD1)
    public String getZrnbyoumeicd1() {
        return zrnbyoumeicd1;
    }

    public void setZrnbyoumeicd1(String pZrnbyoumeicd1) {
        zrnbyoumeicd1 = pZrnbyoumeicd1;
    }

    private String zrnbyoumeicd2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBYOUMEICD2)
    public String getZrnbyoumeicd2() {
        return zrnbyoumeicd2;
    }

    public void setZrnbyoumeicd2(String pZrnbyoumeicd2) {
        zrnbyoumeicd2 = pZrnbyoumeicd2;
    }

    private String zrnshrnaiyoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSHRNAIYOUKBN)
    public String getZrnshrnaiyoukbn() {
        return zrnshrnaiyoukbn;
    }

    public void setZrnshrnaiyoukbn(String pZrnshrnaiyoukbn) {
        zrnshrnaiyoukbn = pZrnshrnaiyoukbn;
    }

    private String zrngituyuknkbn1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGITUYUKNKBN1)
    public String getZrngituyuknkbn1() {
        return zrngituyuknkbn1;
    }

    public void setZrngituyuknkbn1(String pZrngituyuknkbn1) {
        zrngituyuknkbn1 = pZrngituyuknkbn1;
    }

    private String zrngituyuknkbn2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGITUYUKNKBN2)
    public String getZrngituyuknkbn2() {
        return zrngituyuknkbn2;
    }

    public void setZrngituyuknkbn2(String pZrngituyuknkbn2) {
        zrngituyuknkbn2 = pZrngituyuknkbn2;
    }

    private String zrnsyeiebnri1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYEIEBNRI1)
    public String getZrnsyeiebnri1() {
        return zrnsyeiebnri1;
    }

    public void setZrnsyeiebnri1(String pZrnsyeiebnri1) {
        zrnsyeiebnri1 = pZrnsyeiebnri1;
    }

    private String zrnsyeiebnri2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYEIEBNRI2)
    public String getZrnsyeiebnri2() {
        return zrnsyeiebnri2;
    }

    public void setZrnsyeiebnri2(String pZrnsyeiebnri2) {
        zrnsyeiebnri2 = pZrnsyeiebnri2;
    }

    private String zrnminnesotacd1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMINNESOTACD1)
    public String getZrnminnesotacd1() {
        return zrnminnesotacd1;
    }

    public void setZrnminnesotacd1(String pZrnminnesotacd1) {
        zrnminnesotacd1 = pZrnminnesotacd1;
    }

    private String zrnminnesotacd2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMINNESOTACD2)
    public String getZrnminnesotacd2() {
        return zrnminnesotacd2;
    }

    public void setZrnminnesotacd2(String pZrnminnesotacd2) {
        zrnminnesotacd2 = pZrnminnesotacd2;
    }

    private String zrnminnesotacd3;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMINNESOTACD3)
    public String getZrnminnesotacd3() {
        return zrnminnesotacd3;
    }

    public void setZrnminnesotacd3(String pZrnminnesotacd3) {
        zrnminnesotacd3 = pZrnminnesotacd3;
    }

    private String zrnminnesotacd4;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMINNESOTACD4)
    public String getZrnminnesotacd4() {
        return zrnminnesotacd4;
    }

    public void setZrnminnesotacd4(String pZrnminnesotacd4) {
        zrnminnesotacd4 = pZrnminnesotacd4;
    }

    private String zrnminnesotacd5;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMINNESOTACD5)
    public String getZrnminnesotacd5() {
        return zrnminnesotacd5;
    }

    public void setZrnminnesotacd5(String pZrnminnesotacd5) {
        zrnminnesotacd5 = pZrnminnesotacd5;
    }

    private String zrnmnsisiensindanjiyuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNMNSISIENSINDANJIYUU)
    public String getZrnmnsisiensindanjiyuu() {
        return zrnmnsisiensindanjiyuu;
    }

    public void setZrnmnsisiensindanjiyuu(String pZrnmnsisiensindanjiyuu) {
        zrnmnsisiensindanjiyuu = pZrnmnsisiensindanjiyuu;
    }

    private String zrnknkuhnsindanjiyuu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKNKUHNSINDANJIYUU)
    public String getZrnknkuhnsindanjiyuu() {
        return zrnknkuhnsindanjiyuu;
    }

    public void setZrnknkuhnsindanjiyuu(String pZrnknkuhnsindanjiyuu) {
        zrnknkuhnsindanjiyuu = pZrnknkuhnsindanjiyuu;
    }

    private String zrnhushrkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHUSHRKBN)
    public String getZrnhushrkbn() {
        return zrnhushrkbn;
    }

    public void setZrnhushrkbn(String pZrnhushrkbn) {
        zrnhushrkbn = pZrnhushrkbn;
    }

    private String zrnhushrym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHUSHRYM)
    public String getZrnhushrym() {
        return zrnhushrym;
    }

    public void setZrnhushrym(String pZrnhushrym) {
        zrnhushrym = pZrnhushrym;
    }

    private String zrnsyuunyuumrtinkshrkkn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUNYUUMRTINKSHRKKN)
    public String getZrnsyuunyuumrtinkshrkkn() {
        return zrnsyuunyuumrtinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuunyuumrtinkshrkkn(String pZrnsyuunyuumrtinkshrkkn) {
        zrnsyuunyuumrtinkshrkkn = pZrnsyuunyuumrtinkshrkkn;
    }

    private String zrntokujyousakugenkikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUJYOUSAKUGENKIKAN)
    public String getZrntokujyousakugenkikan() {
        return zrntokujyousakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokujyousakugenkikan(String pZrntokujyousakugenkikan) {
        zrntokujyousakugenkikan = pZrntokujyousakugenkikan;
    }

    private String zrngengakutenkankykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGENGAKUTENKANKYKHYJ)
    public String getZrngengakutenkankykhyj() {
        return zrngengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngengakutenkankykhyj(String pZrngengakutenkankykhyj) {
        zrngengakutenkankykhyj = pZrngengakutenkankykhyj;
    }

    private String zrnharaikomihouhou;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHARAIKOMIHOUHOU)
    public String getZrnharaikomihouhou() {
        return zrnharaikomihouhou;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnharaikomihouhou(String pZrnharaikomihouhou) {
        zrnharaikomihouhou = pZrnharaikomihouhou;
    }

    private String zrnsinsahouhou;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSINSAHOUHOU)
    public String getZrnsinsahouhou() {
        return zrnsinsahouhou;
    }

    public void setZrnsinsahouhou(String pZrnsinsahouhou) {
        zrnsinsahouhou = pZrnsinsahouhou;
    }

    private String zrnkykniyutksytioukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYKNIYUTKSYTIOUKBN)
    public String getZrnkykniyutksytioukbn() {
        return zrnkykniyutksytioukbn;
    }

    public void setZrnkykniyutksytioukbn(String pZrnkykniyutksytioukbn) {
        zrnkykniyutksytioukbn = pZrnkykniyutksytioukbn;
    }

    private String zrnrnduyuryumshyutn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNRNDUYURYUMSHYUTN)
    public String getZrnrnduyuryumshyutn() {
        return zrnrnduyuryumshyutn;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnrnduyuryumshyutn(String pZrnrnduyuryumshyutn) {
        zrnrnduyuryumshyutn = pZrnrnduyuryumshyutn;
    }

    private String zrnhutanpobui1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHUTANPOBUI1)
    public String getZrnhutanpobui1() {
        return zrnhutanpobui1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhutanpobui1(String pZrnhutanpobui1) {
        zrnhutanpobui1 = pZrnhutanpobui1;
    }

    private String zrnhtnpkkn1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHTNPKKN1)
    public String getZrnhtnpkkn1() {
        return zrnhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn1(String pZrnhtnpkkn1) {
        zrnhtnpkkn1 = pZrnhtnpkkn1;
    }

    private String zrnhutanpobui2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHUTANPOBUI2)
    public String getZrnhutanpobui2() {
        return zrnhutanpobui2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhutanpobui2(String pZrnhutanpobui2) {
        zrnhutanpobui2 = pZrnhutanpobui2;
    }

    private String zrnhtnpkkn2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHTNPKKN2)
    public String getZrnhtnpkkn2() {
        return zrnhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn2(String pZrnhtnpkkn2) {
        zrnhtnpkkn2 = pZrnhtnpkkn2;
    }

    private String zrnhukasyuksyu;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHUKASYUKSYU)
    public String getZrnhukasyuksyu() {
        return zrnhukasyuksyu;
    }

    public void setZrnhukasyuksyu(String pZrnhukasyuksyu) {
        zrnhukasyuksyu = pZrnhukasyuksyu;
    }

    private String zrnsuuriyoutokuyakukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUTOKUYAKUKBN)
    public String getZrnsuuriyoutokuyakukbn() {
        return zrnsuuriyoutokuyakukbn;
    }

    public void setZrnsuuriyoutokuyakukbn(String pZrnsuuriyoutokuyakukbn) {
        zrnsuuriyoutokuyakukbn = pZrnsuuriyoutokuyakukbn;
    }

    private String zrntokuyakuno;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUYAKUNO)
    public String getZrntokuyakuno() {
        return zrntokuyakuno;
    }

    public void setZrntokuyakuno(String pZrntokuyakuno) {
        zrntokuyakuno = pZrntokuyakuno;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrnkusnmetkyksykipjyutuym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKUSNMETKYKSYKIPJYUTUYM)
    public String getZrnkusnmetkyksykipjyutuym() {
        return zrnkusnmetkyksykipjyutuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnkusnmetkyksykipjyutuym(String pZrnkusnmetkyksykipjyutuym) {
        zrnkusnmetkyksykipjyutuym = pZrnkusnmetkyksykipjyutuym;
    }

    private String zrnsykikjgykbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYKIKJGYKBN)
    public String getZrnsykikjgykbn() {
        return zrnsykikjgykbn;
    }

    public void setZrnsykikjgykbn(String pZrnsykikjgykbn) {
        zrnsykikjgykbn = pZrnsykikjgykbn;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrntenkanminaosikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTENKANMINAOSIKBN)
    public String getZrntenkanminaosikbn() {
        return zrntenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanminaosikbn(String pZrntenkanminaosikbn) {
        zrntenkanminaosikbn = pZrntenkanminaosikbn;
    }

    private String zrnkaijyokbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKAIJYOKBN)
    public String getZrnkaijyokbn() {
        return zrnkaijyokbn;
    }

    public void setZrnkaijyokbn(String pZrnkaijyokbn) {
        zrnkaijyokbn = pZrnkaijyokbn;
    }

    private String zrnsyuruihenkouarihyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYURUIHENKOUARIHYOUJI)
    public String getZrnsyuruihenkouarihyouji() {
        return zrnsyuruihenkouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuruihenkouarihyouji(String pZrnsyuruihenkouarihyouji) {
        zrnsyuruihenkouarihyouji = pZrnsyuruihenkouarihyouji;
    }

    private String zrndai2hihokensyasonzokuhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDAI2HIHOKENSYASONZOKUHYJ)
    public String getZrndai2hihokensyasonzokuhyj() {
        return zrndai2hihokensyasonzokuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyasonzokuhyj(String pZrndai2hihokensyasonzokuhyj) {
        zrndai2hihokensyasonzokuhyj = pZrndai2hihokensyasonzokuhyj;
    }

    private String zrnsyukeiyakukigou;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUKEIYAKUKIGOU)
    public String getZrnsyukeiyakukigou() {
        return zrnsyukeiyakukigou;
    }

    public void setZrnsyukeiyakukigou(String pZrnsyukeiyakukigou) {
        zrnsyukeiyakukigou = pZrnsyukeiyakukigou;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private String zrntyuutohukatkhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTYUUTOHUKATKHYJ)
    public String getZrntyuutohukatkhyj() {
        return zrntyuutohukatkhyj;
    }

    public void setZrntyuutohukatkhyj(String pZrntyuutohukatkhyj) {
        zrntyuutohukatkhyj = pZrntyuutohukatkhyj;
    }

    private String zrnyoukigjyutigituymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOUKIGJYUTIGITUYMD)
    public String getZrnyoukigjyutigituymd() {
        return zrnyoukigjyutigituymd;
    }

    public void setZrnyoukigjyutigituymd(String pZrnyoukigjyutigituymd) {
        zrnyoukigjyutigituymd = pZrnyoukigjyutigituymd;
    }

    private String zrnyoukigjyutigeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOUKIGJYUTIGENINKBN)
    public String getZrnyoukigjyutigeninkbn() {
        return zrnyoukigjyutigeninkbn;
    }

    public void setZrnyoukigjyutigeninkbn(String pZrnyoukigjyutigeninkbn) {
        zrnyoukigjyutigeninkbn = pZrnyoukigjyutigeninkbn;
    }

    private String zrnsykmtssyukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYKMTSSYUKAHIKBN)
    public String getZrnsykmtssyukahikbn() {
        return zrnsykmtssyukahikbn;
    }

    public void setZrnsykmtssyukahikbn(String pZrnsykmtssyukahikbn) {
        zrnsykmtssyukahikbn = pZrnsykmtssyukahikbn;
    }

    private String zrnfktrsmtkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNFKTRSMTKAHIKBN)
    public String getZrnfktrsmtkahikbn() {
        return zrnfktrsmtkahikbn;
    }

    public void setZrnfktrsmtkahikbn(String pZrnfktrsmtkahikbn) {
        zrnfktrsmtkahikbn = pZrnfktrsmtkahikbn;
    }

    private String zrnhokoukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHOKOUKAHIKBN)
    public String getZrnhokoukahikbn() {
        return zrnhokoukahikbn;
    }

    public void setZrnhokoukahikbn(String pZrnhokoukahikbn) {
        zrnhokoukahikbn = pZrnhokoukahikbn;
    }

    private String zrnnyykkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNNYYKKAHIKBN)
    public String getZrnnyykkahikbn() {
        return zrnnyykkahikbn;
    }

    public void setZrnnyykkahikbn(String pZrnnyykkahikbn) {
        zrnnyykkahikbn = pZrnnyykkahikbn;
    }

    private String zrnihukutyakudatukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNIHUKUTYAKUDATUKAHIKBN)
    public String getZrnihukutyakudatukahikbn() {
        return zrnihukutyakudatukahikbn;
    }

    public void setZrnihukutyakudatukahikbn(String pZrnihukutyakudatukahikbn) {
        zrnihukutyakudatukahikbn = pZrnihukutyakudatukahikbn;
    }

    private String zrntihougeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTIHOUGENINKBN)
    public String getZrntihougeninkbn() {
        return zrntihougeninkbn;
    }

    public void setZrntihougeninkbn(String pZrntihougeninkbn) {
        zrntihougeninkbn = pZrntihougeninkbn;
    }

    private String zrnsyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUKGUSDKBN)
    public String getZrnsyukgusdkbn() {
        return zrnsyukgusdkbn;
    }

    public void setZrnsyukgusdkbn(String pZrnsyukgusdkbn) {
        zrnsyukgusdkbn = pZrnsyukgusdkbn;
    }

    private String zrntignmrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTIGNMRTISYUKGUSDKBN)
    public String getZrntignmrtisyukgusdkbn() {
        return zrntignmrtisyukgusdkbn;
    }

    public void setZrntignmrtisyukgusdkbn(String pZrntignmrtisyukgusdkbn) {
        zrntignmrtisyukgusdkbn = pZrntignmrtisyukgusdkbn;
    }

    private String zrnrenseimrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNRENSEIMRTISYUKGUSDKBN)
    public String getZrnrenseimrtisyukgusdkbn() {
        return zrnrenseimrtisyukgusdkbn;
    }

    public void setZrnrenseimrtisyukgusdkbn(String pZrnrenseimrtisyukgusdkbn) {
        zrnrenseimrtisyukgusdkbn = pZrnrenseimrtisyukgusdkbn;
    }

    private String zrnsyunyumrtisyukgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUNYUMRTISYUKGUSDKBN)
    public String getZrnsyunyumrtisyukgusdkbn() {
        return zrnsyunyumrtisyukgusdkbn;
    }

    public void setZrnsyunyumrtisyukgusdkbn(String pZrnsyunyumrtisyukgusdkbn) {
        zrnsyunyumrtisyukgusdkbn = pZrnsyunyumrtisyukgusdkbn;
    }

    private String zrnsykyksyuruikgusdkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYKYKSYURUIKGUSDKBN)
    public String getZrnsykyksyuruikgusdkbn() {
        return zrnsykyksyuruikgusdkbn;
    }

    public void setZrnsykyksyuruikgusdkbn(String pZrnsykyksyuruikgusdkbn) {
        zrnsykyksyuruikgusdkbn = pZrnsykyksyuruikgusdkbn;
    }

    private String zrnpmenhukakbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENHUKAKBN)
    public String getZrnpmenhukakbn() {
        return zrnpmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhukakbn(String pZrnpmenhukakbn) {
        zrnpmenhukakbn = pZrnpmenhukakbn;
    }

    private String zrnpmenkbnv2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENKBNV2)
    public String getZrnpmenkbnv2() {
        return zrnpmenkbnv2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenkbnv2(String pZrnpmenkbnv2) {
        zrnpmenkbnv2 = pZrnpmenkbnv2;
    }

    private String zrnpmenjikohasseiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENJIKOHASSEIYMD)
    public String getZrnpmenjikohasseiymd() {
        return zrnpmenjikohasseiymd;
    }

    public void setZrnpmenjikohasseiymd(String pZrnpmenjikohasseiymd) {
        zrnpmenjikohasseiymd = pZrnpmenjikohasseiymd;
    }

    private String zrnbosyuukeirokbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBOSYUUKEIROKBN)
    public String getZrnbosyuukeirokbn() {
        return zrnbosyuukeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbosyuukeirokbn(String pZrnbosyuukeirokbn) {
        zrnbosyuukeirokbn = pZrnbosyuukeirokbn;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnsyorinov2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYORINOV2)
    public String getZrnsyorinov2() {
        return zrnsyorinov2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyorinov2(String pZrnsyorinov2) {
        zrnsyorinov2 = pZrnsyorinov2;
    }

    private String zrnkigkyhsitihsyutkykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKIGKYHSITIHSYUTKYKHYJ)
    public String getZrnkigkyhsitihsyutkykhyj() {
        return zrnkigkyhsitihsyutkykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigkyhsitihsyutkykhyj(String pZrnkigkyhsitihsyutkykhyj) {
        zrnkigkyhsitihsyutkykhyj = pZrnkigkyhsitihsyutkykhyj;
    }

    private String zrnpmenhutanpobui1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENHUTANPOBUI1)
    public String getZrnpmenhutanpobui1() {
        return zrnpmenhutanpobui1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpobui1(String pZrnpmenhutanpobui1) {
        zrnpmenhutanpobui1 = pZrnpmenhutanpobui1;
    }

    private String zrnpmenhutanpokikan1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENHUTANPOKIKAN1)
    public String getZrnpmenhutanpokikan1() {
        return zrnpmenhutanpokikan1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpokikan1(String pZrnpmenhutanpokikan1) {
        zrnpmenhutanpokikan1 = pZrnpmenhutanpokikan1;
    }

    private String zrnpmenhutanpobui2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENHUTANPOBUI2)
    public String getZrnpmenhutanpobui2() {
        return zrnpmenhutanpobui2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpobui2(String pZrnpmenhutanpobui2) {
        zrnpmenhutanpobui2 = pZrnpmenhutanpobui2;
    }

    private String zrnpmenhutanpokikan2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPMENHUTANPOKIKAN2)
    public String getZrnpmenhutanpokikan2() {
        return zrnpmenhutanpokikan2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpokikan2(String pZrnpmenhutanpokikan2) {
        zrnpmenhutanpokikan2 = pZrnpmenhutanpokikan2;
    }

    private String zrnkanyujidatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKANYUJIDATAKANRINO)
    public String getZrnkanyujidatakanrino() {
        return zrnkanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnkanyujidatakanrino(String pZrnkanyujidatakanrino) {
        zrnkanyujidatakanrino = pZrnkanyujidatakanrino;
    }

    private String zrnbnktgsnzkkykdatakanrino;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBNKTGSNZKKYKDATAKANRINO)
    public String getZrnbnktgsnzkkykdatakanrino() {
        return zrnbnktgsnzkkykdatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnbnktgsnzkkykdatakanrino(String pZrnbnktgsnzkkykdatakanrino) {
        zrnbnktgsnzkkykdatakanrino = pZrnbnktgsnzkkykdatakanrino;
    }

    private String zrnbnkttnknkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBNKTTNKNKBN)
    public String getZrnbnkttnknkbn() {
        return zrnbnkttnknkbn;
    }

    public void setZrnbnkttnknkbn(String pZrnbnkttnknkbn) {
        zrnbnkttnknkbn = pZrnbnkttnknkbn;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrnbnktjisisttkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBNKTJISISTTKARIHYJ)
    public String getZrnbnktjisisttkarihyj() {
        return zrnbnktjisisttkarihyj;
    }

    public void setZrnbnktjisisttkarihyj(String pZrnbnktjisisttkarihyj) {
        zrnbnktjisisttkarihyj = pZrnbnktjisisttkarihyj;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private String zrncareneedssiharaihyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNCARENEEDSSIHARAIHYOUJI)
    public String getZrncareneedssiharaihyouji() {
        return zrncareneedssiharaihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncareneedssiharaihyouji(String pZrncareneedssiharaihyouji) {
        zrncareneedssiharaihyouji = pZrncareneedssiharaihyouji;
    }

    private String zrnbnktjitiktkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNBNKTJITIKTKARIHYJ)
    public String getZrnbnktjitiktkarihyj() {
        return zrnbnktjitiktkarihyj;
    }

    public void setZrnbnktjitiktkarihyj(String pZrnbnktjitiktkarihyj) {
        zrnbnktjitiktkarihyj = pZrnbnktjitiktkarihyj;
    }

    private String zrnkousinkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKOUSINKBN)
    public String getZrnkousinkbn() {
        return zrnkousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkousinkbn(String pZrnkousinkbn) {
        zrnkousinkbn = pZrnkousinkbn;
    }

    private String zrnksnym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKSNYM)
    public String getZrnksnym() {
        return zrnksnym;
    }

    public void setZrnksnym(String pZrnksnym) {
        zrnksnym = pZrnksnym;
    }

    private String zrnijitoukeiyuksnhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNIJITOUKEIYUKSNHYJ)
    public String getZrnijitoukeiyuksnhyj() {
        return zrnijitoukeiyuksnhyj;
    }

    public void setZrnijitoukeiyuksnhyj(String pZrnijitoukeiyuksnhyj) {
        zrnijitoukeiyuksnhyj = pZrnijitoukeiyuksnhyj;
    }

    private String zrnikoujisnskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNIKOUJISNSKBN)
    public String getZrnikoujisnskbn() {
        return zrnikoujisnskbn;
    }

    public void setZrnikoujisnskbn(String pZrnikoujisnskbn) {
        zrnikoujisnskbn = pZrnikoujisnskbn;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnsuuriyouyobin1;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN1)
    public String getZrnsuuriyouyobin1() {
        return zrnsuuriyouyobin1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1(String pZrnsuuriyouyobin1) {
        zrnsuuriyouyobin1 = pZrnsuuriyouyobin1;
    }

    private Integer zrnimustiyusbus;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNIMUSTIYUSBUS)
    public Integer getZrnimustiyusbus() {
        return zrnimustiyusbus;
    }

    public void setZrnimustiyusbus(Integer pZrnimustiyusbus) {
        zrnimustiyusbus = pZrnimustiyusbus;
    }

    private Integer zrnkeisansykykbbnkhns;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANSYKYKBBNKHNS)
    public Integer getZrnkeisansykykbbnkhns() {
        return zrnkeisansykykbbnkhns;
    }

    public void setZrnkeisansykykbbnkhns(Integer pZrnkeisansykykbbnkhns) {
        zrnkeisansykykbbnkhns = pZrnkeisansykykbbnkhns;
    }

    private String zrnsuuriyoubosyuukeitaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUBOSYUUKEITAIKBN)
    public String getZrnsuuriyoubosyuukeitaikbn() {
        return zrnsuuriyoubosyuukeitaikbn;
    }

    public void setZrnsuuriyoubosyuukeitaikbn(String pZrnsuuriyoubosyuukeitaikbn) {
        zrnsuuriyoubosyuukeitaikbn = pZrnsuuriyoubosyuukeitaikbn;
    }

    private String zrnsysnikoujiym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYSNIKOUJIYM)
    public String getZrnsysnikoujiym() {
        return zrnsysnikoujiym;
    }

    public void setZrnsysnikoujiym(String pZrnsysnikoujiym) {
        zrnsysnikoujiym = pZrnsysnikoujiym;
    }

    private String zrngnspshrhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGNSPSHRHYJ)
    public String getZrngnspshrhyj() {
        return zrngnspshrhyj;
    }

    public void setZrngnspshrhyj(String pZrngnspshrhyj) {
        zrngnspshrhyj = pZrngnspshrhyj;
    }

    private String zrngnspshrkeikaym;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGNSPSHRKEIKAYM)
    public String getZrngnspshrkeikaym() {
        return zrngnspshrkeikaym;
    }

    public void setZrngnspshrkeikaym(String pZrngnspshrkeikaym) {
        zrngnspshrkeikaym = pZrngnspshrkeikaym;
    }

    private String zrngnspshrgenincd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGNSPSHRGENINCD)
    public String getZrngnspshrgenincd() {
        return zrngnspshrgenincd;
    }

    public void setZrngnspshrgenincd(String pZrngnspshrgenincd) {
        zrngnspshrgenincd = pZrngnspshrgenincd;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnngerkahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNNGERKAHIKBN)
    public String getZrnngerkahikbn() {
        return zrnngerkahikbn;
    }

    public void setZrnngerkahikbn(String pZrnngerkahikbn) {
        zrnngerkahikbn = pZrnngerkahikbn;
    }

    private String zrnhokenhoutekiyouhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHOKENHOUTEKIYOUHYOUJI)
    public String getZrnhokenhoutekiyouhyouji() {
        return zrnhokenhoutekiyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhokenhoutekiyouhyouji(String pZrnhokenhoutekiyouhyouji) {
        zrnhokenhoutekiyouhyouji = pZrnhokenhoutekiyouhyouji;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private Integer zrnkeisansyukeiyakup;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANSYUKEIYAKUP)
    public Integer getZrnkeisansyukeiyakup() {
        return zrnkeisansyukeiyakup;
    }

    public void setZrnkeisansyukeiyakup(Integer pZrnkeisansyukeiyakup) {
        zrnkeisansyukeiyakup = pZrnkeisansyukeiyakup;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private Integer zrnkeisangoukeitenkans;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANGOUKEITENKANS)
    public Integer getZrnkeisangoukeitenkans() {
        return zrnkeisangoukeitenkans;
    }

    public void setZrnkeisangoukeitenkans(Integer pZrnkeisangoukeitenkans) {
        zrnkeisangoukeitenkans = pZrnkeisangoukeitenkans;
    }

    private Integer zrnkeisangoukeitenkankakaku;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANGOUKEITENKANKAKAKU)
    public Integer getZrnkeisangoukeitenkankakaku() {
        return zrnkeisangoukeitenkankakaku;
    }

    public void setZrnkeisangoukeitenkankakaku(Integer pZrnkeisangoukeitenkankakaku) {
        zrnkeisangoukeitenkankakaku = pZrnkeisangoukeitenkankakaku;
    }

    private Integer zrnkisnwnsgukitnknkakaku;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKISNWNSGUKITNKNKAKAKU)
    public Integer getZrnkisnwnsgukitnknkakaku() {
        return zrnkisnwnsgukitnknkakaku;
    }

    public void setZrnkisnwnsgukitnknkakaku(Integer pZrnkisnwnsgukitnknkakaku) {
        zrnkisnwnsgukitnknkakaku = pZrnkisnwnsgukitnknkakaku;
    }

    private BizNumber zrntnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTNKNKHNBBNJYUTURT)
    public BizNumber getZrntnknkhnbbnjyuturt() {
        return zrntnknkhnbbnjyuturt;
    }

    public void setZrntnknkhnbbnjyuturt(BizNumber pZrntnknkhnbbnjyuturt) {
        zrntnknkhnbbnjyuturt = pZrntnknkhnbbnjyuturt;
    }

    private String zrnharaizumiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNHARAIZUMIYMD)
    public String getZrnharaizumiymd() {
        return zrnharaizumiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnharaizumiymd(String pZrnharaizumiymd) {
        zrnharaizumiymd = pZrnharaizumiymd;
    }

    private String zrnstdsstkjytkyuhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSTDSSTKJYTKYUHYJ)
    public String getZrnstdsstkjytkyuhyj() {
        return zrnstdsstkjytkyuhyj;
    }

    public void setZrnstdsstkjytkyuhyj(String pZrnstdsstkjytkyuhyj) {
        zrnstdsstkjytkyuhyj = pZrnstdsstkjytkyuhyj;
    }

    private BizNumber zrnkeisanyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEISANYOTEIRIRITU)
    public BizNumber getZrnkeisanyoteiriritu() {
        return zrnkeisanyoteiriritu;
    }

    public void setZrnkeisanyoteiriritu(BizNumber pZrnkeisanyoteiriritu) {
        zrnkeisanyoteiriritu = pZrnkeisanyoteiriritu;
    }

    private String zrnseiketuseiyoukahikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSEIKETUSEIYOUKAHIKBN)
    public String getZrnseiketuseiyoukahikbn() {
        return zrnseiketuseiyoukahikbn;
    }

    public void setZrnseiketuseiyoukahikbn(String pZrnseiketuseiyoukahikbn) {
        zrnseiketuseiyoukahikbn = pZrnseiketuseiyoukahikbn;
    }

    private String zrnsyuurouhunoukgjyoutaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUROUHUNOUKGJYOUTAIKBN)
    public String getZrnsyuurouhunoukgjyoutaikbn() {
        return zrnsyuurouhunoukgjyoutaikbn;
    }

    public void setZrnsyuurouhunoukgjyoutaikbn(String pZrnsyuurouhunoukgjyoutaikbn) {
        zrnsyuurouhunoukgjyoutaikbn = pZrnsyuurouhunoukgjyoutaikbn;
    }

    private String zrnsyuurouhunoujyoutaikbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSYUUROUHUNOUJYOUTAIKBN)
    public String getZrnsyuurouhunoujyoutaikbn() {
        return zrnsyuurouhunoujyoutaikbn;
    }

    public void setZrnsyuurouhunoujyoutaikbn(String pZrnsyuurouhunoujyoutaikbn) {
        zrnsyuurouhunoujyoutaikbn = pZrnsyuurouhunoujyoutaikbn;
    }

    private String zrnsiznkyhsyoubyouhasseiymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSIZNKYHSYOUBYOUHASSEIYMD)
    public String getZrnsiznkyhsyoubyouhasseiymd() {
        return zrnsiznkyhsyoubyouhasseiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsiznkyhsyoubyouhasseiymd(String pZrnsiznkyhsyoubyouhasseiymd) {
        zrnsiznkyhsyoubyouhasseiymd = pZrnsiznkyhsyoubyouhasseiymd;
    }

    private String zrnkyusisnknkuskgitukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKYUSISNKNKUSKGITUKBN)
    public String getZrnkyusisnknkuskgitukbn() {
        return zrnkyusisnknkuskgitukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyusisnknkuskgitukbn(String pZrnkyusisnknkuskgitukbn) {
        zrnkyusisnknkuskgitukbn = pZrnkyusisnknkuskgitukbn;
    }

    private String zrnnousottyuugaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNNOUSOTTYUUGAITOUKBN)
    public String getZrnnousottyuugaitoukbn() {
        return zrnnousottyuugaitoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnousottyuugaitoukbn(String pZrnnousottyuugaitoukbn) {
        zrnnousottyuugaitoukbn = pZrnnousottyuugaitoukbn;
    }

    private String zrnjinhuzengaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNJINHUZENGAITOUKBN)
    public String getZrnjinhuzengaitoukbn() {
        return zrnjinhuzengaitoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjinhuzengaitoukbn(String pZrnjinhuzengaitoukbn) {
        zrnjinhuzengaitoukbn = pZrnjinhuzengaitoukbn;
    }

    private String zrndoumyakusikkangaitoukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDOUMYAKUSIKKANGAITOUKBN)
    public String getZrndoumyakusikkangaitoukbn() {
        return zrndoumyakusikkangaitoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndoumyakusikkangaitoukbn(String pZrndoumyakusikkangaitoukbn) {
        zrndoumyakusikkangaitoukbn = pZrndoumyakusikkangaitoukbn;
    }

    private String zrndatakanrino2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDATAKANRINO2)
    public String getZrndatakanrino2() {
        return zrndatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino2(String pZrndatakanrino2) {
        zrndatakanrino2 = pZrndatakanrino2;
    }

    private String zrndatakanrino3;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNDATAKANRINO3)
    public String getZrndatakanrino3() {
        return zrndatakanrino3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrndatakanrino3(String pZrndatakanrino3) {
        zrndatakanrino3 = pZrndatakanrino3;
    }

    private String zrnsinkeiyakujivithkhyouji;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSINKEIYAKUJIVITHKHYOUJI)
    public String getZrnsinkeiyakujivithkhyouji() {
        return zrnsinkeiyakujivithkhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinkeiyakujivithkhyouji(String pZrnsinkeiyakujivithkhyouji) {
        zrnsinkeiyakujivithkhyouji = pZrnsinkeiyakujivithkhyouji;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnknkuzusnzyrtsiyounendo;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKNKUZUSNZYRTSIYOUNENDO)
    public String getZrnknkuzusnzyrtsiyounendo() {
        return zrnknkuzusnzyrtsiyounendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnknkuzusnzyrtsiyounendo(String pZrnknkuzusnzyrtsiyounendo) {
        zrnknkuzusnzyrtsiyounendo = pZrnknkuzusnzyrtsiyounendo;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnvittkykkaiyakuymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNVITTKYKKAIYAKUYMD)
    public String getZrnvittkykkaiyakuymd() {
        return zrnvittkykkaiyakuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnvittkykkaiyakuymd(String pZrnvittkykkaiyakuymd) {
        zrnvittkykkaiyakuymd = pZrnvittkykkaiyakuymd;
    }

    private String zrnpwrbksidhitekiyouhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNPWRBKSIDHITEKIYOUHYJ)
    public String getZrnpwrbksidhitekiyouhyj() {
        return zrnpwrbksidhitekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpwrbksidhitekiyouhyj(String pZrnpwrbksidhitekiyouhyj) {
        zrnpwrbksidhitekiyouhyj = pZrnpwrbksidhitekiyouhyj;
    }

    private String zrnnintisyougeninkbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNNINTISYOUGENINKBN)
    public String getZrnnintisyougeninkbn() {
        return zrnnintisyougeninkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnintisyougeninkbn(String pZrnnintisyougeninkbn) {
        zrnnintisyougeninkbn = pZrnnintisyougeninkbn;
    }

    private String zrnsuuriyouyobin1x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN1X2)
    public String getZrnsuuriyouyobin1x2() {
        return zrnsuuriyouyobin1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x2(String pZrnsuuriyouyobin1x2) {
        zrnsuuriyouyobin1x2 = pZrnsuuriyouyobin1x2;
    }

    private String zrnsuuriyouyobin8x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X3)
    public String getZrnsuuriyouyobin8x3() {
        return zrnsuuriyouyobin8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x3(String pZrnsuuriyouyobin8x3) {
        zrnsuuriyouyobin8x3 = pZrnsuuriyouyobin8x3;
    }

    private String zrnsuuriyouyobin8x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X4)
    public String getZrnsuuriyouyobin8x4() {
        return zrnsuuriyouyobin8x4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x4(String pZrnsuuriyouyobin8x4) {
        zrnsuuriyouyobin8x4 = pZrnsuuriyouyobin8x4;
    }

    private String zrnsuuriyouyobin8x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X5)
    public String getZrnsuuriyouyobin8x5() {
        return zrnsuuriyouyobin8x5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x5(String pZrnsuuriyouyobin8x5) {
        zrnsuuriyouyobin8x5 = pZrnsuuriyouyobin8x5;
    }

    private String zrnsuuriyouyobin8x6;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X6)
    public String getZrnsuuriyouyobin8x6() {
        return zrnsuuriyouyobin8x6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x6(String pZrnsuuriyouyobin8x6) {
        zrnsuuriyouyobin8x6 = pZrnsuuriyouyobin8x6;
    }

    private String zrnsuuriyouyobin8x7;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X7)
    public String getZrnsuuriyouyobin8x7() {
        return zrnsuuriyouyobin8x7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x7(String pZrnsuuriyouyobin8x7) {
        zrnsuuriyouyobin8x7 = pZrnsuuriyouyobin8x7;
    }

    private String zrnsuuriyouyobin8x8;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X8)
    public String getZrnsuuriyouyobin8x8() {
        return zrnsuuriyouyobin8x8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x8(String pZrnsuuriyouyobin8x8) {
        zrnsuuriyouyobin8x8 = pZrnsuuriyouyobin8x8;
    }

    private String zrnsuuriyouyobin8x9;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X9)
    public String getZrnsuuriyouyobin8x9() {
        return zrnsuuriyouyobin8x9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x9(String pZrnsuuriyouyobin8x9) {
        zrnsuuriyouyobin8x9 = pZrnsuuriyouyobin8x9;
    }

    private String zrnsuuriyouyobin8x10;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8X10)
    public String getZrnsuuriyouyobin8x10() {
        return zrnsuuriyouyobin8x10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8x10(String pZrnsuuriyouyobin8x10) {
        zrnsuuriyouyobin8x10 = pZrnsuuriyouyobin8x10;
    }

    private Integer zrnyobin7;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN7)
    public Integer getZrnyobin7() {
        return zrnyobin7;
    }

    public void setZrnyobin7(Integer pZrnyobin7) {
        zrnyobin7 = pZrnyobin7;
    }

    private Integer zrnyobin7x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN7X2)
    public Integer getZrnyobin7x2() {
        return zrnyobin7x2;
    }

    public void setZrnyobin7x2(Integer pZrnyobin7x2) {
        zrnyobin7x2 = pZrnyobin7x2;
    }

    private Integer zrnyobin7x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN7X3)
    public Integer getZrnyobin7x3() {
        return zrnyobin7x3;
    }

    public void setZrnyobin7x3(Integer pZrnyobin7x3) {
        zrnyobin7x3 = pZrnyobin7x3;
    }

    private Integer zrnyobin7x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN7X4)
    public Integer getZrnyobin7x4() {
        return zrnyobin7x4;
    }

    public void setZrnyobin7x4(Integer pZrnyobin7x4) {
        zrnyobin7x4 = pZrnyobin7x4;
    }

    private Integer zrnyobin7x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN7X5)
    public Integer getZrnyobin7x5() {
        return zrnyobin7x5;
    }

    public void setZrnyobin7x5(Integer pZrnyobin7x5) {
        zrnyobin7x5 = pZrnyobin7x5;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnyobiv59;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIV59)
    public String getZrnyobiv59() {
        return zrnyobiv59;
    }

    public void setZrnyobiv59(String pZrnyobiv59) {
        zrnyobiv59 = pZrnyobiv59;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private Long zrngaikadatekihons;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGAIKADATEKIHONS)
    public Long getZrngaikadatekihons() {
        return zrngaikadatekihons;
    }

    public void setZrngaikadatekihons(Long pZrngaikadatekihons) {
        zrngaikadatekihons = pZrngaikadatekihons;
    }

    private Long zrngaikadatesibous;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNGAIKADATESIBOUS)
    public Long getZrngaikadatesibous() {
        return zrngaikadatesibous;
    }

    public void setZrngaikadatesibous(Long pZrngaikadatesibous) {
        zrngaikadatesibous = pZrngaikadatesibous;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_SbRituToukeiSeibiRenRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }
}