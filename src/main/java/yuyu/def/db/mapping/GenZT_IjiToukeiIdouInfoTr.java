package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.id.PKZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;

/**
 * 医事統計異動情報テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_IjiToukeiIdouInfoTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IjiToukeiIdouInfoTr}</td><td colspan="3">医事統計異動情報テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">{@link PKZT_IjiToukeiIdouInfoTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyoriymd ztrsyoriymd}</td><td>（取込用）処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykmfksnctr ztrkykmfksnctr}</td><td>（取込用）契約ＭＦ更新ＣＴＲ</td><td align="center">{@link PKZT_IjiToukeiIdouInfoTr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrsyukgu ztrsyukgu}</td><td>（取込用）種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknnen2keta ztrhhknnen2keta}</td><td>（取込用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknseikbn ztrhhknseikbn}</td><td>（取込用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykym ztrkykym}</td><td>（取込用）契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkisnkihons ztrkisnkihons}</td><td>（取込用）計算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrimustiyusbus ztrimustiyusbus}</td><td>（取込用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrshrs ztrshrs}</td><td>（取込用）支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrshrymd ztrshrymd}</td><td>（取込用）支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsymtgenincd ztrsymtgenincd}</td><td>（取込用）消滅原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkeikaym ztrkeikaym}</td><td>（取込用）経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsbugenincd ztrsbugenincd}</td><td>（取込用）死亡原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbsyym ztrbsyym}</td><td>（取込用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdai2hhknnen ztrdai2hhknnen}</td><td>（取込用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmannenreihyj ztrmannenreihyj}</td><td>（取込用）満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtignmrtisyukgu ztrtignmrtisyukgu}</td><td>（取込用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknnentysihyj ztrhhknnentysihyj}</td><td>（取込用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdai2hhknnentysihyj ztrdai2hhknnentysihyj}</td><td>（取込用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenseimrtisyukgu ztrrenseimrtisyukgu}</td><td>（取込用）連生マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbnktjitiktkarihyj ztrbnktjitiktkarihyj}</td><td>（取込用）分割時定期特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrlivingneedsshrarihyj ztrlivingneedsshrarihyj}</td><td>（取込用）リビングニーズ支払有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrlnkeikaym ztrlnkeikaym}</td><td>（取込用）ＬＮ経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrlnshrgenincd ztrlnshrgenincd}</td><td>（取込用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkituenkbn ztrkituenkbn}</td><td>（取込用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkituenhonsuu ztrkituenhonsuu}</td><td>（取込用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgnspshrhyj ztrgnspshrhyj}</td><td>（取込用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgnspshrkeikaym ztrgnspshrkeikaym}</td><td>（取込用）がんサポ支払経過年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgnspshrgenincd ztrgnspshrgenincd}</td><td>（取込用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyunyumrtisyukgu ztrsyunyumrtisyukgu}</td><td>（取込用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsysnymd ztrsysnymd}</td><td>（取込用）初診年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsindanymd ztrsindanymd}</td><td>（取込用）診断年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbyoumeicd1 ztrbyoumeicd1}</td><td>（取込用）病名コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbyoumeicd2 ztrbyoumeicd2}</td><td>（取込用）病名コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrshrnaiyoukbn ztrshrnaiyoukbn}</td><td>（取込用）支払内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgituyuknkbn1 ztrgituyuknkbn1}</td><td>（取込用）該当要件区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrgituyuknkbn2 ztrgituyuknkbn2}</td><td>（取込用）該当要件区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyeiebnri1 ztrsyeiebnri1}</td><td>（取込用）シェイエ分類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyeiebnri2 ztrsyeiebnri2}</td><td>（取込用）シェイエ分類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrminnesotacd1 ztrminnesotacd1}</td><td>（取込用）ミネソタコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrminnesotacd2 ztrminnesotacd2}</td><td>（取込用）ミネソタコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrminnesotacd3 ztrminnesotacd3}</td><td>（取込用）ミネソタコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrminnesotacd4 ztrminnesotacd4}</td><td>（取込用）ミネソタコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrminnesotacd5 ztrminnesotacd5}</td><td>（取込用）ミネソタコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmnsisiensindanjiyuu ztrmnsisiensindanjiyuu}</td><td>（取込用）慢性膵炎診断事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknkuhnsindanjiyuu ztrknkuhnsindanjiyuu}</td><td>（取込用）肝硬変診断事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhushrkbn ztrhushrkbn}</td><td>（取込用）不支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhushrym ztrhushrym}</td><td>（取込用）不支払年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyuurouhunoukghasseiymd ztrsyuurouhunoukghasseiymd}</td><td>（取込用）就労不能介護傷病発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyuurouhunoukgjyoutaikbn ztrsyuurouhunoukgjyoutaikbn}</td><td>（取込用）就労不能介護状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhokoukahikbn ztrhokoukahikbn}</td><td>（取込用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrngerkahikbn ztrngerkahikbn}</td><td>（取込用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrihukutyakudatukahikbn ztrihukutyakudatukahikbn}</td><td>（取込用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnyykkahikbn ztrnyykkahikbn}</td><td>（取込用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsykmtssyukahikbn ztrsykmtssyukahikbn}</td><td>（取込用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrfktrsmtkahikbn ztrfktrsmtkahikbn}</td><td>（取込用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseiketuseiyoukahikbn ztrseiketuseiyoukahikbn}</td><td>（取込用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyuurouhunoujyoutaikbn ztrsyuurouhunoujyoutaikbn}</td><td>（取込用）就労不能状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyuuseisinkinkousokukbn ztrkyuuseisinkinkousokukbn}</td><td>（取込用）急性心筋梗塞区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnousottyuukbn ztrnousottyuukbn}</td><td>（取込用）脳卒中区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrjinhuzenkbn ztrjinhuzenkbn}</td><td>（取込用）腎不全区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhukasyuksyu ztrhukasyuksyu}</td><td>（取込用）付加主契約種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtkkbn2 ztrtkkbn2}</td><td>（取込用）特約区分（２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdoumyakusikkankbn ztrdoumyakusikkankbn}</td><td>（取込用）動脈疾患区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsykikjgykbn ztrsykikjgykbn}</td><td>（取込用）職域事業区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkaijyokbn ztrkaijyokbn}</td><td>（取込用）解除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsymtymd ztrsymtymd}</td><td>（取込用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtyuutohukatkhyj ztrtyuutohukatkhyj}</td><td>（取込用）中途付加特約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryoukigjyutigituymd ztryoukigjyutigituymd}</td><td>（取込用）要介護状態該当年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryoukigjyutigeninkbn ztryoukigjyutigeninkbn}</td><td>（取込用）要介護状態原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtihougeninkbn ztrtihougeninkbn}</td><td>（取込用）痴呆原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyukgusdkbn ztrsyukgusdkbn}</td><td>（取込用）種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtignmrtisyukgusdkbn ztrtignmrtisyukgusdkbn}</td><td>（取込用）逓減マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenseimrtisyukgusdkbn ztrrenseimrtisyukgusdkbn}</td><td>（取込用）連生マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyunyumrtisyukgusdkbn ztrsyunyumrtisyukgusdkbn}</td><td>（取込用）収入マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsbtoukeiidouinfopmenkbn ztrsbtoukeiidouinfopmenkbn}</td><td>（取込用）死亡統計異動情報Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrpmenjikohasseiymd ztrpmenjikohasseiymd}</td><td>（取込用）Ｐ免事故発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorino2moji ztrsyorino2moji}</td><td>（取込用）処理番号（２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrksnym ztrksnym}</td><td>（取込用）更新年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrikoujisnskbn ztrikoujisnskbn}</td><td>（取込用）移行時診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsysnikoujiym ztrsysnikoujiym}</td><td>（取込用）終身移行時年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrijitoukeiyuksnhyj ztrijitoukeiyuksnhyj}</td><td>（取込用）医事統計用更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsotodasiphkbnmnoshyouji ztrsotodasiphkbnmnoshyouji}</td><td>（取込用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrstdsstkjytkyuhyj ztrstdsstkjytkyuhyj}</td><td>（取込用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrstdssytikbn ztrstdssytikbn}</td><td>（取込用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbnktgosnzkkyksyono ztrbnktgosnzkkyksyono}</td><td>（取込用）分割後存続契約証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbnkttnknkbn ztrbnkttnknkbn}</td><td>（取込用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykjiqpackhyj ztrkykjiqpackhyj}</td><td>（取込用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbnktjisisttkarihyj ztrbnktjisisttkarihyj}</td><td>（取込用）分割時災疾特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsotodasipmenkbn ztrsotodasipmenkbn}</td><td>（取込用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrstdssnskbn ztrstdssnskbn}</td><td>（取込用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobisuuti7x1 ztryobisuuti7x1}</td><td>（取込用）予備数値７＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtryobisuuti7x2 ztryobisuuti7x2}</td><td>（取込用）予備数値７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtryobimojihan15 ztryobimojihan15}</td><td>（取込用）予備文字半角１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobimojihan51 ztryobimojihan51}</td><td>（取込用）予備文字半角５１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_IjiToukeiIdouInfoTr
 * @see     PKZT_IjiToukeiIdouInfoTr
 * @see     QZT_IjiToukeiIdouInfoTr
 * @see     GenQZT_IjiToukeiIdouInfoTr
 */
