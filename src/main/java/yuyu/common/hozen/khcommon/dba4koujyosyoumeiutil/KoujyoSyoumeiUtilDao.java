package yuyu.common.hozen.khcommon.dba4koujyosyoumeiutil;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 控除証明ユーティリティDaoクラス
 */
public class KoujyoSyoumeiUtilDao {

    public List<IT_KoujyoSymNaiyou> getSymkkntySeisanKoujyoNaiyous(IT_KykKihon pKykKihon, BizDateYM pSyoumeistartYm,
        BizDateYM pSyoumeiendYm) {

        List<IT_KoujyoSymNaiyou> itKoujyoSymNaiyouLst = pKykKihon.getKoujyoSymNaiyous();

        return new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(itKoujyoSymNaiyouLst,
            new FilterKoujyoSymNaiyou1(pSyoumeistartYm, pSyoumeiendYm)));
    }

    public List<IT_KihrkmpSeisanRireki> getSsnkkntyMikeikaps(IT_KykKihon pKykKihon, Integer pRenno, BizDateYM pJyuutouym) {

        List<IT_KihrkmpSeisanRireki> itKihrkmpSeisanRirekiLst = pKykKihon.getKihrkmpSeisanRirekis();

        return new ArrayList<IT_KihrkmpSeisanRireki>(Collections2.filter(itKihrkmpSeisanRirekiLst,
            new FilterKihrkmpSeisanRireki1(pRenno, pJyuutouym)));
    }

}
