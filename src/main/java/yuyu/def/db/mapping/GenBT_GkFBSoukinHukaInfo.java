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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.number.BizCurrency;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.def.db.id.PKBT_GkFBSoukinHukaInfo;
import yuyu.def.db.meta.GenQBT_GkFBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_GkFBSoukinHukaInfo;

/**
 * 外貨ＦＢ送金付加情報データテーブル テーブルのマッピング情報クラスで、 {@link BT_GkFBSoukinHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_GkFBSoukinHukaInfo}</td><td colspan="3">外貨ＦＢ送金付加情報データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">{@link PKBT_GkFBSoukinHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFbtrhksyoukaino fbtrhksyoukaino}</td><td>ＦＢ取引先照会番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDengk dengk}</td><td>伝票金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_GkFBSoukinHukaInfo
 * @see     PKBT_GkFBSoukinHukaInfo
 * @see     QBT_GkFBSoukinHukaInfo
 * @see     GenQBT_GkFBSoukinHukaInfo
 */
@MappedSuperclass
@Table(name=GenBT_GkFBSoukinHukaInfo.TABLE_NAME)
@IdClass(value=PKBT_GkFBSoukinHukaInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class)
})
public abstract class GenBT_GkFBSoukinHukaInfo extends AbstractExDBEntity<BT_GkFBSoukinHukaInfo, PKBT_GkFBSoukinHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_GkFBSoukinHukaInfo";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String FBTRHKSYOUKAINO          = "fbtrhksyoukaino";
    public static final String DENGK                    = "dengk";

    private final PKBT_GkFBSoukinHukaInfo primaryKey;

    public GenBT_GkFBSoukinHukaInfo() {
        primaryKey = new PKBT_GkFBSoukinHukaInfo();
    }

    public GenBT_GkFBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        primaryKey = new PKBT_GkFBSoukinHukaInfo(pFbsoukindatasikibetukey);
    }

    @Transient
    @Override
    public PKBT_GkFBSoukinHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_GkFBSoukinHukaInfo> getMetaClass() {
        return QBT_GkFBSoukinHukaInfo.class;
    }

    @Id
    @Column(name=GenBT_GkFBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return getPrimaryKey().getFbsoukindatasikibetukey();
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        getPrimaryKey().setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
    }

    private String fbtrhksyoukaino;

    @Column(name=GenBT_GkFBSoukinHukaInfo.FBTRHKSYOUKAINO)
    public String getFbtrhksyoukaino() {
        return fbtrhksyoukaino;
    }

    public void setFbtrhksyoukaino(String pFbtrhksyoukaino) {
        fbtrhksyoukaino = pFbtrhksyoukaino;
    }

    private BizCurrency dengk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDengk() {
        return dengk;
    }

    public void setDengk(BizCurrency pDengk) {
        dengk = pDengk;
        dengkValue = null;
        dengkType  = null;
    }

    transient private BigDecimal dengkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DENGK, nullable=true)
    protected BigDecimal getDengkValue() {
        if (dengkValue == null && dengk != null) {
            if (dengk.isOptional()) return null;
            return dengk.absolute();
        }
        return dengkValue;
    }

    protected void setDengkValue(BigDecimal value) {
        dengkValue = value;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }

    transient private String dengkType = null;

    @Column(name=DENGK + "$", nullable=true)
    protected String getDengkType() {
        if (dengkType == null && dengk != null) return dengk.getType().toString();
        if (dengkType == null && getDengkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dengk$' should not be NULL."));
        }
        return dengkType;
    }

    protected void setDengkType(String type) {
        dengkType = type;
        dengk = Optional.fromNullable(toCurrencyType(dengkType))
            .transform(bizCurrencyTransformer(getDengkValue()))
            .orNull();
    }
}
