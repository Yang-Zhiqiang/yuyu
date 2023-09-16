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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import yuyu.def.db.id.PKJM_SyujyutuKyuuhu;
import yuyu.def.db.meta.GenQJM_SyujyutuKyuuhu;
import yuyu.def.db.meta.QJM_SyujyutuKyuuhu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 手術給付マスタ テーブルのマッピング情報クラスで、 {@link JM_SyujyutuKyuuhu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SyujyutuKyuuhu}</td><td colspan="3">手術給付マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyujyutubunruicd syujyutubunruicd}</td><td>手術分類コード</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyujyututekiyoukkanfrom syujyututekiyoukkanfrom}</td><td>手術適用期間（自）</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyututekiyoukkanto syujyututekiyoukkanto}</td><td>手術適用期間（至）</td><td align="center">{@link PKJM_SyujyutuKyuuhu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyujyutukyhbairitu syujyutukyhbairitu}</td><td>手術給付倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKyuuhugendokikan kyuuhugendokikan}</td><td>給付限度期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyujyutusyurui syujyutusyurui}</td><td>手術種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokusyusyujyutukbn tokusyusyujyutukbn}</td><td>特殊手術区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SyujyutuKyuuhu
 * @see     PKJM_SyujyutuKyuuhu
 * @see     QJM_SyujyutuKyuuhu
 * @see     GenQJM_SyujyutuKyuuhu
 */
@MappedSuperclass
@Table(name=GenJM_SyujyutuKyuuhu.TABLE_NAME)
@IdClass(value=PKJM_SyujyutuKyuuhu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJM_SyujyutuKyuuhu extends AbstractExDBEntity<JM_SyujyutuKyuuhu, PKJM_SyujyutuKyuuhu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SyujyutuKyuuhu";
    public static final String SYUJYUTUBUNRUICD         = "syujyutubunruicd";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String SYUJYUTUTEKIYOUKKANFROM  = "syujyututekiyoukkanfrom";
    public static final String SYUJYUTUTEKIYOUKKANTO    = "syujyututekiyoukkanto";
    public static final String SYUJYUTUKYHBAIRITU       = "syujyutukyhbairitu";
    public static final String KYUUHUGENDOKIKAN         = "kyuuhugendokikan";
    public static final String SYUJYUTUSYURUI           = "syujyutusyurui";
    public static final String TOKUSYUSYUJYUTUKBN       = "tokusyusyujyutukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJM_SyujyutuKyuuhu primaryKey;

    public GenJM_SyujyutuKyuuhu() {
        primaryKey = new PKJM_SyujyutuKyuuhu();
    }

    public GenJM_SyujyutuKyuuhu(
        String pSyujyutubunruicd,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pKyuuhucd,
        BizDate pSyujyututekiyoukkanfrom,
        BizDate pSyujyututekiyoukkanto
    ) {
        primaryKey = new PKJM_SyujyutuKyuuhu(
            pSyujyutubunruicd,
            pSyouhncd,
            pSyouhnsdno,
            pKyuuhucd,
            pSyujyututekiyoukkanfrom,
            pSyujyututekiyoukkanto
        );
    }

    @Transient
    @Override
    public PKJM_SyujyutuKyuuhu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SyujyutuKyuuhu> getMetaClass() {
        return QJM_SyujyutuKyuuhu.class;
    }

    @Id
    @Column(name=GenJM_SyujyutuKyuuhu.SYUJYUTUBUNRUICD)
    @MaxLength(max=3)
    @AlphaDigit
    @SingleByteStrings
    public String getSyujyutubunruicd() {
        return getPrimaryKey().getSyujyutubunruicd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyujyutubunruicd(String pSyujyutubunruicd) {
        getPrimaryKey().setSyujyutubunruicd(pSyujyutubunruicd);
    }

    @Id
    @Column(name=GenJM_SyujyutuKyuuhu.SYOUHNCD)
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
    @Column(name=GenJM_SyujyutuKyuuhu.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJM_SyujyutuKyuuhu.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJM_SyujyutuKyuuhu.SYUJYUTUTEKIYOUKKANFROM)
    public BizDate getSyujyututekiyoukkanfrom() {
        return getPrimaryKey().getSyujyututekiyoukkanfrom();
    }

    public void setSyujyututekiyoukkanfrom(BizDate pSyujyututekiyoukkanfrom) {
        getPrimaryKey().setSyujyututekiyoukkanfrom(pSyujyututekiyoukkanfrom);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJM_SyujyutuKyuuhu.SYUJYUTUTEKIYOUKKANTO)
    public BizDate getSyujyututekiyoukkanto() {
        return getPrimaryKey().getSyujyututekiyoukkanto();
    }

    public void setSyujyututekiyoukkanto(BizDate pSyujyututekiyoukkanto) {
        getPrimaryKey().setSyujyututekiyoukkanto(pSyujyututekiyoukkanto);
    }

    private BizNumber syujyutukyhbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenJM_SyujyutuKyuuhu.SYUJYUTUKYHBAIRITU)
    public BizNumber getSyujyutukyhbairitu() {
        return syujyutukyhbairitu;
    }

    public void setSyujyutukyhbairitu(BizNumber pSyujyutukyhbairitu) {
        syujyutukyhbairitu = pSyujyutukyhbairitu;
    }

    private Integer kyuuhugendokikan;

    @Column(name=GenJM_SyujyutuKyuuhu.KYUUHUGENDOKIKAN)
    public Integer getKyuuhugendokikan() {
        return kyuuhugendokikan;
    }

    public void setKyuuhugendokikan(Integer pKyuuhugendokikan) {
        kyuuhugendokikan = pKyuuhugendokikan;
    }

    private String syujyutusyurui;

    @Column(name=GenJM_SyujyutuKyuuhu.SYUJYUTUSYURUI)
    public String getSyujyutusyurui() {
        return syujyutusyurui;
    }

    public void setSyujyutusyurui(String pSyujyutusyurui) {
        syujyutusyurui = pSyujyutusyurui;
    }

    private C_UmuKbn tokusyusyujyutukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_SyujyutuKyuuhu.TOKUSYUSYUJYUTUKBN)
    public C_UmuKbn getTokusyusyujyutukbn() {
        return tokusyusyujyutukbn;
    }

    public void setTokusyusyujyutukbn(C_UmuKbn pTokusyusyujyutukbn) {
        tokusyusyujyutukbn = pTokusyusyujyutukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJM_SyujyutuKyuuhu.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJM_SyujyutuKyuuhu.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
