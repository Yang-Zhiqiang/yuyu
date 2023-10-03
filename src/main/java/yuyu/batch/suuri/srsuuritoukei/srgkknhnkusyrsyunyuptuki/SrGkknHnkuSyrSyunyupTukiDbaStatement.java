package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.suuri.detacher.SV_KiykSyuhnDataDetacher;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.sorter.SortSV_KiykSyuhnData;

/**
 * 数理 数理統計 月間変更処理収入Ｐ統計情報作成のＤＢアクセスクラス
 */
public class SrGkknHnkuSyrSyunyupTukiDbaStatement {

    private static final int DRTENRENNO = 1;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    public ExDBResults<BT_DenpyoData> getDenpyoDatasHnkuNyukinPBySyoriYmd(BizDate pSyoriFrom, BizDate pSyoriTo) {

        return srGkknHnkuSyrSyunyupTukiDao.getDenpyoDatasHnkuNyukinPBySyoriYmd(pSyoriFrom, pSyoriTo);
    }

    public IT_KhShrRireki getKhShrRireki(String pSyono, BizDate pSiharaiSyoriYmd, String pDenpyoNo) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKhShrRirekitouched(kykKihon);

        IT_KhShrRireki khShrRireki = null;

        List<IT_KhTtdkRireki> khTtdkRirekiList = kykKihon.getKhTtdkRirekis();

        if ((khTtdkRirekiList != null) && (khTtdkRirekiList.size() > 0)) {
            for (IT_KhTtdkRireki khTtdkRireki : khTtdkRirekiList) {
                khShrRireki = khTtdkRireki.getKhShrRirekiByShrsyoriymdDenrenno(pSiharaiSyoriYmd, pDenpyoNo);

                if (khShrRireki != null) {
                    return khShrRireki;
                }
            }
        }

        return khShrRireki;

    }

    public IT_KhTtdkRireki getKhTtdkRireki(String pSyono, String pHenkousikibetukey) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKhTtdkRirekitouched(kykKihon);

        return kykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRireki(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachNyknJissekiRirekitouched(kykKihon);

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon.getNyknJissekiRirekis();

        SortIT_NyknJissekiRireki sortIT_NyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);
        return sortIT_NyknJissekiRireki.OrderIT_NyknJissekiRirekiByRyosyuymdRennoAsc(nyknJissekiRirekiList);
    }

    public IT_KykDairiten getKykDairiten(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykDairitentouched(kykKihon);

        return kykKihon.getKykDairitenByDrtenrenno(DRTENRENNO);
    }

    public IT_KykSonotaTkyk getKykSonotaTkyk(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykSonotaTkyktouched(kykKihon);

        return kykKihon.getKykSonotaTkyk();
    }

    public IT_KykSya getKykSya(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);

        return kykKihon.getKykSya();
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return IT_KykKihonDetacher.detachKykKihontouched(kykKihon);
    }


    public List<SV_KiykSyuhnData> getKiykSyuhnData(String pSyono, C_SyutkKbn pSyutkkbn) {

        List<SV_KiykSyuhnData> svKiykSyuhnDataList = suuriDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(
            pSyono,
            pSyutkkbn);

        svKiykSyuhnDataList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(svKiykSyuhnDataList);

        SortSV_KiykSyuhnData sortSVKiykSyuhnData = SWAKInjector.getInstance(SortSV_KiykSyuhnData.class);

        svKiykSyuhnDataList = sortSVKiykSyuhnData.OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(svKiykSyuhnDataList);

        return svKiykSyuhnDataList;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhinCd, Integer pSyouhnsdNo) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhinCd, pSyouhnsdNo);

        return syouhnZokusei;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunymd) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao
            .getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunymd);

        return khSisuurendoTmttknLst;
    }

    public List<IT_KykSyouhn> getKykSyouhns(String pSyono, C_SyutkKbn pSyutkKbn) {

        return srCommonKinouDao.getKykSyouhns(pSyono, pSyutkKbn);
    }

    public IT_KihrkmpSeisanRireki getKihrkmpSeisanRireki(
        String pSyono,
        String pHenkousikibetukey,
        C_KiharaiPseisanNaiyouKbn pKiharaiPseisanNaiyouKbn) {

        return srGkknHnkuSyrSyunyupTukiDao.getKihrkmpSeisanRireki(pSyono, pHenkousikibetukey, pKiharaiPseisanNaiyouKbn);
    }

    public JT_SiKekka getSiKekkaBySyono(String pSyono) {

        return srGkknHnkuSyrSyunyupTukiDao.getSiKekkaBySyono(pSyono);
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoNnykdenno(String pSyono, String pNykdenno) {

        return srCommonKinouDao.getNyknJissekiRirekisBySyonoNnykdenno(pSyono, pNykdenno);
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoNyktrksdenno(String pSyono, String pNyktrksdenno) {

        return srGkknHnkuSyrSyunyupTukiDao.getNyknJissekiRirekisBySyonoNyktrksdenno(pSyono, pNyktrksdenno);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        return srCommonKinouDao.getAnsyuKihon(pSyono);
    }

    public IT_Zennou getZennou(String pSyono, BizDate pZennoukaisiymd, Integer pRenno) {

        return srGkknHnkuSyrSyunyupTukiDao.getZennou(pSyono, pZennoukaisiymd, pRenno);
    }

    public ExDBResults<IT_NyknJissekiRireki> getNyknJissekiRirekisByNyksyoriymdNykkeiro(
        BizDate pHyksyoriymdfrom, BizDate pHyksyoriymdto, C_Nykkeiro pNykkeiro, Integer pRenNo) {

        return srGkknHnkuSyrSyunyupTukiDao.getNyknJissekiRirekisByNyksyoriymdNykkeiro(
            pHyksyoriymdfrom, pHyksyoriymdto, pNykkeiro, pRenNo);
    }

    public BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd) {

        return bizDomManager.getTantouCd(pTantocd);
    }

    public AS_Kinou getKinou(String pKinouId) {

        return baseDomManager.getKinou(pKinouId);
    }

    public List<JT_Sk> getSks(String Skno, String pSyono) {

        return srGkknHnkuSyrSyunyupTukiDao.getSks(Skno, pSyono);
    }

    public List<JT_SkKihon> getSkKihons(String pSyono, C_SeikyuuSyubetu pSeikyuuSyubetu) {

        return srGkknHnkuSyrSyunyupTukiDao.getSkKihons(pSyono, pSeikyuuSyubetu);
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekis(
        String pSyono,
        BizDate pSyoriYmd,
        String pGyoumuKousinKinou) {

        return srGkknHnkuSyrSyunyupTukiDao.getKhTtdkRirekis(pSyono, pSyoriYmd, pGyoumuKousinKinou);
    }

}