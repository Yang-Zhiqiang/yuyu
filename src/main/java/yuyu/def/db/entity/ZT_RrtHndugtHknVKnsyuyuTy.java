package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.mapping.GenZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuTy;

/**
 * 利率変動型保険Ｖ検証用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RrtHndugtHknVKnsyuyuTy} の JavaDoc を参照してください。
 * @see     GenZT_RrtHndugtHknVKnsyuyuTy
 * @see     PKZT_RrtHndugtHknVKnsyuyuTy
 * @see     QZT_RrtHndugtHknVKnsyuyuTy
 * @see     GenQZT_RrtHndugtHknVKnsyuyuTy
 */
@Entity
public class ZT_RrtHndugtHknVKnsyuyuTy extends GenZT_RrtHndugtHknVKnsyuyuTy {

    private static final long serialVersionUID = 1L;

    public ZT_RrtHndugtHknVKnsyuyuTy() {
    }

    public ZT_RrtHndugtHknVKnsyuyuTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
