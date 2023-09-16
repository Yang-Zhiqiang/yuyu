package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeirituInfoParam;
import yuyu.def.db.id.PKSV_Sp2RnduyuSouseiritu;
import yuyu.def.db.mapping.GenSV_Sp2RnduyuSouseiritu;
import yuyu.def.db.meta.GenQSV_Sp2RnduyuSouseiritu;
import yuyu.def.db.meta.QSV_Sp2RnduyuSouseiritu;

/**
 * ＳＰ２連動用総成立情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_Sp2RnduyuSouseiritu} の JavaDoc を参照してください。
 * @see     GenSV_Sp2RnduyuSouseiritu
 * @see     PKSV_Sp2RnduyuSouseiritu
 * @see     QSV_Sp2RnduyuSouseiritu
 * @see     GenQSV_Sp2RnduyuSouseiritu
 */
@Entity
public class SV_Sp2RnduyuSouseiritu extends GenSV_Sp2RnduyuSouseiritu {

    private static final long serialVersionUID = 1L;

    public SV_Sp2RnduyuSouseiritu() {
    }

    public SV_Sp2RnduyuSouseiritu(String pMosno) {
        super(pMosno);
    }

}
