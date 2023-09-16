package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_YuukouKakErrorList;

/**
 * 有効確認エラーリストテーブル(IT_YuukouKakErrorListDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YuukouKakErrorListDao extends AbstractDao<IT_YuukouKakErrorList> {

    public IT_YuukouKakErrorListDao() {
        super(IT_YuukouKakErrorList.class);
    }

    public IT_YuukouKakErrorList getYuukouKakErrorList(String pSyono, String pCreditkessaiyouno, BizDateYM pSyoriym) {
        IT_YuukouKakErrorList iT_YuukouKakErrorList =  new IT_YuukouKakErrorList();
        iT_YuukouKakErrorList.setSyono(pSyono);
        iT_YuukouKakErrorList.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_YuukouKakErrorList.setSyoriym(pSyoriym);
        return this.selectOne(iT_YuukouKakErrorList);
    }
}
