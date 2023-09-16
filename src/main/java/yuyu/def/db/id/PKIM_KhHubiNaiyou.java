package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.mapping.GenIM_KhHubiNaiyou;
import yuyu.def.db.meta.GenQIM_KhHubiNaiyou;
import yuyu.def.db.meta.QIM_KhHubiNaiyou;

/**
 * 契約保全不備内容マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHubiNaiyou}</td><td colspan="3">契約保全不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassinsakikbn</td><td>発信先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassinsakiKbn C_HassinsakiKbn}</td></tr>
 *  <tr><td>genponhnkykumu</td><td>原本返却有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hubinaiyouhyoujijyun</td><td>不備内容表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubinaiyou</td><td>不備内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hubisyoruimsg</td><td>不備書類用メッセージ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHubiNaiyou
 * @see     GenIM_KhHubiNaiyou
 * @see     QIM_KhHubiNaiyou
 * @see     GenQIM_KhHubiNaiyou
 */
public class PKIM_KhHubiNaiyou extends AbstractExDBPrimaryKey<IM_KhHubiNaiyou, PKIM_KhHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhHubiNaiyou() {
    }

    public PKIM_KhHubiNaiyou(
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
    public Class<IM_KhHubiNaiyou> getEntityClass() {
        return IM_KhHubiNaiyou.class;
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