package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 保全契約異動状態取得
 */
public class HozenKeiyakuIdouJyoutaiSyutoku {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    private C_YouhiKbn detachYouhiKbn = C_YouhiKbn.YOU;

    public HozenKeiyakuIdouJyoutaiSyutoku() {
        super();
    }

    public void setDetachYouhiKbn(C_YouhiKbn pDetachYouhiKbn) {
        detachYouhiKbn = pDetachYouhiKbn;
    }

    public HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutoku(String pSyoNo) {

        logger.debug("▽ 保全契約異動状態取得 開始");

        HozenKeiyakuIdouJyoutaiSyutokuBean hkijsBean = hozenKeiyakuIdouJyoutaiSyutokuCommon(pSyoNo, C_YouhiKbn.YOU);

        logger.debug("△ 保全契約異動状態取得 終了");

        return hkijsBean;
    }

    public HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuDSMikanyuu(String pSyoNo) {

        logger.debug("▽ 保全契約異動状態取得（ＤＳ未加入契約） 開始");

        HozenKeiyakuIdouJyoutaiSyutokuBean hkijsBean = hozenKeiyakuIdouJyoutaiSyutokuCommon(pSyoNo, C_YouhiKbn.HUYOU);

        logger.debug("△ 保全契約異動状態取得（ＤＳ未加入契約） 終了");

        return hkijsBean;
    }

