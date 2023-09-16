package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.id.PKJM_ChkSiJimuttdk;
import yuyu.def.db.meta.GenQJM_ChkSiJimuttdk;
import yuyu.def.db.meta.QJM_ChkSiJimuttdk;
import yuyu.def.db.type.UserType_C_SKNaiyouChkKbn;

/**
 * 支払事務手続チェックマスタ テーブルのマッピング情報クラスで、 {@link JM_ChkSiJimuttdk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_ChkSiJimuttdk}</td><td colspan="3">支払事務手続チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKJM_ChkSiJimuttdk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorijimuttdkcd syorijimuttdkcd}</td><td>処理中事務手続コード</td><td align="center">{@link PKJM_ChkSiJimuttdk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSknaiyouchkkbn sknaiyouchkkbn}</td><td>請求内容チェック区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SKNaiyouChkKbn}</td></tr>
 * </table>
 * @see     JM_ChkSiJimuttdk
 * @see     PKJM_ChkSiJimuttdk
 * @see     QJM_ChkSiJimuttdk
 * @see     GenQJM_ChkSiJimuttdk
 */
@MappedSuperclass
@Table(name=GenJM_ChkSiJimuttdk.TABLE_NAME)
@IdClass(value=PKJM_ChkSiJimuttdk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SKNaiyouChkKbn", typeClass=UserType_C_SKNaiyouChkKbn.class)
})
public abstract class GenJM_ChkSiJimuttdk extends AbstractExDBEntity<JM_ChkSiJimuttdk, PKJM_ChkSiJimuttdk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_ChkSiJimuttdk";
    public static final String KINOUID                  = "kinouId";
    public static final String SYORIJIMUTTDKCD          = "syorijimuttdkcd";
    public static final String SKNAIYOUCHKKBN           = "sknaiyouchkkbn";

    private final PKJM_ChkSiJimuttdk primaryKey;

    public GenJM_ChkSiJimuttdk() {
        primaryKey = new PKJM_ChkSiJimuttdk();
    }

    public GenJM_ChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {
        primaryKey = new PKJM_ChkSiJimuttdk(pKinouId, pSyorijimuttdkcd);
    }

    @Transient
    @Override
    public PKJM_ChkSiJimuttdk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_ChkSiJimuttdk> getMetaClass() {
        return QJM_ChkSiJimuttdk.class;
    }

    @Id
    @Column(name=GenJM_ChkSiJimuttdk.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenJM_ChkSiJimuttdk.SYORIJIMUTTDKCD)
    public String getSyorijimuttdkcd() {
        return getPrimaryKey().getSyorijimuttdkcd();
    }

    public void setSyorijimuttdkcd(String pSyorijimuttdkcd) {
        getPrimaryKey().setSyorijimuttdkcd(pSyorijimuttdkcd);
    }

    private C_SKNaiyouChkKbn sknaiyouchkkbn;

    @Type(type="UserType_C_SKNaiyouChkKbn")
    @Column(name=GenJM_ChkSiJimuttdk.SKNAIYOUCHKKBN)
    public C_SKNaiyouChkKbn getSknaiyouchkkbn() {
        return sknaiyouchkkbn;
    }

    public void setSknaiyouchkkbn(C_SKNaiyouChkKbn pSknaiyouchkkbn) {
        sknaiyouchkkbn = pSknaiyouchkkbn;
    }
}