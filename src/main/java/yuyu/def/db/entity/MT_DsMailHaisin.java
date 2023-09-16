package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMT_DsMailHaisin;
import yuyu.def.db.mapping.GenMT_DsMailHaisin;
import yuyu.def.db.meta.GenQMT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsMailHaisin} の JavaDoc を参照してください。
 * @see     GenMT_DsMailHaisin
 * @see     PKMT_DsMailHaisin
 * @see     QMT_DsMailHaisin
 * @see     GenQMT_DsMailHaisin
 */
@Entity
public class MT_DsMailHaisin extends GenMT_DsMailHaisin {

    private static final long serialVersionUID = 1L;

    public MT_DsMailHaisin() {
    }

    public MT_DsMailHaisin(
        BizDate pSousinymd,
        String pDskokmailaddressskbtkey,
        C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn,
        String pDssousinno
    ) {
        super(
            pSousinymd,
            pDskokmailaddressskbtkey,
            pDssousinmailsyubetukbn,
            pDssousinno
        );
    }

}
