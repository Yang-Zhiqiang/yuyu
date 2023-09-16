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
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.id.PKHM_SkHubiNaiyou;
import yuyu.def.db.meta.GenQHM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 新契約不備内容マスタ テーブルのマッピング情報クラスで、 {@link HM_SkHubiNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiNaiyou}</td><td colspan="3">新契約不備内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkhubikoumokucd skhubikoumokucd}</td><td>新契約不備項目コード</td><td align="center">{@link PKHM_SkHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubinaiyoucd skhubinaiyoucd}</td><td>新契約不備内容コード</td><td align="center">{@link PKHM_SkHubiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubinaiyou skhubinaiyou}</td><td>新契約不備内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubinaiyousentakumongon skhubinaiyousentakumongon}</td><td>新契約不備内容選択文言</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkseibisijinaiyoucd skseibisijinaiyoucd}</td><td>新契約整備指示内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubirenrakunaiyoucd skhubirenrakunaiyoucd}</td><td>新契約不備連絡内容コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHyoujikahikbn hyoujikahikbn}</td><td>表示可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiNaiyou
 * @see     PKHM_SkHubiNaiyou
 * @see     QHM_SkHubiNaiyou
 * @see     GenQHM_SkHubiNaiyou
 */
@MappedSuperclass
@Table(name=GenHM_SkHubiNaiyou.TABLE_NAME)
@IdClass(value=PKHM_SkHubiNaiyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class)
})
public abstract class GenHM_SkHubiNaiyou extends AbstractExDBEntity<HM_SkHubiNaiyou, PKHM_SkHubiNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkHubiNaiyou";
    public static final String SKHUBIKOUMOKUCD          = "skhubikoumokucd";
    public static final String SKHUBINAIYOUCD           = "skhubinaiyoucd";
    public static final String SKHUBINAIYOU             = "skhubinaiyou";
    public static final String SKHUBINAIYOUSENTAKUMONGON = "skhubinaiyousentakumongon";
    public static final String SKSEIBISIJINAIYOUCD      = "skseibisijinaiyoucd";
    public static final String SKHUBIRENRAKUNAIYOUCD    = "skhubirenrakunaiyoucd";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String HYOUJIKAHIKBN            = "hyoujikahikbn";

    private final PKHM_SkHubiNaiyou primaryKey;

    public GenHM_SkHubiNaiyou() {
        primaryKey = new PKHM_SkHubiNaiyou();
    }

    public GenHM_SkHubiNaiyou(String pSkhubikoumokucd, String pSkhubinaiyoucd) {
        primaryKey = new PKHM_SkHubiNaiyou(pSkhubikoumokucd, pSkhubinaiyoucd);
    }

    @Transient
    @Override
    public PKHM_SkHubiNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkHubiNaiyou> getMetaClass() {
        return QHM_SkHubiNaiyou.class;
    }

    @Id
    @Column(name=GenHM_SkHubiNaiyou.SKHUBIKOUMOKUCD)
    public String getSkhubikoumokucd() {
        return getPrimaryKey().getSkhubikoumokucd();
    }

    public void setSkhubikoumokucd(String pSkhubikoumokucd) {
        getPrimaryKey().setSkhubikoumokucd(pSkhubikoumokucd);
    }

    @Id
    @Column(name=GenHM_SkHubiNaiyou.SKHUBINAIYOUCD)
    public String getSkhubinaiyoucd() {
        return getPrimaryKey().getSkhubinaiyoucd();
    }

    public void setSkhubinaiyoucd(String pSkhubinaiyoucd) {
        getPrimaryKey().setSkhubinaiyoucd(pSkhubinaiyoucd);
    }

    private String skhubinaiyou;

    @Column(name=GenHM_SkHubiNaiyou.SKHUBINAIYOU)
    public String getSkhubinaiyou() {
        return skhubinaiyou;
    }

    public void setSkhubinaiyou(String pSkhubinaiyou) {
        skhubinaiyou = pSkhubinaiyou;
    }

    private String skhubinaiyousentakumongon;

    @Column(name=GenHM_SkHubiNaiyou.SKHUBINAIYOUSENTAKUMONGON)
    public String getSkhubinaiyousentakumongon() {
        return skhubinaiyousentakumongon;
    }

    public void setSkhubinaiyousentakumongon(String pSkhubinaiyousentakumongon) {
        skhubinaiyousentakumongon = pSkhubinaiyousentakumongon;
    }

    private String skseibisijinaiyoucd;

    @Column(name=GenHM_SkHubiNaiyou.SKSEIBISIJINAIYOUCD)
    public String getSkseibisijinaiyoucd() {
        return skseibisijinaiyoucd;
    }

    public void setSkseibisijinaiyoucd(String pSkseibisijinaiyoucd) {
        skseibisijinaiyoucd = pSkseibisijinaiyoucd;
    }

    private String skhubirenrakunaiyoucd;

    @Column(name=GenHM_SkHubiNaiyou.SKHUBIRENRAKUNAIYOUCD)
    public String getSkhubirenrakunaiyoucd() {
        return skhubirenrakunaiyoucd;
    }

    public void setSkhubirenrakunaiyoucd(String pSkhubirenrakunaiyoucd) {
        skhubirenrakunaiyoucd = pSkhubirenrakunaiyoucd;
    }

    private Integer hyoujijyun;

    @Column(name=GenHM_SkHubiNaiyou.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private C_KahiKbn hyoujikahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenHM_SkHubiNaiyou.HYOUJIKAHIKBN)
    public C_KahiKbn getHyoujikahikbn() {
        return hyoujikahikbn;
    }

    public void setHyoujikahikbn(C_KahiKbn pHyoujikahikbn) {
        hyoujikahikbn = pHyoujikahikbn;
    }
}
