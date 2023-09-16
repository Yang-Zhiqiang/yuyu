package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.id.PKWT_TorikomiKanri;
import yuyu.def.db.meta.GenQWT_TorikomiKanri;
import yuyu.def.db.meta.QWT_TorikomiKanri;

/**
 * 取込管理テーブル テーブルのマッピング情報クラスで、 {@link WT_TorikomiKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_TorikomiKanri}</td><td colspan="3">取込管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIwfImageId iwfImageId}</td><td>IWFイメージＩＤ</td><td align="center">{@link PKWT_TorikomiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTourokuId tourokuId}</td><td>登録者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTourokuTime tourokuTime}</td><td>登録時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam1 extParam1}</td><td>拡張パラメータ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam2 extParam2}</td><td>拡張パラメータ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam3 extParam3}</td><td>拡張パラメータ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam4 extParam4}</td><td>拡張パラメータ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam5 extParam5}</td><td>拡張パラメータ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam6 extParam6}</td><td>拡張パラメータ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam7 extParam7}</td><td>拡張パラメータ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam8 extParam8}</td><td>拡張パラメータ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam9 extParam9}</td><td>拡張パラメータ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam10 extParam10}</td><td>拡張パラメータ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam11 extParam11}</td><td>拡張パラメータ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam12 extParam12}</td><td>拡張パラメータ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam13 extParam13}</td><td>拡張パラメータ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam14 extParam14}</td><td>拡張パラメータ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getExtParam15 extParam15}</td><td>拡張パラメータ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_TorikomiKanri
 * @see     PKWT_TorikomiKanri
 * @see     QWT_TorikomiKanri
 * @see     GenQWT_TorikomiKanri
 */
@MappedSuperclass
@Table(name=GenWT_TorikomiKanri.TABLE_NAME)
@IdClass(value=PKWT_TorikomiKanri.class)
public abstract class GenWT_TorikomiKanri extends AbstractExDBEntity<WT_TorikomiKanri, PKWT_TorikomiKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_TorikomiKanri";
    public static final String IWFIMAGEID               = "iwfImageId";
    public static final String TORIKOMISYORUICD         = "torikomiSyoruiCd";
    public static final String TOUROKUID                = "tourokuId";
    public static final String TOUROKUTIME              = "tourokuTime";
    public static final String EXTPARAM1                = "extParam1";
    public static final String EXTPARAM2                = "extParam2";
    public static final String EXTPARAM3                = "extParam3";
    public static final String EXTPARAM4                = "extParam4";
    public static final String EXTPARAM5                = "extParam5";
    public static final String EXTPARAM6                = "extParam6";
    public static final String EXTPARAM7                = "extParam7";
    public static final String EXTPARAM8                = "extParam8";
    public static final String EXTPARAM9                = "extParam9";
    public static final String EXTPARAM10               = "extParam10";
    public static final String EXTPARAM11               = "extParam11";
    public static final String EXTPARAM12               = "extParam12";
    public static final String EXTPARAM13               = "extParam13";
    public static final String EXTPARAM14               = "extParam14";
    public static final String EXTPARAM15               = "extParam15";

    private final PKWT_TorikomiKanri primaryKey;

    public GenWT_TorikomiKanri() {
        primaryKey = new PKWT_TorikomiKanri();
    }

    public GenWT_TorikomiKanri(String pIwfImageId) {
        primaryKey = new PKWT_TorikomiKanri(pIwfImageId);
    }

    @Transient
    @Override
    public PKWT_TorikomiKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_TorikomiKanri> getMetaClass() {
        return QWT_TorikomiKanri.class;
    }

    @Id
    @Column(name=GenWT_TorikomiKanri.IWFIMAGEID)
    public String getIwfImageId() {
        return getPrimaryKey().getIwfImageId();
    }

    public void setIwfImageId(String pIwfImageId) {
        getPrimaryKey().setIwfImageId(pIwfImageId);
    }

    private String torikomiSyoruiCd;

    @Column(name=GenWT_TorikomiKanri.TORIKOMISYORUICD)
    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    private String tourokuId;

    @Column(name=GenWT_TorikomiKanri.TOUROKUID)
    public String getTourokuId() {
        return tourokuId;
    }

    public void setTourokuId(String pTourokuId) {
        tourokuId = pTourokuId;
    }

    private String tourokuTime;

    @Column(name=GenWT_TorikomiKanri.TOUROKUTIME)
    public String getTourokuTime() {
        return tourokuTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTourokuTime(String pTourokuTime) {
        tourokuTime = pTourokuTime;
    }

    private String extParam1;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM1)
    public String getExtParam1() {
        return extParam1;
    }

    public void setExtParam1(String pExtParam1) {
        extParam1 = pExtParam1;
    }

    private String extParam2;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM2)
    public String getExtParam2() {
        return extParam2;
    }

    public void setExtParam2(String pExtParam2) {
        extParam2 = pExtParam2;
    }

    private String extParam3;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM3)
    public String getExtParam3() {
        return extParam3;
    }

    public void setExtParam3(String pExtParam3) {
        extParam3 = pExtParam3;
    }

    private String extParam4;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM4)
    public String getExtParam4() {
        return extParam4;
    }

    public void setExtParam4(String pExtParam4) {
        extParam4 = pExtParam4;
    }

    private String extParam5;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM5)
    public String getExtParam5() {
        return extParam5;
    }

    public void setExtParam5(String pExtParam5) {
        extParam5 = pExtParam5;
    }

    private String extParam6;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM6)
    public String getExtParam6() {
        return extParam6;
    }

    public void setExtParam6(String pExtParam6) {
        extParam6 = pExtParam6;
    }

    private String extParam7;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM7)
    public String getExtParam7() {
        return extParam7;
    }

    public void setExtParam7(String pExtParam7) {
        extParam7 = pExtParam7;
    }

    private String extParam8;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM8)
    public String getExtParam8() {
        return extParam8;
    }

    public void setExtParam8(String pExtParam8) {
        extParam8 = pExtParam8;
    }

    private String extParam9;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM9)
    public String getExtParam9() {
        return extParam9;
    }

    public void setExtParam9(String pExtParam9) {
        extParam9 = pExtParam9;
    }

    private String extParam10;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM10)
    public String getExtParam10() {
        return extParam10;
    }

    public void setExtParam10(String pExtParam10) {
        extParam10 = pExtParam10;
    }

    private String extParam11;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM11)
    public String getExtParam11() {
        return extParam11;
    }

    public void setExtParam11(String pExtParam11) {
        extParam11 = pExtParam11;
    }

    private String extParam12;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM12)
    public String getExtParam12() {
        return extParam12;
    }

    public void setExtParam12(String pExtParam12) {
        extParam12 = pExtParam12;
    }

    private String extParam13;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM13)
    public String getExtParam13() {
        return extParam13;
    }

    public void setExtParam13(String pExtParam13) {
        extParam13 = pExtParam13;
    }

    private String extParam14;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM14)
    public String getExtParam14() {
        return extParam14;
    }

    public void setExtParam14(String pExtParam14) {
        extParam14 = pExtParam14;
    }

    private String extParam15;

    @Column(name=GenWT_TorikomiKanri.EXTPARAM15)
    public String getExtParam15() {
        return extParam15;
    }

    public void setExtParam15(String pExtParam15) {
        extParam15 = pExtParam15;
    }
}