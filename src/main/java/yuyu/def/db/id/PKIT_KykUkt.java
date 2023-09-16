package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.mapping.GenIT_KykUkt;
import yuyu.def.db.meta.GenQIT_KykUkt;
import yuyu.def.db.meta.QIT_KykUkt;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約受取人テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykUkt}</td><td colspan="3">契約受取人テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kokno</td><td>顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkjkhukakbn</td><td>受取人名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>uktseiymd</td><td>受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ukttdk</td><td>受取人続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>uktbnwari</td><td>受取人分割割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktyno</td><td>受取人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr1kj</td><td>受取人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr2kj</td><td>受取人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr3kj</td><td>受取人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KykUkt
 * @see     GenIT_KykUkt
 * @see     QIT_KykUkt
 * @see     GenQIT_KykUkt
 */
public class PKIT_KykUkt extends AbstractExDBPrimaryKey<IT_KykUkt, PKIT_KykUkt> {

    private static final long serialVersionUID = 1L;

    public PKIT_KykUkt() {
    }

    public PKIT_KykUkt(
        String pKbnkey,
        String pSyono,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        uktsyukbn = pUktsyukbn;
        uktsyurenno = pUktsyurenno;
    }

    @Transient
    @Override
    public Class<IT_KykUkt> getEntityClass() {
        return IT_KykUkt.class;
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
    private C_UktsyuKbn uktsyukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UktsyuKbn")
    public C_UktsyuKbn getUktsyukbn() {
        return uktsyukbn;
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        uktsyukbn = pUktsyukbn;
    }
    private Integer uktsyurenno;

    public Integer getUktsyurenno() {
        return uktsyurenno;
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        uktsyurenno = pUktsyurenno;
    }

}