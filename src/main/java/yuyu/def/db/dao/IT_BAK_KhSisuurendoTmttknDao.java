package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_BAK_KhSisuurendoTmttkn;
import java.util.List;

/**
 * 指数連動積増型年金積立金バックアップテーブル(IT_BAK_KhSisuurendoTmttknDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhSisuurendoTmttknDao extends AbstractDao<IT_BAK_KhSisuurendoTmttkn> {

    public IT_BAK_KhSisuurendoTmttknDao() {
        super(IT_BAK_KhSisuurendoTmttkn.class);
    }

    @Deprecated
    public IT_BAK_KhSisuurendoTmttkn getBAKKhSisuurendoTmttkn(String pSyono, String pTrkssikibetukey, BizDateYM pTmttkntaisyouym, Integer pRenno) {
        IT_BAK_KhSisuurendoTmttkn iT_BAK_KhSisuurendoTmttkn =  new IT_BAK_KhSisuurendoTmttkn( pSyono,  pTrkssikibetukey,  pTmttkntaisyouym,  pRenno);
        return this.selectOne(iT_BAK_KhSisuurendoTmttkn);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhSisuurendoTmttkn> selectAll() {
        return super.selectAll();
    }
}
