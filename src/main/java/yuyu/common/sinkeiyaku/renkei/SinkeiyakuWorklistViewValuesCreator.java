package yuyu.common.sinkeiyaku.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.common.biz.renkei.WorklistViewValuesCreator;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNo;

/**
 * 新契約 サブシステム連携 新契約ワークリスト用表示情報生成
 */
public class SinkeiyakuWorklistViewValuesCreator extends WorklistViewValuesCreator {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SinkeiyakuWorklistViewValuesCreator() {
        super();
    }

    @Override
    public List<WorklistViewValuesBean> create(List<WorklistViewValuesBean> pWorklistViewValuesBeanLst) {

        for (WorklistViewValuesBean worklistViewValuesBean : pWorklistViewValuesBeanLst) {
            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(
                    C_HknsyuruiNo.valueOf(worklistViewValuesBean.getHknsyuruiNo()));
            SortHM_SkHokenSyuruiNo sortHM_SkHokenSyuruiNo  = SWAKInjector.getInstance(SortHM_SkHokenSyuruiNo.class);
            skHokenSyuruiNoLst = sortHM_SkHokenSyuruiNo.OrderHM_SkHokenSyuruiNoByPkDesc(skHokenSyuruiNoLst);
            String hknsyuRuiNm = null;

            if (skHokenSyuruiNoLst == null || skHokenSyuruiNoLst.size() == 0) {
                hknsyuRuiNm = "";
            }
            else {
                hknsyuRuiNm = skHokenSyuruiNoLst.get(0).getHknsyuruiworklist();
            }

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(worklistViewValuesBean.getMosno());
            String kykNmKj = null;
            String kykNmKn = null;

            if (syoriCTL == null) {

                kykNmKj = "";
                kykNmKn = "";

            }
            else {

                C_ImusateijyouKbn imusateijyouKbn = syoriCTL.getImusateijyoukbn();
                C_UmuKbn doujiMosUmu = syoriCTL.getDoujimosumu();
                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                if (mosKihon == null) {
                    kykNmKj = "";
                    kykNmKn = "";
                }
                else {
                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                        kykNmKj = mosKihon.getHhknnmkj();
                        kykNmKn = mosKihon.getHhknnmkn();
                    }
                    else {
                        kykNmKj = mosKihon.getKyknmkj();
                        kykNmKn = mosKihon.getKyknmkn();
                    }
                }
                HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = syoriCTL.getSkTtdkTyuuiKanri();
                C_YouhiKbn skeittdKkinkyuyouhiKbn = null;
                C_YouhiKbn skeittdKtyuuiyouhiKbn = null;
                if (skTtdkTyuuiKanri == null) {
                    skeittdKkinkyuyouhiKbn = C_YouhiKbn.HUYOU;
                    skeittdKtyuuiyouhiKbn = C_YouhiKbn.HUYOU;
                }
                else {
                    skeittdKkinkyuyouhiKbn = skTtdkTyuuiKanri.getSkeittdkkinkyuyouhikbn();
                    skeittdKtyuuiyouhiKbn = skTtdkTyuuiKanri.getSkeittdktyuuiyouhikbn();
                }

                if (C_YouhiKbn.YOU.eq(skeittdKtyuuiyouhiKbn)) {
                    kykNmKj = "●" + kykNmKj;
                }

                if (C_YouhiKbn.YOU.eq(skeittdKkinkyuyouhiKbn)) {
                    kykNmKj = "◎" + kykNmKj;
                }

                if (C_UmuKbn.ARI.eq(doujiMosUmu)) {
                    kykNmKj = "■" + kykNmKj;
                }

                if (!C_ImusateijyouKbn.NONE.eq(imusateijyouKbn) && !C_ImusateijyouKbn.SATEIZUMI.eq(imusateijyouKbn)) {
                    kykNmKj = "△" + kykNmKj;
                }
            }

            worklistViewValuesBean.setHknsyuruiWorklist(hknsyuRuiNm);
            worklistViewValuesBean.setKyknmkj(kykNmKj);
            worklistViewValuesBean.setKyknmkn(kykNmKn);
        }

        return pWorklistViewValuesBeanLst;
    }
}
