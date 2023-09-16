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
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.id.PKAT_UserIdKanren;
import yuyu.def.db.meta.GenQAT_UserIdKanren;
import yuyu.def.db.meta.QAT_UserIdKanren;

/**
 * ユーザーＩＤ関連テーブル テーブルのマッピング情報クラスで、 {@link AT_UserIdKanren} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserIdKanren}</td><td colspan="3">ユーザーＩＤ関連テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKAT_UserIdKanren ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKAT_UserIdKanren ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_UserIdKanren
 * @see     PKAT_UserIdKanren
 * @see     QAT_UserIdKanren
 * @see     GenQAT_UserIdKanren
 */
@MappedSuperclass
@Table(name=GenAT_UserIdKanren.TABLE_NAME)
@IdClass(value=PKAT_UserIdKanren.class)
public abstract class GenAT_UserIdKanren extends AbstractExDBEntity<AT_UserIdKanren, PKAT_UserIdKanren> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_UserIdKanren";
    public static final String IDKBN                    = "idkbn";
    public static final String IDCD                     = "idcd";
    public static final String USERID                   = "userId";

    private final PKAT_UserIdKanren primaryKey;

    public GenAT_UserIdKanren() {
        primaryKey = new PKAT_UserIdKanren();
    }

    public GenAT_UserIdKanren(String pIdkbn, String pIdcd) {
        primaryKey = new PKAT_UserIdKanren(pIdkbn, pIdcd);
    }

    @Transient
    @Override
    public PKAT_UserIdKanren getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_UserIdKanren> getMetaClass() {
        return QAT_UserIdKanren.class;
    }

    @Id
    @Column(name=GenAT_UserIdKanren.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenAT_UserIdKanren.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    private String userId;

    @Column(name=GenAT_UserIdKanren.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }
}