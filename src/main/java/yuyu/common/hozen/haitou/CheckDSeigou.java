package yuyu.common.hozen.haitou;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.haitou.BaseDCommon;
import yuyu.common.hozen.haitou.DBAccessDCommon;
import yuyu.common.hozen.haitou.SetHokenNnd;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;

/**
 * 契約保全 配当 配当整合チェック
 */
public class CheckDSeigou extends BaseDCommon {

    private C_UmuKbn dHuseigouUmu;

    private C_UmuKbn kykMfHaitounendoHuseigouUmu;

    private C_UmuKbn haitoukanriTBLHuseigouUmu;

    private C_UmuKbn tumitateDkanriTBLHuseigouUmu;

    @Inject
    private static Logger logger;

    {
        regErrorInfo("001", "入力値エラー", "必須の入力項目にnullが含まれる");
    }

    public CheckDSeigou() {
        super();
    }

    public C_ErrorKbn exec(String pSyono, BizDateY pKykMfHaitounendo, BizDate pKykYmd,
        BizDate pYendtHnkYmd, BizDate pSyoriYmd) {

        logger.debug("▽ 配当整合チェック メイン処理 開始");

        init();

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (pSyono == null || pSyoriYmd == null) {

                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

                super.setErrorInfo("001");

                logger.debug("△ 配当整合チェック メイン処理 終了");

                return errorKbn;
            }

            if (BizDateUtil.compareYmd(pSyoriYmd, pKykYmd) == BizDateUtil.COMPARE_LESSER) {

                kykMfHaitounendoHuseigouUmu = C_UmuKbn.NONE;
                haitoukanriTBLHuseigouUmu = C_UmuKbn.NONE;
                tumitateDkanriTBLHuseigouUmu = C_UmuKbn.NONE;
                dHuseigouUmu = C_UmuKbn.NONE;

                C_ErrorKbn errorKbn = C_ErrorKbn.OK;

                logger.debug("△ 配当整合チェック メイン処理 終了");

                return errorKbn;
            }

            C_UmuKbn umuKbn = checkKykMfHaitounendo(pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

            if (umuKbn == null) {

                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 配当整合チェック メイン処理 終了");

                return errorKbn;
            }

            C_UmuKbn kykMfHaitounendoHsgUmu = umuKbn;

            umuKbn = checkHaitoukanriTBL(pSyono, pKykMfHaitounendo);

            if (umuKbn == null) {

                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 配当整合チェック メイン処理 終了");

                return errorKbn;
            }

            C_UmuKbn haitoukanriTblHsgUmu = umuKbn;

            umuKbn = checkTumitateDkanriTBL(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd);

            if (umuKbn == null) {

                C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 配当整合チェック メイン処理 終了");

                return errorKbn;
            }

            C_UmuKbn tumitateDkanriTblHsgUmu = umuKbn;

            kykMfHaitounendoHuseigouUmu = kykMfHaitounendoHsgUmu;
            haitoukanriTBLHuseigouUmu = haitoukanriTblHsgUmu;
            tumitateDkanriTBLHuseigouUmu = tumitateDkanriTblHsgUmu;

            if (C_UmuKbn.ARI.eq(kykMfHaitounendoHuseigouUmu) ||
                C_UmuKbn.ARI.eq(haitoukanriTBLHuseigouUmu) ||
                C_UmuKbn.ARI.eq(tumitateDkanriTBLHuseigouUmu)) {

                dHuseigouUmu = C_UmuKbn.ARI;
            }
            else {

                dHuseigouUmu = C_UmuKbn.NONE;
            }

            C_ErrorKbn errorKbn = C_ErrorKbn.OK;

            logger.debug("△ 配当整合チェック メイン処理 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public void init() {

        logger.debug("▽ 配当整合チェック 初期化処理 開始");

        super.clear();

        dHuseigouUmu = null;
        kykMfHaitounendoHuseigouUmu = null;
        haitoukanriTBLHuseigouUmu = null;
        tumitateDkanriTBLHuseigouUmu = null;

        logger.debug("△ 配当整合チェック 初期化処理 終了");
    }

    public C_UmuKbn checkKykMfHaitounendo(BizDateY pKykMfHaitounendo, BizDate pKykYmd, BizDate pYendtHnkYmd,
        BizDate pSyoriYmd) {

        logger.debug("▽ 配当整合チェック 契約MF配当年度不整合チェック 開始");

        BizDateY kykMfHaitounendo;

        if(pKykMfHaitounendo == null){
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            kykMfHaitounendo = setKessanNensibi.exec(pKykYmd).getBizDateY();
        } else {
            kykMfHaitounendo = pKykMfHaitounendo;
        }

        BizDate haitoushrKijyunYmd = null;

        if (pYendtHnkYmd == null) {

            haitoushrKijyunYmd = pKykYmd;
        }
        else {

            haitoushrKijyunYmd = pYendtHnkYmd;
        }

        SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);

        HokenNndBean hokenNndBean = setHokenNnd.exec(haitoushrKijyunYmd, pSyoriYmd);

        if (hokenNndBean == null) {

            super.setErrorLink(setHokenNnd);

            logger.debug("△ 配当整合チェック 契約MF配当年度不整合チェック 終了");

            return null;
        }

        BizDateY syoriYmdhaitouNendo = hokenNndBean.getHokenNnd();

        if (kykMfHaitounendo.compareTo(syoriYmdhaitouNendo) > 0) {

            logger.debug("△ 配当整合チェック 契約MF配当年度不整合チェック 終了");

            return C_UmuKbn.ARI;
        }

        logger.debug("△ 配当整合チェック 契約MF配当年度不整合チェック 終了");

        return C_UmuKbn.NONE;
    }

    public C_UmuKbn checkHaitoukanriTBL(String pSyono, BizDateY pKykMfHaitounendo) {

        logger.debug("▽ 配当整合チェック 配当管理TBLの不整合チェック 開始");

        DBAccessDCommon dbAccessDCommon = getInjectInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getSaisinHaitouKanriSyu(pSyono);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            super.setErrorLink(dbAccessDCommon);

            logger.debug("△ 配当整合チェック 配当管理TBLの不整合チェック 終了");

            return null;
        }

        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommon.getKhHaitouKanri();

        if (pKykMfHaitounendo == null) {

            if (khHaitouKanri != null) {

                logger.debug("△ 配当整合チェック 配当管理TBLの不整合チェック 終了");

                return C_UmuKbn.ARI;
            }

            logger.debug("△ 配当整合チェック 配当管理TBLの不整合チェック 終了");

            return C_UmuKbn.NONE;
        }

        if (khHaitouKanri == null) {

            logger.debug("△ 配当整合チェック 配当管理TBLの不整合チェック 終了");

            return C_UmuKbn.ARI;
        }

        logger.debug("△ 配当整合チェック 配当管理TBLの不整合チェック 終了");

        return C_UmuKbn.NONE;
    }

