package yuyu.def.base.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.ObjectUtil;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.result.bean.FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean;
import yuyu.def.base.result.bean.TaisyouUserAndUserRoleInfosByItemsBean;
import yuyu.def.base.result.bean.TaisyouUserInfosByItemsBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchResultKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.entity.AM_IdCard;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_FileServerInfo;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.entity.AT_AppIdentifier;
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.entity.AT_BatchJob;
import yuyu.def.db.entity.AT_BatchLog;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.entity.AT_FileRireki;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_KobetuInfo;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.entity.AT_MyMenu;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.entity.AT_UserIdKanren;
import yuyu.def.db.entity.AT_UserRoleRireki;
import yuyu.def.db.entity.AT_UserSettei;

import com.google.common.base.Function;
import com.google.common.base.Optional;

/**
 * 業務基盤 DOM マネージャー 実装クラス<br />
 * {@link BaseDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャーを使用しています。 <br />
 */
public class BaseDomManagerImpl extends AbstractDomManager implements BaseDomManager {

    @Inject
    private AccountDomManager accManager;

    @Inject
    private SystemDomManager sysManager;

    @Inject
    private InfrDomManager infrManager;

    @Inject
    private LogDomManager logManager;

    @Inject
    private ReportDomManager reportManager;

    @Inject
    private CommonDomManager commonManager;

    @Inject
    private AccountDomManager accountDomManager;

    @Override
    public List<AM_IdCard> getAllIdCards() {
        return accManager.getAllIdCards();
    }

    @Override
    public AM_IdCard getIdCard(String pIdkbn, String pIdcd) {
        return accManager.getIdCard(pIdkbn, pIdcd);
    }

    @Override
    public List<AT_UserIdKanren> getAllUserIdKanrens() {
        return accManager.getAllUserIdKanrens();
    }

    @Override
    public AT_UserIdKanren getUserIdKanren(String pIdkbn, String pIdcd) {
        return accManager.getUserIdKanren(pIdkbn, pIdcd);
    }

    @Override
    public List<AM_IdCardYakusyoku> getAllIdCardYakusyokus() {
        return accManager.getAllIdCardYakusyokus();
    }

    @Override
    public AM_IdCardYakusyoku getIdCardYakusyoku(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {
        return accManager.getIdCardYakusyoku(pIdkbn, pIdcd, pYakusyokuhatureiymd, pYakusyokuhatureino);
    }

    @Override
    public List<AM_User> getAllUsers() {
        return accManager.getAllUsers();
    }

    @Override
    public AM_User getUser(String pUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーID", pUserId);
        paramLogging(paramMap);

        return accManager.getUser(pUserId);
    }

    @Override
    public List<AM_User> getUsersByUserIdUserNmSyozokusosikicd(String pUserId, String pUserNm, String pSyozokusosikicd){

        return accManager.getUsersByUserIdUserNmSyozokusosikicd(pUserId, pUserNm, pSyozokusosikicd);
    }

    @Override
    public List<TaisyouUserInfosByItemsBean> getTaisyouUserInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
            String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList){

        return accManager.getTaisyouUserInfosByItems(pUserId, pUserNm, pSyozokusosikicd, pSisyaAtukaiSosikiCdList, pSisyaReigaiSosikiCdList);
    }

