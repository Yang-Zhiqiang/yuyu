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
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.id.PKBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.meta.GenQBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.meta.QBM_KktNk1stNkBigkGnsritu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 確定年金（第１回年金倍額型）原資率マスタ テーブルのマッピング情報クラスで、 {@link BM_KktNk1stNkBigkGnsritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KktNk1stNkBigkGnsritu}</td><td colspan="3">確定年金（第１回年金倍額型）原資率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_KktNk1stNkBigkGnsritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_KktNk1stNkBigkGnsritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkkn shrkkn}</td><td>支払期間</td><td align="center">{@link PKBM_KktNk1stNkBigkGnsritu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNkgnsritu nkgnsritu}</td><td>年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KktNk1stNkBigkGnsritu
 * @see     PKBM_KktNk1stNkBigkGnsritu
 * @see     QBM_KktNk1stNkBigkGnsritu
 * @see     GenQBM_KktNk1stNkBigkGnsritu
 */
@MappedSuperclass
@Table(name=GenBM_KktNk1stNkBigkGnsritu.TABLE_NAME)
@IdClass(value=PKBM_KktNk1stNkBigkGnsritu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_KktNk1stNkBigkGnsritu extends AbstractExDBEntity<BM_KktNk1stNkBigkGnsritu, PKBM_KktNk1stNkBigkGnsritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KktNk1stNkBigkGnsritu";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String SHRKKN                   = "shrkkn";
    public static final String NKGNSRITU                = "nkgnsritu";

    private final PKBM_KktNk1stNkBigkGnsritu primaryKey;

    public GenBM_KktNk1stNkBigkGnsritu() {
        primaryKey = new PKBM_KktNk1stNkBigkGnsritu();
    }

    public GenBM_KktNk1stNkBigkGnsritu(
        String pRyouritusdno,
        C_Tuukasyu pTuukasyu,
        Integer pShrkkn
    ) {
        primaryKey = new PKBM_KktNk1stNkBigkGnsritu(
            pRyouritusdno,
            pTuukasyu,
            pShrkkn
        );
    }

    @Transient
    @Override
    public PKBM_KktNk1stNkBigkGnsritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KktNk1stNkBigkGnsritu> getMetaClass() {
        return QBM_KktNk1stNkBigkGnsritu.class;
    }

    @Id
    @Column(name=GenBM_KktNk1stNkBigkGnsritu.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_KktNk1stNkBigkGnsritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_KktNk1stNkBigkGnsritu.SHRKKN)
    public Integer getShrkkn() {
        return getPrimaryKey().getShrkkn();
    }

    public void setShrkkn(Integer pShrkkn) {
        getPrimaryKey().setShrkkn(pShrkkn);
    }

    private BizNumber nkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KktNk1stNkBigkGnsritu.NKGNSRITU)
    public BizNumber getNkgnsritu() {
        return nkgnsritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkgnsritu(BizNumber pNkgnsritu) {
        nkgnsritu = pNkgnsritu;
    }
}