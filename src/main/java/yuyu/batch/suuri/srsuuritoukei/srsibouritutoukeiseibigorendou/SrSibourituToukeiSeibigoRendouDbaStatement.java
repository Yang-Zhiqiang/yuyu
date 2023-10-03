package yuyu.batch.suuri.srsuuritoukei.srsibouritutoukeiseibigorendou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 死亡率統計整備後連動情報作成ＤＢＡ宣言
 */
public class SrSibourituToukeiSeibigoRendouDbaStatement {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public ExDBResults<SV_SibourituToukeiSeibigo> getSibourituToukeiSeibigoInfo(BizDate pSyoriYmdFrm,
        BizDate pSyoriYmdTo, C_SyutkKbn pSyutkKbn) {

        SrSibourituToukeiSeibigoRendouDao srSibourituToukeiSeibigoRendouDao = SWAKInjector
            .getInstance(SrSibourituToukeiSeibigoRendouDao.class);

        ExDBResults<SV_SibourituToukeiSeibigo> sibourituToukeiSeibigoLst = srSibourituToukeiSeibigoRendouDao
            .getSibourituToukeiSeibigosBySyoriYmdSyutkkbn(pSyoriYmdFrm, pSyoriYmdTo, pSyutkKbn);

        return sibourituToukeiSeibigoLst;
    }

    public List<SV_KiykSyuhnData> getKeiyakuSyouhinInfo(String pSyono, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(
            pSyono, pSyutkKbn);

        kiykSyuhnDataLst = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataLst);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        return sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataLst);
    }

    public BM_SyouhnZokusei getSyouhnZokuseiMst(String pSyouhncd, Integer pSyouhnSdNo) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnSdNo);

        return syouhnZokusei;
    }

    public AS_Kinou getKinou(String pKinouId) {

        AS_Kinou asKinou = baseDomManager.getKinou(pKinouId);

        return asKinou;
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaes(String pSyono) {

        List<IT_KykSyouhnHnkmae> kykSyouhnHnkmaeList = srCommonKinouDao.getKykSyouhnHnkmaes(pSyono);

        return kykSyouhnHnkmaeList;
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return IT_KykKihonDetacher.detachKykKihontouched(kykKihon);
    }

}
