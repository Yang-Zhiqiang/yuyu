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
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import yuyu.def.db.id.PKBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.GenQBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.QBT_SikinIdouListCsvFSks;
import yuyu.def.db.type.UserType_C_SikinidoulistKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リストＣＳＶファイル作成用テーブル テーブルのマッピング情報クラスで、 {@link BT_SikinIdouListCsvFSks} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SikinIdouListCsvFSks}</td><td colspan="3">資金移動リストＣＳＶファイル作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_SikinIdouListCsvFSks ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSikinidoulistkbn sikinidoulistkbn}</td><td>資金移動リスト区分</td><td align="center">{@link PKBT_SikinIdouListCsvFSks ○}</td><td align="center">V</td><td>{@link C_SikinidoulistKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBT_SikinIdouListCsvFSks ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSikinidouymd sikinidouymd}</td><td>資金移動日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSikinidoumeisaigk sikinidoumeisaigk}</td><td>資金移動明細額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukkinkouzatuukasyu syukkinkouzatuukasyu}</td><td>出金口座通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukkinkouzano syukkinkouzano}</td><td>出金口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNyuukinkouzatuukasyu nyuukinkouzatuukasyu}</td><td>入金口座通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getNyuukinkouzano nyuukinkouzano}</td><td>入金口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFilesakuseiymd filesakuseiymd}</td><td>ファイル作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_SikinIdouListCsvFSks
 * @see     PKBT_SikinIdouListCsvFSks
 * @see     QBT_SikinIdouListCsvFSks
 * @see     GenQBT_SikinIdouListCsvFSks
 */
