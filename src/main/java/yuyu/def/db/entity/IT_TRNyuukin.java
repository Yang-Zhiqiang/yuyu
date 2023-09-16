package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_TRNyuukin;

/**
 * 入金ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRNyuukin} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRNyuukin<br />
 * @see     PKIT_TRNyuukin<br />
 * @see     QIT_TRNyuukin<br />
 * @see     GenQIT_TRNyuukin<br />
 */
@Entity
public class IT_TRNyuukin extends GenIT_TRNyuukin {

    private static final long serialVersionUID = 1L;

    public IT_TRNyuukin() {
    }

    public IT_TRNyuukin(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pNyktrrenno,Integer pDatarenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pNyktrrenno,pDatarenno);
    }

    public IT_TRNyuukin(String pSyono,BizDate pSyoriYmd,String pNyktrrenno,Integer pDatarenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pNyktrrenno,pDatarenno);
    }


}

