package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNkgnsHonken;
import java.util.List;

/**
 * 年金原資本件事方書チェックマスタ(BM_ChkJhNkgnsHonkenDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhNkgnsHonkenDao extends AbstractDao<BM_ChkJhNkgnsHonken> {

    public BM_ChkJhNkgnsHonkenDao() {
        super(BM_ChkJhNkgnsHonken.class);
    }

    @Deprecated
    public BM_ChkJhNkgnsHonken getChkJhNkgnsHonken(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        BM_ChkJhNkgnsHonken bM_ChkJhNkgnsHonken =  new BM_ChkJhNkgnsHonken();
        bM_ChkJhNkgnsHonken.setSyouhncd(pSyouhncd);
        bM_ChkJhNkgnsHonken.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhNkgnsHonken.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhNkgnsHonken.setHhknfromnen(pHhknfromnen);
        bM_ChkJhNkgnsHonken.setHhkntonen(pHhkntonen);
        return this.selectOne(bM_ChkJhNkgnsHonken);
    }

    @Override
    @Deprecated
    public List<BM_ChkJhNkgnsHonken> selectAll() {
        return super.selectAll();
    }
}
