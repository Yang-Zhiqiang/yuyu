package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;

/**
 * 平準払入金用資金移動リスト作成用テーブル（外貨）(BT_HijynNykSiknIdouLstSksGkDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HijynNykSiknIdouLstSksGkDao extends AbstractDao<BT_HijynNykSiknIdouLstSksGk> {

    public BT_HijynNykSiknIdouLstSksGkDao() {
        super(BT_HijynNykSiknIdouLstSksGk.class);
    }

    public BT_HijynNykSiknIdouLstSksGk getHijynNykSiknIdouLstSksGk(BizDate pSyoriYmd, C_SikinidouPKbn pSikinidoupkbn, String pSyono, Integer pRenno) {
        BT_HijynNykSiknIdouLstSksGk bT_HijynNykSiknIdouLstSksGk =  new BT_HijynNykSiknIdouLstSksGk();
        bT_HijynNykSiknIdouLstSksGk.setSyoriYmd(pSyoriYmd);
        bT_HijynNykSiknIdouLstSksGk.setSikinidoupkbn(pSikinidoupkbn);
        bT_HijynNykSiknIdouLstSksGk.setSyono(pSyono);
        bT_HijynNykSiknIdouLstSksGk.setRenno(pRenno);
        return this.selectOne(bT_HijynNykSiknIdouLstSksGk);
    }
}
