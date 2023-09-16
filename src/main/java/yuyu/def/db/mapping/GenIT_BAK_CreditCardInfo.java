package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_BAK_CreditCardInfo;
import yuyu.def.db.id.PKIT_BAK_CreditCardInfo;
import yuyu.def.db.meta.GenQIT_BAK_CreditCardInfo;
import yuyu.def.db.meta.QIT_BAK_CreditCardInfo;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * クレカ情報バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_CreditCardInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_CreditCardInfo}</td><td colspan="3">クレカ情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_CreditCardInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_CreditCardInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_CreditCardInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredityuukoukakym credityuukoukakym}</td><td>クレジットカード有効確認年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCredityuukoukakkekka credityuukoukakkekka}</td><td>クレジットカード有効確認結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Yuukoukakkekka}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_CreditCardInfo
 * @see     PKIT_BAK_CreditCardInfo
 * @see     QIT_BAK_CreditCardInfo
 * @see     GenQIT_BAK_CreditCardInfo
 */
@MappedSuperclass
@Table(name=GenIT_BAK_CreditCardInfo.TABLE_NAME)
@IdClass(value=PKIT_BAK_CreditCardInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Yuukoukakkekka", typeClass=UserType_C_Yuukoukakkekka.class)
})
public abstract class GenIT_BAK_CreditCardInfo extends AbstractExDBEntity<IT_BAK_CreditCardInfo, PKIT_BAK_CreditCardInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_CreditCardInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITYUUKOUKAKYM        = "credityuukoukakym";
    public static final String CREDITYUUKOUKAKKEKKA     = "credityuukoukakkekka";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_CreditCardInfo primaryKey;

    public GenIT_BAK_CreditCardInfo() {
        primaryKey = new PKIT_BAK_CreditCardInfo();
    }

    public GenIT_BAK_CreditCardInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKIT_BAK_CreditCardInfo(
            pKbnkey,
            pSyono,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_CreditCardInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_CreditCardInfo> getMetaClass() {
        return QIT_BAK_CreditCardInfo.class;
    }

    @Id
    @Column(name=GenIT_BAK_CreditCardInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_CreditCardInfo.SYONO)
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
    @Column(name=GenIT_BAK_CreditCardInfo.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_BAK_CreditCardInfo.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private BizDateYM credityuukoukakym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_CreditCardInfo.CREDITYUUKOUKAKYM)
    public BizDateYM getCredityuukoukakym() {
        return credityuukoukakym;
    }

    public void setCredityuukoukakym(BizDateYM pCredityuukoukakym) {
        credityuukoukakym = pCredityuukoukakym;
    }

    private C_Yuukoukakkekka credityuukoukakkekka;

    @Type(type="UserType_C_Yuukoukakkekka")
    @Column(name=GenIT_BAK_CreditCardInfo.CREDITYUUKOUKAKKEKKA)
    public C_Yuukoukakkekka getCredityuukoukakkekka() {
        return credityuukoukakkekka;
    }

    public void setCredityuukoukakkekka(C_Yuukoukakkekka pCredityuukoukakkekka) {
        credityuukoukakkekka = pCredityuukoukakkekka;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_CreditCardInfo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_CreditCardInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_CreditCardInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}