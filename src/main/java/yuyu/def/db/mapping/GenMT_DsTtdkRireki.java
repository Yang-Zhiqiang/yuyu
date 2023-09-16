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
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.db.id.PKMT_DsTtdkRireki;
import yuyu.def.db.meta.GenQMT_DsTtdkRireki;
import yuyu.def.db.meta.QMT_DsTtdkRireki;
import yuyu.def.db.type.UserType_C_DsSyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * ＤＳ手続履歴テーブル テーブルのマッピング情報クラスで、 {@link MT_DsTtdkRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTtdkRireki}</td><td colspan="3">ＤＳ手続履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsTtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKMT_DsTtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDssyorikbn dssyorikbn}</td><td>ＤＳ処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyoriKbn}</td></tr>
 *  <tr><td>{@link #getHenkourrkumu henkourrkumu}</td><td>変更履歴有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTtdkRireki
 * @see     PKMT_DsTtdkRireki
 * @see     QMT_DsTtdkRireki
 * @see     GenQMT_DsTtdkRireki
 */
@MappedSuperclass
@Table(name=GenMT_DsTtdkRireki.TABLE_NAME)
@IdClass(value=PKMT_DsTtdkRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSyoriKbn", typeClass=UserType_C_DsSyoriKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenMT_DsTtdkRireki extends AbstractExDBEntity<MT_DsTtdkRireki, PKMT_DsTtdkRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsTtdkRireki";
    public static final String DSKOKNO                  = "dskokno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DSSYORIKBN               = "dssyorikbn";
    public static final String HENKOURRKUMU             = "henkourrkumu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_DsTtdkRireki primaryKey;

    public GenMT_DsTtdkRireki() {
        primaryKey = new PKMT_DsTtdkRireki();
    }

    public GenMT_DsTtdkRireki(String pDskokno, String pHenkousikibetukey) {
        primaryKey = new PKMT_DsTtdkRireki(pDskokno, pHenkousikibetukey);
    }

    @Transient
    @Override
    public PKMT_DsTtdkRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsTtdkRireki> getMetaClass() {
        return QMT_DsTtdkRireki.class;
    }

    @Id
    @Column(name=GenMT_DsTtdkRireki.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsTtdkRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTtdkRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_DsSyoriKbn dssyorikbn;

    @Type(type="UserType_C_DsSyoriKbn")
    @Column(name=GenMT_DsTtdkRireki.DSSYORIKBN)
    public C_DsSyoriKbn getDssyorikbn() {
        return dssyorikbn;
    }

    public void setDssyorikbn(C_DsSyoriKbn pDssyorikbn) {
        dssyorikbn = pDssyorikbn;
    }

    private C_UmuKbn henkourrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenMT_DsTtdkRireki.HENKOURRKUMU)
    public C_UmuKbn getHenkourrkumu() {
        return henkourrkumu;
    }

    public void setHenkourrkumu(C_UmuKbn pHenkourrkumu) {
        henkourrkumu = pHenkourrkumu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsTtdkRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsTtdkRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsTtdkRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}