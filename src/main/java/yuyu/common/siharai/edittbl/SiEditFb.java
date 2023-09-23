package yuyu.common.siharai.edittbl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金ＦＢ送金データTBL編集クラス
 */
public class SiEditFb {
    @Inject
    private static Logger logger;
    @Inject
    BaseUserInfo baseUserInfo;
    @Inject
    private AS_Kinou kinou;


    public SiEditFbOutBean exec(SiEditFbInBean pSiEditFbInBean) {
        logger.debug("▽ 保険金給付金ＦＢ送金データテーブル編集 開始");
        if (pSiEditFbInBean.getShrhouSiteiKbn() == null) {
            throw new BizAppException(MessageId.EJS1005, "shrhouSiteiKbn");
        }
        if (pSiEditFbInBean.getBankCd() == null) {
            throw new BizAppException(MessageId.EJS1005, "bankCd");
        }
        if (pSiEditFbInBean.getSitenCd() == null) {
            throw new BizAppException(MessageId.EJS1005, "sitenCd");
        }
        if (pSiEditFbInBean.getYokinKbn() == null) {
            throw new BizAppException(MessageId.EJS1005, "yokinKbn");
        }
        if (pSiEditFbInBean.getKouzaNo() == null) {
            throw new BizAppException(MessageId.EJS1005, "kouzaNo");
        }
        if (pSiEditFbInBean.getKykTuukasyu() == null) {
            throw new BizAppException(MessageId.EJS1005, "kykTuukasyu");
        }
        if (pSiEditFbInBean.getSoukinKwsRate() == null) {
            throw new BizAppException(MessageId.EJS1005, "soukinKwsRate");
        }
        if (pSiEditFbInBean.getFbSokinEdaBangou() == null) {
            throw new BizAppException(MessageId.EJS1005, "fbSokinEdaBangou");
        }
        if (pSiEditFbInBean.getSiDenpyoDataLst() == null) {
            throw new BizAppException(MessageId.EJS1005, "siDenpyoDataLst");
        }
        SiEditFbOutBean siEditFbOutBean = SWAKInjector.getInstance(SiEditFbOutBean.class);
        JT_SiDenpyoData siDenpyoData = null;
        for (JT_SiDenpyoData siDenpyoDataTemp : pSiEditFbInBean.getSiDenpyoDataLst()) {
            if (siDenpyoDataTemp.getEdano().equals(pSiEditFbInBean.getFbSokinEdaBangou())) {
                siDenpyoData = siDenpyoDataTemp;
            }
        }
        if (siDenpyoData == null) {
        }
        else {
            if (C_Tuukasyu.JPY.eq(siDenpyoData.getTuukasyu())) {
                BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
                bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(siDenpyoData.getDenrenno());
                bzFbSoukinDataSksBean.setEdaNo(siDenpyoData.getEdano());
                bzFbSoukinDataSksBean.setDenSysKbn(siDenpyoData.getDensyskbn());
                bzFbSoukinDataSksBean.setSyoriCd(siDenpyoData.getSyoricd());
                bzFbSoukinDataSksBean.setSyoriSosikiCd(siDenpyoData.getSyorisosikicd());
                bzFbSoukinDataSksBean.setSyoriYmd(siDenpyoData.getSyoriYmd());
                bzFbSoukinDataSksBean.setDenYmd(siDenpyoData.getDenymd());
                bzFbSoukinDataSksBean.setSyoNo(siDenpyoData.getSyono());
                bzFbSoukinDataSksBean.setShrHouSiteiKbn(pSiEditFbInBean.getShrhouSiteiKbn());
                bzFbSoukinDataSksBean.setBankCd(pSiEditFbInBean.getBankCd());
                bzFbSoukinDataSksBean.setSitenCd(pSiEditFbInBean.getSitenCd());
                bzFbSoukinDataSksBean.setYokinKbn(pSiEditFbInBean.getYokinKbn());
                bzFbSoukinDataSksBean.setKouzaNo(pSiEditFbInBean.getKouzaNo());
                bzFbSoukinDataSksBean.setKzMeigiNmKn(pSiEditFbInBean.getKzMeiginmKn());
                bzFbSoukinDataSksBean.setSouKingk(pSiEditFbInBean.getSoukinGk());
                bzFbSoukinDataSksBean.setKykTuukasyu(pSiEditFbInBean.getKykTuukasyu());
                bzFbSoukinDataSksBean.setGaikaTaikagk(pSiEditFbInBean.getGaikaTaikaGk());
                bzFbSoukinDataSksBean.setSoukinKwsRate(pSiEditFbInBean.getSoukinKwsRate());
                bzFbSoukinDataSksBean.setKinouId(kinou.getKinouId());
                bzFbSoukinDataSksBean.setUserId(baseUserInfo.getUserId());
                bzFbSoukinDataSksBean.setDengyoumuCd(siDenpyoData.getDengyoumucd());

                JT_SiFBSoukinData siFBSoukinData = bzFbSoukinDataSks.execSi(bzFbSoukinDataSksBean);

                if (siFBSoukinData != null) {
                    List<JT_SiFBSoukinData> siFBSoukinDataLst = new ArrayList<>();
                    siFBSoukinDataLst.add(siFBSoukinData);

                    siEditFbOutBean.setSiFBSoukinDataLst(siFBSoukinDataLst);
                }
            }
            else {
                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pSiEditFbInBean.getBankCd(),
                    pSiEditFbInBean.getSitenCd(), BizDate.getSysDate());
                C_BankmasterUmuKbn bankmasterUmuKbn = bzGetBankDataBean.getBankmasterUmuKbn();
                if (C_UmuKbn.NONE.getValue().equals(bankmasterUmuKbn.getValue())) {
                    throw new BizAppException("EBS0005", "BM_Ginkou", "bankcd", pSiEditFbInBean.getBankCd(), "sitencd",
                        pSiEditFbInBean.getSitenCd());
                }
                BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
                BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean = SWAKInjector
                    .getInstance(BzGkfbSoukinDataSksBean.class);

                bzGkfbSoukinDataSksBean.setDenRenno(siDenpyoData.getDenrenno());
                bzGkfbSoukinDataSksBean.setEdaNo(siDenpyoData.getEdano());
                bzGkfbSoukinDataSksBean.setDenSysKbn(siDenpyoData.getDensyskbn());
                bzGkfbSoukinDataSksBean.setSyoriCd(siDenpyoData.getSyoricd());
                bzGkfbSoukinDataSksBean.setSyoriSosikiCd(siDenpyoData.getSyorisosikicd());
                bzGkfbSoukinDataSksBean.setSyoriYmd(siDenpyoData.getSyoriYmd());
                bzGkfbSoukinDataSksBean.setDenYmd(siDenpyoData.getDenymd());
                bzGkfbSoukinDataSksBean.setSyono(siDenpyoData.getSyono());
                bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(pSiEditFbInBean.getShrhouSiteiKbn());
                bzGkfbSoukinDataSksBean.setBankCd(pSiEditFbInBean.getBankCd());
                bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
                bzGkfbSoukinDataSksBean.setSitenCd(pSiEditFbInBean.getSitenCd());
                bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
                bzGkfbSoukinDataSksBean.setKouzaNo(pSiEditFbInBean.getKouzaNo());
                bzGkfbSoukinDataSksBean.setKzMeigiNmEi(pSiEditFbInBean.getKzMeiginmei());
                bzGkfbSoukinDataSksBean.setShrTuukaSyu(pSiEditFbInBean.getShrTuukaSyu());
                bzGkfbSoukinDataSksBean.setGaikaShrgk(pSiEditFbInBean.getGaikaShrgk());
                bzGkfbSoukinDataSksBean.setKykTuukaSyu(pSiEditFbInBean.getKykTuukasyu());
                bzGkfbSoukinDataSksBean.setCrossRateShrgk(pSiEditFbInBean.getCrossRateShrgk());
                bzGkfbSoukinDataSksBean.setSoukinKwsRate(pSiEditFbInBean.getSoukinKwsRate());
                bzGkfbSoukinDataSksBean.setKinouId(kinou.getKinouId());
                bzGkfbSoukinDataSksBean.setUserId(baseUserInfo.getUserId());
                bzGkfbSoukinDataSksBean.setDengyoumuCd(siDenpyoData.getDengyoumucd());

                JT_SiGaikaFBSoukinData siGaikaFBSoukinData = bzGkfbSoukinDataSks.execSi(bzGkfbSoukinDataSksBean);

                if (siGaikaFBSoukinData != null) {
                    List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = new ArrayList<>();
                    siGaikaFBSoukinDataLst.add(siGaikaFBSoukinData);
                    siEditFbOutBean.setSiGaikaFBSoukinDataLst(siGaikaFBSoukinDataLst);
                }
            }
        }
        logger.debug("△ 保険金給付金ＦＢ送金データテーブル編集 終了");
        return siEditFbOutBean;
    }
}
