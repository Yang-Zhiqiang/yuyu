package yuyu.batch.suuri.srkessan.srskoikmtyouseidenpyotyusyutu;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSkOikmTyouseiDenpyoTyusyutuDbaStatement {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SuuriDomManager suuriDomManager;

    public List<ST_ConvertKanjyouKamoku> getAllConvertKanjyouKamoku() {

        List<ST_ConvertKanjyouKamoku> convertKanjyouKamokuLst = suuriDomManager.getAllConvertKanjyouKamoku();

        return convertKanjyouKamokuLst;
    }

    public BM_KanjyouKamoku getKanjyouKamoku(C_Kanjyoukmkcd pKanjyouKmkCd) {

        BM_KanjyouKamoku kanjyouKamoku = bizDomManager.getKanjyouKamoku(pKanjyouKmkCd);

        return kanjyouKamoku;
    }

    public ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> getSkOikmKaikei(
        BizDate pKsnYokugetuFirstdayYMD,
        BizDate pKsnDenSimeYMD) {

        ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst =
            suuriDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(pKsnYokugetuFirstdayYMD, pKsnDenSimeYMD);

        return skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst;
    }
}
