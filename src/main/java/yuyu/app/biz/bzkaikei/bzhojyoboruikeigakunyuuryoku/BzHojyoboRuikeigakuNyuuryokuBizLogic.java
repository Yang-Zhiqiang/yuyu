package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import static yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.BzHojyoboRuikeigakuNyuuryokuConstants.*;
import static yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku.GenBzHojyoboRuikeigakuNyuuryokuConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.exception.CoreRuntimeException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import yuyu.def.db.entity.BV_HjybruikeigakuData;

import com.google.common.collect.Lists;

/**
 * 補助簿累計額入力 のビジネスロジックです。
 */
public class BzHojyoboRuikeigakuNyuuryokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzHojyoboRuikeigakuNyuuryokuUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzHojyoboRuikeigakuNyuuryokuDao bzHojyoboRuikeigakuNyuuryokuDao;

    void init() {
        BizPropertyInitializer.initialize(uiBean);

        boolean updateKanouFlg = false;

        BizDate sysDate = BizDate.getSysDate();
        BizDateY sysDateY = sysDate.getBizDateY();
        BizDateYM sysDateYM = sysDate.getBizDateYM();
        BizDateYM wkDateYm4 = BizDateYM.valueOf(sysDateY, Integer.valueOf(SYORI_MONTH4));
        BizDateYM wkDateYm5 = BizDateYM.valueOf(sysDateY, Integer.valueOf(SYORI_MONTH5));

        if ((BizDateUtil.compareYm(sysDateYM, wkDateYm4) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(sysDateYM, wkDateYm4) == BizDateUtil.COMPARE_GREATER) &&
            (BizDateUtil.compareYm(sysDateYM, wkDateYm5) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(sysDateYM, wkDateYm5) == BizDateUtil.COMPARE_LESSER)) {

            BM_DensimeNenkanSchedule densimeNenkanSchedule = bizDomManager.getDensimeNenkanSchedule(wkDateYm4);

            BizDate densimeymd4 = densimeNenkanSchedule.getZengetudensimeymd().addBusinessDays(1);
            densimeNenkanSchedule = bizDomManager.getDensimeNenkanSchedule(wkDateYm5);

            BizDate densimeymd5 = densimeNenkanSchedule.getZengetudensimeymd();

            if ((BizDateUtil.compareYmd(sysDate, densimeymd4) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(sysDate, densimeymd4) == BizDateUtil.COMPARE_GREATER) &&
                (BizDateUtil.compareYmd(sysDate, densimeymd5) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(sysDate, densimeymd5) == BizDateUtil.COMPARE_LESSER)) {
                updateKanouFlg = true;
            }
        }

        uiBean.setUpdateKanouFlg(updateKanouFlg);

        List<BV_HjybruikeigakuData> hjybruikeigakuDataLst = bzHojyoboRuikeigakuNyuuryokuDao.getHjybruikeigakuDataByHjybtantositucd(baseUserInfo.getTmSosikiCd().substring(0, 3));
        List<HojyoboRuikeigakuInfoListDataSourceBean> hojyoboRuikeigakuInfoList = Lists.newArrayList();
        String teiseiLink = MessageUtil.getMessage(DDID_HOJYOBORUIKEIGAKUINFOLIST_TEISEILINK.getErrorResourceKey());
        for (BV_HjybruikeigakuData hjybruikeigakuData : hjybruikeigakuDataLst) {
            if(hjybruikeigakuData.getKarikataruigk() != null && hjybruikeigakuData.getHjybruigkteiseiumukbn().eq(C_UmuKbn.NONE)) {
                continue;
            }

            HojyoboRuikeigakuInfoListDataSourceBean dataSourceBean = new HojyoboRuikeigakuInfoListDataSourceBean();

            BM_KanjyouKamoku kanjyouKamoku = bizDomManager.getKanjyouKamoku(hjybruikeigakuData.getKanjyoukmkcd());
            dataSourceBean.setSyukanjokamokucd(hjybruikeigakuData.getKanjyoukmkcd().getValue());
            dataSourceBean.setKanjyoukmknm(kanjyouKamoku.getKanjyoukmknm());
            dataSourceBean.setTeiseilink(teiseiLink);

            if (hjybruikeigakuData.getKarikataruigk() != null) {
                dataSourceBean.setKarikataruigk(hjybruikeigakuData.getKarikataruigk());
            }
            else {
                dataSourceBean.setKarikataruigk(BizCurrency.optional());
            }

            if (hjybruikeigakuData.getKasikataruigk() != null) {
                dataSourceBean.setKasikataruigk(hjybruikeigakuData.getKasikataruigk());
            }
            else {
                dataSourceBean.setKasikataruigk(BizCurrency.optional());
            }

            if (hjybruikeigakuData.getKarikatateiseigk() != null) {
                dataSourceBean.setKarikatateiseigk(hjybruikeigakuData.getKarikatateiseigk());
            }
            else {
                dataSourceBean.setKarikatateiseigk(BizCurrency.optional());
            }

            if (hjybruikeigakuData.getKasikatateiseigk() != null) {
                dataSourceBean.setKasikatateiseigk(hjybruikeigakuData.getKasikatateiseigk());
            }
            else {
                dataSourceBean.setKasikatateiseigk(BizCurrency.optional());
            }

            hojyoboRuikeigakuInfoList.add(dataSourceBean);

        }

        uiBean.setHojyoboRuikeigakuInfoList(hojyoboRuikeigakuInfoList);

        messageManager.addMessageId(MessageId.IBF1008);
    }

    void clear() {
    }

    void pushSinkiTourokuBL() {

        uiBean.setInputGamenMod(SINKI_TOUROKU);
        uiBean.setDispkarikataruigk(HYPHEN);
        uiBean.setInputkarikatateiseigk(HYPHEN);
        uiBean.setDispkasikataruigk(ZERO_YEN);
        uiBean.setInputkasikatateiseigk(ZERO_YEN);
        uiBean.setSakujyoBtnDispFlg(false);
    }

    void pushTeiseiBL() {

        HojyoboRuikeigakuInfoListDataSourceBean dataSourceBean =
            uiBean.getHojyoboRuikeigakuInfoListDataSource().getSelectedBean();

        uiBean.setInputGamenMod(TEISEI);
        uiBean.setUpdateKanjyoukmkCd(dataSourceBean.getSyukanjokamokucd());
        uiBean.setDispkanjyoukamoku(
            dataSourceBean.getSyukanjokamokucd() + ZENKAKU_BLANK + dataSourceBean.getKanjyoukmknm());
        uiBean.setInputkanjyoukamoku(dataSourceBean.getSyukanjokamokucd());

        if (dataSourceBean.getKarikataruigk().isOptional()) {
            uiBean.setDispkarikataruigk(HYPHEN);
        } else {
            uiBean.setDispkarikataruigk(
                ViewReport.editCommaTuuka(dataSourceBean.getKarikataruigk(), BizUtil.ZERO_FILL));
        }

        if (dataSourceBean.getKasikataruigk().isOptional()) {
            uiBean.setInputkarikatateiseigk(HYPHEN);
        } else {
            uiBean.setInputkarikatateiseigk(
                ViewReport.editCommaTuuka(dataSourceBean.getKasikataruigk(), BizUtil.ZERO_FILL));
        }

        if (dataSourceBean.getKarikatateiseigk().isOptional()) {
            uiBean.setDispkasikataruigk(dataSourceBean.getKarikataruigk());
        }
        else {
            uiBean.setDispkasikataruigk(dataSourceBean.getKarikatateiseigk());
        }

        if (dataSourceBean.getKasikatateiseigk().isOptional()) {
            uiBean.setInputkasikatateiseigk(dataSourceBean.getKasikataruigk());
        }
        else {
            uiBean.setInputkasikatateiseigk(dataSourceBean.getKasikatateiseigk());
        }

        if (dataSourceBean.getKarikatateiseigk().isOptional() &&
            dataSourceBean.getKasikatateiseigk().isOptional()) {
            uiBean.setSakujyoBtnDispFlg(false);
        }
        else {
            uiBean.setSakujyoBtnDispFlg(true);
        }
    }

    void pushKakuninBL() {

        if (uiBean.getDispkasikataruigk().isOptional()) {
            throw new BizLogicException(MessageId.EBF1022,new Item[]{DDID_INPUTDATAINFO_DISPKASIKATARUIGK});
        }

        if (uiBean.getInputkasikatateiseigk().isOptional()) {
            throw new BizLogicException(MessageId.EBF1023,new Item[]{DDID_INPUTDATAINFO_INPUTKASIKATATEISEIGK});
        }

        if (SINKI_TOUROKU.equals(uiBean.getInputGamenMod())) {
            try {
                C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.valueOf(uiBean.getInputkanjyoukamoku());

                BM_KanjyouKamoku  kanjyouKamoku = bizDomManager.getKanjyouKamoku(kanjyoukmkcd);

                if (kanjyouKamoku == null) {
                    throw new BizLogicException(MessageId.EBF1024,new Item[]{DDID_INPUTDATAINFO_INPUTKANJYOUKAMOKU});
                }

                BV_HjybruikeigakuData hjybruikeigakuData =
                    bizDomManager.getHjybruikeigakuData(baseUserInfo.getTmSosikiCd().substring(0, 3), kanjyoukmkcd);
                if (hjybruikeigakuData != null && hjybruikeigakuData.getDenym() != null) {
                    throw new BizLogicException(MessageId.EBF1025,new Item[]{DDID_INPUTDATAINFO_INPUTKANJYOUKAMOKU});
                }

                if (hjybruikeigakuData != null &&
                    ((hjybruikeigakuData.getKarikatateiseigk() != null &&
                    !hjybruikeigakuData.getKarikatateiseigk().isOptional()) ||
                    (hjybruikeigakuData.getKasikatateiseigk() != null &&
                    !hjybruikeigakuData.getKasikatateiseigk().isOptional()))) {
                    throw new BizLogicException(MessageId.EBF1026,new Item[]{DDID_INPUTDATAINFO_INPUTKANJYOUKAMOKU});
                }

                uiBean.setDispkanjyoukamoku(
                    uiBean.getInputkanjyoukamoku() + ZENKAKU_BLANK + kanjyouKamoku.getKanjyoukmknm());
                uiBean.setUpdateKanjyoukmkCd(uiBean.getInputkanjyoukamoku());
            } catch (CoreRuntimeException e) {
                throw new BizLogicException(MessageId.EBF1024,new Item[]{DDID_INPUTDATAINFO_INPUTKANJYOUKAMOKU});
            }
        }

        uiBean.setDeleteFlg(false);
        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushTeiseigksakujyoBL() {

        BV_HjybruikeigakuData hjybruikeigakuData =
            bizDomManager.getHjybruikeigakuData(baseUserInfo.getTmSosikiCd().substring(0, 3),
                C_Kanjyoukmkcd.valueOf(uiBean.getInputkanjyoukamoku()));
        uiBean.setDispkasikataruigk(hjybruikeigakuData.getKarikatateiseigk());
        uiBean.setInputkasikatateiseigk(hjybruikeigakuData.getKasikatateiseigk());
        uiBean.setDeleteFlg(true);
        messageManager.addMessageId(MessageId.QBF1001);

    }

    @Transactional
    void pushKakuteiBL () {
        BT_HjybruikeigakuTeisei hjybruikeigakuTeisei = bizDomManager.getHjybruikeigakuTeisei(
            baseUserInfo.getTmSosikiCd().substring(0, 3), C_Kanjyoukmkcd.valueOf(uiBean.getUpdateKanjyoukmkCd()));
        if (!uiBean.getDeleteFlg()) {
            if (hjybruikeigakuTeisei != null) {
                hjybruikeigakuTeisei.setKarikatateiseigk(uiBean.getDispkasikataruigk());
                hjybruikeigakuTeisei.setKasikatateiseigk(uiBean.getInputkasikatateiseigk());

                bizDomManager.update(hjybruikeigakuTeisei);
            }
            else {
                hjybruikeigakuTeisei = new BT_HjybruikeigakuTeisei();
                hjybruikeigakuTeisei.setHjybruigkteiseitantositucd(baseUserInfo.getTmSosikiCd().substring(0,3));
                hjybruikeigakuTeisei.setKanjyoukmkcd(C_Kanjyoukmkcd.valueOf(uiBean.getUpdateKanjyoukmkCd()));
                hjybruikeigakuTeisei.setKarikatateiseigk(uiBean.getDispkasikataruigk());
                hjybruikeigakuTeisei.setKasikatateiseigk(uiBean.getInputkasikatateiseigk());
                BizPropertyInitializer.initialize(hjybruikeigakuTeisei);
                bizDomManager.insert(hjybruikeigakuTeisei);
            }
        }
        else {
            bizDomManager.delete(hjybruikeigakuTeisei);
        }
        messageManager.addMessageId(MessageId.IAC0009);

    }
}
