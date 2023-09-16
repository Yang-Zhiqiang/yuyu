package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKSV_NkBikin;
import yuyu.def.db.mapping.GenSV_NkBikin;
import yuyu.def.db.meta.GenQSV_NkBikin;
import yuyu.def.db.meta.QSV_NkBikin;

/**
 * 年金備金ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_NkBikin} の JavaDoc を参照してください。
 * @see     GenSV_NkBikin
 * @see     PKSV_NkBikin
 * @see     QSV_NkBikin
 * @see     GenQSV_NkBikin
 */
@Entity
public class SV_NkBikin extends GenSV_NkBikin {

    private static final long serialVersionUID = 1L;

    public SV_NkBikin() {
    }

    public SV_NkBikin(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
