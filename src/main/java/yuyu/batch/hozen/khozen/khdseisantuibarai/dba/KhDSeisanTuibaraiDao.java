package yuyu.batch.hozen.khozen.khdseisantuibarai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.meta.QIT_DSeisanTuibaraiKanri;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 契約保全 Ｄ精算追払DAOクラス
 */
public class KhDSeisanTuibaraiDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;
    public ExDBResults<KhDSeisanTuibaraiBean> getKhDSeisanTuibaraiKanriByHaitounendo(String pKakutyouJobCd, BizDateY pHaitouNendo) {

        QIT_DSeisanTuibaraiKanri qIT_DSeisanTuibaraiKanri = new QIT_DSeisanTuibaraiKanri("qIT_DSeisanTuibaraiKanri");

        String mainStr = $SELECT + $NEW(KhDSeisanTuibaraiBean.class,
            qIT_DSeisanTuibaraiKanri.kbnkey,
            qIT_DSeisanTuibaraiKanri.syono,
            qIT_DSeisanTuibaraiKanri.haitounendo,
            qIT_DSeisanTuibaraiKanri.syouhncd,
            qIT_DSeisanTuibaraiKanri.syouhnsdno,
            qIT_DSeisanTuibaraiKanri.kykymd,
            qIT_DSeisanTuibaraiKanri.kyktuukasyu,
            qIT_DSeisanTuibaraiKanri.shrhousiteikbn,
            qIT_DSeisanTuibaraiKanri.inputshrhousiteikbn,
            qIT_DSeisanTuibaraiKanri.tuibaraiyouhikbn,
            qIT_DSeisanTuibaraiKanri.tuutisakuseiyouhikbn,
            qIT_DSeisanTuibaraiKanri.dseisantetudukimeikbn,
            qIT_DSeisanTuibaraiKanri.shrymd,
            qIT_DSeisanTuibaraiKanri.shrtienrskkisanymd,
            qIT_DSeisanTuibaraiKanri.tienrsknissuu,
            qIT_DSeisanTuibaraiKanri.syoruiukeymd,
            qIT_DSeisanTuibaraiKanri.kouryokuhasseiymd,
            qIT_DSeisanTuibaraiKanri.shrtuukasyu,
            qIT_DSeisanTuibaraiKanri.gsbunritaisyou,
            qIT_DSeisanTuibaraiKanri.yenshrtkumu,
            qIT_DSeisanTuibaraiKanri.kzsyuruikbn,
            qIT_DSeisanTuibaraiKanri.bankcd,
            qIT_DSeisanTuibaraiKanri.sitencd,
            qIT_DSeisanTuibaraiKanri.yokinkbn,
            qIT_DSeisanTuibaraiKanri.kouzano,
            qIT_DSeisanTuibaraiKanri.kzdoukbn,
            qIT_DSeisanTuibaraiKanri.kzmeiginmkn,
            qIT_DSeisanTuibaraiKanri.gaikashrkwsratekjnymd,
            qIT_DSeisanTuibaraiKanri.gaikashrkwsrate,
            qIT_DSeisanTuibaraiKanri.zeimukwsratekjnymd,
            qIT_DSeisanTuibaraiKanri.zeimukwsrate,
            qIT_DSeisanTuibaraiKanri.nztodouhukencd,
            qIT_DSeisanTuibaraiKanri.yensynykngk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yensynykngk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenhtykeihi.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenhtykeihi.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenkztgk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenkztgk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrkykhtykeihi.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrkykhtykeihi.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.kykhnkkaisuu,
            qIT_DSeisanTuibaraiKanri.shrtysykurikosiyouhi,
            qIT_DSeisanTuibaraiKanri.shrtuukashrgkgoukei.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukashrgkgoukei.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukagstszeigk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukagstszeigk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukashrtienrsk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukashrtienrsk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukasonotashrkngk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.shrtuukasonotashrkngk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenkansanhaitoukin.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenkansanhaitoukin.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yensonotahaitoukin.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yensonotahaitoukin.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrgkgoukei.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrgkgoukei.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigknationaltax.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigknationaltax.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigklocaltax.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yengstszeigklocaltax.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrtienrsk.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.yenshrtienrsk.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.sonotashrkngkyen.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.sonotashrkngkyen.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.sonotashrkngksiteituuka.getTypeFieldName(),
            qIT_DSeisanTuibaraiKanri.sonotashrkngksiteituuka.getValueFieldName(),
            qIT_DSeisanTuibaraiKanri.kaiyakujiyuu,
            qIT_DSeisanTuibaraiKanri.soukinsakiyno,
            qIT_DSeisanTuibaraiKanri.soukinsakiadr1kj,
            qIT_DSeisanTuibaraiKanri.soukinsakiadr2kj,
            qIT_DSeisanTuibaraiKanri.soukinsakiadr3kj,
            qIT_DSeisanTuibaraiKanri.soukinsakinmkj,
            qIT_DSeisanTuibaraiKanri.dseisansouhusakihnsyukbn,
            qIT_DSeisanTuibaraiKanri.zeitratkikbn) +

            $FROM(qIT_DSeisanTuibaraiKanri) +
            $WHERE + qIT_DSeisanTuibaraiKanri.tuibaraiyouhikbn.eq(C_YouhiKbn.YOU) +
            $AND + qIT_DSeisanTuibaraiKanri.haitounendo.eq(pHaitouNendo);

        ExDBResults<KhDSeisanTuibaraiBean> exDBResults = exDBEntityManager.createJPQL(
            mainStr, KhDSeisanTuibaraiBean.class).bind(qIT_DSeisanTuibaraiKanri).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }
}
