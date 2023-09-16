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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.id.PKIT_DattaiUktk;
import yuyu.def.db.meta.GenQIT_DattaiUktk;
import yuyu.def.db.meta.QIT_DattaiUktk;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_CreditdataKbn;
import yuyu.def.db.type.UserType_C_Dattaikeiro;
import yuyu.def.db.type.UserType_C_DattairiyuuKbn;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 脱退受付テーブル テーブルのマッピング情報クラスで、 {@link IT_DattaiUktk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DattaiUktk}</td><td colspan="3">脱退受付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DattaiUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DattaiUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDattaikeiro dattaikeiro}</td><td>脱退経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Dattaikeiro}</td></tr>
 *  <tr><td>{@link #getDattairiyuukbn dattairiyuukbn}</td><td>脱退理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DattairiyuuKbn}</td></tr>
 *  <tr><td>{@link #getDattaiym dattaiym}</td><td>脱退年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCreditdatakbn creditdatakbn}</td><td>クレジットデータ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditdataKbn}</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditbrerrorcd creditbrerrorcd}</td><td>クレジット払エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Creditbrerrorcd}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getComment124keta comment124keta}</td><td>コメント（１２４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DattaiUktk
 * @see     PKIT_DattaiUktk
 * @see     QIT_DattaiUktk
 * @see     GenQIT_DattaiUktk
 */
@MappedSuperclass
@Table(name=GenIT_DattaiUktk.TABLE_NAME)
@IdClass(value=PKIT_DattaiUktk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Creditbrerrorcd", typeClass=UserType_C_Creditbrerrorcd.class),
    @TypeDef(name="UserType_C_CreditdataKbn", typeClass=UserType_C_CreditdataKbn.class),
    @TypeDef(name="UserType_C_Dattaikeiro", typeClass=UserType_C_Dattaikeiro.class),
    @TypeDef(name="UserType_C_DattairiyuuKbn", typeClass=UserType_C_DattairiyuuKbn.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_DattaiUktk extends AbstractExDBEntity<IT_DattaiUktk, PKIT_DattaiUktk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DattaiUktk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String DATTAIKEIRO              = "dattaikeiro";
    public static final String DATTAIRIYUUKBN           = "dattairiyuukbn";
    public static final String DATTAIYM                 = "dattaiym";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String CREDITDATAKBN            = "creditdatakbn";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITBRERRORCD          = "creditbrerrorcd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String COMMENT124KETA           = "comment124keta";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";

    private final PKIT_DattaiUktk primaryKey;

    public GenIT_DattaiUktk() {
        primaryKey = new PKIT_DattaiUktk();
    }

    public GenIT_DattaiUktk(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_DattaiUktk(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_DattaiUktk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DattaiUktk> getMetaClass() {
        return QIT_DattaiUktk.class;
    }

    @Id
    @Column(name=GenIT_DattaiUktk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_DattaiUktk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DattaiUktk.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syorisosikicd;

    @Column(name=GenIT_DattaiUktk.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_Dattaikeiro dattaikeiro;

    @Type(type="UserType_C_Dattaikeiro")
    @Column(name=GenIT_DattaiUktk.DATTAIKEIRO)
    public C_Dattaikeiro getDattaikeiro() {
        return dattaikeiro;
    }

    public void setDattaikeiro(C_Dattaikeiro pDattaikeiro) {
        dattaikeiro = pDattaikeiro;
    }

    private C_DattairiyuuKbn dattairiyuukbn;

    @Type(type="UserType_C_DattairiyuuKbn")
    @Column(name=GenIT_DattaiUktk.DATTAIRIYUUKBN)
    public C_DattairiyuuKbn getDattairiyuukbn() {
        return dattairiyuukbn;
    }

    public void setDattairiyuukbn(C_DattairiyuuKbn pDattairiyuukbn) {
        dattairiyuukbn = pDattairiyuukbn;
    }

    private BizDateYM dattaiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DattaiUktk.DATTAIYM)
    public BizDateYM getDattaiym() {
        return dattaiym;
    }

    public void setDattaiym(BizDateYM pDattaiym) {
        dattaiym = pDattaiym;
    }

    private String bankcd;

    @Column(name=GenIT_DattaiUktk.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_DattaiUktk.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_DattaiUktk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_DattaiUktk.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_DattaiUktk.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DattaiUktk.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    private C_CreditdataKbn creditdatakbn;

    @Type(type="UserType_C_CreditdataKbn")
    @Column(name=GenIT_DattaiUktk.CREDITDATAKBN)
    public C_CreditdataKbn getCreditdatakbn() {
        return creditdatakbn;
    }

    public void setCreditdatakbn(C_CreditdataKbn pCreditdatakbn) {
        creditdatakbn = pCreditdatakbn;
    }

    private String creditcardno1;

    @Column(name=GenIT_DattaiUktk.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_DattaiUktk.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_DattaiUktk.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_DattaiUktk.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private C_Creditbrerrorcd creditbrerrorcd;

    @Type(type="UserType_C_Creditbrerrorcd")
    @Column(name=GenIT_DattaiUktk.CREDITBRERRORCD)
    public C_Creditbrerrorcd getCreditbrerrorcd() {
        return creditbrerrorcd;
    }

    public void setCreditbrerrorcd(C_Creditbrerrorcd pCreditbrerrorcd) {
        creditbrerrorcd = pCreditbrerrorcd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_DattaiUktk.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private String comment124keta;

    @Column(name=GenIT_DattaiUktk.COMMENT124KETA)
    public String getComment124keta() {
        return comment124keta;
    }

    @Trim("right")
    public void setComment124keta(String pComment124keta) {
        comment124keta = pComment124keta;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DattaiUktk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DattaiUktk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DattaiUktk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_DattaiUktk.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}