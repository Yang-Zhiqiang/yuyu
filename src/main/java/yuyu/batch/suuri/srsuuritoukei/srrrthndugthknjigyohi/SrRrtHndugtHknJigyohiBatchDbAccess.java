package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 利率変動型保険事業費情報作成のＤＢアクセスクラス
 */
public class SrRrtHndugtHknJigyohiBatchDbAccess {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private SrRrtHndugtHknJigyohiDao srRrtHndugtHknJigyohiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<ST_SynypTukiYkgtIkouHozon> getHoyuuMeisaiTyukeiyouItzHzns(BizDateYM pKijyunym) {

        ExDBResults<ST_SynypTukiYkgtIkouHozon> synypTukiYkgtIkouHozonLst =
            srRrtHndugtHknJigyohiDao.getST_SynypTukiYkgtIkouHozons(pKijyunym);

        return synypTukiYkgtIkouHozonLst;
    }

    public ExDBResults<ST_SynypTukiTugtTykiyuHozon> getSynypTukiTugtTykiyuHozons(BizDateYM pKijyunym,
        String pKakutyoujobcdSkSynyp, String pKakutyoujobcdGekkanHnkSynyp) {

        ExDBResults<ST_SynypTukiTugtTykiyuHozon> synypTukiTugtTykiyuHozonLst = srRrtHndugtHknJigyohiDao
            .getSynypTukiTugtTykiyuHozons(pKijyunym, pKakutyoujobcdSkSynyp, pKakutyoujobcdGekkanHnkSynyp);

        return synypTukiTugtTykiyuHozonLst;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatas(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        return sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);
    }

    public SV_HoyuuMeisai getHoyuuMeisai(String pSyono) {

        SV_HoyuuMeisai hoyuuMeisai = suuriDomManager.getHoyuuMeisai(pSyono);

        return hoyuuMeisai;
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttknsBySyonoTmttknkouryokukaisiymdDesc(
        String pSyono, BizDateYM pKijyunym) {

        return srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunym);
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki1(String pSyono, BizDateYM pJyuutouym) {

        IT_NyknJissekiRireki nyknJissekiRireki = srRrtHndugtHknJigyohiDao.getNyknJissekiRireki1(pSyono, pJyuutouym);

        return nyknJissekiRireki;
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki2(String pSyono,BizDateYM pJyuutouym, String pNyktrksdenno) {

        IT_NyknJissekiRireki nyknJissekiRireki = srRrtHndugtHknJigyohiDao.getNyknJissekiRireki2(pSyono, pJyuutouym,
            pNyktrksdenno);

        return nyknJissekiRireki;
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki3(String pSyono,BizDateYM pJyutouStartYm, Integer pRenno) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);

        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(pJyutouStartYm, pRenno);

        return nyknJissekiRireki;
    }
}
