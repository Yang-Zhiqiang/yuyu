package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.db.id.PKHW_SikinIdouWk;
import yuyu.def.db.meta.GenQHW_SikinIdouWk;
import yuyu.def.db.meta.QHW_SikinIdouWk;

/**
 * 資金移動ワークテーブル テーブルのマッピング情報クラスで、 {@link HW_SikinIdouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_SikinIdouWk}</td><td colspan="3">資金移動ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">{@link PKHW_SikinIdouWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">{@link PKHW_SikinIdouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSikinidoumotohonkouzacd sikinidoumotohonkouzacd}</td><td>資金移動元本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSikinidousakihonkouzacd sikinidousakihonkouzacd}</td><td>資金移動先本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSikinidougaku sikinidougaku}</td><td>資金移動額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_SikinIdouWk
 * @see     PKHW_SikinIdouWk
 * @see     QHW_SikinIdouWk
 * @see     GenQHW_SikinIdouWk
 */
@MappedSuperclass
@Table(name=GenHW_SikinIdouWk.TABLE_NAME)
@IdClass(value=PKHW_SikinIdouWk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenHW_SikinIdouWk extends AbstractExDBEntity<HW_SikinIdouWk, PKHW_SikinIdouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_SikinIdouWk";
    public static final String NYKSYORIYMD              = "nyksyoriymd";
    public static final String ITIRENNO                 = "itirenno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SIKINIDOUMOTOHONKOUZACD  = "sikinidoumotohonkouzacd";
    public static final String SIKINIDOUSAKIHONKOUZACD  = "sikinidousakihonkouzacd";
    public static final String SIKINIDOUGAKU            = "sikinidougaku";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHW_SikinIdouWk primaryKey;

    public GenHW_SikinIdouWk() {
        primaryKey = new PKHW_SikinIdouWk();
    }

    public GenHW_SikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {
        primaryKey = new PKHW_SikinIdouWk(pNyksyoriymd, pItirenno);
    }

    @Transient
    @Override
    public PKHW_SikinIdouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_SikinIdouWk> getMetaClass() {
        return QHW_SikinIdouWk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_SikinIdouWk.NYKSYORIYMD)
    public BizDate getNyksyoriymd() {
        return getPrimaryKey().getNyksyoriymd();
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        getPrimaryKey().setNyksyoriymd(pNyksyoriymd);
    }

    @Id
    @Column(name=GenHW_SikinIdouWk.ITIRENNO)
    public String getItirenno() {
        return getPrimaryKey().getItirenno();
    }

    public void setItirenno(String pItirenno) {
        getPrimaryKey().setItirenno(pItirenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHW_SikinIdouWk.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String sikinidoumotohonkouzacd;

    @Column(name=GenHW_SikinIdouWk.SIKINIDOUMOTOHONKOUZACD)
    public String getSikinidoumotohonkouzacd() {
        return sikinidoumotohonkouzacd;
    }

    public void setSikinidoumotohonkouzacd(String pSikinidoumotohonkouzacd) {
        sikinidoumotohonkouzacd = pSikinidoumotohonkouzacd;
    }

    private String sikinidousakihonkouzacd;

    @Column(name=GenHW_SikinIdouWk.SIKINIDOUSAKIHONKOUZACD)
    public String getSikinidousakihonkouzacd() {
        return sikinidousakihonkouzacd;
    }

    public void setSikinidousakihonkouzacd(String pSikinidousakihonkouzacd) {
        sikinidousakihonkouzacd = pSikinidousakihonkouzacd;
    }

    private BizCurrency sikinidougaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSikinidougaku() {
        return sikinidougaku;
    }

    public void setSikinidougaku(BizCurrency pSikinidougaku) {
        sikinidougaku = pSikinidougaku;
        sikinidougakuValue = null;
        sikinidougakuType  = null;
    }

    transient private BigDecimal sikinidougakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIKINIDOUGAKU, nullable=true)
    protected BigDecimal getSikinidougakuValue() {
        if (sikinidougakuValue == null && sikinidougaku != null) {
            if (sikinidougaku.isOptional()) return null;
            return sikinidougaku.absolute();
        }
        return sikinidougakuValue;
    }

    protected void setSikinidougakuValue(BigDecimal value) {
        sikinidougakuValue = value;
        sikinidougaku = Optional.fromNullable(toCurrencyType(sikinidougakuType))
            .transform(bizCurrencyTransformer(getSikinidougakuValue()))
            .orNull();
    }

    transient private String sikinidougakuType = null;

    @Column(name=SIKINIDOUGAKU + "$", nullable=true)
    protected String getSikinidougakuType() {
        if (sikinidougakuType == null && sikinidougaku != null) return sikinidougaku.getType().toString();
        if (sikinidougakuType == null && getSikinidougakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sikinidougaku$' should not be NULL."));
        }
        return sikinidougakuType;
    }

    protected void setSikinidougakuType(String type) {
        sikinidougakuType = type;
        sikinidougaku = Optional.fromNullable(toCurrencyType(sikinidougakuType))
            .transform(bizCurrencyTransformer(getSikinidougakuValue()))
            .orNull();
    }

    private String nykmosno;

    @Column(name=GenHW_SikinIdouWk.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHW_SikinIdouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHW_SikinIdouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}