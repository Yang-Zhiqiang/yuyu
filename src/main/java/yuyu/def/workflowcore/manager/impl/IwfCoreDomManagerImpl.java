package yuyu.def.workflowcore.manager.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.dao.JBPM_PROCESSDEFINITIONDao;
import yuyu.def.db.dao.JBPM_TASKDao;
import yuyu.def.db.dao.JBPM_TASKINSTANCEDao;
import yuyu.def.db.dao.WM_TorikomiSyoruiDao;
import yuyu.def.db.dao.WT_GyoumuKeyDao;
import yuyu.def.db.dao.WT_ImageArriveNoticeDao;
import yuyu.def.db.dao.WT_KengenKouteiDao;
import yuyu.def.db.dao.WT_KengenSyoruiDao;
import yuyu.def.db.dao.WT_KouteiLockDao;
import yuyu.def.db.dao.WT_KouteiRirekiDao;
import yuyu.def.db.dao.WT_KouteiSummaryDao;
import yuyu.def.db.dao.WT_PDFHozonDao;
import yuyu.def.db.dao.WT_PageDao;
import yuyu.def.db.dao.WT_TaskSummaryDao;
import yuyu.def.db.dao.WT_TorikomiKanriDao;
import yuyu.def.db.dao.WT_TorikomiRelationDao;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;
import yuyu.def.db.entity.JBPM_TASK;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.AbstractDomManager;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
/**
 * iwfcore DOM マネージャ 実装クラス<br />
 * {@link IwfCoreDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */

public class IwfCoreDomManagerImpl extends AbstractDomManager implements IwfCoreDomManager {

    @Inject
    private WM_TorikomiSyoruiDao wM_TorikomiSyoruiDao;

    @Inject
    private WT_GyoumuKeyDao wT_GyoumuKeyDao;

    @Inject
    private WT_KengenKouteiDao wT_KengenKouteiDao;

    @Inject
    private WT_KengenSyoruiDao wT_KengenSyoruiDao;

    @Inject
    private WT_KouteiRirekiDao wT_KouteiRirekiDao;

    @Inject
    private WT_KouteiSummaryDao wT_KouteiSummaryDao;

    @Inject
    private WT_PageDao wT_PageDao;

    @Inject
    private WT_PDFHozonDao wT_PDFHozonDao;

    @Inject
    private WT_TorikomiKanriDao wT_TorikomiKanriDao;

    @Inject
    private JBPM_PROCESSDEFINITIONDao jBPM_PROCESSDEFINITIONDao;

    @Inject
    private JBPM_TASKDao jBPM_TASKDao;

    @Inject
    private JBPM_TASKINSTANCEDao jBPM_TASKINSTANCEDao;

    @Inject
    private WT_TaskSummaryDao wT_TaskSummaryDao;

    @Inject
    private WT_ImageArriveNoticeDao wT_ImageArriveNoticeDao;

    @Inject
    private WT_KouteiLockDao wT_KouteiLockDao;

    @Inject
    private WT_TorikomiRelationDao wT_TorikomiRelationDao;

    @Override
    public WM_TorikomiSyorui getTorikomiSyorui(String pTorikomiSyoruiCd) {
        return wM_TorikomiSyoruiDao.getTorikomiSyorui(pTorikomiSyoruiCd);
    }

    @Override
    public List<WM_TorikomiSyorui> getAllTorikomiSyorui() {
        return wM_TorikomiSyoruiDao.getAllTorikomiSyorui();
    }

