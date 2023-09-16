package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD2;

/**
 * 利差配当商品用Ｄレートマスタ２(BM_RisaHitSyouhnyouRateD2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_RisaHitSyouhnyouRateD2Dao extends AbstractDao<BM_RisaHitSyouhnyouRateD2> {

    public BM_RisaHitSyouhnyouRateD2Dao() {
        super(BM_RisaHitSyouhnyouRateD2.class);
    }

    public BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu, String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan, String pPalannaihuyouriyuukbn, String pRatetuukasyukbn, String pRatedai1hknkkn, String pPaldnendo, String pPaldratenaikakucode) {
        BM_RisaHitSyouhnyouRateD2 bM_RisaHitSyouhnyouRateD2 =  new BM_RisaHitSyouhnyouRateD2();
        bM_RisaHitSyouhnyouRateD2.setPalhokensyuruikigou(pPalhokensyuruikigou);
        bM_RisaHitSyouhnyouRateD2.setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
        bM_RisaHitSyouhnyouRateD2.setPalyoteiriritu(pPalyoteiriritu);
        bM_RisaHitSyouhnyouRateD2.setPalpmencode(pPalpmencode);
        bM_RisaHitSyouhnyouRateD2.setPalharaikomikaisuu(pPalharaikomikaisuu);
        bM_RisaHitSyouhnyouRateD2.setPalhhknsei(pPalhhknsei);
        bM_RisaHitSyouhnyouRateD2.setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
        bM_RisaHitSyouhnyouRateD2.setPalsaimankihyouji(pPalsaimankihyouji);
        bM_RisaHitSyouhnyouRateD2.setPalhokenkikan(pPalhokenkikan);
        bM_RisaHitSyouhnyouRateD2.setPalpharaikomikikan(pPalpharaikomikikan);
        bM_RisaHitSyouhnyouRateD2.setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
        bM_RisaHitSyouhnyouRateD2.setRatetuukasyukbn(pRatetuukasyukbn);
        bM_RisaHitSyouhnyouRateD2.setRatedai1hknkkn(pRatedai1hknkkn);
        bM_RisaHitSyouhnyouRateD2.setPaldnendo(pPaldnendo);
        bM_RisaHitSyouhnyouRateD2.setPaldratenaikakucode(pPaldratenaikakucode);
        return this.selectOne(bM_RisaHitSyouhnyouRateD2);
    }

    public BM_RisaHitSyouhnyouRateD2 getRisaHitSyouhnyouRateD2byRisaHitSyouhnyouRateDkey(String pPalhokensyuruikigou, String pPalhokensyuruikigousdicode, String pPalyoteiriritu,
        String pPalpmencode, String pPalharaikomikaisuu, String pPalhhknsei, String pPalkeiyakujihhknnen, String pPalsaimankihyouji, String pPalhokenkikan, String pPalpharaikomikikan,
        String pPaldnendo, String pPaldratenaikakucode) {


        QBM_RisaHitSyouhnyouRateD2 qBM_RisaHitSyouhnyouRateD2 = new QBM_RisaHitSyouhnyouRateD2("qBM_RisaHitSyouhnyouRateD2");


        String queryStr = $SELECT + qBM_RisaHitSyouhnyouRateD2 +
            $FROM (qBM_RisaHitSyouhnyouRateD2) +
            $WHERE + qBM_RisaHitSyouhnyouRateD2.palhokensyuruikigou.eq(pPalhokensyuruikigou) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palhokensyuruikigousdicode.eq(pPalhokensyuruikigousdicode) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palyoteiriritu.eq(pPalyoteiriritu) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palpmencode.eq(pPalpmencode) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palharaikomikaisuu.eq(pPalharaikomikaisuu) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palhhknsei.eq(pPalhhknsei) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palkeiyakujihhknnen.eq(pPalkeiyakujihhknnen) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palsaimankihyouji.eq(pPalsaimankihyouji) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palhokenkikan.eq(pPalhokenkikan) +
            $AND + qBM_RisaHitSyouhnyouRateD2.palpharaikomikikan.eq(pPalpharaikomikikan) +
            $AND + qBM_RisaHitSyouhnyouRateD2.paldnendo.eq(pPaldnendo) +
            $AND + qBM_RisaHitSyouhnyouRateD2.paldratenaikakucode.eq(pPaldratenaikakucode);


        return em.createJPQL(queryStr).bind(qBM_RisaHitSyouhnyouRateD2).getSingleResult();
    }
}
