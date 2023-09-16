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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.id.PKHM_SkHokenSyuruiNo;
import yuyu.def.db.meta.GenQHM_SkHokenSyuruiNo;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNo;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;

/**
 * 保険種類番号マスタ テーブルのマッピング情報クラスで、 {@link HM_SkHokenSyuruiNo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkHokenSyuruiNo}</td><td colspan="3">保険種類番号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">{@link PKHM_SkHokenSyuruiNo ○}</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getHknsyuruinosd hknsyuruinosd}</td><td>保険種類番号世代</td><td align="center">{@link PKHM_SkHokenSyuruiNo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHyoujifromymd hyoujifromymd}</td><td>表示日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujitoymd hyoujitoymd}</td><td>表示日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknsyuruinm hknsyuruinm}</td><td>保険種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruinmsyanaidisp hknsyuruinmsyanaidisp}</td><td>保険種類名（社内表示用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruiworklist hknsyuruiworklist}</td><td>保険種類名（ワークリスト用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaihyouhknsyuruino daihyouhknsyuruino}</td><td>代表保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getInputctrlsyouhncd inputctrlsyouhncd}</td><td>入力制御用商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInputctrlsyouhnsdno inputctrlsyouhnsdno}</td><td>入力制御用商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1hknkknselect dai1hknkknselect}</td><td>第１保険期間選択肢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTargettkmkhtselect targettkmkhtselect}</td><td>ターゲット特約目標値選択肢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyohnsortno syohnsortno}</td><td>商品ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_SkHokenSyuruiNo
 * @see     PKHM_SkHokenSyuruiNo
 * @see     QHM_SkHokenSyuruiNo
 * @see     GenQHM_SkHokenSyuruiNo
 */
