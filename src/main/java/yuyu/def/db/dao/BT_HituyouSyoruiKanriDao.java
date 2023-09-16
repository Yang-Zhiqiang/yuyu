package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;

/**
 * 必要書類管理テーブル(BT_HituyouSyoruiKanriDao) アクセス用の DAO クラスです。<br />
 */
public class BT_HituyouSyoruiKanriDao extends AbstractDao<BT_HituyouSyoruiKanri> {

    public BT_HituyouSyoruiKanriDao() {
        super(BT_HituyouSyoruiKanri.class);
    }

    @Deprecated
    public BT_HituyouSyoruiKanri getHituyouSyoruiKanri(String pKouteikanriid,
         C_SyoruiCdKbn pSyoruiCd){
        BT_HituyouSyoruiKanri bT_HituyouSyoruiKanri =  new BT_HituyouSyoruiKanri();
        bT_HituyouSyoruiKanri.setKouteikanriid(pKouteikanriid);
        bT_HituyouSyoruiKanri.setSyoruiCd(pSyoruiCd);
        return this.selectOne(bT_HituyouSyoruiKanri);
    }

    @Override
    @Deprecated
    public List<BT_HituyouSyoruiKanri> selectAll() {
        return super.selectAll();
    }
}
