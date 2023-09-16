package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DattaiTuutiKzhuri;

/**
 * 脱退通知（口座振替）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DattaiTuutiKzhuri} の JavaDoc を参照してください。<br />
 * @see     GenIT_DattaiTuutiKzhuri<br />
 * @see     PKIT_DattaiTuutiKzhuri<br />
 * @see     QIT_DattaiTuutiKzhuri<br />
 * @see     GenQIT_DattaiTuutiKzhuri<br />
 */
@Entity
public class IT_DattaiTuutiKzhuri extends GenIT_DattaiTuutiKzhuri {

    private static final long serialVersionUID = 1L;

    public IT_DattaiTuutiKzhuri() {
    }

    public IT_DattaiTuutiKzhuri(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_DattaiTuutiKzhuri(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

