package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.id.PKBM_KanjyouKamoku;
import yuyu.def.db.meta.GenQBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KanjyoukmkgroupKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 勘定科目マスタ テーブルのマッピング情報クラスで、 {@link BM_KanjyouKamoku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KanjyouKamoku}</td><td colspan="3">勘定科目マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKBM_KanjyouKamoku ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getDenkanjokamokucd denkanjokamokucd}</td><td>伝票用勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjyoukmknm kanjyoukmknm}</td><td>勘定科目名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJigyouhiutiwakecd jigyouhiutiwakecd}</td><td>事業費内訳コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJigyouhiutiwakenm jigyouhiutiwakenm}</td><td>事業費内訳名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjybyouhyj hjybyouhyj}</td><td>補助簿要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getHjybtantositucd hjybtantositucd}</td><td>補助簿統括担当室コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjybruigkteiseiumukbn hjybruigkteiseiumukbn}</td><td>補助簿累計額訂正有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkgroupkbn kanjyoukmkgroupkbn}</td><td>勘定科目グループ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KanjyoukmkgroupKbn}</td></tr>
 *  <tr><td>{@link #getKbnkeiriyouhi kbnkeiriyouhi}</td><td>区分経理要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_KanjyouKamoku
 * @see     PKBM_KanjyouKamoku
 * @see     QBM_KanjyouKamoku
 * @see     GenQBM_KanjyouKamoku
 */
@MappedSuperclass
@Table(name=GenBM_KanjyouKamoku.TABLE_NAME)
@IdClass(value=PKBM_KanjyouKamoku.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KanjyoukmkgroupKbn", typeClass=UserType_C_KanjyoukmkgroupKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenBM_KanjyouKamoku extends AbstractExDBEntity<BM_KanjyouKamoku, PKBM_KanjyouKamoku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KanjyouKamoku";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String DENKANJOKAMOKUCD         = "denkanjokamokucd";
    public static final String KANJYOUKMKNM             = "kanjyoukmknm";
    public static final String JIGYOUHIUTIWAKECD        = "jigyouhiutiwakecd";
    public static final String JIGYOUHIUTIWAKENM        = "jigyouhiutiwakenm";
    public static final String HJYBYOUHYJ               = "hjybyouhyj";
    public static final String HJYBTANTOSITUCD          = "hjybtantositucd";
    public static final String HJYBRUIGKTEISEIUMUKBN    = "hjybruigkteiseiumukbn";
    public static final String KANJYOUKMKGROUPKBN       = "kanjyoukmkgroupkbn";
    public static final String KBNKEIRIYOUHI            = "kbnkeiriyouhi";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_KanjyouKamoku primaryKey;

    public GenBM_KanjyouKamoku() {
        primaryKey = new PKBM_KanjyouKamoku();
    }

    public GenBM_KanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd) {
        primaryKey = new PKBM_KanjyouKamoku(pKanjyoukmkcd);
    }

    @Transient
    @Override
    public PKBM_KanjyouKamoku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KanjyouKamoku> getMetaClass() {
        return QBM_KanjyouKamoku.class;
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBM_KanjyouKamoku.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    private String denkanjokamokucd;

    @Column(name=GenBM_KanjyouKamoku.DENKANJOKAMOKUCD)
    public String getDenkanjokamokucd() {
        return denkanjokamokucd;
    }

    public void setDenkanjokamokucd(String pDenkanjokamokucd) {
        denkanjokamokucd = pDenkanjokamokucd;
    }

    private String kanjyoukmknm;

    @Column(name=GenBM_KanjyouKamoku.KANJYOUKMKNM)
    public String getKanjyoukmknm() {
        return kanjyoukmknm;
    }

    public void setKanjyoukmknm(String pKanjyoukmknm) {
        kanjyoukmknm = pKanjyoukmknm;
    }

    private String jigyouhiutiwakecd;

    @Column(name=GenBM_KanjyouKamoku.JIGYOUHIUTIWAKECD)
    public String getJigyouhiutiwakecd() {
        return jigyouhiutiwakecd;
    }

    public void setJigyouhiutiwakecd(String pJigyouhiutiwakecd) {
        jigyouhiutiwakecd = pJigyouhiutiwakecd;
    }

    private String jigyouhiutiwakenm;

    @Column(name=GenBM_KanjyouKamoku.JIGYOUHIUTIWAKENM)
    public String getJigyouhiutiwakenm() {
        return jigyouhiutiwakenm;
    }

    public void setJigyouhiutiwakenm(String pJigyouhiutiwakenm) {
        jigyouhiutiwakenm = pJigyouhiutiwakenm;
    }

    private C_YouhiKbn hjybyouhyj;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenBM_KanjyouKamoku.HJYBYOUHYJ)
    public C_YouhiKbn getHjybyouhyj() {
        return hjybyouhyj;
    }

    public void setHjybyouhyj(C_YouhiKbn pHjybyouhyj) {
        hjybyouhyj = pHjybyouhyj;
    }

    private String hjybtantositucd;

    @Column(name=GenBM_KanjyouKamoku.HJYBTANTOSITUCD)
    public String getHjybtantositucd() {
        return hjybtantositucd;
    }

    public void setHjybtantositucd(String pHjybtantositucd) {
        hjybtantositucd = pHjybtantositucd;
    }

    private C_UmuKbn hjybruigkteiseiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_KanjyouKamoku.HJYBRUIGKTEISEIUMUKBN)
    public C_UmuKbn getHjybruigkteiseiumukbn() {
        return hjybruigkteiseiumukbn;
    }

    public void setHjybruigkteiseiumukbn(C_UmuKbn pHjybruigkteiseiumukbn) {
        hjybruigkteiseiumukbn = pHjybruigkteiseiumukbn;
    }

    private C_KanjyoukmkgroupKbn kanjyoukmkgroupkbn;

    @Type(type="UserType_C_KanjyoukmkgroupKbn")
    @Column(name=GenBM_KanjyouKamoku.KANJYOUKMKGROUPKBN)
    public C_KanjyoukmkgroupKbn getKanjyoukmkgroupkbn() {
        return kanjyoukmkgroupkbn;
    }

    public void setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn pKanjyoukmkgroupkbn) {
        kanjyoukmkgroupkbn = pKanjyoukmkgroupkbn;
    }

    private C_YouhiKbn kbnkeiriyouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenBM_KanjyouKamoku.KBNKEIRIYOUHI)
    public C_YouhiKbn getKbnkeiriyouhi() {
        return kbnkeiriyouhi;
    }

    public void setKbnkeiriyouhi(C_YouhiKbn pKbnkeiriyouhi) {
        kbnkeiriyouhi = pKbnkeiriyouhi;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_KanjyouKamoku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_KanjyouKamoku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}