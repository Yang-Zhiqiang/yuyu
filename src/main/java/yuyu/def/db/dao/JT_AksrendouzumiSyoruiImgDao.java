package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;

/**
 * ＡＫＳ連動済書類情報テーブル(JT_AksrendouzumiSyoruiImgDao) アクセス用の DAO クラスです。<br />
 */
public class JT_AksrendouzumiSyoruiImgDao extends AbstractDao<JT_AksrendouzumiSyoruiImg> {

    public JT_AksrendouzumiSyoruiImgDao() {
        super(JT_AksrendouzumiSyoruiImg.class);
    }

    public JT_AksrendouzumiSyoruiImg getAksrendouzumiSyoruiImg(String pSkno, String pSyono, String pImageid) {
        JT_AksrendouzumiSyoruiImg jT_AksrendouzumiSyoruiImg =  new JT_AksrendouzumiSyoruiImg();
        jT_AksrendouzumiSyoruiImg.setSkno(pSkno);
        jT_AksrendouzumiSyoruiImg.setSyono(pSyono);
        jT_AksrendouzumiSyoruiImg.setImageid(pImageid);
        return this.selectOne(jT_AksrendouzumiSyoruiImg);
    }

}
