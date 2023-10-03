package yuyu.batch.suuri.srsuuritoukei.srjigyounendosikitkhoyuu;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.detacher.IT_ItekiToukeiInfoDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 数理 数理統計 事業年度式特約保有情報作成のＤＢアクセスクラス
 */
public class SrJigyounendosikiTkHoyuuBatchDbAccess {

    private static final int DRTENRENNO = 1;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SrCommonKinouDao commonKinouDao;

    public ExDBResults<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkKbn, String pKbnkey) {

        return commonKinouDao.getKykSyouhns(pSyutkKbn, pKbnkey);
    }

    public IT_KhTtdkRireki getKhTtdkRireki(String pSyono, String pHenkousikibetukey) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykKihonDetacher.detachKhTtdkRirekitouched(kykKihon);
        return kykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhinCd, Integer pSyouhnsdNo) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhinCd, pSyouhnsdNo);

        return syouhnZokusei;
    }

    public IT_KykDairiten getKykDairitenByDrtenrenno(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykKihonDetacher.detachKykDairitentouched(kykKihon);
        return kykKihon.getKykDairitenByDrtenrenno(DRTENRENNO);
    }

    public IT_KykSonotaTkyk getKykSonotaTkyk(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        IT_KykKihonDetacher.detachKykSonotaTkyktouched(kykKihon);
        return kykKihon.getKykSonotaTkyk();
    }

    public IT_ItekiToukeiInfo getItekiToukeiInfoBySyono(String pSyono) {

        IT_ItekiToukeiInfo itekiToukeiInfo = hozenDomManager.getItekiToukeiInfo(pSyono);
        return IT_ItekiToukeiInfoDetacher.detachItekiToukeiInfotouched(itekiToukeiInfo);
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        return IT_KykKihonDetacher.detachKykKihontouched(kykKihon);
    }
}