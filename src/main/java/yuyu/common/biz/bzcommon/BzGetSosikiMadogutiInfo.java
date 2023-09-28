package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.biz.detacher.BM_SosikiMadogutiDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SosikiMadoguti;

/**
 * 業務共通 共通 組織窓口情報取得
 */
public class BzGetSosikiMadogutiInfo {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzGetSosikiMadogutiInfo() {
        super();
    }

    public BzGetSosikiMadogutiInfoKekkaBean exec(String pSosikicd) {

        logger.debug("▽ 組織窓口情報取得 開始");

        BzGetSosikiMadogutiInfoKekkaBean getSosikiMadogutiInfoKekkaBean =
            SWAKInjector.getInstance(BzGetSosikiMadogutiInfoKekkaBean.class);

        if (BizUtil.isBlank(pSosikicd)) {
            getSosikiMadogutiInfoKekkaBean = null;
            logger.debug("△ 組織窓口情報取得 終了");

            return getSosikiMadogutiInfoKekkaBean;
        }

        BM_SosikiMadoguti sosikiMadoguti = bizDomManager.getSosikiMadoguti(pSosikicd);
        sosikiMadoguti = BM_SosikiMadogutiDetacher.detachSosikiMadogutitouched(sosikiMadoguti);

        if (sosikiMadoguti != null) {
            String sskmdkanjisosikinm;

            if (sosikiMadoguti.getSskmdkanjisosikinm() == null) {
                sskmdkanjisosikinm = "";
            }
            else {
                sskmdkanjisosikinm = sosikiMadoguti.getSskmdkanjisosikinm();
            }

            String sskmdsosikikbnnm;

            if (sosikiMadoguti.getSskmdsosikikbnnm() == null) {
                sskmdsosikikbnnm = "";
            }
            else {
                sskmdsosikikbnnm = sosikiMadoguti.getSskmdsosikikbnnm();
            }

            getSosikiMadogutiInfoKekkaBean.setKanjisosikinm(sskmdkanjisosikinm + sskmdsosikikbnnm);
            getSosikiMadogutiInfoKekkaBean.setHassoukbn(sosikiMadoguti.getSskmdhassoukbn().getValue());
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1(sosikiMadoguti.getSskmdkanjisosikiadr1());
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2(sosikiMadoguti.getSskmdkanjisosikiadr2());
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr3(sosikiMadoguti.getSskmdkanjisosikiadr3());
            getSosikiMadogutiInfoKekkaBean.setPostalCd(sosikiMadoguti.getSskmdpostalcd());
            getSosikiMadogutiInfoKekkaBean.setTelno(sosikiMadoguti.getSskmdtelno());
            getSosikiMadogutiInfoKekkaBean.setFaxno(sosikiMadoguti.getSskmdfaxno());
            getSosikiMadogutiInfoKekkaBean.setSisyaharaidasikznm(sosikiMadoguti.getSskmdsisyaharaidasikznm());
            getSosikiMadogutiInfoKekkaBean.setKouzanocd(sosikiMadoguti.getSskmdkouzanocd());
            getSosikiMadogutiInfoKekkaBean.setSisyaharaidasikouzano(sosikiMadoguti.getSskmdsisyaharaidasikouzano());
        }
        else {
            getSosikiMadogutiInfoKekkaBean.setKanjisosikinm("");
            getSosikiMadogutiInfoKekkaBean.setHassoukbn("");
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr1("");
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr2("");
            getSosikiMadogutiInfoKekkaBean.setKanjisosikiadr3("");
            getSosikiMadogutiInfoKekkaBean.setPostalCd("");
            getSosikiMadogutiInfoKekkaBean.setTelno("");
            getSosikiMadogutiInfoKekkaBean.setFaxno("");
            getSosikiMadogutiInfoKekkaBean.setSisyaharaidasikznm("");
            getSosikiMadogutiInfoKekkaBean.setKouzanocd("");
            getSosikiMadogutiInfoKekkaBean.setSisyaharaidasikouzano("");

        }

        logger.debug("△ 組織窓口情報取得 終了");

        return getSosikiMadogutiInfoKekkaBean;
    }
}
