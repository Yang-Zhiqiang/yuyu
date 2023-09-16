package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;
import yuyu.def.db.id.PKBM_TokujyouSakugenRate;
import yuyu.def.db.meta.GenQBM_TokujyouSakugenRate;
import yuyu.def.db.meta.QBM_TokujyouSakugenRate;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;

/**
 * 特条削減率マスタ テーブルのマッピング情報クラスで、 {@link BM_TokujyouSakugenRate} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TokujyouSakugenRate}</td><td colspan="3">特条削減率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_TokujyouSakugenRate ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKBM_TokujyouSakugenRate ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkjyskgnkkn tkjyskgnkkn}</td><td>特条削減期間</td><td align="center">{@link PKBM_TokujyouSakugenRate ○}</td><td align="center">V</td><td>{@link C_Tkjyskgnkkn}</td></tr>
 *  <tr><td>{@link #getDai1hknnndskgnsrate dai1hknnndskgnsrate}</td><td>第１保険年度削減支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai2hknnndskgnsrate dai2hknnndskgnsrate}</td><td>第２保険年度削減支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai3hknnndskgnsrate dai3hknnndskgnsrate}</td><td>第３保険年度削減支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai4hknnndskgnsrate dai4hknnndskgnsrate}</td><td>第４保険年度削減支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai5hknnndskgnsrate dai5hknnndskgnsrate}</td><td>第５保険年度削減支払割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_TokujyouSakugenRate
 * @see     PKBM_TokujyouSakugenRate
 * @see     QBM_TokujyouSakugenRate
 * @see     GenQBM_TokujyouSakugenRate
 */
@MappedSuperclass
@Table(name=GenBM_TokujyouSakugenRate.TABLE_NAME)
@IdClass(value=PKBM_TokujyouSakugenRate.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tkjyskgnkkn", typeClass=UserType_C_Tkjyskgnkkn.class)
})
public abstract class GenBM_TokujyouSakugenRate extends AbstractExDBEntity<BM_TokujyouSakugenRate, PKBM_TokujyouSakugenRate> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_TokujyouSakugenRate";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String TKJYSKGNKKN              = "tkjyskgnkkn";
    public static final String DAI1HKNNNDSKGNSRATE      = "dai1hknnndskgnsrate";
    public static final String DAI2HKNNNDSKGNSRATE      = "dai2hknnndskgnsrate";
    public static final String DAI3HKNNNDSKGNSRATE      = "dai3hknnndskgnsrate";
    public static final String DAI4HKNNNDSKGNSRATE      = "dai4hknnndskgnsrate";
    public static final String DAI5HKNNNDSKGNSRATE      = "dai5hknnndskgnsrate";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_TokujyouSakugenRate primaryKey;

    public GenBM_TokujyouSakugenRate() {
        primaryKey = new PKBM_TokujyouSakugenRate();
    }

    public GenBM_TokujyouSakugenRate(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_Tkjyskgnkkn pTkjyskgnkkn
    ) {
        primaryKey = new PKBM_TokujyouSakugenRate(
            pSyouhncd,
            pSyouhnsdno,
            pTkjyskgnkkn
        );
    }

    @Transient
    @Override
    public PKBM_TokujyouSakugenRate getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_TokujyouSakugenRate> getMetaClass() {
        return QBM_TokujyouSakugenRate.class;
    }

    @Id
    @Column(name=GenBM_TokujyouSakugenRate.SYOUHNCD)
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
    @Column(name=GenBM_TokujyouSakugenRate.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Type(type="UserType_C_Tkjyskgnkkn")
    @Column(name=GenBM_TokujyouSakugenRate.TKJYSKGNKKN)
    public C_Tkjyskgnkkn getTkjyskgnkkn() {
        return getPrimaryKey().getTkjyskgnkkn();
    }

    public void setTkjyskgnkkn(C_Tkjyskgnkkn pTkjyskgnkkn) {
        getPrimaryKey().setTkjyskgnkkn(pTkjyskgnkkn);
    }

    private BizNumber dai1hknnndskgnsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TokujyouSakugenRate.DAI1HKNNNDSKGNSRATE)
    public BizNumber getDai1hknnndskgnsrate() {
        return dai1hknnndskgnsrate;
    }

    @Trim("both")
    public void setDai1hknnndskgnsrate(BizNumber pDai1hknnndskgnsrate) {
        dai1hknnndskgnsrate = pDai1hknnndskgnsrate;
    }

    private BizNumber dai2hknnndskgnsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TokujyouSakugenRate.DAI2HKNNNDSKGNSRATE)
    public BizNumber getDai2hknnndskgnsrate() {
        return dai2hknnndskgnsrate;
    }

    @Trim("both")
    public void setDai2hknnndskgnsrate(BizNumber pDai2hknnndskgnsrate) {
        dai2hknnndskgnsrate = pDai2hknnndskgnsrate;
    }

    private BizNumber dai3hknnndskgnsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TokujyouSakugenRate.DAI3HKNNNDSKGNSRATE)
    public BizNumber getDai3hknnndskgnsrate() {
        return dai3hknnndskgnsrate;
    }

    @Trim("both")
    public void setDai3hknnndskgnsrate(BizNumber pDai3hknnndskgnsrate) {
        dai3hknnndskgnsrate = pDai3hknnndskgnsrate;
    }

    private BizNumber dai4hknnndskgnsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TokujyouSakugenRate.DAI4HKNNNDSKGNSRATE)
    public BizNumber getDai4hknnndskgnsrate() {
        return dai4hknnndskgnsrate;
    }

    @Trim("both")
    public void setDai4hknnndskgnsrate(BizNumber pDai4hknnndskgnsrate) {
        dai4hknnndskgnsrate = pDai4hknnndskgnsrate;
    }

    private BizNumber dai5hknnndskgnsrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_TokujyouSakugenRate.DAI5HKNNNDSKGNSRATE)
    public BizNumber getDai5hknnndskgnsrate() {
        return dai5hknnndskgnsrate;
    }

    @Trim("both")
    public void setDai5hknnndskgnsrate(BizNumber pDai5hknnndskgnsrate) {
        dai5hknnndskgnsrate = pDai5hknnndskgnsrate;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_TokujyouSakugenRate.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_TokujyouSakugenRate.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_TokujyouSakugenRate.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
