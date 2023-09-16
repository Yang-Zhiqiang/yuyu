package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.mapping.GenZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuTy;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SrKbkSsuRnduHknVKnsyuyuTy} の JavaDoc を参照してください。
 * @see     GenZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     PKZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     QZT_SrKbkSsuRnduHknVKnsyuyuTy
 * @see     GenQZT_SrKbkSsuRnduHknVKnsyuyuTy
 */
@Entity
public class ZT_SrKbkSsuRnduHknVKnsyuyuTy extends GenZT_SrKbkSsuRnduHknVKnsyuyuTy {

    private static final long serialVersionUID = 1L;

    public ZT_SrKbkSsuRnduHknVKnsyuyuTy() {
    }

    public ZT_SrKbkSsuRnduHknVKnsyuyuTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
