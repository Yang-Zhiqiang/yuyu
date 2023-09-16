package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IW_KhHaitouTaisyouWK;
import java.util.List;

/**
 * 配当金算出対象抽出ワークテーブル(IW_KhHaitouTaisyouWKDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhHaitouTaisyouWKDao extends AbstractDao<IW_KhHaitouTaisyouWK> {

    public IW_KhHaitouTaisyouWKDao() {
        super(IW_KhHaitouTaisyouWK.class);
    }

    @Deprecated
    public IW_KhHaitouTaisyouWK getKhHaitouTaisyouWK(String pSyono, BizDate pSyoriYmd, C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn, C_HaitoumeisaiKbn pHaitoumeisaikbn, Integer pRenno) {
        IW_KhHaitouTaisyouWK iW_KhHaitouTaisyouWK =  new IW_KhHaitouTaisyouWK( pSyono,  pSyoriYmd,  pHaitoukinuketorihoukbn,  pHaitoumeisaikbn,  pRenno);
        return this.selectOne(iW_KhHaitouTaisyouWK);
    }

    @Override
    @Deprecated
    public List<IW_KhHaitouTaisyouWK> selectAll() {
        return super.selectAll();
    }
}
