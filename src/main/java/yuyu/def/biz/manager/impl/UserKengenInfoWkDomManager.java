package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.sorter.SortBT_UserKengenHaneiSskInfo;
import yuyu.def.biz.sorter.SortBW_IdCardWk;
import yuyu.def.biz.sorter.SortBW_IdCardYakusyokuWk;
import yuyu.def.biz.sorter.SortBW_UserIdKanrenWk;
import yuyu.def.biz.sorter.SortBW_UserRoleWk;
import yuyu.def.biz.sorter.SortBW_UserWk;
import yuyu.def.db.dao.BT_UserKengenHaneiSskInfoDao;
import yuyu.def.db.dao.BW_IdCardWkDao;
import yuyu.def.db.dao.BW_IdCardYakusyokuWkDao;
import yuyu.def.db.dao.BW_UserIdKanrenWkDao;
import yuyu.def.db.dao.BW_UserRoleWkDao;
import yuyu.def.db.dao.BW_UserWkDao;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.entity.BW_UserWk;


/**
 * UserKengenInfoWkDomマネージャー<br />
 * UserKengenInfoWkにおける、DB操作を提供する。<br />
 */
class UserKengenInfoWkDomManager {

    @Inject
    private BT_UserKengenHaneiSskInfoDao userKengenHaneiSskInfoDao;

    @Inject
    private BW_IdCardWkDao idCardWkDao;

    @Inject
    private BW_IdCardYakusyokuWkDao idCardYakusyokuWkDao;

    @Inject
    private BW_UserIdKanrenWkDao userIdKanrenWkDao;

    @Inject
    private BW_UserRoleWkDao userRoleWkDao;

    @Inject
    private BW_UserWkDao userWkDao;

    List<BW_IdCardWk> getAllIdCardWk(){
        SortBW_IdCardWk sortBW_IdCardWk = new SortBW_IdCardWk();
        return sortBW_IdCardWk.OrderBW_IdCardWkByPkAsc(idCardWkDao.selectAll());
    }

    BW_IdCardWk getIdCardWk(String pIdkbn, String pIdcd) {

        return idCardWkDao.getIdCardWk(pIdkbn, pIdcd);
    }

    ExDBResults<BW_IdCardWk>  getIdCardWks() {

        return idCardWkDao.getIdCardWks();
    }

    Long getIdCardWkCount() {

        return idCardWkDao.getIdCardWkCount();
    }

    ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWk() {

        return idCardWkDao.getIdCardWksByNotExistsUserWk();
    }

    ExDBResults<BW_IdCardWk>  getIdCardWksByNotExistsUserWkUserNm() {

        return idCardWkDao.getIdCardWksByNotExistsUserWkUserNm();
    }

    ExDBResults<BW_IdCardWk> getIdCardWksSyoukaiUserByNotExistsUserWk() {

        return idCardWkDao.getIdCardWksSyoukaiUserByNotExistsUserWk();
    }

    List<BW_UserIdKanrenWk> getAllUserIdKanrenWk(){
        SortBW_UserIdKanrenWk sortBW_UserIdKanrenWk = new SortBW_UserIdKanrenWk();
        return sortBW_UserIdKanrenWk.OrderBW_UserIdKanrenWkByPkAsc(userIdKanrenWkDao.selectAll());
    }

    BW_UserIdKanrenWk getUserIdKanrenWk(String pIdkbn, String pIdcd) {

        return userIdKanrenWkDao.getUserIdKanrenWk(pIdkbn, pIdcd);
    }

    List<BW_IdCardYakusyokuWk> getAllIdCardYakusyokuWk(){
        SortBW_IdCardYakusyokuWk sortBW_IdCardYakusyokuWk = new SortBW_IdCardYakusyokuWk();
        return sortBW_IdCardYakusyokuWk.OrderBW_IdCardYakusyokuWkByPkAsc(idCardYakusyokuWkDao.selectAll());
    }

    BW_IdCardYakusyokuWk getIdCardYakusyokuWk(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {

        return idCardYakusyokuWkDao.getIdCardYakusyokuWk(pIdkbn, pIdcd, pYakusyokuhatureiymd, pYakusyokuhatureino);
    }

    List<BT_UserKengenHaneiSskInfo> getAllUserKengenHaneiSskInfo(){
        SortBT_UserKengenHaneiSskInfo sortBT_UserKengenHaneiSskInfo = new SortBT_UserKengenHaneiSskInfo();
        return sortBT_UserKengenHaneiSskInfo.OrderBT_UserKengenHaneiSskInfoByPkAsc(userKengenHaneiSskInfoDao.selectAll());
    }

    BT_UserKengenHaneiSskInfo getUserKengenHaneiSskInfo(String pSosikicdkami3) {

        return userKengenHaneiSskInfoDao.getUserKengenHaneiSskInfo(pSosikicdkami3);
    }

    List<BW_UserWk> getAllUserWk(){
        SortBW_UserWk sortBW_UserWk = new SortBW_UserWk();
        return sortBW_UserWk.OrderBW_UserWkByPkAsc(userWkDao.selectAll());
    }

    BW_UserWk getUserWk(String pUserId) {

        return userWkDao.getUserWk(pUserId);
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSisyaUserRoleWk(String[] pSisyaReigaiSosikiCdList, String[] pSisyayouRoleCdList) {

        return userWkDao.getUserWksNotExistsSisyaUserRoleWk(pSisyaReigaiSosikiCdList, pSisyayouRoleCdList);
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsSyoukaiUserRoleWk(String[] pHnsaSknmSsyRoruCdList) {

        return userWkDao.getUserWksNotExistsSyoukaiUserRoleWk(pHnsaSknmSsyRoruCdList);
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserIdKanrenWk() {

        return userWkDao.getUserWksNotExistsUserIdKanrenWk();
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaReigaiSosikiCdList) {

        return userWkDao.getUserWksNotExistsUserKengenHaneiSskInfo(pSisyaReigaiSosikiCdList);
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksNotExistsUserKengenHaneiSskInfo(String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList) {

        return userWkDao.getUserWksNotExistsUserKengenHaneiSskInfo(pSisyaAtukaiSosikiCdList, pSisyaReigaiSosikiCdList);
    }

    List<BW_UserRoleWk> getAllUserRoleWk(){
        SortBW_UserRoleWk sortBW_UserRoleWk = new SortBW_UserRoleWk();
        return sortBW_UserRoleWk.OrderBW_UserRoleWkByPkAsc(userRoleWkDao.selectAll());
    }

    BW_UserRoleWk getUserRoleWk(String pUserId, String pRoleCd) {

        return userRoleWkDao.getUserRoleWk(pUserId, pRoleCd);
    }

    List<BW_UserRoleWk> getUserRoleWksByUserId(String pUserId) {

        return userRoleWkDao.getUserRoleWksByUserId(pUserId);
    }

    ExDBUpdatableResults<BW_IdCardWk> getIdCardWksBySyozokusosikicdKeta3() {


        return null;
    }

    ExDBUpdatableResults<BW_UserWk> getUserWksBySyozokusosikicdKeta3() {

        return userWkDao.getUserWksBySyozokusosikicdKeta3();
    }

}
