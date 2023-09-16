package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BM_HaitouRiritu;

/**
 * 配当利率マスタ(BM_HaitouRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_HaitouRirituDao extends AbstractDao<BM_HaitouRiritu> {

    public BM_HaitouRirituDao() {
        super(BM_HaitouRiritu.class);
    }

    public BM_HaitouRiritu getHaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        BM_HaitouRiritu bM_HaitouRiritu =  new BM_HaitouRiritu();
        bM_HaitouRiritu.setKijyunfromymd(pKijyunfromymd);
        bM_HaitouRiritu.setKijyuntoymd(pKijyuntoymd);
        return this.selectOne(bM_HaitouRiritu);
    }

}
