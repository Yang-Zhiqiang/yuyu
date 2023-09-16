package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;

/**
 * 期日到来本番検証用テーブル(BT_KijituTouraiHonbanKensyouDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KijituTouraiHonbanKensyouDao extends AbstractDao<BT_KijituTouraiHonbanKensyou> {

    public BT_KijituTouraiHonbanKensyouDao() {
        super(BT_KijituTouraiHonbanKensyou.class);
    }

    public BT_KijituTouraiHonbanKensyou getKijituTouraiHonbanKensyou(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno, String pDatakanrino) {
        BT_KijituTouraiHonbanKensyou bT_KijituTouraiHonbanKensyou =  new BT_KijituTouraiHonbanKensyou();
        bT_KijituTouraiHonbanKensyou.setSyoriYmd(pSyoriYmd);
        bT_KijituTouraiHonbanKensyou.setSubSystemId(pSubSystemId);
        bT_KijituTouraiHonbanKensyou.setTysytno(pTysytno);
        bT_KijituTouraiHonbanKensyou.setDatakanrino(pDatakanrino);
        return this.selectOne(bT_KijituTouraiHonbanKensyou);
    }
}
