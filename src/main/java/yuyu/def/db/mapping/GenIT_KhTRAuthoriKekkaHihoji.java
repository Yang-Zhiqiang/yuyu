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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.id.PKIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.GenQIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.meta.QIT_KhTRAuthoriKekkaHihoji;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * オーソリ結果ＴＲ（クレカ非保持）テーブル テーブルのマッピング情報クラスで、 {@link IT_KhTRAuthoriKekkaHihoji} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTRAuthoriKekkaHihoji}</td><td colspan="3">オーソリ結果ＴＲ（クレカ非保持）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_KhTRAuthoriKekkaHihoji ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_KhTRAuthoriKekkaHihoji ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardbrandkbn cardbrandkbn}</td><td>カードブランド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CardBrandKbn}</td></tr>
 *  <tr><td>{@link #getCreditkaiinnosimo4keta creditkaiinnosimo4keta}</td><td>クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorijkkbn authorijkkbn}</td><td>オーソリ状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthorijkKbn}</td></tr>
 *  <tr><td>{@link #getDatajyusinymd datajyusinymd}</td><td>データ受信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTRAuthoriKekkaHihoji
 * @see     PKIT_KhTRAuthoriKekkaHihoji
 * @see     QIT_KhTRAuthoriKekkaHihoji
 * @see     GenQIT_KhTRAuthoriKekkaHihoji
 */
@MappedSuperclass
@Table(name=GenIT_KhTRAuthoriKekkaHihoji.TABLE_NAME)
@IdClass(value=PKIT_KhTRAuthoriKekkaHihoji.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AuthorijkKbn", typeClass=UserType_C_AuthorijkKbn.class),
    @TypeDef(name="UserType_C_CardBrandKbn", typeClass=UserType_C_CardBrandKbn.class)
})
public abstract class GenIT_KhTRAuthoriKekkaHihoji extends AbstractExDBEntity<IT_KhTRAuthoriKekkaHihoji, PKIT_KhTRAuthoriKekkaHihoji> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhTRAuthoriKekkaHihoji";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String CARDBRANDKBN             = "cardbrandkbn";
    public static final String CREDITKAIINNOSIMO4KETA   = "creditkaiinnosimo4keta";
    public static final String AUTHORIJKKBN             = "authorijkkbn";
    public static final String DATAJYUSINYMD            = "datajyusinymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhTRAuthoriKekkaHihoji primaryKey;

    public GenIT_KhTRAuthoriKekkaHihoji() {
        primaryKey = new PKIT_KhTRAuthoriKekkaHihoji();
    }

    public GenIT_KhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {
        primaryKey = new PKIT_KhTRAuthoriKekkaHihoji(pCreditkessaiyouno, pSyoriYmd);
    }

    @Transient
    @Override
    public PKIT_KhTRAuthoriKekkaHihoji getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhTRAuthoriKekkaHihoji> getMetaClass() {
        return QIT_KhTRAuthoriKekkaHihoji.class;
    }

    @Id
    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    private String syono;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_CardBrandKbn cardbrandkbn;

    @Type(type="UserType_C_CardBrandKbn")
    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.CARDBRANDKBN)
    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private String creditkaiinnosimo4keta;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.CREDITKAIINNOSIMO4KETA)
    public String getCreditkaiinnosimo4keta() {
        return creditkaiinnosimo4keta;
    }

    public void setCreditkaiinnosimo4keta(String pCreditkaiinnosimo4keta) {
        creditkaiinnosimo4keta = pCreditkaiinnosimo4keta;
    }

    private C_AuthorijkKbn authorijkkbn;

    @Type(type="UserType_C_AuthorijkKbn")
    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.AUTHORIJKKBN)
    public C_AuthorijkKbn getAuthorijkkbn() {
        return authorijkkbn;
    }

    public void setAuthorijkkbn(C_AuthorijkKbn pAuthorijkkbn) {
        authorijkkbn = pAuthorijkkbn;
    }

    private String datajyusinymd;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.DATAJYUSINYMD)
    public String getDatajyusinymd() {
        return datajyusinymd;
    }

    public void setDatajyusinymd(String pDatajyusinymd) {
        datajyusinymd = pDatajyusinymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhTRAuthoriKekkaHihoji.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}