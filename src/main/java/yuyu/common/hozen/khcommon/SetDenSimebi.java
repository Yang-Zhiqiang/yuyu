package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;

/**
 * 契約保全 契約保全共通 伝票締切日設定
 */
public class SetDenSimebi {

    @Inject
    private BizDomManager bizDomManager;

    public SetDenSimebi() {
        super();
    }

    public BizDate exec(BizDate pSyoribi){

        BizDateYM syoriYm = pSyoribi.getBizDateYM();
        BM_DensimeNenkanSchedule densimeNenkanSchedule =
            bizDomManager.getDensimeNenkanSchedule(syoriYm);

        if (densimeNenkanSchedule == null){
            throw new CommonBizAppException("伝票締切日年間スケジュールマスタに" +
                syoriYm + "月分のデータが存在しません。");
        }
        return densimeNenkanSchedule.getZengetudensimeymd();
    }

}
