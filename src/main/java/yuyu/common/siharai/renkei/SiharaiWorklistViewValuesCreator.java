package yuyu.common.siharai.renkei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.common.biz.renkei.WorklistViewValuesCreator;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金支払 サブシステム連携 保険金給付金支払ワークリスト用表示情報生成
 */
public class SiharaiWorklistViewValuesCreator extends WorklistViewValuesCreator {

    @Inject
    private BizDomManager bizDomManager;

    public SiharaiWorklistViewValuesCreator() {
        super();
    }

    @Override
    public List<WorklistViewValuesBean> create(List<WorklistViewValuesBean> pWorklistViewValuesBeanLst) {
        for (WorklistViewValuesBean worklistViewValuesBean : pWorklistViewValuesBeanLst) {
            KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
            keiyakuPrm.setSyono(worklistViewValuesBean.getSyono());
            KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
            keiyakuInfoSyutoku.getInfos(keiyakuPrm);
            List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();
            JT_SiKykKihon siKykKihon = siKykKihonLst.get(0);
            List<JT_SiKykSyouhn> siKykSyouhnLst = siKykKihon.getSiKykSyouhns();
            BM_SyouhnZokusei syouhnZokusei = bizDomManager.
                    getSyouhnZokusei(siKykSyouhnLst.get(0).getSyouhncd(), siKykSyouhnLst.get(0).getSyouhnsdno());
            worklistViewValuesBean.setDispsyouhnnmworklist(syouhnZokusei.getSyouhnnmworklist());
            worklistViewValuesBean.setKyknmkj(siKykKihon.getKyknmkj());
            worklistViewValuesBean.setKyknmkn(siKykKihon.getKyknmkn());
        }
        return pWorklistViewValuesBeanLst;
    }
}
