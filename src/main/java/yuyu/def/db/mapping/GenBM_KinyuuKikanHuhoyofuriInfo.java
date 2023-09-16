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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TapekoukanKbn;
import yuyu.def.classification.C_TsrkeisanhouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.id.PKBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.GenQBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.QBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.type.UserType_C_TapekoukanKbn;
import yuyu.def.db.type.UserType_C_TsrkeisanhouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 金融機関普保預振情報マスタ テーブルのマッピング情報クラスで、 {@link BM_KinyuuKikanHuhoyofuriInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KinyuuKikanHuhoyofuriInfo}</td><td colspan="3">金融機関普保預振情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">{@link PKBM_KinyuuKikanHuhoyofuriInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYofurikyouteikaisiymd yofurikyouteikaisiymd}</td><td>預振協定開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYofurikyouteikaijyoymd yofurikyouteikaijyoymd}</td><td>預振協定解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItakusyakinyuucd itakusyakinyuucd}</td><td>委託者金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakusyasitencd itakusyasitencd}</td><td>委託者支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakusyayokinkbn itakusyayokinkbn}</td><td>委託者預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getItakusyakouzano itakusyakouzano}</td><td>委託者口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrkeisanhoukbn tsrkeisanhoukbn}</td><td>手数料計算方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsrkeisanhouKbn}</td></tr>
 *  <tr><td>{@link #getKinyuutesuuryou kinyuutesuuryou}</td><td>金融機関手数料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getItakusyacd itakusyacd}</td><td>委託者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTapekoukankbn1 tapekoukankbn1}</td><td>テープ交換区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TapekoukanKbn}</td></tr>
 *  <tr><td>{@link #getMdsisyacd mdsisyacd}</td><td>窓口支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZzkkyouteikaisiymd zzkkyouteikaisiymd}</td><td>全税共協定開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZzkkyouteikaijyoymd zzkkyouteikaijyoymd}</td><td>全税共協定解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCsskyouteikaisiymd csskyouteikaisiymd}</td><td>ＣＳＳ協定開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCsskyouteikaijyoymd csskyouteikaijyoymd}</td><td>ＣＳＳ協定解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHuhoyofuriinfokousinymd huhoyofuriinfokousinymd}</td><td>普保預振情報更新年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BM_KinyuuKikanHuhoyofuriInfo
 * @see     PKBM_KinyuuKikanHuhoyofuriInfo
 * @see     QBM_KinyuuKikanHuhoyofuriInfo
 * @see     GenQBM_KinyuuKikanHuhoyofuriInfo
 */
@MappedSuperclass
@Table(name=GenBM_KinyuuKikanHuhoyofuriInfo.TABLE_NAME)
@IdClass(value=PKBM_KinyuuKikanHuhoyofuriInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_TapekoukanKbn", typeClass=UserType_C_TapekoukanKbn.class),
    @TypeDef(name="UserType_C_TsrkeisanhouKbn", typeClass=UserType_C_TsrkeisanhouKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenBM_KinyuuKikanHuhoyofuriInfo extends AbstractExDBEntity<BM_KinyuuKikanHuhoyofuriInfo, PKBM_KinyuuKikanHuhoyofuriInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KinyuuKikanHuhoyofuriInfo";
    public static final String BANKCD                   = "bankcd";
    public static final String YOFURIKYOUTEIKAISIYMD    = "yofurikyouteikaisiymd";
    public static final String YOFURIKYOUTEIKAIJYOYMD   = "yofurikyouteikaijyoymd";
    public static final String ITAKUSYAKINYUUCD         = "itakusyakinyuucd";
    public static final String ITAKUSYASITENCD          = "itakusyasitencd";
    public static final String ITAKUSYAYOKINKBN         = "itakusyayokinkbn";
    public static final String ITAKUSYAKOUZANO          = "itakusyakouzano";
    public static final String TSRKEISANHOUKBN          = "tsrkeisanhoukbn";
    public static final String KINYUUTESUURYOU          = "kinyuutesuuryou";
    public static final String ITAKUSYACD               = "itakusyacd";
    public static final String TAPEKOUKANKBN1           = "tapekoukankbn1";
    public static final String MDSISYACD                = "mdsisyacd";
    public static final String ZZKKYOUTEIKAISIYMD       = "zzkkyouteikaisiymd";
    public static final String ZZKKYOUTEIKAIJYOYMD      = "zzkkyouteikaijyoymd";
    public static final String CSSKYOUTEIKAISIYMD       = "csskyouteikaisiymd";
    public static final String CSSKYOUTEIKAIJYOYMD      = "csskyouteikaijyoymd";
    public static final String HUHOYOFURIINFOKOUSINYMD  = "huhoyofuriinfokousinymd";

    private final PKBM_KinyuuKikanHuhoyofuriInfo primaryKey;

    public GenBM_KinyuuKikanHuhoyofuriInfo() {
        primaryKey = new PKBM_KinyuuKikanHuhoyofuriInfo();
    }

    public GenBM_KinyuuKikanHuhoyofuriInfo(String pBankcd) {
        primaryKey = new PKBM_KinyuuKikanHuhoyofuriInfo(pBankcd);
    }

    @Transient
    @Override
    public PKBM_KinyuuKikanHuhoyofuriInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KinyuuKikanHuhoyofuriInfo> getMetaClass() {
        return QBM_KinyuuKikanHuhoyofuriInfo.class;
    }

    @Id
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return getPrimaryKey().getBankcd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        getPrimaryKey().setBankcd(pBankcd);
    }

    private BizDate yofurikyouteikaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.YOFURIKYOUTEIKAISIYMD)
    public BizDate getYofurikyouteikaisiymd() {
        return yofurikyouteikaisiymd;
    }

    public void setYofurikyouteikaisiymd(BizDate pYofurikyouteikaisiymd) {
        yofurikyouteikaisiymd = pYofurikyouteikaisiymd;
    }

    private BizDate yofurikyouteikaijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.YOFURIKYOUTEIKAIJYOYMD)
    public BizDate getYofurikyouteikaijyoymd() {
        return yofurikyouteikaijyoymd;
    }

    public void setYofurikyouteikaijyoymd(BizDate pYofurikyouteikaijyoymd) {
        yofurikyouteikaijyoymd = pYofurikyouteikaijyoymd;
    }

    private String itakusyakinyuucd;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ITAKUSYAKINYUUCD)
    public String getItakusyakinyuucd() {
        return itakusyakinyuucd;
    }

    public void setItakusyakinyuucd(String pItakusyakinyuucd) {
        itakusyakinyuucd = pItakusyakinyuucd;
    }

    private String itakusyasitencd;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ITAKUSYASITENCD)
    public String getItakusyasitencd() {
        return itakusyasitencd;
    }

    public void setItakusyasitencd(String pItakusyasitencd) {
        itakusyasitencd = pItakusyasitencd;
    }

    private C_YokinKbn itakusyayokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ITAKUSYAYOKINKBN)
    public C_YokinKbn getItakusyayokinkbn() {
        return itakusyayokinkbn;
    }

    public void setItakusyayokinkbn(C_YokinKbn pItakusyayokinkbn) {
        itakusyayokinkbn = pItakusyayokinkbn;
    }

    private String itakusyakouzano;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ITAKUSYAKOUZANO)
    public String getItakusyakouzano() {
        return itakusyakouzano;
    }

    public void setItakusyakouzano(String pItakusyakouzano) {
        itakusyakouzano = pItakusyakouzano;
    }

    private C_TsrkeisanhouKbn tsrkeisanhoukbn;

    @Type(type="UserType_C_TsrkeisanhouKbn")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.TSRKEISANHOUKBN)
    public C_TsrkeisanhouKbn getTsrkeisanhoukbn() {
        return tsrkeisanhoukbn;
    }

    public void setTsrkeisanhoukbn(C_TsrkeisanhouKbn pTsrkeisanhoukbn) {
        tsrkeisanhoukbn = pTsrkeisanhoukbn;
    }

    private Integer kinyuutesuuryou;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.KINYUUTESUURYOU)
    public Integer getKinyuutesuuryou() {
        return kinyuutesuuryou;
    }

    public void setKinyuutesuuryou(Integer pKinyuutesuuryou) {
        kinyuutesuuryou = pKinyuutesuuryou;
    }

    private String itakusyacd;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ITAKUSYACD)
    public String getItakusyacd() {
        return itakusyacd;
    }

    public void setItakusyacd(String pItakusyacd) {
        itakusyacd = pItakusyacd;
    }

    private C_TapekoukanKbn tapekoukankbn1;

    @Type(type="UserType_C_TapekoukanKbn")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.TAPEKOUKANKBN1)
    public C_TapekoukanKbn getTapekoukankbn1() {
        return tapekoukankbn1;
    }

    public void setTapekoukankbn1(C_TapekoukanKbn pTapekoukankbn1) {
        tapekoukankbn1 = pTapekoukankbn1;
    }

    private String mdsisyacd;

    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.MDSISYACD)
    public String getMdsisyacd() {
        return mdsisyacd;
    }

    public void setMdsisyacd(String pMdsisyacd) {
        mdsisyacd = pMdsisyacd;
    }

    private BizDate zzkkyouteikaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ZZKKYOUTEIKAISIYMD)
    public BizDate getZzkkyouteikaisiymd() {
        return zzkkyouteikaisiymd;
    }

    public void setZzkkyouteikaisiymd(BizDate pZzkkyouteikaisiymd) {
        zzkkyouteikaisiymd = pZzkkyouteikaisiymd;
    }

    private BizDate zzkkyouteikaijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.ZZKKYOUTEIKAIJYOYMD)
    public BizDate getZzkkyouteikaijyoymd() {
        return zzkkyouteikaijyoymd;
    }

    public void setZzkkyouteikaijyoymd(BizDate pZzkkyouteikaijyoymd) {
        zzkkyouteikaijyoymd = pZzkkyouteikaijyoymd;
    }

    private BizDate csskyouteikaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.CSSKYOUTEIKAISIYMD)
    public BizDate getCsskyouteikaisiymd() {
        return csskyouteikaisiymd;
    }

    public void setCsskyouteikaisiymd(BizDate pCsskyouteikaisiymd) {
        csskyouteikaisiymd = pCsskyouteikaisiymd;
    }

    private BizDate csskyouteikaijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.CSSKYOUTEIKAIJYOYMD)
    public BizDate getCsskyouteikaijyoymd() {
        return csskyouteikaijyoymd;
    }

    public void setCsskyouteikaijyoymd(BizDate pCsskyouteikaijyoymd) {
        csskyouteikaijyoymd = pCsskyouteikaijyoymd;
    }

    private BizDate huhoyofuriinfokousinymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_KinyuuKikanHuhoyofuriInfo.HUHOYOFURIINFOKOUSINYMD)
    public BizDate getHuhoyofuriinfokousinymd() {
        return huhoyofuriinfokousinymd;
    }

    public void setHuhoyofuriinfokousinymd(BizDate pHuhoyofuriinfokousinymd) {
        huhoyofuriinfokousinymd = pHuhoyofuriinfokousinymd;
    }
}