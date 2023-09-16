package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_HonyakuYouKouinRn;
import yuyu.def.db.mapping.GenZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.GenQZT_HonyakuYouKouinRn;
import yuyu.def.db.meta.QZT_HonyakuYouKouinRn;

/**
 * 翻訳用行員Ｆ用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_HonyakuYouKouinRn} の JavaDoc を参照してください。
 * @see     GenZT_HonyakuYouKouinRn
 * @see     PKZT_HonyakuYouKouinRn
 * @see     QZT_HonyakuYouKouinRn
 * @see     GenQZT_HonyakuYouKouinRn
 */
@Entity
public class ZT_HonyakuYouKouinRn extends GenZT_HonyakuYouKouinRn {

    private static final long serialVersionUID = 1L;

    public ZT_HonyakuYouKouinRn() {
    }

    public ZT_HonyakuYouKouinRn(String pZrnkinyuukikancd, String pZrnkouincd) {
        super(pZrnkinyuukikancd, pZrnkouincd);
    }

}
