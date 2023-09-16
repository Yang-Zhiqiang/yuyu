package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.mapping.GenAM_UserGroup;
import yuyu.def.db.meta.GenQAM_UserGroup;
import yuyu.def.db.meta.QAM_UserGroup;

/**
 * ユーザーグループマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_UserGroup}</td><td colspan="3">ユーザーグループマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserGroupCd userGroupCd}</td><td>ユーザーグループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userGroupNm</td><td>ユーザーグループ名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userGroupSetumei</td><td>ユーザーグループ説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_UserGroup
 * @see     GenAM_UserGroup
 * @see     QAM_UserGroup
 * @see     GenQAM_UserGroup
 */
public class PKAM_UserGroup extends AbstractExDBPrimaryKey<AM_UserGroup, PKAM_UserGroup> {

    private static final long serialVersionUID = 1L;

    public PKAM_UserGroup() {
    }

    public PKAM_UserGroup(String pUserGroupCd) {
        userGroupCd = pUserGroupCd;
    }

    @Transient
    @Override
    public Class<AM_UserGroup> getEntityClass() {
        return AM_UserGroup.class;
    }

    private String userGroupCd;

    public String getUserGroupCd() {
        return userGroupCd;
    }

    public void setUserGroupCd(String pUserGroupCd) {
        userGroupCd = pUserGroupCd;
    }

}