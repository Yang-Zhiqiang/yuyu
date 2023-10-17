package yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai.dba.KhKawaseRateYoteiRrtSyoukaiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Lists;

/**
 * 為替レート予定利率推移照会（平準払） のビジネスロジックです。
 */
public class KhKawaseRateYoteiRrtSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKawaseRateYoteiRrtSyoukaiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhKawaseRateYoteiRrtSyoukaiDao KhKawaseRateYoteiRrtSyoukaiDao;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void pushReferenceBL() {

        BizDate sysDate = BizDate.getSysDate();
        String syono = uiBean.getSyono();


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        if (kykKihon == null) {
            throw new BizLogicException(MessageId.EBA0090);
        }

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
            throw new BizLogicException(MessageId.EBA0031, C_YuukousyoumetuKbn.SYOUMETU.getContent());
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
        if (syohinHanteiKbn != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            throw new BizLogicException(
                MessageId.EIA1015,
                MessageUtil.getMessage(MessageId.IIW1007));
        }

        if (BizDateUtil.compareYmd(sysDate, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            throw new BizLogicException(MessageId.EIA0070, "照会日");
        }

        KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
        BizCurrency yenhrkgk = kykKihon.getHrkp();
        C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();
        BizDate fstpnyknymd = kykKihon.getFstpnyknymd();

        List<BM_YoteiRiritu3> yoteiRiritu3List =
            KhKawaseRateYoteiRrtSyoukaiDao.getYoteiRiritu3List(
                kykSyouhn.getSyouhncd(),
                "",
                "",
                kykSyouhn.getKykymd().getBizDateYM().getFirstDay(),
                sysDate);

        List<ReferenceListDataSourceBean> referenceListDataSourceBeanList = Lists.newArrayList();

        for (int index = 0; index < yoteiRiritu3List.size(); index++) {

            ReferenceListDataSourceBean referenceListDataSourceBean = new ReferenceListDataSourceBean();

            BM_YoteiRiritu3 yoteiRiritu3 = yoteiRiritu3List.get(index);

            BizDateYM kijyunym = yoteiRiritu3.getKijyunfromymd().getBizDateYM();

            keisanGaikaP.exec(
                yenhrkgk,
                kyktuukasyu,
                kijyunym,
                kykSyouhn.getKykymd(),
                fstpnyknymd);

            BizCurrency pgaika = keisanGaikaP.getP();
            BizNumber gaikaknsnkwsrate = keisanGaikaP.getKawaseRate();
            BizDate gaikaknsnkwsratekjymd = keisanGaikaP.getKwsrateKjYmd();

            referenceListDataSourceBean.setDispym(kijyunym);
            referenceListDataSourceBean.setDisphrkp(yenhrkgk);
            referenceListDataSourceBean.setDispgaikaknsnkwsratekjymd(gaikaknsnkwsratekjymd);
            referenceListDataSourceBean.setDispgaikaknsnkwsrate(gaikaknsnkwsrate);
            referenceListDataSourceBean.setDispkyktuukasyu(kyktuukasyu);
            referenceListDataSourceBean.setDisppgaika(pgaika);
            referenceListDataSourceBean.setDispytirrtcalckijyunrrt(yoteiRiritu3.getYoteiriritu().multiply(100));
            referenceListDataSourceBeanList.add(referenceListDataSourceBean);
        }

        uiBean.setReferenceList(referenceListDataSourceBeanList);
    }
}
