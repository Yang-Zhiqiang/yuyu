package yuyu.def.base.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
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

/**
 * 業務基盤 DOM マネージャー インターフェース<br />
 * カテゴリDomマネージャーを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャーを使用しています。 <br />
 */
public interface BaseDomManager extends DomManager {

    List<AM_IdCard> getAllIdCards();

    AM_IdCard getIdCard(String pIdkbn, String pIdcd);

    List<AT_UserIdKanren> getAllUserIdKanrens();

    AT_UserIdKanren getUserIdKanren(String pIdkbn, String pIdcd);

    List<AM_IdCardYakusyoku> getAllIdCardYakusyokus();

    AM_IdCardYakusyoku getIdCardYakusyoku(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino);

    List<AM_User> getAllUsers();

    AM_User getUser(String pUserId);

    List<AM_User> getUsersByUserIdUserNmSyozokusosikicd(String pUserId, String pUserNm, String pSyozokusosikicd);

    List<TaisyouUserInfosByItemsBean> getTaisyouUserInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
            String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList);

    List<TaisyouUserAndUserRoleInfosByItemsBean> getTaisyouUserAndUserRoleInfosByItems(String pUserId, String pUserNm, String pSyozokusosikicd,
            String[] pSisyaAtukaiSosikiCdList, String[] pSisyaReigaiSosikiCdList);

    List<AM_Sosiki> getAllSosikis();

    List<AM_Sosiki> getSosikisByUserId(String pUserId);

    AM_Sosiki getSosiki(String pSosikicd);

    AM_User getDetachedUser(String pUserId);


    long getUserByCountUserGroupCd(String pUserGroupCd);

    long getUserCountByUserIdKinouIdKinouModeId(String pUserId, String pKinouId, String pKinouModeId);

    List<AM_UserGroup> getAllUserGroups();


    AM_UserGroup getUserGroup(String pUserGroupCd);


    List<AM_UserGroup> getUserGroupsSerchResult(String userGroupCd, String userGroupNm);

    List<AM_Role> getAllRoles();

    AM_Role getRole(String pRoleCd);

    List<AT_UserHenkouRireki> getUserHenkouRirekis(String pUserId);

    AT_PasswordRireki getPasswordRirekiByUniqueId(String pUniqueId);

    AT_UserHenkouRireki getUserHenkouRirekiByUniqueId(String pUniqueId);

    AT_UserSettei getUserSettei(String pUserId);

    Long getHonyakutsgSosikiCdCount();


    List<AS_SubSystem> getAllSubSystems();

    List<AS_SubSystem> getAllSubSystemsSortNoOrder();

    AS_SubSystem getSubSystem(String pSubSystemId);

    List<AS_Category> getAllCategories();

    List<AS_Kinou> getAllKinous();

    List<AS_Kinou> getAllKinous4KinouList();

    List<AS_Kinou> getKinousBySubSystem(String pSubSystemId);

    List<AS_Kinou> getKinousByCategory(String pCategoryId);

    AS_Kinou getKinou(String pKinouId);

    AS_Kinou getDetachedKinou(String pKinouId);

    List<AS_Kinou> getAS_KinousByC_KinouKbn(C_KinouKbn pC_KinouKbn);

    List<AS_KinouMode> getKinouModesByKadouTimeGroup(String pKadouTimeGroupCd);

    List<AS_KinouModeSiborikomi> getKinouModeSiborikomi(String pKinouId, String pKinouModeId);

    List<AT_HolidayGroup> getAllHolidayGroups();

    List<AT_HolidayGroup> getHolidayGroup4Gyoumu();

    AT_HolidayGroup getHolidayGroup(String pHolidayGroupCd);

    List<AT_Holiday> getHolidaysNotExistsYoyaku(String pHolidayGroupCd);

    List<AT_HolidayYoyaku> getHolidayYoyakusByHolidayGroupCd(String pHolidayGroupCd);

    List<AT_KadouTimeGroup> getAllKadouTimeGroups();

    AT_KadouTimeGroup getKadouTimeGroup(String pKadouTimeGroupCd);

    AT_TokuteibiKadouTime getTokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd);

    List<AT_TokuteibiKadouTime> getAllTokuteibiKadouTime();

    AS_Category getCategory(String pCategoryId);

    List<AT_MyMenu> getMyMenu(String pUserId);

    long getCountHolidayByHolidayPattern(String pHolidayPatternParam);

    long getCountHolidayYoyakuByHolidayPattern(String pHolidayPatternParam);

    long getKinouModeByCountKadouTimeGroupCd(String pKadouTimeGroupCd);

    long getTokuteibiKadouTimeByCountKadouTimeGroupCd(String pKadouTimeGroupCd);

    long getKadouTimeGroupByCountHolidayGroupCd(String pHolidayGroupCd);

    long getCountUsersByRoleCd(String pRoleCd);

    AT_KyoutuuInfo getKyoutuuInfoByKinouIdInfoSeqNo(String pKinouId, String pInfoSeqNo);

    List<AT_SosikiRole> getAllSosikiRoles();

    AT_SosikiRole getSosikiRole(String pTanmatusettisosikicd, String pRoleCd);

    List<AT_SosikiRole> getSosikiRolesByTanmatusettisosikicd(String pTanmatusettisosikicd);


    List<AT_RoleSiyouKanouSosiki> getAllRoleSiyouKanouSosikis();

    AT_RoleSiyouKanouSosiki getRoleSiyouKanouSosiki(String pSyozokusosikicd, String pRoleCd);

    List<AT_RoleSiyouKanouSosiki> getRoleSiyouKanouSosikisBySyozokusosikicd(String pSyozokusosikicd);

    List<AT_UserRoleRireki> getAllUserRoleRirekis();

    AT_UserRoleRireki getUserRoleRireki(String pUniqueId);

    List<AT_AccessLog> getAllAccessLogs();

    AT_AccessLog getAccessLog(String pLogId);

    List<AT_AccessLog> selAccessLogs(
            String pSubSystemId,
            String pCategoryId,
            String pKinouId,
            C_KinouKbn pKinouKbn,
            BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
            BizDate pSyoriYmdTo, String pSyoriTimeTo,
            String pUserId,
            String pIpAddress,
            String pSessionId,
            C_AccessLogSyubetuKbn pLogKindCd
            );

    long getAccessLogCount(
            String pSubSystemId,
            String pCategoryId,
            String pKinouId,
            C_KinouKbn pKinouKbn,
            BizDate pSyoriYmdFrom, String pSyoriTimeFrom,
            BizDate pSyoriYmdTo, String pSyoriTimeTo,
            String pUserId,
            String pIpAddress,
            String pSessionId,
            C_AccessLogSyubetuKbn pLogKindCd
            );

    List<AT_AccessLogSyousai> getAccessLogSyousaisByLogIdEdaNoOrder(String pLogId);

    List<AM_Batch> getBatchBySubSystem(String pSubSystemId);

    long getBatchJobCountByIdSyoriYmdJyoutaiKbnResultKbn(
            String[] pBatchIds,
            BizDate pBatchSyoriYmdFrom,
            BizDate pBatchSyoriYmdTo,
            C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
            C_BatchResultKbn[] pBatchResultKbns
            );

    List<AT_BatchJob> getBatchJobListByIdbatchStartTimebatchEndTimeJyoutaiKbnResultKbn(
            String[] pBatchIds,
            BizDate pBatchSyoriYmdFrom,
            BizDate pBatchSyoriYmdTo,
            C_BatchJyoutaiKbn[] pBatchJyoutaiKbns,
            C_BatchResultKbn[] pBatchResultKbns
            );

    List<AT_BatchLog> getBatchLogByBatchJobId(String pBatchJobId);

    List<AT_BatchLogReport> getBatchLogReportByBatchJobId(String pBatchJobId);

    AT_BatchJob getBatchJob(String pBatchJobId);

    AM_Batch getBatch(String pKinouId);

    List<AS_BatchOrder> getBatchOrderByKinouId(String pKinouId);

    List<AS_BatchHeisouList> getBatchHeisouListBySelfKinouId(String pSelfKinouId);

    List<AS_BatchOrder> getBatchOrderExecuteList(String pBatchJobId);

    List<AS_BatchOrder> getBatchOrderList();

    BizDate getBatchDate();

    AT_BatchDate getAT_BatchDate();

    List<AT_BatchDate> getAT_BatchDateAll();

    AS_BatchHeisouList getBatchHeisouListBySelfKinouIdTargetKinouId(String pSelfKinouId, String pTargetKinouId);

    AS_BatchOrder getBatchOrderByBatchJobId(String pBatchJobId);

    AT_BatchDate getBatchDateByDate(BizDate pBatchExecDate);

    AT_TyouhyouHozon getTyouhyouHozon(String pTyouhyouKey);

    AT_TyouhyouKensaku getTyouhyouKensaku(String pUniqueId);

    List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(
            C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount
            );

    long getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(
            C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount
            );

    List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(
            String pSubSystemId, BizDate pSyoriYmd, String pOutCount
            );

    long getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(
            String pSubSystemId, BizDate pSyoriYmd, String pOutCount
            );

    List<AM_SyoruiZokusei> getAllSyoruiZokuseis();

    AM_SyoruiZokusei getSyoruiZokusei(C_SyoruiCdKbn pSyoruiCd);

    List<AM_SyoruiZokusei> getSyoruiZokuseiByHozonKikan(Integer pHozonKikan);

    List<AS_TyouhyouSakujyotaisyo> getAllTyouhyouSakujyotaisyo();

    AS_TyouhyouSakujyotaisyo getTyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd);

    List<AS_TyouhyouSakujyotaisyo> getTyouhyouSakujyotaisyosByHozonKikanOut(Integer pHozonKikan);

    List<AS_FileSyurui> getAllFileSyuruis();

    AS_FileSyurui getFileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd);

    List<AS_FileSyurui> getFileSyuruiByFileSyuruiKbn(C_FileSyuruiKbn pSyuruiKbn);

    List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(String[] pUserRoleCd, String[] pTanmatusettisosikiRoleCd);

    List<AT_FileHozonInfo> getAllFileHozonInfo();

    List<AT_FileHozonInfo> getFileHozonInfoByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd);

    List<AT_FileHozonInfo> getFileHozonInfoByTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo);

    List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd, String pTourokuTime);

    List<AT_FileHozonInfo> getFileHozonInfoByAllCondition(String pUniqueId,
            String pFileName,
            C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo,
            String pSakuseiKinouId,
            String pSakuseiUserId);

    long getFileHozonInfoCountByFileNm(String pFileNm);

    AT_FileHozonInfo getFileHozonInfo(String pUniqueId);

    List<AT_FileHozonInfo> getFileHozonInfoByHaitaKey(C_FileSyuruiCdKbn pFileSyuruiCd, String pHaitaKey);

    AT_FileHozon getFileHozon(String pUniqueId);

    List<AT_HaitaSeigyo> getAllHaitaSeigyos();

    AT_HaitaSeigyo getHaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey);

    List<AS_Sequence> getAllSequences();

    AS_Sequence getSequence(String pId);

    List<AS_FileServerInfo> getAllFileServerInfos();

    AS_FileServerInfo getFileServerInfo(Integer pSetteiNo, BizDate pTekiyoYmdFrom);

    List<AS_Sakujyotaisyo> getAllSakujyotaisyos();

    AS_Sakujyotaisyo getSakujyotaisyo(String pSakujyotaisyoTableId);

    List<AS_Sakujyotaisyo> getSakujyotaisyoByHozonKikan(Integer pHozonKikan);

    List<AT_MqInfo> getAllMqInfos();

    AT_MqInfo getMqInfo(String pServerType);

    AM_HaitaSyurui getHaitaSyuruiByHaitaSyuruiCd(String pHaitaSyuruiCd);

    AT_FileRirekiKanri getFileRirekiKanriByHistoryId(String pHistoryId);

    AT_SequenceValue getSequenceValueByIdKeys(String pId, String pKeys);

    AT_AppIdentifier getAppIdentifierByIdentifier(String pIdentifier);


    AT_FileRireki getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(String pUniqueId, String pHistoryId,
            String pTourokuTime, int pFileNmSuffix);

    AT_KobetuInfo getKobetuInfoByUserId(String pUserId, String pInfoSeqNo);

    List<AS_Kinou> getKinousBySyoricd(String pSyoricd);

    List<AT_RinjiKadouTaisyoSosiki> getAllRinjiKadouTaisyoSosiki();

    AT_RinjiKadouTaisyoSosiki getRinjiKadouTaisyoSosiki(String pKadouSosikiCd);

    List<AT_SystemControlInfo> getAllSystemControlInfo();

    AT_SystemControlInfo getSystemControlInfo(String pSystemCtrlInfo);

    List<AM_HonyakutsgSosikiCd> getAllHonyakutsgSosikiCd();

    AM_HonyakutsgSosikiCd getHonyakutsgSosikiCd(String pSosikicd);

}
