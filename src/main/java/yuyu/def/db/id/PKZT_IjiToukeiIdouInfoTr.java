package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.mapping.GenZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;

/**
 * 医事統計異動情報テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IjiToukeiIdouInfoTr}</td><td colspan="3">医事統計異動情報テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyono ztrsyono}</td><td>（取込用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyoriymd</td><td>（取込用）処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrkykmfksnctr ztrkykmfksnctr}</td><td>（取込用）契約ＭＦ更新ＣＴＲ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrsyukgu</td><td>（取込用）種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknnen2keta</td><td>（取込用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknseikbn</td><td>（取込用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykym</td><td>（取込用）契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkisnkihons</td><td>（取込用）計算基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrimustiyusbus</td><td>（取込用）医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrshrs</td><td>（取込用）支払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrshrymd</td><td>（取込用）支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsymtgenincd</td><td>（取込用）消滅原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkeikaym</td><td>（取込用）経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsbugenincd</td><td>（取込用）死亡原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbsyym</td><td>（取込用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdai2hhknnen</td><td>（取込用）第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmannenreihyj</td><td>（取込用）満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtignmrtisyukgu</td><td>（取込用）逓減マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknnentysihyj</td><td>（取込用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdai2hhknnentysihyj</td><td>（取込用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrrenseimrtisyukgu</td><td>（取込用）連生マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbnktjitiktkarihyj</td><td>（取込用）分割時定期特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrlivingneedsshrarihyj</td><td>（取込用）リビングニーズ支払有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrlnkeikaym</td><td>（取込用）ＬＮ経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrlnshrgenincd</td><td>（取込用）ＬＮ支払原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkituenkbn</td><td>（取込用）喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkituenhonsuu</td><td>（取込用）喫煙本数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgnspshrhyj</td><td>（取込用）がんサポ支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgnspshrkeikaym</td><td>（取込用）がんサポ支払経過年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgnspshrgenincd</td><td>（取込用）がんサポ支払原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyunyumrtisyukgu</td><td>（取込用）収入マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsysnymd</td><td>（取込用）初診年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsindanymd</td><td>（取込用）診断年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbyoumeicd1</td><td>（取込用）病名コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbyoumeicd2</td><td>（取込用）病名コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrshrnaiyoukbn</td><td>（取込用）支払内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgituyuknkbn1</td><td>（取込用）該当要件区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrgituyuknkbn2</td><td>（取込用）該当要件区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyeiebnri1</td><td>（取込用）シェイエ分類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyeiebnri2</td><td>（取込用）シェイエ分類２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrminnesotacd1</td><td>（取込用）ミネソタコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrminnesotacd2</td><td>（取込用）ミネソタコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrminnesotacd3</td><td>（取込用）ミネソタコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrminnesotacd4</td><td>（取込用）ミネソタコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrminnesotacd5</td><td>（取込用）ミネソタコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmnsisiensindanjiyuu</td><td>（取込用）慢性膵炎診断事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknkuhnsindanjiyuu</td><td>（取込用）肝硬変診断事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhushrkbn</td><td>（取込用）不支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhushrym</td><td>（取込用）不支払年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyuurouhunoukghasseiymd</td><td>（取込用）就労不能介護傷病発生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyuurouhunoukgjyoutaikbn</td><td>（取込用）就労不能介護状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhokoukahikbn</td><td>（取込用）歩行可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrngerkahikbn</td><td>（取込用）寝返り可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrihukutyakudatukahikbn</td><td>（取込用）衣服着脱可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnyykkahikbn</td><td>（取込用）入浴可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsykmtssyukahikbn</td><td>（取込用）食物摂取可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrfktrsmtkahikbn</td><td>（取込用）拭き取り始末可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseiketuseiyoukahikbn</td><td>（取込用）清潔整容可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyuurouhunoujyoutaikbn</td><td>（取込用）就労不能状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyuuseisinkinkousokukbn</td><td>（取込用）急性心筋梗塞区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnousottyuukbn</td><td>（取込用）脳卒中区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrjinhuzenkbn</td><td>（取込用）腎不全区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhukasyuksyu</td><td>（取込用）付加主契約種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtkkbn2</td><td>（取込用）特約区分（２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdoumyakusikkankbn</td><td>（取込用）動脈疾患区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsykikjgykbn</td><td>（取込用）職域事業区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkaijyokbn</td><td>（取込用）解除区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsymtymd</td><td>（取込用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtyuutohukatkhyj</td><td>（取込用）中途付加特約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryoukigjyutigituymd</td><td>（取込用）要介護状態該当年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryoukigjyutigeninkbn</td><td>（取込用）要介護状態原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtihougeninkbn</td><td>（取込用）痴呆原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyukgusdkbn</td><td>（取込用）種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtignmrtisyukgusdkbn</td><td>（取込用）逓減マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrrenseimrtisyukgusdkbn</td><td>（取込用）連生マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyunyumrtisyukgusdkbn</td><td>（取込用）収入マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsbtoukeiidouinfopmenkbn</td><td>（取込用）死亡統計異動情報Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrpmenjikohasseiymd</td><td>（取込用）Ｐ免事故発生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyorino2moji</td><td>（取込用）処理番号（２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrksnym</td><td>（取込用）更新年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrikoujisnskbn</td><td>（取込用）移行時診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsysnikoujiym</td><td>（取込用）終身移行時年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrijitoukeiyuksnhyj</td><td>（取込用）医事統計用更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsotodasiphkbnmnoshyouji</td><td>（取込用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrstdsstkjytkyuhyj</td><td>（取込用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrstdssytikbn</td><td>（取込用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbnktgosnzkkyksyono</td><td>（取込用）分割後存続契約証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbnkttnknkbn</td><td>（取込用）分割転換区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykjiqpackhyj</td><td>（取込用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbnktjisisttkarihyj</td><td>（取込用）分割時災疾特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsotodasipmenkbn</td><td>（取込用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrstdssnskbn</td><td>（取込用）外出診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobisuuti7x1</td><td>（取込用）予備数値７＿１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztryobisuuti7x2</td><td>（取込用）予備数値７＿２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztryobimojihan15</td><td>（取込用）予備文字半角１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobimojihan51</td><td>（取込用）予備文字半角５１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_IjiToukeiIdouInfoTr
 * @see     GenZT_IjiToukeiIdouInfoTr
 * @see     QZT_IjiToukeiIdouInfoTr
 * @see     GenQZT_IjiToukeiIdouInfoTr
 */
public class PKZT_IjiToukeiIdouInfoTr extends AbstractExDBPrimaryKey<ZT_IjiToukeiIdouInfoTr, PKZT_IjiToukeiIdouInfoTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_IjiToukeiIdouInfoTr() {
    }

    public PKZT_IjiToukeiIdouInfoTr(String pZtrsyono, Integer pZtrkykmfksnctr) {
        ztrsyono = pZtrsyono;
        ztrkykmfksnctr = pZtrkykmfksnctr;
    }

    @Transient
    @Override
    public Class<ZT_IjiToukeiIdouInfoTr> getEntityClass() {
        return ZT_IjiToukeiIdouInfoTr.class;
    }

    private String ztrsyono;

    public String getZtrsyono() {
        return ztrsyono;
    }

    public void setZtrsyono(String pZtrsyono) {
        ztrsyono = pZtrsyono;
    }
    private Integer ztrkykmfksnctr;

    public Integer getZtrkykmfksnctr() {
        return ztrkykmfksnctr;
    }

    public void setZtrkykmfksnctr(Integer pZtrkykmfksnctr) {
        ztrkykmfksnctr = pZtrkykmfksnctr;
    }

}