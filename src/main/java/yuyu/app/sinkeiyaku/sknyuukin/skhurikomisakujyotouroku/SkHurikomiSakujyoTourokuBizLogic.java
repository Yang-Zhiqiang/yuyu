package yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku;

import static yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku.SkHurikomiSakujyoTourokuConstants.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.slf4j.Logger;

import com.google.common.collect.Lists;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_HrkmNyknSakujyo;

/**
 * 振込入金削除データ登録 のビジネスロジックです。
 */
public class SkHurikomiSakujyoTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkHurikomiSakujyoTourokuUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    void init() {
        clear();

        uiBean.setSakujyotrkymd(BizDate.getSysDate());

        SortHT_HrkmNyknSakujyo sortHT_HrkmNyknSakujyo = SWAKInjector.getInstance(SortHT_HrkmNyknSakujyo.class);

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst =
            sortHT_HrkmNyknSakujyo.OrderHT_HrkmNyknSakujyoByGyoumuKousinTimeDesc(
                sinkeiyakuDomManager.getHrkmNyknSakujyosBySyorizumiflg(C_Syorizumiflg.MISYORI));

        List<SakujyoInfoListDataSourceBean> SakujyoInfoListDataSourceBeanLst =
            new ArrayList<>();

        for (HT_HrkmNyknSakujyo hkmNyknSakujyo : hrkmNyknSakujyoLst) {

            SakujyoInfoListDataSourceBean sakujyoInfoListDataSourceBean =
                SWAKInjector.getInstance(SakujyoInfoListDataSourceBean.class);

            sakujyoInfoListDataSourceBean.setHrkmdeldataskbtkey(hkmNyknSakujyo.getHrkmdeldataskbtkey());
            sakujyoInfoListDataSourceBean.setDisptrkymd(hkmNyknSakujyo.getTrkymd());
            sakujyoInfoListDataSourceBean.setDispmosno(hkmNyknSakujyo.getNykmosno());
            sakujyoInfoListDataSourceBean.setDisphrkmirninnm(hkmNyknSakujyo.getHrkmirninnm());
            sakujyoInfoListDataSourceBean.setDispoyadrtencd(hkmNyknSakujyo.getOyadrtencd());
            sakujyoInfoListDataSourceBean.setDisprstuukasyu(hkmNyknSakujyo.getRstuukasyu());
            sakujyoInfoListDataSourceBean.setDisprskingaku(hkmNyknSakujyo.getTrhkkgk());
            sakujyoInfoListDataSourceBean.setDispsakujyoLink(
                MessageUtil.getMessage(DDID_SAKUJYOINFOLIST_SAKUJYOLINK.getErrorResourceKey())
                );

            SakujyoInfoListDataSourceBeanLst.add(sakujyoInfoListDataSourceBean);
        }

        uiBean.setSakujyoInfoList(SakujyoInfoListDataSourceBeanLst);
    }

    void clear() {

        uiBean.setMosnochknasi("");
        uiBean.setOyadrtencd("");
        uiBean.setRstuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHrkmirninnm("");
        uiBean.setRsgaku(BizCurrency.optional());

        BizPropertyInitializer.initialize(uiBean);
    }

    @Transactional
    void kakuteiBtnOnClick() {

        checkZero();

        List<HT_HrkmNyknSakujyo> hrkmNyknSakujyoLst =
            sinkeiyakuDomManager.getHrkmNyknSakujyosByOyadrtencdMosnoHrkmirninnmTrhkkgkRstuukasyuSyorizumiflg(
                uiBean.getOyadrtencd(),
                uiBean.getMosnochknasi(),
                uiBean.getHrkmirninnm(),
                uiBean.getRsgaku(),
                uiBean.getRstuukasyu(),
                C_Syorizumiflg.MISYORI);

        if (hrkmNyknSakujyoLst.size() > 0) {

            throw new BizLogicException(MessageId.EHA0041, SAKUJYO_JYOUHOU);
        }

        String uniqueKey = uniqueKeyGenerator.generateUniqueKey();

        HT_HrkmNyknSakujyo hrkmNyknSakujyo = new HT_HrkmNyknSakujyo();

        hrkmNyknSakujyo.setHrkmdeldataskbtkey(uniqueKey);
        hrkmNyknSakujyo.setTrkymd(uiBean.getSakujyotrkymd());
        hrkmNyknSakujyo.setOyadrtencd(uiBean.getOyadrtencd());
        hrkmNyknSakujyo.setNykmosno(uiBean.getMosnochknasi());
        hrkmNyknSakujyo.setHrkmirninnm(uiBean.getHrkmirninnm());
        hrkmNyknSakujyo.setTrhkkgk(uiBean.getRsgaku());
        hrkmNyknSakujyo.setRstuukasyu(uiBean.getRstuukasyu());
        hrkmNyknSakujyo.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        hrkmNyknSakujyo.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        hrkmNyknSakujyo.setGyoumuKousinTime(BizDate.getSysDateTime());

        BizPropertyInitializer.initialize(hrkmNyknSakujyo);

        sinkeiyakuDomManager.insert(hrkmNyknSakujyo);
    }

    @Transactional
    void sakujyoLinkOnClick() {

        HT_HrkmNyknSakujyo hrkmNyknSakujyo =
            sinkeiyakuDomManager.getHrkmNyknSakujyo(uiBean.getSakujyoInfoListDataSource().
                getSelectedBean().getHrkmdeldataskbtkey());

        if (hrkmNyknSakujyo == null) {
            throw new BizLogicException(MessageId.EHA0477, SAKUJYO_JYOUHOU);
        }

        sinkeiyakuDomManager.delete(hrkmNyknSakujyo);
    }

    @SuppressWarnings("resource")
    void  callAjaxCommonBL() throws IOException {
        HttpServletRequest request = SWAKInjector.getInstance(HttpServletRequest.class);
        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        List<String> outStrLst = Lists.newArrayList();

        C_Tuukasyu tuukasyu = C_Tuukasyu.valueOf(request.getParameter(AJAX_POST_PARAM_TUUKASYU));

        outStrLst = ajaxCurrencyChange(tuukasyu);

        String responseJson = JSON.encode(outStrLst);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.close();
    }

    private List<String> ajaxCurrencyChange(C_Tuukasyu pTuukasyu) {
        List<String> outStrLst = Lists.newArrayList();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);
        BizCurrency initKingaku = BizCurrency.optional(currencyType);

        outStrLst.add(initKingaku.toString());
        outStrLst.add(initKingaku.toPattern());
        outStrLst.add(currencyType.getUnitValue());
        outStrLst.add(currencyType.toString());

        uiBean.setRsgaku(initKingaku);

        return outStrLst;
    }

    private void checkZero() {

        boolean isZeroFlg = BizUtil.isZero(uiBean.getRsgaku());

        if (isZeroFlg) {

            throw new BizLogicException(MessageId.EAV0019, DDID_KIHONINFO_RSGAKU);
        }
    }

}
