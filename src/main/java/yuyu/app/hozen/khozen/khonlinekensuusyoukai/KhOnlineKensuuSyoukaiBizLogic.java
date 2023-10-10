package yuyu.app.hozen.khozen.khonlinekensuusyoukai;

import static yuyu.app.hozen.khozen.khonlinekensuusyoukai.KhOnlineKensuuSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全オンライン処理件数照会 のビジネスロジックです。
 */
public class KhOnlineKensuuSyoukaiBizLogic {

    @Inject
    private KhOnlineKensuuSyoukaiUiBean uiBean;

    @Inject
    private HozenDomManager domManager;

    @Inject
    private AS_Kinou kiNou;

    void init() {

        uiBean.setSyoriYmd(BizDate.getSysDate());

        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void pushSyoukaiBL() {

        BizDate syoriYmd = uiBean.getSyoriYmd();

        if (BizDateUtil.compareYmd(syoriYmd, BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EIA0037, SYORIYMD);
        }

        List<Object[]> khTtdkRirekiCountLst = domManager.getKhTtdkRirekiCountBySyoriYmdSubSystemId(syoriYmd,
            kiNou.getSubSystemId());

        List<SyoriKensuuListDataSourceBean> syoriKensuuLst = new ArrayList<>();

        for (Object[] khTtdkRirekiCounts : khTtdkRirekiCountLst) {

            SyoriKensuuListDataSourceBean syoriKensuuBean = new SyoriKensuuListDataSourceBean();

            syoriKensuuBean.setDispkinounm((String) khTtdkRirekiCounts[0]);
            syoriKensuuBean.setDispkensuu(Integer.parseInt(khTtdkRirekiCounts[1].toString()));

            syoriKensuuLst.add(syoriKensuuBean);
        }

        uiBean.setSyoriKensuuList(syoriKensuuLst);
    }
}
