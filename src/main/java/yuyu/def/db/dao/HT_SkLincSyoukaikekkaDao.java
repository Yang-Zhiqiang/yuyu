package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル(HT_SkLincSyoukaikekkaDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincSyoukaikekkaDao extends AbstractDao<HT_SkLincSyoukaikekka> {

    public HT_SkLincSyoukaikekkaDao() {
        super(HT_SkLincSyoukaikekka.class);
    }

    public HT_SkLincSyoukaikekka getSkLincSyoukaikekka(String pMosno, String pLincjyusintrrenno, Integer pRenno) {
        HT_SkLincSyoukaikekka hT_SkLincSyoukaikekka =  new HT_SkLincSyoukaikekka();
        hT_SkLincSyoukaikekka.setMosno(pMosno);
        hT_SkLincSyoukaikekka.setLincjyusintrrenno(pLincjyusintrrenno);
        hT_SkLincSyoukaikekka.setRenno(pRenno);
        return this.selectOne(hT_SkLincSyoukaikekka);
    }
}
