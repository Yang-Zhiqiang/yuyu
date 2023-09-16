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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.IT_BAK_YykIdouUktk;
import yuyu.def.db.id.PKIT_BAK_YykIdouUktk;
import yuyu.def.db.meta.GenQIT_BAK_YykIdouUktk;
import yuyu.def.db.meta.QIT_BAK_YykIdouUktk;
import yuyu.def.db.type.UserType_C_YykidousyoriKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 予約異動受付バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_YykIdouUktk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_YykIdouUktk}</td><td colspan="3">予約異動受付バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_YykIdouUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_YykIdouUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_YykIdouUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_YykIdouUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIT_BAK_YykIdouUktk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYykidousyorikbn yykidousyorikbn}</td><td>予約異動処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YykidousyoriKbn}</td></tr>
 *  <tr><td>{@link #getUktkymd uktkymd}</td><td>受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_YykIdouUktk
 * @see     PKIT_BAK_YykIdouUktk
 * @see     QIT_BAK_YykIdouUktk
 * @see     GenQIT_BAK_YykIdouUktk
 */
@MappedSuperclass
@Table(name=GenIT_BAK_YykIdouUktk.TABLE_NAME)
@IdClass(value=PKIT_BAK_YykIdouUktk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_YykidousyoriKbn", typeClass=UserType_C_YykidousyoriKbn.class)
})
public abstract class GenIT_BAK_YykIdouUktk extends AbstractExDBEntity<IT_BAK_YykIdouUktk, PKIT_BAK_YykIdouUktk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_YykIdouUktk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String KINOUID                  = "kinouId";
    public static final String YYKIDOUSYORIKBN          = "yykidousyorikbn";
    public static final String UKTKYMD                  = "uktkymd";
    public static final String SYORIYM                  = "syoriym";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_YykIdouUktk primaryKey;

    public GenIT_BAK_YykIdouUktk() {
        primaryKey = new PKIT_BAK_YykIdouUktk();
    }

    public GenIT_BAK_YykIdouUktk(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey,
        String pKinouId
    ) {
        primaryKey = new PKIT_BAK_YykIdouUktk(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey,
            pKinouId
        );
    }

    @Transient
    @Override
    public PKIT_BAK_YykIdouUktk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_YykIdouUktk> getMetaClass() {
        return QIT_BAK_YykIdouUktk.class;
    }

    @Id
    @Column(name=GenIT_BAK_YykIdouUktk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_YykIdouUktk.SYONO)
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
    @Column(name=GenIT_BAK_YykIdouUktk.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_YykIdouUktk.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_YykIdouUktk.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private C_YykidousyoriKbn yykidousyorikbn;

    @Type(type="UserType_C_YykidousyoriKbn")
    @Column(name=GenIT_BAK_YykIdouUktk.YYKIDOUSYORIKBN)
    public C_YykidousyoriKbn getYykidousyorikbn() {
        return yykidousyorikbn;
    }

    public void setYykidousyorikbn(C_YykidousyoriKbn pYykidousyorikbn) {
        yykidousyorikbn = pYykidousyorikbn;
    }

    private BizDate uktkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_YykIdouUktk.UKTKYMD)
    public BizDate getUktkymd() {
        return uktkymd;
    }

    public void setUktkymd(BizDate pUktkymd) {
        uktkymd = pUktkymd;
    }

    private BizDateYM syoriym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_YykIdouUktk.SYORIYM)
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_YykIdouUktk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_YykIdouUktk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_YykIdouUktk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}