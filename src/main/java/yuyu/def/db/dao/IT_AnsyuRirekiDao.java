package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;

/**
 * 案内収納履歴テーブル(IT_AnsyuRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AnsyuRirekiDao extends AbstractDao<IT_AnsyuRireki> {

    public IT_AnsyuRirekiDao() {
        super(IT_AnsyuRireki.class);
    }

    @Deprecated
    public IT_AnsyuRireki getAnsyuRireki(String pSyono,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BizDateYM pJyuutouym,
        Integer pAnnaino){
        IT_AnsyuRireki iT_AnsyuRireki =  new IT_AnsyuRireki();
        iT_AnsyuRireki.setSyono(pSyono);
        iT_AnsyuRireki.setNyknaiyoukbn(pNyknaiyoukbn);
        iT_AnsyuRireki.setJyuutouym(pJyuutouym);
        iT_AnsyuRireki.setAnnaino(pAnnaino);
        return this.selectOne(iT_AnsyuRireki);
    }

    @Override
    @Deprecated
    public List<IT_AnsyuRireki> selectAll() {
        return super.selectAll();
    }

}
