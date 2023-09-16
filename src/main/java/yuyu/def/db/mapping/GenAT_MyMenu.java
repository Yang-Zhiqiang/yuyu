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
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.id.PKAT_MyMenu;
import yuyu.def.db.meta.GenQAT_MyMenu;
import yuyu.def.db.meta.QAT_MyMenu;

/**
 * マイメニューテーブル テーブルのマッピング情報クラスで、 {@link AT_MyMenu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_MyMenu}</td><td colspan="3">マイメニューテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKAT_MyMenu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAT_MyMenu ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_MyMenu
 * @see     PKAT_MyMenu
 * @see     QAT_MyMenu
 * @see     GenQAT_MyMenu
 */
@MappedSuperclass
@Table(name=GenAT_MyMenu.TABLE_NAME)
@IdClass(value=PKAT_MyMenu.class)
public abstract class GenAT_MyMenu extends AbstractExDBEntity<AT_MyMenu, PKAT_MyMenu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_MyMenu";
    public static final String USERID                   = "userId";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYID               = "categoryId";
    public static final String KINOUID                  = "kinouId";

    private final PKAT_MyMenu primaryKey;

    public GenAT_MyMenu() {
        primaryKey = new PKAT_MyMenu();
    }

    public GenAT_MyMenu(String pUserId, String pKinouId) {
        primaryKey = new PKAT_MyMenu(pUserId, pKinouId);
    }

    @Transient
    @Override
    public PKAT_MyMenu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_MyMenu> getMetaClass() {
        return QAT_MyMenu.class;
    }

    @Id
    @Column(name=GenAT_MyMenu.USERID)
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

    private String subSystemId;

    @Column(name=GenAT_MyMenu.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    @Column(name=GenAT_MyMenu.CATEGORYID)
    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    @Id
    @Column(name=GenAT_MyMenu.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }
}
