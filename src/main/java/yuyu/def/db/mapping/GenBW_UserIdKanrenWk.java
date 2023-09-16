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
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.id.PKBW_UserIdKanrenWk;
import yuyu.def.db.meta.GenQBW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;

/**
 * ユーザーＩＤ関連ワークテーブル テーブルのマッピング情報クラスで、 {@link BW_UserIdKanrenWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserIdKanrenWk}</td><td colspan="3">ユーザーＩＤ関連ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKBW_UserIdKanrenWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKBW_UserIdKanrenWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_UserIdKanrenWk
 * @see     PKBW_UserIdKanrenWk
 * @see     QBW_UserIdKanrenWk
 * @see     GenQBW_UserIdKanrenWk
 */
@MappedSuperclass
@Table(name=GenBW_UserIdKanrenWk.TABLE_NAME)
@IdClass(value=PKBW_UserIdKanrenWk.class)
public abstract class GenBW_UserIdKanrenWk extends AbstractExDBEntity<BW_UserIdKanrenWk, PKBW_UserIdKanrenWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_UserIdKanrenWk";
    public static final String IDKBN                    = "idkbn";
    public static final String IDCD                     = "idcd";
    public static final String USERID                   = "userId";

    private final PKBW_UserIdKanrenWk primaryKey;

    public GenBW_UserIdKanrenWk() {
        primaryKey = new PKBW_UserIdKanrenWk();
    }

    public GenBW_UserIdKanrenWk(String pIdkbn, String pIdcd) {
        primaryKey = new PKBW_UserIdKanrenWk(pIdkbn, pIdcd);
    }

    @Transient
    @Override
    public PKBW_UserIdKanrenWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_UserIdKanrenWk> getMetaClass() {
        return QBW_UserIdKanrenWk.class;
    }

    @Id
    @Column(name=GenBW_UserIdKanrenWk.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenBW_UserIdKanrenWk.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    private String userId;

    @Column(name=GenBW_UserIdKanrenWk.USERID)
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