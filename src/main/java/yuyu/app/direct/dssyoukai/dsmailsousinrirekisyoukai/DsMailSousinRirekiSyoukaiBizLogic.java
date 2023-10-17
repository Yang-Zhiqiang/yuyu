package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai;

import static yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.DsMailSousinRirekiSyoukaiConstants.*;
import static yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.GenDsMailSousinRirekiSyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai.dba.DsMailSousinRirekiSyoukaiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_SpiralMailSousinErrCd;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MV_DsMailSosinRirekiSyoukai;
import yuyu.def.direct.manager.DirectDomManager;

import com.google.common.collect.Lists;

/**
 * ＤＳメール送信履歴照会 のビジネスロジックです。
 */
public class DsMailSousinRirekiSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private DsMailSousinRirekiSyoukaiUiBean uiBean;

    @Inject
    private DsMailSousinRirekiSyoukaiDao dsMailSousinRirekiSyoukaiDao;

    @Inject
    private MessageManager messageManager;

    @Inject
    private DirectDomManager directDomManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);

        uiBean.setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn.BLNK);
    }

    void clear() {
    }

    void pushSearchBtnbyInputkeySelectBL() {

        uiBean.setSearchResultInfo(null);

        messageManager.removeConversationMessage(DS_MAIL_SOUSIN_RIREKI_SYOUKAI);

        if (BizUtil.isBlank(uiBean.getSrchdskokno()) &&
            BizUtil.isBlank(uiBean.getSrchsyono()) &&
            uiBean.getDsgaitoukokyakukensaku() == false &&
            BizUtil.isBlank(uiBean.getSrchdssousinno()) &&
            C_DsSousinMailSyubetuKbn.BLNK.eq(uiBean.getDssousinmailsyubetukbn()) &&
            uiBean.getSousinymdfrom() == null &&
            uiBean.getSousinymdto() == null) {
            throw new BizLogicException(MessageId.EMC1005);
        }

        if (!BizUtil.isBlank(uiBean.getSrchdssousinno())) {
            if (!BizUtil.isBlank(uiBean.getSrchdskokno()) ||
                !BizUtil.isBlank(uiBean.getSrchsyono()) ||
                uiBean.getDsgaitoukokyakukensaku() == true ||
                !C_DsSousinMailSyubetuKbn.BLNK.eq(uiBean.getDssousinmailsyubetukbn()) ||
                uiBean.getSousinymdfrom() != null ||
                uiBean.getSousinymdto() != null) {
                throw new BizLogicException(MessageId.EMC1001, new Item[] { DDID_SEARCHJYOUKENINFO_SRCHDSKOKNO,
                    DDID_SEARCHJYOUKENINFO_SRCHSYONO, DDID_SEARCHJYOUKENINFO_DSSOUSINMAILSYUBETUKBN,
                    DDID_SEARCHJYOUKENINFO_SOUSINYMDFROM, DDID_SEARCHJYOUKENINFO_SOUSINYMDTO },
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SRCHDSSOUSINNO.getErrorResourceKey()), "その他検索条件");
            }
        }
        if (!BizUtil.isBlank(uiBean.getSrchdskokno())) {
            if(!BizUtil.isBlank(uiBean.getSrchsyono())){
                throw new BizLogicException(MessageId.EMC1001, new Item[] { DDID_SEARCHJYOUKENINFO_SRCHSYONO },
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SRCHDSKOKNO.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SRCHSYONO.getErrorResourceKey()));
            }

            if (uiBean.getDsgaitoukokyakukensaku() == true) {
                throw new BizLogicException(MessageId.EMC1001,
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SRCHDSKOKNO.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_DSGAITOUKOKYAKUKENSAKU.getErrorResourceKey()));
            }
        }
        if (uiBean.getDsgaitoukokyakukensaku() == true) {
            if (BizUtil.isBlank(uiBean.getSrchsyono())) {
                throw new BizLogicException(MessageId.EMC1006, new Item[] { DDID_SEARCHJYOUKENINFO_SRCHSYONO },
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_DSGAITOUKOKYAKUKENSAKU.getErrorResourceKey()));
            }
        }

        if (uiBean.getSousinymdfrom() != null && uiBean.getSousinymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSousinymdfrom(), uiBean.getSousinymdto()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EAC0005,
                    new Item[] { DDID_SEARCHJYOUKENINFO_SOUSINYMDFROM, DDID_SEARCHJYOUKENINFO_SOUSINYMDTO },
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SOUSINYMDFROM.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SEARCHJYOUKENINFO_SOUSINYMDTO.getErrorResourceKey()));
            }
        }

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();
        DsMailSousinRirekiKensakuBean dsMailSousinRirekiKensakuBean = new DsMailSousinRirekiKensakuBean();

        if (uiBean.getDsgaitoukokyakukensaku() == true) {
            List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = directDomManager.getDsKokyakuKeiyakusBySyono(uiBean.getSrchsyono());

            if (dsKokyakuKeiyakuList.size() != 0) {
                dsMailSousinRirekiKensakuBean.setDsKokNo(dsKokyakuKeiyakuList.get(0).getDskokno());
                dsMailSousinRirekiKensakuBean.setSyoNo("");
                dsMailSousinRirekiKensakuBean.setDsSousinNo("");
                dsMailSousinRirekiKensakuBean.setDsSousinMailSyubetuKbn(uiBean.getDssousinmailsyubetukbn());
                if (uiBean.getSousinymdfrom() == null) {
                    dsMailSousinRirekiKensakuBean.setSousinYmdFrom(BizDate.valueOf(19000101));
                }
                else {
                    dsMailSousinRirekiKensakuBean.setSousinYmdFrom(uiBean.getSousinymdfrom());
                }

                if (uiBean.getSousinymdto() == null) {
                    dsMailSousinRirekiKensakuBean.setSousinYmdTo(BizDate.valueOf(21991231));
                }
                else {
                    dsMailSousinRirekiKensakuBean.setSousinYmdTo(uiBean.getSousinymdto());
                }

                dsMailSousinRirekiKensakuBean.setKensakuResultMaxKensuu(searchResultMaxCnt + 1);
            }
            else {
                dsMailSousinRirekiKensakuBean = null;
            }
        }
        else {
            dsMailSousinRirekiKensakuBean.setDsKokNo(uiBean.getSrchdskokno());
            dsMailSousinRirekiKensakuBean.setSyoNo(uiBean.getSrchsyono());
            dsMailSousinRirekiKensakuBean.setDsSousinNo(uiBean.getSrchdssousinno());
            dsMailSousinRirekiKensakuBean.setDsSousinMailSyubetuKbn(uiBean.getDssousinmailsyubetukbn());
            if (uiBean.getSousinymdfrom() == null) {
                dsMailSousinRirekiKensakuBean.setSousinYmdFrom(BizDate.valueOf(19000101));
            }
            else {
                dsMailSousinRirekiKensakuBean.setSousinYmdFrom(uiBean.getSousinymdfrom());
            }

            if (uiBean.getSousinymdto() == null) {
                dsMailSousinRirekiKensakuBean.setSousinYmdTo(BizDate.valueOf(21991231));
            }
            else{
                dsMailSousinRirekiKensakuBean.setSousinYmdTo(uiBean.getSousinymdto());
            }

            dsMailSousinRirekiKensakuBean.setKensakuResultMaxKensuu(searchResultMaxCnt + 1);
        }

        List<MV_DsMailSosinRirekiSyoukai> dsMailSosinRirekiSyoukaiList = Lists.newArrayList();

        if (dsMailSousinRirekiKensakuBean != null) {
            dsMailSosinRirekiSyoukaiList = dsMailSousinRirekiSyoukaiDao
                .getDsMailSosinRirekiSyoukaiByDsMailSosinRirekiKensaku(dsMailSousinRirekiKensakuBean);
        }

        if (dsMailSosinRirekiSyoukaiList.size() == 0) {
            messageManager.addMessageId(MessageId.IAC0023);

            return;
        }
        if (dsMailSosinRirekiSyoukaiList.size() > searchResultMaxCnt) {
            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));
        }

        List<SearchResultInfoDataSourceBean> searchResultInfoDataSourceBeanList = Lists.newArrayList();

        for (MV_DsMailSosinRirekiSyoukai dsMailSosinRirekiSyoukai : dsMailSosinRirekiSyoukaiList) {
            SearchResultInfoDataSourceBean searchResultInfoDataSourceBean =
                SWAKInjector.getInstance(SearchResultInfoDataSourceBean.class);

            searchResultInfoDataSourceBean.setDsdatasakuseiymd(dsMailSosinRirekiSyoukai.getDsdatasakuseiymd());
            searchResultInfoDataSourceBean.setDskokno(dsMailSosinRirekiSyoukai.getDskokno());
            searchResultInfoDataSourceBean.setSyono(dsMailSosinRirekiSyoukai.getSyono());
            searchResultInfoDataSourceBean.setDssousinmailsyubetukbn(dsMailSosinRirekiSyoukai.getDssousinmailsyubetukbn());
            searchResultInfoDataSourceBean.setHaisinjidsmailaddress(dsMailSosinRirekiSyoukai.getHaisinjidsmailaddress());
            searchResultInfoDataSourceBean.setDssousinno(dsMailSosinRirekiSyoukai.getDssousinno());
            searchResultInfoDataSourceBean.setHaisinerrorcount(getHaisinerrorcount(dsMailSosinRirekiSyoukai.getHaisinerrorcount()));

            searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);
        }

        if (searchResultInfoDataSourceBeanList.size() > searchResultMaxCnt) {
            searchResultInfoDataSourceBeanList.remove(searchResultMaxCnt);
        }

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);
    }


    private String getHaisinerrorcount(String pHaisinerrorcount) {
        String hanyakuTukiHaisinerrorcount = "";

        if (!BizUtil.isBlank(pHaisinerrorcount)) {
            hanyakuTukiHaisinerrorcount = pHaisinerrorcount
                + " "
                + C_SpiralMailSousinErrCd.getContentByValue(C_SpiralMailSousinErrCd.PATTERN_BUNRUIHENKAN,
                    pHaisinerrorcount.substring(pHaisinerrorcount.length() - 5, pHaisinerrorcount.length()));
        }

        return hanyakuTukiHaisinerrorcount;
    }
}
