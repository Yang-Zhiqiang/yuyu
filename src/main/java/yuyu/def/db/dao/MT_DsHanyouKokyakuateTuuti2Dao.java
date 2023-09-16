package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import java.util.List;

/**
 * ＤＳ汎用顧客宛通知２テーブル(MT_DsHanyouKokyakuateTuuti2Dao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHanyouKokyakuateTuuti2Dao extends AbstractDao<MT_DsHanyouKokyakuateTuuti2> {

    public MT_DsHanyouKokyakuateTuuti2Dao() {
        super(MT_DsHanyouKokyakuateTuuti2.class);
    }

    @Deprecated
    public MT_DsHanyouKokyakuateTuuti2 getDsHanyouKokyakuateTuuti2(BizDate pDsdatasakuseiymd, String pDskoktuutirenno, String pDskokno, C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        MT_DsHanyouKokyakuateTuuti2 mT_DsHanyouKokyakuateTuuti2 =  new MT_DsHanyouKokyakuateTuuti2();
        mT_DsHanyouKokyakuateTuuti2.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsHanyouKokyakuateTuuti2.setDskoktuutirenno(pDskoktuutirenno);
        mT_DsHanyouKokyakuateTuuti2.setDskokno(pDskokno);
        mT_DsHanyouKokyakuateTuuti2.setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
        return this.selectOne(mT_DsHanyouKokyakuateTuuti2);
    }

    @Override
    @Deprecated
    public List<MT_DsHanyouKokyakuateTuuti2> selectAll() {
        return super.selectAll();
    }
}
