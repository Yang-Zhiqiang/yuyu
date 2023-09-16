package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import java.util.List;

/**
 * ＤＳ登録受付（口座暗証番号）テーブル(MT_DsTourokuUkKouzaAnsyonoDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsTourokuUkKouzaAnsyonoDao extends AbstractDao<MT_DsTourokuUkKouzaAnsyono> {

    public MT_DsTourokuUkKouzaAnsyonoDao() {
        super(MT_DsTourokuUkKouzaAnsyono.class);
    }

    @Deprecated
    public MT_DsTourokuUkKouzaAnsyono getDsTourokuUkKouzaAnsyono(String pSyono, C_DsTtdksyubetuKbn pDsttdksyubetukbn, Integer pDatarenno) {
        MT_DsTourokuUkKouzaAnsyono mT_DsTourokuUkKouzaAnsyono =  new MT_DsTourokuUkKouzaAnsyono();
        mT_DsTourokuUkKouzaAnsyono.setSyono(pSyono);
        mT_DsTourokuUkKouzaAnsyono.setDsttdksyubetukbn(pDsttdksyubetukbn);
        mT_DsTourokuUkKouzaAnsyono.setDatarenno(pDatarenno);
        return this.selectOne(mT_DsTourokuUkKouzaAnsyono);
    }

    @Override
    @Deprecated
    public List<MT_DsTourokuUkKouzaAnsyono> selectAll() {
        return super.selectAll();
    }
}
