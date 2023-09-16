package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_ZennouTtdkKanryouTuuti;

/**
 * 前納手続完了通知書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ZennouTtdkKanryouTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_ZennouTtdkKanryouTuuti<br />
 * @see     PKIT_ZennouTtdkKanryouTuuti<br />
 * @see     QIT_ZennouTtdkKanryouTuuti<br />
 * @see     GenQIT_ZennouTtdkKanryouTuuti<br />
 */
@Entity
public class IT_ZennouTtdkKanryouTuuti extends GenIT_ZennouTtdkKanryouTuuti {

    private static final long serialVersionUID = 1L;

    public IT_ZennouTtdkKanryouTuuti() {
    }

    public IT_ZennouTtdkKanryouTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_ZennouTtdkKanryouTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