@MappedSuperclass
@Table(name=GenHM_SkHokenSyuruiNo.TABLE_NAME)
@IdClass(value=PKHM_SkHokenSyuruiNo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class)
})
public abstract class GenHM_SkHokenSyuruiNo extends AbstractExDBEntity<HM_SkHokenSyuruiNo, PKHM_SkHokenSyuruiNo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkHokenSyuruiNo";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String HKNSYURUINOSD            = "hknsyuruinosd";
    public static final String HYOUJIFROMYMD            = "hyoujifromymd";
    public static final String HYOUJITOYMD              = "hyoujitoymd";
    public static final String HKNSYURUINM              = "hknsyuruinm";
    public static final String HKNSYURUINMSYANAIDISP    = "hknsyuruinmsyanaidisp";
    public static final String HKNSYURUIWORKLIST        = "hknsyuruiworklist";
    public static final String DAIHYOUHKNSYURUINO       = "daihyouhknsyuruino";
    public static final String INPUTCTRLSYOUHNCD        = "inputctrlsyouhncd";
    public static final String INPUTCTRLSYOUHNSDNO      = "inputctrlsyouhnsdno";
    public static final String DAI1HKNKKNSELECT         = "dai1hknkknselect";
    public static final String TARGETTKMKHTSELECT       = "targettkmkhtselect";
    public static final String SYOHNSORTNO              = "syohnsortno";

    private final PKHM_SkHokenSyuruiNo primaryKey;

    public GenHM_SkHokenSyuruiNo() {
        primaryKey = new PKHM_SkHokenSyuruiNo();
    }

    public GenHM_SkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosd) {
        primaryKey = new PKHM_SkHokenSyuruiNo(pHknsyuruino, pHknsyuruinosd);
    }

    @Transient
    @Override
    public PKHM_SkHokenSyuruiNo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkHokenSyuruiNo> getMetaClass() {
        return QHM_SkHokenSyuruiNo.class;
    }

    @Id
    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHM_SkHokenSyuruiNo.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return getPrimaryKey().getHknsyuruino();
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        getPrimaryKey().setHknsyuruino(pHknsyuruino);
    }

    @Id
    @Column(name=GenHM_SkHokenSyuruiNo.HKNSYURUINOSD)
    public Integer getHknsyuruinosd() {
        return getPrimaryKey().getHknsyuruinosd();
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        getPrimaryKey().setHknsyuruinosd(pHknsyuruinosd);
    }

    private BizDate hyoujifromymd;

    @Type(type="BizDateType")
    @Column(name=GenHM_SkHokenSyuruiNo.HYOUJIFROMYMD)
    @ValidDate
    public BizDate getHyoujifromymd() {
        return hyoujifromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujifromymd(BizDate pHyoujifromymd) {
        hyoujifromymd = pHyoujifromymd;
    }

    private BizDate hyoujitoymd;

    @Type(type="BizDateType")
    @Column(name=GenHM_SkHokenSyuruiNo.HYOUJITOYMD)
    @ValidDate
    public BizDate getHyoujitoymd() {
        return hyoujitoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujitoymd(BizDate pHyoujitoymd) {
        hyoujitoymd = pHyoujitoymd;
    }

    private String hknsyuruinm;

    @Column(name=GenHM_SkHokenSyuruiNo.HKNSYURUINM)
    public String getHknsyuruinm() {
        return hknsyuruinm;
    }

    public void setHknsyuruinm(String pHknsyuruinm) {
        hknsyuruinm = pHknsyuruinm;
    }

    private String hknsyuruinmsyanaidisp;

    @Column(name=GenHM_SkHokenSyuruiNo.HKNSYURUINMSYANAIDISP)
    public String getHknsyuruinmsyanaidisp() {
        return hknsyuruinmsyanaidisp;
    }

    public void setHknsyuruinmsyanaidisp(String pHknsyuruinmsyanaidisp) {
        hknsyuruinmsyanaidisp = pHknsyuruinmsyanaidisp;
    }

    private String hknsyuruiworklist;

    @Column(name=GenHM_SkHokenSyuruiNo.HKNSYURUIWORKLIST)
    public String getHknsyuruiworklist() {
        return hknsyuruiworklist;
    }

    public void setHknsyuruiworklist(String pHknsyuruiworklist) {
        hknsyuruiworklist = pHknsyuruiworklist;
    }

    private C_HknsyuruiNo daihyouhknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHM_SkHokenSyuruiNo.DAIHYOUHKNSYURUINO)
    public C_HknsyuruiNo getDaihyouhknsyuruino() {
        return daihyouhknsyuruino;
    }

    public void setDaihyouhknsyuruino(C_HknsyuruiNo pDaihyouhknsyuruino) {
        daihyouhknsyuruino = pDaihyouhknsyuruino;
    }

    private String inputctrlsyouhncd;

    @Column(name=GenHM_SkHokenSyuruiNo.INPUTCTRLSYOUHNCD)
    public String getInputctrlsyouhncd() {
        return inputctrlsyouhncd;
    }

    public void setInputctrlsyouhncd(String pInputctrlsyouhncd) {
        inputctrlsyouhncd = pInputctrlsyouhncd;
    }

    private Integer inputctrlsyouhnsdno;

    @Column(name=GenHM_SkHokenSyuruiNo.INPUTCTRLSYOUHNSDNO)
    public Integer getInputctrlsyouhnsdno() {
        return inputctrlsyouhnsdno;
    }

    public void setInputctrlsyouhnsdno(Integer pInputctrlsyouhnsdno) {
        inputctrlsyouhnsdno = pInputctrlsyouhnsdno;
    }

    private String dai1hknkknselect;

    @Column(name=GenHM_SkHokenSyuruiNo.DAI1HKNKKNSELECT)
    public String getDai1hknkknselect() {
        return dai1hknkknselect;
    }

    public void setDai1hknkknselect(String pDai1hknkknselect) {
        dai1hknkknselect = pDai1hknkknselect;
    }

    private String targettkmkhtselect;

    @Column(name=GenHM_SkHokenSyuruiNo.TARGETTKMKHTSELECT)
    public String getTargettkmkhtselect() {
        return targettkmkhtselect;
    }

    public void setTargettkmkhtselect(String pTargettkmkhtselect) {
        targettkmkhtselect = pTargettkmkhtselect;
    }

    private Integer syohnsortno;

    @Column(name=GenHM_SkHokenSyuruiNo.SYOHNSORTNO)
    public Integer getSyohnsortno() {
        return syohnsortno;
    }

    public void setSyohnsortno(Integer pSyohnsortno) {
        syohnsortno = pSyohnsortno;
    }
}