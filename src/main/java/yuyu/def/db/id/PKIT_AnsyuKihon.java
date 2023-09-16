package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.mapping.GenIT_AnsyuKihon;
import yuyu.def.db.meta.GenQIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納基本テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AnsyuKihon}</td><td colspan="3">案内収納基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>tkiktannaitukisuu</td><td>定期一括案内月数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkiktannaitukisuu C_Tkiktannaitukisuu}</td></tr>
 *  <tr><td>kjsmhakkouzumiflg</td><td>控除証明書発行済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kjsmhakkouzumiflg C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>syuharaimanymd</td><td>主契約払満日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_AnsyuKihon
 * @see     GenIT_AnsyuKihon
 * @see     QIT_AnsyuKihon
 * @see     GenQIT_AnsyuKihon
 */
public class PKIT_AnsyuKihon extends AbstractExDBPrimaryKey<IT_AnsyuKihon, PKIT_AnsyuKihon> {

    private static final long serialVersionUID = 1L;

    public PKIT_AnsyuKihon() {
    }

    public PKIT_AnsyuKihon(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_AnsyuKihon> getEntityClass() {
        return IT_AnsyuKihon.class;
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

}