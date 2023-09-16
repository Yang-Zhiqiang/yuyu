package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_CardTourokuMati;
import yuyu.def.db.mapping.GenIT_CardTourokuMati;
import yuyu.def.db.meta.GenQIT_CardTourokuMati;
import yuyu.def.db.meta.QIT_CardTourokuMati;

/**
 * カード情報登録待ちテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_CardTourokuMati} の JavaDoc を参照してください。
 * @see     GenIT_CardTourokuMati
 * @see     PKIT_CardTourokuMati
 * @see     QIT_CardTourokuMati
 * @see     GenQIT_CardTourokuMati
 */
@Entity
public class IT_CardTourokuMati extends GenIT_CardTourokuMati {

    private static final long serialVersionUID = 1L;

    public IT_CardTourokuMati() {
    }

    public IT_CardTourokuMati(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
