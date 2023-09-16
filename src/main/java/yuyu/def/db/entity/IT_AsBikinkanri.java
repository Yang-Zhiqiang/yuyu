package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_AsBikinkanri;
import yuyu.def.db.mapping.GenIT_AsBikinkanri;
import yuyu.def.db.meta.GenQIT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BkncdKbn;
import jp.co.slcs.swak.date.BizDate;

/**
 * 案内収納備金管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AsBikinkanri} の JavaDoc を参照してください。
 * @see     GenIT_AsBikinkanri
 * @see     PKIT_AsBikinkanri
 * @see     QIT_AsBikinkanri
 * @see     GenQIT_AsBikinkanri
 */
@Entity
public class IT_AsBikinkanri extends GenIT_AsBikinkanri {

    private static final long serialVersionUID = 1L;

    public IT_AsBikinkanri() {
    }

    public IT_AsBikinkanri(
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno
    ) {
        super(
            pSyono,
            pKessankijyunymd,
            pBkncdkbn,
            pBknkktymd,
            pRenno
        );
    }

}
