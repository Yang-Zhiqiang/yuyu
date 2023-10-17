package yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin;

import static yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin.SkTokuteiKankeiHoujinConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;

/**
 * 特定関係法人照会 のビジネスロジックです。
 */
public class SkTokuteiKankeiHoujinBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkTokuteiKankeiHoujinUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKensakuKekkaHyoujiKbn(KENSAKUKEKKAHYOUJIKBN_HIHYOUJI);
    }

    void initSeniyou() {
        BizPropertyInitializer.initialize(uiBean);
        uiBean.setKensakuKekkaHyoujiKbn(KENSAKUKEKKAHYOUJIKBN_HYOUJI);

        uiBean.setSearchResults(null);

        String mosno = uiBean.getMosno();

        List<HT_MosDairiten> mosDairitenLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getMosDairitens();

        List<String> dairitenNmLst = Lists.newArrayList();
        List<String> kinyuuCdLst = Lists.newArrayList();
        List<HM_TokuteiKankeiHoujin> tkhjnKekkaLst = Lists.newArrayList();
        String tkhjnkinyuucd = BLANK;
        String oyadrtencd = BLANK;
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        for (HT_MosDairiten mosDairiten : mosDairitenLst) {

            if (!oyadrtencd.equals(mosDairiten.getOyadrtencd())) {

                oyadrtencd = mosDairiten.getOyadrtencd();
                HM_SkDairitenKobetuJyouhou skDairitenKobetuJyouhou =
                    sinkeiyakuDomManager.getSkDairitenKobetuJyouhou(oyadrtencd);

                if (skDairitenKobetuJyouhou != null && !BizUtil.isBlank(skDairitenKobetuJyouhou.getTkhjnkinyuucd())
                    && !skDairitenKobetuJyouhou.getTkhjnkinyuucd().equals(tkhjnkinyuucd)) {

                    List<BzGetAgInfoBean> dairitenInfoOutBeanLst = bzGetAgInfo.exec(mosDairiten.getOyadrtencd());

                    for (BzGetAgInfoBean bzGetAgInfoBean : dairitenInfoOutBeanLst) {
                        if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                            List<HM_TokuteiKankeiHoujin> tkhjnMstLst =
                                sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(
                                    skDairitenKobetuJyouhou.getTkhjnkinyuucd(), BLANK, BLANK);

                            dairitenNmLst.add(bzGetAgInfoBean.getKanjiDairitenNm());

                            kinyuuCdLst.add(skDairitenKobetuJyouhou.getTkhjnkinyuucd());

                            tkhjnKekkaLst.addAll(tkhjnMstLst);

                            if (BizUtil.isBlank(tkhjnkinyuucd)) {
                                tkhjnkinyuucd = skDairitenKobetuJyouhou.getTkhjnkinyuucd();
                            }
                        }
                    }
                }
            }
        }

        uiBean.setSrchtkhjnkinyuucd(tkhjnkinyuucd);

        if (kinyuuCdLst.size() != 0) {
            if (kinyuuCdLst.size() == 1) {
                uiBean.setDisptkhjnkinyuucd(kinyuuCdLst.get(0));
            }
            else if (kinyuuCdLst.size() == 2) {
                uiBean.setDisptkhjnkinyuucd(kinyuuCdLst.get(0) + TOUTEN + kinyuuCdLst.get(1));
            }
        }
        else {
            uiBean.setDisptkhjnkinyuucd(null);
        }

        if (dairitenNmLst.size() != 0) {
            if (dairitenNmLst.size() == 1) {
                uiBean.setDisptkhjnkjdrtennm(dairitenNmLst.get(0));
            }
            else if (dairitenNmLst.size() == 2) {
                uiBean.setDisptkhjnkjdrtennm(dairitenNmLst.get(0) + TOUTEN + dairitenNmLst.get(1));
            }
        }
        else {
            uiBean.setDisptkhjnkjdrtennm(null);
        }

        uiBean.setDisptkhjnnmkj(null);

        if (BizUtil.isBlank(tkhjnkinyuucd)) {
            messageManager.addMessageId(MessageId.IHA1005);
        }
        else if (tkhjnKekkaLst.size() == 0) {
            messageManager.addMessageId(MessageId.IHA0044, TOKUTEIKANKEIHOUJIN);
        }

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanLst = Lists.newArrayList();

        for (HM_TokuteiKankeiHoujin tokuteiKankeiHoujin : tkhjnKekkaLst) {
            SearchResultsDataSourceBean searchResultsDataSourceBean = new SearchResultsDataSourceBean();

            searchResultsDataSourceBean.setDisptkhjnkinyuucd(tokuteiKankeiHoujin.getTkhjnkinyuucd());
            searchResultsDataSourceBean.setDisptkhjnkjdrtennm(tokuteiKankeiHoujin.getTkhjnkjdrtennm());
            searchResultsDataSourceBean.setDisptkhjnnmkj(tokuteiKankeiHoujin.getTkhjnnmkj());

            searchResultsDataSourceBeanLst.add(searchResultsDataSourceBean);
        }

        uiBean.setSearchResults(searchResultsDataSourceBeanLst);
    }

    void doSearchBL() {

        uiBean.setKensakuKekkaHyoujiKbn(KENSAKUKEKKAHYOUJIKBN_HYOUJI);

        uiBean.setSearchResults(null);

        String kinyuuCd = uiBean.getSrchtkhjnkinyuucd();
        String dairitenNm = uiBean.getSrchtkhjnkjdrtennm();
        String tokuteiKankeiHoujinNm = uiBean.getSrchtkhjnnmkj();

        if (BizUtil.isBlank(kinyuuCd) && BizUtil.isBlank(dairitenNm) && BizUtil.isBlank(tokuteiKankeiHoujinNm)) {
            throw new BizLogicException(MessageId.EHA0101);
        }

        uiBean.setKensakuKekkaHyoujiKbn(KENSAKUKEKKAHYOUJIKBN_HYOUJI);

        List<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinMasterLst =
            sinkeiyakuDomManager.getTokuteiKankeiHoujinsByTkhjnkinyuucdTkhjnkjdrtennmTkhjnnmkj(
                kinyuuCd, dairitenNm, tokuteiKankeiHoujinNm);

        uiBean.setDisptkhjnkinyuucd(kinyuuCd);
        uiBean.setDisptkhjnkjdrtennm(dairitenNm);
        uiBean.setDisptkhjnnmkj(tokuteiKankeiHoujinNm);

        if (tokuteiKankeiHoujinMasterLst.size() == 0) {
            messageManager.addMessageId(MessageId.IHA0044, TOKUTEIKANKEIHOUJIN);
        }

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanLst = Lists.newArrayList();

        for (HM_TokuteiKankeiHoujin tokuteiKankeiHoujin : tokuteiKankeiHoujinMasterLst) {
            SearchResultsDataSourceBean searchResultsDataSourceBean = new SearchResultsDataSourceBean();

            searchResultsDataSourceBean.setDisptkhjnkinyuucd(tokuteiKankeiHoujin.getTkhjnkinyuucd());
            searchResultsDataSourceBean.setDisptkhjnkjdrtennm(tokuteiKankeiHoujin.getTkhjnkjdrtennm());
            searchResultsDataSourceBean.setDisptkhjnnmkj(tokuteiKankeiHoujin.getTkhjnnmkj());

            searchResultsDataSourceBeanLst.add(searchResultsDataSourceBean);

        }
        uiBean.setSearchResults(searchResultsDataSourceBeanLst);
    }
}
