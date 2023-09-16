package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.mapping.GenZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuRn;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SrKbkSsuRnduHknVKnsyuyuRn} の JavaDoc を参照してください。
 * @see     GenZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     PKZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     QZT_SrKbkSsuRnduHknVKnsyuyuRn
 * @see     GenQZT_SrKbkSsuRnduHknVKnsyuyuRn
 */
@Entity
public class ZT_SrKbkSsuRnduHknVKnsyuyuRn extends GenZT_SrKbkSsuRnduHknVKnsyuyuRn {

    private static final long serialVersionUID = 1L;

    public ZT_SrKbkSsuRnduHknVKnsyuyuRn() {
    }

    public ZT_SrKbkSsuRnduHknVKnsyuyuRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
