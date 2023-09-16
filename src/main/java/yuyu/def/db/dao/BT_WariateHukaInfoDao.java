package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_WariateHukaInfo;

/**
 * 割当不可情報テーブル(BT_WariateHukaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BT_WariateHukaInfoDao extends AbstractDao<BT_WariateHukaInfo> {

    public BT_WariateHukaInfoDao() {
        super(BT_WariateHukaInfo.class);
    }

    public BT_WariateHukaInfo getWariateHukaInfo(String pKouteikanriid,
        String pSubSystemId,
        String pJimutetuzukicd,
        String pWrthukatskid,
        String pUserId){
        BT_WariateHukaInfo bT_WariateHukaInfo =  new BT_WariateHukaInfo();
        bT_WariateHukaInfo.setKouteikanriid(pKouteikanriid);
        bT_WariateHukaInfo.setSubSystemId(pSubSystemId);
        bT_WariateHukaInfo.setJimutetuzukicd(pJimutetuzukicd);
        bT_WariateHukaInfo.setWrthukatskid(pWrthukatskid);
        bT_WariateHukaInfo.setUserId(pUserId);
        return this.selectOne(bT_WariateHukaInfo);
    }

    public List<BT_WariateHukaInfo> getWariateHukaInfosBySubSystemIdUserId(String pSubSystemId, String pUserId) {

        BT_WariateHukaInfo bT_WariateHukaInfo =  new BT_WariateHukaInfo();

        bT_WariateHukaInfo.setSubSystemId(pSubSystemId);
        bT_WariateHukaInfo.setUserId(pUserId);
        return this.select(bT_WariateHukaInfo);
    }

    public List<BT_WariateHukaInfo> getWariateHukaInfosByPKWithoutUserId(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukatskid) {

        BT_WariateHukaInfo bT_WariateHukaInfo =  new BT_WariateHukaInfo();

        bT_WariateHukaInfo.setKouteikanriid(pKouteikanriid);
        bT_WariateHukaInfo.setSubSystemId(pSubSystemId);
        bT_WariateHukaInfo.setJimutetuzukicd(pJimutetuzukicd);
        bT_WariateHukaInfo.setWrthukatskid(pWrthukatskid);
        return this.select(bT_WariateHukaInfo);

    }

    public List<BT_WariateHukaInfo> getWariateHukaInfosByKouteikanriidSubSystemIdJimutetuzukicdWrthukakaijyotskid(String pKouteikanriid, String pSubSystemId, String pJimutetuzukicd, String pWrthukakaijyotskid) {

        BT_WariateHukaInfo bT_WariateHukaInfo =  new BT_WariateHukaInfo();

        bT_WariateHukaInfo.setKouteikanriid(pKouteikanriid);
        bT_WariateHukaInfo.setSubSystemId(pSubSystemId);
        bT_WariateHukaInfo.setJimutetuzukicd(pJimutetuzukicd);
        bT_WariateHukaInfo.setWrthukakaijyotskid(pWrthukakaijyotskid);
        return this.select(bT_WariateHukaInfo);
    }
}
