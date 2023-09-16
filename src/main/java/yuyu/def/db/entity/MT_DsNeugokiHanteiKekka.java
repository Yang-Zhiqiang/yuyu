package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMT_DsNeugokiHanteiKekka;
import yuyu.def.db.mapping.GenMT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.GenQMT_DsNeugokiHanteiKekka;
import yuyu.def.db.meta.QMT_DsNeugokiHanteiKekka;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＤＳ値動き判定結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsNeugokiHanteiKekka} の JavaDoc を参照してください。
 * @see     GenMT_DsNeugokiHanteiKekka
 * @see     PKMT_DsNeugokiHanteiKekka
 * @see     QMT_DsNeugokiHanteiKekka
 * @see     GenQMT_DsNeugokiHanteiKekka
 */
@Entity
public class MT_DsNeugokiHanteiKekka extends GenMT_DsNeugokiHanteiKekka {

    private static final long serialVersionUID = 1L;

    public MT_DsNeugokiHanteiKekka() {
    }

    public MT_DsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono) {
        super(pDsdatasakuseiymd, pSyono);
    }

}
