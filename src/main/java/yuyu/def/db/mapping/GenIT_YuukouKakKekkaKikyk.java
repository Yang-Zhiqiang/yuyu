package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;
import yuyu.def.db.id.PKIT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.GenQIT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaKikyk;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;

/**
 * 有効性確認結果（既契約）テーブル テーブルのマッピング情報クラスで、 {@link IT_YuukouKakKekkaKikyk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouKakKekkaKikyk}</td><td colspan="3">有効性確認結果（既契約）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_YuukouKakKekkaKikyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno creditcardno}</td><td>クレジットカード番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardyuukoukigen4keta cardyuukoukigen4keta}</td><td>クレジットカード有効期限（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredityuukoukakym credityuukoukakym}</td><td>クレジットカード有効確認年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCredityuukoukakkekka credityuukoukakkekka}</td><td>クレジットカード有効確認結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Yuukoukakkekka}</td></tr>
 *  <tr><td>{@link #getCreditkigyoucd creditkigyoucd}</td><td>クレジットカード企業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouKakKekkaKikyk
 * @see     PKIT_YuukouKakKekkaKikyk
 * @see     QIT_YuukouKakKekkaKikyk
 * @see     GenQIT_YuukouKakKekkaKikyk
 */
@MappedSuperclass
@Table(name=GenIT_YuukouKakKekkaKikyk.TABLE_NAME)
@IdClass(value=PKIT_YuukouKakKekkaKikyk.class)
@TypeDefs({
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Yuukoukakkekka", typeClass=UserType_C_Yuukoukakkekka.class)
})
public abstract class GenIT_YuukouKakKekkaKikyk extends AbstractExDBEntity<IT_YuukouKakKekkaKikyk, PKIT_YuukouKakKekkaKikyk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_YuukouKakKekkaKikyk";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITCARDNO             = "creditcardno";
    public static final String CARDYUUKOUKIGEN4KETA     = "cardyuukoukigen4keta";
    public static final String CREDITYUUKOUKAKYM        = "credityuukoukakym";
    public static final String CREDITYUUKOUKAKKEKKA     = "credityuukoukakkekka";
    public static final String CREDITKIGYOUCD           = "creditkigyoucd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_YuukouKakKekkaKikyk primaryKey;

    public GenIT_YuukouKakKekkaKikyk() {
        primaryKey = new PKIT_YuukouKakKekkaKikyk();
    }

    public GenIT_YuukouKakKekkaKikyk(String pCreditkessaiyouno) {
        primaryKey = new PKIT_YuukouKakKekkaKikyk(pCreditkessaiyouno);
    }

    @Transient
    @Override
    public PKIT_YuukouKakKekkaKikyk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_YuukouKakKekkaKikyk> getMetaClass() {
        return QIT_YuukouKakKekkaKikyk.class;
    }

    @Id
    @Column(name=GenIT_YuukouKakKekkaKikyk.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    private String creditcardno;

    @Column(name=GenIT_YuukouKakKekkaKikyk.CREDITCARDNO)
    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String pCreditcardno) {
        creditcardno = pCreditcardno;
    }

    private String cardyuukoukigen4keta;

    @Column(name=GenIT_YuukouKakKekkaKikyk.CARDYUUKOUKIGEN4KETA)
    public String getCardyuukoukigen4keta() {
        return cardyuukoukigen4keta;
    }

    public void setCardyuukoukigen4keta(String pCardyuukoukigen4keta) {
        cardyuukoukigen4keta = pCardyuukoukigen4keta;
    }

    private BizDateYM credityuukoukakym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_YuukouKakKekkaKikyk.CREDITYUUKOUKAKYM)
    public BizDateYM getCredityuukoukakym() {
        return credityuukoukakym;
    }

    public void setCredityuukoukakym(BizDateYM pCredityuukoukakym) {
        credityuukoukakym = pCredityuukoukakym;
    }

    private C_Yuukoukakkekka credityuukoukakkekka;

    @Type(type="UserType_C_Yuukoukakkekka")
    @Column(name=GenIT_YuukouKakKekkaKikyk.CREDITYUUKOUKAKKEKKA)
    public C_Yuukoukakkekka getCredityuukoukakkekka() {
        return credityuukoukakkekka;
    }

    public void setCredityuukoukakkekka(C_Yuukoukakkekka pCredityuukoukakkekka) {
        credityuukoukakkekka = pCredityuukoukakkekka;
    }

    private String creditkigyoucd;

    @Column(name=GenIT_YuukouKakKekkaKikyk.CREDITKIGYOUCD)
    public String getCreditkigyoucd() {
        return creditkigyoucd;
    }

    public void setCreditkigyoucd(String pCreditkigyoucd) {
        creditkigyoucd = pCreditkigyoucd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_YuukouKakKekkaKikyk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_YuukouKakKekkaKikyk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_YuukouKakKekkaKikyk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}