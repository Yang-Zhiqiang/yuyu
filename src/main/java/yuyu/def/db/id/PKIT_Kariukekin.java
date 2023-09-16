package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.mapping.GenIT_Kariukekin;
import yuyu.def.db.meta.GenQIT_Kariukekin;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 仮受金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_Kariukekin}</td><td colspan="3">仮受金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>krkkeijyoymd</td><td>仮受計上処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>krkgk</td><td>仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hasseidenymd</td><td>発生伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisandenymd</td><td>精算伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>krkseisanzumiflg</td><td>仮受精算済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Krkseisanzumiflg C_Krkseisanzumiflg}</td></tr>
 *  <tr><td>krkriyuukbn</td><td>仮受理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KrkriyuuKbn C_KrkriyuuKbn}</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>jyutoukaisuuy</td><td>充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jyutoukaisuum</td><td>充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_Kariukekin
 * @see     GenIT_Kariukekin
 * @see     QIT_Kariukekin
 * @see     GenQIT_Kariukekin
 */
public class PKIT_Kariukekin extends AbstractExDBPrimaryKey<IT_Kariukekin, PKIT_Kariukekin> {

    private static final long serialVersionUID = 1L;

    public PKIT_Kariukekin() {
    }

    public PKIT_Kariukekin(
        String pKbnkey,
        String pSyono,
        Integer pKrkno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        krkno = pKrkno;
    }

    @Transient
    @Override
    public Class<IT_Kariukekin> getEntityClass() {
        return IT_Kariukekin.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer krkno;

    public Integer getKrkno() {
        return krkno;
    }

    public void setKrkno(Integer pKrkno) {
        krkno = pKrkno;
    }

}