package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;

/**
 * 自動収納照合明細テーブル(HT_JidouSyuunouMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_JidouSyuunouMeisaiDao extends AbstractDao<HT_JidouSyuunouMeisai> {

    public HT_JidouSyuunouMeisaiDao() {
        super(HT_JidouSyuunouMeisai.class);
    }

    public HT_JidouSyuunouMeisai getJidouSyuunouMeisai(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu) {
        HT_JidouSyuunouMeisai hT_JidouSyuunouMeisai =  new HT_JidouSyuunouMeisai();
        hT_JidouSyuunouMeisai.setSyoriYmd(pSyoriYmd);
        hT_JidouSyuunouMeisai.setKessankbn(pKessankbn);
        hT_JidouSyuunouMeisai.setRstuukasyu(pRstuukasyu);
        return this.selectOne(hT_JidouSyuunouMeisai);
    }
}
