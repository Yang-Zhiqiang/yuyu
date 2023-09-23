package yuyu.common.hozen.renkei;

import java.util.List;

import javax.inject.Inject;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.renkei.WorklistViewValuesBean;
import yuyu.common.biz.renkei.WorklistViewValuesCreator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 契約保全ワークリスト用表示情報生成
 */
public class HozenWorklistViewValuesCreator extends WorklistViewValuesCreator {

    @Inject
    private HozenDomManager hozenDomManager;

    public HozenWorklistViewValuesCreator() {
        super();
    }

    @Override
    public List<WorklistViewValuesBean> create(List<WorklistViewValuesBean> pWorklistViewValuesBeanLst) {

        for (WorklistViewValuesBean worklistViewValuesBean : pWorklistViewValuesBeanLst) {



            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(worklistViewValuesBean.getSyono());

            if (kykKihon == null) {
                throw new CommonBizAppException("契約基本TBLにデータが存在しません。");
            }


            IT_KykSya kykSya = kykKihon.getKykSya();

            if (kykSya == null) {
                throw new CommonBizAppException("契約者TBLにデータが存在しません。");
            }


            List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

            if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {
                throw new CommonBizAppException("契約商品TBLにデータが存在しません。");
            }


            if (kykSyouhnLst.get(0).getSyouhnZokusei() == null) {
                throw new CommonBizAppException("商品属性マスタにデータが存在しません。");
            }



            worklistViewValuesBean.setDispsyouhnnmworklist(kykSyouhnLst.get(0).getSyouhnZokusei().getSyouhnnmworklist());

            worklistViewValuesBean.setKyknmkj(kykSya.getKyknmkj());

            worklistViewValuesBean.setKyknmkn(kykSya.getKyknmkn());
        }

        return pWorklistViewValuesBeanLst;
    }
}
