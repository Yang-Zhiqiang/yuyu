package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.id.PKZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoRn;

/**
 * 医事統計異動情報テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IjiToukeiIdouInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IjiToukeiIdouInfoRn}</td><td colspan="3">医事統計異動情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_IjiToukeiIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">{@link PKZT_IjiToukeiIdouInfoRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyukgu zrnsyukgu}</td><td>（連携用）種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykym zrnkykym}</td><td>（連携用）契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkisnkihons zrnkisnkihons}</td><td>（連携用）計算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnimustiyusbus zrnimustiyusbus}</td><td>（連携用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnshrs zrnshrs}</td><td>（連携用）支払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnshrymd zrnshrymd}</td><td>（連携用）支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtgenincd zrnsymtgenincd}</td><td>（連携用）消滅原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikaym zrnkeikaym}</td><td>（連携用）経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbugenincd zrnsbugenincd}</td><td>（連携用）死亡原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnen zrndai2hhknnen}</td><td>（連携用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmannenreihyj zrnmannenreihyj}</td><td>（連携用）満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgu zrntignmrtisyukgu}</td><td>（連携用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenseimrtisyukgu zrnrenseimrtisyukgu}</td><td>（連携用）連生マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktjitiktkarihyj zrnbnktjitiktkarihyj}</td><td>（連携用）分割時定期特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivingneedsshrarihyj zrnlivingneedsshrarihyj}</td><td>（連携用）リビングニーズ支払有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnkeikaym zrnlnkeikaym}</td><td>（連携用）ＬＮ経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlnshrgenincd zrnlnshrgenincd}</td><td>（連携用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenkbn zrnkituenkbn}</td><td>（連携用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenhonsuu zrnkituenhonsuu}</td><td>（連携用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrhyj zrngnspshrhyj}</td><td>（連携用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrkeikaym zrngnspshrkeikaym}</td><td>（連携用）がんサポ支払経過年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngnspshrgenincd zrngnspshrgenincd}</td><td>（連携用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtisyukgu zrnsyunyumrtisyukgu}</td><td>（連携用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnsyuurouhunoukghasseiymd zrnsyuurouhunoukghasseiymd}</td><td>（連携用）就労不能介護傷病発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuurouhunoukgjyoutaikbn zrnsyuurouhunoukgjyoutaikbn}</td><td>（連携用）就労不能介護状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokoukahikbn zrnhokoukahikbn}</td><td>（連携用）歩行可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnngerkahikbn zrnngerkahikbn}</td><td>（連携用）寝返り可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnihukutyakudatukahikbn zrnihukutyakudatukahikbn}</td><td>（連携用）衣服着脱可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyykkahikbn zrnnyykkahikbn}</td><td>（連携用）入浴可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykmtssyukahikbn zrnsykmtssyukahikbn}</td><td>（連携用）食物摂取可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfktrsmtkahikbn zrnfktrsmtkahikbn}</td><td>（連携用）拭き取り始末可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiketuseiyoukahikbn zrnseiketuseiyoukahikbn}</td><td>（連携用）清潔整容可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuurouhunoujyoutaikbn zrnsyuurouhunoujyoutaikbn}</td><td>（連携用）就労不能状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyuuseisinkinkousokukbn zrnkyuuseisinkinkousokukbn}</td><td>（連携用）急性心筋梗塞区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnousottyuukbn zrnnousottyuukbn}</td><td>（連携用）脳卒中区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjinhuzenkbn zrnjinhuzenkbn}</td><td>（連携用）腎不全区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukasyuksyu zrnhukasyuksyu}</td><td>（連携用）付加主契約種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkkbn2 zrntkkbn2}</td><td>（連携用）特約区分（２文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndoumyakusikkankbn zrndoumyakusikkankbn}</td><td>（連携用）動脈疾患区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykikjgykbn zrnsykikjgykbn}</td><td>（連携用）職域事業区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaijyokbn zrnkaijyokbn}</td><td>（連携用）解除区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuutohukatkhyj zrntyuutohukatkhyj}</td><td>（連携用）中途付加特約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukigjyutigituymd zrnyoukigjyutigituymd}</td><td>（連携用）要介護状態該当年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoukigjyutigeninkbn zrnyoukigjyutigeninkbn}</td><td>（連携用）要介護状態原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntihougeninkbn zrntihougeninkbn}</td><td>（連携用）痴呆原因区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukgusdkbn zrnsyukgusdkbn}</td><td>（連携用）種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgusdkbn zrntignmrtisyukgusdkbn}</td><td>（連携用）逓減マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenseimrtisyukgusdkbn zrnrenseimrtisyukgusdkbn}</td><td>（連携用）連生マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtisyukgusdkbn zrnsyunyumrtisyukgusdkbn}</td><td>（連携用）収入マル定種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbtoukeiidouinfopmenkbn zrnsbtoukeiidouinfopmenkbn}</td><td>（連携用）死亡統計異動情報Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenjikohasseiymd zrnpmenjikohasseiymd}</td><td>（連携用）Ｐ免事故発生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorino2moji zrnsyorino2moji}</td><td>（連携用）処理番号（２文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnym zrnksnym}</td><td>（連携用）更新年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikoujisnskbn zrnikoujisnskbn}</td><td>（連携用）移行時診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsysnikoujiym zrnsysnikoujiym}</td><td>（連携用）終身移行時年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeiyuksnhyj zrnijitoukeiyuksnhyj}</td><td>（連携用）医事統計用更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdsstkjytkyuhyj zrnstdsstkjytkyuhyj}</td><td>（連携用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktgosnzkkyksyono zrnbnktgosnzkkyksyono}</td><td>（連携用）分割後存続契約証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkttnknkbn zrnbnkttnknkbn}</td><td>（連携用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktjisisttkarihyj zrnbnktjisisttkarihyj}</td><td>（連携用）分割時災疾特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdssnskbn zrnstdssnskbn}</td><td>（連携用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobisuuti7x1 zrnyobisuuti7x1}</td><td>（連携用）予備数値７＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobisuuti7x2 zrnyobisuuti7x2}</td><td>（連携用）予備数値７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobimojihan15 zrnyobimojihan15}</td><td>（連携用）予備文字半角１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobimojihan51 zrnyobimojihan51}</td><td>（連携用）予備文字半角５１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IjiToukeiIdouInfoRn
 * @see     PKZT_IjiToukeiIdouInfoRn
 * @see     QZT_IjiToukeiIdouInfoRn
 * @see     GenQZT_IjiToukeiIdouInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_IjiToukeiIdouInfoRn.TABLE_NAME)
@IdClass(value=PKZT_IjiToukeiIdouInfoRn.class)
public abstract class GenZT_IjiToukeiIdouInfoRn extends AbstractExDBEntityForZDB<ZT_IjiToukeiIdouInfoRn, PKZT_IjiToukeiIdouInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IjiToukeiIdouInfoRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNKYKMFKSNCTR           = "zrnkykmfksnctr";
    public static final String ZRNSYUKGU                = "zrnsyukgu";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKYM                 = "zrnkykym";
    public static final String ZRNKISNKIHONS            = "zrnkisnkihons";
    public static final String ZRNIMUSTIYUSBUS          = "zrnimustiyusbus";
    public static final String ZRNSHRS                  = "zrnshrs";
    public static final String ZRNSHRYMD                = "zrnshrymd";
    public static final String ZRNSYMTGENINCD           = "zrnsymtgenincd";
    public static final String ZRNKEIKAYM               = "zrnkeikaym";
    public static final String ZRNSBUGENINCD            = "zrnsbugenincd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNDAI2HHKNNEN           = "zrndai2hhknnen";
    public static final String ZRNMANNENREIHYJ          = "zrnmannenreihyj";
    public static final String ZRNTIGNMRTISYUKGU        = "zrntignmrtisyukgu";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNRENSEIMRTISYUKGU      = "zrnrenseimrtisyukgu";
    public static final String ZRNBNKTJITIKTKARIHYJ     = "zrnbnktjitiktkarihyj";
    public static final String ZRNLIVINGNEEDSSHRARIHYJ  = "zrnlivingneedsshrarihyj";
    public static final String ZRNLNKEIKAYM             = "zrnlnkeikaym";
    public static final String ZRNLNSHRGENINCD          = "zrnlnshrgenincd";
    public static final String ZRNKITUENKBN             = "zrnkituenkbn";
    public static final String ZRNKITUENHONSUU          = "zrnkituenhonsuu";
    public static final String ZRNGNSPSHRHYJ            = "zrngnspshrhyj";
    public static final String ZRNGNSPSHRKEIKAYM        = "zrngnspshrkeikaym";
    public static final String ZRNGNSPSHRGENINCD        = "zrngnspshrgenincd";
    public static final String ZRNSYUNYUMRTISYUKGU      = "zrnsyunyumrtisyukgu";
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
    public static final String ZRNSYUUROUHUNOUKGHASSEIYMD = "zrnsyuurouhunoukghasseiymd";
    public static final String ZRNSYUUROUHUNOUKGJYOUTAIKBN = "zrnsyuurouhunoukgjyoutaikbn";
    public static final String ZRNHOKOUKAHIKBN          = "zrnhokoukahikbn";
    public static final String ZRNNGERKAHIKBN           = "zrnngerkahikbn";
    public static final String ZRNIHUKUTYAKUDATUKAHIKBN = "zrnihukutyakudatukahikbn";
    public static final String ZRNNYYKKAHIKBN           = "zrnnyykkahikbn";
    public static final String ZRNSYKMTSSYUKAHIKBN      = "zrnsykmtssyukahikbn";
    public static final String ZRNFKTRSMTKAHIKBN        = "zrnfktrsmtkahikbn";
    public static final String ZRNSEIKETUSEIYOUKAHIKBN  = "zrnseiketuseiyoukahikbn";
    public static final String ZRNSYUUROUHUNOUJYOUTAIKBN = "zrnsyuurouhunoujyoutaikbn";
    public static final String ZRNKYUUSEISINKINKOUSOKUKBN = "zrnkyuuseisinkinkousokukbn";
    public static final String ZRNNOUSOTTYUUKBN         = "zrnnousottyuukbn";
    public static final String ZRNJINHUZENKBN           = "zrnjinhuzenkbn";
    public static final String ZRNHUKASYUKSYU           = "zrnhukasyuksyu";
    public static final String ZRNTKKBN2                = "zrntkkbn2";
    public static final String ZRNDOUMYAKUSIKKANKBN     = "zrndoumyakusikkankbn";
    public static final String ZRNSYKIKJGYKBN           = "zrnsykikjgykbn";
    public static final String ZRNKAIJYOKBN             = "zrnkaijyokbn";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNTYUUTOHUKATKHYJ       = "zrntyuutohukatkhyj";
    public static final String ZRNYOUKIGJYUTIGITUYMD    = "zrnyoukigjyutigituymd";
    public static final String ZRNYOUKIGJYUTIGENINKBN   = "zrnyoukigjyutigeninkbn";
    public static final String ZRNTIHOUGENINKBN         = "zrntihougeninkbn";
    public static final String ZRNSYUKGUSDKBN           = "zrnsyukgusdkbn";
    public static final String ZRNTIGNMRTISYUKGUSDKBN   = "zrntignmrtisyukgusdkbn";
    public static final String ZRNRENSEIMRTISYUKGUSDKBN = "zrnrenseimrtisyukgusdkbn";
    public static final String ZRNSYUNYUMRTISYUKGUSDKBN = "zrnsyunyumrtisyukgusdkbn";
    public static final String ZRNSBTOUKEIIDOUINFOPMENKBN = "zrnsbtoukeiidouinfopmenkbn";
    public static final String ZRNPMENJIKOHASSEIYMD     = "zrnpmenjikohasseiymd";
    public static final String ZRNSYORINO2MOJI          = "zrnsyorino2moji";
    public static final String ZRNKSNYM                 = "zrnksnym";
    public static final String ZRNIKOUJISNSKBN          = "zrnikoujisnskbn";
    public static final String ZRNSYSNIKOUJIYM          = "zrnsysnikoujiym";
    public static final String ZRNIJITOUKEIYUKSNHYJ     = "zrnijitoukeiyuksnhyj";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNSTDSSTKJYTKYUHYJ      = "zrnstdsstkjytkyuhyj";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNBNKTGOSNZKKYKSYONO    = "zrnbnktgosnzkkyksyono";
    public static final String ZRNBNKTTNKNKBN           = "zrnbnkttnknkbn";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNBNKTJISISTTKARIHYJ    = "zrnbnktjisisttkarihyj";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNSTDSSNSKBN            = "zrnstdssnskbn";
    public static final String ZRNYOBISUUTI7X1          = "zrnyobisuuti7x1";
    public static final String ZRNYOBISUUTI7X2          = "zrnyobisuuti7x2";
    public static final String ZRNYOBIMOJIHAN15         = "zrnyobimojihan15";
    public static final String ZRNYOBIMOJIHAN51         = "zrnyobimojihan51";

    private final PKZT_IjiToukeiIdouInfoRn primaryKey;

    public GenZT_IjiToukeiIdouInfoRn() {
        primaryKey = new PKZT_IjiToukeiIdouInfoRn();
    }

    public GenZT_IjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {
        primaryKey = new PKZT_IjiToukeiIdouInfoRn(pZrnsyono, pZrnkykmfksnctr);
    }

    @Transient
    @Override
    public PKZT_IjiToukeiIdouInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IjiToukeiIdouInfoRn> getMetaClass() {
        return QZT_IjiToukeiIdouInfoRn.class;
    }

    @Id
    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnsyoriymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }

    @Id
    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKYKMFKSNCTR)
    public Integer getZrnkykmfksnctr() {
        return getPrimaryKey().getZrnkykmfksnctr();
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        getPrimaryKey().setZrnkykmfksnctr(pZrnkykmfksnctr);
    }

    private String zrnsyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUKGU)
    public String getZrnsyukgu() {
        return zrnsyukgu;
    }

    public void setZrnsyukgu(String pZrnsyukgu) {
        zrnsyukgu = pZrnsyukgu;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkykym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKYKYM)
    public String getZrnkykym() {
        return zrnkykym;
    }

    public void setZrnkykym(String pZrnkykym) {
        zrnkykym = pZrnkykym;
    }

    private Integer zrnkisnkihons;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKISNKIHONS)
    public Integer getZrnkisnkihons() {
        return zrnkisnkihons;
    }

    public void setZrnkisnkihons(Integer pZrnkisnkihons) {
        zrnkisnkihons = pZrnkisnkihons;
    }

    private Integer zrnimustiyusbus;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNIMUSTIYUSBUS)
    public Integer getZrnimustiyusbus() {
        return zrnimustiyusbus;
    }

    public void setZrnimustiyusbus(Integer pZrnimustiyusbus) {
        zrnimustiyusbus = pZrnimustiyusbus;
    }

    private Integer zrnshrs;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSHRS)
    public Integer getZrnshrs() {
        return zrnshrs;
    }

    public void setZrnshrs(Integer pZrnshrs) {
        zrnshrs = pZrnshrs;
    }

    private String zrnshrymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSHRYMD)
    public String getZrnshrymd() {
        return zrnshrymd;
    }

    public void setZrnshrymd(String pZrnshrymd) {
        zrnshrymd = pZrnshrymd;
    }

    private String zrnsymtgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYMTGENINCD)
    public String getZrnsymtgenincd() {
        return zrnsymtgenincd;
    }

    public void setZrnsymtgenincd(String pZrnsymtgenincd) {
        zrnsymtgenincd = pZrnsymtgenincd;
    }

    private String zrnkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKEIKAYM)
    public String getZrnkeikaym() {
        return zrnkeikaym;
    }

    public void setZrnkeikaym(String pZrnkeikaym) {
        zrnkeikaym = pZrnkeikaym;
    }

    private String zrnsbugenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSBUGENINCD)
    public String getZrnsbugenincd() {
        return zrnsbugenincd;
    }

    public void setZrnsbugenincd(String pZrnsbugenincd) {
        zrnsbugenincd = pZrnsbugenincd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrndai2hhknnen;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNDAI2HHKNNEN)
    public String getZrndai2hhknnen() {
        return zrndai2hhknnen;
    }

    public void setZrndai2hhknnen(String pZrndai2hhknnen) {
        zrndai2hhknnen = pZrndai2hhknnen;
    }

    private String zrnmannenreihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMANNENREIHYJ)
    public String getZrnmannenreihyj() {
        return zrnmannenreihyj;
    }

    public void setZrnmannenreihyj(String pZrnmannenreihyj) {
        zrnmannenreihyj = pZrnmannenreihyj;
    }

    private String zrntignmrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNTIGNMRTISYUKGU)
    public String getZrntignmrtisyukgu() {
        return zrntignmrtisyukgu;
    }

    public void setZrntignmrtisyukgu(String pZrntignmrtisyukgu) {
        zrntignmrtisyukgu = pZrntignmrtisyukgu;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnrenseimrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNRENSEIMRTISYUKGU)
    public String getZrnrenseimrtisyukgu() {
        return zrnrenseimrtisyukgu;
    }

    public void setZrnrenseimrtisyukgu(String pZrnrenseimrtisyukgu) {
        zrnrenseimrtisyukgu = pZrnrenseimrtisyukgu;
    }

    private String zrnbnktjitiktkarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBNKTJITIKTKARIHYJ)
    public String getZrnbnktjitiktkarihyj() {
        return zrnbnktjitiktkarihyj;
    }

    public void setZrnbnktjitiktkarihyj(String pZrnbnktjitiktkarihyj) {
        zrnbnktjitiktkarihyj = pZrnbnktjitiktkarihyj;
    }

    private String zrnlivingneedsshrarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNLIVINGNEEDSSHRARIHYJ)
    public String getZrnlivingneedsshrarihyj() {
        return zrnlivingneedsshrarihyj;
    }

    public void setZrnlivingneedsshrarihyj(String pZrnlivingneedsshrarihyj) {
        zrnlivingneedsshrarihyj = pZrnlivingneedsshrarihyj;
    }

    private String zrnlnkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNLNKEIKAYM)
    public String getZrnlnkeikaym() {
        return zrnlnkeikaym;
    }

    public void setZrnlnkeikaym(String pZrnlnkeikaym) {
        zrnlnkeikaym = pZrnlnkeikaym;
    }

    private String zrnlnshrgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNLNSHRGENINCD)
    public String getZrnlnshrgenincd() {
        return zrnlnshrgenincd;
    }

    public void setZrnlnshrgenincd(String pZrnlnshrgenincd) {
        zrnlnshrgenincd = pZrnlnshrgenincd;
    }

    private String zrnkituenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKITUENKBN)
    public String getZrnkituenkbn() {
        return zrnkituenkbn;
    }

    public void setZrnkituenkbn(String pZrnkituenkbn) {
        zrnkituenkbn = pZrnkituenkbn;
    }

    private String zrnkituenhonsuu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKITUENHONSUU)
    public String getZrnkituenhonsuu() {
        return zrnkituenhonsuu;
    }

    public void setZrnkituenhonsuu(String pZrnkituenhonsuu) {
        zrnkituenhonsuu = pZrnkituenhonsuu;
    }

    private String zrngnspshrhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNGNSPSHRHYJ)
    public String getZrngnspshrhyj() {
        return zrngnspshrhyj;
    }

    public void setZrngnspshrhyj(String pZrngnspshrhyj) {
        zrngnspshrhyj = pZrngnspshrhyj;
    }

    private String zrngnspshrkeikaym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNGNSPSHRKEIKAYM)
    public String getZrngnspshrkeikaym() {
        return zrngnspshrkeikaym;
    }

    public void setZrngnspshrkeikaym(String pZrngnspshrkeikaym) {
        zrngnspshrkeikaym = pZrngnspshrkeikaym;
    }

    private String zrngnspshrgenincd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNGNSPSHRGENINCD)
    public String getZrngnspshrgenincd() {
        return zrngnspshrgenincd;
    }

    public void setZrngnspshrgenincd(String pZrngnspshrgenincd) {
        zrngnspshrgenincd = pZrngnspshrgenincd;
    }

    private String zrnsyunyumrtisyukgu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUNYUMRTISYUKGU)
    public String getZrnsyunyumrtisyukgu() {
        return zrnsyunyumrtisyukgu;
    }

    public void setZrnsyunyumrtisyukgu(String pZrnsyunyumrtisyukgu) {
        zrnsyunyumrtisyukgu = pZrnsyunyumrtisyukgu;
    }

    private String zrnsysnymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYSNYMD)
    public String getZrnsysnymd() {
        return zrnsysnymd;
    }

    public void setZrnsysnymd(String pZrnsysnymd) {
        zrnsysnymd = pZrnsysnymd;
    }

    private String zrnsindanymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSINDANYMD)
    public String getZrnsindanymd() {
        return zrnsindanymd;
    }

    public void setZrnsindanymd(String pZrnsindanymd) {
        zrnsindanymd = pZrnsindanymd;
    }

    private String zrnbyoumeicd1;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBYOUMEICD1)
    public String getZrnbyoumeicd1() {
        return zrnbyoumeicd1;
    }

    public void setZrnbyoumeicd1(String pZrnbyoumeicd1) {
        zrnbyoumeicd1 = pZrnbyoumeicd1;
    }

    private String zrnbyoumeicd2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBYOUMEICD2)
    public String getZrnbyoumeicd2() {
        return zrnbyoumeicd2;
    }

    public void setZrnbyoumeicd2(String pZrnbyoumeicd2) {
        zrnbyoumeicd2 = pZrnbyoumeicd2;
    }

    private String zrnshrnaiyoukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSHRNAIYOUKBN)
    public String getZrnshrnaiyoukbn() {
        return zrnshrnaiyoukbn;
    }

    public void setZrnshrnaiyoukbn(String pZrnshrnaiyoukbn) {
        zrnshrnaiyoukbn = pZrnshrnaiyoukbn;
    }

    private String zrngituyuknkbn1;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNGITUYUKNKBN1)
    public String getZrngituyuknkbn1() {
        return zrngituyuknkbn1;
    }

    public void setZrngituyuknkbn1(String pZrngituyuknkbn1) {
        zrngituyuknkbn1 = pZrngituyuknkbn1;
    }

    private String zrngituyuknkbn2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNGITUYUKNKBN2)
    public String getZrngituyuknkbn2() {
        return zrngituyuknkbn2;
    }

    public void setZrngituyuknkbn2(String pZrngituyuknkbn2) {
        zrngituyuknkbn2 = pZrngituyuknkbn2;
    }

    private String zrnsyeiebnri1;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYEIEBNRI1)
    public String getZrnsyeiebnri1() {
        return zrnsyeiebnri1;
    }

    public void setZrnsyeiebnri1(String pZrnsyeiebnri1) {
        zrnsyeiebnri1 = pZrnsyeiebnri1;
    }

    private String zrnsyeiebnri2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYEIEBNRI2)
    public String getZrnsyeiebnri2() {
        return zrnsyeiebnri2;
    }

    public void setZrnsyeiebnri2(String pZrnsyeiebnri2) {
        zrnsyeiebnri2 = pZrnsyeiebnri2;
    }

    private String zrnminnesotacd1;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMINNESOTACD1)
    public String getZrnminnesotacd1() {
        return zrnminnesotacd1;
    }

    public void setZrnminnesotacd1(String pZrnminnesotacd1) {
        zrnminnesotacd1 = pZrnminnesotacd1;
    }

    private String zrnminnesotacd2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMINNESOTACD2)
    public String getZrnminnesotacd2() {
        return zrnminnesotacd2;
    }

    public void setZrnminnesotacd2(String pZrnminnesotacd2) {
        zrnminnesotacd2 = pZrnminnesotacd2;
    }

    private String zrnminnesotacd3;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMINNESOTACD3)
    public String getZrnminnesotacd3() {
        return zrnminnesotacd3;
    }

    public void setZrnminnesotacd3(String pZrnminnesotacd3) {
        zrnminnesotacd3 = pZrnminnesotacd3;
    }

    private String zrnminnesotacd4;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMINNESOTACD4)
    public String getZrnminnesotacd4() {
        return zrnminnesotacd4;
    }

    public void setZrnminnesotacd4(String pZrnminnesotacd4) {
        zrnminnesotacd4 = pZrnminnesotacd4;
    }

    private String zrnminnesotacd5;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMINNESOTACD5)
    public String getZrnminnesotacd5() {
        return zrnminnesotacd5;
    }

    public void setZrnminnesotacd5(String pZrnminnesotacd5) {
        zrnminnesotacd5 = pZrnminnesotacd5;
    }

    private String zrnmnsisiensindanjiyuu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNMNSISIENSINDANJIYUU)
    public String getZrnmnsisiensindanjiyuu() {
        return zrnmnsisiensindanjiyuu;
    }

    public void setZrnmnsisiensindanjiyuu(String pZrnmnsisiensindanjiyuu) {
        zrnmnsisiensindanjiyuu = pZrnmnsisiensindanjiyuu;
    }

    private String zrnknkuhnsindanjiyuu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKNKUHNSINDANJIYUU)
    public String getZrnknkuhnsindanjiyuu() {
        return zrnknkuhnsindanjiyuu;
    }

    public void setZrnknkuhnsindanjiyuu(String pZrnknkuhnsindanjiyuu) {
        zrnknkuhnsindanjiyuu = pZrnknkuhnsindanjiyuu;
    }

    private String zrnhushrkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHUSHRKBN)
    public String getZrnhushrkbn() {
        return zrnhushrkbn;
    }

    public void setZrnhushrkbn(String pZrnhushrkbn) {
        zrnhushrkbn = pZrnhushrkbn;
    }

    private String zrnhushrym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHUSHRYM)
    public String getZrnhushrym() {
        return zrnhushrym;
    }

    public void setZrnhushrym(String pZrnhushrym) {
        zrnhushrym = pZrnhushrym;
    }

    private String zrnsyuurouhunoukghasseiymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUUROUHUNOUKGHASSEIYMD)
    public String getZrnsyuurouhunoukghasseiymd() {
        return zrnsyuurouhunoukghasseiymd;
    }

    public void setZrnsyuurouhunoukghasseiymd(String pZrnsyuurouhunoukghasseiymd) {
        zrnsyuurouhunoukghasseiymd = pZrnsyuurouhunoukghasseiymd;
    }

    private String zrnsyuurouhunoukgjyoutaikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUUROUHUNOUKGJYOUTAIKBN)
    public String getZrnsyuurouhunoukgjyoutaikbn() {
        return zrnsyuurouhunoukgjyoutaikbn;
    }

    public void setZrnsyuurouhunoukgjyoutaikbn(String pZrnsyuurouhunoukgjyoutaikbn) {
        zrnsyuurouhunoukgjyoutaikbn = pZrnsyuurouhunoukgjyoutaikbn;
    }

    private String zrnhokoukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHOKOUKAHIKBN)
    public String getZrnhokoukahikbn() {
        return zrnhokoukahikbn;
    }

    public void setZrnhokoukahikbn(String pZrnhokoukahikbn) {
        zrnhokoukahikbn = pZrnhokoukahikbn;
    }

    private String zrnngerkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNNGERKAHIKBN)
    public String getZrnngerkahikbn() {
        return zrnngerkahikbn;
    }

    public void setZrnngerkahikbn(String pZrnngerkahikbn) {
        zrnngerkahikbn = pZrnngerkahikbn;
    }

    private String zrnihukutyakudatukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNIHUKUTYAKUDATUKAHIKBN)
    public String getZrnihukutyakudatukahikbn() {
        return zrnihukutyakudatukahikbn;
    }

    public void setZrnihukutyakudatukahikbn(String pZrnihukutyakudatukahikbn) {
        zrnihukutyakudatukahikbn = pZrnihukutyakudatukahikbn;
    }

    private String zrnnyykkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNNYYKKAHIKBN)
    public String getZrnnyykkahikbn() {
        return zrnnyykkahikbn;
    }

    public void setZrnnyykkahikbn(String pZrnnyykkahikbn) {
        zrnnyykkahikbn = pZrnnyykkahikbn;
    }

    private String zrnsykmtssyukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYKMTSSYUKAHIKBN)
    public String getZrnsykmtssyukahikbn() {
        return zrnsykmtssyukahikbn;
    }

    public void setZrnsykmtssyukahikbn(String pZrnsykmtssyukahikbn) {
        zrnsykmtssyukahikbn = pZrnsykmtssyukahikbn;
    }

    private String zrnfktrsmtkahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNFKTRSMTKAHIKBN)
    public String getZrnfktrsmtkahikbn() {
        return zrnfktrsmtkahikbn;
    }

    public void setZrnfktrsmtkahikbn(String pZrnfktrsmtkahikbn) {
        zrnfktrsmtkahikbn = pZrnfktrsmtkahikbn;
    }

    private String zrnseiketuseiyoukahikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSEIKETUSEIYOUKAHIKBN)
    public String getZrnseiketuseiyoukahikbn() {
        return zrnseiketuseiyoukahikbn;
    }

    public void setZrnseiketuseiyoukahikbn(String pZrnseiketuseiyoukahikbn) {
        zrnseiketuseiyoukahikbn = pZrnseiketuseiyoukahikbn;
    }

    private String zrnsyuurouhunoujyoutaikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUUROUHUNOUJYOUTAIKBN)
    public String getZrnsyuurouhunoujyoutaikbn() {
        return zrnsyuurouhunoujyoutaikbn;
    }

    public void setZrnsyuurouhunoujyoutaikbn(String pZrnsyuurouhunoujyoutaikbn) {
        zrnsyuurouhunoujyoutaikbn = pZrnsyuurouhunoujyoutaikbn;
    }

    private String zrnkyuuseisinkinkousokukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKYUUSEISINKINKOUSOKUKBN)
    public String getZrnkyuuseisinkinkousokukbn() {
        return zrnkyuuseisinkinkousokukbn;
    }

    public void setZrnkyuuseisinkinkousokukbn(String pZrnkyuuseisinkinkousokukbn) {
        zrnkyuuseisinkinkousokukbn = pZrnkyuuseisinkinkousokukbn;
    }

    private String zrnnousottyuukbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNNOUSOTTYUUKBN)
    public String getZrnnousottyuukbn() {
        return zrnnousottyuukbn;
    }

    public void setZrnnousottyuukbn(String pZrnnousottyuukbn) {
        zrnnousottyuukbn = pZrnnousottyuukbn;
    }

    private String zrnjinhuzenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNJINHUZENKBN)
    public String getZrnjinhuzenkbn() {
        return zrnjinhuzenkbn;
    }

    public void setZrnjinhuzenkbn(String pZrnjinhuzenkbn) {
        zrnjinhuzenkbn = pZrnjinhuzenkbn;
    }

    private String zrnhukasyuksyu;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNHUKASYUKSYU)
    public String getZrnhukasyuksyu() {
        return zrnhukasyuksyu;
    }

    public void setZrnhukasyuksyu(String pZrnhukasyuksyu) {
        zrnhukasyuksyu = pZrnhukasyuksyu;
    }

    private String zrntkkbn2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNTKKBN2)
    public String getZrntkkbn2() {
        return zrntkkbn2;
    }

    public void setZrntkkbn2(String pZrntkkbn2) {
        zrntkkbn2 = pZrntkkbn2;
    }

    private String zrndoumyakusikkankbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNDOUMYAKUSIKKANKBN)
    public String getZrndoumyakusikkankbn() {
        return zrndoumyakusikkankbn;
    }

    public void setZrndoumyakusikkankbn(String pZrndoumyakusikkankbn) {
        zrndoumyakusikkankbn = pZrndoumyakusikkankbn;
    }

    private String zrnsykikjgykbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYKIKJGYKBN)
    public String getZrnsykikjgykbn() {
        return zrnsykikjgykbn;
    }

    public void setZrnsykikjgykbn(String pZrnsykikjgykbn) {
        zrnsykikjgykbn = pZrnsykikjgykbn;
    }

    private String zrnkaijyokbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKAIJYOKBN)
    public String getZrnkaijyokbn() {
        return zrnkaijyokbn;
    }

    public void setZrnkaijyokbn(String pZrnkaijyokbn) {
        zrnkaijyokbn = pZrnkaijyokbn;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private String zrntyuutohukatkhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNTYUUTOHUKATKHYJ)
    public String getZrntyuutohukatkhyj() {
        return zrntyuutohukatkhyj;
    }

    public void setZrntyuutohukatkhyj(String pZrntyuutohukatkhyj) {
        zrntyuutohukatkhyj = pZrntyuutohukatkhyj;
    }

    private String zrnyoukigjyutigituymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOUKIGJYUTIGITUYMD)
    public String getZrnyoukigjyutigituymd() {
        return zrnyoukigjyutigituymd;
    }

    public void setZrnyoukigjyutigituymd(String pZrnyoukigjyutigituymd) {
        zrnyoukigjyutigituymd = pZrnyoukigjyutigituymd;
    }

    private String zrnyoukigjyutigeninkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOUKIGJYUTIGENINKBN)
    public String getZrnyoukigjyutigeninkbn() {
        return zrnyoukigjyutigeninkbn;
    }

    public void setZrnyoukigjyutigeninkbn(String pZrnyoukigjyutigeninkbn) {
        zrnyoukigjyutigeninkbn = pZrnyoukigjyutigeninkbn;
    }

    private String zrntihougeninkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNTIHOUGENINKBN)
    public String getZrntihougeninkbn() {
        return zrntihougeninkbn;
    }

    public void setZrntihougeninkbn(String pZrntihougeninkbn) {
        zrntihougeninkbn = pZrntihougeninkbn;
    }

    private String zrnsyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUKGUSDKBN)
    public String getZrnsyukgusdkbn() {
        return zrnsyukgusdkbn;
    }

    public void setZrnsyukgusdkbn(String pZrnsyukgusdkbn) {
        zrnsyukgusdkbn = pZrnsyukgusdkbn;
    }

    private String zrntignmrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNTIGNMRTISYUKGUSDKBN)
    public String getZrntignmrtisyukgusdkbn() {
        return zrntignmrtisyukgusdkbn;
    }

    public void setZrntignmrtisyukgusdkbn(String pZrntignmrtisyukgusdkbn) {
        zrntignmrtisyukgusdkbn = pZrntignmrtisyukgusdkbn;
    }

    private String zrnrenseimrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNRENSEIMRTISYUKGUSDKBN)
    public String getZrnrenseimrtisyukgusdkbn() {
        return zrnrenseimrtisyukgusdkbn;
    }

    public void setZrnrenseimrtisyukgusdkbn(String pZrnrenseimrtisyukgusdkbn) {
        zrnrenseimrtisyukgusdkbn = pZrnrenseimrtisyukgusdkbn;
    }

    private String zrnsyunyumrtisyukgusdkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYUNYUMRTISYUKGUSDKBN)
    public String getZrnsyunyumrtisyukgusdkbn() {
        return zrnsyunyumrtisyukgusdkbn;
    }

    public void setZrnsyunyumrtisyukgusdkbn(String pZrnsyunyumrtisyukgusdkbn) {
        zrnsyunyumrtisyukgusdkbn = pZrnsyunyumrtisyukgusdkbn;
    }

    private String zrnsbtoukeiidouinfopmenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSBTOUKEIIDOUINFOPMENKBN)
    public String getZrnsbtoukeiidouinfopmenkbn() {
        return zrnsbtoukeiidouinfopmenkbn;
    }

    public void setZrnsbtoukeiidouinfopmenkbn(String pZrnsbtoukeiidouinfopmenkbn) {
        zrnsbtoukeiidouinfopmenkbn = pZrnsbtoukeiidouinfopmenkbn;
    }

    private String zrnpmenjikohasseiymd;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNPMENJIKOHASSEIYMD)
    public String getZrnpmenjikohasseiymd() {
        return zrnpmenjikohasseiymd;
    }

    public void setZrnpmenjikohasseiymd(String pZrnpmenjikohasseiymd) {
        zrnpmenjikohasseiymd = pZrnpmenjikohasseiymd;
    }

    private String zrnsyorino2moji;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYORINO2MOJI)
    public String getZrnsyorino2moji() {
        return zrnsyorino2moji;
    }

    public void setZrnsyorino2moji(String pZrnsyorino2moji) {
        zrnsyorino2moji = pZrnsyorino2moji;
    }

    private String zrnksnym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKSNYM)
    public String getZrnksnym() {
        return zrnksnym;
    }

    public void setZrnksnym(String pZrnksnym) {
        zrnksnym = pZrnksnym;
    }

    private String zrnikoujisnskbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNIKOUJISNSKBN)
    public String getZrnikoujisnskbn() {
        return zrnikoujisnskbn;
    }

    public void setZrnikoujisnskbn(String pZrnikoujisnskbn) {
        zrnikoujisnskbn = pZrnikoujisnskbn;
    }

    private String zrnsysnikoujiym;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSYSNIKOUJIYM)
    public String getZrnsysnikoujiym() {
        return zrnsysnikoujiym;
    }

    public void setZrnsysnikoujiym(String pZrnsysnikoujiym) {
        zrnsysnikoujiym = pZrnsysnikoujiym;
    }

    private String zrnijitoukeiyuksnhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNIJITOUKEIYUKSNHYJ)
    public String getZrnijitoukeiyuksnhyj() {
        return zrnijitoukeiyuksnhyj;
    }

    public void setZrnijitoukeiyuksnhyj(String pZrnijitoukeiyuksnhyj) {
        zrnijitoukeiyuksnhyj = pZrnijitoukeiyuksnhyj;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrnstdsstkjytkyuhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSTDSSTKJYTKYUHYJ)
    public String getZrnstdsstkjytkyuhyj() {
        return zrnstdsstkjytkyuhyj;
    }

    public void setZrnstdsstkjytkyuhyj(String pZrnstdsstkjytkyuhyj) {
        zrnstdsstkjytkyuhyj = pZrnstdsstkjytkyuhyj;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnbnktgosnzkkyksyono;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBNKTGOSNZKKYKSYONO)
    public String getZrnbnktgosnzkkyksyono() {
        return zrnbnktgosnzkkyksyono;
    }

    public void setZrnbnktgosnzkkyksyono(String pZrnbnktgosnzkkyksyono) {
        zrnbnktgosnzkkyksyono = pZrnbnktgosnzkkyksyono;
    }

    private String zrnbnkttnknkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBNKTTNKNKBN)
    public String getZrnbnkttnknkbn() {
        return zrnbnkttnknkbn;
    }

    public void setZrnbnkttnknkbn(String pZrnbnkttnknkbn) {
        zrnbnkttnknkbn = pZrnbnkttnknkbn;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrnbnktjisisttkarihyj;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNBNKTJISISTTKARIHYJ)
    public String getZrnbnktjisisttkarihyj() {
        return zrnbnktjisisttkarihyj;
    }

    public void setZrnbnktjisisttkarihyj(String pZrnbnktjisisttkarihyj) {
        zrnbnktjisisttkarihyj = pZrnbnktjisisttkarihyj;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrnstdssnskbn;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNSTDSSNSKBN)
    public String getZrnstdssnskbn() {
        return zrnstdssnskbn;
    }

    public void setZrnstdssnskbn(String pZrnstdssnskbn) {
        zrnstdssnskbn = pZrnstdssnskbn;
    }

    private Integer zrnyobisuuti7x1;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOBISUUTI7X1)
    public Integer getZrnyobisuuti7x1() {
        return zrnyobisuuti7x1;
    }

    public void setZrnyobisuuti7x1(Integer pZrnyobisuuti7x1) {
        zrnyobisuuti7x1 = pZrnyobisuuti7x1;
    }

    private Integer zrnyobisuuti7x2;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOBISUUTI7X2)
    public Integer getZrnyobisuuti7x2() {
        return zrnyobisuuti7x2;
    }

    public void setZrnyobisuuti7x2(Integer pZrnyobisuuti7x2) {
        zrnyobisuuti7x2 = pZrnyobisuuti7x2;
    }

    private String zrnyobimojihan15;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOBIMOJIHAN15)
    public String getZrnyobimojihan15() {
        return zrnyobimojihan15;
    }

    public void setZrnyobimojihan15(String pZrnyobimojihan15) {
        zrnyobimojihan15 = pZrnyobimojihan15;
    }

    private String zrnyobimojihan51;

    @Column(name=GenZT_IjiToukeiIdouInfoRn.ZRNYOBIMOJIHAN51)
    public String getZrnyobimojihan51() {
        return zrnyobimojihan51;
    }

    public void setZrnyobimojihan51(String pZrnyobimojihan51) {
        zrnyobimojihan51 = pZrnyobimojihan51;
    }
}