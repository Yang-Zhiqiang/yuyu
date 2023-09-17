package yuyu.def.base.manager.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.result.bean.TaisyouUserAndUserRoleInfosByItemsBean;
import yuyu.def.base.result.bean.TaisyouUserInfosByItemsBean;
import yuyu.def.base.sorter.SortAM_HonyakutsgSosikiCd;
import yuyu.def.base.sorter.SortAM_IdCard;
import yuyu.def.base.sorter.SortAM_IdCardYakusyoku;
import yuyu.def.base.sorter.SortAM_Sosiki;
import yuyu.def.base.sorter.SortAT_RoleSiyouKanouSosiki;
import yuyu.def.base.sorter.SortAT_SosikiRole;
import yuyu.def.base.sorter.SortAT_UserIdKanren;
import yuyu.def.base.sorter.SortAT_UserRoleRireki;
import yuyu.def.db.dao.AM_HonyakutsgSosikiCdDao;
import yuyu.def.db.dao.AM_IdCardDao;
import yuyu.def.db.dao.AM_IdCardYakusyokuDao;
import yuyu.def.db.dao.AM_RoleDao;
import yuyu.def.db.dao.AM_SosikiDao;
import yuyu.def.db.dao.AM_UserDao;
import yuyu.def.db.dao.AM_UserGroupDao;
import yuyu.def.db.dao.AT_KobetuInfoDao;
import yuyu.def.db.dao.AT_PasswordRirekiDao;
import yuyu.def.db.dao.AT_RoleSiyouKanouSosikiDao;
import yuyu.def.db.dao.AT_SosikiRoleDao;
import yuyu.def.db.dao.AT_UserHenkouRirekiDao;
import yuyu.def.db.dao.AT_UserIdKanrenDao;
import yuyu.def.db.dao.AT_UserRoleRirekiDao;
import yuyu.def.db.dao.AT_UserSetteiDao;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.entity.AT_KobetuInfo;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.entity.AT_UserSettei;

import com.google.common.base.Strings;

/**
 * アカウントDomマネージャー<br />
 * アカウントドメインにおける、DB操作を提供する。<br />
 *
 * @version XXXX/XX/XX 198171 新規作成
 * @version 2013/09/24 802161 カテゴリDomマネージャを、業務機能から隠蔽
 *          2016/02/01 関傑元 組織ロールテーブルエンティティリスト取得(端末設置組織コード)の追加<br />
 *          2016/02/03 王　興遠 権限情報レコード件数取得(ユーザーＩＤ、機能ＩＤ、機能モードＩＤ)の実装<br />
 *          2016/02/17 関　傑元 ロール使用可能組織テーブルエンティティリスト取得(所属組織コード)の実装<br />
 *          2016/02/25 宋　倩倩 ユーザーマスタエンティティリスト取得（ユーザーＩＤ、ユーザー名、所属組織コード）の実装<br />
 *          2016/03/07 孫曉宇 組織マスタエンティティ取得（ユーザーＩＤ）の実装<br />
 */
class AccountDomManager {

    @Inject
    private AM_IdCardDao idCardDao;

    @Inject
    private AT_UserIdKanrenDao userIdKanrenDao;

    @Inject
    private AM_IdCardYakusyokuDao idCardYakusyokuDao;

    @Inject
    private AM_SosikiDao sosikiDao;

    @Inject
    private AM_UserDao userDao;

    @Inject
    private AM_RoleDao roleDao;

    @Inject
    private AM_UserGroupDao userGroupDao;

    @Inject
    private AT_UserHenkouRirekiDao userHenkoRirekiDao;

    @Inject
    private AT_PasswordRirekiDao passwordRirekiDao;

    @Inject
    private AT_UserHenkouRirekiDao userHenkouRirekiDao;

    @Inject
    private AT_UserSetteiDao userSetteiDao;

    @Inject
    private AT_KobetuInfoDao kobetuInfoDao;

    @Inject
    private AT_SosikiRoleDao sosikiRoleDao;

    @Inject
    private AT_RoleSiyouKanouSosikiDao roleSiyouKanouSosikiDao;

    @Inject
    private AT_UserRoleRirekiDao userRoleRirekiDao;

    @Inject
    private AM_HonyakutsgSosikiCdDao honyakutsgSosikiCdDao;

    List<AM_IdCard> getAllIdCards(){
        SortAM_IdCard sortAM_IdCard = new SortAM_IdCard();
        return sortAM_IdCard.OrderAM_IdCardByPkAsc(idCardDao.selectAll());
    }

    AM_IdCard getIdCard(String pIdkbn, String pIdcd) {

        return idCardDao.getIdCard(pIdkbn, pIdcd);
    }

