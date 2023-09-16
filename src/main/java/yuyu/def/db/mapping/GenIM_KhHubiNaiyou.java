package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.id.PKIM_KhHubiNaiyou;
import yuyu.def.db.meta.GenQIM_KhHubiNaiyou;
import yuyu.def.db.meta.QIM_KhHubiNaiyou;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備内容マスタ テーブルのマッピング情報クラスで、 {@link IM_KhHubiNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHubiNaiyou}</td><td colspan="3">契約保全不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKIM_KhHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKIM_KhHubiNaiyou ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassinsakikbn hassinsakikbn}</td><td>発信先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassinsakiKbn}</td></tr>
 *  <tr><td>{@link #getGenponhnkykumu genponhnkykumu}</td><td>原本返却有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHubinaiyouhyoujijyun hubinaiyouhyoujijyun}</td><td>不備内容表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">{@link PKIM_KhHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyou hubinaiyou}</td><td>不備内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyoruimsg hubisyoruimsg}</td><td>不備書類用メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHubiNaiyou
 * @see     PKIM_KhHubiNaiyou
 * @see     QIM_KhHubiNaiyou
 * @see     GenQIM_KhHubiNaiyou
 */
@MappedSuperclass
@Table(name=GenIM_KhHubiNaiyou.TABLE_NAME)
@IdClass(value=PKIM_KhHubiNaiyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HassinsakiKbn", typeClass=UserType_C_HassinsakiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIM_KhHubiNaiyou extends AbstractExDBEntity<IM_KhHubiNaiyou, PKIM_KhHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhHubiNaiyou";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSINSAKIKBN            = "hassinsakikbn";
    public static final String GENPONHNKYKUMU           = "genponhnkykumu";
    public static final String HUBINAIYOUHYOUJIJYUN     = "hubinaiyouhyoujijyun";
    public static final String HUBINAIYOUCD             = "hubinaiyoucd";
    public static final String HUBINAIYOU               = "hubinaiyou";
    public static final String HUBISYORUIMSG            = "hubisyoruimsg";

    private final PKIM_KhHubiNaiyou primaryKey;

    public GenIM_KhHubiNaiyou() {
        primaryKey = new PKIM_KhHubiNaiyou();
    }

    public GenIM_KhHubiNaiyou(
        String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd,
        String pHubinaiyoucd
    ) {
        primaryKey = new PKIM_KhHubiNaiyou(
            pJimutetuzukicd,
            pSyoruiCd,
            pHubinaiyoucd
        );
    }

    @Transient
    @Override
    public PKIM_KhHubiNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhHubiNaiyou> getMetaClass() {
        return QIM_KhHubiNaiyou.class;
    }

    @Id
    @Column(name=GenIM_KhHubiNaiyou.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIM_KhHubiNaiyou.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private C_HassinsakiKbn hassinsakikbn;

    @Type(type="UserType_C_HassinsakiKbn")
    @Column(name=GenIM_KhHubiNaiyou.HASSINSAKIKBN)
    public C_HassinsakiKbn getHassinsakikbn() {
        return hassinsakikbn;
    }

    public void setHassinsakikbn(C_HassinsakiKbn pHassinsakikbn) {
        hassinsakikbn = pHassinsakikbn;
    }

    private C_UmuKbn genponhnkykumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIM_KhHubiNaiyou.GENPONHNKYKUMU)
    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkykumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkykumu) {
        genponhnkykumu = pGenponhnkykumu;
    }

    private Integer hubinaiyouhyoujijyun;

    @Column(name=GenIM_KhHubiNaiyou.HUBINAIYOUHYOUJIJYUN)
    public Integer getHubinaiyouhyoujijyun() {
        return hubinaiyouhyoujijyun;
    }

    public void setHubinaiyouhyoujijyun(Integer pHubinaiyouhyoujijyun) {
        hubinaiyouhyoujijyun = pHubinaiyouhyoujijyun;
    }

    @Id
    @Column(name=GenIM_KhHubiNaiyou.HUBINAIYOUCD)
    public String getHubinaiyoucd() {
        return getPrimaryKey().getHubinaiyoucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        getPrimaryKey().setHubinaiyoucd(pHubinaiyoucd);
    }

    private String hubinaiyou;

    @Column(name=GenIM_KhHubiNaiyou.HUBINAIYOU)
    public String getHubinaiyou() {
        return hubinaiyou;
    }

    public void setHubinaiyou(String pHubinaiyou) {
        hubinaiyou = pHubinaiyou;
    }

    private String hubisyoruimsg;

    @Column(name=GenIM_KhHubiNaiyou.HUBISYORUIMSG)
    public String getHubisyoruimsg() {
        return hubisyoruimsg;
    }

    public void setHubisyoruimsg(String pHubisyoruimsg) {
        hubisyoruimsg = pHubisyoruimsg;
    }
}