package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.biz.result.bean.GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.meta.QBT_GyoumuKouteiInfo;

/**
 * 業務用工程情報テーブル(BT_GyoumuKouteiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_GyoumuKouteiInfoDao extends AbstractDao<BT_GyoumuKouteiInfo> {

    public BT_GyoumuKouteiInfoDao() {
        super(BT_GyoumuKouteiInfo.class);
    }

    public BT_GyoumuKouteiInfo getGyoumuKouteiInfo(String pKouteikanriid){
        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo =  new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setKouteikanriid(pKouteikanriid);
        return this.selectOne(bT_GyoumuKouteiInfo);
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriids(String[] pSyukouteikanriid) {


        QBT_GyoumuKouteiInfo qBT_GyoumuKouteiInfo = new QBT_GyoumuKouteiInfo();


        String querySql = $SELECT + qBT_GyoumuKouteiInfo +
            $FROM + qBT_GyoumuKouteiInfo.BT_GyoumuKouteiInfo() +
            $WHERE + qBT_GyoumuKouteiInfo.syukouteikanriid.in(pSyukouteikanriid) +
            $ORDER_BY(qBT_GyoumuKouteiInfo.kouteikanriid.asc());

        return em.createJPQL(querySql).bind(qBT_GyoumuKouteiInfo).getResultList();
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySkno(String pSkno) {
        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setSkno(pSkno);
        return this.select(bT_GyoumuKouteiInfo);
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByMosno(String pMosno) {


        QBT_GyoumuKouteiInfo qBT_GyoumuKouteiInfo = new QBT_GyoumuKouteiInfo();


        String querySql = $SELECT + qBT_GyoumuKouteiInfo +
            $FROM + qBT_GyoumuKouteiInfo.BT_GyoumuKouteiInfo() +
            $WHERE + qBT_GyoumuKouteiInfo.mosno.eq(pMosno) +
            $AND + qBT_GyoumuKouteiInfo.syukouteikanriid.eq(qBT_GyoumuKouteiInfo.kouteikanriid);

        return em.createJPQL(querySql).bind(qBT_GyoumuKouteiInfo).getResultList();
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyonoSkno(String pSyono, String pSkno) {
        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setSyono(pSyono);
        bT_GyoumuKouteiInfo.setSkno(pSkno);
        return this.select(bT_GyoumuKouteiInfo);
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd(
        String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setSyukouteikanriid(pSyukouteikanriid);
        bT_GyoumuKouteiInfo.setSyukouteijimutetuzukicd(pSyukouteijimutetuzukicd);
        return this.select(bT_GyoumuKouteiInfo);
    }

    public List<GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean> getGyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicd2(
        String pSyukouteikanriid, String pSyukouteijimutetuzukicd) {
        QBT_GyoumuKouteiInfo qBT_GyoumuKouteiInfo = new QBT_GyoumuKouteiInfo("qBT_GyoumuKouteiInfo");

        String jpql = $SELECT + $NEW(GyoumuKouteiInfosBySyukouteikanriidSyukouteijimutetuzukicdBean.class,
            qBT_GyoumuKouteiInfo.kouteikanriid,
            qBT_GyoumuKouteiInfo.jimutetuzukicd
            ) +
            $FROM(qBT_GyoumuKouteiInfo) +
            $WHERE + qBT_GyoumuKouteiInfo.syukouteikanriid.eq(pSyukouteikanriid) +
            $AND + qBT_GyoumuKouteiInfo.syukouteijimutetuzukicd.eq(pSyukouteijimutetuzukicd);

        return em.createJPQL(jpql).bind(qBT_GyoumuKouteiInfo).getResultList();
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyukouteikanriid(String pJimutetuzukicd,
        String pSyukouteikanriid) {

        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo =  new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setJimutetuzukicd(pJimutetuzukicd);
        bT_GyoumuKouteiInfo.setSyukouteikanriid(pSyukouteikanriid);
        return this.select(bT_GyoumuKouteiInfo);
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(String pJimutetuzukicd,
        String pSyono, String pSkno) {


        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setJimutetuzukicd(pJimutetuzukicd);
        bT_GyoumuKouteiInfo.setSyono(pSyono);
        bT_GyoumuKouteiInfo.setSkno(pSkno);


        return this.select(bT_GyoumuKouteiInfo);
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfosBySyukouteikanriid(String pSyukouteikanriid) {


        BT_GyoumuKouteiInfo bT_GyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        bT_GyoumuKouteiInfo.setSyukouteikanriid(pSyukouteikanriid);


        return this.select(bT_GyoumuKouteiInfo);
    }
}
