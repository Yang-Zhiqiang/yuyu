package yuyu.batch.suuri.srsuuritoukei.srrisanomituujyouhaitousyoyougaku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
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
 * 利差のみ通常配当所要額情報ＤＢＡ宣言
 */
public class SrRisanomiTuujyouHaitousyoyougakuDbaStatement {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_RisanomiTuujyuHitusyyugk> getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(
        C_SyutkKbn syutkKbn,
        C_HaitouKbn haitouKbn,
        String kbnkey) {

        ExDBResults<SV_RisanomiTuujyuHitusyyugk> riSanomiTuujyuHitusyyugkList = suuriDomManager
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(syutkKbn, haitouKbn, kbnkey);

        return riSanomiTuujyuHitusyyugkList;

    }

    public List<IT_KykSyouhn> getKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkKbn) {

        return srCommonKinouDao.getKykSyouhns(pSyono, pSyutkKbn);
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

    public HoyuuKhTtdkRirekiByPkBean getKhTtdkRireki(String pSyono, String pHenkousikibetukey) {

        return hozenDomManager.getHoyuuKhTtdkRirekiByPk(pSyono, pHenkousikibetukey);

    }

    public List<BM_SjkkkTyouseiyouRiritu> getSjkkkTyouseiyouRiritusByPK(String pSyouhnCd, C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknNenKbn, BizDate pKykfromYmd, BizDate pKyktoYmd) {

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusByPK(
            pSyouhnCd, pTuukasyu, pHhknNenKbn, pKykfromYmd, pKyktoYmd);
        return sjkkkTyouseiyouRirituLst;

    }

    public List<BizDate> getKeiyakuSyouhinjouhouView(String pSyono, String pHenkousikibetukey) {

        return suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaesList(String pSyono){
        return srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknListAsc(String pSyono, BizDate pKijyunymd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttkns(String pSyono, BizDateYM pKijyunYm) {

        return srCommonKinouDao.getHokenryouTmttkns(pSyono, pKijyunYm);
    }

    public List<IT_KhHaitouKanri> getKhHaitouKanriKakutei(String pSyono, BizDateY pHaitounendo) {

        return srCommonKinouDao.getKhHaitouKanriKakutei(pSyono, pHaitounendo);
    }
}