@MappedSuperclass
@Table(name=GenZT_IjiToukeiIdouInfoTr.TABLE_NAME)
@IdClass(value=PKZT_IjiToukeiIdouInfoTr.class)
public abstract class GenZT_IjiToukeiIdouInfoTr extends AbstractExDBEntity<ZT_IjiToukeiIdouInfoTr, PKZT_IjiToukeiIdouInfoTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IjiToukeiIdouInfoTr";
    public static final String ZTRSYONO                 = "ztrsyono";
    public static final String ZTRSYORIYMD              = "ztrsyoriymd";
    public static final String ZTRKYKMFKSNCTR           = "ztrkykmfksnctr";
    public static final String ZTRSYUKGU                = "ztrsyukgu";
    public static final String ZTRHHKNNEN2KETA          = "ztrhhknnen2keta";
    public static final String ZTRHHKNSEIKBN            = "ztrhhknseikbn";
    public static final String ZTRKYKYM                 = "ztrkykym";
    public static final String ZTRKISNKIHONS            = "ztrkisnkihons";
    public static final String ZTRIMUSTIYUSBUS          = "ztrimustiyusbus";
    public static final String ZTRSHRS                  = "ztrshrs";
    public static final String ZTRSHRYMD                = "ztrshrymd";
    public static final String ZTRSYMTGENINCD           = "ztrsymtgenincd";
    public static final String ZTRKEIKAYM               = "ztrkeikaym";
    public static final String ZTRSBUGENINCD            = "ztrsbugenincd";
    public static final String ZTRBSYYM                 = "ztrbsyym";
    public static final String ZTRDAI2HHKNNEN           = "ztrdai2hhknnen";
    public static final String ZTRMANNENREIHYJ          = "ztrmannenreihyj";
    public static final String ZTRTIGNMRTISYUKGU        = "ztrtignmrtisyukgu";
    public static final String ZTRHHKNNENTYSIHYJ        = "ztrhhknnentysihyj";
    public static final String ZTRDAI2HHKNNENTYSIHYJ    = "ztrdai2hhknnentysihyj";
    public static final String ZTRRENSEIMRTISYUKGU      = "ztrrenseimrtisyukgu";
    public static final String ZTRBNKTJITIKTKARIHYJ     = "ztrbnktjitiktkarihyj";
    public static final String ZTRLIVINGNEEDSSHRARIHYJ  = "ztrlivingneedsshrarihyj";
    public static final String ZTRLNKEIKAYM             = "ztrlnkeikaym";
    public static final String ZTRLNSHRGENINCD          = "ztrlnshrgenincd";
    public static final String ZTRKITUENKBN             = "ztrkituenkbn";
    public static final String ZTRKITUENHONSUU          = "ztrkituenhonsuu";
    public static final String ZTRGNSPSHRHYJ            = "ztrgnspshrhyj";
    public static final String ZTRGNSPSHRKEIKAYM        = "ztrgnspshrkeikaym";
    public static final String ZTRGNSPSHRGENINCD        = "ztrgnspshrgenincd";
    public static final String ZTRSYUNYUMRTISYUKGU      = "ztrsyunyumrtisyukgu";
    public static final String ZTRSYSNYMD               = "ztrsysnymd";
    public static final String ZTRSINDANYMD             = "ztrsindanymd";
    public static final String ZTRBYOUMEICD1            = "ztrbyoumeicd1";
    public static final String ZTRBYOUMEICD2            = "ztrbyoumeicd2";
    public static final String ZTRSHRNAIYOUKBN          = "ztrshrnaiyoukbn";
    public static final String ZTRGITUYUKNKBN1          = "ztrgituyuknkbn1";
    public static final String ZTRGITUYUKNKBN2          = "ztrgituyuknkbn2";
    public static final String ZTRSYEIEBNRI1            = "ztrsyeiebnri1";
    public static final String ZTRSYEIEBNRI2            = "ztrsyeiebnri2";
    public static final String ZTRMINNESOTACD1          = "ztrminnesotacd1";
    public static final String ZTRMINNESOTACD2          = "ztrminnesotacd2";
    public static final String ZTRMINNESOTACD3          = "ztrminnesotacd3";
    public static final String ZTRMINNESOTACD4          = "ztrminnesotacd4";
    public static final String ZTRMINNESOTACD5          = "ztrminnesotacd5";
    public static final String ZTRMNSISIENSINDANJIYUU   = "ztrmnsisiensindanjiyuu";
    public static final String ZTRKNKUHNSINDANJIYUU     = "ztrknkuhnsindanjiyuu";
    public static final String ZTRHUSHRKBN              = "ztrhushrkbn";
    public static final String ZTRHUSHRYM               = "ztrhushrym";
    public static final String ZTRSYUUROUHUNOUKGHASSEIYMD = "ztrsyuurouhunoukghasseiymd";
    public static final String ZTRSYUUROUHUNOUKGJYOUTAIKBN = "ztrsyuurouhunoukgjyoutaikbn";
    public static final String ZTRHOKOUKAHIKBN          = "ztrhokoukahikbn";
    public static final String ZTRNGERKAHIKBN           = "ztrngerkahikbn";
    public static final String ZTRIHUKUTYAKUDATUKAHIKBN = "ztrihukutyakudatukahikbn";
    public static final String ZTRNYYKKAHIKBN           = "ztrnyykkahikbn";
    public static final String ZTRSYKMTSSYUKAHIKBN      = "ztrsykmtssyukahikbn";
    public static final String ZTRFKTRSMTKAHIKBN        = "ztrfktrsmtkahikbn";
    public static final String ZTRSEIKETUSEIYOUKAHIKBN  = "ztrseiketuseiyoukahikbn";
    public static final String ZTRSYUUROUHUNOUJYOUTAIKBN = "ztrsyuurouhunoujyoutaikbn";
    public static final String ZTRKYUUSEISINKINKOUSOKUKBN = "ztrkyuuseisinkinkousokukbn";
    public static final String ZTRNOUSOTTYUUKBN         = "ztrnousottyuukbn";
    public static final String ZTRJINHUZENKBN           = "ztrjinhuzenkbn";
    public static final String ZTRHUKASYUKSYU           = "ztrhukasyuksyu";
    public static final String ZTRTKKBN2                = "ztrtkkbn2";
    public static final String ZTRDOUMYAKUSIKKANKBN     = "ztrdoumyakusikkankbn";
    public static final String ZTRSYKIKJGYKBN           = "ztrsykikjgykbn";
    public static final String ZTRKAIJYOKBN             = "ztrkaijyokbn";
    public static final String ZTRSYMTYMD               = "ztrsymtymd";
    public static final String ZTRTYUUTOHUKATKHYJ       = "ztrtyuutohukatkhyj";
    public static final String ZTRYOUKIGJYUTIGITUYMD    = "ztryoukigjyutigituymd";
    public static final String ZTRYOUKIGJYUTIGENINKBN   = "ztryoukigjyutigeninkbn";
    public static final String ZTRTIHOUGENINKBN         = "ztrtihougeninkbn";
    public static final String ZTRSYUKGUSDKBN           = "ztrsyukgusdkbn";
    public static final String ZTRTIGNMRTISYUKGUSDKBN   = "ztrtignmrtisyukgusdkbn";
    public static final String ZTRRENSEIMRTISYUKGUSDKBN = "ztrrenseimrtisyukgusdkbn";
    public static final String ZTRSYUNYUMRTISYUKGUSDKBN = "ztrsyunyumrtisyukgusdkbn";
    public static final String ZTRSBTOUKEIIDOUINFOPMENKBN = "ztrsbtoukeiidouinfopmenkbn";
    public static final String ZTRPMENJIKOHASSEIYMD     = "ztrpmenjikohasseiymd";
    public static final String ZTRSYORINO2MOJI          = "ztrsyorino2moji";
    public static final String ZTRKSNYM                 = "ztrksnym";
    public static final String ZTRIKOUJISNSKBN          = "ztrikoujisnskbn";
    public static final String ZTRSYSNIKOUJIYM          = "ztrsysnikoujiym";
    public static final String ZTRIJITOUKEIYUKSNHYJ     = "ztrijitoukeiyuksnhyj";
    public static final String ZTRSOTODASIPHKBNMNOSHYOUJI = "ztrsotodasiphkbnmnoshyouji";
    public static final String ZTRSTDSSTKJYTKYUHYJ      = "ztrstdsstkjytkyuhyj";
    public static final String ZTRSTDSSYTIKBN           = "ztrstdssytikbn";
    public static final String ZTRBNKTGOSNZKKYKSYONO    = "ztrbnktgosnzkkyksyono";
    public static final String ZTRBNKTTNKNKBN           = "ztrbnkttnknkbn";
    public static final String ZTRKYKJIQPACKHYJ         = "ztrkykjiqpackhyj";
    public static final String ZTRBNKTJISISTTKARIHYJ    = "ztrbnktjisisttkarihyj";
    public static final String ZTRSOTODASIPMENKBN       = "ztrsotodasipmenkbn";
    public static final String ZTRSTDSSNSKBN            = "ztrstdssnskbn";
    public static final String ZTRYOBISUUTI7X1          = "ztryobisuuti7x1";
    public static final String ZTRYOBISUUTI7X2          = "ztryobisuuti7x2";
    public static final String ZTRYOBIMOJIHAN15         = "ztryobimojihan15";
    public static final String ZTRYOBIMOJIHAN51         = "ztryobimojihan51";

    private final PKZT_IjiToukeiIdouInfoTr primaryKey;

    public GenZT_IjiToukeiIdouInfoTr() {
        primaryKey = new PKZT_IjiToukeiIdouInfoTr();
    }

    public GenZT_IjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {
        primaryKey = new PKZT_IjiToukeiIdouInfoTr(pZtrsyono, pZtrkykmfksnctr);
    }

    @Transient
    @Override
    public PKZT_IjiToukeiIdouInfoTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IjiToukeiIdouInfoTr> getMetaClass() {
        return QZT_IjiToukeiIdouInfoTr.class;
    }

    @Id
    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYONO)
    public String getZtrsyono() {
        return getPrimaryKey().getZtrsyono();
    }

    public void setZtrsyono(String pZtrsyono) {
        getPrimaryKey().setZtrsyono(pZtrsyono);
    }

    private String ztrsyoriymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYORIYMD)
    public String getZtrsyoriymd() {
        return ztrsyoriymd;
    }

    public void setZtrsyoriymd(String pZtrsyoriymd) {
        ztrsyoriymd = pZtrsyoriymd;
    }

    @Id
    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKYKMFKSNCTR)
    public Integer getZtrkykmfksnctr() {
        return getPrimaryKey().getZtrkykmfksnctr();
    }

    public void setZtrkykmfksnctr(Integer pZtrkykmfksnctr) {
        getPrimaryKey().setZtrkykmfksnctr(pZtrkykmfksnctr);
    }

    private String ztrsyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUKGU)
    public String getZtrsyukgu() {
        return ztrsyukgu;
    }

    public void setZtrsyukgu(String pZtrsyukgu) {
        ztrsyukgu = pZtrsyukgu;
    }

    private String ztrhhknnen2keta;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHHKNNEN2KETA)
    public String getZtrhhknnen2keta() {
        return ztrhhknnen2keta;
    }

    public void setZtrhhknnen2keta(String pZtrhhknnen2keta) {
        ztrhhknnen2keta = pZtrhhknnen2keta;
    }

    private String ztrhhknseikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHHKNSEIKBN)
    public String getZtrhhknseikbn() {
        return ztrhhknseikbn;
    }

    public void setZtrhhknseikbn(String pZtrhhknseikbn) {
        ztrhhknseikbn = pZtrhhknseikbn;
    }

    private String ztrkykym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKYKYM)
    public String getZtrkykym() {
        return ztrkykym;
    }

    public void setZtrkykym(String pZtrkykym) {
        ztrkykym = pZtrkykym;
    }

    private Integer ztrkisnkihons;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKISNKIHONS)
    public Integer getZtrkisnkihons() {
        return ztrkisnkihons;
    }

    public void setZtrkisnkihons(Integer pZtrkisnkihons) {
        ztrkisnkihons = pZtrkisnkihons;
    }

    private Integer ztrimustiyusbus;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRIMUSTIYUSBUS)
    public Integer getZtrimustiyusbus() {
        return ztrimustiyusbus;
    }

    public void setZtrimustiyusbus(Integer pZtrimustiyusbus) {
        ztrimustiyusbus = pZtrimustiyusbus;
    }

    private Integer ztrshrs;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSHRS)
    public Integer getZtrshrs() {
        return ztrshrs;
    }

    public void setZtrshrs(Integer pZtrshrs) {
        ztrshrs = pZtrshrs;
    }

    private String ztrshrymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSHRYMD)
    public String getZtrshrymd() {
        return ztrshrymd;
    }

    public void setZtrshrymd(String pZtrshrymd) {
        ztrshrymd = pZtrshrymd;
    }

    private String ztrsymtgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYMTGENINCD)
    public String getZtrsymtgenincd() {
        return ztrsymtgenincd;
    }

    public void setZtrsymtgenincd(String pZtrsymtgenincd) {
        ztrsymtgenincd = pZtrsymtgenincd;
    }

    private String ztrkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKEIKAYM)
    public String getZtrkeikaym() {
        return ztrkeikaym;
    }

    public void setZtrkeikaym(String pZtrkeikaym) {
        ztrkeikaym = pZtrkeikaym;
    }

    private String ztrsbugenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSBUGENINCD)
    public String getZtrsbugenincd() {
        return ztrsbugenincd;
    }

    public void setZtrsbugenincd(String pZtrsbugenincd) {
        ztrsbugenincd = pZtrsbugenincd;
    }

    private String ztrbsyym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBSYYM)
    public String getZtrbsyym() {
        return ztrbsyym;
    }

    public void setZtrbsyym(String pZtrbsyym) {
        ztrbsyym = pZtrbsyym;
    }

    private String ztrdai2hhknnen;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRDAI2HHKNNEN)
    public String getZtrdai2hhknnen() {
        return ztrdai2hhknnen;
    }

    public void setZtrdai2hhknnen(String pZtrdai2hhknnen) {
        ztrdai2hhknnen = pZtrdai2hhknnen;
    }

    private String ztrmannenreihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMANNENREIHYJ)
    public String getZtrmannenreihyj() {
        return ztrmannenreihyj;
    }

    public void setZtrmannenreihyj(String pZtrmannenreihyj) {
        ztrmannenreihyj = pZtrmannenreihyj;
    }

    private String ztrtignmrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRTIGNMRTISYUKGU)
    public String getZtrtignmrtisyukgu() {
        return ztrtignmrtisyukgu;
    }

    public void setZtrtignmrtisyukgu(String pZtrtignmrtisyukgu) {
        ztrtignmrtisyukgu = pZtrtignmrtisyukgu;
    }

    private String ztrhhknnentysihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHHKNNENTYSIHYJ)
    public String getZtrhhknnentysihyj() {
        return ztrhhknnentysihyj;
    }

    public void setZtrhhknnentysihyj(String pZtrhhknnentysihyj) {
        ztrhhknnentysihyj = pZtrhhknnentysihyj;
    }

    private String ztrdai2hhknnentysihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRDAI2HHKNNENTYSIHYJ)
    public String getZtrdai2hhknnentysihyj() {
        return ztrdai2hhknnentysihyj;
    }

    public void setZtrdai2hhknnentysihyj(String pZtrdai2hhknnentysihyj) {
        ztrdai2hhknnentysihyj = pZtrdai2hhknnentysihyj;
    }

    private String ztrrenseimrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRRENSEIMRTISYUKGU)
    public String getZtrrenseimrtisyukgu() {
        return ztrrenseimrtisyukgu;
    }

    public void setZtrrenseimrtisyukgu(String pZtrrenseimrtisyukgu) {
        ztrrenseimrtisyukgu = pZtrrenseimrtisyukgu;
    }

    private String ztrbnktjitiktkarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBNKTJITIKTKARIHYJ)
    public String getZtrbnktjitiktkarihyj() {
        return ztrbnktjitiktkarihyj;
    }

    public void setZtrbnktjitiktkarihyj(String pZtrbnktjitiktkarihyj) {
        ztrbnktjitiktkarihyj = pZtrbnktjitiktkarihyj;
    }

    private String ztrlivingneedsshrarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRLIVINGNEEDSSHRARIHYJ)
    public String getZtrlivingneedsshrarihyj() {
        return ztrlivingneedsshrarihyj;
    }

    public void setZtrlivingneedsshrarihyj(String pZtrlivingneedsshrarihyj) {
        ztrlivingneedsshrarihyj = pZtrlivingneedsshrarihyj;
    }

    private String ztrlnkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRLNKEIKAYM)
    public String getZtrlnkeikaym() {
        return ztrlnkeikaym;
    }

    public void setZtrlnkeikaym(String pZtrlnkeikaym) {
        ztrlnkeikaym = pZtrlnkeikaym;
    }

    private String ztrlnshrgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRLNSHRGENINCD)
    public String getZtrlnshrgenincd() {
        return ztrlnshrgenincd;
    }

    public void setZtrlnshrgenincd(String pZtrlnshrgenincd) {
        ztrlnshrgenincd = pZtrlnshrgenincd;
    }

    private String ztrkituenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKITUENKBN)
    public String getZtrkituenkbn() {
        return ztrkituenkbn;
    }

    public void setZtrkituenkbn(String pZtrkituenkbn) {
        ztrkituenkbn = pZtrkituenkbn;
    }

    private String ztrkituenhonsuu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKITUENHONSUU)
    public String getZtrkituenhonsuu() {
        return ztrkituenhonsuu;
    }

    public void setZtrkituenhonsuu(String pZtrkituenhonsuu) {
        ztrkituenhonsuu = pZtrkituenhonsuu;
    }

    private String ztrgnspshrhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRGNSPSHRHYJ)
    public String getZtrgnspshrhyj() {
        return ztrgnspshrhyj;
    }

    public void setZtrgnspshrhyj(String pZtrgnspshrhyj) {
        ztrgnspshrhyj = pZtrgnspshrhyj;
    }

    private String ztrgnspshrkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRGNSPSHRKEIKAYM)
    public String getZtrgnspshrkeikaym() {
        return ztrgnspshrkeikaym;
    }

    public void setZtrgnspshrkeikaym(String pZtrgnspshrkeikaym) {
        ztrgnspshrkeikaym = pZtrgnspshrkeikaym;
    }

    private String ztrgnspshrgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRGNSPSHRGENINCD)
    public String getZtrgnspshrgenincd() {
        return ztrgnspshrgenincd;
    }

    public void setZtrgnspshrgenincd(String pZtrgnspshrgenincd) {
        ztrgnspshrgenincd = pZtrgnspshrgenincd;
    }

    private String ztrsyunyumrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUNYUMRTISYUKGU)
    public String getZtrsyunyumrtisyukgu() {
        return ztrsyunyumrtisyukgu;
    }

    public void setZtrsyunyumrtisyukgu(String pZtrsyunyumrtisyukgu) {
        ztrsyunyumrtisyukgu = pZtrsyunyumrtisyukgu;
    }

    private String ztrsysnymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYSNYMD)
    public String getZtrsysnymd() {
        return ztrsysnymd;
    }

    public void setZtrsysnymd(String pZtrsysnymd) {
        ztrsysnymd = pZtrsysnymd;
    }

    private String ztrsindanymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSINDANYMD)
    public String getZtrsindanymd() {
        return ztrsindanymd;
    }

    public void setZtrsindanymd(String pZtrsindanymd) {
        ztrsindanymd = pZtrsindanymd;
    }

    private String ztrbyoumeicd1;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBYOUMEICD1)
    public String getZtrbyoumeicd1() {
        return ztrbyoumeicd1;
    }

    public void setZtrbyoumeicd1(String pZtrbyoumeicd1) {
        ztrbyoumeicd1 = pZtrbyoumeicd1;
    }

    private String ztrbyoumeicd2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBYOUMEICD2)
    public String getZtrbyoumeicd2() {
        return ztrbyoumeicd2;
    }

    public void setZtrbyoumeicd2(String pZtrbyoumeicd2) {
        ztrbyoumeicd2 = pZtrbyoumeicd2;
    }

    private String ztrshrnaiyoukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSHRNAIYOUKBN)
    public String getZtrshrnaiyoukbn() {
        return ztrshrnaiyoukbn;
    }

    public void setZtrshrnaiyoukbn(String pZtrshrnaiyoukbn) {
        ztrshrnaiyoukbn = pZtrshrnaiyoukbn;
    }

    private String ztrgituyuknkbn1;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRGITUYUKNKBN1)
    public String getZtrgituyuknkbn1() {
        return ztrgituyuknkbn1;
    }

    public void setZtrgituyuknkbn1(String pZtrgituyuknkbn1) {
        ztrgituyuknkbn1 = pZtrgituyuknkbn1;
    }

    private String ztrgituyuknkbn2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRGITUYUKNKBN2)
    public String getZtrgituyuknkbn2() {
        return ztrgituyuknkbn2;
    }

    public void setZtrgituyuknkbn2(String pZtrgituyuknkbn2) {
        ztrgituyuknkbn2 = pZtrgituyuknkbn2;
    }

    private String ztrsyeiebnri1;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYEIEBNRI1)
    public String getZtrsyeiebnri1() {
        return ztrsyeiebnri1;
    }

    public void setZtrsyeiebnri1(String pZtrsyeiebnri1) {
        ztrsyeiebnri1 = pZtrsyeiebnri1;
    }

    private String ztrsyeiebnri2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYEIEBNRI2)
    public String getZtrsyeiebnri2() {
        return ztrsyeiebnri2;
    }

    public void setZtrsyeiebnri2(String pZtrsyeiebnri2) {
        ztrsyeiebnri2 = pZtrsyeiebnri2;
    }

    private String ztrminnesotacd1;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMINNESOTACD1)
    public String getZtrminnesotacd1() {
        return ztrminnesotacd1;
    }

    public void setZtrminnesotacd1(String pZtrminnesotacd1) {
        ztrminnesotacd1 = pZtrminnesotacd1;
    }

    private String ztrminnesotacd2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMINNESOTACD2)
    public String getZtrminnesotacd2() {
        return ztrminnesotacd2;
    }

    public void setZtrminnesotacd2(String pZtrminnesotacd2) {
        ztrminnesotacd2 = pZtrminnesotacd2;
    }

    private String ztrminnesotacd3;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMINNESOTACD3)
    public String getZtrminnesotacd3() {
        return ztrminnesotacd3;
    }

    public void setZtrminnesotacd3(String pZtrminnesotacd3) {
        ztrminnesotacd3 = pZtrminnesotacd3;
    }

    private String ztrminnesotacd4;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMINNESOTACD4)
    public String getZtrminnesotacd4() {
        return ztrminnesotacd4;
    }

    public void setZtrminnesotacd4(String pZtrminnesotacd4) {
        ztrminnesotacd4 = pZtrminnesotacd4;
    }

    private String ztrminnesotacd5;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMINNESOTACD5)
    public String getZtrminnesotacd5() {
        return ztrminnesotacd5;
    }

    public void setZtrminnesotacd5(String pZtrminnesotacd5) {
        ztrminnesotacd5 = pZtrminnesotacd5;
    }

    private String ztrmnsisiensindanjiyuu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRMNSISIENSINDANJIYUU)
    public String getZtrmnsisiensindanjiyuu() {
        return ztrmnsisiensindanjiyuu;
    }

    public void setZtrmnsisiensindanjiyuu(String pZtrmnsisiensindanjiyuu) {
        ztrmnsisiensindanjiyuu = pZtrmnsisiensindanjiyuu;
    }

    private String ztrknkuhnsindanjiyuu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKNKUHNSINDANJIYUU)
    public String getZtrknkuhnsindanjiyuu() {
        return ztrknkuhnsindanjiyuu;
    }

    public void setZtrknkuhnsindanjiyuu(String pZtrknkuhnsindanjiyuu) {
        ztrknkuhnsindanjiyuu = pZtrknkuhnsindanjiyuu;
    }

    private String ztrhushrkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHUSHRKBN)
    public String getZtrhushrkbn() {
        return ztrhushrkbn;
    }

    public void setZtrhushrkbn(String pZtrhushrkbn) {
        ztrhushrkbn = pZtrhushrkbn;
    }

    private String ztrhushrym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHUSHRYM)
    public String getZtrhushrym() {
        return ztrhushrym;
    }

    public void setZtrhushrym(String pZtrhushrym) {
        ztrhushrym = pZtrhushrym;
    }

    private String ztrsyuurouhunoukghasseiymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUUROUHUNOUKGHASSEIYMD)
    public String getZtrsyuurouhunoukghasseiymd() {
        return ztrsyuurouhunoukghasseiymd;
    }

    public void setZtrsyuurouhunoukghasseiymd(String pZtrsyuurouhunoukghasseiymd) {
        ztrsyuurouhunoukghasseiymd = pZtrsyuurouhunoukghasseiymd;
    }

    private String ztrsyuurouhunoukgjyoutaikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUUROUHUNOUKGJYOUTAIKBN)
    public String getZtrsyuurouhunoukgjyoutaikbn() {
        return ztrsyuurouhunoukgjyoutaikbn;
    }

    public void setZtrsyuurouhunoukgjyoutaikbn(String pZtrsyuurouhunoukgjyoutaikbn) {
        ztrsyuurouhunoukgjyoutaikbn = pZtrsyuurouhunoukgjyoutaikbn;
    }

    private String ztrhokoukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHOKOUKAHIKBN)
    public String getZtrhokoukahikbn() {
        return ztrhokoukahikbn;
    }

    public void setZtrhokoukahikbn(String pZtrhokoukahikbn) {
        ztrhokoukahikbn = pZtrhokoukahikbn;
    }

    private String ztrngerkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRNGERKAHIKBN)
    public String getZtrngerkahikbn() {
        return ztrngerkahikbn;
    }

    public void setZtrngerkahikbn(String pZtrngerkahikbn) {
        ztrngerkahikbn = pZtrngerkahikbn;
    }

    private String ztrihukutyakudatukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRIHUKUTYAKUDATUKAHIKBN)
    public String getZtrihukutyakudatukahikbn() {
        return ztrihukutyakudatukahikbn;
    }

    public void setZtrihukutyakudatukahikbn(String pZtrihukutyakudatukahikbn) {
        ztrihukutyakudatukahikbn = pZtrihukutyakudatukahikbn;
    }

    private String ztrnyykkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRNYYKKAHIKBN)
    public String getZtrnyykkahikbn() {
        return ztrnyykkahikbn;
    }

    public void setZtrnyykkahikbn(String pZtrnyykkahikbn) {
        ztrnyykkahikbn = pZtrnyykkahikbn;
    }

    private String ztrsykmtssyukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYKMTSSYUKAHIKBN)
    public String getZtrsykmtssyukahikbn() {
        return ztrsykmtssyukahikbn;
    }

    public void setZtrsykmtssyukahikbn(String pZtrsykmtssyukahikbn) {
        ztrsykmtssyukahikbn = pZtrsykmtssyukahikbn;
    }

    private String ztrfktrsmtkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRFKTRSMTKAHIKBN)
    public String getZtrfktrsmtkahikbn() {
        return ztrfktrsmtkahikbn;
    }

    public void setZtrfktrsmtkahikbn(String pZtrfktrsmtkahikbn) {
        ztrfktrsmtkahikbn = pZtrfktrsmtkahikbn;
    }

    private String ztrseiketuseiyoukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSEIKETUSEIYOUKAHIKBN)
    public String getZtrseiketuseiyoukahikbn() {
        return ztrseiketuseiyoukahikbn;
    }

    public void setZtrseiketuseiyoukahikbn(String pZtrseiketuseiyoukahikbn) {
        ztrseiketuseiyoukahikbn = pZtrseiketuseiyoukahikbn;
    }

    private String ztrsyuurouhunoujyoutaikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUUROUHUNOUJYOUTAIKBN)
    public String getZtrsyuurouhunoujyoutaikbn() {
        return ztrsyuurouhunoujyoutaikbn;
    }

    public void setZtrsyuurouhunoujyoutaikbn(String pZtrsyuurouhunoujyoutaikbn) {
        ztrsyuurouhunoujyoutaikbn = pZtrsyuurouhunoujyoutaikbn;
    }

    private String ztrkyuuseisinkinkousokukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKYUUSEISINKINKOUSOKUKBN)
    public String getZtrkyuuseisinkinkousokukbn() {
        return ztrkyuuseisinkinkousokukbn;
    }

    public void setZtrkyuuseisinkinkousokukbn(String pZtrkyuuseisinkinkousokukbn) {
        ztrkyuuseisinkinkousokukbn = pZtrkyuuseisinkinkousokukbn;
    }

    private String ztrnousottyuukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRNOUSOTTYUUKBN)
    public String getZtrnousottyuukbn() {
        return ztrnousottyuukbn;
    }

    public void setZtrnousottyuukbn(String pZtrnousottyuukbn) {
        ztrnousottyuukbn = pZtrnousottyuukbn;
    }

    private String ztrjinhuzenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRJINHUZENKBN)
    public String getZtrjinhuzenkbn() {
        return ztrjinhuzenkbn;
    }

    public void setZtrjinhuzenkbn(String pZtrjinhuzenkbn) {
        ztrjinhuzenkbn = pZtrjinhuzenkbn;
    }

    private String ztrhukasyuksyu;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRHUKASYUKSYU)
    public String getZtrhukasyuksyu() {
        return ztrhukasyuksyu;
    }

    public void setZtrhukasyuksyu(String pZtrhukasyuksyu) {
        ztrhukasyuksyu = pZtrhukasyuksyu;
    }

    private String ztrtkkbn2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRTKKBN2)
    public String getZtrtkkbn2() {
        return ztrtkkbn2;
    }

    public void setZtrtkkbn2(String pZtrtkkbn2) {
        ztrtkkbn2 = pZtrtkkbn2;
    }

    private String ztrdoumyakusikkankbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRDOUMYAKUSIKKANKBN)
    public String getZtrdoumyakusikkankbn() {
        return ztrdoumyakusikkankbn;
    }

    public void setZtrdoumyakusikkankbn(String pZtrdoumyakusikkankbn) {
        ztrdoumyakusikkankbn = pZtrdoumyakusikkankbn;
    }

    private String ztrsykikjgykbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYKIKJGYKBN)
    public String getZtrsykikjgykbn() {
        return ztrsykikjgykbn;
    }

    public void setZtrsykikjgykbn(String pZtrsykikjgykbn) {
        ztrsykikjgykbn = pZtrsykikjgykbn;
    }

    private String ztrkaijyokbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKAIJYOKBN)
    public String getZtrkaijyokbn() {
        return ztrkaijyokbn;
    }

    public void setZtrkaijyokbn(String pZtrkaijyokbn) {
        ztrkaijyokbn = pZtrkaijyokbn;
    }

    private String ztrsymtymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYMTYMD)
    public String getZtrsymtymd() {
        return ztrsymtymd;
    }

    public void setZtrsymtymd(String pZtrsymtymd) {
        ztrsymtymd = pZtrsymtymd;
    }

    private String ztrtyuutohukatkhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRTYUUTOHUKATKHYJ)
    public String getZtrtyuutohukatkhyj() {
        return ztrtyuutohukatkhyj;
    }

    public void setZtrtyuutohukatkhyj(String pZtrtyuutohukatkhyj) {
        ztrtyuutohukatkhyj = pZtrtyuutohukatkhyj;
    }

    private String ztryoukigjyutigituymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOUKIGJYUTIGITUYMD)
    public String getZtryoukigjyutigituymd() {
        return ztryoukigjyutigituymd;
    }

    public void setZtryoukigjyutigituymd(String pZtryoukigjyutigituymd) {
        ztryoukigjyutigituymd = pZtryoukigjyutigituymd;
    }

    private String ztryoukigjyutigeninkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOUKIGJYUTIGENINKBN)
    public String getZtryoukigjyutigeninkbn() {
        return ztryoukigjyutigeninkbn;
    }

    public void setZtryoukigjyutigeninkbn(String pZtryoukigjyutigeninkbn) {
        ztryoukigjyutigeninkbn = pZtryoukigjyutigeninkbn;
    }

    private String ztrtihougeninkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRTIHOUGENINKBN)
    public String getZtrtihougeninkbn() {
        return ztrtihougeninkbn;
    }

    public void setZtrtihougeninkbn(String pZtrtihougeninkbn) {
        ztrtihougeninkbn = pZtrtihougeninkbn;
    }

    private String ztrsyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUKGUSDKBN)
    public String getZtrsyukgusdkbn() {
        return ztrsyukgusdkbn;
    }

    public void setZtrsyukgusdkbn(String pZtrsyukgusdkbn) {
        ztrsyukgusdkbn = pZtrsyukgusdkbn;
    }

    private String ztrtignmrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRTIGNMRTISYUKGUSDKBN)
    public String getZtrtignmrtisyukgusdkbn() {
        return ztrtignmrtisyukgusdkbn;
    }

    public void setZtrtignmrtisyukgusdkbn(String pZtrtignmrtisyukgusdkbn) {
        ztrtignmrtisyukgusdkbn = pZtrtignmrtisyukgusdkbn;
    }

    private String ztrrenseimrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRRENSEIMRTISYUKGUSDKBN)
    public String getZtrrenseimrtisyukgusdkbn() {
        return ztrrenseimrtisyukgusdkbn;
    }

    public void setZtrrenseimrtisyukgusdkbn(String pZtrrenseimrtisyukgusdkbn) {
        ztrrenseimrtisyukgusdkbn = pZtrrenseimrtisyukgusdkbn;
    }

    private String ztrsyunyumrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYUNYUMRTISYUKGUSDKBN)
    public String getZtrsyunyumrtisyukgusdkbn() {
        return ztrsyunyumrtisyukgusdkbn;
    }

    public void setZtrsyunyumrtisyukgusdkbn(String pZtrsyunyumrtisyukgusdkbn) {
        ztrsyunyumrtisyukgusdkbn = pZtrsyunyumrtisyukgusdkbn;
    }

    private String ztrsbtoukeiidouinfopmenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSBTOUKEIIDOUINFOPMENKBN)
    public String getZtrsbtoukeiidouinfopmenkbn() {
        return ztrsbtoukeiidouinfopmenkbn;
    }

    public void setZtrsbtoukeiidouinfopmenkbn(String pZtrsbtoukeiidouinfopmenkbn) {
        ztrsbtoukeiidouinfopmenkbn = pZtrsbtoukeiidouinfopmenkbn;
    }

    private String ztrpmenjikohasseiymd;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRPMENJIKOHASSEIYMD)
    public String getZtrpmenjikohasseiymd() {
        return ztrpmenjikohasseiymd;
    }

    public void setZtrpmenjikohasseiymd(String pZtrpmenjikohasseiymd) {
        ztrpmenjikohasseiymd = pZtrpmenjikohasseiymd;
    }

    private String ztrsyorino2moji;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYORINO2MOJI)
    public String getZtrsyorino2moji() {
        return ztrsyorino2moji;
    }

    public void setZtrsyorino2moji(String pZtrsyorino2moji) {
        ztrsyorino2moji = pZtrsyorino2moji;
    }

    private String ztrksnym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKSNYM)
    public String getZtrksnym() {
        return ztrksnym;
    }

    public void setZtrksnym(String pZtrksnym) {
        ztrksnym = pZtrksnym;
    }

    private String ztrikoujisnskbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRIKOUJISNSKBN)
    public String getZtrikoujisnskbn() {
        return ztrikoujisnskbn;
    }

    public void setZtrikoujisnskbn(String pZtrikoujisnskbn) {
        ztrikoujisnskbn = pZtrikoujisnskbn;
    }

    private String ztrsysnikoujiym;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSYSNIKOUJIYM)
    public String getZtrsysnikoujiym() {
        return ztrsysnikoujiym;
    }

    public void setZtrsysnikoujiym(String pZtrsysnikoujiym) {
        ztrsysnikoujiym = pZtrsysnikoujiym;
    }

    private String ztrijitoukeiyuksnhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRIJITOUKEIYUKSNHYJ)
    public String getZtrijitoukeiyuksnhyj() {
        return ztrijitoukeiyuksnhyj;
    }

    public void setZtrijitoukeiyuksnhyj(String pZtrijitoukeiyuksnhyj) {
        ztrijitoukeiyuksnhyj = pZtrijitoukeiyuksnhyj;
    }

    private String ztrsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSOTODASIPHKBNMNOSHYOUJI)
    public String getZtrsotodasiphkbnmnoshyouji() {
        return ztrsotodasiphkbnmnoshyouji;
    }

    public void setZtrsotodasiphkbnmnoshyouji(String pZtrsotodasiphkbnmnoshyouji) {
        ztrsotodasiphkbnmnoshyouji = pZtrsotodasiphkbnmnoshyouji;
    }

    private String ztrstdsstkjytkyuhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSTDSSTKJYTKYUHYJ)
    public String getZtrstdsstkjytkyuhyj() {
        return ztrstdsstkjytkyuhyj;
    }

    public void setZtrstdsstkjytkyuhyj(String pZtrstdsstkjytkyuhyj) {
        ztrstdsstkjytkyuhyj = pZtrstdsstkjytkyuhyj;
    }

    private String ztrstdssytikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSTDSSYTIKBN)
    public String getZtrstdssytikbn() {
        return ztrstdssytikbn;
    }

    public void setZtrstdssytikbn(String pZtrstdssytikbn) {
        ztrstdssytikbn = pZtrstdssytikbn;
    }

    private String ztrbnktgosnzkkyksyono;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBNKTGOSNZKKYKSYONO)
    public String getZtrbnktgosnzkkyksyono() {
        return ztrbnktgosnzkkyksyono;
    }

    public void setZtrbnktgosnzkkyksyono(String pZtrbnktgosnzkkyksyono) {
        ztrbnktgosnzkkyksyono = pZtrbnktgosnzkkyksyono;
    }

    private String ztrbnkttnknkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBNKTTNKNKBN)
    public String getZtrbnkttnknkbn() {
        return ztrbnkttnknkbn;
    }

    public void setZtrbnkttnknkbn(String pZtrbnkttnknkbn) {
        ztrbnkttnknkbn = pZtrbnkttnknkbn;
    }

    private String ztrkykjiqpackhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRKYKJIQPACKHYJ)
    public String getZtrkykjiqpackhyj() {
        return ztrkykjiqpackhyj;
    }

    public void setZtrkykjiqpackhyj(String pZtrkykjiqpackhyj) {
        ztrkykjiqpackhyj = pZtrkykjiqpackhyj;
    }

    private String ztrbnktjisisttkarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRBNKTJISISTTKARIHYJ)
    public String getZtrbnktjisisttkarihyj() {
        return ztrbnktjisisttkarihyj;
    }

    public void setZtrbnktjisisttkarihyj(String pZtrbnktjisisttkarihyj) {
        ztrbnktjisisttkarihyj = pZtrbnktjisisttkarihyj;
    }

    private String ztrsotodasipmenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSOTODASIPMENKBN)
    public String getZtrsotodasipmenkbn() {
        return ztrsotodasipmenkbn;
    }

    public void setZtrsotodasipmenkbn(String pZtrsotodasipmenkbn) {
        ztrsotodasipmenkbn = pZtrsotodasipmenkbn;
    }

    private String ztrstdssnskbn;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRSTDSSNSKBN)
    public String getZtrstdssnskbn() {
        return ztrstdssnskbn;
    }

    public void setZtrstdssnskbn(String pZtrstdssnskbn) {
        ztrstdssnskbn = pZtrstdssnskbn;
    }

    private Integer ztryobisuuti7x1;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOBISUUTI7X1)
    public Integer getZtryobisuuti7x1() {
        return ztryobisuuti7x1;
    }

    public void setZtryobisuuti7x1(Integer pZtryobisuuti7x1) {
        ztryobisuuti7x1 = pZtryobisuuti7x1;
    }

    private Integer ztryobisuuti7x2;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOBISUUTI7X2)
    public Integer getZtryobisuuti7x2() {
        return ztryobisuuti7x2;
    }

    public void setZtryobisuuti7x2(Integer pZtryobisuuti7x2) {
        ztryobisuuti7x2 = pZtryobisuuti7x2;
    }

    private String ztryobimojihan15;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOBIMOJIHAN15)
    public String getZtryobimojihan15() {
        return ztryobimojihan15;
    }

    public void setZtryobimojihan15(String pZtryobimojihan15) {
        ztryobimojihan15 = pZtryobimojihan15;
    }

    private String ztryobimojihan51;

    @Column(name=GenZT_IjiToukeiIdouInfoTr.ZTRYOBIMOJIHAN51)
    public String getZtryobimojihan51() {
        return ztryobimojihan51;
    }

    public void setZtryobimojihan51(String pZtryobimojihan51) {
        ztryobimojihan51 = pZtryobimojihan51;
    }
}
