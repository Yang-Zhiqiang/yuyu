package yuyu.def.hozen.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.dao.IT_AnsyuyouErrJyouhouDao;
import yuyu.def.db.dao.IT_AsBikinkanriDao;
import yuyu.def.db.dao.IT_AzukarikinKessankanriDao;
import yuyu.def.db.dao.IT_BAK_KhDenpyoDataDao;
import yuyu.def.db.dao.IT_BAK_KhFBSoukinDataDao;
import yuyu.def.db.dao.IT_BAK_KhGaikaFBSoukinDataDao;
import yuyu.def.db.dao.IT_BAK_KhSntkInfoTourokuDao;
import yuyu.def.db.dao.IT_BAK_NyuukinKakusyouDataDao;
import yuyu.def.db.dao.IT_CardTourokuMatiDao;
import yuyu.def.db.dao.IT_DrtenMinyuKykNaiyouDao;
import yuyu.def.db.dao.IT_DrtenMinyuKykTaisyoDao;
import yuyu.def.db.dao.IT_HengakuCfDenpyoDao;
import yuyu.def.db.dao.IT_HrhnCreditCardTourokuDao;
import yuyu.def.db.dao.IT_ItekiToukeiInfoDao;
import yuyu.def.db.dao.IT_KessanYokukiPDao;
import yuyu.def.db.dao.IT_KessanZennouDao;
import yuyu.def.db.dao.IT_KhBikinkanriDao;
import yuyu.def.db.dao.IT_KhDenpyoDataDao;
import yuyu.def.db.dao.IT_KhFBSoukinDataDao;
import yuyu.def.db.dao.IT_KhGaikaFBSoukinDataDao;
import yuyu.def.db.dao.IT_KhGinkouMdhnMisyuuInfoDao;
import yuyu.def.db.dao.IT_KhKesikomiDataDao;
import yuyu.def.db.dao.IT_KhSntkInfoTourokuDao;
import yuyu.def.db.dao.IT_KhTyouhyouHonbanKakuninDao;
import yuyu.def.db.dao.IT_KyuukzAnnaimatiDao;
import yuyu.def.db.dao.IT_NyuukinKakusyouDataDao;
import yuyu.def.db.dao.IT_SeihowebMizuhoMinyuuDtlDao;
import yuyu.def.db.dao.IT_SyuunouKanriDao;
import yuyu.def.db.dao.IT_ZennouHoyuuIdouKykDtlDao;
import yuyu.def.db.dao.IT_ZennouKessanDao;
import yuyu.def.db.dao.IW_TmttkinYskWkDao;
import yuyu.def.db.entity.IT_AnsyuyouErrJyouhou;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_CardTourokuMati;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;
import yuyu.def.db.entity.IT_HengakuCfDenpyo;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KessanYokukiP;
import yuyu.def.db.entity.IT_KessanZennou;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.entity.IT_SyuunouKanri;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.entity.IT_ZennouKessan;
import yuyu.def.db.entity.IW_TmttkinYskWk;
import yuyu.def.hozen.predicate.FilterKhBikinkanriBySyonoHenkousikibetukey;
import yuyu.def.hozen.sorter.SortIT_AnsyuyouErrJyouhou;
import yuyu.def.hozen.sorter.SortIT_AsBikinkanri;
import yuyu.def.hozen.sorter.SortIT_AzukarikinKessankanri;
import yuyu.def.hozen.sorter.SortIT_BAK_KhDenpyoData;
import yuyu.def.hozen.sorter.SortIT_BAK_KhFBSoukinData;
import yuyu.def.hozen.sorter.SortIT_BAK_KhGaikaFBSoukinData;
import yuyu.def.hozen.sorter.SortIT_BAK_KhSntkInfoTouroku;
import yuyu.def.hozen.sorter.SortIT_BAK_NyuukinKakusyouData;
import yuyu.def.hozen.sorter.SortIT_CardTourokuMati;
import yuyu.def.hozen.sorter.SortIT_DrtenMinyuKykNaiyou;
import yuyu.def.hozen.sorter.SortIT_DrtenMinyuKykTaisyo;
import yuyu.def.hozen.sorter.SortIT_HengakuCfDenpyo;
import yuyu.def.hozen.sorter.SortIT_HrhnCreditCardTouroku;
import yuyu.def.hozen.sorter.SortIT_ItekiToukeiInfo;
import yuyu.def.hozen.sorter.SortIT_KessanYokukiP;
import yuyu.def.hozen.sorter.SortIT_KessanZennou;
import yuyu.def.hozen.sorter.SortIT_KhBikinkanri;
import yuyu.def.hozen.sorter.SortIT_KhDenpyoData;
import yuyu.def.hozen.sorter.SortIT_KhFBSoukinData;
import yuyu.def.hozen.sorter.SortIT_KhGaikaFBSoukinData;
import yuyu.def.hozen.sorter.SortIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.hozen.sorter.SortIT_KhKesikomiData;
import yuyu.def.hozen.sorter.SortIT_KhSntkInfoTouroku;
import yuyu.def.hozen.sorter.SortIT_KhTyouhyouHonbanKakunin;
import yuyu.def.hozen.sorter.SortIT_KyuukzAnnaimati;
import yuyu.def.hozen.sorter.SortIT_NyuukinKakusyouData;
import yuyu.def.hozen.sorter.SortIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.hozen.sorter.SortIT_SyuunouKanri;
import yuyu.def.hozen.sorter.SortIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.hozen.sorter.SortIT_ZennouKessan;
import yuyu.def.hozen.sorter.SortIW_TmttkinYskWk;

