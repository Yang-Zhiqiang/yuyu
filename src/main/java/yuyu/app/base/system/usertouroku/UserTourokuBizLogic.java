package yuyu.app.base.system.usertouroku;

import static yuyu.app.base.system.usertouroku.GenUserTourokuConstants.*;
import static yuyu.def.enumeration.E_SyoriKbn.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.common.base.collection.predicate.CheckedCommonCheckBoxPredicate;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.infr.entity.YuyuEntityUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * ユーザー登録 のビジネスロジックです。
 */
public class UserTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private UserTourokuUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseDomManager manager;

    @Inject
    private ConversationStatus status;

    @Inject
    private BaseUserInfo loginUserInfo;

    @Inject
    private UniqueKeyGenerator unique;

    void init() {
        clear();
    }

    void clear() {
        uiBean.setUser(new AM_User());
        uiBean.setRoleInfo(null);
    }

    void setupUiBeanUser(){

        AM_User user = manager.getUser(uiBean.getUser().getUserId());

        chkUserInfo(user);

        switch (status.getSyoriKbn()) {

            case EDIT:
                uiBean.setUser(user);
                setRoleList();
                break;

            default:
                throw new UnknownForwardException();
        }

    }

    void searchRoleInfo() {

        List<AT_RoleSiyouKanouSosiki> roleSiyouKanouSosikiList =
            manager.getRoleSiyouKanouSosikisBySyozokusosikicd(uiBean.getSrchsosikicd());

        List<AM_Role> roleList = Lists.newArrayList();
        List<String> roleCdList = Lists.newArrayList();
        List<String> roleSiyouKanouSosikiRoleCdList = Lists.newArrayList();

        if (roleSiyouKanouSosikiList.size() > 0) {
            for (AT_RoleSiyouKanouSosiki roleSiyouKanouSosiki : roleSiyouKanouSosikiList) {
                roleSiyouKanouSosikiRoleCdList.add(roleSiyouKanouSosiki.getRoleCd());
            }

            for (int i = 0; i < roleSiyouKanouSosikiList.size(); i++) {
                if (i == 0){
                    roleList.add(roleSiyouKanouSosikiList.get(i).getRole());
                }

                else if (!roleSiyouKanouSosikiList.get(i).getRoleCd().equals
                    (roleSiyouKanouSosikiList.get(i - 1).getRoleCd())){
                    roleList.add(roleSiyouKanouSosikiList.get(i).getRole());
                }
            }
        }

        List<RoleInfoDataSourceBean> roleInfoDataSourceBeanList =
            BeanUtil.createList(RoleInfoDataSourceBean.class,
                ImmutableList.copyOf(Iterables.filter(roleList, new RoleEntityPredicate())));

        for (RoleInfoDataSourceBean roleInfoDsBean : roleInfoDataSourceBeanList) {
            roleCdList.add(roleInfoDsBean.getRoleCd());
        }

        if (uiBean.getRoleInfoDataSource().getDatas() != null) {
            List<RoleInfoDataSourceBean> filteredList = ImmutableList.copyOf(
                Iterables.filter(uiBean.getRoleInfoDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

            for (RoleInfoDataSourceBean checkedDsBean : filteredList) {
                if (roleCdList.contains(checkedDsBean.getRoleCd())) {
                    for (RoleInfoDataSourceBean roleInfoDsBeanTemp : roleInfoDataSourceBeanList) {
                        if (roleInfoDsBeanTemp.getRoleCd().equals(checkedDsBean.getRoleCd())) {
                            roleInfoDsBeanTemp.setCommonCheckBox(true);
                        }
                    }
                    continue;
                }

                roleInfoDataSourceBeanList.add(checkedDsBean);
            }
        }

        Ordering<RoleInfoDataSourceBean> ordering = Ordering.natural().nullsLast().onResultOf(new RoleEntitySortFunction ());
        List<RoleInfoDataSourceBean> sortedRoleInfoDataSourceBeanList = ordering.sortedCopy(roleInfoDataSourceBeanList);

        uiBean.setRoleInfo(sortedRoleInfoDataSourceBeanList);
    }

    @Transactional
    void commitUser(){
        AM_User user = uiBean.getUser();

        switch (status.getSyoriKbn()) {
            case EDIT:
                addUserRoleRireki(C_RirekiSyuruiKbn.EDIT);

                user.setSpecialUserKbn(C_SpecialUserKbn.IPPAN);
                setupUserRoles();

                AccessLog.UserModify.log(user.getUserId());

                if (loginUserInfo.getUserId().equals(user.getUserId())) {
                    loginUserInfo.refresh();
                }

                manager.update(user);

                break;
            default:
                throw new UnknownForwardException();
        }
        messageManager.addMessageId(MessageId.IAC0009);
    }

    void setConfirmMessage(){

        switch (status.getSyoriKbn()) {
            case EDIT:

                List<RoleInfoDataSourceBean> filteredList = ImmutableList.copyOf(
                    Iterables.filter(uiBean.getRoleInfoDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

                if (filteredList.size() > 0) {
                    messageManager.addMessageId(MessageId.QAC0009);
                }
                else {
                    messageManager.addMessageId(MessageId.QAC1001);
                }

                break;

            default:      throw new UnknownForwardException();
        }
    }

    void chkReferenceMaster(){

        if(!chkExistUserRole()){
            throw new BizLogicException(MessageId.EAC0046, MessageUtil.getMessage(MessageId.IAW0037));
        }
    }

    void setRoleInfoDataSource(){

        if(uiBean.getRoleInfoDataSource().getDatas() == null){
            uiBean.setRoleInfo(new ArrayList<RoleInfoDataSourceBean>());
        }
    }

    void checkMeigininNmKanji(){

        boolean meigininNmKjFlg =
            CheckMeigininNmKanji.isCheckOK(uiBean.getUser().getUserNm(), C_Kojinhjn.KOJIN);

        if (!meigininNmKjFlg) {
            throw new BizLogicException(MessageId.EBC0002, DDID_KEYINFOINPUT_USERNM);
        }
    }

    private void chkUserInfo(AM_User pUser) {

        switch (status.getSyoriKbn()) {

            case EDIT:

                chkExistUser(pUser);
                chkSystemUser(pUser);
                break;

            default:
                throw new UnknownForwardException();
        }
    }

    private void chkExistUser(AM_User pUser) {
        if(pUser == null){
            throw new BizLogicException(MessageId.EAC0001, DDID_KEYINFOINPUT_USERID);
        }
    }

    private void chkSystemUser(AM_User pUser) {
        for (AT_UserRole userRole : pUser.getUserRoles()) {
            if (C_SysSiyouKbn.SYSSIYOU.eq( userRole.getRole().getSysSiyouKbn())) {
                throw new BizLogicException(MessageId.EAF0025, DDID_KEYINFOINPUT_USERID);
            }
        }
    }

    private void setRoleList(){

        List<AT_UserRole> userRolelist = uiBean.getUser().getUserRoles();

        List<RoleInfoDataSourceBean> roleInfoDataSourceBeanList = Lists.newArrayList();

        if (userRolelist.size() > 0) {
            for (AT_UserRole userRole : userRolelist) {

                RoleInfoDataSourceBean roleInfoDataSourceBean = SWAKInjector.getInstance(RoleInfoDataSourceBean.class);

                roleInfoDataSourceBean.setCommonCheckBox(true);
                roleInfoDataSourceBean.setRoleCd(userRole.getRoleCd());
                roleInfoDataSourceBean.setRoleNm(userRole.getRole().getRoleNm());
                roleInfoDataSourceBean.setRoleSetumei(userRole.getRole().getRoleSetumei());

                roleInfoDataSourceBeanList.add(roleInfoDataSourceBean);
            }
        }

        uiBean.setRoleInfo(roleInfoDataSourceBeanList);
    }

    private void setupUserRoles(){

        List<RoleInfoDataSourceBean> filteredList = ImmutableList.copyOf(
            Iterables.filter(uiBean.getRoleInfoDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

        if (status.getSyoriKbn() == EDIT){

            List<AT_UserRole> userRoles = Lists.newArrayList();

            for(RoleInfoDataSourceBean ds : filteredList){

                AT_UserRole userRole = new AT_UserRole();
                userRole.setUserId(uiBean.getUser().getUserId());
                userRole.setRoleCd(ds.getRoleCd());

                userRoles.add(userRole);
            }

            if (userRoles.size() > 0) {
                YuyuEntityUtil.entityReplace(uiBean.getUser().getUserRoles(), userRoles);
            }
            else {
                uiBean.getUser().getUserRoles().removeAll(uiBean.getUser().getUserRoles());
            }

        }

    }

    private boolean chkExistUserRole(){

        List<RoleInfoDataSourceBean> filteredList = ImmutableList.copyOf(
            Iterables.filter(uiBean.getRoleInfoDataSource().getDatas(), new CheckedCommonCheckBoxPredicate()));

        for(RoleInfoDataSourceBean roleInfo : filteredList){

            if(manager.getRole(roleInfo.getRoleCd()) == null){

                setRoleList();

                return false;
            }
        }
        return true;
    }

    private void addUserRoleRireki(C_RirekiSyuruiKbn pRirekiSyuruiKbn) {

        List<AT_UserRoleRireki> userRoleRirekiList = Lists.newArrayList();

        List<RoleInfoDataSourceBean> noFilteredList =
            ImmutableList.copyOf(uiBean.getRoleInfoDataSource().getDatas());

        if(status.getSyoriKbn() == EDIT){
            List<AT_UserRole> userRolelist = uiBean.getUser().getUserRoles();

            if (noFilteredList.size() == 0) {
                if (userRolelist.size() > 0) {
                    for(AT_UserRole userRole : userRolelist){
                        AT_UserRoleRireki userRoleRireki = new AT_UserRoleRireki();
                        userRoleRireki.setUniqueId(unique.generateUniqueKey());
                        userRoleRireki.setUserId(uiBean.getUser().getUserId());
                        userRoleRireki.setRoleCd(userRole.getRoleCd());
                        userRoleRireki.setRirekiSyuruiKbn(C_RirekiSyuruiKbn.DELETE);

                        userRoleRirekiList.add(userRoleRireki);
                    }
                }
            }
            else {
                for (RoleInfoDataSourceBean allDsBean : noFilteredList) {
                    if (allDsBean.getCommonCheckBox()){

                        boolean rirekiTableAddFlg = true;

                        for (AT_UserRole userRole : userRolelist){
                            if (userRole.getRoleCd().equals(allDsBean.getRoleCd())){
                                rirekiTableAddFlg = false;
                                break;
                            }
                        }

                        if (rirekiTableAddFlg == true){
                            AT_UserRoleRireki userRoleRireki = new AT_UserRoleRireki();
                            userRoleRireki.setUniqueId(unique.generateUniqueKey());
                            userRoleRireki.setUserId(uiBean.getUser().getUserId());
                            userRoleRireki.setRoleCd(allDsBean.getRoleCd());
                            userRoleRireki.setRirekiSyuruiKbn(C_RirekiSyuruiKbn.NEW);

                            userRoleRirekiList.add(userRoleRireki);
                        }
                    }
                    else {
                        for (AT_UserRole userRole : userRolelist){
                            if (userRole.getRoleCd().equals(allDsBean.getRoleCd())){
                                AT_UserRoleRireki userRoleRireki = new AT_UserRoleRireki();
                                userRoleRireki.setUniqueId(unique.generateUniqueKey());
                                userRoleRireki.setUserId(uiBean.getUser().getUserId());
                                userRoleRireki.setRoleCd(userRole.getRoleCd());
                                userRoleRireki.setRirekiSyuruiKbn(C_RirekiSyuruiKbn.DELETE);

                                userRoleRirekiList.add(userRoleRireki);
                                break;
                            }
                        }
                    }
                }

                for (AT_UserRole userRole : userRolelist){

                    boolean rirekiTableAddFlg = true;

                    for (RoleInfoDataSourceBean allDsBean : noFilteredList){
                        if (allDsBean.getRoleCd().equals(userRole.getRoleCd())){
                            rirekiTableAddFlg = false;
                            break;
                        }
                    }

                    if (rirekiTableAddFlg == true){
                        AT_UserRoleRireki userRoleRireki = new AT_UserRoleRireki();
                        userRoleRireki.setUniqueId(unique.generateUniqueKey());
                        userRoleRireki.setUserId(uiBean.getUser().getUserId());
                        userRoleRireki.setRoleCd(userRole.getRoleCd());
                        userRoleRireki.setRirekiSyuruiKbn(C_RirekiSyuruiKbn.DELETE);

                        userRoleRirekiList.add(userRoleRireki);
                    }
                }
            }
        }

        if (userRoleRirekiList != null && userRoleRirekiList.size() > 0){
            manager.insert(userRoleRirekiList);
        }
    }
}