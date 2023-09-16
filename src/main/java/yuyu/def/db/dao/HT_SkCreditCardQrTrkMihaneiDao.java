package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;

/**
 * 新契約クレジットカードＱＲ登録結果未反映テーブル(HT_SkCreditCardQrTrkMihaneiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkCreditCardQrTrkMihaneiDao extends AbstractDao<HT_SkCreditCardQrTrkMihanei> {

    public HT_SkCreditCardQrTrkMihaneiDao() {
        super(HT_SkCreditCardQrTrkMihanei.class);
    }

    public HT_SkCreditCardQrTrkMihanei getSkCreditCardQrTrkMihanei(BizDate pSyoriYmd, BizDate pSystemjyusinymd, String pSystemjyusintime, String pCreditkessaiyouno) {
        HT_SkCreditCardQrTrkMihanei hT_SkCreditCardQrTrkMihanei =  new HT_SkCreditCardQrTrkMihanei();
        hT_SkCreditCardQrTrkMihanei.setSyoriYmd(pSyoriYmd);
        hT_SkCreditCardQrTrkMihanei.setSystemjyusinymd(pSystemjyusinymd);
        hT_SkCreditCardQrTrkMihanei.setSystemjyusintime(pSystemjyusintime);
        hT_SkCreditCardQrTrkMihanei.setCreditkessaiyouno(pCreditkessaiyouno);
        return this.selectOne(hT_SkCreditCardQrTrkMihanei);
    }
}
