package yuyu.def.db.dao;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.base.Predicate.FilterUserGroupByUserGroupCd;
import yuyu.def.base.Predicate.FilterUserGroupByUserGroupCdGroupNm;
import yuyu.def.base.Predicate.FilterUserGroupByUserGroupNm;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * ユーザーグルプ(AM_UserGroup) テーブルアクセス用の DAO クラスです。
 */
public class AM_UserGroupDao extends AbstractDao<AM_UserGroup> {

    protected AM_UserGroupDao() {
        super(AM_UserGroup.class);
    }


    public AM_UserGroup getAM_UserGroup(String pUserGroupCd){

        AM_UserGroup userGroup = new AM_UserGroup();
        userGroup.setUserGroupCd(pUserGroupCd);

        return selectOne(userGroup);
    }


    public List<AM_UserGroup> getUserGroupsSerchResult(String userGroupCd, String userGroupNm) {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        List<AM_UserGroup> aM_UserGroups = new ArrayList<>();

        if (null != userGroupCd && null == userGroupNm) {
            aM_UserGroups = ImmutableList.copyOf(Iterables.filter(baseDomManager.getAllUserGroups(), new FilterUserGroupByUserGroupCd(userGroupCd)));
        } else if (null == userGroupCd && null != userGroupNm) {
            aM_UserGroups = ImmutableList.copyOf(Iterables.filter(baseDomManager.getAllUserGroups(), new FilterUserGroupByUserGroupNm(userGroupNm)));
        } else if (null == userGroupCd && null == userGroupNm) {
            aM_UserGroups = baseDomManager.getAllUserGroups();
        } else if (null != userGroupCd && null != userGroupNm) {
            aM_UserGroups = ImmutableList.copyOf(Iterables.filter(baseDomManager.getAllUserGroups(), new FilterUserGroupByUserGroupCdGroupNm(userGroupCd, userGroupNm)));
        }

        return aM_UserGroups;
    }

}
