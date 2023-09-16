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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.id.PKAM_UserGroup;
import yuyu.def.db.meta.GenQAM_UserGroup;
import yuyu.def.db.meta.QAM_UserGroup;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * ユーザーグループマスタ テーブルのマッピング情報クラスで、 {@link AM_UserGroup} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_UserGroup}</td><td colspan="3">ユーザーグループマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserGroupCd userGroupCd}</td><td>ユーザーグループコード</td><td align="center">{@link PKAM_UserGroup ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserGroupNm userGroupNm}</td><td>ユーザーグループ名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUserGroupSetumei userGroupSetumei}</td><td>ユーザーグループ説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_UserGroup
 * @see     PKAM_UserGroup
 * @see     QAM_UserGroup
 * @see     GenQAM_UserGroup
 */
@MappedSuperclass
@Table(name=GenAM_UserGroup.TABLE_NAME)
@IdClass(value=PKAM_UserGroup.class)
public abstract class GenAM_UserGroup extends AbstractExDBEntity<AM_UserGroup, PKAM_UserGroup> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_UserGroup";
    public static final String USERGROUPCD              = "userGroupCd";
    public static final String USERGROUPNM              = "userGroupNm";
    public static final String USERGROUPSETUMEI         = "userGroupSetumei";

    private final PKAM_UserGroup primaryKey;

    public GenAM_UserGroup() {
        primaryKey = new PKAM_UserGroup();
    }

    public GenAM_UserGroup(String pUserGroupCd) {
        primaryKey = new PKAM_UserGroup(pUserGroupCd);
    }

    @Transient
    @Override
    public PKAM_UserGroup getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_UserGroup> getMetaClass() {
        return QAM_UserGroup.class;
    }

    @Id
    @Column(name=GenAM_UserGroup.USERGROUPCD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserGroupCd() {
        return getPrimaryKey().getUserGroupCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserGroupCd(String pUserGroupCd) {
        getPrimaryKey().setUserGroupCd(pUserGroupCd);
    }

    private String userGroupNm;

    @Column(name=GenAM_UserGroup.USERGROUPNM)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getUserGroupNm() {
        return userGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUserGroupNm(String pUserGroupNm) {
        userGroupNm = pUserGroupNm;
    }

    private String userGroupSetumei;

    @Column(name=GenAM_UserGroup.USERGROUPSETUMEI)
    @MaxLength(max=100)
    @InvalidCharacter
    public String getUserGroupSetumei() {
        return userGroupSetumei;
    }

    @Trim("right")
    public void setUserGroupSetumei(String pUserGroupSetumei) {
        userGroupSetumei = pUserGroupSetumei;
    }
}