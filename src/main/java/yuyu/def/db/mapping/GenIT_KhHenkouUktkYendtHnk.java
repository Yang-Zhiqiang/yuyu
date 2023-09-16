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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.id.PKIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.GenQIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HnskariyuuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（円建変更）テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHenkouUktkYendtHnk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouUktkYendtHnk}</td><td colspan="3">契約保全変更受付内容（円建変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhHenkouUktkYendtHnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhHenkouUktkYendtHnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">{@link PKIT_KhHenkouUktkYendtHnk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYendthnkymd yendthnkymd}</td><td>円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMkhgktttymd mkhgktttymd}</td><td>目標額到達日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMkhgktttkaiyakuhr mkhgktttkaiyakuhr}</td><td>目標額到達時解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewkaiyakuhr newkaiyakuhr}</td><td>変更後解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkhr yendthnkhr}</td><td>円建変更時返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNyuuryokuhassoukbn nyuuryokuhassoukbn}</td><td>入力発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getHnskariyuu1 hnskariyuu1}</td><td>本社回送理由１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnskariyuuKbn}</td></tr>
 *  <tr><td>{@link #getHnskariyuu2 hnskariyuu2}</td><td>本社回送理由２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnskariyuuKbn}</td></tr>
 *  <tr><td>{@link #getYendthnkkaiyakuhrgaika yendthnkkaiyakuhrgaika}</td><td>円建変更時解約返戻金（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkkaiyakuhryen yendthnkkaiyakuhryen}</td><td>円建変更時解約返戻金（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkjikwsrate yendthnkjikwsrate}</td><td>円建変更時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNewsyouhncd newsyouhncd}</td><td>変更後商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewsyouhnsdno newsyouhnsdno}</td><td>変更後商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYendthnkkihons yendthnkkihons}</td><td>円建変更後基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewhokenryou newhokenryou}</td><td>変更後保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNewkyktuukasyu newkyktuukasyu}</td><td>変更後契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getNewryouritusdno newryouritusdno}</td><td>変更後料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNewtumitateriritu newtumitateriritu}</td><td>変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNewyoteiriritu newyoteiriritu}</td><td>変更後予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMkhgk mkhgk}</td><td>目標額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkkjnkg yendthnkkjnkg}</td><td>円建変更基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYendthnkbfrsibousyen yendthnkbfrsibousyen}</td><td>円建変更前死亡Ｓ（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkjiptumitatekin yendthnkjiptumitatekin}</td><td>円建変更時保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkjisjkkktyouseiritu yendthnkjisjkkktyouseiritu}</td><td>円建変更時市場価格調整率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYendthnkjikaiyakukjgk yendthnkjikaiyakukjgk}</td><td>円建変更時解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYendthnkjikaiyakukoujyoritu yendthnkjikaiyakukoujyoritu}</td><td>円建変更時解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakukoujyoritutekiumu kaiyakukoujyoritutekiumu}</td><td>解約控除率適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     IT_KhHenkouUktkYendtHnk
 * @see     PKIT_KhHenkouUktkYendtHnk
 * @see     QIT_KhHenkouUktkYendtHnk
 * @see     GenQIT_KhHenkouUktkYendtHnk
 */
@MappedSuperclass
@Table(name=GenIT_KhHenkouUktkYendtHnk.TABLE_NAME)
@IdClass(value=PKIT_KhHenkouUktkYendtHnk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HnskariyuuKbn", typeClass=UserType_C_HnskariyuuKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KhHenkouUktkYendtHnk extends AbstractExDBEntity<IT_KhHenkouUktkYendtHnk, PKIT_KhHenkouUktkYendtHnk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHenkouUktkYendtHnk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HOZENHENKOUUKTKRENNO     = "hozenhenkouuktkrenno";
    public static final String YENDTHNKYMD              = "yendthnkymd";
    public static final String MKHGKTTTYMD              = "mkhgktttymd";
    public static final String MKHGKTTTKAIYAKUHR        = "mkhgktttkaiyakuhr";
    public static final String NEWKAIYAKUHR             = "newkaiyakuhr";
    public static final String YENDTHNKHR               = "yendthnkhr";
    public static final String NYUURYOKUHASSOUKBN       = "nyuuryokuhassoukbn";
    public static final String HNSKARIYUU1              = "hnskariyuu1";
    public static final String HNSKARIYUU2              = "hnskariyuu2";
    public static final String YENDTHNKKAIYAKUHRGAIKA   = "yendthnkkaiyakuhrgaika";
    public static final String YENDTHNKKAIYAKUHRYEN     = "yendthnkkaiyakuhryen";
    public static final String YENDTHNKJIKWSRATE        = "yendthnkjikwsrate";
    public static final String NEWSYOUHNCD              = "newsyouhncd";
    public static final String NEWSYOUHNSDNO            = "newsyouhnsdno";
    public static final String YENDTHNKKIHONS           = "yendthnkkihons";
    public static final String NEWHOKENRYOU             = "newhokenryou";
    public static final String NEWKYKTUUKASYU           = "newkyktuukasyu";
    public static final String NEWRYOURITUSDNO          = "newryouritusdno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String NEWTUMITATERIRITU        = "newtumitateriritu";
    public static final String NEWYOTEIRIRITU           = "newyoteiriritu";
    public static final String MKHGK                    = "mkhgk";
    public static final String YENDTHNKKJNKG            = "yendthnkkjnkg";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String YENDTHNKBFRSIBOUSYEN     = "yendthnkbfrsibousyen";
    public static final String YENDTHNKJIPTUMITATEKIN   = "yendthnkjiptumitatekin";
    public static final String YENDTHNKJISJKKKTYOUSEIRITU = "yendthnkjisjkkktyouseiritu";
    public static final String YENDTHNKJIKAIYAKUKJGK    = "yendthnkjikaiyakukjgk";
    public static final String YENDTHNKJIKAIYAKUKOUJYORITU = "yendthnkjikaiyakukoujyoritu";
    public static final String KAIYAKUKOUJYORITUTEKIUMU = "kaiyakukoujyoritutekiumu";

    private final PKIT_KhHenkouUktkYendtHnk primaryKey;

    public GenIT_KhHenkouUktkYendtHnk() {
        primaryKey = new PKIT_KhHenkouUktkYendtHnk();
    }

    public GenIT_KhHenkouUktkYendtHnk(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
    ) {
        primaryKey = new PKIT_KhHenkouUktkYendtHnk(
            pKbnkey,
            pSyono,
            pHozenhenkouuktkrenno
        );
    }

    @Transient
    @Override
    public PKIT_KhHenkouUktkYendtHnk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHenkouUktkYendtHnk> getMetaClass() {
        return QIT_KhHenkouUktkYendtHnk.class;
    }

    @Id
    @Column(name=GenIT_KhHenkouUktkYendtHnk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhHenkouUktkYendtHnk.SYONO)
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
    @Column(name=GenIT_KhHenkouUktkYendtHnk.HOZENHENKOUUKTKRENNO)
    public Integer getHozenhenkouuktkrenno() {
        return getPrimaryKey().getHozenhenkouuktkrenno();
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        getPrimaryKey().setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
    }

    private BizDate yendthnkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.YENDTHNKYMD)
    public BizDate getYendthnkymd() {
        return yendthnkymd;
    }

    public void setYendthnkymd(BizDate pYendthnkymd) {
        yendthnkymd = pYendthnkymd;
    }

    private BizDate mkhgktttymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.MKHGKTTTYMD)
    public BizDate getMkhgktttymd() {
        return mkhgktttymd;
    }

    public void setMkhgktttymd(BizDate pMkhgktttymd) {
        mkhgktttymd = pMkhgktttymd;
    }

    private BizCurrency mkhgktttkaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMkhgktttkaiyakuhr() {
        return mkhgktttkaiyakuhr;
    }

    public void setMkhgktttkaiyakuhr(BizCurrency pMkhgktttkaiyakuhr) {
        mkhgktttkaiyakuhr = pMkhgktttkaiyakuhr;
        mkhgktttkaiyakuhrValue = null;
        mkhgktttkaiyakuhrType  = null;
    }

    transient private BigDecimal mkhgktttkaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MKHGKTTTKAIYAKUHR, nullable=true)
    protected BigDecimal getMkhgktttkaiyakuhrValue() {
        if (mkhgktttkaiyakuhrValue == null && mkhgktttkaiyakuhr != null) {
            if (mkhgktttkaiyakuhr.isOptional()) return null;
            return mkhgktttkaiyakuhr.absolute();
        }
        return mkhgktttkaiyakuhrValue;
    }

    protected void setMkhgktttkaiyakuhrValue(BigDecimal value) {
        mkhgktttkaiyakuhrValue = value;
        mkhgktttkaiyakuhr = Optional.fromNullable(toCurrencyType(mkhgktttkaiyakuhrType))
            .transform(bizCurrencyTransformer(getMkhgktttkaiyakuhrValue()))
            .orNull();
    }

    transient private String mkhgktttkaiyakuhrType = null;

    @Column(name=MKHGKTTTKAIYAKUHR + "$", nullable=true)
    protected String getMkhgktttkaiyakuhrType() {
        if (mkhgktttkaiyakuhrType == null && mkhgktttkaiyakuhr != null) return mkhgktttkaiyakuhr.getType().toString();
        if (mkhgktttkaiyakuhrType == null && getMkhgktttkaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mkhgktttkaiyakuhr$' should not be NULL."));
        }
        return mkhgktttkaiyakuhrType;
    }

    protected void setMkhgktttkaiyakuhrType(String type) {
        mkhgktttkaiyakuhrType = type;
        mkhgktttkaiyakuhr = Optional.fromNullable(toCurrencyType(mkhgktttkaiyakuhrType))
            .transform(bizCurrencyTransformer(getMkhgktttkaiyakuhrValue()))
            .orNull();
    }

    private BizCurrency newkaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewkaiyakuhr() {
        return newkaiyakuhr;
    }

    public void setNewkaiyakuhr(BizCurrency pNewkaiyakuhr) {
        newkaiyakuhr = pNewkaiyakuhr;
        newkaiyakuhrValue = null;
        newkaiyakuhrType  = null;
    }

    transient private BigDecimal newkaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWKAIYAKUHR, nullable=true)
    protected BigDecimal getNewkaiyakuhrValue() {
        if (newkaiyakuhrValue == null && newkaiyakuhr != null) {
            if (newkaiyakuhr.isOptional()) return null;
            return newkaiyakuhr.absolute();
        }
        return newkaiyakuhrValue;
    }

    protected void setNewkaiyakuhrValue(BigDecimal value) {
        newkaiyakuhrValue = value;
        newkaiyakuhr = Optional.fromNullable(toCurrencyType(newkaiyakuhrType))
            .transform(bizCurrencyTransformer(getNewkaiyakuhrValue()))
            .orNull();
    }

    transient private String newkaiyakuhrType = null;

    @Column(name=NEWKAIYAKUHR + "$", nullable=true)
    protected String getNewkaiyakuhrType() {
        if (newkaiyakuhrType == null && newkaiyakuhr != null) return newkaiyakuhr.getType().toString();
        if (newkaiyakuhrType == null && getNewkaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newkaiyakuhr$' should not be NULL."));
        }
        return newkaiyakuhrType;
    }

    protected void setNewkaiyakuhrType(String type) {
        newkaiyakuhrType = type;
        newkaiyakuhr = Optional.fromNullable(toCurrencyType(newkaiyakuhrType))
            .transform(bizCurrencyTransformer(getNewkaiyakuhrValue()))
            .orNull();
    }

    private BizCurrency yendthnkhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkhr() {
        return yendthnkhr;
    }

    public void setYendthnkhr(BizCurrency pYendthnkhr) {
        yendthnkhr = pYendthnkhr;
        yendthnkhrValue = null;
        yendthnkhrType  = null;
    }

    transient private BigDecimal yendthnkhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKHR, nullable=true)
    protected BigDecimal getYendthnkhrValue() {
        if (yendthnkhrValue == null && yendthnkhr != null) {
            if (yendthnkhr.isOptional()) return null;
            return yendthnkhr.absolute();
        }
        return yendthnkhrValue;
    }

    protected void setYendthnkhrValue(BigDecimal value) {
        yendthnkhrValue = value;
        yendthnkhr = Optional.fromNullable(toCurrencyType(yendthnkhrType))
            .transform(bizCurrencyTransformer(getYendthnkhrValue()))
            .orNull();
    }

    transient private String yendthnkhrType = null;

    @Column(name=YENDTHNKHR + "$", nullable=true)
    protected String getYendthnkhrType() {
        if (yendthnkhrType == null && yendthnkhr != null) return yendthnkhr.getType().toString();
        if (yendthnkhrType == null && getYendthnkhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkhr$' should not be NULL."));
        }
        return yendthnkhrType;
    }

    protected void setYendthnkhrType(String type) {
        yendthnkhrType = type;
        yendthnkhr = Optional.fromNullable(toCurrencyType(yendthnkhrType))
            .transform(bizCurrencyTransformer(getYendthnkhrValue()))
            .orNull();
    }

    private C_HassouKbn nyuuryokuhassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.NYUURYOKUHASSOUKBN)
    public C_HassouKbn getNyuuryokuhassoukbn() {
        return nyuuryokuhassoukbn;
    }

    public void setNyuuryokuhassoukbn(C_HassouKbn pNyuuryokuhassoukbn) {
        nyuuryokuhassoukbn = pNyuuryokuhassoukbn;
    }

    private C_HnskariyuuKbn hnskariyuu1;

    @Type(type="UserType_C_HnskariyuuKbn")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.HNSKARIYUU1)
    public C_HnskariyuuKbn getHnskariyuu1() {
        return hnskariyuu1;
    }

    public void setHnskariyuu1(C_HnskariyuuKbn pHnskariyuu1) {
        hnskariyuu1 = pHnskariyuu1;
    }

    private C_HnskariyuuKbn hnskariyuu2;

    @Type(type="UserType_C_HnskariyuuKbn")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.HNSKARIYUU2)
    public C_HnskariyuuKbn getHnskariyuu2() {
        return hnskariyuu2;
    }

    public void setHnskariyuu2(C_HnskariyuuKbn pHnskariyuu2) {
        hnskariyuu2 = pHnskariyuu2;
    }

    private BizCurrency yendthnkkaiyakuhrgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkkaiyakuhrgaika() {
        return yendthnkkaiyakuhrgaika;
    }

    public void setYendthnkkaiyakuhrgaika(BizCurrency pYendthnkkaiyakuhrgaika) {
        yendthnkkaiyakuhrgaika = pYendthnkkaiyakuhrgaika;
        yendthnkkaiyakuhrgaikaValue = null;
        yendthnkkaiyakuhrgaikaType  = null;
    }

    transient private BigDecimal yendthnkkaiyakuhrgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKKAIYAKUHRGAIKA, nullable=true)
    protected BigDecimal getYendthnkkaiyakuhrgaikaValue() {
        if (yendthnkkaiyakuhrgaikaValue == null && yendthnkkaiyakuhrgaika != null) {
            if (yendthnkkaiyakuhrgaika.isOptional()) return null;
            return yendthnkkaiyakuhrgaika.absolute();
        }
        return yendthnkkaiyakuhrgaikaValue;
    }

    protected void setYendthnkkaiyakuhrgaikaValue(BigDecimal value) {
        yendthnkkaiyakuhrgaikaValue = value;
        yendthnkkaiyakuhrgaika = Optional.fromNullable(toCurrencyType(yendthnkkaiyakuhrgaikaType))
            .transform(bizCurrencyTransformer(getYendthnkkaiyakuhrgaikaValue()))
            .orNull();
    }

    transient private String yendthnkkaiyakuhrgaikaType = null;

    @Column(name=YENDTHNKKAIYAKUHRGAIKA + "$", nullable=true)
    protected String getYendthnkkaiyakuhrgaikaType() {
        if (yendthnkkaiyakuhrgaikaType == null && yendthnkkaiyakuhrgaika != null) return yendthnkkaiyakuhrgaika.getType().toString();
        if (yendthnkkaiyakuhrgaikaType == null && getYendthnkkaiyakuhrgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkkaiyakuhrgaika$' should not be NULL."));
        }
        return yendthnkkaiyakuhrgaikaType;
    }

    protected void setYendthnkkaiyakuhrgaikaType(String type) {
        yendthnkkaiyakuhrgaikaType = type;
        yendthnkkaiyakuhrgaika = Optional.fromNullable(toCurrencyType(yendthnkkaiyakuhrgaikaType))
            .transform(bizCurrencyTransformer(getYendthnkkaiyakuhrgaikaValue()))
            .orNull();
    }

    private BizCurrency yendthnkkaiyakuhryen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkkaiyakuhryen() {
        return yendthnkkaiyakuhryen;
    }

    public void setYendthnkkaiyakuhryen(BizCurrency pYendthnkkaiyakuhryen) {
        yendthnkkaiyakuhryen = pYendthnkkaiyakuhryen;
        yendthnkkaiyakuhryenValue = null;
        yendthnkkaiyakuhryenType  = null;
    }

    transient private BigDecimal yendthnkkaiyakuhryenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKKAIYAKUHRYEN, nullable=true)
    protected BigDecimal getYendthnkkaiyakuhryenValue() {
        if (yendthnkkaiyakuhryenValue == null && yendthnkkaiyakuhryen != null) {
            if (yendthnkkaiyakuhryen.isOptional()) return null;
            return yendthnkkaiyakuhryen.absolute();
        }
        return yendthnkkaiyakuhryenValue;
    }

    protected void setYendthnkkaiyakuhryenValue(BigDecimal value) {
        yendthnkkaiyakuhryenValue = value;
        yendthnkkaiyakuhryen = Optional.fromNullable(toCurrencyType(yendthnkkaiyakuhryenType))
            .transform(bizCurrencyTransformer(getYendthnkkaiyakuhryenValue()))
            .orNull();
    }

    transient private String yendthnkkaiyakuhryenType = null;

    @Column(name=YENDTHNKKAIYAKUHRYEN + "$", nullable=true)
    protected String getYendthnkkaiyakuhryenType() {
        if (yendthnkkaiyakuhryenType == null && yendthnkkaiyakuhryen != null) return yendthnkkaiyakuhryen.getType().toString();
        if (yendthnkkaiyakuhryenType == null && getYendthnkkaiyakuhryenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkkaiyakuhryen$' should not be NULL."));
        }
        return yendthnkkaiyakuhryenType;
    }

    protected void setYendthnkkaiyakuhryenType(String type) {
        yendthnkkaiyakuhryenType = type;
        yendthnkkaiyakuhryen = Optional.fromNullable(toCurrencyType(yendthnkkaiyakuhryenType))
            .transform(bizCurrencyTransformer(getYendthnkkaiyakuhryenValue()))
            .orNull();
    }

    private BizNumber yendthnkjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.YENDTHNKJIKWSRATE)
    public BizNumber getYendthnkjikwsrate() {
        return yendthnkjikwsrate;
    }

    public void setYendthnkjikwsrate(BizNumber pYendthnkjikwsrate) {
        yendthnkjikwsrate = pYendthnkjikwsrate;
    }

    private String newsyouhncd;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWSYOUHNCD)
    public String getNewsyouhncd() {
        return newsyouhncd;
    }

    public void setNewsyouhncd(String pNewsyouhncd) {
        newsyouhncd = pNewsyouhncd;
    }

    private Integer newsyouhnsdno;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWSYOUHNSDNO)
    public Integer getNewsyouhnsdno() {
        return newsyouhnsdno;
    }

    public void setNewsyouhnsdno(Integer pNewsyouhnsdno) {
        newsyouhnsdno = pNewsyouhnsdno;
    }

    private BizCurrency yendthnkkihons;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkkihons() {
        return yendthnkkihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYendthnkkihons(BizCurrency pYendthnkkihons) {
        yendthnkkihons = pYendthnkkihons;
        yendthnkkihonsValue = null;
        yendthnkkihonsType  = null;
    }

    transient private BigDecimal yendthnkkihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKKIHONS, nullable=true)
    protected BigDecimal getYendthnkkihonsValue() {
        if (yendthnkkihonsValue == null && yendthnkkihons != null) {
            if (yendthnkkihons.isOptional()) return null;
            return yendthnkkihons.absolute();
        }
        return yendthnkkihonsValue;
    }

    protected void setYendthnkkihonsValue(BigDecimal value) {
        yendthnkkihonsValue = value;
        yendthnkkihons = Optional.fromNullable(toCurrencyType(yendthnkkihonsType))
            .transform(bizCurrencyTransformer(getYendthnkkihonsValue()))
            .orNull();
    }

    transient private String yendthnkkihonsType = null;

    @Column(name=YENDTHNKKIHONS + "$", nullable=true)
    protected String getYendthnkkihonsType() {
        if (yendthnkkihonsType == null && yendthnkkihons != null) return yendthnkkihons.getType().toString();
        if (yendthnkkihonsType == null && getYendthnkkihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkkihons$' should not be NULL."));
        }
        return yendthnkkihonsType;
    }

    protected void setYendthnkkihonsType(String type) {
        yendthnkkihonsType = type;
        yendthnkkihons = Optional.fromNullable(toCurrencyType(yendthnkkihonsType))
            .transform(bizCurrencyTransformer(getYendthnkkihonsValue()))
            .orNull();
    }

    private BizCurrency newhokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNewhokenryou() {
        return newhokenryou;
    }

    public void setNewhokenryou(BizCurrency pNewhokenryou) {
        newhokenryou = pNewhokenryou;
        newhokenryouValue = null;
        newhokenryouType  = null;
    }

    transient private BigDecimal newhokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NEWHOKENRYOU, nullable=true)
    protected BigDecimal getNewhokenryouValue() {
        if (newhokenryouValue == null && newhokenryou != null) {
            if (newhokenryou.isOptional()) return null;
            return newhokenryou.absolute();
        }
        return newhokenryouValue;
    }

    protected void setNewhokenryouValue(BigDecimal value) {
        newhokenryouValue = value;
        newhokenryou = Optional.fromNullable(toCurrencyType(newhokenryouType))
            .transform(bizCurrencyTransformer(getNewhokenryouValue()))
            .orNull();
    }

    transient private String newhokenryouType = null;

    @Column(name=NEWHOKENRYOU + "$", nullable=true)
    protected String getNewhokenryouType() {
        if (newhokenryouType == null && newhokenryou != null) return newhokenryou.getType().toString();
        if (newhokenryouType == null && getNewhokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'newhokenryou$' should not be NULL."));
        }
        return newhokenryouType;
    }

    protected void setNewhokenryouType(String type) {
        newhokenryouType = type;
        newhokenryou = Optional.fromNullable(toCurrencyType(newhokenryouType))
            .transform(bizCurrencyTransformer(getNewhokenryouValue()))
            .orNull();
    }

    private C_Tuukasyu newkyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWKYKTUUKASYU)
    public C_Tuukasyu getNewkyktuukasyu() {
        return newkyktuukasyu;
    }

    public void setNewkyktuukasyu(C_Tuukasyu pNewkyktuukasyu) {
        newkyktuukasyu = pNewkyktuukasyu;
    }

    private String newryouritusdno;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWRYOURITUSDNO)
    public String getNewryouritusdno() {
        return newryouritusdno;
    }

    public void setNewryouritusdno(String pNewryouritusdno) {
        newryouritusdno = pNewryouritusdno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizNumber newtumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWTUMITATERIRITU)
    public BizNumber getNewtumitateriritu() {
        return newtumitateriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewtumitateriritu(BizNumber pNewtumitateriritu) {
        newtumitateriritu = pNewtumitateriritu;
    }

    private BizNumber newyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.NEWYOTEIRIRITU)
    public BizNumber getNewyoteiriritu() {
        return newyoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewyoteiriritu(BizNumber pNewyoteiriritu) {
        newyoteiriritu = pNewyoteiriritu;
    }

    private BizCurrency mkhgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMkhgk() {
        return mkhgk;
    }

    public void setMkhgk(BizCurrency pMkhgk) {
        mkhgk = pMkhgk;
        mkhgkValue = null;
        mkhgkType  = null;
    }

    transient private BigDecimal mkhgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MKHGK, nullable=true)
    protected BigDecimal getMkhgkValue() {
        if (mkhgkValue == null && mkhgk != null) {
            if (mkhgk.isOptional()) return null;
            return mkhgk.absolute();
        }
        return mkhgkValue;
    }

    protected void setMkhgkValue(BigDecimal value) {
        mkhgkValue = value;
        mkhgk = Optional.fromNullable(toCurrencyType(mkhgkType))
            .transform(bizCurrencyTransformer(getMkhgkValue()))
            .orNull();
    }

    transient private String mkhgkType = null;

    @Column(name=MKHGK + "$", nullable=true)
    protected String getMkhgkType() {
        if (mkhgkType == null && mkhgk != null) return mkhgk.getType().toString();
        if (mkhgkType == null && getMkhgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mkhgk$' should not be NULL."));
        }
        return mkhgkType;
    }

    protected void setMkhgkType(String type) {
        mkhgkType = type;
        mkhgk = Optional.fromNullable(toCurrencyType(mkhgkType))
            .transform(bizCurrencyTransformer(getMkhgkValue()))
            .orNull();
    }

    private BizCurrency yendthnkkjnkg;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkkjnkg() {
        return yendthnkkjnkg;
    }

    public void setYendthnkkjnkg(BizCurrency pYendthnkkjnkg) {
        yendthnkkjnkg = pYendthnkkjnkg;
        yendthnkkjnkgValue = null;
        yendthnkkjnkgType  = null;
    }

    transient private BigDecimal yendthnkkjnkgValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKKJNKG, nullable=true)
    protected BigDecimal getYendthnkkjnkgValue() {
        if (yendthnkkjnkgValue == null && yendthnkkjnkg != null) {
            if (yendthnkkjnkg.isOptional()) return null;
            return yendthnkkjnkg.absolute();
        }
        return yendthnkkjnkgValue;
    }

    protected void setYendthnkkjnkgValue(BigDecimal value) {
        yendthnkkjnkgValue = value;
        yendthnkkjnkg = Optional.fromNullable(toCurrencyType(yendthnkkjnkgType))
            .transform(bizCurrencyTransformer(getYendthnkkjnkgValue()))
            .orNull();
    }

    transient private String yendthnkkjnkgType = null;

    @Column(name=YENDTHNKKJNKG + "$", nullable=true)
    protected String getYendthnkkjnkgType() {
        if (yendthnkkjnkgType == null && yendthnkkjnkg != null) return yendthnkkjnkg.getType().toString();
        if (yendthnkkjnkgType == null && getYendthnkkjnkgValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkkjnkg$' should not be NULL."));
        }
        return yendthnkkjnkgType;
    }

    protected void setYendthnkkjnkgType(String type) {
        yendthnkkjnkgType = type;
        yendthnkkjnkg = Optional.fromNullable(toCurrencyType(yendthnkkjnkgType))
            .transform(bizCurrencyTransformer(getYendthnkkjnkgValue()))
            .orNull();
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIT_KhHenkouUktkYendtHnk.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private BizCurrency yendthnkbfrsibousyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkbfrsibousyen() {
        return yendthnkbfrsibousyen;
    }

    public void setYendthnkbfrsibousyen(BizCurrency pYendthnkbfrsibousyen) {
        yendthnkbfrsibousyen = pYendthnkbfrsibousyen;
        yendthnkbfrsibousyenValue = null;
        yendthnkbfrsibousyenType  = null;
    }

    transient private BigDecimal yendthnkbfrsibousyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKBFRSIBOUSYEN, nullable=true)
    protected BigDecimal getYendthnkbfrsibousyenValue() {
        if (yendthnkbfrsibousyenValue == null && yendthnkbfrsibousyen != null) {
            if (yendthnkbfrsibousyen.isOptional()) return null;
            return yendthnkbfrsibousyen.absolute();
        }
        return yendthnkbfrsibousyenValue;
    }

    protected void setYendthnkbfrsibousyenValue(BigDecimal value) {
        yendthnkbfrsibousyenValue = value;
        yendthnkbfrsibousyen = Optional.fromNullable(toCurrencyType(yendthnkbfrsibousyenType))
            .transform(bizCurrencyTransformer(getYendthnkbfrsibousyenValue()))
            .orNull();
    }

    transient private String yendthnkbfrsibousyenType = null;

    @Column(name=YENDTHNKBFRSIBOUSYEN + "$", nullable=true)
    protected String getYendthnkbfrsibousyenType() {
        if (yendthnkbfrsibousyenType == null && yendthnkbfrsibousyen != null) return yendthnkbfrsibousyen.getType().toString();
        if (yendthnkbfrsibousyenType == null && getYendthnkbfrsibousyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkbfrsibousyen$' should not be NULL."));
        }
        return yendthnkbfrsibousyenType;
    }

    protected void setYendthnkbfrsibousyenType(String type) {
        yendthnkbfrsibousyenType = type;
        yendthnkbfrsibousyen = Optional.fromNullable(toCurrencyType(yendthnkbfrsibousyenType))
            .transform(bizCurrencyTransformer(getYendthnkbfrsibousyenValue()))
            .orNull();
    }

    private BizCurrency yendthnkjiptumitatekin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkjiptumitatekin() {
        return yendthnkjiptumitatekin;
    }

    public void setYendthnkjiptumitatekin(BizCurrency pYendthnkjiptumitatekin) {
        yendthnkjiptumitatekin = pYendthnkjiptumitatekin;
        yendthnkjiptumitatekinValue = null;
        yendthnkjiptumitatekinType  = null;
    }

    transient private BigDecimal yendthnkjiptumitatekinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKJIPTUMITATEKIN, nullable=true)
    protected BigDecimal getYendthnkjiptumitatekinValue() {
        if (yendthnkjiptumitatekinValue == null && yendthnkjiptumitatekin != null) {
            if (yendthnkjiptumitatekin.isOptional()) return null;
            return yendthnkjiptumitatekin.absolute();
        }
        return yendthnkjiptumitatekinValue;
    }

    protected void setYendthnkjiptumitatekinValue(BigDecimal value) {
        yendthnkjiptumitatekinValue = value;
        yendthnkjiptumitatekin = Optional.fromNullable(toCurrencyType(yendthnkjiptumitatekinType))
            .transform(bizCurrencyTransformer(getYendthnkjiptumitatekinValue()))
            .orNull();
    }

    transient private String yendthnkjiptumitatekinType = null;

    @Column(name=YENDTHNKJIPTUMITATEKIN + "$", nullable=true)
    protected String getYendthnkjiptumitatekinType() {
        if (yendthnkjiptumitatekinType == null && yendthnkjiptumitatekin != null) return yendthnkjiptumitatekin.getType().toString();
        if (yendthnkjiptumitatekinType == null && getYendthnkjiptumitatekinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkjiptumitatekin$' should not be NULL."));
        }
        return yendthnkjiptumitatekinType;
    }

    protected void setYendthnkjiptumitatekinType(String type) {
        yendthnkjiptumitatekinType = type;
        yendthnkjiptumitatekin = Optional.fromNullable(toCurrencyType(yendthnkjiptumitatekinType))
            .transform(bizCurrencyTransformer(getYendthnkjiptumitatekinValue()))
            .orNull();
    }

    private BizNumber yendthnkjisjkkktyouseiritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.YENDTHNKJISJKKKTYOUSEIRITU)
    public BizNumber getYendthnkjisjkkktyouseiritu() {
        return yendthnkjisjkkktyouseiritu;
    }

    public void setYendthnkjisjkkktyouseiritu(BizNumber pYendthnkjisjkkktyouseiritu) {
        yendthnkjisjkkktyouseiritu = pYendthnkjisjkkktyouseiritu;
    }

    private BizCurrency yendthnkjikaiyakukjgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYendthnkjikaiyakukjgk() {
        return yendthnkjikaiyakukjgk;
    }

    public void setYendthnkjikaiyakukjgk(BizCurrency pYendthnkjikaiyakukjgk) {
        yendthnkjikaiyakukjgk = pYendthnkjikaiyakukjgk;
        yendthnkjikaiyakukjgkValue = null;
        yendthnkjikaiyakukjgkType  = null;
    }

    transient private BigDecimal yendthnkjikaiyakukjgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENDTHNKJIKAIYAKUKJGK, nullable=true)
    protected BigDecimal getYendthnkjikaiyakukjgkValue() {
        if (yendthnkjikaiyakukjgkValue == null && yendthnkjikaiyakukjgk != null) {
            if (yendthnkjikaiyakukjgk.isOptional()) return null;
            return yendthnkjikaiyakukjgk.absolute();
        }
        return yendthnkjikaiyakukjgkValue;
    }

    protected void setYendthnkjikaiyakukjgkValue(BigDecimal value) {
        yendthnkjikaiyakukjgkValue = value;
        yendthnkjikaiyakukjgk = Optional.fromNullable(toCurrencyType(yendthnkjikaiyakukjgkType))
            .transform(bizCurrencyTransformer(getYendthnkjikaiyakukjgkValue()))
            .orNull();
    }

    transient private String yendthnkjikaiyakukjgkType = null;

    @Column(name=YENDTHNKJIKAIYAKUKJGK + "$", nullable=true)
    protected String getYendthnkjikaiyakukjgkType() {
        if (yendthnkjikaiyakukjgkType == null && yendthnkjikaiyakukjgk != null) return yendthnkjikaiyakukjgk.getType().toString();
        if (yendthnkjikaiyakukjgkType == null && getYendthnkjikaiyakukjgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yendthnkjikaiyakukjgk$' should not be NULL."));
        }
        return yendthnkjikaiyakukjgkType;
    }

    protected void setYendthnkjikaiyakukjgkType(String type) {
        yendthnkjikaiyakukjgkType = type;
        yendthnkjikaiyakukjgk = Optional.fromNullable(toCurrencyType(yendthnkjikaiyakukjgkType))
            .transform(bizCurrencyTransformer(getYendthnkjikaiyakukjgkValue()))
            .orNull();
    }

    private BizNumber yendthnkjikaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.YENDTHNKJIKAIYAKUKOUJYORITU)
    public BizNumber getYendthnkjikaiyakukoujyoritu() {
        return yendthnkjikaiyakukoujyoritu;
    }

    public void setYendthnkjikaiyakukoujyoritu(BizNumber pYendthnkjikaiyakukoujyoritu) {
        yendthnkjikaiyakukoujyoritu = pYendthnkjikaiyakukoujyoritu;
    }

    private C_UmuKbn kaiyakukoujyoritutekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhHenkouUktkYendtHnk.KAIYAKUKOUJYORITUTEKIUMU)
    public C_UmuKbn getKaiyakukoujyoritutekiumu() {
        return kaiyakukoujyoritutekiumu;
    }

    public void setKaiyakukoujyoritutekiumu(C_UmuKbn pKaiyakukoujyoritutekiumu) {
        kaiyakukoujyoritutekiumu = pKaiyakukoujyoritutekiumu;
    }
}