package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DrtenMinyuKykNaiyou;

/**
 * 代理店未入契約明細内容テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DrtenMinyuKykNaiyou} の JavaDoc を参照してください。<br />
 * @see     GenIT_DrtenMinyuKykNaiyou<br />
 * @see     PKIT_DrtenMinyuKykNaiyou<br />
 * @see     QIT_DrtenMinyuKykNaiyou<br />
 * @see     GenQIT_DrtenMinyuKykNaiyou<br />
 */
@Entity
public class IT_DrtenMinyuKykNaiyou extends GenIT_DrtenMinyuKykNaiyou {

    private static final long serialVersionUID = 1L;

    public IT_DrtenMinyuKykNaiyou() {
    }

    public IT_DrtenMinyuKykNaiyou(String pKbnkey,String pSyono,BizDateYM pSyoriym) {
        super(pKbnkey,pSyono,pSyoriym);
    }

    public IT_DrtenMinyuKykNaiyou(String pSyono,BizDateYM pSyoriym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriym);
    }


}

