package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;

/**
 * 有効性確認結果（新契約）テーブル(IT_YuukouKakKekkaSkDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YuukouKakKekkaSkDao extends AbstractDao<IT_YuukouKakKekkaSk> {

    public IT_YuukouKakKekkaSkDao() {
        super(IT_YuukouKakKekkaSk.class);
    }

    public IT_YuukouKakKekkaSk getYuukouKakKekkaSk(String pCreditkessaiyouno) {
        IT_YuukouKakKekkaSk iT_YuukouKakKekkaSk =  new IT_YuukouKakKekkaSk();
        iT_YuukouKakKekkaSk.setCreditkessaiyouno(pCreditkessaiyouno);
        return this.selectOne(iT_YuukouKakKekkaSk);
    }
}
