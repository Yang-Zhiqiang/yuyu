package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.KykDairitenByPkBean;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KhBikinkanriDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.siharai.detacher.JT_SiBikinkanriDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理統計 数理統計 異動明細情報作成のＤＢアクセスクラス
 */
public class SrIdouMeisaiBatchDbAccess {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrIdouMeisaiDao idouMeisaiDao;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_IdouMeisai> getIdouMeisaisBySyoriYmdSyutkkbn(BizDate pZenkaidensimeymd, BizDate pKonkaidensimeymd, C_SyutkKbn pSyutkkbn) {

        return idouMeisaiDao.getIdouMeisaisBySyoriYmdSyutkkbn(pZenkaidensimeymd, pKonkaidensimeymd, pSyutkkbn);
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisBySyonoHenkousikibetukey(String pSyono, String pKey) {
        return IT_KhBikinkanriDetacher.detachKhBikinkanritouched(hozenDomManager.
            getKhBikinkanrisBySyonoHenkousikibetukey(pSyono, pKey));
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoBknjkukbn(String pSyono) {
        return JT_SiBikinkanriDetacher.detachSiBikinkanritouched(
            siharaiDomManager.getSiBikinkanrisBySyonoBknjkukbn(pSyono));
    }

    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoSkno(String pSyono, String pSkno) {
        return JT_SiBikinkanriDetacher.detachSiBikinkanritouched(siharaiDomManager.
            getSiBikinkanrisBySyonoSkno(pSyono, pSkno));
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnData(String pSyno, C_SyutkKbn pCSyutkKbn) {

        List<SV_KiykSyuhnData> sVKiykSyuhnDataLst =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyno, pCSyutkKbn);

        sVKiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(sVKiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        return sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(sVKiykSyuhnDataLst);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhincd, Integer pSyouhnsdno) {

        BM_SyouhnZokusei bMSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhincd, pSyouhnsdno);

        return bMSyouhnZokusei;
    }

    public AS_Kinou getKinou(String pKinouId) {

        return baseDomManager.getKinou(pKinouId);
    }

    public IT_NyknJissekiRireki getNyknJissekiRireki(
        String pSyno, BizDateYM pJyutoustartym, Integer pRenno) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyno);

        return kykKihon.getNyknJissekiRirekiByJyutoustartymRenno(pJyutoustartym, pRenno);
    }

    public List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftKykhenkoYmdList(
        String pSyono, String pHenkousikibetukey) {

        return hozenDomManager.getTargetTokuyakuBefaAftKykhenkoYmdList(pSyono, pHenkousikibetukey);
    }

    public KykDairitenByPkBean getKykDairitenByPk(String pSyono, Integer pDrtenrenno) {

        return srCommonKinouDao.getKykDairitenByPk(pSyono, pDrtenrenno);
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunymd) {

        return srCommonKinouDao.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaes(String pSyono) {

        return srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);
    }

    public BT_DenpyoData getDenpyoDataDenYmd(String pSyono, BizDate pSyoriYmd) {

        return idouMeisaiDao.getDenpyoDataDenYmd(pSyono, pSyoriYmd);
    }

    public BT_DenpyoData getDenpyoDataDenYenkagk(String pSyono, BizDate pSyoriYmd) {

        return idouMeisaiDao.getDenpyoDataDenYenkagk(pSyono, pSyoriYmd);
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekis(String pSyono, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return idouMeisaiDao.getKhTtdkRirekis(pSyono, pSyoriYmdFrom, pSyoriYmdTo);
    }

    public List<IT_KykSyouhn> getKykSyouhns(String pSyono, C_SyutkKbn pSyutkKbn) {

        return srCommonKinouDao.getKykSyouhns(pSyono, pSyutkKbn);
    }

    public ExDBResults<SV_IdouMeisai> getIdouMeisaiSokyuukikannai(String pSyono, C_SyutkKbn pSyutkkbn,
        BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pHenkousikibetukey) {

        return idouMeisaiDao.getIdouMeisaiSokyuukikannai(pSyono, pSyutkkbn, pSyoriYmdFrom, pSyoriYmdTo, pHenkousikibetukey);
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getKhHenkouRirekis(String pSyono,
        String pHenkousikibetukey, String pTableid, String pHenkoukoumokuid) {

        return srCommonKinouDao.getKhHenkouRirekis(pSyono, pHenkousikibetukey, pTableid, pHenkoukoumokuid);
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttkns(String pSyono,
        BizDateYM pTmttkntaisyouym) {

        return srCommonKinouDao.getHokenryouTmttkns(pSyono, pTmttkntaisyouym);
    }

    public IT_Azukarikin getAzukarikin(String pSyono,
        String pHenkousikibetukey,C_Tuukasyu pTuukasyu) {

        return srCommonKinouDao.getAzukarikin(pSyono, pHenkousikibetukey, pTuukasyu);
    }

    public IT_PMinyuuSyoumetuInfo getPMinyuuSyoumetuInfo(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon.getPMinyuuSyoumetuInfo();
    }

    public ExDBResults<SV_IdouMeisai> getIdouMeisaisSokyuugengaku(String pSyono, C_SyutkKbn pSyutkkbn,
        String pHenkousikibetukey) {

        return idouMeisaiDao.getIdouMeisaisSokyuugengaku(pSyono, pSyutkkbn, pHenkousikibetukey);
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono) {

        return srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList(pSyono);
    }

}