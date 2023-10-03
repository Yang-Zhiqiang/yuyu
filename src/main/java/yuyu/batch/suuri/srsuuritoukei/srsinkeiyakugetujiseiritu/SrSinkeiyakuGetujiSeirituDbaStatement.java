package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakugetujiseiritu;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSinkeiyakuGetujiSeirituDbaStatement {

    private static final int RENBAN = 1;

    @Inject
    private SrSinkeiyakuGetujiSeirituDao srSinkeiyakuGetujiSeirituDao;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_SnkiykGtjSirt> getSnkiykGtjSirt(BizDateYM pTysytTaisyouym, C_SeirituKbn pSeirituKbn) {

        ExDBResults<SV_SnkiykGtjSirt> snkiykGtjSirtLst =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(pTysytTaisyouym, pSeirituKbn);

        return snkiykGtjSirtLst;
    }

    public List<HT_MosSyouhn> getMosSyouhns(String pMosno, C_SyutkKbn pSyutkKbn) {

        HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosSyouhntouched(sinkeiyakuDomManager.getSyoriCTL(pMosno));

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(pSyutkKbn);

        return mosSyouhnLst;
    }

    public List<HT_MosDairiten> getMosDairiten (String pMosno) {

        HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosDairitentouched(sinkeiyakuDomManager.getSyoriCTL(pMosno));

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();

        return mosDairitenLst;
    }

    public IT_KykUkt getKykUkt(String pSyono, C_UktsyuKbn pUktsyuKbn) {

        IT_KykKihon kykKihon = IT_KykKihonDetacher.detachKykUkttouched(hozenDomManager.getKykKihon(pSyono));

        IT_KykUkt kykUkt = kykKihon.getKykUktsByUktsyukbnUktsyurenno(pUktsyuKbn, RENBAN);

        return kykUkt;
    }

    public List<HT_Nyuukin> getNyuukinJyouhou (String pMosno) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        syoriCTL = HT_SyoriCTLDetacher.detachNyuukintouched(syoriCTL);

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByZenhnknkbnBlank();

        SortHT_Nyuukin nyuukinSort = SWAKInjector.getInstance(SortHT_Nyuukin.class);

        nyuukinLst = nyuukinSort.OrderHT_NyuukinByRyosyuymdRennoAsc(nyuukinLst);

        return nyuukinLst;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return syouhnZokusei;
    }

    public List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean>
    getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
            hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(pSyono);

        return khHenkouRirekiBeanList;
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean>
    getTargetTokuyakuBefaAftMokuhyoutiAscList(String pSyono) {

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftMokuhyoutiAscList =
            hozenDomManager.getTargetTokuyakuBefaAftMokuhyoutiAscList(pSyono);

        return targetTokuyakuBefaAftMokuhyoutiAscList;
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean>
    getTargetTokuyakuBefaAftKijyungkAscList(String pSyono) {

        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftKijyungkAscList =
            hozenDomManager.getTargetTokuyakuBefaAftKijyungkAscList(pSyono);

        return targetTokuyakuBefaAftKijyungkAscList;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono, BizDate pKijyunYmd) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList =
            srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunYmd);

        return khSisuurendoTmttknList;
    }

    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn,
        String pMosno, C_DensyoriKbn pDensyoriKbn) {

        List<BT_DenpyoData> btDenpyoDataList =
            srCommonKinouDao.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensyskbn, pMosno, pDensyoriKbn);

        return btDenpyoDataList;
    }
}
