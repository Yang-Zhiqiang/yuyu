package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhKesikomiData;

/**
 * 消込データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhKesikomiData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhKesikomiData<br />
 * @see     PKIT_KhKesikomiData<br />
 * @see     QIT_KhKesikomiData<br />
 * @see     GenQIT_KhKesikomiData<br />
 */
@Entity
public class IT_KhKesikomiData extends GenIT_KhKesikomiData {

    private static final long serialVersionUID = 1L;

    public IT_KhKesikomiData() {
    }

    public IT_KhKesikomiData(String pKbnkey,String pNyuukinkakusyouno,String pSyono) {
        super(pKbnkey,pNyuukinkakusyouno,pSyono);
    }

    public IT_KhKesikomiData(String pNyuukinkakusyouno,String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pNyuukinkakusyouno,pSyono);
    }


}

