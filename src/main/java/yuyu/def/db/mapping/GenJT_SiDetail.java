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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.id.PKJT_SiDetail;
import yuyu.def.db.meta.GenQJT_SiDetail;
import yuyu.def.db.meta.QJT_SiDetail;
import yuyu.def.db.type.UserType_C_HokenkinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_KyhkinTaniKbn;
import yuyu.def.db.type.UserType_C_KyuuhuKbn;
import yuyu.def.db.type.UserType_C_NitigakuHokenKngkKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払明細テーブル テーブルのマッピング情報クラスで、 {@link JT_SiDetail} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiDetail}</td><td colspan="3">支払明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn kyhgndkatakbn}</td><td>給付限度型区分</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_SiDetail ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhukbn kyuuhukbn}</td><td>給付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyuuhuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkinsyuruikbn hokenkinsyuruikbn}</td><td>保険金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HokenkinsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getChecktaisyouumukbn checktaisyouumukbn}</td><td>チェック対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNitigakuhokenkngkkbn nitigakuhokenkngkkbn}</td><td>日額・保険金額区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NitigakuHokenKngkKbn}</td></tr>
 *  <tr><td>{@link #getNitigakuhokenkngk nitigakuhokenkngk}</td><td>日額・保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNissuubairitu nissuubairitu}</td><td>日数・倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyhkintanikbn kyhkintanikbn}</td><td>給付金単位区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhkinTaniKbn}</td></tr>
 *  <tr><td>{@link #getKyhkg kyhkg}</td><td>給付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkyhgk yenkyhgk}</td><td>円換算給付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSitihsyutkyumaeyenhknkngk sitihsyutkyumaeyenhknkngk}</td><td>最低保証適用前円換算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHutanponissuu hutanponissuu}</td><td>不担保日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrriyuugaitouymd shrriyuugaitouymd}</td><td>支払理由該当日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknskgnkkntgtumukbn hknskgnkkntgtumukbn}</td><td>保険金削減期間対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkinshrwariai hokenkinshrwariai}</td><td>保険金支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBikoumsg1 bikoumsg1}</td><td>備考ＭＳＧ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikoumsg2 bikoumsg2}</td><td>備考ＭＳＧ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikoumsg3 bikoumsg3}</td><td>備考ＭＳＧ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikoumsg4 bikoumsg4}</td><td>備考ＭＳＧ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiDetail
 * @see     PKJT_SiDetail
 * @see     QJT_SiDetail
 * @see     GenQJT_SiDetail
 */
@MappedSuperclass
@Table(name=GenJT_SiDetail.TABLE_NAME)
@IdClass(value=PKJT_SiDetail.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HokenkinsyuruiKbn", typeClass=UserType_C_HokenkinsyuruiKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_KyhkinTaniKbn", typeClass=UserType_C_KyhkinTaniKbn.class),
    @TypeDef(name="UserType_C_KyuuhuKbn", typeClass=UserType_C_KyuuhuKbn.class),
    @TypeDef(name="UserType_C_NitigakuHokenKngkKbn", typeClass=UserType_C_NitigakuHokenKngkKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SiDetail extends AbstractExDBEntity<JT_SiDetail, PKJT_SiDetail> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiDetail";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String UKETUKENO                = "uketukeno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYHGNDKATAKBN            = "kyhgndkatakbn";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String RENNO                    = "renno";
    public static final String KYUUHUKBN                = "kyuuhukbn";
    public static final String HOKENKINSYURUIKBN        = "hokenkinsyuruikbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String CHECKTAISYOUUMUKBN       = "checktaisyouumukbn";
    public static final String NITIGAKUHOKENKNGKKBN     = "nitigakuhokenkngkkbn";
    public static final String NITIGAKUHOKENKNGK        = "nitigakuhokenkngk";
    public static final String NISSUUBAIRITU            = "nissuubairitu";
    public static final String KYHKINTANIKBN            = "kyhkintanikbn";
    public static final String KYHKG                    = "kyhkg";
    public static final String YENKYHGK                 = "yenkyhgk";
    public static final String SITIHSYUTKYUMAEYENHKNKNGK = "sitihsyutkyumaeyenhknkngk";
    public static final String HUTANPONISSUU            = "hutanponissuu";
    public static final String SHRRIYUUGAITOUYMD        = "shrriyuugaitouymd";
    public static final String HKNSKGNKKNTGTUMUKBN      = "hknskgnkkntgtumukbn";
    public static final String HOKENKINSHRWARIAI        = "hokenkinshrwariai";
    public static final String BIKOUMSG1                = "bikoumsg1";
    public static final String BIKOUMSG2                = "bikoumsg2";
    public static final String BIKOUMSG3                = "bikoumsg3";
    public static final String BIKOUMSG4                = "bikoumsg4";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiDetail primaryKey;

    public GenJT_SiDetail() {
        primaryKey = new PKJT_SiDetail();
    }

    public GenJT_SiDetail(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        String pKyuuhucd,
        Integer pRenno
    ) {
        primaryKey = new PKJT_SiDetail(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pUketukeno,
            pSyutkkbn,
            pSyouhncd,
            pKyhgndkatakbn,
            pSyouhnsdno,
            pKyksyouhnrenno,
            pKyuuhucd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKJT_SiDetail getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiDetail> getMetaClass() {
        return QJT_SiDetail.class;
    }

    @Id
    @Column(name=GenJT_SiDetail.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SiDetail.SYONO)
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
    @Column(name=GenJT_SiDetail.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SiDetail.UKETUKENO)
    public Integer getUketukeno() {
        return getPrimaryKey().getUketukeno();
    }

    public void setUketukeno(Integer pUketukeno) {
        getPrimaryKey().setUketukeno(pUketukeno);
    }

    @Id
    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenJT_SiDetail.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return getPrimaryKey().getSyutkkbn();
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        getPrimaryKey().setSyutkkbn(pSyutkkbn);
    }

    @Id
    @Column(name=GenJT_SiDetail.SYOUHNCD)
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
    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenJT_SiDetail.KYHGNDKATAKBN)
    public C_KyhgndkataKbn getKyhgndkatakbn() {
        return getPrimaryKey().getKyhgndkatakbn();
    }

    public void setKyhgndkatakbn(C_KyhgndkataKbn pKyhgndkatakbn) {
        getPrimaryKey().setKyhgndkatakbn(pKyhgndkatakbn);
    }

    @Id
    @Column(name=GenJT_SiDetail.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJT_SiDetail.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return getPrimaryKey().getKyksyouhnrenno();
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        getPrimaryKey().setKyksyouhnrenno(pKyksyouhnrenno);
    }

    @Id
    @Column(name=GenJT_SiDetail.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    @Id
    @Column(name=GenJT_SiDetail.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_KyuuhuKbn kyuuhukbn;

    @Type(type="UserType_C_KyuuhuKbn")
    @Column(name=GenJT_SiDetail.KYUUHUKBN)
    public C_KyuuhuKbn getKyuuhukbn() {
        return kyuuhukbn;
    }

    public void setKyuuhukbn(C_KyuuhuKbn pKyuuhukbn) {
        kyuuhukbn = pKyuuhukbn;
    }

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    @Type(type="UserType_C_HokenkinsyuruiKbn")
    @Column(name=GenJT_SiDetail.HOKENKINSYURUIKBN)
    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenJT_SiDetail.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private C_UmuKbn checktaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiDetail.CHECKTAISYOUUMUKBN)
    public C_UmuKbn getChecktaisyouumukbn() {
        return checktaisyouumukbn;
    }

    public void setChecktaisyouumukbn(C_UmuKbn pChecktaisyouumukbn) {
        checktaisyouumukbn = pChecktaisyouumukbn;
    }

    private C_NitigakuHokenKngkKbn nitigakuhokenkngkkbn;

    @Type(type="UserType_C_NitigakuHokenKngkKbn")
    @Column(name=GenJT_SiDetail.NITIGAKUHOKENKNGKKBN)
    public C_NitigakuHokenKngkKbn getNitigakuhokenkngkkbn() {
        return nitigakuhokenkngkkbn;
    }

    public void setNitigakuhokenkngkkbn(C_NitigakuHokenKngkKbn pNitigakuhokenkngkkbn) {
        nitigakuhokenkngkkbn = pNitigakuhokenkngkkbn;
    }

    private BizCurrency nitigakuhokenkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNitigakuhokenkngk() {
        return nitigakuhokenkngk;
    }

    public void setNitigakuhokenkngk(BizCurrency pNitigakuhokenkngk) {
        nitigakuhokenkngk = pNitigakuhokenkngk;
        nitigakuhokenkngkValue = null;
        nitigakuhokenkngkType  = null;
    }

    transient private BigDecimal nitigakuhokenkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NITIGAKUHOKENKNGK, nullable=true)
    protected BigDecimal getNitigakuhokenkngkValue() {
        if (nitigakuhokenkngkValue == null && nitigakuhokenkngk != null) {
            if (nitigakuhokenkngk.isOptional()) return null;
            return nitigakuhokenkngk.absolute();
        }
        return nitigakuhokenkngkValue;
    }

    protected void setNitigakuhokenkngkValue(BigDecimal value) {
        nitigakuhokenkngkValue = value;
        nitigakuhokenkngk = Optional.fromNullable(toCurrencyType(nitigakuhokenkngkType))
            .transform(bizCurrencyTransformer(getNitigakuhokenkngkValue()))
            .orNull();
    }

    transient private String nitigakuhokenkngkType = null;

    @Column(name=NITIGAKUHOKENKNGK + "$", nullable=true)
    protected String getNitigakuhokenkngkType() {
        if (nitigakuhokenkngkType == null && nitigakuhokenkngk != null) return nitigakuhokenkngk.getType().toString();
        if (nitigakuhokenkngkType == null && getNitigakuhokenkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nitigakuhokenkngk$' should not be NULL."));
        }
        return nitigakuhokenkngkType;
    }

    protected void setNitigakuhokenkngkType(String type) {
        nitigakuhokenkngkType = type;
        nitigakuhokenkngk = Optional.fromNullable(toCurrencyType(nitigakuhokenkngkType))
            .transform(bizCurrencyTransformer(getNitigakuhokenkngkValue()))
            .orNull();
    }

    private Integer nissuubairitu;

    @Column(name=GenJT_SiDetail.NISSUUBAIRITU)
    public Integer getNissuubairitu() {
        return nissuubairitu;
    }

    public void setNissuubairitu(Integer pNissuubairitu) {
        nissuubairitu = pNissuubairitu;
    }

    private C_KyhkinTaniKbn kyhkintanikbn;

    @Type(type="UserType_C_KyhkinTaniKbn")
    @Column(name=GenJT_SiDetail.KYHKINTANIKBN)
    public C_KyhkinTaniKbn getKyhkintanikbn() {
        return kyhkintanikbn;
    }

    public void setKyhkintanikbn(C_KyhkinTaniKbn pKyhkintanikbn) {
        kyhkintanikbn = pKyhkintanikbn;
    }

    private BizCurrency kyhkg;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyhkg() {
        return kyhkg;
    }

    public void setKyhkg(BizCurrency pKyhkg) {
        kyhkg = pKyhkg;
        kyhkgValue = null;
        kyhkgType  = null;
    }

    transient private BigDecimal kyhkgValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYHKG, nullable=true)
    protected BigDecimal getKyhkgValue() {
        if (kyhkgValue == null && kyhkg != null) {
            if (kyhkg.isOptional()) return null;
            return kyhkg.absolute();
        }
        return kyhkgValue;
    }

    protected void setKyhkgValue(BigDecimal value) {
        kyhkgValue = value;
        kyhkg = Optional.fromNullable(toCurrencyType(kyhkgType))
            .transform(bizCurrencyTransformer(getKyhkgValue()))
            .orNull();
    }

    transient private String kyhkgType = null;

    @Column(name=KYHKG + "$", nullable=true)
    protected String getKyhkgType() {
        if (kyhkgType == null && kyhkg != null) return kyhkg.getType().toString();
        if (kyhkgType == null && getKyhkgValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyhkg$' should not be NULL."));
        }
        return kyhkgType;
    }

    protected void setKyhkgType(String type) {
        kyhkgType = type;
        kyhkg = Optional.fromNullable(toCurrencyType(kyhkgType))
            .transform(bizCurrencyTransformer(getKyhkgValue()))
            .orNull();
    }

    private BizCurrency yenkyhgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkyhgk() {
        return yenkyhgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkyhgk(BizCurrency pYenkyhgk) {
        yenkyhgk = pYenkyhgk;
        yenkyhgkValue = null;
        yenkyhgkType  = null;
    }

    transient private BigDecimal yenkyhgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKYHGK, nullable=true)
    protected BigDecimal getYenkyhgkValue() {
        if (yenkyhgkValue == null && yenkyhgk != null) {
            if (yenkyhgk.isOptional()) return null;
            return yenkyhgk.absolute();
        }
        return yenkyhgkValue;
    }

    protected void setYenkyhgkValue(BigDecimal value) {
        yenkyhgkValue = value;
        yenkyhgk = Optional.fromNullable(toCurrencyType(yenkyhgkType))
            .transform(bizCurrencyTransformer(getYenkyhgkValue()))
            .orNull();
    }

    transient private String yenkyhgkType = null;

    @Column(name=YENKYHGK + "$", nullable=true)
    protected String getYenkyhgkType() {
        if (yenkyhgkType == null && yenkyhgk != null) return yenkyhgk.getType().toString();
        if (yenkyhgkType == null && getYenkyhgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkyhgk$' should not be NULL."));
        }
        return yenkyhgkType;
    }

    protected void setYenkyhgkType(String type) {
        yenkyhgkType = type;
        yenkyhgk = Optional.fromNullable(toCurrencyType(yenkyhgkType))
            .transform(bizCurrencyTransformer(getYenkyhgkValue()))
            .orNull();
    }

    private BizCurrency sitihsyutkyumaeyenhknkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSitihsyutkyumaeyenhknkngk() {
        return sitihsyutkyumaeyenhknkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitihsyutkyumaeyenhknkngk(BizCurrency pSitihsyutkyumaeyenhknkngk) {
        sitihsyutkyumaeyenhknkngk = pSitihsyutkyumaeyenhknkngk;
        sitihsyutkyumaeyenhknkngkValue = null;
        sitihsyutkyumaeyenhknkngkType  = null;
    }

    transient private BigDecimal sitihsyutkyumaeyenhknkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK, nullable=true)
    protected BigDecimal getSitihsyutkyumaeyenhknkngkValue() {
        if (sitihsyutkyumaeyenhknkngkValue == null && sitihsyutkyumaeyenhknkngk != null) {
            if (sitihsyutkyumaeyenhknkngk.isOptional()) return null;
            return sitihsyutkyumaeyenhknkngk.absolute();
        }
        return sitihsyutkyumaeyenhknkngkValue;
    }

    protected void setSitihsyutkyumaeyenhknkngkValue(BigDecimal value) {
        sitihsyutkyumaeyenhknkngkValue = value;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    transient private String sitihsyutkyumaeyenhknkngkType = null;

    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK + "$", nullable=true)
    protected String getSitihsyutkyumaeyenhknkngkType() {
        if (sitihsyutkyumaeyenhknkngkType == null && sitihsyutkyumaeyenhknkngk != null) return sitihsyutkyumaeyenhknkngk.getType().toString();
        if (sitihsyutkyumaeyenhknkngkType == null && getSitihsyutkyumaeyenhknkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sitihsyutkyumaeyenhknkngk$' should not be NULL."));
        }
        return sitihsyutkyumaeyenhknkngkType;
    }

    protected void setSitihsyutkyumaeyenhknkngkType(String type) {
        sitihsyutkyumaeyenhknkngkType = type;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    private Integer hutanponissuu;

    @Column(name=GenJT_SiDetail.HUTANPONISSUU)
    public Integer getHutanponissuu() {
        return hutanponissuu;
    }

    public void setHutanponissuu(Integer pHutanponissuu) {
        hutanponissuu = pHutanponissuu;
    }

    private BizDate shrriyuugaitouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDetail.SHRRIYUUGAITOUYMD)
    @ValidDate
    public BizDate getShrriyuugaitouymd() {
        return shrriyuugaitouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrriyuugaitouymd(BizDate pShrriyuugaitouymd) {
        shrriyuugaitouymd = pShrriyuugaitouymd;
    }

    private C_UmuKbn hknskgnkkntgtumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiDetail.HKNSKGNKKNTGTUMUKBN)
    public C_UmuKbn getHknskgnkkntgtumukbn() {
        return hknskgnkkntgtumukbn;
    }

    public void setHknskgnkkntgtumukbn(C_UmuKbn pHknskgnkkntgtumukbn) {
        hknskgnkkntgtumukbn = pHknskgnkkntgtumukbn;
    }

    private BizNumber hokenkinshrwariai;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiDetail.HOKENKINSHRWARIAI)
    public BizNumber getHokenkinshrwariai() {
        return hokenkinshrwariai;
    }

    public void setHokenkinshrwariai(BizNumber pHokenkinshrwariai) {
        hokenkinshrwariai = pHokenkinshrwariai;
    }

    private String bikoumsg1;

    @Column(name=GenJT_SiDetail.BIKOUMSG1)
    public String getBikoumsg1() {
        return bikoumsg1;
    }

    public void setBikoumsg1(String pBikoumsg1) {
        bikoumsg1 = pBikoumsg1;
    }

    private String bikoumsg2;

    @Column(name=GenJT_SiDetail.BIKOUMSG2)
    public String getBikoumsg2() {
        return bikoumsg2;
    }

    public void setBikoumsg2(String pBikoumsg2) {
        bikoumsg2 = pBikoumsg2;
    }

    private String bikoumsg3;

    @Column(name=GenJT_SiDetail.BIKOUMSG3)
    public String getBikoumsg3() {
        return bikoumsg3;
    }

    public void setBikoumsg3(String pBikoumsg3) {
        bikoumsg3 = pBikoumsg3;
    }

    private String bikoumsg4;

    @Column(name=GenJT_SiDetail.BIKOUMSG4)
    public String getBikoumsg4() {
        return bikoumsg4;
    }

    public void setBikoumsg4(String pBikoumsg4) {
        bikoumsg4 = pBikoumsg4;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiDetail.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiDetail.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiDetail.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiDetail.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}