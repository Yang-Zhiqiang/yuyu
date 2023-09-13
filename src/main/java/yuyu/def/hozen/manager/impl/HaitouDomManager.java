package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.dao.IT_BAK_KhDshrTukiDao;
import yuyu.def.db.dao.IT_BAK_KhHaitouKanriDao;
import yuyu.def.db.dao.IT_BAK_KhTumitateDKanriDao;
import yuyu.def.db.dao.IT_DSeisanTuibaraiKanriDao;
import yuyu.def.db.dao.IT_KhDshrTukiDao;
import yuyu.def.db.dao.IT_KhHaitouKanriDao;
import yuyu.def.db.dao.IT_KhTumitateDKanriDao;
import yuyu.def.db.dao.IW_KhHaitouTaisyouWKDao;
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.def.db.entity.IT_BAK_KhTumitateDKanri;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import yuyu.def.hozen.sorter.SortIT_BAK_KhDshrTuki;
import yuyu.def.hozen.sorter.SortIT_BAK_KhHaitouKanri;
import yuyu.def.hozen.sorter.SortIT_BAK_KhTumitateDKanri;
import yuyu.def.hozen.sorter.SortIT_DSeisanTuibaraiKanri;
import yuyu.def.hozen.sorter.SortIT_KhDshrTuki;
import yuyu.def.hozen.sorter.SortIT_KhHaitouKanri;
import yuyu.def.hozen.sorter.SortIT_KhTumitateDKanri;
import yuyu.def.hozen.sorter.SortIW_KhHaitouTaisyouWK;


/**
 * HaitouDomマネージャー<br />
 * Haitouにおける、DB操作を提供する。<br />
 */
class HaitouDomManager {

    @Inject
    private IT_BAK_KhDshrTukiDao bAK_KhDshrTukiDao;

    @Inject
    private IT_BAK_KhHaitouKanriDao bAK_KhHaitouKanriDao;

    @Inject
    private IT_BAK_KhTumitateDKanriDao bAK_KhTumitateDKanriDao;

    @Inject
    private IT_DSeisanTuibaraiKanriDao dSeisanTuibaraiKanriDao;

    @Inject
    private IT_KhDshrTukiDao khDshrTukiDao;

    @Inject
    private IT_KhHaitouKanriDao khHaitouKanriDao;

    @Inject
    private IT_KhTumitateDKanriDao khTumitateDKanriDao;

    @Inject
    private IW_KhHaitouTaisyouWKDao khHaitouTaisyouWKDao;

    List<IT_KhHaitouKanri> getAllKhHaitouKanri(){
        SortIT_KhHaitouKanri sortIT_KhHaitouKanri = new SortIT_KhHaitouKanri();
        return sortIT_KhHaitouKanri.OrderIT_KhHaitouKanriByPkAsc(khHaitouKanriDao.selectAll());
    }

