package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.bean.AddressDistinctItemsBypostalCdBean;
import yuyu.def.biz.result.bean.AddressDistinctPostAdrkjAdrknbkarisByItemsBean;
import yuyu.def.biz.result.bean.GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean;
import yuyu.def.biz.result.bean.SyoruiZokuseiTyouhyouInfoBean;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdBean;
import yuyu.def.biz.result.bean.UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean;
import yuyu.def.biz.sorter.SortBM_Address;
import yuyu.def.biz.sorter.SortBM_PalSyoumetujiyuu;
import yuyu.def.biz.sorter.SortBM_SeisanDShrymd;
import yuyu.def.biz.sorter.SortBM_Simekiribi;
import yuyu.def.biz.sorter.SortBM_SosikiMadoguti;
import yuyu.def.biz.sorter.SortBM_Syonokanri;
import yuyu.def.biz.sorter.SortBM_Syoritanto;
import yuyu.def.biz.sorter.SortBM_TantouCd;
import yuyu.def.biz.sorter.SortBM_WariateHukaInfoKanri;
import yuyu.def.biz.sorter.SortBT_GyoumuKouteiInfo;
import yuyu.def.biz.sorter.SortBT_HengakuEpsilonDenpyo;
import yuyu.def.biz.sorter.SortBT_KinouHukaInfo;
import yuyu.def.biz.sorter.SortBT_LastSyoriYMDKanri;
import yuyu.def.biz.sorter.SortBT_TuutirirekiMeisaiHokan;
import yuyu.def.biz.sorter.SortBT_WariateHukaInfo;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_LastSyoriymdKanriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.dao.AM_SyoruiZokuseiExDao;
import yuyu.def.db.dao.AM_UserExDao;
import yuyu.def.db.dao.AS_SubSystemExDao;
import yuyu.def.db.dao.AT_AccessLogExDao;
import yuyu.def.db.dao.AT_FileHozonInfoExDao;
import yuyu.def.db.dao.AT_TyouhyouKensakuExDao;
import yuyu.def.db.dao.AT_UserRoleExDao;
import yuyu.def.db.dao.BM_AddressDao;
import yuyu.def.db.dao.BM_PalSyoumetujiyuuDao;
import yuyu.def.db.dao.BM_SeisanDShrymdDao;
import yuyu.def.db.dao.BM_SimekiribiDao;
import yuyu.def.db.dao.BM_SosikiMadogutiDao;
import yuyu.def.db.dao.BM_SyonokanriDao;
import yuyu.def.db.dao.BM_SyoritantoDao;
import yuyu.def.db.dao.BM_TantouCdDao;
import yuyu.def.db.dao.BM_WariateHukaInfoKanriDao;
import yuyu.def.db.dao.BT_GyoumuKouteiInfoDao;
import yuyu.def.db.dao.BT_HengakuEpsilonDenpyoDao;
import yuyu.def.db.dao.BT_KinouHukaInfoDao;
import yuyu.def.db.dao.BT_LastSyoriYMDKanriDao;
import yuyu.def.db.dao.BT_TuutirirekiMeisaiHokanDao;
import yuyu.def.db.dao.BT_WariateHukaInfoDao;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.entity.BM_Simekiribi;
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.def.db.entity.BM_Syonokanri;
import yuyu.def.db.entity.BM_Syoritanto;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.entity.BT_LastSyoriYMDKanri;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.BT_WariateHukaInfo;


/**
 * EtcDomマネージャー<br />
 * Etcにおける、DB操作を提供する。<br />
 */
class EtcDomManager {

    @Inject
    private AM_SyoruiZokuseiExDao syoruiZokuseiExDao;

    @Inject
    private AM_UserExDao userExDao;

    @Inject
    private AS_SubSystemExDao subSystemExDao;

    @Inject
    private AT_AccessLogExDao accessLogExDao;

    @Inject
    private AT_FileHozonInfoExDao fileHozonInfoExDao;

    @Inject
    private AT_TyouhyouKensakuExDao tyouhyouKensakuExDao;

    @Inject
    private AT_UserRoleExDao userRoleExDao;

    @Inject
    private BM_AddressDao addressDao;

    @Inject
    private BM_PalSyoumetujiyuuDao palSyoumetujiyuuDao;

    @Inject
    private BM_SeisanDShrymdDao seisanDShrymdDao;

    @Inject
    private BM_SimekiribiDao simekiribiDao;

    @Inject
    private BM_SosikiMadogutiDao sosikiMadogutiDao;

