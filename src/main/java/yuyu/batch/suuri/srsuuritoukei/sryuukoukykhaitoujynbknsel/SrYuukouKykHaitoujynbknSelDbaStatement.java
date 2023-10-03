package yuyu.batch.suuri.srsuuritoukei.sryuukoukykhaitoujynbknsel;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai.SrHoyuuMeisaiDao;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 有効契約配当準備金データ抽出ＤＢＡ宣言
 */
public class SrYuukouKykHaitoujynbknSelDbaStatement {

    @Inject
    private SrHoyuuMeisaiDao srHoyuuMeisaiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_HoyuuMeisai> getHoyuuMeisais(String pKbnkey) {

        ExDBResults<SV_HoyuuMeisai> svHoyuuMeisaiList = srHoyuuMeisaiDao.getHoyuuMeisais(pKbnkey);

        return svHoyuuMeisaiList;
    }

    public List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getHoyuKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkKbn) {

        return hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(pSyono, pSyutkKbn);
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono) {

        return hozenDomManager.getKhBikinkanrisBySyono(pSyono);
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono) {

        return siharaiDomManager.getSiBikinkanrisBySyono(pSyono);
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyno, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.
            getKiykSyuhnDatasBySyonoSyutkkbn(pSyno, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSV_KiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        kiykSyuhnDataLst = sortSV_KiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);

        return kiykSyuhnDataLst;

    }

    public HoyuuKhTtdkRirekiByPkBean getHoyuuKhTtdkRirekiByPk(String pSyono, String pHenkousikibetukey) {

        return hozenDomManager.getHoyuuKhTtdkRirekiByPk(pSyono, pHenkousikibetukey);
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanris(String pSyono, BizDate pKijyunymd) {

        return srCommonKinouDao.getTumitateDKanris(pSyono, pKijyunymd);
    }

    public List<IT_KhHaitouKanri> getHaitouKanris(String pSyono, BizDate pKijyunymd) {

        return srCommonKinouDao.getHaitouKanris(pSyono, C_HaitoumeisaiKbn.SYU, pKijyunymd);
    }
}
