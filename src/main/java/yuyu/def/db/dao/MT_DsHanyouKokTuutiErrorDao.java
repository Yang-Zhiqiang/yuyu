package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import java.util.List;

/**
 * ＤＳ汎用顧客宛通知エラーテーブル(MT_DsHanyouKokTuutiErrorDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHanyouKokTuutiErrorDao extends AbstractDao<MT_DsHanyouKokTuutiError> {

    public MT_DsHanyouKokTuutiErrorDao() {
        super(MT_DsHanyouKokTuutiError.class);
    }

    @Deprecated
    public MT_DsHanyouKokTuutiError getDsHanyouKokTuutiError(BizDate pDsdatasakuseiymd, String pDskoktuutirenno, String pDskokno, C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        MT_DsHanyouKokTuutiError mT_DsHanyouKokTuutiError =  new MT_DsHanyouKokTuutiError();
        mT_DsHanyouKokTuutiError.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsHanyouKokTuutiError.setDskoktuutirenno(pDskoktuutirenno);
        mT_DsHanyouKokTuutiError.setDskokno(pDskokno);
        mT_DsHanyouKokTuutiError.setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
        return this.selectOne(mT_DsHanyouKokTuutiError);
    }

    @Override
    @Deprecated
    public List<MT_DsHanyouKokTuutiError> selectAll() {
        return super.selectAll();
    }
}
