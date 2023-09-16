package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.def.db.id.PKBM_NenkinYoteiRiritu;
import yuyu.def.db.meta.GenQBM_NenkinYoteiRiritu;
import yuyu.def.db.meta.QBM_NenkinYoteiRiritu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 年金開始後予定利率マスタ テーブルのマッピング情報クラスで、 {@link BM_NenkinYoteiRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_NenkinYoteiRiritu}</td><td colspan="3">年金開始後予定利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNenkinsyu nenkinsyu}</td><td>年金種類</td><td align="center">{@link PKBM_NenkinYoteiRiritu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_NenkinYoteiRiritu ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">{@link PKBM_NenkinYoteiRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">{@link PKBM_NenkinYoteiRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_NenkinYoteiRiritu
 * @see     PKBM_NenkinYoteiRiritu
 * @see     QBM_NenkinYoteiRiritu
 * @see     GenQBM_NenkinYoteiRiritu
 */
@MappedSuperclass
@Table(name=GenBM_NenkinYoteiRiritu.TABLE_NAME)
@IdClass(value=PKBM_NenkinYoteiRiritu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_NenkinYoteiRiritu extends AbstractExDBEntity<BM_NenkinYoteiRiritu, PKBM_NenkinYoteiRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_NenkinYoteiRiritu";
    public static final String NENKINSYU                = "nenkinsyu";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String KYKFROMYMD               = "kykfromymd";
    public static final String KYKTOYMD                 = "kyktoymd";
    public static final String YOTEIRIRITU              = "yoteiriritu";

    private final PKBM_NenkinYoteiRiritu primaryKey;

    public GenBM_NenkinYoteiRiritu() {
        primaryKey = new PKBM_NenkinYoteiRiritu();
    }

    public GenBM_NenkinYoteiRiritu(
        String pNenkinsyu,
        C_Tuukasyu pTuukasyu,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        primaryKey = new PKBM_NenkinYoteiRiritu(
            pNenkinsyu,
            pTuukasyu,
            pKykfromymd,
            pKyktoymd
        );
    }

    @Transient
    @Override
    public PKBM_NenkinYoteiRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_NenkinYoteiRiritu> getMetaClass() {
        return QBM_NenkinYoteiRiritu.class;
    }

    @Id
    @Column(name=GenBM_NenkinYoteiRiritu.NENKINSYU)
    public String getNenkinsyu() {
        return getPrimaryKey().getNenkinsyu();
    }

    public void setNenkinsyu(String pNenkinsyu) {
        getPrimaryKey().setNenkinsyu(pNenkinsyu);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_NenkinYoteiRiritu.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_NenkinYoteiRiritu.KYKFROMYMD)
    public BizDate getKykfromymd() {
        return getPrimaryKey().getKykfromymd();
    }

    public void setKykfromymd(BizDate pKykfromymd) {
        getPrimaryKey().setKykfromymd(pKykfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_NenkinYoteiRiritu.KYKTOYMD)
    public BizDate getKyktoymd() {
        return getPrimaryKey().getKyktoymd();
    }

    public void setKyktoymd(BizDate pKyktoymd) {
        getPrimaryKey().setKyktoymd(pKyktoymd);
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_NenkinYoteiRiritu.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }
}
