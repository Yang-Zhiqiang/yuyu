package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.dao.HT_BAK_SmbcStyKanriDao;
import yuyu.def.db.dao.HT_SisyaToukeiHokanDao;
import yuyu.def.db.dao.HT_SkLincJyusinDataDao;
import yuyu.def.db.dao.HT_SkLincSousinDataDao;
import yuyu.def.db.dao.HT_SmbcStyKanriDao;
import yuyu.def.db.dao.HT_SmbcStyKanriSsRirekiDao;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.sinkeiyaku.sorter.SortHT_BAK_SmbcStyKanri;
import yuyu.def.sinkeiyaku.sorter.SortHT_SisyaToukeiHokan;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkLincJyusinData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkLincSousinData;
import yuyu.def.sinkeiyaku.sorter.SortHT_SmbcStyKanri;
import yuyu.def.sinkeiyaku.sorter.SortHT_SmbcStyKanriSsRireki;


/**
 * GaibuRendoInfoDomマネージャー<br />
 * GaibuRendoInfoにおける、DB操作を提供する。<br />
 */
class GaibuRendoInfoDomManager {


    @Inject
    private HT_BAK_SmbcStyKanriDao bAK_SmbcStyKanriDao;


    @Inject
    private HT_SisyaToukeiHokanDao sisyaToukeiHokanDao;


    @Inject
    private HT_SkLincJyusinDataDao skLincJyusinDataDao;


    @Inject
    private HT_SkLincSousinDataDao skLincSousinDataDao;


    @Inject
    private HT_SmbcStyKanriDao smbcStyKanriDao;


    @Inject
    private HT_SmbcStyKanriSsRirekiDao smbcStyKanriSsRirekiDao;


    List<HT_SmbcStyKanri> getAllSmbcStyKanri(){
        SortHT_SmbcStyKanri sortHT_SmbcStyKanri = new SortHT_SmbcStyKanri();
        return sortHT_SmbcStyKanri.OrderHT_SmbcStyKanriByPkAsc(smbcStyKanriDao.selectAll());
    }


    HT_SmbcStyKanri getSmbcStyKanri(BizDate pDatarenymd, BizNumber pDatasakuseirenno) {

        return smbcStyKanriDao.getSmbcStyKanri(pDatarenymd, pDatasakuseirenno);
    }


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcd(String pKakutyoujobcd) {


        ExDBResults<HT_SmbcStyKanri> exDBResults = smbcStyKanriDao.getSmbcStyKanrisByKakutyoujobcd();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno(String pKakutyoujobcd) {


        ExDBResults<HT_SmbcStyKanri> exDBResults = smbcStyKanriDao.getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno(String pKakutyoujobcd) {


        ExDBResults<HT_SmbcStyKanri> exDBResults = smbcStyKanriDao.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno();


        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));


        return exDBResults;
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySmbcsyono(String pSmbcsyono) {

        return smbcStyKanriDao.getSmbcStyKanrisBySmbcsyono(pSmbcsyono);
    }


    List<HT_SisyaToukeiHokan> getAllSisyaToukeiHokan(){
        SortHT_SisyaToukeiHokan sortHT_SisyaToukeiHokan = new SortHT_SisyaToukeiHokan();
        return sortHT_SisyaToukeiHokan.OrderHT_SisyaToukeiHokanByPkAsc(sisyaToukeiHokanDao.selectAll());
    }


    HT_SisyaToukeiHokan getSisyaToukeiHokan(String pSstmosno, Integer pRenno) {

        return sisyaToukeiHokanDao.getSisyaToukeiHokan(pSstmosno, pRenno);
    }


    List<HT_SisyaToukeiHokan> getSisyaToukeiHokansBySstmosno(String pSstmosno) {

        return sisyaToukeiHokanDao.getSisyaToukeiHokansBySstmosno(pSstmosno);
    }


    List<HT_SkLincJyusinData> getAllSkLincJyusinData(){
        SortHT_SkLincJyusinData sortHT_SkLincJyusinData = new SortHT_SkLincJyusinData();
        return sortHT_SkLincJyusinData.OrderHT_SkLincJyusinDataByPkAsc(skLincJyusinDataDao.selectAll());
    }


    HT_SkLincJyusinData getSkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {

        return skLincJyusinDataDao.getSkLincJyusinData(pSyoriYmd, pLinckyknaiykekdatarenno);
    }


    HT_SkLincJyusinData getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(String pMosno) {

        return skLincJyusinDataDao.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(pMosno);
    }


    List<HT_SkLincJyusinData> getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate pSyoriYmd, String pLinckyknaiykekdatarennooya) {

        return skLincJyusinDataDao.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(pSyoriYmd, pLinckyknaiykekdatarennooya);
    }


