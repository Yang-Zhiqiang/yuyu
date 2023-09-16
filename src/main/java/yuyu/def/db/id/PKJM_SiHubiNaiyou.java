package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.mapping.GenJM_SiHubiNaiyou;
import yuyu.def.db.meta.GenQJM_SiHubiNaiyou;
import yuyu.def.db.meta.QJM_SiHubiNaiyou;

/**
 * 支払不備内容マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiHubiNaiyou}</td><td colspan="3">支払不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyou</td><td>不備内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubisyoruimsg</td><td>不備書類用メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SiHubiNaiyou
 * @see     GenJM_SiHubiNaiyou
 * @see     QJM_SiHubiNaiyou
 * @see     GenQJM_SiHubiNaiyou
 */
public class PKJM_SiHubiNaiyou extends AbstractExDBPrimaryKey<JM_SiHubiNaiyou, PKJM_SiHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKJM_SiHubiNaiyou() {
    }

    public PKJM_SiHubiNaiyou(
        String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd,
        String pHubinaiyoucd
    ) {
        jimutetuzukicd = pJimutetuzukicd;
        syoruiCd = pSyoruiCd;
        hubinaiyoucd = pHubinaiyoucd;
    }

    @Transient
    @Override
    public Class<JM_SiHubiNaiyou> getEntityClass() {
        return JM_SiHubiNaiyou.class;
    }

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
    private String hubinaiyoucd;

    public String getHubinaiyoucd() {
        return hubinaiyoucd;
    }

    public void setHubinaiyoucd(String pHubinaiyoucd) {
        hubinaiyoucd = pHubinaiyoucd;
    }

}