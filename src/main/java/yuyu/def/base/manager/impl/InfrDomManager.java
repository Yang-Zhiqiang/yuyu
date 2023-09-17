package yuyu.def.base.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.result.bean.FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.db.dao.AM_HaitaSyuruiDao;
import yuyu.def.db.dao.AS_FileServerInfoDao;
import yuyu.def.db.dao.AS_FileSyuruiDao;
import yuyu.def.db.dao.AS_SakujyotaisyoDao;
import yuyu.def.db.dao.AS_SequenceDao;
import yuyu.def.db.dao.AT_FileHozonDao;
import yuyu.def.db.dao.AT_FileHozonInfoDao;
import yuyu.def.db.dao.AT_FileRirekiDao;
import yuyu.def.db.dao.AT_FileRirekiKanriDao;
import yuyu.def.db.dao.AT_HaitaSeigyoDao;
import yuyu.def.db.dao.AT_MqInfoDao;
import yuyu.def.db.dao.AT_SequenceValueDao;
import yuyu.def.db.entity.AM_HaitaSyurui;
import yuyu.def.db.entity.AS_FileServerInfo;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.entity.AT_FileRireki;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.def.db.entity.AT_MqInfo;
import yuyu.def.db.entity.AT_SequenceValue;

/**
 * インフラドメインDomマネージャー
 * インフラドメインにおける、DB操作を提供する。
 * 処理対象となるTBL(Entity)は、E-R図を確認すること。
 */
class InfrDomManager {

    @Inject
    private AS_FileSyuruiDao fileSyuruiDao;

    @Inject
    private AT_FileHozonInfoDao fileHozonInfoDao;

    @Inject
    private AT_FileHozonDao fileHozonDao;

    @Inject
    private AT_HaitaSeigyoDao haitaSeigyoDao;

    @Inject
    private AS_SequenceDao sequenceDao;

    @Inject
    private AS_FileServerInfoDao fileServerInfoDao;

    @Inject
    private AS_SakujyotaisyoDao sakujyotaisyoDao;

    @Inject
    private AT_MqInfoDao mqInfoDao;

    @Inject
    private AM_HaitaSyuruiDao haitaSyuruiDao;

    @Inject
    private AT_FileRirekiKanriDao fileRirekiKanriDao;

    @Inject
    private AT_SequenceValueDao sequenceValueDao;

    @Inject
    private AT_FileRirekiDao fileRirekiDao;


    List<AS_FileSyurui> getAllFileSyuruis() {
        return fileSyuruiDao.selectAll();
    }

    AS_FileSyurui getFileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        return fileSyuruiDao.getAS_FileSyurui(pFileSyuruiCd);
    }

    List<AS_FileSyurui> getFileSyuruiByFileSyuruiKbn(
            C_FileSyuruiKbn pSyuruiKbn) {
        return fileSyuruiDao.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);
    }

    List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(String[] pUserRoleCd, String[] pTanmatusettisosikiRoleCd){
        return fileSyuruiDao.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(pUserRoleCd, pTanmatusettisosikiRoleCd);
    }

    List<AT_FileHozonInfo> getAllFileHozonInfo() {
        return fileHozonInfoDao.getAllFileHozonInfo();
    }

    List<AT_FileHozonInfo> getFileHozonInfoByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        return fileHozonInfoDao.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);
    }

    public List<AT_FileHozonInfo> getFileHozonInfoByHaitaKey(C_FileSyuruiCdKbn pFileSyuruiCd, String pHaitaKey) {
        return fileHozonInfoDao.getFileHozonInfoByHaitaKey(pFileSyuruiCd, pHaitaKey);
    }

    long getFileHozonInfoCountByFileNm(String pFileNm) {
        return fileHozonInfoDao.getFileHozonInfoCountByFileNm(pFileNm);
    }

    AT_FileHozonInfo getFileHozonInfo(String pUniqueId) {
        return fileHozonInfoDao.getAT_FileHozonInfo(pUniqueId);
    }

    List<AT_FileHozonInfo> getFileHozonInfoByTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo){
        return fileHozonInfoDao.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);
    }

    List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd, String pTourokuTime){
        return fileHozonInfoDao.getFileHozonInfosByFileSyuruiCdTourokuTime(pFileSyuruiCd, pTourokuTime);
    }


    public List<AT_FileHozonInfo> getFileHozonInfoByAllCondition(String pUniqueId,
            String pFileName,
            C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo,
            String pSakuseiKinouId,
            String pSakuseiUserId) {

        return fileHozonInfoDao.getFileHozonInfoByAllCondition(pUniqueId,
                pFileName,
                pFileSyuruiCd,
                pHaitaKey,
                pTourokuTimeFrom,
                pTourokuTimeTo,
                pSakuseiKinouId,
                pSakuseiUserId);
    }
    AT_FileHozon getFileHozon(String pUniqueId) {
        return fileHozonDao.getAT_FileHozon(pUniqueId);
    }

    List<AT_HaitaSeigyo> getAllHaitaSeigyos() {
        return haitaSeigyoDao.selectAll();
    }

    AT_HaitaSeigyo getHaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        return haitaSeigyoDao.getAT_HaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
    }

    List<AS_Sequence> getAllSequences() {
        return sequenceDao.selectAll();
    }

    AS_Sequence getSequence(String pId) {
        return sequenceDao.getAS_Sequence(pId);
    }

    List<AS_FileServerInfo> getAllFileServerInfos() {
        return fileServerInfoDao.selectAll();
    }

    AS_FileServerInfo getFileServerInfo(Integer pSetteiNo, BizDate pTekiyoYmdFrom) {
        return fileServerInfoDao.getAS_FileServerInfo(pSetteiNo, pTekiyoYmdFrom);
    }

    List<AS_Sakujyotaisyo> getAllSakujyotaisyos() {
        return sakujyotaisyoDao.selectAll();
    }

    AS_Sakujyotaisyo getSakujyotaisyo(String pSakujyotaisyoTableId) {
        return sakujyotaisyoDao.getAS_Sakujyotaisyo(pSakujyotaisyoTableId);
    }

    List<AS_Sakujyotaisyo> getSakujyotaisyoByHozonKikan(Integer pHozonKikan) {
        return sakujyotaisyoDao.getSakujyotaisyoByHozonKikan(pHozonKikan);
    }

    List<AT_MqInfo> getAllMqInfos() {
        return mqInfoDao.selectAll();
    }

    AT_MqInfo getMqInfo(String pServerType) {
        return mqInfoDao.getAT_MqInfo(pServerType);
    }

    AM_HaitaSyurui getHaitaSyuruiByHaitaSyuruiCd(String pHaitaSyuruiCd){
        return haitaSyuruiDao.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
    }

    AT_FileRirekiKanri getFileRirekiKanriByHistroyId(String pHistoryId){
        return fileRirekiKanriDao.getFileRirekiKanriByHistoryId(pHistoryId);
    }

    AT_SequenceValue getSequenceValueByIdKeys(String pId, String pKeys){
        return sequenceValueDao.getSequenceValueByIdKeys(pId, pKeys);
    }

    AT_FileRireki getFileRirekiByUniquedIdHistoryIdTourokuTimeFileNm(String pUniqueId, String pHistoryId,
            String pTourokuTime, int pFileNmSuffix){

        return fileRirekiDao.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId, pHistoryId, pTourokuTime,
                pFileNmSuffix);
    }
}