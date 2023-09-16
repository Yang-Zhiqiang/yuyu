package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_BAK_AnsyuRireki;

/**
 * 案内収納履歴バックアップテーブル(IT_BAK_AnsyuRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_AnsyuRirekiDao extends AbstractDao<IT_BAK_AnsyuRireki> {

    public IT_BAK_AnsyuRirekiDao() {
        super(IT_BAK_AnsyuRireki.class);
    }

    @Deprecated
    public IT_BAK_AnsyuRireki getBAKAnsyuRireki(String pSyono,
         String pTrkssikibetukey,
         C_NyknaiyouKbn pNyknaiyoukbn,
         BizDateYM pJyuutouym,
         Integer pAnnaino){
        IT_BAK_AnsyuRireki iT_BAK_AnsyuRireki =  new IT_BAK_AnsyuRireki();
        iT_BAK_AnsyuRireki.setSyono(pSyono);
        iT_BAK_AnsyuRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_AnsyuRireki.setNyknaiyoukbn(pNyknaiyoukbn);
        iT_BAK_AnsyuRireki.setJyuutouym(pJyuutouym);
        iT_BAK_AnsyuRireki.setAnnaino(pAnnaino);
        return this.selectOne(iT_BAK_AnsyuRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_AnsyuRireki> selectAll() {
        return super.selectAll();
    }
}
