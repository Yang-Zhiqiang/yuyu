package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_NyuukinKakusyouData;

/**
 * 入金確証データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_NyuukinKakusyouData} の JavaDoc を参照してください。<br />
 * @see     GenIT_NyuukinKakusyouData<br />
 * @see     PKIT_NyuukinKakusyouData<br />
 * @see     QIT_NyuukinKakusyouData<br />
 * @see     GenQIT_NyuukinKakusyouData<br />
 */
@Entity
public class IT_NyuukinKakusyouData extends GenIT_NyuukinKakusyouData {

    private static final long serialVersionUID = 1L;

    public IT_NyuukinKakusyouData() {
    }

    public IT_NyuukinKakusyouData(String pKbnkey,String pNyuukinkakusyouno,String pSyono) {
        super(pKbnkey,pNyuukinkakusyouno,pSyono);
    }

    public IT_NyuukinKakusyouData(String pNyuukinkakusyouno,String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pNyuukinkakusyouno,pSyono);
    }


}

