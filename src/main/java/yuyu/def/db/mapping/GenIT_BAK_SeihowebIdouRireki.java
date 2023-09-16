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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_SeihowebIdouRireki;
import yuyu.def.db.id.PKIT_BAK_SeihowebIdouRireki;
import yuyu.def.db.meta.GenQIT_BAK_SeihowebIdouRireki;
import yuyu.def.db.meta.QIT_BAK_SeihowebIdouRireki;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 生保Ｗｅｂ用異動履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_SeihowebIdouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_SeihowebIdouRireki}</td><td colspan="3">生保Ｗｅｂ用異動履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_SeihowebIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_SeihowebIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_SeihowebIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_SeihowebIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdouhasseiym idouhasseiym}</td><td>異動発生年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getIdouhasseiymd idouhasseiymd}</td><td>異動発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeihowebidoukbnnaiyou1 seihowebidoukbnnaiyou1}</td><td>生保Ｗｅｂ異動区分内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeihowebidoukbnnaiyou2 seihowebidoukbnnaiyou2}</td><td>生保Ｗｅｂ異動区分内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd1 bosyuucd1}</td><td>募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenbunumu drtenbunumu}</td><td>代理店分担有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd2 bosyuucd2}</td><td>募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_SeihowebIdouRireki
 * @see     PKIT_BAK_SeihowebIdouRireki
 * @see     QIT_BAK_SeihowebIdouRireki
 * @see     GenQIT_BAK_SeihowebIdouRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_SeihowebIdouRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_SeihowebIdouRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_SeihowebIdouRireki extends AbstractExDBEntity<IT_BAK_SeihowebIdouRireki, PKIT_BAK_SeihowebIdouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_SeihowebIdouRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String IDOUHASSEIYM             = "idouhasseiym";
    public static final String IDOUHASSEIYMD            = "idouhasseiymd";
    public static final String SEIHOWEBIDOUKBNNAIYOU1   = "seihowebidoukbnnaiyou1";
    public static final String SEIHOWEBIDOUKBNNAIYOU2   = "seihowebidoukbnnaiyou2";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String BOSYUUCD1                = "bosyuucd1";
    public static final String DRTENBUNUMU              = "drtenbunumu";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String BOSYUUCD2                = "bosyuucd2";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String CIFCD                    = "cifcd";
    public static final String BANKCD                   = "bankcd";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKYMD                   = "kykymd";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_SeihowebIdouRireki primaryKey;

    public GenIT_BAK_SeihowebIdouRireki() {
        primaryKey = new PKIT_BAK_SeihowebIdouRireki();
    }

    public GenIT_BAK_SeihowebIdouRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_SeihowebIdouRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_SeihowebIdouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_SeihowebIdouRireki> getMetaClass() {
        return QIT_BAK_SeihowebIdouRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_SeihowebIdouRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_SeihowebIdouRireki.SYONO)
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
    @Column(name=GenIT_BAK_SeihowebIdouRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_SeihowebIdouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDateYM idouhasseiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.IDOUHASSEIYM)
    public BizDateYM getIdouhasseiym() {
        return idouhasseiym;
    }

    public void setIdouhasseiym(BizDateYM pIdouhasseiym) {
        idouhasseiym = pIdouhasseiym;
    }

    private BizDate idouhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.IDOUHASSEIYMD)
    public BizDate getIdouhasseiymd() {
        return idouhasseiymd;
    }

    public void setIdouhasseiymd(BizDate pIdouhasseiymd) {
        idouhasseiymd = pIdouhasseiymd;
    }

    private String seihowebidoukbnnaiyou1;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.SEIHOWEBIDOUKBNNAIYOU1)
    public String getSeihowebidoukbnnaiyou1() {
        return seihowebidoukbnnaiyou1;
    }

    public void setSeihowebidoukbnnaiyou1(String pSeihowebidoukbnnaiyou1) {
        seihowebidoukbnnaiyou1 = pSeihowebidoukbnnaiyou1;
    }

    private String seihowebidoukbnnaiyou2;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.SEIHOWEBIDOUKBNNAIYOU2)
    public String getSeihowebidoukbnnaiyou2() {
        return seihowebidoukbnnaiyou2;
    }

    public void setSeihowebidoukbnnaiyou2(String pSeihowebidoukbnnaiyou2) {
        seihowebidoukbnnaiyou2 = pSeihowebidoukbnnaiyou2;
    }

    private String dairitencd1;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String bosyuucd1;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.BOSYUUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    private C_UmuKbn drtenbunumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.DRTENBUNUMU)
    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        drtenbunumu = pDrtenbunumu;
    }

    private String dairitencd2;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String bosyuucd2;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.BOSYUUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private String cifcd;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String bankcd;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private String kyknmkj;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private String syouhncd;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.SYOUHNCD)
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

    private Integer syouhnsdno;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_SeihowebIdouRireki.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_SeihowebIdouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}