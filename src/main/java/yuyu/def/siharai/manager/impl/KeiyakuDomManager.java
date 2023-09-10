package yuyu.def.siharai.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.dao.JM_KyuuhuDao;
import yuyu.def.db.dao.JM_SiSyouhnZokuseiDao;
import yuyu.def.db.dao.JT_SiKykKihonDao;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;
import yuyu.def.siharai.sorter.SortJM_Kyuuhu;
import yuyu.def.siharai.sorter.SortJM_SiSyouhnZokusei;
import yuyu.def.siharai.sorter.SortJT_SiKykKihon;


/**
 * KeiyakuDomマネージャー<br />
 * Keiyakuにおける、DB操作を提供する。<br />
 */
class KeiyakuDomManager {


    @Inject
    private JM_KyuuhuDao kyuuhuDao;


    @Inject
    private JM_SiSyouhnZokuseiDao siSyouhnZokuseiDao;


    @Inject
    private JT_SiKykKihonDao siKykKihonDao;


    List<JT_SiKykKihon> getAllSiKykKihon(){
        SortJT_SiKykKihon sortJT_SiKykKihon = new SortJT_SiKykKihon();
        return sortJT_SiKykKihon.OrderJT_SiKykKihonByPkAsc(siKykKihonDao.selectAll());
    }


    JT_SiKykKihon getSiKykKihon(String pSyono) {

        return siKykKihonDao.getSiKykKihon(pSyono);
    }


    ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean>  getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {

        return siKykKihonDao.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(pSeikyuusyubetu, pSyoriYmdFrom, pSyoriYmdTo);
    }


    List<JM_SiSyouhnZokusei> getAllSiSyouhnZokusei(){
        SortJM_SiSyouhnZokusei sortJM_SiSyouhnZokusei = new SortJM_SiSyouhnZokusei();
        return sortJM_SiSyouhnZokusei.OrderJM_SiSyouhnZokuseiByPkAsc(siSyouhnZokuseiDao.selectAll());
    }


    JM_SiSyouhnZokusei getSiSyouhnZokusei(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno, String pKyuuhucd) {

        return siSyouhnZokuseiDao.getSiSyouhnZokusei(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno, pKyuuhucd);
    }


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdSyouhnsdno(String pSyouhncd, Integer pSyouhnsdno) {

        return siSyouhnZokuseiDao.getSiSyouhnZokuseisBySyouhncdSyouhnsdno(pSyouhncd, pSyouhnsdno);
    }


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisByKyuuhu(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {

        return siSyouhnZokuseiDao.getSiSyouhnZokuseisByKyuuhu(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno);
    }


    List<JM_Kyuuhu> getAllKyuuhu(){
        SortJM_Kyuuhu sortJM_Kyuuhu = new SortJM_Kyuuhu();
        return sortJM_Kyuuhu.OrderJM_KyuuhuByPkAsc(kyuuhuDao.selectAll());
    }


    JM_Kyuuhu getKyuuhu(String pKyuuhucd) {

        return kyuuhuDao.getKyuuhu(pKyuuhucd);
    }


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {

        return siSyouhnZokuseiDao.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno);
    }


    JM_SiSyouhnZokusei getSiSyouhnZokuseisBySyouhncd(String pSyouhncd) {

        return siSyouhnZokuseiDao.getSiSyouhnZokuseisBySyouhncd(pSyouhncd);
    }

}
