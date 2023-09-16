package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_DairitenItakuSyouhnRn;
import yuyu.def.db.mapping.GenZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.GenQZT_DairitenItakuSyouhnRn;
import yuyu.def.db.meta.QZT_DairitenItakuSyouhnRn;

/**
 * 代理店委託商品情報用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenItakuSyouhnRn} の JavaDoc を参照してください。
 * @see     GenZT_DairitenItakuSyouhnRn
 * @see     PKZT_DairitenItakuSyouhnRn
 * @see     QZT_DairitenItakuSyouhnRn
 * @see     GenQZT_DairitenItakuSyouhnRn
 */
@Entity
public class ZT_DairitenItakuSyouhnRn extends GenZT_DairitenItakuSyouhnRn {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenItakuSyouhnRn() {
    }

    public ZT_DairitenItakuSyouhnRn(
        String pZrndairitencd,
        String pZrndrtsyouhinsikibetukbnstr,
        String pZrndrthrkhouhoukbn,
        String pZrndrtplannmkbn,
        String pZrnitakuhknhnbkaisiymd
    ) {
        super(
            pZrndairitencd,
            pZrndrtsyouhinsikibetukbnstr,
            pZrndrthrkhouhoukbn,
            pZrndrtplannmkbn,
            pZrnitakuhknhnbkaisiymd
        );
    }

}