    @Inject
    private BM_SyonokanriDao syonokanriDao;

    @Inject
    private BM_SyoritantoDao syoritantoDao;

    @Inject
    private BM_TantouCdDao tantouCdDao;

    @Inject
    private BM_WariateHukaInfoKanriDao wariateHukaInfoKanriDao;

    @Inject
    private BT_GyoumuKouteiInfoDao gyoumuKouteiInfoDao;

    @Inject
    private BT_HengakuEpsilonDenpyoDao hengakuEpsilonDenpyoDao;

    @Inject
    private BT_KinouHukaInfoDao kinouHukaInfoDao;

    @Inject
    private BT_LastSyoriYMDKanriDao lastSyoriYMDKanriDao;

    @Inject
    private BT_TuutirirekiMeisaiHokanDao tuutirirekiMeisaiHokanDao;

    @Inject
    private BT_WariateHukaInfoDao wariateHukaInfoDao;

    List<BM_Syonokanri> getAllSyonokanri(){
        SortBM_Syonokanri sortBM_Syonokanri = new SortBM_Syonokanri();
        return sortBM_Syonokanri.OrderBM_SyonokanriByPkAsc(syonokanriDao.selectAll());
    }

    BM_Syonokanri getSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno) {

        return syonokanriDao.getSyonokanri(pSeirekinen2keta, pBosyuusosikicd, pSyonorenno);
    }

    List<BM_Syonokanri> getSyonokanrisBySyono(String pSyono) {

        return syonokanriDao.getSyonokanrisBySyono(pSyono);
    }

    String getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(String pSeirekinen2keta) {

        return syonokanriDao.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(pSeirekinen2keta);
    }

    String getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(String pSeirekinen2keta, BizDate pSaibanymd) {

        return syonokanriDao.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(pSeirekinen2keta, pSaibanymd);
    }

    Integer getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(String pSeirekinen2keta, String pBosyuusosikicd) {

        return syonokanriDao.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(pSeirekinen2keta, pBosyuusosikicd);
    }

    List<BM_SeisanDShrymd> getAllSeisanDShrymd(){
        SortBM_SeisanDShrymd sortBM_SeisanDShrymd = new SortBM_SeisanDShrymd();
        return sortBM_SeisanDShrymd.OrderBM_SeisanDShrymdByPkAsc(seisanDShrymdDao.selectAll());
    }

    BM_SeisanDShrymd getSeisanDShrymd(BizDateY pSyorinendo) {

        return seisanDShrymdDao.getSeisanDShrymd(pSyorinendo);
    }

    List<BM_Simekiribi> getAllSimekiribi(){
        SortBM_Simekiribi sortBM_Simekiribi = new SortBM_Simekiribi();
        return sortBM_Simekiribi.OrderBM_SimekiribiByPkAsc(simekiribiDao.selectAll());
    }

    BM_Simekiribi getSimekiribi(BizDateYM pBosyuuym) {

        return simekiribiDao.getSimekiribi(pBosyuuym);
    }

    List<BT_HengakuEpsilonDenpyo> getAllHengakuEpsilonDenpyo(){
        SortBT_HengakuEpsilonDenpyo sortBT_HengakuEpsilonDenpyo = new SortBT_HengakuEpsilonDenpyo();
        return sortBT_HengakuEpsilonDenpyo.OrderBT_HengakuEpsilonDenpyoByPkAsc(hengakuEpsilonDenpyoDao.selectAll());
    }

    BT_HengakuEpsilonDenpyo getHengakuEpsilonDenpyo(C_HengakuSyuruiKbn pHengakusyuruikbn, C_UnitFundKbn pUnitfundkbn, C_TkbtKanjyouUnitFundKbn pTkbtkanjyouunitfundkbn
        , String pKacd, BizDate pDenymd, C_DenpyouKbn pDenpyoukbn, C_TaisyakuKbn pTaisyakukbn, String pKamokucd
        , BizDate pSyoriYmd) {

        return hengakuEpsilonDenpyoDao.getHengakuEpsilonDenpyo(pHengakusyuruikbn, pUnitfundkbn, pTkbtkanjyouunitfundkbn
            , pKacd, pDenymd, pDenpyoukbn, pTaisyakukbn, pKamokucd
            , pSyoriYmd);
    }

    List<BT_KinouHukaInfo> getAllKinouHukaInfo(){
        SortBT_KinouHukaInfo sortBT_KinouHukaInfo = new SortBT_KinouHukaInfo();
        return sortBT_KinouHukaInfo.OrderBT_KinouHukaInfoByPkAsc(kinouHukaInfoDao.selectAll());
    }

    BT_KinouHukaInfo getKinouHukaInfo(String pKinouId) {

        return kinouHukaInfoDao.getKinouHukaInfo(pKinouId);
    }

    List<BT_WariateHukaInfo> getAllWariateHukaInfo(){
        SortBT_WariateHukaInfo sortBT_WariateHukaInfo = new SortBT_WariateHukaInfo();
        return sortBT_WariateHukaInfo.OrderBT_WariateHukaInfoByPkAsc(wariateHukaInfoDao.selectAll());
    }

    BT_WariateHukaInfo getWariateHukaInfo(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid,  String  pUserId) {

        return wariateHukaInfoDao.getWariateHukaInfo(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukatskid, pUserId);
    }

    List<BT_WariateHukaInfo> getWariateHukaInfosByPKWithoutUserId(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid) {

        return wariateHukaInfoDao.getWariateHukaInfosByPKWithoutUserId(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukatskid);
    }

    List<BT_WariateHukaInfo> getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukakaijyotskid) {

        return wariateHukaInfoDao.getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(pKouteikanriid, pSubSystemId, pJimutetuzukicd, pWrthukakaijyotskid);
    }

    List<BT_LastSyoriYMDKanri> getAllLastSyoriYMDKanri(){
        SortBT_LastSyoriYMDKanri sortBT_LastSyoriYMDKanri = new SortBT_LastSyoriYMDKanri();
        return sortBT_LastSyoriYMDKanri.OrderBT_LastSyoriYMDKanriByPkAsc(lastSyoriYMDKanriDao.selectAll());
    }

    BT_LastSyoriYMDKanri getLastSyoriYMDKanri(C_LastSyoriymdKanriKbn pLastsyoriymdkanrikbn) {

        return lastSyoriYMDKanriDao.getLastSyoriYMDKanri(pLastsyoriymdkanrikbn);
    }

    List<BM_Address> getAllAddress(){
        SortBM_Address sortBM_Address = new SortBM_Address();
        return sortBM_Address.OrderBM_AddressByPkAsc(addressDao.selectAll());
    }

    BM_Address getAddress(String pPostalCd, String pKihontikucdsimo1) {

        return addressDao.getAddress(pPostalCd, pKihontikucdsimo1);
    }

    Long getAddressDistinctPostAdrkjAdrknbkarisCountByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj) {

        return addressDao.getAddressDistinctPostAdrkjAdrknbkarisCountByItems(pPostalCd, pKihontikucdsyoumetukbn, pTodouhukencd, pAdrkn, pAdrkj);
    }

    List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> getAddressDistinctPostAdrkjAdrknbkarisByItems(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn, C_TodouhukenKbn pTodouhukencd, String pAdrkn
        , String pAdrkj) {

        return addressDao.getAddressDistinctPostAdrkjAdrknbkarisByItems(pPostalCd, pKihontikucdsyoumetukbn, pTodouhukencd, pAdrkn, pAdrkj);
    }

    List<String> getAddressDistinctAdrknblankarisByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {

        return addressDao.getAddressDistinctAdrknblankarisByPostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    C_TodouhukenKbn getAddressMinTodouhukencdByPostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {

        return addressDao.getAddressMinTodouhukencdByPostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    List<AddressDistinctItemsBypostalCdBean> getAddressDistinctItemsBypostalCd(String pPostalCd, C_KihontikucdSyoumetuKbn pKihontikucdsyoumetukbn) {

        return addressDao.getAddressDistinctItemsBypostalCd(pPostalCd, pKihontikucdsyoumetukbn);
    }

    List<BT_GyoumuKouteiInfo> getAllGyoumuKouteiInfo(){
        SortBT_GyoumuKouteiInfo sortBT_GyoumuKouteiInfo = new SortBT_GyoumuKouteiInfo();
        return sortBT_GyoumuKouteiInfo.OrderBT_GyoumuKouteiInfoByPkAsc(gyoumuKouteiInfoDao.selectAll());
    }

    BT_GyoumuKouteiInfo getGyoumuKouteiInfo(String pKouteikanriid) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfo(pKouteikanriid);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(pSyukouteikanriid, pSyukouteijimutetuzukicd);
    }

    List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(pSyukouteikanriid, pSyukouteijimutetuzukicd);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySkno(String pSkno) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySkno(pSkno);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByMosno(String pMosno) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosByMosno(pMosno);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(String pJimutetuzukicd, String pSyono, String pSkno) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(pJimutetuzukicd, pSyono, pSkno);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriids(String[] pSyukouteikanriid) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySyukouteikanriids(pSyukouteikanriid);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriid(String pSyukouteikanriid) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySyukouteikanriid(pSyukouteikanriid);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(String pJimutetuzukicd, String pSyukouteikanriid) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(pJimutetuzukicd, pSyukouteikanriid);
    }

    List<AS_Kinou> getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn pTjttrkskahi, String pSubSystemId) {

        return kinouHukaInfoDao.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(pTjttrkskahi, pSubSystemId);
    }

    List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyonoSkno(String pSyono, String pSkno) {

        return gyoumuKouteiInfoDao.getGyoumuKouteiInfosBySyonoSkno(pSyono, pSkno);
    }

    List<BM_PalSyoumetujiyuu> getAllPalSyoumetujiyuu(){
        SortBM_PalSyoumetujiyuu sortBM_PalSyoumetujiyuu = new SortBM_PalSyoumetujiyuu();
        return sortBM_PalSyoumetujiyuu.OrderBM_PalSyoumetujiyuuByPkAsc(palSyoumetujiyuuDao.selectAll());
    }

    BM_PalSyoumetujiyuu getPalSyoumetujiyuu(String pPalsyoumetucd, C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {

        return palSyoumetujiyuuDao.getPalSyoumetujiyuu(pPalsyoumetucd, pBetukutikeiyakukbn);
    }

    List<BM_TantouCd> getAllTantouCd(){
        SortBM_TantouCd sortBM_TantouCd = new SortBM_TantouCd();
        return sortBM_TantouCd.OrderBM_TantouCdByPkAsc(tantouCdDao.selectAll());
    }

    BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd) {

        return tantouCdDao.getTantouCd(pTantocd);
    }

    List<BM_Syoritanto> getAllSyoritanto(){
        SortBM_Syoritanto sortBM_Syoritanto = new SortBM_Syoritanto();
        return sortBM_Syoritanto.OrderBM_SyoritantoByPkAsc(syoritantoDao.selectAll());
    }

    BM_Syoritanto getSyoritanto(String pSyoricd) {

        return syoritantoDao.getSyoritanto(pSyoricd);
    }

    List<BM_SosikiMadoguti> getAllSosikiMadoguti(){
        SortBM_SosikiMadoguti sortBM_SosikiMadoguti = new SortBM_SosikiMadoguti();
        return sortBM_SosikiMadoguti.OrderBM_SosikiMadogutiByPkAsc(sosikiMadogutiDao.selectAll());
    }

    BM_SosikiMadoguti getSosikiMadoguti(String pSskmdsosikicd) {

        return sosikiMadogutiDao.getSosikiMadoguti(pSskmdsosikicd);
    }

    List<BM_WariateHukaInfoKanri> getAllWariateHukaInfoKanri(){
        SortBM_WariateHukaInfoKanri sortBM_WariateHukaInfoKanri = new SortBM_WariateHukaInfoKanri();
        return sortBM_WariateHukaInfoKanri.OrderBM_WariateHukaInfoKanriByPkAsc(wariateHukaInfoKanriDao.selectAll());
    }

    BM_WariateHukaInfoKanri getWariateHukaInfoKanri(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, Integer pRenno) {

        return wariateHukaInfoKanriDao.getWariateHukaInfoKanri(pSubSystemId, pJimutetuzukicd, pCurrenttskid, pRenno);
    }

    List<BM_WariateHukaInfoKanri> getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(String pSubSystemId, String pJimutetuzukicd, String pCurrenttskid, String pNexttskid) {

        return wariateHukaInfoKanriDao.getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(pSubSystemId, pJimutetuzukicd, pCurrenttskid, pNexttskid);
    }

    List<BT_WariateHukaInfo> getWariateHukaInfosBySubSystemIdUserId(String pSubSystemId, String pUserId) {

        return wariateHukaInfoDao.getWariateHukaInfosBySubSystemIdUserId(pSubSystemId, pUserId);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, String pSubSystemId, BizDate pSyoriYmd, Integer pOutCount) {
        return tyouhyouKensakuExDao.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(pSyoruiCd, pSubSystemId, pSyoriYmd, pOutCount);
    }

    List<SyoruiZokuseiTyouhyouInfoBean> getSyoruiZokuseiTyouhyouInfo(String pSubSystemId, BizDate pSyoriYmd, String[] pRoleCd, C_SyoruiCdKbn pSyoruiCd) {

        return syoruiZokuseiExDao.getSyoruiZokuseiTyouhyouInfo(pSubSystemId, pSyoriYmd, pRoleCd, pSyoruiCd);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakusByTyouhyouJoinKey(String pTyouhyouJoinKey) {

        return tyouhyouKensakuExDao.getTyouhyouKensakusByTyouhyouJoinKey(pTyouhyouJoinKey);
    }

    Long getTyouhyouKensakuCountByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto) {
        return tyouhyouKensakuExDao.getTyouhyouKensakuCountByKensakuInfo(pSubSystemId, pSyoruiCd, pKensakuKey1, pKensakuKey2,
            pKensakuKey3, pKensakuKey4, pKensakuKey5, pTyouhyouymdfrom, pTyouhyouymdto);
    }

    List<AT_TyouhyouKensaku> getTyouhyouKensakusByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1, String pKensakuKey2, String pKensakuKey3
        , String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto) {
        return tyouhyouKensakuExDao.getTyouhyouKensakusByKensakuInfo(pSubSystemId, pSyoruiCd, pKensakuKey1, pKensakuKey2,
            pKensakuKey3, pKensakuKey4, pKensakuKey5, pTyouhyouymdfrom, pTyouhyouymdto);
    }

    List<UsersByKinouIdKinouModeIdUserIdBean> getUsersByKinouIdKinouModeIdUserId(String pKinouId, String pKinouModeId, String pUserId) {

        return userExDao.getUsersByKinouIdKinouModeIdUserId(pKinouId, pKinouModeId, pUserId);
    }

    List<UsersByKinouIdKinouModeIdUserIdFlowIdNodeIdBean> getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(String pKinouId, String pKinouModeId, String pUserId, String pFlowId, String pNodeId) {

        return userExDao.getUsersByKinouIdKinouModeIdUserIdFlowIdNodeId(pKinouId, pKinouModeId, pUserId, pFlowId, pNodeId);
    }

    ExDBUpdatableResults<AM_User> getUsersByTables() {

        return userExDao.getUsersByTables();
    }

    ExDBResults<AT_AccessLog> getAccessLogsByTimeStamp(Long pSyoriYmdFrom, Long pSyoriYmdTo) {

        return accessLogExDao.getAccessLogsByTimeStamp(pSyoriYmdFrom,pSyoriYmdTo);
    }

    ExDBResults<AT_AccessLog> getAccessLogsBySyoriYmdFromSyoriYmdTo(Long pSyoriYmdFrom, Long pSyoriYmdTo) {

        return accessLogExDao.getAccessLogsBySyoriYmdFromSyoriYmdTo(pSyoriYmdFrom, pSyoriYmdTo);
    }

    List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {

        return fileHozonInfoExDao.getFileHozonInfosByFileSyuruiCd(pFileSyuruiCd);
    }

    List<BM_Address> getAddressesByPostalCd(String pPostalCd) {

        return addressDao.getAddressesByPostalCd(pPostalCd);
    }

    List<AS_SubSystem> getSubSystemsBySubSystemIds(String[] pSubSystemId) {

        return subSystemExDao.getSubSystemsBySubSystemIds(pSubSystemId);
    }

    List<BT_TuutirirekiMeisaiHokan> getAllTuutirirekiMeisaiHokan(){
        SortBT_TuutirirekiMeisaiHokan sortBT_TuutirirekiMeisaiHokan = new SortBT_TuutirirekiMeisaiHokan();
        return sortBT_TuutirirekiMeisaiHokan.OrderBT_TuutirirekiMeisaiHokanByPkAsc(tuutirirekiMeisaiHokanDao.selectAll());
    }

    BT_TuutirirekiMeisaiHokan getTuutirirekiMeisaiHokan(String pTuutirirekirenno) {

        return tuutirirekiMeisaiHokanDao.getTuutirirekiMeisaiHokan(pTuutirirekirenno);
    }

    ExDBUpdatableResults<BT_TuutirirekiMeisaiHokan> getTuutirirekiMeisaiHokansByTuutisakuseiymd2(BizDateYM pTuutisakuseiym) {
        return tuutirirekiMeisaiHokanDao.getTuutirirekiMeisaiHokansByTuutisakuseiymd2(pTuutisakuseiym);
    }

}
