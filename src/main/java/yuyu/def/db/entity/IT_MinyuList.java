package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_MinyuList;


/**
 * 未入一覧表テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_MinyuList} の JavaDoc を参照してください。<br />
 * @see     GenIT_MinyuList<br />
 * @see     PKIT_MinyuList<br />
 * @see     QIT_MinyuList<br />
 * @see     GenQIT_MinyuList<br />
 */
@Entity
public class IT_MinyuList extends GenIT_MinyuList {

    private static final long serialVersionUID = 1L;

    public IT_MinyuList() {
    }

    public IT_MinyuList(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_MinyuList(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

