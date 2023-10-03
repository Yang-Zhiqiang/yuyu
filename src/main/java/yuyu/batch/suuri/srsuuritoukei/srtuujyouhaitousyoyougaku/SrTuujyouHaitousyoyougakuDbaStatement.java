package yuyu.batch.suuri.srsuuritoukei.srtuujyouhaitousyoyougaku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.hozen.detacher.IT_KhBikinkanriDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 通常配当所要額情報ＤＢＡ宣言
 */
public class SrTuujyouHaitousyoyougakuDbaStatement {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private BizDomManager bizDomManager;

    public ExDBResults<SV_TuujyuHitusyyugk> getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn syutkKbn,
        C_HaitouKbn haitouKbn, String pKbnkey) {

        ExDBResults<SV_TuujyuHitusyyugk> tuujyuHitusyyugkList = suuriDomManager
            .getTuujyuHitusyyugksBySyutkkbnHaitoukbn(syutkKbn, haitouKbn, pKbnkey);

        return tuujyuHitusyyugkList;

    }

    public List<IT_KykSyouhn> getKykSyouhnsBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkKbn) {

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(pSyono);

        itKykKihon = IT_KykKihonDetacher.detachKykSyouhntouched(itKykKihon);

        List<IT_KykSyouhn> itKykSyouhnList = itKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn);

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

    public IT_KhTtdkRireki getKhTtdkRirekiByHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(pSyono);

        itKykKihon = IT_KykKihonDetacher.detachKhTtdkRirekitouched(itKykKihon);

        IT_KhTtdkRireki khTtdkRireki = itKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);

        return khTtdkRireki;
    }

    public List<BizDate> getKeiyakuSyouhinjouhouView(String pSyono, String pHenkousikibetukey) {

        return suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmae(String pSyono) {

        return srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return bmSyouhnZokusei;
    }
}