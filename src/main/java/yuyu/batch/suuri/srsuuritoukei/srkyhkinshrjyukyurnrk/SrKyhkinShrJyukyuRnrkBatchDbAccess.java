package yuyu.batch.suuri.srsuuritoukei.srkyhkinshrjyukyurnrk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SkKihonDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_Sk;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 給付金支払状況連絡情報作成のＤＢアクセスクラス
 */
public class SrKyhkinShrJyukyuRnrkBatchDbAccess {

    private static final Integer DRTENRENNO1 = 1;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn pShrkekkakbn,
        BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {

        ExDBResults<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(
            pShrkekkakbn, pShrsyoriymdFrom, pShrsyoriymdTo);

        return siRirekiLst;
    }

    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(C_ShrKekkaKbn pShrkekkakbn,
        BizDate pTyakkinymdFrom, BizDate pTyakkinymdTo) {

        ExDBResults<JT_SiRireki> siRirekiLst = siharaiDomManager.getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(
            pShrkekkakbn, pTyakkinymdFrom, pTyakkinymdTo);

        return siRirekiLst;
    }

    public JT_SkKihon getSkKihon(String pSkno, String pSyono) {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        return JT_SkKihonDetacher.detachSkKihontouched(skKihon);
    }

    public List<JT_Sk> getSks(String pSkno, String pSyono) {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        JT_SkKihonDetacher.detachSktouched(skKihon);

        List<JT_Sk> skLst = skKihon.getSks();

        SortJT_Sk SortJTSk = SWAKInjector.getInstance(SortJT_Sk.class);

        skLst = SortJTSk.OrderJT_SkByPkDesc(skLst);

        return skLst;
    }

    public List<JT_SkJiyuu> getSkJiyuus(String pSkno, String pSyono, Integer pSeikyuurirekino) {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        JT_SkKihonDetacher.detachSkJiyuutouched(skKihon);

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(pSeikyuurirekino);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();

        return skJiyuuLst;
    }

    public List<JT_SiDetail> getSiDetails(String pSkno, String pSyono, Integer pSeikyuurirekino) {

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(pSkno, pSyono);

        JT_SkKihonDetacher.detachSiDetailtouched(skKihon);

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(pSeikyuurirekino);

        List<JT_SkJiyuu> skJiyuuLst = sk.getSkJiyuus();

        List<JT_SiDetail> siDetailLst = skJiyuuLst.get(0).getSiDetailsByKyhkg();

        return siDetailLst;
    }

    public IT_KykDairiten getKykDairiten(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykKihonDetacher.detachKykDairitentouched(kykKihon);

        IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(DRTENRENNO1);

        return kykDairiten;
    }

    public IT_KykSonotaTkyk getKykSonotaTkyk(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykKihonDetacher.detachKykSonotaTkyktouched(kykKihon);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        return kykSonotaTkyk;
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KykKihonDetacher.detachKykKihontouched(kykKihon);

        return kykKihon;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyohinCd, Integer pSyohinSedaiNo) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyohinCd, pSyohinSedaiNo);

        return syouhnZokusei;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager
            .getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkkbn);

        SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(svKiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        svKiykSyuhnDataList = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(svKiykSyuhnDataList);

        return svKiykSyuhnDataList;
    }
}
