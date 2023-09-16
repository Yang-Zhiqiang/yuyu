package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;

/**
 * 解約控除率マスタ(BM_KaiyakuKoujyoRituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KaiyakuKoujyoRituDao extends AbstractDao<BM_KaiyakuKoujyoRitu> {

    public BM_KaiyakuKoujyoRituDao() {
        super(BM_KaiyakuKoujyoRitu.class);
    }

    public BM_KaiyakuKoujyoRitu getKaiyakuKoujyoRitu(String pSyouhncd,
         String pRyouritusdno,
         String pKaiyakukjtkybr1,
         String pKaiyakukjtkybr2,
         Integer pKeikanensuu){
        BM_KaiyakuKoujyoRitu bM_KaiyakuKoujyoRitu =  new BM_KaiyakuKoujyoRitu();
        bM_KaiyakuKoujyoRitu.setSyouhncd(pSyouhncd);
        bM_KaiyakuKoujyoRitu.setRyouritusdno(pRyouritusdno);
        bM_KaiyakuKoujyoRitu.setKaiyakukjtkybr1(pKaiyakukjtkybr1);
        bM_KaiyakuKoujyoRitu.setKaiyakukjtkybr2(pKaiyakukjtkybr2);
        bM_KaiyakuKoujyoRitu.setKeikanensuu(pKeikanensuu);
        return this.selectOne(bM_KaiyakuKoujyoRitu);
    }
}