    @Override
    public List<TaisyouUserAndUserRoleInfosByItemsBean> getTaisyouUserAndUserRoleInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
            String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList){

        return accManager.getTaisyouUserAndUserRoleInfosByItems(pUserId, pUserNm, pSyozokusosikicd, pSisyaAtukaiSosikiCdList, pSisyaReigaiSosikiCdList);
    }


    @Override
    public List<AM_Sosiki> getSosikisByUserId(String pUserId) {
        return accManager.getSosikisByUserId(pUserId);
    }

    @Override
    public List<AM_Sosiki> getAllSosikis() {
        return accManager.getAllSosikis();
    }

    @Override
    public AM_Sosiki getSosiki(String pSosikicd) {
        return accManager.getSosiki(pSosikicd);
    }

    @Override
    public AM_User getDetachedUser(String pUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーID", pUserId);
        paramLogging(paramMap);

        return Optional
                .fromNullable(accManager.getUser(pUserId))
                .transform(new Function<AM_User, AM_User>() {
                    @Override
                    public AM_User apply(AM_User managedUser) {
                        AM_User detachedUser = new AM_User();



                        detachedUser = ObjectUtil.deepCopy(managedUser);
                        return detachedUser;
                    }
                })
                .orNull();
    }

    @Override
    public long getUserByCountUserGroupCd (String pUserGroupCd) {
        return accManager.getUserByCountUserGroupCd(pUserGroupCd);
    }

    @Override
    public long getUserCountByUserIdKinouIdKinouModeId (String pUserId, String pKinouId, String pKinouModeId) {
        return accManager.getUserCountByUserIdKinouIdKinouModeId(pUserId, pKinouId, pKinouModeId);
    }

    @Override
    public List<AM_UserGroup> getAllUserGroups(){
        return accManager.getAllUserGroups();
    }

    @Override
    public AM_UserGroup getUserGroup(String pUserGroupCd){
        return accManager.getUserGroup(pUserGroupCd);
    }

    @Override
    public List<AM_UserGroup> getUserGroupsSerchResult(String userGroupCd, String userGroupNm) {
        return accManager.getUserGroupsSerchResult(userGroupCd, userGroupNm);

    }

    @Override
    public List<AM_Role> getAllRoles() {
        return accManager.getAllRoles();
    }

    @Override
    public AM_Role getRole(String pRoleCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ロールコード", pRoleCd);
        paramLogging(paramMap);
        return accManager.getRole(pRoleCd);
    }

    @Override
    public List<AT_UserHenkouRireki> getUserHenkouRirekis(String pUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーＩＤ ", pUserId);
        paramLogging(paramMap);

        return accManager.getUserHenkouRirekis(pUserId);
    }

    @Override
    public AT_PasswordRireki getPasswordRirekiByUniqueId(String pUniqueId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユニークＩＤ", pUniqueId);
        paramLogging(paramMap);

        return accManager.getPasswordRirekiByUniqueId(pUniqueId);
    }

    @Override
    public AT_UserHenkouRireki getUserHenkouRirekiByUniqueId(String pUniqueId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユニークＩＤ", pUniqueId);
        paramLogging(paramMap);

        return accManager.getUserHenkouRirekiByUniqueId(pUniqueId);
    }

    @Override
    public AT_UserSettei getUserSettei(String pUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーＩＤ", pUserId);
        paramLogging(paramMap);

        return accManager.getUserSettei(pUserId);
    }
    @Override
    public AT_KobetuInfo getKobetuInfoByUserId(String pUserId, String pInfoSeqNo){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーID", pUserId);
        paramMap.put("情報連番", pInfoSeqNo);
        paramLogging(paramMap);

        return accManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo);
    }

    @Override
    public List<AT_SosikiRole> getAllSosikiRoles() {
        return accManager.getAllSosikiRoles();
    }

    @Override
    public AT_SosikiRole getSosikiRole(String pTanmatusettisosikicd, String pRoleCd) {
        return accManager.getSosikiRole(pTanmatusettisosikicd, pRoleCd);
    }

    @Override
    public List<AT_SosikiRole> getSosikiRolesByTanmatusettisosikicd(String pTanmatusettisosikicd) {
        return accManager.getSosikiRolesByTanmatusettisosikicd(pTanmatusettisosikicd);
    }

    @Override
    public List<AT_RoleSiyouKanouSosiki> getAllRoleSiyouKanouSosikis() {
        return accManager.getAllRoleSiyouKanouSosikis();
    }

    @Override
    public AT_RoleSiyouKanouSosiki getRoleSiyouKanouSosiki(String pSyozokusosikicd, String pRoleCd) {
        return accManager.getRoleSiyouKanouSosiki(pSyozokusosikicd, pRoleCd);
    }

    @Override
    public List<AT_RoleSiyouKanouSosiki> getRoleSiyouKanouSosikisBySyozokusosikicd(String pSyozokusosikicd) {
        return accManager.getRoleSiyouKanouSosikisBySyozokusosikicd(pSyozokusosikicd);
    }

    @Override
    public List<AT_UserRoleRireki> getAllUserRoleRirekis() {
        return accManager.getAllUserRoleRirekis();
    }

    @Override
    public AT_UserRoleRireki getUserRoleRireki(String pUniqueId) {
        return accManager.getUserRoleRireki(pUniqueId);
    }

    @Override
    public List<AM_HonyakutsgSosikiCd> getAllHonyakutsgSosikiCd() {
        return accountDomManager.getAllHonyakutsgSosikiCd();
    }

    @Override
    public AM_HonyakutsgSosikiCd getHonyakutsgSosikiCd(String pSosikicd) {
        return accountDomManager.getHonyakutsgSosikiCd(pSosikicd);
    }

    @Override
    public Long getHonyakutsgSosikiCdCount() {
        return accountDomManager.getHonyakutsgSosikiCdCount();
    }

    @Override
    public List<AS_SubSystem> getAllSubSystems() {
        return sysManager.getAllSubSystems();
    }

    @Override
    public List<AS_SubSystem> getAllSubSystemsSortNoOrder() {
        return sysManager.getAllSubSystemsSortNoOrder();
    }

    @Override
    public AS_SubSystem getSubSystem(String pSubSystemId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramLogging(paramMap);

        return sysManager.getSubSystem(pSubSystemId);
    }

    @Override
    public List<AS_Category> getAllCategories() {
        return sysManager.getAllCategories();
    }

    @Override
    public List<AS_Kinou> getAllKinous() {
        return sysManager.getAllKinous();
    }

    @Override
    public List<AS_Kinou> getAllKinous4KinouList() {
        return sysManager.getAllKinous4KinouList();
    }

    @Override
    public List<AS_Kinou> getKinousBySubSystem(String subSystemId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", subSystemId);
        paramLogging(paramMap);

        return sysManager.getKinousBySubSystem(subSystemId);
    }

    @Override
    public List<AS_Kinou> getKinousByCategory(String categoryId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("カテゴリID", categoryId);
        paramLogging(paramMap);

        return sysManager.getKinousByCategory(categoryId);
    }

    @Override
    public AS_Kinou getKinou(String pkinouId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("機能ID", pkinouId);
        paramLogging(paramMap);

        return sysManager.getKinou(pkinouId);
    }

    @Override
    public AS_Kinou getDetachedKinou(String pkinouId) {

        return Optional.fromNullable(sysManager.getKinou(pkinouId)).transform(
                new Function<AS_Kinou, AS_Kinou>() {
                    @Override
                    public AS_Kinou apply(AS_Kinou managedKinou) {




                        AS_Kinou detachedKinou = ObjectUtil.deepCopy(managedKinou);
                        return detachedKinou;
                    }
                }
                ).orNull();
    }

    @Override
    public List<AS_Kinou> getAS_KinousByC_KinouKbn(C_KinouKbn pC_KinouKbn) {
        return sysManager.getAS_KinousByC_KinouKbn(pC_KinouKbn);
    }

    @Override
    public List<AS_KinouMode> getKinouModesByKadouTimeGroup(String pKadouTimeGroupCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("稼働時間グループコード", pKadouTimeGroupCd);
        paramLogging(paramMap);

        return sysManager.getKinouModesByKadouTimeGroup(pKadouTimeGroupCd);
    }

    @Override
    public List<AS_KinouModeSiborikomi> getKinouModeSiborikomi(String pKinouId, String pKinouModeId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("機能ID", pKinouId);
        paramMap.put("機能モードID", pKinouModeId);
        paramLogging(paramMap);

        return sysManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);
    }

    @Override
    public List<AT_HolidayGroup> getAllHolidayGroups() {
        return sysManager.getAllHolidayGroups();
    }

    @Override
    public List<AT_HolidayGroup> getHolidayGroup4Gyoumu() {
        return sysManager.getHolidayGroup4Gyoumu();
    }

    @Override
    public AT_HolidayGroup getHolidayGroup(String pHolidayGroupCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("休日グループコード", pHolidayGroupCd);
        paramLogging(paramMap);

        return sysManager.getHolidayGroup(pHolidayGroupCd);
    }

    @Override
    public List<AT_Holiday> getHolidaysNotExistsYoyaku(String pHolidayGroupCd){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("休日グループコード", pHolidayGroupCd);
        paramLogging(paramMap);

        return sysManager.getHolidaysNotExistsYoyaku(pHolidayGroupCd);
    }

    @Override
    public List<AT_HolidayYoyaku> getHolidayYoyakusByHolidayGroupCd(String pHolidayGroupCd){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("休日グループコード", pHolidayGroupCd);
        paramLogging(paramMap);

        return sysManager.getHolidayYoyakusByHolidayGroupCd(pHolidayGroupCd);
    }

    @Override
    public List<AT_KadouTimeGroup> getAllKadouTimeGroups() {
        return sysManager.getAllKadouTimeGroups();
    }

    @Override
    public AT_KadouTimeGroup getKadouTimeGroup(String pKadouTimeGroupCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("稼働時間グループコード", pKadouTimeGroupCd);
        paramLogging(paramMap);

        return sysManager.getKadouTimeGroup(pKadouTimeGroupCd);
    }

    @Override
    public AT_TokuteibiKadouTime getTokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("稼働時間グループコード", pKadouTimeGroupCd);
        paramMap.put("稼働時間指定年月日", pKadouTimeSiteiYmd);
        paramLogging(paramMap);

        return sysManager.getTokuteibiKadouTime(pKadouTimeGroupCd, pKadouTimeSiteiYmd);
    }

    @Override
    public List<AT_TokuteibiKadouTime> getAllTokuteibiKadouTime() {
        return sysManager.getAllTokuteibiKadouTime();
    }

    @Override
    public AS_Category getCategory(String pCategoryId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("カテゴリID", pCategoryId);
        paramLogging(paramMap);

        return sysManager.getCategory(pCategoryId);
    }

    @Override
    public List<AT_MyMenu> getMyMenu(String pUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユーザーID", pUserId);
        paramLogging(paramMap);

        return sysManager.getMyMenu(pUserId);
    }

    @Override
    public long getCountHolidayByHolidayPattern(String pHolidayPatternParam) {
        return sysManager.getCountHolidayByHolidayPattern(pHolidayPatternParam);
    }

    @Override
    public long getCountHolidayYoyakuByHolidayPattern(String pHolidayPatternParam) {
        return sysManager.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);
    }


    @Override
    public long getKinouModeByCountKadouTimeGroupCd(String pKadouTimeGroupCd){
        return sysManager.getKinouModeByCountKadouTimeGroupCd(pKadouTimeGroupCd);
    }

    @Override
    public long getTokuteibiKadouTimeByCountKadouTimeGroupCd(String pKadouTimeGroupCd) {
        return sysManager.getTokuteibiKadouTimeByCountKadouTimeGroupCd(pKadouTimeGroupCd);
    }

    @Override
    public long getKadouTimeGroupByCountHolidayGroupCd(String pHolidayGroupCd) {
        return sysManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);
    }

    @Override
    public long getCountUsersByRoleCd(String pRoleCd) {
        return sysManager.getCountUsersByRoleCd(pRoleCd);
    }

    @Override
    public AT_KyoutuuInfo getKyoutuuInfoByKinouIdInfoSeqNo(String pKinouId, String pInfoSeqNo){
        return sysManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId, pInfoSeqNo);
    }

    @Override
    public List<AT_AccessLog> getAllAccessLogs() {
        return logManager.getAllAccessLogs();
    }

    @Override
    public AT_AccessLog getAccessLog(String pLogId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ログID", pLogId);
        paramLogging(paramMap);

        return logManager.getAccessLog(pLogId);
    }

    @Override
    public List<AT_AccessLog> selAccessLogs(
            String  pSubSystemId,
            String  pCategoryId,
            String  pKinouId,
            C_KinouKbn pKinouKbn,
            BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
            BizDate pSyoriYmdTo,   String pSyoriTimeTo,
            String  pUserId,
            String  pIpAddress,
            String  pSessionId,
            C_AccessLogSyubetuKbn pLogKindCd
            ) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramMap.put("カテゴリID", pCategoryId);
        paramMap.put("機能ID", pKinouId);
        paramMap.put("機能区分", pKinouKbn);
        paramMap.put("処理年月日（自）", pSyoriYmdFrom);
        paramMap.put("処理時間（自）", pSyoriTimeFrom);
        paramMap.put("処理年月日（至）", pSyoriYmdTo);
        paramMap.put("処理時間（至）", pSyoriTimeTo);
        paramMap.put("ユーザーID", pUserId);
        paramMap.put("IPアドレス", pIpAddress);
        paramMap.put("セッションID", pSessionId);
        paramMap.put("ログ種別コード", pLogKindCd);
        paramLogging(paramMap);

        return logManager.selAccessLogs(
                pSubSystemId,
                pCategoryId,
                pKinouId,
                pKinouKbn,
                pSyoriYmdFrom, pSyoriTimeFrom,
                pSyoriYmdTo,   pSyoriTimeTo,
                pUserId,
                pIpAddress,
                pSessionId,
                pLogKindCd
                );
    }

    @Override
    public long getAccessLogCount(
            String  pSubSystemId,
            String  pCategoryId,
            String  pKinouId,
            C_KinouKbn pKinouKbn,
            BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
            BizDate pSyoriYmdTo,   String pSyoriTimeTo,
            String  pUserId,
            String  pIpAddress,
            String  pSessionId,
            C_AccessLogSyubetuKbn pLogKindCd
            ) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramMap.put("カテゴリID", pCategoryId);
        paramMap.put("機能ID", pKinouId);
        paramMap.put("機能区分", pKinouKbn);
        paramMap.put("処理年月日（自）", pSyoriYmdFrom);
        paramMap.put("処理時間（自）", pSyoriTimeFrom);
        paramMap.put("処理年月日（至）", pSyoriYmdTo);
        paramMap.put("処理時間（至）", pSyoriTimeTo);
        paramMap.put("ユーザーID", pUserId);
        paramMap.put("IPアドレス", pIpAddress);
        paramMap.put("セッションID", pSessionId);
        paramMap.put("ログ種別コード", pLogKindCd);
        paramLogging(paramMap);

        return logManager.getAccessLogCount(
                pSubSystemId,
                pCategoryId,
                pKinouId,
                pKinouKbn,
                pSyoriYmdFrom, pSyoriTimeFrom,
                pSyoriYmdTo,   pSyoriTimeTo,
                pUserId,
                pIpAddress,
                pSessionId,
                pLogKindCd
                );
    }

    @Override
    public List<AT_AccessLogSyousai> getAccessLogSyousaisByLogIdEdaNoOrder(String pLogId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ログID", pLogId);
        paramLogging(paramMap);

        return logManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);
    }

    @Override
    public List<AM_Batch> getBatchBySubSystem(String pSubSystemId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramLogging(paramMap);

        return logManager.getBatchBySubSystem(pSubSystemId);
    }

    @Override
    public long getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn (
            String[] pBatchIds,
            BizDate pBatchSyoriYmdFrom,
            BizDate pBatchSyoriYmdTo,
            C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
            C_BatchResultKbn[] pBatchResultKbns
            ) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチID(配列)", pBatchIds);
        paramMap.put("バッチ処理年月日(自)", pBatchSyoriYmdFrom);
        paramMap.put("バッチ処理年月日(至)", pBatchSyoriYmdTo);
        paramMap.put("バッチ状態区分(配列)", pBatchJyoutaiKbns);
        paramMap.put("バッチ結果区分(配列)", pBatchResultKbns);
        paramLogging(paramMap);

        return logManager.getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(
                pBatchIds,
                pBatchSyoriYmdFrom,
                pBatchSyoriYmdTo,
                pBatchJyoutaiKbns,
                pBatchResultKbns);
    }

    @Override
    public List<AT_BatchJob> getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn (
            String[] pBatchIds,
            BizDate pBatchSyoriYmdFrom,
            BizDate pBatchSyoriYmdTo,
            C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
            C_BatchResultKbn[] pBatchResultKbns
            ) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチID(配列)", pBatchIds);
        paramMap.put("バッチ処理年月日(自)", pBatchSyoriYmdFrom);
        paramMap.put("バッチ処理年月日(至)", pBatchSyoriYmdTo);
        paramMap.put("バッチ状態区分(配列)", pBatchJyoutaiKbns);
        paramMap.put("バッチ結果区分(配列)", pBatchResultKbns);
        paramLogging(paramMap);

        return logManager.getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn(
                pBatchIds,
                pBatchSyoriYmdFrom,
                pBatchSyoriYmdTo,
                pBatchJyoutaiKbns,
                pBatchResultKbns);
    }

    @Override
    public List<AT_BatchLog> getBatchLogByBatchJobId(String pBatchJobId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチジョブID", pBatchJobId);
        paramLogging(paramMap);

        return logManager.getBatchLogByBatchJobId(pBatchJobId);
    }

    @Override
    public List<AT_BatchLogReport> getBatchLogReportByBatchJobId(String pBatchJobId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチジョブID", pBatchJobId);
        paramLogging(paramMap);

        return logManager.getBatchLogReportByBatchJobId(pBatchJobId);
    }

    @Override
    public AT_BatchJob getBatchJob(String pBatchJobId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチジョブID", pBatchJobId);
        paramLogging(paramMap);

        return logManager.getBatchJob(pBatchJobId);
    }

    @Override
    public AM_Batch getBatch(String pKinouId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチID", pKinouId);
        paramLogging(paramMap);

        return logManager.getBatch(pKinouId);
    }

    @Override
    public List<AS_BatchOrder> getBatchOrderByKinouId(String pKinouId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("機能ＩＤ ", pKinouId);
        paramLogging(paramMap);

        return logManager.getBatchOrderByKinouId(pKinouId);
    }

    @Override
    public List<AS_BatchHeisouList> getBatchHeisouListBySelfKinouId(String pSelfKinouId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("自機能ＩＤ ", pSelfKinouId);
        paramLogging(paramMap);

        return logManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);
    }

    @Override
    public List<AS_BatchOrder> getBatchOrderExecuteList(String pBatchJobId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("バッチジョブId ", pBatchJobId);
        paramLogging(paramMap);

        return logManager.getBatchOrderExecuteList(pBatchJobId);
    }

    @Override
    public List<AS_BatchOrder> getBatchOrderList() {
        return logManager.getBatchOrderList();
    }

    @Override
    public BizDate getBatchDate() {
        return logManager.getBatchDate();
    }

    @Override
    public AT_BatchDate getAT_BatchDate() {
        return logManager.getAT_BatchDate();
    }

    @Override
    public List<AT_BatchDate> getAT_BatchDateAll() {
        return logManager.getAT_BatchDateAll();
    }

    @Override
    public AS_BatchHeisouList getBatchHeisouListBySelfKinouIdTargetKinouId(String pSelfKinouId, String pTargetKinouId){
        return logManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pSelfKinouId, pTargetKinouId);
    }

    @Override
    public AS_BatchOrder getBatchOrderByBatchJobId(String pBatchJobId){
        return logManager.getBatchOrderByBatchJobId(pBatchJobId);
    }

    @Override
    public AT_BatchDate getBatchDateByDate(BizDate pBatchExecDate){
        return logManager.getBatchDateByDate(pBatchExecDate);
    }

    @Override
    public AT_TyouhyouHozon getTyouhyouHozon(String TyouhyouKey) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("帳票キー", TyouhyouKey);
        paramLogging(paramMap);

        return reportManager.getTyouhyouHozon(TyouhyouKey);
    }

    @Override
    public AT_TyouhyouKensaku getTyouhyouKensaku(String pUniqueId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユニークID", pUniqueId);
        paramLogging(paramMap);

        return reportManager.getTyouhyouKensaku(pUniqueId);
    }

    @Override
    public List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("書類コード", pSyoruiCd);
        paramMap.put("処理年月日", pSyoriYmd);
        paramMap.put("出力回数", pOutCount);
        paramLogging(paramMap);

        return reportManager.getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);
    }

    @Override
    public long getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("書類コード", pSyoruiCd);
        paramMap.put("処理年月日", pSyoriYmd);
        paramMap.put("出力回数", pOutCount);
        paramLogging(paramMap);

        return reportManager.getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(pSyoruiCd, pSyoriYmd, pOutCount);
    }

    @Override
    public List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramMap.put("処理年月日", pSyoriYmd);
        paramMap.put("出力回数", pOutCount);
        paramLogging(paramMap);

        return reportManager.getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(pSubSystemId, pSyoriYmd, pOutCount);
    }

    @Override
    public long getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サブシステムID", pSubSystemId);
        paramMap.put("処理年月日", pSyoriYmd);
        paramMap.put("出力回数", pOutCount);
        paramLogging(paramMap);

        return reportManager.getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(pSubSystemId, pSyoriYmd, pOutCount);
    }

    @Override
    public List<AM_SyoruiZokusei> getAllSyoruiZokuseis() {
        return reportManager.getAllSyoruiZokuseis();
    }

    @Override
    public AM_SyoruiZokusei getSyoruiZokusei(C_SyoruiCdKbn pSyoruiCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("書類コード", pSyoruiCd);
        paramLogging(paramMap);

        return reportManager.getSyoruiZokusei(pSyoruiCd);
    }

    @Override
    public List<AM_SyoruiZokusei> getSyoruiZokuseiByHozonKikan(Integer pHozonKikan) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("保存期間", pHozonKikan);
        paramLogging(paramMap);

        return reportManager.getSyoruiZokuseiByHozonKikan(pHozonKikan);
    }

    @Override
    public List<AS_TyouhyouSakujyotaisyo> getAllTyouhyouSakujyotaisyo() {
        return reportManager.getAllTyouhyouSakujyotaisyo();
    }

    @Override
    public AS_TyouhyouSakujyotaisyo getTyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {
        return reportManager.getTyouhyouSakujyotaisyo(pSyoruiCd);
    }

    @Override
    public List<AS_TyouhyouSakujyotaisyo> getTyouhyouSakujyotaisyosByHozonKikanOut(Integer pHozonKikan) {
        return reportManager.getTyouhyouSakujyotaisyosByHozonKikanOut(pHozonKikan);
    }

    @Override
    public List<AS_FileSyurui> getAllFileSyuruis() {
        return infrManager.getAllFileSyuruis();
    }

    @Override
    public AS_FileSyurui getFileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル種類コード", pFileSyuruiCd);
        paramLogging(paramMap);

        return infrManager.getFileSyurui(pFileSyuruiCd);
    }

    @Override
    public List<AS_FileSyurui> getFileSyuruiByFileSyuruiKbn(C_FileSyuruiKbn pSyuruiKbn) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル種類区分", pSyuruiKbn);
        paramLogging(paramMap);

        return infrManager.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);
    }

    @Override
    public  List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(String[] pUserRoleCd, String[] pTanmatusettisosikiRoleCd){

        return infrManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(pUserRoleCd, pTanmatusettisosikiRoleCd);
    }

    @Override
    public List<AT_FileHozonInfo> getAllFileHozonInfo() {
        return infrManager.getAllFileHozonInfo();
    }

    @Override
    public List<AT_FileHozonInfo> getFileHozonInfoByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル種類コード", pFileSyuruiCd);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);
    }

    @Override
    public List<AT_FileHozonInfo> getFileHozonInfoByTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル種類コード", pFileSyuruiCd);
        paramMap.put("排他キー", pHaitaKey);
        paramMap.put("登録時間（自）", pTourokuTimeFrom);
        paramMap.put("登録時間（至）", pTourokuTimeTo);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd,
                pHaitaKey,
                pTourokuTimeFrom,
                pTourokuTimeTo);
    }

    @Override
    public List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd, String pTourokuTime){

        return infrManager.getFileHozonInfosByFileSyuruiCdTourokuTime(pFileSyuruiCd, pTourokuTime);
    }
    @Override
    public List<AT_FileHozonInfo> getFileHozonInfoByAllCondition(String pUniqueId,
            String pFileName,
            C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo,
            String pSakuseiKinouId,
            String pSakuseiUserId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル名", pFileName);
        paramMap.put("ファイル種類コード", pFileSyuruiCd);
        paramMap.put("排他キー", pHaitaKey);
        paramMap.put("登録時間（自）", pTourokuTimeFrom);
        paramMap.put("登録時間（至）", pTourokuTimeTo);
        paramMap.put("作成機能ID", pSakuseiKinouId);
        paramMap.put("作成ユーザーID", pSakuseiUserId);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfoByAllCondition(pUniqueId,
                pFileName,
                pFileSyuruiCd,
                pHaitaKey,
                pTourokuTimeFrom,
                pTourokuTimeTo,
                pSakuseiKinouId,
                pSakuseiUserId);
    }

    @Override
    public long getFileHozonInfoCountByFileNm(String pFileNm) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル名", pFileNm);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfoCountByFileNm(pFileNm);
    }


    @Override
    public AT_FileHozonInfo getFileHozonInfo(String pUniqueId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユニークID", pUniqueId);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfo(pUniqueId);
    }

    @Override
    public List<AT_FileHozonInfo> getFileHozonInfoByHaitaKey(C_FileSyuruiCdKbn pFileSyuruiCd, String pHaitaKey) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ファイル種類コード", pFileSyuruiCd);
        paramMap.put("排他キー", pHaitaKey);
        paramLogging(paramMap);

        return infrManager.getFileHozonInfoByHaitaKey(pFileSyuruiCd, pHaitaKey);
    }

    @Override
    public AT_FileHozon getFileHozon(String pUniqueId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ユニークID", pUniqueId);
        paramLogging(paramMap);

        return infrManager.getFileHozon(pUniqueId);
    }

    @Override
    public List<AT_HaitaSeigyo> getAllHaitaSeigyos() {
        return infrManager.getAllHaitaSeigyos();
    }

    @Override
    public AT_HaitaSeigyo getHaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("排他種類コード", pHaitaSyuruiCd);
        paramMap.put("排他キー", pHaitaKey);
        paramLogging(paramMap);

        return infrManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
    }

    @Override
    public List<AS_Sequence> getAllSequences() {
        return infrManager.getAllSequences();
    }

    @Override
    public AS_Sequence getSequence(String pId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ID", pId);
        paramLogging(paramMap);

        return infrManager.getSequence(pId);
    }

    @Override
    public List<AS_FileServerInfo> getAllFileServerInfos() {
        return infrManager.getAllFileServerInfos();
    }

    @Override
    public AS_FileServerInfo getFileServerInfo(Integer pSetteiNo, BizDate pTekiyoYmdFrom) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("設定番号", pSetteiNo);
        paramMap.put("適用年月日(自)", pTekiyoYmdFrom);
        paramLogging(paramMap);

        return infrManager.getFileServerInfo(pSetteiNo, pTekiyoYmdFrom);
    }

    @Override
    public List<AS_Sakujyotaisyo> getAllSakujyotaisyos() {
        return infrManager.getAllSakujyotaisyos();
    }

    @Override
    public AS_Sakujyotaisyo getSakujyotaisyo(String pSakujyotaisyoTableId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("削除対象テーブルID", pSakujyotaisyoTableId);
        paramLogging(paramMap);

        return infrManager.getSakujyotaisyo(pSakujyotaisyoTableId);
    }

    @Override
    public List<AT_MqInfo> getAllMqInfos() {
        return infrManager.getAllMqInfos();
    }

    @Override
    public AT_MqInfo getMqInfo(String pServerType) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("サーバ種別", pServerType);
        paramLogging(paramMap);

        return infrManager.getMqInfo(pServerType);
    }

    @Override
    public List<AS_Sakujyotaisyo> getSakujyotaisyoByHozonKikan(Integer pHozonKikan) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("保存期間", pHozonKikan);
        paramLogging(paramMap);

        return infrManager.getSakujyotaisyoByHozonKikan(pHozonKikan);
    }

    @Override
    public AM_HaitaSyurui getHaitaSyuruiByHaitaSyuruiCd(String pHaitaSyuruiCd){
        return infrManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
    }

    @Override
    public AT_FileRirekiKanri getFileRirekiKanriByHistoryId(String pHistoryId){
        return infrManager.getFileRirekiKanriByHistroyId(pHistoryId);
    }

    @Override
    public AT_SequenceValue getSequenceValueByIdKeys(String pId, String pKeys){
        return infrManager.getSequenceValueByIdKeys(pId, pKeys);
    }

    @Override
    public AT_FileRireki getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(String pUniqueId, String pHistoryId,
            String pTourokuTime, int pFileNmSuffix) {
        return infrManager.getFileRirekiByUniquedIdHistoryIdTourokuTimeFileNm(pUniqueId, pHistoryId, pTourokuTime, pFileNmSuffix);
    }

    @Override
    public List<AS_Kinou> getKinousBySyoricd(String pSyoricd) {
        return sysManager.getKinousBySyoricd(pSyoricd);
    }

    @Override
    public AT_AppIdentifier getAppIdentifierByIdentifier(String pIdentifier){
        return commonManager.getAppIdentifierByIdentifier(pIdentifier);
    }

    @Override
    public List<AT_RinjiKadouTaisyoSosiki> getAllRinjiKadouTaisyoSosiki() {
        return commonManager.getAllRinjiKadouTaisyoSosiki();
    }

    @Override
    public AT_RinjiKadouTaisyoSosiki getRinjiKadouTaisyoSosiki(String pKadouSosikiCd) {
        return commonManager.getRinjiKadouTaisyoSosiki(pKadouSosikiCd);
    }

    @Override
    public List<AT_SystemControlInfo> getAllSystemControlInfo() {
        return commonManager.getAllSystemControlInfo();
    }

    @Override
    public AT_SystemControlInfo getSystemControlInfo(String pSystemCtrlInfo) {
        return commonManager.getSystemControlInfo(pSystemCtrlInfo);
    }

}
