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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.id.PKHM_SkHubiKoumoku;
import yuyu.def.db.meta.GenQHM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 新契約不備項目マスタ テーブルのマッピング情報クラスで、 {@link HM_SkHubiKoumoku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHubiKoumoku}</td><td colspan="3">新契約不備項目マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKHM_SkHubiKoumoku ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSkhubikoumokucd skhubikoumokucd}</td><td>新契約不備項目コード</td><td align="center">{@link PKHM_SkHubiKoumoku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkhubikoumoku skhubikoumoku}</td><td>新契約不備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHyoujikahikbn hyoujikahikbn}</td><td>表示可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 * </table>
 * @see     HM_SkHubiKoumoku
 * @see     PKHM_SkHubiKoumoku
 * @see     QHM_SkHubiKoumoku
 * @see     GenQHM_SkHubiKoumoku
 */
@MappedSuperclass
@Table(name=GenHM_SkHubiKoumoku.TABLE_NAME)
@IdClass(value=PKHM_SkHubiKoumoku.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenHM_SkHubiKoumoku extends AbstractExDBEntity<HM_SkHubiKoumoku, PKHM_SkHubiKoumoku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkHubiKoumoku";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SKHUBIKOUMOKUCD          = "skhubikoumokucd";
    public static final String SKHUBIKOUMOKU            = "skhubikoumoku";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String HYOUJIKAHIKBN            = "hyoujikahikbn";

    private final PKHM_SkHubiKoumoku primaryKey;

    public GenHM_SkHubiKoumoku() {
        primaryKey = new PKHM_SkHubiKoumoku();
    }

    public GenHM_SkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd, String pSkhubikoumokucd) {
        primaryKey = new PKHM_SkHubiKoumoku(pSyoruiCd, pSkhubikoumokucd);
    }

    @Transient
    @Override
    public PKHM_SkHubiKoumoku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkHubiKoumoku> getMetaClass() {
        return QHM_SkHubiKoumoku.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenHM_SkHubiKoumoku.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    @Id
    @Column(name=GenHM_SkHubiKoumoku.SKHUBIKOUMOKUCD)
    public String getSkhubikoumokucd() {
        return getPrimaryKey().getSkhubikoumokucd();
    }

    public void setSkhubikoumokucd(String pSkhubikoumokucd) {
        getPrimaryKey().setSkhubikoumokucd(pSkhubikoumokucd);
    }

    private String skhubikoumoku;

    @Column(name=GenHM_SkHubiKoumoku.SKHUBIKOUMOKU)
    public String getSkhubikoumoku() {
        return skhubikoumoku;
    }

    public void setSkhubikoumoku(String pSkhubikoumoku) {
        skhubikoumoku = pSkhubikoumoku;
    }

    private Integer hyoujijyun;

    @Column(name=GenHM_SkHubiKoumoku.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private C_KahiKbn hyoujikahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenHM_SkHubiKoumoku.HYOUJIKAHIKBN)
    public C_KahiKbn getHyoujikahikbn() {
        return hyoujikahikbn;
    }

    public void setHyoujikahikbn(C_KahiKbn pHyoujikahikbn) {
        hyoujikahikbn = pHyoujikahikbn;
    }
}