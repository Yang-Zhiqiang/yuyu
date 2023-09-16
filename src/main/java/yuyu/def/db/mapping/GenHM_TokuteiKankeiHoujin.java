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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.id.PKHM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.GenQHM_TokuteiKankeiHoujin;
import yuyu.def.db.meta.QHM_TokuteiKankeiHoujin;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 特定関係法人マスタ テーブルのマッピング情報クラスで、 {@link HM_TokuteiKankeiHoujin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_TokuteiKankeiHoujin}</td><td colspan="3">特定関係法人マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTkhjnkinyuucd tkhjnkinyuucd}</td><td>特定関係法人金融機関コード</td><td align="center">{@link PKHM_TokuteiKankeiHoujin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMeisaino meisaino}</td><td>明細番号</td><td align="center">{@link PKHM_TokuteiKankeiHoujin ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMarukinhyouji marukinhyouji}</td><td>マル金表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkhjnkjdrtennm tkhjnkjdrtennm}</td><td>特定関係法人漢字代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenbtno dairitenbtno}</td><td>代理店別通番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkhjnnmkj tkhjnnmkj}</td><td>特定関係法人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkhjnnmkn tkhjnnmkn}</td><td>特定関係法人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKosymd kosymd}</td><td>更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     HM_TokuteiKankeiHoujin
 * @see     PKHM_TokuteiKankeiHoujin
 * @see     QHM_TokuteiKankeiHoujin
 * @see     GenQHM_TokuteiKankeiHoujin
 */
@MappedSuperclass
@Table(name=GenHM_TokuteiKankeiHoujin.TABLE_NAME)
@IdClass(value=PKHM_TokuteiKankeiHoujin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenHM_TokuteiKankeiHoujin extends AbstractExDBEntity<HM_TokuteiKankeiHoujin, PKHM_TokuteiKankeiHoujin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_TokuteiKankeiHoujin";
    public static final String TKHJNKINYUUCD            = "tkhjnkinyuucd";
    public static final String MEISAINO                 = "meisaino";
    public static final String MARUKINHYOUJI            = "marukinhyouji";
    public static final String TKHJNKJDRTENNM           = "tkhjnkjdrtennm";
    public static final String DAIRITENBTNO             = "dairitenbtno";
    public static final String TKHJNNMKJ                = "tkhjnnmkj";
    public static final String TKHJNNMKN                = "tkhjnnmkn";
    public static final String KOSYMD                   = "kosymd";

    private final PKHM_TokuteiKankeiHoujin primaryKey;

    public GenHM_TokuteiKankeiHoujin() {
        primaryKey = new PKHM_TokuteiKankeiHoujin();
    }

    public GenHM_TokuteiKankeiHoujin(String pTkhjnkinyuucd, BizNumber pMeisaino) {
        primaryKey = new PKHM_TokuteiKankeiHoujin(pTkhjnkinyuucd, pMeisaino);
    }

    @Transient
    @Override
    public PKHM_TokuteiKankeiHoujin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_TokuteiKankeiHoujin> getMetaClass() {
        return QHM_TokuteiKankeiHoujin.class;
    }

    @Id
    @Column(name=GenHM_TokuteiKankeiHoujin.TKHJNKINYUUCD)
    @AlphaDigit
    @MaxLength(max=4)
    public String getTkhjnkinyuucd() {
        return getPrimaryKey().getTkhjnkinyuucd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhjnkinyuucd(String pTkhjnkinyuucd) {
        getPrimaryKey().setTkhjnkinyuucd(pTkhjnkinyuucd);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenHM_TokuteiKankeiHoujin.MEISAINO)
    public BizNumber getMeisaino() {
        return getPrimaryKey().getMeisaino();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMeisaino(BizNumber pMeisaino) {
        getPrimaryKey().setMeisaino(pMeisaino);
    }

    private String marukinhyouji;

    @Column(name=GenHM_TokuteiKankeiHoujin.MARUKINHYOUJI)
    public String getMarukinhyouji() {
        return marukinhyouji;
    }

    public void setMarukinhyouji(String pMarukinhyouji) {
        marukinhyouji = pMarukinhyouji;
    }

    private String tkhjnkjdrtennm;

    @Column(name=GenHM_TokuteiKankeiHoujin.TKHJNKJDRTENNM)
    public String getTkhjnkjdrtennm() {
        return tkhjnkjdrtennm;
    }

    public void setTkhjnkjdrtennm(String pTkhjnkjdrtennm) {
        tkhjnkjdrtennm = pTkhjnkjdrtennm;
    }

    private Integer dairitenbtno;

    @Column(name=GenHM_TokuteiKankeiHoujin.DAIRITENBTNO)
    public Integer getDairitenbtno() {
        return dairitenbtno;
    }

    public void setDairitenbtno(Integer pDairitenbtno) {
        dairitenbtno = pDairitenbtno;
    }

    private String tkhjnnmkj;

    @Column(name=GenHM_TokuteiKankeiHoujin.TKHJNNMKJ)
    @MaxLength(max=100)
    @InvalidCharacter
    public String getTkhjnnmkj() {
        return tkhjnnmkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTkhjnnmkj(String pTkhjnnmkj) {
        tkhjnnmkj = pTkhjnnmkj;
    }

    private String tkhjnnmkn;

    @Column(name=GenHM_TokuteiKankeiHoujin.TKHJNNMKN)
    public String getTkhjnnmkn() {
        return tkhjnnmkn;
    }

    public void setTkhjnnmkn(String pTkhjnnmkn) {
        tkhjnnmkn = pTkhjnnmkn;
    }

    private BizDate kosymd;

    @Type(type="BizDateType")
    @Column(name=GenHM_TokuteiKankeiHoujin.KOSYMD)
    public BizDate getKosymd() {
        return kosymd;
    }

    public void setKosymd(BizDate pKosymd) {
        kosymd = pKosymd;
    }
}