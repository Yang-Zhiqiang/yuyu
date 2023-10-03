package yuyu.batch.suuri.srsuuritoukei.srdshrtoukei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 Ｄ支払統計情報作成
 */
public class SrDshrToukeiBatchDbAccess {

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrDshrToukeiDao srDshrToukeiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    public ExDBResults<IT_KhDshrTuki> getItKhDshrTuki(BizDate pZenkaidensimeymd, BizDate pKonkaidensimeymd) {

        ExDBResults<IT_KhDshrTuki> itKhDshrTukiLst = srDshrToukeiDao.getItKhDshrTuki(pZenkaidensimeymd,
            pKonkaidensimeymd);

        return itKhDshrTukiLst;
    }

    public ExDBResults<JT_SiDshrTuki> getJtSiDshrTuki(BizDate pZenkaidensimeymd, BizDate pKonkaidensimeymd) {

        ExDBResults<JT_SiDshrTuki> jtSiDshrTukiLst = srDshrToukeiDao.getJtSiDshrTuki(pZenkaidensimeymd,
            pKonkaidensimeymd);

        return jtSiDshrTukiLst;
    }

    public long getBikinKykHaitouMeisaiCount(String pSyono, BizDate pKessanKijyunYmd) {

        long bikinKykHaitouMeisaiCount = srDshrToukeiDao.getBikinKykHaitouMeisaiCount(pSyono, pKessanKijyunYmd);

        return bikinKykHaitouMeisaiCount;
    }

    public AS_Kinou getKinou(String pKinouId) {

        AS_Kinou kinou = baseDomManager.getKinou(pKinouId);

        return kinou;
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyoNo) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

        return ansyuKihon;
    }

    public List<SV_KiykSyuhnData> getKiykSyuhnDatas(String pSyoNo, C_SyutkKbn pSyutkKbn) {

        List<SV_KiykSyuhnData> kiykSyuhnDataList =
            suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyoNo, pSyutkKbn);

        kiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(kiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSV_KiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        kiykSyuhnDataList = sortSV_KiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(kiykSyuhnDataList);

        return kiykSyuhnDataList;
    }

}