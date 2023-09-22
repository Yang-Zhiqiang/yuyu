package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkTtdkTyuui;

/**
 * 新契約 新契約共通 新契約手続注意情報取得
 */
public class GetSkTtdkTyuui {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public GetSkTtdkTyuui() {
        super();
    }

    public HT_SkTtdkTyuuiKanri getTtdkTyuuiKanri(String pMosno) {

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = sinkeiyakuDomManager.getSyoriCTL(pMosno).getSkTtdkTyuuiKanri();

        if (skTtdkTyuuiKanri == null) {

            return null;
        }

        return skTtdkTyuuiKanri;
    }

    public List<HT_SkTtdkTyuui> getTtdkTyuui(String pMosno, C_SkeittdkrenrakuKbn pSkeittdkrenrakuKbn) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        List<HT_SkTtdkTyuui> skTtdkTyuuiList = syoriCTL.getSkTtdkTyuuisBySkeittdkrenrakukbn(pSkeittdkrenrakuKbn);

        if (skTtdkTyuuiList != null && skTtdkTyuuiList.size() > 0) {

            SortHT_SkTtdkTyuui sortHT_SkTtdkTyuui = new SortHT_SkTtdkTyuui();

            skTtdkTyuuiList = sortHT_SkTtdkTyuui.OrderHT_SkTtdkTyuuiByTrkymdDatarennoAsc(skTtdkTyuuiList);

            return skTtdkTyuuiList;
        }

        return null;
    }
}