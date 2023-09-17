package yuyu.def.base.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.dao.AS_CategoryDao;
import yuyu.def.db.dao.AS_KinouDao;
import yuyu.def.db.dao.AS_KinouModeDao;
import yuyu.def.db.dao.AS_KinouModeSiborikomiDao;
import yuyu.def.db.dao.AS_SubSystemDao;
import yuyu.def.db.dao.AT_HolidayDao;
import yuyu.def.db.dao.AT_HolidayGroupDao;
import yuyu.def.db.dao.AT_HolidayYoyakuDao;
import yuyu.def.db.dao.AT_KadouTimeGroupDao;
import yuyu.def.db.dao.AT_KyoutuuInfoDao;
import yuyu.def.db.dao.AT_MyMenuDao;
import yuyu.def.db.dao.AT_TokuteibiKadouTimeDao;
import yuyu.def.db.dao.AT_UserRoleDao;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;

import com.google.common.collect.Ordering;

/**
 * システムドメインDomマネージャー
 * システムドメインにおける、DB操作を提供する。
 * 処理対象となるTBL(Entity)は、E-R図を確認すること。
 *
 */
class SystemDomManager {

    @Inject
    private AS_SubSystemDao subSystemDao;

    @Inject
    private AS_KinouDao kinouDao;

    @Inject
    private AS_KinouModeDao kinouModeDao;

    @Inject
    private AS_KinouModeSiborikomiDao siborikomiDao;

    @Inject
    private AT_HolidayGroupDao holidayGroupDao;

    @Inject
    private AT_HolidayDao holidayDao;

    @Inject
    private AT_HolidayYoyakuDao holidayYoyakuDao;

    @Inject
    private AT_KadouTimeGroupDao kadouTimeGroupDao;

    @Inject
    private AT_TokuteibiKadouTimeDao tokuteibiKadouTimeDao;

    @Inject
    private AS_CategoryDao categoryDao;

    @Inject
    private AT_UserRoleDao userRoleDao;

    @Inject
    private AT_MyMenuDao myMenuDao;

    @Inject
    private AT_KyoutuuInfoDao kyoutuuInfoDao;




    List<AS_SubSystem> getAllSubSystems() {
        List<AS_SubSystem> subSystems = subSystemDao.selectAll();
        Collections.sort(subSystems, new SubSystemCompBySubSystemId());
        return subSystems;
    }

    List<AS_SubSystem> getAllSubSystemsSortNoOrder() {
        List<AS_SubSystem> subSystems = subSystemDao.selectAll();
        Collections.sort(subSystems, new SubSystemCompBySortNo());
        return subSystems;
    }

    AS_SubSystem getSubSystem(String pSubSystemId) {
        return subSystemDao.getAS_SubSystem(pSubSystemId);
    }




    List<AS_Category> getAllCategories() {
        return categoryDao.selectAll();
    }

    AS_Category getCategory(String pCategoryId) {
        return categoryDao.getAS_Category(pCategoryId);
    }




    List<AS_Kinou> getAllKinous() {
        List<AS_Kinou> kinous = kinouDao.selectAll();
        Collections.sort(kinous, new KinouCompByKinouId());
        return kinous;
    }

    List<AS_Kinou> getAllKinous4KinouList() {
        return kinouDao.getAllKinous4KinouList();
    }

    List<AS_Kinou> getKinousBySubSystem(String pSubSystemId) {
        return kinouDao.getKinousBySubSystem(pSubSystemId);
    }

    List<AS_Kinou> getKinousByCategory(String pCategoryId) {
        return kinouDao.getKinousByCategory(pCategoryId);
    }

    AS_Kinou getKinou(String pKinouId) {
        return kinouDao.getAS_Kinou(pKinouId);
    }

    List<AS_KinouMode> getKinouModesByKadouTimeGroup(String pKadouTimeGroupCd) {
        return kinouModeDao.getKinouModesByKadouTimeGroup(pKadouTimeGroupCd);
    }