import com.google.common.collect.Collections2;

/**
 * EtcDomマネージャー<br />
 * Etcにおける、DB操作を提供する。<br />
 */
class EtcDomManager {

    @Inject
    private IT_AnsyuyouErrJyouhouDao ansyuyouErrJyouhouDao;

    @Inject
    private IT_AsBikinkanriDao asBikinkanriDao;

    @Inject
    private IT_AzukarikinKessankanriDao azukarikinKessankanriDao;

    @Inject
    private IT_BAK_KhDenpyoDataDao bAK_KhDenpyoDataDao;

    @Inject
    private IT_BAK_KhFBSoukinDataDao bAK_KhFBSoukinDataDao;

    @Inject
    private IT_BAK_KhGaikaFBSoukinDataDao bAK_KhGaikaFBSoukinDataDao;

    @Inject
    private IT_BAK_KhSntkInfoTourokuDao bAK_KhSntkInfoTourokuDao;

    @Inject
    private IT_BAK_NyuukinKakusyouDataDao bAK_NyuukinKakusyouDataDao;

    @Inject
    private IT_CardTourokuMatiDao cardTourokuMatiDao;

    @Inject
    private IT_DrtenMinyuKykNaiyouDao drtenMinyuKykNaiyouDao;

    @Inject
    private IT_DrtenMinyuKykTaisyoDao drtenMinyuKykTaisyoDao;

    @Inject
    private IT_HengakuCfDenpyoDao hengakuCfDenpyoDao;

    @Inject
    private IT_HrhnCreditCardTourokuDao hrhnCreditCardTourokuDao;

    @Inject
    private IT_ItekiToukeiInfoDao itekiToukeiInfoDao;

    @Inject
    private IT_KessanYokukiPDao kessanYokukiPDao;

    @Inject
    private IT_KessanZennouDao kessanZennouDao;

    @Inject
    private IT_KhBikinkanriDao khBikinkanriDao;

    @Inject
    private IT_KhDenpyoDataDao khDenpyoDataDao;

    @Inject
    private IT_KhFBSoukinDataDao khFBSoukinDataDao;

    @Inject
    private IT_KhGaikaFBSoukinDataDao khGaikaFBSoukinDataDao;

    @Inject
    private IT_KhGinkouMdhnMisyuuInfoDao khGinkouMdhnMisyuuInfoDao;

    @Inject
    private IT_KhKesikomiDataDao khKesikomiDataDao;

    @Inject
    private IT_KhSntkInfoTourokuDao khSntkInfoTourokuDao;

    @Inject
    private IT_KhTyouhyouHonbanKakuninDao khTyouhyouHonbanKakuninDao;

    @Inject
    private IT_KyuukzAnnaimatiDao kyuukzAnnaimatiDao;

    @Inject
    private IT_NyuukinKakusyouDataDao nyuukinKakusyouDataDao;

