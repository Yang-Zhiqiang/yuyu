package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_BAK_KykUkt;

/**
 * 契約受取人バックアップテーブル(IT_BAK_KykUktDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KykUktDao extends AbstractDao<IT_BAK_KykUkt> {

    public IT_BAK_KykUktDao() {
        super(IT_BAK_KykUkt.class);
    }

    @Deprecated
    public IT_BAK_KykUkt getBAKKykUkt(String pSyono,
         String pTrkssikibetukey,
         C_UktsyuKbn pUktsyukbn,
         Integer pUktsyurenno){
        IT_BAK_KykUkt iT_BAK_KykUkt =  new IT_BAK_KykUkt();
        iT_BAK_KykUkt.setSyono(pSyono);
        iT_BAK_KykUkt.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KykUkt.setUktsyukbn(pUktsyukbn);
        iT_BAK_KykUkt.setUktsyurenno(pUktsyurenno);
        return this.selectOne(iT_BAK_KykUkt);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KykUkt> selectAll() {
        return super.selectAll();
    }
}
