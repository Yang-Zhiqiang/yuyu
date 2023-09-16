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
import yuyu.def.classification.C_GaibuRenkeiKakuJkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_ChkYuukousei;
import yuyu.def.db.id.PKIT_ChkYuukousei;
import yuyu.def.db.meta.GenQIT_ChkYuukousei;
import yuyu.def.db.meta.QIT_ChkYuukousei;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_GaibuRenkeiKakuJkKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効性確認データテーブル テーブルのマッピング情報クラスで、 {@link IT_ChkYuukousei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ChkYuukousei}</td><td colspan="3">有効性確認データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_ChkYuukousei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnsyuusyskbn ansyuusyskbn}</td><td>案内収納用システム区分</td><td align="center">{@link PKIT_ChkYuukousei ○}</td><td align="center">V</td><td>{@link C_AnsyuusysKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_ChkYuukousei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_ChkYuukousei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardykkigen creditcardykkigen}</td><td>クレジットカード有効期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYuukoutaisyouym yuukoutaisyouym}</td><td>有効性確認対象年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokensyuruikigousdicode hokensyuruikigousdicode}</td><td>保険種類記号世代コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk1 hknsyukigoukktkmk1}</td><td>保険種類記号拡張項目１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk2 hknsyukigoukktkmk2}</td><td>保険種類記号拡張項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyukigoukktkmk3 hknsyukigoukktkmk3}</td><td>保険種類記号拡張項目３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getKameitenno kameitenno}</td><td>加盟店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKameitennm kameitennm}</td><td>加盟店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaiburenkeikakujkkbn gaiburenkeikakujkkbn}</td><td>外部連携確認状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GaibuRenkeiKakuJkKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ChkYuukousei
 * @see     PKIT_ChkYuukousei
 * @see     QIT_ChkYuukousei
 * @see     GenQIT_ChkYuukousei
 */
