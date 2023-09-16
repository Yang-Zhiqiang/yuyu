package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_YuukouKakKekkaKikyk;

/**
 * 有効性確認結果（既契約）テーブル(IT_YuukouKakKekkaKikykDao) アクセス用の DAO クラスです。<br />
 */
public class IT_YuukouKakKekkaKikykDao extends AbstractDao<IT_YuukouKakKekkaKikyk> {

    public IT_YuukouKakKekkaKikykDao() {
        super(IT_YuukouKakKekkaKikyk.class);
    }

    public IT_YuukouKakKekkaKikyk getYuukouKakKekkaKikyk(String pCreditkessaiyouno) {
        IT_YuukouKakKekkaKikyk iT_YuukouKakKekkaKikyk =  new IT_YuukouKakKekkaKikyk();
        iT_YuukouKakKekkaKikyk.setCreditkessaiyouno(pCreditkessaiyouno);
        return this.selectOne(iT_YuukouKakKekkaKikyk);
    }
}
