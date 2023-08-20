package yuyu.def.workflowcore.manager;

import java.util.List;
import java.util.Map;

import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.classification.C_RirekiKbn;
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


/**
 * iwfcore DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface IwfCoreDomManager extends DomManager{

    List<WT_KengenKoutei> getKengenKouteiByUserId(String pUserId);

    List<WT_KengenSyorui> getKengenSyoruiByUserId(String pUserId);

    WM_TorikomiSyorui getTorikomiSyorui(String pTorikomiSyoruiCd);

    List<WM_TorikomiSyorui> getAllTorikomiSyorui();

    List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd);

    List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd, String pSyzkDaibunruiId, String pSyzkSyoubunruiId, String pFlowId, String pNodeId);

    List<WM_TorikomiSyorui> getTorikomiSyoruis(String pTorikomiSyoruiCd, String[] pFlowids);

    WT_GyoumuKey getGyoumuKey(String pFlowId, String pGyoumuKey);

    List<WT_GyoumuKey> getAllGyoumuKey();

    List<WT_GyoumuKey> getGyoumuKeys(String pGyoumuKey);

    List<WT_GyoumuKey> getGyoumuKeys(String pFlowId, String pTokenId);

    List<WT_GyoumuKey> getGyoumuKeysByTokenId(String pTokenId);

    public List<WT_GyoumuKey> getGyoumuKeysByFlowIdTokenId(String pFlowId, String pTokenId);

    List<String> getGyoumuKeysDistinctGyoumuKey();

    WT_KengenKoutei getKengenKoutei(String pRoleCd, String pFlowId, String pNodeId);

    List<WT_KengenKoutei> getKengenKouteisByRoleCd(String pRoleCd);

    List<WT_KengenKoutei> getKengenKouteisByRoleCds(String[] pRoleCds);

    List<WT_KengenKoutei> getKengenKouteisByFlowIdNodeId(String pFlowId, String pNodeId);

    public List<WT_KengenKoutei> getKengenKouteisByFlowIdRoleCd(String pFlowId, String pRoleCd);

    WT_KengenSyorui getKengenSyorui(String pRoleCd, String pTorikomiSyoruiCd);

    List<WT_KengenSyorui> getAllKengenSyorui();

    List<WT_KengenSyorui> getKengenSyoruisByRoleCd(String pRoleCd);

    List<WT_KengenSyorui> getKengenSyoruisByRoleCds(String[] pRoleCds);

    List<WT_KengenSyorui> getKengenSyoruis(String pTorikomiSyoruiCd, String... pRoleCds);

    WT_KouteiRireki getKouteiRireki(String pTokenId, C_RirekiKbn pRirekiKbn, String pSyoriTime);

    List<WT_KouteiRireki> getAllKouteiRireki();

    List<String> getKouteiRirekis();

    Long getCountKouteiRirekiByGyoumukeyFlowidRirekiKbn(String pGyoumukey, String pFlowid, C_RirekiKbn pRirekiKbn);

    List<WT_KouteiRireki> getKouteiRirekis(String pGyoumukey, String pFlowid, C_RirekiKbn pRirekiKbn);

    List<WT_KouteiRireki> getKouteiRirekis(String pUserId, List<String> pListFlowid, C_RirekiKbn pRirekiKbn,
        String pSyoriTimeFrom, String pSyoriTimeTo);

    WT_KouteiSummary getKouteiSummary(String pGyoumuKey);

    List<WT_KouteiSummary> getAllKouteiSummary();

    Long getCountKouteiSummary(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus, String pAccountid, String pAccountwariateumu,
        String pNodename, Map<String, WSExtParam> pExtParam);

    List<WT_KouteiSummary> getKouteiSummarys(String[] pGyoumukeys, String[] pFlowids, String pKouteikaisibifrom,
        String pKouteikaisibito, String pKouteikanryoubifrom, String pKouteikanryoubito, String pLastSyoritimefrom,
        String pLastSyoritimeto, String[] pSyoristatus, String pAccountid, String pAccountwariateumu,
        String pNodename, Map<String, WSExtParam> pExtParam);

    WT_Page getPage(String pImageId, String pSyoruiToutyakuTime, Integer pPageNo);

    List<WT_Page> getAllPage();

    List<WT_Page> getPages(String pImageId);

    List<WT_Page> getPages(String pImageId, String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo);

    WT_PDFHozon getPDFHozon(String pImageId, String pPageId);

    List<WT_PDFHozon> getAllPDFHozon();

    WT_TorikomiKanri getTorikomiKanri(String pImageId);

    List<WT_TorikomiKanri> getAllTorikomiKanri();

    List<WT_TorikomiKanri> getTorikomiKanris(String pImageId);

    List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCd(String pTorikomiSyoruiCd);

    List<WT_TorikomiKanri> getTorikomiKanrisBySyoruiCds(String[] pTorikomiSyoruiCds);

    List<WT_TorikomiKanri> getTorikomiKanrisByImageIds(String[] pImageIds);

    List<WT_TorikomiKanri> getTorikomiKanris(WT_TorikomiKanri pWT_TorikomiKanri);

    List<WT_KengenKoutei> getAllKengenKoutei();

    List<JBPM_PROCESSDEFINITION> getAllProcessDef();

    List<JBPM_PROCESSDEFINITION> getProcessDefsByNames(String[] flowIds);

    List<Object[]> getLatestProcessDefs();

    JBPM_PROCESSDEFINITION getProcessDefByProcIns(Long procInsId);

    List<JBPM_TASK> getAllTask();

    List<JBPM_TASKINSTANCE> getAllTaskInstance();

    List<JBPM_TASKINSTANCE> getTaskInstances();

    JBPM_TASKINSTANCE getActiveTaskInstanceWithTokenId(Long pTokenId);

    List<Object[]> getTaskNodeInfo();

    List<String> getNodesByProcDefId(Long procDefId);

    List<JBPM_TASKINSTANCE> getExecutableTasksByCond(String[] pSyoriStatus, String[] pFlowIds,
        String pKouteiKaisiYmdFrom, String pKouteiKaisiYmdTo,
        String pKouteiKanryouYmdFrom, String pKouteiKanryouYmdTo, Map<String, WSExtParam> pExtParam);

    WT_TaskSummary getTaskSummary(String pFlowId, String pTaskId, String pTokenId, String pTaskcreatetimeto);

    List<WT_TaskSummary> getAllTaskSummary();

    List<WT_TaskSummary> getTaskSummaryByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowId, String pTaskId,
        String pTaskcreatetimefrom,
        String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto);

    List<Object[]> getTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu, String pFlowId,
        String pTaskId,
        String pTaskcreatetimefrom,
        String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto);

    List<Object[]> getUserBetsuTaskKensuuByCond(String pAccountid, String pWariateumu, String pTaskendumu,
        String pFlowId,
        String pTaskId,
        String pTaskcreatetimefrom,
        String pTaskcreatetimeto, String pTaskstarttimefrom, String pTaskstarttimeto,
        String pTaskendtimefrom, String pTaskendtimeto);

    int deleteAllTaskSummary();

    int deleteTaskSummaryWithFlowIds(String[] flowIds);

    WT_ImageArriveNotice getImageArriveNotice(String pArrivekey);

    List<WT_ImageArriveNotice> getAllImageArriveNotice();

    List<WT_ImageArriveNotice> getImageArriveNoticeByCond(String pArrivekey, String pFlowid, String pGyoumukey,
        String pTorikomisyoruicd, String pSubsystemid);

    WT_KouteiLock getKouteiLock(String pFlowId, String pGyoumuKey);

    List<WT_KouteiLock> getKouteiLockByCond(String[] pGyoumukeys, String[] pFlowids);

    WT_TorikomiRelation getTorikomiRelation(String pImageId, String pGyoumuKey);

    List<WT_TorikomiRelation> getAllTorikomiRelation();

    List<WT_TorikomiRelation> getTorikomiRelations(String pGyoumuKey);

    List<WT_TorikomiRelation> getTorikomiRelationsByImageId(String pImageId);

    List<WT_TorikomiRelation> getTorikomiRelations(String[] pImageIds);
}
