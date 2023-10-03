package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.KykDairitenByPkBean;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KhBikinkanriDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 保有明細情報作成
 */
public class SrHoyuuMeisaiBatchDbAccess {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SrHoyuuMeisaiDao srHoyuuMeisaiDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_HoyuuMeisai> getHoyuuMeisais(String pKbnkey) {

        ExDBResults<SV_HoyuuMeisai> svHoyuuMeisaiList = srHoyuuMeisaiDao.getHoyuuMeisais(pKbnkey);

        return svHoyuuMeisaiList;

    }

    public List<HoyuKykSyouhnsBySyonoSyutkkbnBean> getKiykSyuhnDatas(String pSyono, C_SyutkKbn pSyutkKbn) {

        return hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(pSyono, pSyutkKbn);
    }

    public List<IT_KhBikinkanri> getKhBikinkanris(String pSyono) {

        List<IT_KhBikinkanri> itKhBikinkanriList = hozenDomManager.getKhBikinkanrisBySyono(pSyono);

        itKhBikinkanriList = IT_KhBikinkanriDetacher.detachKhBikinkanritouched(itKhBikinkanriList);

        return itKhBikinkanriList;
    }

    public List<JT_SiBikinkanri> getSiBikinkanris(String pSyono) {

        List<JT_SiBikinkanri> jtSiBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyono(pSyono);

        jtSiBikinkanriList = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(jtSiBikinkanriList);

        return jtSiBikinkanriList;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnList(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager.
            getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkKbn);

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

    public NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean getNyknJissekiRireki(String pSyono,
        BizDateYM pJyutoustartym, Integer pRenno) {

        return hozenDomManager.getNyknJissekiRirekiRstuukasyuRyosyuymdByPK(pSyono, pJyutoustartym, pRenno);
    }

    public List<KhHenkouRirekiHenkousikibetukeyItemsBySyonoBean> getSyokisiboujiYenkansanSaiteihosyougakuHenkoumaeList(String pSyono) {

        return hozenDomManager.getKhHenkouRirekiHenkousikibetukeyItemsBySyono(pSyono);
    }

    public List<BizDate> getKeiyakuSyouhinjouhouView(String pSyono, String pHenkousikibetukey) {

        return suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(
        String pSyono) {

        return hozenDomManager.getTargetTokuyakuBefaAftMokuhyoutiDescList(pSyono);
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(
        String pSyono, String pHenkousikibetukey) {

        return hozenDomManager.getTargetTokuyakuBefaAftKykhenkoYmdList(pSyono, pHenkousikibetukey);
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKijyungkDescList(
        String pSyono) {

        return hozenDomManager.getTargetTokuyakuBefaAftKijyungkDescList(pSyono);
    }

    public KykDairitenByPkBean getKykDairitenByPk(String pSyono, Integer pDrtenrenno) {

        return srCommonKinouDao.getKykDairitenByPk(pSyono, pDrtenrenno);
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaes(String pSyono) {

        return srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
        String pSyono, BizDate pKijyunymd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttknsBySyonoTmttknkouryokukaisiymdDesc(
        String pSyono, BizDateYM pKijyunym) {

        return srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunym);
    }
}