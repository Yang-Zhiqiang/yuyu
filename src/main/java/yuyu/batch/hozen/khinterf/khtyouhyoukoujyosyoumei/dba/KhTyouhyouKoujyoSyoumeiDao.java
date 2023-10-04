package yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.db.meta.QIT_KoujyoSym;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;

/**
 * 契約保全 控除証明書Ｆ作成機能DAOクラス
 */
public class KhTyouhyouKoujyoSyoumeiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KoujyoSymDataBean> getKoujyoSymsByKakutyoujobcdTyouhyouymdKbnkey(
        String pKakutyoujobcd,
        BizDate pTyouhyouymd,
        String pKbnkey) {

        QIT_KoujyoSym qIT_KoujyoSym = new QIT_KoujyoSym("qIT_KoujyoSym");

        String where = "";
        where = $WHERE + qIT_KoujyoSym.tyouhyouymd.eq(pTyouhyouymd);
        if (!BizUtil.isBlank(pKbnkey)) {
            where += $AND+ qIT_KoujyoSym.kbnkey.eq(pKbnkey);
        }
        where += $AND+ qIT_KoujyoSym.kjsmsakuseisyorikbn.eq(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        String strSql = $SELECT + $NEW(KoujyoSymDataBean.class,
            qIT_KoujyoSym.kbnkey,
            qIT_KoujyoSym.syono,
            qIT_KoujyoSym.nendo,
            qIT_KoujyoSym.tyouhyouymd,
            qIT_KoujyoSym.renno,
            qIT_KoujyoSym.kjsmsakuseisyorikbn,
            qIT_KoujyoSym.tekiyouseidokbn,
            qIT_KoujyoSym.syoumeiymd,
            qIT_KoujyoSym.syoumeistartym,
            qIT_KoujyoSym.syoumeiendym,
            qIT_KoujyoSym.syoumeikkntukisuu,
            qIT_KoujyoSym.syoumeikknnensuu,
            qIT_KoujyoSym.kyknmkj,
            qIT_KoujyoSym.uktnmkjaddsama,
            qIT_KoujyoSym.nenkinuktseiymd,
            qIT_KoujyoSym.hknsyuruinmrykkj,
            qIT_KoujyoSym.kykymd,
            qIT_KoujyoSym.hknkknsmnkbnsyu,
            qIT_KoujyoSym.hknkknsyu,
            qIT_KoujyoSym.nenkanhrkkaisuu,
            qIT_KoujyoSym.phrkkkn,
            qIT_KoujyoSym.nkshrstartymd,
            qIT_KoujyoSym.nknshry,
            qIT_KoujyoSym.kykjyoutai,
            qIT_KoujyoSym.yuukousyoumetukbn,
            qIT_KoujyoSym.haitoukinuketorihoukbn,
            qIT_KoujyoSym.oldippanjissekip.getTypeFieldName() +
            $AS + ("oldippanjissekipType"),
            qIT_KoujyoSym.oldippanjissekip.getValueFieldName(),
            qIT_KoujyoSym.oldippannenkanp.getTypeFieldName() +
            $AS + ("oldippannenkanpType"),
            qIT_KoujyoSym.oldippannenkanp.getValueFieldName(),
            qIT_KoujyoSym.oldippanjissekihaitoukin.getTypeFieldName() +
            $AS + ("oldippanjissekihaitoukinType"),
            qIT_KoujyoSym.oldippanjissekihaitoukin.getValueFieldName(),
            qIT_KoujyoSym.oldippannenkanhaitoukin.getTypeFieldName()  +
            $AS + ("oldippannenkanhaitoukinType"),
            qIT_KoujyoSym.oldippannenkanhaitoukin.getValueFieldName(),
            qIT_KoujyoSym.oldippanjissekisyoumeigk.getTypeFieldName() +
            $AS + ("oldippanjissekisyoumeigkType"),
            qIT_KoujyoSym.oldippanjissekisyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.oldippannenkansyoumeigk.getTypeFieldName() +
            $AS + ("oldippannenkansyoumeigkType"),
            qIT_KoujyoSym.oldippannenkansyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newippanjissekip.getTypeFieldName() +
            $AS + ("newippanjissekipType"),
            qIT_KoujyoSym.newippanjissekip.getValueFieldName() ,
            qIT_KoujyoSym.newippannenkanp.getTypeFieldName() +
            $AS + ("newippannenkanpType"),
            qIT_KoujyoSym.newippannenkanp.getValueFieldName(),
            qIT_KoujyoSym.newippanjissekihaitoukin.getTypeFieldName() +
            $AS + ("newippanjissekihaitoukinType"),
            qIT_KoujyoSym.newippanjissekihaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newippannenkanhaitoukin.getTypeFieldName() +
            $AS + ("newippannenkanhaitoukinType"),
            qIT_KoujyoSym.newippannenkanhaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newippanjissekisyoumeigk.getTypeFieldName() +
            $AS + ("newippanjissekisyoumeigkType"),
            qIT_KoujyoSym.newippanjissekisyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newippannenkansyoumeigk.getTypeFieldName() +
            $AS + ("newippannenkansyoumeigkType"),
            qIT_KoujyoSym.newippannenkansyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newiryoujissekip.getTypeFieldName() +
            $AS + ("newiryoujissekipType"),
            qIT_KoujyoSym.newiryoujissekip.getValueFieldName(),
            qIT_KoujyoSym.newiryounenkanp.getTypeFieldName() +
            $AS + ("newiryounenkanpType"),
            qIT_KoujyoSym.newiryounenkanp.getValueFieldName(),
            qIT_KoujyoSym.newiryoujissekihaitoukin.getTypeFieldName() +
            $AS + ("newiryoujissekihaitoukinType"),
            qIT_KoujyoSym.newiryoujissekihaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newiryounenkanhaitoukin.getTypeFieldName() +
            $AS + ("newiryounenkanhaitoukinType"),
            qIT_KoujyoSym.newiryounenkanhaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newiryoujissekisyoumeigk.getTypeFieldName() +
            $AS + ("newiryoujissekisyoumeigkType"),
            qIT_KoujyoSym.newiryoujissekisyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newiryounenkansyoumeigk.getTypeFieldName() +
            $AS + ("newiryounenkansyoumeigkType"),
            qIT_KoujyoSym.newiryounenkansyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newnkjissekip.getTypeFieldName() +
            $AS + ("newnkjissekipType"),
            qIT_KoujyoSym.newnkjissekip.getValueFieldName(),
            qIT_KoujyoSym.newnknenkanp.getTypeFieldName() +
            $AS + ("newnknenkanpType"),
            qIT_KoujyoSym.newnknenkanp.getValueFieldName(),
            qIT_KoujyoSym.newnkjissekihaitoukin.getTypeFieldName() +
            $AS + ("newnkjissekihaitoukinType"),
            qIT_KoujyoSym.newnkjissekihaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newnknenkanhaitoukin.getTypeFieldName() +
            $AS + ("newnknenkanhaitoukinType"),
            qIT_KoujyoSym.newnknenkanhaitoukin.getValueFieldName(),
            qIT_KoujyoSym.newnkjissekisyoumeigk.getTypeFieldName() +
            $AS + ("newnkjissekisyoumeigkType"),
            qIT_KoujyoSym.newnkjissekisyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.newnknenkansyoumeigk.getTypeFieldName() +
            $AS + ("newnknenkansyoumeigkType"),
            qIT_KoujyoSym.newnknenkansyoumeigk.getValueFieldName(),
            qIT_KoujyoSym.kjnnkkoujyum,
            qIT_KoujyoSym.tsinyno,
            qIT_KoujyoSym.tsinadr1kj,
            qIT_KoujyoSym.tsinadr2kj,
            qIT_KoujyoSym.tsinadr3kj,
            qIT_KoujyoSym.toiawasesosikinmkj,
            qIT_KoujyoSym.toiawaseyno,
            qIT_KoujyoSym.toiawaseadr1kj,
            qIT_KoujyoSym.toiawaseadr2kj,
            qIT_KoujyoSym.toiawaseadr3kj,
            qIT_KoujyoSym.toiawasetelno,
            qIT_KoujyoSym.toiawaseteluktkkanou1,
            qIT_KoujyoSym.toiawaseteluktkkanou2,
            qIT_KoujyoSym.toiawasesosikinmkj2,
            qIT_KoujyoSym.toiawasetelno2,
            qIT_KoujyoSym.hassoukbn,
            qIT_KoujyoSym.drtencd,
            qIT_KoujyoSym.drtennmkj,
            qIT_KoujyoSym.hengakuumu,
            qIT_KoujyoSym.newsyoumeigkumukbn,
            qIT_KoujyoSym.gyoumuKousinKinou,
            qIT_KoujyoSym.gyoumuKousinsyaId,
            qIT_KoujyoSym.gyoumuKousinTime,
            qIT_KoujyoSym.koujyosyoumeisentakukbn,
            qIT_KoujyoSym.kyknmkn,
            qIT_KoujyoSym.uktnmkn,
            qIT_KoujyoSym.saihkhyjkbn,
            qIT_KoujyoSym.koujyosyoumeimsgkbn) +
            $FROM(qIT_KoujyoSym) +
            where;

        ExDBResults<KoujyoSymDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KoujyoSymDataBean.class).bind(qIT_KoujyoSym).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