    public C_UmuKbn checkTumitateDkanriTBL(String pSyono, BizDateY pKykMfHaitounendo, BizDate pKykYmd,
        BizDate pYendtHnkYmd) {

        logger.debug("▽ 配当整合チェック 積立Ｄ管理TBLの不整合チェック 開始");

        DBAccessDCommon dbAccessDCommon = getInjectInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getSaisinTumitateDKanri(pSyono);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            super.setErrorLink(dbAccessDCommon);

            logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック 終了");

            return null;
        }

        IT_KhTumitateDKanri khTumitateDKanri = dbAccessDCommon.getKhTumitateDKanri();

        C_UmuKbn umuKbn = null;

        if (pYendtHnkYmd == null) {

            umuKbn = checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);
        }
        else {

            umuKbn = checkTumitateDkanriTBLYendtHnkGo(khTumitateDKanri);
        }

        logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック 終了");

        return umuKbn;
    }

    public C_UmuKbn checkTumitateDkanriTBLYendtHnkMae(BizDateY pKykMfHaitounendo, BizDate pKykYmd,
        IT_KhTumitateDKanri pKhTumitateDKanri) {

        logger.debug("▽ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 開始");

        SetHokenNnd setHokenNnd = getInjectInstance(SetHokenNnd.class);

        HokenNndBean hokenNndBean = setHokenNnd.exec(pKykYmd, pKykYmd);

        if (hokenNndBean == null) {

            super.setErrorLink(setHokenNnd);

            logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 終了");

            return null;
        }

        BizDateY kykYmdHaitouNendo = hokenNndBean.getHokenNnd();

        boolean seisikiWrateHssumi = true;

        BizDateY kykMfHaitounendo;

        if(pKykMfHaitounendo == null){
            kykMfHaitounendo = kykYmdHaitouNendo;
        } else {
            kykMfHaitounendo = pKykMfHaitounendo;
        }

        if (kykMfHaitounendo.compareTo(kykYmdHaitouNendo) >= 5) {

            seisikiWrateHssumi = true;
        }
        else {

            seisikiWrateHssumi = false;
        }

        if (seisikiWrateHssumi) {

            if (pKhTumitateDKanri == null) {

                logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 終了");

                return C_UmuKbn.ARI;
            }

            logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 終了");

            return C_UmuKbn.NONE;
        }

        if (pKhTumitateDKanri != null) {

            logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 終了");

            return C_UmuKbn.ARI;
        }

        logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更前 終了");

        return C_UmuKbn.NONE;
    }

    public C_UmuKbn checkTumitateDkanriTBLYendtHnkGo(IT_KhTumitateDKanri pKhTumitateDKanri) {

        logger.debug("▽ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更後 開始");

        if (pKhTumitateDKanri == null) {

            logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更後 終了");

            return C_UmuKbn.ARI;
        }

        logger.debug("△ 配当整合チェック 積立Ｄ管理TBLの不整合チェック円建変更後 終了");

        return C_UmuKbn.NONE;
    }

    public C_UmuKbn getDHuseigouUmu() {
        return dHuseigouUmu;
    }

    public C_UmuKbn getKykMfHaitounendoHuseigouUmu() {
        return kykMfHaitounendoHuseigouUmu;
    }

    public C_UmuKbn getHaitoukanriTBLHuseigouUmu() {
        return haitoukanriTBLHuseigouUmu;
    }

    public C_UmuKbn getTumitateDkanriTBLHuseigouUmu() {
        return tumitateDkanriTBLHuseigouUmu;
    }
}
