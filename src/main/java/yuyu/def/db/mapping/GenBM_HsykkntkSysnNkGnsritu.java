package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.id.PKBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.GenQBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.meta.QBM_HsykkntkSysnNkGnsritu;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 保証期間付終身年金原資率マスタ テーブルのマッピング情報クラスで、 {@link BM_HsykkntkSysnNkGnsritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HsykkntkSysnNkGnsritu}</td><td colspan="3">保証期間付終身年金原資率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_HsykkntkSysnNkGnsritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_HsykkntkSysnNkGnsritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">{@link PKBM_HsykkntkSysnNkGnsritu ○}</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getNkshrstartnen nkshrstartnen}</td><td>年金支払開始年齢</td><td align="center">{@link PKBM_HsykkntkSysnNkGnsritu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHsykkn hsykkn}</td><td>保証期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnsritu nkgnsritu}</td><td>年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_HsykkntkSysnNkGnsritu
 * @see     PKBM_HsykkntkSysnNkGnsritu
 * @see     QBM_HsykkntkSysnNkGnsritu
 * @see     GenQBM_HsykkntkSysnNkGnsritu
 */
@MappedSuperclass
@Table(name=GenBM_HsykkntkSysnNkGnsritu.TABLE_NAME)
@IdClass(value=PKBM_HsykkntkSysnNkGnsritu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_HsykkntkSysnNkGnsritu extends AbstractExDBEntity<BM_HsykkntkSysnNkGnsritu, PKBM_HsykkntkSysnNkGnsritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_HsykkntkSysnNkGnsritu";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SEIBETU                  = "seibetu";
    public static final String NKSHRSTARTNEN            = "nkshrstartnen";
    public static final String HSYKKN                   = "hsykkn";
    public static final String NKGNSRITU                = "nkgnsritu";

    private final PKBM_HsykkntkSysnNkGnsritu primaryKey;

    public GenBM_HsykkntkSysnNkGnsritu() {
        primaryKey = new PKBM_HsykkntkSysnNkGnsritu();
    }

    public GenBM_HsykkntkSysnNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        C_Seibetu pSeibetu,
        Integer pNkshrstartnen
    ) {
        primaryKey = new PKBM_HsykkntkSysnNkGnsritu(
            pRyouritusdno,
            pTuukasyu,
            pSeibetu,
            pNkshrstartnen
        );
    }

    @Transient
    @Override
    public PKBM_HsykkntkSysnNkGnsritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_HsykkntkSysnNkGnsritu> getMetaClass() {
        return QBM_HsykkntkSysnNkGnsritu.class;
    }

    @Id
    @Column(name=GenBM_HsykkntkSysnNkGnsritu.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_HsykkntkSysnNkGnsritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Type(type="UserType_C_Seibetu")
    @Column(name=GenBM_HsykkntkSysnNkGnsritu.SEIBETU)
    public C_Seibetu getSeibetu() {
        return getPrimaryKey().getSeibetu();
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        getPrimaryKey().setSeibetu(pSeibetu);
    }

    @Id
    @Column(name=GenBM_HsykkntkSysnNkGnsritu.NKSHRSTARTNEN)
    public Integer getNkshrstartnen() {
        return getPrimaryKey().getNkshrstartnen();
    }

    public void setNkshrstartnen(Integer pNkshrstartnen) {
        getPrimaryKey().setNkshrstartnen(pNkshrstartnen);
    }

    private Integer hsykkn;

    @Column(name=GenBM_HsykkntkSysnNkGnsritu.HSYKKN)
    public Integer getHsykkn() {
        return hsykkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHsykkn(Integer pHsykkn) {
        hsykkn = pHsykkn;
    }

    private BizNumber nkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_HsykkntkSysnNkGnsritu.NKGNSRITU)
    public BizNumber getNkgnsritu() {
        return nkgnsritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkgnsritu(BizNumber pNkgnsritu) {
        nkgnsritu = pNkgnsritu;
    }
}