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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.id.PKJM_SiHubiNaiyou;
import yuyu.def.db.meta.GenQJM_SiHubiNaiyou;
import yuyu.def.db.meta.QJM_SiHubiNaiyou;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 支払不備内容マスタ テーブルのマッピング情報クラスで、 {@link JM_SiHubiNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SiHubiNaiyou}</td><td colspan="3">支払不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">{@link PKJM_SiHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKJM_SiHubiNaiyou ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHubinaiyoucd hubinaiyoucd}</td><td>不備内容コード</td><td align="center">{@link PKJM_SiHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubinaiyou hubinaiyou}</td><td>不備内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubisyoruimsg hubisyoruimsg}</td><td>不備書類用メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SiHubiNaiyou
 * @see     PKJM_SiHubiNaiyou
 * @see     QJM_SiHubiNaiyou
 * @see     GenQJM_SiHubiNaiyou
 */
@MappedSuperclass
@Table(name=GenJM_SiHubiNaiyou.TABLE_NAME)
@IdClass(value=PKJM_SiHubiNaiyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenJM_SiHubiNaiyou extends AbstractExDBEntity<JM_SiHubiNaiyou, PKJM_SiHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SiHubiNaiyou";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HUBINAIYOUCD             = "hubinaiyoucd";
    public static final String HUBINAIYOU               = "hubinaiyou";
    public static final String HUBISYORUIMSG            = "hubisyoruimsg";

    private final PKJM_SiHubiNaiyou primaryKey;

    public GenJM_SiHubiNaiyou() {
        primaryKey = new PKJM_SiHubiNaiyou();
    }

    public GenJM_SiHubiNaiyou(
        String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd,
        String pHubinaiyoucd
    ) {
        primaryKey = new PKJM_SiHubiNaiyou(
            pJimutetuzukicd,
            pSyoruiCd,
            pHubinaiyoucd
        );
    }

    @Transient
    @Override
    public PKJM_SiHubiNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SiHubiNaiyou> getMetaClass() {
        return QJM_SiHubiNaiyou.class;
    }

    @Id
    @Column(name=GenJM_SiHubiNaiyou.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return getPrimaryKey().getJimutetuzukicd();
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        getPrimaryKey().setJimutetuzukicd(pJimutetuzukicd);
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenJM_SiHubiNaiyou.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    @Id
    @Column(name=GenJM_SiHubiNaiyou.HUBINAIYOUCD)
    public String getHubinaiyoucd() {
        return getPrimaryKey().getHubinaiyoucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubinaiyoucd(String pHubinaiyoucd) {
        getPrimaryKey().setHubinaiyoucd(pHubinaiyoucd);
    }

    private String hubinaiyou;

    @Column(name=GenJM_SiHubiNaiyou.HUBINAIYOU)
    public String getHubinaiyou() {
        return hubinaiyou;
    }

    public void setHubinaiyou(String pHubinaiyou) {
        hubinaiyou = pHubinaiyou;
    }

    private String hubisyoruimsg;

    @Column(name=GenJM_SiHubiNaiyou.HUBISYORUIMSG)
    public String getHubisyoruimsg() {
        return hubisyoruimsg;
    }

    public void setHubisyoruimsg(String pHubisyoruimsg) {
        hubisyoruimsg = pHubisyoruimsg;
    }
}