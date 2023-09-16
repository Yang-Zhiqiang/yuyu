package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BT_SikinIdouRireki;

/**
 * 資金移動用履歴テーブル(BT_SikinIdouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_SikinIdouRirekiDao extends AbstractDao<BT_SikinIdouRireki> {

    public BT_SikinIdouRirekiDao() {
        super(BT_SikinIdouRireki.class);
    }

    public BT_SikinIdouRireki getSikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno) {
        BT_SikinIdouRireki bT_SikinIdouRireki =  new BT_SikinIdouRireki();
        bT_SikinIdouRireki.setSyoriYmd(pSyoriYmd);
        bT_SikinIdouRireki.setKeirisyorirenno(pKeirisyorirenno);
        return this.selectOne(bT_SikinIdouRireki);
    }
}
