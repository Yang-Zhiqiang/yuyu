package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;

/**
 * 支払不備内容マスタ(JM_SiHubiNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SiHubiNaiyouDao extends AbstractDao<JM_SiHubiNaiyou> {

    public JM_SiHubiNaiyouDao() {
        super(JM_SiHubiNaiyou.class);
    }

    public JM_SiHubiNaiyou getSiHubiNaiyou(String pJimutetuzukicd,
            C_SyoruiCdKbn pSyoruiCd,
            String pHubinaiyoucd){
        JM_SiHubiNaiyou jM_SiHubiNaiyou =  new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou.setJimutetuzukicd(pJimutetuzukicd);
        jM_SiHubiNaiyou.setSyoruiCd(pSyoruiCd);
        jM_SiHubiNaiyou.setHubinaiyoucd(pHubinaiyoucd);
        return this.selectOne(jM_SiHubiNaiyou);
    }

    public List<JM_SiHubiNaiyou> getSiHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {

        JM_SiHubiNaiyou jM_SiHubiNaiyou =  new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou.setJimutetuzukicd(pJimutetuzukicd);
        jM_SiHubiNaiyou.setSyoruiCd(pSyoruiCd);

        return this.select(jM_SiHubiNaiyou);
    }
}
