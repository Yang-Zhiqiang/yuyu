package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyou;
import yuyu.def.db.id.PKIT_BAK_KoujyoSymNaiyou;
import yuyu.def.db.meta.GenQIT_BAK_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_BAK_KoujyoSymNaiyou;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_DispKbn;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;
import yuyu.def.db.type.UserType_C_KoujyosymnaiyourecKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeipKbn;
import yuyu.def.db.type.UserType_C_TekiyouseidoKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明内容バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KoujyoSymNaiyou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KoujyoSymNaiyou}</td><td colspan="3">控除証明内容バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeinnd koujyosyoumeinnd}</td><td>控除証明年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoumeistartym syoumeistartym}</td><td>証明開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSyoumeiendym syoumeiendym}</td><td>証明終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeipkbn koujyosyoumeipkbn}</td><td>控除証明保険料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosyoumeipKbn}</td></tr>
 *  <tr><td>{@link #getTekiyouseidokbn tekiyouseidokbn}</td><td>適用制度区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TekiyouseidoKbn}</td></tr>
 *  <tr><td>{@link #getKoujyosymnaiyoureckbn koujyosymnaiyoureckbn}</td><td>控除証明内容レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosymnaiyourecKbn}</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeigk koujyosyoumeigk}</td><td>控除証明額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNyknjskrrkrenno nyknjskrrkrenno}</td><td>入金実績履歴連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKihrkpssrrkrenno kihrkpssrrkrenno}</td><td>既払込Ｐ精算履歴連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKjsmhakkouzumiflg kjsmhakkouzumiflg}</td><td>控除証明書発行済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakujyoflg sakujyoflg}</td><td>削除フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Delflag}</td></tr>
 *  <tr><td>{@link #getZennoukaisiymd zennoukaisiymd}</td><td>前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennourenno zennourenno}</td><td>前納連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKeisanhukahyoujikbn keisanhukahyoujikbn}</td><td>計算不可表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DispKbn}</td></tr>
 *  <tr><td>{@link #getKeisanhukariyuucd keisanhukariyuucd}</td><td>計算不可理由コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KoujyoSymNaiyou
 * @see     PKIT_BAK_KoujyoSymNaiyou
 * @see     QIT_BAK_KoujyoSymNaiyou
 * @see     GenQIT_BAK_KoujyoSymNaiyou
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KoujyoSymNaiyou.TABLE_NAME)
@IdClass(value=PKIT_BAK_KoujyoSymNaiyou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Delflag", typeClass=UserType_C_Delflag.class),
    @TypeDef(name="UserType_C_DispKbn", typeClass=UserType_C_DispKbn.class),
    @TypeDef(name="UserType_C_Kjsmhakkouzumiflg", typeClass=UserType_C_Kjsmhakkouzumiflg.class),
    @TypeDef(name="UserType_C_KoujyosymnaiyourecKbn", typeClass=UserType_C_KoujyosymnaiyourecKbn.class),
    @TypeDef(name="UserType_C_KoujyosyoumeipKbn", typeClass=UserType_C_KoujyosyoumeipKbn.class),
    @TypeDef(name="UserType_C_TekiyouseidoKbn", typeClass=UserType_C_TekiyouseidoKbn.class)
})
public abstract class GenIT_BAK_KoujyoSymNaiyou extends AbstractExDBEntity<IT_BAK_KoujyoSymNaiyou, PKIT_BAK_KoujyoSymNaiyou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KoujyoSymNaiyou";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String KOUJYOSYOUMEINND         = "koujyosyoumeinnd";
    public static final String SYOUMEISTARTYM           = "syoumeistartym";
    public static final String SYOUMEIENDYM             = "syoumeiendym";
    public static final String KOUJYOSYOUMEIPKBN        = "koujyosyoumeipkbn";
    public static final String TEKIYOUSEIDOKBN          = "tekiyouseidokbn";
    public static final String KOUJYOSYMNAIYOURECKBN    = "koujyosymnaiyoureckbn";
    public static final String KOUJYOSYOUMEIGK          = "koujyosyoumeigk";
    public static final String JYUTOUSTARTYM            = "jyutoustartym";
    public static final String NYKNJSKRRKRENNO          = "nyknjskrrkrenno";
    public static final String KIHRKPSSRRKRENNO         = "kihrkpssrrkrenno";
    public static final String KJSMHAKKOUZUMIFLG        = "kjsmhakkouzumiflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SAKUJYOFLG               = "sakujyoflg";
    public static final String ZENNOUKAISIYMD           = "zennoukaisiymd";
    public static final String ZENNOURENNO              = "zennourenno";
    public static final String KEISANHUKAHYOUJIKBN      = "keisanhukahyoujikbn";
    public static final String KEISANHUKARIYUUCD        = "keisanhukariyuucd";

    private final PKIT_BAK_KoujyoSymNaiyou primaryKey;

    public GenIT_BAK_KoujyoSymNaiyou() {
        primaryKey = new PKIT_BAK_KoujyoSymNaiyou();
    }

    public GenIT_BAK_KoujyoSymNaiyou(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pSyouhncd,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_BAK_KoujyoSymNaiyou(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pSyouhncd,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KoujyoSymNaiyou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KoujyoSymNaiyou> getMetaClass() {
        return QIT_BAK_KoujyoSymNaiyou.class;
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.SYONO)
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
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String koujyosyoumeinnd;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KOUJYOSYOUMEINND)
    public String getKoujyosyoumeinnd() {
        return koujyosyoumeinnd;
    }

    public void setKoujyosyoumeinnd(String pKoujyosyoumeinnd) {
        koujyosyoumeinnd = pKoujyosyoumeinnd;
    }

    private BizDateYM syoumeistartym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.SYOUMEISTARTYM)
    public BizDateYM getSyoumeistartym() {
        return syoumeistartym;
    }

    public void setSyoumeistartym(BizDateYM pSyoumeistartym) {
        syoumeistartym = pSyoumeistartym;
    }

    private BizDateYM syoumeiendym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.SYOUMEIENDYM)
    public BizDateYM getSyoumeiendym() {
        return syoumeiendym;
    }

    public void setSyoumeiendym(BizDateYM pSyoumeiendym) {
        syoumeiendym = pSyoumeiendym;
    }

    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Type(type="UserType_C_KoujyosyoumeipKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KOUJYOSYOUMEIPKBN)
    public C_KoujyosyoumeipKbn getKoujyosyoumeipkbn() {
        return koujyosyoumeipkbn;
    }

    public void setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn pKoujyosyoumeipkbn) {
        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
    }

    private C_TekiyouseidoKbn tekiyouseidokbn;

    @Type(type="UserType_C_TekiyouseidoKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.TEKIYOUSEIDOKBN)
    public C_TekiyouseidoKbn getTekiyouseidokbn() {
        return tekiyouseidokbn;
    }

    public void setTekiyouseidokbn(C_TekiyouseidoKbn pTekiyouseidokbn) {
        tekiyouseidokbn = pTekiyouseidokbn;
    }

    private C_KoujyosymnaiyourecKbn koujyosymnaiyoureckbn;

    @Type(type="UserType_C_KoujyosymnaiyourecKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KOUJYOSYMNAIYOURECKBN)
    public C_KoujyosymnaiyourecKbn getKoujyosymnaiyoureckbn() {
        return koujyosymnaiyoureckbn;
    }

    public void setKoujyosymnaiyoureckbn(C_KoujyosymnaiyourecKbn pKoujyosymnaiyoureckbn) {
        koujyosymnaiyoureckbn = pKoujyosymnaiyoureckbn;
    }

    private BizCurrency koujyosyoumeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKoujyosyoumeigk() {
        return koujyosyoumeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKoujyosyoumeigk(BizCurrency pKoujyosyoumeigk) {
        koujyosyoumeigk = pKoujyosyoumeigk;
        koujyosyoumeigkValue = null;
        koujyosyoumeigkType  = null;
    }

    transient private BigDecimal koujyosyoumeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KOUJYOSYOUMEIGK, nullable=true)
    protected BigDecimal getKoujyosyoumeigkValue() {
        if (koujyosyoumeigkValue == null && koujyosyoumeigk != null) {
            if (koujyosyoumeigk.isOptional()) return null;
            return koujyosyoumeigk.absolute();
        }
        return koujyosyoumeigkValue;
    }

    protected void setKoujyosyoumeigkValue(BigDecimal value) {
        koujyosyoumeigkValue = value;
        koujyosyoumeigk = Optional.fromNullable(toCurrencyType(koujyosyoumeigkType))
            .transform(bizCurrencyTransformer(getKoujyosyoumeigkValue()))
            .orNull();
    }

    transient private String koujyosyoumeigkType = null;

    @Column(name=KOUJYOSYOUMEIGK + "$", nullable=true)
    protected String getKoujyosyoumeigkType() {
        if (koujyosyoumeigkType == null && koujyosyoumeigk != null) return koujyosyoumeigk.getType().toString();
        if (koujyosyoumeigkType == null && getKoujyosyoumeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'koujyosyoumeigk$' should not be NULL."));
        }
        return koujyosyoumeigkType;
    }

    protected void setKoujyosyoumeigkType(String type) {
        koujyosyoumeigkType = type;
        koujyosyoumeigk = Optional.fromNullable(toCurrencyType(koujyosyoumeigkType))
            .transform(bizCurrencyTransformer(getKoujyosyoumeigkValue()))
            .orNull();
    }

    private BizDateYM jyutoustartym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.JYUTOUSTARTYM)
    public BizDateYM getJyutoustartym() {
        return jyutoustartym;
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        jyutoustartym = pJyutoustartym;
    }

    private Integer nyknjskrrkrenno;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.NYKNJSKRRKRENNO)
    public Integer getNyknjskrrkrenno() {
        return nyknjskrrkrenno;
    }

    public void setNyknjskrrkrenno(Integer pNyknjskrrkrenno) {
        nyknjskrrkrenno = pNyknjskrrkrenno;
    }

    private Integer kihrkpssrrkrenno;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KIHRKPSSRRKRENNO)
    public Integer getKihrkpssrrkrenno() {
        return kihrkpssrrkrenno;
    }

    public void setKihrkpssrrkrenno(Integer pKihrkpssrrkrenno) {
        kihrkpssrrkrenno = pKihrkpssrrkrenno;
    }

    private C_Kjsmhakkouzumiflg kjsmhakkouzumiflg;

    @Type(type="UserType_C_Kjsmhakkouzumiflg")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KJSMHAKKOUZUMIFLG)
    public C_Kjsmhakkouzumiflg getKjsmhakkouzumiflg() {
        return kjsmhakkouzumiflg;
    }

    public void setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg pKjsmhakkouzumiflg) {
        kjsmhakkouzumiflg = pKjsmhakkouzumiflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_Delflag sakujyoflg;

    @Type(type="UserType_C_Delflag")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.SAKUJYOFLG)
    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }

    private BizDate zennoukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.ZENNOUKAISIYMD)
    public BizDate getZennoukaisiymd() {
        return zennoukaisiymd;
    }

    public void setZennoukaisiymd(BizDate pZennoukaisiymd) {
        zennoukaisiymd = pZennoukaisiymd;
    }

    private Integer zennourenno;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.ZENNOURENNO)
    public Integer getZennourenno() {
        return zennourenno;
    }

    public void setZennourenno(Integer pZennourenno) {
        zennourenno = pZennourenno;
    }

    private C_DispKbn keisanhukahyoujikbn;

    @Type(type="UserType_C_DispKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KEISANHUKAHYOUJIKBN)
    public C_DispKbn getKeisanhukahyoujikbn() {
        return keisanhukahyoujikbn;
    }

    public void setKeisanhukahyoujikbn(C_DispKbn pKeisanhukahyoujikbn) {
        keisanhukahyoujikbn = pKeisanhukahyoujikbn;
    }

    private String keisanhukariyuucd;

    @Column(name=GenIT_BAK_KoujyoSymNaiyou.KEISANHUKARIYUUCD)
    public String getKeisanhukariyuucd() {
        return keisanhukariyuucd;
    }

    public void setKeisanhukariyuucd(String pKeisanhukariyuucd) {
        keisanhukariyuucd = pKeisanhukariyuucd;
    }
}