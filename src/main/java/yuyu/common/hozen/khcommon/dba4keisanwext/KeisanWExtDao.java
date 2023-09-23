package yuyu.common.hozen.khcommon.dba4keisanwext;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 共通 解約返戻金計算拡張情報作成DAOクラス
 */
public class KeisanWExtDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public KeisanWKykInfoBean getKeisanWKykInfoBean(String pSyono) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        String strSql = $SELECT + $NEW(KeisanWKykInfoBean.class,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_KykSyouhn.ryouritusdno,
            qIT_KykSyouhn.yoteiriritu,
            qIT_KykKihon.hrkkaisuu,
            qIT_KykKihon.fstpnyknymd,
            qIT_KykSyouhn.hknkknsmnkbn,
            qIT_KykSyouhn.hrkkknsmnkbn,
            qIT_KykSyouhn.hrkkkn,
            qIT_KykSyouhn.hknkkn,
            qIT_KykSyouhn.hhknnen,
            qIT_KykSyouhn.hhknsei,
            qIT_KykSyouhn.kihons.getTypeFieldName(),
            qIT_KykSyouhn.kihons.getValueFieldName(),
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName(),
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.kyksjkkktyouseiriritu,
            qIT_KykSyouhn.tumitateriritu,
            qIT_KykSyouhn.yoteirrthendohosyurrt,
            qIT_KykSyouhn.yendthnkymd,
            qIT_KykSyouhn.dai1hknkkn,
            qIT_KykSyouhn.kykjyoutai,
            qBM_SyouhnZokusei.mvatekiumu,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykSonotaTkyk.teikishrtkykhukaumu) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qBM_SyouhnZokusei,
                qIT_AnsyuKihon,
                qIT_KykSonotaTkyk) +
                $WHERE + qIT_KykKihon.syono.eq(pSyono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qIT_KykSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSonotaTkyk.syono);

        KeisanWKykInfoBean keisanWKykInfoBean = exDBEntityManager.createJPQL(strSql,
            KeisanWKykInfoBean.class).bind(qIT_KykKihon, qIT_KykSyouhn,
                qBM_SyouhnZokusei, qIT_AnsyuKihon, qIT_KykSonotaTkyk).getSingleResult();

        return keisanWKykInfoBean;
    }
}
