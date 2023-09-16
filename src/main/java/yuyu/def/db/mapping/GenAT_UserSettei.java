package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NiGamenModeJyoutaiKbn;
import yuyu.def.db.entity.AT_UserSettei;
import yuyu.def.db.id.PKAT_UserSettei;
import yuyu.def.db.meta.GenQAT_UserSettei;
import yuyu.def.db.meta.QAT_UserSettei;
import yuyu.def.db.type.UserType_C_NiGamenModeJyoutaiKbn;

/**
 * ユーザー設定テーブル テーブルのマッピング情報クラスで、 {@link AT_UserSettei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserSettei}</td><td colspan="3">ユーザー設定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKAT_UserSettei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNiGamenModKbn niGamenModKbn}</td><td>２画面モード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NiGamenModeJyoutaiKbn}</td></tr>
 * </table>
 * @see     AT_UserSettei
 * @see     PKAT_UserSettei
 * @see     QAT_UserSettei
 * @see     GenQAT_UserSettei
 */
@MappedSuperclass
@Table(name=GenAT_UserSettei.TABLE_NAME)
@IdClass(value=PKAT_UserSettei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NiGamenModeJyoutaiKbn", typeClass=UserType_C_NiGamenModeJyoutaiKbn.class)
})
public abstract class GenAT_UserSettei extends AbstractExDBEntity<AT_UserSettei, PKAT_UserSettei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_UserSettei";
    public static final String USERID                   = "userId";
    public static final String NIGAMENMODKBN            = "niGamenModKbn";

    private final PKAT_UserSettei primaryKey;

    public GenAT_UserSettei() {
        primaryKey = new PKAT_UserSettei();
    }

    public GenAT_UserSettei(String pUserId) {
        primaryKey = new PKAT_UserSettei(pUserId);
    }

    @Transient
    @Override
    public PKAT_UserSettei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_UserSettei> getMetaClass() {
        return QAT_UserSettei.class;
    }

    @Id
    @Column(name=GenAT_UserSettei.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return getPrimaryKey().getUserId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        getPrimaryKey().setUserId(pUserId);
    }

    private C_NiGamenModeJyoutaiKbn niGamenModKbn;

    @Type(type="UserType_C_NiGamenModeJyoutaiKbn")
    @Column(name=GenAT_UserSettei.NIGAMENMODKBN)
    public C_NiGamenModeJyoutaiKbn getNiGamenModKbn() {
        return niGamenModKbn;
    }

    public void setNiGamenModKbn(C_NiGamenModeJyoutaiKbn pNiGamenModKbn) {
        niGamenModKbn = pNiGamenModKbn;
    }
}
