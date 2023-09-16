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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_ChkYukokekkaData;
import yuyu.def.db.id.PKIT_ChkYukokekkaData;
import yuyu.def.db.meta.GenQIT_ChkYukokekkaData;
import yuyu.def.db.meta.QIT_ChkYukokekkaData;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効性確認結果データテーブル テーブルのマッピング情報クラスで、 {@link IT_ChkYukokekkaData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ChkYukokekkaData}</td><td colspan="3">有効性確認結果データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKIT_ChkYukokekkaData ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getYuukoukekkarenno yuukoukekkarenno}</td><td>有効性確認結果データ連番</td><td align="center">{@link PKIT_ChkYukokekkaData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInputyuukoukigen inputyuukoukigen}</td><td>入力有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukoutaisyouym yuukoutaisyouym}</td><td>有効性確認対象年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCardnokosumu cardnokosumu}</td><td>カード番号更新有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCardykkigenkosumu cardykkigenkosumu}</td><td>カード有効期限更新有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNewcreditcardno1 newcreditcardno1}</td><td>（変更後）クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewcreditcardno2 newcreditcardno2}</td><td>（変更後）クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewcreditcardno3 newcreditcardno3}</td><td>（変更後）クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewcreditcardno4 newcreditcardno4}</td><td>（変更後）クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewcreditcardykkigen newcreditcardykkigen}</td><td>（変更後）クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukouhanteikekka yuukouhanteikekka}</td><td>有効性判定結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getErrorflg errorflg}</td><td>エラーフラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditbrerrorcd creditbrerrorcd}</td><td>クレジット払エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Creditbrerrorcd}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ChkYukokekkaData
 * @see     PKIT_ChkYukokekkaData
 * @see     QIT_ChkYukokekkaData
 * @see     GenQIT_ChkYukokekkaData
 */
