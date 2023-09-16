package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuRn;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknVKnsyuyuRn} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknVKnsyuyuRn
 * @see     PKZT_RrtHndugtHknVKnsyuyuRn
 * @see     QZT_RrtHndugtHknVKnsyuyuRn
 * @see     GenQZT_RrtHndugtHknVKnsyuyuRn
 */
@Entity
public class ZT_RrtHndugtHknVKnsyuyuRn extends GenZT_RrtHndugtHknVKnsyuyuRn {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknVKnsyuyuRn() {
    }

    public ZT_RrtHndugtHknVKnsyuyuRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
