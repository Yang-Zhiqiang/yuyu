package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsHonninKakuninCd;
import java.util.List;

/**
 * ＤＳ本人確認コードバックアップテーブル(MT_BAK_DsHonninKakuninCdDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsHonninKakuninCdDao extends AbstractDao<MT_BAK_DsHonninKakuninCd> {

    public MT_BAK_DsHonninKakuninCdDao() {
        super(MT_BAK_DsHonninKakuninCd.class);
    }

    @Deprecated
    public MT_BAK_DsHonninKakuninCd getBAKDsHonninKakuninCd(String pDskokno, String pTrkssikibetukey) {
        MT_BAK_DsHonninKakuninCd mT_BAK_DsHonninKakuninCd =  new MT_BAK_DsHonninKakuninCd();
        mT_BAK_DsHonninKakuninCd.setDskokno(pDskokno);
        mT_BAK_DsHonninKakuninCd.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsHonninKakuninCd);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsHonninKakuninCd> selectAll() {
        return super.selectAll();
    }
}
