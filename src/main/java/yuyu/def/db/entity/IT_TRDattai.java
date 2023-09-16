package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_TRDattai;

/**
 * 脱退ＴＲテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_TRDattai} の JavaDoc を参照してください。<br />
 * @see     GenIT_TRDattai<br />
 * @see     PKIT_TRDattai<br />
 * @see     QIT_TRDattai<br />
 * @see     GenQIT_TRDattai<br />
 */
@Entity
public class IT_TRDattai extends GenIT_TRDattai {

    private static final long serialVersionUID = 1L;

    public IT_TRDattai() {
    }

    public IT_TRDattai(String pKbnkey,String pSyono,BizDate pSyoriYmd,String pDattaitrrenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pDattaitrrenno);
    }

    public IT_TRDattai(String pSyono,BizDate pSyoriYmd,String pDattaitrrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pDattaitrrenno);
    }


}

