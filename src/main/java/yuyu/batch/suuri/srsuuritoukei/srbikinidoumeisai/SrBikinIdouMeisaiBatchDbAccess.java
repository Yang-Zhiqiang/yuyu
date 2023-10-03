package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.suuri.srcommon.KykDairitenByPkBean;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 備金異動明細情報作成
 */
public class SrBikinIdouMeisaiBatchDbAccess {

    @Inject
    private SrBikinIdouMeisaiDao srBikinIdouMeisaiDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public List<SV_KiykSyuhnData> getKiykSyuhnDatas(String pSyono, C_SyutkKbn pSyutkkbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager.
            getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkkbn);

        svKiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(svKiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSV_KiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        svKiykSyuhnDataList = sortSV_KiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(svKiykSyuhnDataList);

        return svKiykSyuhnDataList;

    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }

    public List<SV_BikinIdouMeisai> getBikinIdouMeisais(C_BknJkuKbn pBknJkuKbn,
        C_BknrigiKbn pBknrigiKbn, BizDate pKessankijyunymd) {

        List<SV_BikinIdouMeisai> bikinIdouMeisaiLst = srBikinIdouMeisaiDao.
            getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(pBknJkuKbn, pBknrigiKbn, pKessankijyunymd);

        return bikinIdouMeisaiLst;
    }

    public AS_Kinou getKinou(String pKinouId) {

        AS_Kinou kinou = baseDomManager.getKinou(pKinouId);

        return kinou;
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki(String pSyoNo, BizDateYM pJyutouStartYm, Integer pRenNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);

        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(pJyutouStartYm, pRenNo);

        return nyknJissekiRireki;
    }

    public List<JT_SiBikinkanri> getSiBikinkanri(String pSyoNo, BizDate pKessanKijyunYmd) {

        List<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(pSyoNo,
            pKessanKijyunYmd);

        siBikinkanriLst = JT_SiBikinkanriDetacher.detachSiBikinkanritouched(siBikinkanriLst);

        return siBikinkanriLst;
    }

    public KykDairitenByPkBean getKykDairitenByPk(String pSyono, Integer pDrtenrenno) {

        return srCommonKinouDao.getKykDairitenByPk(pSyono, pDrtenrenno);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunYmd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunYmd);
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaeBySyonoHenkousikibetukeyDesc(String pSyono) {

        return srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttknsBySyonoTmttkntaisyouymDesc(String pSyono, BizDateYM pKijyunYm) {

        return srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunYm);
    }
}