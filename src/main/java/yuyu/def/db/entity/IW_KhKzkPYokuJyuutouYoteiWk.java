package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIW_KhKzkPYokuJyuutouYoteiWk;


/**
 * 継続Ｐ翌月充当予定ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhKzkPYokuJyuutouYoteiWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhKzkPYokuJyuutouYoteiWk<br />
 * @see     PKIW_KhKzkPYokuJyuutouYoteiWk<br />
 * @see     QIW_KhKzkPYokuJyuutouYoteiWk<br />
 * @see     GenQIW_KhKzkPYokuJyuutouYoteiWk<br />
 */
@Entity
public class IW_KhKzkPYokuJyuutouYoteiWk extends GenIW_KhKzkPYokuJyuutouYoteiWk {

    private static final long serialVersionUID = 1L;

    public IW_KhKzkPYokuJyuutouYoteiWk() {
    }

    public IW_KhKzkPYokuJyuutouYoteiWk(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IW_KhKzkPYokuJyuutouYoteiWk(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


}

