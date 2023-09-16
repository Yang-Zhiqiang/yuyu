package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;

/**
 * 期日到来本番検証用通知状況テーブル(BT_KijituTuriHnbnKnsouTutJkDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KijituTuriHnbnKnsouTutJkDao extends AbstractDao<BT_KijituTuriHnbnKnsouTutJk> {

    public BT_KijituTuriHnbnKnsouTutJkDao() {
        super(BT_KijituTuriHnbnKnsouTutJk.class);
    }

    public BT_KijituTuriHnbnKnsouTutJk getKijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {
        BT_KijituTuriHnbnKnsouTutJk bT_KijituTuriHnbnKnsouTutJk =  new BT_KijituTuriHnbnKnsouTutJk();
        bT_KijituTuriHnbnKnsouTutJk.setSubSystemId(pSubSystemId);
        bT_KijituTuriHnbnKnsouTutJk.setTysytno(pTysytno);
        return this.selectOne(bT_KijituTuriHnbnKnsouTutJk);
    }
}
