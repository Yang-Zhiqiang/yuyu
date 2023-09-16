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
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.id.PKIT_Tokusin;
import yuyu.def.db.meta.GenQIT_Tokusin;
import yuyu.def.db.meta.QIT_Tokusin;
import yuyu.def.db.type.UserType_C_TokusinKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 特伸テーブル テーブルのマッピング情報クラスで、 {@link IT_Tokusin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_Tokusin}</td><td colspan="3">特伸テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_Tokusin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_Tokusin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokusinkbn tokusinkbn}</td><td>特伸区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusinKbn}</td></tr>
 *  <tr><td>{@link #getTokusinsyoriymd tokusinsyoriymd}</td><td>特伸処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHsgymd hsgymd}</td><td>被災害年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTokusinendymd tokusinendymd}</td><td>特伸終了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_Tokusin
 * @see     PKIT_Tokusin
 * @see     QIT_Tokusin
 * @see     GenQIT_Tokusin
 */
@MappedSuperclass
@Table(name=GenIT_Tokusin.TABLE_NAME)
@IdClass(value=PKIT_Tokusin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_TokusinKbn", typeClass=UserType_C_TokusinKbn.class)
})
public abstract class GenIT_Tokusin extends AbstractExDBEntity<IT_Tokusin, PKIT_Tokusin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_Tokusin";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TOKUSINKBN               = "tokusinkbn";
    public static final String TOKUSINSYORIYMD          = "tokusinsyoriymd";
    public static final String HSGYMD                   = "hsgymd";
    public static final String TOKUSINENDYMD            = "tokusinendymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_Tokusin primaryKey;

    public GenIT_Tokusin() {
        primaryKey = new PKIT_Tokusin();
    }

    public GenIT_Tokusin(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_Tokusin(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_Tokusin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_Tokusin> getMetaClass() {
        return QIT_Tokusin.class;
    }

    @Id
    @Column(name=GenIT_Tokusin.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_Tokusin.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_TokusinKbn tokusinkbn;

    @Type(type="UserType_C_TokusinKbn")
    @Column(name=GenIT_Tokusin.TOKUSINKBN)
    public C_TokusinKbn getTokusinkbn() {
        return tokusinkbn;
    }

    public void setTokusinkbn(C_TokusinKbn pTokusinkbn) {
        tokusinkbn = pTokusinkbn;
    }

    private BizDate tokusinsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Tokusin.TOKUSINSYORIYMD)
    public BizDate getTokusinsyoriymd() {
        return tokusinsyoriymd;
    }

    public void setTokusinsyoriymd(BizDate pTokusinsyoriymd) {
        tokusinsyoriymd = pTokusinsyoriymd;
    }

    private BizDate hsgymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Tokusin.HSGYMD)
    @ValidDate
    public BizDate getHsgymd() {
        return hsgymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHsgymd(BizDate pHsgymd) {
        hsgymd = pHsgymd;
    }

    private BizDate tokusinendymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_Tokusin.TOKUSINENDYMD)
    @ValidDate
    public BizDate getTokusinendymd() {
        return tokusinendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTokusinendymd(BizDate pTokusinendymd) {
        tokusinendymd = pTokusinendymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_Tokusin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_Tokusin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_Tokusin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}