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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_BAK_KhShrRirekiDetail;
import yuyu.def.db.id.PKIT_BAK_KhShrRirekiDetail;
import yuyu.def.db.meta.GenQIT_BAK_KhShrRirekiDetail;
import yuyu.def.db.meta.QIT_BAK_KhShrRirekiDetail;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全支払履歴明細バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhShrRirekiDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhShrRirekiDetail}</td><td colspan="3">契約保全支払履歴明細バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKIT_BAK_KhShrRirekiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyushrgk syushrgk}</td><td>主たる支払額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtstmttkin shrtstmttkin}</td><td>支払対象積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtstmttkinhngkbbn shrtstmttkinhngkbbn}</td><td>支払対象積立金（変額部分）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSjkkktyouseigk sjkkktyouseigk}</td><td>市場価格調整額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakusjkkktyouseiritu kaiyakusjkkktyouseiritu}</td><td>解約市場価格調整率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakusjkkktyouseiriritu kaiyakusjkkktyouseiriritu}</td><td>解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakukjgk kaiyakukjgk}</td><td>解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakukoujyoritu kaiyakukoujyoritu}</td><td>解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeiritutmttkngk teiritutmttkngk}</td><td>定率積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSisuurendoutmttkngk sisuurendoutmttkngk}</td><td>指数連動積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_KhShrRirekiDetail
 * @see     PKIT_BAK_KhShrRirekiDetail
 * @see     QIT_BAK_KhShrRirekiDetail
 * @see     GenQIT_BAK_KhShrRirekiDetail
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhShrRirekiDetail.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhShrRirekiDetail.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenIT_BAK_KhShrRirekiDetail extends AbstractExDBEntity<IT_BAK_KhShrRirekiDetail, PKIT_BAK_KhShrRirekiDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhShrRirekiDetail";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String SYUSHRGK                 = "syushrgk";
    public static final String SHRTSTMTTKIN             = "shrtstmttkin";
    public static final String SHRTSTMTTKINHNGKBBN      = "shrtstmttkinhngkbbn";
    public static final String SJKKKTYOUSEIGK           = "sjkkktyouseigk";
    public static final String KAIYAKUSJKKKTYOUSEIRITU  = "kaiyakusjkkktyouseiritu";
    public static final String KAIYAKUSJKKKTYOUSEIRIRITU = "kaiyakusjkkktyouseiriritu";
    public static final String KAIYAKUKJGK              = "kaiyakukjgk";
    public static final String KAIYAKUKOUJYORITU        = "kaiyakukoujyoritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TEIRITUTMTTKNGK          = "teiritutmttkngk";
    public static final String SISUURENDOUTMTTKNGK      = "sisuurendoutmttkngk";

    private final PKIT_BAK_KhShrRirekiDetail primaryKey;

    public GenIT_BAK_KhShrRirekiDetail() {
        primaryKey = new PKIT_BAK_KhShrRirekiDetail();
    }

    public GenIT_BAK_KhShrRirekiDetail(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno
    ) {
        primaryKey = new PKIT_BAK_KhShrRirekiDetail(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey,
            pSyouhncd,
            pSyouhnsdno,
            pKyksyouhnrenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhShrRirekiDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhShrRirekiDetail> getMetaClass() {
        return QIT_BAK_KhShrRirekiDetail.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRirekiDetail.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRirekiDetail.SYONO)
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
    @Column(name=GenIT_BAK_KhShrRirekiDetail.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRirekiDetail.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRirekiDetail.SYOUHNCD)
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
    @Column(name=GenIT_BAK_KhShrRirekiDetail.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRirekiDetail.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    private BizCurrency syushrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyushrgk() {
        return syushrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyushrgk(BizCurrency pSyushrgk) {
        syushrgk = pSyushrgk;
        syushrgkValue = null;
        syushrgkType  = null;
    }

    transient private BigDecimal syushrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUSHRGK, nullable=true)
    protected BigDecimal getSyushrgkValue() {
        if (syushrgkValue == null && syushrgk != null) {
            if (syushrgk.isOptional()) return null;
            return syushrgk.absolute();
        }
        return syushrgkValue;
    }

    protected void setSyushrgkValue(BigDecimal value) {
        syushrgkValue = value;
        syushrgk = Optional.fromNullable(toCurrencyType(syushrgkType))
            .transform(bizCurrencyTransformer(getSyushrgkValue()))
            .orNull();
    }

    transient private String syushrgkType = null;

    @Column(name=SYUSHRGK + "$", nullable=true)
    protected String getSyushrgkType() {
        if (syushrgkType == null && syushrgk != null) return syushrgk.getType().toString();
        if (syushrgkType == null && getSyushrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syushrgk$' should not be NULL."));
        }
        return syushrgkType;
    }

    protected void setSyushrgkType(String type) {
        syushrgkType = type;
        syushrgk = Optional.fromNullable(toCurrencyType(syushrgkType))
            .transform(bizCurrencyTransformer(getSyushrgkValue()))
            .orNull();
    }

    private BizCurrency shrtstmttkin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtstmttkin() {
        return shrtstmttkin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrtstmttkin(BizCurrency pShrtstmttkin) {
        shrtstmttkin = pShrtstmttkin;
        shrtstmttkinValue = null;
        shrtstmttkinType  = null;
    }

    transient private BigDecimal shrtstmttkinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTSTMTTKIN, nullable=true)
    protected BigDecimal getShrtstmttkinValue() {
        if (shrtstmttkinValue == null && shrtstmttkin != null) {
            if (shrtstmttkin.isOptional()) return null;
            return shrtstmttkin.absolute();
        }
        return shrtstmttkinValue;
    }

    protected void setShrtstmttkinValue(BigDecimal value) {
        shrtstmttkinValue = value;
        shrtstmttkin = Optional.fromNullable(toCurrencyType(shrtstmttkinType))
            .transform(bizCurrencyTransformer(getShrtstmttkinValue()))
            .orNull();
    }

    transient private String shrtstmttkinType = null;

    @Column(name=SHRTSTMTTKIN + "$", nullable=true)
    protected String getShrtstmttkinType() {
        if (shrtstmttkinType == null && shrtstmttkin != null) return shrtstmttkin.getType().toString();
        if (shrtstmttkinType == null && getShrtstmttkinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtstmttkin$' should not be NULL."));
        }
        return shrtstmttkinType;
    }

    protected void setShrtstmttkinType(String type) {
        shrtstmttkinType = type;
        shrtstmttkin = Optional.fromNullable(toCurrencyType(shrtstmttkinType))
            .transform(bizCurrencyTransformer(getShrtstmttkinValue()))
            .orNull();
    }

    private BizCurrency shrtstmttkinhngkbbn;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtstmttkinhngkbbn() {
        return shrtstmttkinhngkbbn;
    }

    public void setShrtstmttkinhngkbbn(BizCurrency pShrtstmttkinhngkbbn) {
        shrtstmttkinhngkbbn = pShrtstmttkinhngkbbn;
        shrtstmttkinhngkbbnValue = null;
        shrtstmttkinhngkbbnType  = null;
    }

    transient private BigDecimal shrtstmttkinhngkbbnValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTSTMTTKINHNGKBBN, nullable=true)
    protected BigDecimal getShrtstmttkinhngkbbnValue() {
        if (shrtstmttkinhngkbbnValue == null && shrtstmttkinhngkbbn != null) {
            if (shrtstmttkinhngkbbn.isOptional()) return null;
            return shrtstmttkinhngkbbn.absolute();
        }
        return shrtstmttkinhngkbbnValue;
    }

    protected void setShrtstmttkinhngkbbnValue(BigDecimal value) {
        shrtstmttkinhngkbbnValue = value;
        shrtstmttkinhngkbbn = Optional.fromNullable(toCurrencyType(shrtstmttkinhngkbbnType))
            .transform(bizCurrencyTransformer(getShrtstmttkinhngkbbnValue()))
            .orNull();
    }

    transient private String shrtstmttkinhngkbbnType = null;

    @Column(name=SHRTSTMTTKINHNGKBBN + "$", nullable=true)
    protected String getShrtstmttkinhngkbbnType() {
        if (shrtstmttkinhngkbbnType == null && shrtstmttkinhngkbbn != null) return shrtstmttkinhngkbbn.getType().toString();
        if (shrtstmttkinhngkbbnType == null && getShrtstmttkinhngkbbnValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtstmttkinhngkbbn$' should not be NULL."));
        }
        return shrtstmttkinhngkbbnType;
    }

    protected void setShrtstmttkinhngkbbnType(String type) {
        shrtstmttkinhngkbbnType = type;
        shrtstmttkinhngkbbn = Optional.fromNullable(toCurrencyType(shrtstmttkinhngkbbnType))
            .transform(bizCurrencyTransformer(getShrtstmttkinhngkbbnValue()))
            .orNull();
    }

    private BizCurrency sjkkktyouseigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSjkkktyouseigk() {
        return sjkkktyouseigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSjkkktyouseigk(BizCurrency pSjkkktyouseigk) {
        sjkkktyouseigk = pSjkkktyouseigk;
        sjkkktyouseigkValue = null;
        sjkkktyouseigkType  = null;
    }

    transient private BigDecimal sjkkktyouseigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SJKKKTYOUSEIGK, nullable=true)
    protected BigDecimal getSjkkktyouseigkValue() {
        if (sjkkktyouseigkValue == null && sjkkktyouseigk != null) {
            if (sjkkktyouseigk.isOptional()) return null;
            return sjkkktyouseigk.absolute();
        }
        return sjkkktyouseigkValue;
    }

    protected void setSjkkktyouseigkValue(BigDecimal value) {
        sjkkktyouseigkValue = value;
        sjkkktyouseigk = Optional.fromNullable(toCurrencyType(sjkkktyouseigkType))
            .transform(bizCurrencyTransformer(getSjkkktyouseigkValue()))
            .orNull();
    }

    transient private String sjkkktyouseigkType = null;

    @Column(name=SJKKKTYOUSEIGK + "$", nullable=true)
    protected String getSjkkktyouseigkType() {
        if (sjkkktyouseigkType == null && sjkkktyouseigk != null) return sjkkktyouseigk.getType().toString();
        if (sjkkktyouseigkType == null && getSjkkktyouseigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sjkkktyouseigk$' should not be NULL."));
        }
        return sjkkktyouseigkType;
    }

    protected void setSjkkktyouseigkType(String type) {
        sjkkktyouseigkType = type;
        sjkkktyouseigk = Optional.fromNullable(toCurrencyType(sjkkktyouseigkType))
            .transform(bizCurrencyTransformer(getSjkkktyouseigkValue()))
            .orNull();
    }

    private BizNumber kaiyakusjkkktyouseiritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRirekiDetail.KAIYAKUSJKKKTYOUSEIRITU)
    public BizNumber getKaiyakusjkkktyouseiritu() {
        return kaiyakusjkkktyouseiritu;
    }

    public void setKaiyakusjkkktyouseiritu(BizNumber pKaiyakusjkkktyouseiritu) {
        kaiyakusjkkktyouseiritu = pKaiyakusjkkktyouseiritu;
    }

    private BizNumber kaiyakusjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRirekiDetail.KAIYAKUSJKKKTYOUSEIRIRITU)
    public BizNumber getKaiyakusjkkktyouseiriritu() {
        return kaiyakusjkkktyouseiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakusjkkktyouseiriritu(BizNumber pKaiyakusjkkktyouseiriritu) {
        kaiyakusjkkktyouseiriritu = pKaiyakusjkkktyouseiriritu;
    }

    private BizCurrency kaiyakukjgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakukjgk() {
        return kaiyakukjgk;
    }

    public void setKaiyakukjgk(BizCurrency pKaiyakukjgk) {
        kaiyakukjgk = pKaiyakukjgk;
        kaiyakukjgkValue = null;
        kaiyakukjgkType  = null;
    }

    transient private BigDecimal kaiyakukjgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUKJGK, nullable=true)
    protected BigDecimal getKaiyakukjgkValue() {
        if (kaiyakukjgkValue == null && kaiyakukjgk != null) {
            if (kaiyakukjgk.isOptional()) return null;
            return kaiyakukjgk.absolute();
        }
        return kaiyakukjgkValue;
    }

    protected void setKaiyakukjgkValue(BigDecimal value) {
        kaiyakukjgkValue = value;
        kaiyakukjgk = Optional.fromNullable(toCurrencyType(kaiyakukjgkType))
            .transform(bizCurrencyTransformer(getKaiyakukjgkValue()))
            .orNull();
    }

    transient private String kaiyakukjgkType = null;

    @Column(name=KAIYAKUKJGK + "$", nullable=true)
    protected String getKaiyakukjgkType() {
        if (kaiyakukjgkType == null && kaiyakukjgk != null) return kaiyakukjgk.getType().toString();
        if (kaiyakukjgkType == null && getKaiyakukjgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakukjgk$' should not be NULL."));
        }
        return kaiyakukjgkType;
    }

    protected void setKaiyakukjgkType(String type) {
        kaiyakukjgkType = type;
        kaiyakukjgk = Optional.fromNullable(toCurrencyType(kaiyakukjgkType))
            .transform(bizCurrencyTransformer(getKaiyakukjgkValue()))
            .orNull();
    }

    private BizNumber kaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRirekiDetail.KAIYAKUKOUJYORITU)
    public BizNumber getKaiyakukoujyoritu() {
        return kaiyakukoujyoritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakukoujyoritu(BizNumber pKaiyakukoujyoritu) {
        kaiyakukoujyoritu = pKaiyakukoujyoritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhShrRirekiDetail.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhShrRirekiDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhShrRirekiDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizCurrency teiritutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeiritutmttkngk() {
        return teiritutmttkngk;
    }

    public void setTeiritutmttkngk(BizCurrency pTeiritutmttkngk) {
        teiritutmttkngk = pTeiritutmttkngk;
        teiritutmttkngkValue = null;
        teiritutmttkngkType  = null;
    }

    transient private BigDecimal teiritutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIRITUTMTTKNGK, nullable=true)
    protected BigDecimal getTeiritutmttkngkValue() {
        if (teiritutmttkngkValue == null && teiritutmttkngk != null) {
            if (teiritutmttkngk.isOptional()) return null;
            return teiritutmttkngk.absolute();
        }
        return teiritutmttkngkValue;
    }

    protected void setTeiritutmttkngkValue(BigDecimal value) {
        teiritutmttkngkValue = value;
        teiritutmttkngk = Optional.fromNullable(toCurrencyType(teiritutmttkngkType))
            .transform(bizCurrencyTransformer(getTeiritutmttkngkValue()))
            .orNull();
    }

    transient private String teiritutmttkngkType = null;

    @Column(name=TEIRITUTMTTKNGK + "$", nullable=true)
    protected String getTeiritutmttkngkType() {
        if (teiritutmttkngkType == null && teiritutmttkngk != null) return teiritutmttkngk.getType().toString();
        if (teiritutmttkngkType == null && getTeiritutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teiritutmttkngk$' should not be NULL."));
        }
        return teiritutmttkngkType;
    }

    protected void setTeiritutmttkngkType(String type) {
        teiritutmttkngkType = type;
        teiritutmttkngk = Optional.fromNullable(toCurrencyType(teiritutmttkngkType))
            .transform(bizCurrencyTransformer(getTeiritutmttkngkValue()))
            .orNull();
    }

    private BizCurrency sisuurendoutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSisuurendoutmttkngk() {
        return sisuurendoutmttkngk;
    }

    public void setSisuurendoutmttkngk(BizCurrency pSisuurendoutmttkngk) {
        sisuurendoutmttkngk = pSisuurendoutmttkngk;
        sisuurendoutmttkngkValue = null;
        sisuurendoutmttkngkType  = null;
    }

    transient private BigDecimal sisuurendoutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SISUURENDOUTMTTKNGK, nullable=true)
    protected BigDecimal getSisuurendoutmttkngkValue() {
        if (sisuurendoutmttkngkValue == null && sisuurendoutmttkngk != null) {
            if (sisuurendoutmttkngk.isOptional()) return null;
            return sisuurendoutmttkngk.absolute();
        }
        return sisuurendoutmttkngkValue;
    }

    protected void setSisuurendoutmttkngkValue(BigDecimal value) {
        sisuurendoutmttkngkValue = value;
        sisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(sisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getSisuurendoutmttkngkValue()))
            .orNull();
    }

    transient private String sisuurendoutmttkngkType = null;

    @Column(name=SISUURENDOUTMTTKNGK + "$", nullable=true)
    protected String getSisuurendoutmttkngkType() {
        if (sisuurendoutmttkngkType == null && sisuurendoutmttkngk != null) return sisuurendoutmttkngk.getType().toString();
        if (sisuurendoutmttkngkType == null && getSisuurendoutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sisuurendoutmttkngk$' should not be NULL."));
        }
        return sisuurendoutmttkngkType;
    }

    protected void setSisuurendoutmttkngkType(String type) {
        sisuurendoutmttkngkType = type;
        sisuurendoutmttkngk = Optional.fromNullable(toCurrencyType(sisuurendoutmttkngkType))
            .transform(bizCurrencyTransformer(getSisuurendoutmttkngkValue()))
            .orNull();
    }
}