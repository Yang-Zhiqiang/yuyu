package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknidouv;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.batch.suuri.srsuuritoukei.srsinkeiyakugetujiseiritu.SrSinkeiyakuGetujiSeirituDao;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.hozen.detacher.IT_ItekiToukeiInfoDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 株価指数連動保険異動Ｖ情報作成のＤＢアクセスクラス
 */
public class SrKbkSsuRnduHknIdouVBatchDbAccess {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private SrSinkeiyakuGetujiSeirituDao srSinkeiyakuGetujiSeirituDao;

    public ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> getIdouMeisaiTyukeiyouItzHzn(String pKijyunym,
        String pKakutyoujobcd, String[] pHknsyukigou) {

        ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznLst = srCommonKinouDao
            .getIdouMeisaiTyukeiyouItzHzns(pKijyunym, pKakutyoujobcd, pHknsyukigou);

        return idouMeisaiTyukeiyouItzHznLst;
    }

    public ExDBResults<SV_SnkiykGtjSirt> getSkSeirituDate(BizDateYM pTysytTaisyouym, C_SeirituKbn pSeirituKbn) {

        ExDBResults<SV_SnkiykGtjSirt> snkiykGtjSirtLst =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(pTysytTaisyouym, pSeirituKbn);

        return snkiykGtjSirtLst;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnData(String pSyno, C_SyutkKbn pCSyutkKbn) {

        List<SV_KiykSyuhnData> sVKiykSyuhnDataLst =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyno, pCSyutkKbn);

        sVKiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(sVKiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        return sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(sVKiykSyuhnDataLst);
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return IT_KykKihonDetacher.detachKykKihontouched(kykKihon);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }

    public IT_KykDairiten getKykDairiten(String pSyono, Integer pDrtenrenno) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykDairitentouched(kykKihon);

        return kykKihon.getKykDairitenByDrtenrenno(pDrtenrenno);

    }

    public IT_NyknJissekiRireki getNyknJissekiRireki(String pSyoNo, BizDateYM pJyutouStartYm, Integer pRenNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);

        IT_NyknJissekiRireki nyknJissekiRireki =
            kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(pJyutouStartYm, pRenNo);

        return nyknJissekiRireki;
    }

    public IT_ItekiToukeiInfo getItekiToukeiInfoBySyono(String pSyono) {

        IT_ItekiToukeiInfo itekiToukeiInfo = hozenDomManager.getItekiToukeiInfo(pSyono);

        return IT_ItekiToukeiInfoDetacher.detachItekiToukeiInfotouched(itekiToukeiInfo);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunYmd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunYmd);
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

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getKhHenkouRirekis(
        String pSyono, String pHenkousikibetukey, String pTableid, String pHenkoukoumokuid ) {

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean =
            srCommonKinouDao.getKhHenkouRirekis(pSyono, pHenkousikibetukey, pTableid, pHenkoukoumokuid);

        return khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
    }
}
