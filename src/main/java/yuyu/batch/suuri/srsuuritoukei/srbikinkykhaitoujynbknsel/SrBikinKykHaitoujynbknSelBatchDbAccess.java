package yuyu.batch.suuri.srsuuritoukei.srbikinkykhaitoujynbknsel;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 備金契約配当準備金データ抽出バッチＤＢアクセスクラス
 */
public class SrBikinKykHaitoujynbknSelBatchDbAccess {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private SrBikinKykHaitoujynbknSelDao srBikinKykHaitouMeisaiDao;

    public ExDBResults<SV_BikinKykHaitouMeisai> getBikinKykHaitouMeisais(C_BknrigiKbn pBknrigiKbn, BizDate pKessanKijyunYmd) {

        ExDBResults<SV_BikinKykHaitouMeisai> bikinKykHaitouMeisaiList =
            srBikinKykHaitouMeisaiDao.getBikinKykHaitouMeisaisByBknrigikbnKessankijyunymd(pBknrigiKbn, pKessanKijyunYmd);

        return bikinKykHaitouMeisaiList;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatas(String pSyoNo, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataList =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyoNo, pSyutkKbn);

        kiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSV_KiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        kiykSyuhnDataList = sortSV_KiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataList);

        return kiykSyuhnDataList;
    }

    public List<JT_SiBikinkanri> getSiBikinkanris(String pSyoNo, BizDate pKessankijyunyMd) {

        List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(pSyoNo,
            pKessankijyunyMd);

        siBikinkanriLst = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(siBikinkanriLst);

        return siBikinkanriLst;
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanris(String pSyoNo, BizDate pKijyunYmd) {

        List<IT_KhTumitateDKanri> khTumitateDKanriList =  srCommonKinouDao.getTumitateDKanris(pSyoNo, pKijyunYmd);

        return khTumitateDKanriList;
    }

    public List<IT_KhHaitouKanri> getHaitouKanris(String pSyoNo, C_HaitoumeisaiKbn pHaitoumeisaiKbn,BizDate pKijyunYmd) {

        List<IT_KhHaitouKanri> khHaitouKanriList =  srCommonKinouDao.getHaitouKanris(pSyoNo, pHaitoumeisaiKbn, pKijyunYmd);

        return khHaitouKanriList;
    }

    public List<IT_KhDshrTuki> getKhDshrTukis(String pSyono, C_Syoumetujiyuu pSyoumetujiyuu, String pGyoumuKousinKinou) {

        List<IT_KhDshrTuki> khDshrTukiList = srBikinKykHaitouMeisaiDao.getKhDshrTukis(pSyono, pSyoumetujiyuu, pGyoumuKousinKinou);

        return khDshrTukiList;
    }

    public List<IT_KhDshrTuki> getKhDshrTukisBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        List<IT_KhDshrTuki> khDshrTukiList = srBikinKykHaitouMeisaiDao.getKhDshrTukisBySyonoHenkousikibetukey(
            pSyono, pHenkousikibetukey);

        return khDshrTukiList;
    }

    public List<JT_SiDshrTuki> getSiDshrTukis(String pSyono, String pGyoumuKousinKinou) {

        List<JT_SiDshrTuki> siDshrTukiList = srBikinKykHaitouMeisaiDao.getSiDshrTukis(pSyono, pGyoumuKousinKinou);

        return siDshrTukiList;
    }

}
