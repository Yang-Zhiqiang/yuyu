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
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.id.PKHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.GenQHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 新契約整備指示内容マスタ テーブルのマッピング情報クラスで、 {@link HM_SkSeibiSijiNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkSeibiSijiNaiyou}</td><td colspan="3">新契約整備指示内容マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkseibisijinaiyoucd skseibisijinaiyoucd}</td><td>新契約整備指示内容コード</td><td align="center">{@link PKHM_SkSeibiSijiNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkseibisijinaiyou skseibisijinaiyou}</td><td>新契約整備指示内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHyoujikahikbn hyoujikahikbn}</td><td>表示可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkSeibiSijiNaiyou
 * @see     PKHM_SkSeibiSijiNaiyou
 * @see     QHM_SkSeibiSijiNaiyou
 * @see     GenQHM_SkSeibiSijiNaiyou
 */
@MappedSuperclass
@Table(name=GenHM_SkSeibiSijiNaiyou.TABLE_NAME)
@IdClass(value=PKHM_SkSeibiSijiNaiyou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class)
})
public abstract class GenHM_SkSeibiSijiNaiyou extends AbstractExDBEntity<HM_SkSeibiSijiNaiyou, PKHM_SkSeibiSijiNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkSeibiSijiNaiyou";
    public static final String SKSEIBISIJINAIYOUCD      = "skseibisijinaiyoucd";
    public static final String SKSEIBISIJINAIYOU        = "skseibisijinaiyou";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String HYOUJIKAHIKBN            = "hyoujikahikbn";

    private final PKHM_SkSeibiSijiNaiyou primaryKey;

    public GenHM_SkSeibiSijiNaiyou() {
        primaryKey = new PKHM_SkSeibiSijiNaiyou();
    }

    public GenHM_SkSeibiSijiNaiyou(String pSkseibisijinaiyoucd) {
        primaryKey = new PKHM_SkSeibiSijiNaiyou(pSkseibisijinaiyoucd);
    }

    @Transient
    @Override
    public PKHM_SkSeibiSijiNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkSeibiSijiNaiyou> getMetaClass() {
        return QHM_SkSeibiSijiNaiyou.class;
    }

    @Id
    @Column(name=GenHM_SkSeibiSijiNaiyou.SKSEIBISIJINAIYOUCD)
    public String getSkseibisijinaiyoucd() {
        return getPrimaryKey().getSkseibisijinaiyoucd();
    }

    public void setSkseibisijinaiyoucd(String pSkseibisijinaiyoucd) {
        getPrimaryKey().setSkseibisijinaiyoucd(pSkseibisijinaiyoucd);
    }

    private String skseibisijinaiyou;

    @Column(name=GenHM_SkSeibiSijiNaiyou.SKSEIBISIJINAIYOU)
    public String getSkseibisijinaiyou() {
        return skseibisijinaiyou;
    }

    public void setSkseibisijinaiyou(String pSkseibisijinaiyou) {
        skseibisijinaiyou = pSkseibisijinaiyou;
    }

    private Integer hyoujijyun;

    @Column(name=GenHM_SkSeibiSijiNaiyou.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private C_KahiKbn hyoujikahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenHM_SkSeibiSijiNaiyou.HYOUJIKAHIKBN)
    public C_KahiKbn getHyoujikahikbn() {
        return hyoujikahikbn;
    }

    public void setHyoujikahikbn(C_KahiKbn pHyoujikahikbn) {
        hyoujikahikbn = pHyoujikahikbn;
    }
}