    long getKadouTimeGroupByCountHolidayGroupCd(String pHolidayGroupCd) {
        return holidayGroupDao.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);
    }

    List<AS_KinouModeSiborikomi> getKinouModeSiborikomi(
        String pKinouId, String pKinouModeId) {
        return siborikomiDao.getKinouModeSiborikomi(pKinouId,
            pKinouModeId);
    }

    long getKinouModeByCountKadouTimeGroupCd(String pKadouTimeGroupCd) {
        return kinouModeDao.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);
    }

    List<AT_HolidayGroup> getAllHolidayGroups() {
        List<AT_HolidayGroup> holidayGroups = holidayGroupDao.selectAll();
        Collections.sort(holidayGroups, new HolidayGroupCompByHolidayGroupCd());
        return holidayGroups;
    }

    List<AT_HolidayGroup> getHolidayGroup4Gyoumu() {
        return holidayGroupDao.getHolidayGroup4Gyoumu();
    }

    AT_HolidayGroup getHolidayGroup(String pHolidayGroupCd) {
        return holidayGroupDao.getAT_HolidayGroup(pHolidayGroupCd);
    }

    List<AT_Holiday> getHolidaysNotExistsYoyaku(String pHolidayGroupCd) {
        return holidayDao
            .getHolidaysByHolidayGroupCdNotExistsYoyaku(pHolidayGroupCd);
    }

    long getCountHolidayByHolidayPattern(String pHolidayPatternParam) {

        if (pHolidayPatternParam == null) {
            throw new ExNullArgumentException("pHolidayPatternParam");
        }

        return holidayDao.getCountHolidayByHolidayPattern(pHolidayPatternParam);
    }

    List<AT_HolidayYoyaku> getHolidayYoyakusByHolidayGroupCd(
        String pHolidayGroupCd) {
        return holidayYoyakuDao
            .getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);
    }

    long getCountHolidayYoyakuByHolidayPattern(String pHolidayPatternParam) {

        if (pHolidayPatternParam == null) {
            throw new ExNullArgumentException("pHolidayPatternParam");
        }

        return holidayYoyakuDao.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);

    }

    List<AT_KadouTimeGroup> getAllKadouTimeGroups() {
        List<AT_KadouTimeGroup> kadouTimeGroups = kadouTimeGroupDao.selectAll();
        Collections.sort(kadouTimeGroups,
            new KadouTimeGroupCompByKadouTimeGroupCd());
        return kadouTimeGroups;
    }

    AT_KadouTimeGroup getKadouTimeGroup(String pKadouTimeGroupCd) {
        return kadouTimeGroupDao.getAT_KadouTimeGroup(pKadouTimeGroupCd);
    }

    AT_TokuteibiKadouTime getTokuteibiKadouTime(String pKadouTimeGroupCd,
        BizDate pKadouTimeSiteiYmd) {
        return tokuteibiKadouTimeDao.getAT_TokuteibiKadouTime(pKadouTimeGroupCd,
            pKadouTimeSiteiYmd);
    }

    List<AT_TokuteibiKadouTime> getAllTokuteibiKadouTime() {
        List<AT_TokuteibiKadouTime> retList = new ArrayList<>();
        List<AT_KadouTimeGroup> kadouTimeGroups = getAllKadouTimeGroups();
        for (AT_KadouTimeGroup kadouTimeGroup : kadouTimeGroups) {
            retList
            .addAll(kadouTimeSiteiYmdOrderTokuteibiKadouTime.sortedCopy(kadouTimeGroup.getTokuteibiKadouTimes()));
        }
        return retList;
    }

    long getTokuteibiKadouTimeByCountKadouTimeGroupCd(String pKadouTimeGroupCd) {
        return tokuteibiKadouTimeDao.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);
    }

    class SubSystemCompBySubSystemId implements Comparator<AS_SubSystem> {
        @Override
        public int compare(AS_SubSystem subSystem1, AS_SubSystem subSystem2) {
            return subSystem1.getSubSystemId().compareTo(
                subSystem2.getSubSystemId());
        }
    }

    class SubSystemCompBySortNo implements Comparator<AS_SubSystem> {
        @Override
        public int compare(AS_SubSystem subSystem1, AS_SubSystem subSystem2) {
            return subSystem1.getSortNo().intValue()
                - subSystem2.getSortNo().intValue();
        }
    }

    class KinouCompByKinouId implements Comparator<AS_Kinou> {
        @Override
        public int compare(AS_Kinou kinou1, AS_Kinou kinou2) {
            return kinou1.getKinouId().compareTo(kinou2.getKinouId());
        }
    }

    class HolidayGroupCompByHolidayGroupCd implements
    Comparator<AT_HolidayGroup> {
        @Override
        public int compare(AT_HolidayGroup holidayGroup1,
            AT_HolidayGroup holidayGroup2) {
            return holidayGroup1.getHolidayGroupCd().compareTo(
                holidayGroup2.getHolidayGroupCd());
        }
    }

    class KadouTimeGroupCompByKadouTimeGroupCd implements
    Comparator<AT_KadouTimeGroup> {
        @Override
        public int compare(AT_KadouTimeGroup kadouTimeGroup1,
            AT_KadouTimeGroup kadouTimeGroup2) {
            return kadouTimeGroup1.getKadouTimeGroupCd().compareTo(
                kadouTimeGroup2.getKadouTimeGroupCd());
        }
    }

    private static final Ordering<AT_TokuteibiKadouTime> kadouTimeSiteiYmdOrderTokuteibiKadouTime = new Ordering<AT_TokuteibiKadouTime>() {
        @Override
        public int compare(AT_TokuteibiKadouTime pTokuteibiKadouTime1, AT_TokuteibiKadouTime pTokuteibiKadouTime2) {

            return pTokuteibiKadouTime1.getKadouTimeSiteiYmd().intValue() -
                pTokuteibiKadouTime2.getKadouTimeSiteiYmd().intValue();
        }
    };

    List<AT_MyMenu> getMyMenu(String pUserId) {
        return myMenuDao.getMyMenuByUserId(pUserId);
    }

    List<AS_Kinou> getAS_KinousByC_KinouKbn(C_KinouKbn pC_KinouKbn) {

        return kinouDao.getAS_KinousByC_KinouKbn(pC_KinouKbn);

    }

    public long getCountUsersByRoleCd(String pRoleCd) {
        return userRoleDao.getCountUsersByRoleCd(pRoleCd);
    }

    public AT_KyoutuuInfo getKyoutuuInfoByKinouIdInfoSeqNo(String pKinouId, String pInfoSeqNo){
        return kyoutuuInfoDao.getKyoutuuInfoByKinouIdByInfoSeqNo(pKinouId, pInfoSeqNo);
    }

    List<AS_Kinou> getKinousBySyoricd(String pSyoricd) {

        return kinouDao.getKinousBySyoricd(pSyoricd);
    }

}
