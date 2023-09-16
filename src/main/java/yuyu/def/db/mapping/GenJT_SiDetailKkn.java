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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_SensinItijikinShrUmuKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrtaisyouKbn;
import yuyu.def.classification.C_SyujyutuHousiki;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiDetailKkn;
import yuyu.def.db.id.PKJT_SiDetailKkn;
import yuyu.def.db.meta.GenQJT_SiDetailKkn;
import yuyu.def.db.meta.QJT_SiDetailKkn;
import yuyu.def.db.type.UserType_C_3daiSippeiHknShrRiyuuKbn;
import yuyu.def.db.type.UserType_C_HushrSyousaiKbn;
import yuyu.def.db.type.UserType_C_SensinItijikinShrUmuKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_ShrtaisyouKbn;
import yuyu.def.db.type.UserType_C_SyujyutuHousiki;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払明細期間テーブル テーブルのマッピング情報クラスで、 {@link JT_SiDetailKkn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiDetailKkn}</td><td colspan="3">支払明細期間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRenno2keta2 renno2keta2}</td><td>連番（２桁）２</td><td align="center">{@link PKJT_SiDetailKkn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrtaisyoukbn shrtaisyoukbn}</td><td>支払対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrtaisyouKbn}</td></tr>
 *  <tr><td>{@link #getTaisyoukknfrom taisyoukknfrom}</td><td>対象期間（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyoukknto taisyoukknto}</td><td>対象期間（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuukknfrom seikyuukknfrom}</td><td>請求期間（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuukknto seikyuukknto}</td><td>請求期間（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyututourokuno syujyututourokuno}</td><td>手術登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd1 kjcd1}</td><td>Ｋ・Ｊコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd2 kjcd2}</td><td>Ｋ・Ｊコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjcd3 kjcd3}</td><td>Ｋ・Ｊコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkn syujyutunmkn}</td><td>手術名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutunmkj syujyutunmkj}</td><td>手術名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyouken jyouken}</td><td>条件</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutubunruicd syujyutubunruicd}</td><td>手術分類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyutuhousiki syujyutuhousiki}</td><td>手術方式</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyujyutuHousiki}</td></tr>
 *  <tr><td>{@link #getSensingijuturyou sensingijuturyou}</td><td>先進医療技術料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSensinitijikinshrumukbn sensinitijikinshrumukbn}</td><td>先進医療一時金支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SensinItijikinShrUmuKbn}</td></tr>
 *  <tr><td>{@link #getSandaisippeihknshrriyuukbn sandaisippeihknshrriyuukbn}</td><td>３大疾病保険金支払理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_3daiSippeiHknShrRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHushrsyousaikbn hushrsyousaikbn}</td><td>不支払詳細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HushrSyousaiKbn}</td></tr>
 *  <tr><td>{@link #getHutanpoflg hutanpoflg}</td><td>不担保フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getItinyuuingendotyoukaflg itinyuuingendotyoukaflg}</td><td>1入院限度超過フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuusangendotyoukaflg tuusangendotyoukaflg}</td><td>通算限度超過フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGannyuuinflg gannyuuinflg}</td><td>がん入院フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNyuuintyuuflg nyuuintyuuflg}</td><td>入院中フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyhknskgnkkntaisyouumukbn kyhknskgnkkntaisyouumukbn}</td><td>給付金削減期間対象有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiDetailKkn
 * @see     PKJT_SiDetailKkn
 * @see     QJT_SiDetailKkn
 * @see     GenQJT_SiDetailKkn
 */
@MappedSuperclass
@Table(name=GenJT_SiDetailKkn.TABLE_NAME)
@IdClass(value=PKJT_SiDetailKkn.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_3daiSippeiHknShrRiyuuKbn", typeClass=UserType_C_3daiSippeiHknShrRiyuuKbn.class),
    @TypeDef(name="UserType_C_HushrSyousaiKbn", typeClass=UserType_C_HushrSyousaiKbn.class),
    @TypeDef(name="UserType_C_SensinItijikinShrUmuKbn", typeClass=UserType_C_SensinItijikinShrUmuKbn.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_ShrtaisyouKbn", typeClass=UserType_C_ShrtaisyouKbn.class),
    @TypeDef(name="UserType_C_SyujyutuHousiki", typeClass=UserType_C_SyujyutuHousiki.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SiDetailKkn extends AbstractExDBEntity<JT_SiDetailKkn, PKJT_SiDetailKkn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiDetailKkn";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String UKETUKENO                = "uketukeno";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String RENNO                    = "renno";
    public static final String RENNO2KETA2              = "renno2keta2";
    public static final String SHRTAISYOUKBN            = "shrtaisyoukbn";
    public static final String TAISYOUKKNFROM           = "taisyoukknfrom";
    public static final String TAISYOUKKNTO             = "taisyoukknto";
    public static final String SEIKYUUKKNFROM           = "seikyuukknfrom";
    public static final String SEIKYUUKKNTO             = "seikyuukknto";
    public static final String SYUJYUTUTOUROKUNO        = "syujyututourokuno";
    public static final String KJCD1                    = "kjcd1";
    public static final String KJCD2                    = "kjcd2";
    public static final String KJCD3                    = "kjcd3";
    public static final String SYUJYUTUNMKN             = "syujyutunmkn";
    public static final String SYUJYUTUNMKJ             = "syujyutunmkj";
    public static final String JYOUKEN                  = "jyouken";
    public static final String SYUJYUTUBUNRUICD         = "syujyutubunruicd";
    public static final String SYUJYUTUHOUSIKI          = "syujyutuhousiki";
    public static final String SENSINGIJUTURYOU         = "sensingijuturyou";
    public static final String SENSINITIJIKINSHRUMUKBN  = "sensinitijikinshrumukbn";
    public static final String SANDAISIPPEIHKNSHRRIYUUKBN = "sandaisippeihknshrriyuukbn";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String HUSHRSYOUSAIKBN          = "hushrsyousaikbn";
    public static final String HUTANPOFLG               = "hutanpoflg";
    public static final String ITINYUUINGENDOTYOUKAFLG  = "itinyuuingendotyoukaflg";
    public static final String TUUSANGENDOTYOUKAFLG     = "tuusangendotyoukaflg";
    public static final String GANNYUUINFLG             = "gannyuuinflg";
    public static final String NYUUINTYUUFLG            = "nyuuintyuuflg";
    public static final String KYHKNSKGNKKNTAISYOUUMUKBN = "kyhknskgnkkntaisyouumukbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiDetailKkn primaryKey;

    public GenJT_SiDetailKkn() {
        primaryKey = new PKJT_SiDetailKkn();
    }

    public GenJT_SiDetailKkn(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        String pKyuuhucd,
        Integer pRenno,
        Integer pRenno2keta2
    ) {
        primaryKey = new PKJT_SiDetailKkn(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pUketukeno,
            pKyuuhucd,
            pRenno,
            pRenno2keta2
        );
    }

    @Transient
    @Override
    public PKJT_SiDetailKkn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiDetailKkn> getMetaClass() {
        return QJT_SiDetailKkn.class;
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.SYONO)
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
    @Column(name=GenJT_SiDetailKkn.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.UKETUKENO)
    public Integer getUketukeno() {
        return getPrimaryKey().getUketukeno();
    }

    public void setUketukeno(Integer pUketukeno) {
        getPrimaryKey().setUketukeno(pUketukeno);
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    @Id
    @Column(name=GenJT_SiDetailKkn.RENNO2KETA2)
    public Integer getRenno2keta2() {
        return getPrimaryKey().getRenno2keta2();
    }

    public void setRenno2keta2(Integer pRenno2keta2) {
        getPrimaryKey().setRenno2keta2(pRenno2keta2);
    }

    private C_ShrtaisyouKbn shrtaisyoukbn;

    @Type(type="UserType_C_ShrtaisyouKbn")
    @Column(name=GenJT_SiDetailKkn.SHRTAISYOUKBN)
    public C_ShrtaisyouKbn getShrtaisyoukbn() {
        return shrtaisyoukbn;
    }

    public void setShrtaisyoukbn(C_ShrtaisyouKbn pShrtaisyoukbn) {
        shrtaisyoukbn = pShrtaisyoukbn;
    }

    private BizDate taisyoukknfrom;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDetailKkn.TAISYOUKKNFROM)
    @ValidDate
    public BizDate getTaisyoukknfrom() {
        return taisyoukknfrom;
    }

    public void setTaisyoukknfrom(BizDate pTaisyoukknfrom) {
        taisyoukknfrom = pTaisyoukknfrom;
    }

    private BizDate taisyoukknto;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDetailKkn.TAISYOUKKNTO)
    @ValidDate
    public BizDate getTaisyoukknto() {
        return taisyoukknto;
    }

    public void setTaisyoukknto(BizDate pTaisyoukknto) {
        taisyoukknto = pTaisyoukknto;
    }

    private BizDate seikyuukknfrom;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDetailKkn.SEIKYUUKKNFROM)
    public BizDate getSeikyuukknfrom() {
        return seikyuukknfrom;
    }

    public void setSeikyuukknfrom(BizDate pSeikyuukknfrom) {
        seikyuukknfrom = pSeikyuukknfrom;
    }

    private BizDate seikyuukknto;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiDetailKkn.SEIKYUUKKNTO)
    public BizDate getSeikyuukknto() {
        return seikyuukknto;
    }

    public void setSeikyuukknto(BizDate pSeikyuukknto) {
        seikyuukknto = pSeikyuukknto;
    }

    private String syujyututourokuno;

    @Column(name=GenJT_SiDetailKkn.SYUJYUTUTOUROKUNO)
    public String getSyujyututourokuno() {
        return syujyututourokuno;
    }

    public void setSyujyututourokuno(String pSyujyututourokuno) {
        syujyututourokuno = pSyujyututourokuno;
    }

    private String kjcd1;

    @Column(name=GenJT_SiDetailKkn.KJCD1)
    public String getKjcd1() {
        return kjcd1;
    }

    public void setKjcd1(String pKjcd1) {
        kjcd1 = pKjcd1;
    }

    private String kjcd2;

    @Column(name=GenJT_SiDetailKkn.KJCD2)
    public String getKjcd2() {
        return kjcd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd2(String pKjcd2) {
        kjcd2 = pKjcd2;
    }

    private String kjcd3;

    @Column(name=GenJT_SiDetailKkn.KJCD3)
    public String getKjcd3() {
        return kjcd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKjcd3(String pKjcd3) {
        kjcd3 = pKjcd3;
    }

    private String syujyutunmkn;

    @Column(name=GenJT_SiDetailKkn.SYUJYUTUNMKN)
    public String getSyujyutunmkn() {
        return syujyutunmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkn(String pSyujyutunmkn) {
        syujyutunmkn = pSyujyutunmkn;
    }

    private String syujyutunmkj;

    @Column(name=GenJT_SiDetailKkn.SYUJYUTUNMKJ)
    public String getSyujyutunmkj() {
        return syujyutunmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyujyutunmkj(String pSyujyutunmkj) {
        syujyutunmkj = pSyujyutunmkj;
    }

    private String jyouken;

    @Column(name=GenJT_SiDetailKkn.JYOUKEN)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getJyouken() {
        return jyouken;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setJyouken(String pJyouken) {
        jyouken = pJyouken;
    }

    private String syujyutubunruicd;

    @Column(name=GenJT_SiDetailKkn.SYUJYUTUBUNRUICD)
    @MaxLength(max=3)
    @AlphaDigit
    @SingleByteStrings
    public String getSyujyutubunruicd() {
        return syujyutubunruicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyujyutubunruicd(String pSyujyutubunruicd) {
        syujyutubunruicd = pSyujyutubunruicd;
    }

    private C_SyujyutuHousiki syujyutuhousiki;

    @Type(type="UserType_C_SyujyutuHousiki")
    @Column(name=GenJT_SiDetailKkn.SYUJYUTUHOUSIKI)
    public C_SyujyutuHousiki getSyujyutuhousiki() {
        return syujyutuhousiki;
    }

    public void setSyujyutuhousiki(C_SyujyutuHousiki pSyujyutuhousiki) {
        syujyutuhousiki = pSyujyutuhousiki;
    }

    private BizCurrency sensingijuturyou;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=11)
    @PositiveNumberBizCalcble
    public BizCurrency getSensingijuturyou() {
        return sensingijuturyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSensingijuturyou(BizCurrency pSensingijuturyou) {
        sensingijuturyou = pSensingijuturyou;
        sensingijuturyouValue = null;
        sensingijuturyouType  = null;
    }

    transient private BigDecimal sensingijuturyouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SENSINGIJUTURYOU, nullable=true)
    protected BigDecimal getSensingijuturyouValue() {
        if (sensingijuturyouValue == null && sensingijuturyou != null) {
            if (sensingijuturyou.isOptional()) return null;
            return sensingijuturyou.absolute();
        }
        return sensingijuturyouValue;
    }

    protected void setSensingijuturyouValue(BigDecimal value) {
        sensingijuturyouValue = value;
        sensingijuturyou = Optional.fromNullable(toCurrencyType(sensingijuturyouType))
            .transform(bizCurrencyTransformer(getSensingijuturyouValue()))
            .orNull();
    }

    transient private String sensingijuturyouType = null;

    @Column(name=SENSINGIJUTURYOU + "$", nullable=true)
    protected String getSensingijuturyouType() {
        if (sensingijuturyouType == null && sensingijuturyou != null) return sensingijuturyou.getType().toString();
        if (sensingijuturyouType == null && getSensingijuturyouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sensingijuturyou$' should not be NULL."));
        }
        return sensingijuturyouType;
    }

    protected void setSensingijuturyouType(String type) {
        sensingijuturyouType = type;
        sensingijuturyou = Optional.fromNullable(toCurrencyType(sensingijuturyouType))
            .transform(bizCurrencyTransformer(getSensingijuturyouValue()))
            .orNull();
    }

    private C_SensinItijikinShrUmuKbn sensinitijikinshrumukbn;

    @Type(type="UserType_C_SensinItijikinShrUmuKbn")
    @Column(name=GenJT_SiDetailKkn.SENSINITIJIKINSHRUMUKBN)
    public C_SensinItijikinShrUmuKbn getSensinitijikinshrumukbn() {
        return sensinitijikinshrumukbn;
    }

    public void setSensinitijikinshrumukbn(C_SensinItijikinShrUmuKbn pSensinitijikinshrumukbn) {
        sensinitijikinshrumukbn = pSensinitijikinshrumukbn;
    }

    private C_3daiSippeiHknShrRiyuuKbn sandaisippeihknshrriyuukbn;

    @Type(type="UserType_C_3daiSippeiHknShrRiyuuKbn")
    @Column(name=GenJT_SiDetailKkn.SANDAISIPPEIHKNSHRRIYUUKBN)
    public C_3daiSippeiHknShrRiyuuKbn getSandaisippeihknshrriyuukbn() {
        return sandaisippeihknshrriyuukbn;
    }

    public void setSandaisippeihknshrriyuukbn(C_3daiSippeiHknShrRiyuuKbn pSandaisippeihknshrriyuukbn) {
        sandaisippeihknshrriyuukbn = pSandaisippeihknshrriyuukbn;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJT_SiDetailKkn.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private C_HushrSyousaiKbn hushrsyousaikbn;

    @Type(type="UserType_C_HushrSyousaiKbn")
    @Column(name=GenJT_SiDetailKkn.HUSHRSYOUSAIKBN)
    public C_HushrSyousaiKbn getHushrsyousaikbn() {
        return hushrsyousaikbn;
    }

    public void setHushrsyousaikbn(C_HushrSyousaiKbn pHushrsyousaikbn) {
        hushrsyousaikbn = pHushrsyousaikbn;
    }

    private Integer hutanpoflg;

    @Column(name=GenJT_SiDetailKkn.HUTANPOFLG)
    public Integer getHutanpoflg() {
        return hutanpoflg;
    }

    public void setHutanpoflg(Integer pHutanpoflg) {
        hutanpoflg = pHutanpoflg;
    }

    private Integer itinyuuingendotyoukaflg;

    @Column(name=GenJT_SiDetailKkn.ITINYUUINGENDOTYOUKAFLG)
    public Integer getItinyuuingendotyoukaflg() {
        return itinyuuingendotyoukaflg;
    }

    public void setItinyuuingendotyoukaflg(Integer pItinyuuingendotyoukaflg) {
        itinyuuingendotyoukaflg = pItinyuuingendotyoukaflg;
    }

    private Integer tuusangendotyoukaflg;

    @Column(name=GenJT_SiDetailKkn.TUUSANGENDOTYOUKAFLG)
    public Integer getTuusangendotyoukaflg() {
        return tuusangendotyoukaflg;
    }

    public void setTuusangendotyoukaflg(Integer pTuusangendotyoukaflg) {
        tuusangendotyoukaflg = pTuusangendotyoukaflg;
    }

    private Integer gannyuuinflg;

    @Column(name=GenJT_SiDetailKkn.GANNYUUINFLG)
    public Integer getGannyuuinflg() {
        return gannyuuinflg;
    }

    public void setGannyuuinflg(Integer pGannyuuinflg) {
        gannyuuinflg = pGannyuuinflg;
    }

    private C_UmuKbn nyuuintyuuflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiDetailKkn.NYUUINTYUUFLG)
    public C_UmuKbn getNyuuintyuuflg() {
        return nyuuintyuuflg;
    }

    public void setNyuuintyuuflg(C_UmuKbn pNyuuintyuuflg) {
        nyuuintyuuflg = pNyuuintyuuflg;
    }

    private C_UmuKbn kyhknskgnkkntaisyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiDetailKkn.KYHKNSKGNKKNTAISYOUUMUKBN)
    public C_UmuKbn getKyhknskgnkkntaisyouumukbn() {
        return kyhknskgnkkntaisyouumukbn;
    }

    public void setKyhknskgnkkntaisyouumukbn(C_UmuKbn pKyhknskgnkkntaisyouumukbn) {
        kyhknskgnkkntaisyouumukbn = pKyhknskgnkkntaisyouumukbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_SiDetailKkn.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SiDetailKkn.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiDetailKkn.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiDetailKkn.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}