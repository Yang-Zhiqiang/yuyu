package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.JT_SiFBSoukinData;

/**
 * 業務共通 経理・会計 ＦＢ送金データ作成
 */
public class BzFbSoukinDataSks {

    private final String YUUCHOGINKOU = "9900";

    private final String SITENCODE_SITA1KETA = "8";

    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator unique;

    public BzFbSoukinDataSks() {
        super();
    }

    public HT_SkFBSoukinData execSk(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {

        logger.debug("▽ ＦＢ送金データ作成 開始");

        HT_SkFBSoukinData skFBSoukinData = new HT_SkFBSoukinData();

        editTbl(pBzFbSoukinDataSksBean, skFBSoukinData);

        if (skFBSoukinData.getFbsoukindatasikibetukey() == null) {

            skFBSoukinData = null;
        }

        else {

            BizPropertyInitializer.initialize(skFBSoukinData);
        }

        logger.debug("△ ＦＢ送金データ作成 終了");

        return skFBSoukinData;
    }

    public IT_KhFBSoukinData execKh(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {

        logger.debug("▽ ＦＢ送金データ作成 開始");

        IT_KhFBSoukinData khFBSoukinData = new IT_KhFBSoukinData();

        editTbl(pBzFbSoukinDataSksBean, khFBSoukinData);

        if (khFBSoukinData.getFbsoukindatasikibetukey() == null) {

            khFBSoukinData = null;
        }

        else {

            BizPropertyInitializer.initialize(khFBSoukinData);
        }

        logger.debug("△ ＦＢ送金データ作成 終了");

        return khFBSoukinData;
    }

    public JT_SiFBSoukinData execSi(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {

        logger.debug("▽ ＦＢ送金データ作成 開始");

        JT_SiFBSoukinData siFBSoukinData = new JT_SiFBSoukinData();

        editTbl(pBzFbSoukinDataSksBean, siFBSoukinData);

        if (siFBSoukinData.getFbsoukindatasikibetukey() == null) {

            siFBSoukinData = null;
        }

        else {

            BizPropertyInitializer.initialize(siFBSoukinData);
        }

        logger.debug("△ ＦＢ送金データ作成 終了");

        return siFBSoukinData;
    }

    // 2016/11/07 熊谷 年金削除対応
    //    public KT_NkFBSoukinData execNk(BzFbSoukinDataSksBean pBzFbSoukinDataSksBean) {
    //
    //        logger.debug("▽ ＦＢ送金データ作成 開始");
    //
    //        KT_NkFBSoukinData nkFBSoukinData = new KT_NkFBSoukinData();
    //
    //        editTbl(pBzFbSoukinDataSksBean, nkFBSoukinData);
    //
    //        if (nkFBSoukinData.getFbsoukindatasikibetukey() == null) {
    //
    //            nkFBSoukinData = null;
    //        }
    //
    //        else {
    //
    //            BizPropertyInitializer.initialize(nkFBSoukinData);
    //        }
    //
    //        logger.debug("△ ＦＢ送金データ作成 終了");
    //
    //        return nkFBSoukinData;
    //    }

    private void editTbl(
        BzFbSoukinDataSksBean pBzFbSoukinDataSksBean, FBSoukinDataParam pFBSoukinDataParam) {

        String syoriTime = BizDate.getSysDateTimeMilli();
        String fbSoukinDataSikibetuKey = unique.generateUniqueKey();

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        C_Gyoumucd gyoumuCd = bzGyoumuCdSyutoku.changeYkGyoumuCd(pBzFbSoukinDataSksBean.getDengyoumuCd());
        if (C_Gyoumucd.BLNK.eq(gyoumuCd)) {
            return;
        }

        pFBSoukinDataParam.setFbsoukindatasikibetukey(fbSoukinDataSikibetuKey);
        pFBSoukinDataParam.setDenrenno(pBzFbSoukinDataSksBean.getDenbyouyouDataRenbon());
        pFBSoukinDataParam.setEdano(pBzFbSoukinDataSksBean.getEdaNo());
        pFBSoukinDataParam.setDensyskbn(pBzFbSoukinDataSksBean.getDenSysKbn());
        pFBSoukinDataParam.setGyoumucd(gyoumuCd);
        pFBSoukinDataParam.setSyoricd(pBzFbSoukinDataSksBean.getSyoriCd());
        pFBSoukinDataParam.setSyorisosikicd(pBzFbSoukinDataSksBean.getSyoriSosikiCd());
        pFBSoukinDataParam.setSyoriYmd(pBzFbSoukinDataSksBean.getSyoriYmd());
        pFBSoukinDataParam.setDenymd(pBzFbSoukinDataSksBean.getDenYmd());
        pFBSoukinDataParam.setSyono(pBzFbSoukinDataSksBean.getSyoNo());
        pFBSoukinDataParam.setShrhousiteikbn(pBzFbSoukinDataSksBean.getShrHouSiteiKbn());
        pFBSoukinDataParam.setBankcd(pBzFbSoukinDataSksBean.getBankCd());

        String sSitenCd = pBzFbSoukinDataSksBean.getSitenCd();

        if (YUUCHOGINKOU.equals(pBzFbSoukinDataSksBean.getBankCd())) {

            pFBSoukinDataParam.setSitencd(sSitenCd.substring(0, 2).concat(SITENCODE_SITA1KETA));
        } else {

            pFBSoukinDataParam.setSitencd(sSitenCd);
        }

        pFBSoukinDataParam.setYokinkbn(pBzFbSoukinDataSksBean.getYokinKbn());
        pFBSoukinDataParam.setKouzano(pBzFbSoukinDataSksBean.getKouzaNo());
        pFBSoukinDataParam.setKzmeiginmkn(pBzFbSoukinDataSksBean.getKzMeigiNmKn());
        pFBSoukinDataParam.setSoukingk(pBzFbSoukinDataSksBean.getSouKingk());
        pFBSoukinDataParam.setKyktuukasyu(pBzFbSoukinDataSksBean.getKykTuukasyu());
        pFBSoukinDataParam.setGaikataikagk(pBzFbSoukinDataSksBean.getGaikaTaikagk());
        pFBSoukinDataParam.setSoukinkwsrate(pBzFbSoukinDataSksBean.getSoukinKwsRate());
        pFBSoukinDataParam.setGyoumuKousinKinou(pBzFbSoukinDataSksBean.getKinouId());
        pFBSoukinDataParam.setGyoumuKousinsyaId(pBzFbSoukinDataSksBean.getUserId());
        pFBSoukinDataParam.setGyoumuKousinTime(syoriTime);
    }
}