    public C_YuukshantkekKbn keiyakuJyoutaiYuukouseiHantei(String pSyoNo) {

        logger.debug("▽ 保全契約状態有効性判定 開始");

        C_YuukshantkekKbn yuukouKbn = null;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (C_YouhiKbn.YOU.eq(detachYouhiKbn)) {
            kykKihon = IT_KykKihonDetacher.detachKykSyouhntouched(kykKihon);
        }

        if (kykKihon == null) {

            yuukouKbn = C_YuukshantkekKbn.ERROR;

            logger.debug("△ 保全契約状態有効性判定 終了");

            return yuukouKbn;
        }

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst.size() == 0) {

            yuukouKbn = C_YuukshantkekKbn.ERROR;
        }
        else {
            if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())) {

                yuukouKbn = C_YuukshantkekKbn.OK;
            }
            else {

                yuukouKbn = C_YuukshantkekKbn.NG;
            }
        }

        logger.debug("△ 保全契約状態有効性判定 終了");

        return yuukouKbn;
    }

    private HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuCommon(String pSyoNo, C_YouhiKbn pYouhiKbn) {

        HozenKeiyakuIdouJyoutaiSyutokuBean idouJyoutaiSyutokuBean =
            SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutokuBean.class);

        C_YuukshantkekKbn yuuksHantkekKbn = keiyakuJyoutaiYuukouseiHantei(pSyoNo);
        idouJyoutaiSyutokuBean.setYuukouKbn(yuuksHantkekKbn);

        if (C_YuukshantkekKbn.ERROR.eq(yuuksHantkekKbn)) {

            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);

            return idouJyoutaiSyutokuBean;
        }

        DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean dsKokyakuInfoBean =
            directDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(pSyoNo);
        boolean idouInfoHikakuFlg = true;

        if (dsKokyakuInfoBean == null) {
            if (C_YouhiKbn.YOU.eq(pYouhiKbn)) {

                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.ERROR);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);

                return idouJyoutaiSyutokuBean;
            }

            idouInfoHikakuFlg = false;
        }

        idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        idouJyoutaiSyutokuBean.setYotenSouiUmuKbn(C_UmuKbn.NONE);
        idouJyoutaiSyutokuBean.setMeigiHenkouUmuKbn(C_UmuKbn.NONE);
        idouJyoutaiSyutokuBean.setJuushoHenkouUmuKbn(C_UmuKbn.NONE);
        idouJyoutaiSyutokuBean.setSrMeigiHenkouUmuKbn(C_UmuKbn.NONE);
        idouJyoutaiSyutokuBean.setSrJuushoHenkouUmuKbn(C_UmuKbn.NONE);

        if (idouInfoHikakuFlg == true) {

            String dsKokyakuNmkj = dsKokyakuInfoBean.getDskokyakunmkj();
            String dsKokyakuNmkn = dsKokyakuInfoBean.getDskokyakunmkn();
            BizDate dsKokyakuSeiYmd = dsKokyakuInfoBean.getDskokyakuseiymd();
            String dsKokyakuYno = dsKokyakuInfoBean.getDskokyakuyno();
            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

            IT_KykSya kykSya = null;

            try {
                if (C_YouhiKbn.YOU.eq(detachYouhiKbn)) {
                    kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);
                }

                kykSya = kykKihon.getKykSya();
            }
            catch (EntityNotFoundException e) {
            }
            catch (NullPointerException e) {
            }

            if (kykKihon == null) {

                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.ERROR);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);

                return idouJyoutaiSyutokuBean;
            }

            if (kykSya == null) {

                idouJyoutaiSyutokuBean.setYuukouKbn(C_YuukshantkekKbn.ERROR);
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.ERROR);

                return idouJyoutaiSyutokuBean;
            }

            String hzKykNmkj = kykSya.getKyknmkj();
            String hzKykNmkn = kykSya.getKyknmkn();
            BizDate hzKykySeiYmd = kykSya.getKykseiymd();
            String hzKykYno = kykSya.getTsinyno();

            if (!dsKokyakuNmkj.equals(hzKykNmkj) ||
                !dsKokyakuNmkn.equals(hzKykNmkn) ||
                BizDateUtil.compareYmd(dsKokyakuSeiYmd, hzKykySeiYmd) != BizDateUtil.COMPARE_EQUAL) {

                idouJyoutaiSyutokuBean.setMeigiHenkouUmuKbn(C_UmuKbn.ARI);
            }

            if (!dsKokyakuYno.equals(hzKykYno)) {

                idouJyoutaiSyutokuBean.setJuushoHenkouUmuKbn(C_UmuKbn.ARI);
            }


            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setSyoNo(pSyoNo);
            bzGetProcessSummaryInBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutList.size() != 0) {

                if (bzGetProcessSummaryOutList.get(0).getJimuStartYmd() != null) {

                    idouJyoutaiSyutokuBean.setSrMeigiHenkouUmuKbn(C_UmuKbn.ARI);
                }
            }


            bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setSyoNo(pSyoNo);
            bzGetProcessSummaryInBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);

            bzGetProcessSummaryOutList = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutList.size() != 0) {

                if (bzGetProcessSummaryOutList.get(0).getJimuStartYmd() != null) {

                    idouJyoutaiSyutokuBean.setSrJuushoHenkouUmuKbn(C_UmuKbn.ARI);
                }
            }

            if (C_UmuKbn.ARI.eq(idouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn()) ||
                C_UmuKbn.ARI.eq(idouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn()) ||
                C_UmuKbn.ARI.eq(idouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn()) ||
                C_UmuKbn.ARI.eq(idouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn())) {

                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);
                idouJyoutaiSyutokuBean.setYotenSouiUmuKbn(C_UmuKbn.ARI);
            }
            else {
                idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
                idouJyoutaiSyutokuBean.setYotenSouiUmuKbn(C_UmuKbn.NONE);
            }
        }
        else {
            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setSyoNo(pSyoNo);
            bzGetProcessSummaryInBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutLst.size() != 0) {

                if (bzGetProcessSummaryOutLst.get(0).getJimuStartYmd() != null) {

                    idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);

                    return idouJyoutaiSyutokuBean;
                }
            }

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

            bzGetProcessSummaryInBean1.setJimuTetuzukiCd(IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU);
            bzGetProcessSummaryInBean1.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean1.setSyoNo(pSyoNo);
            bzGetProcessSummaryInBean1.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);

            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutLst1 = bzGetProcessSummary.exec(bzGetProcessSummaryInBean1);

            if (bzGetProcessSummaryOutLst1.size() != 0) {

                if (bzGetProcessSummaryOutLst1.get(0).getJimuStartYmd() != null) {

                    idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUTYUU);

                    return idouJyoutaiSyutokuBean;
                }
            }

            idouJyoutaiSyutokuBean.setIdoutyuuKbn(C_IdoutyuuHanteiKekkaKbn.IDOUNASHI);
        }
        return idouJyoutaiSyutokuBean;
    }

}
