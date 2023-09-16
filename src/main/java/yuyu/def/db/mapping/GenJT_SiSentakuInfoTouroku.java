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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KdssSiharaiJyoutaiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.id.PKJT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.GenQJT_SiSentakuInfoTouroku;
import yuyu.def.db.meta.QJT_SiSentakuInfoTouroku;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_KankeisyaKbn;
import yuyu.def.db.type.UserType_C_KdssSiharaiJyoutaiKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金選択情報登録テーブル テーブルのマッピング情報クラスで、 {@link JT_SiSentakuInfoTouroku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiSentakuInfoTouroku}</td><td colspan="3">保険金給付金選択情報登録テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiSentakuInfoTouroku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_SiSentakuInfoTouroku ○}</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getKdsssiharaijyoutaikbn kdsssiharaijyoutaikbn}</td><td>高度障害Ｓ支払状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KdssSiharaiJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getKdsssiharaiymd kdsssiharaiymd}</td><td>高度障害Ｓ支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKdsymd kdsymd}</td><td>高度障害年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKdssiharaisosikicd kdssiharaisosikicd}</td><td>高度障害支払組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiSentakuInfoTouroku
 * @see     PKJT_SiSentakuInfoTouroku
 * @see     QJT_SiSentakuInfoTouroku
 * @see     GenQJT_SiSentakuInfoTouroku
 */
