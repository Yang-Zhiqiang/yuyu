package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BW_HtkinSikinIdouWk;

/**
 * 業務共通 経理・会計 経理配当金資金移動データ作成
 */
public class BzKrHtkinSikinIdouDataSks {

    private static final String MONTH_MARCH_LASTDAY = "0331";

    private static final String GONENMEOUTOUBIKBN_SEISIKIWARIATE = "1";

    @Inject
    private static Logger logger;

    public BzKrHtkinSikinIdouDataSks() {
        super();
    }

    public BW_HtkinSikinIdouWk exec(HtkinSikinIdouDataBean pHtkinSikinIdouDataBean) {

        logger.debug("▽ 経理配当金資金移動データ作成 開始");

        BW_HtkinSikinIdouWk htkinSikinIdouWk = null;

        Boolean hanteiKekka = hanteiHtkinSikinIdou(pHtkinSikinIdouDataBean);

        if (hanteiKekka) {

            htkinSikinIdouWk = new BW_HtkinSikinIdouWk(
                pHtkinSikinIdouDataBean.getSyono(),
                pHtkinSikinIdouDataBean.getKijyunymd());

            htkinSikinIdouWk.setHaitounendo(pHtkinSikinIdouDataBean.getKijyunymd().getBizDateY());
            htkinSikinIdouWk.setKyktuukasyu(pHtkinSikinIdouDataBean.getKyktuukasyu());
            htkinSikinIdouWk.setSeisikiwariategaku(pHtkinSikinIdouDataBean.getYuukoutyuusyoyougaku());
            htkinSikinIdouWk.setSeg1cd(pHtkinSikinIdouDataBean.getSeg1cd());
            htkinSikinIdouWk.setSikinidoukawaserate(pHtkinSikinIdouDataBean.getKawaserate());

            BizPropertyInitializer.initialize(htkinSikinIdouWk);
        }

        logger.debug("△ 経理配当金資金移動データ作成 終了");

        return htkinSikinIdouWk;
    }

    private Boolean hanteiHtkinSikinIdou(HtkinSikinIdouDataBean pHtkinSikinIdouDataBean) {

        Boolean hanteiKekka = false;

        List<String> htkinSikinIdouDataTrkTsyJobcdList =
            YuyuBizConfig.getInstance().getHtkinSikinIdouDataTrkTsyJobcdList();

        String kijyunMd = pHtkinSikinIdouDataBean.getKijyunymd().getBizDateMD().toString();

        if (MONTH_MARCH_LASTDAY.equals(kijyunMd)
            && htkinSikinIdouDataTrkTsyJobcdList.contains(pHtkinSikinIdouDataBean.getKakutyoujobcd())
            && !C_Tuukasyu.JPY.eq(pHtkinSikinIdouDataBean.getKyktuukasyu())
            && !C_Tuukasyu.BLNK.eq(pHtkinSikinIdouDataBean.getKyktuukasyu())
            && GONENMEOUTOUBIKBN_SEISIKIWARIATE.equals(pHtkinSikinIdouDataBean.getGonenmeoutoubikbn())
            && pHtkinSikinIdouDataBean.getYuukoutyuusyoyougaku().compareTo(BizCurrency.valueOf(0)) > 0) {

            hanteiKekka = true;
        }

        return hanteiKekka;
    }
}