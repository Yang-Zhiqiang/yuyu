package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.mapping.GenJT_SiUkt;
import yuyu.def.db.meta.GenQJT_SiUkt;
import yuyu.def.db.meta.QJT_SiUkt;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払受取人テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiUkt}</td><td colspan="3">支払受取人テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHkuktsyu hkuktsyu}</td><td>給付金受取人種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_Hkuktsyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktseiymd</td><td>受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ukttdk</td><td>受取人続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>uktbnwari</td><td>受取人分割割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiUkt
 * @see     GenJT_SiUkt
 * @see     QJT_SiUkt
 * @see     GenQJT_SiUkt
 */
public class PKJT_SiUkt extends AbstractExDBPrimaryKey<JT_SiUkt, PKJT_SiUkt> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiUkt() {
    }

    public PKJT_SiUkt(
        String pSyono,
        C_Hkuktsyu pHkuktsyu,
        Integer pUktsyurenno
    ) {
        syono = pSyono;
        hkuktsyu = pHkuktsyu;
        uktsyurenno = pUktsyurenno;
    }

    @Transient
    @Override
    public Class<JT_SiUkt> getEntityClass() {
        return JT_SiUkt.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_Hkuktsyu hkuktsyu;

    @org.hibernate.annotations.Type(type="UserType_C_Hkuktsyu")
    public C_Hkuktsyu getHkuktsyu() {
        return hkuktsyu;
    }

    public void setHkuktsyu(C_Hkuktsyu pHkuktsyu) {
        hkuktsyu = pHkuktsyu;
    }
    private Integer uktsyurenno;

    public Integer getUktsyurenno() {
        return uktsyurenno;
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        uktsyurenno = pUktsyurenno;
    }

}