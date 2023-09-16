package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.id.PKHM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.GenQHM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.type.UserType_C_AisyoumeiChannelKbn;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;

/**
 * 保険種類番号愛称マスタ テーブルのマッピング情報クラスで、 {@link HM_SkHokenSyuruiNoAisyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHokenSyuruiNoAisyou}</td><td colspan="3">保険種類番号愛称マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">{@link PKHM_SkHokenSyuruiNoAisyou ○}</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getHknsyuruinosdfrom hknsyuruinosdfrom}</td><td>保険種類番号世代自</td><td align="center">{@link PKHM_SkHokenSyuruiNoAisyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknsyuruinosdto hknsyuruinosdto}</td><td>保険種類番号世代至</td><td align="center">{@link PKHM_SkHokenSyuruiNoAisyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknsyuruinobetukey1 hknsyuruinobetukey1}</td><td>保険種類番号別キー１</td><td align="center">{@link PKHM_SkHokenSyuruiNoAisyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisyoumeichannelkbn aisyoumeichannelkbn}</td><td>愛称名チャネル区分</td><td align="center">{@link PKHM_SkHokenSyuruiNoAisyou ○}</td><td align="center">V</td><td>{@link C_AisyoumeiChannelKbn}</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getAisyoumei aisyoumei}</td><td>愛称名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHusyoudakumanualinfo husyoudakumanualinfo}</td><td>不承諾手続きマニュアル情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SkHokenSyuruiNoAisyou
 * @see     PKHM_SkHokenSyuruiNoAisyou
 * @see     QHM_SkHokenSyuruiNoAisyou
 * @see     GenQHM_SkHokenSyuruiNoAisyou
 */
@MappedSuperclass
@Table(name=GenHM_SkHokenSyuruiNoAisyou.TABLE_NAME)
@IdClass(value=PKHM_SkHokenSyuruiNoAisyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_AisyoumeiChannelKbn", typeClass=UserType_C_AisyoumeiChannelKbn.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class)
})
public abstract class GenHM_SkHokenSyuruiNoAisyou extends AbstractExDBEntity<HM_SkHokenSyuruiNoAisyou, PKHM_SkHokenSyuruiNoAisyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkHokenSyuruiNoAisyou";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String HKNSYURUINOSDFROM        = "hknsyuruinosdfrom";
    public static final String HKNSYURUINOSDTO          = "hknsyuruinosdto";
    public static final String HKNSYURUINOBETUKEY1      = "hknsyuruinobetukey1";
    public static final String AISYOUMEICHANNELKBN      = "aisyoumeichannelkbn";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String AISYOUMEI                = "aisyoumei";
    public static final String HUSYOUDAKUMANUALINFO     = "husyoudakumanualinfo";

    private final PKHM_SkHokenSyuruiNoAisyou primaryKey;

    public GenHM_SkHokenSyuruiNoAisyou() {
        primaryKey = new PKHM_SkHokenSyuruiNoAisyou();
    }

    public GenHM_SkHokenSyuruiNoAisyou(
        C_HknsyuruiNo pHknsyuruino,
        Integer pHknsyuruinosdfrom,
        Integer pHknsyuruinosdto,
        String pHknsyuruinobetukey1,
        C_AisyoumeiChannelKbn pAisyoumeichannelkbn
    ) {
        primaryKey = new PKHM_SkHokenSyuruiNoAisyou(
            pHknsyuruino,
            pHknsyuruinosdfrom,
            pHknsyuruinosdto,
            pHknsyuruinobetukey1,
            pAisyoumeichannelkbn
        );
    }

    @Transient
    @Override
    public PKHM_SkHokenSyuruiNoAisyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkHokenSyuruiNoAisyou> getMetaClass() {
        return QHM_SkHokenSyuruiNoAisyou.class;
    }

    @Id
    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return getPrimaryKey().getHknsyuruino();
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        getPrimaryKey().setHknsyuruino(pHknsyuruino);
    }

    @Id
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.HKNSYURUINOSDFROM)
    public Integer getHknsyuruinosdfrom() {
        return getPrimaryKey().getHknsyuruinosdfrom();
    }

    public void setHknsyuruinosdfrom(Integer pHknsyuruinosdfrom) {
        getPrimaryKey().setHknsyuruinosdfrom(pHknsyuruinosdfrom);
    }

    @Id
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.HKNSYURUINOSDTO)
    public Integer getHknsyuruinosdto() {
        return getPrimaryKey().getHknsyuruinosdto();
    }

    public void setHknsyuruinosdto(Integer pHknsyuruinosdto) {
        getPrimaryKey().setHknsyuruinosdto(pHknsyuruinosdto);
    }

    @Id
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.HKNSYURUINOBETUKEY1)
    public String getHknsyuruinobetukey1() {
        return getPrimaryKey().getHknsyuruinobetukey1();
    }

    public void setHknsyuruinobetukey1(String pHknsyuruinobetukey1) {
        getPrimaryKey().setHknsyuruinobetukey1(pHknsyuruinobetukey1);
    }

    @Id
    @Type(type="UserType_C_AisyoumeiChannelKbn")
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.AISYOUMEICHANNELKBN)
    public C_AisyoumeiChannelKbn getAisyoumeichannelkbn() {
        return getPrimaryKey().getAisyoumeichannelkbn();
    }

    public void setAisyoumeichannelkbn(C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        getPrimaryKey().setAisyoumeichannelkbn(pAisyoumeichannelkbn);
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenHM_SkHokenSyuruiNoAisyou.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private String aisyoumei;

    @Column(name=GenHM_SkHokenSyuruiNoAisyou.AISYOUMEI)
    public String getAisyoumei() {
        return aisyoumei;
    }

    public void setAisyoumei(String pAisyoumei) {
        aisyoumei = pAisyoumei;
    }

    private String husyoudakumanualinfo;

    @Column(name=GenHM_SkHokenSyuruiNoAisyou.HUSYOUDAKUMANUALINFO)
    public String getHusyoudakumanualinfo() {
        return husyoudakumanualinfo;
    }

    public void setHusyoudakumanualinfo(String pHusyoudakumanualinfo) {
        husyoudakumanualinfo = pHusyoudakumanualinfo;
    }
}