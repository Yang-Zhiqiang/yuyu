package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金ＴＢＬ作成クラス
 */
public class BzGkfbSoukinDataSks {

    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator unique;

    public BzGkfbSoukinDataSks() {
        super();
    }

    public HT_SkGaikaFBSoukinData execSk(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {

        logger.debug("▽ 外貨ＦＢ送金データ作成 開始");

        HT_SkGaikaFBSoukinData skGaikaFBSoukinData = new HT_SkGaikaFBSoukinData();

        editTbl(pBzGkfbSoukinDataSksBean, skGaikaFBSoukinData);

        if (skGaikaFBSoukinData.getFbsoukindatasikibetukey() == null) {
            skGaikaFBSoukinData = null;
        }
        else {
            BizPropertyInitializer.initialize(skGaikaFBSoukinData);
        }

        logger.debug("△ 外貨ＦＢ送金データ作成 終了");

        return skGaikaFBSoukinData;
    }


    public IT_KhGaikaFBSoukinData execKh(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {

        logger.debug("▽ 外貨ＦＢ送金データ作成 開始");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = new IT_KhGaikaFBSoukinData();

        editTbl(pBzGkfbSoukinDataSksBean, khGaikaFBSoukinData);

        if (khGaikaFBSoukinData.getFbsoukindatasikibetukey() == null) {
            khGaikaFBSoukinData = null;
        }
        else {
            BizPropertyInitializer.initialize(khGaikaFBSoukinData);
        }

        logger.debug("△ 外貨ＦＢ送金データ作成 終了");

        return khGaikaFBSoukinData;
    }

    public JT_SiGaikaFBSoukinData execSi(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {

        logger.debug("▽ 外貨ＦＢ送金データ作成 開始");

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData = new JT_SiGaikaFBSoukinData();

        editTbl(pBzGkfbSoukinDataSksBean, siGaikaFBSoukinData);

        if (siGaikaFBSoukinData.getFbsoukindatasikibetukey() == null) {
            siGaikaFBSoukinData = null;
        }
        else {
            BizPropertyInitializer.initialize(siGaikaFBSoukinData);
        }

        logger.debug("△ 外貨ＦＢ送金データ作成 終了");

        return siGaikaFBSoukinData;
    }

    // 2016/11/07 熊谷 年金削除対応
    //    public KT_NkGaikaFBSoukinData execNk(BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean) {
    //
    //        logger.debug("▽ 外貨ＦＢ送金データ作成 開始");
    //
    //        KT_NkGaikaFBSoukinData nkGaikaFBSoukinData = new KT_NkGaikaFBSoukinData();
    //
    //        editTbl(pBzGkfbSoukinDataSksBean, nkGaikaFBSoukinData);
    //
    //        if (nkGaikaFBSoukinData.getFbsoukindatasikibetukey() == null) {
    //            nkGaikaFBSoukinData = null;
    //        }
    //        else {
    //            BizPropertyInitializer.initialize(nkGaikaFBSoukinData);
    //        }
    //
    //        logger.debug("△ 外貨ＦＢ送金データ作成 終了");
    //
    //        return nkGaikaFBSoukinData;
    //    }

    private void editTbl(
        BzGkfbSoukinDataSksBean pBzGkfbSoukinDataSksBean, GkFBSoukinDataParam pGkFBSoukinDataParam) {

        String syoriTime = BizDate.getSysDateTimeMilli();
        String fbSoukinDataSikibetuKey = unique.generateUniqueKey();

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Gkgyoumucd gkGyoumuCd = bzGyoumuCdSyutoku.changeGkGyoumuCd(pBzGkfbSoukinDataSksBean.getDengyoumuCd());
        if (C_Gkgyoumucd.BLNK.eq(gkGyoumuCd)) {
            return;
        }

        pGkFBSoukinDataParam.setFbsoukindatasikibetukey(fbSoukinDataSikibetuKey);
        pGkFBSoukinDataParam.setDenrenno(pBzGkfbSoukinDataSksBean.getDenRenno());
        pGkFBSoukinDataParam.setEdano(pBzGkfbSoukinDataSksBean.getEdaNo());
        pGkFBSoukinDataParam.setDensyskbn(pBzGkfbSoukinDataSksBean.getDenSysKbn());
        pGkFBSoukinDataParam.setGkgyoumucd(gkGyoumuCd);
        pGkFBSoukinDataParam.setSyoricd(pBzGkfbSoukinDataSksBean.getSyoriCd());
        pGkFBSoukinDataParam.setSyorisosikicd(pBzGkfbSoukinDataSksBean.getSyoriSosikiCd());
        pGkFBSoukinDataParam.setSyoriYmd(pBzGkfbSoukinDataSksBean.getSyoriYmd());
        pGkFBSoukinDataParam.setDenymd(pBzGkfbSoukinDataSksBean.getDenYmd());
        pGkFBSoukinDataParam.setSyono(pBzGkfbSoukinDataSksBean.getSyono());
        pGkFBSoukinDataParam.setShrhousiteikbn(pBzGkfbSoukinDataSksBean.getShrHouSiteiKbn());
        pGkFBSoukinDataParam.setBankcd(pBzGkfbSoukinDataSksBean.getBankCd());
        pGkFBSoukinDataParam.setBanknmej(pBzGkfbSoukinDataSksBean.getBankNmEj());
        pGkFBSoukinDataParam.setSitencd(pBzGkfbSoukinDataSksBean.getSitenCd());
        pGkFBSoukinDataParam.setSitennmej(pBzGkfbSoukinDataSksBean.getSitenNmEj());
        pGkFBSoukinDataParam.setKouzano(pBzGkfbSoukinDataSksBean.getKouzaNo());
        pGkFBSoukinDataParam.setKzmeiginmei(pBzGkfbSoukinDataSksBean.getKzMeigiNmEi());
        pGkFBSoukinDataParam.setShrtuukasyu(pBzGkfbSoukinDataSksBean.getShrTuukaSyu());
        pGkFBSoukinDataParam.setGaikashrgk(pBzGkfbSoukinDataSksBean.getGaikaShrgk());
        pGkFBSoukinDataParam.setKyktuukasyu(pBzGkfbSoukinDataSksBean.getKykTuukaSyu());
        pGkFBSoukinDataParam.setCrossrateshrgk(pBzGkfbSoukinDataSksBean.getCrossRateShrgk());
        pGkFBSoukinDataParam.setSoukinkwsrate(pBzGkfbSoukinDataSksBean.getSoukinKwsRate());
        pGkFBSoukinDataParam.setGyoumuKousinKinou(pBzGkfbSoukinDataSksBean.getKinouId());
        pGkFBSoukinDataParam.setGyoumuKousinsyaId(pBzGkfbSoukinDataSksBean.getUserId());
        pGkFBSoukinDataParam.setGyoumuKousinTime(syoriTime);
    }
}