    List<AT_UserIdKanren> getAllUserIdKanrens(){
        SortAT_UserIdKanren sortAT_UserIdKanren = new SortAT_UserIdKanren();
        return sortAT_UserIdKanren.OrderAT_UserIdKanrenByPkAsc(userIdKanrenDao.selectAll());
    }

    AT_UserIdKanren getUserIdKanren(String pIdkbn, String pIdcd) {

        return userIdKanrenDao.getUserIdKanren(pIdkbn, pIdcd);
    }

    List<AM_IdCardYakusyoku> getAllIdCardYakusyokus(){
        SortAM_IdCardYakusyoku sortAM_IdCardYakusyoku = new SortAM_IdCardYakusyoku();
        return sortAM_IdCardYakusyoku.OrderAM_IdCardYakusyokuByPkAsc(idCardYakusyokuDao.selectAll());
    }

    AM_IdCardYakusyoku getIdCardYakusyoku(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {

        return idCardYakusyokuDao.getIdCardYakusyoku(pIdkbn, pIdcd, pYakusyokuhatureiymd, pYakusyokuhatureino);
    }

    List<AM_User> getAllUsers(){
        List<AM_User> users = userDao.selectAll();
        Collections.sort(users, new UserCompByUserId());
        return users;
    }

    AM_User getUser(String pUserId){
        if(Strings.isNullOrEmpty(pUserId)) {
            return null;
        }
        return userDao.getAM_User(pUserId);
    }

    List<AM_User> getUsersByUserIdUserNmSyozokusosikicd(String pUserId, String pUserNm, String pSyozokusosikicd){
        return userDao.getUsersByUserIdUserNmSyozokusosikicd(pUserId,pUserNm,pSyozokusosikicd);
    }

    List<TaisyouUserInfosByItemsBean> getTaisyouUserInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
        String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList){

        return userDao.getTaisyouUserInfosByItems(pUserId,pUserNm,pSyozokusosikicd, pSisyaAtukaiSosikiCdList, pSisyaReigaiSosikiCdList);
    }

