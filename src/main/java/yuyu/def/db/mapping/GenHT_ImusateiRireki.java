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
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.id.PKHT_ImusateiRireki;
import yuyu.def.db.meta.GenQHT_ImusateiRireki;
import yuyu.def.db.meta.QHT_ImusateiRireki;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SntkinfosakuseiyhKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 医務査定履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_ImusateiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_ImusateiRireki}</td><td colspan="3">医務査定履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_ImusateiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_ImusateiRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSateiketsyorinmkbn sateiketsyorinmkbn}</td><td>査定・決定処理名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SateiketsyorinmKbn}</td></tr>
 *  <tr><td>{@link #getImusateikekkakbn imusateikekkakbn}</td><td>医務査定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getTnsketsyacd tnsketsyacd}</td><td>転送先決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getImusateicomment imusateicomment}</td><td>医務査定コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getSntkinfosakuseiyhkbn sntkinfosakuseiyhkbn}</td><td>選択情報作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkinfosakuseiyhKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_ImusateiRireki
 * @see     PKHT_ImusateiRireki
 * @see     QHT_ImusateiRireki
 * @see     GenQHT_ImusateiRireki
 */
@MappedSuperclass
@Table(name=GenHT_ImusateiRireki.TABLE_NAME)
@IdClass(value=PKHT_ImusateiRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Ketriyuucd", typeClass=UserType_C_Ketriyuucd.class),
    @TypeDef(name="UserType_C_SateiketsyorinmKbn", typeClass=UserType_C_SateiketsyorinmKbn.class),
    @TypeDef(name="UserType_C_SntkinfosakuseiyhKbn", typeClass=UserType_C_SntkinfosakuseiyhKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_SyoubyoujyoutaiKbn", typeClass=UserType_C_SyoubyoujyoutaiKbn.class)
})
public abstract class GenHT_ImusateiRireki extends AbstractExDBEntity<HT_ImusateiRireki, PKHT_ImusateiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_ImusateiRireki";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SATEIKETSYORINMKBN       = "sateiketsyorinmkbn";
    public static final String IMUSATEIKEKKAKBN         = "imusateikekkakbn";
    public static final String TNSKETSYACD              = "tnsketsyacd";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String IMUSATEICOMMENT          = "imusateicomment";
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
    public static final String SNTKINFOSAKUSEIYHKBN     = "sntkinfosakuseiyhkbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_ImusateiRireki primaryKey;

    public GenHT_ImusateiRireki() {
        primaryKey = new PKHT_ImusateiRireki();
    }

    public GenHT_ImusateiRireki(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_ImusateiRireki(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_ImusateiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_ImusateiRireki> getMetaClass() {
        return QHT_ImusateiRireki.class;
    }

    @Id
    @Column(name=GenHT_ImusateiRireki.MOSNO)
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
    @Column(name=GenHT_ImusateiRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHT_ImusateiRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_SateiketsyorinmKbn sateiketsyorinmkbn;

    @Type(type="UserType_C_SateiketsyorinmKbn")
    @Column(name=GenHT_ImusateiRireki.SATEIKETSYORINMKBN)
    public C_SateiketsyorinmKbn getSateiketsyorinmkbn() {
        return sateiketsyorinmkbn;
    }

    public void setSateiketsyorinmkbn(C_SateiketsyorinmKbn pSateiketsyorinmkbn) {
        sateiketsyorinmkbn = pSateiketsyorinmkbn;
    }

    private C_SyorikekkaKbn imusateikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenHT_ImusateiRireki.IMUSATEIKEKKAKBN)
    public C_SyorikekkaKbn getImusateikekkakbn() {
        return imusateikekkakbn;
    }

    public void setImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        imusateikekkakbn = pImusateikekkakbn;
    }

    private String tnsketsyacd;

    @Column(name=GenHT_ImusateiRireki.TNSKETSYACD)
    public String getTnsketsyacd() {
        return tnsketsyacd;
    }

    public void setTnsketsyacd(String pTnsketsyacd) {
        tnsketsyacd = pTnsketsyacd;
    }

    private String ketsyacd;

    @Column(name=GenHT_ImusateiRireki.KETSYACD)
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

    @Column(name=GenHT_ImusateiRireki.PALKETSYACD)
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

    private String imusateicomment;

    @Column(name=GenHT_ImusateiRireki.IMUSATEICOMMENT)
    public String getImusateicomment() {
        return imusateicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setImusateicomment(String pImusateicomment) {
        imusateicomment = pImusateicomment;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenHT_ImusateiRireki.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private C_Ketriyuucd ketriyuucd1;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_ImusateiRireki.KETRIYUUCD1)
    public C_Ketriyuucd getKetriyuucd1() {
        return ketriyuucd1;
    }

    public void setKetriyuucd1(C_Ketriyuucd pKetriyuucd1) {
        ketriyuucd1 = pKetriyuucd1;
    }

    private C_Ketriyuucd ketriyuucd2;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_ImusateiRireki.KETRIYUUCD2)
    public C_Ketriyuucd getKetriyuucd2() {
        return ketriyuucd2;
    }

    public void setKetriyuucd2(C_Ketriyuucd pKetriyuucd2) {
        ketriyuucd2 = pKetriyuucd2;
    }

    private C_Ketriyuucd ketriyuucd3;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_ImusateiRireki.KETRIYUUCD3)
    public C_Ketriyuucd getKetriyuucd3() {
        return ketriyuucd3;
    }

    public void setKetriyuucd3(C_Ketriyuucd pKetriyuucd3) {
        ketriyuucd3 = pKetriyuucd3;
    }

    private C_Ketriyuucd ketriyuucd4;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_ImusateiRireki.KETRIYUUCD4)
    public C_Ketriyuucd getKetriyuucd4() {
        return ketriyuucd4;
    }

    public void setKetriyuucd4(C_Ketriyuucd pKetriyuucd4) {
        ketriyuucd4 = pKetriyuucd4;
    }

    private String syoubyoucd1;

    @Column(name=GenHT_ImusateiRireki.SYOUBYOUCD1)
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
    @Column(name=GenHT_ImusateiRireki.SYOUBYOUJYOUTAIKBN1)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn1() {
        return syoubyoujyoutaikbn1;
    }

    public void setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn1) {
        syoubyoujyoutaikbn1 = pSyoubyoujyoutaikbn1;
    }

    private BizDateYM kantiym1;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_ImusateiRireki.KANTIYM1)
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

    @Column(name=GenHT_ImusateiRireki.SYOUBYOUCD2)
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
    @Column(name=GenHT_ImusateiRireki.SYOUBYOUJYOUTAIKBN2)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn2() {
        return syoubyoujyoutaikbn2;
    }

    public void setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn2) {
        syoubyoujyoutaikbn2 = pSyoubyoujyoutaikbn2;
    }

    private BizDateYM kantiym2;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_ImusateiRireki.KANTIYM2)
    @ValidDateYm
    public BizDateYM getKantiym2() {
        return kantiym2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym2(BizDateYM pKantiym2) {
        kantiym2 = pKantiym2;
    }

    private C_SntkinfosakuseiyhKbn sntkinfosakuseiyhkbn;

    @Type(type="UserType_C_SntkinfosakuseiyhKbn")
    @Column(name=GenHT_ImusateiRireki.SNTKINFOSAKUSEIYHKBN)
    public C_SntkinfosakuseiyhKbn getSntkinfosakuseiyhkbn() {
        return sntkinfosakuseiyhkbn;
    }

    public void setSntkinfosakuseiyhkbn(C_SntkinfosakuseiyhKbn pSntkinfosakuseiyhkbn) {
        sntkinfosakuseiyhkbn = pSntkinfosakuseiyhkbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_ImusateiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_ImusateiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}