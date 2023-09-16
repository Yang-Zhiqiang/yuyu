package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;

/**
 * 期日到来本番検証用通知テーブル(BT_KijituTuriHnbnKnsouTutDao) アクセス用の DAO クラスです。<br />
 */
public class BT_KijituTuriHnbnKnsouTutDao extends AbstractDao<BT_KijituTuriHnbnKnsouTut> {

    public BT_KijituTuriHnbnKnsouTutDao() {
        super(BT_KijituTuriHnbnKnsouTut.class);
    }

    public BT_KijituTuriHnbnKnsouTut getKijituTuriHnbnKnsouTut(BizDate pSyoriYmd, String pSubSystemId, Integer pTysytno) {
        BT_KijituTuriHnbnKnsouTut bT_KijituTuriHnbnKnsouTut =  new BT_KijituTuriHnbnKnsouTut();
        bT_KijituTuriHnbnKnsouTut.setSyoriYmd(pSyoriYmd);
        bT_KijituTuriHnbnKnsouTut.setSubSystemId(pSubSystemId);
        bT_KijituTuriHnbnKnsouTut.setTysytno(pTysytno);
        return this.selectOne(bT_KijituTuriHnbnKnsouTut);
    }
}
