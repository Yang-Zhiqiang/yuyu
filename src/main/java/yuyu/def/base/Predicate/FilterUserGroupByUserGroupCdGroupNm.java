package yuyu.def.base.Predicate;

import yuyu.def.db.entity.AM_UserGroup;

import com.google.common.base.Predicate;

/**
 * 不備メッセージテーブル用 Predicate<br/>
 * 不備種別区分   （不一致）
 */
public class FilterUserGroupByUserGroupCdGroupNm implements Predicate<AM_UserGroup>{

    String userGroupCd;
    String userGroupNm;

    public FilterUserGroupByUserGroupCdGroupNm(String pUserGroupCd, String pUserGroupNm){
        super();
        userGroupCd = pUserGroupCd;
        userGroupNm = pUserGroupNm;
    }

    @Override
    public boolean apply(AM_UserGroup pUserGroup) {

        if (pUserGroup.getUserGroupCd().startsWith(userGroupCd) && pUserGroup.getUserGroupNm().matches(".*" + userGroupNm + ".*")) {
            return true;
        }
        return false;
    }
}
