package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;

import com.google.common.base.Predicate;

/**
 * 手数料情報商品履歴テーブル用 Predicate<br/>
 * 主契約特約区分（一致）
 */
public class FilterTesuuryouSyouhnRirekiBySyutkkbn implements Predicate<IT_TesuuryouSyouhnRireki> {

    C_SyutkKbn syutkKbn;

    public FilterTesuuryouSyouhnRirekiBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        super();
        syutkKbn = pSyutkkbn;
    }

    @Override
    public boolean apply(IT_TesuuryouSyouhnRireki pTesuuryouSyouhnRireki) {

        if(syutkKbn.eq(pTesuuryouSyouhnRireki.getSyutkkbn())){

            return true;
        }

        return false;
    }

}