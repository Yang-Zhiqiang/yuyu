package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.IT_CreditCard;
import yuyu.def.db.id.PKIT_CreditCard;
import yuyu.def.db.meta.GenQIT_CreditCard;
import yuyu.def.db.meta.QIT_CreditCard;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * クレジットカードテーブル テーブルのマッピング情報クラスで、 {@link IT_CreditCard} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_CreditCard}</td><td colspan="3">クレジットカードテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_CreditCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_CreditCard ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokno kokno}</td><td>顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardykkigen creditcardykkigen}</td><td>クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditmeiginmkn creditmeiginmkn}</td><td>クレジットカード名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_CreditCard
 * @see     PKIT_CreditCard
 * @see     QIT_CreditCard
 * @see     GenQIT_CreditCard
 */
@MappedSuperclass
@Table(name=GenIT_CreditCard.TABLE_NAME)
@IdClass(value=PKIT_CreditCard.class)
public abstract class GenIT_CreditCard extends AbstractExDBEntity<IT_CreditCard, PKIT_CreditCard> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_CreditCard";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String KOKNO                    = "kokno";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITCARDYKKIGEN        = "creditcardykkigen";
    public static final String CREDITMEIGINMKN          = "creditmeiginmkn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_CreditCard primaryKey;

    public GenIT_CreditCard() {
        primaryKey = new PKIT_CreditCard();
    }

    public GenIT_CreditCard(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_CreditCard(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_CreditCard getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_CreditCard> getMetaClass() {
        return QIT_CreditCard.class;
    }

    @Id
    @Column(name=GenIT_CreditCard.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_CreditCard.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String kokno;

    @Column(name=GenIT_CreditCard.KOKNO)
    public String getKokno() {
        return kokno;
    }

    public void setKokno(String pKokno) {
        kokno = pKokno;
    }

    private String cardkaisyacd;

    @Column(name=GenIT_CreditCard.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private String creditcardno1;

    @Column(name=GenIT_CreditCard.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_CreditCard.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_CreditCard.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_CreditCard.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String creditcardykkigen;

    @Column(name=GenIT_CreditCard.CREDITCARDYKKIGEN)
    public String getCreditcardykkigen() {
        return creditcardykkigen;
    }

    public void setCreditcardykkigen(String pCreditcardykkigen) {
        creditcardykkigen = pCreditcardykkigen;
    }

    private String creditmeiginmkn;

    @Column(name=GenIT_CreditCard.CREDITMEIGINMKN)
    public String getCreditmeiginmkn() {
        return creditmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCreditmeiginmkn(String pCreditmeiginmkn) {
        creditmeiginmkn = pCreditmeiginmkn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_CreditCard.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_CreditCard.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_CreditCard.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}