package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.db.mapping.GenIT_SyuunouKanri;


/**
 * 収納管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SyuunouKanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_SyuunouKanri<br />
 * @see     PKIT_SyuunouKanri<br />
 * @see     QIT_SyuunouKanri<br />
 * @see     GenQIT_SyuunouKanri<br />
 */
@Entity
public class IT_SyuunouKanri extends GenIT_SyuunouKanri {

    private static final long serialVersionUID = 1L;

    public IT_SyuunouKanri() {
    }

    public IT_SyuunouKanri(C_Syuudaikocd pSyuudaikocd,BizDate pHurikaeymd) {
        super(pSyuudaikocd,pHurikaeymd);
    }



}

