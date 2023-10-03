package yuyu.batch.suuri.srkessan.srskkessankubunkeiri;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.suuri.manager.SuuriDomManager;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSkKessanKubunKeiriDbaStatement {

    @Inject
    private SuuriDomManager suuriDomManager;

    public List<ST_SkKessanSyukei> getSkKessanSyukei(BizDate pDenpyouYMD) {

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisBySeg1cdDenymd(pDenpyouYMD);

        return skKessanSyukeiLst;
    }
}
