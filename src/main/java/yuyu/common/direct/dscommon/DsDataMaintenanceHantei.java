package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_DsDataMaintenanceRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳデータメンテナンス中判定
 */
public class DsDataMaintenanceHantei {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsDataMaintenanceHantei(){
        super();
    }

    public DsDataMaintenanceHanteiBean exec(String pSyoNo) {

        logger.debug("▽ ＤＳデータメンテナンス中判定 開始");

        DsDataMaintenanceHanteiBean dsDataMaintenanceHanteiBean = SWAKInjector.getInstance(DsDataMaintenanceHanteiBean.class);
        dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.OK);
        dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.NONE);
        dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.BLNK);

        C_UmuKbn zennouUmuKbn = C_UmuKbn.NONE;
        BizDate sysDate = BizDate.getSysDate();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {
            dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);

            logger.debug("△ ＤＳデータメンテナンス中判定 終了");

            return dsDataMaintenanceHanteiBean;
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnList == null || kykSyouhnList.size() == 0) {
            dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);

            logger.debug("△ ＤＳデータメンテナンス中判定 終了");

            return dsDataMaintenanceHanteiBean;
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

        if (ansyuKihon == null) {
            dsDataMaintenanceHanteiBean.setKekkaKbn(C_ErrorKbn.ERROR);

            logger.debug("△ ＤＳデータメンテナンス中判定 終了");

            return dsDataMaintenanceHanteiBean;
        }

        List<IT_Zennou> zennouList = ansyuKihon.getZennous();

        if (zennouList != null &&
            zennouList.size() != 0 &&
            C_Kykjyoutai.ZENNOU.eq(kykSyouhnList.get(0).getKykjyoutai())) {
            zennouUmuKbn = C_UmuKbn.ARI;
        }

        int syouhinHanteiKbn = SyouhinUtil.hantei(kykSyouhnList.get(0).getSyouhncd());

        if (syouhinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            syouhinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            BizDate jkipjytymOutouYmd = BizDate.valueOf(ansyuKihon.getJkipjytym(), kykSyouhnList.get(0).getKykymd().getDay()).getRekijyou();

            if (C_UmuKbn.ARI.eq(zennouUmuKbn) &&
                (BizDateUtil.compareYmd(sysDate, jkipjytymOutouYmd) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(sysDate, jkipjytymOutouYmd) == BizDateUtil.COMPARE_EQUAL)) {
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.ZENNOUJYUUTOUSYORITYUU);

                logger.debug("△ ＤＳデータメンテナンス中判定 終了");

                return dsDataMaintenanceHanteiBean;
            }
        }

        if ((syouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  ||
            syouhinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) &&
            kykSyouhnList.get(0).getYendthnkymd() == null){

            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(pSyoNo);
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(sysDate);
            hanteiTmttknJyoutaiBean.setKykymd(kykSyouhnList.get(0).getKykymd());

            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

            if (!result) {
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
                dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.TUMITATEKINMIHANEI);

                logger.debug("△ ＤＳデータメンテナンス中判定 終了");

                return dsDataMaintenanceHanteiBean;
            }
        }

        if (BizDateUtil.compareYmd(sysDate, kykSyouhnList.get(0).getKouryokuhasseiymd()) == BizDateUtil.COMPARE_LESSER) {
            dsDataMaintenanceHanteiBean.setDsDataMaintenanceUmuKbn(C_UmuKbn.ARI);
            dsDataMaintenanceHanteiBean.setDsDataMaintenanceRiyuuKbn(C_DsDataMaintenanceRiyuuKbn.KOURYOKUHASSEIYMDMITOURAI);

            logger.debug("△ ＤＳデータメンテナンス中判定 終了");

            return dsDataMaintenanceHanteiBean;
        }

        logger.debug("△ ＤＳデータメンテナンス中判定 終了");

        return dsDataMaintenanceHanteiBean;
    }
}
