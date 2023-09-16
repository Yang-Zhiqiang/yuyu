package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;

/**
 * オーソリ結果ＴＲ（クレカ非保持）テーブル(IT_KhTRAuthoriKekkaHihojiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTRAuthoriKekkaHihojiDao extends AbstractDao<IT_KhTRAuthoriKekkaHihoji> {

    public IT_KhTRAuthoriKekkaHihojiDao() {
        super(IT_KhTRAuthoriKekkaHihoji.class);
    }

    public IT_KhTRAuthoriKekkaHihoji getKhTRAuthoriKekkaHihoji(String pCreditkessaiyouno, BizDate pSyoriYmd) {
        IT_KhTRAuthoriKekkaHihoji iT_KhTRAuthoriKekkaHihoji =  new IT_KhTRAuthoriKekkaHihoji();
        iT_KhTRAuthoriKekkaHihoji.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_KhTRAuthoriKekkaHihoji.setSyoriYmd(pSyoriYmd);
        return this.selectOne(iT_KhTRAuthoriKekkaHihoji);
    }
}
