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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.id.PKHT_KnksateiRireki;
import yuyu.def.db.meta.GenQHT_KnksateiRireki;
import yuyu.def.db.meta.QHT_KnksateiRireki;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TorikesisyousairiyuuCd;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 環境査定履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_KnksateiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KnksateiRireki}</td><td colspan="3">環境査定履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_KnksateiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_KnksateiRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSateiketsyorinmkbn sateiketsyorinmkbn}</td><td>査定・決定処理名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SateiketsyorinmKbn}</td></tr>
 *  <tr><td>{@link #getKnksateikekkakbn knksateikekkakbn}</td><td>環境査定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getTnsketsyacd tnsketsyacd}</td><td>転送先決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKnksateicomment knksateicomment}</td><td>環境査定コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd1 ketriyuucd1}</td><td>決定理由コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd2 ketriyuucd2}</td><td>決定理由コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd3 ketriyuucd3}</td><td>決定理由コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd4 ketriyuucd4}</td><td>決定理由コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getMrriyuucdkbn mrriyuucdkbn}</td><td>ＭＲ理由コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MrRiyuucdKbn}</td></tr>
 *  <tr><td>{@link #getTorikesisyousairiyuucd torikesisyousairiyuucd}</td><td>取消詳細理由コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TorikesisyousairiyuuCd}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KnksateiRireki
 * @see     PKHT_KnksateiRireki
 * @see     QHT_KnksateiRireki
 * @see     GenQHT_KnksateiRireki
 */
@MappedSuperclass
@Table(name=GenHT_KnksateiRireki.TABLE_NAME)
@IdClass(value=PKHT_KnksateiRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Ketriyuucd", typeClass=UserType_C_Ketriyuucd.class),
    @TypeDef(name="UserType_C_MrRiyuucdKbn", typeClass=UserType_C_MrRiyuucdKbn.class),
    @TypeDef(name="UserType_C_SateiketsyorinmKbn", typeClass=UserType_C_SateiketsyorinmKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_TorikesisyousairiyuuCd", typeClass=UserType_C_TorikesisyousairiyuuCd.class)
})
public abstract class GenHT_KnksateiRireki extends AbstractExDBEntity<HT_KnksateiRireki, PKHT_KnksateiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_KnksateiRireki";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SATEIKETSYORINMKBN       = "sateiketsyorinmkbn";
    public static final String KNKSATEIKEKKAKBN         = "knksateikekkakbn";
    public static final String TNSKETSYACD              = "tnsketsyacd";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String KNKSATEICOMMENT          = "knksateicomment";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String KETRIYUUCD1              = "ketriyuucd1";
    public static final String KETRIYUUCD2              = "ketriyuucd2";
    public static final String KETRIYUUCD3              = "ketriyuucd3";
    public static final String KETRIYUUCD4              = "ketriyuucd4";
    public static final String MRRIYUUCDKBN             = "mrriyuucdkbn";
    public static final String TORIKESISYOUSAIRIYUUCD   = "torikesisyousairiyuucd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_KnksateiRireki primaryKey;

    public GenHT_KnksateiRireki() {
        primaryKey = new PKHT_KnksateiRireki();
    }

    public GenHT_KnksateiRireki(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_KnksateiRireki(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_KnksateiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_KnksateiRireki> getMetaClass() {
        return QHT_KnksateiRireki.class;
    }

    @Id
    @Column(name=GenHT_KnksateiRireki.MOSNO)
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
    @Column(name=GenHT_KnksateiRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KnksateiRireki.SYORIYMD)
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
    @Column(name=GenHT_KnksateiRireki.SATEIKETSYORINMKBN)
    public C_SateiketsyorinmKbn getSateiketsyorinmkbn() {
        return sateiketsyorinmkbn;
    }

    public void setSateiketsyorinmkbn(C_SateiketsyorinmKbn pSateiketsyorinmkbn) {
        sateiketsyorinmkbn = pSateiketsyorinmkbn;
    }

    private C_SyorikekkaKbn knksateikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenHT_KnksateiRireki.KNKSATEIKEKKAKBN)
    public C_SyorikekkaKbn getKnksateikekkakbn() {
        return knksateikekkakbn;
    }

    public void setKnksateikekkakbn(C_SyorikekkaKbn pKnksateikekkakbn) {
        knksateikekkakbn = pKnksateikekkakbn;
    }

    private String tnsketsyacd;

    @Column(name=GenHT_KnksateiRireki.TNSKETSYACD)
    public String getTnsketsyacd() {
        return tnsketsyacd;
    }

    public void setTnsketsyacd(String pTnsketsyacd) {
        tnsketsyacd = pTnsketsyacd;
    }

    private String ketsyacd;

    @Column(name=GenHT_KnksateiRireki.KETSYACD)
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

    @Column(name=GenHT_KnksateiRireki.PALKETSYACD)
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

    private String knksateicomment;

    @Column(name=GenHT_KnksateiRireki.KNKSATEICOMMENT)
    public String getKnksateicomment() {
        return knksateicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnksateicomment(String pKnksateicomment) {
        knksateicomment = pKnksateicomment;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenHT_KnksateiRireki.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private C_Ketriyuucd ketriyuucd1;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_KnksateiRireki.KETRIYUUCD1)
    public C_Ketriyuucd getKetriyuucd1() {
        return ketriyuucd1;
    }

    public void setKetriyuucd1(C_Ketriyuucd pKetriyuucd1) {
        ketriyuucd1 = pKetriyuucd1;
    }

    private C_Ketriyuucd ketriyuucd2;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_KnksateiRireki.KETRIYUUCD2)
    public C_Ketriyuucd getKetriyuucd2() {
        return ketriyuucd2;
    }

    public void setKetriyuucd2(C_Ketriyuucd pKetriyuucd2) {
        ketriyuucd2 = pKetriyuucd2;
    }

    private C_Ketriyuucd ketriyuucd3;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_KnksateiRireki.KETRIYUUCD3)
    public C_Ketriyuucd getKetriyuucd3() {
        return ketriyuucd3;
    }

    public void setKetriyuucd3(C_Ketriyuucd pKetriyuucd3) {
        ketriyuucd3 = pKetriyuucd3;
    }

    private C_Ketriyuucd ketriyuucd4;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenHT_KnksateiRireki.KETRIYUUCD4)
    public C_Ketriyuucd getKetriyuucd4() {
        return ketriyuucd4;
    }

    public void setKetriyuucd4(C_Ketriyuucd pKetriyuucd4) {
        ketriyuucd4 = pKetriyuucd4;
    }

    private C_MrRiyuucdKbn mrriyuucdkbn;

    @Type(type="UserType_C_MrRiyuucdKbn")
    @Column(name=GenHT_KnksateiRireki.MRRIYUUCDKBN)
    public C_MrRiyuucdKbn getMrriyuucdkbn() {
        return mrriyuucdkbn;
    }

    public void setMrriyuucdkbn(C_MrRiyuucdKbn pMrriyuucdkbn) {
        mrriyuucdkbn = pMrriyuucdkbn;
    }

    private C_TorikesisyousairiyuuCd torikesisyousairiyuucd;

    @Type(type="UserType_C_TorikesisyousairiyuuCd")
    @Column(name=GenHT_KnksateiRireki.TORIKESISYOUSAIRIYUUCD)
    public C_TorikesisyousairiyuuCd getTorikesisyousairiyuucd() {
        return torikesisyousairiyuucd;
    }

    public void setTorikesisyousairiyuucd(C_TorikesisyousairiyuuCd pTorikesisyousairiyuucd) {
        torikesisyousairiyuucd = pTorikesisyousairiyuucd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_KnksateiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_KnksateiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}