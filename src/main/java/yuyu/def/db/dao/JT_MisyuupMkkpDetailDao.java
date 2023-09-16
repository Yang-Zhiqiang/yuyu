package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;

/**
 * 未収Ｐ未経過Ｐ明細テーブル(JT_MisyuupMkkpDetailDao) アクセス用の DAO クラスです。<br />
 */
public class JT_MisyuupMkkpDetailDao extends AbstractDao<JT_MisyuupMkkpDetail> {

    public JT_MisyuupMkkpDetailDao() {
        super(JT_MisyuupMkkpDetail.class);
    }

    @Deprecated
    public JT_MisyuupMkkpDetail getMisyuupMkkpDetail(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pDatarenno){
        JT_MisyuupMkkpDetail jT_MisyuupMkkpDetail =  new JT_MisyuupMkkpDetail();
        jT_MisyuupMkkpDetail.setSkno(pSkno);
        jT_MisyuupMkkpDetail.setSyono(pSyono);
        jT_MisyuupMkkpDetail.setSeikyuurirekino(pSeikyuurirekino);
        jT_MisyuupMkkpDetail.setDatarenno(pDatarenno);
        return this.selectOne(jT_MisyuupMkkpDetail);
    }

    @Override
    @Deprecated
    public List<JT_MisyuupMkkpDetail> selectAll() {
        return super.selectAll();
    }
}