    List<TaisyouUserAndUserRoleInfosByItemsBean> getTaisyouUserAndUserRoleInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
        String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList){

        return userDao.getTaisyouUserAndUserRoleInfosByItems(pUserId,pUserNm,pSyozokusosikicd, pSisyaAtukaiSosikiCdList, pSisyaReigaiSosikiCdList);
    }


    long getUserByCountUserGroupCd (String pUserGroupCd) {
        return userDao.getUserByCountUserGroupCd(pUserGroupCd);
    }

    long getUserCountByUserIdKinouIdKinouModeId(String pUserId, String pKinouId, String pKinouModeId) {
        return userDao.getUserCountByUserIdKinouIdKinouModeId(pUserId, pKinouId, pKinouModeId);
    }

    List<AM_Sosiki> getSosikisByUserId(String pUserId){
        return sosikiDao.getSosikisByUserId(pUserId);
    }

    List<AM_Sosiki> getAllSosikis(){
        SortAM_Sosiki sortAM_Sosiki = new SortAM_Sosiki();
        return sortAM_Sosiki.OrderAM_SosikiByPkAsc(sosikiDao.selectAll());
    }

    AM_Sosiki getSosiki(String pSosikicd) {

        return sosikiDao.getSosiki(pSosikicd);
    }

    List<AM_UserGroup> getAllUserGroups(){
        List<AM_UserGroup> userGroups = userGroupDao.selectAll();
        Collections.sort(userGroups, new UserGroupsCompByUserGroupCd());
        return userGroups;
    }


    AM_UserGroup getUserGroup(String pUserGroupCd){
        if(Strings.isNullOrEmpty(pUserGroupCd)) {
            return null;
        }
        return userGroupDao.getAM_UserGroup(pUserGroupCd);
    }


    List<AM_UserGroup> getUserGroupsSerchResult(String userGroupCd, String userGroupNm) {
        return userGroupDao.getUserGroupsSerchResult(userGroupCd, userGroupNm);

    }


    List<AM_Role> getAllRoles(){
        List<AM_Role> roles = roleDao.selectAll();
        Collections.sort(roles, new RoleCompByRoleCd());
        return roles;
    }

    AM_Role getRole(String pRoleCd){
        if(Strings.isNullOrEmpty(pRoleCd)) {
            return null;
        }
        return roleDao.getAM_Role(pRoleCd);
    }

    List<AT_UserHenkouRireki> getUserHenkouRirekis(String pUserId) {
        return userHenkoRirekiDao.getUserHenkouRirekis(pUserId);
    }


    AT_PasswordRireki getPasswordRirekiByUniqueId(String pUniqueId) {
        return passwordRirekiDao.getPasswordRirekiByUniqueId(pUniqueId);
    }

    AT_UserHenkouRireki getUserHenkouRirekiByUniqueId(String pUniqueId) {
        return userHenkouRirekiDao.getUserHenkouRirekiByUniqueId(pUniqueId);
    }

    AT_UserSettei getUserSettei(String pUserId) {
        return userSetteiDao.getUserSettei(pUserId);
    }

    AT_KobetuInfo getKobetuInfoByUserId(String pUserId, String pInfoSeqNo){
        return kobetuInfoDao.getKobetuInfoByUserId(pUserId, pInfoSeqNo);
    }

    class UserCompByUserId implements Comparator<AM_User> {

        @Override
        public int compare(AM_User user1, AM_User user2) {
            return user1.getUserId().compareTo(user2.getUserId());
        }

    }

    class UserGroupsCompByUserGroupCd implements Comparator<AM_UserGroup> {

        @Override
        public int compare(AM_UserGroup userGroup1, AM_UserGroup userGroup2) {
            return userGroup1.getUserGroupCd().compareTo(userGroup2.getUserGroupCd());
        }

    }

    class RoleCompByRoleCd implements Comparator<AM_Role> {

        @Override
        public int compare(AM_Role role1, AM_Role role2) {
            return role1.getRoleCd().compareTo(role2.getRoleCd());
        }

    }

    List<AT_SosikiRole> getAllSosikiRoles(){
        SortAT_SosikiRole sortAT_SosikiRole = new SortAT_SosikiRole();
        return sortAT_SosikiRole.OrderAT_SosikiRoleByPkAsc(sosikiRoleDao.selectAll());
    }

    AT_SosikiRole getSosikiRole(String pTanmatusettisosikicd, String pRoleCd) {

        return sosikiRoleDao.getSosikiRole(pTanmatusettisosikicd, pRoleCd);
    }

    List<AT_SosikiRole> getSosikiRolesByTanmatusettisosikicd(String pTanmatusettisosikicd) {

        return sosikiRoleDao.getSosikiRolesByTanmatusettisosikicd(pTanmatusettisosikicd);
    }


    List<AT_RoleSiyouKanouSosiki> getAllRoleSiyouKanouSosikis(){
        SortAT_RoleSiyouKanouSosiki sortAT_RoleSiyouKanouSosiki = new SortAT_RoleSiyouKanouSosiki();
        return sortAT_RoleSiyouKanouSosiki.OrderAT_RoleSiyouKanouSosikiByPkAsc(roleSiyouKanouSosikiDao.selectAll());
    }

    List<AT_RoleSiyouKanouSosiki> getRoleSiyouKanouSosikisBySyozokusosikicd(String pSyozokusosikicd) {

        return roleSiyouKanouSosikiDao.getRoleSiyouKanouSosikisBySyozokusosikicd(pSyozokusosikicd);
    }

    AT_RoleSiyouKanouSosiki getRoleSiyouKanouSosiki(String pSyozokusosikicd, String pRoleCd) {

        return roleSiyouKanouSosikiDao.getRoleSiyouKanouSosiki(pSyozokusosikicd, pRoleCd);
    }

    List<AT_UserRoleRireki> getAllUserRoleRirekis(){
        SortAT_UserRoleRireki sortAT_UserRoleRireki = new SortAT_UserRoleRireki();
        return sortAT_UserRoleRireki.OrderAT_UserRoleRirekiByPkAsc(userRoleRirekiDao.selectAll());
    }

    AT_UserRoleRireki getUserRoleRireki(String pUniqueId) {

        return userRoleRirekiDao.getUserRoleRireki(pUniqueId);
    }

    List<AM_HonyakutsgSosikiCd> getAllHonyakutsgSosikiCd(){
        SortAM_HonyakutsgSosikiCd sortAM_HonyakutsgSosikiCd = new SortAM_HonyakutsgSosikiCd();
        return sortAM_HonyakutsgSosikiCd.OrderAM_HonyakutsgSosikiCdByPkAsc(honyakutsgSosikiCdDao.selectAll());
    }


    AM_HonyakutsgSosikiCd getHonyakutsgSosikiCd(String pSosikicd) {

        return honyakutsgSosikiCdDao.getHonyakutsgSosikiCd(pSosikicd);
    }

    Long getHonyakutsgSosikiCdCount() {

        return honyakutsgSosikiCdDao.getHonyakutsgSosikiCdCount();
    }

}