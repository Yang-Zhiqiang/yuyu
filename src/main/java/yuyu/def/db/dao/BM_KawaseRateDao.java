package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KawaseRate;

/**
 * 為替レートマスタ(BM_KawaseRateDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KawaseRateDao extends AbstractDao<BM_KawaseRate> {

    public BM_KawaseRateDao() {
        super(BM_KawaseRate.class);
    }

    public BM_KawaseRate getKawaseRate(BizDate pKwsratekjymd,
        C_KwsrendouKbn pKwsrendoukbn,
        C_Tuukasyu pMototuuka,
        C_Tuukasyu pKanzantuuka,
        C_KawasetekiyoKbn pKawasetekiyokbn,
        C_KawasetsryKbn pKawasetsrykbn){
        BM_KawaseRate bM_KawaseRate =  new BM_KawaseRate();
        bM_KawaseRate.setKwsratekjymd(pKwsratekjymd);
        bM_KawaseRate.setKwsrendoukbn(pKwsrendoukbn);
        bM_KawaseRate.setMototuuka(pMototuuka);
        bM_KawaseRate.setKanzantuuka(pKanzantuuka);
        bM_KawaseRate.setKawasetekiyokbn(pKawasetekiyokbn);
        bM_KawaseRate.setKawasetsrykbn(pKawasetsrykbn);
        return this.selectOne(bM_KawaseRate);
    }
}
