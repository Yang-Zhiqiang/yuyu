package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.mapping.GenHT_BosUketorinin;
import yuyu.def.db.meta.GenQHT_BosUketorinin;
import yuyu.def.db.meta.QHT_BosUketorinin;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集受取人テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosUketorinin}</td><td colspan="3">募集受取人テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkjkhukakbn</td><td>受取人名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>ukttdk</td><td>受取人続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>uktbnwari</td><td>受取人分割割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>uktseiymd</td><td>受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ukttsindousiteikbn</td><td>受取人通信先同一指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsindousiteiKbn C_TsindousiteiKbn}</td></tr>
 *  <tr><td>uktyno</td><td>受取人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr1kj</td><td>受取人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr2kj</td><td>受取人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktadr3kj</td><td>受取人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosUketorinin
 * @see     GenHT_BosUketorinin
 * @see     QHT_BosUketorinin
 * @see     GenQHT_BosUketorinin
 */
public class PKHT_BosUketorinin extends AbstractExDBPrimaryKey<HT_BosUketorinin, PKHT_BosUketorinin> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosUketorinin() {
    }

    public PKHT_BosUketorinin(
        String pMosno,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        mosno = pMosno;
        uktsyukbn = pUktsyukbn;
        uktsyurenno = pUktsyurenno;
    }

    @Transient
    @Override
    public Class<HT_BosUketorinin> getEntityClass() {
        return HT_BosUketorinin.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
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