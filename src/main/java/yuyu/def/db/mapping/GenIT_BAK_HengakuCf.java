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
import yuyu.def.classification.C_CfKbn;
import yuyu.def.classification.C_HasseiRiyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_BAK_HengakuCf;
import yuyu.def.db.id.PKIT_BAK_HengakuCf;
import yuyu.def.db.meta.GenQIT_BAK_HengakuCf;
import yuyu.def.db.meta.QIT_BAK_HengakuCf;
import yuyu.def.db.type.UserType_C_CfKbn;
import yuyu.def.db.type.UserType_C_HasseiRiyuuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UnitFundKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 変額ＣＦバックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_HengakuCf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HengakuCf}</td><td colspan="3">変額ＣＦバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKIT_BAK_HengakuCf ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCfkbn cfkbn}</td><td>ＣＦ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CfKbn}</td></tr>
 *  <tr><td>{@link #getHasseiriyuukbn hasseiriyuukbn}</td><td>発生理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HasseiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 * </table>
 * @see     IT_BAK_HengakuCf
 * @see     PKIT_BAK_HengakuCf
 * @see     QIT_BAK_HengakuCf
 * @see     GenQIT_BAK_HengakuCf
 */
@MappedSuperclass
@Table(name=GenIT_BAK_HengakuCf.TABLE_NAME)
@IdClass(value=PKIT_BAK_HengakuCf.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_CfKbn", typeClass=UserType_C_CfKbn.class),
    @TypeDef(name="UserType_C_HasseiRiyuuKbn", typeClass=UserType_C_HasseiRiyuuKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenIT_BAK_HengakuCf extends AbstractExDBEntity<IT_BAK_HengakuCf, PKIT_BAK_HengakuCf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_HengakuCf";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String RENNO                    = "renno";
    public static final String CFKBN                    = "cfkbn";
    public static final String HASSEIRIYUUKBN           = "hasseiriyuukbn";
    public static final String TUUKASYU                 = "tuukasyu";

    private final PKIT_BAK_HengakuCf primaryKey;

    public GenIT_BAK_HengakuCf() {
        primaryKey = new PKIT_BAK_HengakuCf();
    }

    public GenIT_BAK_HengakuCf(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey,
        C_UnitFundKbn pUnitfundkbn,
        BizDate pSyoriYmd,
        Integer pRenno
    ) {
        primaryKey = new PKIT_BAK_HengakuCf(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey,
            pUnitfundkbn,
            pSyoriYmd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKIT_BAK_HengakuCf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_HengakuCf> getMetaClass() {
        return QIT_BAK_HengakuCf.class;
    }

    @Id
    @Column(name=GenIT_BAK_HengakuCf.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_HengakuCf.SYONO)
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
    @Column(name=GenIT_BAK_HengakuCf.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_HengakuCf.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenIT_BAK_HengakuCf.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HengakuCf.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_BAK_HengakuCf.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_CfKbn cfkbn;

    @Type(type="UserType_C_CfKbn")
    @Column(name=GenIT_BAK_HengakuCf.CFKBN)
    public C_CfKbn getCfkbn() {
        return cfkbn;
    }

    public void setCfkbn(C_CfKbn pCfkbn) {
        cfkbn = pCfkbn;
    }

    private C_HasseiRiyuuKbn hasseiriyuukbn;

    @Type(type="UserType_C_HasseiRiyuuKbn")
    @Column(name=GenIT_BAK_HengakuCf.HASSEIRIYUUKBN)
    public C_HasseiRiyuuKbn getHasseiriyuukbn() {
        return hasseiriyuukbn;
    }

    public void setHasseiriyuukbn(C_HasseiRiyuuKbn pHasseiriyuukbn) {
        hasseiriyuukbn = pHasseiriyuukbn;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HengakuCf.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
}