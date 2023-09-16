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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DecKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.id.PKIT_KhSntkInfoTouroku;
import yuyu.def.db.meta.GenQIT_KhSntkInfoTouroku;
import yuyu.def.db.meta.QIT_KhSntkInfoTouroku;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_DecKbn;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkInfoKykTorikesiKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全選択情報登録テーブル テーブルのマッピング情報クラスで、 {@link IT_KhSntkInfoTouroku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhSntkInfoTouroku}</td><td colspan="3">契約保全選択情報登録テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhSntkInfoTouroku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_KhSntkInfoTouroku ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHuho2kykno huho2kykno}</td><td>普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuho2kyknokbn huho2kyknokbn}</td><td>普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Huho2kyknoKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSntkinfokankeisyakbn sntkinfokankeisyakbn}</td><td>選択情報関係者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KankeisyaKbn}</td></tr>
 *  <tr><td>{@link #getTaisyounmkn taisyounmkn}</td><td>対象者氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaisyounmkj taisyounmkj}</td><td>対象者氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTaisyouseiymd taisyouseiymd}</td><td>対象者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyouseibetu taisyouseibetu}</td><td>対象者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getDakuhiketnaiyouumukbn dakuhiketnaiyouumukbn}</td><td>諾否決定内容有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKktnaiyouumukbn kktnaiyouumukbn}</td><td>告知内容有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKijinaiyouumukbn kijinaiyouumukbn}</td><td>記事内容有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getMrumukbn mrumukbn}</td><td>ＭＲ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKoudosyougaiumukbn koudosyougaiumukbn}</td><td>高度障害有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getTorikaijoumukbn torikaijoumukbn}</td><td>取消解除有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getDeckbn deckbn}</td><td>ＤＥＣ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DecKbn}</td></tr>
 *  <tr><td>{@link #getKetymd ketymd}</td><td>決定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKetkekkacd ketkekkacd}</td><td>決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd1 ketriyuucd1}</td><td>決定理由コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd2 ketriyuucd2}</td><td>決定理由コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd3 ketriyuucd3}</td><td>決定理由コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetriyuucd4 ketriyuucd4}</td><td>決定理由コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketriyuucd}</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSintyou sintyou}</td><td>身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaijyuu taijyuu}</td><td>体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoubyoucd1 syoubyoucd1}</td><td>傷病コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoujyoutaikbn1 syoubyoujyoutaikbn1}</td><td>傷病状態区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKantiym1 kantiym1}</td><td>完治年月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoubyoucd2 syoubyoucd2}</td><td>傷病コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoujyoutaikbn2 syoubyoujyoutaikbn2}</td><td>傷病状態区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoubyoujyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKantiym2 kantiym2}</td><td>完治年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMrriyuucdkbn mrriyuucdkbn}</td><td>ＭＲ理由コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MrRiyuucdKbn}</td></tr>
 *  <tr><td>{@link #getSntkinfokyktorikesikbn sntkinfokyktorikesikbn}</td><td>選択情報用契約取消処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkInfoKykTorikesiKbn}</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhSntkInfoTouroku
 * @see     PKIT_KhSntkInfoTouroku
 * @see     QIT_KhSntkInfoTouroku
 * @see     GenQIT_KhSntkInfoTouroku
 */
@MappedSuperclass
@Table(name=GenIT_KhSntkInfoTouroku.TABLE_NAME)
@IdClass(value=PKIT_KhSntkInfoTouroku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_DecKbn", typeClass=UserType_C_DecKbn.class),
    @TypeDef(name="UserType_C_Huho2kyknoKbn", typeClass=UserType_C_Huho2kyknoKbn.class),
    @TypeDef(name="UserType_C_KankeisyaKbn", typeClass=UserType_C_KankeisyaKbn.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_Ketriyuucd", typeClass=UserType_C_Ketriyuucd.class),
    @TypeDef(name="UserType_C_MrRiyuucdKbn", typeClass=UserType_C_MrRiyuucdKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SntkInfoKykTorikesiKbn", typeClass=UserType_C_SntkInfoKykTorikesiKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_SyoubyoujyoutaiKbn", typeClass=UserType_C_SyoubyoujyoutaiKbn.class)
})
public abstract class GenIT_KhSntkInfoTouroku extends AbstractExDBEntity<IT_KhSntkInfoTouroku, PKIT_KhSntkInfoTouroku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhSntkInfoTouroku";
    public static final String SYONO                    = "syono";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String HUHO2KYKNO               = "huho2kykno";
    public static final String HUHO2KYKNOKBN            = "huho2kyknokbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SNTKINFOKANKEISYAKBN     = "sntkinfokankeisyakbn";
    public static final String TAISYOUNMKN              = "taisyounmkn";
    public static final String TAISYOUNMKJ              = "taisyounmkj";
    public static final String TAISYOUSEIYMD            = "taisyouseiymd";
    public static final String TAISYOUSEIBETU           = "taisyouseibetu";
    public static final String DAKUHIKETNAIYOUUMUKBN    = "dakuhiketnaiyouumukbn";
    public static final String KKTNAIYOUUMUKBN          = "kktnaiyouumukbn";
    public static final String KIJINAIYOUUMUKBN         = "kijinaiyouumukbn";
    public static final String MRUMUKBN                 = "mrumukbn";
    public static final String KOUDOSYOUGAIUMUKBN       = "koudosyougaiumukbn";
    public static final String TORIKAIJOUMUKBN          = "torikaijoumukbn";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String DECKBN                   = "deckbn";
    public static final String KETYMD                   = "ketymd";
    public static final String KETKEKKACD               = "ketkekkacd";
    public static final String KETRIYUUCD1              = "ketriyuucd1";
    public static final String KETRIYUUCD2              = "ketriyuucd2";
    public static final String KETRIYUUCD3              = "ketriyuucd3";
    public static final String KETRIYUUCD4              = "ketriyuucd4";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String SINTYOU                  = "sintyou";
    public static final String TAIJYUU                  = "taijyuu";
    public static final String KKTYMD                   = "kktymd";
    public static final String SYOUBYOUCD1              = "syoubyoucd1";
    public static final String SYOUBYOUJYOUTAIKBN1      = "syoubyoujyoutaikbn1";
    public static final String KANTIYM1                 = "kantiym1";
    public static final String SYOUBYOUCD2              = "syoubyoucd2";
    public static final String SYOUBYOUJYOUTAIKBN2      = "syoubyoujyoutaikbn2";
    public static final String KANTIYM2                 = "kantiym2";
    public static final String MRRIYUUCDKBN             = "mrriyuucdkbn";
    public static final String SNTKINFOKYKTORIKESIKBN   = "sntkinfokyktorikesikbn";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhSntkInfoTouroku primaryKey;

    public GenIT_KhSntkInfoTouroku() {
        primaryKey = new PKIT_KhSntkInfoTouroku();
    }

    public GenIT_KhSntkInfoTouroku(String pSyono, Integer pRenno) {
        primaryKey = new PKIT_KhSntkInfoTouroku(pSyono, pRenno);
    }

    @Transient
    @Override
    public PKIT_KhSntkInfoTouroku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhSntkInfoTouroku> getMetaClass() {
        return QIT_KhSntkInfoTouroku.class;
    }

    @Id
    @Column(name=GenIT_KhSntkInfoTouroku.SYONO)
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
    @Column(name=GenIT_KhSntkInfoTouroku.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSntkInfoTouroku.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String huho2kykno;

    @Column(name=GenIT_KhSntkInfoTouroku.HUHO2KYKNO)
    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    private C_Huho2kyknoKbn huho2kyknokbn;

    @Type(type="UserType_C_Huho2kyknoKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.HUHO2KYKNOKBN)
    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    private String syouhncd;

    @Column(name=GenIT_KhSntkInfoTouroku.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private C_KankeisyaKbn sntkinfokankeisyakbn;

    @Type(type="UserType_C_KankeisyaKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.SNTKINFOKANKEISYAKBN)
    public C_KankeisyaKbn getSntkinfokankeisyakbn() {
        return sntkinfokankeisyakbn;
    }

    public void setSntkinfokankeisyakbn(C_KankeisyaKbn pSntkinfokankeisyakbn) {
        sntkinfokankeisyakbn = pSntkinfokankeisyakbn;
    }

    private String taisyounmkn;

    @Column(name=GenIT_KhSntkInfoTouroku.TAISYOUNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    public String getTaisyounmkn() {
        return taisyounmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTaisyounmkn(String pTaisyounmkn) {
        taisyounmkn = pTaisyounmkn;
    }

    private String taisyounmkj;

    @Column(name=GenIT_KhSntkInfoTouroku.TAISYOUNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTaisyounmkj() {
        return taisyounmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTaisyounmkj(String pTaisyounmkj) {
        taisyounmkj = pTaisyounmkj;
    }

    private BizDate taisyouseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSntkInfoTouroku.TAISYOUSEIYMD)
    @ValidDate
    public BizDate getTaisyouseiymd() {
        return taisyouseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaisyouseiymd(BizDate pTaisyouseiymd) {
        taisyouseiymd = pTaisyouseiymd;
    }

    private C_Seibetu taisyouseibetu;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_KhSntkInfoTouroku.TAISYOUSEIBETU)
    public C_Seibetu getTaisyouseibetu() {
        return taisyouseibetu;
    }

    public void setTaisyouseibetu(C_Seibetu pTaisyouseibetu) {
        taisyouseibetu = pTaisyouseibetu;
    }

    private C_BlnktkumuKbn dakuhiketnaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.DAKUHIKETNAIYOUUMUKBN)
    public C_BlnktkumuKbn getDakuhiketnaiyouumukbn() {
        return dakuhiketnaiyouumukbn;
    }

    public void setDakuhiketnaiyouumukbn(C_BlnktkumuKbn pDakuhiketnaiyouumukbn) {
        dakuhiketnaiyouumukbn = pDakuhiketnaiyouumukbn;
    }

    private C_BlnktkumuKbn kktnaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.KKTNAIYOUUMUKBN)
    public C_BlnktkumuKbn getKktnaiyouumukbn() {
        return kktnaiyouumukbn;
    }

    public void setKktnaiyouumukbn(C_BlnktkumuKbn pKktnaiyouumukbn) {
        kktnaiyouumukbn = pKktnaiyouumukbn;
    }

    private C_BlnktkumuKbn kijinaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.KIJINAIYOUUMUKBN)
    public C_BlnktkumuKbn getKijinaiyouumukbn() {
        return kijinaiyouumukbn;
    }

    public void setKijinaiyouumukbn(C_BlnktkumuKbn pKijinaiyouumukbn) {
        kijinaiyouumukbn = pKijinaiyouumukbn;
    }

    private C_BlnktkumuKbn mrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.MRUMUKBN)
    public C_BlnktkumuKbn getMrumukbn() {
        return mrumukbn;
    }

    public void setMrumukbn(C_BlnktkumuKbn pMrumukbn) {
        mrumukbn = pMrumukbn;
    }

    private C_BlnktkumuKbn koudosyougaiumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.KOUDOSYOUGAIUMUKBN)
    public C_BlnktkumuKbn getKoudosyougaiumukbn() {
        return koudosyougaiumukbn;
    }

    public void setKoudosyougaiumukbn(C_BlnktkumuKbn pKoudosyougaiumukbn) {
        koudosyougaiumukbn = pKoudosyougaiumukbn;
    }

    private C_BlnktkumuKbn torikaijoumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.TORIKAIJOUMUKBN)
    public C_BlnktkumuKbn getTorikaijoumukbn() {
        return torikaijoumukbn;
    }

    public void setTorikaijoumukbn(C_BlnktkumuKbn pTorikaijoumukbn) {
        torikaijoumukbn = pTorikaijoumukbn;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private C_DecKbn deckbn;

    @Type(type="UserType_C_DecKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.DECKBN)
    public C_DecKbn getDeckbn() {
        return deckbn;
    }

    public void setDeckbn(C_DecKbn pDeckbn) {
        deckbn = pDeckbn;
    }

    private BizDate ketymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSntkInfoTouroku.KETYMD)
    @ValidDate
    public BizDate getKetymd() {
        return ketymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetymd(BizDate pKetymd) {
        ketymd = pKetymd;
    }

    private C_Ketkekkacd ketkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenIT_KhSntkInfoTouroku.KETKEKKACD)
    public C_Ketkekkacd getKetkekkacd() {
        return ketkekkacd;
    }

    public void setKetkekkacd(C_Ketkekkacd pKetkekkacd) {
        ketkekkacd = pKetkekkacd;
    }

    private C_Ketriyuucd ketriyuucd1;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenIT_KhSntkInfoTouroku.KETRIYUUCD1)
    public C_Ketriyuucd getKetriyuucd1() {
        return ketriyuucd1;
    }

    public void setKetriyuucd1(C_Ketriyuucd pKetriyuucd1) {
        ketriyuucd1 = pKetriyuucd1;
    }

    private C_Ketriyuucd ketriyuucd2;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenIT_KhSntkInfoTouroku.KETRIYUUCD2)
    public C_Ketriyuucd getKetriyuucd2() {
        return ketriyuucd2;
    }

    public void setKetriyuucd2(C_Ketriyuucd pKetriyuucd2) {
        ketriyuucd2 = pKetriyuucd2;
    }

    private C_Ketriyuucd ketriyuucd3;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenIT_KhSntkInfoTouroku.KETRIYUUCD3)
    public C_Ketriyuucd getKetriyuucd3() {
        return ketriyuucd3;
    }

    public void setKetriyuucd3(C_Ketriyuucd pKetriyuucd3) {
        ketriyuucd3 = pKetriyuucd3;
    }

    private C_Ketriyuucd ketriyuucd4;

    @Type(type="UserType_C_Ketriyuucd")
    @Column(name=GenIT_KhSntkInfoTouroku.KETRIYUUCD4)
    public C_Ketriyuucd getKetriyuucd4() {
        return ketriyuucd4;
    }

    public void setKetriyuucd4(C_Ketriyuucd pKetriyuucd4) {
        ketriyuucd4 = pKetriyuucd4;
    }

    private String ketsyacd;

    @Column(name=GenIT_KhSntkInfoTouroku.KETSYACD)
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

    @Column(name=GenIT_KhSntkInfoTouroku.PALKETSYACD)
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

    private Integer sintyou;

    @Column(name=GenIT_KhSntkInfoTouroku.SINTYOU)
    @Range(min="0", max="999")
    public Integer getSintyou() {
        return sintyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }

    private Integer taijyuu;

    @Column(name=GenIT_KhSntkInfoTouroku.TAIJYUU)
    @Range(min="0", max="999")
    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhSntkInfoTouroku.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private String syoubyoucd1;

    @Column(name=GenIT_KhSntkInfoTouroku.SYOUBYOUCD1)
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
    @Column(name=GenIT_KhSntkInfoTouroku.SYOUBYOUJYOUTAIKBN1)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn1() {
        return syoubyoujyoutaikbn1;
    }

    public void setSyoubyoujyoutaikbn1(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn1) {
        syoubyoujyoutaikbn1 = pSyoubyoujyoutaikbn1;
    }

    private BizDateYM kantiym1;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhSntkInfoTouroku.KANTIYM1)
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

    @Column(name=GenIT_KhSntkInfoTouroku.SYOUBYOUCD2)
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
    @Column(name=GenIT_KhSntkInfoTouroku.SYOUBYOUJYOUTAIKBN2)
    public C_SyoubyoujyoutaiKbn getSyoubyoujyoutaikbn2() {
        return syoubyoujyoutaikbn2;
    }

    public void setSyoubyoujyoutaikbn2(C_SyoubyoujyoutaiKbn pSyoubyoujyoutaikbn2) {
        syoubyoujyoutaikbn2 = pSyoubyoujyoutaikbn2;
    }

    private BizDateYM kantiym2;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KhSntkInfoTouroku.KANTIYM2)
    @ValidDateYm
    public BizDateYM getKantiym2() {
        return kantiym2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKantiym2(BizDateYM pKantiym2) {
        kantiym2 = pKantiym2;
    }

    private C_MrRiyuucdKbn mrriyuucdkbn;

    @Type(type="UserType_C_MrRiyuucdKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.MRRIYUUCDKBN)
    public C_MrRiyuucdKbn getMrriyuucdkbn() {
        return mrriyuucdkbn;
    }

    public void setMrriyuucdkbn(C_MrRiyuucdKbn pMrriyuucdkbn) {
        mrriyuucdkbn = pMrriyuucdkbn;
    }

    private C_SntkInfoKykTorikesiKbn sntkinfokyktorikesikbn;

    @Type(type="UserType_C_SntkInfoKykTorikesiKbn")
    @Column(name=GenIT_KhSntkInfoTouroku.SNTKINFOKYKTORIKESIKBN)
    public C_SntkInfoKykTorikesiKbn getSntkinfokyktorikesikbn() {
        return sntkinfokyktorikesikbn;
    }

    public void setSntkinfokyktorikesikbn(C_SntkInfoKykTorikesiKbn pSntkinfokyktorikesikbn) {
        sntkinfokyktorikesikbn = pSntkinfokyktorikesikbn;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenIT_KhSntkInfoTouroku.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhSntkInfoTouroku.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhSntkInfoTouroku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhSntkInfoTouroku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}