@MappedSuperclass
@Table(name=GenBT_SikinIdouListCsvFSks.TABLE_NAME)
@IdClass(value=PKBT_SikinIdouListCsvFSks.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SikinidoulistKbn", typeClass=UserType_C_SikinidoulistKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_SikinIdouListCsvFSks extends AbstractExDBEntity<BT_SikinIdouListCsvFSks, PKBT_SikinIdouListCsvFSks> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SikinIdouListCsvFSks";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SIKINIDOULISTKBN         = "sikinidoulistkbn";
    public static final String RENNO                    = "renno";
    public static final String SIKINIDOUYMD             = "sikinidouymd";
    public static final String SIKINIDOUMEISAIGK        = "sikinidoumeisaigk";
    public static final String SYUKKINKOUZATUUKASYU     = "syukkinkouzatuukasyu";
    public static final String SYUKKINKOUZANO           = "syukkinkouzano";
    public static final String NYUUKINKOUZATUUKASYU     = "nyuukinkouzatuukasyu";
    public static final String NYUUKINKOUZANO           = "nyuukinkouzano";
    public static final String FILESAKUSEIYMD           = "filesakuseiymd";

    private final PKBT_SikinIdouListCsvFSks primaryKey;

    public GenBT_SikinIdouListCsvFSks() {
        primaryKey = new PKBT_SikinIdouListCsvFSks();
    }

    public GenBT_SikinIdouListCsvFSks(
        BizDate pSyoriYmd,
        C_SikinidoulistKbn pSikinidoulistkbn,
        Integer pRenno
    ) {
        primaryKey = new PKBT_SikinIdouListCsvFSks(
            pSyoriYmd,
            pSikinidoulistkbn,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBT_SikinIdouListCsvFSks getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SikinIdouListCsvFSks> getMetaClass() {
        return QBT_SikinIdouListCsvFSks.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouListCsvFSks.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Type(type="UserType_C_SikinidoulistKbn")
    @Column(name=GenBT_SikinIdouListCsvFSks.SIKINIDOULISTKBN)
    public C_SikinidoulistKbn getSikinidoulistkbn() {
        return getPrimaryKey().getSikinidoulistkbn();
    }

    public void setSikinidoulistkbn(C_SikinidoulistKbn pSikinidoulistkbn) {
        getPrimaryKey().setSikinidoulistkbn(pSikinidoulistkbn);
    }

    @Id
    @Column(name=GenBT_SikinIdouListCsvFSks.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate sikinidouymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouListCsvFSks.SIKINIDOUYMD)
    public BizDate getSikinidouymd() {
        return sikinidouymd;
    }

    public void setSikinidouymd(BizDate pSikinidouymd) {
        sikinidouymd = pSikinidouymd;
    }

    private BizCurrency sikinidoumeisaigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSikinidoumeisaigk() {
        return sikinidoumeisaigk;
    }

    public void setSikinidoumeisaigk(BizCurrency pSikinidoumeisaigk) {
        sikinidoumeisaigk = pSikinidoumeisaigk;
        sikinidoumeisaigkValue = null;
        sikinidoumeisaigkType  = null;
    }

    transient private BigDecimal sikinidoumeisaigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIKINIDOUMEISAIGK, nullable=true)
    protected BigDecimal getSikinidoumeisaigkValue() {
        if (sikinidoumeisaigkValue == null && sikinidoumeisaigk != null) {
            if (sikinidoumeisaigk.isOptional()) return null;
            return sikinidoumeisaigk.absolute();
        }
        return sikinidoumeisaigkValue;
    }

    protected void setSikinidoumeisaigkValue(BigDecimal value) {
        sikinidoumeisaigkValue = value;
        sikinidoumeisaigk = Optional.fromNullable(toCurrencyType(sikinidoumeisaigkType))
            .transform(bizCurrencyTransformer(getSikinidoumeisaigkValue()))
            .orNull();
    }

    transient private String sikinidoumeisaigkType = null;

    @Column(name=SIKINIDOUMEISAIGK + "$", nullable=true)
    protected String getSikinidoumeisaigkType() {
        if (sikinidoumeisaigkType == null && sikinidoumeisaigk != null) return sikinidoumeisaigk.getType().toString();
        if (sikinidoumeisaigkType == null && getSikinidoumeisaigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sikinidoumeisaigk$' should not be NULL."));
        }
        return sikinidoumeisaigkType;
    }

    protected void setSikinidoumeisaigkType(String type) {
        sikinidoumeisaigkType = type;
        sikinidoumeisaigk = Optional.fromNullable(toCurrencyType(sikinidoumeisaigkType))
            .transform(bizCurrencyTransformer(getSikinidoumeisaigkValue()))
            .orNull();
    }

    private C_Tuukasyu syukkinkouzatuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SikinIdouListCsvFSks.SYUKKINKOUZATUUKASYU)
    public C_Tuukasyu getSyukkinkouzatuukasyu() {
        return syukkinkouzatuukasyu;
    }

    public void setSyukkinkouzatuukasyu(C_Tuukasyu pSyukkinkouzatuukasyu) {
        syukkinkouzatuukasyu = pSyukkinkouzatuukasyu;
    }

    private String syukkinkouzano;

    @Column(name=GenBT_SikinIdouListCsvFSks.SYUKKINKOUZANO)
    public String getSyukkinkouzano() {
        return syukkinkouzano;
    }

    public void setSyukkinkouzano(String pSyukkinkouzano) {
        syukkinkouzano = pSyukkinkouzano;
    }

    private C_Tuukasyu nyuukinkouzatuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SikinIdouListCsvFSks.NYUUKINKOUZATUUKASYU)
    public C_Tuukasyu getNyuukinkouzatuukasyu() {
        return nyuukinkouzatuukasyu;
    }

    public void setNyuukinkouzatuukasyu(C_Tuukasyu pNyuukinkouzatuukasyu) {
        nyuukinkouzatuukasyu = pNyuukinkouzatuukasyu;
    }

    private String nyuukinkouzano;

    @Column(name=GenBT_SikinIdouListCsvFSks.NYUUKINKOUZANO)
    public String getNyuukinkouzano() {
        return nyuukinkouzano;
    }

    public void setNyuukinkouzano(String pNyuukinkouzano) {
        nyuukinkouzano = pNyuukinkouzano;
    }

    private BizDate filesakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouListCsvFSks.FILESAKUSEIYMD)
    public BizDate getFilesakuseiymd() {
        return filesakuseiymd;
    }

    public void setFilesakuseiymd(BizDate pFilesakuseiymd) {
        filesakuseiymd = pFilesakuseiymd;
    }
}