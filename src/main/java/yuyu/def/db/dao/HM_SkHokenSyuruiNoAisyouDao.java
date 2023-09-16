package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNoAisyou;

/**
 * 保険種類番号愛称マスタ(HM_SkHokenSyuruiNoAisyouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkHokenSyuruiNoAisyouDao extends AbstractDao<HM_SkHokenSyuruiNoAisyou> {

    public HM_SkHokenSyuruiNoAisyouDao() {
        super(HM_SkHokenSyuruiNoAisyou.class);
    }

    public HM_SkHokenSyuruiNoAisyou getSkHokenSyuruiNoAisyou(C_HknsyuruiNo pHknsyuruino, Integer pHknsyuruinosdfrom, Integer pHknsyuruinosdto, String pHknsyuruinobetukey1, C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        HM_SkHokenSyuruiNoAisyou hM_SkHokenSyuruiNoAisyou =  new HM_SkHokenSyuruiNoAisyou();
        hM_SkHokenSyuruiNoAisyou.setHknsyuruino(pHknsyuruino);
        hM_SkHokenSyuruiNoAisyou.setHknsyuruinosdfrom(pHknsyuruinosdfrom);
        hM_SkHokenSyuruiNoAisyou.setHknsyuruinosdto(pHknsyuruinosdto);
        hM_SkHokenSyuruiNoAisyou.setHknsyuruinobetukey1(pHknsyuruinobetukey1);
        hM_SkHokenSyuruiNoAisyou.setAisyoumeichannelkbn(pAisyoumeichannelkbn);
        return this.selectOne(hM_SkHokenSyuruiNoAisyou);
    }

    public List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(
        C_HknsyuruiNo pHknsyuruino, C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {

        HM_SkHokenSyuruiNoAisyou hM_SkHokenSyuruiNoAisyou = new HM_SkHokenSyuruiNoAisyou();
        hM_SkHokenSyuruiNoAisyou.setHknsyuruino(pHknsyuruino);
        hM_SkHokenSyuruiNoAisyou.setAisyoumeichannelkbn(pAisyoumeichannelkbn);
        return this.select(hM_SkHokenSyuruiNoAisyou);
    }

    public List<HM_SkHokenSyuruiNoAisyou> getSkHokenSyuruiNoAisyousByPK(C_HknsyuruiNo pHknsyuruino,
        Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeichannelkbn, String pHknsyuruinobetukey1) {


        QHM_SkHokenSyuruiNoAisyou qHM_SkHokenSyuruiNoAisyou = new QHM_SkHokenSyuruiNoAisyou();


        String strSql = $SELECT + qHM_SkHokenSyuruiNoAisyou +
            $FROM + qHM_SkHokenSyuruiNoAisyou.HM_SkHokenSyuruiNoAisyou() +
            $WHERE + qHM_SkHokenSyuruiNoAisyou.hknsyuruino.eq(pHknsyuruino) +
            $AND + qHM_SkHokenSyuruiNoAisyou.hknsyuruinosdfrom.le(pHknsyuruinosd) +
            $AND + qHM_SkHokenSyuruiNoAisyou.hknsyuruinosdto.ge(pHknsyuruinosd) +
            $AND + qHM_SkHokenSyuruiNoAisyou.aisyoumeichannelkbn.eq(pAisyoumeichannelkbn) +
            $AND + qHM_SkHokenSyuruiNoAisyou.hknsyuruinobetukey1.eq(pHknsyuruinobetukey1);


        return em.createJPQL(strSql).bind(qHM_SkHokenSyuruiNoAisyou).getResultList();
    }
}
