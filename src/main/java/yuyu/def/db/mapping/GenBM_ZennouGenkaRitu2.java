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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;
import yuyu.def.db.id.PKBM_ZennouGenkaRitu2;
import yuyu.def.db.meta.GenQBM_ZennouGenkaRitu2;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu2;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 前納現価率マスタ２ テーブルのマッピング情報クラスで、 {@link BM_ZennouGenkaRitu2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouGenkaRitu2}</td><td colspan="3">前納現価率マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getZennoutkybr1 zennoutkybr1}</td><td>前納適用分類１</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoutkybr2 zennoutkybr2}</td><td>前納適用分類２</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennoutkybr3 zennoutkybr3}</td><td>前納適用分類３</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennounensuu zennounensuu}</td><td>前納年数</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">{@link PKBM_ZennouGenkaRitu2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZennougenkaritu zennougenkaritu}</td><td>前納現価率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouGenkaRitu2
 * @see     PKBM_ZennouGenkaRitu2
 * @see     QBM_ZennouGenkaRitu2
 * @see     GenQBM_ZennouGenkaRitu2
 */
@MappedSuperclass
@Table(name=GenBM_ZennouGenkaRitu2.TABLE_NAME)
@IdClass(value=PKBM_ZennouGenkaRitu2.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBM_ZennouGenkaRitu2 extends AbstractExDBEntity<BM_ZennouGenkaRitu2, PKBM_ZennouGenkaRitu2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ZennouGenkaRitu2";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String ZENNOUTKYBR1             = "zennoutkybr1";
    public static final String ZENNOUTKYBR2             = "zennoutkybr2";
    public static final String ZENNOUTKYBR3             = "zennoutkybr3";
    public static final String ZENNOUNENSUU             = "zennounensuu";
    public static final String TEKIYOUKKNFROM           = "tekiyoukknfrom";
    public static final String TEKIYOUKKNKTO            = "tekiyoukknkto";
    public static final String ZENNOUGENKARITU          = "zennougenkaritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_ZennouGenkaRitu2 primaryKey;

    public GenBM_ZennouGenkaRitu2() {
        primaryKey = new PKBM_ZennouGenkaRitu2();
    }

    public GenBM_ZennouGenkaRitu2(
        C_Tuukasyu pTuukasyu,
        String pZennoutkybr1,
        String pZennoutkybr2,
        String pZennoutkybr3,
        Integer pZennounensuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        primaryKey = new PKBM_ZennouGenkaRitu2(
            pTuukasyu,
            pZennoutkybr1,
            pZennoutkybr2,
            pZennoutkybr3,
            pZennounensuu,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

    @Transient
    @Override
    public PKBM_ZennouGenkaRitu2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ZennouGenkaRitu2> getMetaClass() {
        return QBM_ZennouGenkaRitu2.class;
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_ZennouGenkaRitu2.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.ZENNOUTKYBR1)
    public String getZennoutkybr1() {
        return getPrimaryKey().getZennoutkybr1();
    }

    public void setZennoutkybr1(String pZennoutkybr1) {
        getPrimaryKey().setZennoutkybr1(pZennoutkybr1);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.ZENNOUTKYBR2)
    public String getZennoutkybr2() {
        return getPrimaryKey().getZennoutkybr2();
    }

    public void setZennoutkybr2(String pZennoutkybr2) {
        getPrimaryKey().setZennoutkybr2(pZennoutkybr2);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.ZENNOUTKYBR3)
    public String getZennoutkybr3() {
        return getPrimaryKey().getZennoutkybr3();
    }

    public void setZennoutkybr3(String pZennoutkybr3) {
        getPrimaryKey().setZennoutkybr3(pZennoutkybr3);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.ZENNOUNENSUU)
    public Integer getZennounensuu() {
        return getPrimaryKey().getZennounensuu();
    }

    public void setZennounensuu(Integer pZennounensuu) {
        getPrimaryKey().setZennounensuu(pZennounensuu);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.TEKIYOUKKNFROM)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknfrom() {
        return getPrimaryKey().getTekiyoukknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        getPrimaryKey().setTekiyoukknfrom(pTekiyoukknfrom);
    }

    @Id
    @Column(name=GenBM_ZennouGenkaRitu2.TEKIYOUKKNKTO)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknkto() {
        return getPrimaryKey().getTekiyoukknkto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknkto(String pTekiyoukknkto) {
        getPrimaryKey().setTekiyoukknkto(pTekiyoukknkto);
    }

    private BizNumber zennougenkaritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ZennouGenkaRitu2.ZENNOUGENKARITU)
    public BizNumber getZennougenkaritu() {
        return zennougenkaritu;
    }

    public void setZennougenkaritu(BizNumber pZennougenkaritu) {
        zennougenkaritu = pZennougenkaritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_ZennouGenkaRitu2.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_ZennouGenkaRitu2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_ZennouGenkaRitu2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}