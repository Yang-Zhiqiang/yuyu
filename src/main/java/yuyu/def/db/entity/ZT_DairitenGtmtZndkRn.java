package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DairitenGtmtZndkRn;
import yuyu.def.db.mapping.GenZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.GenQZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkRn;

/**
 * 代理店月末残高情報Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenGtmtZndkRn} の JavaDoc を参照してください。
 * @see     GenZT_DairitenGtmtZndkRn
 * @see     PKZT_DairitenGtmtZndkRn
 * @see     QZT_DairitenGtmtZndkRn
 * @see     GenQZT_DairitenGtmtZndkRn
 */
@Entity
public class ZT_DairitenGtmtZndkRn extends GenZT_DairitenGtmtZndkRn {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenGtmtZndkRn() {
    }

    public ZT_DairitenGtmtZndkRn(String pZrndatakijyunymd, String pZrnsyono) {
        super(pZrndatakijyunymd, pZrnsyono);
    }

}
