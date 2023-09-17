package yuyu.def.base.Predicate;

import yuyu.def.db.entity.AM_UserGroup;

import com.google.common.base.Predicate;

/**
 * 不備メッセージテーブル用 Predicate<br/>
 * 不備種別区分   （不一致）
 */
public class FilterUserGroupByUserGroupCd implements Predicate<AM_UserGroup>{

    String userGroupCd;

    public FilterUserGroupByUserGroupCd(String pUserGroupCd){
        super();
        userGroupCd = pUserGroupCd;
    }

    @Override
    public boolean apply(AM_UserGroup pUserGroup) {

        if ((pUserGroup.getUserGroupCd()).startsWith(userGroupCd)){
            return true;
        }
        return false;
    }
}
