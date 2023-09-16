package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.db.meta.QIT_KhHubiMikaisyouList;

/**
 * 契約保全不備未解消リストテーブル(IT_KhHubiMikaisyouListDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhHubiMikaisyouListDao extends AbstractDao<IT_KhHubiMikaisyouList> {

    public IT_KhHubiMikaisyouListDao() {
        super(IT_KhHubiMikaisyouList.class);
    }

    public IT_KhHubiMikaisyouList getKhHubiMikaisyouList(String pJimutetuzukicd,
        String pSyono,
        C_HassinsakiKbn pHassinsakikbn){
        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList =  new IT_KhHubiMikaisyouList();
        iT_KhHubiMikaisyouList.setJimutetuzukicd(pJimutetuzukicd);
        iT_KhHubiMikaisyouList.setSyono(pSyono);
        iT_KhHubiMikaisyouList.setHassinsakikbn(pHassinsakikbn);
        return this.selectOne(iT_KhHubiMikaisyouList);
    }

    public ExDBResults<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByJimutetuzukicd(String pJimutetuzukicd) {


        QIT_KhHubiMikaisyouList qIT_KhHubiMikaisyouList =  new QIT_KhHubiMikaisyouList();


        String querySql = $SELECT + qIT_KhHubiMikaisyouList +
            $FROM + qIT_KhHubiMikaisyouList.IT_KhHubiMikaisyouList() +
            $WHERE + qIT_KhHubiMikaisyouList.jimutetuzukicd.eq(pJimutetuzukicd) +
            $ORDER_BY(qIT_KhHubiMikaisyouList.lasthubbihasinymd.asc(),
                qIT_KhHubiMikaisyouList.syono.asc(),
                qIT_KhHubiMikaisyouList.hassinsakikbn.asc());

        return em.createJPQL(querySql).bind(qIT_KhHubiMikaisyouList).getResults();
    }

    public List<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByJimutetuzukicdSyono(String pJimutetuzukicd, String pSyono) {


        IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList = new IT_KhHubiMikaisyouList();
        iT_KhHubiMikaisyouList.setJimutetuzukicd(pJimutetuzukicd);
        iT_KhHubiMikaisyouList.setSyono(pSyono);


        return this.select(iT_KhHubiMikaisyouList);
    }

    public ExDBResults<IT_KhHubiMikaisyouList> getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(
        String pJimutetuzukicd) {


        QIT_KhHubiMikaisyouList qIT_KhHubiMikaisyouList = new QIT_KhHubiMikaisyouList();


        String querySql = $SELECT + qIT_KhHubiMikaisyouList +
            $FROM + qIT_KhHubiMikaisyouList.IT_KhHubiMikaisyouList() +
            $WHERE + qIT_KhHubiMikaisyouList.jimutetuzukicd.eq(pJimutetuzukicd) +
            $ORDER_BY(qIT_KhHubiMikaisyouList.lasthubbihasinymd.asc(),
                qIT_KhHubiMikaisyouList.syono.asc(),
                qIT_KhHubiMikaisyouList.hassinsakikbn.asc());

        return em.createJPQL(querySql).bind(qIT_KhHubiMikaisyouList).getResults();
    }
}