@MappedSuperclass
@Table(name=GenJT_SiSentakuInfoTouroku.TABLE_NAME)
@IdClass(value=PKJT_SiSentakuInfoTouroku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_Huho2kyknoKbn", typeClass=UserType_C_Huho2kyknoKbn.class),
    @TypeDef(name="UserType_C_KankeisyaKbn", typeClass=UserType_C_KankeisyaKbn.class),
    @TypeDef(name="UserType_C_KdssSiharaiJyoutaiKbn", typeClass=UserType_C_KdssSiharaiJyoutaiKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class)
})
public abstract class GenJT_SiSentakuInfoTouroku extends AbstractExDBEntity<JT_SiSentakuInfoTouroku, PKJT_SiSentakuInfoTouroku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiSentakuInfoTouroku";
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
    public static final String KDSSSIHARAIJYOUTAIKBN    = "kdsssiharaijyoutaikbn";
    public static final String KDSSSIHARAIYMD           = "kdsssiharaiymd";
    public static final String KDSYMD                   = "kdsymd";
    public static final String KDSSIHARAISOSIKICD       = "kdssiharaisosikicd";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiSentakuInfoTouroku primaryKey;

    public GenJT_SiSentakuInfoTouroku() {
        primaryKey = new PKJT_SiSentakuInfoTouroku();
    }

    public GenJT_SiSentakuInfoTouroku(String pSyono, Integer pRenno) {
        primaryKey = new PKJT_SiSentakuInfoTouroku(pSyono, pRenno);
    }

    @Transient
    @Override
    public PKJT_SiSentakuInfoTouroku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiSentakuInfoTouroku> getMetaClass() {
        return QJT_SiSentakuInfoTouroku.class;
    }

    @Id
    @Column(name=GenJT_SiSentakuInfoTouroku.SYONO)
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
    @Column(name=GenJT_SiSentakuInfoTouroku.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiSentakuInfoTouroku.SYORIYMD)
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

    @Column(name=GenJT_SiSentakuInfoTouroku.HUHO2KYKNO)
    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    private C_Huho2kyknoKbn huho2kyknokbn;

    @Type(type="UserType_C_Huho2kyknoKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.HUHO2KYKNOKBN)
    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    private String syouhncd;

    @Column(name=GenJT_SiSentakuInfoTouroku.SYOUHNCD)
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
    @Column(name=GenJT_SiSentakuInfoTouroku.SNTKINFOKANKEISYAKBN)
    public C_KankeisyaKbn getSntkinfokankeisyakbn() {
        return sntkinfokankeisyakbn;
    }

    public void setSntkinfokankeisyakbn(C_KankeisyaKbn pSntkinfokankeisyakbn) {
        sntkinfokankeisyakbn = pSntkinfokankeisyakbn;
    }

    private String taisyounmkn;

    @Column(name=GenJT_SiSentakuInfoTouroku.TAISYOUNMKN)
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

    @Column(name=GenJT_SiSentakuInfoTouroku.TAISYOUNMKJ)
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
    @Column(name=GenJT_SiSentakuInfoTouroku.TAISYOUSEIYMD)
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
    @Column(name=GenJT_SiSentakuInfoTouroku.TAISYOUSEIBETU)
    public C_Seibetu getTaisyouseibetu() {
        return taisyouseibetu;
    }

    public void setTaisyouseibetu(C_Seibetu pTaisyouseibetu) {
        taisyouseibetu = pTaisyouseibetu;
    }

    private C_BlnktkumuKbn dakuhiketnaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.DAKUHIKETNAIYOUUMUKBN)
    public C_BlnktkumuKbn getDakuhiketnaiyouumukbn() {
        return dakuhiketnaiyouumukbn;
    }

    public void setDakuhiketnaiyouumukbn(C_BlnktkumuKbn pDakuhiketnaiyouumukbn) {
        dakuhiketnaiyouumukbn = pDakuhiketnaiyouumukbn;
    }

    private C_BlnktkumuKbn kktnaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.KKTNAIYOUUMUKBN)
    public C_BlnktkumuKbn getKktnaiyouumukbn() {
        return kktnaiyouumukbn;
    }

    public void setKktnaiyouumukbn(C_BlnktkumuKbn pKktnaiyouumukbn) {
        kktnaiyouumukbn = pKktnaiyouumukbn;
    }

    private C_BlnktkumuKbn kijinaiyouumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.KIJINAIYOUUMUKBN)
    public C_BlnktkumuKbn getKijinaiyouumukbn() {
        return kijinaiyouumukbn;
    }

    public void setKijinaiyouumukbn(C_BlnktkumuKbn pKijinaiyouumukbn) {
        kijinaiyouumukbn = pKijinaiyouumukbn;
    }

    private C_BlnktkumuKbn mrumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.MRUMUKBN)
    public C_BlnktkumuKbn getMrumukbn() {
        return mrumukbn;
    }

    public void setMrumukbn(C_BlnktkumuKbn pMrumukbn) {
        mrumukbn = pMrumukbn;
    }

    private C_BlnktkumuKbn koudosyougaiumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.KOUDOSYOUGAIUMUKBN)
    public C_BlnktkumuKbn getKoudosyougaiumukbn() {
        return koudosyougaiumukbn;
    }

    public void setKoudosyougaiumukbn(C_BlnktkumuKbn pKoudosyougaiumukbn) {
        koudosyougaiumukbn = pKoudosyougaiumukbn;
    }

    private C_BlnktkumuKbn torikaijoumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.TORIKAIJOUMUKBN)
    public C_BlnktkumuKbn getTorikaijoumukbn() {
        return torikaijoumukbn;
    }

    public void setTorikaijoumukbn(C_BlnktkumuKbn pTorikaijoumukbn) {
        torikaijoumukbn = pTorikaijoumukbn;
    }

    private C_KdssSiharaiJyoutaiKbn kdsssiharaijyoutaikbn;

    @Type(type="UserType_C_KdssSiharaiJyoutaiKbn")
    @Column(name=GenJT_SiSentakuInfoTouroku.KDSSSIHARAIJYOUTAIKBN)
    public C_KdssSiharaiJyoutaiKbn getKdsssiharaijyoutaikbn() {
        return kdsssiharaijyoutaikbn;
    }

    public void setKdsssiharaijyoutaikbn(C_KdssSiharaiJyoutaiKbn pKdsssiharaijyoutaikbn) {
        kdsssiharaijyoutaikbn = pKdsssiharaijyoutaikbn;
    }

    private BizDate kdsssiharaiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiSentakuInfoTouroku.KDSSSIHARAIYMD)
    @ValidDate
    public BizDate getKdsssiharaiymd() {
        return kdsssiharaiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKdsssiharaiymd(BizDate pKdsssiharaiymd) {
        kdsssiharaiymd = pKdsssiharaiymd;
    }

    private BizDate kdsymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiSentakuInfoTouroku.KDSYMD)
    @ValidDate
    public BizDate getKdsymd() {
        return kdsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKdsymd(BizDate pKdsymd) {
        kdsymd = pKdsymd;
    }

    private String kdssiharaisosikicd;

    @Column(name=GenJT_SiSentakuInfoTouroku.KDSSIHARAISOSIKICD)
    public String getKdssiharaisosikicd() {
        return kdssiharaisosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKdssiharaisosikicd(String pKdssiharaisosikicd) {
        kdssiharaisosikicd = pKdssiharaisosikicd;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenJT_SiSentakuInfoTouroku.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_SiSentakuInfoTouroku.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiSentakuInfoTouroku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiSentakuInfoTouroku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}