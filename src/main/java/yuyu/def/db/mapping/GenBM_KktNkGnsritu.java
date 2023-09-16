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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import yuyu.def.db.id.PKBM_KktNkGnsritu;
import yuyu.def.db.meta.GenQBM_KktNkGnsritu;
import yuyu.def.db.meta.QBM_KktNkGnsritu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 確定年金原資率マスタ テーブルのマッピング情報クラスで、 {@link BM_KktNkGnsritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KktNkGnsritu}</td><td colspan="3">確定年金原資率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_KktNkGnsritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_KktNkGnsritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkkn shrkkn}</td><td>支払期間</td><td align="center">{@link PKBM_KktNkGnsritu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnsritu nkgnsritu}</td><td>年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNkgnsritu2 nkgnsritu2}</td><td>年金原資率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KktNkGnsritu
 * @see     PKBM_KktNkGnsritu
 * @see     QBM_KktNkGnsritu
 * @see     GenQBM_KktNkGnsritu
 */
@MappedSuperclass
@Table(name=GenBM_KktNkGnsritu.TABLE_NAME)
@IdClass(value=PKBM_KktNkGnsritu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_KktNkGnsritu extends AbstractExDBEntity<BM_KktNkGnsritu, PKBM_KktNkGnsritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KktNkGnsritu";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SHRKKN                   = "shrkkn";
    public static final String NKGNSRITU                = "nkgnsritu";
    public static final String NKGNSRITU2               = "nkgnsritu2";

    private final PKBM_KktNkGnsritu primaryKey;

    public GenBM_KktNkGnsritu() {
        primaryKey = new PKBM_KktNkGnsritu();
    }

    public GenBM_KktNkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        Integer pShrkkn
    ) {
        primaryKey = new PKBM_KktNkGnsritu(
            pRyouritusdno,
            pTuukasyu,
            pShrkkn
        );
    }

    @Transient
    @Override
    public PKBM_KktNkGnsritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KktNkGnsritu> getMetaClass() {
        return QBM_KktNkGnsritu.class;
    }

    @Id
    @Column(name=GenBM_KktNkGnsritu.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_KktNkGnsritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_KktNkGnsritu.SHRKKN)
    public Integer getShrkkn() {
        return getPrimaryKey().getShrkkn();
    }

    public void setShrkkn(Integer pShrkkn) {
        getPrimaryKey().setShrkkn(pShrkkn);
    }

    private BizNumber nkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KktNkGnsritu.NKGNSRITU)
    public BizNumber getNkgnsritu() {
        return nkgnsritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkgnsritu(BizNumber pNkgnsritu) {
        nkgnsritu = pNkgnsritu;
    }

    private BizNumber nkgnsritu2;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KktNkGnsritu.NKGNSRITU2)
    public BizNumber getNkgnsritu2() {
        return nkgnsritu2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkgnsritu2(BizNumber pNkgnsritu2) {
        nkgnsritu2 = pNkgnsritu2;
    }
}