@MappedSuperclass
@Table(name=GenIT_ChkYuukousei.TABLE_NAME)
@IdClass(value=PKIT_ChkYuukousei.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AnsyuusysKbn", typeClass=UserType_C_AnsyuusysKbn.class),
    @TypeDef(name="UserType_C_GaibuRenkeiKakuJkKbn", typeClass=UserType_C_GaibuRenkeiKakuJkKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class)
})
public abstract class GenIT_ChkYuukousei extends AbstractExDBEntity<IT_ChkYuukousei, PKIT_ChkYuukousei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_ChkYuukousei";
    public static final String KBNKEY                   = "kbnkey";
    public static final String ANSYUUSYSKBN             = "ansyuusyskbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITCARDYKKIGEN        = "creditcardykkigen";
    public static final String YUUKOUTAISYOUYM          = "yuukoutaisyouym";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HOKENSYURUIKIGOUSDICODE  = "hokensyuruikigousdicode";
    public static final String HKNSYUKIGOUKKTKMK1       = "hknsyukigoukktkmk1";
    public static final String HKNSYUKIGOUKKTKMK2       = "hknsyukigoukktkmk2";
    public static final String HKNSYUKIGOUKKTKMK3       = "hknsyukigoukktkmk3";
    public static final String KAMEITENNO               = "kameitenno";
    public static final String KAMEITENNM               = "kameitennm";
    public static final String GAIBURENKEIKAKUJKKBN     = "gaiburenkeikakujkkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_ChkYuukousei primaryKey;

    public GenIT_ChkYuukousei() {
        primaryKey = new PKIT_ChkYuukousei();
    }

    public GenIT_ChkYuukousei(
        String pKbnkey,
        C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriYmd,
        String pSyono
    ) {
        primaryKey = new PKIT_ChkYuukousei(
            pKbnkey,
            pAnsyuusyskbn,
            pSyoriYmd,
            pSyono
        );
    }

    @Transient
    @Override
    public PKIT_ChkYuukousei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_ChkYuukousei> getMetaClass() {
        return QIT_ChkYuukousei.class;
    }

    @Id
    @Column(name=GenIT_ChkYuukousei.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Type(type="UserType_C_AnsyuusysKbn")
    @Column(name=GenIT_ChkYuukousei.ANSYUUSYSKBN)
    public C_AnsyuusysKbn getAnsyuusyskbn() {
        return getPrimaryKey().getAnsyuusyskbn();
    }

    public void setAnsyuusyskbn(C_AnsyuusysKbn pAnsyuusyskbn) {
        getPrimaryKey().setAnsyuusyskbn(pAnsyuusyskbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_ChkYuukousei.SYORIYMD)
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
    @Column(name=GenIT_ChkYuukousei.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String creditcardno1;

    @Column(name=GenIT_ChkYuukousei.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_ChkYuukousei.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_ChkYuukousei.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_ChkYuukousei.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String creditcardykkigen;

    @Column(name=GenIT_ChkYuukousei.CREDITCARDYKKIGEN)
    public String getCreditcardykkigen() {
        return creditcardykkigen;
    }

    public void setCreditcardykkigen(String pCreditcardykkigen) {
        creditcardykkigen = pCreditcardykkigen;
    }

    private BizDateYM yuukoutaisyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_ChkYuukousei.YUUKOUTAISYOUYM)
    public BizDateYM getYuukoutaisyouym() {
        return yuukoutaisyouym;
    }

    public void setYuukoutaisyouym(BizDateYM pYuukoutaisyouym) {
        yuukoutaisyouym = pYuukoutaisyouym;
    }

    private String cardkaisyacd;

    @Column(name=GenIT_ChkYuukousei.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_ChkYuukousei.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String hknsyukigou;

    @Column(name=GenIT_ChkYuukousei.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String hokensyuruikigousdicode;

    @Column(name=GenIT_ChkYuukousei.HOKENSYURUIKIGOUSDICODE)
    public String getHokensyuruikigousdicode() {
        return hokensyuruikigousdicode;
    }

    @DataConvert("toSingleByte")
    public void setHokensyuruikigousdicode(String pHokensyuruikigousdicode) {
        hokensyuruikigousdicode = pHokensyuruikigousdicode;
    }

    private Long hknsyukigoukktkmk1;

    @Column(name=GenIT_ChkYuukousei.HKNSYUKIGOUKKTKMK1)
    public Long getHknsyukigoukktkmk1() {
        return hknsyukigoukktkmk1;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk1(Long pHknsyukigoukktkmk1) {
        hknsyukigoukktkmk1 = pHknsyukigoukktkmk1;
    }

    private String hknsyukigoukktkmk2;

    @Column(name=GenIT_ChkYuukousei.HKNSYUKIGOUKKTKMK2)
    public String getHknsyukigoukktkmk2() {
        return hknsyukigoukktkmk2;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk2(String pHknsyukigoukktkmk2) {
        hknsyukigoukktkmk2 = pHknsyukigoukktkmk2;
    }

    private Long hknsyukigoukktkmk3;

    @Column(name=GenIT_ChkYuukousei.HKNSYUKIGOUKKTKMK3)
    public Long getHknsyukigoukktkmk3() {
        return hknsyukigoukktkmk3;
    }

    @DataConvert("toSingleByte")
    public void setHknsyukigoukktkmk3(Long pHknsyukigoukktkmk3) {
        hknsyukigoukktkmk3 = pHknsyukigoukktkmk3;
    }

    private String kameitenno;

    @Column(name=GenIT_ChkYuukousei.KAMEITENNO)
    public String getKameitenno() {
        return kameitenno;
    }

    @DataConvert("toSingleByte")
    public void setKameitenno(String pKameitenno) {
        kameitenno = pKameitenno;
    }

    private String kameitennm;

    @Column(name=GenIT_ChkYuukousei.KAMEITENNM)
    public String getKameitennm() {
        return kameitennm;
    }

    @DataConvert("toSingleByte")
    public void setKameitennm(String pKameitennm) {
        kameitennm = pKameitennm;
    }

    private C_GaibuRenkeiKakuJkKbn gaiburenkeikakujkkbn;

    @Type(type="UserType_C_GaibuRenkeiKakuJkKbn")
    @Column(name=GenIT_ChkYuukousei.GAIBURENKEIKAKUJKKBN)
    public C_GaibuRenkeiKakuJkKbn getGaiburenkeikakujkkbn() {
        return gaiburenkeikakujkkbn;
    }

    @DataConvert("toSingleByte")
    public void setGaiburenkeikakujkkbn(C_GaibuRenkeiKakuJkKbn pGaiburenkeikakujkkbn) {
        gaiburenkeikakujkkbn = pGaiburenkeikakujkkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_ChkYuukousei.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_ChkYuukousei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_ChkYuukousei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}