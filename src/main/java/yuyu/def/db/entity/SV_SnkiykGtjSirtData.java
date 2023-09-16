package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKSV_SnkiykGtjSirtData;
import yuyu.def.db.mapping.GenSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.GenQSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.QSV_SnkiykGtjSirtData;

/**
 * 新契約決算ベース月次成立情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenSV_SnkiykGtjSirtData} の JavaDoc を参照してください。
 * @see     GenSV_SnkiykGtjSirtData
 * @see     PKSV_SnkiykGtjSirtData
 * @see     QSV_SnkiykGtjSirtData
 * @see     GenQSV_SnkiykGtjSirtData
 */
@Entity
public class SV_SnkiykGtjSirtData extends GenSV_SnkiykGtjSirtData {

    private static final long serialVersionUID = 1L;

    public SV_SnkiykGtjSirtData() {
    }

    public SV_SnkiykGtjSirtData(Integer pRenno8keta) {
        super(pRenno8keta);
    }

}