    IT_KhHaitouKanri getKhHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn, C_HaitoumeisaiKbn pHaitoumeisaikbn) {

        return khHaitouKanriDao.getKhHaitouKanri(pSyono, pHaitounendo, pRenno, pHaitoukinskskbn, pHaitoumeisaikbn);
    }

    List<IW_KhHaitouTaisyouWK> getAllKhHaitouTaisyouWK(){
        SortIW_KhHaitouTaisyouWK sortIW_KhHaitouTaisyouWK = new SortIW_KhHaitouTaisyouWK();
        return sortIW_KhHaitouTaisyouWK.OrderIW_KhHaitouTaisyouWKByPkAsc(khHaitouTaisyouWKDao.selectAll());
    }

    IW_KhHaitouTaisyouWK getKhHaitouTaisyouWK(String pSyono, BizDate pSyoriYmd, C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn, C_HaitoumeisaiKbn pHaitoumeisaikbn
        , Integer pRenno) {

        return khHaitouTaisyouWKDao.getKhHaitouTaisyouWK(pSyono, pSyoriYmd, pHaitoukinuketorihoukbn, pHaitoumeisaikbn
            , pRenno);
    }

    List<IT_KhHaitouKanri> getKhHaitouKanriBySyono(String pSyono) {

        return khHaitouKanriDao.getKhHaitouKanriBySyono(pSyono);
    }

    List<IT_KhTumitateDKanri> getKhTumitateDKanriBySyono(String pSyono) {

        return khTumitateDKanriDao.getKhTumitateDKanriBySyono(pSyono);
    }

    List<IT_BAK_KhHaitouKanri> getBAKKhHaitouKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhHaitouKanriDao.getBAKKhHaitouKanriBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhTumitateDKanri> getBAKKhTumitateDKanriBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhTumitateDKanriDao.getBAKKhTumitateDKanriBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhHaitouKanri> getAllBAKKhHaitouKanri(){
        SortIT_BAK_KhHaitouKanri sortIT_BAK_KhHaitouKanri = new SortIT_BAK_KhHaitouKanri();
        return sortIT_BAK_KhHaitouKanri.OrderIT_BAK_KhHaitouKanriByPkAsc(bAK_KhHaitouKanriDao.selectAll());
    }

    IT_BAK_KhHaitouKanri getBAKKhHaitouKanri(String pSyono, String pTrkssikibetukey, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn
        , C_HaitoumeisaiKbn pHaitoumeisaikbn) {

        return bAK_KhHaitouKanriDao.getBAKKhHaitouKanri(pSyono, pTrkssikibetukey, pHaitounendo, pRenno, pHaitoukinskskbn
            , pHaitoumeisaikbn);
    }

    List<IT_BAK_KhTumitateDKanri> getAllBAKKhTumitateDKanri(){
        SortIT_BAK_KhTumitateDKanri sortIT_BAK_KhTumitateDKanri = new SortIT_BAK_KhTumitateDKanri();
        return sortIT_BAK_KhTumitateDKanri.OrderIT_BAK_KhTumitateDKanriByPkAsc(bAK_KhTumitateDKanriDao.selectAll());
    }

    IT_BAK_KhTumitateDKanri getBAKKhTumitateDKanri(String pSyono, String pTrkssikibetukey, BizDate pTumitatedtumitateymd, Integer pRenno) {

        return bAK_KhTumitateDKanriDao.getBAKKhTumitateDKanri(pSyono, pTrkssikibetukey, pTumitatedtumitateymd, pRenno);
    }

    List<IT_KhTumitateDKanri> getAllKhTumitateDKanri(){
        SortIT_KhTumitateDKanri sortIT_KhTumitateDKanri = new SortIT_KhTumitateDKanri();
        return sortIT_KhTumitateDKanri.OrderIT_KhTumitateDKanriByPkAsc(khTumitateDKanriDao.selectAll());
    }

    IT_KhTumitateDKanri getKhTumitateDKanri(String pSyono, BizDate pTumitatedtumitateymd, Integer pRenno) {

        return khTumitateDKanriDao.getKhTumitateDKanri(pSyono, pTumitatedtumitateymd, pRenno);
    }

    List<IT_DSeisanTuibaraiKanri> getAllDSeisanTuibaraiKanri(){
        SortIT_DSeisanTuibaraiKanri sortIT_DSeisanTuibaraiKanri = new SortIT_DSeisanTuibaraiKanri();
        return sortIT_DSeisanTuibaraiKanri.OrderIT_DSeisanTuibaraiKanriByPkAsc(dSeisanTuibaraiKanriDao.selectAll());
    }

    IT_DSeisanTuibaraiKanri getDSeisanTuibaraiKanri(String pSyono, BizDateY pHaitounendo) {

        return dSeisanTuibaraiKanriDao.getDSeisanTuibaraiKanri(pSyono, pHaitounendo);
    }

    List<IT_KhDshrTuki> getAllKhDshrTuki(){
        SortIT_KhDshrTuki sortIT_KhDshrTuki = new SortIT_KhDshrTuki();
        return sortIT_KhDshrTuki.OrderIT_KhDshrTukiByPkAsc(khDshrTukiDao.selectAll());
    }

    IT_KhDshrTuki getKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono) {

        return khDshrTukiDao.getKhDshrTuki(pDshrtoukeisikibetukey, pSyono);
    }

    List<IT_BAK_KhDshrTuki> getAllBAKKhDshrTuki(){
        SortIT_BAK_KhDshrTuki sortIT_BAK_KhDshrTuki = new SortIT_BAK_KhDshrTuki();
        return sortIT_BAK_KhDshrTuki.OrderIT_BAK_KhDshrTukiByPkAsc(bAK_KhDshrTukiDao.selectAll());
    }

    IT_BAK_KhDshrTuki getBAKKhDshrTuki(String pDshrtoukeisikibetukey, String pSyono, String pTrkssikibetukey) {

        return bAK_KhDshrTukiDao.getBAKKhDshrTuki(pDshrtoukeisikibetukey, pSyono, pTrkssikibetukey);
    }

    List<IT_BAK_KhDshrTuki> getBAKKhDshrTukiBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhDshrTukiDao.getBAKKhDshrTukiBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }

    List<IT_KhDshrTuki> getKhDshrTukiBySyono(String pSyono) {

        return khDshrTukiDao.getKhDshrTukiBySyono(pSyono);
    }

}
