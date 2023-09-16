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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TkjysydksyhyKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.id.PKHT_DakuhiKettei;
import yuyu.def.db.meta.GenQHT_DakuhiKettei;
import yuyu.def.db.meta.QHT_DakuhiKettei;
import yuyu.def.db.type.UserType_C_DakuhiktbunruiKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_SntkinfosakuseiyhKbn;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;
import yuyu.def.db.type.UserType_C_TkjysydksyhyKbn;
import yuyu.def.db.type.UserType_C_TorikesisyousairiyuuCd;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 諾否決定テーブル テーブルのマッピング情報クラスで、 {@link HT_DakuhiKettei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_DakuhiKettei}</td><td colspan="3">諾否決定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_DakuhiKettei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDakuhiktrenno dakuhiktrenno}</td><td>諾否決定連番</td><td align="center">{@link PKHT_DakuhiKettei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKetymd ketymd}</td><td>決定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDakuhiktbunruikbn dakuhiktbunruikbn}</td><td>諾否決定分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DakuhiktbunruiKbn}</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd1 ketriyuucd1}</td><td>決定理由コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd2 ketriyuucd2}</td><td>決定理由コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd3 ketriyuucd3}</td><td>決定理由コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd4 ketriyuucd4}</td><td>決定理由コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getSyoubyoucd1 syoubyoucd1}</td><td>傷病コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoujyoutaikbn1 syoubyoujyoutaikbn1}</td><td>傷病状態区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKantiym1 kantiym1}</td><td>完治年月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoubyoucd2 syoubyoucd2}</td><td>傷病コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoujyoutaikbn2 syoubyoujyoutaikbn2}</td><td>傷病状態区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKantiym2 kantiym2}</td><td>完治年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkjysydkno tkjysydkno}</td><td>特条承諾番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkjysydkymd tkjysydkymd}</td><td>特条条件付承諾日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTkjysydksyhykbn tkjysydksyhykbn}</td><td>特条承諾書不要区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkjysydksyhyKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfosakuseiyhkbn sntkinfosakuseiyhkbn}</td><td>選択情報作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkinfosakuseiyhKbn}</td></tr>
 *  <tr><td>{@link #getMrriyuucdkbn mrriyuucdkbn}</td><td>ＭＲ理由コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MrRiyuucdKbn}</td></tr>
 *  <tr><td>{@link #getTorikesisyousairiyuucd torikesisyousairiyuucd}</td><td>取消詳細理由コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TorikesisyousairiyuuCd}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_DakuhiKettei
 * @see     PKHT_DakuhiKettei
 * @see     QHT_DakuhiKettei
 * @see     GenQHT_DakuhiKettei
 */
@MappedSuperclass
@Table(name=GenHT_DakuhiKettei.TABLE_NAME)
@IdClass(value=PKHT_DakuhiKettei.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_DakuhiktbunruiKbn", typeClass=UserType_C_DakuhiktbunruiKbn.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Ketriyuucd", typeClass=UserType_C_Ketriyuucd.class),
    @TypeDef(name="UserType_C_MrRiyuucdKbn", typeClass=UserType_C_MrRiyuucdKbn.class),
    @TypeDef(name="UserType_C_SntkinfosakuseiyhKbn", typeClass=UserType_C_SntkinfosakuseiyhKbn.class),
    @TypeDef(name="UserType_C_SyoubyoujyoutaiKbn", typeClass=UserType_C_SyoubyoujyoutaiKbn.class),
    @TypeDef(name="UserType_C_TkjysydksyhyKbn", typeClass=UserType_C_TkjysydksyhyKbn.class),
    @TypeDef(name="UserType_C_TorikesisyousairiyuuCd", typeClass=UserType_C_TorikesisyousairiyuuCd.class)
})
public abstract class GenHT_DakuhiKettei extends AbstractExDBEntity<HT_DakuhiKettei, PKHT_DakuhiKettei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_DakuhiKettei";
    public static final String MOSNO                    = "mosno";
    public static final String DAKUHIKTRENNO            = "dakuhiktrenno";
    public static final String KETYMD                   = "ketymd";
    public static final String DAKUHIKTBUNRUIKBN        = "dakuhiktbunruikbn";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String KETRIYUUCD1              = "ketriyuucd1";
    public static final String KETRIYUUCD2              = "ketriyuucd2";
    public static final String KETRIYUUCD3              = "ketriyuucd3";
    public static final String KETRIYUUCD4              = "ketriyuucd4";
    public static final String SYOUBYOUCD1              = "syoubyoucd1";
    public static final String SYOUBYOUJYOUTAIKBN1      = "syoubyoujyoutaikbn1";
    public static final String KANTIYM1                 = "kantiym1";
    public static final String SYOUBYOUCD2              = "syoubyoucd2";
    public static final String SYOUBYOUJYOUTAIKBN2      = "syoubyoujyoutaikbn2";
    public static final String KANTIYM2                 = "kantiym2";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String TKJYSYDKNO               = "tkjysydkno";
    public static final String TKJYSYDKYMD              = "tkjysydkymd";
    public static final String TKJYSYDKSYHYKBN          = "tkjysydksyhykbn";
    public static final String SNTKINFOSAKUSEIYHKBN     = "sntkinfosakuseiyhkbn";
    public static final String MRRIYUUCDKBN             = "mrriyuucdkbn";
    public static final String TORIKESISYOUSAIRIYUUCD   = "torikesisyousairiyuucd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_DakuhiKettei primaryKey;

    public GenHT_DakuhiKettei() {
        primaryKey = new PKHT_DakuhiKettei();
    }

    public GenHT_DakuhiKettei(String pMosno, Integer pDakuhiktrenno) {
        primaryKey = new PKHT_DakuhiKettei(pMosno, pDakuhiktrenno);
    }

    @Transient
    @Override
    public PKHT_DakuhiKettei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_DakuhiKettei> getMetaClass() {
        return QHT_DakuhiKettei.class;
    }

    @Id
    @Column(name=GenHT_DakuhiKettei.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_DakuhiKettei.DAKUHIKTRENNO)
    public Integer getDakuhiktrenno() {
        return getPrimaryKey().getDakuhiktrenno();
    }

    public void setDakuhiktrenno(Integer pDakuhiktrenno) {
        getPrimaryKey().setDakuhiktrenno(pDakuhiktrenno);
    }

    private BizDate ketymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_DakuhiKettei.KETYMD)
    @ValidDate
    public BizDate getKetymd() {
        return ketymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetymd(BizDate pKetymd) {
        ketymd = pKetymd;
    }

    private C_DakuhiktbunruiKbn dakuhiktbunruikbn;

    @Type(type="UserType_C_DakuhiktbunruiKbn")
    @Column(name=GenHT_DakuhiKettei.DAKUHIKTBUNRUIKBN)
    public C_DakuhiktbunruiKbn getDakuhiktbunruikbn() {
        return dakuhiktbunruikbn;
    }

    public void setDakuhiktbunruikbn(C_DakuhiktbunruiKbn pDakuhiktbunruikbn) {
        dakuhiktbunruikbn = pDakuhiktbunruikbn;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenHT_DakuhiKettei.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private C_Ketriyuucd ketriyuucd1;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_DakuhiKettei.KETRIYUUCD1)
    public C_Ketriyuucd getKetriyuucd1() {
        return ketriyuucd1;
    }

    public void setKetriyuucd1(C_Ketriyuucd pKetriyuucd1) {
        ketriyuucd1 = pKetriyuucd1;
    }

    private C_Ketriyuucd ketriyuucd2;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_DakuhiKettei.KETRIYUUCD2)
    public C_Ketriyuucd getKetriyuucd2() {
        return ketriyuucd2;
    }

    public void setKetriyuucd2(C_Ketriyuucd pKetriyuucd2) {
        ketriyuucd2 = pKetriyuucd2;
    }

    private C_Ketriyuucd ketriyuucd3;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_DakuhiKettei.KETRIYUUCD3)
    public C_Ketriyuucd getKetriyuucd3() {
        return ketriyuucd3;
    }

    public void setKetriyuucd3(C_Ketriyuucd pKetriyuucd3) {
        ketriyuucd3 = pKetriyuucd3;
    }

    private C_Ketriyuucd ketriyuucd4;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_DakuhiKettei.KETRIYUUCD4)
    public C_Ketriyuucd getKetriyuucd4() {
        return ketriyuucd4;
    }

    public void setKetriyuucd4(C_Ketriyuucd pKetriyuucd4) {
        ketriyuucd4 = pKetriyuucd4;
    }

    private String syoubyoucd1;

    @Column(name=GenHT_DakuhiKettei.SYOUBYOUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyoubyoucd1() {
        return syoubyoucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd1(String pSyoubyoucd1) {
        syoubyoucd1 = pSyoubyoucd1;
    }

    private C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn1;

    @Type(type="UserType_C_SyoubyoujyoutaiKbn")
    @Column(name=GenHT_DakuhiKettei.SYOUBYOUJYOUTAIKBN1)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn1() {
        return syoubyoujyoutaikbn1;
    }

    public void setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn1) {
        syoubyoujyoutaikbn1 = pSyoubyoujyoutaikbn1;
    }

    private BizDateYM kantiym1;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_DakuhiKettei.KANTIYM1)
    @ValidDateYm
    public BizDateYM getKantiym1() {
        return kantiym1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym1(BizDateYM pKantiym1) {
        kantiym1 = pKantiym1;
    }

    private String syoubyoucd2;

    @Column(name=GenHT_DakuhiKettei.SYOUBYOUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyoubyoucd2() {
        return syoubyoucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd2(String pSyoubyoucd2) {
        syoubyoucd2 = pSyoubyoucd2;
    }

    private C_SyoubyoujyoutaiKbn syoubyoujyoutaikbn2;

    @Type(type="UserType_C_SyoubyoujyoutaiKbn")
    @Column(name=GenHT_DakuhiKettei.SYOUBYOUJYOUTAIKBN2)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn2() {
        return syoubyoujyoutaikbn2;
    }

    public void setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn2) {
        syoubyoujyoutaikbn2 = pSyoubyoujyoutaikbn2;
    }

    private BizDateYM kantiym2;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_DakuhiKettei.KANTIYM2)
    @ValidDateYm
    public BizDateYM getKantiym2() {
        return kantiym2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym2(BizDateYM pKantiym2) {
        kantiym2 = pKantiym2;
    }

    private String ketsyacd;

    @Column(name=GenHT_DakuhiKettei.KETSYACD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getKetsyacd() {
        return ketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetsyacd(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

    private String palketsyacd;

    @Column(name=GenHT_DakuhiKettei.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private Integer tkjysydkno;

    @Column(name=GenHT_DakuhiKettei.TKJYSYDKNO)
    public Integer getTkjysydkno() {
        return tkjysydkno;
    }

    public void setTkjysydkno(Integer pTkjysydkno) {
        tkjysydkno = pTkjysydkno;
    }

    private BizDate tkjysydkymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_DakuhiKettei.TKJYSYDKYMD)
    public BizDate getTkjysydkymd() {
        return tkjysydkymd;
    }

    public void setTkjysydkymd(BizDate pTkjysydkymd) {
        tkjysydkymd = pTkjysydkymd;
    }

    private C_TkjysydksyhyKbn tkjysydksyhykbn;

    @Type(type="UserType_C_TkjysydksyhyKbn")
    @Column(name=GenHT_DakuhiKettei.TKJYSYDKSYHYKBN)
    public C_TkjysydksyhyKbn getTkjysydksyhykbn() {
        return tkjysydksyhykbn;
    }

    public void setTkjysydksyhykbn(C_TkjysydksyhyKbn pTkjysydksyhykbn) {
        tkjysydksyhykbn = pTkjysydksyhykbn;
    }

    private C_SntkinfosakuseiyhKbn sntkinfosakuseiyhkbn;

    @Type(type="UserType_C_SntkinfosakuseiyhKbn")
    @Column(name=GenHT_DakuhiKettei.SNTKINFOSAKUSEIYHKBN)
    public C_SntkinfosakuseiyhKbn getSntkinfosakuseiyhkbn() {
        return sntkinfosakuseiyhkbn;
    }

    public void setSntkinfosakuseiyhkbn(C_SntkinfosakuseiyhKbn pSntkinfosakuseiyhkbn) {
        sntkinfosakuseiyhkbn = pSntkinfosakuseiyhkbn;
    }

    private C_MrRiyuucdKbn mrriyuucdkbn;

    @Type(type="UserType_C_MrRiyuucdKbn")
    @Column(name=GenHT_DakuhiKettei.MRRIYUUCDKBN)
    public C_MrRiyuucdKbn getMrriyuucdkbn() {
        return mrriyuucdkbn;
    }

    public void setMrriyuucdkbn(C_MrRiyuucdKbn pMrriyuucdkbn) {
        mrriyuucdkbn = pMrriyuucdkbn;
    }

    private C_TorikesisyousairiyuuCd torikesisyousairiyuucd;

    @Type(type="UserType_C_TorikesisyousairiyuuCd")
    @Column(name=GenHT_DakuhiKettei.TORIKESISYOUSAIRIYUUCD)
    public C_TorikesisyousairiyuuCd getTorikesisyousairiyuucd() {
        return torikesisyousairiyuucd;
    }

    public void setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd pTorikesisyousairiyuucd) {
        torikesisyousairiyuucd = pTorikesisyousairiyuucd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_DakuhiKettei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_DakuhiKettei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}