    @Override
    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd) {
        return wM_TorikomiSyoruiDao.getTorikomiSyoruis(pTorikomiSyoruiCd);
    }

    @Override
    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd,
        String pSyzkDaibunruiId, String pSyzkSyoubunruiId, String pFlowId,
        String pNodeId) {
        return wM_TorikomiSyoruiDao.getTorikomiSyoruis(pTorikomiSyoruiCd, pSyzkDaibunruiId, pSyzkSyoubunruiId, pFlowId, pNodeId);
    }

    @Override
    public List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd, String[] pFlowids) {
        return wM_TorikomiSyoruiDao.getTorikomiSyoruis(pTorikomiSyoruiCd, pFlowids);
    }

    @Override
    public WT_GyoumuKey getGyoumuKey(String pFlowId, String pGyoumuKey) {
        return wT_GyoumuKeyDao.getGyoumuKey(pFlowId, pGyoumuKey);
    }

    @Override
    public List<WT_GyoumuKey> getAllGyoumuKey() {
        return wT_GyoumuKeyDao.getAllGyoumuKey();
    }

    @Override
    public List<WT_GyoumuKey> getGyoumuKeys(String pGyoumuKey) {
        return wT_GyoumuKeyDao.getGyoumuKeys(pGyoumuKey);
    }

    @Override
    public List<WT_GyoumuKey> getGyoumuKeys(String pFlowId, String pTokenId) {
        return wT_GyoumuKeyDao.getGyoumuKeys(pFlowId, pTokenId);
    }

    @Override
    public List<WT_GyoumuKey> getGyoumuKeysByTokenId(String pTokenId) {
        return wT_GyoumuKeyDao.getGyoumuKeysByTokenId(pTokenId);
    }

    @Override
    public List<WT_GyoumuKey> getGyoumuKeysByFlowIdTokenId(String pFlowId, String pTokenId) {
        return wT_GyoumuKeyDao.getGyoumuKeysByFlowIdTokenId(pFlowId, pTokenId);
    }

    @Override
    public List<String> getGyoumuKeysDistinctGyoumuKey() {
        return wT_GyoumuKeyDao.getGyoumuKeysDistinctGyoumuKey();
    }

    @Override
    public List<WT_KengenKoutei> getKengenKouteiByUserId(String pUserId) {
        return wT_KengenKouteiDao.getKengenKouteiByUserId(pUserId);
    }

    @Override
    public List<WT_KengenSyorui> getKengenSyoruiByUserId(String pUserId) {
        return wT_KengenSyoruiDao.getKengenSyoruiByUserId(pUserId);
    }

    @Override
    public WT_KengenKoutei getKengenKoutei(String pRoleCd, String pFlowId,
        String pNodeId) {
        return wT_KengenKouteiDao.getKengenKoutei(pRoleCd, pFlowId, pNodeId);
    }

    @Override
    public List<WT_KengenKoutei> getKengenKouteisByRoleCd(String pRoleCd) {
        return wT_KengenKouteiDao.getKengenKouteisByRoleCd(pRoleCd);
    }

    @Override
    public List<WT_KengenKoutei> getKengenKouteisByRoleCds(String[] pRoleCd) {
        return wT_KengenKouteiDao.getKengenKouteisByRoleCds(pRoleCd);
    }

    @Override
    public List<WT_KengenKoutei> getKengenKouteisByFlowIdNodeId(String pFlowId,
        String pNodeId) {
        return wT_KengenKouteiDao.getKengenKouteisByFlowIdNodeId(pFlowId, pNodeId);
    }

    @Override
    public List<WT_KengenKoutei> getKengenKouteisByFlowIdRoleCd(String pFlowId, String pRoleCd) {
        return wT_KengenKouteiDao.getKengenKouteisByFlowIdRoleCd(pFlowId, pRoleCd);
    }

    @Override
    public WT_KengenSyorui getKengenSyorui(String pRoleCd,
        String pTorikomiSyoruiCd) {
        return wT_KengenSyoruiDao.getKengenSyorui(pRoleCd, pTorikomiSyoruiCd);
    }

    @Override
    public List<WT_KengenSyorui> getAllKengenSyorui() {
        return wT_KengenSyoruiDao.selectAll();
    }

    @Override
    public List<WT_KengenSyorui> getKengenSyoruisByRoleCd(String pRoleCd) {
        return wT_KengenSyoruiDao.getKengenSyoruisByRoleCd(pRoleCd);
    }

    @Override
    public List<WT_KengenSyorui> getKengenSyoruisByRoleCds(String[] pRoleCds) {
        return wT_KengenSyoruiDao.getKengenSyoruisByRoleCds(pRoleCds);
    }

    @Override
    public List<WT_KengenSyorui> getKengenSyoruis(String pTorikomiSyoruiCd,
        String... pRoleCds) {
        return wT_KengenSyoruiDao.getKengenSyoruis(pTorikomiSyoruiCd, pRoleCds);
    }

    @Override
    public WT_KouteiRireki getKouteiRireki(String pTokenId,
        C_RirekiKbn pRirekiKbn, String pSyoriTime) {
        return wT_KouteiRirekiDao.getKouteiRireki(pTokenId, pRirekiKbn, pSyoriTime);
    }

    @Override
    public List<WT_KouteiRireki> getAllKouteiRireki() {
        return wT_KouteiRirekiDao.getAllKouteiRireki();
    }

    @Override
    public List<String> getKouteiRirekis() {
        return wT_KouteiRirekiDao.getKouteiRirekis();
    }

    @Override
    public Long getCountKouteiRirekiByGyoumukeyFlowidRirekiKbn(String pGyoumukey, String pFlowid,
        C_RirekiKbn pRirekiKbn) {
        return wT_KouteiRirekiDao.getCount(pGyoumukey, pFlowid, pRirekiKbn);
    }

    @Override
    public List<WT_KouteiRireki> getKouteiRirekis(String pGyoumukey,
        String pFlowid, C_RirekiKbn pRirekiKbn) {
        return wT_KouteiRirekiDao.getKouteiRirekis(pGyoumukey, pFlowid, pRirekiKbn);
    }

    @Override
    public  List<WT_KouteiRireki> getKouteiRirekis(String pUserId, List<String> pListFlowid, C_RirekiKbn pRirekiKbn, String pSyoriTimeFrom, String pSyoriTimeTo) {
        return wT_KouteiRirekiDao.getKouteiRirekis(pUserId, pListFlowid, pRirekiKbn, pSyoriTimeFrom, pSyoriTimeTo);
    }

    @Override
    public WT_KouteiSummary getKouteiSummary(String pGyoumuKey) {
        return wT_KouteiSummaryDao.getKouteiSummary(pGyoumuKey);
    }

    @Override
    public List<WT_KouteiSummary> getAllKouteiSummary() {
        return wT_KouteiSummaryDao.getAllKouteiSummary();
    }

    @Override
    public Long getCountKouteiSummary(String[] pGyoumukeys, String[] pFlowids,
        String pKouteikaisibifrom, String pKouteikaisibito,
        String pKouteikanryoubifrom, String pKouteikanryoubito,
        String pLastSyoritimefrom,
        String pLastSyoritimeto,
        String[] pSyoristatus, String pAccountid,
        String pAccountwariateumu, String pNodename, Map<String, WSExtParam> pExtParam) {
        return wT_KouteiSummaryDao.getCount(pGyoumukeys, pFlowids,
            pKouteikaisibifrom, pKouteikaisibito, pKouteikanryoubifrom,
            pKouteikanryoubito, pLastSyoritimefrom, pLastSyoritimeto,pSyoristatus, pAccountid,
            pAccountwariateumu, pNodename, pExtParam);
    }

    @Override
    public List<WT_KouteiSummary> getKouteiSummarys(String[] pGyoumukeys,
        String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom,
        String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus,
        String pAccountid, String pAccountwariateumu, String pNodename, Map<String, WSExtParam> pExtParam) {
        return wT_KouteiSummaryDao.getKouteiSummarys(pGyoumukeys, pFlowids,
            pKouteikaisibifrom, pKouteikaisibito, pKouteikanryoubifrom,
            pKouteikanryoubito, pLastSyoritimefrom, pLastSyoritimeto, pSyoristatus, pAccountid,
            pAccountwariateumu, pNodename, pExtParam);
    }

    @Override
    public WT_Page getPage(String pImageId, String pSyoruiToutyakuTime,
        Integer pPageNo) {
        return wT_PageDao.getPage(pImageId, pSyoruiToutyakuTime, pPageNo);
    }

    @Override
    public List<WT_Page> getAllPage() {
        return wT_PageDao.getAllPage();
    }

    @Override
    public List<WT_Page> getPages(String pImageId) {
        return wT_PageDao.getPages(pImageId);
    }

    @Override
    public List<WT_Page> getPages(String pImageId,
        String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo) {
        return wT_PageDao.getPages(pImageId, pSyoruiToutyakuTimeFrom, pSyoruiToutyakuTimeTo);
    }

    @Override
    public WT_PDFHozon getPDFHozon(String pImageId, String pPageId) {
        return wT_PDFHozonDao.getPDFHozon(pImageId, pPageId);
    }

    @Override
    public List<WT_PDFHozon> getAllPDFHozon() {
        return wT_PDFHozonDao.getAllPDFHozon();
    }

    @Override
    public WT_TorikomiKanri getTorikomiKanri(String pImageId) {
        return wT_TorikomiKanriDao.getTorikomiKanri(pImageId);
    }

    @Override
    public List<WT_TorikomiKanri> getAllTorikomiKanri() {
        return wT_TorikomiKanriDao.getAllTorikomiKanri();
    }

    @Override
    public List<WT_TorikomiKanri> getTorikomiKanris(String pImageId) {
        return wT_TorikomiKanriDao.getTorikomiKanris(pImageId);
    }

    @Override
    public List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCd(String pTorikomiSyoruiCd) {
        return wT_TorikomiKanriDao.getTorikomiKanrisBySyoruiCd(pTorikomiSyoruiCd);
    }

    @Override
    public List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCds(String[] pTorikomiSyoruiCds) {
        return wT_TorikomiKanriDao.getTorikomiKanrisBySyoruiCds(pTorikomiSyoruiCds);
    }

    @Override
    public List<WT_TorikomiKanri> getTorikomiKanrisByImageIds(String[] pImageIds) {
        return wT_TorikomiKanriDao.getTorikomiKanrisByImageIds(pImageIds);
    }

    @Override
    public List<WT_TorikomiKanri> getTorikomiKanris(WT_TorikomiKanri pWT_TorikomiKanri){
        return wT_TorikomiKanriDao.getTorikomiKanris(pWT_TorikomiKanri);
    }

    @Override
    public List<WT_KengenKoutei> getAllKengenKoutei() {
        return wT_KengenKouteiDao.selectAll();
    }

    @Override
    public WT_TaskSummary getTaskSummary(String pFlowId, String pTaskId, String pTokenId, String pTaskcreatetimeto) {
        return wT_TaskSummaryDao.getTaskSummary(pFlowId, pTaskId, pTokenId, pTaskcreatetimeto);
    }

    @Override
    public List<JBPM_PROCESSDEFINITION> getAllProcessDef() {
        return jBPM_PROCESSDEFINITIONDao.getAllProcessDef();
    }

    @Override
    public List<JBPM_PROCESSDEFINITION> getProcessDefsByNames(String[] flowIds) {
        return jBPM_PROCESSDEFINITIONDao.getProcessDefsByNames(flowIds);
    }

    @Override
    public List<Object[]> getLatestProcessDefs() {
        return jBPM_PROCESSDEFINITIONDao.getLatestProcessDefs();
    }

    @Override
    public JBPM_PROCESSDEFINITION getProcessDefByProcIns(Long procInsId){
        return jBPM_PROCESSDEFINITIONDao.getProcessDefByProcIns(procInsId);
    }

    @Override
    public List<JBPM_TASK> getAllTask() {
        return jBPM_TASKDao.getAllTask();
    }

    @Override
    public List<JBPM_TASKINSTANCE> getAllTaskInstance() {
        return jBPM_TASKINSTANCEDao.getAllTaskInstance();
    }

    @Override
    public List<JBPM_TASKINSTANCE> getTaskInstances() {
        return jBPM_TASKINSTANCEDao.getTaskInstances();
    }

    @Override
    public JBPM_TASKINSTANCE getActiveTaskInstanceWithTokenId(Long pTokenId) {
        return jBPM_TASKINSTANCEDao.getActiveTaskInstanceWithTokenId(pTokenId);
    }

    @Override
    public List<Object[]> getTaskNodeInfo() {
        return jBPM_TASKINSTANCEDao.getTaskNodeInfo();
    }

    @Override
    public List<String> getNodesByProcDefId(Long procDefId) {
        return jBPM_TASKDao.getNodesByProcDefId(procDefId);
    }

    @Override
    public List<JBPM_TASKINSTANCE> getExecutableTasksByCond(String[] pSyoriStatus, String[] pFlowIds,
        String pKouteiKaisiYmdFrom,
        String pKouteiKaisiYmdTo, String pKouteiKanryouYmdFrom, String pKouteiKanryouYmdTo,
        Map<String, WSExtParam> pExtParam) {
        return jBPM_TASKINSTANCEDao.getExecutableTasksByCond(pSyoriStatus, pFlowIds,
            pKouteiKaisiYmdFrom, pKouteiKaisiYmdTo, pKouteiKanryouYmdFrom, pKouteiKanryouYmdTo, pExtParam);
    }

    @Override
    public List<WT_TaskSummary> getAllTaskSummary() {
        return wT_TaskSummaryDao.getAllTaskSummary();
    }

    @Override
    public List<WT_TaskSummary> getTaskSummaryByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {
        return wT_TaskSummaryDao.getTaskSummaryByCond(pAccountid, pWariateumu, pTaskendumu, pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto);
    }

    @Override
    public List<Object[]> getTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {
        return wT_TaskSummaryDao.getTaskKensuuByCond(pAccountid, pWariateumu, pTaskendumu, pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto);
    }

    @Override
    public List<Object[]> getUserBetsuTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowid,
        String pTaskid,
        String pTaskcreatetimefrom, String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto) {
        return wT_TaskSummaryDao.getUserBetsuTaskKensuuByCond(pAccountid, pWariateumu, pTaskendumu, pFlowid, pTaskid,
            pTaskcreatetimefrom, pTaskcreatetimeto, pTaskstarttimefrom, pTaskstarttimeto, pTaskendtimefrom,
            pTaskendtimeto);
    }

    @Override
    public int deleteAllTaskSummary() {
        return wT_TaskSummaryDao.deleteAllTaskSummary();
    }

    @Override
    public int deleteTaskSummaryWithFlowIds(String[] flowIds) {
        return wT_TaskSummaryDao.deleteTaskSummaryWithFlowIds(flowIds);
    }

    @Override
    public WT_ImageArriveNotice getImageArriveNotice(String pArrivekey) {
        return wT_ImageArriveNoticeDao.getImageArriveNotice(pArrivekey);
    }

    @Override
    public List<WT_ImageArriveNotice> getAllImageArriveNotice() {
        return wT_ImageArriveNoticeDao.getAllImageArriveNotice();
    }

    @Override
    public List<WT_ImageArriveNotice> getImageArriveNoticeByCond(String pArrivekey, String pFlowid, String pGyoumukey, String pTorikomisyoruicd,String  pSubsystemid) {
        return wT_ImageArriveNoticeDao.getImageArriveNoticeByCond(pArrivekey, pFlowid, pGyoumukey, pTorikomisyoruicd, pSubsystemid);
    }

    @Override
    public WT_KouteiLock getKouteiLock(String pFlowId, String pGyoumuKey) {
        return wT_KouteiLockDao.getKouteiLock(pFlowId, pGyoumuKey);
    }

    @Override
    public List<WT_KouteiLock> getKouteiLockByCond(String[] pGyoumukeys, String[] pFlowids) {
        return wT_KouteiLockDao.getKouteiLockByCond(pGyoumukeys, pFlowids);
    }

    @Override
    public WT_TorikomiRelation getTorikomiRelation(String pImageId, String pGyoumuKey) {
        return wT_TorikomiRelationDao.getTorikomiRelation(pImageId, pGyoumuKey);
    }

    @Override
    public List<WT_TorikomiRelation> getAllTorikomiRelation() {
        return wT_TorikomiRelationDao.getAllTorikomiRelation();
    }

    @Override
    public List<WT_TorikomiRelation> getTorikomiRelations(String pGyoumuKey) {
        return wT_TorikomiRelationDao.getTorikomiRelations(pGyoumuKey);
    }

    @Override
    public List<WT_TorikomiRelation> getTorikomiRelationsByImageId(String pImageId) {
        return wT_TorikomiRelationDao.getTorikomiRelationsByImageId(pImageId);
    }

    @Override
    public List<WT_TorikomiRelation> getTorikomiRelations(String[] pImageIds) {
        return wT_TorikomiRelationDao.getTorikomiRelations(pImageIds);
    }
}
