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
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.IT_BAK_KhHenreikin;
import yuyu.def.db.id.PKIT_BAK_KhHenreikin;
import yuyu.def.db.meta.GenQIT_BAK_KhHenreikin;
import yuyu.def.db.meta.QIT_BAK_KhHenreikin;
import yuyu.def.db.type.UserType_C_HrsyuruiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Siharaijyoutaikbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全返戻金バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhHenreikin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHenreikin}</td><td colspan="3">契約保全返戻金バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhHenreikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhHenreikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhHenreikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_KhHenreikin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrsyuruikbn hrsyuruikbn}</td><td>返戻金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrhsiymd hrhsiymd}</td><td>返戻金発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrhsisyoriymd hrhsisyoriymd}</td><td>返戻金発生処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenreikingk henreikingk}</td><td>返戻金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrsiharaijyoutaikbn hrsiharaijyoutaikbn}</td><td>返戻金支払状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Siharaijyoutaikbn}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSeg2cd seg2cd}</td><td>セグメント２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhHenreikin
 * @see     PKIT_BAK_KhHenreikin
 * @see     QIT_BAK_KhHenreikin
 * @see     GenQIT_BAK_KhHenreikin
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhHenreikin.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhHenreikin.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HrsyuruiKbn", typeClass=UserType_C_HrsyuruiKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_Siharaijyoutaikbn", typeClass=UserType_C_Siharaijyoutaikbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class)
})
public abstract class GenIT_BAK_KhHenreikin extends AbstractExDBEntity<IT_BAK_KhHenreikin, PKIT_BAK_KhHenreikin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhHenreikin";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String HRSYURUIKBN              = "hrsyuruikbn";
    public static final String SHRYMD                   = "shrymd";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String HRHSIYMD                 = "hrhsiymd";
    public static final String HRHSISYORIYMD            = "hrhsisyoriymd";
    public static final String HENREIKINGK              = "henreikingk";
    public static final String HRSIHARAIJYOUTAIKBN      = "hrsiharaijyoutaikbn";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SEG2CD                   = "seg2cd";
    public static final String TANTOCD                  = "tantocd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KhHenreikin primaryKey;

    public GenIT_BAK_KhHenreikin() {
        primaryKey = new PKIT_BAK_KhHenreikin();
    }

    public GenIT_BAK_KhHenreikin(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_KhHenreikin(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhHenreikin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhHenreikin> getMetaClass() {
        return QIT_BAK_KhHenreikin.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhHenreikin.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhHenreikin.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_BAK_KhHenreikin.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhHenreikin.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_HrsyuruiKbn hrsyuruikbn;

    @Type(type="UserType_C_HrsyuruiKbn")
    @Column(name=GenIT_BAK_KhHenreikin.HRSYURUIKBN)
    public C_HrsyuruiKbn getHrsyuruikbn() {
        return hrsyuruikbn;
    }

    public void setHrsyuruikbn(C_HrsyuruiKbn pHrsyuruikbn) {
        hrsyuruikbn = pHrsyuruikbn;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHenreikin.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHenreikin.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate hrhsiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHenreikin.HRHSIYMD)
    public BizDate getHrhsiymd() {
        return hrhsiymd;
    }

    public void setHrhsiymd(BizDate pHrhsiymd) {
        hrhsiymd = pHrhsiymd;
    }

    private BizDate hrhsisyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhHenreikin.HRHSISYORIYMD)
    public BizDate getHrhsisyoriymd() {
        return hrhsisyoriymd;
    }

    public void setHrhsisyoriymd(BizDate pHrhsisyoriymd) {
        hrhsisyoriymd = pHrhsisyoriymd;
    }

    private BizCurrency henreikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHenreikingk() {
        return henreikingk;
    }

    public void setHenreikingk(BizCurrency pHenreikingk) {
        henreikingk = pHenreikingk;
        henreikingkValue = null;
        henreikingkType  = null;
    }

    transient private BigDecimal henreikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HENREIKINGK, nullable=true)
    protected BigDecimal getHenreikingkValue() {
        if (henreikingkValue == null && henreikingk != null) {
            if (henreikingk.isOptional()) return null;
            return henreikingk.absolute();
        }
        return henreikingkValue;
    }

    protected void setHenreikingkValue(BigDecimal value) {
        henreikingkValue = value;
        henreikingk = Optional.fromNullable(toCurrencyType(henreikingkType))
            .transform(bizCurrencyTransformer(getHenreikingkValue()))
            .orNull();
    }

    transient private String henreikingkType = null;

    @Column(name=HENREIKINGK + "$", nullable=true)
    protected String getHenreikingkType() {
        if (henreikingkType == null && henreikingk != null) return henreikingk.getType().toString();
        if (henreikingkType == null && getHenreikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'henreikingk$' should not be NULL."));
        }
        return henreikingkType;
    }

    protected void setHenreikingkType(String type) {
        henreikingkType = type;
        henreikingk = Optional.fromNullable(toCurrencyType(henreikingkType))
            .transform(bizCurrencyTransformer(getHenreikingkValue()))
            .orNull();
    }

    private C_Siharaijyoutaikbn hrsiharaijyoutaikbn;

    @Type(type="UserType_C_Siharaijyoutaikbn")
    @Column(name=GenIT_BAK_KhHenreikin.HRSIHARAIJYOUTAIKBN)
    public C_Siharaijyoutaikbn getHrsiharaijyoutaikbn() {
        return hrsiharaijyoutaikbn;
    }

    public void setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn pHrsiharaijyoutaikbn) {
        hrsiharaijyoutaikbn = pHrsiharaijyoutaikbn;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_BAK_KhHenreikin.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Segcd seg2cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenIT_BAK_KhHenreikin.SEG2CD)
    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_BAK_KhHenreikin.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhHenreikin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhHenreikin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhHenreikin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}