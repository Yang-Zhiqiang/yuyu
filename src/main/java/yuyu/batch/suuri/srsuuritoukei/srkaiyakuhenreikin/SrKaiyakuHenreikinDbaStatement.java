package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KhBikinkanriDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 解約返戻金相当額情報ＤＢＡ宣言
 */
public class SrKaiyakuHenreikinDbaStatement {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_KiykHnriknSutugk> getKiykHnriknSutugks(String pKbnkey) {

        SrKaiyakuHenreikinDao srKaiyakuHenreikinDao = SWAKInjector.getInstance(SrKaiyakuHenreikinDao.class);

        ExDBResults<SV_KiykHnriknSutugk> svKiykHnriknSutugkList = srKaiyakuHenreikinDao.getKiykHnriknSutugks(pKbnkey);

        return svKiykHnriknSutugkList;

    }

    public List<IT_KykSyouhn> getKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<IT_KykSyouhn> itKykSyouhnList = srCommonKinouDao.getKykSyouhns(pSyono, pSyutkKbn);

        return itKykSyouhnList;
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono) {

        List<IT_KhBikinkanri> itKhBikinkanriList = hozenDomManager.getKhBikinkanrisBySyono(pSyono);

        itKhBikinkanriList = IT_KhBikinkanriDetacher.detachKhBikinkanritouched(itKhBikinkanriList);

        return itKhBikinkanriList;
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono) {

        List<JT_SiBikinkanri> jtSiBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        jtSiBikinkanriList = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(jtSiBikinkanriList);

        return jtSiBikinkanriList;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(
            pSyono,
            pSyutkkbn);

        svKiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(svKiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        svKiykSyuhnDataList = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(svKiykSyuhnDataList);

        return svKiykSyuhnDataList;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }

    public HoyuuKhTtdkRirekiByPkBean getKhTtdkRireki(String pSyono, String pHenkousikibetukey) {

        return hozenDomManager.getHoyuuKhTtdkRirekiByPk(pSyono, pHenkousikibetukey);
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttkns(String pSyono, BizDateYM pKijyunym) {

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunym);

        return hokenryouTmttknLst;
    }

}