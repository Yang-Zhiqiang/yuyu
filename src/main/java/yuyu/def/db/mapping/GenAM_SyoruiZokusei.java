package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NengetuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.id.PKAM_SyoruiZokusei;
import yuyu.def.db.meta.GenQAM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;
import yuyu.def.db.type.UserType_C_NengetuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_YesNoKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 書類属性マスタ テーブルのマッピング情報クラスで、 {@link AM_SyoruiZokusei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_SyoruiZokusei}</td><td colspan="3">書類属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKAM_SyoruiZokusei ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSyoruinm syoruinm}</td><td>書類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruinmryaku syoruinmryaku}</td><td>書類名（略称）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouid tyouhyouid}</td><td>帳票フォームＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNengetukbn nengetukbn}</td><td>年月区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NengetuKbn}</td></tr>
 *  <tr><td>{@link #getAngoukaKbn angoukaKbn}</td><td>暗号化区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getPdfHozonKbn pdfHozonKbn}</td><td>ＰＤＦ保存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getZipHozonKbn zipHozonKbn}</td><td>ＺＩＰ保存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getPageCount pageCount}</td><td>ページ数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKensakuKey1 kensakuKey1}</td><td>検索キー１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey2 kensakuKey2}</td><td>検索キー２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey3 kensakuKey3}</td><td>検索キー３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey4 kensakuKey4}</td><td>検索キー４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey5 kensakuKey5}</td><td>検索キー５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_SyoruiZokusei
 * @see     PKAM_SyoruiZokusei
 * @see     QAM_SyoruiZokusei
 * @see     GenQAM_SyoruiZokusei
 */
@MappedSuperclass
@Table(name=GenAM_SyoruiZokusei.TABLE_NAME)
@IdClass(value=PKAM_SyoruiZokusei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NengetuKbn", typeClass=UserType_C_NengetuKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_YesNoKbn", typeClass=UserType_C_YesNoKbn.class)
})
public abstract class GenAM_SyoruiZokusei extends AbstractExDBEntity<AM_SyoruiZokusei, PKAM_SyoruiZokusei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_SyoruiZokusei";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SYORUINM                 = "syoruinm";
    public static final String SYORUINMRYAKU            = "syoruinmryaku";
    public static final String TYOUHYOUID               = "tyouhyouid";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String NENGETUKBN               = "nengetukbn";
    public static final String ANGOUKAKBN               = "angoukaKbn";
    public static final String PDFHOZONKBN              = "pdfHozonKbn";
    public static final String ZIPHOZONKBN              = "zipHozonKbn";
    public static final String PAGECOUNT                = "pageCount";
    public static final String SORTNO                   = "sortNo";
    public static final String KENSAKUKEY1              = "kensakuKey1";
    public static final String KENSAKUKEY2              = "kensakuKey2";
    public static final String KENSAKUKEY3              = "kensakuKey3";
    public static final String KENSAKUKEY4              = "kensakuKey4";
    public static final String KENSAKUKEY5              = "kensakuKey5";

    private final PKAM_SyoruiZokusei primaryKey;

    public GenAM_SyoruiZokusei() {
        primaryKey = new PKAM_SyoruiZokusei();
    }

    public GenAM_SyoruiZokusei(C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKAM_SyoruiZokusei(pSyoruiCd);
    }

    @Transient
    @Override
    public PKAM_SyoruiZokusei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_SyoruiZokusei> getMetaClass() {
        return QAM_SyoruiZokusei.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenAM_SyoruiZokusei.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private String syoruinm;

    @Column(name=GenAM_SyoruiZokusei.SYORUINM)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoruinm() {
        return syoruinm;
    }

    @Trim("both")
    public void setSyoruinm(String pSyoruinm) {
        syoruinm = pSyoruinm;
    }

    private String syoruinmryaku;

    @Column(name=GenAM_SyoruiZokusei.SYORUINMRYAKU)
    @MaxLength(max=10)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoruinmryaku() {
        return syoruinmryaku;
    }

    public void setSyoruinmryaku(String pSyoruinmryaku) {
        syoruinmryaku = pSyoruinmryaku;
    }

    private String tyouhyouid;

    @Column(name=GenAM_SyoruiZokusei.TYOUHYOUID)
    @MaxLength(max=30)
    public String getTyouhyouid() {
        return tyouhyouid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouid(String pTyouhyouid) {
        tyouhyouid = pTyouhyouid;
    }

    private Integer hozonKikan;

    @Column(name=GenAM_SyoruiZokusei.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private C_NengetuKbn nengetukbn;

    @Type(type="UserType_C_NengetuKbn")
    @Column(name=GenAM_SyoruiZokusei.NENGETUKBN)
    public C_NengetuKbn getNengetukbn() {
        return nengetukbn;
    }

    public void setNengetukbn(C_NengetuKbn pNengetukbn) {
        nengetukbn = pNengetukbn;
    }

    private C_YesNoKbn angoukaKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAM_SyoruiZokusei.ANGOUKAKBN)
    public C_YesNoKbn getAngoukaKbn() {
        return angoukaKbn;
    }

    public void setAngoukaKbn(C_YesNoKbn pAngoukaKbn) {
        angoukaKbn = pAngoukaKbn;
    }

    private C_YesNoKbn pdfHozonKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAM_SyoruiZokusei.PDFHOZONKBN)
    public C_YesNoKbn getPdfHozonKbn() {
        return pdfHozonKbn;
    }

    public void setPdfHozonKbn(C_YesNoKbn pPdfHozonKbn) {
        pdfHozonKbn = pPdfHozonKbn;
    }

    private C_YesNoKbn zipHozonKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAM_SyoruiZokusei.ZIPHOZONKBN)
    public C_YesNoKbn getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(C_YesNoKbn pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }

    private Integer pageCount;

    @Column(name=GenAM_SyoruiZokusei.PAGECOUNT)
    public Integer getPageCount() {
        return pageCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPageCount(Integer pPageCount) {
        pageCount = pPageCount;
    }

    private Integer sortNo;

    @Column(name=GenAM_SyoruiZokusei.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private String kensakuKey1;

    @Column(name=GenAM_SyoruiZokusei.KENSAKUKEY1)
    public String getKensakuKey1() {
        return kensakuKey1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey1(String pKensakuKey1) {
        kensakuKey1 = pKensakuKey1;
    }

    private String kensakuKey2;

    @Column(name=GenAM_SyoruiZokusei.KENSAKUKEY2)
    public String getKensakuKey2() {
        return kensakuKey2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey2(String pKensakuKey2) {
        kensakuKey2 = pKensakuKey2;
    }

    private String kensakuKey3;

    @Column(name=GenAM_SyoruiZokusei.KENSAKUKEY3)
    public String getKensakuKey3() {
        return kensakuKey3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey3(String pKensakuKey3) {
        kensakuKey3 = pKensakuKey3;
    }

    private String kensakuKey4;

    @Column(name=GenAM_SyoruiZokusei.KENSAKUKEY4)
    public String getKensakuKey4() {
        return kensakuKey4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey4(String pKensakuKey4) {
        kensakuKey4 = pKensakuKey4;
    }

    private String kensakuKey5;

    @Column(name=GenAM_SyoruiZokusei.KENSAKUKEY5)
    public String getKensakuKey5() {
        return kensakuKey5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey5(String pKensakuKey5) {
        kensakuKey5 = pKensakuKey5;
    }
}