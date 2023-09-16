package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;

/**
 * 自動収納照合明細テーブル２(HT_JidouSyuunouMeisai2Dao) アクセス用の DAO クラスです。<br />
 */
public class HT_JidouSyuunouMeisai2Dao extends AbstractDao<HT_JidouSyuunouMeisai2> {

    public HT_JidouSyuunouMeisai2Dao() {
        super(HT_JidouSyuunouMeisai2.class);
    }

    public HT_JidouSyuunouMeisai2 getJidouSyuunouMeisai2(BizDate pSyoriYmd, C_KessanKbn pKessankbn, C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn pNyktyhyoutkbn) {
        HT_JidouSyuunouMeisai2 hT_JidouSyuunouMeisai2 =  new HT_JidouSyuunouMeisai2();
        hT_JidouSyuunouMeisai2.setSyoriYmd(pSyoriYmd);
        hT_JidouSyuunouMeisai2.setKessankbn(pKessankbn);
        hT_JidouSyuunouMeisai2.setRstuukasyu(pRstuukasyu);
        hT_JidouSyuunouMeisai2.setNyktyhyoutkbn(pNyktyhyoutkbn);
        return this.selectOne(hT_JidouSyuunouMeisai2);
    }
}
