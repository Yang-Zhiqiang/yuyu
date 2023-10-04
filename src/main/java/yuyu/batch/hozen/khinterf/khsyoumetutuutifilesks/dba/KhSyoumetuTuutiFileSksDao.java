package yuyu.batch.hozen.khinterf.khsyoumetutuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_SyoumetuTuuti;

/**
 * 契約保全 インターフェイス 消滅通知Ｆ作成機能DAOクラス
 */
public class KhSyoumetuTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSyometuTuutiDataBean> getSyometuTuutiDataBeans(String pKakutyouJobCd, BizDate pSyoriYmd) {

        QIT_SyoumetuTuuti qIT_SyoumetuTuuti = new QIT_SyoumetuTuuti("qIT_SyoumetuTuuti");

        String subQuery = $SELECT + $NEW(KhSyometuTuutiDataBean.class,
            qIT_SyoumetuTuuti.kbnkey,
            qIT_SyoumetuTuuti.syono,
            qIT_SyoumetuTuuti.tyouhyouymd,
            qIT_SyoumetuTuuti.henkousikibetukey,
            qIT_SyoumetuTuuti.syoruiCd,
            qIT_SyoumetuTuuti.hassoukbn,
            qIT_SyoumetuTuuti.sksdoufuukbn,
            qIT_SyoumetuTuuti.mynosinkokuiraidoufuukbn,
            qIT_SyoumetuTuuti.shskyno,
            qIT_SyoumetuTuuti.shsadr1kj,
            qIT_SyoumetuTuuti.shsadr2kj,
            qIT_SyoumetuTuuti.shsadr3kj,
            qIT_SyoumetuTuuti.shsnmkj,
            qIT_SyoumetuTuuti.toiawaseyno,
            qIT_SyoumetuTuuti.toiawaseadr1kj,
            qIT_SyoumetuTuuti.toiawaseadr2kj,
            qIT_SyoumetuTuuti.toiawaseadr3kj,
            qIT_SyoumetuTuuti.toiawasekaisyanmkj,
            qIT_SyoumetuTuuti.toiawasesosikinmkj,
            qIT_SyoumetuTuuti.toiawasetelno,
            qIT_SyoumetuTuuti.toiawaseteluktkkanou1,
            qIT_SyoumetuTuuti.toiawaseteluktkkanou2,
            qIT_SyoumetuTuuti.toiawasesosikinmkj2,
            qIT_SyoumetuTuuti.toiawasetelno2,
            qIT_SyoumetuTuuti.syoumetuymd,
            qIT_SyoumetuTuuti.shrymd,
            qIT_SyoumetuTuuti.kyknmkj,
            qIT_SyoumetuTuuti.hhknnmkj,
            qIT_SyoumetuTuuti.keiyakuymd,
            qIT_SyoumetuTuuti.shrtuukakaiyakuhrkngkkei.getTypeFieldName(),
            qIT_SyoumetuTuuti.shrtuukakaiyakuhrkngkkei.getValueFieldName(),
            qIT_SyoumetuTuuti.kaiyakuhrkngkkeisiteituuka.getTypeFieldName(),
            qIT_SyoumetuTuuti.kaiyakuhrkngkkeisiteituuka.getValueFieldName(),
            qIT_SyoumetuTuuti.sonotaseisan.getTypeFieldName(),
            qIT_SyoumetuTuuti.sonotaseisan.getValueFieldName(),
            qIT_SyoumetuTuuti.yenkansanhaitoukin.getTypeFieldName(),
            qIT_SyoumetuTuuti.yenkansanhaitoukin.getValueFieldName(),
            qIT_SyoumetuTuuti.yensonotahaitoukin.getTypeFieldName(),
            qIT_SyoumetuTuuti.yensonotahaitoukin.getValueFieldName(),
            qIT_SyoumetuTuuti.shrtuukagstszeigk.getTypeFieldName(),
            qIT_SyoumetuTuuti.shrtuukagstszeigk.getValueFieldName(),
            qIT_SyoumetuTuuti.zitkazukarikingksiteituuka.getTypeFieldName(),
            qIT_SyoumetuTuuti.zitkazukarikingksiteituuka.getValueFieldName(),
            qIT_SyoumetuTuuti.shrgkkei.getTypeFieldName(),
            qIT_SyoumetuTuuti.shrgkkei.getValueFieldName(),
            qIT_SyoumetuTuuti.shrtuukasyu,
            qIT_SyoumetuTuuti.shrkwsrate,
            qIT_SyoumetuTuuti.bankcd,
            qIT_SyoumetuTuuti.sitencd,
            qIT_SyoumetuTuuti.banknmkj,
            qIT_SyoumetuTuuti.sitennmkj,
            qIT_SyoumetuTuuti.yokinkbn,
            qIT_SyoumetuTuuti.kouzano,
            qIT_SyoumetuTuuti.kzsyuruikbn,
            qIT_SyoumetuTuuti.kzmeiginmkn,
            qIT_SyoumetuTuuti.htsiryosyukbn,
            qIT_SyoumetuTuuti.synykngk.getTypeFieldName(),
            qIT_SyoumetuTuuti.synykngk.getValueFieldName(),
            qIT_SyoumetuTuuti.htykeihi.getTypeFieldName(),
            qIT_SyoumetuTuuti.htykeihi.getValueFieldName(),
            qIT_SyoumetuTuuti.shrkykhtykeihi.getTypeFieldName(),
            qIT_SyoumetuTuuti.shrkykhtykeihi.getValueFieldName(),
            qIT_SyoumetuTuuti.zeimunaiyouhensyuctrlkbn,
            qIT_SyoumetuTuuti.kykhnkkaisuu,
            qIT_SyoumetuTuuti.kykmsnkbn,
            qIT_SyoumetuTuuti.lastsyosaihkymd,
            qIT_SyoumetuTuuti.tsinyno,
            qIT_SyoumetuTuuti.tsintelno,
            qIT_SyoumetuTuuti.tsinadr1kj,
            qIT_SyoumetuTuuti.tsinadr2kj,
            qIT_SyoumetuTuuti.tsinadr3kj,
            qIT_SyoumetuTuuti.toritugisyasyozokunm,
            qIT_SyoumetuTuuti.toritugisyakjncd,
            qIT_SyoumetuTuuti.toritugisyanm) +
            $FROM(qIT_SyoumetuTuuti) +
            $WHERE + qIT_SyoumetuTuuti.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhSyometuTuutiDataBean> exDBResults = exDBEntityManager.createJPQL(subQuery,
            KhSyometuTuutiDataBean.class).bind(qIT_SyoumetuTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

}