    @Inject
    private IT_SeihowebMizuhoMinyuuDtlDao seihowebMizuhoMinyuuDtlDao;

    @Inject
    private IT_SyuunouKanriDao syuunouKanriDao;

    @Inject
    private IW_TmttkinYskWkDao tmttkinYskWkDao;

    @Inject
    private IT_ZennouHoyuuIdouKykDtlDao zennouHoyuuIdouKykDtlDao;

    @Inject
    private IT_ZennouKessanDao zennouKessanDao;

    List<IT_KhDenpyoData> getAllKhDenpyoData(){
        SortIT_KhDenpyoData sortIT_KhDenpyoData = new SortIT_KhDenpyoData();
        return sortIT_KhDenpyoData.OrderIT_KhDenpyoDataByPkAsc(khDenpyoDataDao.selectAll());
    }

    IT_KhDenpyoData getKhDenpyoData(String pDenrenno, Integer pEdano) {

        return khDenpyoDataDao.getKhDenpyoData(pDenrenno, pEdano);
    }

    List<IT_KhDenpyoData> getKhDenpyoDatasBySyono(String pSyono) {

        return khDenpyoDataDao.getKhDenpyoDatasBySyono(pSyono);
    }

    ExDBUpdatableResults<IT_KhDenpyoData> getKhDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriymd) {

        ExDBUpdatableResults<IT_KhDenpyoData> exDBResults = khDenpyoDataDao.getKhDenpyoDatasByKakutyoujobcdSyoriYmd(pSyoriymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_KhFBSoukinData> getAllKhFBSoukinData(){
        SortIT_KhFBSoukinData sortIT_KhFBSoukinData = new SortIT_KhFBSoukinData();
        return sortIT_KhFBSoukinData.OrderIT_KhFBSoukinDataByPkAsc(khFBSoukinDataDao.selectAll());
    }

    ExDBResults<IT_KhFBSoukinData> getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {

        ExDBResults<IT_KhFBSoukinData> exDBResults = khFBSoukinDataDao.getKhFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    IT_KhFBSoukinData getKhFBSoukinData(String pFbsoukindatasikibetukey) {

        return khFBSoukinDataDao.getKhFBSoukinData(pFbsoukindatasikibetukey);
    }

    List<IT_KhFBSoukinData> getKhFBSoukinDatasBySyono(String pSyono) {

        return khFBSoukinDataDao.getKhFBSoukinDatasBySyono(pSyono);
    }

    List<IT_SyuunouKanri> getAllSyuunouKanri(){
        SortIT_SyuunouKanri sortIT_SyuunouKanri = new SortIT_SyuunouKanri();
        return sortIT_SyuunouKanri.OrderIT_SyuunouKanriByPkAsc(syuunouKanriDao.selectAll());
    }

    IT_SyuunouKanri getSyuunouKanri(C_Syuudaikocd pSyuudaikocd, BizDate pHurikaeymd) {

        return syuunouKanriDao.getSyuunouKanri(pSyuudaikocd, pHurikaeymd);
    }

    List<IT_KhGaikaFBSoukinData> getAllKhGaikaFBSoukinData(){
        SortIT_KhGaikaFBSoukinData sortIT_KhGaikaFBSoukinData = new SortIT_KhGaikaFBSoukinData();
        return sortIT_KhGaikaFBSoukinData.OrderIT_KhGaikaFBSoukinDataByPkAsc(khGaikaFBSoukinDataDao.selectAll());
    }

    IT_KhGaikaFBSoukinData getKhGaikaFBSoukinData(String pFbsoukindatasikibetukey) {

        return khGaikaFBSoukinDataDao.getKhGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }

    List<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasBySyono(String pSyono) {

        return khGaikaFBSoukinDataDao.getKhGaikaFBSoukinDatasBySyono(pSyono);
    }

    ExDBResults<IT_KhGaikaFBSoukinData> getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {

        ExDBResults<IT_KhGaikaFBSoukinData> exDBResults = khGaikaFBSoukinDataDao.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pSyoriYmd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_KhSntkInfoTouroku> getAllKhSntkInfoTouroku(){
        SortIT_KhSntkInfoTouroku sortIT_KhSntkInfoTouroku = new SortIT_KhSntkInfoTouroku();
        return sortIT_KhSntkInfoTouroku.OrderIT_KhSntkInfoTourokuByPkAsc(khSntkInfoTourokuDao.selectAll());
    }

    IT_KhSntkInfoTouroku getKhSntkInfoTouroku(String pSyono, Integer pRenno) {

        return khSntkInfoTourokuDao.getKhSntkInfoTouroku(pSyono, pRenno);
    }

    List<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusBySyono(String pSyono) {

        return khSntkInfoTourokuDao.getKhSntkInfoTourokusBySyono(pSyono);
    }

    Integer getKhSntkInfoTourokuMaxRennoBySyono(String pSyono) {

        return khSntkInfoTourokuDao.getKhSntkInfoTourokuMaxRennoBySyono(pSyono);
    }

    ExDBUpdatableResults<IT_KhSntkInfoTouroku> getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg  pSyorizumiflg) {

        ExDBUpdatableResults<IT_KhSntkInfoTouroku> exDBResults = khSntkInfoTourokuDao.getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(pSyorizumiflg);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_BAK_KhDenpyoData> getAllBAKKhDenpyoData(){
        SortIT_BAK_KhDenpyoData sortIT_BAK_KhDenpyoData = new SortIT_BAK_KhDenpyoData();
        return sortIT_BAK_KhDenpyoData.OrderIT_BAK_KhDenpyoDataByPkAsc(bAK_KhDenpyoDataDao.selectAll());
    }

    IT_BAK_KhDenpyoData getBAKKhDenpyoData(String pDenrenno, String pTrkssikibetukey, Integer pEdano) {

        return bAK_KhDenpyoDataDao.getBAKKhDenpyoData(pDenrenno, pTrkssikibetukey, pEdano);
    }

    List<IT_BAK_KhDenpyoData> getBAKKhDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhDenpyoDataDao.getBAKKhDenpyoDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhFBSoukinData> getAllBAKKhFBSoukinData(){
        SortIT_BAK_KhFBSoukinData sortIT_BAK_KhFBSoukinData = new SortIT_BAK_KhFBSoukinData();
        return sortIT_BAK_KhFBSoukinData.OrderIT_BAK_KhFBSoukinDataByPkAsc(bAK_KhFBSoukinDataDao.selectAll());
    }

    IT_BAK_KhFBSoukinData getBAKKhFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {

        return bAK_KhFBSoukinDataDao.getBAKKhFBSoukinData(pFbsoukindatasikibetukey, pTrkssikibetukey);
    }

    List<IT_BAK_KhFBSoukinData> getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhFBSoukinDataDao.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhGaikaFBSoukinData> getAllBAKKhGaikaFBSoukinData(){
        SortIT_BAK_KhGaikaFBSoukinData sortIT_BAK_KhGaikaFBSoukinData = new SortIT_BAK_KhGaikaFBSoukinData();
        return sortIT_BAK_KhGaikaFBSoukinData.OrderIT_BAK_KhGaikaFBSoukinDataByPkAsc(bAK_KhGaikaFBSoukinDataDao.selectAll());
    }

    IT_BAK_KhGaikaFBSoukinData getBAKKhGaikaFBSoukinData(String pFbsoukindatasikibetukey, String pTrkssikibetukey) {

        return bAK_KhGaikaFBSoukinDataDao.getBAKKhGaikaFBSoukinData(pFbsoukindatasikibetukey, pTrkssikibetukey);
    }

    List<IT_BAK_KhGaikaFBSoukinData> getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhGaikaFBSoukinDataDao.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhSntkInfoTouroku> getAllBAKKhSntkInfoTouroku(){
        SortIT_BAK_KhSntkInfoTouroku sortIT_BAK_KhSntkInfoTouroku = new SortIT_BAK_KhSntkInfoTouroku();
        return sortIT_BAK_KhSntkInfoTouroku.OrderIT_BAK_KhSntkInfoTourokuByPkAsc(bAK_KhSntkInfoTourokuDao.selectAll());
    }

    IT_BAK_KhSntkInfoTouroku getBAKKhSntkInfoTouroku(String pSyono, String pTrkssikibetukey, Integer pRenno) {

        return bAK_KhSntkInfoTourokuDao.getBAKKhSntkInfoTouroku(pSyono, pTrkssikibetukey, pRenno);
    }

    List<IT_HengakuCfDenpyo> getAllHengakuCfDenpyo(){
        SortIT_HengakuCfDenpyo sortIT_HengakuCfDenpyo = new SortIT_HengakuCfDenpyo();
        return sortIT_HengakuCfDenpyo.OrderIT_HengakuCfDenpyoByPkAsc(hengakuCfDenpyoDao.selectAll());
    }

    IT_HengakuCfDenpyo getHengakuCfDenpyo(String pDenrenno, Integer pEdano) {

        return hengakuCfDenpyoDao.getHengakuCfDenpyo(pDenrenno, pEdano);
    }

    List<IT_KhBikinkanri> getAllKhBikinkanri(){
        SortIT_KhBikinkanri sortIT_KhBikinkanri = new SortIT_KhBikinkanri();
        return sortIT_KhBikinkanri.OrderIT_KhBikinkanriByPkAsc(khBikinkanriDao.selectAll());
    }

    IT_KhBikinkanri getKhBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno) {

        return khBikinkanriDao.getKhBikinkanri(pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pRenno);
    }

    List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono) {

        return khBikinkanriDao.getKhBikinkanrisBySyono(pSyono);
    }

    List<IT_KhBikinkanri> getKhBikinkanrisBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        return  new ArrayList<IT_KhBikinkanri>(Collections2.filter(getAllKhBikinkanri(),
            new FilterKhBikinkanriBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey)));
    }

    List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {

        return khBikinkanriDao.getKhBikinkanrisByKessankijyunymdBknrigikbn(pKessankijyunymd, pBknrigikbn);
    }

    List<IT_KhBikinkanri> getKhBikinkanrisByPKWithoutRenno(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd) {

        return khBikinkanriDao.getKhBikinkanrisByPKWithoutRenno(pSyono,pKessankijyunymd,pBkncdkbn,pBknkktymd);
    }

    ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {

        ExDBResults<IT_KhBikinkanri> exDBResults = khBikinkanriDao.getKhBikinkanrisByKakutyoujobcdKessankijyunymd(pKessankijyunymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(String pKakutyoujobcd, BizDate pKessankijyunymd) {

        ExDBResults<IT_KhBikinkanri> exDBResults = khBikinkanriDao.getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(pKessankijyunymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    List<IT_ItekiToukeiInfo> getAllItekiToukeiInfo(){
        SortIT_ItekiToukeiInfo sortIT_ItekiToukeiInfo = new SortIT_ItekiToukeiInfo();
        return sortIT_ItekiToukeiInfo.OrderIT_ItekiToukeiInfoByPkAsc(itekiToukeiInfoDao.selectAll());
    }

    IT_ItekiToukeiInfo getItekiToukeiInfo(String pSyono) {

        return itekiToukeiInfoDao.getItekiToukeiInfo(pSyono);
    }


    List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(BizDate pKessankijyunymd, C_BkncdKbn[] pBkncdkbn) {

        return khBikinkanriDao.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(pKessankijyunymd, pBkncdkbn);

    }

    IT_KhTyouhyouHonbanKakunin getKhTyouhyouHonbanKakunin(C_TyouhyouBunruiKbn pTyouhyoubunrui, C_SyoruiCdKbn pSyoruiCd, String pJyoukenbunrui1, String pJyoukenbunrui2, String pJyoukenbunrui3) {

        return khTyouhyouHonbanKakuninDao.getKhTyouhyouHonbanKakunin(pTyouhyoubunrui, pSyoruiCd, pJyoukenbunrui1, pJyoukenbunrui2, pJyoukenbunrui3);
    }

    List<IT_KhTyouhyouHonbanKakunin> getAllKhTyouhyouHonbanKakunin(){
        SortIT_KhTyouhyouHonbanKakunin sortIT_KhTyouhyouHonbanKakunin = new SortIT_KhTyouhyouHonbanKakunin();
        return sortIT_KhTyouhyouHonbanKakunin.OrderIT_KhTyouhyouHonbanKakuninByPkAsc(khTyouhyouHonbanKakuninDao.selectAll());
    }

    List<IT_NyuukinKakusyouData> getNyuukinKakusyouDataBySyono(String pSyono) {

        return nyuukinKakusyouDataDao.getNyuukinKakusyouDataBySyono(pSyono);
    }

    List<IT_BAK_NyuukinKakusyouData> getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_NyuukinKakusyouDataDao.getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_AnsyuyouErrJyouhou> getAllAnsyuyouErrJyouhou(){
        SortIT_AnsyuyouErrJyouhou sortIT_AnsyuyouErrJyouhou = new SortIT_AnsyuyouErrJyouhou();
        return sortIT_AnsyuyouErrJyouhou.OrderIT_AnsyuyouErrJyouhouByPkAsc(ansyuyouErrJyouhouDao.selectAll());
    }

    IT_AnsyuyouErrJyouhou getAnsyuyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pAnsyuyouerrnaiyou) {

        return ansyuyouErrJyouhouDao.getAnsyuyouErrJyouhou(pSyoriYmd, pKakutyoujobcd, pSyono, pGyoumuKousinTime, pAnsyuyouerrnaiyou);
    }

    List<IT_NyuukinKakusyouData> getAllNyuukinKakusyouData(){
        SortIT_NyuukinKakusyouData sortIT_NyuukinKakusyouData = new SortIT_NyuukinKakusyouData();
        return sortIT_NyuukinKakusyouData.OrderIT_NyuukinKakusyouDataByPkAsc(nyuukinKakusyouDataDao.selectAll());
    }

    IT_NyuukinKakusyouData getNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono) {

        return nyuukinKakusyouDataDao.getNyuukinKakusyouData(pNyuukinkakusyouno, pSyono);
    }

    List<IT_BAK_NyuukinKakusyouData> getAllBAKNyuukinKakusyouData(){
        SortIT_BAK_NyuukinKakusyouData sortIT_BAK_NyuukinKakusyouData = new SortIT_BAK_NyuukinKakusyouData();
        return sortIT_BAK_NyuukinKakusyouData.OrderIT_BAK_NyuukinKakusyouDataByPkAsc(bAK_NyuukinKakusyouDataDao.selectAll());
    }

    IT_BAK_NyuukinKakusyouData getBAKNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono, String pTrkssikibetukey) {

        return bAK_NyuukinKakusyouDataDao.getBAKNyuukinKakusyouData(pNyuukinkakusyouno, pSyono, pTrkssikibetukey);
    }

    List<IT_KessanYokukiP> getAllKessanYokukiP(){
        SortIT_KessanYokukiP sortIT_KessanYokukiP = new SortIT_KessanYokukiP();
        return sortIT_KessanYokukiP.OrderIT_KessanYokukiPByPkAsc(kessanYokukiPDao.selectAll());
    }

    IT_KessanYokukiP getKessanYokukiP(BizDateYM pKeijyouym, String pSyono) {

        return kessanYokukiPDao.getKessanYokukiP(pKeijyouym, pSyono);
    }

    List<IT_KessanZennou> getAllKessanZennou(){
        SortIT_KessanZennou sortIT_KessanZennou = new SortIT_KessanZennou();
        return sortIT_KessanZennou.OrderIT_KessanZennouByPkAsc(kessanZennouDao.selectAll());
    }

    IT_KessanZennou getKessanZennou(String pSyono, C_Segcd pKbnkeirisegcd, String pZennoutoukeilistkbn, String pZennoukbn, BizDateYM pZennoustartym) {

        return kessanZennouDao.getKessanZennou(pSyono, pKbnkeirisegcd, pZennoutoukeilistkbn, pZennoukbn, pZennoustartym);
    }

    List<IT_KhGinkouMdhnMisyuuInfo> getAllKhGinkouMdhnMisyuuInfo(){
        SortIT_KhGinkouMdhnMisyuuInfo sortIT_KhGinkouMdhnMisyuuInfo = new SortIT_KhGinkouMdhnMisyuuInfo();
        return sortIT_KhGinkouMdhnMisyuuInfo.OrderIT_KhGinkouMdhnMisyuuInfoByPkAsc(khGinkouMdhnMisyuuInfoDao.selectAll());
    }

    IT_KhGinkouMdhnMisyuuInfo getKhGinkouMdhnMisyuuInfo(BizDate pDatarenymd, String pSyono, String pHenkousikibetukey) {

        return khGinkouMdhnMisyuuInfoDao.getKhGinkouMdhnMisyuuInfo(pDatarenymd, pSyono, pHenkousikibetukey);
    }

    List<IT_KhKesikomiData> getAllKhKesikomiData(){
        SortIT_KhKesikomiData sortIT_KhKesikomiData = new SortIT_KhKesikomiData();
        return sortIT_KhKesikomiData.OrderIT_KhKesikomiDataByPkAsc(khKesikomiDataDao.selectAll());
    }

    IT_KhKesikomiData getKhKesikomiData(String pNyuukinkakusyouno, String pSyono) {

        return khKesikomiDataDao.getKhKesikomiData(pNyuukinkakusyouno, pSyono);
    }

    List<IT_KyuukzAnnaimati> getAllKyuukzAnnaimati(){
        SortIT_KyuukzAnnaimati sortIT_KyuukzAnnaimati = new SortIT_KyuukzAnnaimati();
        return sortIT_KyuukzAnnaimati.OrderIT_KyuukzAnnaimatiByPkAsc(kyuukzAnnaimatiDao.selectAll());
    }

    IT_KyuukzAnnaimati getKyuukzAnnaimati(String pKouteikanriid) {

        return kyuukzAnnaimatiDao.getKyuukzAnnaimati(pKouteikanriid);
    }

    List<IT_DrtenMinyuKykTaisyo> getAllDrtenMinyuKykTaisyo(){
        SortIT_DrtenMinyuKykTaisyo sortIT_DrtenMinyuKykTaisyo = new SortIT_DrtenMinyuKykTaisyo();
        return sortIT_DrtenMinyuKykTaisyo.OrderIT_DrtenMinyuKykTaisyoByPkAsc(drtenMinyuKykTaisyoDao.selectAll());
    }

    IT_DrtenMinyuKykTaisyo getDrtenMinyuKykTaisyo(String pSyono, BizDate pSyoriYmd, String pMinyuutrrenno) {

        return drtenMinyuKykTaisyoDao.getDrtenMinyuKykTaisyo(pSyono, pSyoriYmd, pMinyuutrrenno);
    }

    List<IT_DrtenMinyuKykNaiyou> getAllDrtenMinyuKykNaiyou(){
        SortIT_DrtenMinyuKykNaiyou sortIT_DrtenMinyuKykNaiyou = new SortIT_DrtenMinyuKykNaiyou();
        return sortIT_DrtenMinyuKykNaiyou.OrderIT_DrtenMinyuKykNaiyouByPkAsc(drtenMinyuKykNaiyouDao.selectAll());
    }

    IT_DrtenMinyuKykNaiyou getDrtenMinyuKykNaiyou(String pSyono, BizDateYM pSyoriym) {

        return drtenMinyuKykNaiyouDao.getDrtenMinyuKykNaiyou(pSyono, pSyoriym);
    }

    List<IT_SeihowebMizuhoMinyuuDtl> getAllSeihowebMizuhoMinyuuDtl(){
        SortIT_SeihowebMizuhoMinyuuDtl sortIT_SeihowebMizuhoMinyuuDtl = new SortIT_SeihowebMizuhoMinyuuDtl();
        return sortIT_SeihowebMizuhoMinyuuDtl.OrderIT_SeihowebMizuhoMinyuuDtlByPkAsc(seihowebMizuhoMinyuuDtlDao.selectAll());
    }

    IT_SeihowebMizuhoMinyuuDtl getSeihowebMizuhoMinyuuDtl(String pSyono, String pDrtencd, String pBosyuucd, BizDateYM pSyoriym) {

        return seihowebMizuhoMinyuuDtlDao.getSeihowebMizuhoMinyuuDtl(pSyono, pDrtencd, pBosyuucd, pSyoriym);
    }

    List<IT_ZennouKessan> getAllZennouKessan(){
        SortIT_ZennouKessan sortIT_ZennouKessan = new SortIT_ZennouKessan();
        return sortIT_ZennouKessan.OrderIT_ZennouKessanByPkAsc(zennouKessanDao.selectAll());
    }

    IT_ZennouKessan getZennouKessan(String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn
        , BizDateYM pZennoustartym) {

        return zennouKessanDao.getZennouKessan(pSyono, pSakuseiymd, pKbnkeirisegcd, pZennoukbn, pZennoutoukeilistkbn
            , pZennoustartym);
    }

    List<IT_ZennouHoyuuIdouKykDtl> getAllZennouHoyuuIdouKykDtl(){
        SortIT_ZennouHoyuuIdouKykDtl sortIT_ZennouHoyuuIdouKykDtl = new SortIT_ZennouHoyuuIdouKykDtl();
        return sortIT_ZennouHoyuuIdouKykDtl.OrderIT_ZennouHoyuuIdouKykDtlByPkAsc(zennouHoyuuIdouKykDtlDao.selectAll());
    }

    IT_ZennouHoyuuIdouKykDtl getZennouHoyuuIdouKykDtl(String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr) {

        return zennouHoyuuIdouKykDtlDao.getZennouHoyuuIdouKykDtl(pSyono, pSakuseiymd, pSyoricd, pKykmfksnctr);
    }

    List<IT_AzukarikinKessankanri> getAllAzukarikinKessankanri(){
        SortIT_AzukarikinKessankanri sortIT_AzukarikinKessankanri = new SortIT_AzukarikinKessankanri();
        return sortIT_AzukarikinKessankanri.OrderIT_AzukarikinKessankanriByPkAsc(azukarikinKessankanriDao.selectAll());
    }

    IT_AzukarikinKessankanri getAzukarikinKessankanri(String pSyono, BizDate pKessankijyunymd, String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {

        return azukarikinKessankanriDao.getAzukarikinKessankanri(pSyono, pKessankijyunymd, pHenkousikibetukey, pTuukasyu);
    }

    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {

        ExDBResults<IT_AzukarikinKessankanri> exDBResults = azukarikinKessankanriDao.getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(pKessankijyunymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(String pKakutyoujobcd, BizDate pKessankijyunymd) {

        ExDBResults<IT_AzukarikinKessankanri> exDBResults = azukarikinKessankanriDao.getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(pKessankijyunymd);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public List<String> getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate pKessankijyunymd) {

        return azukarikinKessankanriDao.getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(pKessankijyunymd);
    }

    List<IT_AsBikinkanri> getAllAsBikinkanri(){
        SortIT_AsBikinkanri sortIT_AsBikinkanri = new SortIT_AsBikinkanri();
        return sortIT_AsBikinkanri.OrderIT_AsBikinkanriByPkAsc(asBikinkanriDao.selectAll());
    }

    IT_AsBikinkanri getAsBikinkanri(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, Integer pRenno) {

        return asBikinkanriDao.getAsBikinkanri(pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pRenno);
    }

    List<IT_HrhnCreditCardTouroku> getAllHrhnCreditCardTouroku(){
        SortIT_HrhnCreditCardTouroku sortIT_HrhnCreditCardTouroku = new SortIT_HrhnCreditCardTouroku();
        return sortIT_HrhnCreditCardTouroku.OrderIT_HrhnCreditCardTourokuByPkAsc(hrhnCreditCardTourokuDao.selectAll());
    }

    IT_HrhnCreditCardTouroku getHrhnCreditCardTouroku(String pCreditkessaiyouno) {

        return hrhnCreditCardTourokuDao.getHrhnCreditCardTouroku(pCreditkessaiyouno);
    }

    List<IT_CardTourokuMati> getAllCardTourokuMati(){
        SortIT_CardTourokuMati sortIT_CardTourokuMati = new SortIT_CardTourokuMati();
        return sortIT_CardTourokuMati.OrderIT_CardTourokuMatiByPkAsc(cardTourokuMatiDao.selectAll());
    }

    IT_CardTourokuMati getCardTourokuMati(String pKouteikanriid) {

        return cardTourokuMatiDao.getCardTourokuMati(pKouteikanriid);
    }

    List<IW_TmttkinYskWk> getAllTmttkinYskWk(){
        SortIW_TmttkinYskWk sortIW_TmttkinYskWk = new SortIW_TmttkinYskWk();
        return sortIW_TmttkinYskWk.OrderIW_TmttkinYskWkByPkAsc(tmttkinYskWkDao.selectAll());
    }

    IW_TmttkinYskWk getTmttkinYskWk(String pSyono) {

        return tmttkinYskWkDao.getTmttkinYskWk(pSyono);
    }

}
