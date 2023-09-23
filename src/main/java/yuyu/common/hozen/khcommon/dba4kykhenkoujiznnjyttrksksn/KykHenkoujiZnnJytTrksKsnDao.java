package yuyu.common.hozen.khcommon.dba4kykhenkoujiznnjyttrksksn;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 契約変更時前納充当取消および更新Daoクラスです
 */
public class KykHenkoujiZnnJytTrksKsnDao {

    public Integer getNyknJissekiRirekiMaxRenno(IT_KykKihon pKykKihon, BizDateYM pJyutoustartYm) {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(
            pKykKihon.getNyknJissekiRirekis(), new FilterNyknJissekiRireki2(pJyutoustartYm)));

        Integer maxRenno = 0;

        for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {
            if (nyknJissekiRireki.getRenno() == null) {
                continue;
            }
            if (nyknJissekiRireki.getRenno() > maxRenno) {
                maxRenno = nyknJissekiRireki.getRenno();
            }
        }

        return maxRenno;

    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekis(IT_KykKihon pKykKihon, BizDateYM pJyutoustartYm) {

        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(
            pKykKihon.getNyknJissekiRirekis(), new FilterNyknJissekiRireki1(pJyutoustartYm)));

    }

}