    List<HT_SkLincSousinData> getAllSkLincSousinData(){
        SortHT_SkLincSousinData sortHT_SkLincSousinData = new SortHT_SkLincSousinData();
        return sortHT_SkLincSousinData.OrderHT_SkLincSousinDataByPkAsc(skLincSousinDataDao.selectAll());
    }


    HT_SkLincSousinData getSkLincSousinData(String pMosno, BizDate pSyoriYmd, Integer pRenno) {

        return skLincSousinDataDao.getSkLincSousinData(pMosno, pSyoriYmd, pRenno);
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyono(String pSyono) {

        return smbcStyKanriDao.getSmbcStyKanrisBySyono(pSyono);
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisByMosno(String pMosno) {

        return smbcStyKanriDao.getSmbcStyKanrisByMosno(pMosno);
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoRendouflg(String pSyono) {

        return smbcStyKanriDao.getSmbcStyKanrisBySyonoRendouflg(pSyono);
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(String pSyono, String pSmbcseihosyknhkkzmymd) {

        return smbcStyKanriDao.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(pSyono, pSmbcseihosyknhkkzmymd);
    }


    BizNumber getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate pDatarenymd) {

        return smbcStyKanriDao.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(pDatarenymd);
    }


    List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(String pSyono, String pSmbcseihosyknhkkzmymd, String pSmbcseihotrksymd) {

        return smbcStyKanriDao.getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(pSyono, pSmbcseihosyknhkkzmymd, pSmbcseihotrksymd);
    }


    List<HT_SmbcStyKanriSsRireki> getAllSmbcStyKanriSsRireki(){
        SortHT_SmbcStyKanriSsRireki sortHT_SmbcStyKanriSsRireki = new SortHT_SmbcStyKanriSsRireki();
        return sortHT_SmbcStyKanriSsRireki.OrderHT_SmbcStyKanriSsRirekiByPkAsc(smbcStyKanriSsRirekiDao.selectAll());
    }


    HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRireki(String pSyono) {

        return smbcStyKanriSsRirekiDao.getSmbcStyKanriSsRireki(pSyono);
    }


    List<HT_SmbcStyKanriSsRireki> getSmbcStyKanriSsRirekisByMosno(String pMosno) {

        return smbcStyKanriSsRirekiDao.getSmbcStyKanriSsRirekisByMosno(pMosno);
    }


    HT_SmbcStyKanriSsRireki getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(String pSyono, String pSyrctrltblkostime) {

        return smbcStyKanriSsRirekiDao.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime(pSyono, pSyrctrltblkostime);
    }


    List<HT_BAK_SmbcStyKanri> getAllBAKSmbcStyKanri(){
        SortHT_BAK_SmbcStyKanri sortHT_BAK_SmbcStyKanri = new SortHT_BAK_SmbcStyKanri();
        return sortHT_BAK_SmbcStyKanri.OrderHT_BAK_SmbcStyKanriByPkAsc(bAK_SmbcStyKanriDao.selectAll());
    }


    List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_SmbcStyKanriDao.getBAKSmbcStyKanrisBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisByMosno(String pMosno) {

        return bAK_SmbcStyKanriDao.getBAKSmbcStyKanrisByMosno(pMosno);
    }


    HT_BAK_SmbcStyKanri getBAKSmbcStyKanri(BizDate pDatarenymd, String pTrkssikibetukey, BizNumber pDatasakuseirenno) {

        return bAK_SmbcStyKanriDao.getBAKSmbcStyKanri(pDatarenymd, pTrkssikibetukey, pDatasakuseirenno);
    }

}