@MappedSuperclass
@Table(name=GenIT_ChkYukokekkaData.TABLE_NAME)
@IdClass(value=PKIT_ChkYukokekkaData.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_Creditbrerrorcd", typeClass=UserType_C_Creditbrerrorcd.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_ChkYukokekkaData extends AbstractExDBEntity<IT_ChkYukokekkaData, PKIT_ChkYukokekkaData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ChkYukokekkaData";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String YUUKOUKEKKARENNO         = "yuukoukekkarenno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String INPUTYUUKOUKIGEN         = "inputyuukoukigen";
    public static final String YUUKOUTAISYOUYM          = "yuukoutaisyouym";
    public static final String CARDNOKOSUMU             = "cardnokosumu";
    public static final String CARDYKKIGENKOSUMU        = "cardykkigenkosumu";
    public static final String NEWCREDITCARDNO1         = "newcreditcardno1";
    public static final String NEWCREDITCARDNO2         = "newcreditcardno2";
    public static final String NEWCREDITCARDNO3         = "newcreditcardno3";
    public static final String NEWCREDITCARDNO4         = "newcreditcardno4";
    public static final String NEWCREDITCARDYKKIGEN     = "newcreditcardykkigen";
    public static final String YUUKOUHANTEIKEKKA        = "yuukouhanteikekka";
    public static final String ERRORFLG                 = "errorflg";
    public static final String CREDITBRERRORCD          = "creditbrerrorcd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_ChkYukokekkaData primaryKey;

    public GenIT_ChkYukokekkaData() {
        primaryKey = new PKIT_ChkYukokekkaData();
    }

    public GenIT_ChkYukokekkaData(C_AnsyuusysKbn pAnsyuusyskbn, String pYuukoukekkarenno) {
        primaryKey = new PKIT_ChkYukokekkaData(pAnsyuusyskbn, pYuukoukekkarenno);
    }

    @Transient
    @Override
    public PKIT_ChkYukokekkaData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ChkYukokekkaData> getMetaClass() {
        return QIT_ChkYukokekkaData.class;
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenIT_ChkYukokekkaData.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Column(name=GenIT_ChkYukokekkaData.YUUKOUKEKKARENNO)
    public String getYuukoukekkarenno() {
        return getPrimaryKey().getYuukoukekkarenno();
    }

    public void setYuukoukekkarenno(String pYuukoukekkarenno) {
        getPrimaryKey().setYuukoukekkarenno(pYuukoukekkarenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_ChkYukokekkaData.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syono;

    @Column(name=GenIT_ChkYukokekkaData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String creditcardno1;

    @Column(name=GenIT_ChkYukokekkaData.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_ChkYukokekkaData.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_ChkYukokekkaData.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_ChkYukokekkaData.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String inputyuukoukigen;

    @Column(name=GenIT_ChkYukokekkaData.INPUTYUUKOUKIGEN)
    public String getInputyuukoukigen() {
        return inputyuukoukigen;
    }

    public void setInputyuukoukigen(String pInputyuukoukigen) {
        inputyuukoukigen = pInputyuukoukigen;
    }

    private BizDateYM yuukoutaisyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ChkYukokekkaData.YUUKOUTAISYOUYM)
    public BizDateYM getYuukoutaisyouym() {
        return yuukoutaisyouym;
    }

    public void setYuukoutaisyouym(BizDateYM pYuukoutaisyouym) {
        yuukoutaisyouym = pYuukoutaisyouym;
    }

    private C_UmuKbn cardnokosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_ChkYukokekkaData.CARDNOKOSUMU)
    public C_UmuKbn getCardnokosumu() {
        return cardnokosumu;
    }

    public void setCardnokosumu(C_UmuKbn pCardnokosumu) {
        cardnokosumu = pCardnokosumu;
    }

    private C_UmuKbn cardykkigenkosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_ChkYukokekkaData.CARDYKKIGENKOSUMU)
    public C_UmuKbn getCardykkigenkosumu() {
        return cardykkigenkosumu;
    }

    public void setCardykkigenkosumu(C_UmuKbn pCardykkigenkosumu) {
        cardykkigenkosumu = pCardykkigenkosumu;
    }

    private String newcreditcardno1;

    @Column(name=GenIT_ChkYukokekkaData.NEWCREDITCARDNO1)
    public String getNewcreditcardno1() {
        return newcreditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewcreditcardno1(String pNewcreditcardno1) {
        newcreditcardno1 = pNewcreditcardno1;
    }

    private String newcreditcardno2;

    @Column(name=GenIT_ChkYukokekkaData.NEWCREDITCARDNO2)
    public String getNewcreditcardno2() {
        return newcreditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewcreditcardno2(String pNewcreditcardno2) {
        newcreditcardno2 = pNewcreditcardno2;
    }

    private String newcreditcardno3;

    @Column(name=GenIT_ChkYukokekkaData.NEWCREDITCARDNO3)
    public String getNewcreditcardno3() {
        return newcreditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewcreditcardno3(String pNewcreditcardno3) {
        newcreditcardno3 = pNewcreditcardno3;
    }

    private String newcreditcardno4;

    @Column(name=GenIT_ChkYukokekkaData.NEWCREDITCARDNO4)
    public String getNewcreditcardno4() {
        return newcreditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewcreditcardno4(String pNewcreditcardno4) {
        newcreditcardno4 = pNewcreditcardno4;
    }

    private String newcreditcardykkigen;

    @Column(name=GenIT_ChkYukokekkaData.NEWCREDITCARDYKKIGEN)
    public String getNewcreditcardykkigen() {
        return newcreditcardykkigen;
    }

    public void setNewcreditcardykkigen(String pNewcreditcardykkigen) {
        newcreditcardykkigen = pNewcreditcardykkigen;
    }

    private String yuukouhanteikekka;

    @Column(name=GenIT_ChkYukokekkaData.YUUKOUHANTEIKEKKA)
    public String getYuukouhanteikekka() {
        return yuukouhanteikekka;
    }

    public void setYuukouhanteikekka(String pYuukouhanteikekka) {
        yuukouhanteikekka = pYuukouhanteikekka;
    }

    private String errorflg;

    @Column(name=GenIT_ChkYukokekkaData.ERRORFLG)
    public String getErrorflg() {
        return errorflg;
    }

    public void setErrorflg(String pErrorflg) {
        errorflg = pErrorflg;
    }

    private C_Creditbrerrorcd creditbrerrorcd;

    @Type(type="UserType_C_Creditbrerrorcd")
    @Column(name=GenIT_ChkYukokekkaData.CREDITBRERRORCD)
    public C_Creditbrerrorcd getCreditbrerrorcd() {
        return creditbrerrorcd;
    }

    public void setCreditbrerrorcd(C_Creditbrerrorcd pCreditbrerrorcd) {
        creditbrerrorcd = pCreditbrerrorcd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_ChkYukokekkaData.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_ChkYukokekkaData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_ChkYukokekkaData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}