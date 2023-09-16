package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhTumitateDKanri;

/**
 * 積立Ｄ管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhTumitateDKanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhTumitateDKanri<br />
 * @see     PKIT_KhTumitateDKanri<br />
 * @see     QIT_KhTumitateDKanri<br />
 * @see     GenQIT_KhTumitateDKanri<br />
 */
@Entity
public class IT_KhTumitateDKanri extends GenIT_KhTumitateDKanri {

    private static final long serialVersionUID = 1L;

    public IT_KhTumitateDKanri() {
    }

    public IT_KhTumitateDKanri(String pKbnkey,String pSyono,BizDate pTumitatedtumitateymd,Integer pRenno) {
        super(pKbnkey,pSyono,pTumitatedtumitateymd,pRenno);
    }

    public IT_KhTumitateDKanri(String pSyono,BizDate pTumitatedtumitateymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTumitatedtumitateymd,pRenno);
    }


}

