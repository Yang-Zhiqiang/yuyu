package yuyu.batch.biz.bzkaikei.bzjigyouhiknjykakusyoulistsks;

import java.util.Arrays;
import java.util.List;

import yuyu.def.biz.bean.report.BzJigyouhiKnjyKakusyouListDataSourceBean;

import com.google.common.base.Predicate;

/**
 * 事業費勘定確証リストDSBEANの担当室を判定するクラスです。
 *
 */
public class TantousituPredicate implements Predicate <BzJigyouhiKnjyKakusyouListDataSourceBean>{

    private List<String> tantousituCds;

    public TantousituPredicate(String... pTantousituCds) {
        this.tantousituCds = Arrays.asList(pTantousituCds);
    }

    @Override
    public boolean apply(BzJigyouhiKnjyKakusyouListDataSourceBean bean) {
        return tantousituCds.contains(bean.getIrAtesakikacd());
    }
}
