package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.meta.QIM_KhHubiNaiyou;

/**
 * 契約保全不備内容マスタ(IM_KhHubiNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhHubiNaiyouDao extends AbstractDao<IM_KhHubiNaiyou> {

    public IM_KhHubiNaiyouDao() {
        super(IM_KhHubiNaiyou.class);
    }

    public IM_KhHubiNaiyou getKhHubiNaiyou(String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd,
        String pHubinaiyoucd){
        IM_KhHubiNaiyou iM_KhHubiNaiyou =  new IM_KhHubiNaiyou();
        iM_KhHubiNaiyou.setJimutetuzukicd(pJimutetuzukicd);
        iM_KhHubiNaiyou.setSyoruiCd(pSyoruiCd);
        iM_KhHubiNaiyou.setHubinaiyoucd(pHubinaiyoucd);
        return this.selectOne(iM_KhHubiNaiyou);
    }

    public List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd) {

        IM_KhHubiNaiyou iM_KhHubiNaiyou = new IM_KhHubiNaiyou();
        iM_KhHubiNaiyou.setJimutetuzukicd(pJimutetuzukicd);
        iM_KhHubiNaiyou.setSyoruiCd(pSyoruiCd);
        return this.select(iM_KhHubiNaiyou);
    }

    public List<IM_KhHubiNaiyou> getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems(String pJimutetuzukicd,
        C_SyoruiCdKbn pSyoruiCd, C_HassinsakiKbn pHassinsakikbn, C_KensakuyouGenponHnkykumu pKensakuyougenponhnkykumu,C_UmuKbn pGenponhnkykumu, String pHubinaiyou) {


        QIM_KhHubiNaiyou qIM_KhHubiNaiyou = new QIM_KhHubiNaiyou();


        String subquery = "";


        if(!pHassinsakikbn.eq(C_HassinsakiKbn.BLNK)){


            subquery = $AND + qIM_KhHubiNaiyou.hassinsakikbn.eq(pHassinsakikbn);
        }


        if (!pKensakuyougenponhnkykumu.eq(C_KensakuyouGenponHnkykumu.BLNK)) {


            subquery = subquery + $AND + qIM_KhHubiNaiyou.genponhnkykumu.eq(pGenponhnkykumu);
        }


        if (!StringUtil.isNullOrBlank(pHubinaiyou)) {


            subquery = subquery + $AND + qIM_KhHubiNaiyou.hubinaiyou.like("%" + pHubinaiyou + "%");
        }


        String querySql = $SELECT + qIM_KhHubiNaiyou +
            $FROM + qIM_KhHubiNaiyou.IM_KhHubiNaiyou() +
            $WHERE + qIM_KhHubiNaiyou.jimutetuzukicd.eq(pJimutetuzukicd) +
            $AND + qIM_KhHubiNaiyou.syoruiCd.eq(pSyoruiCd) +
            subquery +
            $ORDER_BY(qIM_KhHubiNaiyou.hubinaiyouhyoujijyun.asc(),
                qIM_KhHubiNaiyou.hubinaiyoucd.asc());

        return em.createJPQL(querySql).bind(qIM_KhHubiNaiyou).getResultList();
    }
}
