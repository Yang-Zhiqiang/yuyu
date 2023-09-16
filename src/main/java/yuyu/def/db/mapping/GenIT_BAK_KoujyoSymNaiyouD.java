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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.db.entity.IT_BAK_KoujyoSymNaiyouD;
import yuyu.def.db.id.PKIT_BAK_KoujyoSymNaiyouD;
import yuyu.def.db.meta.GenQIT_BAK_KoujyoSymNaiyouD;
import yuyu.def.db.meta.QIT_BAK_KoujyoSymNaiyouD;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明内容Ｄバックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KoujyoSymNaiyouD} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KoujyoSymNaiyouD}</td><td colspan="3">控除証明内容Ｄバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyouD ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyouD ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyouD ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyouD ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_BAK_KoujyoSymNaiyouD ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeinnd koujyosyoumeinnd}</td><td>控除証明年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeid koujyosyoumeid}</td><td>控除証明Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getHaitoukanrirenno haitoukanrirenno}</td><td>配当管理連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaitoukinskskbn haitoukinskskbn}</td><td>配当金作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinsksKbn}</td></tr>
 *  <tr><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>{@link #getKjsmhakkouzumiflg kjsmhakkouzumiflg}</td><td>控除証明書発行済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>{@link #getSakujyoflg sakujyoflg}</td><td>削除フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Delflag}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KoujyoSymNaiyouD
 * @see     PKIT_BAK_KoujyoSymNaiyouD
 * @see     QIT_BAK_KoujyoSymNaiyouD
 * @see     GenQIT_BAK_KoujyoSymNaiyouD
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KoujyoSymNaiyouD.TABLE_NAME)
@IdClass(value=PKIT_BAK_KoujyoSymNaiyouD.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="UserType_C_Delflag", typeClass=UserType_C_Delflag.class),
    @TypeDef(name="UserType_C_HaitoukinsksKbn", typeClass=UserType_C_HaitoukinsksKbn.class),
    @TypeDef(name="UserType_C_HaitoumeisaiKbn", typeClass=UserType_C_HaitoumeisaiKbn.class),
    @TypeDef(name="UserType_C_Kjsmhakkouzumiflg", typeClass=UserType_C_Kjsmhakkouzumiflg.class)
})
public abstract class GenIT_BAK_KoujyoSymNaiyouD extends AbstractExDBEntity<IT_BAK_KoujyoSymNaiyouD, PKIT_BAK_KoujyoSymNaiyouD> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KoujyoSymNaiyouD";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String KOUJYOSYOUMEINND         = "koujyosyoumeinnd";
    public static final String KOUJYOSYOUMEID           = "koujyosyoumeid";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String HAITOUKANRIRENNO         = "haitoukanrirenno";
    public static final String HAITOUKINSKSKBN          = "haitoukinskskbn";
    public static final String HAITOUMEISAIKBN          = "haitoumeisaikbn";
    public static final String KJSMHAKKOUZUMIFLG        = "kjsmhakkouzumiflg";
    public static final String SAKUJYOFLG               = "sakujyoflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_KoujyoSymNaiyouD primaryKey;

    public GenIT_BAK_KoujyoSymNaiyouD() {
        primaryKey = new PKIT_BAK_KoujyoSymNaiyouD();
    }

    public GenIT_BAK_KoujyoSymNaiyouD(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pSyouhncd,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_BAK_KoujyoSymNaiyouD(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pSyouhncd,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KoujyoSymNaiyouD getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KoujyoSymNaiyouD> getMetaClass() {
        return QIT_BAK_KoujyoSymNaiyouD.class;
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.SYONO)
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
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.SYOUHNCD)
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
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String koujyosyoumeinnd;

    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.KOUJYOSYOUMEINND)
    public String getKoujyosyoumeinnd() {
        return koujyosyoumeinnd;
    }

    public void setKoujyosyoumeinnd(String pKoujyosyoumeinnd) {
        koujyosyoumeinnd = pKoujyosyoumeinnd;
    }

    private BizCurrency koujyosyoumeid;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKoujyosyoumeid() {
        return koujyosyoumeid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKoujyosyoumeid(BizCurrency pKoujyosyoumeid) {
        koujyosyoumeid = pKoujyosyoumeid;
        koujyosyoumeidValue = null;
        koujyosyoumeidType  = null;
    }

    transient private BigDecimal koujyosyoumeidValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KOUJYOSYOUMEID, nullable=true)
    protected BigDecimal getKoujyosyoumeidValue() {
        if (koujyosyoumeidValue == null && koujyosyoumeid != null) {
            if (koujyosyoumeid.isOptional()) return null;
            return koujyosyoumeid.absolute();
        }
        return koujyosyoumeidValue;
    }

    protected void setKoujyosyoumeidValue(BigDecimal value) {
        koujyosyoumeidValue = value;
        koujyosyoumeid = Optional.fromNullable(toCurrencyType(koujyosyoumeidType))
            .transform(bizCurrencyTransformer(getKoujyosyoumeidValue()))
            .orNull();
    }

    transient private String koujyosyoumeidType = null;

    @Column(name=KOUJYOSYOUMEID + "$", nullable=true)
    protected String getKoujyosyoumeidType() {
        if (koujyosyoumeidType == null && koujyosyoumeid != null) return koujyosyoumeid.getType().toString();
        if (koujyosyoumeidType == null && getKoujyosyoumeidValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'koujyosyoumeid$' should not be NULL."));
        }
        return koujyosyoumeidType;
    }

    protected void setKoujyosyoumeidType(String type) {
        koujyosyoumeidType = type;
        koujyosyoumeid = Optional.fromNullable(toCurrencyType(koujyosyoumeidType))
            .transform(bizCurrencyTransformer(getKoujyosyoumeidValue()))
            .orNull();
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private Integer haitoukanrirenno;

    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.HAITOUKANRIRENNO)
    public Integer getHaitoukanrirenno() {
        return haitoukanrirenno;
    }

    public void setHaitoukanrirenno(Integer pHaitoukanrirenno) {
        haitoukanrirenno = pHaitoukanrirenno;
    }

    private C_HaitoukinsksKbn haitoukinskskbn;

    @Type(type="UserType_C_HaitoukinsksKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.HAITOUKINSKSKBN)
    public C_HaitoukinsksKbn getHaitoukinskskbn() {
        return haitoukinskskbn;
    }

    public void setHaitoukinskskbn(C_HaitoukinsksKbn pHaitoukinskskbn) {
        haitoukinskskbn = pHaitoukinskskbn;
    }

    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @Type(type="UserType_C_HaitoumeisaiKbn")
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.HAITOUMEISAIKBN)
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return haitoumeisaikbn;
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        haitoumeisaikbn = pHaitoumeisaikbn;
    }

    private C_Kjsmhakkouzumiflg kjsmhakkouzumiflg;

    @Type(type="UserType_C_Kjsmhakkouzumiflg")
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.KJSMHAKKOUZUMIFLG)
    public C_Kjsmhakkouzumiflg getKjsmhakkouzumiflg() {
        return kjsmhakkouzumiflg;
    }

    public void setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg pKjsmhakkouzumiflg) {
        kjsmhakkouzumiflg = pKjsmhakkouzumiflg;
    }

    private C_Delflag sakujyoflg;

    @Type(type="UserType_C_Delflag")
    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.SAKUJYOFLG)
    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KoujyoSymNaiyouD.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}