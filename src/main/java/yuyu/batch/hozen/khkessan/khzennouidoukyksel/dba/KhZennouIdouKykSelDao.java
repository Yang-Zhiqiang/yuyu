package yuyu.batch.hozen.khkessan.khzennouidoukyksel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Collections2;

import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 決算 前納異動契約データ抽出機能DAOクラス
 */
public class KhZennouIdouKykSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<ZennouIdouKykInfoBean> getZennouIdouKykInfoBeans (BizDate pKessanKaisiYmd, BizDate pKessanKijyunYmd) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("qIT_Zennou");

        String strSql = $SELECT + $NEW(ZennouIdouKykInfoBean.class,
            qIT_Zennou.kbnkey,
            qIT_Zennou.syono,
            qIT_Zennou.zennoukaisiymd,
            qIT_Zennou.renno,
            qIT_Zennou.zennounyuukinsyoriymd,
            qIT_Zennou.zennounyuukindenno,
            qIT_Zennou.zennounyuukindenymd,
            qIT_Zennou.ryosyuymd,
            qIT_Zennou.zennoukikan,
            qIT_Zennou.zennounyuukinkgk.getTypeFieldName(),
            qIT_Zennou.zennounyuukinkgk.getValueFieldName(),
            qIT_Zennou.zennoujihrkp.getTypeFieldName(),
            qIT_Zennou.zennoujihrkp.getValueFieldName(),
            qIT_Zennou.zennouseisankbn,
            qIT_Zennou.zennouseisansyoriymd,
            qIT_Zennou.zennouseisankgk.getTypeFieldName(),
            qIT_Zennou.zennouseisankgk.getValueFieldName(),
            qIT_Zennou.zennouseisankijyunymd,
            qIT_Zennou.zennouseisandenymd,
            qIT_Zennou.annaisaikaiym,
            qIT_Zennou.kjsmyouzennoukaisiymd,
            qIT_Zennou.kjsmyouzennoukikanm,
            qIT_Zennou.kjsmyouzennounyuukinkgk.getTypeFieldName(),
            qIT_Zennou.kjsmyouzennounyuukinkgk.getValueFieldName(),
            qIT_Zennou.rstuukasyu,
            qIT_Zennou.ryosyukwsrate,
            qIT_Zennou.ryosyukwsratekjymd,
            qIT_Zennou.zennounyuukinkgkrstk.getTypeFieldName(),
            qIT_Zennou.zennounyuukinkgkrstk.getValueFieldName(),
            qIT_Zennou.tyakkinymd,
            qIT_Zennou.gyoumuKousinKinou) +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.zennouseisankbn.eq(C_ZennouSeisanKbn.SEISANZUMI) +
            $AND + $(
                $(qIT_Zennou.zennouseisandenymd.isNotNull() +
                    $AND + qIT_Zennou.zennouseisandenymd.le(pKessanKijyunYmd) +
                    $AND + qIT_Zennou.zennouseisandenymd.ge(pKessanKaisiYmd) ) +
                    $OR + $(qIT_Zennou.zennouseisandenymd.isNull() +
                        $AND + qIT_Zennou.zennouseisansyoriymd.le(pKessanKijyunYmd) +
                        $AND + qIT_Zennou.zennouseisansyoriymd.ge(pKessanKaisiYmd) )
                ) +
                $ORDER_BY(qIT_Zennou.syono.asc() ,
                    qIT_Zennou.gyoumuKousinKinou.asc() ,
                    qIT_Zennou.renno.asc());

        return exDBEntityManager.createJPQL(strSql, ZennouIdouKykInfoBean.class).bind(qIT_Zennou).getResults();
    }

    public IT_Zennou getZennou (IT_AnsyuKihon pAnsyuKihon,
        BizDate pZennouKaisiYmd,
        Integer pRenno) {

        List<IT_Zennou> zennoulist = pAnsyuKihon.getZennous();

        List<IT_Zennou> zennouFilterList = new ArrayList<IT_Zennou>(Collections2.filter(zennoulist,
            new FilterZennou1(pZennouKaisiYmd, pRenno)));

        if (zennouFilterList.size() > 0) {
            return zennouFilterList.get(0);
        }
        return null;
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekisBySyonoGyoumuKousinKinou (String pSyono,
        String pGyoumuKousinKinou){
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        List<IT_KhTtdkRireki> khTtdkRirekilist = kykKihon.getKhTtdkRirekisByGyoumuKousinKinou(pGyoumuKousinKinou);

        SortIT_KhTtdkRireki sortKhTtdkRireki = SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);
        khTtdkRirekilist = sortKhTtdkRireki.OrderIT_KhTtdkRirekiByGyoumuKousinTimeDesc(khTtdkRirekilist);
        return khTtdkRirekilist;
    }
}
