package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti;

/**
 * ＤＳ汎用顧客宛通知テーブル(MT_DsHanyouKokyakuateTuutiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHanyouKokyakuateTuutiDao extends AbstractDao<MT_DsHanyouKokyakuateTuuti> {

    public MT_DsHanyouKokyakuateTuutiDao() {
        super(MT_DsHanyouKokyakuateTuuti.class);
    }

    @Deprecated
    public MT_DsHanyouKokyakuateTuuti getDsHanyouKokyakuateTuuti(BizDate pDsdatasakuseiymd, String pDskokno, C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        MT_DsHanyouKokyakuateTuuti mT_DsHanyouKokyakuateTuuti =  new MT_DsHanyouKokyakuateTuuti();
        mT_DsHanyouKokyakuateTuuti.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsHanyouKokyakuateTuuti.setDskokno(pDskokno);
        mT_DsHanyouKokyakuateTuuti.setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
        return this.selectOne(mT_DsHanyouKokyakuateTuuti);
    }

    @Override
    @Deprecated
    public List<MT_DsHanyouKokyakuateTuuti> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<MT_DsHanyouKokyakuateTuuti> getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(
            BizDate pDsdatasakuseiymd) {


        QMT_DsHanyouKokyakuateTuuti qMT_DsHanyouKokyakuateTuuti = new QMT_DsHanyouKokyakuateTuuti();


        String strSql  = $SELECT + qMT_DsHanyouKokyakuateTuuti +
                $FROM + qMT_DsHanyouKokyakuateTuuti.MT_DsHanyouKokyakuateTuuti() +
                $WHERE + qMT_DsHanyouKokyakuateTuuti.dsdatasakuseiymd.eq(pDsdatasakuseiymd) +
                $AND + qMT_DsHanyouKokyakuateTuuti.dshanyoukokyakuatetuutikbn.eq(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);


        return em.createJPQL(strSql).bind(qMT_DsHanyouKokyakuateTuuti).getResults();
    }
}
