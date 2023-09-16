package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.mapping.GenHM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.GenQHM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNoAisyou;

/**
 * 保険種類番号愛称マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHokenSyuruiNoAisyou}</td><td colspan="3">保険種類番号愛称マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">○</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruinosdfrom hknsyuruinosdfrom}</td><td>保険種類番号世代自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruinosdto hknsyuruinosdto}</td><td>保険種類番号世代至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknsyuruinobetukey1 hknsyuruinobetukey1}</td><td>保険種類番号別キー１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAisyoumeichannelkbn aisyoumeichannelkbn}</td><td>愛称名チャネル区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AisyoumeiChannelKbn}</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>aisyoumei</td><td>愛称名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>husyoudakumanualinfo</td><td>不承諾手続きマニュアル情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SkHokenSyuruiNoAisyou
 * @see     GenHM_SkHokenSyuruiNoAisyou
 * @see     QHM_SkHokenSyuruiNoAisyou
 * @see     GenQHM_SkHokenSyuruiNoAisyou
 */
public class PKHM_SkHokenSyuruiNoAisyou extends AbstractExDBPrimaryKey<HM_SkHokenSyuruiNoAisyou, PKHM_SkHokenSyuruiNoAisyou> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkHokenSyuruiNoAisyou() {
    }

    public PKHM_SkHokenSyuruiNoAisyou(
        C_HknsyuruiNo pHknsyuruino,
        Integer pHknsyuruinosdfrom,
        Integer pHknsyuruinosdto,
        String pHknsyuruinobetukey1,
        C_AisyoumeiChannelKbn pAisyoumeichannelkbn
    ) {
        hknsyuruino = pHknsyuruino;
        hknsyuruinosdfrom = pHknsyuruinosdfrom;
        hknsyuruinosdto = pHknsyuruinosdto;
        hknsyuruinobetukey1 = pHknsyuruinobetukey1;
        aisyoumeichannelkbn = pAisyoumeichannelkbn;
    }

    @Transient
    @Override
    public Class<HM_SkHokenSyuruiNoAisyou> getEntityClass() {
        return HM_SkHokenSyuruiNoAisyou.class;
    }

    private C_HknsyuruiNo hknsyuruino;

    @org.hibernate.annotations.Type(type="UserType_C_HknsyuruiNo")
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }
    private Integer hknsyuruinosdfrom;

    public Integer getHknsyuruinosdfrom() {
        return hknsyuruinosdfrom;
    }

    public void setHknsyuruinosdfrom(Integer pHknsyuruinosdfrom) {
        hknsyuruinosdfrom = pHknsyuruinosdfrom;
    }
    private Integer hknsyuruinosdto;

    public Integer getHknsyuruinosdto() {
        return hknsyuruinosdto;
    }

    public void setHknsyuruinosdto(Integer pHknsyuruinosdto) {
        hknsyuruinosdto = pHknsyuruinosdto;
    }
    private String hknsyuruinobetukey1;

    public String getHknsyuruinobetukey1() {
        return hknsyuruinobetukey1;
    }

    public void setHknsyuruinobetukey1(String pHknsyuruinobetukey1) {
        hknsyuruinobetukey1 = pHknsyuruinobetukey1;
    }
    private C_AisyoumeiChannelKbn aisyoumeichannelkbn;

    @org.hibernate.annotations.Type(type="UserType_C_AisyoumeiChannelKbn")
    public C_AisyoumeiChannelKbn getAisyoumeichannelkbn() {
        return aisyoumeichannelkbn;
    }

    public void setAisyoumeichannelkbn(C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        aisyoumeichannelkbn = pAisyoumeichannelkbn;
    }

}